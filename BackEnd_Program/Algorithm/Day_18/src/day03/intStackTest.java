package day03;

public class intStackTest {

	public static void main(String[] args) {
		
		intStack sk = new intStack(5);
		sk.push(10);
		sk.push(20);
		sk.push(30);
		sk.push(40);
		sk.push(50);
//		sk.push(60);
		System.out.println(sk.peek());
		sk.pop();
		System.out.println(sk.peek());
		System.out.println("sk size : " + sk.size());
		sk.clear();
		System.out.println("after clear size : " + sk.size());
		System.out.println("is it empty? " + sk.isEmpty());
		System.out.println("is it full? " + sk.isFull());
		for(int i=1;i<6;i++) {
			sk.push(i*100);
		}
		
		System.out.println("After push, is it empty? " + sk.isEmpty());
		System.out.println("After push, is it full? " + sk.isFull());
		System.out.println(sk.peek());
		System.out.println(sk.indexOf(400));
		sk.pop(); //500
		sk.pop(); //400
		sk.printStack();
		System.out.println("sk.capacity : " + sk.getCapacity());
		System.out.println("sk.size : " + sk.size());
	}

}
