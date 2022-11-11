<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" info="에러 처리 방법 알아보는 page" buffer="4kb" %>

<%@ page errorPage="myerror.jsp" %>
<%-- 이 페이지에서 에러가 발생하면 myerror.jsp페이지에서 해당 에러를 
처리해서 보여주겠다는 의미. 그러면 myerror.jsp페이지에서는 반드시
isErrorPage속성값을 true로 주어야 한다. 그래야 exception내장객체를
사용할 수 있다. 
--%>
<!-- ex10_error.jsp -->

<h1>JSP에서 발생된 에러를 처리하기</h1>
<h2><%=this.getServletInfo() %></h2>

<%
	Random ran = new Random();
	int num = ran.nextInt(100) + 10;
	//ran.nextInt(범위) + 시작수
	int a= 0;
%>
<h2 style='color:purple'>랜덤한 정수 : <%=num %></h2>

<%
	int b = num/a; //ArithmeticException
	out.println("b" + b);
%>