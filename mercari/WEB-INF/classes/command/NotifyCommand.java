package command;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractMysqlFactory;
import dao.NoticeInterfaceDao;
import exception.BusinessLogicException;
import exception.IntegrationException;

public class NotifyCommand extends AbstractCommand {
	private String userId;
	private String comment;

	public NotifyCommand(String userId,String comment) {
		this.userId = userId;
		this.comment = comment;
	}

	//他のcommandがこのcommandを呼び出す
	@Override
	public ResponseContext execute(ResponseContext resc) throws BusinessLogicException {
		RequestContext reqc = getRequestContext();
		AbstractMysqlFactory factory = AbstractMysqlFactory.getFactory();
		NoticeInterfaceDao noticeDao = factory.getNoticeInterfaceDao();

		try {
			noticeDao.registNotice(userId,comment);
		}catch(IntegrationException e) {
		}

		return resc;
	}
}
