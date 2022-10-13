package day12;

import java.io.*;
import javax.swing.*;

public class FileReaderWriterTest {

	public static void main(String[] args) throws Exception {
		String file = JOptionPane.showInputDialog("읽을 파일명 입력 : ");
		if(file == null) return;
		
		FileReader fr = new FileReader(file);
		FileWriter fw = new FileWriter("src/day12/copy4.txt", true);
		//src/day12/ObjectInOut.java
		
		File f = new File(file); //파일 객체
		long fsize = f.length(); //파일 크기를 반환
		System.out.println("읽을 파일 크기 : " + fsize);
		
		int n = 0;
		char[] data = new char[1000];
		while((n=fr.read(data)) != -1) {
			fw.write(data,0,n);
			fw.flush();
		}
		System.out.println("copy");
		fw.close();
		fr.close();
		
	}

}
