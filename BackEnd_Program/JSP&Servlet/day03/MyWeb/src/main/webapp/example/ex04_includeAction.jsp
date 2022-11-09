<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- includeAction.jsp -->
<h1>include 액션을 이용해 ex03.jsp페이지를 포함시키기</h1>
<h2>include액션은 소스를 포함시키는 방식이 아니라, 실행결과를 포함시키는 방식이다.</h2>
<h3>JSP흐름을 ex03.jsp로 이동시켜 그 실행 결과물을 현재 위치에 포함시킨다</h3>
<hr color='blue'>

<jsp:include page="ex03.jsp"/>
<!-- includeAction -->
<%--
	RequestDispatcher disp = request.getRequestDispatcher("ex03.jsp");
	disp.include(request, response); 와 jsp include 액션은 동일한 코드
--%>