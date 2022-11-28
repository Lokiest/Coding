<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/top"/> 

<script>
	$(function(){
		$('#bt1').click(function(){
			let url="ajaxVO";
			$.ajax({
				url:url,
				type:'get',
				data:'num=100&name='+encodeURIComponent('홍길동'),
				dataType:'json',
				cache:false,
				success:function(res){
					//alert(res)
					let str='<h3>Num: '+res.idx+"</h3>";
					str+='<h3>Name: '+res.name+"</h3>";
					$('#resultView').html(str);
				},
				error:function(err){
					alert('err')
				}
				
			})
		});
		$('#bt2').click(function(){
			let url="ajaxList";
			$.ajax({
				url:url,
				type:'get',
				data:'idx=33&name='+encodeURIComponent("김철수"),
				dataType:'json',
				cache:false
			})
			.done(function(res){
				//alert(JSON.stringify(res));
				let str='<ul>';
					$.each(res, function(i, vo){
						str+='<li>'+vo.idx+", "+vo.name+", "+vo.msg+"</li>";
					})
					str+='</ul>'
				$('#resultView').html(str);
			})
			.fail(function(err){
				alert('err')
			})
		});
		
	})
	
	
	
</script>

<div class="container mt-3" style="height:600px;overflow: auto;">
	<h1 class="text-center">Ajax Test Page</h1>
	<button id="bt1" class="btn">ajax(VO)</button>
	<button id="bt2" class="btn">ajax(List)</button>
	<hr>
	<div id="resultView"></div>
</div>
<c:import url="/foot" />