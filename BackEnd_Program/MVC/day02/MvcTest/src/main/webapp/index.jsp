<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>    
<div class="container">
	<h1>Index</h1>
	<p>
	<%=request.getAttribute("msg") %>	<br>
	<a href="./test.do">test</a>
	</p>
</div>
<jsp:include page="/foot.jsp"/>