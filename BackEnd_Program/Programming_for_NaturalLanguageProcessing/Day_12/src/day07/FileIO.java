package day07;

import java.io.*;
import javax.swing.*;
//파일을 읽어서 콘솔에 출력하는 프로그램 구현
//[1] try catch
//[2] throws

public class FileIO {
	
	public static String reading(String fileName) {
		System.out.println("-----" + fileName + "-----");
		String contents = "";
		FileReader fr = null;
		char[] data = new char[1000];
		try {
			fr = new FileReader(fileName);
			//파일과 노드 연결
			
			fr.read(data, 0, 1000);
			//파일 읽어서 그 내용을 data배열에 담음
			
			fr.close();
			//노드 연결 종료 (파일 리소스 반환)
		} catch (FileNotFoundException e) {
			System.out.println("파일 찾을 수 없음");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 읽을 수 없음");
		}
		
		contents = new String(data);
		
		return contents;
	}

	public static void main(String[] args) {

		String fname = JOptionPane.showInputDialog("파일명 입력 : ");
		if (fname == null) return;
		String str = reading(fname);
		System.out.println(str);
		
	}

}
