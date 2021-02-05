package command;

import java.util.ArrayList;
import java.util.List;

import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;

public class ShowItemListCommand  extends AbstractCommand {
	public  ResponseContext execute(ResponseContext resc){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao=factory.getItemInterfaceDao();

        List items = new ArrayList();
        try {
        	items = dao.getAllItems();
        }catch(IntegrationException e) {
        }

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(items);
		List<List> result=new ArrayList<>();
		result.add(first);

        resc.setResult(result);
        resc.setTarget("search");
        return resc;
    }
}
