package memo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.model.MemoDAO;


@WebServlet("/MemoDelete")
public class MemoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		String idxStr = req.getParameter("idx");
		
		if(idxStr==null||idxStr.trim().equals("")) {
			res.sendRedirect("MemoList");
			return;
		}
		
		int idx = Integer.parseInt(idxStr.trim());
		MemoDAO dao = new MemoDAO();
		
		try {
			int n = dao.deleteMemo(idx);
			String str = (n>0)?"삭제 성공":"삭제 실패";
			String loc = "MemoList";
			out.println("<script>");
			out.println("alert('"+str+"')");
			out.println("location.href='"+loc+"'");
			out.println("</script>");
		} catch(SQLException e) {
			e.printStackTrace();
			out.println("error : " + e.getMessage() + "<br>");
		}
		
		out.close();
	}

}
