package command;

import context.ResponseContext;

public class ForwardListingEditCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		resc.setTarget("listingEdit");
        return resc;
	}
}