<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
<style>
	.time{
		color:maroon;
	}
</style>
</head>
<body>
	<h1>Hello JSP</h1>
	<h2>Hi JSP</h2>
	<hr color="red">
	<%
		//이 안에서 자바코드 자유자재로 작성 가능
		java.util.Date today = new java.util.Date();
		String str = today.toString();
		out.println("<h2 class = 'time'>" + str + "</h2>");
		//out: PrintWriter타입의 내장 객체, 브라우저와 노드 연결
	%>
</body>
</html>