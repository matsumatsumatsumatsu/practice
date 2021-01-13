package dao;
import java.util.List;

import bean.User;

public interface UserInterfaceDao{
    public void addUser(User p);
    public User getUser(String pid);
    public List getAllProducts();
}