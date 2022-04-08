package springbook.user.dao;

public class DaoFactory {
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	public AccountDao accountDao() {
		return new AccountDao(connectionMaker());
	}
	
	public MessageDao messageDao() {
		return new MessageDao(connectionMaker());
	}
	
	public ConnectionMaker connectionMaker() { //분리해서 중복을 제거
		return new DConnectionMaker();
	}
}
