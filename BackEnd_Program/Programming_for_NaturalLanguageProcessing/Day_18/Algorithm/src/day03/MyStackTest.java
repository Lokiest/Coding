package day03;

public class MyStackTest {

	public static void main(String[] args) {

		MyStack<String> sk1 = new MyStack<>();
		sk1.push("JAVA");
		sk1.push("JDBC");
		sk1.push("ORACLE");
		sk1.push("Mongo");
		
		System.out.println(sk1.peek());
		String item = sk1.pop();
		System.out.println("which is pop? : " + item);
		System.out.println(sk1.peek());
		sk1.pop();
		sk1.pop();
		System.out.println(sk1.peek());
		System.out.println(sk1.isEmpty());
		
		System.out.println("------------------------------------");
		
		MyStack<Integer> sk2 = new MyStack<>();
		sk2.push(10);
		sk2.push(20);
		System.out.println(sk2.peek());
		
		System.out.println("------------------------------------");
		
		MyStack<Member> sk3 = new MyStack<>();
		Member m1 = new Member("~~~", 22, 177);
		Member m2 = new Member("@@@", 33, 188);
		Member m3 = new Member("###", 44, 199);
		
		sk3.push(m1);
		sk3.push(m2);
		sk3.push(m3);
		
		while(!sk3.isEmpty()) {
			System.out.println(sk3.pop().toString());
		}
	}

}
