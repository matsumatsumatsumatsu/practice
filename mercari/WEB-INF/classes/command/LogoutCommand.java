package command;

import context.RequestContext;
import context.ResponseContext;
import util.SessionManager;

public class LogoutCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		SessionManager.getSession(reqc);
		SessionManager.invalidate();
		resc.setTarget("completeLogout");
		return resc;
	}
}
