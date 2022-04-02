package com.DoRyeon.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DoRyeon.app.entity.Notice;

public class NoticeService {
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "system";
	private String pwd = "1001";
	private String driv = "oracle.jdbc.driver.OracleDriver";
	
	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		
		int start = 1 + (page-1)*6; //1, 7, 13...
		int end = 6 * page; // 6, 12, 18...
		
		String sql = "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
		
		Class.forName(driv);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + query + "%");
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		
		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("title");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			String files = rs.getString("FILES");
			
			Notice notice = new Notice(
								id,
								title,
								writerId,
								regDate,
								content,
								hit,
								files
							); //생성자를 통해서 세팅할 경우 주의할 점 : 순서가 엉망되지않도록 주의
			list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String sql = "INSERT INTO NOTICE ("
				+ "    TITLE,"
				+ "    WRITER_ID,"
				+ "    CONTENT,"
				+ "    FILES"
				+ ") VALUES (?,?,?,?)";
		
		Class.forName(driv);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String sql = "UPDATE NOTICE"
				+ " SET"
				+ "    TITLE = ?,"
				+ "    CONTENT = ?,"
				+ "    FILES = ?"
				+ "WHERE ID = ?";
		
		Class.forName(driv);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE NOTICE WHERE ID = ?";
		
		Class.forName(driv);
		Connection con = DriverManager.getConnection(url, "system", "1001");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
	//scalar값을 얻어오는 함수 (단일값)
	public int getCount() throws SQLException, ClassNotFoundException {
		int count = 0;
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";
		
		Class.forName(driv);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Notice> list = new ArrayList<Notice>();

		if(rs.next())
			count = rs.getInt("COUNT");
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}
}
