package dao;
import java.util.List;

import bean.User;

public interface UsersDao{
    public void addUser(User user);
    public List getAllUsers();
}