package dao;
public class MysqlDaoFactory extends AbstractMysqlFactory{
    public UsersDao getUsersDao(){
        return new UserDao();
    }

}
