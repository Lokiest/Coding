<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!-- top.jsp -->
<% 
	String myctx=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    
    <link rel="stylesheet" type="text/css" href="<%=myctx%>/css/layout.css"/>
	<script src="jquery-3.6.1.min.js"></script>
</head>
<body>
    <div id="wrap" class="container">
        <!-- 헤더: 로고 이미지, 검색폼, 목차 -->
        <header>
            <!-- 헤더영역 -->
            <a href="<%=myctx%>/index.do"><img src="<%=myctx%>/images/main_logo.JPG"></a>
        </header>
        <div class="clear"></div>
        <!-- 내바게이션바 : 메뉴 -->
        <nav>
       
        <ul>
            <li><a href="<%=myctx%>/index.do">Home</a></li>
            <li><a href="<%=myctx%>/boardWrite.do">Board 쓰기</a></li>
            <li><a href="<%=myctx%>/boardList.do">Board 목록</a></li>
            <li><a href="<%=myctx%>/joinForm.do">회원가입</a></li>        
            <!-- el표현식 연산자 : eq(==), ne(!=) -->
            <c:choose>
            	<c:when test="${loginUser eq null}">
	            <li><a href="<%=myctx%>/login.do">로그인</a></li>
	            </c:when>
	            <c:otherwise>
	            <li><a href="<%=myctx%>/logout.do">로그아웃</a></li>
	            </c:otherwise>
	        </c:choose>
        </ul>
    </nav>
    <div class="clear"></div>
        <!-- 컨텐츠 영역 -------------------------------->
        <article>
        
        
        