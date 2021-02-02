package command;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;

public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rq=  getRequestContext();

		String userNames[] =rq.getParameter("userName");
        String userName=userNames[0];
        String userPasswords[] =rq.getParameter("userPassword");
        String userPassword=userPasswords[0];

        AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UserInterfaceDao dao=factory.getUserInterfaceDao();

        dao.getUser(userName);
		resc.setTarget("start");
        return resc;
	}
}