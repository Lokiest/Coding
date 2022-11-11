<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*" %>
<!-- 로그인 체크모듈 포함 -->    
<%@ include file="/login/loginCheckModule.jsp" %>

<jsp:include page="/top.jsp" />

<%
	int idx = user.getIdx();
	UserDAO userDao = new UserDAO();
	user = userDao.selectUserByIdx(idx);
%>

<div class="container">
	<h1><%=user.getName() %>님 정보</h1>
	<p>회원 인증 페이지 - 로그인해야 들어올 수 있는 페이지</p>
	<ul style="list-style-type: none">
		<li>아이디 : <b><%=user.getUserid() %></b></li>
		<li>연락처 : <b><%=user.getAllHp() %></b></li>
		<li>마일리지 : <b><%=user.getMileage() %></b></li>
		<li>회원상태 : <b><%=user.getStatusStr() %></b></li>
		<li>주소 : <b><%=user.getAllAddr() %></b></li>
	</ul>
	<button onclick="location.href='../member/modify.jsp'">회원정보 수정 | 탈퇴</button>
</div>

<jsp:include page="/foot.jsp" />