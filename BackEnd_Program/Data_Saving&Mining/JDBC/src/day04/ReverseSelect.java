package day04;

/*ResultSet의 커서를 자유 자재로 이동시켜보자.
 * - PreparedStatement ps=con.prepareStatement(sql)
 *  ==> rs의 커서는 next()만 가능함
 * 
 *  - rs의 커서를 자유 자재로 이동시키려면
 *   PreparedStatement ps=con.prepareStatement(sql,
 *   		ResultSet.TYPE_SCROLL_SENSITIVE,
 *   	    ResultSet.CONCUR_READ_ONLY)
 * */

import java.util.*;
import common.DBUtil;
import java.sql.*;

public class ReverseSelect {

	public static void main(String[] args) throws Exception {

		Connection con = DBUtil.getCon();
		String sql = "select empno, ename, job from emp order by empno";
		//사번 오름차순으로 가져오기
		
		PreparedStatement ps = con.prepareStatement(sql, 
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = ps.executeQuery();
		//기본적으로 rs 커서는 첫번째 행의 진전에 위치함 > beforeFirst
		//마지막행의 직후 커서 위치를 이동시키기 > afterLast
		rs.afterLast();
		while(rs.previous()) {
			int idx = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			System.out.println(idx + "\t" + ename + "\t" + job);
		}
		//rs 커서를 특정행에 위치 : absolute(n)
		rs.absolute(2);
		System.out.println(rs.getInt(1) + " / " + rs.getString(2) + " / " + rs.getString(3));
		
		rs.absolute(-1);
		System.out.println(rs.getInt(1) + " / " + rs.getString(2) + " / " + rs.getString(3));
		
		/*
		 * rs.beforeFirst() : 첫 번째 행의 직전에 위치
		 * rs.first() : 첫 번째 행에 위치
		 * rs.last() : 마지막 행
		 * rs.getRow() : 실제 커서가 위치한 곳의 행번호를 반환
		 * */
		
		rs.close();
		ps.close();
		con.close();

	}

}
