package day05;

import java.sql.*;
import common.DBUtil;

public class CallableStatementTest3 {

	public static void main(String[] args) throws SQLException {

		Connection con = DBUtil.getCon();
		String sql = "{call memo_all(?)}";
		
		CallableStatement cs = con.prepareCall(sql);
		cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
		
//		ResultSet rs = cs.executeQuery(); [x]
		cs.execute();
		ResultSet rs = (ResultSet)cs.getObject(1);
		
		while(rs.next()) {
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			String msg = rs.getString("msg");
			Date wdate = rs.getDate("wdate");
			System.out.println(idx + "\t" + name + "\t" + msg + "\t" + wdate);
		}
		
		rs.close();
		cs.close();
		con.close();
	}

}
