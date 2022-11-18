<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.setHeader("Pragma","No-cache"); //HTTP 1.0 
	response.setDateHeader ("Expires", 0); 
	response.setHeader("Cache-Control","no-cache");
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOOK</title>
<!-- CDN 참조-------------------------------------- -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- ------------------------------------------------- -->
<style type="text/css">


</style>


<script type="text/javascript">
	//jQuery의 $.ajax() 함수를 이용해서 ajax를 요청을 해보자
	/* 
		$.ajax({
			type:'get', //요청방식
			url:'serverpage',
			cache : false, //no cache
			dataType:'xml', //응답유형
			success : function(res){ //응답변수
				
			},
			error:function(err) { //에러변수
				
			}
		})
		
	*/
	function goDel(visbn) {
		//alert(visbn);
		$.ajax({
			type:'GET',
			url:'bookDelete.jsp?isbn='+visbn,
			cache:false,
			dataType:'xml',
			success : function(res) {
				let n = $(res).find('result').text();
				if(parseInt(n)>0) {
					getAllBook();
				} else {
					alert('삭제 실패');
				}
			},
			error:function(err) {
				alert('error : ' + err.status);
			}
		})
	}
	
	function goEdit(visbn) {
		//alert(visbn);
		$.ajax({
			type:'POST',
			url:'bookInfo.jsp',
			data:"isbn=" + visbn, //post
			cache:false,
			dataType:'json',
			success : function(res) {
				//alert(JSON.stringify(res));
				let vtitle = res.title;
				let vpublish = res.publish;
				let vpubdate = res.published;
				let vprice = res.price;
				let vimage = res.bimage;
				//alert(vtitle);
				
				$('#isbn').val(visbn);
				$('#title').val(vtitle);
				$('#publish').val(vpublish);
				$('#published').val(vpubdate);
				$('#published').val(vpubdate);
				$('#price').val(vprice);
				let str="<img src='./images/"+vimage+"'>";
				$('#bimage').html(str);
			},
			error:function(err) {
				alert('error : ' + err.status);
			}
		})
	}
	
	function getAllBook() {
		//alert('a');
		$.ajax({
			type:'GET',
			url:'bookAll.jsp',
			cache:false,
			dataType:'html',
			success : function(res) {
				//alert(res);
				$('#book_data').html(res);
			},
			error:function(err) {
				alert('error : ' + err.status);
			}
		})
		
	}

</script>
</head>
<!--onload시 출판사 목록 가져오기  -->
<body onload="getPublish()">
   <div class="container">
	<h2 id="msg">서적 정보 페이지</h2>
<form name="findF" id="findF" role="form"
 action="" method="POST">
<div class="form-group">
<label for="sel" class="control-label col-sm-2">출판사</label>
<span id="sel"></span><span id="sel2"></span>
</div>
<p>
<div class='form-group'>
	<label for="books" class="control-label col-sm-2" id="msg1">도서검색</label>
	<div class="col-sm-6">
	<input type="text" name="books" id="books"
	 onkeyup="autoComp(this.value)"
	 class="form-control" >
	 <!-- ---------------------------- -->
	 <div id="lst1" class="listbox"
	  style="display:none">
	 	<div id="lst2" class="blist"
	 	 style="display:none">
	 	</div>
	 </div>
	 <!-- ---------------------------- -->
	</div>
</div>
</form>
<div>
 
 <button type="button"
  onclick="getBook()"
  class="btn btn-primary">검색</button>
 
 <button type="button" onclick="getAllBook()" class="btn btn-success">모두보기</button>
 <button type="button" id="openBtn"
  class="btn btn-info">OPEN API에서 검색</button><br><br>
</div>
<div id="localBook">

<table class="table table-bordered" border="1"  style="margin:0; padding:0;">
	<tr class="info">
		<td style="width:20%;">서명</td>
		<td style="width:20%;">출판사</td>
		<td style="width:20%;">가격</td>
		<td style="width:20%;">출판일</td>
		<td style="width:20%;">편집</td>
	</tr>
</table>
<!-- ----------------------- -->
<div id="book_data"></div>
<!-- ----------------------- -->
<form id="editF" name="editF">
<table id="book_info" class="table table-hover" border="2">
	<tr>
		<td width="20%">ISBN코드</td>
		<td>
		<input type="text" name="isbn" id="isbn"
		class="form-control" readonly>
		</td>
		<td rowspan="6" width="30%" id="bimage" class="text-center"></td>
	</tr>
	<tr>
		<td>서명</td>
		<td>
		<input type="text" name="title" id="title"
		class="form-control">
		</td>
		
	</tr>
	<tr>
		
		<td>출판사</td>
		<td>
		<input type="text" name="publish" id="publish"
		class="form-control">
		</td>
		
	
	</tr>
	<tr>
	
		<td>가격</td>
		<td>
		<input type="text" name="price" id="price"
		class="form-control">
		</td>
		
	</tr>
	<tr>
	
		<td>출판일</td>
		<td>
		<input type="text" name="published"
		 id="published"  disabled
		class="form-control">
		</td>
		
	</tr>
	<tr>
		<td colspan="2">
		<button type="button"
		onclick="goEditEnd()" class="btn btn-danger">갱신</button></td>
	</tr>
</table>
</form>
	</div>
</div><!-- #localBook end -->

<!-- ------------------------------- -->
<div id="openApiBook">

</div>
	
</body>
</html>

<!-- https://apis.daum.net/search/book -->
<!-- 53c73f32f6c4150ca5aa184ba6250d8e -->

<!-- https://apis.daum.net/search/book?apikey=53c73f32f6c4150ca5aa184ba6250d8e&q=다음카카오&output=json -->




