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
		System.out.println("token:"+SessionManager.getAttribute("token"));
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();
	    System.out.println("user_id="+sessionUserId);

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		UserInterfaceDao userdao = factory.getUserInterfaceDao();
		DealInterfaceDao dealdao = factory.getDealInterfaceDao();


		List user = new ArrayList(); //ユーザーの情報
		//購入した取引中の取引一覧
		List buyDeal = new ArrayList();

        try {
        	user = userdao.getUser(sessionUserId);
        	buyDeal = dealdao.getAllDeals(sessionUserId);

        }catch(IntegrationException e) {
        	//例外処理

        }

		List sellDeal = new ArrayList();

        try {
        	user = userdao.getUser(sessionUserId);
        	sellDeal = dealdao.getSellAllDeals(sessionUserId);

        }catch(IntegrationException e) {
        }

		//出品した取引中の取引一覧


        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(user);

		List<Object> second=new ArrayList<>();
		second.add("buyDeal");
		second.add(buyDeal);

		List<Object> third=new ArrayList<>();
		third.add("sellDeal");
		third.add(sellDeal);

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);
		result.add(third);

		resc.setResult(result);
		resc.setTarget("mypage");
		return resc;
	}
}
