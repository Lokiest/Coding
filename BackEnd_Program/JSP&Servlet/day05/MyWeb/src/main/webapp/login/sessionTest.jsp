<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp" />

<div class="container">
	<h1>session에 저장된 모든 정보를 꺼내기</h1>
	<h2 style="color:purple">JSESSIONID : <%=session.getId() %></h2>
	<%
		java.util.Enumeration<String> en = session.getAttributeNames();
		//세션의 키값들만 반환
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			Object val = session.getAttribute(key);
			%>
			<h2><%=key %> : <%=val %></h2>
			
			<%
		}
	
	%>
</div>

<jsp:include page="/foot.jsp" />