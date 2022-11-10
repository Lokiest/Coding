package memo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.model.MemoDAO;
import memo.model.MemoVO;

@WebServlet("/MemoEdit")
public class MemoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		//0.post
//		req.setCharacterEncoding("UTF-8");
		
//		MemoEditServlet
//		=> url mapping : MemoEdit
//		1. 사용자가 입력한 값 받아오기(idx, name, msg)
		String idxStr = req.getParameter("idx");
		String name = req.getParameter("name");
		String msg = req.getParameter("msg");
		
//		2. idx, name 의 유효성 체크 => MemoList로 redirect이동
		if(idxStr==null||name==null||idxStr.trim().isEmpty()||name.trim().isEmpty()) {
			res.sendRedirect("MemoList");
			return;
		};
		int idx = Integer.parseInt(idxStr.trim());
		
//		3. 1번에서 받은 값을 MemoVO에 담아준다.
		MemoVO vo = new MemoVO(idx,name,msg,null);
		
//		4. MemoDAO 의 updateMemo(vo)
		MemoDAO dao = new MemoDAO();
		try {
			int n = dao.updateMemo(vo);
//
//		5. 그 결과 메시지,
//		 이동경로로 이동 성공=> MemoList로 이동
//			          실패 => MemoEditForm?idx=글번호
			String str = (n>0)?"수정 성공":"수정 실패";
			String loc = (n>0)?"MemoList":"MemoEditFrom";
			out.println("<script>");
			out.println("alert('"+str+"')");
			out.println("location.href='"+loc+"'");
			out.println("</script>");
		} catch(Exception e) {
			e.printStackTrace();
			out.println("error : " + e.getMessage() + "<br>");
		}
		out.close();
		
	}

}
