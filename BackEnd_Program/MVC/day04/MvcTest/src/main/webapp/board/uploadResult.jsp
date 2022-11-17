<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>    
<div class="container">
	<h1>Upload Result</h1>
	<p>
		<h2>contentType : ${ctype}</h2>
		<h2>contentLength : ${len}</h2>
		<h2>count : ${count}</h2>
	</p>
	 
	<hr color='red'>
	${content}
	<br>
	<h2>올린이 : ${name}</h2> 
	<h2>첨부파일명 : ${fname}</h2>
	<h2>첨부파일크기 : ${fsize} bytes</h2>
</div>
<jsp:include page="/foot.jsp"/>
