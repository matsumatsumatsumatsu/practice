package dao;
import java.util.List;

import tera.User;

public interface UsersDao{
    public void addUser(User p);
    public User getUser(String pid);
    public List getAllProducts();
}