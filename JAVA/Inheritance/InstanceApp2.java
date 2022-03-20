class Cal {
	public int sum(int v1, int v2) {
		return v1 + v2;
	}
	public int sum(int v1, int v2, int v3) {
		return this.sum(v1, v2) + v3;
	}
}
class Cal2 extends Cal {
	public int minus(int v1, int v2) {
		return v1 - v2;
	}
	
	public int sum(int v1, int v2) {
		System.out.println("a2!");
		return super.sum(v1, v2);
	}
}
public class InstanceApp2 {

	public static void main(String[] args) {
		Cal a1 = new Cal();
		System.out.println(a1.sum(1, 2));
		System.out.println(a1.sum(1, 2, 1));
		
		Cal2 a2 = new Cal2();
		System.out.println(a2.sum(1, 2));
		System.out.println(a2.minus(1, 2));

	}

}
