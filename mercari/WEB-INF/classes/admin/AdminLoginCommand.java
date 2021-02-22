package admin;
import bean.Admin;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.AdminInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;


public class AdminLoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rq=  getRequestContext();

        String adminName =rq.getParameter("adminName")[0];
        String adminPassword =rq.getParameter("adminPassword")[0];

        AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        AdminInterfaceDao dao=factory.getAdminInterfaceDao();
        Admin admin= new Admin();
		try {
			admin = (Admin)dao.getAdminPass(adminName).get(0);
		} catch (IntegrationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        if(adminPassword.equals(admin.getAdminPassword())) {
            SessionManager.getSession(rq);;
        	SessionManager.setAttribute("token",admin);
        	System.out.println("ログインユーザー名："+adminName+" :	ログイン完了");
        	resc.setTarget("admin/admin");
        }
        else {
        	resc.setTarget("../../login");
        }
        return resc;
	}
}