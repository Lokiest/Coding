package com.my.multiweb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.model.UserVO;
import com.user.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@GetMapping("/join")
	public String joinForm() {
		
		return "/member/join";		
	}//---------------------------
	
	@PostMapping("/join")
	public String joinEnd(Model m, @ModelAttribute("user") UserVO user) {		
		log.info("join === user: "+user);
		if(user.getName()==null||user.getUserid()==null||user.getPwd()==null||
				user.getName().trim().isEmpty()||user.getUserid().trim().isEmpty()
				||user.getPwd().trim().isEmpty()) {
			
			return "redirect:join";
		}
		
		int n=userService.createUser(user);
		String str=(n>0)?"회원가입 완료":"가입 실패";
		String loc=(n>0)?"admin/userList":"javascript:history.back()";
		
		m.addAttribute("message",str);
		m.addAttribute("loc",loc);
		return "msg";
	}//---------------------------
	/* 스프링에서 JSON데이터를 생성해야 하는 경우
	 * 
	 * [1] pom.xml에 아래 라이브러리를 등록해야 한다.
	 * 
	 * <dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-core</artifactId>
			<version>2.9.8</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-yaml -->
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-yaml</artifactId>
			<version>2.9.8</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.8</version>
		</dependency>
	 * 
	 * [2] @ResponseBody 어노테이션을 붙여주고
	 * 반환되는 자료유형을 Map 또는 VO유형으로 하면 위 라이브러리가
	 * 알아서 자동으로 json형태로 변환해준다.
	 * [3] 응답유형이 json이라면
	 * produces="application/json" 을 기술하자.
	 * */
	
	/*아이디 중복체크 ajax처리-------------------
	 * 응답 데이터만 반환해야 할 때=>@ResponseBody
	 * */
	@GetMapping(value = "/idcheck", produces = "application/json")
	@ResponseBody
	public  Map<String, String> idCheck(@RequestParam("userid") String userid){
		log.info("userid==="+userid);		
		boolean isUse=userService.idCheck(userid);
		String result=(isUse)?"ok":"no";
		
		Map<String, String> map=new HashMap<>();
		map.put("result", result);		
		return map;
	}
	
	@GetMapping("/admin/userList")
	public String userList(Model m) {
		List<UserVO> userArr=userService.listUser(null);
		
		m.addAttribute("userArr",userArr);
		return "/member/list";
	}

	@PostMapping("/admin/userDel")
	public String userDelete(@RequestParam(defaultValue="0") int idx) {
		log.info("idx==="+idx);
		if(idx==0) {
			return "redirect:userList";
		}
		int n=userService.deleteUser(idx);
		log.info("n: "+n);
		return "redirect:userList";
	}
	
	

}



