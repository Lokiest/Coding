package my.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션으로 urlmappin urlpattern 등록
//이때 @WebServlet 안의 url parttern은 유니크해야함
@WebServlet("/GetTest")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		//html의 form 태그를 통해 전송된 파라미터 값은 req를 이용해서 받음
		String name = req.getParameter("name"); //html의 input name값을 파라미터명으로 ㅈ너달하면 사용자가 입력한 값을 반환
		String userid = req.getParameter("userid");
		
		out.println("<h1>GetServlet</h1>");
		out.println("<h2>GET 방식의 요청을 처리할 때는 doGet() 메소드를 오버라이드 함</h2>");
		
		out.println("<h3>이 름 : " + name + "</h3>");
		out.println("<h3>아이디 : " + userid + "</h3>");
		
		out.close();
	}

}
