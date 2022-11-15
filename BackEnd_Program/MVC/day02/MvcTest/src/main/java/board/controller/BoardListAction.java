package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAOMybatis;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		BoardDAOMybatis dao=new BoardDAOMybatis();
		int count=dao.getTotalCount();
		
		List<BoardVO> boardArr=dao.listBoard();
		
		req.setAttribute("totalCount", count);
		req.setAttribute("boardArr", boardArr);
		
		this.setViewPage("board/boardList.jsp");
		this.setRedirect(false);
	}

}
