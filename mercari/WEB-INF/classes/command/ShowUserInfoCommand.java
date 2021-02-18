package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import dao.UserInterfaceDao;
import exception.IntegrationException;

public class ShowUserInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();

		System.out.println("--ShowUserInfo--");

		List user = new ArrayList();
		List itemList = new ArrayList();

		String userId = reqc.getParameter("user_id")[0];
		String key = "where seller_id = "+ userId;
		try {
			 	user = userDao.getUser(userId);
			 	itemList = itemDao.getItem(key);
		 }catch(IntegrationException e) { }

		List<Object> first=new ArrayList<>();
		first.add("user");
		first.add(user);

		List<Object> second=new ArrayList<>();
		second.add("item");
		second.add(itemList);

		System.out.println("わわわわわわ！！！" + first);
		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);

		resc.setResult(result);
		System.out.println("--ShowUserInfo--");

		resc.setTarget("userInfo");
		return resc;
	}
}
