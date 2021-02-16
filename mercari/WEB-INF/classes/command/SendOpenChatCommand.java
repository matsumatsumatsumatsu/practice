package command;

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

        String texts[] = reqc.getParameter("openChatText");
        String text = texts[0];

        String itemIds[] = reqc.getParameter("itemId");
        String itemId = itemIds[0];

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        OpenChatInterfaceDao dao = factory.getOpenChatInterfaceDao();

        System.out.println("token:"+SessionManager.getAttribute("token"));

        OpenChat oc = new OpenChat();
        oc.setUserId(sessionUserId);
        oc.setText(text);

		resc.setResult("");
		return resc;
	}
}
