package day02;

import javax.swing.JOptionPane;

public class SwitchTest {

	public static void main(String[] args) {
		// 월 입력
		// 일 수 알려주는 프로그램
		//swtich에서 사용하는 변수 또는 수식은 int형 이하의 자료형이나 String만 가능
		String month=JOptionPane.showInputDialog("월을 입력하세요");
		int num= Integer.parseInt(month);
		int day=0;
		switch(num) {
		case 1: day=31;break;
		case 2: day=28;break;
		case 3: day=31;break;
		case 4: day=30;break;
		case 5: day=31;break;
		case 6: day=30;break;
		case 7: day=31;break;
		case 8: day=31;break;
		case 9: day=30;break;
		case 10:day=31;break;
		case 11:day=30;break;
		case 12:day=31;break;
		}
		System.out.printf("%d월은 %d일까지 있습니다.\n",num,day);
		
	}

}
