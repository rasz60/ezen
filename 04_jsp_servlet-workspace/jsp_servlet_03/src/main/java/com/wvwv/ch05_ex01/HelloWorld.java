package com.wvwv.ch05_ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/hw")
//@webservlet("url") : 해당 서블릿을 실행했을 때의 url을 매핑 
public class HelloWorld extends HttpServlet {
	//servlet역할 클래스는 추상클래스인 HttpServlet를 상속받아야 한다.

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // 상위클래스(HttpServlet)의 생성자를 호출 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //HttpServlet에서 override한 abstract method doGet() / doPost()
    // client -> request method: get -> servlet doGet();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello World~~");
		response.setContentType("text/html; charset=UTF-8");
		//response content의 type을 설정 (text로 된 html, charset은 UTF-8)
		
		PrintWriter writer = response.getWriter();
		//PrintWriter는 문자열 형태로 출력을 처리하는 객체
		
		writer.println("<html><head></head><body>");
		writer.println("<h1>! ! ! HELLO WORLD ! ! !</h1>");
		writer.println("</body></html>");
		//PrintWriter 객체의 print method를 이용하여 html문서를 작성하면 client에 보여진다.
		
		writer.close();
		//작업을 완료하고 PrintWriter 객체을 닫아주어야 한다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
