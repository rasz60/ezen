package com.wvwv.ch08_ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInit
 */
//@WebServlet("/ServI")
public class ServletInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		// web.xml에 지정한 초기값은 get방식으로 submit
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
