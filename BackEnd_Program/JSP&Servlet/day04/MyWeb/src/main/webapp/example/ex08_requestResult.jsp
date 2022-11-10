<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//단일 값 받아오기 (name,pwd,gender,photo,job,intro,secret)
	//request : HttpServletRequest type
	//String getParameter("파라미터이름")
	String name = request.getParameter("userid");
	String passwd = request.getParameter("passwd");
	String gender = request.getParameter("gender");
	String photo = request.getParameter("photo");
	String job = request.getParameter("job");
	String intro = request.getParameter("intro");
	String secret = request.getParameter("secret");
	
	
	//다중 값 받아오기 (hobby,lang)
	//String[] getParameterValues("파라미터이름")
	String[] hobbies = request.getParameterValues("hobby");
	String[] langs = request.getParameterValues("lang");
	
%>
<ul>
	<li>이름 : <%=name %></li>
	<li>비밀번호 : <%=passwd %></li>
	<li>성별 : <%=gender %></li>
	<li>파일명 : <%=photo %></li>
	<li>직업 : <%=job %></li>
	<li>자기소개 : <%=intro %></li>
	<li>비밀 : <%=secret %></li>
	<li>취미 : 
		<% if(hobbies!=null) {
			for(String hobby:hobbies) {
				out.println(hobby + ", ");
				}
			}
		%>
	</li>
	<li>언어 : 
		<%
			if(langs!=null) {
				for(String lang:langs) {
					out.println(lang + ", ");
				}
			}
		%>
	</li>

</ul>
<hr color='red'>
<h1>request의 주요 메소드</h1>
<%
	String server = request.getServerName(); //서버 도메인명
	int port = request.getServerPort(); //포트 번호
	StringBuffer buf = request.getRequestURL(); //전체 url을 반환
	String url = buf.toString();
	String uri = request.getRequestURI(); //컨텍스트명 이후 경로를 반환
	String myctx = request.getContextPath();
	String queryString = request.getQueryString();
	String cip = request.getRemoteAddr();
	String protocol = request.getProtocol();
	
	int i = uri.indexOf(".jsp");
	int end=0;
	if(i>0)
		end=i;
	String str = uri.substring(myctx.length(), end);
%>
<h2>서버 도메인명 : <%=server %></h2>
<h2>서버 포트번호 : <%=port %></h2>
<h2>요청 url : <%=url %></h2>
<h2>요청 uri : <%=uri %></h2>
<h2>컨텍스트명 : <%=myctx %></h2>
<h2>QueryString : <%=queryString %></h2>
<h2>클라이언트 ip : <%=cip %></h2> <!-- ip주소 타고 들어가야 확인 가능 -->
<h2>Protocol : <%=protocol %></h2>
<hr color='blue'>
<h2><%=str %></h2>
