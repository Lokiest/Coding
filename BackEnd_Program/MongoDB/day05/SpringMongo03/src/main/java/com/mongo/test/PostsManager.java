package com.mongo.test;

import static com.mongodb.client.model.Filters.eq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

public class PostsManager {
	
	MongoClient mclient;
	MongoDatabase mongodb;
	MongoCollection<Document> mcol;
	Scanner sc = new Scanner(System.in);
	
	public PostsManager() {
		mclient = MongoClients.create("mongodb://localhost:27017");
		mongodb = mclient.getDatabase("mydb");
		mcol = mongodb.getCollection("posts");
		System.out.println("몽고디비 mydb 데이터베이스 접속 완료");
	}
	
	public void close() {
		if(mclient!=null) {
			mclient.close();
		}
	}
	
	public void insertPosts() {
		System.out.print("author : ");
		String author = sc.nextLine();
		System.out.println("Post title insert : ");
		String title = sc.nextLine();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String wdate = sdf.format(today);
		
		Document doc = new Document();
		doc.append("author", author)
			.append("title", title)
			.append("wdate", wdate);
		
		InsertOneResult res = mcol.insertOne(doc);
		System.out.println(res.getInsertedId() + " document created");
	}

	public static void main(String[] args) {
		
		PostsManager app = new PostsManager();
//		app.insertPosts();
		System.out.println("bring the post list --------");
		app.selectPostsAll();
		
		app.updatePosts();
		System.out.println("bring the post list2 --------");
		app.selectPostsAll2();
//		app.deletePosts();

	}
	
	public void updatePosts() {
		System.out.println("select author to update : ");
		String author = sc.nextLine();
		System.out.println("update title : ");
		String title = sc.nextLine();
		System.out.println();
		
		Bson query = eq("author", author);
		Bson edit1 = Updates.combine(Updates.set("title", title));
		UpdateResult res = mcol.updateOne(query, edit1);
		long n = res.getModifiedCount();
		System.out.println(n + " documents updated");
	}
	
	public void selectPostsAll2() {
		FindIterable<Document> cr = mcol.find();
		MongoCursor<Document> mcr = cr.iterator();
		while(mcr.hasNext()) {
			Document doc = mcr.next();
			String author = doc.getString("author");
			String title = doc.getString("title");
			String wdate = doc.getString("wdate");
			System.out.println(author + "\t" + title + "\t" + wdate);
		}
		
	}
	
	public void deletePosts() {
		System.out.println("insert author to delete : ");
		String author = sc.nextLine();
		
//		DeleteResult res =  mcol.deleteOne(eq("author", author));
		DeleteResult res = mcol.deleteMany(eq("author", author));
		long n = res.getDeletedCount();
		System.out.println(n + " documents deleted");
	}

	private void selectPostsAll() {
		
		FindIterable<Document> cursor = mcol.find();
		for(Document doc : cursor) {
			String title = doc.get("title").toString();
//			System.out.println(title);
			System.out.println(doc.toJson()); // json 문자열을 반환
		}
		
	}

}
