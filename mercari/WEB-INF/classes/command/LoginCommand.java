package command;

import context.RequestContext;
import context.ResponseContext;


public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext rq = getRequestContext();


		return resc;
	}

}
