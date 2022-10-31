package day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class PreparedStatement2 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 사번 입력 : ");
		int no = sc.nextInt();
		System.out.println("수정할 업무 입력 : ");
		String job = sc.next();
		System.out.println("수정할 부서번호 입력 : ");
		int dno = sc.nextInt();
		System.out.println("수정할 급여 입력 : ");
		int sal = sc.nextInt();
		
		//emp table 수정하는 문자 만들기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott", pwd = "tiger";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		String sql = "update emp set job=?, deptno=?, sal=? where empno=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, job);
		ps.setInt(2, dno);
		ps.setInt(3, sal);
		ps.setInt(4, no);
		
		int n = ps.executeUpdate();
		System.out.println(n + " 개의 레코드 수정");
		
		ps.close();
		con.close();

	}

}
