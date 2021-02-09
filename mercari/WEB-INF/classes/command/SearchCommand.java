package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;

public class SearchCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        ItemInterfaceDao dao=factory.getItemInterfaceDao();
        RequestContext reqc = getRequestContext();
        List items = new ArrayList();

        String itemName = reqc.getParameter("keyword")[0];

        try {
        	items = dao.getItem("where item_name like '%", itemName+ "%'");
        }catch(IntegrationException e) {

        }

        resc.setResult(items);
        resc.setTarget("search");// 検索結果を表示するページへ
        return resc;
    }
}