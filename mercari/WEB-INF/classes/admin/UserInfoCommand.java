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

        DealInterfaceDao dealdao = factory.getDealInterfaceDao();
        RequestContext reqc = getRequestContext();


        List user = new ArrayList(); //ユーザーの情報
        List deal = new ArrayList();

        String userId = reqc.getParameter("user_id")[0];


        try {
            user = userdao.getUser(userId);
            deal = dealdao.getAllDeals(userId,"1");
        }catch(IntegrationException e) {
        }

        List<Object> first=new ArrayList<>();
        first.add("data");
        first.add(user);
        System.out.println(first.get(0));

        List<Object> second=new ArrayList<>();
        second.add("deal");
        second.add(deal);
        System.out.println(second.get(0));

        List<List> result=new ArrayList<>();
        result.add(first);
        result.add(second);
        System.out.println(result.get(0));


        resc.setResult(result);
        resc.setTarget("admin/userInfo");
        return resc;
    }
}