package day01;

public class Q3_GopTable {

	public static void printTable() {
		System.out.print("   |");
		for (int i = 1; i < 10; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		System.out.println("---+---------------------------------");
		for (int i = 1; i < 10; i++) {
			System.out.printf("%2d |", i);
			for (int j = 1; j < 10; j++) {
				System.out.printf("%3d", (i * j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		printTable();

	}

}
