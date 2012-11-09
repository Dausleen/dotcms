package org.apache.jsp.html.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
import com.dotmarketing.util.Config;
import com.dotmarketing.util.UtilMethods;
import org.apache.struts.action.ActionErrors;
import java.util.HashSet;
import java.util.Set;
import org.apache.struts.action.ActionErrors;
import com.liferay.portal.language.LanguageUtil;
import java.util.List;
import java.util.ArrayList;
import org.apache.struts.action.ActionMessage;
import java.util.Iterator;
import com.liferay.util.servlet.SessionMessages;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.Globals;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.util.Config;
import com.dotmarketing.util.UtilMethods;
import java.util.List;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.util.UtilMethods;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLImpl;
import javax.portlet.WindowState;
import javax.portlet.PortletMode;
import com.liferay.portal.util.PortletKeys;
import javax.portlet.PortletURL;
import com.liferay.portal.language.LanguageUtil;
import com.dotmarketing.business.Role;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.util.CompanyUtils;
import com.dotmarketing.util.Config;
import com.liferay.portal.util.ReleaseInfo;
import java.net.URLEncoder;
import com.dotmarketing.viewtools.JSONTool;
import com.dotmarketing.util.json.JSONObject;
import com.dotmarketing.util.json.JSONArray;
import java.util.Date;
import java.util.Calendar;
import com.dotmarketing.business.Layout;
import java.util.List;
import com.liferay.portal.util.WebKeys;
import com.dotmarketing.util.UtilMethods;
import org.apache.struts.action.ActionErrors;
import java.util.HashSet;
import java.util.Set;
import org.apache.struts.action.ActionErrors;
import com.liferay.portal.language.LanguageUtil;
import java.util.List;
import java.util.ArrayList;
import org.apache.struts.action.ActionMessage;
import java.util.Iterator;
import com.liferay.util.servlet.SessionMessages;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.Globals;
import com.dotmarketing.util.UtilMethods;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.ParamUtil;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.util.Config;
import com.liferay.portal.language.LanguageUtil;
import com.dotmarketing.db.DbConnectionFactory;

public final class layout_005fportal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(13);
    _jspx_dependants.add("/html/common/init.jsp");
    _jspx_dependants.add("/html/common/top_inc.jsp");
    _jspx_dependants.add("/html/common/messages_inc.jsp");
    _jspx_dependants.add("/html/common/bottom_inc.jsp");
    _jspx_dependants.add("/html/common/nav_main_inc.jsp");
    _jspx_dependants.add("/html/common/nav_sub_inc.jsp");
    _jspx_dependants.add("/html/common/bottom_portal_inc.jsp");
    _jspx_dependants.add("/WEB-INF/tld/c-rt.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tld/liferay-portlet.tld");
    _jspx_dependants.add("/WEB-INF/tld/liferay-util.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-tiles.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fliferay_005finclude_0026_005fpage_005fflush_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fliferay_005finclude_0026_005fpage_005fflush_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fliferay_005finclude_0026_005fpage_005fflush_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.release();
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

      out.write('\r');
      out.write('\n');
      //  tiles:useAttribute
      org.apache.struts.taglib.tiles.UseAttributeTag _jspx_th_tiles_005fuseAttribute_005f0 = (org.apache.struts.taglib.tiles.UseAttributeTag) _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody.get(org.apache.struts.taglib.tiles.UseAttributeTag.class);
      _jspx_th_tiles_005fuseAttribute_005f0.setPageContext(_jspx_page_context);
      _jspx_th_tiles_005fuseAttribute_005f0.setParent(null);
      // /html/portal/layout_portal.jsp(2,0) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005fuseAttribute_005f0.setId("tilesContent");
      // /html/portal/layout_portal.jsp(2,0) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005fuseAttribute_005f0.setName("content");
      // /html/portal/layout_portal.jsp(2,0) name = classname type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005fuseAttribute_005f0.setClassname("java.lang.String");
      int _jspx_eval_tiles_005fuseAttribute_005f0 = _jspx_th_tiles_005fuseAttribute_005f0.doStartTag();
      if (_jspx_th_tiles_005fuseAttribute_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody.reuse(_jspx_th_tiles_005fuseAttribute_005f0);
        return;
      }
      _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody.reuse(_jspx_th_tiles_005fuseAttribute_005f0);
      java.lang.String tilesContent = null;
      tilesContent = (java.lang.String) _jspx_page_context.findAttribute("tilesContent");
      out.write('\r');
      out.write('\n');
      //  tiles:useAttribute
      org.apache.struts.taglib.tiles.UseAttributeTag _jspx_th_tiles_005fuseAttribute_005f1 = (org.apache.struts.taglib.tiles.UseAttributeTag) _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody.get(org.apache.struts.taglib.tiles.UseAttributeTag.class);
      _jspx_th_tiles_005fuseAttribute_005f1.setPageContext(_jspx_page_context);
      _jspx_th_tiles_005fuseAttribute_005f1.setParent(null);
      // /html/portal/layout_portal.jsp(3,0) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005fuseAttribute_005f1.setId("tilesPortletSubNav");
      // /html/portal/layout_portal.jsp(3,0) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005fuseAttribute_005f1.setName("portlet_sub_nav");
      // /html/portal/layout_portal.jsp(3,0) name = classname type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tiles_005fuseAttribute_005f1.setClassname("java.lang.String");
      int _jspx_eval_tiles_005fuseAttribute_005f1 = _jspx_th_tiles_005fuseAttribute_005f1.doStartTag();
      if (_jspx_th_tiles_005fuseAttribute_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody.reuse(_jspx_th_tiles_005fuseAttribute_005f1);
        return;
      }
      _005fjspx_005ftagPool_005ftiles_005fuseAttribute_0026_005fname_005fid_005fclassname_005fnobody.reuse(_jspx_th_tiles_005fuseAttribute_005f1);
      java.lang.String tilesPortletSubNav = null;
      tilesPortletSubNav = (java.lang.String) _jspx_page_context.findAttribute("tilesPortletSubNav");
      out.write('\r');
      out.write('\n');

	boolean inPortal = (request.getAttribute("org.dotcms.variables.inPortlets") != null);
	boolean inPopupIFrame = UtilMethods.isSet(ParamUtil.getString(request, "popup")) || UtilMethods.isSet(ParamUtil.getString(request, "in_frame"));

	request.setAttribute("org.dotcms.variables.inPortlets", "true"); 
	

      out.write("\r\n");
      out.write("\r\n");
if(inPortal ) {
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /html/portal/layout_portal.jsp(13,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest( Validator.isNotNull(tilesPortletSubNav) );
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<div class=\"portlet-wrapper\" >\r\n");
          out.write("\t\t\t");
          //  liferay:include
          com.liferay.taglib.IncludeTag _jspx_th_liferay_005finclude_005f0 = (com.liferay.taglib.IncludeTag) _005fjspx_005ftagPool_005fliferay_005finclude_0026_005fpage_005fflush_005fnobody.get(com.liferay.taglib.IncludeTag.class);
          _jspx_th_liferay_005finclude_005f0.setPageContext(_jspx_page_context);
          _jspx_th_liferay_005finclude_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
          // /html/portal/layout_portal.jsp(15,3) name = page type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_liferay_005finclude_005f0.setPage( Constants.TEXT_HTML_DIR + tilesPortletSubNav );
          // /html/portal/layout_portal.jsp(15,3) name = flush type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_liferay_005finclude_005f0.setFlush(true);
          int _jspx_eval_liferay_005finclude_005f0 = _jspx_th_liferay_005finclude_005f0.doStartTag();
          if (_jspx_th_liferay_005finclude_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fliferay_005finclude_0026_005fpage_005fflush_005fnobody.reuse(_jspx_th_liferay_005finclude_005f0);
            return;
          }
          _005fjspx_005ftagPool_005fliferay_005finclude_0026_005fpage_005fflush_005fnobody.reuse(_jspx_th_liferay_005finclude_005f0);
          out.write("\r\n");
          out.write("\t\t</div>\r\n");
          out.write("\t");
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
      out.write("\t<div class=\"portlet-wrapper\" >\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response,  Constants.TEXT_HTML_DIR + tilesContent , out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
}else if(inPopupIFrame) { 
      out.write('\r');
      out.write('\n');
      out.write('	');
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
      out.write("\n");
      out.write("\t<style>\n");
      out.write("\t\tbody{\n");
      out.write("\t\t\tbackground: white;\n");
      out.write("\t\t}\n");
      out.write("\t</style>\r\n");
      out.write("\t");
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

if(request.getSession().getAttribute(ActionErrors.GLOBAL_ERROR) != null){
	request.setAttribute(ActionErrors.GLOBAL_ERROR, request.getSession().getAttribute(ActionErrors.GLOBAL_ERROR));

}


Set<String> messages = new HashSet<String>();
Set<String> errors = new HashSet<String>();

if(request.getAttribute(ActionErrors.GLOBAL_ERROR) !=null){
	ActionErrors aes = (ActionErrors) request.getAttribute(ActionErrors.GLOBAL_ERROR);
	Iterator it = aes.get();
	while(it.hasNext()){
		ActionMessage am = (ActionMessage) it.next();
		String m = LanguageUtil.get(pageContext, am.getKey());
		if(am.getValues() != null){
			for(int i=0;i<am.getValues().length;i++){
				m = UtilMethods.replace(m, "{" + i + "}", (String) am.getValues()[i]);
			}
		}
		errors.add(m);
	}
}

if(request.getAttribute(Globals.ERROR_KEY) != null){
	ActionErrors aes = (ActionErrors) request.getAttribute(Globals.ERROR_KEY);
	Iterator it = aes.get();
	while(it.hasNext()){
		ActionMessage am = (ActionMessage) it.next();
		String m = LanguageUtil.get(pageContext, am.getKey());
		if(am.getValues() != null){
			for(int i=0;i<am.getValues().length;i++){
				m = UtilMethods.replace(m, "{" + i + "}", (String) am.getValues()[i]);
			}
		}
		errors.add(m);
	}
}




if(request.getAttribute(ActionMessages.GLOBAL_MESSAGE) !=null){
	ActionMessages aes = (ActionMessages) request.getAttribute(ActionMessages.GLOBAL_MESSAGE);
	Iterator it = aes.get();
	while(it.hasNext()){
		ActionMessage am = (ActionMessage) it.next();
		messages.add(am.getKey());
	}
}



if(SessionMessages.contains(session, "message")){
	messages.add((String) SessionMessages.get(session, "message"));
}

if(SessionMessages.contains(session, "error")){
	errors.add((String) SessionMessages.get(session, "error"));
}
if(SessionMessages.contains(session, "custommessage")){
	messages.add((String) SessionMessages.get(session, "custommessage"));
}

if(SessionMessages.contains(request, "message")){
	messages.add((String) SessionMessages.get(request, "message"));
}
if(SessionMessages.contains(request, "error")){
	errors.add((String) SessionMessages.get(request, "error"));
}
if(SessionMessages.contains(request, "custommessage")){
	messages.add((String) SessionMessages.get(request, "custommessage"));
}



SessionMessages.clear(session);
SessionMessages.clear(request);
request.getSession().removeAttribute("org.apache.struts.action.MESSAGE");
request.getSession().removeAttribute("org.apache.struts.action.ERROR");




      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tdojo.require(\"dojo.fx\");\r\n");
      out.write("\tdojo.require(\"dijit.layout.ContentPane\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar messagesCount = 0;\r\n");
      out.write("\tvar messageYIncrement = 60;\r\n");
      out.write("\tvar occupiedPositions = new Array();\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t");
if(errors.size() > 0){
      out.write("\r\n");
      out.write("\t\t   dojo.addOnLoad(\r\n");
      out.write("\t\t\t\t   function () {\r\n");
      out.write("\t\t   \t\t\t\tshowDotCMSErrorMessage(\"<ul>");
for(String x : errors){
      out.write("<li>");
      out.print(UtilMethods.replace(LanguageUtil.get(pageContext, x), "\"", "\\\"") );
      out.write("</li>");
} 
      out.write("</ul>\")\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t   \t\t);\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t");
if(messages.size() > 0){
      out.write("\r\n");
      out.write("\t\t   dojo.addOnLoad(\r\n");
      out.write("\t\t\t\t   function () {\r\n");
      out.write("\t\t   \t\t\t\tshowDotCMSSystemMessage(\"<div class=\\\"messageIcon resolveIcon\\\"></div>\" + \"");
for(String x : messages){
      out.write(' ');
      out.print(UtilMethods.replace(LanguageUtil.get(pageContext, x), "\"", "\\\"") );
} 
      out.write("\")\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t   \t\t);\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction showDotCMSSystemMessage(message){\r\n");
      out.write("\t\t\tshowDotCMSSystemMessage(message, false);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction showDotCMSSystemMessage(message, isError){\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar position = 40;\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(occupiedPositions.length > 0)\r\n");
      out.write("\t\t\t\tposition = occupiedPositions[occupiedPositions.length - 1] + messageYIncrement;\t\r\n");
      out.write("\t\t\t\toccupiedPositions.push(position);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar className = isError? 'systemErrorsHolder':'systemMessagesHolder';\r\n");
      out.write("\t\t\tvar holdingDiv = dojo.create(\"div\", { \t\r\n");
      out.write("\t\t\t\tid : \"systemMessagesWrapper\" + messagesCount, \r\n");
      out.write("\t\t\t\tclassName : className,\r\n");
      out.write("\t\t\t\tstyle: { top: position + '%' }\r\n");
      out.write("\t\t\t}, dojo.body());\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar className = isError? 'errorMessages':'systemMessages';\r\n");
      out.write("\t\t\tvar systemMessages = dojo.create(\"div\", { \t\r\n");
      out.write("\t\t\t\tid: \"systemMessages\" + messagesCount,\r\n");
      out.write("\t\t\t\tclassName: className\r\n");
      out.write("\t\t\t}, holdingDiv);\r\n");
      out.write("\r\n");
      out.write("\t\t\tsystemMessages.innerHTML = message;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tdojo.connect(dijit.byId(\"systemMessages\"), \"onClick\", hideDotCMSSystemMessage);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tvar hideFn = dojo.partial(hideDotCMSSystemMessage, messagesCount);\r\n");
      out.write("\t\t\tdojo.connect(holdingDiv, 'onclick', hideFn);\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar hideFn = dojo.partial(hideDotCMSSystemMessage, messagesCount);\r\n");
      out.write("\t\t\tvar fadeOutFn = dojo.fadeOut({node: \"systemMessages\" + messagesCount, delay: 10, duration: 0, onEnd: hideFn }).play;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar fadeIn = dojo.fadeIn({node: \"systemMessages\" + messagesCount, duration: 2000, onEnd: fadeOutFn });\r\n");
      out.write("\t\t\tfadeIn.play();\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar ttl = message.split(\" \").length;\r\n");
      out.write("\t\t\tttl = ttl * 200;\r\n");
      out.write("\t\t\tif(ttl < 1000){\r\n");
      out.write("\t\t\t\tttl = 1000;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\thideMessagesHandler = setTimeout(hideFn,ttl);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tmessagesCount++;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction hideDotCMSSystemMessage(messageId){\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar currentY = parseInt(dojo.byId(\"systemMessagesWrapper\" + messageId).style.top);\r\n");
      out.write("\t\t\toccupiedPositions = dojo.filter(occupiedPositions, function (x) {\r\n");
      out.write("\t\t\t\treturn x != currentY;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tdojo.fadeOut({node: \"systemMessagesWrapper\" + messageId}).play();\r\n");
      out.write("\t\t\tdojo.destroy(\"systemMessagesWrapper\" + messageId);\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar hideErrorsHandler;\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction showDotCMSErrorMessage(message){\r\n");
      out.write("\t\t\tshowDotCMSSystemMessage(message, true);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response,  Constants.TEXT_HTML_DIR + tilesContent , out, false);
      out.write('\r');
      out.write('\n');
      out.write('	');
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
}else{ 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
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
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"doc3\" class=\"yui-t7\">\r\n");
      out.write("\t\t<div id=\"hd\">\r\n");
      out.write("\t\t\t");
      out.write("\n");
      out.write("<div id=\"menu\">\r\n");
      out.write("\t<ul class=\"level1 horizontal\" id=\"root\">\r\n");
      out.write("\r\n");
      out.write("\t");
for(int l=0;l< layouts.length ;l++){
		String tabName =LanguageUtil.get(pageContext, LanguageUtil.get(pageContext, layouts[l].getName())); 
		String tabDescription = (!UtilMethods.isSet(layouts[l].getDescription())) ? "&nbsp;" :layouts[l].getDescription() ;
		if(!tabDescription.equals("&nbsp;")){
		 	tabDescription = LanguageUtil.get(pageContext,tabDescription) ;
		 }
		
		
		List<String> portletIDs = layouts[l].getPortletIds();
		boolean isSelectedTab = (layout != null && layouts !=null && layout.getId().equals(layouts[l].getId()));
		PortletURLImpl portletURLImpl = new PortletURLImpl(request, portletIDs.get(0), layouts[l].getId(), false);
		String tabHREF = portletURLImpl.toString() + "&dm_rlout=1&r=" + System.currentTimeMillis();
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<li class=\"level1 ");
      out.print((isSelectedTab) ? "Active" : "");
      out.write("\">\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.print(tabHREF );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<div class=\"tabLeft\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navMenu-title\">");
      out.print(tabName );
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navMenu-subtitle\">");
      out.print(tabDescription );
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navMenu-arrow\">&nbsp;</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t");
if( portletIDs.size()>1){
      out.write("\r\n");
      out.write("\t\t\t\t\t<span class=\"tabRight\"></span>\r\n");
      out.write("\t\t\t\t\t<ul class=\"level2 dropdown\">\r\n");
      out.write("\t\t\t\t\t\t");
for(int i=0;i< portletIDs.size() ;i++){
							portletURLImpl = new PortletURLImpl(request, portletIDs.get(i), layouts[l].getId(), false);			
							String linkHREF = portletURLImpl.toString() + "&dm_rlout=1&r=" + System.currentTimeMillis();
							String linkName = LanguageUtil.get(pageContext,"javax.portlet.title." + portletIDs.get(i)); 
							
							
							if("EXT_LICENSE_MANAGER".equals(portletIDs.get(i))){
								request.setAttribute("licenseManagerPortletUrl", linkHREF);
							}
							
							
							
							
							
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"level2 dotCMS_");
      out.print(portletIDs.get(i));
      out.write("\"><a href=\"");
      out.print(linkHREF );
      out.write("\"><span></span>");
      out.print(linkName );
      out.write("</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\n");
      out.write("\tvar _myWindowWidth=0;\n");
      out.write("\t\r\n");
      out.write("\tfunction smallifyMenu(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// move our menu out of sight for rendering....\r\n");
      out.write("\t\tvar m = dojo.byId(\"menu\");\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar viewport = dijit.getViewport();\r\n");
      out.write("\t\tvar  screenWidth= (viewport.w -40);\r\n");
      out.write("\t\t//alert(screenWidth);\r\n");
      out.write("\t\tif(_myWindowWidth == screenWidth){\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\t_myWindowWidth = screenWidth;\r\n");
      out.write("\t\t// tabW keeps track of the tab width\r\n");
      out.write("\t\tvar tabW = 0;\r\n");
      out.write("\t\tvar fattestTab =0;\r\n");
      out.write("\t\tvar tabs = dojo.query(\"li.level1\");\r\n");
      out.write("\t\tfor(i = 0;i<tabs.length;i++){\r\n");
      out.write("\t\t\tvar x = tabs[i];\r\n");
      out.write("\t\t\tvar classes = dojo.attr(x, \"class\");\r\n");
      out.write("\t\t\tclasses = classes.replace(\" smallify\", \"\");\r\n");
      out.write("\t\t\tdojo.attr(x, \"class\", classes);\r\n");
      out.write("\t\t\twidth =  (dojo.coords(x)).w;\r\n");
      out.write("\t\t\tif(width > fattestTab){\r\n");
      out.write("\t\t\t\tfattestTab=width;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\ttabW = tabW + (dojo.coords(x)).w;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tscreenWidth = screenWidth - fattestTab;\r\n");
      out.write("\t\t//alert(fattestTab);\r\n");
      out.write("\t\t// get the top of our menu (to see if we are wrapping)\r\n");
      out.write("\t\tvar firstTop = (dojo.coords(tabs[0])).t;\r\n");
      out.write("\t\tvar lastTop = (dojo.coords(tabs[(tabs.length-1)])).t;\r\n");
      out.write("\t\tif(tabW > screenWidth || lastTop > firstTop){\r\n");
      out.write("\t\t\tfor(i = tabs.length;i>0;i--){\r\n");
      out.write("\t\t\t\tlastTop = (dojo.coords(tabs[(tabs.length-1)])).t;\r\n");
      out.write("\t\t\t\tvar x = tabs[i-1];\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\tvar width = (dojo.coords(x)).w;\r\n");
      out.write("\t\t\t\ttabW = tabW-width;\r\n");
      out.write("\t\t\t\tvar classes = dojo.attr(x, \"class\");\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(tabW > screenWidth || lastTop > firstTop){\r\n");
      out.write("\t\t\t\t\tclasses = classes + \" smallify\";\r\n");
      out.write("\t\t\t\t\tdojo.attr(x, \"class\", classes);\r\n");
      out.write("\t\t\t\t\twidth = (dojo.coords(x)).w;\r\n");
      out.write("\t\t\t\t\ttabW = tabW+width;\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\tdojo.addOnLoad (smallifyMenu);\r\n");
      out.write("\tdojo.connect(window, \"onresize\", this, \"smallifyMenu\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\t\t\t");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    boolean isCommunity = ("100".equals(System
            .getProperty("dotcms_level")));
    String licenseMessage = null;
    String licenseURL = "http://www.dotcms.com/buy-now";
    List<Layout> layoutListForLicenseManager=null;
    try {
        if (isCommunity) {
        	licenseMessage = LanguageUtil.get(pageContext, "Try-Enterprise-Now") + "!" ;

            layoutListForLicenseManager=APILocator.getLayoutAPI().findAllLayouts();
            for (Layout layoutForLicenseManager:layoutListForLicenseManager) {
                List<String> portletIdsForLicenseManager=layoutForLicenseManager.getPortletIds();
                if (portletIdsForLicenseManager.contains("EXT_LICENSE_MANAGER")) {
                    licenseURL = "/c/portal/layout?p_l_id=" + layoutForLicenseManager.getId() +"&p_p_id=EXT_LICENSE_MANAGER&p_p_action=0";
                    break;
                }

            }



        } else {
            boolean isPerpetual = new Boolean(System
                    .getProperty("dotcms_license_perpetual"));
            boolean isTrial = true;
            try{
                isTrial = (System.getProperty("dotcms_license_client_name").toLowerCase().indexOf("trial") >-1);
            }
            catch(Exception e){}
            Date td = new Date();
            Date ed = new Date(Long.parseLong(System
                    .getProperty("dotcms_valid_until")));

            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(td);
            start.set(Calendar.HOUR, 0);
            start.set(Calendar.MINUTE, 0);
            start.set(Calendar.SECOND, 0);
            start.set(Calendar.MILLISECOND, 0);
            end.setTime(ed);
            long milliseconds1 = start.getTimeInMillis();
            long milliseconds2 = end.getTimeInMillis();
            long diff = milliseconds2 - milliseconds1;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (!isPerpetual && isTrial) {
                if (diffDays > 1) {
                	licenseMessage = LanguageUtil.format(pageContext, "days-remaining-Purchase-now",diffDays,false);
                    licenseURL = "http://dotcms.com/buy-now";
                }
                if (diffDays == 1) {
                	licenseMessage = LanguageUtil.format(pageContext, "day-remaining-Purchase-now",diffDays,false);
                    licenseURL = "http://dotcms.com/buy-now";
                }
                if (diffDays < 1) {
                	licenseMessage = LanguageUtil.get(pageContext,"Trial-Expired-Purchase-Now");
                    licenseURL = "http://dotcms.com/buy-now";
                }

            }else if (!isPerpetual) {
                if (diffDays > 1 && diffDays < 30) {
                	licenseMessage = LanguageUtil.format(pageContext, "Subscription-expires-in-days",diffDays,false);
                    licenseURL = "http://dotcms.com/renew-now";
                }
                if (diffDays == 1) {
                	licenseMessage = LanguageUtil.format(pageContext, "Subscription-expires-in-day",diffDays,false);
                    licenseURL = "http://dotcms.com/renew-now";
                }
                if (diffDays < 1) {
                	licenseMessage = LanguageUtil.get(pageContext,"Subscription-Expired-Renew-Now");
                    licenseURL = "http://dotcms.com/buy-now";
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    boolean hasRolesPortlet = false;
    boolean hasLicenseManagerPortlet = false;
    String portletLinkHREF = "";
    java.util.List<com.dotmarketing.business.Layout> userLayouts = APILocator.getLayoutAPI().loadLayoutsForUser(user);
    if ((userLayouts != null) && (userLayouts.size() != 0)) {
        int count = 0;
        for (int i = 0; i < userLayouts.size(); i++) {
            java.util.List<String> portletids = userLayouts.get(i).getPortletIds();
            for (int j = 0; j < portletids.size(); j++) {
                if (portletids.get(j).equals("EXT_ROLE_ADMIN") && !hasRolesPortlet) {
                    hasRolesPortlet = true;

                }

                if (portletids.get(j).equals("EXT_LICENSE_MANAGER") && !hasLicenseManagerPortlet) {
                    hasLicenseManagerPortlet = true;
                }
            }
            if(!userLayouts.get(i).getName().equals("CMS Admin")){
                count+=1;
            }
        }

    }
    if (!hasRolesPortlet || hasLicenseManagerPortlet) {

         java.util.List<com.dotmarketing.business.Layout> allLayouts = APILocator.getLayoutAPI().findAllLayouts();
         com.liferay.portal.model.Portlet portlet = null;
         String ticket = "";
        if(!hasRolesPortlet){
          String roleAdminPortletId = "";
          portlet = APILocator.getPortletAPI().findPortlet("EXT_ROLE_ADMIN");
            if(portlet!=null){
                roleAdminPortletId = portlet.getPortletId();
            }

        if ((allLayouts != null) && (allLayouts.size() != 0)) {
            for (int i = 0; i < allLayouts.size(); i++) {
                if(allLayouts.get(i).getName().equals("CMS Admin")){
                    PortletURLImpl portletURLImpl = new PortletURLImpl(
                            request, roleAdminPortletId, allLayouts.get(i).getId(), false);
                     ticket  = String.valueOf(portletURLImpl.hashCode());
                    if(request.getSession().getAttribute("roleAdminOverrideTicket")==null){
                        request.getSession().setAttribute("roleAdminOverrideTicket",ticket);
                    }else{
                        ticket = (String)request.getSession().getAttribute("roleAdminOverrideTicket");
                    }

                    portletLinkHREF = portletURLImpl.toString()+ "&dm_rlout=1&roleAdminOverrideTicket="+ticket;
                    break;
                }
            }
         }
        }

        if(!hasLicenseManagerPortlet){
            String licenseManagerPortletId = "";
            portlet = APILocator.getPortletAPI().findPortlet("EXT_LICENSE_MANAGER");
                if(portlet!=null){
                    licenseManagerPortletId = portlet.getPortletId();
                }


            if ((allLayouts != null) && (allLayouts.size() != 0)) {

                if (APILocator.getUserAPI().isCMSAdmin(user)){
                        PortletURLImpl portletURLImpl = new PortletURLImpl(
                                request, licenseManagerPortletId, allLayouts.get(1).getId(), false);
                        ticket  = String.valueOf(portletURLImpl.hashCode());
                        if(request.getSession().getAttribute("licenseManagerOverrideTicket")==null){
                            request.getSession().setAttribute("licenseManagerOverrideTicket",ticket);
                        }else{
                            ticket = (String)request.getSession().getAttribute("licenseManagerOverrideTicket");
                        }

                        licenseURL = portletURLImpl.toString()+ "&dm_rlout=1&licenseManagerOverrideTicket="+ticket;

                    }
                }

            }
    }else {
        if(request.getSession().getAttribute("roleAdminOverrideTicket")!=null){
           request.getSession().removeAttribute("roleAdminOverrideTicket");
        }

        if(request.getSession().getAttribute("licenseManagerOverrideTicket")!=null){
               request.getSession().removeAttribute("licenseManagerOverrideTicket");
        }
    }





        boolean emailAuth = false;
        if(company.getAuthType().equals(com.liferay.portal.model.Company.AUTH_TYPE_EA)) {
            emailAuth = true;
        }


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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/dwr/interface/UserAjax.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("dojo.require(\"dojo.cookie\");\r\n");
      out.write("\r\n");
      out.write("    dojo.addOnLoad (function () {\r\n");
      out.write("        dojo.connect(dijit.byId('portal_login_as_user'), 'onChange',\r\n");
      out.write("            function (val) {\r\n");
      out.write("                if(val != '') {\r\n");
      out.write("                    ");
try {
      out.write("\r\n");
      out.write("                        UserAjax.hasUserRoles(dijit.byId('portal_login_as_user').value.split(\"-\")[1], [ '");
      out.print(APILocator.getRoleAPI().loadRoleByKey(
                        Role.ADMINISTRATOR).getId());
      out.write("', '");
      out.print(APILocator.getRoleAPI().loadCMSAdminRole().getId());
      out.write("' ], portal_loginAs_checkAdminRole);\r\n");
      out.write("                    ");
} catch (Exception ex) {

            }
      out.write("\r\n");
      out.write("                } else {\r\n");
      out.write("                    //dojo.byId('portal_loginasbutton').disabled = true;\r\n");
      out.write("                }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        dojo.connect(dijit.byId('portal_loginasbutton'), 'onClick', function () {\r\n");
      out.write("            dojo.byId('portal_login_as_users_form').submit();\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        ");
if (request.getSession().getAttribute("portal_login_as_error") != null) {
      out.write("\r\n");
      out.write("                dojo.byId('portal_loginas_errors').innerHTML = '");
      //  bean:message
      org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f0 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
      _jspx_th_bean_005fmessage_005f0.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fmessage_005f0.setParent(null);
      // /html/common/nav_sub_inc.jsp(239,64) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_bean_005fmessage_005f0.setKey((String) request.getSession().getAttribute(
                            "portal_login_as_error"));
      int _jspx_eval_bean_005fmessage_005f0 = _jspx_th_bean_005fmessage_005f0.doStartTag();
      if (_jspx_th_bean_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
      out.write("';\r\n");
      out.write("                portal_showLoginAs();\r\n");
      out.write("\r\n");
      out.write("        ");
request.getSession().removeAttribute(
                            "portal_login_as_error");
                }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    function portal_loginAs_checkAdminRole(isAdmin) {\r\n");
      out.write("        var wrapper = dojo.byId('portal_login_as_password_wrapper');\r\n");
      out.write("        if(isAdmin) {\r\n");
      out.write("            dojo.style(wrapper, { display: '' });\r\n");
      out.write("        } else {\r\n");
      out.write("            dojo.style(wrapper, { display: 'none' });\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function portal_showLoginAs() {\r\n");
      out.write("        dijit.byId('portal_login_as_users_wrapper').show();\r\n");
      out.write("        dijit.byId('portal_login_as_user').value = '';\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function portal_cancelLoginAs() {\r\n");
      out.write("        dijit.byId('portal_login_as_users_wrapper').hide();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function portal_showRolesPortlet() {\r\n");
      out.write("        dijit.byId('portal_roles_wrapper').show();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function portal_showMyAccount() {\r\n");
      out.write("        dijit.byId('portal_myaccount_wrapper').show();\r\n");
      out.write("        var userId='");
      out.print( user.getUserId());
      out.write("';\r\n");
      out.write("        if(userId!='null'){\r\n");
      out.write("            editUserMyAccount(userId);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    ");
 if(emailAuth) { 
      out.write("\r\n");
      out.write("    \tvar emailAuth = true;\r\n");
      out.write("    ");
 } else { 
      out.write("\r\n");
      out.write("    \tvar emailAuth = false;\r\n");
      out.write("    ");
 }  
      out.write("\r\n");
      out.write("\r\n");
      out.write("    var passwordsDontMatchError = '");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "passwords-dont-match-error")) );
      out.write("';\r\n");
      out.write("    var userSavedMsg = '");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "User-Info-Saved")) );
      out.write("';\r\n");
      out.write("    var sameEmailAlreadyRegisteredErrorMsg = '");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "user-email-already-registered")) );
      out.write("';\r\n");
      out.write("    var sameUserIdAlreadyRegisteredErrorMsg = '");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "user-id-already-registered")) );
      out.write("';\r\n");
      out.write("    var doNotHavePermissionsMsg = '");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "dont-have-permissions-msg")) );
      out.write("';\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    var currentUserMyAccount;\r\n");
      out.write("    function editUserMyAccount(userIdMyAccount) {\r\n");
      out.write("        //dojo.byId('loadingUserProfile').style.display = '';\r\n");
      out.write("        UserAjax.getUserById(userIdMyAccount, editUserMyAccountCallback);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //Gathering the user info from the server and setting up the right hand side\r\n");
      out.write("    //of user info\r\n");
      out.write("    function editUserMyAccountCallback(user) {\r\n");
      out.write("\r\n");
      out.write("        //Global user variable\r\n");
      out.write("        currentUserMyAccount = user;\r\n");
      out.write("\r\n");
      out.write("        //SEtting user info form\r\n");
      out.write("        if(!emailAuth) {\r\n");
      out.write("            dijit.byId('userIdMyAccount').attr('value', user.id);\r\n");
      out.write("            dijit.byId('userIdMyAccount').setDisabled(true);\r\n");
      out.write("        } else {\r\n");
      out.write("            dojo.byId('userIdValueMyAccount').innerHTML = user.id;\r\n");
      out.write("            dojo.byId('userIdMyAccount').value = user.id;\r\n");
      out.write("        }\r\n");
      out.write("        dojo.byId('userIdLabelMyAccount').style.display = '';\r\n");
      out.write("        dojo.byId('userIdValueMyAccount').style.display = '';\r\n");
      out.write("        dijit.byId('firstNameMyAccount').attr('value', user.firstName);\r\n");
      out.write("        dijit.byId('lastNameMyAccount').attr('value', user.lastName);\r\n");
      out.write("        dijit.byId('emailAddressMyAccount').attr('value', user.emailaddress);\r\n");
      out.write("        dijit.byId('passwordMyAccount').attr('value', '********');\r\n");
      out.write("        dijit.byId('passwordCheckMyAccount').attr('value', '********');\r\n");
      out.write("\r\n");
      out.write("        dojo.query(\".fullUserName\").forEach(function (elem) { elem.innerHTML = '<b>' + user.name + '</b>'; });\r\n");
      out.write("\r\n");
      out.write("        userChangedMyAccount = false;\r\n");
      out.write("        //dojo.byId('loadingUserProfile').style.display = 'none';\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    //Handler from when the user info has changed\r\n");
      out.write("    var userChangedMyAccount = false;\r\n");
      out.write("    function userInfoChangedMyAccount() {\r\n");
      out.write("        userChangedMyAccount = true;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //Handler from when the user password has changed\r\n");
      out.write("    var passwordChangedMyAccount = false;\r\n");
      out.write("    function userPasswordChangedMyAccount() {\r\n");
      out.write("        userChangedMyAccount = true;\r\n");
      out.write("        passwordChangedMyAccount = true;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //Handler to save the user details\r\n");
      out.write("    function saveUserDetailsMyAccount() {\r\n");
      out.write("\r\n");
      out.write("        //If user has not changed do nothing\r\n");
      out.write("        if(!userChangedMyAccount) {\r\n");
      out.write("            alert(userSavedMsg);\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        //If the form is not valid focus on the first not valid field and\r\n");
      out.write("        //hightlight the other not valid ones\r\n");
      out.write("        if(!dijit.byId('userInfoFormMyAccount').validate()) {\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        var myAccountpassswordValue;\r\n");
      out.write("        var myAccountreenterPasswordValue;\r\n");
      out.write("        if(passwordChangedMyAccount) {\r\n");
      out.write("            myAccountpassswordValue = dijit.byId('passwordMyAccount').attr('value');\r\n");
      out.write("            myAccountreenterPasswordValue = dijit.byId('passwordCheckMyAccount').attr('value');\r\n");
      out.write("            if(myAccountpassswordValue != myAccountreenterPasswordValue) {\r\n");
      out.write("                alert(passwordsDontMatchError);\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        //Executing the update user logic\r\n");
      out.write("        var callbackOptions = {\r\n");
      out.write("            callback: saveUserCallbackMyAccount,\r\n");
      out.write("            exceptionHandler: saveUserExceptionMyAccount\r\n");
      out.write("        }\r\n");
      out.write("        UserAjax.updateUser(currentUserMyAccount.id, currentUserMyAccount.id, dijit.byId('firstNameMyAccount').attr('value'),\r\n");
      out.write("                dijit.byId('lastNameMyAccount').attr('value'),\r\n");
      out.write("                dijit.byId('emailAddressMyAccount').attr('value'), myAccountpassswordValue, callbackOptions);\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //Callback from the server to confirm the user saved\r\n");
      out.write("    function saveUserCallbackMyAccount (userId) {\r\n");
      out.write("        if(userId) {\r\n");
      out.write("            userChangedMyAccount = false;\r\n");
      out.write("            passwordChangedMyAccount = false;\r\n");
      out.write("            alert(userSavedMsg);\r\n");
      out.write("            editUserMyAccount(userId);\r\n");
      out.write("        } else {\r\n");
      out.write("            alert(userSaveFailedMsg);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function saveUserExceptionMyAccount(message, exception){\r\n");
      out.write("        if(exception.javaClassName == 'com.dotmarketing.business.DuplicateUserException') {\r\n");
      out.write("            if(emailAuth) {\r\n");
      out.write("                alert(sameEmailAlreadyRegisteredErrorMsg);\r\n");
      out.write("            }\r\n");
      out.write("            else {\r\n");
      out.write("                alert(sameUserIdAlreadyRegisteredErrorMsg);\r\n");
      out.write("            }\r\n");
      out.write("        } else if(exception.javaClassName == 'com.dotmarketing.exception.DotSecurityException'){\r\n");
      out.write("                alert(doNotHavePermissionsMsg);\r\n");
      out.write("            }else {\r\n");
      out.write("            alert(\"Server error: \" + exception);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function showAutoUpdaterPopUp(){\r\n");
      out.write("        dijit.byId('portal_autoupdater_wrapper').show();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function remindMeLater(){\r\n");
      out.write("        dojo.cookie(\"autoupdater-reminder\", \"true\",{expires: 7, path: '/'});\r\n");
      out.write("        dijit.byId('portal_autoupdater_wrapper').hide();\r\n");
      out.write("        document.getElementById('autoUpdaterLink').style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var major;\r\n");
      out.write("    var minor;\r\n");
      out.write("\r\n");
      out.write("    function whatsNew(version){\r\n");
      out.write("        var href = \"http://dotcms.com/dotCMSVersions#\";\r\n");
      out.write("        if (version=='current'){\r\n");
      out.write("            href+=\"");
      out.print( ReleaseInfo.getVersion() );
      out.write("\";\r\n");
      out.write("        }else if(version=='major'){\r\n");
      out.write("            href+=major;\r\n");
      out.write("        }else if(version=='minor'){\r\n");
      out.write("            href+=minor;\r\n");
      out.write("        }\r\n");
      out.write("        window.open(href);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function howTo(){\r\n");
      out.write("\r\n");
      out.write("        var href = \"");
      out.print( LanguageUtil.get(pageContext, "Autoupdater-link"));
      out.write("\";\r\n");
      out.write("        window.open(href);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function setTextContent(element, text) {\r\n");
      out.write("        while (element.firstChild!==null)\r\n");
      out.write("            element.removeChild(element.firstChild); // remove all existing content\r\n");
      out.write("        element.appendChild(document.createTextNode(text));\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function enableAutoUpdaterLink(versionInfo){\r\n");
      out.write("        major = versionInfo.major;\r\n");
      out.write("        minor = versionInfo.minor;\r\n");
      out.write("        build = versionInfo.buildNumber;\r\n");
      out.write("        if(major!=''){\r\n");
      out.write("            document.getElementById('majorUpdate').style.display=\"\";\r\n");
      out.write("            setTextContent(document.getElementById('wnMajor'), major + \"(");
      out.print( LanguageUtil.get(pageContext, "Whats-new") );
      out.write(")\");\r\n");
      out.write("        }\r\n");
      out.write("        if(minor!=''){\r\n");
      out.write("            document.getElementById('minorUpdate').style.display=\"\";\r\n");
      out.write("            if(build!='' && build!='0'){\r\n");
      out.write("                setTextContent(document.getElementById('wnMinor'),  minor + \" Build: \" + build +\"(");
      out.print( LanguageUtil.get(pageContext, "Whats-new") );
      out.write(")\");\r\n");
      out.write("            }else{\r\n");
      out.write("                setTextContent(document.getElementById('wnMinor'),minor + \"(");
      out.print( LanguageUtil.get(pageContext, "Whats-new") );
      out.write(")\");\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        var autoUpdaterCookie = dojo.cookie(\"autoupdater-reminder\");\r\n");
      out.write("        if(!autoUpdaterCookie || autoUpdaterCookie=='false' || autoUpdaterCookie=='undefined'){\r\n");
      out.write("            if(versionInfo.showUpdate){\r\n");
      out.write("                 //var animArgs = {node: 'autoUpdaterLink',duration: 1000, delay: 50};\r\n");
      out.write("                 //dojo.fadeIn(animArgs).play();\r\n");
      out.write("                 dojo.style(\"autoUpdaterLink\", \"display\", \"inline-block\");\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\tfunction showAboutDotCMSMessage(){\r\n");
      out.write("       var myDialog = dijit.byId(\"dotBackEndDialog\");\r\n");
      out.write("       myDialog.titleNode.innerHTML=\"");
      out.print( LanguageUtil.get(pageContext, "about") );
      out.write(" dotCMS\";\r\n");
      out.write("       dijit.byId(\"dotBackEndDialogCP\").setHref(\"/html/portal/about.jsp\");\r\n");
      out.write("       myDialog.show();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction showDisclaimerMessage(){\r\n");
      out.write("       var myDialog = dijit.byId(\"dotBackEndDialog\");\r\n");
      out.write("       myDialog.titleNode.innerHTML=\"");
      out.print( UnicodeLanguageUtil.get(pageContext, "disclaimer") );
      out.write("\";\r\n");
      out.write("       dijit.byId(\"dotBackEndDialogCP\").setHref(\"/html/portal/disclaimer.jsp\");\r\n");
      out.write("       myDialog.show();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t function toggleAccount() {\r\n");
      out.write("\t\tif(document.getElementById(\"account-menu\").style.display==\"none\") {\r\n");
      out.write("\t\t\tdocument.getElementById(\"account-menu\").style.display=\"\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"closeTab\").style.display=\"\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"account-trigger\").setAttribute(\"class\", \"trigger-on\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdocument.getElementById(\"account-menu\").style.display=\"none\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"closeTab\").style.display=\"none\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"account-trigger\").setAttribute(\"class\", \"trigger-off\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\t\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div id=\"admin-banner-logo-div\">\r\n");
      out.write("    <h1>dotCMS</h1>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Start Site Tools -->\r\n");
 if (signedIn) { 
      out.write("\r\n");
      out.write("    <div id=\"admin-site-tools-div\">\r\n");
      out.write("\t\t<!-- Updates -->\r\n");
      out.write("        ");
 if (licenseMessage != null) { 
      out.write("\r\n");
      out.write("            <a class=\"goEnterpriseLink\" href=\"");
      out.print(licenseURL);
      out.write("\"><span class=\"keyIcon\"></span>");
      out.print(licenseMessage);
      out.write("</a>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \t\t<a id=\"autoUpdaterLink\" style=\"display:none;\" class=\"goEnterpriseLink\"  href=\"javascript: showAutoUpdaterPopUp();\"><span class=\"exclamation-red\"></span>");
      out.print( LanguageUtil.get(pageContext, "Update-available") );
      out.write("</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- User Actions -->\r\n");
      out.write("\t\t");
 if (request.getSession().getAttribute(WebKeys.PRINCIPAL_USER_ID) == null) { 
      out.write("\r\n");
      out.write("\t\t\t<a href=\"#\" id=\"account-trigger\" onclick=\"toggleAccount();\" class=\"trigger-off\">");
      out.print(user.getFullName());
      out.write("</a>\r\n");
      out.write("\t    ");
 } else { 
      out.write("\r\n");
      out.write("\t        <a href=\"");
      out.print(CTX_PATH);
      out.write("/portal");
      out.print(PortalUtil.getAuthorizedPath(request));
      out.write("/logout_as?referer=");
      out.print(CTX_PATH);
      out.write("\"><span class=\"plusIcon\"></span>");
      if (_jspx_meth_bean_005fmessage_005f1(_jspx_page_context))
        return;
      out.write(' ');
      out.print(user.getFullName());
      out.write("</a>\r\n");
      out.write("\t    ");
 } 
      out.write("\r\n");
      out.write("\t</div>\r\n");
 } 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!-- End Site Tools -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- User Info Drop Down -->\r\n");
      out.write("\r\n");
      out.write("<div id=\"account-menu\" class=\"account-flyout\" style=\"display:none;\">\r\n");
      out.write("\t<div class=\"my-account\">\r\n");
      out.write("\t\t<h3>");
      out.print(user.getFullName());
      out.write("</h3>\r\n");
      out.write("\t\t<a href=\"javascript: portal_showMyAccount();toggleAccount();\">\r\n");
      out.write("\t\t\t");
      out.print(LanguageUtil.get(pageContext, "my-account"));
      out.write("\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"service-links\">\r\n");
      out.write("\t\t<a  href=\"javascript:showAboutDotCMSMessage();toggleAccount();\" >");
      out.print( LanguageUtil.get(pageContext, "about")  );
      out.write("</a>\r\n");
      out.write("\t\t<a  href=\"javascript:showDisclaimerMessage();toggleAccount();\">");
      out.print( LanguageUtil.get(pageContext, "disclaimer")  );
      out.write("</a>\r\n");
      out.write("\t\t<a  href=\"#\" onClick=\"dijit.byId('showSupport').show();toggleAccount();\">");
      out.print(LanguageUtil.get(pageContext, "Support") );
      out.write("</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"login-out\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<a  href=\"");
      out.print(CTX_PATH);
      out.write("/portal");
      out.print(PortalUtil.getAuthorizedPath(request));
      out.write("/logout?referer=");
      out.print(CTX_PATH);
      out.write('"');
      out.write('>');
      out.print(LanguageUtil.get(pageContext, "Logout"));
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /html/common/nav_sub_inc.jsp(548,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest( APILocator.getRoleAPI().doesUserHaveRole(user, APILocator.getRoleAPI().loadRoleByKey(Role.LOGIN_AS)) && request.getSession().getAttribute(WebKeys.PRINCIPAL_USER_ID) == null );
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<td style=\"border-left:1px solid #d0d0d0;width:50%;\"><a href=\"javascript: portal_showLoginAs();toggleAccount();\">");
          if (_jspx_meth_bean_005fmessage_005f2(_jspx_th_c_005fif_005f1, _jspx_page_context))
            return;
          out.write("</a></td>\r\n");
          out.write("\t\t\t\t    ");
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
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("    ");
 if (!hasRolesPortlet && APILocator.getUserAPI().isCMSAdmin(user) ) { 
      out.write("\r\n");
      out.write("        <a class=\"rolePortletLink\" href=\"");
      out.print(portletLinkHREF);
      out.write('"');
      out.write('>');
      if (_jspx_meth_bean_005fmessage_005f3(_jspx_page_context))
        return;
      out.write("</a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"closeTab\" onClick=\"toggleAccount();\" style=\"display:none;\"></div>\r\n");
      out.write("\r\n");
      out.write("<!-- End User Info Drop Down -->\r\n");
      out.write("\r\n");
      out.write("<!-- Start Login As pop up -->\r\n");
      out.write("    ");

        if (APILocator.getRoleAPI().doesUserHaveRole(user,
            APILocator.getRoleAPI().loadRoleByKey(Role.LOGIN_AS))
            && request.getSession().getAttribute(
                WebKeys.PRINCIPAL_USER_ID) == null) {
    
      out.write("\r\n");
      out.write("        <div id=\"portal_login_as_users_wrapper\" dojoType=\"dijit.Dialog\" style=\"display:none;height:180px;vertical-align: middle;\" draggable=\"false\" >\r\n");
      out.write("            <div id=\"portal_loginas_errors\"></div>\r\n");
      out.write("            <form id=\"portal_login_as_users_form\" action=\"");
      out.print(CTX_PATH);
      out.write("/portal");
      out.print(PortalUtil.getAuthorizedPath(request));
      out.write("/login_as?referer=");
      out.print(CTX_PATH);
      out.write("\" method=\"post\">\r\n");
      out.write("                <div id=\"portal_login_as_users_select\" class=\"formRow\" style=\"text-align:center;\">\r\n");
      out.write("                    <div dojoType=\"dotcms.dojo.data.UsersReadStore\" jsId=\"usersStore\" includeRoles=\"false\"></div>\r\n");
      out.write("                    ");
      if (_jspx_meth_bean_005fmessage_005f4(_jspx_page_context))
        return;
      out.write(" : &nbsp;\r\n");
      out.write("                        <select id=\"portal_login_as_user\" name=\"portal_login_as_user\" dojoType=\"dijit.form.FilteringSelect\"\r\n");
      out.write("                        store=\"usersStore\" searchDelay=\"300\" pageSize=\"30\" labelAttr=\"name\"\r\n");
      out.write("                        invalidMessage=\"");
      out.print(LanguageUtil.get(pageContext,
                            "Invalid-option-selected"));
      out.write("\"\r\n");
      out.write("                        ></select>\r\n");
      out.write("                </div><br/>\r\n");
      out.write("                <div class=\"formRow\" id=\"portal_login_as_password_wrapper\" style=\"text-align:center; display: none;\">\r\n");
      out.write("                    ");
      if (_jspx_meth_bean_005fmessage_005f5(_jspx_page_context))
        return;
      out.write(" <input type=\"password\" name=\"portal_login_as_password\" id=\"portal_login_as_password\"/><br/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"formRow\"  style=\"text-align:center\">\r\n");
      out.write("                    <button dojoType=\"dijit.form.Button\" id=\"portal_loginasbutton\" iconClass=\"loginAsIcon\">");
      if (_jspx_meth_bean_005fmessage_005f6(_jspx_page_context))
        return;
      out.write("</button>\r\n");
      out.write("                    <button dojoType=\"dijit.form.Button\" iconClass=\"cancelIcon\" onclick=\"portal_cancelLoginAs()\">");
      if (_jspx_meth_bean_005fmessage_005f7(_jspx_page_context))
        return;
      out.write("</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("<!-- End Login As pop up -->\r\n");
      out.write("\r\n");
      out.write("<!-- START User Detail pop up -->\r\n");
      out.write("    <div id=\"portal_myaccount_wrapper\" dojoType=\"dijit.Dialog\" style=\"display:none;height:400px;width:450px;vertical-align: middle;\" draggable=\"false\" >\r\n");
      out.write("        <div style=\"overflow-y:auto;\" dojoType=\"dijit.layout.ContentPane\">\r\n");
      out.write("            <div class=\"yui-g nameHeader\">\r\n");
      out.write("                <div class=\"yui-u first\">\r\n");
      out.write("                    <span id=\"fullUserNameMyAccount\" class=\"fullUserName\"></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div style=\"padding:0 0 10px 0; border-bottom:1px solid #ccc;\">\r\n");
      out.write("                <form id=\"userInfoFormMyAccount\" dojoType=\"dijit.form.Form\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userPasswordChanged\" value=\"false\"/>\r\n");
      out.write("                    <dl>\r\n");
      out.write("                        ");
 if(emailAuth) { 
      out.write("\r\n");
      out.write("                            <dt id=\"userIdLabelMyAccount\">");
      out.print( LanguageUtil.get(pageContext, "User-ID") );
      out.write(": <input type=\"hidden\" id=\"userIdMyAccount\" name=\"userId\" value=\"\"/></dt>\r\n");
      out.write("                            <dd id=\"userIdValueMyAccount\"></dd>\r\n");
      out.write("                        ");
 } else {
      out.write("\r\n");
      out.write("                            <dt id=\"userIdLabelMyAccount\">");
      out.print( LanguageUtil.get(pageContext, "User-ID") );
      out.write(":</dt>\r\n");
      out.write("                            <dd id=\"userIdValueMyAccount\"><input id=\"userIdMyAccount\" type=\"text\" onkeyup=\"userInfoChangedMyAccount()\" required=\"true\" invalidMessage=\"Required.\" dojoType=\"dijit.form.ValidationTextBox\" disabled=\"disabled\" /></dd>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                        <dt>");
      out.print( LanguageUtil.get(pageContext, "First-Name") );
      out.write(":</dt>\r\n");
      out.write("                        <dd><input id=\"firstNameMyAccount\" type=\"text\" onkeyup=\"userInfoChangedMyAccount()\" required=\"true\" invalidMessage=\"Required.\" dojoType=\"dijit.form.ValidationTextBox\" /></dd>\r\n");
      out.write("                        <dt>");
      out.print( LanguageUtil.get(pageContext, "Last-Name") );
      out.write(":</dt>\r\n");
      out.write("                        <dd><input id=\"lastNameMyAccount\" type=\"text\" onkeyup=\"userInfoChangedMyAccount()\" required=\"true\" invalidMessage=\"Required.\" dojoType=\"dijit.form.ValidationTextBox\" /></dd>\r\n");
      out.write("                        <dt>");
      out.print( LanguageUtil.get(pageContext, "Email-Address") );
      out.write(":</dt>\r\n");
      out.write("                        <dd><input id=\"emailAddressMyAccount\" type=\"text\" onkeyup=\"userInfoChangedMyAccount()\" required=\"true\" invalidMessage=\"Required.\" dojoType=\"dijit.form.ValidationTextBox\" /></dd>\r\n");
      out.write("                        <dt>");
      out.print( LanguageUtil.get(pageContext, "Password") );
      out.write(":</dt>\r\n");
      out.write("                        <dd><input id=\"passwordMyAccount\" type=\"password\" onkeyup=\"userPasswordChangedMyAccount()\" required=\"true\" invalidMessage=\"Required.\" dojoType=\"dijit.form.ValidationTextBox\" /></dd>\r\n");
      out.write("                        <dt>");
      out.print( LanguageUtil.get(pageContext, "Password-Again") );
      out.write(":</dt>\r\n");
      out.write("                        <dd><input id=\"passwordCheckMyAccount\" type=\"password\" onkeyup=\"userPasswordChangedMyAccount()\" required=\"true\" invalidMessage=\"Required.\" dojoType=\"dijit.form.ValidationTextBox\" /></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clear\"></div>\r\n");
      out.write("            <div class=\"buttonRow\">\r\n");
      out.write("                <button dojoType=\"dijit.form.Button\" onclick=\"saveUserDetailsMyAccount()\" type=\"button\" iconClass=\"saveIcon\">");
      out.print( LanguageUtil.get(pageContext, "Save") );
      out.write("</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("<!-- END User Detail pop up -->\r\n");
      out.write("\r\n");
 if (APILocator.getUserAPI().isCMSAdmin(user)) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- START Auto Updater pop up -->\r\n");
      out.write("        <div id=\"portal_autoupdater_wrapper\" dojoType=\"dijit.Dialog\" style=\"display:none;height:280px;width:450px;vertical-align: middle;\" draggable=\"false\" >\r\n");
      out.write("            <div style=\"overflow-y:auto;\" dojoType=\"dijit.layout.ContentPane\">\r\n");
      out.write("                <div class=\"yui-g nameHeader\">\r\n");
      out.write("                    <div class=\"yui-u first\">\r\n");
      out.write("                        <span class=\"fullUserName\"><b>");
      out.print( LanguageUtil.get(pageContext, "Update-available") );
      out.write("</b></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div style=\"padding:0 0 10px 0; border-bottom:1px solid #ccc;\" align=\"center\">\r\n");
      out.write("                <b>");
      out.print( LanguageUtil.get(pageContext, "You-are-running") );
      out.write(":</b> <a href=\"javascript:whatsNew('current');\">");
      out.print( ReleaseInfo.getVersion() );
      out.write('(');
      out.print( LanguageUtil.get(pageContext, "Whats-new") );
      out.write(")</a>\r\n");
      out.write("                <br />\r\n");
      out.write("                <br />\r\n");
      out.write("                <div id=\"minorUpdate\" style=\"display:none;\">\r\n");
      out.write("                <b>");
      out.print( LanguageUtil.get(pageContext, "Latest-update") );
      out.write(":</b> <a id=\"wnMinor\" href=\"javascript:whatsNew('minor');\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br />\r\n");
      out.write("                <div id=\"majorUpdate\" style=\"display:none;\">\r\n");
      out.write("                <b>");
      out.print( LanguageUtil.get(pageContext, "New-version") );
      out.write(":</b> <a id=\"wnMajor\" href=\"javascript:whatsNew('major');\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br />\r\n");
      out.write("                <br />\r\n");
      out.write("                <a href=\"javascript:howTo();\">");
      out.print( LanguageUtil.get(pageContext, "Learn-how-to-use-the-autoupdater") );
      out.write("</a>\r\n");
      out.write("                <br />\r\n");
      out.write("                <br />\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clear\"></div>\r\n");
      out.write("                <div class=\"buttonRow\">\r\n");
      out.write("                    <button dojoType=\"dijit.form.Button\" onclick=\"remindMeLater()\" type=\"button\">");
      out.print( LanguageUtil.get(pageContext, "Remind-me-later") );
      out.write("</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    <!-- END Auto Updater pop up -->\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- About pop up -->\r\n");
      out.write("\t<div id=\"dotBackEndDialog\" dojoType=\"dijit.Dialog\" style=\"display:none\" title=\"");
      out.print( LanguageUtil.get(pageContext, "about") );
      out.write(" dotCMS\">\r\n");
      out.write("\t\t<!-- Server Info -->\r\n");
      out.write("\t\t\t");
String serverId = Config.getStringProperty("DIST_INDEXATION_SERVER_ID");
      out.write("\r\n");
      out.write("\t\t\t");
 if (UtilMethods.isSet(serverId)){ 
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"serverID\"><strong>Server:</strong> ");
      out.print(serverId);
      out.write("</div>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t<!-- End Server Info -->\r\n");
      out.write("\t\t<div dojoType=\"dijit.layout.ContentPane\" style=\"width:400px;height:150px;\" class=\"box\" hasShadow=\"true\" id=\"dotBackEndDialogCP\"></div>\r\n");
      out.write("\t\t<div class=\"copyright\">&copy;");
      out.print(new GregorianCalendar().get(Calendar.YEAR));
      out.write(" dotCMS Inc. ");
      out.print( LanguageUtil.get(pageContext, "All-rights-reserved") );
      out.write(".</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Support pop up -->\r\n");
      out.write("\t<div id=\"showSupport\" dojoType=\"dijit.Dialog\" style=\"display: none\">\r\n");
      out.write("\t\t<table width=\"600\"><tr>\r\n");
      out.write("\t\t\t<td valign=\"top\" width=\"50%\" style=\"padding:10px;border-right:1px solid #dcdcdc;\">\r\n");
      out.write("\t\t\t\t<h2>");
      out.print(LanguageUtil.get(pageContext, "Report-a-Bug") );
      out.write("</h2>\r\n");
      out.write("\t\t\t\t<p>");
      out.print(LanguageUtil.get(pageContext, "dotCMS-is-dedicated-to-quality-assurance") );
      out.write("</p>\r\n");
      out.write("\t\t\t\t<div class=\"buttonRow\">\r\n");
      out.write("\t\t\t\t\t<button dojoType=\"dijit.form.Button\" iconClass=\"bugIcon\" onclick=\"window.open('https://github.com/dotCMS');\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(LanguageUtil.get(pageContext, "Report-a-Bug") );
      out.write("\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td valign=\"top\" width=\"50%\" style=\"padding:10px 10px 10px 20px;\">\r\n");
      out.write("\t\t\t\t<h2>");
      out.print(LanguageUtil.get(pageContext, "Professional-Support") );
      out.write("</h2>\r\n");
      out.write("\t\t\t\t<p>");
      out.print(LanguageUtil.get(pageContext, "Let-our-support-engineers-get-you-back-on-track") );
      out.write("</p>\r\n");
      out.write("\t\t\t\t<div style=\"text-align:center;font-size:146.5%;color:#990000;\">+1 877-9-DOTCMS</div>\r\n");
      out.write("\t\t\t\t<div style=\"text-align:center;font-size:77%;color:#999;\">");
      out.print(LanguageUtil.get(pageContext, "Toll-Free") );
      out.write("+1 877-936-8267</div>\r\n");
      out.write("\t\t\t\t<div style=\"text-align:center;font-size:146.5%;color:#999;\">");
      out.print(LanguageUtil.get(pageContext, "or") );
      out.write("</div>\r\n");
      out.write("\t\t\t\t<div style=\"text-align:center;\">\r\n");
      out.write("\t\t\t\t\t<a href=\"http://www.dotcms.org/enterprise/\" target=\"_blank\">");
      out.print(LanguageUtil.get(pageContext, "Click-here-to-login-to-your-account") );
      out.write("</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr></table>\r\n");
      out.write("\t</div>\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
if(session.getAttribute("_autoupdater_showUpdate") == null) {
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\" src=\"/dwr/interface/AutoUpdaterAjax.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            dojo.addOnLoad(function(){\r\n");
      out.write("                AutoUpdaterAjax.getLatestVersionInfo(dojo.hitch(enableAutoUpdaterLink));\r\n");
      out.write("            })\r\n");
      out.write("        </script>\r\n");
      out.write("    ");
}else if((Boolean) session.getAttribute("_autoupdater_showUpdate") == true) {
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            dojo.addOnLoad(function(){\r\n");
      out.write("                var enableupdatevar = {\r\n");
      out.write("                        showUpdate : ");
      out.print(session.getAttribute("_autoupdater_showUpdate"));
      out.write(",\r\n");
      out.write("                        major : \"");
      out.print(session.getAttribute("_autoupdater_major"));
      out.write("\",\r\n");
      out.write("                        minor : \"");
      out.print(session.getAttribute("_autoupdater_minor"));
      out.write("\",\r\n");
      out.write("                        buildNumber : '0'\r\n");
      out.write("                }\r\n");
      out.write("                if(enableupdatevar.showUpdate){\r\n");
      out.write("                    enableAutoUpdaterLink(enableupdatevar);\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        </script>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("\r\n");
}
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\t\t\t");
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

if(request.getSession().getAttribute(ActionErrors.GLOBAL_ERROR) != null){
	request.setAttribute(ActionErrors.GLOBAL_ERROR, request.getSession().getAttribute(ActionErrors.GLOBAL_ERROR));

}


Set<String> messages = new HashSet<String>();
Set<String> errors = new HashSet<String>();

if(request.getAttribute(ActionErrors.GLOBAL_ERROR) !=null){
	ActionErrors aes = (ActionErrors) request.getAttribute(ActionErrors.GLOBAL_ERROR);
	Iterator it = aes.get();
	while(it.hasNext()){
		ActionMessage am = (ActionMessage) it.next();
		String m = LanguageUtil.get(pageContext, am.getKey());
		if(am.getValues() != null){
			for(int i=0;i<am.getValues().length;i++){
				m = UtilMethods.replace(m, "{" + i + "}", (String) am.getValues()[i]);
			}
		}
		errors.add(m);
	}
}

if(request.getAttribute(Globals.ERROR_KEY) != null){
	ActionErrors aes = (ActionErrors) request.getAttribute(Globals.ERROR_KEY);
	Iterator it = aes.get();
	while(it.hasNext()){
		ActionMessage am = (ActionMessage) it.next();
		String m = LanguageUtil.get(pageContext, am.getKey());
		if(am.getValues() != null){
			for(int i=0;i<am.getValues().length;i++){
				m = UtilMethods.replace(m, "{" + i + "}", (String) am.getValues()[i]);
			}
		}
		errors.add(m);
	}
}




if(request.getAttribute(ActionMessages.GLOBAL_MESSAGE) !=null){
	ActionMessages aes = (ActionMessages) request.getAttribute(ActionMessages.GLOBAL_MESSAGE);
	Iterator it = aes.get();
	while(it.hasNext()){
		ActionMessage am = (ActionMessage) it.next();
		messages.add(am.getKey());
	}
}



if(SessionMessages.contains(session, "message")){
	messages.add((String) SessionMessages.get(session, "message"));
}

if(SessionMessages.contains(session, "error")){
	errors.add((String) SessionMessages.get(session, "error"));
}
if(SessionMessages.contains(session, "custommessage")){
	messages.add((String) SessionMessages.get(session, "custommessage"));
}

if(SessionMessages.contains(request, "message")){
	messages.add((String) SessionMessages.get(request, "message"));
}
if(SessionMessages.contains(request, "error")){
	errors.add((String) SessionMessages.get(request, "error"));
}
if(SessionMessages.contains(request, "custommessage")){
	messages.add((String) SessionMessages.get(request, "custommessage"));
}



SessionMessages.clear(session);
SessionMessages.clear(request);
request.getSession().removeAttribute("org.apache.struts.action.MESSAGE");
request.getSession().removeAttribute("org.apache.struts.action.ERROR");




      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tdojo.require(\"dojo.fx\");\r\n");
      out.write("\tdojo.require(\"dijit.layout.ContentPane\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar messagesCount = 0;\r\n");
      out.write("\tvar messageYIncrement = 60;\r\n");
      out.write("\tvar occupiedPositions = new Array();\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t");
if(errors.size() > 0){
      out.write("\r\n");
      out.write("\t\t   dojo.addOnLoad(\r\n");
      out.write("\t\t\t\t   function () {\r\n");
      out.write("\t\t   \t\t\t\tshowDotCMSErrorMessage(\"<ul>");
for(String x : errors){
      out.write("<li>");
      out.print(UtilMethods.replace(LanguageUtil.get(pageContext, x), "\"", "\\\"") );
      out.write("</li>");
} 
      out.write("</ul>\")\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t   \t\t);\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t");
if(messages.size() > 0){
      out.write("\r\n");
      out.write("\t\t   dojo.addOnLoad(\r\n");
      out.write("\t\t\t\t   function () {\r\n");
      out.write("\t\t   \t\t\t\tshowDotCMSSystemMessage(\"<div class=\\\"messageIcon resolveIcon\\\"></div>\" + \"");
for(String x : messages){
      out.write(' ');
      out.print(UtilMethods.replace(LanguageUtil.get(pageContext, x), "\"", "\\\"") );
} 
      out.write("\")\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t   \t\t);\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction showDotCMSSystemMessage(message){\r\n");
      out.write("\t\t\tshowDotCMSSystemMessage(message, false);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction showDotCMSSystemMessage(message, isError){\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar position = 40;\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(occupiedPositions.length > 0)\r\n");
      out.write("\t\t\t\tposition = occupiedPositions[occupiedPositions.length - 1] + messageYIncrement;\t\r\n");
      out.write("\t\t\t\toccupiedPositions.push(position);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar className = isError? 'systemErrorsHolder':'systemMessagesHolder';\r\n");
      out.write("\t\t\tvar holdingDiv = dojo.create(\"div\", { \t\r\n");
      out.write("\t\t\t\tid : \"systemMessagesWrapper\" + messagesCount, \r\n");
      out.write("\t\t\t\tclassName : className,\r\n");
      out.write("\t\t\t\tstyle: { top: position + '%' }\r\n");
      out.write("\t\t\t}, dojo.body());\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar className = isError? 'errorMessages':'systemMessages';\r\n");
      out.write("\t\t\tvar systemMessages = dojo.create(\"div\", { \t\r\n");
      out.write("\t\t\t\tid: \"systemMessages\" + messagesCount,\r\n");
      out.write("\t\t\t\tclassName: className\r\n");
      out.write("\t\t\t}, holdingDiv);\r\n");
      out.write("\r\n");
      out.write("\t\t\tsystemMessages.innerHTML = message;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tdojo.connect(dijit.byId(\"systemMessages\"), \"onClick\", hideDotCMSSystemMessage);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tvar hideFn = dojo.partial(hideDotCMSSystemMessage, messagesCount);\r\n");
      out.write("\t\t\tdojo.connect(holdingDiv, 'onclick', hideFn);\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar hideFn = dojo.partial(hideDotCMSSystemMessage, messagesCount);\r\n");
      out.write("\t\t\tvar fadeOutFn = dojo.fadeOut({node: \"systemMessages\" + messagesCount, delay: 10, duration: 0, onEnd: hideFn }).play;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar fadeIn = dojo.fadeIn({node: \"systemMessages\" + messagesCount, duration: 2000, onEnd: fadeOutFn });\r\n");
      out.write("\t\t\tfadeIn.play();\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar ttl = message.split(\" \").length;\r\n");
      out.write("\t\t\tttl = ttl * 200;\r\n");
      out.write("\t\t\tif(ttl < 1000){\r\n");
      out.write("\t\t\t\tttl = 1000;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\thideMessagesHandler = setTimeout(hideFn,ttl);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tmessagesCount++;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction hideDotCMSSystemMessage(messageId){\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar currentY = parseInt(dojo.byId(\"systemMessagesWrapper\" + messageId).style.top);\r\n");
      out.write("\t\t\toccupiedPositions = dojo.filter(occupiedPositions, function (x) {\r\n");
      out.write("\t\t\t\treturn x != currentY;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tdojo.fadeOut({node: \"systemMessagesWrapper\" + messageId}).play();\r\n");
      out.write("\t\t\tdojo.destroy(\"systemMessagesWrapper\" + messageId);\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar hideErrorsHandler;\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction showDotCMSErrorMessage(message){\r\n");
      out.write("\t\t\tshowDotCMSSystemMessage(message, true);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"bd\">\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response,  Constants.TEXT_HTML_DIR + tilesContent , out, false);
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
if((DbConnectionFactory.isOracle() ||  DbConnectionFactory.isMsSql()) 
		&& "100".equals(System.getProperty("dotcms_level")) 
		&& session.getAttribute("db-community-edition-warning") ==null){ 
      out.write('\n');
      out.write('	');
      out.write('	');
session.setAttribute("db-community-edition-warning", "1");  
      out.write("\n");
      out.write("\t<script>\n");
      out.write("\t\tfunction closeCotDbWarningDialog(){\n");
      out.write("\t\t\tdijit.byId('dotDbWarningDialog').hide();\n");
      out.write("\t\t\t");
if(request.getAttribute("licenseManagerPortletUrl") != null){ 
      out.write("\n");
      out.write("\t\t\t\twindow.location='");
      out.print(request.getAttribute("licenseManagerPortletUrl") );
      out.write("';\n");
      out.write("\t\t\t");
}
      out.write("\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t<div id=\"dotDbWarningDialog\" dojoType=\"dijit.Dialog\" style=\"display:none\" title=\"");
      out.print( LanguageUtil.get(pageContext, "db-community-edition-warning-title") );
      out.write("\">\n");
      out.write("\t\t<div dojoType=\"dijit.layout.ContentPane\" style=\"width:400px;height:150px;\" class=\"box\" hasShadow=\"true\" id=\"dotDbWarningDialogCP\">\n");
      out.write("\t\t\t");
      out.print( LanguageUtil.get(pageContext, "db-community-edition-warning-text") );
      out.write("\n");
      out.write("\t\t\t<br>&nbsp;<br>\n");
      out.write("\t\t\t<div class=\"buttonRow\">\n");
      out.write("\t\t\t\t<button dojoType=\"dijit.form.Button\" onClick=\"closeCotDbWarningDialog()\" iconClass=\"cancelIcon\">");
      out.print( LanguageUtil.get(pageContext, "close") );
      out.write("</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<script>\n");
      out.write("\t\tdojo.addOnLoad (function(){\n");
      out.write("\t\t\tdojo.style(dijit.byId(\"dotDbWarningDialog\").closeButtonNode, \"visibility\", \"hidden\"); \n");
      out.write("\t\t\tdijit.byId(\"dotDbWarningDialog\").show();\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("\t\n");
} 
      out.write("\n");
      out.write("\n");
      out.write("\r\n");
      out.write("<iframe name=\"hidden_iframe\" id=\"hidden_iframe\" style=\"position:absolute;top:-100px;width:0px; height:0px; border: 0px;\"></iframe>\r\n");
      out.write("<script>\n");
      out.write("\tfunction setKeepAlive(){\n");
      out.write("\t\tvar myId=document.getElementById(\"hidden_iframe\");\n");
      out.write("\t\tmyId.src =\"/html/common/keep_alive.jsp?r=");
      out.print(System.currentTimeMillis());
      out.write("\";\n");
      out.write("\t}\n");
      out.write("\t// 15 minutes\n");
      out.write("\tsetTimeout(\"setKeepAlive()\", 60000 * 15);\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
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

  private boolean _jspx_meth_bean_005fmessage_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f1 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fmessage_005f1.setParent(null);
    // /html/common/nav_sub_inc.jsp(519,144) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fmessage_005f1.setKey("logout-as");
    int _jspx_eval_bean_005fmessage_005f1 = _jspx_th_bean_005fmessage_005f1.doStartTag();
    if (_jspx_th_bean_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f1);
    return false;
  }

  private boolean _jspx_meth_bean_005fmessage_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f2 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_005fmessage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fmessage_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /html/common/nav_sub_inc.jsp(549,119) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fmessage_005f2.setKey("login-as");
    int _jspx_eval_bean_005fmessage_005f2 = _jspx_th_bean_005fmessage_005f2.doStartTag();
    if (_jspx_th_bean_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f2);
    return false;
  }

  private boolean _jspx_meth_bean_005fmessage_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f3 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_005fmessage_005f3.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fmessage_005f3.setParent(null);
    // /html/common/nav_sub_inc.jsp(557,63) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fmessage_005f3.setKey("warning-roles-portlet");
    int _jspx_eval_bean_005fmessage_005f3 = _jspx_th_bean_005fmessage_005f3.doStartTag();
    if (_jspx_th_bean_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f3);
    return false;
  }

  private boolean _jspx_meth_bean_005fmessage_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f4 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_005fmessage_005f4.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fmessage_005f4.setParent(null);
    // /html/common/nav_sub_inc.jsp(577,20) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fmessage_005f4.setKey("Select-User");
    int _jspx_eval_bean_005fmessage_005f4 = _jspx_th_bean_005fmessage_005f4.doStartTag();
    if (_jspx_th_bean_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f4);
    return false;
  }

  private boolean _jspx_meth_bean_005fmessage_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f5 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_005fmessage_005f5.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fmessage_005f5.setParent(null);
    // /html/common/nav_sub_inc.jsp(585,20) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fmessage_005f5.setKey("enter-your-password");
    int _jspx_eval_bean_005fmessage_005f5 = _jspx_th_bean_005fmessage_005f5.doStartTag();
    if (_jspx_th_bean_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f5);
    return false;
  }

  private boolean _jspx_meth_bean_005fmessage_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f6 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_005fmessage_005f6.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fmessage_005f6.setParent(null);
    // /html/common/nav_sub_inc.jsp(588,107) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fmessage_005f6.setKey("login-as");
    int _jspx_eval_bean_005fmessage_005f6 = _jspx_th_bean_005fmessage_005f6.doStartTag();
    if (_jspx_th_bean_005fmessage_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f6);
    return false;
  }

  private boolean _jspx_meth_bean_005fmessage_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f7 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_005fmessage_005f7.setPageContext(_jspx_page_context);
    _jspx_th_bean_005fmessage_005f7.setParent(null);
    // /html/common/nav_sub_inc.jsp(589,113) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_bean_005fmessage_005f7.setKey("cancel");
    int _jspx_eval_bean_005fmessage_005f7 = _jspx_th_bean_005fmessage_005f7.doStartTag();
    if (_jspx_th_bean_005fmessage_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f7);
    return false;
  }
}
