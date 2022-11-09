<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [1] for루프 이용해서 Hello JSP 5번 출력하기 --%>
<%	
	for(int i=0;i<5;i++) {
%>	
	<h2>Hello JSP <%=i %></h2>
<%
	}
%>

<%-- [2] while루프 이용해서 구구단 8단 출력하기 --%>
<%
	int dan = 8;
	int i = 1;
	while(i<10) {
		%>
		<h3><%=dan %>x <%=i%>= <%=dan*i %></h3>
		<%
		i++;
	}
%>
<hr color='red'>
<%-- [3]구구단 전체를 table형태로 출력하기 --%>
<table border="1" style="width:90%; margin:auto">
	<tr>
	<%
		for(dan=2;dan<10;dan++) {
	%>
		<th bgcolor="efefef"><%=dan%>단</th>
	
	<%	} 
	
	%>
	</tr>
	<%for(i=1;i<10;i++) {%>
	<tr>
		<%for(int k=2;k<10;k++) { %>
		<td style="pdaaing-left:10px">
			<%=k %> x <%=i %> = <%=k*i%>
		</td>
		<%} %>
	</tr>
	<%} %>
</table>



