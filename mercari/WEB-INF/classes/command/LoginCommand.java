package command;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import util.SessionManager;


public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rq=  getRequestContext();

        String userName =rq.getParameter("userName")[0];
        String userPassword =rq.getParameter("userPassword")[0];

        AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UserInterfaceDao dao=factory.getUserInterfaceDao();
        User ub = dao.getUser(userName);

        System.out.println("user:"+ub);

        if(userPassword.equals(ub.getUserPassword())) {
            SessionManager session = new SessionManager(rq);
        	session.setAttribute("token",ub);
        	System.out.println("token取得");
        	resc.setTarget("start");
        }
        else {
        	resc.setTarget("login");
        }

        return resc;
	}
}