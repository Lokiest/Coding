package day12;

import java.io.*;

public class InputStreamTest3 {

	public static void main(String[] args) throws IOException{
		byte[] data = new byte[6];
		int n = 0, count = 0, total = 0;
		System.out.println("입 력 : ");
		while((n = System.in.read(data)) != -1) {
			//입력 받은 데이터는 data배열에 담긴다
			//n을 내보내면 안되고
//			System.out.write(data); >> 쓰레기 값이 나올 수 있음
			System.out.write(data,0,n);
			count++;
			total += n; //입력받은 바이트 수
		}
		System.out.println("------------------");
		System.out.println(total + "bytes");
		System.in.close();
		System.out.close();
 
	}

}
