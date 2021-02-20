package command;

import java.util.ArrayList;
import java.util.List;

import bean.Deal;
import bean.Item;
import bean.PaymentLog;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.ItemInterfaceDao;
import dao.PaymentLogInterfaceDao;
import dao.UserInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;
import util.SessionManager;

public class PayCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();
		PaymentLogInterfaceDao payDao = factory.getPaymentLogInterfaceDao();
		DealInterfaceDao dealDao = factory.getDealInterfaceDao();

		//商品情報の格納
        List item = new ArrayList();

        //item_idから商品情報の取得
        String itemId = reqc.getParameter("item_id")[0];
        String key = " where item_id = " + itemId;
        try {
        	item = itemDao.getItem(key);
        }catch(IntegrationException e) {}
        System.out.println(item.get(0));

        //user情報の所得
        List user = new ArrayList();

        //sessionからuserIdを持ってくる
        SessionManager.getSession(reqc);
		String sessionUserId = ((User)SessionManager.getAttribute("token")).getUserId();

		try {
			user = userDao.getUser(sessionUserId);
		}catch(IntegrationException e) {}

//		System.out.println("---PayCommand---");
//		System.out.println("userId"+((User)user.get(0)).getUserId());

		int userPoint = ((User)user.get(0)).getPoint();
		int itemPrice = ((Item)item.get(0)).getPrice();

		//userのポイントから商品ポイントを減らす
		int point = userPoint - itemPrice;

		//PaymentLogのインスタンス化
		PaymentLog p = new PaymentLog();
		//sellerは仮ユーザーとして、管理者を挿入
		p.setSellerId("1");
		p.setBuyerId(sessionUserId);
		p.setItemId(itemId);
		//商品の値段
		p.setPrice(((Item)item.get(0)).getPrice());

		String payId = null;

		try {
			payId = payDao.insertPaymentLog(p);
		}catch(IntegrationException e) {
			//例外処理

		}



		//Dealのインスタンス化（購入者側）
		Deal deal = new Deal();
		deal.setBeforePaymentId(payId);
		deal.setAfterPaymentId(null);
		deal.setItemId(itemId);
		//1は取引中
		deal.setDealState("1");
		deal.setUserId(sessionUserId);
		//1は購入者の取引中
		deal.setUserState("1");

		try{
			dealDao.insertDeal(deal);
		}catch(IntegrationException e) {
			//例外処理
		}

//		//Dealのインスタンス化（出品者側）
//		deal.setBeforePaymentId(payId);
//		deal.setAfterPaymentId(null);
//		deal.setItemId(itemId);
//		//1は取引中
//		deal.setDealState("1");
//		deal.setUserId(((Item)item.get(0)).getSellerId());
//		//1は購入者の取引中
//		deal.setUserState("2");

//		try{
//			dealDao.insertDeal(deal);
//		}catch(IntegrationException e) {
//			//例外処理
//		}

		try {
			userDao.pay(sessionUserId,point);
			//在庫を減らす
			itemDao.manageStock(itemId);
		}catch(IntegrationException e) {
		}

		//通知処理
		//売り手のID
		System.out.println("商品ID確認ーーーーーー"+itemId);
		String sellerId = itemDao.getSellerId(itemId);
		//購入者と出品者双方に決済を通達する
		String buyerComment = itemDao.getItemName(itemId) + "を購入しました";
		String sellerComment = itemDao.getItemName(itemId) + "が購入されました";
		System.out.println(buyerComment);
		System.out.println(sellerComment);

		NotifyCommand notifyBuyer  = new NotifyCommand(sessionUserId,buyerComment);
		NotifyCommand notifySeller  = new NotifyCommand(sellerId,sellerComment);

		notifyBuyer.init(reqc);
		notifySeller.init(reqc);

		resc = notifyBuyer.execute(resc);
		resc = notifySeller.execute(resc);

		resc.setTarget("start");
		return resc;
	}

}
