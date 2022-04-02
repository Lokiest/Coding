package com.DoRyeon.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.DoRyeon.app.entity.Notice;
import com.DoRyeon.app.service.NoticeService;

public class NoticeConsole {
	
	private NoticeService service;
	private int page;
	private String searchWord;
	private String searchField;
	
	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
		searchWord = "";
		searchField = "TITLE";
	}
	
	public void printNoticeList() throws SQLException, ClassNotFoundException {
		List<Notice> list = service.getList(page, searchField, searchWord);
		int count = service.getCount(); //list 구할 때마다 count 불러야하기때문에 지역변수로
		int last_page = count / 6;
		last_page = count % 6 == 0 ? last_page : last_page + 1;
		
		System.out.println("───────────────────────────────────────────");
		System.out.printf("<공지사항> 총 %d 게시글\n", count);
		System.out.println("───────────────────────────────────────────");
		
		for (Notice n : list) {
		System.out.printf("%d. %s / %s / %s\n", n.getId(), n.getTitle(), n.getWriterId(), n.getRegDate());
		}
		System.out.println("───────────────────────────────────────────");
		System.out.printf("			%d / %d pages		\n", page, last_page);
	}

	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("1. 상세조회 / 2. 이전 / 3. 다음 / 4. 글쓰기 / 5. 검색 / 5. 종료 >");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		return menu;
	}

	public void movePrevList() {
		if(page == 1) {
			System.out.println("첫페이지 입니다.");
			return;
		}
		page--;
		
	}

	public void moveNextList() throws ClassNotFoundException, SQLException { 
		int count = service.getCount();
		int last_page = count / 6;
		last_page = count % 6 == 0 ? last_page : last_page + 1;
		if(page == last_page) { //이 전의 지역변수 last_page와 값이 다를 수 있기 때문에 새로 정의
			System.out.println("마지막 페이지입니다.");
			return;
		}
		page++;
		
	}

	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 범주 중 하나 정해주세요.");
		System.out.print(">");
		searchField = scan.nextLine(); //목록 조회시 list가 사용할 내용이므로 다른 메서드와 공유해야함 > 멤버
		
		System.out.print("검색어 > ");
		searchWord = scan.nextLine(); //목록 조회시 list가 사용할 내용이므로 다른 메서드와 공유해야함 > 멤버
		
		
	}


}
