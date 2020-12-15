package command;

import context.RequestContext;
import context.ResponseContext;

public abstract class AbstractCommand {
	private RequestContext _req;
	public void init(RequestContext rc){
		_req=rc;
	}
	public RequestContext getRequestContext(){
		return _req;
	}
	public abstract ResponseContext execute(ResponseContext resc);
}
