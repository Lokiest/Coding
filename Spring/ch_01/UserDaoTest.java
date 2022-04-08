package springbook.user.dao;

import java.sql.SQLException;

public class UserDaoTest {
	static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		
		UserDao dao = new UserDao(connectionMaker);
	}
}
