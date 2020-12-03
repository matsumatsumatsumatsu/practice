
package tera;
import dao.AbstractMysqlFactory;
import dao.UsersDao;

public class AddUserCommand extends AbstractCommand{
    public  ResponseContext execute(ResponseContext rec){
        RequestContext rq=  getRequestContext();

        System.out.println("AddUser Command");

        String user_names[] =rq.getParameter("user_name");
        String user_name=user_names[0];
        String real_names[] =rq.getParameter("real_name");
        String real_name=real_names[0];
        String addresses[] =rq.getParameter("address");
        String address=addresses[0];
    	String tells[] =rq.getParameter("tell");
        String tell=tells[0];
    	String malis[] =rq.getParameter("mali");
        String mali=malis[0];
        User u= new User();
        u.setUser_name(user_name);
        u.setReal_name(real_name);
        u.setAddress(address);
    	u.setTell(tell);
    	u.setMail(mali);


        AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        UsersDao dao=factory.getUsersDao();

        System.out.println("DAO"+dao.getClass().getName());
        //呼ばれていない
        dao.addUser(u);

        rec.setTarget("start");
        return rec;
    }
}
