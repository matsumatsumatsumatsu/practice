package command;

import context.ResponseContext;
import exception.BusinessLogicException;

public class ForwardEditProfileCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		resc.setTarget("profileEdit");
		return resc;
	}

}
