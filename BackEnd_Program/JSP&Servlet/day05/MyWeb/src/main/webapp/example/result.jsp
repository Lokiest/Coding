<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>
<%
	request.setCharacterEncoding("UTF-8");
	String idxstr=request.getParameter("idx");
	if(idxstr==null||idxstr.trim().isEmpty()){
		response.sendRedirect("ex06.jsp");
		return;
	}
	int idx=Integer.parseInt(idxstr);
	String javastr=request.getParameter("java");
	String databasestr=request.getParameter("database");
	String jspstr=request.getParameter("jsp");
	int java=0,database=0,jsp=0;
	if(javastr!=null&&!javastr.trim().isEmpty()){
		java=Integer.parseInt(javastr);
	}
	if(databasestr!=null&&!databasestr.trim().isEmpty()){
		database=Integer.parseInt(javastr);
	}
	
	if(jspstr!=null&&!jspstr.trim().isEmpty()){
		jsp=Integer.parseInt(javastr);
	}
	
	float avg=(java+database+jsp)/(float)3;
	String rs=String.format("%.2f",avg);
	
%>
<style>
	input{
		width:100%;
	}
	table{
		text-align:center;
		margin:auto;
	}
	td{
		padding:5px;
	}
</style>

<table border="1" style="width:80%">
	<tr>
		<td colspan="2">사번</td>
		<td><%=idx %></td>
	</tr>
	<tr>
		<td rowspan="3">과목</td>
		<td>Java</td>
		<td><%=java %></td>
	</tr>
	<tr>
		<td>Database</td>
		<td><%=database %></td>
	</tr>
	<tr>
		<td>JSP</td>
		<td><%=jsp %></td>
	</tr>
		<tr>
		<td colspan="2">평균</td>
		<td><%=rs %></td>
	</tr>
	<tr>
		<td colspan="3"><button  onclick="location.href='ex06.jsp'">입력화면</button></td>
	</tr>
	
</table>


<jsp:include page="/foot.jsp"/> 