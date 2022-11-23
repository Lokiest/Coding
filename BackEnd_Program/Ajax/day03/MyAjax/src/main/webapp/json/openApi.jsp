<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- CDN 참조-------------------------------------- -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- ------------------------------------------------- -->
<script>
$(function() {
	$('#btnSearch').click(function(evt) {
		evt.preventDefault(); //기본동작 막기
		//검색어 입력값 받기
		let keyword = $('#title').val();
		if(!keyword) {
			alert('검색어 입력');
			$('#title').focus();
			return;
		}
		let url="openApiResult.jsp?query=" + encodeURIComponent(keyword) + "&display=20&start=1";
		send(url, keyword, 1);
	})
})

function send(url, keyword, cpage) {
	$.ajax({
		type:'get',
		url:url,
		dataType:'json',
		cache:false
	})
	.done(function(res) {
		console.log(res);
		let total = res.total;
		
		let obj = {
			total:total,
			keyword:keyword,
			capge:cpage,
			display:20
		};
		showList(res.items, obj);
		showPage(obj)
	})
	.fail(function(err) {
		alert('error : ' + err.status);
	})
}

function showList(items, obj) {
	let str='<h2>'+obj.keyword+' 검색 결과 '+obj.total+'개</h2>';
		str+='<table class="table">';
		str+='<tr>';
		$.each(items, function(i, book){
			str+='<td width="20%" style="text-align:center">';
			str+='<a href="'+book.link+'" target="_blank">';
			str+='<img src="'+book.image+'" class="img img-thumbnail" style="width:70%">';
			str+='</a>';
			str+='<h5>' + book.title+ '</h5>';
			str+='</td>';
			if(i%5==4) { //한 행에 5개씩
				str+='</tr><tr>';
			}
		})	
		str+='</tr>';
		str+='</table>';
	
	$('#openApiBook').html(str);
}

function showPage(obj) {
	let total = obj.total;
	let display = obj.display;
	
	if(total > 200) {
		total = 200;
	}
	
	let query = obj.keyword;
	let pageCount = Math.ceil((total-1)/display);
	let str='<ul class="pagination">';
		for(let i=1;i<=pageCount;i++) {
			let start = (i-1)*display + 1;
			if(i==obj.cpage){
				str+='<li class="active">';
			}else{
				str+='<li>';
			}
			str+='<a href="#" onclick="fetch(\''+query+'\','+start+','+i+')">';
			str+=i;
			str+='</a>';
			str+='</li>';
		}
		str+='</ul>';
	$('#pageNavi').html(str);
}

function fetch(query, start, cpage) {
	//alert(query + " / " + start + " / " + cpage);
	let url="openApiResult.jsp?query="+encodeURIComponent(query)+"&display=20&start="+start;
	send(url, query, cpage);
}

</script>

<div class="container">
   <div class="row">
      <div class="col-md-12">
         <form action="text.jsp">
            <h1 class="text-center">Naver 도서 검색</h1>
            <input type="text" name="title" id="title" placeholder="도서명을 입력하세요" class="form-control">
            <button class="btn btn-info" id="btnSearch">검    색</button>
         </form>
      </div>      
   </div>
   <hr>
   <div id="pageNavi" class="text-center">
   </div>
   <hr>
   <div id="openApiBook">
   
   </div>
</div>
