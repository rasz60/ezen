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
    //servlet ��ü�� �����Ͽ� �ʱ�ȭ�ϴ� �޼���
	public void init(ServletConfig config) throws ServletException {
        System.out.println("init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	//servlet�� ����� ��(server�� ����� ��)�� ����
	public void destroy() {
        System.out.println("destroy()");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

/*
 * 	request�� ����� �� ó�� ȣ��Ǹ�, �ش� method�� doGet() / doPost()�� ȣ��
 * 	�ش� method�� ���� ���������� �ʰ� ����Ŭ���� HttpServlet Ŭ������ �޼��带 �״�� ���
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

	@PostConstruct //construct ������ �Ŀ� ����� �۾��� �ش��ϴ� ���� ����
	public void postConst() {
		System.out.println("@PostConstruct");
	}

	@PreDestroy //destroy�� �Ŀ� ����� �۾��� �ش��ϴ� ���� ����
	public void postDestroy() {
		System.out.println("@PreDestroy");
	}
}
