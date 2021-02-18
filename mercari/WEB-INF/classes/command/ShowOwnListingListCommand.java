package command;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;
import util.SessionManager;

public class ShowOwnListingListCommand extends AbstractCommand {
	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao=factory.getItemInterfaceDao();

		//ログインしているユーザーのIDを取得する
		SessionManager.getSession(reqc);
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();
		String key = "where seller_id = " + sessionUserId;
		List itemList = new ArrayList();
		try {
        	itemList = dao.getItem(key);
        }catch(IntegrationException e) {
        }

		List<Object> first=new ArrayList<>();
		first.add("item");
		first.add(itemList);
		List<List> result=new ArrayList<>();
		result.add(first);

		resc.setResult(result);
		resc.setTarget("listingList");
		return resc;
	}

}
