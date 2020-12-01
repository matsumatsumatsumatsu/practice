package tera;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebApplicationControler implements ApplicationController{
    public RequestContext getRequest(Object request){
        RequestContext reqc = new WebRequestContext();
        reqc.setRequest(request);

        return reqc;
    }
    public ResponseContext handleRepuest(RequestContext req){
        AbstractCommand command = CommandFactory.getCommand(req);
        command.init(req);

        ResponseContext reqc = command.execute(new WebResponseContext());
        return reqc;
    }
    public void handleResponse(RequestContext reqc,ResponseContext resc){
        HttpServletRequest req=(HttpServletRequest)reqc.getRequest();
        HttpServletResponse res=(HttpServletResponse)resc.getResponse();

        req.setAttribute("date",resc.getResult());
        RequestDispatcher rd= req.getRequestDispatcher(resc.getTarget());
        try{
            rd.forward(req,res);
        }catch(ServletException e){

        }catch(IOException e){

        }
    }
}