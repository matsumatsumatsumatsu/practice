package command;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import exception.IntegrationException;

public class DispatchItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		DealInterfaceDao dealDao = factory.getDealInterfaceDao();

		String  dealId= reqc.getParameter("deal_id")[0];


		try{
			//考えもの
			dealDao.changeState(dealId, "4");
//			dealDao.changeState(dealId, "1");
		}catch(IntegrationException e) {
			//例外処理
		}

		ShowDealingInfoCommand show = new ShowDealingInfoCommand();
		show.init(reqc);
		resc = show.execute(resc);

		return resc;
	}

}
