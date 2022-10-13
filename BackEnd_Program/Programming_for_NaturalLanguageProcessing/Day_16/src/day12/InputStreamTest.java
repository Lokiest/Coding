package day12;

import java.io.*;

//키보드 입력 받아서 도스 콘솔에 출력
// [1] 데이터 소스 : 키보드 >>> 노드 스트림 (System.in)
// [2] 데이터 목적지 : 콘솔 >>> 노드 스트림 (System.out)

//- System.in
//- 1byte 기반 스트림
//- 노드 스트림 (키보드와 노드 연결)
//- InputStream 타입 (int read(), int read(byte[] data)

public class InputStreamTest {

	public static void main(String[] args) throws IOException {
		int n = 0;
		int count = 0;
		
		System.out.println("입 력 : ");
		while(true) {
			n = System.in.read();
			count++;
			System.out.println("n : " + n);
			if(n=='x'||n=='X') break;
		}
		System.out.println("-----------------------------------");
	}

}
