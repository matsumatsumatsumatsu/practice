package command;

import java.util.ArrayList;
import java.util.List;

import bean.PrivateChat;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.PrivateChatInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;
import util.SessionManager;

public class SendPrivateChatCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
        RequestContext reqc = getRequestContext();

        AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        PrivateChatInterfaceDao dao = factory.getPrivateChatInterfaceDao();

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
//        System.out.println("reqc.getCommandPath() ="+reqc.getCommandPath());
//        System.out.println("sellerId="+sellerId);
//        System.out.println("buyerId="+buyerId);

		String text = reqc.getParameter("text")[0];

		PrivateChat p = new PrivateChat();
		p.setDealId(dealId);
		p.setBuyerId(buyerId);
		p.setSellerId(sellerId);
		p.setText(text);

		List chat = new ArrayList();
        try {
			dao.send(p);
		} catch (IntegrationException e) {
			e.printStackTrace();
		}

		String userState= reqc.getParameter("user_state")[0];
		System.out.println("userState:"+userState);

		ShowDealingInfoCommand s = new ShowDealingInfoCommand();
		s.init(reqc);
		resc = s.execute(resc);

//        if(userState.equals("1")) {
//        	resc.setTarget("buyerDealingInfo");
//        }else {
//        	resc.setTarget("sellerDealingInfo");
//        }

		return resc;
	}

}
