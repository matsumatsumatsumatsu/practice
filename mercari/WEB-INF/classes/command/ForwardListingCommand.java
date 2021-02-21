package command;

import java.util.ArrayList;
import java.util.List;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.CategoryInterfaceDao;
import dao.HardwareInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;

public class ForwardListingCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
    	AbstractMysqlFactory factory=AbstractMysqlFactory.getFactory();
        CategoryInterfaceDao categorydao=factory.getCategoryInterfaceDao();
        HardwareInterfaceDao hardwaredao=factory.getHardwareInterfaceDao();

        RequestContext reqc = getRequestContext();
        List hardwares = new ArrayList();
        List categorys = new ArrayList();

        try {
        	hardwares = hardwaredao.getAllHardware();
        	categorys = categorydao.getAllCategory();
        }catch(IntegrationException e) {
        	//例外処理
        }

		List<Object> first=new ArrayList<>();
		first.add("hardware");
		first.add(hardwares);

        List<Object> second=new ArrayList<>();
        second.add("category");
        second.add(categorys);

		List<List> result=new ArrayList<>();
		result.add(first);
		result.add(second);

        resc.setResult(result);

		resc.setTarget("listing");
		return resc;
	}

}
