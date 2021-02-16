package command;

import context.ResponseContext;

public class ForwardShowItemInfoCommand extends AbstractCommand{
	public  ResponseContext execute(ResponseContext resc){
		ShowOpenChatCommand showChat = new ShowOpenChatCommand();
		ShowItemInfoCommand showItem = new ShowItemInfoCommand();
		showChat.execute(resc);
		showItem.execute(resc);
        return resc;
	}
}
