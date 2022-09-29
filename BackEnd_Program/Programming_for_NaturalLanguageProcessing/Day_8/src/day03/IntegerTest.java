package day03;

import javax.swing.*;
import java.util.Scanner;
import java.lang.Math;

//java.lang.Wrapper 클래스
//기본자료형을 감싸서 클래스로 만드는
//byte > Byte, short > Short, char < Character, int > Integer Long, Float, Double Boolean
public class IntegerTest {

	public static void main(String[] args) {
		//final static int MAX_VALUE : 정수형의 최대값
		//final static int MIN_VALUE : 정수형의 최소값
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		//125의 이진수값을 반환하는 메서드 찾아서 출력 toBinarySring
		//125의 8진수값을 반환하는 메서드 찾아서 출력 toHexString
		//125의 16진수값을 반환하는 메서드 찾아서 출력 toOctalString
		int a = 125;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toHexString(a));
		System.out.println(Integer.toOctalString(a));
	}

}
