package com.mongo.posts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongo.posts.domain.PostVO;
import com.mongo.posts.service.PostsService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class PostsController {
	
	@Resource(name="postsServiceImpl")
	private PostsService pService;
	
	@GetMapping("/posts")
	public String postsForm(Model m) {
		
		
		return "posts/write";
	}
	
	@PostMapping(value="/posts", produces = "application/json")
	@ResponseBody
	public ModelMap postsInsert(@RequestBody PostVO vo) {
		Date d = new Date();
		log.info("vo == " + vo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String wdate = sdf.format(d);
		vo.setWdate(wdate);
		
		ModelMap map = new ModelMap();
		int n = pService.insertPosts(vo);
		map.put("result", n);
		return map;
	}
	
	@GetMapping(value="/postsAll", produces = "application/json")
	@ResponseBody
	public List<PostVO> postsList() {
		
		return this.pService.listPosts();
	}
	
	@PostMapping(value="/postsDel", produces = "application/json")
	@ResponseBody
	public ModelMap postsDelete(@RequestBody PostVO vo) {
		log.info("vo == " + vo.getId());
		int n = this.pService.deletePosts(vo.getId());
		ModelMap map = new ModelMap();
		map.put("result", n);
		return map;
	}
	
	@GetMapping(value="/postsEdit", produces = "application/json")
	@ResponseBody
	public PostVO postsEdit(@RequestParam String id) {
		log.info("id" == id);
		PostVO vo = this.pService.selectPosts(id);
		return vo;
	}

}
