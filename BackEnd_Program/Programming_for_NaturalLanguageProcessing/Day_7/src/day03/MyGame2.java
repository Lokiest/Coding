package day03;

import javax.swing.*;
import java.util.Scanner;
import java.lang.Math;

public class MyGame2 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("알파벳, 0~9 사이 수, 그외 문자 하나 입력");
		if (str == null) return;
		//String클래스의 메서드 : charAt(int i) > 문자열의 인덱스 i번째 문자를 하나 추출
		// ex) Hello >> 
//		String s = "Hello";
//		char ch = s.charAt(0);
//		System.out.println(ch);
		
		//입력 받은 문자열의 첫 문자 > 숫자면: 숫자, 알파벳 : 알파벳, 그외 : 기타
		char ch = str.charAt(0);
		String lang = "";
		if (ch >= '0' && ch <= '9') {
			lang = "숫자";
		} else if (ch >= 'A' && ch <='Z' || ch >='a' && ch <='z') {
			lang = "알파벳";
		} else {
			lang = "기타";
		}
		System.out.println(lang);
			
		
		//[2] java.lang.Character 클래스 메소드 활용해서 동일하게 해결해보기
		//숫자 판별하는 메서드 : static booelan isDigit(char ch)
		//알파벳 판별하는 메서드 : static boolean isAlphabetic(int codePoint)
		//소문자 : static boolean isLowerCase(char ch)
		//대문자 : static boolean isUpperCase(char ch)
		if (Character.isDigit(ch)) {
			System.out.print("숫자");
		} else if (Character.isAlphabetic(ch)) {
			System.out.print("알파벳");
		} else {
			System.out.print("기타");
		}
		
	}

}
