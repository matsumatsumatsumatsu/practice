package command;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
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
		UserInterfaceDao dao = factory.getUserInterfaceDao();

		List user = new ArrayList(); //ユーザーの情報
		List item = new ArrayList(); //商品の情報

        try {
        	user = dao.getUser(sessionUserId);
        }catch(IntegrationException e) {
        }

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(user);
		System.out.println(first.get(0));

		List<Object> second=new ArrayList<>();
		second.add("item");
		second.add(item);
		System.out.println(second.get(0));

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);
		System.out.println(result.get(0));

		resc.setResult(result);
		resc.setTarget("mypage");
		return resc;
	}
}
