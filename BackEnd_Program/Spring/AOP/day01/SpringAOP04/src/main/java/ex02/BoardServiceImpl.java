package ex02;

import java.util.ArrayList;
import java.util.List;

import ex03.BoardService;

public class BoardServiceImpl implements BoardService {

	List<BoardVO> boardArr = new ArrayList<>();
	@Override
	public int insertBoard(BoardVO vo) {
		System.out.println("핵심 로직을 수행하는 메서드 : insertBoard " + vo.getTitle() +"글 등록");
		
		boardArr.add(vo);
		boardArr.add(vo);
//		boardArr=null; //예외 발생시키는 코드
		boardArr.add(vo);
		
		return boardArr.size();
	}

}
