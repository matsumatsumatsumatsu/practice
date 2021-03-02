package command;

import java.util.ArrayList;
import java.util.List;

import bean.Deal;
import bean.Item;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.ItemInterfaceDao;
import dao.PrivateChatInterfaceDao;
import dao.UserInterfaceDao;
import exception.IntegrationException;

public class ShowDealingInfoCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
        RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        DealInterfaceDao dealdao = factory.getDealInterfaceDao();
        PrivateChatInterfaceDao pcdao = factory.getPrivateChatInterfaceDao();
        ItemInterfaceDao itemdao = factory.getItemInterfaceDao();
        UserInterfaceDao userdao = factory.getUserInterfaceDao();

        String dealId = reqc.getParameter("deal_id")[0];

        List deal = new ArrayList();
        try {
			deal = dealdao.getDeal(dealId);
		} catch (IntegrationException e) {
			e.printStackTrace();
		}
        List first = new ArrayList();
        first.add("deal");
        first.add(deal);

        List chat = new ArrayList();
        try {
			chat = pcdao.getAllMessage(dealId);
		} catch (IntegrationException e) {
			e.printStackTrace();
		}
        List second = new ArrayList();
        second.add("chat");
        second.add(chat);

        List item = new ArrayList();
        List user = new ArrayList();
        String itemId = ((Deal)deal.get(0)).getItemId();
        String key = "where item_id = "+itemId;
    	try {
			item = itemdao.getItem(key);
			user = userdao.getUser(((Item)item.get(0)).getSellerId());
		} catch (IntegrationException e) {
			e.printStackTrace();
		}
    	List third = new ArrayList();
    	third.add("item");
    	third.add(item);

    	List fourth = new ArrayList();
    	fourth.add("user");
    	fourth.add(user);

        List result = new ArrayList();
        result.add(first);
        result.add(second);
        result.add(third);

        resc.setResult(result);
        String userState= reqc.getParameter("user_state")[0];

        System.out.println("userState:"+userState);

        if(userState.equals("1")) {
        	resc.setTarget("buyerDealingInfo");
        }else {
        	resc.setTarget("sellerDealingInfo");
        }

		return resc;
	}

}
