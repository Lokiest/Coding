package day05;

public class SchoolApp {

	public static void main(String[] args) {
		Student st = new Student();
		Student st2 = new Student();
		Student st3 = new Student();
		Professor pf = new Professor();
		
		st.setNumber(1000);
		st.setName("김창렬");
		st.setMajor("컴퓨터공학");
//		st.printInfo();
		
		st2.setNumber(2000);
		st2.setName("김차기");
		st2.setMajor("글경");
//		st2.printInfo();
		
		st3.setNumber(3000);
		st3.setName("박차기");
		st3.setMajor("김치학과");
//		st3.printInfo();
		
		pf.setNumber(10000);
		pf.setName("김열창");
		pf.setSubject("경제학");
		pf.printInfo();
		
		Student[] arr = {st, st2, st3};
		for(int i = 0; i<arr.length;i++) {
			arr[i].printInfo();
		}
		// 문제1]학생 객체를 2개 더 생성하고...
		// 각각 이름,학번,전공 값을 넣어준뒤...
		// 배열에 저장하자.
		// for루프 돌리면서 저장된 학생 객체들의
		// 정보를 출력해보자.
		
	}

}
