package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import dao.PrivateChatInterfaceDao;
import exception.IntegrationException;

public class ShowDealingInfoCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
        RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        DealInterfaceDao dealdao = factory.getDealInterfaceDao();
        PrivateChatInterfaceDao pcdao = factory.getPrivateChatInterfaceDao();

        String dealId = reqc.getParameter("deal_id")[0];

        List deal = new ArrayList();
        try {
			deal = dealdao.getDeal(dealId);
		} catch (IntegrationException e) {
			e.printStackTrace();
		}
        List first = new ArrayList();
        first.add("deal");
        first.add(deal);

        List chat = new ArrayList();
        try {
			chat = pcdao.getAllMessage(dealId);
		} catch (IntegrationException e) {
			e.printStackTrace();
		}
        List second = new ArrayList();
        second.add("chat");
        second.add(chat);

        List result = new ArrayList();
        result.add(first);
        result.add(second);

        resc.setResult(result);
        String userState= reqc.getParameter("user_state")[0];
        if(userState.equals("1")) {
        	resc.setTarget("buyerDealingInfo");
        }else {
        	resc.setTarget("sellerDealingInfo");
        }

		return resc;
	}

}