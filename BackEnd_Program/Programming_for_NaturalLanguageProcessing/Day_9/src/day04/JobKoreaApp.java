package day04;

public class JobKoreaApp {

	public static void main(String[] args) {
		Person p=new Person();
		String info=p.memberInfo();
		System.out.println(info);
		
		p.name="이상화";
		p.age=22;
		p.skill="Java 중급";
		p.profile="개발경력 3년";
		
		info=p.memberInfo();
		//if(p.state) //구직중이라면 출력
		//	System.out.println(info);
		p.openProfile();
		
		System.out.println(p.state);
		
		p.changeState();
		System.out.println(p.state);
		
		//if(p.state) //구직중이라면 출력
		//	System.out.println(info);
		p.openProfile();
		
		//[1]
		//객체를 2개 더 생성하세요. 이름,나이,스킬,프로필 정보를 할당하고
		//공개여부 설정한 뒤 프로필을 출력하세요
		Person p2=new Person();
		p2.name="이상호";
		p2.age=28;
		p2.skill="Java 고급";
		p2.profile="개발경력 5년";
		System.out.println(p2.memberInfo());

		
		Person p3=new Person();
		p3.name="이상춘";
		p3.age=30;
		p3.skill="Python 씹고급";
		p3.profile="데이터분석 10년";
		System.out.println(p3.memberInfo());
		
		
		//[2] 구직자 객체 3개를 저장할 배열을 선언하고 해당 배열에 저장하세요
		//   반복문 이용해서 모든 구직자 정보를 출력하세요
		Person[] arr = new Person[3];
		arr[0] = p;
		arr[1] = p2;
		arr[2] = p3;
		
		for(int i =0;i<arr.length;i++) {
//			System.out.println(arr[i]); 주소값이 나옴
			arr[i].changeState();
			arr[i].openProfile();
		}
	}

}
