package dao;

import java.util.List;

import exception.IntegrationException;

public interface NoticeInterfaceDao {
	public void registNotice(String userId,String comment) throws IntegrationException;
	public List getAllNotices(String userId) throws IntegrationException;
	public String readCheck(String userId) throws IntegrationException;
}
