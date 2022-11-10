<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, java.text.*"%>
<!-- page directive (page지시어) -->
<!-- 1.html 주석 -->
<h1>처음 해보는 JSP</h1>
<% 
	//scriptlet 태그 : 이 안에서는 자바 코드를 기술
	/*2. 자바 주석*/
	// 자바주석
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String str = sdf.format(today);
	//out : JspWriter타입
	out.println("<h2>"+str+"</h2>");
%>

<%--
	JSP 주석
	<%= %>와 같은 친구를 설명할 때 사용 : 출력식 expression >> out.println과 동일
--%>
<h2 style="color:aqua"><%=str %></h2>
