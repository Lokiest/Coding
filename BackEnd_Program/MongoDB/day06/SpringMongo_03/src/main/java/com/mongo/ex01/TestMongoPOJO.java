package com.mongo.ex01;

//static import문을 이용하여 클래스명을 생략하고 사용해보자.
//eq(), gt(), lt(), gte()...
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.not;
//combine(), set()...
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.UpdateResult;
//http://www.bjpowernode.com/api/mongo/


public class TestMongoPOJO {

	String db = "mydb";
	String table = "posts";
	MongoClient mclient;
	MongoDatabase mdb;
	MongoCollection<PostVO> mcol;
	Scanner sc=new Scanner(System.in);

	public TestMongoPOJO() {
		this.mappingPojo();
	}

	// Bson문서를 Java Pojo객체에 매핑하는 메서드==> 코덱 레지스트리가 필요함
	/*
	 * POJO에 CodecRegistry변환을 처리할 코덱을 포함하도록 구성=> 다음에는 기본 코덱 레지스트리 PojoCodecProvider를
	 * 자동으로 생성하도록 구성된 레지스트리와 결합
	 */
	private void mappingPojo() {
		ConnectionString conStr = new ConnectionString("mongodb://localhost:27017");
		CodecRegistry pojoCodec = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		// 기본 코덱 레지스트리 PojoCodecProvider를 자동으로 생성하도록 구성
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodec);
		// 이를 몽고디비 셋팅을 통해 얻은 기본 코덱레지스트리와 결합을 한다
		// 몽고디비에서 가져온 BSon데이터를 자바 POJO로 인코딩,디코딩하도록 설정하는 작업
		// Bson문서를 Java Pojo객체에 매핑하는 메서드==> 코덱 레지스트리가 필요함		
		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(conStr)
				.codecRegistry(codecRegistry).build();
		//몽고디비 연결 문자열을 적용하고, 코덱레지스트리를 설정한뒤 빌드하여 몽고클라이언트 셋팅 객체를 얻는다.
		mclient = MongoClients.create(clientSettings);
		//몽고클라이언트 객체를 생성한뒤 이를 통해 몽고데이터베이스를 얻어온다.
		mdb = mclient.getDatabase(db);
	}// ----------------------------------


	public void insertOne() {
		mcol = mdb.getCollection(table, PostVO.class);
		PostVO vo = new PostVO(null, "Kim", "오늘도 수고 많으셨어요", "2022-12-13");
		mcol.insertOne(vo);
		System.out.println(vo.getTitle() + "글을 등록했습니다.");
	}// ---------------------------
	
	public void insertMany() {
		mcol = mdb.getCollection(table,PostVO.class);
		List<PostVO> postsArr=Arrays.asList(
				new PostVO(null,"Scott","추운 날씨입니다","2022-12-14"),
				new PostVO(null,"James","감기 조심하세요","2022-12-14"),
				new PostVO(null,"King","알겠습니다","2022-12-14")
				);
		
		InsertManyResult res=mcol.insertMany(postsArr);
		int n=res.getInsertedIds().size();
		System.out.println(n+"개의 도큐먼트 삽입 완료");
	}// ---------------------------
	public void findAll() {
		mcol=mdb.getCollection(table,PostVO.class);
		FindIterable<PostVO> cursor=mcol.find();
		MongoCursor<PostVO> mcr=cursor.iterator();
		List<PostVO> arr=new ArrayList<>();
		System.out.println("--------POSTS 목록-----------");
		while(mcr.hasNext()) {
			PostVO vo=mcr.next();
			arr.add(vo);
			System.out.println(vo.getTitle()+"\t"+vo.getAuthor()+"\t"+vo.getWdate());
		}
		//System.out.println(arr);
		System.out.println("-------------------------");
	}//------------------------------
	public void findByAuthor() {
		System.out.println("검색할 작성자명 입력: ");
		String name=sc.nextLine();
		mcol=mdb.getCollection(table,PostVO.class);
		//필터 객체를 전달해서 같은 조건의 도큐먼트를 가져오자.
		Bson query=Filters.eq("author", name);
		FindIterable<PostVO> cursor=mcol.find(query);
		//PostVO vo1=cursor.first();
		System.out.println("--검색어: "+name+"------------");
		for(PostVO vo:cursor) {
			System.out.println(vo.getAuthor()+"\t"+vo.getTitle());
		}
		System.out.println("-----------------------------");
	}//------------------------------
	
	public void deleteOne() {
		System.out.println("삭제할 글의 작성자명 입력: ");
		String name=sc.nextLine();
		//DeleteResult res=mcol.deleteOne(Filters.eq("author",name));
		DeleteResult res=mcol.deleteMany(Filters.eq("author", name));
		System.out.println(res.getDeletedCount()+"개의 도큐먼트가 삭제됨");
	}//------------------------------
	
	public void updateOne() {
		System.out.println("수정할 글의 작성자명을 입력: ");
		String name=sc.nextLine();
		System.out.println("수정할 글 제목: ");
		String title=sc.nextLine();
		System.out.println("수정할 글의 작성일[yyyy-MM-dd]: ");
		String wdate=sc.nextLine();
		
		mcol=mdb.getCollection(table,PostVO.class);
		
		//UpdateResult res=mcol.updateOne(Filters.eq("author",name), 
		//								Updates.combine(Updates.set("title", title), Updates.set("wdate", wdate)));
		
		UpdateResult res=mcol.updateOne(eq("author", name), combine(set("title",title), set("wdate", wdate)));
		
		long n=res.getModifiedCount();
		System.out.println(n+"개의 도큐먼트가 수정되었습니다");
	}//---------------------------------------------
	
	public void updateMany() {
		System.out.println("수정하지 않을 작성자명 입력: ");
		String name=sc.nextLine();
		System.out.println("수정할 글 제목: ");
		String title=sc.nextLine();
		System.out.println("수정할 글의 작성일[yyyy-MM-dd]: ");
		String wdate=sc.nextLine();
		
		mcol=mdb.getCollection(table,PostVO.class);
		//UpdateResult res=mcol.updateMany(ne("author", name), combine(set("title",title)));
		UpdateResult res=mcol.updateMany(not(eq("author",name)), combine(set("title",title),set("wdate",wdate)));
		long n=res.getModifiedCount();
		System.out.println(n+"개의 도큐먼트 수정됨");
	}//------------------------------------
	public void replaceOne() {
		mcol=mdb.getCollection(table,PostVO.class);
		PostVO vo=new PostVO(null,"김길동","replaceOne으로 Posts내용을 변경합니다","2022-12-14");
		UpdateResult res=mcol.replaceOne(eq("author",vo.getAuthor()), vo);
		System.out.println(res.getModifiedCount()+"개의 도큐먼트가 교체되었습니다");
	}//------------------------------------
	
	public void findOneAndReplace() {
		mcol=mdb.getCollection(table,PostVO.class);
		FindIterable<PostVO> cursor=mcol.find(eq("author","King"));
		ObjectId id=cursor.first().getId();
		System.out.println("_id: "+id);
		PostVO pvo=mcol.findOneAndReplace(eq("_id",id), new PostVO(id,"김수정","findAndReplace....","2022-12-15"));
		//pvo: 예전에 썼던 글이 반환된다.
		System.out.println("pvo: "+pvo);
		
	}//------------------------------------

	public static void main(String[] args) {
		TestMongoPOJO app = new TestMongoPOJO();
		//app.insertOne();
		//app.insertMany();
		app.findAll();
		//app.findByAuthor();
		//app.deleteOne();
		//app.updateOne();
		//app.updateMany();
		//app.replaceOne();
		app.findOneAndReplace();
		System.out.println("--수정 처리후 --------");
		app.findAll();
		
		
	}

}//////////////////////////////////////////



