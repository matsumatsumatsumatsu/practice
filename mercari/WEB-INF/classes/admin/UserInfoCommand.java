package admin;

import java.util.ArrayList;
import java.util.List;

import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.UserInterfaceDao;
import exception.IntegrationException;

public class UserInfoCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc) {
        AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UserInterfaceDao userdao = factory.getUserInterfaceDao();

        DealInterfaceDao dealDao = factory.getDealInterfaceDao();
        RequestContext reqc = getRequestContext();


        List user = new ArrayList(); //ユーザーの情報
        List deal = new ArrayList();

		//購入した取引中の取引一覧
		List buyDeal = new ArrayList();
		List buyHistory = new ArrayList();
		//出品した取引中の取引一覧
		List sellDeal = new ArrayList();
		List sellHistory = new ArrayList();


        String userId = reqc.getParameter("user_id")[0];


        try {
            user = userdao.getUser(userId);
//            deal = dealDao.getAllDeals(userId,"1");

            buyDeal = dealDao.getAllDeals(userId," and (deal_state = 1 or deal_state = 4)");
        	sellDeal = dealDao.getSellAllDeals(userId," and (deal_state = 1 or deal_state = 4)");
        	buyHistory = dealDao.getAllDeals(userId," and (deal_state = 3 or deal_state = 2)");
        	sellHistory = dealDao.getSellAllDeals(userId," and (deal_state = 3 or deal_state = 2)");
        }catch(IntegrationException e) {
        }

//        List<Object> first=new ArrayList<>();
//        first.add("data");
//        first.add(user);
//        System.out.println(first.get(0));

//        List<Object> second=new ArrayList<>();
//        second.add("deal");
//        second.add(deal);
//        System.out.println(second.get(0));
//
//        List<List> result=new ArrayList<>();
//        result.add(first);
//        result.add(second);
//        System.out.println(result.get(0));
        List<Object> first=new ArrayList<>();
		first.add("data");
		first.add(user);

		List<Object> second=new ArrayList<>();
		second.add("buyDeal");
		second.add(buyDeal);

		List<Object> third=new ArrayList<>();
		third.add("sellDeal");
		third.add(sellDeal);

		List<Object> fourth=new ArrayList<>();
		fourth.add("buyHistory");
		fourth.add(buyHistory);

		List<Object> fifth=new ArrayList<>();
		fifth.add("sellHistory");
		fifth.add(sellHistory);

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);
		result.add(third);
		result.add(fourth);
		result.add(fifth);

		resc.setResult(result);


        resc.setResult(result);
        resc.setTarget("admin/userInfo");
        return resc;
    }
}