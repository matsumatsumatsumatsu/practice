package tera;


public class InputCommand extends AbstractCommand{
    public  ResponseContext execute(ResponseContext reqc){
        reqc.setTarget("input");
        return reqc;
    }
}