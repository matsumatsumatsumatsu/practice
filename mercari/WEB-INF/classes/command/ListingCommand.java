package command;

import context.RequestContext;
import context.ResponseContext;
import util.ImageUploadManager;

public class ListingCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rq=  getRequestContext();

		ImageUploadManager.upload(rq);

		/*String itemNames[] = rq.getParameter("itemName");
		String itemName = itemNames[0];

		String prices[] = rq.getParameter("price");
		int price = Integer.parseInt(prices[0]);

		String itemImage  = rq.getParameter("itemImage")[0];
		itemImage = UUID.randomUUID().toString()+".jpg";


		String itemExplanations[] = rq.getParameter("itemExplanation");
		String itemExplanation = itemExplanations[0];

		String hardwareIds[] = rq.getParameter("hardwareId");
		String hardwareId = hardwareIds[0];

		String categoryIds[] = rq.getParameter("categoryId");
		String categoryId = categoryIds[0];

		String terms[] = rq.getParameter("term");
		int term = Integer.parseInt(terms[0]);

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		ItemInterfaceDao dao = factory.getItemInterfaceDao();

		SessionManager.getSession(rq);
		System.out.println("token:"+SessionManager.getAttribute("token"));

		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();

		//beanインスタンス化
		Item i = new Item();
		i.setItemName(itemName);
		i.setPrice(price);
		i.setItemImage(itemImage);
		i.setItemExplanation(itemExplanation);
		i.setHardwareId(hardwareId);
		i.setCategoryId(categoryId);
		i.setTerm(term);
		i.setSellerId(sessionUserId);

		try {
			dao.listing(i);
		}catch(IntegrationException e) {

		}*/
		resc.setTarget("start");

		return resc;
	}

}
