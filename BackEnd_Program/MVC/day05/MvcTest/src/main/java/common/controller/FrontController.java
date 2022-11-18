package common.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "*.do" }, 
		initParams = { 
				@WebInitParam(name = "config", value = "C:\\Users\\wngh0\\eclipse-workspace\\MvcTest\\src\\main\\webapp\\WEB-INF\\Command.properties")
		})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> cmdMap = new HashMap<>();
	
	@Override
	public void init(ServletConfig conf) throws ServletException {
		System.out.println("init 호출");
		String props = conf.getInitParameter("config"); //value
		System.out.println("props : " + props);
		FileInputStream fis = null;
		Properties pr = new Properties();
		
		try {
			fis = new FileInputStream(props);
			pr.load(fis);
			
			String val = pr.getProperty("/index.do");
			System.out.println("index.do : " + val);
			
			Set<Object> set = pr.keySet();
			for (Object key : set) {
				String cmd = key.toString();
				String className = pr.getProperty(cmd);
				
				if(className!=null) {
					className = className.trim();
				}
				System.out.println(cmd + " : " + className);
				
				Class<?> cls = Class.forName(className);
				Object cmdInstance = cls.getDeclaredConstructor().newInstance();
				System.out.println("cmdinstance : " + cmdInstance);
				cmdMap.put(cmd, cmdInstance);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = req.getServletPath(); //index.do
		Object instance = cmdMap.get(cmd);
		
		if(instance==null) {
			System.out.println("acion is null");
			throw new ServletException("action is null");
		}
		System.out.println(instance);
		
		AbstractAction action = (AbstractAction)instance;
		try {
			action.execute(req, res);
			String viewPage = action.getViewPage();
			boolean isRedirect = action.isRedirect();
			if(viewPage==null) {
				viewPage = "index.jsp";
			}
			if(isRedirect) {
				res.sendRedirect(viewPage);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher(viewPage);
				rd.forward(req, res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
