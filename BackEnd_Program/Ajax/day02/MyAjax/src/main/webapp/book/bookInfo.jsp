<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*, java.util.*" %>

<%
	BookDAO dao = new BookDAO();

	BookDTO book = dao.getBookInfo(request.getParameter("isbn"));
	request.setAttribute("book", book);
%>

{
	"title" : "${book.title}",
	"isbn":"${book.isbn}",
	"publish":"${book.publish}",
	"published":"${book.published}",
	"price":"${book.price}",
	"bimage":"${book.bimage}"
}