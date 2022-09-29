package day04;

public class ArrayTest3 {

	public static void main(String[] args) {
		//[1] String 유형을 저장하는 2차원 배열선언, 초기화
		//[2] for 이용해서 모두 소문자로
		String a[][] = new String[2][2];
		a[0][0] = "AB";
		a[0][1] = "BA";
		a[1][0] = "CD";
		a[1][1] = "DC";
		for (String[] s:a) {
			for (String s2:s) {
				System.out.print(s2.toLowerCase());
			}
			System.out.println();
		}
	
	/* 문제 2] 2차원 배열에 다음의 값을 저장하되,
	  for루프를 이용해 저장하자.
	  그런 뒤, 저장된 값들을 출력해봅시다.
	  1 0 0 0 0
	  0 1 0 0 0
	  0 0 1 0 0
	  0 0 0 1 0
	  0 0 0 0 1
	 */
		int b[][] = new int[5][5];
		for (int i =0;i<b.length;i++) {
			for (int j=0;j<b[i].length;j++) {
				if (i == j) {
					b[i][j] = 1;
				}
			}
		}
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
		
		int c[][] = new int[5][5];
		int count = 0;
		int x = 0, y = 0;
		
		for(int k=0;k<2;k++) {
			for (int i=0;i<4-2*k;i++) {
				c[y+k][x+k] = ++count;
				x++;
			}
			
			if(x+y+2*k==4) {
				for(int i =0;i<4-2*k;i++) {
					c[y+k][x+k] = ++count;
					y++;
				}
			}
			
			if (x==y) {
				for(int i =0;i<4-2*k;i++) {
					c[y+k][x+k] = ++count;
					x--;
				}
			}
			
			if (x+y+2*k==4) {
				for(int i =0;i<4-2*k;i++) {
					c[y+k][x+k] = ++count;
					y--;
				}
			}
		}
		c[2][2] = ++count;
		
		
		for (int i=0;i<c.length;i++) {
			for(int j = 0;j<c[i].length;j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
		
		
	}

}
