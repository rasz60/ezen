package com.wvwv.ch06_ex01;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/cycl")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycle() {
        super();
        System.out.println("construct()");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    //servlet 객체를 생성하여 초기화하는 메서드
	public void init(ServletConfig config) throws ServletException {
        System.out.println("init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	//servlet이 종료될 때(server가 종료될 때)만 실행
	public void destroy() {
        System.out.println("destroy()");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

/*
 * 	request가 생기면 맨 처음 호출되며, 해당 method가 doGet() / doPost()를 호출
 * 	해당 method는 따로 재정의하지 않고 상위클래스 HttpServlet 클래스의 메서드를 그대로 사용
 *	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 *	}
 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@PostConstruct //construct 생성된 후에 실행될 작업에 해당하는 곳에 지정
	public void postConst() {
		System.out.println("@PostConstruct");
	}

	@PreDestroy //destroy된 후에 실행될 작업에 해당하는 곳에 지정
	public void postDestroy() {
		System.out.println("@PreDestroy");
	}
}
