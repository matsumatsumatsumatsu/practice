package command;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;

public class RegistDealCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException{
		RequestContext reqc = getRequestContext();

		String itemId = reqc.getParameter("item_id")[0];

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		DealInterfaceDao dao = factory.getDealInterfaceDao();

		try{
			dao.insertDeal(itemId);
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
