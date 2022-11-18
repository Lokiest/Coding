package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import user.model.UserDAOMyBatis;

public class IdCheckAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String method = req.getMethod();
		if(method.equalsIgnoreCase("get")) {
			
			this.setViewPage("member/idCheck.jsp");
			this.setRedirect(false);
		} else {
			String userid = req.getParameter("userid");
			UserDAOMyBatis dao = new UserDAOMyBatis();
			boolean isUse = dao.idCheck(userid);
			String result = (isUse)?"ok":"no";
			req.setAttribute("result", result);
			req.setAttribute("userid", userid);
			
			this.setViewPage("member/idCheckResult.jsp");
			this.setRedirect(false);
		}
		
		

	}

}
