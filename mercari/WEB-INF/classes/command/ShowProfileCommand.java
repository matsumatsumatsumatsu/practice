package command;

import context.RequestContext;
import context.ResponseContext;

public class ShowProfileCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		String profUserId  = reqc.getParameter("user_id")[0];	//プロフィールに遷移するユーザーのID

		String sessionToken = reqc.getParameter("user_session")[0];	//ログインしてるユーザーのsessionToken


		resc.setTarget("");
		return resc;
	}
}
