/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2021-02-24 01:44:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.webpage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-inverse log\" >\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>                        \r\n");
      out.write("      </button>\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">\r\n");
      out.write("        <img  id=\"ilogo\" src=\"../images/gsjLogo2.png\">\r\n");
      out.write("      </a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n");
      out.write("      \r\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("        <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\r\n");
      out.write("        <li><a href=\"#\"><span class=\"glyphicon glyphicon-heart\"></span>회원가입</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>                        \r\n");
      out.write("      </button>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\">\r\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("         \r\n");
      out.write("         <li class=\"dropdown\">\r\n");
      out.write("  \t\t\t<a class=\"dropdown-toggle\"  data-toggle=\"dropdown\">마이페이지\r\n");
      out.write("\t\t    <span class=\"caret\"></span></a>\r\n");
      out.write("\t\t    <ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t    <li><a href=\"#\">내정보수정</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">적립금</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">보관함</a></li>\r\n");
      out.write("\t\t    </ul>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<li class=\"dropdown\">\r\n");
      out.write("  \t\t\t<a class=\"dropdown-toggle\"  data-toggle=\"dropdown\">이벤트\r\n");
      out.write("\t\t    <span class=\"caret\"></span></a>\r\n");
      out.write("\t\t    <ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t    <li><a href=\"#\">진행중인이벤트</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">반짝세일</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">1+1</a></li>\r\n");
      out.write("\t\t    </ul>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<li class=\"dropdown\">\r\n");
      out.write("  \t\t\t<a class=\"dropdown-toggle\"  data-toggle=\"dropdown\">게시판\r\n");
      out.write("\t\t    <span class=\"caret\"></span></a>\r\n");
      out.write("\t\t    <ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t    <li><a href=\"#\">공지게시판</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">자유게시판</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">QNA</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">자료실</a></li>\r\n");
      out.write("\t\t    </ul>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("       \r\n");
      out.write("      </ul>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
