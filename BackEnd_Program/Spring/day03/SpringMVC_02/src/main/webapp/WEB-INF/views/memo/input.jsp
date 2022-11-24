<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<div id="wrap" class="container py-5">
	<form name="frm" action="memo" method="post">
		<table class="table">
			<tr class="table-primary">
				<th colspan="2" class="text-center"> <h1>::한줄 메모장::</h1> </th>
			</tr>
			<tr>
				<td width="20%"><b>작성자</b></td>
				<td width="80%">
					<input type="text" name="name" placeholder="Name" class="form-control" required>
				</td>
			</tr>
			<tr>
				<td width="20%"><b>메모 내용</b></td>
				<td width="80%">
					<input type="text" name="msg" placeholder="Message" class="form-control" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<button class="btn btn-success">글 남기기</button>		
					<!-- button에 type을 기술하지 않으면 기본이 submit버튼 -->		
					<button class="btn btn-warning" type="reset">다시 쓰기</button>				
				</td>
			</tr>
		</table>	
	</form>
</div>
