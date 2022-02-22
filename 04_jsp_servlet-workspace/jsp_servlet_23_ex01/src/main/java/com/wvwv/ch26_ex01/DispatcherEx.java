package com.wvwv.ch26_ex01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherEx
 */
@WebServlet("/DEx")
public class DispatcherEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherEx() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		actionDo(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()");
		request.setAttribute("id", "abcde");
		request.setAttribute("pwd", "12345");
		
		// RequestDispatcher ��ü�� �̵��� �������� url�� �Է�
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dispatcherJSP.jsp");
		
		// request�� �� ���� �ش� �۾��� ������ �������� url�� ������ �ٽ� request�ϰ� ��.
		// getRequestDispatcher()�� ������ url�� request, response ��ü ���� ������ �̵��ϱ� ������, �̵��� ���������� �߰��� �Ӽ���(setAttribute()) ����� �� �ִ�.
		dispatcher.forward(request, response);
	}

}