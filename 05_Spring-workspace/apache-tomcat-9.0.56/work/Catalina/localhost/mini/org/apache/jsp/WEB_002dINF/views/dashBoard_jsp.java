/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-03-28 01:10:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashBoard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(9);
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/ezenMini/WEB-INF/lib/jstl-1.2.jar!/META-INF/x.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/views/nav.jsp", Long.valueOf(1648168922596L));
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
  }

  public void _jspDestroy() {
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
      out.write("\r\n");
      out.write("<!-- dashboard 용 script cdn -->\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js\"></script>\r\n");
      out.write("<title>DashBoard</title>\r\n");
      out.write("\r\n");
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
      out.write("</style>\r\n");
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
      out.write("				<a href=\"folio\" class=\"nav-link\">Portfolio</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			\r\n");
      out.write("			<li class=\"nav-item\">\r\n");
      out.write("				<a href=\"dash\" class=\"nav-link\">Dash</a>\r\n");
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
      out.write("<br /><br />\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("	<a href=\"bar\" id=\"bar\" class=\"btn btn-primary\"><i class=\"fa-solid fa-chart-column\"></i></a>&nbsp;&nbsp;\r\n");
      out.write("	<a href=\"pie\" id=\"pie\" class=\"btn btn-danger\"><i class=\"fa-solid fa-chart-pie\"></i></a>&nbsp;&nbsp;\r\n");
      out.write("	<a href=\"line\" id=\"line\" class=\"btn btn-success\"><i class=\"fa-solid fa-chart-line\"></i></a>&nbsp;&nbsp;\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"main\" class=\"container mt-5\">\r\n");
      out.write("	<canvas id=\"canvas\" style=\"min-height: 350px;\"></canvas>\r\n");
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
      out.write("	var chartLabels = [];\r\n");
      out.write("	var chartData1 = [];\r\n");
      out.write("	var chartData2 = [];\r\n");
      out.write("	\r\n");
      out.write("	// 그래프를 그릴 수 있도록 가공해둔 변수\r\n");
      out.write("	var lineChartData = {\r\n");
      out.write("			// 그래프의 기본 x축 값\r\n");
      out.write("			labels : chartLabels,\r\n");
      out.write("			datasets : [	// 그래프에 표시 할 데이터 값 chartData1, chartData2를 수용\r\n");
      out.write("				{\r\n");
      out.write("					label : \"월별 pc 판매량\", //데이터 종류 이름\r\n");
      out.write("					fillColor : \"rgba(220, 220, 220, 0.2)\", //그래프 색\r\n");
      out.write("					strokeColor : \"rgba(220, 220, 220, 1)\", //선 색\r\n");
      out.write("					pointColor : \"rgba(220, 220, 220, 1)\",\r\n");
      out.write("					pointStrokeColor : \"#fff\",\r\n");
      out.write("					pointHightlightFill : \"#fff\",\r\n");
      out.write("					pointHightlightStroke : \"rgba(220, 220, 220, 1)\",\r\n");
      out.write("					data : chartData1\r\n");
      out.write("				},\r\n");
      out.write("				{\r\n");
      out.write("					label : \"월별 모니터 판매량\", //데이터 종류 이름\r\n");
      out.write("					fillColor : \"rgba(151, 187, 205, 0.2)\", //그래프 색\r\n");
      out.write("					strokeColor : \"rgba(151, 187, 205, 1)\", //선 색\r\n");
      out.write("					pointColor : \"rgba(151, 187, 205, 1)\",\r\n");
      out.write("					pointStrokeColor : \"#fff\",\r\n");
      out.write("					pointHightlightFill : \"#fff\",\r\n");
      out.write("					pointHightlightStroke : \"rgba(151, 187, 205, 1)\",\r\n");
      out.write("					data : chartData2\r\n");
      out.write("				}\r\n");
      out.write("			]\r\n");
      out.write("	};\r\n");
      out.write("	\r\n");
      out.write("	function createChart(){\r\n");
      out.write("		let ctx = document.getElementById(\"canvas\").getContext(\"2d\"); //그림그리기 객체\r\n");
      out.write("		// Chart.Line() 메서드는 Chartjs에서 제공한 막대그래프 그리기 메서드\r\n");
      out.write("		LineChartDemo = Chart.Line(ctx,{ //그림그리기 객체를 이용해서 \r\n");
      out.write("			data : lineChartData,  //사용할 데이터\r\n");
      out.write("			options : {\r\n");
      out.write("				scales : { // 눈금표시\r\n");
      out.write("					yAxes : [ // y축\r\n");
      out.write("						{\r\n");
      out.write("							ticks : {\r\n");
      out.write("								beginAtZero : true // 0에서부터 시작\r\n");
      out.write("							}	\r\n");
      out.write("						}\r\n");
      out.write("					]\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url : \"dashView\", //서버에서 그래프용 데이터 처리 요청\r\n");
      out.write("		type : \"post\",\r\n");
      out.write("		data : { //서버로 보내는 데이터(여러개 보낼 시 객체형으로 보냄)\r\n");
      out.write("			cmd : \"chart\", //getParameter로 처리\r\n");
      out.write("			subcmd : \"line\", // line 방식으로 \r\n");
      out.write("			");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(':');
      out.write('"');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("		},\r\n");
      out.write("		dataType : \"json\", //서버에서 오는 데이터형\r\n");
      out.write("	 	success : function(result){ // result는 서버에서 오는 json형태 값\r\n");
      out.write("	 		// .each함수는 자바의 enhanced for문\r\n");
      out.write("	 		// result.datas는 배열형 객체, index는 색인번호, obj는 현재 객체\r\n");
      out.write("	 		$.each(result.datas, function(index, obj){ \r\n");
      out.write("	 			chartLabels.push(obj.month); //배열 마지막에 값 넣어 주는 메서드 push()\r\n");
      out.write("	 			chartData1.push(obj.pc);\r\n");
      out.write("	 			chartData2.push(obj.monitor);\r\n");
      out.write("	 		});\r\n");
      out.write("	 		createChart(); // 변수에 값 다 넣은 후 createChart() 메서드 실행\r\n");
      out.write("	 	},\r\n");
      out.write("	 	error : function(){\r\n");
      out.write("	 		alert(\"There is an error : method(group)에 에러가 있습니다.\")\r\n");
      out.write("	 	}\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$('#bar').click(function(event) {\r\n");
      out.write("	event.preventDefault();\r\n");
      out.write("	\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url: 'bar',\r\n");
      out.write("		type: 'get',\r\n");
      out.write("		success: function(data) {\r\n");
      out.write("			$('#main').html(data);\r\n");
      out.write("		},\r\n");
      out.write("		error : function() {\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$('#pie').click(function(event) {\r\n");
      out.write("	event.preventDefault();\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url: 'pie',\r\n");
      out.write("		type: 'get',\r\n");
      out.write("		success: function(data) {\r\n");
      out.write("			$('#main').html(data);\r\n");
      out.write("		},\r\n");
      out.write("		error : function() {\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$('#line').click(function(event) {\r\n");
      out.write("	event.preventDefault();\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url: 'line',\r\n");
      out.write("		type: 'get',\r\n");
      out.write("		success: function(data) {\r\n");
      out.write("			$('#main').html(data);\r\n");
      out.write("		},\r\n");
      out.write("		error : function() {\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
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
}
