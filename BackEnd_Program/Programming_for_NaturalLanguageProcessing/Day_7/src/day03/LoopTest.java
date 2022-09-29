package day03;

import javax.swing.*;

public class LoopTest {

	public static void main(String[] args) {
		String dan = JOptionPane.showInputDialog("구구단 몇 단?");
		//[1] 입력받은 단의 구구단 while문으로 출력
		int i = Integer.parseInt(dan);
		int a = 1;
		while(a<10) {
			System.out.println(i+" x "+ a +" = "+ (i * a));
			a++;
		}
		
		//[2] 구구단 전체 출력
		int y = 1;
		while (y < 10) {
			int x = 2;
			while (x < 10) {
				System.out.printf("%d x %d = %d  ", x, y, (x*y));
				x++;
			}
			y++;
			System.out.println();
		}
		
	}
}
		
