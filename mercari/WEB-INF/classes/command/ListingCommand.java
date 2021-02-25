package command;

import java.util.Map;
import java.util.UUID;

import bean.Item;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;
import util.ImageUploadManager;
import util.SessionManager;

public class ListingCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext rq =  getRequestContext();

		ImageUploadManager ium = new ImageUploadManager();
		Map field = ium.upload(rq);

		String itemName = (String)field.get("itemName");

		int price = Integer.parseInt((String)field.get("price"));

		String itemImage  = (String)field.get("itemImage");
		itemImage = UUID.randomUUID().toString()+".jpg";


		String itemExplanation = (String)field.get("itemExplanation");

		String hardwareId = (String)field.get("hardwareId");

		String categoryId = (String)field.get("categoryId");

		int term = Integer.parseInt((String)field.get("term"));

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

		}
		resc.setTarget("start");

		return resc;
	}

}
