//出品した取引中の取引一覧、過去の取引一覧
package command;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.ItemInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;
import util.SessionManager;

public class ShowOwnListingListCommand extends AbstractCommand {
	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao=factory.getItemInterfaceDao();

		//ログインしているユーザーのIDを取得する
		SessionManager.getSession(reqc);
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();
		String key = "where seller_id = " + sessionUserId + " and stock = " + "1";

		//出品中
		List itemList = new ArrayList();

		DealInterfaceDao dealDao = factory.getDealInterfaceDao();

		//出品した取引中の取引一覧
		List sellDeal = new ArrayList();
		List sellHistory = new ArrayList();

		try {
        	itemList = dao.getItem(key);
        	sellDeal = dealDao.getSellAllDeals(sessionUserId," and (deal_state = 1 or deal_state = 4)");
        	sellHistory = dealDao.getSellAllDeals(sessionUserId," and (deal_state = 3 or deal_state = 3)");
        }catch(IntegrationException e) {
        }

		List<Object> first=new ArrayList<>();
		first.add("item");
		first.add(itemList);

		List<Object> second=new ArrayList<>();
		second.add("sellDeal");
		second.add(sellDeal);

		List<Object> third=new ArrayList<>();
		third.add("sellHistory");
		third.add(sellHistory);


		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);
		result.add(third);

		resc.setResult(result);
		resc.setTarget("listingList");
		return resc;
	}

}
