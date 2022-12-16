package com.mongo.ex01;

//static import���� �̿��Ͽ� Ŭ�������� �����ϰ� ����غ���.
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

	// Bson������ Java Pojo��ü�� �����ϴ� �޼���==> �ڵ� ������Ʈ���� �ʿ���
	/*
	 * POJO�� CodecRegistry��ȯ�� ó���� �ڵ��� �����ϵ��� ����=> �������� �⺻ �ڵ� ������Ʈ�� PojoCodecProvider��
	 * �ڵ����� �����ϵ��� ������ ������Ʈ���� ����
	 */
	private void mappingPojo() {
		ConnectionString conStr = new ConnectionString("mongodb://localhost:27017");
		CodecRegistry pojoCodec = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		// �⺻ �ڵ� ������Ʈ�� PojoCodecProvider�� �ڵ����� �����ϵ��� ����
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodec);
		// �̸� ������ ������ ���� ���� �⺻ �ڵ�������Ʈ���� ������ �Ѵ�
		// �����񿡼� ������ BSon�����͸� �ڹ� POJO�� ���ڵ�,���ڵ��ϵ��� �����ϴ� �۾�
		// Bson������ Java Pojo��ü�� �����ϴ� �޼���==> �ڵ� ������Ʈ���� �ʿ���		
		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(conStr)
				.codecRegistry(codecRegistry).build();
		//������ ���� ���ڿ��� �����ϰ�, �ڵ�������Ʈ���� �����ѵ� �����Ͽ� ����Ŭ���̾�Ʈ ���� ��ü�� ��´�.
		mclient = MongoClients.create(clientSettings);
		//����Ŭ���̾�Ʈ ��ü�� �����ѵ� �̸� ���� �������ͺ��̽��� ���´�.
		mdb = mclient.getDatabase(db);
	}// ----------------------------------


	public void insertOne() {
		mcol = mdb.getCollection(table, PostVO.class);
		PostVO vo = new PostVO(null, "Kim", "���õ� ���� �����̾��", "2022-12-13");
		mcol.insertOne(vo);
		System.out.println(vo.getTitle() + "���� ����߽��ϴ�.");
	}// ---------------------------
	
	public void insertMany() {
		mcol = mdb.getCollection(table,PostVO.class);
		List<PostVO> postsArr=Arrays.asList(
				new PostVO(null,"Scott","�߿� �����Դϴ�","2022-12-14"),
				new PostVO(null,"James","���� �����ϼ���","2022-12-14"),
				new PostVO(null,"King","�˰ڽ��ϴ�","2022-12-14")
				);
		
		InsertManyResult res=mcol.insertMany(postsArr);
		int n=res.getInsertedIds().size();
		System.out.println(n+"���� ��ť��Ʈ ���� �Ϸ�");
	}// ---------------------------
	public void findAll() {
		mcol=mdb.getCollection(table,PostVO.class);
		FindIterable<PostVO> cursor=mcol.find();
		MongoCursor<PostVO> mcr=cursor.iterator();
		List<PostVO> arr=new ArrayList<>();
		System.out.println("--------POSTS ���-----------");
		while(mcr.hasNext()) {
			PostVO vo=mcr.next();
			arr.add(vo);
			System.out.println(vo.getTitle()+"\t"+vo.getAuthor()+"\t"+vo.getWdate());
		}
		//System.out.println(arr);
		System.out.println("-------------------------");
	}//------------------------------
	public void findByAuthor() {
		System.out.println("�˻��� �ۼ��ڸ� �Է�: ");
		String name=sc.nextLine();
		mcol=mdb.getCollection(table,PostVO.class);
		//���� ��ü�� �����ؼ� ���� ������ ��ť��Ʈ�� ��������.
		Bson query=Filters.eq("author", name);
		FindIterable<PostVO> cursor=mcol.find(query);
		//PostVO vo1=cursor.first();
		System.out.println("--�˻���: "+name+"------------");
		for(PostVO vo:cursor) {
			System.out.println(vo.getAuthor()+"\t"+vo.getTitle());
		}
		System.out.println("-----------------------------");
	}//------------------------------
	
	public void deleteOne() {
		System.out.println("������ ���� �ۼ��ڸ� �Է�: ");
		String name=sc.nextLine();
		//DeleteResult res=mcol.deleteOne(Filters.eq("author",name));
		DeleteResult res=mcol.deleteMany(Filters.eq("author", name));
		System.out.println(res.getDeletedCount()+"���� ��ť��Ʈ�� ������");
	}//------------------------------
	
	public void updateOne() {
		System.out.println("������ ���� �ۼ��ڸ��� �Է�: ");
		String name=sc.nextLine();
		System.out.println("������ �� ����: ");
		String title=sc.nextLine();
		System.out.println("������ ���� �ۼ���[yyyy-MM-dd]: ");
		String wdate=sc.nextLine();
		
		mcol=mdb.getCollection(table,PostVO.class);
		
		//UpdateResult res=mcol.updateOne(Filters.eq("author",name), 
		//								Updates.combine(Updates.set("title", title), Updates.set("wdate", wdate)));
		
		UpdateResult res=mcol.updateOne(eq("author", name), combine(set("title",title), set("wdate", wdate)));
		
		long n=res.getModifiedCount();
		System.out.println(n+"���� ��ť��Ʈ�� �����Ǿ����ϴ�");
	}//---------------------------------------------
	
	public void updateMany() {
		System.out.println("�������� ���� �ۼ��ڸ� �Է�: ");
		String name=sc.nextLine();
		System.out.println("������ �� ����: ");
		String title=sc.nextLine();
		System.out.println("������ ���� �ۼ���[yyyy-MM-dd]: ");
		String wdate=sc.nextLine();
		
		mcol=mdb.getCollection(table,PostVO.class);
		//UpdateResult res=mcol.updateMany(ne("author", name), combine(set("title",title)));
		UpdateResult res=mcol.updateMany(not(eq("author",name)), combine(set("title",title),set("wdate",wdate)));
		long n=res.getModifiedCount();
		System.out.println(n+"���� ��ť��Ʈ ������");
	}//------------------------------------
	public void replaceOne() {
		mcol=mdb.getCollection(table,PostVO.class);
		PostVO vo=new PostVO(null,"��浿","replaceOne���� Posts������ �����մϴ�","2022-12-14");
		UpdateResult res=mcol.replaceOne(eq("author",vo.getAuthor()), vo);
		System.out.println(res.getModifiedCount()+"���� ��ť��Ʈ�� ��ü�Ǿ����ϴ�");
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
		System.out.println("--���� ó���� --------");
		app.findAll();
		
		
	}

}//////////////////////////////////////////



