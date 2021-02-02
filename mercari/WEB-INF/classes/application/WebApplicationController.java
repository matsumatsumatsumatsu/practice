package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AbstractCommand;
import command.CommandFactory;
import context.RequestContext;
import context.ResponseContext;
import context.WebRequestContext;
import context.WebResponseContext;
import exception.PresentationException;

public class WebApplicationController implements ApplicationController{
    public RequestContext getRequest(Object request){
        RequestContext reqc = new WebRequestContext();
        reqc.setRequest(request);

        return reqc;
    }
    public ResponseContext handleRequest(RequestContext req) throws PresentationException{
        AbstractCommand command = CommandFactory.getCommand(req);
        command.init(req);

        ResponseContext reqc = command.execute(new WebResponseContext());
        return reqc;
    }
    public void handleResponse(RequestContext reqc,ResponseContext resc){
        HttpServletRequest req=(HttpServletRequest)reqc.getRequest();
        HttpServletResponse res=(HttpServletResponse)resc.getResponse();

        req.setAttribute("data",resc.getResult());
        RequestDispatcher rd= req.getRequestDispatcher(resc.getTarget());
        try{
            rd.forward(req,res);
        }catch(ServletException e){

        }catch(IOException e){

        }
    }
}