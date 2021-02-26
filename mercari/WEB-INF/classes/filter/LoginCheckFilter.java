package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginCheckFilter implements Filter{
  public void init(FilterConfig config)throws ServletException{}
  public void destroy(){}

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException{
//	HttpServletRequest hreq = (HttpServletRequest)req;
//	HttpSession session=((HttpServletRequest) req).getSession();
//
//    Object flag=session.getAttribute("token");
//
//    if(flag != null) {
//    	hreq.setAttribute("flag", "OK");
//    }

    chain.doFilter(req,res);

  }
}
