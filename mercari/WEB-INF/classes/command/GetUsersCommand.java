package command;

import java.util.List;

import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UsersDao;

public class GetUsersCommand extends AbstractCommand{

    public  ResponseContext execute(ResponseContext rec){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UsersDao dao=factory.getUsersDao();

        List products = dao.getAllProducts();

        rec.setResult(products);
        rec.setTarget("view");
        return rec;
    }
}