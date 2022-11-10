<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true" %>
    <!-- isErrorPage="true" 기술해야 -->

<%
	//IE의 경우 브라우저가 자체적으로 에러를 처리하려고함 >> 에러가 발생한 것이 아니게끔 인삭하도록 코드 기술 필요
	response.setStatus(200); // 응답성공 >> 200 OK
%>

<div class="container err">
	<h1>Server Error : <%=exception.getMessage() %></h1>
	<%
		exception.printStackTrace(); //디버깅용 >> 톰캣 콘솔에 출력
	%>
	<a href="javascript:history.back()">이전 페이지</a>
	<!-- href = ""에 자바스크립트 코드를 기술하려면 "javascript" 프로토콜을 붙여야 -->
	<button onclick="history.back()">이전 페이지</button>
</div>