<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*, java.util.*" %>

<%
	BookDAO dao = new BookDAO();
	List<BookDTO> arr = dao.getAllBook();
%>

{
	"books": [
		<% 
		if(arr!=null) {
			for(int i=0;i<arr.size();i++) {
				BookDTO book = arr.get(i);
				request.setAttribute("book", book);
		%>
			{
				"isbn":"${book.isbn}",
				"title":"${book.title}",
				"publish":"${book.publish}",
				"price":"${book.price}",
				"published":"${book.published}",
				"bimage":"${book.bimage}"
			}
		
		<%
			if(i<arr.size()-1) {
				out.println(",");
			}
			}
		}
		%>
	]
}