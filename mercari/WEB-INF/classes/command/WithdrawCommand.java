package command;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;
import util.SessionManager;

public class WithdrawCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();

		//ログイン中のユーザーidから登録しているパスワードを取得する
		//sessionからuserIdを取得
		SessionManager.getSession(reqc);
		String sessionUserId = ((User)SessionManager.getAttribute("token")).getUserId();
		User ub = null;
		try {
			ub = (User)userDao.getCurrentUserPass(sessionUserId).get(0);
		} catch (IntegrationException e) {
			e.printStackTrace();
		}

		//入力されたパスワードと一致するか確認する
		String userPassword =reqc.getParameter("userPassword")[0];

		 if(userPassword.equals(ub.getUserPassword())) {
			 userDao.deleteUser(sessionUserId);
	 		SessionManager.invalidate();
			resc.setTarget("start");
		 }else {
			 resc.setTarget("login");
		 }

		return resc;
	}
}
