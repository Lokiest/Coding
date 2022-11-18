<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp" />
<script type="text/javascript" src="./js/userCheck.js"></script>

<div class="container">
	<h1>Signup</h1>
	<form name="mf" action="joinEnd.do" method="post">
		<!-- 날짜: <input type="text" name="birth"><br>
		*날짜 형식에 맞게 입력하세요[yyyy-mm-dd or yyyy/mm/dd] 
		이메일: <input type="text" name="email"><br>
		*이메일 형식에 맞게 입력하세요[aaa@naver.com] 이메일은 알파벳문자,숫자,하이픈(-)@naver.com형식
		-->
		<table border="1" style="width:90%;margin:auto;margin-top:2em">
			<tr>
				<td width="20%" class="m1"><b>이름</b></td>
				<td width="80%" class="m2">
				<input type="text" name="name" id="name" placeholder="Name">
				<br><span class='ck'>*이름은 한글만 가능해요</span>
				</td>
			</tr>
			<tr>
				<td width="20%" class="m1"><b>아이디</b></td>
				<td width="80%" class="m2">
				<input type="text" name="userid" id="userid" placeholder="User ID" readonly>
				<button type="button" onclick="open_idcheck()">아이디 중복 체크</button>
				<br><span class='ck'>*아이디는 영문자, 숫자, _, !만 사용 가능해요</span>
				</td>
			</tr>
			<tr>
				<td width="20%" class="m1"><b>비밀번호</b></td>
				<td width="80%" class="m2">
				<input type="password" name="pwd" id="pwd" placeholder="Password">
				<br><span class='ck'>*비밀번호는 문자,숫자,!,. 포함해서 4~8자리 이내</span>
				</td>
			</tr>
			<tr>
				<td width="20%" class="m1"><b>비밀번호 확인</b></td>
				<td width="80%" class="m2">
				<input type="password" name="pwd2" id="pwd2" placeholder="Re Password">
				</td>
			</tr>
			<tr>
				<td width="20%" class="m1"><b>연락처</b></td>
				<td width="80%" class="m2">
				<input type="text" name="hp1" id="hp1" placeholder="HP1">-
				<input type="text" name="hp2" id="hp2" placeholder="HP2">-
				<input type="text" name="hp3" id="hp3" placeholder="HP3">
				<br><span class='ck'>*앞자리(010|011)중에 하나-(숫자3~4자리)-(숫자4자리) 가능해요</span>
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
<jsp:include page="/foot.jsp" />
