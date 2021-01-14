package dao;
import java.util.List;

import bean.User;

public interface UserInterfaceDao{
	  public void addUser(User user);
	    public List getAllUsers();
}