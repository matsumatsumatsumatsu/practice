package admin;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.UserInterfaceDao;
import exception.IntegrationException;

public class GrantPointCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
		RequestContext reqc = getRequestContext();
		UserInterfaceDao userdao = factory.getUserInterfaceDao();

		List user = new ArrayList(); //ユーザーの情報

		String userId 	=reqc.getParameter("user_id")[0];
//		int userPoint = reqc.getParameter()
		//int grantPoint;
		String point 	=reqc.getParameter("point")[0];




        try {

        	user = userdao.getUser(userId);

        	System.out.println("userId:"+userId);
        }catch(IntegrationException e) {

        }

//		user = userdao.grantPoint(userId,point);
        int userPoint = ((User)user.get(0)).getPoint();
        int addition = (int)userPoint + (Integer.parseInt(point));

        try {

        	userdao.grantPoint(userId,addition);
        }catch(IntegrationException e) {

        }
        System.out.println(userId+"|"+point);
		resc.setTarget("admin/userInfo");
		return resc;
	}
}
