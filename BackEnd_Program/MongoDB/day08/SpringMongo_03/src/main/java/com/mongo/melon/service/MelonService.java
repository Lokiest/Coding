package com.mongo.melon.service;

import java.util.List;

import com.mongo.melon.domain.MelonVO;

public interface MelonService {
	
	//오늘의 멜론 노래 저장
	int crawlingMelon() throws Exception;
	
	//수집된 멜론 노래 목록 가져오기
	List<MelonVO> getMelonList() throws Exception;
	
	//가수별 차트에 올라간 노래수 가져오기
	List<MelonVO> getCntBySinger() throws Exception;
	
	List<MelonVO> getMelonListBySinger(String colName, String singer) throws Exception;
	
}
