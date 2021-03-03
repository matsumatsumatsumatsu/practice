package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticateFilter implements Filter{
	public void init(FilterConfig config)throws ServletException{}
	public void destroy(){}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException{
		//	HttpServletRequest hreq=(HttpServletRequest)req;
		HttpSession session=((HttpServletRequest) req).getSession();

		Object flag=session.getAttribute("token");

		if(flag==null){
			//	  String servletPath=hreq.getServletPath();
			//      hreq.setAttribute("target",servletPath);

			RequestDispatcher dis=req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dis.forward(req,res);
		}else{
			chain.doFilter(req,res);
		}
	}
}
