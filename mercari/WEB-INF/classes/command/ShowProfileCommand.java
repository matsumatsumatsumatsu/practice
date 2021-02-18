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
		List deal = new ArrayList();

        try {
        	user = userdao.getUser(sessionUserId);
        	deal = dealdao.getDealInfo(sessionUserId);

        }catch(IntegrationException e) {
        }

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(user);
		System.out.println(first.get(0));

		List<Object> second=new ArrayList<>();
		second.add("deal");
		second.add(deal);
		System.out.println(second.get(0));


		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);

		resc.setResult(result);
		resc.setTarget("mypage");
		return resc;
	}
}
