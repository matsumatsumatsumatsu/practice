package command;

import bean.OpenChat;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.OpenChatInterfaceDao;
import exception.IntegrationException;
import util.SessionManager;

public class SendOpenChatCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
        RequestContext reqc = getRequestContext();

       //sessionからuserIdを持ってくる
        SessionManager.getSession(reqc);
        String sessionUserId =  ((User)SessionManager.getAttribute("token")).getUserId();

        String texts[] = reqc.getParameter("text");
        System.out.println("SendOpenChatCommand.java:"+reqc.getParameter("text"));
        String text = texts[0];

        String itemIds[] = reqc.getParameter("item_id");
        System.out.println("item_id="+reqc.getParameter("item_id"));
        String itemId = itemIds[0];

		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        OpenChatInterfaceDao dao = factory.getOpenChatInterfaceDao();

        System.out.println("token:"+SessionManager.getAttribute("token"));

        OpenChat op = new OpenChat();
        op.setUserId(sessionUserId);
        op.setText(text);
        op.setItemId(itemId);

		try {
	        dao.send(op);
		}catch(IntegrationException e) {

		}

        ShowItemInfoCommand show = new ShowItemInfoCommand();
        show.init(reqc);
        resc = show.execute(resc);

		return resc;
	}
}
