package day02;

import java.util.*;

public class Q16_DayOfYear {
	
	int[][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31}, //평년
			{31,29,31,30,31,30,31,31,30,31,30,31} //윤년
	};

	public static void main(String[] args) {
		
		Q16_DayOfYear app = new Q16_DayOfYear();
		app.input_date();

	}

	public void input_date() {
		int no = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("년도 : ");
			int year = sc.nextInt();
			
			System.out.println("월 : ");
			int month = sc.nextInt();
			
			System.out.println("일 : ");
			int day = sc.nextInt();
			
			int total = dayOfYear(year, month, day);
			System.out.printf("%d년 %d일째 %n", year, total);
			
			System.out.println("한번 더 하기 1. yes, 2. no ");
			no =  sc.nextInt();
			
		} while(no==1);
			System.out.println("The End");
	}
	public static final int LEAP_YEAR = 1;
	public static final int NORMAL_YEAR = 0;
	
	public int isLeapYear(int yy) {
		int yoon = 0;
		if(yy%4==0&&yy%100==0 || yy%400==0) {
			return LEAP_YEAR;
		}
		return NORMAL_YEAR;
	}
	
	public int dayOfYear(int yy, int mm, int dd) {
		int total = 0;
		//운년 : 4로 나누어 떨어지면서 100으로 나누어 떨어지면 안됨, 다만 400으로 떨어지면 윤년
		//mdays의 2차원 배열의 행 인덱스가 0 > 평년, 1 > 윤년
		int yoon = isLeapYear(yy);
		for(int i=0;i<mm-1;i++) {
			total += mdays[yoon][i];
		}
		total += dd;
		return total;
	}
}
