package day04;

import java.util.Arrays;
import java.util.Scanner;

//회문문자열을 재귀함수를 이용해 판별하는 프로그램을 작성하세요: [실습]=>슬랙에 올리기
//Arrays.copyOfRange(배열, start, end); 배열 start 인덱스 에서 end-1까지 사본을 만들어 반환함
public class PallindromeRecur {
	
	public static boolean isPallindrome(char[] ch) {
		if (ch.length <= 1) {
			return true;
		}
		if (ch[0] == ch[ch.length - 1]) {
			return isPallindrome(Arrays.copyOfRange(ch, 1, ch.length - 1));
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("문자열 입력 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(isPallindrome(str.toCharArray()));
	}
	
}
