package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.AbstractMysqlFactory;
import dao.NoticeInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;

public class NoticeCheckFilter {
	public void init(FilterConfig config)throws ServletException{}
	public void destroy(){}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException{
		HttpServletRequest hreq = (HttpServletRequest)req;

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		NoticeInterfaceDao dao=factory.getNoticeInterfaceDao();

		//ログインしているユーザーのIDを取得する
		HttpSession session=((HttpServletRequest) req).getSession();
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();

		List notices = new ArrayList();

		try {
			notices = dao.getAllNotices(sessionUserId);
		}catch(IntegrationException e) {

		}
		hreq.setAttribute("notice", notices);

		chain.doFilter(req,res);
	}
}
