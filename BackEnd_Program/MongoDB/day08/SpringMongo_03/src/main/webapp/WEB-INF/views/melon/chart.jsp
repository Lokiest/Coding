<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::Melon Chart::</title>
<style>
	#wrap{
		padding:3em;
	}
	
</style>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script>
	$(function() {
		$('#btn1').on('click', function(){
			$.ajax({
				type:'get',
				url:'crawling',
				dataType:'xml',
				cache:false,
				success:function(res) {
					//alert(res);
					let n = $(res).find('result').text();
					//alert(n + ' data saved');
					$('#melonList').html("<h3>" + n + " data crawling success</h3>");
					getMelonList();
				},
				error:function(err) {
					alert('err : ' + err.status);
				}
			})
		})
	})
	
	const getMelonList=function() {
		$.ajax({
			type:'get',
			url:'list',
			dataType:'json',
			cache:false,
			success:function(res) {
				//alert(res);
				renderMelon(res);
			},
			error:function(err) {
				alert('err : ' + err.status);
			}
		})
	}
	
	const renderMelon=function(jsonArr) {
		alert(jsonArr.length);
		let str = '<ul class="melon_chart">';
		$.each(jsonArr, function(i, obj) {
			str+= '<li>';
			str+= obj.ranking;
			str+= '</li>';
			str+= '<li>';
			str+= '<img src="'+obj.albumImage+'">'
			str+= '</li>';
			str+= '<li>';
			str+= '<span class="title">' + obj.songTitle + "</span><br>";
			str+= '<span class="singer">' + obj.singer + "</span>";
			str+= '</li>';
		});
			str+= '</ul>';
		
		$('#melonList').html(str);
	}
</script>
</head>
<body>
<div id="wrap" class="container">
	<h1>Today's Melon Chart - ${today}</h1>
	<button id="btn1">Melon Chart Crawling</button>
	<button id="btn2" onclick="getMelonList()">Melon Chart list</button>
	<div id="melonList">
		
	</div>
</div>

</body>
</html>