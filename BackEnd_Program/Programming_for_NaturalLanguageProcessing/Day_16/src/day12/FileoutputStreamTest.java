package day12;

import java.io.*;
/*[실습]키보드로 입력받은 내용을 파일(C:/MyJava/Workspace/Begin/result.txt)에 저장하는 기능
 * -------------------------------------
 * 데이터 소스 : 키보드===>노드스트림(System.in)
 * 데이터목적지: 파일 ===>노드스트림(FileOutputStream)
 * */


public class FileOutputStreamTest {

	public static void main(String[] args) throws Exception {
		String fname = "C:\\Users\\wngh0\\eclipse-workspace\\Begin\\result.txt";
		//키보드 입력받아 FileoutputStream 객체로 write()
		FileOutputStream fos = new FileOutputStream(fname, true);
		//true를 주면 기존 파일에 덧붙이기
		
		int n = 0, count = 0, total = 0;
		byte[] data = new byte[100];
		while((n = System.in.read(data)) != -1) {
			fos.write(data,0,n);
			fos.flush(); //스트림에 남아있는 데이터를 밀어내기
			total += n;
		}
		System.out.println(fname + " " + total);
		fos.close();

	}

}
