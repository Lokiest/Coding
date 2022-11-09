package user.model;

import java.sql.*;
import java.util.*;

import common.util.*;

public class UserDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDAO() {
		System.out.println("UserDAO생성자()");
	}
	
	public int insertUser(UserVO user) throws SQLException {
		try {
			con=DBUtil.getCon();
			StringBuilder buf = new StringBuilder("insert into member")
					.append(" values(member_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate,1000,0)");
			String sql = buf.toString();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUserid());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getHp1());
			ps.setString(5, user.getHp2());
			ps.setString(6, user.getHp3());
			ps.setString(7, user.getPost());
			ps.setString(8, user.getAddr1());
			ps.setString(9, user.getAddr2());
			
			return ps.executeUpdate();
		} finally {
			close();
		}
	}
	
	public List<UserVO> listUser() throws SQLException {
		try {
			con=DBUtil.getCon();
			StringBuilder buf=new StringBuilder("select * from member order by idx desc");
			String sql=buf.toString();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<UserVO> arr= makeList(rs);
			return arr;

		} finally {
			close();
		}
	}
	
	private List<UserVO> makeList(ResultSet rs) throws SQLException {
		List<UserVO> arr= new ArrayList<>();
		while(rs.next()) {
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			String userid = rs.getString("userid");
			String pwd = rs.getString("pwd");
			String hp1 = rs.getString("hp1");
			String hp2 = rs.getString("hp2");
			String hp3 = rs.getString("hp3");
			String post = rs.getString("post");
			String addr1 = rs.getString("addr1");
			String addr2 = rs.getString("addr2");
			java.sql.Date indate = rs.getDate("indate");
			int mileage = rs.getInt("mileage");
			int status = rs.getInt("status");
			
			UserVO user = 
					new UserVO(idx, name,userid,pwd,hp1,hp2,hp3,post,addr1,addr2,indate,mileage,status);
			arr.add(user);
		}
		
		return arr;
	}
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch(SQLException e) {
			System.out.println("close error + " + e);
		}
	}
}
