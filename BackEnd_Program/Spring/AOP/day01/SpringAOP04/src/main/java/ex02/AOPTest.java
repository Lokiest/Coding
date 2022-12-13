package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ex03.BoardService;

public class AOPTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex02/aop.xml");
		BoardService bs = ctx.getBean("boardSvc", BoardService.class);
		BoardVO vo = new BoardVO(1, "첫번째 게시글 등록", "Park");
		bs.insertBoard(vo);
		bs.insertBoard(vo);
		bs.insertBoard(vo);

	}

}
