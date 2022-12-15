<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#wrap{
		padding:3em;
	}
	#frm li{
		margin:10px 5px;
		list-style-type: none;
	}
	#frm input,textarea,button{
		padding:7px;
	}
</style>    
<div id="wrap" class="container">

	<h1>Posts 글쓰기</h1>
	<form id="frm" name="frm">
		<ul>
			<li>Author: </li>
			<li>
				<input type="text" name="author" id="author" placeholder="Author" required>
			</li>
			<li>
				<textarea name="title" id="title" placeholder="Title" rows="5" cols="70"></textarea>
			</li>
			<li>
				<button>글쓰기</button>
			</li>
		</ul>
	</form>
	<div id="postList">
		여기에 포스트 목록 들어올 예정
	</div>
</div>