package day03;

public class ForTest2 {

	public static void main(String[] args) {
		for (int i=1;i<=3;i++) {
			for (int j=1;j<=3;j++) {
				System.out.println("i = " + i + ", j = " + j);
			}
			System.out.println("-------------------------");
		}
		
		/*[1]
		 *   *****
		 *   *****
		 *   *****
		 *   *****
		 *   
		 *   4행5열
		 * 
		 * */
		
		/* [2]
		 * 
		 *  *
		 *  **
		 *  ***
		 *  ****
		 * 
		 * */
		
		
		/*[3]
		 * 
		 *    *
		 *   **
		 *  ***
		 * ****     
		 * 
		 * */
		//[1]
		for (int i=1;i<=4;i++) {
			for (int j=1;j<=5;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.println("-------------------------");
		//[2]
		for (int i=0;i<4;i++) {
			for (int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		System.out.println("-------------------------");
		//[3]
			for (int i=0;i<4;i++) {
				for (int j=0;j<3-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
			System.out.println(" ");
			}
		System.out.println("-------------------------");
		//[4]
		for (int i = 0;i<3;i++) {
			for (int j =0;j<5;j++) {
				if ((i+j>=2) &&(j-i<=2))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
