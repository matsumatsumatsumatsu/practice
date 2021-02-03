package command;

import context.ResponseContext;

public class ForwardShowItemInfoCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		resc.setTarget("item");
        return resc;
	}
}
