package dao;

import java.util.List;

import bean.PrivateChat;
import exception.IntegrationException;

public interface PrivateChatInterfaceDao {
	public void send(PrivateChat p) throws IntegrationException;
	public List getAllMessage(String deal_id) throws IntegrationException;
}
