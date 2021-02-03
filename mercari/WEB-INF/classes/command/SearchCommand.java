package command;

import bean.Item;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;

public class SearchCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao=factory.getItemInterfaceDao();
        RequestContext reqc = getRequestContext();


        String itemName = reqc.getParameter("itemName")[0];
        Item items = dao.search(itemName);

        resc.setResult(items);
        resc.setTarget("");// 検索結果を表示するページへ
        return resc;
    }
}