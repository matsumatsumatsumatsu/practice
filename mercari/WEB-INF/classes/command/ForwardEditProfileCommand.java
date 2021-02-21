package command;

import context.RequestContext;
import context.ResponseContext;
import exception.BusinessLogicException;

public class ForwardEditProfileCommand extends AbstractCommand {
	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();
		ShowProfileCommand show = new ShowProfileCommand();
		show.init(reqc);
		resc = show.execute(resc);

		resc.setTarget("profileEdit");
		return resc;
	}

}
