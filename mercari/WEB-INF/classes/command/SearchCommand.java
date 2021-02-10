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
        	System.out.println("検索結果："+items);
        }catch(IntegrationException e) {

        }

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(items);
		List<List> result=new ArrayList<>();
		result.add(first);

        resc.setResult(result);


        resc.setTarget("search");// 検索結果を表示するページへ
        return resc;
    }
}