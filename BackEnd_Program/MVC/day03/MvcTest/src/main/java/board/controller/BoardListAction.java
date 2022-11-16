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
		//0. 현재 보여줄 페이지 값 반환
		String cpStr = req.getParameter("cpage");
		if(cpStr==null||cpStr.trim().isEmpty()) {
			cpStr="1"; //1page default
		}
		
		int cpage = Integer.parseInt(cpStr.trim());
		if(cpage<1) {
			cpage=1;
		}
		
		BoardDAOMybatis dao=new BoardDAOMybatis();
		//1. 총 게시글 수 구하기
		int totalCount=dao.getTotalCount();
		//2. 한 페이지당 보여줄 목록 개수 정하기
		int pageSize=5;
		
		//3. page 수 구하기
		/*totalCount	pageSize		pageCount
			1~4/ 5		5		 1		
			6~9/ 10		5		 2
			11~14/ 15	5		3				
			
			if(totalCount%pageSize==0){
			     pageCount=totalCount/pageSize;	
			}else{
			    pageCount=totalCount/pageSize +1;	
			}

		 */
		int pageCount = (totalCount-1)/pageSize + 1;
		
		if(pageCount<0) {
			pageCount=1;
		}
		
		if(cpage>pageCount) {
			cpage=pageCount;
		}
		
		int end = cpage * pageSize;
		int start = end - (pageSize - 1);
		
		
		List<BoardVO> boardArr=dao.listBoard(start, end);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("boardArr", boardArr);
		req.setAttribute("pageSize", pageSize);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("cpage", cpage);
		
		this.setViewPage("board/boardList.jsp");
		this.setRedirect(false);
	}

}
