package com.example.demo;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
	}
	//
	// Dao 사용 코드
	//
	
	CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
	System.out.println("Connection counter : " + ccm.getCounter());
}
