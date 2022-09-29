package day03;

import java.util.Scanner;

public class HomeWork4 {

	public static void main(String[] args) {
		// 3번 문제
		Scanner scan = new Scanner(System.in);
		
		int rNum = (int) (Math.random() * 2);
		rNum = rNum + 1;
		int win = 0;
		while (true) {
			System.out.println("*********가위바위보*********");
			System.out.println("[1]가위 [2]바위 [3]보 [9]종료");
			System.out.println("************************");
			System.out.print("입력하세요 => ");
			int sel = scan.nextInt();
			
			if(sel == 9) {
				System.out.println("종료되었습니다.");
				break;
			}
			System.out.println("당 신 : " + sel);
			System.out.println("컴퓨터 : " + rNum);
			
			if(sel == 1) {
				if(rNum == 1) {
					win = 0;
				} else if(rNum == 2) {
					win = 1;
				} else if(rNum == 3) {
					win = 2;
				}
			} else if(sel == 2) {
				if(rNum == 1) {
					win = 2;
				} else if(rNum == 2) {
					win = 0;
				} else if(rNum == 3) {
					win = 1;
				}
			} else if(sel == 3) {
				if(rNum == 1) {
					win = 1;
				} else if(rNum == 2) {
					win = 2;
				} else if(rNum == 3) {
					win = 0;
				}
			}
			
			if(win == 0) {
				System.out.println("비겼습니다!");
			} else if(win == 1) {
				System.out.println("졌습니다!");
			} else if(win == 2) {
				System.out.println("이겼습니다!");
			}
		}
	}
}


