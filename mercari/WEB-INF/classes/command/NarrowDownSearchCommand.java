//詳細検索
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

public class NarrowDownSearchCommand extends AbstractCommand{
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
        String search = "where item_name like '%"+itemName+ "%' ";
        String hardwareId = null;
        String categoryId = null;

        try {
	        //hardware
	        if(reqc.getParameter("hardware")[0] != null) {
	        	hardwareId = reqc.getParameter("hardware")[0];

	        	//hardware×パターン
	        	if(hardwareId.equals("0")) {

	        		//category
	        		if(reqc.getParameter("category")[0] != null) {
	        			categoryId = reqc.getParameter("category")[0];

	        			//hardware× category×
	        			if(categoryId.equals("0")) {
	        				//items = itemdao.getItem(search);
	        			}
	        			//hardware× category〇
	        			else {
	        				search += "AND item.category_Id = " + categoryId;
	        			}
	        		}
	        		//hardware× category = null
	        		else {
	        			//items = itemdao.getItem(search);
	        		}
	        	}

	        	//hardware〇パターン
	        	else {

	        		//category
	        		if(reqc.getParameter("category")[0] != null) {
	        			categoryId = reqc.getParameter("category")[0];

	        			//hardware〇 category×
	        			if(categoryId.equals("0")) {
	        				search += "AND item.hardware_Id = " + hardwareId;
	        			}
	        			//hardware〇 category〇
	        			else {
	        				search += "AND item.category_Id = " + categoryId + " AND item.hardware_Id = " + hardwareId;
	        			}
	        		}
	        		//hardware〇 category = null
	        		else {
	        			search += "AND item.hardware_Id = " + hardwareId;
	        		}
	        	}
	        }

	        //hardware = null
	        else {
	        	if(reqc.getParameter("category")[0] != null) {
        			categoryId = reqc.getParameter("category")[0];

        			//hardware = null category×
        			if(categoryId.equals("0")) {
        				//items = itemdao.getItem(search);
        			}
        			//hardware = null category〇
        			else {
        				search += "AND item.category_Id = " + categoryId;
        			}
        		}
        		//hardware = null category = null
        		else {
        			//items = itemdao.getItem(search);
        		}
	        }

	        if(!reqc.getParameter("minprice")[0].equals("")) {
	        	String minprice = reqc.getParameter("minprice")[0];
	        	search += " AND price >= " + minprice;
	        }

	        if(!reqc.getParameter("maxprice")[0].equals("")) {
	        	String maxprice = reqc.getParameter("maxprice")[0];
	        	search += " AND price <= " + maxprice;
	        }

	        if(!reqc.getParameter("stock")[0].equals("0")) {
	        	String stock = reqc.getParameter("stock")[0];

	        	if(stock.equals("sold")) {
	        		search += " AND stock = 0";
	        	}else {
	        		search += " AND stock = 1";
	        	}
	        }

	        System.out.println("ここまでは大丈夫？"+search);
	        items = itemdao.getItem(search);
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