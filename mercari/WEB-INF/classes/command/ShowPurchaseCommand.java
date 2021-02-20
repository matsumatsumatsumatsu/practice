//購入した取引中の取引一覧、過去の取引一覧
package command;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;

public class ShowPurchaseCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		//ログインしているユーザーのIDを取得する
		SessionManager.getSession(reqc);
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		DealInterfaceDao dealDao = factory.getDealInterfaceDao();

		//購入した取引中の取引一覧
		List buyDeal = new ArrayList();
		List buyHistory = new ArrayList();


        try {
        	buyDeal = dealDao.getAllDeals(sessionUserId," and deal_state = 1 or deal_state = 4");
        	buyHistory = dealDao.getAllDeals(sessionUserId," and deal_state = 3");
        }catch(IntegrationException e) {
        	//例外処理

        }


		List<Object> first=new ArrayList<>();
		first.add("buyDeal");
		first.add(buyDeal);

		List<Object> second=new ArrayList<>();
		second.add("buyHistory");
		second.add(buyHistory);


		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);

		resc.setResult(result);
		resc.setTarget("purchase");
		return resc;
	}
}
