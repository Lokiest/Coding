package com.my.multiweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.memo.model.MemoVO;
import com.user.model.UserVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class AjaxController {
	
	@GetMapping("/ajaxView")
	public String ajaxView() {
		
		return "ajax/ajaxView";
	}
	
	@GetMapping(value="/ajaxVO", produces = "application/json")
	@ResponseBody //반환되는 값이 뷰네임이 아니라 데이터를 반환한다는 의미로 붙여주자
	public UserVO ajaxVO(int num, String name) {
		log.info("num: "+num+", name: "+name);
		
		UserVO user=new UserVO(num,name,"test","a","b","c","d","e","f","g",null,1000,0,"일반회원");
		
		return user;
	}
	
	@GetMapping(value="/ajaxList", produces="application/json")
	@ResponseBody
	public List<MemoVO> ajaxList(int idx, String name){
		log.info("idx: "+idx+", name: "+name);
		
		MemoVO vo1=new MemoVO(idx,name,"ajaxTest합니다1",null);
		MemoVO vo2=new MemoVO(idx+1,name,"ajaxTest합니다2",null);
		MemoVO vo3=new MemoVO(idx+2,name,"ajaxTest합니다3",null);
		MemoVO vo4=new MemoVO(idx+3,name,"ajaxTest합니다4",null);
		
		List<MemoVO> arr=new ArrayList<>();
		arr.add(vo1);
		arr.add(vo2);
		arr.add(vo3);
		arr.add(vo4);
		
		return arr;
	}
	

}
