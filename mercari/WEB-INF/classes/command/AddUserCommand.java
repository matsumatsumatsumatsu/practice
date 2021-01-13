package command;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UsersDao;

public class AddUserCommand extends AbstractCommand{
    public  ResponseContext execute(ResponseContext rec){
        RequestContext rq=  getRequestContext();

        System.out.println("AddUser Command");

        String userNames[] =rq.getParameter("userName");
        String userName=userNames[0];
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
        u.setRealName(realName);
        u.setAddress(address);
    	u.setTel(tel);
    	u.setMail(mail);


        AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UsersDao dao=factory.getUsersDao();

        System.out.println("DAO"+dao.getClass().getName());

        dao.addUser(u);

        rec.setTarget("start");
        return rec;
    }
}
