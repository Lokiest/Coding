package com.mongo.melon.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="")
public class MelonVO {
	
	@Id
	private String id;
	private int ranking;
	private String songTitle;
	private String singer;
	private String ctime; //수집된 시간 정보
	private String albumImage;
	
	//private int cntBySinger; //차트에 등록된 가수별 노래수
	
}
