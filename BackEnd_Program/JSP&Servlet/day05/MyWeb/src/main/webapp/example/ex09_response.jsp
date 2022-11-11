<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ex09_response.jsp -->

<div style="width:60%; margin:auto">
<h1>response객체의 주요 메서드 - HttpServletResponse Type</h1>
	<form name="f" action="ex09_responseResult.jsp" method="post">
		<p>
			아이디 : <input type="text" name="userid">	
		</p>
		
		<p>
			비밀번호 : <input type="password" name="pwd">	
		</p>
		<button>Login</button>
	</form>
</div>