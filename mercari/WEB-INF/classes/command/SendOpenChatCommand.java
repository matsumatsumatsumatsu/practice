package command;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.OpenChat;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.OpenChatInterfaceDao;
import util.SessionManager;

public class SendOpenChatCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
        RequestContext reqc = getRequestContext();

       //sessionからuserIdを持ってくる
        SessionManager.getSession(reqc);
        String sessionUserId =  ((User)SessionManager.getAttribute("token")).getUserId();

        String texts[] = reqc.getParameter("text");
        String text = texts[0];

        String dates[] = reqc.getParameter("date");
        System.out.println(reqc.getParameter("date"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date parsedDate = null;
		try {
			parsedDate = sdf.parse(dates[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}

        String itemIds[] = reqc.getParameter("itemId");
        String itemId = itemIds[0];

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        OpenChatInterfaceDao dao = factory.getOpenChatInterfaceDao();

        System.out.println("token:"+SessionManager.getAttribute("token"));

        OpenChat oc = new OpenChat();
        oc.setUserId(sessionUserId);
        oc.setText(text);
        oc.setDate((Timestamp)parsedDate);

		resc.setResult("");
		return resc;
	}
}
