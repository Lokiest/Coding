<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ex08request.jsp</title>
</head>
<body style="padding-left:6em;">
    <h1>form양식</h1>
    <p>
        form태그는 사용자가 입력한 값들을 웹서버에 전달하고자 할 때 사용한다
        <br>
        form태그 안에는 다양한 입력 양식들이 올 수 있는데 이를 form control이라고 한다
    </p>
    <hr color="red">
    <!-- method: get(디폴트), post, put, delete, options 
    enctype="application/x-www-form-urlencoded"
    -->
    <form name="frm" id="frm" action="ex08_requestResult.jsp" method="get">
    <!--파일 업로드시 enctype="multipart/form-data"-->
        아이디:<input type="text" name="userid"><br>
        비밀번호:<input type="password" name="passwd"><br>
        회원사진:<input type="file" name="photo"><br>
        성별:<input type="radio" name="gender" value="M">남자
            <input type="radio" name="gender" value="F" checked="checked">여자<br>
        <!--단일 선택: radio  이때 동일한 name일 경우 그 중에 1개만 선택함
            다중 선택: checkbox
        -->
        취미:
        <input type="checkbox" name="hobby" value="Sports" checked>운동
        <input type="checkbox" name="hobby" value="Reading">독서
        <input type="checkbox" name="hobby" value="Music">음악감상
        <input type="checkbox" name="hobby" value="Movie">영화감상<br>
        <!--select : 기본은 단일선택
                - multiple 속성을 주면 다중선택이 가능함
                - size 속성을 주면 펼친형태가 된다
        -->
        드롭다운리스트:
        <select name="job">
            <option value="">::직업을 선택하세요::</option>
            <option value="Developer" selected>개발자</option>
            <option value="Designer">디자이너</option>
            <option value="Manager">매니저</option>            
        </select><br>
        <select name="lang" multiple size="6">
            <option value="">::사용가능 언어::</option>
            <option value="Java">Java</option>
            <option value="JavaScript">JavaScript</option>
            <option value="SQL">SQL</option>
        </select><br>
        자기소개:
        <textarea name="intro" rows="5" cols="70"
         placeholder="자기소개를 100자이내로 하세요"></textarea><br>

        히든필드:
        <input type="hidden" name="secret" value="TopSecret"><br>

        <input type="submit" value="회원가입"><!--전송버튼-->
        <input type="button" value="일반버튼" onclick="alert('안녕하세요')"><!--일반버튼 (전송기능없음)-->
        <input type="reset" value="다시쓰기"><!-- 입력값들을 초기화함-->
        <input type="image" src="../images/login.JPG">
        <!-- 이미지버튼은 기본적으로 submit기능을 갖는다. -->
        <img src="../images/login.JPG" onclick="alert('잘가세요~')">
    </form>
</body>
</html>