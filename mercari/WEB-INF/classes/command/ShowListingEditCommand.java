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

public class ShowListingEditCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();
		CategoryInterfaceDao categorydao=factory.getCategoryInterfaceDao();
		HardwareInterfaceDao hardwaredao=factory.getHardwareInterfaceDao();

		List item = new ArrayList();
		List hardwares = new ArrayList();
		List categorys = new ArrayList();

		String itemId = reqc.getParameter("item_id")[0];
		String key = "where item_id = " + itemId;
		try {
			item = itemDao.getItem(key);
			hardwares = hardwaredao.getAllHardware();
			categorys = categorydao.getAllCategory();
		}catch(IntegrationException e) {
		}

		List<Object> first=new ArrayList<>();
		first.add("item");
		first.add(item);

		List<Object> second=new ArrayList<>();
		second.add("hardware");
		second.add(hardwares);

		List<Object> third=new ArrayList<>();
		third.add("category");
		third.add(categorys);

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);
		result.add(third);

		resc.setResult(result);

		resc.setTarget("listingEdit");
		return resc;
	}
}
