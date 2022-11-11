<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, user.model.*" %>
<%@ include file="/login/adminCheckModule.jsp" %>
    
<%-- <jsp:useBean id="user" class="user.model.UserVO" scope="page" /> --%>
<jsp:useBean id="userDao" class="user.model.UserDAO" scope="session" />
 
<jsp:include page="/top.jsp" />

<div class="container">
	<h1>회원 목록 페이지[Admin Page]</h1>
	<%
		List<UserVO> arr = userDao.listUser(); 
	
	%>
	<table border="1" style="width:90%; margin:1em auto;">
		<tr>
			<th class="m1">번호</th>
			<th class="m1">이름</th>
			<th class="m1">아이디</th>
			<th class="m1">연락처</th>
			<th class="m1">회원상태</th>
			<th class="m1">수정|삭제</th>
		</tr>
		<%
			if(arr==null||arr.size()==0) {
				%>
		<tr><td colspan="6">No Data</td></tr>
				<%
			} else {
				for(UserVO vo : arr) {
		%>
				<tr>
					<td><%=vo.getIdx() %></td>
					<td><%=vo.getName() %></td>
					<td><%=vo.getUserid() %></td>
					<td><%=vo.getAllHp() %></td>
					<td class="state<%=vo.getStatus() %>">
						<%=(vo.getStatus()>=0)?"일반회원":(vo.getStatus()==-1)?"정지회원":"탈퇴회원" %>
					</td>
					<td><a href="modify.jsp?idx=<%=vo.getIdx()%>">수정  </a><a>삭제</a></td>
				</tr>
		<%
				}
			}
		%>
	</table>
</div>

<jsp:include page="/foot.jsp" />