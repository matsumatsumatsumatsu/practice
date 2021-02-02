package command;

import context.RequestContext;
import context.ResponseContext;
import util.SessionManager;

public class LogoutCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		SessionManager session = new SessionManager(reqc);
		session.invalidate();
		resc.setTarget("start");
		return resc;
	}
}
