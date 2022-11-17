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
	.pageWrap{
		position:relative;
	}
	.paging{
		list-style-type:none;
		position: absolute;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%, -50%);
	}
	.paging>li {
		float:left;
		padding: 5px;
		text-align: center;
		width:2em;
		border : 1px solid #ddd;
		border-radius: 3px;
		margin:1px;
	}
	.paging>li.current {
		background-color: beige;
	}
</style>   

<script>
	function find_check() {
		let $keyword = $('#findKeyword');
		//alert($keyword.val());
		if(!$keyword.val()) {
			alert('검색어 입력');
			$keyword.focus();
			return false;
		}
		return true;
	}
</script>

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
	
		<div id="boardSearch">
			<form name="searchF" id="searchF" action="boardList.do" method="get" onsubmit="return find_check()">
				<select name="findType">
					<option value="1">제 목</option>
					<option value="2">작성자</option>
					<option value="3">글내용</option>
				</select>
				<input type="text" name="findKeyword" id="findKeyword">
				<button>Search</button>
			</form>
		</div>
		
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
			<li>
				<a href="boardView.do?num=${vo.num}">${vo.subject}</a>
				<c:if test="${vo.filesize > 0}">
				<img src="images/qwe.png" width="15px">
				</c:if>
			</li>
				
			<li>
			${vo.userid}
			</li>			
			<li>
				<fmt:formatDate value="${vo.wdate}" pattern="yyyy-MM-dd"/>
			</li>
			</c:forEach>
			<!-- ----------------------------------- -->
		</ul>
		<div style="clear:both"></div>
		<br><br>
		<div class="pageWrap">
		<ul class="paging"">
			<li><a href="boardList.do?cpage=${capge-1}${qStr}">◁</a></li>
			
			<c:forEach var="i" begin="1" end="${pageCount }">
				<c:if test="${cpage==i }">
				<li class="current"><a href="boardList.do?cpage=${i}${qStr}">${i}</a></li>
				</c:if>
				
				<c:if test="${cpage!=i }">
				<li><a href="boardList.do?cpage=${i}${qStr}">${i}</a></li>
				</c:if>
			</c:forEach>
			
			<li><a href="boardList.do?cpage=${capge+1}${qStr}">▷</a></li>
		</ul>
		</div>
		<br>
		<div>
			총 게시글 수 : ${totalCount }개, 현재 <span style="color:red">${cpage}</span> /  총 ${pageCount} pages
		</div>
	</div>
	
</div>
<jsp:include page="/foot.jsp"/>