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
//@webservlet("url") : �ش� ������ �������� ���� url�� ���� 
public class HelloWorld extends HttpServlet {
	//servlet���� Ŭ������ �߻�Ŭ������ HttpServlet�� ��ӹ޾ƾ� �Ѵ�.

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // ����Ŭ����(HttpServlet)�� �����ڸ� ȣ�� 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //HttpServlet���� override�� abstract method doGet() / doPost()
    // client -> request method: get -> servlet doGet();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello World~~");
		response.setContentType("text/html; charset=UTF-8");
		//response content�� type�� ���� (text�� �� html, charset�� UTF-8)
		
		PrintWriter writer = response.getWriter();
		//PrintWriter�� ���ڿ� ���·� ����� ó���ϴ� ��ü
		
		writer.println("<html><head></head><body>");
		writer.println("<h1>! ! ! HELLO WORLD ! ! !</h1>");
		writer.println("</body></html>");
		//PrintWriter ��ü�� print method�� �̿��Ͽ� html������ �ۼ��ϸ� client�� ��������.
		
		writer.close();
		//�۾��� �Ϸ��ϰ� PrintWriter ��ü�� �ݾ��־�� �Ѵ�.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
