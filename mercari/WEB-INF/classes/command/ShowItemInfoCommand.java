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
import exception.IntegrationException;
import util.SessionManager;

public class ShowItemInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
    	AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        ItemInterfaceDao itemdao = factory.getItemInterfaceDao();
        OpenChatInterfaceDao chatdao = factory.getOpenChatInterfaceDao();
        RequestContext reqc = getRequestContext();

        System.out.println("--ShowItemInfo--");

        List item = new ArrayList();
        List chat = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        String key = "where item_id = " + itemId;
        try {
        	item = itemdao.getItem(key);
        }catch(IntegrationException e) {
        }

        try {
        	chat = chatdao.getAllMessage(itemId);
        }catch(IntegrationException e) {
        }

        System.out.println("chat:"+chat);

		List<List> result=new ArrayList<>();

        List<Object> first=new ArrayList<>();
		first.add("open");
		first.add(chat);
		result.add(first);

        List<Object> second=new ArrayList<>();
		second.add("item");
		second.add(item);
		result.add(second);

        resc.setResult(result);

        //sessionからuserIdを持ってくる
        SessionManager.getSession(reqc);
        //ログインユーザーかそうでないかの判定
		if(SessionManager.getAttribute("token")==null) {
			resc.setTarget("item");
		}else {
	        //出品者のidとログインユーザーのidが一致したらlisting、
			//違ったらitemに飛ばす
			if(((User)SessionManager.getAttribute("token")).getUserId().equals(((Item)item.get(0)).getSellerId())) {
				resc.setTarget("listingInfo");
			}else {
		        resc.setTarget("item");
		    }
			System.out.println("((User)SessionManager.getAttribute(\"token\")).getUserId()="+((User)SessionManager.getAttribute("token")).getUserId());
			System.out.println("((Item)item.get(0)).getSellerId()="+((Item)item.get(0)).getSellerId());
		}
		return resc;
	}
}
