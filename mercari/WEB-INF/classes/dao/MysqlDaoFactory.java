package dao;
public class MysqlDaoFactory extends AbstractMysqlFactory{
    public UserInterfaceDao getUserInterfaceDao(){
        return new UserDao();
    }

    public ListingInterfaceDao getListingInterfaceDao() {
    	return new ListingDao();
    }
}
