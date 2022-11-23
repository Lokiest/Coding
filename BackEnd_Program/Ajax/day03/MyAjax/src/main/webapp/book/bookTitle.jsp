<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*, java.util.*, net.sf.json.*" %>

<%
	String publish = request.getParameter("publish");
	System.out.println(publish);
	
	BookDAO dao = new BookDAO();
	List<BookDTO> arr = dao.getTitleList(publish);
	JSONArray jsonArr = JSONArray.fromObject(arr);
	
	
%>
<%=jsonArr.toString() %>