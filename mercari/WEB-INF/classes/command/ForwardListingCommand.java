package command;

import context.ResponseContext;
import exception.BusinessLogicException;

public class ForwardListingCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		resc.setTarget("listing");
		return resc;
	}

}
