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
		
		// RequestDispatcher 객체에 이동할 페이지의 url를 입력
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dispatcherJSP.jsp");
		
		// request해 온 곳에 해당 작업을 실행할 페이지의 url을 보내서 다시 request하게 함.
		// getRequestDispatcher()로 지정한 url로 request, response 객체 값을 가지고 이동하기 때문에, 이동한 페이지에서 추가한 속성을(setAttribute()) 사용할 수 있다.
		dispatcher.forward(request, response);
	}

}
