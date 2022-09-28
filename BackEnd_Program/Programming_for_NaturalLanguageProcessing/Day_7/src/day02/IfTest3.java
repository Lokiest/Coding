package day02;
//java 11버전 이후 : java.base 모듈만 사용 가능
import javax.swing.JOptionPane; //java.desktop 모듈 필요

public class IfTest3 {

	public static void main(String[] args) {
		String kor = JOptionPane.showInputDialog("국어 점수 입력");
		String eng = JOptionPane.showInputDialog("영어 점수 입력");
		
		if(kor == null || eng == null) {
			System.out.println("값 입력");
			return;
		}
		System.out.println(kor + " / " + eng);
		
		//java.lang.Integer 클래스의 메서드
		//public static int parseInt(String s) : 문자열 s를 정수로 변환해서 반환
		//static메서드(클래스 메서드) : "클래스명.메서드명()" 으로 접근해야함
		int total = Integer.parseInt(kor) + Integer.parseInt(eng);
		System.out.println("합계 : " + total);
		
		//평균 구해서 학점 출력
		double avg = total / 2;
		if (avg >= 90) {
			System.out.println("A");
		}
		else if (avg >= 80) {
			System.out.println("B");
		}
		else if (avg >= 70) {
			System.out.println("C");
			
		}
		else {
			System.out.println("F");
		}
	}

}
