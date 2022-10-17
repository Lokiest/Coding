package day04;

public class MyArrayList<E> {
	
	private Object[] data;
	private int capacity;
	private int index;
	
	public MyArrayList() {
		this(5);
	}
	public MyArrayList(int initCapa) {
		this.capacity=initCapa;
		this.data=new Object[capacity];
		this.index=0;
	}
	//데이터 추가
	public void add(E obj) {
		if(index>=capacity-1) {//데이터가 꽉 찼다면=>두배로 증가시키자
			doubling();
		}
		data[index++]=obj;
	}//-----------------
	private void doubling() {
		this.capacity=this.capacity*2;//2배로 
		Object []newData=new Object[this.capacity];
		//기존 배열에 저장된 데이터를 새로운 배열로 옮기자
		for(int i=0;i<data.length;i++) {
			newData[i]=data[i];
		}
		this.data=newData;
		//멤버변수data에 새로운 배열의 주소값을 전달한다
		System.out.printf("index: %d, capacity: %d, size: %d%n",index, capacity, this.size());
	}//----------------------
	//리스트에 담긴 데이터 개수를 반환
	public int size() {
		return index;
	}//----------------------------
	//데이터 꺼내기
	public E get(int i) {
		if(i>index-1) {
			throw new ArrayIndexOutOfBoundsException();
		}else if(i<0) {
			throw new RuntimeException("Negative Index Value");
		}
		Object val=data[i];
		return (E)val;
	}//----------------------------
	//특정 인덱스의 데이터 삭제
	public void remove(int i) {
		if(i>index-1) {
			throw new ArrayIndexOutOfBoundsException();
		}else if(i<0) {
			throw new RuntimeException("Negative Index Value");
		}
		for(int k=i;k<this.data.length-1;k++) {
			data[k]=data[k+1];// 뒤에 있는 요소를 앞으로 이동시킨가
		}
		this.index--;
	}
}/////////////////////////////////





















