package day04;

import java.util.*;

public class MyGame {
	
	public void menu() {
		System.out.println("*******MyGame v1.1**********");
		System.out.println("1.가위 2.바위 3.보 9.종료");
		System.out.println("****************************");
		System.out.println("입력하세요 => ");
		System.out.println("****************************");

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyGame my = new MyGame();
		
		for(;;) {
			my.menu();
			int num = sc.nextInt();
			if (num == 9) {
				System.out.println("The End");
//				break;
				System.exit(0);
			}
			if (num < 1 || num>3) {
				System.out.println("입력 오류");
				continue;
			} 
//			System.out.println(">> 진 행 중 <<");
			
			int com = (int)(Math.random()*3 +1);
			my.gameResult(num, com);
		}
		
		
		
	}//MAIN
	
	public void gameResult(int num, int com) {
		String[] arr = {"가위","바위","보"};
		
		System.out.println("나 : " + num + " " + arr[num-1]);
		System.out.println("너 : " + com + " " + arr[com-1]);
		
		if(num == com) {
			System.out.println("비김");
		} else if ((num==1&&com==3) || (num==2&&com==1)|| (num==3&&com==2)) {
			System.out.println("이김");
		} else {
			System.out.println("짐");
		}
	}

}
