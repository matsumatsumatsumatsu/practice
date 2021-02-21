package command;

import java.util.ArrayList;
import java.util.List;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.NoticeInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;
import util.SessionManager;

public class ShowNoticeListCommand extends AbstractCommand {
	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		NoticeInterfaceDao noticeDao = factory.getNoticeInterfaceDao();

		//ログインしているユーザーのIDを取得する
		SessionManager.getSession(reqc);
		String sessionUserId=((User)SessionManager.getAttribute("token")).getUserId();

		List notices = new ArrayList();
		try {
			notices = noticeDao.getAllNotices(sessionUserId);
			noticeDao.readCheck(sessionUserId);
		}catch(IntegrationException e) {
		}

		List<Object> first = new ArrayList();
		first.add("notice");
		first.add(notices);
		List<List> result = new ArrayList();
		result.add(first);

		resc.setResult(result);
		resc.setTarget("notifications");
		return resc;
	}

}
