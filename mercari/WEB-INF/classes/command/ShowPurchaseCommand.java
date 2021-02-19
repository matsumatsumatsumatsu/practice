package command;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.UserInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;

public class ShowPurchaseCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		//ログインしているユーザーのIDを取得する
		SessionManager.getSession(reqc);

		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();


		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		UserInterfaceDao userdao = factory.getUserInterfaceDao();
		DealInterfaceDao dealdao = factory.getDealInterfaceDao();

		//ユーザーの情報
//		List user = new ArrayList();
		//購入した取引中の取引一覧
		List buyDeal = new ArrayList();

        try {
//        	user = userdao.getUser(sessionUserId);
        	buyDeal = dealdao.getAllDeals(sessionUserId);

        }catch(IntegrationException e) {
        	//例外処理

        }
		List<Object> first=new ArrayList<>();
		first.add("buyDeal");
		first.add(buyDeal);


		List<List> result=new ArrayList<>();
		result.add(first);

		resc.setResult(result);
		resc.setTarget("purchase");
		return resc;
	}
}
