package command;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.IntegrationException;

public class SignupCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		RequestContext rq=  getRequestContext();

		String userNames[] =rq.getParameter("userName");
		String userName=userNames[0];
		String userPasswords[] =rq.getParameter("userPassword");
		String userPassword=userPasswords[0];
		String realNames[] =rq.getParameter("realName");
		String realName=realNames[0];
		String addresses[] =rq.getParameter("address");
		String address=addresses[0];
		String tels[] =rq.getParameter("tel");
		String tel=tels[0];
		String mails[] =rq.getParameter("mail");
		String mail=mails[0];
		User u= new User();
		u.setUserName(userName);
		u.setUserPassword(userPassword);
		u.setRealName(realName);
		u.setAddress(address);
		u.setTel(tel);
		u.setMail(mail);

		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		UserInterfaceDao dao=factory.getUserInterfaceDao();

		try {
			dao.addUser(u);
		} catch (IntegrationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		LoginCommand login = new LoginCommand();
		login.init(rq);
		resc = login.execute(resc);

		resc.setTarget("start");
		return resc;
	}
}
