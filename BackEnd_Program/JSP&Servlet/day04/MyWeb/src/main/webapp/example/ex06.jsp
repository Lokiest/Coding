<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>
<h1>성적입력</h1>
<script type="text/javascript">
	function check(){
		//유효성 체크
		if(frm.idx.value==""){
			alert('사번을 입력하세요');
			frm.idx.focus();
			return;
		}
		frm.submit();
	}
</script>
<style>
	input{
		width:100%;
	}
	form,table{
		text-align:center;
		margin:auto;
	}
	
	td{
		padding:5px;
	}
</style>
<form action="result.jsp" method="post" name="frm"> 
<table border="1" style="width:80%">
	<tr>
		<td colspan="2">사번</td>
		<td><input type="text" name="idx"></td>
	</tr>
	<tr>
		<td rowspan="3">과목</td>
		<td>Java</td>
		<td><input type="text" name="java"></td>
	</tr>
	<tr>
		<td>Database</td>
		<td><input type="text" name="database"></td>
	</tr>
	<tr>
		<td>JSP</td>
		<td><input type="text" name="jsp"></td>
	</tr>
	<tr>
		<td colspan="3"><button onclick="check()">저장</button></td>
	</tr>
	
</table>
</form>


<jsp:include page="/foot.jsp"/> 