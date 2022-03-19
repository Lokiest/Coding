import java.io.FileWriter;
import java.io.IOException;

public class OthersApp {

	public static void main(String[] args) throws IOException {
		//class : System, Math, FileWriter
		//instance : a1, a2
		System.out.println(Math.abs(-33));
		System.out.println(Math.PI);
		System.out.println(Math.cos(0));
		
		FileWriter a1 = new FileWriter("TXT.txt");
		a1.write("Hi");
		a1.write(" Tim");
		a1.close();
		
		FileWriter a2 = new FileWriter("TXT2.txt");
		a2.write("Hi");
		a2.write(" Tim");
		a2.close();
		
	}

}
