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
import javax.servlet.http.HttpSession;

import bean.User;
import dao.AbstractMysqlFactory;
import dao.ItemInterfaceDao;
import exception.IntegrationException;

public class ReLoadItemListFilter implements Filter{
	  public void init(FilterConfig config)throws ServletException{}
	  public void destroy(){}

	  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException{
		  HttpServletRequest hreq = (HttpServletRequest)req;

		  AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
	      ItemInterfaceDao dao=factory.getItemInterfaceDao();

	      //商品一覧取得
	      List items = new ArrayList();

	      try {
	    	  items = dao.getAllItems();
	      }catch(IntegrationException e) {

	      }
	      hreq.setAttribute("itemlist", items);
//	      System.out.println("items:"+items);

	      //ログインしているかどうかの確認
	  	HttpSession session=((HttpServletRequest) req).getSession();

	    Object flag=session.getAttribute("token");


	    if(flag != null) {
	    	hreq.setAttribute("flag", "OK");
		    String sessionUserId =  ((User)flag).getUserId();
	    	hreq.setAttribute("userId", sessionUserId);
	    }

		  chain.doFilter(req,res);
	  }
}