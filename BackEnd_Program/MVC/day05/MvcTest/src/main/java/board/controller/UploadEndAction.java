package board.controller;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class UploadEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//컨텐트 타입, 파일 크기
		String ctype = req.getContentType();
		long len = req.getContentLengthLong();
//		int len = req.getContentLength()
		
		//첨부파일 >> request body에 포함되어 오는 파일 데이터를 스트림에 연결해서 읽은 후 브라우저 출력해보기
		ServletInputStream in = req.getInputStream();
		byte[] data = new byte[1024];
		int n = 0, count = 0, total = 0;
		String content = "<xmp>";
		
		while ((n=in.read(data)) != -1) {
			String str = new String(data, 0, n);
			content += str;
			count++;
			total += n;
		}
		content += "</xmp>";
		
		req.setAttribute("ctype", ctype);
		req.setAttribute("len", len);
		req.setAttribute("content", content);
		req.setAttribute("count", total);
		
		in.close();
		
		this.setViewPage("board/uploadResult.jsp");
		this.setRedirect(false);
	}

}
