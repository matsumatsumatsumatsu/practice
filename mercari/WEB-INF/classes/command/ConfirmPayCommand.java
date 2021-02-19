//商品の購入の確認
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

public class ConfirmPayCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

    	AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        ItemInterfaceDao itemDao = factory.getItemInterfaceDao();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();

		//商品情報の取得
        List item = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        String key = " where item_id = " + itemId;
        try {
        	item = itemDao.getItem(key);
        }catch(IntegrationException e) {}
//        System.out.println(item.get(0));

        //user情報の所得
        List user = new ArrayList();

        //sessionからuserIdを持ってくる
        SessionManager.getSession(reqc);
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();

		try {
			user = userDao.getUser(sessionUserId);
		}catch(IntegrationException e) {}
		System.out.println(((User)user.get(0)).getUserId());

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(item);
		System.out.println(first.get(0));

		List<Object> second=new ArrayList<>();
		second.add("user");
		second.add(user);
		System.out.println(second.get(0));

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);
		System.out.println(result.get(0));

        resc.setResult(result);
        resc.setTarget("pay");
        System.out.println("payowari");
		return resc;
	}
}
