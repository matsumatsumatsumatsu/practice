package command;

import bean.Item;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;

public class EditListingCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();

		String itemId = reqc.getParameter("itemId")[0];
		String name = reqc.getParameter("name")[0];
		String explanation = reqc.getParameter("itemExplanation")[0];
		String category = reqc.getParameter("categoryId")[0];
		String hardware = reqc.getParameter("hardwareId")[0];
		int term = Integer.parseInt(reqc.getParameter("term")[0]);
		int price = Integer.parseInt(reqc.getParameter("price")[0]);

		Item i = new Item();
		i.setItemId(itemId);
		i.setItemName(name);
		i.setPrice(price);
		i.setItemExplanation(explanation);
		i.setHardwareId(hardware);
		i.setCategoryId(category);
		i.setTerm(term);

		try {
			itemDao.updateItem(i,itemId);
		} catch (IntegrationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		resc.setTarget("mypage");
		return resc;
	}

}