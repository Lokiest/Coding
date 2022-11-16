<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>    
<div class="container">
	<h1>File Upload Test</h1>
	<form name="f" method="post" action="uploadEnd.do" enctype="multipart/form-data">
		올린이 : <input type="text" name="name"><br><br>
		첨부파일 : <input type="file" name="fname"><br><br>
		<button>Upload</button>
	</form>
</div>
<jsp:include page="/foot.jsp"/>
