package command;

import java.util.Map;

import bean.Item;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;
import util.ConversionManager;
import util.ImageUploadManager;
import util.SessionManager;

public class ListingCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc =  getRequestContext();

		ImageUploadManager ium = new ImageUploadManager();
		Map field = ium.upload(reqc);

		String itemName = (String)field.get("itemName");

		int price = Integer.parseInt((String)field.get("price"));

		String itemImage  = (String)field.get("itemImage");

		String itemExplanation = ConversionManager.conversionText((String)field.get("itemExplanation"));
		String hardwareId = (String)field.get("hardwareId");

		String categoryId = (String)field.get("categoryId");

		int term = Integer.parseInt((String)field.get("term"));

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		ItemInterfaceDao dao = factory.getItemInterfaceDao();

		SessionManager.getSession(reqc);
//		System.out.println("token:"+SessionManager.getAttribute("token"));

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
		resc.setTarget("completeListing");

		return resc;
	}

}
