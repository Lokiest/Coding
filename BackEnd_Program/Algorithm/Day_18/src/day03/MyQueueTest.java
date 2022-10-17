package day03;

public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue q=new MyQueue(5);
		q.enque("Hello");
		q.enque("Hi");
		q.enque("Dog");
		System.out.println(q.peek());
		System.out.println(q.deque());
		System.out.println(q.peek());
		System.out.println(q.size());
		q.deque();
		System.out.println(q.size());
		q.deque();
//		q.deque();
		
		MyQueue q2=new MyQueue(5);
		q2.enque(10);
		q2.enque(20);
		q2.enque(30);
		q2.printQueue();
		System.out.println(q2.indexOf(20));
		System.out.println(q2.indexOf(200));
		
		q2.enque(new Member("홍길동",22,177));
		q2.enque(new Member("김길동",23,167));
		System.out.println(q2.deque());
		System.out.println("--------------------");
		q2.printQueue();
		System.out.println(q2.indexOf(new Member("홍길동",22,177)));
	}

}
