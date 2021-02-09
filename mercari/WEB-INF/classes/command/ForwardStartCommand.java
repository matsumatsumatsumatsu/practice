package command;

import context.ResponseContext;

public class ForwardStartCommand extends AbstractCommand{
    public  ResponseContext execute(ResponseContext resc){
        resc.setTarget("start");
        return resc;
    }
}