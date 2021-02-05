package command;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import dao.UserInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;

public class PayCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

    	AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        ItemInterfaceDao itemDao = factory.getItemInterfaceDao();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();

		//商品情報の取得
        List item = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        try {
        	item = itemDao.getItem(itemId);
        }catch(IntegrationException e) {}

        //user情報の所得
        List user = new ArrayList();

        //sessionからuserIdを持ってくる
        SessionManager.getSession(reqc);
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();

		try {
			user = userDao.getUser(sessionUserId);
		}catch(IntegrationException e) {}


        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(item);

		List<Object> second=new ArrayList<>();
		first.add("user");
		first.add(user);

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);

        resc.setResult(result);
        resc.setTarget("pay");
		return resc;
	}
}
