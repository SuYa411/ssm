/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-06-15 13:22:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
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
      out.write("<div class=\"content-wrapper\">\r\n");
      out.write("    <!-- Content Header (Page header) -->\r\n");
      out.write("    <section class=\"content-header\">\r\n");
      out.write("        <h1>\r\n");
      out.write("            404 错误页面\r\n");
      out.write("        </h1>\r\n");
      out.write("\r\n");
      out.write("        <ol class=\"breadcrumb\">\r\n");
      out.write("            <li><a href=\"all-admin-index.html\"><i class=\"fa fa-dashboard\"></i> 首页</a></li>\r\n");
      out.write("            <li class=\"active\">404 错误</li>\r\n");
      out.write("        </ol>\r\n");
      out.write("\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    <!-- Main content -->\r\n");
      out.write("    <section class=\"content\">\r\n");
      out.write("        <div class=\"error-page\">\r\n");
      out.write("            <h2 class=\"headline text-yellow\"> 404</h2>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"error-content\">\r\n");
      out.write("                <h3><i class=\"fa fa-warning text-yellow\"></i> Oops! 页面没有找到.</h3>\r\n");
      out.write("\r\n");
      out.write("                <p>\r\n");
      out.write("                    没有找到你请求的页面, 你可以 <a href=\"login.jsp\">返回到后台首页</a> 或者通过搜索查询\r\n");
      out.write("                </p>\r\n");
      out.write("\r\n");
      out.write("                <form class=\"search-form\">\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <input type=\"text\" name=\"search\" class=\"form-control\" placeholder=\"搜索\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-group-btn\">\r\n");
      out.write("                            <button type=\"submit\" name=\"submit\" class=\"btn btn-warning btn-flat\"><i class=\"fa fa-search\"></i>\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.input-group -->\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.error-content -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.error-page -->\r\n");
      out.write("    </section>\r\n");
      out.write("    <!-- /.content -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("        setSidebarActive(\"admin-404\");\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
