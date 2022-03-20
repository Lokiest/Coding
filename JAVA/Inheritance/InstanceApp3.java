class Cal3 {
	int v1, v2;
	Cal3(int v1, int v2) {
		System.out.println("Cal3");
		this.v1 = v1;
		this.v2 = v2;
	}
	public int sum() {return this.v1+v2;}
}
class Cal4 extends Cal3 {
	Cal4(int v1, int v2) {
		super(v1, v2);
		System.out.println("Cal4");
	}
	public int minus() {return this.v1-v2;}
}
public class InstanceApp3 {

	public static void main(String[] args) {
		Cal3 a1 = new Cal3(2, 1);
		Cal4 a2 = new Cal4(3, 5);
		System.out.println(a2.sum());
		System.out.println(a2.minus());

	}

}
