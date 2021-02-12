package command;

import java.util.ArrayList;
import java.util.List;

import bean.Item;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;

public class ShowItemInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
    	AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao = factory.getItemInterfaceDao();
        RequestContext reqc = getRequestContext();

        List item = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        String key = "where item_id = " + itemId;
        try {
        	item = dao.getItem(key);
        }catch(IntegrationException e) {
        }

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(item);
		List<List> result=new ArrayList<>();
		result.add(first);

        resc.setResult(result);

        //user情報の所得
        List user = new ArrayList();

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
