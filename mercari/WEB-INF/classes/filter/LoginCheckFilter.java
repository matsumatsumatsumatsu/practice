package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{
    public void init(FilterConfig config)throws ServletException{
    }
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{


        String id=req.getParameter("name");
        String pass=req.getParameter("pass");



        if(id!=null&&pass!=null){

           HttpSession session=((HttpServletRequest)req).getSession();
           session.setAttribute("mflag","OK");
        }

        chain.doFilter(req,res);

    }
}

