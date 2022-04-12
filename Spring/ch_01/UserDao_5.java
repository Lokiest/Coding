package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	private ConnectionMaker connectionMaker;
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
		rs.next();
		this.user = new User();
		this.user.setId(rs.getString("id"));
		this.user.setName(rs.getString("name"));
		this.user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		con.close();
		
		return this.user;
	}
}
