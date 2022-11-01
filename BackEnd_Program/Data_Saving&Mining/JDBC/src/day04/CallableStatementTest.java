package day04;

/*
create or replace procedure memo_add(pname in varchar2 default 'ewr',
pmsg in memo.msg%type)
is
begin
    insert into memo(idx, name, msg, wdate)
    values(memo_seq.nextval, pname, pmsg, sysdate);
    commit;
end;
/
*/

import java.util.*;
import common.DBUtil;
import java.sql.*;

public class CallableStatementTest {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("작성자명 : ");
		String name = sc.nextLine();
		System.out.println("메모 내용 : ");
		String msg = sc.nextLine();
		
		Connection con = DBUtil.getCon();
		//프로시저를 호출하기 위해서는 CallableStatement객체 얻어오기
		String sql = "{call MEMO_ADD(?,?)}";
		
		CallableStatement cs = con.prepareCall(sql);
		//in parameter값 setting
		cs.setString(1, name);
		cs.setString(2, msg);
		
		//실행
		cs.execute();
		System.out.println("등록 성공");
		cs.close();
		con.close();
	}

}
