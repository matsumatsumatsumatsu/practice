package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractMysqlFactory;
import dao.CategoryInterfaceDao;
import exception.IntegrationException;

public class ReLoadCategoryFilter implements Filter{
	  public void init(FilterConfig config)throws ServletException{}
	  public void destroy(){}

	  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException{
		  HttpServletRequest hreq = (HttpServletRequest)req;

		  AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
	      CategoryInterfaceDao dao=factory.getCategoryInterfaceDao();

	      List categorys = new ArrayList();

	      try {
	    	  categorys = dao.getAllCategory();
	      }catch(IntegrationException e) {

	      }
	      hreq.setAttribute("category", categorys);


		  chain.doFilter(req,res);
	  }
}