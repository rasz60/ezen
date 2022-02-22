package com.wvwv.ch08_ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInitParam
 */

//@webServlet 애너테이션에 InitParam을 설정할 수 있다.
@WebServlet(
		urlPatterns = { "/ServIp" }, 
		initParams = { 
				@WebInitParam(name = "id", value = "abcdef"), 
				@WebInitParam(name = "pw", value = "1234"), 
				@WebInitParam(name = "path", value = "c:/javalec/workspace")
		})
public class ServletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInitParam() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String id = getInitParameter("id");
		String pwd = getInitParameter("pw");
		String path = getInitParameter("path");
				
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><body>");
		writer.println("id : " + id + "<br/>");
		writer.println("pw : " + pwd + "<br/>");
		writer.println("path : " + path + "<br/>");
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
