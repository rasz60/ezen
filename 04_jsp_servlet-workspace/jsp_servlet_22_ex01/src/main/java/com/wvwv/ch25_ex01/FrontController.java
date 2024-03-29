package com.wvwv.ch25_ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wvwv.ch25_ex01.command.*;

/**
 * Servlet implementation class FrontController
 */

@WebServlet("*.do") // ~~.do로 넘어오는 모든 request를 받는 servlet
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //command interface 변수 생성
	MyCommand cmd;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
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
		actionDo(request, response);
	}

	// .do로 넘어오는 request의 uri를 이용해 각각의 처리 영역으로 보내주는 메서드
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()");

		// request를 보내온 페이지의 uri를 가져옴
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);

		// request를 보내온 페이지의 contextPath(프로젝트명)을 가져옴
		String conPath = request.getContextPath();
		System.out.println("context path : " + conPath);

		// request의 uri에서 context path를 제외한 경로
		String command = uri.substring(conPath.length());
		System.out.println("command : " + command);

		// 요청한 command 내용에 따른 수행 내용을 지정한다.
		if ( command.equals("/insert.do") ) {
			System.out.println("insert");			
			System.out.println("-----------------");
			cmd = new InsertCommand();
			cmd.execute();
		} else if ( command.equals("/update.do") ) {
			System.out.println("update");			
			System.out.println("-----------------");
			cmd = new UpdateCommand();
			cmd.execute();
		} else if ( command.equals("/select.do") ) {
			System.out.println("select");			
			System.out.println("-----------------");
			cmd = new SelectCommand();
			cmd.execute();
		} else if ( command.equals("/delete.do") ) {
			System.out.println("delete");			
			System.out.println("-----------------");
			cmd = new DeleteCommand();
			cmd.execute();
		}

	}

}
