package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.IntegrationException;

public class ShowUserInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		UserInterfaceDao dao = factory.getUserInterfaceDao();

		System.out.println("--ShowUserInfo--");

		List user = new ArrayList();

		String userId = reqc.getParameter("user_id")[0];
		try {
			 	user = dao.getUser(userId);
		 }catch(IntegrationException e) { }

		List<List> result=new ArrayList<>();
		List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(user);

		System.out.println("わわわわわわ！！！" + first);
		result.add(first);


		resc.setResult(result);
		System.out.println("--ShowUserInfo--");

		resc.setTarget("userInfo");
		return resc;
	}
}
