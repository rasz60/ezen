package com.wvwv.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wvwv.test.command.BCommand;
import com.wvwv.test.command.BListCommand;

/**
 * Servlet implementation class BController
 */
@WebServlet("/")
public class BController extends HttpServlet {

	BCommand bCommand;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String cntxtPath = request.getContextPath();
		String cmd = uri.substring(cntxtPath.length());
		
		String viewPage = null;
		
		if( cmd.equals("/") || cmd.equals("/list.do") ) {
			bCommand = new BListCommand();
			bCommand.execute(request, response);
			viewPage = "list.jsp";
		}
		
		if ( viewPage == null ) {
			System.out.println("viewPage가 없습니다.");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			System.out.println(viewPage + "로 이동.");
			dispatcher.forward(request, response);
		}
	}
}
