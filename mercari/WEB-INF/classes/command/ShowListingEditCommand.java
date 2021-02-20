package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;

public class ShowListingEditCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

    	AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        ItemInterfaceDao itemDao = factory.getItemInterfaceDao();

        List item = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        String key = "where item_id = " + itemId;
        try {
        	item = itemDao.getItem(key);
        }catch(IntegrationException e) {
        }

        List<List> result=new ArrayList<>();

		List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(item);
		result.add(first);

		resc.setResult(result);

		resc.setTarget("listingEdit");
        return resc;
	}
}
