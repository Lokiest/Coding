<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, ajax.book.*, net.sf.json.*" %>

<%
	BookDAO dao = new BookDAO();
	List<BookDTO> arr = dao.getAllBook();
	
	JSONArray jsonArr = JSONArray.fromObject(arr);
	
%>

<%=jsonArr.toString()%>