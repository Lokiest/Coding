package day12;

//ObjectOutputStream
//자바의 다양한 자료형과 객체를 저장할 수 있는 스트림
// - 1byte기반 스트림
// - 필터 스트림

import java.io.*;
import javax.swing.*;
import java.util.Date;

public class ObjectInOut {

	public static void main(String[] args) throws Exception {
		String fname = "src/day12/obj2.txt";
		FileOutputStream fos = new FileOutputStream(fname);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		JFrame f = new JFrame("오브젝트 스트림");
		
		oos.writeObject(f); //객체를 파일에 쓰기
		oos.flush();
		
		Date d = new Date();
		oos.writeObject(d);
		oos.flush();
		
		Member m1 = new Member("~~~", "111", "010");
		Member m2 = new Member("@@@", "222", "999");
		Member m3 = new Member("###", "333", "888");
		
		oos.writeObject(m1);
		oos.flush();
		oos.writeObject(m2);
		oos.flush();
		oos.writeObject(m3);
		oos.flush();
		
		System.out.println(fname + " 저장 완료");
		oos.close();
		fos.close();

	}

}
