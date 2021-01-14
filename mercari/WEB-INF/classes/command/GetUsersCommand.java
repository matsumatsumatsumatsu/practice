package command;

import java.util.List;

import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;

public class GetUsersCommand extends AbstractCommand{

    public  ResponseContext execute(ResponseContext resc){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UserInterfaceDao dao=factory.getUserInterfaceDao();

        List users = dao.getAllUsers();

        resc.setResult(users);
        resc.setTarget("view");
        return resc;
    }
}