package day12;

import java.io.*;

//System.out : PrintStream
// - 1byte기반 스트림
// - 노드 스트림 (콘솔과 노드 연결)
// - print(), println(), printf()
// - write(int n )

public class InputStreamTest2 {

	public static void main(String[] args) throws IOException {
		
		int n = 0, count = 0;
		System.out.println("입 력 : ");
		while((n = System.in.read()) != -1) {
			System.out.println(n);
			count++;
		}
		System.out.println("-------------------------");
		System.out.println(count + "byte reading");
		System.out.println("-------------------------");
		System.in.close();
		System.out.close();
	}

}
