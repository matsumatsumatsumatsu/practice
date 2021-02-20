package command;

import context.ResponseContext;

public class ForwardShowOwnListingList extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		resc.setTarget("ShowOwnListingList");
        return resc;
	}
}