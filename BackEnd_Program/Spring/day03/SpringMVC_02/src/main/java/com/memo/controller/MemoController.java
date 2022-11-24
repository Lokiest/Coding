package com.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.memo.model.MemoDAO;
import com.memo.model.MemoVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MemoController {
	
	@Autowired
	private MemoDAO memoDao;
	
	@RequestMapping(value="/memo", method=RequestMethod.GET)
	public String memoForm() {
		return "memo/input";
	}
	
	//html input name과 VO체의 property이 같고 @ModelAttribute 를 붙이면 parameter값 자 동 으 로 VO 체에 넣 어 줌
	
	@RequestMapping(value="/memo", method=RequestMethod.POST)
	public String memoInsert(Model model, @ModelAttribute("memo") MemoVO memo) {
//		System.out.println("memo---------- : " +memo);
		log.info("memo >>" + memo);
		
		int n = memoDao.insertMemo(memo);
		String str = (n>0)?"성공":"실패";
		String loc = (n>0)?"memoList":"javascript:history.back()";
		
		model.addAttribute("message", str);
		model.addAttribute("loc", loc);
		return "msg";
	}
	
	@RequestMapping("/memoList")
	public String memoList(Model model) {
		int totalCount = memoDao.getTotalCount();
		List<MemoVO> arr = memoDao.listMemo();
		
		model.addAttribute("memoArr", arr);
		model.addAttribute("totalCount", totalCount);
		return "memo/list";
	}
	
	@RequestMapping("/memoDel")
	public String memoDelete(Model model, @RequestParam(defaultValue= "0") int idx) {
		log.info("idx == " + idx); //idx 파라미터값 넘어오지않으면 디폴트값을 0으로
		if(idx==0) {
			return "redirect:memoList"; //redirect 방식으로 이동
		}
		int n = memoDao.deleteMemo(idx);
		String str = (n>0)?"성공":"실패";
		
		model.addAttribute("message", str);
		model.addAttribute("loc", "memoList");
		return "msg";
	}
	
	@RequestMapping(value="/memoEdit", method = RequestMethod.GET)
	public String memoEditForm(Model model, @RequestParam(defaultValue="0") int idx) {
		if(idx==0) {
			return "redirect:memoList";
		}
		MemoVO memo = memoDao.getMemo(idx);
		
		model.addAttribute("memo", memo);
		
		return "memo/edit";
	}
	
	@RequestMapping(value="/memoEdit", method = RequestMethod.POST)
	public String memoEditEnd(Model model, @ModelAttribute("memo") MemoVO memo) {
		log.info("memo edit == " + memo);
		int n = memoDao.updateMemo(memo);
		String str=(n>0)?"수정 성공":"수정 실패";
		model.addAttribute("message", str);
		model.addAttribute("loc", "memoList");
		return "msg";
	}
	
}
