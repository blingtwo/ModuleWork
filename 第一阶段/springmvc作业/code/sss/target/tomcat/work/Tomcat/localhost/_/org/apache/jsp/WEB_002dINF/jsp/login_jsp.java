/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-17 10:27:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>简历登录系统</title>\r\n");
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
      out.write("\r\n");
      out.write("        .login-wrapper {\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("            width: 250px;\r\n");
      out.write("            height: 500px;\r\n");
      out.write("            padding: 0 50px;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 50%;\r\n");
      out.write("            border-radius: 15px;\r\n");
      out.write("            top:50%;\r\n");
      out.write("            transform: translate(-50%,-50%);\r\n");
      out.write("        }\r\n");
      out.write("        .login-wrapper .header {\r\n");
      out.write("            font-size:  30px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            line-height: 200px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-wrapper .form-wrapper .input-item {\r\n");
      out.write("            display: block;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            border-bottom: 2px solid rgb(128,125,125);\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("            outline: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-wrapper .form-wrapper .input-item::placeholder {\r\n");
      out.write("            text-transform: uppercase;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-wrapper .form-wrapper .btn {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            padding: 5px;\r\n");
      out.write("            margin-top: 40px;\r\n");
      out.write("            background-image: linear-gradient(to right,#fbc2eb,#a6c1ee);;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-wrapper  .msg {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            line-height: 80px;\r\n");
      out.write("            font-size: small;\r\n");
      out.write("            color: #ee2a37;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-wrapper  .msg a  {\r\n");
      out.write("            text-decoration-line:  none;\r\n");
      out.write("            color: #a6c1ee;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-button-box{\r\n");
      out.write("            margin-top: 12px;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            margin-left: auto;\r\n");
      out.write("            margin-right: auto;\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            background-image: linear-gradient(to right,#fbc2eb,#a6c1ee);;\r\n");
      out.write("            color: #000000;\r\n");
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
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"login-wrapper\">\r\n");
      out.write("        <div class=\"header\">简历登录系统</div>\r\n");
      out.write("        <div class=\"form-wrapper\">\r\n");
      out.write("            <form action=\"/login/handler\" method=\"post\">\r\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"username\" class=\"input-item\">\r\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"password\" class=\"input-item\">\r\n");
      out.write("                <input class=\"login-button-box\" type=\"submit\" value=\"登陆\">\r\n");
      out.write("                <input class=\"login-button-box\" type=\"reset\" value=\"取消\">\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"mm\" style=\"display: none\">");
      out.print(request.getAttribute("message"));
      out.write("</div>\r\n");
      out.write("        <div id=\"mg\" class=\"msg\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var value = document.getElementById('mm').innerText.valueOf();\r\n");
      out.write("    if (value == \"您还没登录，请先登录！\") {\r\n");
      out.write("        alert(value);\r\n");
      out.write("        document.getElementById('mg').innerText = value;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
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
