package command;

import context.RequestContext;
import context.ResponseContext;

public class ForwardShowItemInfoCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String itemId = reqc.getParameter("item_id")[0];

		ShowOpenChatCommand showChat = new ShowOpenChatCommand();
		ShowItemInfoCommand showItem = new ShowItemInfoCommand();
		showChat.init(reqc);
		showItem.init(reqc);
		resc = showChat.execute(resc);
		resc = showItem.execute(resc);
        return resc;
	}
}
