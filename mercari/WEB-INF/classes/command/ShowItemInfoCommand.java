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

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(item);
		List<List> result=new ArrayList<>();
		result.add(first);

        resc.setResult(result);
        resc.setTarget("item");
		return resc;
	}
}
