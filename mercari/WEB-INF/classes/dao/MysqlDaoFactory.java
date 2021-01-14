package dao;
public class MysqlDaoFactory extends AbstractMysqlFactory{
    public UserInterfaceDao getUserInterfaceDao(){
        return new UserDao();
    }

    public ItemInterfaceDao getListingInterfaceDao() {
    	return new ItemDao();
    }
}
