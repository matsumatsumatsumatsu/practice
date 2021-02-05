package dao;
import java.util.List;

import bean.User;
import exception.IntegrationException;

public interface UserInterfaceDao{
	  public void addUser(User user) throws IntegrationException;
	  public List getUser(String userName) throws IntegrationException;
	  public void updateUser(User u) throws IntegrationException;
	  public void deleteUser(String userId) throws IntegrationException;
	  public List getAllUsers() throws IntegrationException;
}