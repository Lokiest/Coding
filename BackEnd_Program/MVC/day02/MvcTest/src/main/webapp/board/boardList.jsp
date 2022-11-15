<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/top.jsp"/> 
<style>
	#boardWrap{
		width: 94%;
		margin:auto;
		padding-top:1em;
	}
	#boardList>li{
		list-style-type: none;
		float:left;
		height:40px;
		line-height:40px;
		border-bottom: 1px solid #ddd;		
		width:15%;
	}
	#boardList>li:nth-child(4n+2){
		width:55%;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
		/*제목 텍스트가 오버플로우 될 경우 말줄임표로 출력*/
	}
	#boardList a:link, #boardList a:visited, #boardList a:hover{
		text-decoration: none;
	}
</style>   
<div class="container">
	<h1>Board List</h1>
	<br>
	<p>
	<a href="boardWrite.do">글쓰기</a>|<a href="boardList.do">글목록</a>
	
	<%-- <h3>총 게시글 수: ${totalCount} 개</h3> --%>
	<%-- ${boardArr} --%>
	
	</p>
	<br>
	<div id="boardWrap">
		<ul id="boardList" class="boardList">
			<li>번호</li>
			<li>제목</li>
			<li>글쓴이</li>			
			<li>등록일</li>
			<!-- ----------------------------------- -->
			<c:forEach var="vo" items="${boardArr}">
					<!--forEach태그의 속성들
						var : 변수명을 지정한다
						items : 자료구조(ArrayList, Map...)
						begin : 시작값
						end : 끝값
						step: 증가치
						varStatus: 반복문의 상태정보를 담아줄 변수명을 지정
							- count: 반복문 횟수 1~
							- index : 인덱스번호 0~
					  -->
			<li>${vo.num}</li>
			<li><a href="boardView.do?num=${vo.num}">${vo.subject}</a></li>
			<li>
			${vo.userid}
			</li>			
			<li>
				<fmt:formatDate value="${vo.wdate}" pattern="yyyy-MM-dd"/>
			</li>
			</c:forEach>
			<!-- ----------------------------------- -->
		</ul>
	</div>
	
</div>
<jsp:include page="/foot.jsp"/>