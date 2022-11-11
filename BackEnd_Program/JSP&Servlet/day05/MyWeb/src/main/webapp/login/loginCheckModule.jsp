<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*" %>

<%
	UserVO user=(UserVO)session.getAttribute("loginUser");
	if(user==null) {
		%>
		<script>
			alert('로그인해야 이용 가능');
			location.href = "<%=request.getContextPath()%>/login/login.jsp";
		</script>
		<%
		return;
	}
	
	if(user.getStatus()==-1) {
		String str = "정지회원, 활동회원으로 전환 필요";
	
	%>
	<script>
		alert('<%=str%>');
		location.href = "<%=request.getContextPath()%>/member/modify.jsp";
	</script>
	<%
		return;
	}
%>