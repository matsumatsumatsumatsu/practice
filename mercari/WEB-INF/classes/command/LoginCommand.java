package command;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;


public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rq=  getRequestContext();

        String userName =rq.getParameter("userName")[0];
        String userPassword =rq.getParameter("userPassword")[0];

        AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UserInterfaceDao dao=factory.getUserInterfaceDao();
        User ub = null;
		try {
			ub = (User)dao.getUserPass(userName).get(0);
		} catch (IntegrationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        if(userPassword.equals(ub.getUserPassword())) {
            SessionManager.getSession(rq);;
        	SessionManager.setAttribute("token",ub);
        	System.out.println("ログインユーザー名："+userName+" :	ログイン完了");
        	resc.setTarget("start");
        }
        else {
        	resc.setTarget("login");
        }

        return resc;
	}
}