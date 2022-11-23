<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="wrap">
	<form name="frm" action="memo" method="post">
		<table border="1">
			<tr>
				<th colspan="2"> <h1>::한줄 메모장::</h1> </th>
			</tr>
			<tr>
				<td width="20%"><b>작성자</b></td>
				<td width="80%">
					<input type="text" name="name" placeholder="Name" style="" required>
				</td>
			</tr>
			<tr>
				<td width="20%"><b>메모 내용</b></td>
				<td width="80%">
					<input type="text" name="msg" placeholder="Message" style="" required>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>글 남기기</button>		
					<!-- button에 type을 기술하지 않으면 기본이 submit버튼 -->		
					<button type="reset">다시 쓰기</button>				
				</td>
			</tr>
		</table>	
	</form>
</div>
