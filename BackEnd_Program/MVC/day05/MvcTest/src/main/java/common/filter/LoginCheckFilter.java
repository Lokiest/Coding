package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.model.UserVO;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(urlPatterns = {"/user/*", "/admin/*"})
public class LoginCheckFilter extends HttpFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//세션에 저장되어있는 loginUser가 있는지 체크해서
		//없다면 >> "로그인해야 이용 가능" 보여주고 return
		//있다면 >> 다음 필터로 넘어가기
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("loginUser");
		if(user==null) {
			String str="로그인해야 이용 가능";
			String loc=req.getContextPath() + "/login.do"; //절대경로
			
			req.setAttribute("msg", str);
			req.setAttribute("loc", loc);
			RequestDispatcher disp = req.getRequestDispatcher("/message.jsp");
			disp.forward(req, response);
			
			return;
		}
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
