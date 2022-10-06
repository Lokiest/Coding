package day08;

public class Local {
	String str= " ~~~ ";
	
	void demo() {
		String lstr = " ### "; //local >> 로컬이너클래스에서 사용하려면 final 변수여야 함
		System.out.println(str);
		System.out.println(lstr);
		
//		LocalInner li = new LocalInner(); [x]
		
		class LocalInner {
			int n = 100;
			void print() {
				System.out.println(" --- ");
				System.out.println(n);
				System.out.println(str);
				System.out.println(lstr);
//				lstr = "값 변경";
			}
		}
		LocalInner li = new LocalInner();
		li.print();
	}

	public static void main(String[] args) {

		Local lc = new Local();
		lc.demo();
		
//		Local.LocalInner li = new Local().new LocalInner(); [x]

	}

}
