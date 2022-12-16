package com.mongo.melon.mapper;

import java.util.List;

import com.mongo.melon.domain.MelonVO;

public interface MelonMapper {
	
	boolean createCollection(String colName) throws Exception;
	
	int insertMelon(List<MelonVO> mList, String colName) throws Exception;
	
	List<MelonVO> getMelonList(String colName) throws Exception;
	
	List<MelonVO> getCntBySinger(String colName) throws Exception;
	
	List<MelonVO> getMelonListBySinger(String colName, String singer) throws Exception;
	
}
