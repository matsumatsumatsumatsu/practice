package command;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;

public class RemoveItemCommand extends AbstractCommand {
	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc =  getRequestContext();
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		ItemInterfaceDao dao = factory.getItemInterfaceDao();

		String itemId = reqc.getParameter("item_id")[0];

		try {
			dao.deleteItem(itemId);
		}catch(IntegrationException e) {
		}

		ShowProfileCommand show = new ShowProfileCommand();
		show.init(reqc);
		resc = show.execute(resc);

		resc.setTarget("mypage");
		return resc;
	}
}
