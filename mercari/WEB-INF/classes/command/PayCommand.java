package command;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.BusinessLogicException;
import util.SessionManager;

public class PayCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();

		//ログインしているユーザーのIDを取得する
		SessionManager.getSession(reqc);
		System.out.println("token:"+SessionManager.getAttribute("token"));
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();
	    System.out.println("user_id="+sessionUserId);

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		UserInterfaceDao dao = factory.getUserInterfaceDao();



		return null;
	}

}
