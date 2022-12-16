package com.mongo.melon.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.mongo.melon.domain.CommonUtil;
import com.mongo.melon.domain.MelonVO;
import com.mongo.melon.mapper.MelonMapper;

@Service
public class MelonServiceImpl implements MelonService {
	
	@Inject
	private MelonMapper mMapper;
	
	private String url="https://www.melon.com/chart/index.htm";

	@Override
	public int crawlingMelon() throws Exception {
		List<MelonVO> mList = new ArrayList<>();
		
		Document doc = Jsoup.connect(url).get();
		
		Elements divEle=doc.select("div.service_list_song");
		Elements imgEle=divEle.select(".wrap img");
		Elements songEle=divEle.select("tr>td:nth-child(6) div.wrap_song_info");
		
		for(int i=0;i<songEle.size() ;i++) {
			Element songInfo=songEle.get(i);
			Element songImg=imgEle.get(i);
			String songTitle=songInfo.select("div.ellipsis.rank01 a").text(); 
			String songSinger=songInfo.select("div.ellipsis.rank02>a").text();
			String songUrl=songImg.attr("src"); 

			//saveAlbumImg((i+1), songUrl);
			MelonVO vo = new MelonVO();
			
			vo.setRanking(i + 1);
			vo.setCtime(CommonUtil.getDateTime("yyyyMMddhhmmss"));
			vo.setSongTitle(songTitle);
			vo.setSinger(songSinger);
			vo.setAlbumImage(songUrl);
			mList.add(vo);
		}//for--------------------------
		
		//생성할 컬렉션 이름 Melon_~
		String collectionName="Melon_" + CommonUtil.getDateTime("yyyyMMdd");
		
		return this.mMapper.insertMelon(mList, collectionName);
	}

	@Override
	public List<MelonVO> getMelonList() throws Exception {
		String collectionName="Melon_" + CommonUtil.getDateTime("yyyyMMdd");
		
		
		return this.mMapper.getMelonList(collectionName);
	}

	@Override
	public List<MelonVO> getCntBySinger() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MelonVO> getMelonListBySinger(String colName, String singer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
