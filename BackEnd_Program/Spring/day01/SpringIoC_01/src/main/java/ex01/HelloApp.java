package ex01;

public class HelloApp {

	public static void main(String[] args) {
		//System.out.println("Hello");
		
		//MessageBeanKo mbk = new MessageBeanKo();
		MessageBeanEn mbe = new MessageBeanEn();
//		mbk.sayHello("Malky");
		mbe.sayHello("Malky");
		
		/* HelloApp이 MessageBeanKo객체를 사용
		 * >> HelloApp이 MessageBeanKo에 의존한다.
		 * : 이 때, 의존성 있는 객체들간의 결합도가 중요
		 * 결합도 강하면, 문제 발생 가능성 높음
		 * */
	}

}
