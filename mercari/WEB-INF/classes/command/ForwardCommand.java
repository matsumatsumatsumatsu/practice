package command;

import context.ResponseContext;

public class ForwardCommand extends AbstractCommand{
    public  ResponseContext execute(ResponseContext resc){
		String name = getRequestContext().getCommandPath();
		System.out.println(name);
        resc.setTarget(name);
        return resc;
    }
}
