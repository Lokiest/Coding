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
	#postList ul>li{
		float:left;
		height:40px;
		line-height: 40px;
		border-bottom: 1px solid gray;
		list-style-type: none;
		width: 10%;
	}
	#postList ul>li:nth-child(4n + 1) {
		width:70%
	}
</style>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script>
	$(function(){
		//posts 목록 가져오기
		showPosts();
		$('#frm button').click(function(e){
			e.preventDefault();
			let author = $('#author').val();
			let title = $('#title').val();
			//alert(author + " / " + title);
			let jsonData={
				"author":author,
				"title":title
			}
			$.ajax({
				type:'post',
				url:'posts',
				contentType:'application/json',
				data:JSON.stringify(jsonData),
				dataType:'json',
				cach:false,
				success:function(res) {
					//alert(JSON.stringify(res));
					if(res.result>0) {
						showPosts();
					}
				},
				error:function(err) {
					alert('err : ' + err.status);
				}
			});
		})
	})
	
	const showPosts = function() {
		$.ajax({
			type:'get',
			url:'postsAll',
			dataType:'json',
			cache:false,
			success:function(res) {
				//alert(JSON.stringify(res));
				renderPosts(res);
			},
			error:function(err) {
				alert('err : ' + err.status);
			}
		})
	}
	
	const renderPosts = function(data) {
		let str='<ul>';
				$.each(data, function(i, post) {
					str+='<li>';
					str+=post.title;
					str+='</li>';
					str+='<li>';
					str+=post.author;
					str+='</li>';
					str+='<li>';
					str+=post.wdate;
					str+='</li>';
					str+='<li>';
					str+='<a href="#" onclick="postsEdit(\''+post.id+'\')">수정</a>';
					str+='<a href="#" onclick="postsDel(\''+post.id+'\')">삭제</a>';
					str+='</li>';
				})
		
			str+='</ul>';
			$('#postList').html(str);
	}
	
	const postsEdit=function(pid) {
		//alert(pid);
		$.ajax({
			type:'get',
			url:'postsEdit?id='+pid,
			dataType:'json',
			cache:false,
		})
		.done(function(res){
			//alert(JSON.stringify(res));
			$('#id').val(pid);
			$('#title').val(res.title);
			$('#author').val(res.author);
			$('#frm button').text('updates');
		})
		.fail(function(err){
			alert('err : ' + err.status);
		})
	}
	
	const postsDel=function(pid) {
		//alert(pid);
		$('#id').val(pid);
		let data = {
			"id":pid
		}
		$.ajax({
			type:'post',
			url:'postsDel',
			contentType:'application/json',
			data:JSON.stringify(data),
			cache:false,
			success:function(res) {
				//alert(JSON.stringify(res));
				if(res.result>0) {
					showPosts();
				}
			},
			error:function(err) {
				alert('err : ' + err.status);
			}
		})
	}
	
</script>
<div id="wrap" class="container">

	<h1>Posts 글쓰기</h1>
	<form id="frm" name="frm">
		<input type="hidden" name="id" id="id">
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