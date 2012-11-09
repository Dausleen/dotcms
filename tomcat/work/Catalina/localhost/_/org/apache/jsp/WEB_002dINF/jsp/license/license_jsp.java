package org.apache.jsp.WEB_002dINF.jsp.license;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dotmarketing.util.UtilMethods;
import java.util.Date;
import com.liferay.portal.language.LanguageUtil;
import com.dotcms.enterprise.LicenseUtil;
import java.text.SimpleDateFormat;

public final class license_jsp extends org.apache.jasper.runtime.HttpJspBase
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


String error=null;
String message=null;
if (request.getMethod().equalsIgnoreCase("POST") ) {
	error=LicenseUtil.processForm(request);
	

}


boolean isCommunity = ("100".equals(System.getProperty("dotcms_level")));

String expireString = "unknown";
Date expires = null;
try{
	expires = new Date(Long.parseLong(System.getProperty("dotcms_valid_until")));
    SimpleDateFormat format =
        new SimpleDateFormat("MMMM d, yyyy");
    expireString=  format.format(expires);
}
catch(Exception e){
	
}
boolean expired = (expires !=null && expires.before(new Date()));



String licenseFormStr = LicenseUtil.getRequestForm();

if(!UtilMethods.isSet(licenseFormStr)){
	licenseFormStr = LanguageUtil.get(pageContext, "Behind-A-Proxy-Request-A-License");
	
}








      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
if(UtilMethods.isSet(error)){ 
      out.write("\r\n");
      out.write("\tshowDotCMSSystemMessage(\"");
      out.print(error );
      out.write("\");\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction showRequestLicense(){\r\n");
      out.write("\r\n");
      out.write("       var myDialog = dijit.byId(\"dotRequestLicenseDialog\");\r\n");
      out.write("       myDialog.show();\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("function doShowHideRequest(){\r\n");
      out.write("\t\r\n");
      out.write("\tif(dijit.byId(\"pasteRadio\").checked){\r\n");
      out.write("\t\tdojo.style(\"pasteMe\", \"display\", \"\");\r\n");
      out.write("\t\tdojo.style(\"requestMe\", \"display\", \"none\");\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdojo.style(\"pasteMe\", \"display\", \"none\");\r\n");
      out.write("\t\tdojo.style(\"requestMe\", \"display\", \"\");\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function doPaste(){\r\n");
      out.write("\tif(!");
      out.print(isCommunity);
      out.write("){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!confirm(\"");
      out.print( LanguageUtil.get(pageContext, "confirm-license-override") );
      out.write("\")){\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdojo.byId(\"uploadLicenseForm\").submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"portlet-wrapper\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"min-height:400px;\" id=\"borderContainer\" class=\"shadowBox headerBox\">\t\t\t\t\t\t\t\r\n");
      out.write("\t \t<div style=\"padding:7px;\">\r\n");
      out.write("\t\t \t<div>\r\n");
      out.write("\t\t\t\t<h3>");
      out.print( LanguageUtil.get(pageContext, "javax.portlet.title.EXT_LICENSE_MANAGER") );
      out.write("</h3>\r\n");
      out.write("\t\t  \t</div>\r\n");
      out.write("\t\t\t\t<br clear=\"all\">\r\n");
      out.write("\t  \t</div>\r\n");
      out.write("\t  \r\n");
      out.write("\t\t\t");
if(request.getAttribute("LICENSE_APPLIED_SUCCESSFULLY") != null){ 
      out.write("\r\n");
      out.write("\t\t\t\t<div style=\"margin-left:auto;margin-right:auto;width:600px;\" class=\"callOutBox\">\r\n");
      out.write("\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "license-trial-applied-successfully") );
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<form name=\"query\" id=\"uploadLicenseForm\" action=\"");
      out.print( com.dotmarketing.util.PortletURLUtil.getRenderURL(request,null,null,"EXT_LICENSE_MANAGER") );
      out.write("\" method=\"post\" onsubmit=\"return false;\">\r\n");
      out.write("\t\t\t<div style=\"width:600px;margin:auto;border:1px solid silver;padding:20px;background:#eee;\">\r\n");
      out.write("\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t<span class='");
if(isCommunity){  
      out.write("lockIcon");
}else{ 
      out.write("unlockIcon");
} 
      out.write("'></span>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "license-level") );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>");
      out.print( System.getProperty("dotcms_level_name")  );
      out.write("\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t");
 if (!isCommunity) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<dt>");
      out.print( LanguageUtil.get(pageContext, "license-valid-until") );
      out.write(":</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>");
if(expired){ 
      out.write("<font color=\"red\">");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( expireString);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
if(expired){ 
      out.write(" (expired)</font>");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t\t<dt>");
      out.print( LanguageUtil.get(pageContext, "licensed-to") );
      out.write("</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>");
      out.print(  UtilMethods.isSet(System.getProperty("dotcms_license_client_name")) ? System.getProperty("dotcms_license_client_name") + "": "No License Found" );
      out.write("</dd>\r\n");
      out.write("\t\t\t\t\t\t<dt>");
      out.print( LanguageUtil.get(pageContext, "license-serial") );
      out.write("</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>");
      out.print(  UtilMethods.isSet(System.getProperty("dotcms_license_serial")) ? System.getProperty("dotcms_license_serial") : "No License Found" );
      out.write("</dd>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
if(isCommunity){ 
      out.write("\r\n");
      out.write("\t\t\t\t<div style=\"margin:auto;width:500px;padding-top:30px;\">\r\n");
      out.write("\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "license-trial-promo") );
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<div style=\"margin:auto;width:600px;padding:20px;padding-top:0px;\">\r\n");
      out.write("\t\t\t\t<dl style=\"padding:20px;\">\r\n");
      out.write("\t\t\t\t\t");
if(isCommunity){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<dt>");
      out.print( LanguageUtil.get(pageContext, "I-want-to") );
      out.write(":</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<input onclick=\"doShowHideRequest()\" type=\"radio\" checked=\"true\" name=\"iwantTo\" id=\"requestRadio\"  dojoType=\"dijit.form.RadioButton\" value=\"request_license\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"requestRadio\">");
      out.print( LanguageUtil.get(pageContext, "request-trial-license") );
      out.write("</label><br/>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<input onclick=\"doShowHideRequest()\"  type=\"radio\" name=\"iwantTo\" id=\"pasteRadio\"  dojoType=\"dijit.form.RadioButton\" value=\"paste_license\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"pasteRadio\">");
      out.print( LanguageUtil.get(pageContext, "I-already-have-a-license") );
      out.write("</label><br/>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t \t\t<dt>\r\n");
      out.write("\t\t\t\t\t<dd id=\"requestMe\" style=\"");
if(!isCommunity){ 
      out.write("display:none");
} 
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<button  id=\"requestTrialButton\" iconClass=\"keyIcon\" onclick=\"showRequestLicense()\"  dojoType=\"dijit.form.Button\" value=\"request_trial\">");
      out.print( LanguageUtil.get(pageContext, "request-trial-license") );
      out.write("</button>\r\n");
      out.write("\t\t\t\t\t\t<br />&nbsp;<br>");
      out.print( LanguageUtil.get(pageContext, "license-you-request-will-automatically-be-downloaded-and-installed") );
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"upload_button\" value=\"true\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<dd id=\"pasteMe\" style=\"");
if(isCommunity){ 
      out.write("display:none");
} 
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<b>");
      out.print( LanguageUtil.get(pageContext, "paste-your-license") );
      out.write("</b>:<br><textarea rows=\"10\" cols=\"60\"  name=\"license_text\" ></textarea>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"padding:10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" onclick=\"doPaste()\" id=\"uploadButton\" dojoType=\"dijit.form.Button\" name=\"upload_button\" iconClass=\"keyIcon\" value=\"upload\">");
      out.print( LanguageUtil.get(pageContext, "save-license") );
      out.write("</button>\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("<div id=\"dotRequestLicenseDialog\" dojoType=\"dijit.Dialog\" style=\"display:none\" title=\"");
      out.print( LanguageUtil.get(pageContext, "request-license") );
      out.write("\">\r\n");
      out.write("\t<div dojoType=\"dijit.layout.ContentPane\" style=\"width:640px;height:550px;\" class=\"box\" hasShadow=\"true\" id=\"dotRequestLicenseDialogCP\">\r\n");
      out.write("\t\t");
      out.print(licenseFormStr );
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
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
