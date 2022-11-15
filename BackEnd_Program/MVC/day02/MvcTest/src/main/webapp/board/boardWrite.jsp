<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>    
<style>

 #boardFrm li{
 	padding: 10px 5px;
 	text-align: left;
 }
 ul li{
	list-style-type: none;
}
 #subject, #content, #filename{
 	width: 98%;
 }
 #boardFrm input{
 	padding: 5px;
 }
 div.bbs{
 	width:90%;
 	margin: auto;
 }
 .btn{
 	padding: 4px;
 	background-color: #efefef;
 	border: 1px solid silver;
 	width: 200px;
 }
</style>

<script src="https://cdn.ckeditor.com/4.20.0/standard/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script>
	$(function() {
		CKEDITOR.replace("content")
	})
	
	let board_check=function(){
		if($('#subject').val()==''){
			alert('제목을 입력하세요');
			$('#subject').focus();
			return false;
		}
		
		if(!CKEDITOR.instances.content.getData()) {
			alert('글 내용 입력');
			CKEDITOR.instances.content.focus();
			return false;
		}
		
		return true;
	}

</script>

<div class="container">
	<h1>Board 글쓰기</h1>
	<div class="bbs">
	<form name="boardF" id="boardFrm" action="boardWriteEnd.do" method="POST" onsubmit="return board_check()">
		<ul>
			<li>제목</li>
			<li>
				<input type="text" name="subject" id="subject" placeholder="Subject">
			</li>
			<li>글내용</li>
			<li>
			<textarea name="content" id="content" rows="10" cols="50" placeholder="Content"></textarea>
			</li>
			<li>첨부파일</li>
			<li>
			<input type="file" name="filename" id="filename">
			</li>
			<li>
				<button class='btn'>글 등록</button>
				<button type="reset" class='btn'>다시 쓰기</button>
			</li>
		</ul>
	</form>
	</div>
</div>
<jsp:include page="/foot.jsp"/>