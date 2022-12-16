package com.mongo.melon.mapper;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongo.melon.domain.MelonVO;

@Repository
public class MelonMapperImpl implements MelonMapper {
	
	@Inject
	private MongoTemplate mTemplate;

	@Override
	public boolean createCollection(String colName) throws Exception {
		
		return false;
	}

	@Override
	public int insertMelon(List<MelonVO> mList, String colName) throws Exception {
		Collection<MelonVO> arr = mTemplate.insert(mList, colName);
		return arr.size();
	}

	@Override
	public List<MelonVO> getMelonList(String colName) throws Exception {
		
		return this.mTemplate.findAll(MelonVO.class, colName);
	}

	@Override
	public List<MelonVO> getCntBySinger(String colName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MelonVO> getMelonListBySinger(String colName, String singer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
