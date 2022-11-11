<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a href="ex09_response.jsp">로그인 폼으로 돌아가기</a>
<br>
<%
	//아이디 비번 받기
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	out.println(userid + " / " + pwd + "<br>");
	
	//유효성체크
	if(userid==null||pwd==null) {
		response.sendRedirect("ex09_response.jsp");
		//브라우저의 url을 ex09_response.jsp로 바꿔서 새롭게 요청을 보내는 방식으로 이동
		return;
	}
	
	if("".equals(userid.trim())|pwd.trim().isEmpty()) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	if(userid.equalsIgnoreCase("killer")) {
		response.sendError(response.SC_FORBIDDEN);
		return;
	}
%>
<h1 style='color:blue'><%=userid %>님 어서오소</h1>