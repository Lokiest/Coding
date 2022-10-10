package day10;

import java.util.*;

public class HashMapTest {
	//아이디와 비밀번호 mapping
	HashMap<String, String> map = new HashMap<>();
	
	public void join() {
		map.put("~~~", "123");
		map.put("@@@", "321");
		map.put("admin", "213"); //admin
		System.out.println("회원 가입 완료");
	}
	
	public void loginCheck() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("id : ");
			String userid = sc.next();
			System.out.println("password : ");
			String userpwd = sc.next();
			
			boolean b = map.containsKey(userid);
			if (!b) { //없는 아이디 경우
				System.out.println(userid + "는 존재하지 않습니다");
				continue;
			} else {
				String realPwd = map.get(userid);
//				boolean b2 = map.containsValue(userpwd);
				boolean b2 = realPwd.equals(userpwd);
				
				if (!b2) {
					System.out.println("비밀번호 오류");
					continue;
				}
				
				if (userid.equals("admin")) {
					System.out.println("admin mode");
				} else {
					System.out.println("Welcome " + userid + " / " + userpwd);
				}
				break;
			}
			
			/*입력한 값이 map에 저장되어 있는지 체크
			 * 1) 해당 아이디가 map에 저장되어 있는지 검사
			 *    (a) 없다면 => "없는 아이디입니다"
			 *    (b) 있다면 
			 *    		=> 비밀번호 체크
			 *    			=> 비번 일치하면 
			 *    				[1] 일반 유저=> 환영메시지 보여주기
			 *    				[2] 관리자면 => 관리자 모드를 이용할 수 있어요	
			 *             반복문 벗어나기
			 * */

			
		}
		
	}

	public static void main(String[] args) {

		HashMapTest hm = new HashMapTest();
		hm.join();
		hm.loginCheck();

	}

}
