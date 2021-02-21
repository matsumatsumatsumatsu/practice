package command;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;

public class EditProfileCommad extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		UserInterfaceDao userDao = factory.getUserInterfaceDao();

		//ログインしているユーザーのIDを取得する
		SessionManager.getSession(reqc);
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();

		String userName = reqc.getParameter("name")[0];
		String password = reqc.getParameter("pass")[0];
		String realName = reqc.getParameter("real")[0];
		String tel = reqc.getParameter("tel")[0];
		String address = reqc.getParameter("address")[0];
		String profile = reqc.getParameter("prof")[0];

		User u= new User();
		u.setUserName(userName);
		u.setUserPassword(password);
		u.setRealName(realName);
		u.setAddress(address);
		u.setTel(tel);
		u.setMail(profile);

		try {
			userDao.updateUser(u,sessionUserId);
		} catch (IntegrationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		ShowProfileCommand show = new ShowProfileCommand();
		show.init(reqc);
		resc = show.execute(resc);

		resc.setTarget("mypage");
		return resc;
	}

}
