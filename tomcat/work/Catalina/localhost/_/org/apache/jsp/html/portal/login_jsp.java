package org.apache.jsp.html.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dotmarketing.business.UserAPI;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.web.WebAPILocator;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.business.Layout;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.auth.PrincipalException;
import com.liferay.portal.ejb.AddressManagerUtil;
import com.liferay.portal.ejb.CompanyLocalManagerUtil;
import com.liferay.portal.ejb.PortletManagerUtil;
import com.liferay.portal.ejb.PortletPreferencesManagerUtil;
import com.liferay.portal.ejb.UserLocalManagerUtil;
import com.liferay.portal.model.*;
import com.liferay.portal.util.Constants;
import com.liferay.portal.util.CookieKeys;
import com.liferay.portal.util.ImageKey;
import com.liferay.portal.util.LuceneFields;
import com.liferay.portal.util.OmniadminUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.Recipient;
import com.liferay.portal.util.RecipientComparator;
import com.liferay.portal.util.ReleaseInfo;
import com.liferay.portal.util.Resolution;
import com.liferay.portal.util.ShutdownUtil;
import com.liferay.portal.util.WebAppPool;
import com.liferay.portlet.CachePortlet;
import com.liferay.portlet.LiferayWindowState;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.portlet.RenderParametersPool;
import com.liferay.portlet.RenderRequestImpl;
import com.liferay.portlet.RenderResponseImpl;
import com.liferay.portlet.admin.ejb.AdminConfigManagerUtil;
import com.liferay.portlet.admin.model.EmailConfig;
import com.liferay.portlet.admin.model.JournalConfig;
import com.liferay.portlet.admin.model.ShoppingConfig;
import com.liferay.portlet.admin.model.UserConfig;
import com.liferay.util.BrowserSniffer;
import com.liferay.util.CollectionFactory;
import com.liferay.util.CookieUtil;
import com.liferay.util.CreditCard;
import com.liferay.util.FileUtil;
import com.liferay.util.Html;
import com.liferay.util.Http;
import com.liferay.util.JS;
import com.liferay.util.KeyValuePair;
import com.liferay.util.KeyValuePairComparator;
import com.liferay.util.MathUtil;
import com.liferay.util.ObjectValuePair;
import com.liferay.util.OrderedProperties;
import com.liferay.util.ParamUtil;
import com.liferay.util.PhoneNumber;
import com.liferay.util.PropertiesUtil;
import com.liferay.util.ServerDetector;
import com.liferay.util.SimpleCachePool;
import com.liferay.util.SortedProperties;
import com.liferay.util.State;
import com.liferay.util.StateUtil;
import com.liferay.util.StringComparator;
import com.liferay.util.StringPool;
import com.liferay.util.TextFormatter;
import com.liferay.util.Time;
import com.liferay.util.UnicodeFormatter;
import com.liferay.util.Validator;
import com.liferay.util.Xss;
import com.liferay.util.cal.CalendarUtil;
import com.liferay.util.cal.Recurrence;
import com.liferay.util.lang.BooleanWrapper;
import com.liferay.util.lang.IntegerWrapper;
import com.liferay.util.log4j.Levels;
import com.liferay.util.lucene.Hits;
import com.liferay.util.servlet.DynamicServletRequest;
import com.liferay.util.servlet.SessionParameters;
import com.liferay.util.servlet.StringServletResponse;
import com.liferay.util.servlet.UploadException;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.UnavailableException;
import javax.portlet.ValidatorException;
import javax.portlet.WindowState;
import com.dotmarketing.portlets.common.bean.CrumbTrailEntry;
import java.util.HashMap;
import com.liferay.portal.language.LanguageUtil;
import com.liferay.portal.language.LanguageWrapper;
import com.liferay.portal.language.UnicodeLanguageUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.util.GetterUtil;
import com.liferay.util.StringUtil;
import com.liferay.util.servlet.SessionErrors;
import com.liferay.util.servlet.SessionMessages;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.PortletActiveException;
import com.liferay.portal.RequiredLayoutException;
import com.liferay.portal.RequiredRoleException;
import com.liferay.portal.SendPasswordException;
import com.liferay.portal.UserActiveException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.auth.AuthException;
import com.liferay.portal.struts.PortletRequestProcessor;
import com.liferay.portal.util.PortletTitleComparator;
import javax.servlet.jsp.PageContext;
import org.apache.commons.fileupload.LiferayDiskFileUpload;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.tiles.ComponentDefinition;
import org.apache.struts.tiles.TilesUtil;
import com.liferay.portal.UserActiveException;
import com.dotmarketing.util.Config;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.cms.factories.PublicEncryptionFactory;
import com.dotmarketing.util.Logger;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(10);
    _jspx_dependants.add("/html/portal/init.jsp");
    _jspx_dependants.add("/html/common/init.jsp");
    _jspx_dependants.add("/html/common/top_inc.jsp");
    _jspx_dependants.add("/html/common/bottom_inc.jsp");
    _jspx_dependants.add("/WEB-INF/tld/c-rt.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tld/liferay-portlet.tld");
    _jspx_dependants.add("/WEB-INF/tld/liferay-util.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-tiles.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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

	String CTX_PATH = (String) application
			.getAttribute(WebKeys.CTX_PATH);
	String CAPTCHA_PATH = (String) application
			.getAttribute(WebKeys.CAPTCHA_PATH);
	String IMAGE_PATH = (String) application
			.getAttribute(WebKeys.IMAGE_PATH);

	String contextPath = PropsUtil.get(PropsUtil.PORTAL_CTX);
	if (contextPath.equals("/")) {
		contextPath = "";
	}

	String COMMON_IMG = null;

	Company company = PortalUtil.getCompany(request);

	User user = null;
	try {
		user = PortalUtil.getUser(request);
	} catch (NoSuchUserException nsue) {
	}

	boolean signedIn = false;

	if (user == null) {
		user = company.getDefaultUser();
	} else {
		signedIn = true;
	}

	Locale locale = (Locale) session
			.getAttribute(org.apache.struts.Globals.LOCALE_KEY);
	if (locale == null) {

		// Locale should never be null except when the TCK tests invalidate the session

		locale = user.getLocale();
	}
	if(UtilMethods.isSet(request.getParameter("switchLocale"))){
		Locale[] locales = LanguageUtil.getAvailableLocales();
		for (int i = 0; i < locales.length; i++) { 
			String test = locales[i].getLanguage() + "_" + locales[i].getCountry();
			if(test.equals(request.getParameter("switchLocale"))){
				locale = locales[i];
				session.setAttribute(org.apache.struts.Globals.LOCALE_KEY, locale);
				break;
			}
		}
		
	}else{//DOTCMS-5013
		session.setAttribute(org.apache.struts.Globals.LOCALE_KEY, locale);
	}

	TimeZone timeZone = user.getTimeZone();
	if (timeZone == null) {
		timeZone = company.getTimeZone();
	}

	Layout layout = (Layout) request.getAttribute(WebKeys.LAYOUT);
	Layout[] layouts = (Layout[]) request.getAttribute(WebKeys.LAYOUTS);

	String layoutId = null;
	if (layout != null) {
		layoutId = layout.getId();
	}

	//String portletGroupId = PortalUtil.getPortletGroupId(layoutId);

	int RES_NARROW = 0;
	int RES_TOTAL = 0;
	int RES_WIDE = 0;


//	Skin skin = user.getSkin();

	String SKIN_CSS_IMG = null;


	String SKIN_COMMON_IMG =null;
	String SKIN_IMG =null;

      out.write("\r\n");
      out.write("\r\n");

	try {
		String hostId = (String) session.getAttribute(com.dotmarketing.util.WebKeys.CMS_SELECTED_HOST_ID);

		com.dotmarketing.business.web.HostWebAPI hostApi = com.dotmarketing.business.web.WebAPILocator.getHostWebAPI();
		com.dotmarketing.beans.Host currentHost = hostApi.find(hostId, user, false);
		if (currentHost.isArchived()) {
			List<com.dotmarketing.beans.Host> hosts = hostApi.findAll(user, false);
			for (com.dotmarketing.beans.Host host : hosts) {
				if (!host.isSystemHost() && !host.isArchived()) {
					session.setAttribute(com.dotmarketing.util.WebKeys.CMS_SELECTED_HOST_ID, host
							.getIdentifier());
					break;
				}
			}
		}
	} catch (Exception e) {

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");


	String dojoPath = Config.getStringProperty("path.to.dojo");
	if(!UtilMethods.isSet(dojoPath)){
		// Change dojopath in dotmarketing-config.properties!
		response.sendError(500, "No dojo path variable (path.to.dojo) set in the property file");
	}
	String agent = request.getHeader("User-Agent");


      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:bi=\"urn:bi\" xmlns:csp=\"urn:csp\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8,chrome=1\" />\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<meta content=\"no-cache\" http-equiv=\"Cache-Control\" />\r\n");
      out.write("\t<meta content=\"no-cache\" http-equiv=\"Pragma\" />\r\n");
      out.write("\t<meta content=\"0\" http-equiv=\"Expires\" />\r\n");
      out.write("\t<meta name=\"Expire\" content=\"Now\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"//www.dotcms.com/global/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("\t<title>dotCMS : ");
      out.print( LanguageUtil.get(pageContext, "Enterprise-Web-Content-Management") );
      out.write("</title>\r\n");
      out.write("\t \r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t@import \"/html/common/css.jsp?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"; \r\n");
      out.write("        @import \"");
      out.print(dojoPath);
      out.write("/dijit/themes/dmundra/dmundra.css?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\";\r\n");
      out.write("        @import \"");
      out.print(dojoPath);
      out.write("/dijit/themes/dmundra/Grid.css?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\";\r\n");
      out.write("        @import \"");
      out.print(dojoPath);
      out.write("/dojox/widget/Calendar/Calendar.css?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\";\r\n");
      out.write("        @import \"/html/js/dotcms/dijit/image/image_tools.css?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\";\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--[if IE]>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/html/css/iehacks.css\" />\r\n");
      out.write("\t<![endif]--> \r\n");
      out.write("    \r\n");
      out.write("    ");

    String dojoLocaleConfig = "locale:'en-us'";    
    if(locale != null){
    	dojoLocaleConfig = "locale:'"+locale.getLanguage() + "-" + locale.getCountry().toLowerCase() + "',";    	
    }    
    
      out.write("\r\n");
      out.write("   \t    \r\n");
      out.write("   \t<script type=\"text/javascript\">\r\n");
      out.write("       \tdjConfig={\r\n");
      out.write("               parseOnLoad: true,\r\n");
      out.write("               useXDomain: false,\r\n");
      out.write("               isDebug: false,\r\n");
      out.write("               ");
      out.print(dojoLocaleConfig);
      out.write("\r\n");
      out.write("               modulePaths: { dotcms: \"/html/js/dotcms\" }\r\n");
      out.write("       };\r\n");
      out.write("\t   \r\n");
      out.write("\t   \tfunction isInodeSet(x){\r\n");
      out.write("\t\t\treturn (x && x != undefined && x!=\"\" && x.length>15);\r\n");
      out.write("\t\t}\r\n");
      out.write("   \t</script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(dojoPath);
      out.write("/dojo/dojo.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/html/common/javascript.jsp?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/engine.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/util.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/interface/TemplateAjax.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/interface/HostAjax.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/interface/ContainerAjax.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/interface/RoleAjax.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/interface/BrowserAjax.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/interface/UserAjax.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/dwr/interface/InodeAjax.js?b=");
      out.print( ReleaseInfo.getVersion() );
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("\t\tdojo.require(\"dijit.Dialog\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.Button\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.CheckBox\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.DateTextBox\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.FilteringSelect\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.TextBox\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.ValidationTextBox\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.Textarea\");\r\n");
      out.write("\t\tdojo.require(\"dijit.Menu\");\r\n");
      out.write("\t\tdojo.require(\"dijit.MenuItem\");\r\n");
      out.write("\t\tdojo.require(\"dijit.MenuSeparator\");\r\n");
      out.write("\t\tdojo.require(\"dijit.ProgressBar\");\r\n");
      out.write("\t\tdojo.require(\"dijit.PopupMenuItem\");\r\n");
      out.write("\t\tdojo.require('dijit.layout.TabContainer');\r\n");
      out.write("\t\tdojo.require('dijit.layout.ContentPane');\r\n");
      out.write("\t\tdojo.require('dojox.layout.ContentPane');\r\n");
      out.write("\t\tdojo.require(\"dijit.layout.BorderContainer\");\r\n");
      out.write("\t\tdojo.require(\"dijit.TitlePane\");\r\n");
      out.write("\t\tdojo.require(\"dijit.Tooltip\");\r\n");
      out.write("\t\tdojo.require(\"dojo.parser\");\r\n");
      out.write("\t\tdojo.require(\"dojo.fx\");\r\n");
      out.write("\t\tdojo.require(\"dotcms.dojo.data.UsersReadStore\");\r\n");
      out.write("\t\tdojo.require(\"dojox.form.DropDownSelect\");\r\n");
      out.write("\t\tdojo.require(\"dojox.json.query\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.NumberTextBox\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.TimeTextBox\");\r\n");
      out.write("\t\tdojo.require(\"dotcms.dijit.image.ImageEditor\");\r\n");
      out.write("\t\tdojo.require(\"dojox.widget.Calendar\");\r\n");
      out.write("\t\tdojo.require(\"dojo.date.locale\");\r\n");
      out.write("\t\tdojo.require(\"dojox.form.Uploader\");\r\n");
      out.write("        dojo.require(\"dojox.form.uploader.FileList\");\r\n");
      out.write("        dojo.require(\"dojox.form.uploader.plugins.HTML5\");\r\n");
      out.write("        dojo.require(\"dijit.form.ComboBox\");\r\n");
      out.write("   \t\tdojo.require(\"dijit.TooltipDialog\");\r\n");
      out.write("\t\tdojo.require(\"dojox.grid.EnhancedGrid\");\r\n");
      out.write("\t\tdojo.require(\"dojox.grid.enhanced.plugins.Menu\");\r\n");
      out.write("\t\tdojo.require(\"dojo.data.ItemFileReadStore\");\r\n");
      out.write("\t\tdojo.require(\"dijit.form.Form\");\r\n");
      out.write("\t\tdojo.require(\"dojo.io.script\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdojo.addOnLoad(function () {\r\n");
      out.write("\t\t\tdojo.global.DWRUtil = dwr.util;\r\n");
      out.write("\t\t\tdojo.global.DWREngine = dwr.engine;\r\n");
      out.write("\t\t\tdwr.engine.setErrorHandler(DWRErrorHandler);\r\n");
      out.write("\t\t\tdwr.engine.setWarningHandler(DWRErrorHandler);\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tfunction DWRErrorHandler(msg, e) {\r\n");
      out.write("\t\t\t//debugger;\r\n");
      out.write("\t\t\tconsole.log(msg, e);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar dojoDom=dojo.require(\"dojo.dom\");\r\n");
      out.write("\t\tvar dojoDomGeometry=dojo.require(\"dojo.dom-geometry\");\r\n");
      out.write("\t\tvar dojoStyle=dojo.require(\"dojo.dom-style\");\r\n");
      out.write("\t\tdojo.coords = function(elem,xx) {\r\n");
      out.write("            var mb=dojoDomGeometry.getMarginBox(elem,dojoStyle.getComputedStyle(elem));\r\n");
      out.write("            var abs=dojoDomGeometry.position(elem,xx);\r\n");
      out.write("            mb.x=abs.x;\r\n");
      out.write("            mb.y=abs.y;\r\n");
      out.write("            mb.w=abs.w;\r\n");
      out.write("            mb.h=abs.h;\r\n");
      out.write("            return mb;\r\n");
      out.write("        };\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");
 String dotBackImage = (!UtilMethods.isSet(company.getHomeURL()) || "localhost".equals(company.getHomeURL())) ? "/html/images/backgrounds/bg-3.jpg" : company.getHomeURL();
      out.write("\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\t.imageBG{background-color:");
      out.print( company.getSize() );
      out.write(";background-image:url(");
      out.print( dotBackImage );
      out.write(");background-repeat:no-repeat;background-position:top center;background-size:100% auto;height:75px;position:absolute;top:0;left:0;width:100%;z-index:-2;}\r\n");
      out.write("\t</style>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
if(UtilMethods.isSet(request.getParameter("popup")) || UtilMethods.isSet(request.getAttribute("popup")) || UtilMethods.isSet(request.getParameter("in_frame"))){ 
      out.write("\r\n");
      out.write("\t<body class=\"dmundra\" style=\"background:white url()\">\r\n");
}else{ 
      out.write("\r\n");
      out.write("\t<body class=\"dmundra\" style=\"visibility:hidden\">\r\n");
      out.write("\t\t<div class=\"imageBG\"></div>\r\n");
      out.write("\t\t<div class=\"bannerBG\"></div>\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");

String cmd = ParamUtil.getString(request, "my_account_cmd");
session.removeAttribute(WebKeys.USER_ID);
String emailAddress = request.getParameter("my_account_email_address");
Xss.strip(emailAddress);
if ((emailAddress == null) || (emailAddress.equals("null"))) {
	emailAddress = "";
}

String login = request.getParameter("my_account_login");
if(!UtilMethods.isSet(login)){
	login = (String) session.getAttribute("_failedLoginName");
	
}
if(!UtilMethods.isSet(login)){
	login = GetterUtil.getString(CookieUtil.get(request.getCookies(), CookieKeys.LOGIN));
	if (Validator.isNull(login) && company.getAuthType().equals(Company.AUTH_TYPE_EA)) {
		login = "@" + company.getMx();
	}
}
login = Xss.strip(login);



String uId = null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie c : cookies){
	
		if(CookieKeys.ID.equals(c.getName())){
			try{
				uId = PublicEncryptionFactory.decryptString(c.getValue());
			}
			catch(Exception e){
				Logger.info(this, "An ivalid attempt to login as " + uId + " has been made from IP: " + request.getRemoteAddr());
				uId = null;
			}
		}
		
	}
}
if(UtilMethods.isSet(uId)){	
	session.setAttribute(WebKeys.USER_ID, uId);
	String referer = (String)session.getAttribute(WebKeys.REFERER);

	//DOTCMS-4943
	UserAPI userAPI = APILocator.getUserAPI();			
	boolean respectFrontend = WebAPILocator.getUserWebAPI().isLoggedToBackend(request);
	User loggedInUser = userAPI.loadUserById(uId, userAPI.getSystemUser(), respectFrontend);
	session.setAttribute(org.apache.struts.Globals.LOCALE_KEY, loggedInUser.getLocale());
	
	if(UtilMethods.isSet(referer)){
		session.removeAttribute(WebKeys.REFERER);
		response.sendRedirect(referer);
		return;
	}
	referer = (String)request.getAttribute(WebKeys.REFERER);
	if(UtilMethods.isSet(referer)){
		session.removeAttribute(WebKeys.REFERER);
		response.sendRedirect(referer);
		return;
	}
	out.println("<script>");
	out.println("window.location='/c/';");
	out.println("</script>");
	return;
	
}










boolean editPassword = Boolean.valueOf(PropsUtil.get("password.forgot.show"));
boolean rememberMe = ParamUtil.get(request, "my_account_r_m", false);

//PortletURL createAccountURL = new PortletURLImpl(request, PortletKeys.MY_ACCOUNT, layout.getId(), true);

//createAccountURL.setWindowState(WindowState.MAXIMIZED);
//createAccountURL.setPortletMode(PortletMode.VIEW);

//createAccountURL.setParameter("struts_action", "/my_account/create_account");

//String createAccountURLToString = createAccountURL.toString();



//Build errors

String errorMessage = null;
if(cmd.equals("send") && SessionErrors.contains(request, NoSuchUserException.class.getName())){
	errorMessage = LanguageUtil.get(pageContext, "the-email-address-you-requested-is-not-registered-in-our-database") ;
} 
else if(cmd.equals("send") && SessionErrors.contains(request, SendPasswordException.class.getName())){
	errorMessage = LanguageUtil.get(pageContext, "a-new-password-can-only-be-sent-to-an-external-email-address");
}
else if(cmd.equals("send") && SessionErrors.contains(request, UserEmailAddressException.class.getName())){
	errorMessage = LanguageUtil.get(pageContext, "please-enter-a-valid-email-address");
}
else if(cmd.equals("send") && SessionMessages.contains(request, "new_password_sent")){
	String recipient = (String)SessionMessages.get(request, "new_password_sent");
	errorMessage = LanguageUtil.format(pageContext, "a-new-password-has-been-sent-to-x", recipient, false);
} 

else  if(cmd.equals("auth") && SessionErrors.contains(request, NoSuchUserException.class.getName()) || SessionErrors.contains(request, UserEmailAddressException.class.getName())){
	errorMessage = LanguageUtil.get(pageContext, "please-enter-a-valid-login");
	SessionErrors.clear(request);
}
else  if(cmd.equals("auth") && SessionErrors.contains(request, AuthException.class.getName())|| SessionErrors.contains(request, UserEmailAddressException.class.getName())){
	 errorMessage = LanguageUtil.get(pageContext, "authentication-failed");
}
else  if(cmd.equals("auth") && SessionErrors.contains(request, AuthException.class.getName())){
	 errorMessage = LanguageUtil.get(pageContext, "authentication-failed");
}
else  if(cmd.equals("auth") && SessionErrors.contains(request, UserPasswordException.class.getName())){
	 errorMessage = LanguageUtil.get(pageContext, "please-enter-a-valid-password");
}
else  if(cmd.equals("auth") && SessionErrors.contains(request, RequiredLayoutException.class.getName())){
	 errorMessage = LanguageUtil.get(pageContext, "user-without-portlet");
}
else  if(cmd.equals("auth") && SessionErrors.contains(request, UserActiveException.class.getName())){
	 errorMessage = LanguageUtil.format(pageContext, "your-account-is-not-active", new LanguageWrapper[] {new LanguageWrapper("<b><i>", login, "</i></b>")}, false); 
}
if(errorMessage != null){
	session.setAttribute("_dotLoginMessages", errorMessage);
	session.setAttribute("_failedLoginName", login);
	SessionErrors.clear(request);
	out.println("<html><head><script>top.location = '/c/portal_public/login';</script></head><body></body></html>");
	return;
}

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/html/portal/about.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/chrome-frame/1/CFInstall.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\tbody{background-color:");
      out.print( company.getSize() );
      out.write(";background-image:url(");
      out.print( dotBackImage );
      out.write(");background-repeat:no-repeat;background-position:bottom top;background-size:100% 100%;}\r\n");
      out.write("\t#loginBox, #forgotPassword{-moz-box-shadow:2px 2px 8px #274665;-webkit-box-shadow:2px 2px 8px #274665;width:450px;}\r\n");
      out.write("\t.dijitTooltipFocusNode:focus{outline: none;}\r\n");
      out.write("\t.dijitDialogUnderlay{opacity: 0.2;}\r\n");
      out.write("\t.bannerBG, .imageBG{display:none;}\r\n");
      out.write("\t.chromeFrameOverlayContent{}\r\n");
      out.write("\t.chromeFrameOverlayContent iframe{}\r\n");
      out.write("\t.chromeFrameOverlayCloseBar{display:none;}\r\n");
      out.write("\t.chromeFrameOverlayUnderlay{background-color:#222;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\tdojo.addOnLoad(function(){\r\n");
      out.write("\t\tif (dojo.isIE <= 7) {\r\n");
      out.write("\t\t\tCFInstall.check({\r\n");
      out.write("\t\t\t\tmode: \"overlay\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tshowLogin();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("   //dojo.addOnLoad(showLogin);\r\n");
      out.write("   \r\n");
      out.write("\tfunction showLogin(){\r\n");
      out.write("\t       var myDialog = dijit.byId(\"loginBox\");\r\n");
      out.write("\t       dojo.style(myDialog.closeButtonNode, \"visibility\", \"hidden\"); \r\n");
      out.write("\t       myDialog.tabStart = dojo.byId(\"loginPasswordTextBox\");\r\n");
      out.write("\t       myDialog.show();\r\n");
      out.write("\t       setTimeout(\"dijit.byId('loginPasswordTextBox').focus()\",200);\r\n");
      out.write("\t}\r\n");
      out.write("   \r\n");
      out.write("\tfunction showForgot(){\r\n");
      out.write("\t\tvar myDialog = dijit.byId(\"loginBox\");\r\n");
      out.write("\t\tmyDialog.hide();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tmyDialog = dijit.byId(\"forgotPassword\");\r\n");
      out.write("\t\tmyDialog.connect(myDialog,\"hide\",showLogin); \r\n");
      out.write("\t\t\r\n");
      out.write("\t\tmyDialog.show();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdojo.require(\"dojox.validate.web\");\r\n");
      out.write("\tfunction signIn() {\r\n");
      out.write("\r\n");
      out.write("\t\t// set values\r\n");
      out.write("\t\tdocument.fm.my_account_cmd.value = \"auth\";\r\n");
      out.write("\t\tdocument.fm.referer.value = \"");
      out.print( CTX_PATH );
      out.write("\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar loginTextValue = dojo.byId(\"loginTextBox\").value;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
if(company.getAuthType().equals(Company.AUTH_TYPE_EA)){
      out.write("\r\n");
      out.write("\t\t\tif(!dojox.validate.isEmailAddress(loginTextValue)){\r\n");
      out.write("\t\t\t\tdojo.byId(\"dotLoginMessagesDiv\").innerHTML = '");
      out.print( LanguageUtil.get(pageContext, "please-enter-a-valid-email-address") );
      out.write("';\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\tif((loginTextValue.length == 0)\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t|| (loginTextValue.indexOf('>') != -1)\r\n");
      out.write("\t\t\t\t\t|| (loginTextValue.indexOf('<') != -1)){\r\n");
      out.write("\t\t\t\tdojo.byId(\"dotLoginMessagesDiv\").innerHTML = '");
      out.print( LanguageUtil.get(pageContext, "please-enter-a-valid-user-id") );
      out.write("';\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t\tdojo.byId(\"my_account_login\").value = dojo.byId(\"loginTextBox\").value;\r\n");
      out.write("\t\tdojo.byId(\"password\").value = dojo.byId(\"loginPasswordTextBox\").value;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tvar myDialog = dijit.byId(\"loginBox\");\r\n");
      out.write("\t\tmyDialog.hide();\r\n");
      out.write("\r\n");
      out.write("\t\tvar myDialog = dijit.byId(\"progressBarBox\");\r\n");
      out.write("\t    dojo.style(myDialog.closeButtonNode, \"visibility\", \"hidden\"); \r\n");
      out.write("\t\tmyDialog.show();\r\n");
      out.write("\t\tvar progressBarBox = dijit.byId(\"progressBarBox\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        numParts = Math.floor(100/7);\r\n");
      out.write("        jsProgress.update({ maximum: numParts, progress:0 });\r\n");
      out.write("        for (var i=0; i<=numParts; i++){\r\n");
      out.write("            // This plays update({progress:0}) at 1nn milliseconds,\r\n");
      out.write("            // update({progress:1}) at 2nn milliseconds, etc.\r\n");
      out.write("            setTimeout(\r\n");
      out.write("               \"jsProgress.update({ progress: \" + i + \" })\",\r\n");
      out.write("               (i+1)*100 + Math.floor(Math.random()*100)\r\n");
      out.write("            );\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.fm.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction forgotPassword() {\r\n");
      out.write("\t\tif (confirm('");
      out.print( UnicodeLanguageUtil.get(pageContext, "a-new-password-will-be-generated-and-sent-to-your-external-email-address") );
      out.write("')) { \r\n");
      out.write("\t\t\tdocument.fm.my_account_cmd.value = 'send'; \r\n");
      out.write("\r\n");
      out.write("\t\t\tdojo.byId(\"my_account_email_address\").value = dojo.byId(\"forgotPasswordEmailBox\").value;\r\n");
      out.write("\r\n");
      out.write("\t\t\tdocument.fm.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tdojo.connect(dojo.byId(\"loginBox\"), \"onkeypress\", function(e){\r\n");
      out.write("\t        var key = e.keyCode || e.charCode;\r\n");
      out.write("\t        var k = dojo.keys;\r\n");
      out.write("\t        if (key == 13) {\r\n");
      out.write("\t                signIn();\r\n");
      out.write("\t        }\r\n");
      out.write("\t}); \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function showLanguageSelector(){\r\n");
      out.write("\r\n");
      out.write("\tvar test =dojo.byId(\"\");\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
 if(editPassword){ 
      out.write("\r\n");
      out.write("\t\t<div id=\"forgotPassword\" style=\"display:none\" draggable=\"false\" dojoType=\"dijit.Dialog\" title=\"");
      out.print( LanguageUtil.get(pageContext, "forgot-password") );
      out.write("\">\r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dt><label for=\"forgotPasswordEmailBox\" class=\"formLabel\">");
if(company.getAuthType().equals(Company.AUTH_TYPE_EA)){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "email-address") );
      out.write(" : \r\n");
      out.write("\t\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "user-id") );
      out.write(" : \r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("</label></dt>\r\n");
      out.write("\t\t\t\t<dd><input id=\"forgotPasswordEmailBox\" name=\"forgotPasswordEmailBox\" type=\"text\"  value=\"");
      out.print( login );
      out.write("\"  dojoType=\"dijit.form.TextBox\"></dd>\r\n");
      out.write("\t\t\t\t<dd><button dojoType=\"dijit.form.Button\"  onClick=\"forgotPassword()\">");
      out.print( LanguageUtil.get(pageContext, "get-new-password") );
      out.write("</button></dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"loginBox\" dojoType=\"dijit.Dialog\" draggable=\"false\" style=\"display:none\" title=\"");
      out.print( LanguageUtil.get(pageContext, "Login") );
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\t\t");
if(session.getAttribute("_dotLoginMessages") != null ){ 
      out.write("\r\n");
      out.write("\t\t");
String myMessages = (String) session.getAttribute("_dotLoginMessages") ; 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"error-message\" id=\"dotLoginMessagesDiv\">");
      out.print(myMessages);
      out.write("</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t");
session.removeAttribute("_dotLoginMessages");  
      out.write("\r\n");
      out.write("\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error-message\" id=\"dotLoginMessagesDiv\"></div>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t<dl>\r\n");
      out.write("\t\t\t<dt style=\"width:180px\">\r\n");
      out.write("\t\t\t\t<label for=\"loginTextBox\">\r\n");
      out.write("\t\t\t\t\t");
if(company.getAuthType().equals(Company.AUTH_TYPE_EA)){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "email-address") );
      out.write(" : \r\n");
      out.write("\t\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "user-id") );
      out.write(" : \r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</dt>\r\n");
      out.write("\t\t\t<dd><input name=\"loginTextBox\" id=\"loginTextBox\" dojoType=\"dijit.form.TextBox\" size=\"25\" required=\"true\" type=\"text\" tabindex=\"1\"  value=\"");
      out.print( login );
      out.write("\"></dd>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<dt style=\"width:180px\"><label for=\"loginPasswordTextBox\">");
      out.print( LanguageUtil.get(pageContext, "password") );
      out.write(" : </label></dt>\r\n");
      out.write("\t\t\t<dd><input name=\"loginPasswordTextBox\" id=\"loginPasswordTextBox\" dojoType=\"dijit.form.TextBox\" size=\"25\" required=\"true\" type=\"password\" value=\"\" tabindex=\"2\" ></dd>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<dt style=\"width:180px\"><label for=\"rememberMe\">");
      out.print( LanguageUtil.get(pageContext, "remember-me") );
      out.write(" &nbsp;</label></dt>\r\n");
      out.write("\t\t\t<dd>\r\n");
      out.write("\t\t\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /html/portal/login.jsp(323,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest( company.isAutoLogin());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<input id=\"rememberMe\" tabindex=\"3\" ");
          out.print( rememberMe ? "checked" : "" );
          out.write(" type=\"checkbox\"  dojoType=\"dijit.form.CheckBox\"\r\n");
          out.write("\t\t\t\t\tonclick=\"\r\n");
          out.write("\t\t\t\t\t");
          //  c:if
          org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
          _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
          _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
          // /html/portal/login.jsp(326,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_c_005fif_005f1.setTest( company.isAutoLogin() && !request.isSecure() );
          int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
          if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t\tif (this.checked) {document.fm.my_account_r_m.value = 'on';}else {document.fm.my_account_r_m.value = 'off';}\r\n");
              out.write("\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
            return;
          }
          _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
          out.write("\">\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      out.write("\r\n");
      out.write("\t\t\t</dd>\r\n");
      out.write("\t\t</dl>\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Button Row --->\r\n");
      out.write("\t\t\t<div class=\"buttonRow\">\r\n");
      out.write("\t\t\t\t<button dojoType=\"dijit.form.Button\" iconClass=\"loginIcon\" tabindex=\"4\"  onClick=\"signIn();return false;\">\r\n");
      out.write("\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "sign-in") );
      out.write("\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"float: left;  cursor: pointer;padding-bottom:6px;\" class=\"inputCaption\" \r\n");
      out.write("\t\t\t\tonmousedown=\"dijit.popup.open({popup: myDialog, around: dojo.byId('myLanguageImage')})\">\r\n");
      out.write("\t\t\t\t\t<img title=\"\" id=\"myLanguageImage\" alt=\"\" src=\"/html/images/languages/");
      out.print( locale.getLanguage() + "_" + locale.getCountry() );
      out.write(".gif\" align=\"left\" style=\"padding:1px;border:1px solid #ffffff\">\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t    <div id=\"languageSelectorBar\" style=\"visibility: hidden; display: none;\" title=\"Select Language\">\r\n");
      out.write("\t\t\t    \t<div style=\"text-align: right;margin-right:-5px;margin-top:-3px;\">\r\n");
      out.write("\t\t\t    \t\t<img onclick=\"dijit.popup.close(myDialog);\" alt=\"");
      out.print( LanguageUtil.get(pageContext, "close") );
      out.write("\" title=\"");
      out.print( LanguageUtil.get(pageContext, "close") );
      out.write("\" src=\"/html/js/dojo/release/dojo/dijit/themes/dmundra/images/tabCloseHover.png\" width=\"10\" height=\"10\" style=\"cursor: pointer;\">\r\n");
      out.write("\t\t\t    \t\t\r\n");
      out.write("\t\t\t    \t</div>\r\n");
      out.write("\t\t\t    \t<div style=\"text-align: center;padding-left:10px;padding-right:10px;border: none;\">\r\n");
      out.write("\t\t\t\t    \t");
 Locale[] locales = LanguageUtil.getAvailableLocales();
      out.write("\r\n");
      out.write("\t\t\t\t\t    ");
 for (int i = 0; i < locales.length; i++) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t    ");
if(locale.equals(locales[i])){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<img title=\"");
      out.print( locales[i].getDisplayLanguage(locales[i]));
      out.write("\" alt=\"");
      out.print( locales[i].getDisplayLanguage(locales[i]));
      out.write("\" src=\"/html/images/languages/");
      out.print( locales[i].getLanguage() + "_" + locales[i].getCountry() );
      out.write(".gif\" style=\"padding:2px;border:1px solid blue;margin-right:3px;\">\r\n");
      out.write("\t\t\t\t\t\t   \t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t   \t\t<img onclick=\"window.location='/html/portal/login.jsp?switchLocale=");
      out.print( locales[i].getLanguage() + "_" + locales[i].getCountry() );
      out.write("';\" title=\"");
      out.print( locales[i].getDisplayLanguage(locales[i]));
      out.write("\" alt=\"");
      out.print( locales[i].getDisplayLanguage(locales[i]));
      out.write("\" src=\"/html/images/languages/");
      out.print( locales[i].getLanguage() + "_" + locales[i].getCountry() );
      out.write(".gif\" style=\"padding:2px;border:1px solid #dddddd;cursor: pointer;\">\r\n");
      out.write("\t\t\t\t\t\t   \t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t    ");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t   </div>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 if(editPassword){ 
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"inputCaption\" style=\"float:right;\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:showForgot()\">");
      out.print( LanguageUtil.get(pageContext, "forgot-password") );
      out.write("</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t<!-- /Button Row --->\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"progressBarBox\" dojoType=\"dijit.Dialog\" style=\"display:none\" title=\"");
      out.print( LanguageUtil.get(pageContext, "login") );
      out.write("\">\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t<div dojoType=\"dijit.ProgressBar\" style=\"width:200px;text-align:center;\" jsId=\"jsProgress\" id=\"downloadProgress\"></div>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Get Chrome for IE7 -->\r\n");
      out.write("\r\n");
      out.write("<div id=\"getChrome\" style=\"display:none\" draggable=\"false\" dojoType=\"dijit.Dialog\" title=\"Get Chrome Plugin for IE7\">\r\n");
      out.write("\t<h2>You are using a no supported version of Internet Explore!</h2>\r\n");
      out.write("\t<p>You have two options:1. Update your browser to the newest version or 2. install the Chrome plugin.</p>\r\n");
      out.write("\t<div class=\"buttonRow\">\r\n");
      out.write("\t\t\t<button dojoType=\"dijit.form.Button\" iconClass=\"loginIcon\" tabindex=\"4\"  onClick=\"\">\r\n");
      out.write("\t\t\t\tGet Google Chrome Plugin\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print( CTX_PATH );
      out.write("/portal");
      out.print( PortalUtil.getAuthorizedPath(request) );
      out.write("/login\" method=\"post\" name=\"fm\" target=\"actionJackson\">\r\n");
      out.write("\t<input name=\"my_account_cmd\" type=\"hidden\" value=\"\">\r\n");
      out.write("\t<input name=\"referer\" type=\"hidden\" value=\"");
      out.print( CTX_PATH );
      out.write("\">\r\n");
      out.write("\t<input name=\"my_account_r_m\" id=\"my_account_r_m\" type=\"hidden\" value=\"");
      out.print( rememberMe );
      out.write("\">\r\n");
      out.write("\t<input name=\"password\" id=\"password\" type=\"hidden\" value=\"\">\r\n");
      out.write("\t<input name=\"my_account_login\" id=\"my_account_login\" type=\"hidden\" value=\"\">\r\n");
      out.write("\t<input name=\"my_account_email_address\" id=\"my_account_email_address\" type=\"hidden\" value=\"\">\r\n");
      out.write("\t\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<div class=\"inputCaption\" style=\"color:#dddddd;text-align:right;position:absolute;bottom:10px; right:10px;\">\r\n");
      out.write("\t");
String serverId = Config.getStringProperty("DIST_INDEXATION_SERVER_ID");
      out.write('\r');
      out.write('\n');
      out.write('	');
 if (UtilMethods.isSet(serverId)){ 
      out.write("\r\n");
      out.write("\t\t");
      out.print( LanguageUtil.get(pageContext, "Server") );
      out.write(':');
      out.write(' ');
      out.print(serverId);
      out.write(" <br />\r\n");
      out.write("\t");
} 
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.print( System.getProperty("dotcms_level_name"));
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.print( ReleaseInfo.getVersion() );
      out.write("<br/>\r\n");
      out.write("\t(");
      out.print( ReleaseInfo.getBuildDateString() );
      out.write(")\r\n");
      out.write("</div>\r\n");
      out.write("<iframe name=\"actionJackson\" id=\"actionJackson\" style=\"width:0px;height:0px;\" src=\"/html/portal/touch_protected.jsp\" ></iframe>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar myDialog = new dijit.TooltipDialog({style:'display:none;'}, \"languageSelectorBar\");\r\n");
      out.write("\tmyDialog.startup();\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction dotMakeBodVisible(){\n");
      out.write("\t\t\tdojo.style(dojo.body(), \"visibility\", \"visible\");\n");
      out.write("\t\t}\n");
      out.write("\t\t\r\n");
      out.write("\t\tdojo.addOnLoad(dotMakeBodVisible);\n");
      out.write("\t\tsetTimeout( \"dotMakeBodVisible\",2000);\n");
      out.write("\t\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');
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
