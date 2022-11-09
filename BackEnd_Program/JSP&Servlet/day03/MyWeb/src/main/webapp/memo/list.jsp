<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, memo.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<!-- memo.css 참조 -->
<link rel="stylesheet" type="text/css" href="css/memo.css">
</head>
<body>
<!-- MemoListServlet에서 저장한 memoArr을 꺼내기 -->
<div id="wrap">
<table border="1">
<tr>
	<th colspan="4"><h2>::한줄 메모장 목록::</h2></th>
</tr>
<tr>
	<td width="10%"><b>글 번호</b></td>
	<td width="60%"><b>메모 내용</b></td>
	<td width="20%"><b>작성자</b></td>
	<td width="10%"><b>수정 및 삭제</b></td>
</tr>
<%
	//내장 객체 : request >> HttpServletRequest타입
	Object obj = request.getAttribute("memoArr");
	//out.println(obj);
	List<MemoVO> memoArr = (List<MemoVO>)obj;
	if(memoArr!=null) {
		for(MemoVO vo:memoArr) {
%>
		<tr>
			<td><%=vo.getIdx() %></td>
			<td><%=vo.getMsg() %> <span class="mdate">[<%=vo.getWdate()%>]</span></td>
			<td><%=vo.getName() %></td>
			<td><a href="MemoEditForm?idx=<%=vo.getIdx()%>">수정</a>|
			<a href="MemoDelete?idx=<%=vo.getIdx()%>">삭제</a></td>
		</tr>
<%			
		}
	} else {
		out.println("<b>잘못 들어온 경로</b>");
	}
%>
</table>
</div>
</body>
</html>