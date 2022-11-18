<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/top.jsp" />

<div class="container">
	<h1>MyPage</h1>
	<p>
	<h2>회원인증 받은 사람들만 이용 가능</h2>
	<h2>이름 : ${loginUser.name }</h2>
	<h2>연락처 : ${loginUser.getAllHp() }</h2>
	<h2>주소 : ${loginUser.allAddr }</h2>  <!-- .getAllAddr() -->
	
	</p>	
</div>

<jsp:include page="/foot.jsp" />