package command;

import context.ResponseContext;

public class ForwardSignupCommand extends AbstractCommand{
    public  ResponseContext execute(ResponseContext resc){
        resc.setTarget("input");
        return resc;
    }
}