package day10;

/*main()시작						main()종료
 * |---------------------------------|
 * 
 * |---thread생성 -------->|          |main()
 * |---------thread생성-------------- |main()---------->|thread종료
 * 
 * 
 * */

public class ThreadTest {

	public static void main(String[] args) {
		System.out.println("~~~");
		//현재 실행중인 스레드 알아보기
		Thread tr = Thread.currentThread();
		System.out.println(tr.getName());
		
		int count = Thread.activeCount();
		System.out.println(count);
		
		Thread.currentThread().setName("Blar");
		System.out.println(Thread.currentThread().getName());
		
		

	}

}
