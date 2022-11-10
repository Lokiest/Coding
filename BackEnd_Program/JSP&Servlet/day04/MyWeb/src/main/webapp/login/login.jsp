<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>
<style>
	.container {
		padding:8px;
	}
	#btnlogin {
		padding:4px;
		background-color: #abfabf;
		width:20%;
		border:1px solid silver;
	}
</style>
<script>
	let login_check=function() {
		if(!loginF.userid.value) {
			alert('아이디 입력');
			loginF.userid.focus();
			return false;
		}
		
		if(!loginF.pwd.value) {
			alert('비밀번호 입력');
			loginF.pwd.focus();
			return false;
		}
		
		return true;
	}
</script>
<div class="container">
	<br><br>
	<h1>Signin</h1>
	<br>
	<div class="container">
		<form name="loginF" action="loginEnd.jsp" method="post" onsubmit="return login_check()">
		<!-- onsubmit 이벤트 핸들러는 form이 전송될 때 실행, onsubmit에서 호출되는 함수의 반환값에 따라
			전송 여부를 결정, true를 반환하면 전송 false반환하면 전송x -->
			<table border="1" style="width:60%; margin:auto">
				<tr>
					<td width="20%" class="m1"><b>아이디</b></td>
					<td width="80%" class="m2">
						<input type="text" name="userid" id="userid" placeholder="User ID">
					</td>
				</tr>
				
				<tr>
					<td width="20%" class="m1"><b>비밀번호</b></td>
					<td width="80%" class="m2">
						<input type="password" name="pwd" id="pwd" placeholder="Password">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="container">
						<label for="saveId">
							<input type="checkbox" name="saveId" id="saveId">아이디 저장
						</label>
						<button id="btnlogin">로그인</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<jsp:include page="/foot.jsp"/>