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
import exception.BusinessLogicException;
import exception.IntegrationException;

public class ReceiveItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc)  throws BusinessLogicException{
		RequestContext reqc = getRequestContext();



		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		DealInterfaceDao dealDao = factory.getDealInterfaceDao();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();
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

		ShowDealingInfoCommand show = new ShowDealingInfoCommand();
		show.init(reqc);
		resc = show.execute(resc);

		//通知
		//売り手の発送した商品が受け取られた旨を通知する
		String itemId = ((Deal)deal.get(0)).getItemId();
		String sellerId = itemDao.getSellerId(itemId);
		String sellerComment = itemDao.getItemName(itemId) + "を購入者様が受け取りました";

		NotifyCommand notify  = new NotifyCommand(sellerId,sellerComment);
		notify.init(reqc);
		resc = notify.execute(resc);

		return resc;
	}

}
