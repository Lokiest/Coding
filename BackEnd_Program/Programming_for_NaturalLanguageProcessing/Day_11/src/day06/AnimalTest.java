package day06;

import javax.swing.*;

public class AnimalTest {

	public static void main(String[] args) {
		String type = JOptionPane.showInputDialog("종류 입력");
		String count = JOptionPane.showInputDialog("새끼 수 입력");
		if (type == null || count == null) return;
		// == : 기본자료형 > 값을 비교
		// 참조형 > 주소값을 비교
		//Object의 equals() 메소드 : 주소값을 비교
		//:String클래스에서 equals() 메소드 : 문자열의 내용 비교로 재정의
		
		Animal an = null;
		if (type.equals("강아지")) {
			an = new Dog();
		} else if(type.equals("고양이")) {
			an = new Cat();
		} else if(type.equals("오리")) {
			an = new Duck();
		} else {
			System.out.println("동물 x");
			return;
		}
		an.crySound();
		an.getBaby(Integer.parseInt(count));
	}

}
