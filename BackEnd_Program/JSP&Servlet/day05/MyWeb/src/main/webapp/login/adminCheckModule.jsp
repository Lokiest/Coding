<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 관리자 여부를 체크하는 모듈(관리자 status:9) 
		1. 로그인이 되어있어야하고 >> loginCheckModule
		2. 정지회원은 아니어야하고 >> loginCheckModule
		3. status 값은 9
-->

<%@ include file="/login/loginCheckModule.jsp" %>
<%
	if(user.getStatus()!=9) {
		%>
		<script>
			alert('관리자만 접근 가능');
			history.back();
		</script>
		<%
		return;
	}
%>