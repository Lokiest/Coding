package ex1;

import java.sql.SQLException;

import com.DoRyeon.app.console.NoticeConsole;

public class Program_5 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		NoticeConsole console = new NoticeConsole();
		//int page;
		EXIT:
		while(true) {
			console.printNoticeList();
			int menu = console.inputNoticeMenu();
			
			switch(menu) {
			case 1: //상세조회
				break;
			case 2: //이전
				console.movePrevList();
				//page--;
				break;
			case 3: //다음
				console.moveNextList();
				//page++;
				break;
			case 4: //글쓰기
				break;
			case 5: //검색
				console.inputSearchWord();
				break;
			case 6: //종료
				System.out.println("종료");
				break EXIT;
				default:
					System.out.println("잘 못 입력하셨습니다.");
					break;
		}
		}
	}

}
