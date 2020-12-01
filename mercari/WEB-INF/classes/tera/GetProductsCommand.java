package tera;

import java.util.List;

import dao.AbstractMysqlFactory;
import dao.UsersDao;

public class GetProductsCommand extends AbstractCommand{

    public  ResponseContext execute(ResponseContext rec){

    	  AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
          UsersDao dao=factory.getUsersDao();

          List products = dao.getAllProducts();


        rec.setResult(products);
        rec.setTarget("view");
        return rec;
    }
}