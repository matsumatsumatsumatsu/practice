package command;

import bean.Item;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;

public class ListingCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rq=  getRequestContext();

		String itemIds[] = rq.getParameter("itemId");
		int itemId = Integer.parseInt(itemIds[0]);

		String itemNames[] = rq.getParameter("itemName");
		String itemName = itemNames[0];

		String prices[] = rq.getParameter("price");
		int price = Integer.parseInt(prices[0]);

		String itemImages[] = rq.getParameter("itemImage");
		String itemImage = itemImages[0];

		String itemExplanations[] = rq.getParameter("itemExplanation");
		String itemExplanation = itemExplanations[0];

		String hardwareIds[] = rq.getParameter("hardwareId");
		int hardwareId = Integer.parseInt(hardwareIds[0]);

		String categoryIds[] = rq.getParameter("categoryId");
		int categoryId = Integer.parseInt(categoryIds[0]);

		String sellerIds[] = rq.getParameter("sellerId");
		int sellerId = Integer.parseInt(sellerIds[0]);

		String terms[] = rq.getParameter("term");
		int term = Integer.parseInt(terms[0]);

		//beanインスタンス化
		Item i = new Item();
		i.setItemId(itemId);
		i.setItemName(itemName);
		i.setPrice(price);
		i.setItemImage(itemImage);
		i.setItemExplanation(itemExplanation);
		i.setHardwareId(hardwareId);
		i.setCategoryId(categoryId);
		i.setSellerId(sellerId);
		i.setTerm(term);

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		ItemInterfaceDao dao = factory.getItemInterfaceDao();

		dao.listing(i);
		resc.setTarget("start");

		return resc;
	}

}
