package com.my.multiweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/* Rest : Representational State Transfer의 약자
 * - 전송방식과 URI를 결합해서 원하는 작업을 지정하여 처리하도록 하는 방식
 * 	 GET/POST/PUT/DELETE
 *   - GET : 조회
 *   - DELETE : 삭제처리
 *   - POST : INSERT처리
 *   ...
 *   URI +GET/POST/PUT/DELETE
 *   
 *   GET : /users/100 ==> 100번 회원의 정보를 조회하는 로직 처리한다
 *   GET : /users ===> 모든 회원 목록을 조회하는 로직을 처리한다
 *   DELETE: /delete/3 ==> 3번 회원 정보를 삭제 처리...
 * @RestController==> REST방식의 데이터를 처리하는 여러 기능을 쉽게 할 수 있다.
 * */

import com.memo.model.MemoVO;

import lombok.extern.log4j.Log4j;
@RestController
@Log4j
public class AjaxRestController {
	
	@GetMapping(value="/ajaxText", produces = "text/plain; charset=UTF-8")
	public String ajaxText() {
		
		return "Hello Ajax 안녕하세요";
	}
	
	@GetMapping(value="/ajaxVO2", produces = "application/json")
	public MemoVO ajaxVO() {
		MemoVO vo=new MemoVO(55,"김철이","반가워요",null);
		return vo;
	}
	
	@GetMapping(value="/ajaxVO3", produces = "application/xml")
	public MemoVO ajaxVO3() {
		MemoVO vo=new MemoVO(55,"김철이","반가워요",null);
		return vo;
	}

}





