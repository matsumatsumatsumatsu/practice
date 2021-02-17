package admin;


import java.util.ArrayList;
import java.util.List;

import command.AbstractCommand;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.IntegrationException;

public class ShowUserListCommand  extends AbstractCommand {
	public  ResponseContext execute(ResponseContext resc){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UserInterfaceDao dao=factory.getUserInterfaceDao();

        List users = new ArrayList();
        try {
        	users = dao.getAllUsers();
        }catch(IntegrationException e) {
        }

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(users);
		List<List> result=new ArrayList<>();
		result.add(first);

        resc.setResult(result);
        resc.setTarget("admin/show");
        return resc;
    }
}
