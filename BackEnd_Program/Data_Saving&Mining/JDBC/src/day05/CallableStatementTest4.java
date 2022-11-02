package day05;

import java.sql.*;

import javax.swing.JOptionPane;

import common.DBUtil;

/*
create or replace procedure emp_forjava(
    pdno in emp.deptno%type,
    mycr out sys_refcursor)
is
begin
    OPEN mycr for
    select ename,job,hiredate,dname,loc from
    (select * from emp where emp.deptno=pdno) A join dept D
    on A.deptno = D.deptno;
end;
/
*/

public class CallableStatementTest4 {

	public static void main(String[] args) throws Exception {
		String dno = JOptionPane.showInputDialog("검색할 부서번호 : ");
		if(dno==null) return;

		Connection con = DBUtil.getCon();
		//부서번호를 인파라미터로 전달하면 해당 부서에 있는 사원정보(사원명 업무 입사일)와 부서정보를
		//가져오는 프로시저를 작성하고 이것을 자바에서 호출해서 결과 데이터 출력
		String sql = "{call emp_forjava(?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setString(1, dno);
		cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
		cs.execute();
		
		ResultSet rs = (ResultSet)cs.getObject(2);
		System.out.println(dno + "번 부서 사원 목록");
		while(rs.next()) {
			String ename = rs.getString(1);
			String job = rs.getString(2);
			Date hiredate = rs.getDate(3);
			String dname = rs.getString(4);
			String loc = rs.getString(5);
			System.out.println(ename + "\t" + job + "\t" + hiredate + "\t" + dname + "\t" + loc);
		}
		
		rs.close();
		cs.close();
		con.close();

	}

}
