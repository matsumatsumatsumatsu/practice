package command;

import context.ResponseContext;

public class ForwardLogoutCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		resc.setTarget("logout");
        return resc;
	}
}
