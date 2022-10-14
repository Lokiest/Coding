package day03;

import java.util.Arrays;
import java.util.Scanner;

public class Q20_ArraysBinarySearch {

	static Scanner sc = new Scanner(System.in);

	public static void floatBinarySearch() {
		float[] arr = { 1.3f, 2.44f, 10, 'A', 30e-1f, 7.777f };
		Arrays.sort(arr);
		System.out.println("검색 값 입력 : ");
		float key = sc.nextFloat();
		int idx = Arrays.binarySearch(arr, key);
		// 정렬된 배열에서 검색한 인덱스 번호를 반환
		if (idx < 0) {
			System.out.println(key + " 값 없음");
		} else {
			System.out.printf("검색하려는 %f값은 %d에 존재%n", key, idx);
		}
	}

	/*
	 * String클래스가 Comparable인터페이스(compareTo()메서드를 구현하고 있음)를 상속받아 구현하고 있기 때문에 정렬이된다.
	 * => 정렬이 되면 이진검색 가능하다.
	 */

	public static void stringBinarySearch() {
		String[] str = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for",
				"goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new",
				"package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch",
				"synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while" };
		System.out.println("검색 값 입력 : ");
		String keyword = sc.next();
		Arrays.sort(str);
		int idx = Arrays.binarySearch(str, keyword);
		System.out.println("idx : " + idx);
		if (idx < 0) {
			System.out.println(keyword + " 없음");
		} else {
			System.out.println(idx + "에 존재");
		}

	}

	public static void memberBinarySearch() {
		// MEMBER객체 4개 생성해서 배열에 저장
		Member u1 = new Member("~~~", 22, 177);
		Member u2 = new Member("@@@", 33, 188);
		Member u3 = new Member("###", 44, 199);
		Member u4 = new Member("$$$", 55, 166);
		// 나이를 기준으로 오름차순 정렬
		Member[] users = {u1, u2, u3, u4};
		System.out.println(Arrays.toString(users));
		Arrays.sort(users);
		System.out.println(Arrays.toString(users));
		// 검색할 나이 입력받아서 해당 나이를 가진 회원이 있는 여부를 출력하세요
		System.out.println("검색할 회원 나이 : ");
		int findAge = sc.nextInt();
		int idx = Arrays.binarySearch(users, new Member("",findAge,0));
		if(idx<0) {
			System.out.println(findAge + "세 회원 없음");
		} else {
			System.out.println(findAge + "세 회원 찾음");
			System.out.println(users[idx]);
		}
	}
	
	public static void empBinarySearch() {
		
		Emp e1 = new Emp("~~~", 177);
		Emp e2 = new Emp("@@@", 188);
		Emp e3 = new Emp("###", 199);
		Emp e4 = new Emp("$$$", 166);
		Emp emps[] = {e1, e2, e3, e4};
		System.out.println(Arrays.toString(emps));
		
		Arrays.sort(emps, Emp.HEIGHT_ORDER);
		System.out.println(Arrays.toString(emps));
		
		System.out.println("키가 몇?");
		int findHeight = sc.nextInt();
		int idx = Arrays.binarySearch(emps, new Emp("", findHeight) ,Emp.HEIGHT_ORDER);
		if(idx<0) {
			System.out.println("없음");
		} else {
			System.out.println(emps[idx]);
		}
		
	}

	public static void main(String[] args) {

//		floatBinarySearch();
//		stringBinarySearch();
//		memberBinarySearch();
		empBinarySearch();

	}

}
