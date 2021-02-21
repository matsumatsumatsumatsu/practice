package admin;

import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.DealInterfaceDao;
import exception.IntegrationException;

public class ChangeStateCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {
        AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();


        DealInterfaceDao dealdao = factory.getDealInterfaceDao();
        RequestContext reqc = getRequestContext();




        String dealId = reqc.getParameter("deal_id")[0];
        System.out.print("ChangeStateCommand"+dealId);


        try {
           dealdao.changeState(dealId,"2");
        }catch(IntegrationException e) {
        }



        resc.setTarget("admin/admin");
        return resc;
    }
}
