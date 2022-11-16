package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAOMybatis;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardViewAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. 글 번호 받기
		String numStr=req.getParameter("num");
		//2. 유효성 체크
		if(numStr==null||numStr.trim().isEmpty()) {
			this.setViewPage("boardList.do"); 
			this.setRedirect(true);
			return;
		}//-------------------------
		int num=Integer.parseInt(numStr.trim());
		//3. dao의 메서드 호출
		BoardDAOMybatis dao=new BoardDAOMybatis();
		
		BoardVO vo=dao.viewBoard(num);
		//4. req에 저장
		req.setAttribute("board", vo);
		
		//5. 뷰페이지 지정, 이동방식 지정
		this.setViewPage("board/boardView.jsp");
		this.setRedirect(false);
	}

}
