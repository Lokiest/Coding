package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDao {
	public UserDao() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
	}
	
	private ConnectionMaker connectionMaker;
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	private Connection con;
	private User user;
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		this.con = connectionMaker.makeConnection();
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO USERS(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection con = connectionMaker.makeConnection();
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
		ps.setString(1, id);
		
		ResultSet rs  = ps.executeQuery();
		User user = null;
		
		if (rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		
		rs.close();
		ps.close();
		con.close();
		
		if (user == null) throw new EmptyResultDataAccessException(1);
		
		return user;
	}
	
	public void deleteAll() throws ClassNotFoundException, SQLException {
		Connection con = connectionMaker.makeConnection();
		
		PreparedStatement ps = con.prepareStatement("DELETE FROM USERS");
		
		ps.executeQuery();

		ps.close();
		con.close();
	}
	
	public int getCount() throws ClassNotFoundException, SQLException {
		Connection con = connectionMaker.makeConnection();
		
		PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM USERS");
		ResultSet rs  = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);

		rs.close();
		ps.close();
		con.close();
		
		return count;
	}
	
	
}
