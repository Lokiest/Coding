package day12;

import java.io.*;
//파일 읽어서 콘솔에 출력
//데이터 소스 : 파일 >> 노드스트림 fileinpurstream
//데이터 목적지 : 콘솔 >> 노드스트림 system.out

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		String fname = "src/day12/InputStreamTest3.java";
		FileInputStream fis = new FileInputStream(fname);
		int n = 0, count = 0;
		
		while((n=fis.read()) != -1) { //파일 끝에 도달하면 -1 반환
			System.out.write(n);
			count++;
		}
		
		System.out.println(count + "bytes");
		fis.close();
		System.out.close();

	}

}
