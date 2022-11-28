<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 메모장 수정</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<script type="text/javascript">
	function check(){
		//유효성 체크
		if(window.document.frm.name.value==""){
			alert('이름을 입력하세요');
			frm.name.focus();//입력포커스
			return;
		}
		if(!frm.msg.value){
			alert('메모 내용을 입력하세요')
			frm.msg.focus();
			return;
		}
		if(frm.msg.value.length>100){
			alert('메모 내용은 100자까지만 가능해요');
			frm.msg.select();
			return;
		}
		frm.submit();//서버에 전송		
	}
</script>
</head>
<body>


<div id="wrap" class="container py-5">

<c:if test="${memo eq null}">
	<script>
		alert('없는 글입니다');
		history.back();
	</script>
</c:if>
<c:if test="${memo ne null}">
	<form name="frm" action="memoEdit" method="post">
		<table class="table mt-3">
			<tr class="table-info">
				<th colspan="2"> <h1>::한줄 메모장 수정::</h1> </th>
			</tr>
			<tr>
				<td width="20%"><b>글번호</b></td>
				<td width="80%">
					<input type="text" name="idx"  value="${memo.idx}"   readonly placeholder="Idx"
					 class="form-control">
				</td>
			</tr>
			<tr>
				<td width="20%"><b>작성자</b></td>
				<td width="80%">
					<input type="text" name="name"  value="${memo.name}" class="form-control" 
					 placeholder="Name" style="">
				</td>
			</tr>
			<tr>
				<td width="20%"><b>메모 내용</b></td>
				<td width="80%">
					<input type="text" name="msg"  value="${memo.msg}" class="form-control"   
					placeholder="Message" style="">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<button type="button" onclick="check()" class="btn btn-primary">글 수정하기</button>		
					<!-- button에 type을 기술하지 않으면 기본이 submit버튼 -->		
					<button type="reset" class="btn btn-danger">다시 쓰기</button>	
					<button type="button" class="btn btn-success" onclick="location.href='memoList'">글 목록보기</button>			
				</td>
			</tr>
		</table>	
	</form>
</c:if>	
</div>

</body>
</html>
    