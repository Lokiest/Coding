package memo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//data access object : 모델에 속하며 영속성 계층이라고 불림
import java.util.ArrayList;
import java.util.List;

import common.util.DBUtil;

public class MemoDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int insertMemo(MemoVO memo) throws SQLException {
		try {
			con = DBUtil.getCon();
			StringBuilder buf = new StringBuilder("insert into memo(idx,name,msg,wdate) ")
					.append(" values(memo_seq.nextval, ?, ?, sysdate)");
			String sql = buf.toString();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, memo.getName());
			ps.setString(2, memo.getMsg());
			int n = ps.executeUpdate();
			return n;
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

	public List<MemoVO> selectMemoAll() throws SQLException {
		try {
			con = DBUtil.getCon();
			StringBuilder buf = new StringBuilder("select idx, rpad(name,10,' ') name, rpad(msg,100,' ') msg, ")
					.append(" wdate from memo order by idx desc");
			String sql = buf.toString();
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<MemoVO> arr = makeList(rs);
			return arr;
		} finally {
			close();
		}
	}

	private List<MemoVO> makeList(ResultSet rs) throws SQLException {
		List<MemoVO> arr= new ArrayList<>();
		while(rs.next()) {
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			String msg = rs.getString("msg");
			java.sql.Date wdate = rs.getDate("wdate");
			MemoVO vo = new MemoVO(idx,name,msg,wdate);
			
			arr.add(vo);
		}
		return arr;
	}

	public int deleteMemo(int idx) throws SQLException {
		try {
			con = DBUtil.getCon();
			String sql = "delete from memo where idx=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idx);
			return ps.executeUpdate();
		} finally {
			close();
		}
	}

	public MemoVO selectMemo(int idx) throws SQLException {
		try {
			con = DBUtil.getCon();
			String sql = "select idx,name,msg,wdate from memo where idx=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idx);
			rs=ps.executeQuery();
			List<MemoVO> arr = makeList(rs);
			if(arr!=null && arr.size()==1) {
				return arr.get(0);
			}
			return null;
		} finally {
			close();
		}
		
	}
	
	public int updateMemo(MemoVO vo) throws SQLException {
		try {
			con = DBUtil.getCon();
			String sql = "update memo set name=?, msg=? where idx=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getMsg());
			ps.setInt(3, vo.getIdx());
			return ps.executeUpdate();
		} finally {
			close();
		}
	}

	public List<MemoVO> findMemo(int type, String keyword) throws SQLException {
		try {
			con = DBUtil.getCon();
			String colName = (type==0)?"name":"msg";
			String sql = "select idx,name,msg,wdate from memo where " + colName + " like ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,"%" + keyword + "%");
			
			rs = ps.executeQuery();
			List<MemoVO> vo = makeList(rs);
			return vo;
		} finally {
			close();
		}
	}

}
