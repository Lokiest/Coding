package day04;

import java.util.*;
import common.DBUtil;
import java.sql.*;

// 여러 개의 sql문을 한꺼번에 전송하는 일괄처리 방식
// 여러 개의 sql문을 작성해서 Statement의 addBatch(sql),
// executeBatch() 메서드로 일괄 처리
// 모두 성공하던지, 모두 실패하던지

public class BatchQueryTestError {

	public static void main(String[] args) throws Exception {

		Connection con = DBUtil.getCon();
		con.setAutoCommit(false); //자동 커밋 취소, 수동으로 트랜잭션 관리할 때 사용
		
		Statement st = con.createStatement();
		st.addBatch("insert into memo values(memo_seq.nextval, 'ewr', 'BatchTest1', sysdate)");
		st.addBatch("insert into memo values(memo_seq.nextval, 'ewr2', 'BatchTest2', sysdate)");
		st.addBatch("insert into memo values(memo_seq.nextval, 'ewr3', 'BatchTest3', sysdate)");
		//일부로 틀리기
		st.addBatch("insert into memo values(memo_seq.nex, 'ewr4', 'BatchTest4', sysdate)");
		st.addBatch("insert into memo values(memo_seq.nextval, 'ewr5', 'BatchTest5', sysdate)");
		boolean isCommit = false;
		try {
			int[] updateCount = st.executeBatch(); //일괄처리하여 실행
			isCommit = true;
		} catch(SQLException e) {
			isCommit = false;
			e.printStackTrace();
		}
		
		if(isCommit) {
			con.commit();
		} else {
			con.rollback();
		}
		con.setAutoCommit(true);
		
		boolean b = st.execute("select * from memo order by idx desc");
		if(b) {
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " \t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDate(4));
			}
			rs.close();
		}
		
		st.close();
		con.close();
	}

}
