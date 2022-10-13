package day12;

import java.io.*;
import javax.swing.*;
import java.util.Date;

public class ObjectInOut2 {

	public static void main(String[] args) throws Exception {
		String fname = "src/day12/obj.txt";
		//파일 >> FileInputStream >> ObjectInputStream
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
		
		Object o1 = ois.readObject(); //jframe
		Object o2 = ois.readObject(); //date
		
		JFrame f = (JFrame)o1;
		f.setSize(200,200);
		f.setVisible(true);
		
		Date d = (Date)o2;
		System.out.println(d);
		//m1 m2 m3 읽어서 복원시키고 출력
		Member m1 = (Member)ois.readObject();
		Member m2 = (Member)ois.readObject();
		Member m3 = (Member)ois.readObject();
		
		System.out.println(m1.showInfo());
		System.out.println(m2.showInfo());
		System.out.println(m3.showInfo());
		
		ois.close();
		
	}

}
