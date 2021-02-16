package command;

import context.RequestContext;
import context.ResponseContext;
import exception.BusinessLogicException;

public class SendPrivateChatCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
        RequestContext reqc = getRequestContext();

		String dealId = reqc.getParameter("deal_id")[0];


		String text = reqc.getParameter("text")[0];
		return null;
	}

}
