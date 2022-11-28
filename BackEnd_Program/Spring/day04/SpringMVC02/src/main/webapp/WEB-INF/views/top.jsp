<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>MultiShop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body>
<!-- multiweb -->
<c:set var="myctx" value="${pageContext.request.contextPath}"/>

<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>My First Bootstrap 4 Page</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="${myctx}/index">Multi</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="${myctx}/join">Join</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${myctx}/admin/userList">Users</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${myctx}/login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${myctx}/admin/prodForm">상품등록</a>
      </li>    
      <li class="nav-item">
        <a class="nav-link" href="${myctx}/admin/prodList">상품목록</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${myctx}/user/cartList">Cart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${myctx}/user/board/write">Board Form</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${myctx}/board/list">Board List</a>
      </li>
    </ul>
  </div>  
</nav>

