<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*" %>

<jsp:include page="/top.jsp" />
<script type="text/javascript" src="../js/userCheck.js"></script>

<%
	String idxStr = request.getParameter("idx");
	UserVO user = null;
	
	if(idxStr==null||idxStr.trim().isEmpty()) {
		user=(UserVO)session.getAttribute("loginUser");
		if(user==null) {
			response.sendRedirect("../login/login.jsp");
			return;
		}
		idxStr = user.getIdx() + "";
	}
	//회원번호로 회원정보 가져오기
	int idx = Integer.parseInt(idxStr.trim());
%>

<jsp:useBean id="userDao" class="user.model.UserDAO" scope="session" />

<%
	//DB에서 회원번호로 회원정보 가져오기
	user = userDao.selectUserByIdx(idx);
%>

<style>
	#ra1, #ra2, #ra3 #ra4 {
		padding:3px;
		width:40px;
		border:1px solid silver;
	}
</style>

<div class="container">
	<h1>회원정보 수정</h1>
	<form name="mf" action="modifyEnd.jsp" method="post">
		<!--                        hidden field                            -->
		<input type="hidden" name="idx" value="<%=user.getIdx()%>">
		<!--   -----------------------------------------------------------  -->
		<table border="1" style="width:90%; margin:auto; margin-top:2em">
			<tr>
				<td width="20%" class="m1"><b>이름</b></td>
				<td width="80%" class="m2">
				<input type="text" name="name" value="<%=user.getName()%>" id="name" placeholder="Name">
				<br><span class="ck">*이름은 한글만 입력 가능</span>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>아이디</b></td>
				<td width="80%" class="m2">
				<input type="text" name="userid" value="<%=user.getUserid()%>" id="userid" readonly placeholder="User ID">
				<button type="button" onclick="open_idcheck()">아이디 중복 체크</button>
				<br><span class="ck">*아이디는 영문 + 숫자 조합으로</span>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>비밀번호</b></td>
				<td width="80%" class="m2">
				<input type="password" name="pwd" id="pwd" placeholder="Password">
				<br><span class="ck">*비밀번호는 영문 + 숫자 + 특문 조합으로</span>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>비밀번호 확인</b></td>
				<td width="80%" class="m2">
				<input type="password" name="pwd2" id="pwd2" placeholder="RePassword">
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>연락처</b></td>
				<td width="80%" class="m2">
				<input type="text" name="hp1" value="<%=user.getHp1() %>" id="hp1" placeholder="HP1">-
				<input type="text" name="hp2" value="<%=user.getHp2() %>"id="hp2" placeholder="HP2">-
				<input type="text" name="hp3" value="<%=user.getHp3() %>"id="hp3" placeholder="HP3">
				<br><span class="ck">*숫자만 가능</span>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>우편번호</b></td>
				<td width="80%" class="m2">
				<input type="text" name="post" value="<%=user.getPost() %>" id="post" placeholder="Post">
				<button type="button">우편번호 찾기</button>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>주소</b></td>
				<td width="80%" class="m2">
				<input type="text" name="addr1" value="<%=user.getAddr1() %>" id="addr1" placeholder="Address1"><br>
				<input type="text" name="addr2" value="<%=user.getAddr2() %>" id="addr2" placeholder="Address2">
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>마일리지</b></td>
				<td width="80%" class="m2">
				<b><%=user.getMileage() %> 점</b>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>회원상태</b></td>
				<td width="80%" class="m2">
				<b class="state<%=user.getStatus()%>"><%=user.getStatusStr() %></b>
				
				<input type="radio" name="status" value="0" <%=(user.getStatus()==0)?"checked":"" %> id="ra1">일반회원
				<input type="radio" name="status" value="-1" <%=(user.getStatus()==-1)?"checked":"" %> id="ra2">정지회원
				<input type="radio" name="status" value="-2" <%=(user.getStatus()==-2)?"checked":"" %> id="ra3">탈퇴회원
				<input type="radio" name="status" value="9" <%=(user.getStatus()==9)?"checked":"" %> id="ra4">관리자
				</td>
			</tr>
			
			<tr>
				<td colspan="2" class="m3">
					<button type="button" onclick="member_check()">정보수정</button>
					<button type="reset">다시쓰기</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="/foot.jsp"/>