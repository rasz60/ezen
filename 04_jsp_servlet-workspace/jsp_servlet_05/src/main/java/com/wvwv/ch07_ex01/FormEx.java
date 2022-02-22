package com.wvwv.ch07_ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/FormEx")
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		//response하는 content type 설정
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String[] hobby = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><body>");
		writer.println("<h2>Request Report</h2><hr />");
		writer.println("name : " + name + "<br/>");
		writer.println("id : " + id + "<br/>");
		writer.println("password : " + pwd + "<br/>");
		writer.println("hobby : " + Arrays.toString(hobby) + "<br/>");
		writer.println("major : " + major + "<br/>");
		writer.println("protocol : " + protocol + "<br/>");
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		// doPost()로 들어온 request charset 정의
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
