package day12;

import java.io.*;

public class ImageCopy {

	public static void main(String[] args) throws Exception {

		String fname = "image/1.png";
		String target= "copy.png";

		FileInputStream fis = new FileInputStream(fname);
		byte data[] = new byte[1000];
		FileOutputStream fos = new FileOutputStream(target);
		int n = 0, count = 0, total = 0;
		while((n=fis.read(data)) != -1) {
			fos.write(data,0,n);
			fos.flush();
			total += n;
		}
		System.out.println();
		fos.close();
	}

}
