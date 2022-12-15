package com.mongo.ex01;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
	
	private ObjectId id;
	
	@BsonProperty(value="author")
	private String author;
	
	@BsonProperty(value="title")
	private String title;
	
	@BsonProperty(value="wdate")
	private String wdate;

}
