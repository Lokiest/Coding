package com.mongo.ex02;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class CrawlingTest2 {
	MongoClient mclient;
	MongoDatabase mdb;

	public static void main(String[] args) throws IOException{
		String url="https://www.melon.com/chart/index.htm";
		Document doc=Jsoup.connect(url).get();
		Elements divEle=doc.select("div.service_list_song");
		Elements imgEle=divEle.select(".wrap img");
		Elements songEle=divEle.select("tr>td:nth-child(6) div.wrap_song_info");
		
		System.out.println(songEle.size()+"개의 순위----------------------");
		
		List<MelonVO> melonArr=new ArrayList<>();
		
		for(int i=0;i<songEle.size() ;i++) {
			Element songInfo=songEle.get(i);
			Element songImg=imgEle.get(i);
			String songTitle=songInfo.select("div.ellipsis.rank01 a").text(); 
			String songSinger=songInfo.select("div.ellipsis.rank02>a").text();
			String songUrl=songImg.attr("src"); 
			//앨범 이미지를 다운로드 해보자.
			saveAlbumImg((i+1), songUrl);
			MelonVO vo=new MelonVO((i+1), songTitle, songSinger, songUrl);
			melonArr.add(vo);
		}//for--------------------------
		//몽고디비에 컬렉션 이름 "melonChart_년월일"
		new CrawlingTest2().saveMongodb(melonArr);
	}//-------------------------------
	public static synchronized void saveAlbumImg(int num, String imgUrl) {
		try {
			URL url=new URL(imgUrl);
			InputStream is=url.openStream();
			BufferedInputStream bis=new BufferedInputStream(is);
			
			File dir=new File("C:/myjava/crawling/melon_20221214");
			if(!dir.exists()) {
				dir.mkdirs();
			}
			File target=new File(dir, num+"album.jpg");
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(target));
			
			byte[] data=new byte[1024];
			int n=0;
			while((n=bis.read(data))!=-1) {
				bos.write(data,0,n);
			}
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//------------------------------------
	
	
	
	private void mappingPojo(String db) {
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
	
	//몽고디비에 100위까지 차트 정보를 저장하는 메서드
	public void saveMongodb(List<MelonVO> arr) {
		this.mappingPojo("mydb");
		String collectionName="melonChart_20221214";
		MongoCollection<MelonVO> mcol=mdb.getCollection(collectionName,MelonVO.class);
		mcol.insertMany(arr);
		System.out.println(arr.size()+"개의 도큐먼트 저장함 : 데이터베이스 : mydb, 컬렉션명: "+collectionName);		
	}//--------------------------------

}
