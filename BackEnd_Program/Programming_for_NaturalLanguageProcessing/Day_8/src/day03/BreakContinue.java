package day03;
//보조 제어문 : break, continue
//break 레이블명; , break;
//continue 레이블명; , continue;
public class BreakContinue {

	public static void main(String[] args) {
		System.out.println("1.----------------");
		for(int i =0;i<3;i++) {
			if (i==1) break;
			System.out.println("i : " + i);
		}
		
		System.out.println("2.----------------");
		for(int i =0;i<3;i++) {
			if (i==1) continue;
			System.out.println("i : " + i  );
		}
		
		System.out.println("3.----------------");
		for (int i=0;i<3 ;i++ )
		{
			for (int k=0; k<3;k++ )
			{
				if(k==1) break;
				System.out.println("i="+i+", k="+k);
			}
		}//for--------
		
		System.out.println("4.----------------");
		for (int i=0;i<3 ;i++ )
		{
			for (int k=0; k<3;k++ )
			{
				if(k==1) continue;
				System.out.println("i="+i+", k="+k);
			}
		}//for--------
		
		System.out.println("5.----------------");
		outer: //label >> 반복문 앞에 붙일 수 있
		for (int i=0;i<3 ;i++ )
		{	
			inner:
			for (int k=0; k<3;k++ )
			{
				if(k==1) continue outer; //지정된 label과 가까운 반복문을 계속 반복
				System.out.println("i="+i+", k="+k);
			}
		}//for--------
		
		System.out.println("6.----------------");
		outer: //label >> 반복문 앞에 붙일 수 있
		for (int i=0;i<3 ;i++ )
		{	
			inner:
			for (int k=0; k<3;k++ )
			{
				if(k==1) break outer; //지정된 label과 가까운 반복문을 이탈
				System.out.println("i="+i+", k="+k);
			}
		}//for--------
	}

}
