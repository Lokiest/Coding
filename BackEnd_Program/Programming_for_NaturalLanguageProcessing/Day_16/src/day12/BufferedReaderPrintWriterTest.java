package day12;

import java.io.*;
//파일 읽되 라인단뒤로 읽어서 앞에 줄번호를 붙여 콘솔에 출력

public class BufferedReaderPrintWriterTest {

	public static void main(String[] args) throws Exception{

		String fname = "src/day12/BufferedReaderWriterTest.java";
		BufferedReader br = new BufferedReader(new FileReader(fname));
		PrintWriter pw = new PrintWriter(System.out, true);
		
		String line = "";
		int count = 0;
		while((line = br.readLine()) != null) {
//			pw.write(++count + ": " + line + "\n");
//			pw.flush();
			pw.println(++count + ": " + line); // 자동 플러시
		}
		pw.close();
		br.close();

	}

}
