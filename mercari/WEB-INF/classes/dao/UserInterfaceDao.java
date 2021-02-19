package dao;
import java.util.List;

import bean.User;
import exception.IntegrationException;

public interface UserInterfaceDao{
	  public void addUser(User user) throws IntegrationException;
	  public List getUser(String userId) throws IntegrationException;
	  public List getUserPass(String userName) throws IntegrationException;
	  public List getCurrentUserPass(String userName) throws IntegrationException;
	  public void updateUser(User u,String id) throws IntegrationException;
	  public void deleteUser(String userId) throws IntegrationException;
	  public List getAllUsers() throws IntegrationException;
	  public void pay(String userId,int point) throws IntegrationException;
	  public void grantPoint(String userId,int point) throws IntegrationException;
}