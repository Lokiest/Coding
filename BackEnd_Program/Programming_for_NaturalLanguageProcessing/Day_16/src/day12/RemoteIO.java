package day12;

import java.io.*;
import java.net.*;

public class RemoteIO {

	public static void main(String[] args) throws IOException {

		String str = "https://www.naver.com/";
		URL url = new URL(str);
		URLConnection con = url.openConnection();
		// 해당 url로 접속
		InputStream is = con.getInputStream();
		// BufferedReader로 필터링해서 printwriter로 콘솔에 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
		
		String line = "";
		int count = 0;
		while ((line = br.readLine()) != null) {
			pw.println(++count + " : " + line);
		}
		pw.close();
		br.close();

	}

}
