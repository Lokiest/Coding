package com.multicamp;

import java.sql.*;
import java.util.*;
//data access object : 모델에 속하며 영속성 계층이라고 불림

public class MemoDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int insertMemo(MemoVO memo) throws SQLException {
		try {
			con = DBUtil.getCon();
			return 0;
		} finally {
			close();
		}
	}
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			
		}
		
	}
}
