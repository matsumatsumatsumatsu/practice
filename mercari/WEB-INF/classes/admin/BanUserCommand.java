package admin;

import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.IntegrationException;

public class BanUserCommand extends AbstractCommand {

	public  ResponseContext execute(ResponseContext resc){


	    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
	        UserInterfaceDao dao=factory.getUserInterfaceDao();
	        RequestContext reqc = getRequestContext();

	        String userId = reqc.getParameter("user_id")[0];
	        System.out.println("BanUser"+userId);
	    	try {
			 dao.deleteUser(userId);
			} catch (IntegrationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

        resc.setTarget("admin/show");
        return resc;
    }

}
