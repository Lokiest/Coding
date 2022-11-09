<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- top.jsp -->
<%
	//Context명을 동적으로 알아내기 "MyWeb" >> Context
	//절대경로방식 : 컨텍스트를 기준으로 경로 잡는 방식 "MyWeb/memo/list.jsp"
	//top.jsp or foot.jsp는 공통 모듈 >> 절대경로로 설정해야만 함
	String myctx = request.getContextPath();
	//System.out.println("myctx : " + myctx);
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    
    <link rel="stylesheet" type="text/css" href="<%=myctx %>/css/layout.css"/>

</head>
<body>
    <div id="wrap" class="container">
        <!-- 헤더: 로고 이미지, 검색폼, 목차 -->
        <header>
            <!-- 헤더영역 -->
            <a href="<%=myctx %>/index.jsp"><img src="<%=myctx %>/images/main_logo.JPG"></a>
        </header>
        <div class="clear"></div>
        <!-- 내바게이션바 : 메뉴 -->
        <nav>
       
        <ul>
            <li><a href="<%=myctx %>/index.jsp">Home</a></li>
            <li><a href="<%=myctx %>/member/join.jsp">Signup</a></li>
            <li><a href="<%=myctx %>/login/login.jsp">Signin</a></li>
            <li><a href="#">Board</a></li>

       
        </ul>
    </nav>
    <div class="clear"></div>
        <!-- 컨텐츠 영역 -------------------------------->
        <article>