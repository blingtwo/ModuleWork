/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-17 10:27:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>修改</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        * {\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            font-family: 'Open Sans Light';\r\n");
      out.write("            letter-spacing: .05em;\r\n");
      out.write("        }\r\n");
      out.write("        html {\r\n");
      out.write("            height: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            height: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container {\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background-image: linear-gradient(to right,#fbc2eb, #b5d0ee);\r\n");
      out.write("        }\r\n");
      out.write("        .login-wrapper {\r\n");
      out.write("\r\n");
      out.write("            width: 280px;\r\n");
      out.write("            height: 500px;\r\n");
      out.write("            padding: 0 50px;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 50%;\r\n");
      out.write("            border-radius: 15px;\r\n");
      out.write("            top:50%;\r\n");
      out.write("            transform: translate(-50%,-50%);\r\n");
      out.write("        }\r\n");
      out.write("        #hor-minimalist-a\r\n");
      out.write("        {\r\n");
      out.write("            font-family: \"Lucida Sans Unicode\", \"Lucida Grande\", Sans-Serif;\r\n");
      out.write("            font-size: 12px;\r\n");
      out.write("            width: 280px;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("        }\r\n");
      out.write("        #hor-minimalist-a th\r\n");
      out.write("        {\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            font-weight: normal;\r\n");
      out.write("            color: #039;\r\n");
      out.write("            padding: 10px 8px;\r\n");
      out.write("            border-bottom: 2px solid #6678b1;\r\n");
      out.write("        }\r\n");
      out.write("        #hor-minimalist-a td\r\n");
      out.write("        {\r\n");
      out.write("            color: #669;\r\n");
      out.write("            padding: 9px 8px 0px 8px;\r\n");
      out.write("        }\r\n");
      out.write("        #hor-minimalist-a tbody tr:hover td\r\n");
      out.write("        {\r\n");
      out.write("            color: #009;\r\n");
      out.write("        }\r\n");
      out.write("        .login-button-box{\r\n");
      out.write("            margin-top: 12px;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            margin-left: auto;\r\n");
      out.write("            margin-right: auto;\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-button-box button{\r\n");
      out.write("            background-color: #ff7d0a;\r\n");
      out.write("            color: #ffffff;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            width: 386px;\r\n");
      out.write("            height: 40px;\r\n");
      out.write("            margin-left: 18px;\r\n");
      out.write("            border: 1px solid #ff7d0a;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-button-box button:hover{\r\n");
      out.write("            background-color: #ee7204;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-button-box button:active{\r\n");
      out.write("            background-color: #ee7204;\r\n");
      out.write("        }\r\n");
      out.write("        .is {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"login-wrapper\">\r\n");
      out.write("        <form method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resume/editSave\">\r\n");
      out.write("            <table id=\"hor-minimalist-a\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><input type=\"hidden\" name=\"id\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${theResume.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>姓名</td>\r\n");
      out.write("                    <td><input class=\"is\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${theResume.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>地址</td>\r\n");
      out.write("                    <td><input class=\"is\" name=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${theResume.address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>电话</td>\r\n");
      out.write("                    <td><input class=\"is\" name=\"phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${theResume.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td colspan=\"2\"><input class=\"login-button-box\" type=\"submit\" value=\"确定\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
