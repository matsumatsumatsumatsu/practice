package command;

import context.ResponseContext;

public class ForwardListingCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		resc.setTarget("listing");
        return resc;
	}
}
