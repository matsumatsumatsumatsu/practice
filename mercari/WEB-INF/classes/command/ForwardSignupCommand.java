package command;

import context.ResponseContext;

public class ForwardSignupCommand extends AbstractCommand{
    public  ResponseContext execute(ResponseContext resc){
        resc.setTarget("signup");
        return resc;
    }
}