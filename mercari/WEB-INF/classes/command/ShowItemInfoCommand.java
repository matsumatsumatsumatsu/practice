package command;

import java.util.ArrayList;
import java.util.List;

import bean.Item;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import dao.OpenChatInterfaceDao;
import dao.UserInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;

public class ShowItemInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
    	AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        ItemInterfaceDao itemdao = factory.getItemInterfaceDao();
        OpenChatInterfaceDao chatdao = factory.getOpenChatInterfaceDao();
        UserInterfaceDao userdao = factory.getUserInterfaceDao();
        RequestContext reqc = getRequestContext();

//        System.out.println("--ShowItemInfo--");

        //セッションからuserIdを取得
        SessionManager.getSession(reqc);

        String sessionUserId = null;
        if(SessionManager.getAttribute("token") != null) {
        	sessionUserId = ((User)SessionManager.getAttribute("token")).getUserId();
        }

        List item = new ArrayList();
        List chat = new ArrayList();
        List user = new ArrayList();
        List userId = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        String key = "where item_id = " + itemId;
        try {
        	item = itemdao.getItem(key);
        }catch(IntegrationException e) {
        }

        try {
        	chat = chatdao.getAllMessage(itemId);
        	user = userdao.getUser(((Item)item.get(0)).getSellerId());
        }catch(IntegrationException e) {

        }

//        System.out.println("chat:"+chat);

        List<Object> first=new ArrayList<>();
		first.add("open");
		first.add(chat);

        List<Object> second=new ArrayList<>();
		second.add("item");
		second.add(item);

		List<Object> third=new ArrayList<>();
		third.add("user");
		third.add(user);

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);
		result.add(third);

        resc.setResult(result);

        //ログインユーザーかそうでないかの判定
		if(SessionManager.getAttribute("token")==null) {
			resc.setTarget("item");
		}else {
	        //出品者のidとログインユーザーのidが一致したらlisting、
			//違ったらitemに飛ばす
			if(sessionUserId.equals(((Item)item.get(0)).getSellerId())) {
				resc.setTarget("listingInfo");
			}else {
		        resc.setTarget("item");
		    }
//			System.out.println("((User)SessionManager.getAttribute(\"token\")).getUserId()="+((User)SessionManager.getAttribute("token")).getUserId());
//			System.out.println("((Item)item.get(0)).getSellerId()="+((Item)item.get(0)).getSellerId());
		}
		return resc;
	}
}
