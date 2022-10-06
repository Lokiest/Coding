package day07;

interface inter1 {
	void a();
	int b();
}

interface inter2 {
	double pi = 3.14;
}

//인터페이스가 인터페이스 상속받을 경우는 extends, 다중 상속 가능
interface inter3 extends inter1, inter2{
	void c();
}

abstract class AbsClass {
	abstract void d();
}

//mydemo가 AbsClass, inter3 상속받은 뒤 에러 없도록
class mydemo extends AbsClass implements inter3{
	public void  a() {}
	public int b() {return 0;}
	public void c() {
		System.out.println("c()---------");
	}
	void d() {
		System.out.println("d()---------");
	}
}

public class InterfaceTest2 {

	public static void main(String[] args) {
		// 객체 생성해서  a b c d 호출하고 pi 출력
		mydemo md = new mydemo();
		md.a();
		System.out.println(md.b());
		md.c();
		md.d();
		
		inter1 im1 = new mydemo();
		inter2 im2 = new mydemo();
		inter3 im3 = new mydemo();
		AbsClass ac = new mydemo();
		
		im1.a();
		System.out.println(im1.b());
		System.out.println(im2.pi);
		System.out.println(mydemo.pi);
//		mydemo.pi = 666; [x]
		
		im3.a();
		System.out.println(im3.b() + 3);
		im3.c();

	}

}
