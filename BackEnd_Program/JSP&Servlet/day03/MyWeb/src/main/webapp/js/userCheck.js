/**
 * 
 */
 
function member_check() {
	if(!isKor(mf.name)) {
		alert('한글만 가능');
		mf.name.select();
		return;
	}
	if(!isUserid(mf.userid)) {
		alert('id는 영문 숫자 가능');
		mf.userid.select();
		return;
	}
	
	mf.submit();
}

function isUserid(input) {
	let val = input.value;
	//let pattern = /^[abc]+$/; //a or b or c
	let pattern = /^[a-zA-z0-9]+$/
	let b = pattern.test(val);
	alert('b');
	return b;
}
/**

^ : 시작을 의미
$ : 끝을 의미
가-힣 : 한글 의미
+ : 패턴이 한 번 이상 반복된다는 의미
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