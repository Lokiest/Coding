package day01; //1. 패키지 선언문 
//패키지명은 소문자로 기술 + 보통 단계 이상 서술하는 것을 권함
//다음으로는 import 기술 
import java.lang.System;
//java.lang 패키지는 import 생략해도 자동으로 import됨
import java.util.Date;
//주석은 JavaScript랑 똑같음
/*
 * 문서 주석까지 추가 
 */
public class Hi {
	public static void main(String[] args) {
		System.out.println("Hi java");
		Date d = new Date(); //객체 생성
		System.out.println(d);
		
		System.out.print("Hi");
		System.out.println("Hello");
		System.out.println("안\n녕");
		//escape 문자 : \n > 개행, \t : 탭, \" : 쌍따옴표 출력
		//\' : 홑따옴표, \\ : 역슬래시, \r : 커서 맨 앞으로 이동 
		System.out.println("안\t녕\t하");
		System.out.println("김소월의 \'진달래꽃\' \n"
				+ "\"나보기가 역겨워 가실 때에는\"");
		System.out.println("========================");
		//System.out.printf(출력서식, 출력내용);
		//%d : 정수 출력, %f : 실수 출력, %s : 스트링, %b : boolean
		System.out.printf("%s", "Hi\n");
		System.out.printf("%d\n", 22);
		System.out.printf("%f\n", 23.11);
		System.out.printf("%.2f\n", 23.11);
		System.out.printf("%d\n", 23456);
		System.out.printf("%10d\n", 23456);
		System.out.printf("%-10d\n", 23456); //왼쪽 정렬 -
		System.out.printf("%010d\n", 23456); //앞에 남은 공간 0으로 채우기
		
		
	}
}
