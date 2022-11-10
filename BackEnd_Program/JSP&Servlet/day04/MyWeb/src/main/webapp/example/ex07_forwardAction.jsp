<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>ex07_forwardAction page</h1>
<h2>forwardAction을 통해 이동할 예정</h2>
<h3>서버 내부에서 페이지 이동이 일어남</h3>
<h3>브라우저의 url에는 이전 페이지 url이 나타남</h3>
<hr color='red'>

<jsp:forward page="ex01.jsp">
	<jsp:param value="7" name="page"/>
</jsp:forward>