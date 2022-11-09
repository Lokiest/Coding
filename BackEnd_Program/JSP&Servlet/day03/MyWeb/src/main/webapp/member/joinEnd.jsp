<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*" errorPage="/example/myerror.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	
//useBean 액션을 이용해서 UserVO객체와 USerDAO객체 생성하기
	
%>
<jsp:useBean id="user" class="user.model.UserVO" scope="page" />
<%-- UserVO user = new UserVO()와 동일 --%>

<jsp:setProperty property="*" name="user" />
<%-- id와 name이 같아야 
	user.setName(request.getParameter("name"));
	...
--%>
<%
	if(user.getUserid()==null||user.getName()==null) {
		response.sendRedirect("join.jsp");
		return;
	}
%>

<jsp:useBean id="userDao" class="user.model.UserDAO" scope="session" />
<%
	int n = userDao.insertUser(user);
	String str = (n>0)?"회원가입 완료 - 로그인 페이지로":"가입 실패";
	String loc = (n>0)?"list.jsp":"javascript:history.back()";
%>

<script>
	alert('<%=str%>');
	location.href='<%=loc%>';
</script>
