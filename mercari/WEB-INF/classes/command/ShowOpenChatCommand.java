package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.OpenChatInterfaceDao;
import exception.IntegrationException;

public class ShowOpenChatCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
        OpenChatInterfaceDao dao = factory.getOpenChatInterfaceDao();
        RequestContext reqc = getRequestContext();

        System.out.println("--ShowOpenChat--");

        List chat = new ArrayList();

        String itemId = reqc.getParameter("item_id")[0];
        try {
        	chat = dao.getAllMessage(itemId);
        }catch(IntegrationException e) {
        }

        System.out.println("chat:"+chat);

        List<Object> first=new ArrayList<>();
		first.add("open");
		first.add(chat);
		List<List> result=new ArrayList<>();
		result.add(first);

        resc.setResult(result);

		return resc;
	}
}
