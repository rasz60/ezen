package com.wvwv.ch08_ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextInitParam
 */
@WebServlet("/ctxtip")
public class ContextInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextInitParam() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		response.setContentType("text/html; charset=UTF-8");
		
		// getServletContext() : HttpServlet 클래스의 정의된 메서드로 ServletContext 객체를 return
		// getInitParameter()  : ServletContext 객체가 가진 메서드로 해당 context-param 값을 return
		String id = this.getServletContext().getInitParameter("id");
		String pwd = this.getServletContext().getInitParameter("pwd");
		String path = this.getServletContext().getInitParameter("path");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>" +
					"<head>" +
					"<title>ContextInitParameter</title>" +
					"</head>" +
					
					"<body>" +
					"<h3>Context InitParameter 확인</h3>" +
					"<hr />" +
					"id : " + id + "<br />" + 
					"pw : " + pwd + "<br />" +
					"path : " + path + "<br />" + 
					"</body>" +
					"</html>" );
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
