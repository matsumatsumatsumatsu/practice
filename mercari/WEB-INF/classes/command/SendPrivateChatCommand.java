package command;

import bean.PrivateChat;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import exception.BusinessLogicException;
import util.SessionManager;

public class SendPrivateChatCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
        RequestContext reqc = getRequestContext();
		String dealId = reqc.getParameter("deal_id")[0];
		String buyerId = null;
		String sellerId = null;
        //sessionからuserIdを持ってくる
        SessionManager.getSession(reqc);
        String sessionUserId =  ((User)SessionManager.getAttribute("token")).getUserId();

        //飛んできた先で買い手か売り手か判定
        if(reqc.getCommandPath() == "buyerDealingInfo") {
        	buyerId = sessionUserId;
        }else {
        	sellerId = sessionUserId;
        }
        System.out.println("reqc.getCommandPath() ="+reqc.getCommandPath());
        System.out.println("sellerId="+sellerId);
        System.out.println("buyerId="+buyerId);

		String text = reqc.getParameter("text")[0];

		PrivateChat p = new PrivateChat();
		p.setDealId(dealId);
		p.setBuyerId(buyerId);
		p.setSellerId(sellerId);
		p.setText(text);

		return resc;
	}

}
