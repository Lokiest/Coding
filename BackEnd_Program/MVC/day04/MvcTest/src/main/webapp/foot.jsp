<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<!-- foot.jsp -->
<% 
	String myctx=request.getContextPath();
%>
<style>
	.mydiv{
		width:90%;
		margin:auto;
		padding:1em;
		height:130px;
		background-color: beige;
		display: table;
	}
	.mycell {
		text-align: center;
		width:100%;
		height:100%;
		display: table-cell;
		vertical-align: middle;
	}
</style>

       </article>
        <!-- 사이드 영역 -------------------------------->
        <aside>
            <!-- 사이드 
            request에 저장한 값 >> requestScope.key
            session에 저장한 값 >> sessionScope.key
            
            ${key} >> 
            -->
            <nav>
	            <c:if test="${sessionScope.loginUser!=null }">
	                <div class="mydiv">
	                	<div class="mycell">
	                	<h3>${loginUser.name} [${loginUser.userid}]님</h3>
	                	<h3>로그인 중</h3>
	                	<br>
	                	<h4><a href="logout.do">로그아웃</a></h4>
	                	</div>
	                </div>
	            </c:if>
            </nav>
    
        </aside>
        <div class="clear"></div>
        <!-- 푸터 영역 ------------------------------>
        <footer>
            <!-- footer ----------------------->
            &copy;Copyright/회사소개
        </footer>
            
    </div>
    <!-- div#wrap. container end -->
</body>
</html>
