package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}

	//사전처리나 사후처리 할 일 있으면 doFilter() 메서드 안에서 구현
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//post방식일 때 한글 처리를 사전에 처리하기
		request.setCharacterEncoding("UTF-8");
		System.out.println("EncodingFilter dofilter 호출");
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
