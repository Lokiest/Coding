<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*" %>
    
<jsp:useBean id="bookDto" class="ajax.book.BookDTO" scope="page" />
<jsp:setProperty property="*" name="bookDto" />

 <%
 	BookDAO dao = new BookDAO();
 	int n = dao.updateBook(bookDto);
 	
 %>
{
	"result":<%=n %>
}