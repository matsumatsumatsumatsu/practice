package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import exception.IntegrationException;

public class ShowDealingInfo extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
        RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        DealInterfaceDao dao = factory.getDealInterfaceDao();

        String dealId = reqc.getParameter("deal_id")[0];

        List deal = new ArrayList();
        try {
			deal = dao.getDeal(dealId);
		} catch (IntegrationException e) {
			e.printStackTrace();
		}

        resc.setResult(deal);
        String userState= reqc.getParameter("user_state")[0];
        if(userState.equals("1")) {
        	resc.setTarget("buyerDealingInfo");
        }else {
        	resc.setTarget("sellerDealingInfo");
        }

		return resc;
	}

}
