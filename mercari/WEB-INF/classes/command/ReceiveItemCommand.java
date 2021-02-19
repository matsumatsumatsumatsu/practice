package command;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import exception.IntegrationException;

public class ReceiveItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();



		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		DealInterfaceDao dao = factory.getDealInterfaceDao();

		String  dealId= reqc.getParameter("deal_id")[0];

		try{
			dao.changeState(dealId, "3");
		}catch(IntegrationException e) {
			//例外処理
		}

		ShowDealingInfoCommand show = new ShowDealingInfoCommand();
		show.init(reqc);
		resc = show.execute(resc);

		return resc;
	}

}
