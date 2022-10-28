package day01;

import java.sql.*;
import javax.swing.*;

public class MemoInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String name = JOptionPane.showInputDialog("작성자 입력 : ");
		String msg = JOptionPane.showInputDialog("메세지 입력 : ");
		if(name==null) return;
		
		//memo테이블에 insert문 작성해서 메모글 insert하는 프로그램
		// 1. 홍길동 첫번째 작성한 글입니다.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott", pwd = "tiger";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
//		String sql = "insert into memo(idx,name,msg,wdate) values(memo_seq."
//				+ "nextval,'111','네번째 작성글', sysdate)";
		String sql = "insert into memo(idx,name,msg,wdate) values(memo_seq.nextval,'";
			sql += name;
			sql+="','";
			sql+=msg;
			sql+="',sysdate)";
			System.out.println(sql);
		
		Statement stmt = con.createStatement();
//		boolean b = stmt.execute(sql); //select문 경우에만 true 반환
		int b = stmt.executeUpdate(sql);
		//sql문에 의해 영향받은 레코드 개수를 반환
		System.out.println("b : " + b + "개 레코드 삽입");
		
		stmt.close();
		con.close();

	}

}
