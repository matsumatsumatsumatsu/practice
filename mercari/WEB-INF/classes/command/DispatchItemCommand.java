package command;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.ItemInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;

public class DispatchItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		DealInterfaceDao dealDao = factory.getDealInterfaceDao();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();

		String  dealId= reqc.getParameter("deal_id")[0];

		try{
			//考えもの
			dealDao.changeState(dealId, "4");
//			dealDao.changeState(dealId, "1");
		}catch(IntegrationException e) {
			//例外処理
		}

		//売り手が商品を発送したことを買い手に通知する
		String buyerId = dealDao.getBuyerId(dealId);
		String itemId = dealDao.getItemId(dealId);
		String buyerComment = "あなたの購入した商品:<a href=\"showiteminfo?item_id=" + itemId + "\"name=\"itemId\">"+ itemDao.getItemName(itemId) + "</a>が発送されました";

		NotifyCommand notify  = new NotifyCommand(buyerId,buyerComment);
		notify.init(reqc);
		resc = notify.execute(resc);

		ShowDealingInfoCommand show = new ShowDealingInfoCommand();
		show.init(reqc);
		resc = show.execute(resc);

		return resc;
	}

}
