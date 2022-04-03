package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public abstract class UserDao {
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO USERS(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
		ps.setString(1, id);
		
		ResultSet rs  = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		con.close();
		
		return user;
	}
	
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
	public class NUserDao extends UserDao {
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			return null;
			//N사 DB connection 생성코드
		}
	}
	
	public class DUserDao extends UserDao {
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			return null;
			//D사 DB connection 생성코드
		}
	}
}
