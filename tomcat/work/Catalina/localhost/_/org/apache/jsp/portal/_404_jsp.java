package org.apache.jsp.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.net.URL;
import java.lang.Exception;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.beans.Host;
import com.dotmarketing.business.web.WebAPILocator;
import com.dotmarketing.business.CacheLocator;
import com.dotmarketing.util.Logger;
import com.dotmarketing.db.DbConnectionFactory;
import org.apache.commons.lang.StringEscapeUtils;
import com.liferay.portal.util.ImageKey;
import com.liferay.portal.util.WebKeys;
import com.liferay.portal.language.LanguageUtil;
import com.liferay.portal.model.Company;
import com.dotmarketing.util.CompanyUtils;
import com.dotmarketing.cache.LiveCache;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
try{		

	Host host = WebAPILocator.getHostWebAPI().getCurrentHost(request);
	Host defaultHost = WebAPILocator.getHostWebAPI().findDefaultHost(WebAPILocator.getUserWebAPI().getSystemUser(),false);
	Company company = CompanyUtils.getDefaultCompany();
	String portalUrl =  company.getPortalURL();
	String IMAGE_PATH = (String) application.getAttribute(WebKeys.IMAGE_PATH);
	String defaultImage =  IMAGE_PATH+"/company_logo?img_id="+company.getCompanyId()+"&key="+ImageKey.get(company.getCompanyId());
	
	// Save 404 request
	com.dotmarketing.factories.ClickstreamFactory.add404Request(request,response,host);


	
	String ep_originatingHost = host.getHostname();
	String ep_errorCode = "404";
	String ep_error_uri = (String)request.getAttribute("javax.servlet.forward.request_uri");
	
	// Get 404 from virtual link
	String pointer = (String) com.dotmarketing.cache.VirtualLinksCache.getPathFromCache(host.getHostname() + ":/cms404Page");
	if (!UtilMethods.isSet(pointer)) {
		pointer = (String) com.dotmarketing.cache.VirtualLinksCache.getPathFromCache("/cms404Page");
	}
	
	Logger.debug(this, "cms404Page path is: " + pointer);
	
	// if we have a virtual link, see if the page exists.  pointer will be set to null if not
	if (UtilMethods.isSet(pointer)) {
		if (pointer.startsWith("/")) {
		// if the virtual link is a relative path, the path is validated within the current host
			pointer = com.dotmarketing.cache.LiveCache.getPathFromCache(pointer, host);	
			Logger.debug(this, "cms404Page relative path is: " + pointer + " - host: " + host.getHostname() + " and pointer: " + pointer);
		} else {
		// if virtual link points to a host or alias in dotCMS server, the path needs to be validated.
		// Otherwise, the original external pointer is kept for the redirect

			try {
				URL errorPageUrl = new URL(pointer);
				String errorPageHost = errorPageUrl.getHost();
				String errorPagePath = errorPageUrl.getPath();
				
				Logger.debug(this, "cms404Page - errorPageHost: " + errorPageHost + " and errorPagePath: " + errorPagePath);
				
				Host internalHost = WebAPILocator.getHostWebAPI().findByName(errorPageHost, WebAPILocator.getUserWebAPI().getAnonymousUser(), true);
				Host internalAlias = WebAPILocator.getHostWebAPI().findByAlias(errorPageHost, WebAPILocator.getUserWebAPI().getAnonymousUser(), true);
				
				// 404 Virtual Link is pointing to a host in dotCMS
				if ( internalHost != null) {				
					String absPointer = com.dotmarketing.cache.LiveCache.getPathFromCache(errorPagePath, internalHost);
					if (absPointer == null) {
						pointer = null;
					}
					Logger.debug(this, "cms404Page absolute internal path is: " + pointer + " - internalHost: " + internalHost.getHostname() + " and errorPagePath: " + errorPagePath);
				
				// 404 Virtual Link is poiting to an alias in dotCMS
				} else if ( internalAlias != null) {
					String absPointer = com.dotmarketing.cache.LiveCache.getPathFromCache(errorPagePath, internalAlias);
					if (absPointer == null) {
						pointer = null;
					}
					Logger.debug(this, "cms404Page absolute internal path is: " + pointer + " - internalAlias: " + internalAlias.getHostname() + " and errorPagePath: " + errorPagePath);
				
				// 404 Virtual Link is pointing to an external page
				} else {
					Logger.debug(this, "cms404Page absolute external path is: " + pointer);
				}
					
			} catch (Exception e){
				Logger.error(this, "cms404Page path is incorrect: " + pointer + e.getMessage(), e);
				pointer = null;
			}
		}
	}
	
	// if we have virtual link and page exists, redirect or forward
	if(UtilMethods.isSet(pointer) ){
		if (pointer.startsWith("/")) {
			Logger.debug(this, "cms404Page forwarding to relative path: " + pointer);			
			request.getRequestDispatcher(pointer+ "?ep_originatingHost="+ep_originatingHost+"&ep_errorCode="+ep_errorCode+"&ep_error_uri="+ep_error_uri).forward(request, response);
			
		} else {
			pointer = pointer + "?ep_originatingHost="+ep_originatingHost+"&ep_errorCode="+ep_errorCode+"&ep_error_uri="+ep_error_uri;
			Logger.debug(this, "cms404Page redirecting to absolute path: " + pointer);
			response.sendRedirect(pointer);
		}
		return;
	}

	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\t\r\n");
      out.write("\t<html>\r\n");
      out.write("\t\t<head>\r\n");
      out.write("\t\t\t<link rel=\"shortcut icon\" href=\"http://");
      out.print(defaultHost.getHostname());
      out.write("/home/favicon.ico\"\" type=\"image/x-icon\">\r\n");
      out.write("\t\t    <script>\r\n");
      out.write("\t\t        function showError(){\r\n");
      out.write("\t\t            var ele = document.getElementById(\"error\");\r\n");
      out.write("\t\t            if(ele.style.display==\"none\"){\r\n");
      out.write("\t\t                ele.style.display=\"\";\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t            else{\r\n");
      out.write("\t\t                ele.style.display=\"none\";\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t    </script>\r\n");
      out.write("\t\t\t<title>");
      out.print( LanguageUtil.get(pageContext,"404-page-title") );
      out.write("</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\tbody{\r\n");
      out.write("\t\t\tfont-family: verdana, helvetica, san-serif;\r\n");
      out.write("\t\t\tpadding:20px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#main {\r\n");
      out.write("\t\t\twidth: 400px;\r\n");
      out.write("\t\t\tfont-family: verdana, helvetica, san-serif;\r\n");
      out.write("\t\t\tfont-size: 12px;\r\n");
      out.write("\t\t\tmargin-left:auto;\r\n");
      out.write("\t\t\tmargin-right:auto;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#footer {\r\n");
      out.write("\t\t\ttext-align:center;\r\n");
      out.write("\t\t\tfont-family: verdana, helvetica, san-serif;\r\n");
      out.write("\t\t\tfont-size: 12px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\th1 {\r\n");
      out.write("\t\t\tfont-family: verdana, helvetica, san-serif;\r\n");
      out.write("\t\t\tfont-size: 20px;\r\n");
      out.write("\t\t\ttext-decoration: none;\r\n");
      out.write("\t\t\tfont-weight: normal;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#logo{\r\n");
      out.write("\t\t\tfloat: left;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#text{\r\n");
      out.write("\t\t\tfloat: left;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</head>\r\n");
      out.write("\t\t<body>\r\n");
      out.write("\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t    <a href=\"http://");
      out.print(portalUrl);
      out.write("/\"><img src=\"");
      out.print(defaultImage);
      out.write("\" width=\"140\"  hspace=\"10\" border=\"0\" alt=\"");
      out.print(LanguageUtil.get(pageContext,"404-image-title"));
      out.write("\" title=\"");
      out.print(LanguageUtil.get(pageContext,"404-image-title"));
      out.write("\"  /></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"text\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<h1>");
      out.print( LanguageUtil.get(pageContext,"404-title") );
      out.write("</h1>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<p>");
      out.print( LanguageUtil.get(pageContext,"404-body1") );
      out.write("</p>\r\n");
      out.write("\t\t\t\t<p>");
      out.print( LanguageUtil.get(pageContext,"404-body2") );
      out.write("</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br clear=\"all\"/>&nbsp;<br clear=\"all\"/>\r\n");
      out.write("\t\t<div id=\"footer\">&copy; <script>var d = new Date();document.write(d.getFullYear());</script>, <a href=\"http://");
      out.print(portalUrl);
      out.write('"');
      out.write('>');
      out.print( LanguageUtil.get(pageContext,"404-copywright") );
      out.write("</a></div>\r\n");
      out.write("\t\t<br clear=\"all\"/>&nbsp;<br clear=\"all\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
} catch( Exception e){
	Logger.error(this, "cms404Page cant display " + e.getMessage(), e);	
      out.write("\r\n");
      out.write("404\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
 }finally{
	DbConnectionFactory.closeConnection();
}
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
