<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<!--  memo.css-->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<div id="wrap" class="container py-5">
<table class="table table-hover">
<tr>
	<th colspan="4" class="text-center"><h2>::한줄 메모장 목록::</h2></th>
</tr>
<tr>
	<td width="10%"><b>글번호</b></td>
	<td width="60%"><b>메모내용</b></td>
	<td width="20%"><b>작성자</b></td>
	<td width="10%"><b>수정|삭제</b></td>
</tr>
<c:if test="${memoArr eq null or empty memoArr }">
	<tr>
		<td colspan="4"><b>데이터가 없습니다</b></td>
	</tr>
</c:if>
<c:if test="${memoArr ne null and not empty memoArr}">
	<c:forEach var="memo" items="${memoArr}">
		<tr>
			<td>${memo.idx}</td>
			<td>${memo.msg}
			<span class="float-right">
			[<fmt:formatDate value="${memo.wdate}" pattern="yyyy-MM-dd"/>]
			</span> 
			</td>
			<td>${memo.name}</td>
			<td>
			<a href="memoEdit?idx=${memo.idx}">수정</a>|
			
			<a href="memoDel?idx=${memo.idx}">삭제</a></td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="4">총 게시글 수: ${totalCount}</td>
		</tr>	
		
</c:if>
</table>
</div>
</body>
</html>

