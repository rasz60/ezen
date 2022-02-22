package com.wvwv.jspMVC.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wvwv.jspMVC.command.BCommand;
import com.wvwv.jspMVC.command.BListCommand;
import com.wvwv.jspMVC.command.BWriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	BCommand command;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
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
		System.out.println("doPost()");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()");
		
		request.setCharacterEncoding("UTF-8");
		
		// RequestDispatcher�� �̵��� ������ url
		String viewPage = null;
		
		// request�� ������ ������ command class path
		BCommand command = null;
		
		// request uri(contextPath + command)���� contextPath�� ������ command ���� ����
		String uri = request.getRequestURI();
		String cntxtPath = request.getContextPath();
		String cmd = uri.substring(cntxtPath.length());
		
		if( cmd.equals("/") ) {
			viewPage = "writeForm.jsp";
			
		} else if ( cmd.equals("/write.do") ) {
			// INSERT DB Command
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		
		} else if ( cmd.equals("/list.do") ) {
			// SELECT DB Command
			command = new BListCommand();
			
			// SELECT DB execute, request set in LIST
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		
		
		if ( viewPage == null ) {
			System.out.println("viewPage�� �����ϴ�.");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			System.out.println(viewPage + "�� �̵�.");
			dispatcher.forward(request, response);
		}
	}
}
