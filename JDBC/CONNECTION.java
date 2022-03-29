package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program_1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		//게시글에서 필터링을 해야하는 경우
		//데이터 필터링, 정렬 등의 모든 데이터 연산은 데이터베이스에서 처리하기 (데이터 가공)
		String sql = "SELECT * FROM NOTICE WHERE HIT > 10";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "ID", "PASSWORD");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("title");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			
			
			System.out.printf(" id : %d, title : %s, writerId : %s, regDate : %s, content : %s, hit : %d\n",
					id, title, writerId, regDate, content, hit);
		}
		rs.close();
		st.close();
		con.close();
	}

}
