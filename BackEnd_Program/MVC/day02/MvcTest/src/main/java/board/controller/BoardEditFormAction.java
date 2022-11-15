package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAOMybatis;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardEditFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. 수정할 글 번호 받기
		String numStr = req.getParameter("num");
		
		//2. 유효성 체크
		if(numStr==null||numStr.trim().isEmpty()) {
			this.setViewPage("boardList.do");
			this.setRedirect(true);
			return;
		}
		
		
		//3. daoviewBoard(num)
		BoardDAOMybatis dao = new BoardDAOMybatis();
		BoardVO vo = dao.viewBoard(Integer.parseInt(numStr.trim()));
		
		//4. req에 저장 "board
		req.setAttribute("board", vo);
		
		this.setViewPage("board/boardEdit.jsp");
		this.setRedirect(false);

	}

}
