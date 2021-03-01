package command;

import java.util.ArrayList;
import java.util.List;

import bean.Deal;
import bean.Item;
import bean.PaymentLog;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.ItemInterfaceDao;
import dao.PaymentLogInterfaceDao;
import dao.UserInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;

public class ReceiveItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc)  throws BusinessLogicException{
		RequestContext reqc = getRequestContext();



		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		DealInterfaceDao dealDao = factory.getDealInterfaceDao();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();
		PaymentLogInterfaceDao payDao=factory.getPaymentLogInterfaceDao();

		String  dealId= reqc.getParameter("deal_id")[0];

		List deal = new ArrayList();
		List item = new ArrayList();
		PaymentLog payment= new PaymentLog();

		try {
			deal = dealDao.getDeal(dealId);

			String itemId = ((Deal)deal.get(0)).getItemId();
			item = itemDao.getItem("where item_id = "+ itemId);
		}catch(IntegrationException e) {
			//例外処理

		}



		//出品者ユーザー
		payment.setSellerId(((Item)item.get(0)).getSellerId());
		//仮の管理者ユーザーから正式に出品者ユーザーへポイントの付与
    	payment.setBuyerId("1");
    	payment.setItemId(((Item)item.get(0)).getItemId());
    	payment.setPrice(((Item)item.get(0)).getPrice());

    	String payId = null;
		try{
			payId = payDao.insertPaymentLog(payment);
			dealDao.changeState(dealId, "3");
		}catch(IntegrationException e) {
			//例外処理
		}

		Deal d = new Deal();
		d.setAfterPaymentId(payId);

		try {
			dealDao.updatePaymentLog(d,dealId);
		}catch(IntegrationException e) {
			//例外処理
		}

		//売り手の発送した商品が受け取られた旨を通知する
		String itemId = ((Deal)deal.get(0)).getItemId();
		String sellerId = itemDao.getSellerId(itemId);
		String sellerComment = "<a href=\"showiteminfo?item_id=" + itemId + "\"name=\"itemId\">"+ itemDao.getItemName(itemId) + "</a>を購入者様が受け取りました";

		//出品者のポイント増やす処理
		try {
			//userのポイントを減らす
			userDao.grantPoint(sellerId,((Item)item.get(0)).getPrice());
			//在庫を減らす
			itemDao.manageStock(itemId);
		}catch(IntegrationException e) {
		}

		NotifyCommand notify  = new NotifyCommand(sellerId,sellerComment);
		notify.init(reqc);
		resc = notify.execute(resc);

		ShowDealingInfoCommand show = new ShowDealingInfoCommand();
		show.init(reqc);
		resc = show.execute(resc);

		return resc;
	}

}
