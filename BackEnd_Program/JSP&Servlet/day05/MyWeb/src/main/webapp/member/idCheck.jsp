<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<script src="../js/userCheck.js"></script>

<%
	request.setCharacterEncoding("UTF-8");
	String method = request.getMethod();
	/* out.println("method : " + method + "<br>"); */
	
	//get방식일때는 입력 폼을 보여주고
	//post방식일때는 아이디 사용 가능 여부 결과 보여주기
	if(method.equalsIgnoreCase("get")) {
%>

<div class="container m2" style="margin-top:2em;">
	<form name="idf" action="idCheck.jsp" method="post">
		<label for="userid">아이디</label>
		<input type="text" name="userid" id="userid" placeholder="User ID" autofocus="autofocus">
		<button type="button" onclick="id_check()">확 인</button>
	</form>
</div>

<%
	} else {
		//post방식이라면 >> userid값 받아서 사용 가능 여부를 알려줌
		/* out.println("결과 나올 예정"); */
		String userid = request.getParameter("userid");
		%>
		<jsp:useBean id="userDao" class="user.model.UserDAO" scope="session" />
		<%
		boolean isUse = userDao.idCheck(userid);
		if(isUse) {
			%>
			<div class="container m2">
				<h3>ID [<span style='color:gray;font-weight:bold;'><%=userid %></span>] 사용 가능</h3>
				<br>
				<button onclick="setId('<%=userid %>')">닫 기</button>
			</div>
			
			<%
		} else {
			%>
			<div class="container m2">
				<h3>ID [<span style='color:gray;font-weight:bold;'><%=userid %></span>] 이미 사용 중</h3>
			</div>
			
			<div class="container m2" style="margin-top:2em;">
				<form name="idf" action="idCheck.jsp" method="post">
					<label for="userid">아이디</label>
					<input type="text" name="userid" id="userid" placeholder="User ID" autofocus="autofocus">
					<button type="button" onclick="id_check()">확 인</button>
				</form>
			</div>
			<%
		}
		
	}
%>