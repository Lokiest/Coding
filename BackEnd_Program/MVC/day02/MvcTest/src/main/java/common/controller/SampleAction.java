package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleAction extends AbstractAction {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//비지니스 로직 >> 결과를 attribute에 담아줌 >> 갈 곳을 정해주는 것
		
		req.setAttribute("msg", "Sample Setting ready");
		
		this.setViewPage("/template.jsp");
		this.setRedirect(false);
	}
}
