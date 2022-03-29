package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program_4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		int id = 14;
		
		String sql = "DELETE NOTICE WHERE ID = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "ID", "PASSWORD");
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql); //변수를 넣어주는 모듈
		st.setInt(1, id);
		
		int result = st.executeUpdate(); //PREPARED 사용시 EXE~ (SQL) 절대 금지
		System.out.println(result);
		
		st.close();
		con.close();
	}

}
