<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/top.jsp" />
<script type="text/javascript" src="../js/userCheck.js"></script>

<div class="container">
	<h1>Signup</h2>
	<form name="mf" action="joinEnd.jsp" method="post">
		<table border="1" style="width:90%; margin:auto; margin-top:2em">
			<tr>
				<td width="20%" class="m1"><b>이름</b></td>
				<td width="80%" class="m2">
				<input type="text" name="name" id="name" placeholder="Name">
				<br><span class="ck">*이름은 한글만 입력 가능</span>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>아이디</b></td>
				<td width="80%" class="m2">
				<input type="text" name="userid" id="userid" placeholder="User ID">
				<button type="button">아이디 중복 체크</button>
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
				<input type="text" name="hp1" id="hp1" placeholder="HP1">-
				<input type="text" name="hp2" id="hp2" placeholder="HP2">-
				<input type="text" name="hp3" id="hp3" placeholder="HP3">
				<br><span class="ck">*숫자만 가능</span>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>우편번호</b></td>
				<td width="80%" class="m2">
				<input type="text" name="post" id="post" placeholder="Post">
				<button type="button">우편번호 찾기</button>
				</td>
			</tr>
			
			<tr>
				<td width="20%" class="m1"><b>주소</b></td>
				<td width="80%" class="m2">
				<input type="text" name="addr1" id="addr1" placeholder="Address1"><br>
				<input type="text" name="addr2" id="addr2" placeholder="Address2">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" class="m3">
					<button type="button" onclick="member_check()">회원가입</button>
					<button type="reset">다시쓰기</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="/foot.jsp"/>