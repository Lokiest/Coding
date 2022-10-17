package day03;

import common.*;

public class MyQueue {
	private Object[] que;//배열=> 큐
	private int capacity;//큐의 크기
	private int front;//맨 앞 요소 커서
	private int end;//맨 끝 요소 커서
	private int cnt;//현재 데이터 수
	
	public MyQueue(int capacity) {
		this.capacity=capacity;
		cnt=0;
		front=0;
		end=0;
		que=new Object[this.capacity];
	}//------------------------
	//인큐할 때 데이터는 맨 뒤로 들어간다. 큐=>FIFO
	public Object enque(Object val) {
		if(cnt>=this.capacity) throw new OverFlowException();
		
		que[end++]=val;
		cnt++;
		//맨 뒤의 커서 end가 최대용량을 넘어설 경우 end값을 0으로 초기화
		if(end>=this.capacity) {
			end=0;
		}
		return val;
	}//-------------------------
	//프런트 데이터를 바라봄
	public Object peek() {
		if(cnt<=0) {
			throw new EmptyException();
		}
		return que[front];		
	}//-------------------------
	//디큐할 때는 데이터가 맨 앞에서부터 나와야 한다. fifo구조
	public Object deque() {
		if(cnt<=0) throw new EmptyException();
		Object val=que[front++];
		cnt--;
		if(front==this.capacity) {
			front=0;
		}
		return val;
	}//-------------------------
	//큐를 비우는 메서드
	public void clear() {
		cnt=0;
		front=0;
		end=0;
	}//-----------------------
	//현재 큐에 저장된 데이터 개수를 반환
	public int size() {
		return cnt;
	}//-----------------------
	//큐가 비어있는지 여부
	public boolean isEmpty() {
		return cnt<=0;
	}//-----------------------
	public boolean isFull() {
		return cnt >=this.capacity;
	}//-----------------------
	//큐 내용을 출력하는 메서드 구현
	public void printQueue() {
		for(int i=0;i<cnt;i++) {
			System.out.println(que[i+front]);
		}		
	}//-----------------------
	
	//큐에서 검색하는 메서드 구현
	public int indexOf(Object val) {
		for(int i=0;i<cnt;i++) {
			int idx=i+front;
			if(que[idx].equals(val)) {
				return i;
			}
		}//for-----		
		return -1;
	}//-----------------------

}//////////////////////////////////////







