package front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.ApplicationController;
import application.WebApplicationController;
import context.RequestContext;
import context.ResponseContext;
import exception.PresentationException;

public class FrontServlet extends javax.servlet.http.HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// doPostを呼び出す
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		try {
			req.setCharacterEncoding("UTF-8");
			ApplicationController app=new WebApplicationController();
			RequestContext reqc = app.getRequest(req);
			ResponseContext resc= app.handleRequest(reqc);
			resc.setResponse(res);
			app.handleResponse(reqc,resc);
		}catch(PresentationException e){
			e.printStackTrace();
		}
	}
}