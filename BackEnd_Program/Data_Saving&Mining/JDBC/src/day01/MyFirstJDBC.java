package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJDBC {

	public static void main(String[] args) {
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			//프로토콜:dbms유형:driver타입:host:port:전역데이터베이스이름
			
			String user = "scott", pwd = "tiger";
			
			//2. db 연결
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB Connected");
			
			//3. 쿼리문 작성
			String sql = "CREATE TABLE memo(";
					sql+= "idx number(4) primary key, "; //글번호
					sql+= "name varchar2(30) not null, "; //작성자
					sql+= "msg varchar2(100), ";
					sql+= "wdate date default sysdate)";
					
			//4. statement객체 얻기 >> Connection의 createStatement() 이용
			Statement stmt = con.createStatement();
			
			//5. statement의 execute 메서드를 이용해서 쿼리문 실행
			//boolean execute() : 모든 sql문 실행시킴
			//int executeUpdate() : insert/ delete / update 문 실행
			//ResultSet executeQuery : select문 실행
			boolean b = stmt.execute(sql);
			System.out.println("b : " + b);
			
			//db관련 자원 반납
			stmt.close();
			con.close();

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
