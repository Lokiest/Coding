<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*" %>

<%
	String query = request.getParameter("query");
	String display = request.getParameter("display");
	String start = request.getParameter("start");
	if(query==null) {
		query = "Ajax";
	}
	if(display==null) {
		query = "10";
	}
	if(start==null) {
		query = "1";
	}
	String sort = "sim";
	
	NaverBookProxy proxy = new NaverBookProxy();
	String jsonData = proxy.getData(query, display, start, sort);
%>

<%=jsonData%>