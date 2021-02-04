package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;

public class ShowItemInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
    	AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao = factory.getItemInterfaceDao();
        RequestContext reqc = getRequestContext();

        List item = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        try {
        	item = dao.getItem(itemId);
        }catch(IntegrationException e) {

        }
//        System.out.println("itemid:"+((Item)item.get(0)).getItemId());

        resc.setResult(item);
        resc.setTarget("item");
		return resc;
	}
}
