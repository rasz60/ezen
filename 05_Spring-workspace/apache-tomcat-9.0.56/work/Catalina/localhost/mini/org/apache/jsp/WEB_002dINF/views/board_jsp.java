/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-03-17 03:13:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class board_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(9);
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/ezenMini/WEB-INF/lib/jstl-1.2.jar!/META-INF/x.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/views/nav.jsp", Long.valueOf(1647485895438L));
    _jspx_dependants.put("/WEB-INF/views/footer.jsp", Long.valueOf(1647230866707L));
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/ezenMini/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1644909417825L));
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/ezenMini/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/ezenMini/WEB-INF/lib/jstl-1.2.jar!/META-INF/sql.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/ezenMini/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/views/carousel.jsp", Long.valueOf(1647311162626L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta id=\"_csrf\" name=\"_csrf\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/b4e02812b5.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<script src=\"/js/jquery.twbsPagination.js\"></script>\r\n");
      out.write("<title>Board</title>\r\n");
      out.write("<style>\r\n");
      out.write("html, body {\r\n");
      out.write("	height: 100%;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#main {\r\n");
      out.write("	height: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("thead tr {\r\n");
      out.write("	background-color: #A2A9B2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#write {\r\n");
      out.write("	height: 40%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/b4e02812b5.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- \r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("-->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write(".navbar {\r\n");
      out.write("	border-radius: 0;\r\n");
      out.write("	margin-bottom: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".nav-link {\r\n");
      out.write("	font-weight: 400;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#searchForm {\r\n");
      out.write("	visibility: hidden;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-expand-md bg-dark navbar-dark fixed-top font-weight-bold\">\r\n");
      out.write("	<a href=\"/mini\" class=\"navbar-brand\">\r\n");
      out.write("		<i class=\"fa-solid fa-c fa-bounce\"></i>\r\n");
      out.write("		<i class=\"fa-solid fa-a fa-bounce\"></i>\r\n");
      out.write("		<i class=\"fa-solid fa-r fa-bounce\"></i>\r\n");
      out.write("		<i class=\"fa-solid fa-l fa-bounce\"></i>\r\n");
      out.write("		<i class=\"fa-solid fa-h fa-bounce\"></i>\r\n");
      out.write("		<i class=\"fa-solid fa-a fa-bounce\"></i>\r\n");
      out.write("		<i class=\"fa-solid fa-r fa-bounce\"></i>\r\n");
      out.write("		<i class=\"fa-solid fa-r fa-bounce\"></i>\r\n");
      out.write("		<i class=\"fa-solid fa-t fa-bounce\"></i>\r\n");
      out.write("	</a>\r\n");
      out.write("	\r\n");
      out.write("	<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\r\n");
      out.write("		<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("	</button>\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n");
      out.write("		<ul class=\"navbar-nav\">\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"home\" class=\"nav-link\">Home</a>\r\n");
      out.write("			</li>\r\n");
      out.write("		\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"product\" class=\"nav-link\">Products</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"util\" class=\"nav-link\">Utils</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"stores\" class=\"nav-link\">Stores</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"contact\" class=\"nav-link\">Contact</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"portfolio\" class=\"nav-link\">Portfolio</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<!-- Dropdown -->\r\n");
      out.write("			<li class=\"nav-item dropdown\">\r\n");
      out.write("				<a href=\"#\" class=\"nav-link dropdown-toggle\" id=\"navbardrop\" data-toggle=\"dropdown\">알림</a>\r\n");
      out.write("				\r\n");
      out.write("				<div class=\"dropdown-menu\">\r\n");
      out.write("					<a href=\"notice\" class=\"dropdown-item\">공지사항</a>\r\n");
      out.write("					<a href=\"board\" class=\"dropdown-item\">게시판</a>\r\n");
      out.write("					<a href=\"qna\" class=\"dropdown-item\">Q&A</a>\r\n");
      out.write("				</div>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"#\" class=\"nav-link btn disabled\">Space</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"login_view\" class=\"nav-link\">Login</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"logout_view\" class=\"nav-link\">Logout</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"join_view\" class=\"nav-link\">Join</a>\r\n");
      out.write("			</li>\r\n");
      out.write("		</ul>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"#\" id=\"searchForm\" class=\"form-inline\">\r\n");
      out.write("		<button class=\"btn btn-primary mr-sm-2\" type=\"button\" disabled>\r\n");
      out.write("			<i class=\"fa fa-search\"></i>\r\n");
      out.write("		</button>\r\n");
      out.write("		<input type=\"text\" id=\"searchInput\" class=\"form-control mr-sm-2\" placeholder=\"Search\"/>\r\n");
      out.write("	</form>\r\n");
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/b4e02812b5.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- \r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("-->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("html, body {\r\n");
      out.write("	height: 100%;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#demo {\r\n");
      out.write("	margin-top: 3.7rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 이미지 크기만큼 지정해주는 것이 좋음 */\r\n");
      out.write(".carousel-inner img {\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	height: 400px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("														   <!-- 슬라이드되는 ms 지정 (default : 5s)-->\r\n");
      out.write("<div id=\"demo\" class=\"carousel slide mb-5\" data-ride=\"carousel\" data-interval=\"6000\">\r\n");
      out.write("	<ul class=\"carousel-indicators\">\r\n");
      out.write("		<!-- data-target : 슬라이드 이미지가 보여질 박스 지정 , data-slide-to : 몇번째 슬라이드인지 지정 , active : 현재 보여지고 있는 이미지 li -->\r\n");
      out.write("		<li data-target=\"#demo\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("		<li data-target=\"#demo\" data-slide-to=\"1\"></li>\r\n");
      out.write("		<li data-target=\"#demo\" data-slide-to=\"2\"></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 각각의 이미지가 담긴 박스 -->\r\n");
      out.write("	<div class=\"carousel-inner\">\r\n");
      out.write("		<div class=\"carousel-item active\">\r\n");
      out.write("			<img src=\"images/4.jpg\" alt=\"glasses\" width=\"1100\" height=\"500\" />\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"carousel-item text-dark\">\r\n");
      out.write("			<img src=\"images/5.jpg\" alt=\"shirt\" width=\"1100\" height=\"500\" />\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"carousel-item text-dark\">\r\n");
      out.write("			<img src=\"images/6.jpg\" alt=\"tee\" width=\"1100\" height=\"500\" />\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<a href=\"#demo\" class=\"carousel-control-prev\" data-slide=\"prev\">\r\n");
      out.write("		<span class=\"carousel-control-prev-icon text-dark\"></span>\r\n");
      out.write("	</a>\r\n");
      out.write("		<a href=\"#demo\" class=\"carousel-control-next\" data-slide=\"next\">\r\n");
      out.write("		<span class=\"carousel-control-next-icon text-dark\"></span>\r\n");
      out.write("	</a>\r\n");
      out.write("	\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"main\" class=\"container mt-5\">\r\n");
      out.write("	<h3 class=\"display-4 font-italic\">Board</h3>\r\n");
      out.write("\r\n");
      out.write("	<hr />\r\n");
      out.write("\r\n");
      out.write("	<a href=\"write_view\" id=\"write\" class=\"btn btn-sm btn-dark float-right mb-3\">글작성</a>	\r\n");
      out.write("	<table id=\"searchTable\" class=\"table table-hover text-center\">\r\n");
      out.write("		<thead>\r\n");
      out.write("			<tr class=\"row mx-0 text-white\">\r\n");
      out.write("				<th class=\"col-1\">번호</th>\r\n");
      out.write("				<th class=\"col-2\">작성자</th>\r\n");
      out.write("				<th class=\"col-4\">제목</th>\r\n");
      out.write("				<th class=\"col-3\">날짜</th>\r\n");
      out.write("				<th class=\"col-2\">히트수</th>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</thead>\r\n");
      out.write("		\r\n");
      out.write("		<tbody>\r\n");
      out.write("			");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("		</tbody>\r\n");
      out.write("	</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" id=\"boardOnly\">\r\n");
      out.write("	<nav aria-label=\"page navigation\">\r\n");
      out.write("		<ul class=\"pagination justify-content-center\" id=\"pagination\" style=\"margin: 20px 0;\">\r\n");
      out.write("		\r\n");
      out.write("		</ul>\r\n");
      out.write("		\r\n");
      out.write("	</nav>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/b4e02812b5.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- \r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("-->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("footer {\r\n");
      out.write("	height: auto;\r\n");
      out.write("	background-color: #f2f2f2;\r\n");
      out.write("	padding: 25px;	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".footer-title {\r\n");
      out.write("	font-style: italic;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<footer class=\"mt-5\">\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<h6 class=\"text-center display-4 footer-title mb-3\">Online Store Copyright</h6>\r\n");
      out.write("\r\n");
      out.write("		<form action=\"#\" method=\"post\" class=\"footer-frm row\">\r\n");
      out.write("			<div class=\"formgroup col-11\">\r\n");
      out.write("				<label for=\"email\">&nbsp;&nbsp;Get deals</label>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"Enter email\" />\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<button type=\"submit\" class=\"btn btn-danger col-1\">Sing Up</button>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("	$('#searchForm').css(\"visibility\", \"visible\");\r\n");
      out.write("	\r\n");
      out.write("	$('#write').click(function(e) {\r\n");
      out.write("		$('#searchForm').css(\"visibility\", \"hidden\");\r\n");
      out.write("		// a tag의 페이지 이동 기능을 막음, ajax로 현재페이지에 입력 form 페이지를 띄우기 위함\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : \"write_view\",\r\n");
      out.write("			type : \"get\",\r\n");
      out.write("			success : function(data) {\r\n");
      out.write("				$('#main').html(data);\r\n");
      out.write("				$('#boardOnly').css('display','none');\r\n");
      out.write("			},\r\n");
      out.write("			error : function(data) {\r\n");
      out.write("				console.log(data);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/board.jsp(67,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/board.jsp(67,3) '${listContent}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${listContent}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/board.jsp(67,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("dto");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("				<tr class=\"row mx-0\">\r\n");
            out.write("					<td id=\"bid\" class=\"col-1\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.bId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("					<td class=\"col-2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.bName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("					<td class=\"col-4\">\r\n");
            out.write("						");
            if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return true;
            out.write("\r\n");
            out.write("						<a href=\"content_view?bId=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.bId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"content_view text-dark\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.bTitle}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a>\r\n");
            out.write("					</td>\r\n");
            out.write("					<td class=\"col-3\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.bDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("					<td class=\"col-2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.bHit}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("				</tr>\r\n");
            out.write("			");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /WEB-INF/views/board.jsp(72,6) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setBegin(1);
      // /WEB-INF/views/board.jsp(72,6) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.bIndent}", int.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).intValue());
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write('-');
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }
}
