package com.mongo.posts.service;

import java.util.List;

import com.mongo.posts.domain.PostVO;

public interface PostsService {
	
	int insertPosts(PostVO vo);
	
	List<PostVO> listPosts();
	
	int deletePosts(String id);
	
	int updatePosts(PostVO vo);

	PostVO selectPosts(String id);
}
