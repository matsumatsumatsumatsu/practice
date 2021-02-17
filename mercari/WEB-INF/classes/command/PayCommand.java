package command;

import java.util.ArrayList;
import java.util.List;

import bean.Item;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import dao.UserInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;
import util.SessionManager;

public class PayCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		ItemInterfaceDao itemDao = factory.getItemInterfaceDao();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();

		//商品情報の取得
        List item = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        String key = " where item_id = " + itemId;
        try {
        	item = itemDao.getItem(key);
        }catch(IntegrationException e) {}
        System.out.println(item.get(0));

        //user情報の所得
        List user = new ArrayList();

        //sessionからuserIdを持ってくる
        SessionManager.getSession(reqc);
		String sessionUserId = ((User)SessionManager.getAttribute("token")).getUserId();

		try {
			user = userDao.getUser(sessionUserId);
		}catch(IntegrationException e) {}
		System.out.println(((User)user.get(0)).getUserId());

		int userPoint = ((User)user.get(0)).getPoint();
		int itemPrice = ((Item)item.get(0)).getPrice();

		int point = userPoint - itemPrice;

		try {
			userDao.pay(sessionUserId,point);
			//在庫を減らす
			itemDao.manageStock(itemId);
		}catch(IntegrationException e) {
		}

		resc.setTarget("buyerDealingInfo");
		return resc;
	}

}
