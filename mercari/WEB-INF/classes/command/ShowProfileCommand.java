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

public class ShowProfileCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		//ログインしているユーザーのIDを取得する
		SessionManager.getSession(reqc);
//		System.out.println("token:"+SessionManager.getAttribute("token"));
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();
//	    System.out.println("user_id="+sessionUserId);

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();
		DealInterfaceDao dealDao = factory.getDealInterfaceDao();


		List user = new ArrayList(); //ユーザーの情報
		//購入した取引中の取引一覧
		List buyDeal = new ArrayList();
		List buyHistory = new ArrayList();
		//出品した取引中の取引一覧
		List sellDeal = new ArrayList();
		List sellHistory = new ArrayList();

        try {
        	user = userDao.getUser(sessionUserId);

        	buyDeal = dealDao.getAllDeals(sessionUserId," and deal_state = 1 or deal_state = 4");
        	sellDeal = dealDao.getSellAllDeals(sessionUserId," and deal_state = 1 or deal_state = 4");
        	buyHistory = dealDao.getAllDeals(sessionUserId," and deal_state = 3");
        	sellHistory = dealDao.getSellAllDeals(sessionUserId," and deal_state = 3");

        }catch(IntegrationException e) {
        	//例外処理

        }


        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(user);

		List<Object> second=new ArrayList<>();
		second.add("buyDeal");
		second.add(buyDeal);

		List<Object> third=new ArrayList<>();
		third.add("sellDeal");
		third.add(sellDeal);

		List<Object> fourth=new ArrayList<>();
		fourth.add("buyHistory");
		fourth.add(buyHistory);

		List<Object> fifth=new ArrayList<>();
		fifth.add("sellHistory");
		fifth.add(sellHistory);

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);
		result.add(third);
		result.add(fourth);
		result.add(fifth);

		resc.setResult(result);
		resc.setTarget("mypage");
		return resc;
	}
}
