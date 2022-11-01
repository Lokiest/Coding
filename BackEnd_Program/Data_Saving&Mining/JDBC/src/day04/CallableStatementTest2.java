package day04;

/*
create or replace procedure memo_edit(
pidx in memo.idx%type,
pname in memo.name%type,
pmsg in memo.msg%type
)
is
begin
    update memo set name=pname, msg=pmsg where idx=pidx;
end;
/
*/

import java.util.*;
import common.DBUtil;
import java.sql.*;
import day02.MemoVO;

public class CallableStatementTest2 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("글 번호 입력 : ");
		int idx = sc.nextInt();
		sc.skip("\r\n");
		System.out.println("사용자명 : ");
		String name = sc.nextLine();
		System.out.println("메세지 : ");
		String msg = sc.nextLine();
		System.out.println(idx + " / " + name + " / " + msg);
		
		MemoVO vo = new MemoVO(idx, name, msg, null);
		Connection con = DBUtil.getCon();
		
		String sql = "{call memo_edit(?,?,?)}";
		
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, vo.getIdx());
		cs.setString(2, vo.getName());
		cs.setString(3, vo.getMsg());
		cs.execute();
		System.out.println("메모글 수정 완료");
		
		cs.close();
		con.close();
		
	}

}
