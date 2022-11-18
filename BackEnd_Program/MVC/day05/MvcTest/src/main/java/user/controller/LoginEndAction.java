package user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.NotUserException;
import user.model.UserDAOMyBatis;
import user.model.UserVO;

public class LoginEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		String saveId = req.getParameter("saveId");
		if(userid==null||pwd==null||userid.trim().isEmpty()||pwd.trim().isEmpty()) {
			this.setViewPage("login.do");
			this.setRedirect(true);
			return;
		}
		
		UserDAOMyBatis dao = new UserDAOMyBatis();
		try {
			UserVO loginUser = dao.loginCheck(userid, pwd);
			//loginUser가 not null > 회원인증 받은 것 >> 세션에 loginUser를 저장하기
			HttpSession session = req.getSession();
			if(loginUser !=null) {
				session.setAttribute("loginUser", loginUser);
				//아이디 저장
				Cookie ck = new Cookie("uid", loginUser.getUserid());
				
				if(saveId!=null) {
					ck.setMaxAge(7*24*60*60);
				} else {
					ck.setMaxAge(0); //쿠키 삭제
				}
				ck.setPath("/");
				res.addCookie(ck);
				
			}
			
			this.setViewPage("index.do");
			this.setRedirect(true);
			
		} catch(NotUserException e) {
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("loc", "javascript:history.back()");
			this.setViewPage("message.jsp");
			this.setRedirect(false);
		}
	}

}
