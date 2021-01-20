package command;

import context.ResponseContext;

public class ForwardAddUserCommand extends AbstractCommand{
    public  ResponseContext execute(ResponseContext resc){
        resc.setTarget("input");
        return resc;
    }
}