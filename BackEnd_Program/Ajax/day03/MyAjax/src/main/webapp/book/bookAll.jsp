<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String title = request.getParameter("title");
	
	BookDAO dao = new BookDAO();
	List<BookDTO> arr = null;
	if(title==null) {
		arr = dao.getAllBook();
	} else {
		arr = dao.getFindBook(title);
	}

	request.setAttribute("arr", arr);
	
%>

<table class="table table-bordered table-hover">

<c:forEach var="book" items="${arr}">
	<tr>
		<td width="20%">${book.title}</td>
		<td width="20%">${book.publish}</td>
		<td width="20%">
			<fmt:formatNumber value="${book.price}" pattern="###,###"/> 원
		</td>
		<td width="20%">
			<fmt:formatDate value="${book.published}" pattern="yyyy-MM-dd"/>
		</td>
		<td width="20%">
		<a href="#book_data" onclick="goEdit('${book.isbn}')">수정</a> | 
		<a href="#book_data" onclick="goDel('${book.isbn}')">삭제</a></td>
		
	</tr>
</c:forEach>
</table>