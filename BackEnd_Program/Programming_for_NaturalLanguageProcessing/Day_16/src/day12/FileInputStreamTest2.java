package day12;

import java.io.*;
//파일 읽어서 콘솔에 출력
//데이터 소스 : 파일 >> 노드스트림 fileinpurstream
//데이터 목적지 : 콘솔 >> 노드스트림 system.out

public class FileInputStreamTest2 {

	public static void main(String[] args) throws IOException {
		String fname = "src/day12/InputStreamTest3.java";
		FileInputStream fis = new FileInputStream(fname);
		
		//배열에 담아서 읽고 출력
		byte[] data = new byte[1024];
		int n = 0, count = 0, total = 0;
		while((n = fis.read(data))!= -1) {
			System.out.write(data, 0,n);
			count++;
			total += n;
		}
		System.out.println(count + " " + total);
		fis.close();
		System.out.close();

	}

}
