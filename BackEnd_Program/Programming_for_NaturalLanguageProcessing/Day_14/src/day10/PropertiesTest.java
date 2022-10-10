package day10;

import java.util.*;
import java.io.*;

public class PropertiesTest {

	public static void main(String[] args) throws FileNotFoundException, Exception {

//		String loc="C:\\Users\\wngh0\\eclipse-workspace\\Begin\\src\\day10\\database.properties";
		String loc = "src/day10/database.properties";
		Properties prop = new Properties();
		InputStream is = new FileInputStream(loc);
		prop.load(is);
		is.close();
		
		String type = prop.getProperty("DbType");
		System.out.println(type);
		
		String url = prop.getProperty("DbUrl");
		System.out.println(url);
		
		System.out.println(prop.getProperty("DbUser") + " / " + prop.getProperty("DbPwd"));
		System.out.println(prop.getProperty("msg", "Welcome"));
	}

}
