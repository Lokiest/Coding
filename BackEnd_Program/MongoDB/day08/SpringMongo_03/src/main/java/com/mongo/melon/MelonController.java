package com.mongo.melon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mongo.melon.domain.MelonVO;
import com.mongo.melon.service.MelonService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/melon")
public class MelonController {
	
	@Inject
	private MelonService mService;
	
	@GetMapping("/chart")
	public ModelAndView index() {
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = sdf.format(today);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("melon/chart");
		mv.addObject("today", todayStr);
		return mv;
	}
	
	@GetMapping(value="/crawling", produces = "application/xml")
	public ModelMap collectMelonChart() throws Exception {
		log.info("crawling start ------------");
		int n = this.mService.crawlingMelon();
		log.info("crawling end ------------");
		ModelMap map = new ModelMap();
		map.put("result", n);
		return map;
	}
	
	@GetMapping(value="/list", produces = "application/json")
	public List<MelonVO> getMelonList() throws Exception {
		return this.mService.getMelonList();
	}
	
	
}
