package day03;

/*#  큐와 스택
1. 큐 - Queue : Fisrt In First Out 구조
    ex) 택시 줄서기 : 가장 먼저 줄 선 사람이 먼저 택시를 탄다.
    - 큐에서 데이터를 한 개 집어넣는 동작을 인큐(enqueue),
      큐 안에 있는 데이터를 한 개 꺼내는 동작을 디큐(dequeue)라고 표현한다.
2. 스택- Stack : Last In First Out
    ex) 접시 쌓기 :  접시를 쌓아 올리면, 꺼낼 때 가장 마지막 접시부터 꺼내게 됨
    - 스택에 데이터 하나 넣는 동작을 push,
      스택에 있는 데이터를 하나 꺼내는 동작을 pop라고 표현한다.
 * */
import common.*;

public class intStack {
	
	private int capacity;
	private int ptr;
	private int[] stack;
	
	public intStack(int capa) {
		this.capacity = capa;
		ptr=0;
		stack = new int[capacity];
	}
	
	//데이터 삽입하는 메소드, 스택이 가득 차서 더이상 추가할 수 없을 때는 overflow 예외 발생
	public int push(int val) {
		if(ptr>=capacity) throw new OverFlowException();
		return stack[ptr++] = val; //push한 값을 반환하고 포인터값을 하나 증가시키기
	}
	
	//스택에서 맨 위에 있는 데이터를 꺼내 반환, 포인터 값 하나 감소
	public int pop() throws EmptyException {
		if(ptr<=0) throw new EmptyException();
		return stack[--ptr];
	}
	
	//스택에서 맨 위에 있는 데이터를 반환
	public int peek() {
		if (ptr <= 0) throw new EmptyException();
		return stack[ptr - 1];
	}
	
	public int size() {
		return ptr;
	}
	
	public void clear() {
		ptr = 0;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public boolean isEmpty() {
		return ptr<=0;
	}
	
	public boolean isFull() {
		return ptr >= this.capacity;
	}
	
	//저장된 요소값들을 반복문 돌면서 출력하는 메소드
	public void printStack() {
		for(int i=ptr-1;i>=0;i--) {
			System.out.println(stack[i]);
		}
	}
	
	//스택에서 특정 데이터를 검색해서 있으면 해당 데이터의 인덱스 번호를 반환, 없으면 -1 반환하는 메소드
	public int indexOf(int val) {
		for(int i=ptr-1;i>=0;i--) {
			if(stack[i] == val)
				return i;
		}
		return -1;
	}
}
