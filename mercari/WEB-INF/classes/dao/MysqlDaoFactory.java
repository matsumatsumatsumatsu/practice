package dao;
public class MysqlDaoFactory extends AbstractMysqlFactory{
	@Override
	public AdminInterfaceDao getAdminInterfaceDao() {
		return new AdminDao();
	}

	@Override
	public CategoryInterfaceDao getCategoryInterfaceDao() {
		return new CategoryDao();
	}

	@Override
	public DealInterfaceDao getDealInterfaceDao() {
		return new DealDao();
	}

	@Override
	public HardwareInterfaceDao getHardwareInterfaceDao() {
		return new HardwareDao();
	}

	@Override
    public ItemInterfaceDao getItemInterfaceDao() {
    	return new ItemDao();
    }

	@Override
	public NoticeInterfaceDao getNoticeInterfaceDao() {
		return  new NoticeDao();
	}

	@Override
	public OpenChatInterfaceDao getOpenChatInterfaceDao() {
		return new OpenChatDao();
	}

	@Override
	public PaymentLogInterfaceDao getPaymentLogInterfaceDao() {
		return new PaymentLogDao();
	}

	@Override
	public PrivateChatInterfaceDao getPrivateChatInterfaceDao() {
		return new PrivateChatDao();
	}

	@Override
    public UserInterfaceDao getUserInterfaceDao(){
        return new UserDao();
    }
}
