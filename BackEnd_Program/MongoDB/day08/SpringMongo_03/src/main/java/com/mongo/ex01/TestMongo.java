package com.mongo.ex01;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class TestMongo {

	public static void main(String[] args) {
		String db="mydb";
		String table="posts";
		MongoClient mongo_client=null;
		MongoDatabase mongodb=null;
		MongoCollection<Document> collection=null;
		
		mongo_client=MongoClients.create("mongodb://localhost:27017");
		mongodb=mongo_client.getDatabase(db);
		
		collection=mongodb.getCollection(table);
		System.out.println(table+"컬렉션 생성 성공!!");
		
		Document doc=new Document();
		doc.append("author", "홍길동");
		doc.append("title", "몽고디비 테스트 합니다");
		doc.append("wdate", "2022-12-12");
		
		collection.insertOne(doc);
		System.out.println("posts 컬렉션에 도큐먼트 삽입 성공!!");
		
		mongo_client.close();
	}

}




