package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;

public class ReLoadItemListFilter implements Filter{
	  public void init(FilterConfig config)throws ServletException{}
	  public void destroy(){}

	  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException{
		  HttpServletRequest hreq = (HttpServletRequest)req;

		  AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
	      ItemInterfaceDao dao=factory.getItemInterfaceDao();

	      List items = dao.getAllItems();
	      hreq.setAttribute("itemlist", items);
	      System.out.println("items:"+items);

		  chain.doFilter(req,res);
	  }
}