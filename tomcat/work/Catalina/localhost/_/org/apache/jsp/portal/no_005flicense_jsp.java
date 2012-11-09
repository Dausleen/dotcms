package org.apache.jsp.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dotmarketing.db.DbConnectionFactory;

public final class no_005flicense_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n");
      out.write("\t\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function showError(){\r\n");
      out.write("            var ele = document.getElementById(\"error\");\r\n");
      out.write("            if(ele.style.display==\"none\"){\r\n");
      out.write("                ele.style.display=\"\";\r\n");
      out.write("            }\r\n");
      out.write("            else{\r\n");
      out.write("                ele.style.display=\"none\";\r\n");
      out.write("            }\r\n");
      out.write("        \r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("        <title>dotCMS: No License Error</title>\r\n");
      out.write("\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("\t\t\tbody{\r\n");
      out.write("\t\t\t\tfont-family: verdana, helvetica, san-serif;\r\n");
      out.write("\t\t\t\tpadding:20px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#main {\r\n");
      out.write("\t\t\t\twidth: 400px;\r\n");
      out.write("\t\t\t\tfont-family: verdana, helvetica, san-serif;\r\n");
      out.write("\t\t\t\tfont-size: 12px;\r\n");
      out.write("\t\t\t\tmargin-left:auto;\r\n");
      out.write("\t\t\t\tmargin-right:auto;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#footer {\r\n");
      out.write("\t\t\t\ttext-align:center;\r\n");
      out.write("\t\t\t\tfont-family: verdana, helvetica, san-serif;\r\n");
      out.write("\t\t\t\tfont-size: 12px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\th1 {\r\n");
      out.write("\t\t\t\tfont-family: verdana, helvetica, san-serif;\r\n");
      out.write("\t\t\t\tfont-size: 20px;\r\n");
      out.write("\t\t\t\ttext-decoration: none;\r\n");
      out.write("\t\t\t\tfont-weight: normal;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#logo{\r\n");
      out.write("\t\t\t\tfloat: left;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#text{\r\n");
      out.write("\t\t\t\tfloat: left;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"main\">\r\n");
      out.write("            <div id=\"logo\">\r\n");
      out.write("                <a href=\"http://dotcms.com\"><img src=\"/html/images/skin/logo.gif?code=500\"  height=\"50\" hspace=\"10\" border=\"0\" alt=\"dotCMS content management system\" title=\"dotCMS content management system\"  /></a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"text\">\r\n");
      out.write("\t\r\n");
      out.write("                <h1>Invalid License</h1>\r\n");
      out.write("\t\t\r\n");
      out.write("                This server does not have valid dotCMS license.  \r\n");
      out.write("                If you are the administrator for this site,  please contact \r\n");
      out.write("                <a href=\"http://dotcms.com/contact-us\">dotCMS</a> for \r\n");
      out.write("                more information or request a trial license via the \r\n");
      out.write("                license manager admin tool.\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br clear=\"all\"/>&nbsp;<br clear=\"all\"/>\r\n");
      out.write("        <div id=\"footer\">&copy; \r\n");
      out.write("<div id=\"footer\">&copy; <script>var d = new Date();document.write(d.getFullYear());</script>, <a href=\"http://dotcms.com\">DM Web, Corp.</a></div>\r\n");
      out.write("        <br clear=\"all\"/>&nbsp;<br clear=\"all\"/>\r\n");
      out.write("<div id=\"error\" style=\"display: none;border: 1px #cccccc solid; padding:10px; margin:10px;width:80%\">\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
 
	DbConnectionFactory.closeConnection();

      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
