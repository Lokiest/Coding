package com.mongo.ex02;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class CrawlingTest {

	public static void main(String[] args) throws IOException{
		String url="https://www.melon.com/chart/index.htm";
		//python=> BeautifulSoup, Java=> Jsoup
		Document doc=Jsoup.connect(url).get();
		//System.out.println(doc);
		Elements divEle=doc.select("div.service_list_song");
		//앨범 이미지의 url주소를 추출해서 출력해보세요
		Elements imgEle=divEle.select(".wrap img");
		/*for(Element img:imgEle) {
			System.out.println(img.attr("src"));
		}
		System.out.println("##################################");
		*/
		//System.out.println(divEle);
		//Elements songEle=divEle.select("div.wrap_song_info");
		Elements songEle=divEle.select("tr>td:nth-child(6) div.wrap_song_info");
		System.out.println(songEle.size()+"개의 순위----------------------");
		for(int i=0;i<songEle.size() ;i++) {
			System.out.print((i+1)+" : \t");
			Element songInfo=songEle.get(i);

			Element songImg=imgEle.get(i);
//			System.out.println(songInfo);
			String songTitle=songInfo.select("div.ellipsis.rank01 a").text(); 
			System.out.print(songTitle+"\t");
			String songSinger=songInfo.select("div.ellipsis.rank02>a").text();
			System.out.print(songSinger+"\t");
			//노래 제목 추출
			String songUrl=songImg.attr("src"); 
			System.out.println(songUrl);
		}//for--------------------------
		
	}

}
