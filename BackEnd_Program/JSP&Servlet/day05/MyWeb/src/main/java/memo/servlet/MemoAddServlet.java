package memo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.model.*;


@WebServlet("/MemoAdd")
public class MemoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		//1. 사용자가 입력한 값 받아오기
		String name = req.getParameter("name");
		String msg = req.getParameter("msg");
		
		out.println(name + " / " + msg);
		//2. 유효성 체크 (백엔드 쪽에서도 체크)
		if(name==null||msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			res.sendRedirect("memo/input.html");
			//sendRedirect() : redirect 방식으로 페이지를 이동시킴
			//                 >> 브라우저의 url을 지정한 페이지로 변경한 뒤 서버에 새로운 요청을 발생시켜 이동함
			return;
		}
		//3. 1번에서 받은 값을 MemoVO 객체 생성해서 담아주기
		MemoVO vo = new MemoVO(0,name,msg,null);
		//4. MemoDAO 객체 생성해서 insertMemo() 호출하기
		MemoDAO dao = new MemoDAO();
		try {
			int n = dao.insertMemo(vo);
			String str = (n>0)?"(글 등록 성공)":"(글 등록 실패)";
			String loc = (n>0)?"MemoList":"memo/input.html";
			
			out.println("<script>");
			out.println("alert('"+str+"')");
			out.println("location.href='"+loc+"'");
			out.println("</script>");
//			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
			out.println("error" + e.getMessage() + "<br>");
		}
		//5. 실행결과 메세지 처리
		
//		out.println("MemoAddServlet");
		out.close();
	}

}
