<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String title = request.getParameter("title");
	if(title!=null) {
		title = title.trim();
	}
	
	BookDAO dao = new BookDAO();
	List<BookDTO> arr = dao.getFindBook(title);
	request.setAttribute("arr", arr);
	
%>
<c:if test="${arr ne null}">
	<c:forEach var="book" items="${arr}">
		<li><a href="#book_data" onclick="setting('${book.title}')">${book.title}</a></li>
	</c:forEach>
</c:if>