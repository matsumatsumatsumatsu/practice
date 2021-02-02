package command;

import context.ResponseContext;

public class ForwardLoginCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		resc.setTarget("login");
        return resc;
	}
}
