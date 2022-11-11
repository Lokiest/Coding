/**
 * 
 */
 let win = null;
 function open_idcheck() {
 	win = window.open("idCheck.jsp", "idCheck","width=400, height=400, left=200, top=200");
}
 
function setId(uid) {
	//alert(uid);
	//uid값 부모창(window)의 userid의 value값에 전달하기
	//부모창 (opener >> window객체)
	//window > document > forms
	opener.document.mf.userid.value = uid;
	
	//팝업창 닫기 >> self (window)객체
	self.close();
}
 
function id_check() {
	if(!idf.userid.value) {
		alert('아이디 입력');
		idf.userid.focus();
		return;
	}
	
	if(!isUserid(idf.userid)) {
		alert('ID 확인 요망');
		idf.userid.select();
		return;
	}
	
	idf.submit();
}
 
function member_check() {
	if(!isKor(mf.name)) {
		alert('한글만 가능');
		mf.name.select();
		return;
	}
	if(!isUserid(mf.userid)) {
		alert('아이디 확인 요망');
		mf.userid.select();
		return;
	}
	if(!isPasswd(mf.pwd)) {
		alert('비밀번호 확인 요망');
		mf.pwd.select();
		return;
	}
	if(mf.pwd.value!=mf.pwd2.value) {
		alert('비밀번호가 다름');
		mf.pwd2.select();
		return;
	}
	if(!isMobile(mf.hp1, mf.hp2, mf.hp3)) {
		alert('hp 확인 요망');
		mf.hp1.select();
		return;
	}
/*
	if(!isDate(mf.birth)) {
		alert('날짜 형식 확인 요망');
		mf.birth.select();
		return;
	}

	if(!isEmail(mf.email)) {
		alert('이메일 형식 확인 요망');
		mf.email.select();
		return;
	}
*/
	mf.submit();
}


/*
	asdf-123@~.com
	asd.123@~.net
	asd12@~.co.kr
*/

/*
function isEmail(input) {
	let val = input.value;
	let pattern = /^[\w-_]+(\.[\w]+)*@([a-zA-Z]+\.)+[a-z]{2,3}$/;
	let b = pattern.test(val);
	//alert(b);
	return b;
}

function isDate(input) {
	let val = input.value;
	let pattern = /^\d{4}[-\/](0[1-9]|1[012])[-\/](0[1-9]|[12][0-9]|3[01])$/;
	let b = pattern.test(val);
	//alert(b);
	return b;
}
*/
/*
	\b : 단어의 경계를 나타내며 해당 패턴이 정확하게 일치해야함을 의미
	(1|2) : 1 또는 2가 나와야함을 의미
	\d{3,4} : 숫자가 3개 이상 4개 이하 나와야함을 의미
*/

function isMobile(input1, input2, input3) {
	let val = input1.value + "-" + input2.value + "-" + input3.value;
	//alert(val);
	let pattern = /\b(010|011)[-]\d{4}[-]\d{4}\b/;
	let b = pattern.test(val);
	//alert('hp : ' + b);
	return b;
}

function isUserid(input) {
	let val = input.value;
	//let pattern = /^[abc]+$/; //a or b or c
	let pattern = /^[a-zA-Z0-9]{5,10}$/;
	let b = pattern.test(val);
	return b;
}
/*
	\w : 알파벳 대소문자, 숫자
	\. : 마침표
*/

function isPasswd(input) {
	let val = input.value;
	let pattern = /^[\w]{4,8}$/;
	let b = pattern.test(val);
	//alert('pwd : ' + b);
	return b;
}
/**

^ : 시작을 의미
$ : 끝을 의미
가-힣 : 한글 의미
+ : 패턴이 한 번 이상 반복된다는 의미
_ : _
! : !
{4} : 4자리까지만 가능
{4,} : 4자리 이상 가능
{4,8} : 4~8자리 가능
 * 
 */

function isKor(input) {
	let val = input.value;
	//let pattern = new RegExp(/multi/g); //multi문자열이 있는지 여부를 체크한느 패턴
	//let pattern = /multi/g
	let pattern = /^[가-힣]+$/;
	let b = pattern.test(val); //정규식 패턴에 맞으면 true or false 반환
	//alert(b);
	return b;
}