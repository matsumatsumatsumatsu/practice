package command;

import bean.Item;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;

public class ShowItemInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
    	AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao = factory.getItemInterfaceDao();
        RequestContext reqc = getRequestContext();

        String itemId = reqc.getParameter("itemId")[0];
        Item item = dao.getItem(itemId);

        resc.setResult(item);
        resc.setTarget("start");
		return resc;
	}
}
