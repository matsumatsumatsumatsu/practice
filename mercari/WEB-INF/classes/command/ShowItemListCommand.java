package command;

import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;

public class ShowItemListCommand  extends AbstractCommand {
	public  ResponseContext execute(ResponseContext resc){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao=factory.getItemInterfaceDao();

        List items = dao.getAllItems();

        resc.setResult(items);
        resc.setTarget("view");
        return resc;
    }
}
