package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("IndexAction's execute Method Recall");
		
		req.setAttribute("msg", "frontController Setting ready");
		
		this.setViewPage("/index.jsp");
		this.setRedirect(false);
	}
	
}
