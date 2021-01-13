package command;

import java.util.List;

import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;

public class GetUsersCommand extends AbstractCommand{

    public  ResponseContext execute(ResponseContext rec){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UserInterfaceDao dao=factory.getUserInterfaceDao();

        List products = dao.getAllProducts();

        rec.setResult(products);
        rec.setTarget("view");
        return rec;
    }
}