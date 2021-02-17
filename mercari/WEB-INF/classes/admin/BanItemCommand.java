package admin;

import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;

public class BanItemCommand  extends AbstractCommand  {


	public  ResponseContext execute(ResponseContext resc){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
    	ItemInterfaceDao dao=factory.getItemInterfaceDao();
    	  RequestContext reqc = getRequestContext();

	        String itemId = reqc.getParameter("item_id")[0];
	        System.out.println("BanItem"+itemId);


    	try {
    		   dao.deleteItem(itemId);
		} catch (IntegrationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    	 resc.setTarget("admin/admin");
        return resc;
    }

}
