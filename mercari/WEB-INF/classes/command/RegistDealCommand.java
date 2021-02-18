//dealを挿入するcommand
package command;

import bean.Deal;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;
import util.SessionManager;

public class RegistDealCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException{
		RequestContext reqc = getRequestContext();

		String itemId = reqc.getParameter("item_id")[0];

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		DealInterfaceDao dao = factory.getDealInterfaceDao();

		SessionManager.getSession(reqc);
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();

		Deal deal = new Deal();
		deal.setBeforePaymentId(null);
		deal.setBeforePaymentId(null);
		deal.setItemId(itemId);
		//1は取引中
		deal.setDealState("1");
		deal.setUserId(sessionUserId);
		//1は購入者の取引中
		deal.setUserState("1");

		try{
			dao.insertDeal(deal);
		}catch(IntegrationException e) {
			//例外処理
		}

		PayCommand pay = new PayCommand();
		pay.init(reqc);
		resc = pay.execute(resc);

		resc.setTarget("buyerDealingInfo");

		return resc;
	}
}
