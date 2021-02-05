package dao;
import java.util.List;

import bean.User;

public interface UserInterfaceDao{
	  public void addUser(User user);
	  public List getUser(String userName);
	  public void updateUser(User u);
	  public void deleteUser(String userId);
	  public List getAllUsers();
}