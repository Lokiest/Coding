<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"	import="memo.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 메모장 수정</title>

<link rel="stylesheet" type="text/css" href="css/memo.css">

<script type="text/javascript">
	function check() {
		//유효성 체크
		if(window.document.frm.name.value=="") {
			alert('이름 입력');
			frm.name.focus();
			return;
		}
		if(!frm.msg.value) {
			alert('메모 내용 입력');
			frm.msg.focus();
			return;
		}
		if(frm.msg.value.length>100) {
			alert('입력 초과');
			frm.msg.select();
			return;
		}
		frm.submit(); //서버에 전송
	}
</script>

</head>
<body>
<div id="wrap">
<%
	MemoVO vo = (MemoVO)request.getAttribute("memo");
	//out.println("vo : " + vo);
	if(vo==null) {
		%>
		<script>
			alert('존재하지 않는 글');
			history.back();
		</script>
		<%
		return;
	}
%>
	<form name="frm" action="MemoEdit" method="get">
		<table border="1">
			<tr>
				<th colspan="2"><h1> :: 한줄 메모장 수정:: </h1></th>
			</tr>
			<tr>
				<td width="20%"><b>글번호</b></td>
				<td width="80%">
					<input type="text" name="idx" value="<%=vo.getIdx()%>" readonly placeholder="Name" 
					style="width:40% background-color:silver;">
				</td>
			</tr>
			<tr>
				<td width="20%"><b>작성자</b></td>
				<td width="80%">
					<input type="text" name="name" value="<%=vo.getName()%>" placeholder="Message" style="">
				</td>
			</tr>
			<tr>
				<td width="20%"><b>메모 내용</b></td>
				<td width="80%">
					<input type="text" name="msg" value="<%=vo.getMsg()%>" placeholder="Message" style="">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="check()">글 수정하기</button>
					<!-- button에 type 기술하지 않으면 기본이 submit버튼 -->
					<button type="reset">다시 쓰기</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>