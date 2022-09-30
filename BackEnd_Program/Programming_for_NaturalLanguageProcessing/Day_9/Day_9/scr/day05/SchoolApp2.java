package day05;

import java.util.*;

public class SchoolApp2 {

	private Scanner sc = new Scanner(System.in);
	private Student[] arr = new Student[3]; // 학생 객체를 저장할 배열
	private int count = 0; // 등록한 학생 수 count
	// 2, 5, 7, 8
	// 학생 검색 : 학번으로 검색하기
	// "학번 입력하세요": 1
	// 1번학생의 정보만 출력
	// 없으면 =>"등록되지 않은 번호입니다"
	// 학생 삭제: 학번으로 검색해서 있으면 배열에서 삭제 처리
	// 없으면 =>"등록되지 않은 번호입니다"

	public void menu() {
		System.out.println("--------------학사 관리 프로그램--------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 교수 등록");
		System.out.println("3. 직원 등록");
		System.out.println("4. 학생 출력");
		System.out.println("5. 교수 출력");
		System.out.println("6. 지원 출력");
		System.out.println("7. 학생 검색");
		System.out.println("8. 학생 삭제");
		System.out.println("9. 종    료");
		System.out.println("-------------------------------------------");
		System.out.println("번 호 입 력 : ");
		System.out.println("-------------------------------------------");

	}

	// 학생 객체 배열에 저장
	public void addStudent(Student st) {
		st.inputInfo();
		st.printInfo();
		System.out.println("정 보 저 장 ? [1].yes, [2].no");
		int n = sc.nextInt();
		if (n == 1) {
			arr[count++] = st;
			System.out.println(count + "명, 저 장 완 료");
		} else {

		}
	}

	// 등록된 학생 정보 출력
	public void printStudents() {
		for (int i = 0; i < count; i++) {
			arr[i].printInfo();
		}
	}

	public static void main(String[] args) {
//		Student st1 = new Student();
//		st1.inputInfo();
//		st1.printInfo();
		SchoolApp2 sa = new SchoolApp2();

		while (true) {
			sa.menu();

			int num = sa.sc.nextInt();
			if (num == 9) {
				System.out.println("The End");
				System.exit(0);
			}
			switch (num) {
			case 1: {
//				if(sa.count < sa.arr.length) {
//				Student st1 = new Student();
//				sa.addStudent(st1);
//				} else {
//					System.out.println("등 록 마 감");
//				}
				if (sa.count >= sa.arr.length) {
					System.out.println("등 록 마 감, 등록인원 : " + sa.count);
					continue;
				}
				Student st1 = new Student();
				sa.addStudent(st1);
			}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				sa.printStudents();
//				st1.printInfo();
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("입 력 오 류");

			}// sw
		} // wh

	}

}
