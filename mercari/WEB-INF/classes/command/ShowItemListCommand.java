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

        resc.setResult(items);
        resc.setTarget("start");
        return resc;
    }
}
