<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red">
	<%=request.getAttribute("msg") %>
</h1>
<p style="color:blue">
	${requestScope.msg} == ${msg}
</p>
</body>
</html>