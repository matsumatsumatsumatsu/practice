package dao;

import java.util.List;

import bean.OpenChat;
import exception.IntegrationException;

public interface OpenChatInterfaceDao {
	public void send(OpenChat op) throws IntegrationException;
	public List getAllMessage(String item_id) throws IntegrationException;
}
