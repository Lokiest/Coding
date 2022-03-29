package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program_2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		String title = "TEST3";
		String content = "BOYGroup";
		String files = "IMG3";
		int id = 14;
		
		String sql = "UPDATE NOTICE"
				+ " SET"
				+ "    TITLE = ?,"
				+ "    CONTENT = ?,"
				+ "    FILES = ?"
				+ "WHERE ID = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "ID", "PASSWORD");
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql); //변수를 넣어주는 모듈
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate(); //PREPARED 사용시 EXE~ (SQL) 절대 금지
		System.out.println(result);
		
		st.close();
		con.close();
	}

}
