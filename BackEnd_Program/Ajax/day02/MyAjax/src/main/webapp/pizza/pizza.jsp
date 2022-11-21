<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"> <!--모바일 반응형 지원 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pizza.jsp</title>
<!--CDN 참조  -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style type="text/css">
	/* body,h2{
		font-family:돋움,돋움체,verdana;
		color:navy;
	} */
</style>

<script type="text/javascript">
	let req = false; //전역변수
	//Ajax요청을 보내기 위해서 반드시 필요한 객체- XMLHttpRequest객체
	//이 객체를 얻는 방법이 브라우저마다 조금씩 다르다.
	
	const init=function() {
		try {
			req = new XMLHttpRequest();
			//alert(req);
		} catch(e) {
			try {
				req = new ActiveXObject("Msxml2.XMLHTTP"); //ie 경우
			} catch(e2) {
				req = false;
			}
		}
		if(!req) {
			alert('req객체 생성 실패')
		}
	}

	const getUserInfo=function() {
		//사용자가 입력한 연락처 값을 알아내기
		let phone = $('#phone').val();
		//alert(phone);
		
		//서버쪽에 고객의 연락처 정보를 파라미터로 전달
		//[1]
		req.open('GET','pizzaResult.jsp?phone='+phone,true);
		//open(요청방식, url, 비동기여부)
		
		//[2] send() 호출하기 전에 onreadystatechange 속성값에 콜백함수를 지정해줘야함
		req.onreadystatechange=updatePage;
		
		//[3] 요청 전송
		req.send(null); //get방식 요청일 경우 null을 파라미터로 전달
						//post방식 요청일 경우 "phone=111&userid=aaa"를 매개변수로
	}
	
	const updatePage = function() {
		//alert(req.readyState + " / " + req.status);
		if(req.readyState==4 && req.status==200) {
			//성공적인 응답이 온다면 >> 응답 데이터 받아보기
			let res = req.responseText;
			//alert(res);
			//응답유형이 text 형식 >> responseText로 받고
			//			xml형식 >> responseXML로 받음
			//'#' 구분자를 기준으로 쪼개어 배열에 할당
			let tokens = res.split('#');
			let num = tokens[0]; //회원번호
			if(parseInt(num)==0) { //비회원
				$('#nonUser').show(1000);
				$('#userInfo').html("").hide(1000);
				$('#addr').html("").focus();
			} else { //회원 >> 회원정보
				let str = `<ul class='list-group'>
								<li class='list-group-item'>`+num+`</li>
								<li class='list-group-item'>`+tokens[1]+`</li>
								<li class='list-group-item'>`+tokens[2]+`</li>
							</ul>
							`
				$('#userInfo').html(str).show(1000);
				$('#nonUser').hide(1000);
				$('#addr').html("");
			}
			
			//alert(res);
			
			//$('#userInfo').html("<h3 class='text-primary'>"+res+"</h3>")
		}
	}
	
	window.onload = init;
	
</script>

</head>
<body>
<div class="section">
<div class="container">
	<h1>Pizza Order Page</h1>
	<form role="form" class="form-horizontal" 
	name="orderF" id="orderF"
	 action="order.jsp" method="POST">
		<div class="form-group">
			<p class="text-info">
			<b>귀하의 전화번호를 입력하세요:</b>
			<input type="text" size="20"
			 name="phone" id="phone" 
			 onchange="getUserInfo()"
			  class="form-control"/>
			</p>
			<p class="text-danger">
			<b>
				귀하가 주문하신 피자는 아래 주소로 배달됩니다.
			</b>	
			</p>
			<div id="userInfo"></div>
			<div id="address"></div>
			<!-- 비회원 입력 폼 : 비회원일 경우 주소입력 폼을 보여주자.-->
			<div id="nonUser" style="display:none;">
				주소: <input type="text" name="addr" id="addr"
						size="60" style="border:2px solid maroon;" class="form-control"/>
			</div>
			<!-- ------------------------------------------- -->
			<p class="text-info">
			<b>주문 내역을 아래에 기입하세요</b></p>
			<p>
				<textarea name="orderList"
				 id="orderList" rows="6" cols="50" class="form-control"></textarea>
			</p>
			<p>
				<input type="submit" value="Order Pizza" class="btn btn-primary"/>
			</p>
		</div>
	</form>
</div>
</div>
</body>
</html>




