package command;

import java.util.ArrayList;
import java.util.List;

import bean.Deal;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.ItemInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;

public class ReceiveItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc)  throws BusinessLogicException{

		RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		DealInterfaceDao dealDao = factory.getDealInterfaceDao();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();

		String  dealId= reqc.getParameter("deal_id")[0];

		try{
			dealDao.changeState(dealId, "3");
		}catch(IntegrationException e) {
			//例外処理
		}

		ShowDealingInfoCommand show = new ShowDealingInfoCommand();
		show.init(reqc);
		resc = show.execute(resc);

		//通知
		//売り手の発送した商品が受け取られた旨を通知する
		List deal = new ArrayList();
		deal = dealDao.getDeal(dealId);
		String itemId = ((Deal)deal.get(0)).getItemId();
		String sellerId = itemDao.getSellerId(itemId);
		String sellerComment = itemDao.getItemName(itemId) + "を購入者様が受け取りました";

		NotifyCommand notify  = new NotifyCommand(sellerId,sellerComment);
		notify.init(reqc);
		resc = notify.execute(resc);

		return resc;
	}

}
