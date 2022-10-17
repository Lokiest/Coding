package day03;
//객체를 비교할 수 있도록 만들기 위해서는 Comparable인터페이스를 상속받아 compareTo()메서드를 재정의해야 한다
//또는 Comparator인터페이스를 상속받아 compare()메서드를 재정의해야 한다.
/* Comparable과 Comparator의 차이는?
[1] Comparable의 compareTo(T o) 메소드 
[2] Comparator의 compare(T o1, T o2) 메소드

- Comparable은 "자기 자신과 매개변수 객체를 비교"하는 것이고, 
- Comparator는 "두 매개변수 객체를 비교"한다는 것이다.

쉽게 말하자면, Comparable은 자기 자신과 파라미터로 들어오는 객체를 비교하는 것이고, 
Comparator는 자기 자신의 상태가 어떻던 상관없이 파라미터로 들어오는 두 객체를 
비교하는 것이다. 즉, 본질적으로 비교한다는 것 자체는 같지만, 비교 대상이 다르다는 것이다.
* */
public class Member implements Comparable<Member>{
	
	private String name;
	private int age;
	private int height;
	public Member() {
		
	}//-------------------
	public Member(String n, int a, int h) {
		this.name=n;
		this.age=a;
		this.height=h;
	}//------------------------
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member user=(Member)obj;
			if(this.name.equals(user.name)&&this.age==user.age&&this.height==user.height) {
				return true;
			}
		}
		return false;
	}//------------------------------
	
	@Override
	public String toString() {
		return "Member[name="+name+", age="+age+", height="+height+"]";
	}
	//this하고 매개변수로 들어온 obj하고 비교를 함
	//동일한 값을 가지면 0을 반환
	//나이 오름차순 정렬을 한다면
	/*오름차순:
	 * 나	 상대방
	 * 7       3
	 * 내림차순
	 * 7       3
	 * 
	 * 10      13
	 * */
	@Override
	public int compareTo(Member obj) {
		/*if(this.age==obj.age) {
			return 0;
		}else if(this.age>obj.age) {//> 양수 반환: 오름차순,   < 양수반환: 내림차순
			//자기 나이가 상대방 보다 크면 양수를 반환=> 오름차순
			return 1;
		}else {
			return -1;
		}*/
		return this.age-obj.age;//오름차순
		//return obj.age-this.age;//내림차순
	}
}/////////////////////////////////










