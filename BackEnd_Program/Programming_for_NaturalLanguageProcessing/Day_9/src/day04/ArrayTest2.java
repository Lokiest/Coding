package day04;

public class ArrayTest2 {

	public static void main(String[] args) {
		int a[][] = new int[3][2];
		System.out.println(a[0][0]);

		a[0][0] = 10;
		a[0][1] = 20;
		a[1][0] = 30;
		a[1][1] = 40;
		a[2][0] = 50;
		a[2][1] = 60;
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.println(a[i][j]);
			}
		}
		
		short b[][] = {{10,11}, {-3,-2,-1}, {20}};
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		for(short[] s:b) {
			for(short s2:s) {
				System.out.print(s2 + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
		
		char[][] ch = new char[3][];
		System.out.println(ch.length);
		
		ch[0] = new char[2];
		ch[1] = new char[4];
		ch[2] = new char[1];
		
		ch[0][0] = 'H';
		ch[0][1] = 'i';
		ch[1][0] = 'j';
		ch[1][1] = 'a';
		ch[1][2] = 'v';
		ch[1][3] = 'a';
		
		for(char[] c:ch) {
			for (char c2 : c) {
				System.out.print(c2);
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

}
