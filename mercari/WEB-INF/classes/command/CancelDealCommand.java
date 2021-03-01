package command;

import java.util.ArrayList;
import java.util.List;

import bean.Deal;
import bean.Item;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.ItemInterfaceDao;
import dao.UserInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;

public class CancelDealCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();

		DealInterfaceDao dealDao = factory.getDealInterfaceDao();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();
		RequestContext reqc = getRequestContext();

		List deal = new ArrayList();
		List item = new ArrayList();

		String dealId = reqc.getParameter("deal_id")[0];
		//        System.out.print("CancelDealCommand"+dealId);

		try {
			deal = dealDao.getDeal(dealId);
			dealDao.changeState(dealId,"2");
		}catch(IntegrationException e) {
			//例外処理
		}

		//取引がキャンセルされた旨を出品者、購入者に通知する
		String buyerId=((Deal)deal.get(0)).getUserId();
		String itemId = ((Deal)deal.get(0)).getItemId();
		item = itemDao.getItem("where item_id = "+itemId);
		String sellerId = ((Item)item.get(0)).getSellerId();
		String sellerComment = "<a href=\"showiteminfo?item_id=" + itemId + "\"name=\"itemId\">"+ itemDao.getItemName(itemId) + "</a>の取引はキャンセルされました。売却を続けたい場合は再度出品してください";
		String buyerComment = "<a href=\"showiteminfo?item_id=" + itemId + "\"name=\"itemId\">"+ itemDao.getItemName(itemId) + "</a>の取引はキャンセルされました";

		//返金処理
		int point = ((Item)item.get(0)).getPrice();
		userDao.grantPoint(buyerId,point);

		//通知処理
		NotifyCommand notify  = new NotifyCommand(buyerId,buyerComment);
		notify.init(reqc);
		resc = notify.execute(resc);

		notify  = new NotifyCommand(sellerId,sellerComment);
		notify.init(reqc);
		resc = notify.execute(resc);

		ShowDealingInfoCommand show = new ShowDealingInfoCommand();
		show.init(reqc);
		resc = show.execute(resc);

		return resc;
	}
}
