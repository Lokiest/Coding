<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*" %>

<%
	String query = request.getParameter("query");
	if(query==null) {
		query="Ajax";
	}

	String display="10";
	String start="1";
	String sort="sim";
	
	NaverBookProxy proxy = new NaverBookProxy();
	
	String jsonData = proxy.getData(query, display, start, sort);

%>

<%=jsonData %>