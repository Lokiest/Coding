package day03;

import java.util.Scanner;
import java.lang.Math;

public class MyGame {

	public static void startGame() {
		Scanner scan = new Scanner(System.in);

		int answer = (int) (Math.random() * 99 + 1);
		System.out.println("치트키 : " + answer);

		int count = 1;
		while (count <= 7) {
			System.out.print(count + ". 1 ~ 100 사이의 정수를 입력하세요 : ");
			int myAnswer = scan.nextInt();

			if (answer == myAnswer) {
				System.out.println("정답입니다!");
				break;
			}
			if (count == 7) {
				System.out.println("기회를 모두 소진하셨습니다. 다음기회에...");
				break;
			}

			if (answer < myAnswer) {
				System.out.println("down!");
			} else if (answer > myAnswer) {
				System.out.println("up!");
			}
			count += 1;
		}

}
	public static void main(String[] args) {
		MyGame.startGame();
	}
}
