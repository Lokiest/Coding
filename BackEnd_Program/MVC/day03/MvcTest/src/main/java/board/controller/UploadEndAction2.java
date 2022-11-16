package board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.controller.AbstractAction;

public class UploadEndAction2 extends AbstractAction {
	
	String upDir = "C:\\Quiz2";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		MultipartRequest mr = new MultipartRequest(req, upDir, 10*1024*1024,"utf-8", new DefaultFileRenamePolicy());
//		DefaultFileRenamePolicy객체를 매개변수로 전달하면 업로드파일 명이 동일한 것이 있을 경우
		//'파일명 + 인덱스번호' 식으로 업로드
		System.out.println("파일 upload success : " + upDir + "에서 확인");
		
//		String name = req.getParameter("name"); [x]
		String name = mr.getParameter("name");
		System.out.println("name : " + name);
		
		//첨부파일 명 >> getFilesystemName 이용
//		String fname = mr.getParameter("fname") [x]
		String fname = mr.getFilesystemName("fname");
		System.out.println("fname : " + fname);
		
		//첨부파일크기
		File file = mr.getFile("fname");
		long fsize = 0;
		if(file!=null) {
			fsize = file.length();
		}
		
		req.setAttribute("content", "file upload success : " + upDir + "에서 확인");
		req.setAttribute("name", name);
		req.setAttribute("fname", fname);
		req.setAttribute("fsize", fsize);
		
		this.setViewPage("board/uploadResult.jsp");
		this.setRedirect(false);
	}

}
