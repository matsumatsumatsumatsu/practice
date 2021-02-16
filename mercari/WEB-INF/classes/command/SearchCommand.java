package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.CategoryInterfaceDao;
import dao.HardwareInterfaceDao;
import dao.ItemInterfaceDao;
import exception.IntegrationException;

public class SearchCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){

    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        ItemInterfaceDao itemdao=factory.getItemInterfaceDao();
        CategoryInterfaceDao categorydao=factory.getCategoryInterfaceDao();
        HardwareInterfaceDao hardwaredao=factory.getHardwareInterfaceDao();

        RequestContext reqc = getRequestContext();

        List items = new ArrayList();
        List hardwares = new ArrayList();
        List categorys = new ArrayList();

        String itemName = reqc.getParameter("keyword")[0];

        if(reqc.getParameter("hardware")[0] != null) {

        }


        String hardName = reqc.getParameter("hardware")[0];
        if(hardName.equals("0")) {

        }

		if(reqc.getParameter("hardware")[0] != null) {

		}

        String cateName = reqc.getParameter("category")[0];

        try {
        	items = itemdao.getItem("where item_name like '%"+ itemName+ "%'");
        	hardwares = hardwaredao.getAllHardware();
        	categorys = categorydao.getAllCategory();
        	System.out.println("検索結果："+items);
        }catch(IntegrationException e) {

        }

		List<List> result=new ArrayList<>();

        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(items);
		result.add(first);

		List<Object> second=new ArrayList<>();
		second.add("hardware");
		second.add(hardwares);
		result.add(second);

        List<Object> third=new ArrayList<>();
		third.add("category");
		third.add(categorys);
		result.add(third);

        resc.setResult(result);


        resc.setTarget("search");// 検索結果を表示するページへ
        return resc;
    }
}