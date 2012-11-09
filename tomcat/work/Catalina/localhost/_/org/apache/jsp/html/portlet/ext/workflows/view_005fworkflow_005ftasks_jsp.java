package org.apache.jsp.html.portlet.ext.workflows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dotmarketing.business.RoleAPI;
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
import java.util.List;
import com.dotmarketing.util.Config;
import java.util.*;
import com.dotmarketing.cms.factories.*;
import com.dotmarketing.util.UtilMethods;
import com.dotmarketing.portlets.workflows.struts.*;
import com.dotmarketing.portlets.workflows.model.*;
import javax.portlet.WindowState;
import com.dotmarketing.beans.WebAsset;
import java.util.ArrayList;
import com.dotmarketing.portlets.htmlpages.model.HTMLPage;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.portlets.files.model.File;
import com.dotmarketing.portlets.containers.model.Container;
import com.dotmarketing.portlets.links.model.Link;
import com.dotmarketing.portlets.templates.model.Template;
import com.dotmarketing.factories.InodeFactory;
import com.dotmarketing.portlets.structure.model.Structure;
import com.dotmarketing.portlets.structure.model.Field;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import com.dotmarketing.util.Parameter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.liferay.util.cal.CalendarUtil;
import java.util.Locale;
import java.text.SimpleDateFormat;
import com.dotmarketing.beans.WebAsset;
import com.dotmarketing.portlets.htmlpages.model.HTMLPage;
import com.dotmarketing.factories.InodeFactory;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.portlets.files.model.File;
import com.dotmarketing.portlets.templates.model.Template;
import com.dotmarketing.portlets.links.model.Link;
import com.dotmarketing.portlets.containers.model.Container;
import com.dotmarketing.portlets.structure.factories.StructureFactory;
import java.util.ArrayList;
import org.apache.commons.beanutils.PropertyUtils;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.PermissionAPI;
import com.liferay.portal.NoSuchRoleException;
import com.dotmarketing.business.Role;
import com.dotmarketing.portlets.workflows.business.WorkflowAPI;
import com.dotmarketing.util.WebKeys.WorkflowStatuses;
import com.dotmarketing.business.RoleAPI;
import com.dotmarketing.util.UtilMethods;
import com.liferay.portal.language.LanguageUtil;

public final class view_005fworkflow_005ftasks_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(9);
    _jspx_dependants.add("/html/portlet/ext/workflows/init.jsp");
    _jspx_dependants.add("/html/common/init.jsp");
    _jspx_dependants.add("/html/portlet/ext/workflows/workflows_js_inc.jsp");
    _jspx_dependants.add("/WEB-INF/tld/c-rt.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tld/liferay-portlet.tld");
    _jspx_dependants.add("/WEB-INF/tld/liferay-util.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-tiles.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fliferay_005fbox_0026_005ftop_005fbottom;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fliferay_005fparam_0026_005fvalue_005fname_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fliferay_005fbox_0026_005ftop_005fbottom = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fliferay_005fparam_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody.release();
    _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.release();
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fliferay_005fbox_0026_005ftop_005fbottom.release();
    _005fjspx_005ftagPool_005fliferay_005fparam_0026_005fvalue_005fname_005fnobody.release();
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

      out.write('\r');
      out.write('\n');
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
      //  portlet:defineObjects
      com.liferay.portlet.taglib.DefineObjectsTag _jspx_th_portlet_005fdefineObjects_005f0 = (com.liferay.portlet.taglib.DefineObjectsTag) _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody.get(com.liferay.portlet.taglib.DefineObjectsTag.class);
      _jspx_th_portlet_005fdefineObjects_005f0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005fdefineObjects_005f0.setParent(null);
      int _jspx_eval_portlet_005fdefineObjects_005f0 = _jspx_th_portlet_005fdefineObjects_005f0.doStartTag();
      if (_jspx_th_portlet_005fdefineObjects_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody.reuse(_jspx_th_portlet_005fdefineObjects_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody.reuse(_jspx_th_portlet_005fdefineObjects_005f0);
      javax.portlet.PortletConfig portletConfig = null;
      javax.portlet.RenderRequest renderRequest = null;
      javax.portlet.RenderResponse renderResponse = null;
      portletConfig = (javax.portlet.PortletConfig) _jspx_page_context.findAttribute("portletConfig");
      renderRequest = (javax.portlet.RenderRequest) _jspx_page_context.findAttribute("renderRequest");
      renderResponse = (javax.portlet.RenderResponse) _jspx_page_context.findAttribute("renderResponse");
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
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t@import \"/html/portlet/ext/workflows/schemes/workflow.css\"; \r\n");
      out.write("</style>\t\r\n");
      out.write("\r\n");


	WorkflowSearcher searcher = (WorkflowSearcher) session.getAttribute(com.dotmarketing.util.WebKeys.WORKFLOW_SEARCHER);
	if(searcher ==null){
		searcher = new WorkflowSearcher(request.getParameterMap(), user);
		
	}
	if(!searcher.isOpen() && ! searcher.isClosed()){
		searcher.setOpen(true);
	}


    boolean isAdministrator = APILocator.getRoleAPI().doesUserHaveRole(user, APILocator.getRoleAPI().loadCMSAdminRole())
                               || APILocator.getRoleAPI().doesUserHaveRole(user,RoleAPI.WORKFLOW_ADMIN_ROLE_KEY);
	List<Role> roles = APILocator.getRoleAPI().loadRolesForUser(user.getUserId());

    Role assignedTo  = APILocator.getRoleAPI().loadRoleById(searcher.getAssignedTo());
    if(assignedTo ==null){
    	assignedTo =new Role();
    }
    Role myRole  = APILocator.getRoleAPI().getUserRole(user);
    List<WorkflowScheme> schemes = APILocator.getWorkflowAPI().findSchemes(false);  
    

	Map myMap = new HashMap();
	
	myMap.put("struts_action", new String[] { "/ext/workflows/view_workflow_tasks" });
	
	String referer = com.dotmarketing.util.PortletURLUtil.getActionURL(request, WindowState.MAXIMIZED
		.toString(), myMap);

    

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("\tfunction publish (objId,assetId) {\r\n");
      out.write("\t\tif(confirm('");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "Are-you-sure-you-want-to-publish-this-Associated-Type")) );
      out.write("')){\t\r\n");
      out.write("\t\t\tvar href = '");
      //  portlet:actionURL
      com.liferay.portlet.taglib.ActionURLTag _jspx_th_portlet_005factionURL_005f0 = (com.liferay.portlet.taglib.ActionURLTag) _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.get(com.liferay.portlet.taglib.ActionURLTag.class);
      _jspx_th_portlet_005factionURL_005f0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005factionURL_005f0.setParent(null);
      // /html/portlet/ext/workflows/workflows_js_inc.jsp(7,15) name = windowState type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_portlet_005factionURL_005f0.setWindowState( WindowState.MAXIMIZED.toString() );
      int _jspx_eval_portlet_005factionURL_005f0 = _jspx_th_portlet_005factionURL_005f0.doStartTag();
      if (_jspx_eval_portlet_005factionURL_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_portlet_005factionURL_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_portlet_005factionURL_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_portlet_005factionURL_005f0.doInitBody();
        }
        do {
          out.write("'\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f0(_jspx_th_portlet_005factionURL_005f0, _jspx_page_context))
            return;
          out.write("'\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f1(_jspx_th_portlet_005factionURL_005f0, _jspx_page_context))
            return;
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          //  portlet:param
          com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f2 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
          _jspx_th_portlet_005fparam_005f2.setPageContext(_jspx_page_context);
          _jspx_th_portlet_005fparam_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f0);
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(10,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f2.setName("referer");
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(10,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f2.setValue( referer );
          int _jspx_eval_portlet_005fparam_005f2 = _jspx_th_portlet_005fparam_005f2.doStartTag();
          if (_jspx_th_portlet_005fparam_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f2);
            return;
          }
          _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f2);
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          int evalDoAfterBody = _jspx_th_portlet_005factionURL_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_portlet_005factionURL_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_portlet_005factionURL_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f0);
      out.write("&inode='+objId+'&asset_inode='+assetId;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tdocument.location.href = href;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\tfunction unpublish(objId,assetId) {\r\n");
      out.write("\t\tif(confirm('");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "Are-you-sure-you-want-to-un-publish-this-Associated-Type")) );
      out.write("')){\r\n");
      out.write("\t\t\tvar href = '");
      //  portlet:actionURL
      com.liferay.portlet.taglib.ActionURLTag _jspx_th_portlet_005factionURL_005f1 = (com.liferay.portlet.taglib.ActionURLTag) _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.get(com.liferay.portlet.taglib.ActionURLTag.class);
      _jspx_th_portlet_005factionURL_005f1.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005factionURL_005f1.setParent(null);
      // /html/portlet/ext/workflows/workflows_js_inc.jsp(19,15) name = windowState type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_portlet_005factionURL_005f1.setWindowState( WindowState.MAXIMIZED.toString() );
      int _jspx_eval_portlet_005factionURL_005f1 = _jspx_th_portlet_005factionURL_005f1.doStartTag();
      if (_jspx_eval_portlet_005factionURL_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_portlet_005factionURL_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_portlet_005factionURL_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_portlet_005factionURL_005f1.doInitBody();
        }
        do {
          out.write("'\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f3(_jspx_th_portlet_005factionURL_005f1, _jspx_page_context))
            return;
          out.write("'\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f4(_jspx_th_portlet_005factionURL_005f1, _jspx_page_context))
            return;
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          //  portlet:param
          com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f5 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
          _jspx_th_portlet_005fparam_005f5.setPageContext(_jspx_page_context);
          _jspx_th_portlet_005fparam_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f1);
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(22,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f5.setName("referer");
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(22,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f5.setValue( referer );
          int _jspx_eval_portlet_005fparam_005f5 = _jspx_th_portlet_005fparam_005f5.doStartTag();
          if (_jspx_th_portlet_005fparam_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f5);
            return;
          }
          _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f5);
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          int evalDoAfterBody = _jspx_th_portlet_005factionURL_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_portlet_005factionURL_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_portlet_005factionURL_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f1);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f1);
      out.write("&inode='+objId+'&asset_inode='+assetId;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tdocument.location.href = href;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\tfunction archive (objId, assetId) {\r\n");
      out.write("\t\tif(confirm('");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "Are-you-sure-you-want-to-archive-this-Associated-Type")) );
      out.write("')){\r\n");
      out.write("\t   \t\tvar href = '");
      //  portlet:actionURL
      com.liferay.portlet.taglib.ActionURLTag _jspx_th_portlet_005factionURL_005f2 = (com.liferay.portlet.taglib.ActionURLTag) _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.get(com.liferay.portlet.taglib.ActionURLTag.class);
      _jspx_th_portlet_005factionURL_005f2.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005factionURL_005f2.setParent(null);
      // /html/portlet/ext/workflows/workflows_js_inc.jsp(32,18) name = windowState type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_portlet_005factionURL_005f2.setWindowState( WindowState.MAXIMIZED.toString() );
      int _jspx_eval_portlet_005factionURL_005f2 = _jspx_th_portlet_005factionURL_005f2.doStartTag();
      if (_jspx_eval_portlet_005factionURL_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_portlet_005factionURL_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_portlet_005factionURL_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_portlet_005factionURL_005f2.doInitBody();
        }
        do {
          out.write("'\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f6(_jspx_th_portlet_005factionURL_005f2, _jspx_page_context))
            return;
          out.write("'\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f7(_jspx_th_portlet_005factionURL_005f2, _jspx_page_context))
            return;
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          //  portlet:param
          com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f8 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
          _jspx_th_portlet_005fparam_005f8.setPageContext(_jspx_page_context);
          _jspx_th_portlet_005fparam_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f2);
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(35,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f8.setName("referer");
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(35,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f8.setValue( referer );
          int _jspx_eval_portlet_005fparam_005f8 = _jspx_th_portlet_005fparam_005f8.doStartTag();
          if (_jspx_th_portlet_005fparam_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f8);
            return;
          }
          _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f8);
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          int evalDoAfterBody = _jspx_th_portlet_005factionURL_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_portlet_005factionURL_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_portlet_005factionURL_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f2);
      out.write("&inode='+objId+'&asset_inode='+assetId;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tdocument.location.href = href;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction unarchive (objId, assetId) {\r\n");
      out.write("\t\tif(confirm('");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "Are-you-sure-you-want-to-un-archive-this-Associated-Type")) );
      out.write("')){\r\n");
      out.write("\t\t\tvar href = '");
      //  portlet:actionURL
      com.liferay.portlet.taglib.ActionURLTag _jspx_th_portlet_005factionURL_005f3 = (com.liferay.portlet.taglib.ActionURLTag) _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.get(com.liferay.portlet.taglib.ActionURLTag.class);
      _jspx_th_portlet_005factionURL_005f3.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005factionURL_005f3.setParent(null);
      // /html/portlet/ext/workflows/workflows_js_inc.jsp(45,15) name = windowState type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_portlet_005factionURL_005f3.setWindowState( WindowState.MAXIMIZED.toString() );
      int _jspx_eval_portlet_005factionURL_005f3 = _jspx_th_portlet_005factionURL_005f3.doStartTag();
      if (_jspx_eval_portlet_005factionURL_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_portlet_005factionURL_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_portlet_005factionURL_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_portlet_005factionURL_005f3.doInitBody();
        }
        do {
          out.write("'\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f9(_jspx_th_portlet_005factionURL_005f3, _jspx_page_context))
            return;
          out.write("'\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f10(_jspx_th_portlet_005factionURL_005f3, _jspx_page_context))
            return;
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          //  portlet:param
          com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f11 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
          _jspx_th_portlet_005fparam_005f11.setPageContext(_jspx_page_context);
          _jspx_th_portlet_005fparam_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f3);
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(48,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f11.setName("referer");
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(48,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f11.setValue( referer );
          int _jspx_eval_portlet_005fparam_005f11 = _jspx_th_portlet_005fparam_005f11.doStartTag();
          if (_jspx_th_portlet_005fparam_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f11);
            return;
          }
          _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f11);
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          int evalDoAfterBody = _jspx_th_portlet_005factionURL_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_portlet_005factionURL_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_portlet_005factionURL_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f3);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f3);
      out.write("&inode='+objId+'&asset_inode='+assetId;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tdocument.location.href = href;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction previewHTMLPage (objId, referer) {\r\n");
      out.write("\t\ttop.location='");
      //  portlet:actionURL
      com.liferay.portlet.taglib.ActionURLTag _jspx_th_portlet_005factionURL_005f4 = (com.liferay.portlet.taglib.ActionURLTag) _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.get(com.liferay.portlet.taglib.ActionURLTag.class);
      _jspx_th_portlet_005factionURL_005f4.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005factionURL_005f4.setParent(null);
      // /html/portlet/ext/workflows/workflows_js_inc.jsp(56,16) name = windowState type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_portlet_005factionURL_005f4.setWindowState( WindowState.MAXIMIZED.toString() );
      int _jspx_eval_portlet_005factionURL_005f4 = _jspx_th_portlet_005factionURL_005f4.doStartTag();
      if (_jspx_eval_portlet_005factionURL_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_portlet_005factionURL_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_portlet_005factionURL_005f4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_portlet_005factionURL_005f4.doInitBody();
        }
        do {
          if (_jspx_meth_portlet_005fparam_005f12(_jspx_th_portlet_005factionURL_005f4, _jspx_page_context))
            return;
          if (_jspx_meth_portlet_005fparam_005f13(_jspx_th_portlet_005factionURL_005f4, _jspx_page_context))
            return;
          int evalDoAfterBody = _jspx_th_portlet_005factionURL_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_portlet_005factionURL_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_portlet_005factionURL_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f4);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f4);
      out.write("&inode=' + objId + '&referer=' + referer;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction deleteWorkFlowTask(inode) {\r\n");
      out.write("\t");

		java.util.Map viewParams = new java.util.HashMap();
		viewParams.put("struts_action",new String[] {"/ext/workflows/view_workflow_tasks"});
		String viewReferer = com.dotmarketing.util.PortletURLUtil.getRenderURL(request,WindowState.MAXIMIZED.toString(),viewParams);
	
      out.write("\r\n");
      out.write("\t  if(confirm('");
      out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "Are-you-sure-you-want-to-delete-this-workflow-task")) );
      out.write("')){\r\n");
      out.write("\t\t\tvar href= '");
      //  portlet:actionURL
      com.liferay.portlet.taglib.ActionURLTag _jspx_th_portlet_005factionURL_005f5 = (com.liferay.portlet.taglib.ActionURLTag) _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.get(com.liferay.portlet.taglib.ActionURLTag.class);
      _jspx_th_portlet_005factionURL_005f5.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005factionURL_005f5.setParent(null);
      // /html/portlet/ext/workflows/workflows_js_inc.jsp(66,14) name = windowState type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_portlet_005factionURL_005f5.setWindowState( WindowState.MAXIMIZED.toString() );
      int _jspx_eval_portlet_005factionURL_005f5 = _jspx_th_portlet_005factionURL_005f5.doStartTag();
      if (_jspx_eval_portlet_005factionURL_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_portlet_005factionURL_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_portlet_005factionURL_005f5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_portlet_005factionURL_005f5.doInitBody();
        }
        do {
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f14(_jspx_th_portlet_005factionURL_005f5, _jspx_page_context))
            return;
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          if (_jspx_meth_portlet_005fparam_005f15(_jspx_th_portlet_005factionURL_005f5, _jspx_page_context))
            return;
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          //  portlet:param
          com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f16 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
          _jspx_th_portlet_005fparam_005f16.setPageContext(_jspx_page_context);
          _jspx_th_portlet_005fparam_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f5);
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(69,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f16.setName("referer");
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(69,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f16.setValue( viewReferer );
          int _jspx_eval_portlet_005fparam_005f16 = _jspx_th_portlet_005fparam_005f16.doStartTag();
          if (_jspx_th_portlet_005fparam_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f16);
            return;
          }
          _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f16);
          out.write("';\r\n");
          out.write("\t\t\thref = href + '");
          int evalDoAfterBody = _jspx_th_portlet_005factionURL_005f5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_portlet_005factionURL_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_portlet_005factionURL_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f5);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f5);
      out.write("&inode='+inode;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdocument.location.href = href;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t//Layout Initialization\r\n");
      out.write("\tvar browserLoaded = false;\r\n");
      out.write("\t\r\n");
      out.write("\tfunction  resizeBrowser(){\r\n");
      out.write("\t\tif(browserLoaded) return;\r\n");
      out.write("\t\tbrowserLoaded=true;\r\n");
      out.write("\t    var viewport = dijit.getViewport();\r\n");
      out.write("\t    var viewport_height = viewport.h;\r\n");
      out.write("\t    var e =  dojo.byId(\"borderContainer\");\r\n");
      out.write("\t    dojo.style(e, \"height\", viewport_height -150 + \"px\");\r\n");
      out.write("\t    var bc = dijit.byId('borderContainer');\r\n");
      out.write("\t    if(bc != undefined){\r\n");
      out.write("\t    \tbc.resize();\r\n");
      out.write("\t    }\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdojo.connect(window, \"onresize\", this, \"resizeBrowser\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t    dojo.declare(\"dotcms.dijit.contentlet.ContentAdmin\", null, {\r\n");
      out.write("\t    \tcontentletIdentifier : \"\",\r\n");
      out.write("\t    \tcontentletInode : \"\",\r\n");
      out.write("\t    \tlanguageID : \"\",\r\n");
      out.write("\t    \twfActionId:\"\",\r\n");
      out.write("\t    \tconstructor : function(contentletIdentifier, contentletInode,languageId ) {\r\n");
      out.write("\t    \t\tthis.contentletIdentifier = contentletIdentifier;\r\n");
      out.write("\t    \t\tthis.contentletInode =contentletInode;\r\n");
      out.write("\t    \t\tthis.languageId=languageId;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t    \t},\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \texecuteWfAction: function(wfId, assignable, commentable, inode){\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t\tthis.wfActionId=wfId;\r\n");
      out.write("\r\n");
      out.write("\t    \t\tif(assignable || commentable){\r\n");
      out.write("\t    \t\t\t\r\n");
      out.write("\t    \t\t\tvar myCp = dijit.byId(\"contentletWfCP\");\r\n");
      out.write("\t    \t\t\tif(myCp){\r\n");
      out.write("\t    \t\t\t\tmyCp.destroyRecursive();\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t\tvar dia = dijit.byId(\"contentletWfDialog\");\r\n");
      out.write("\t    \t\t\tif(dia){\r\n");
      out.write("\t    \t\t\t\tdia.destroyRecursive();\r\n");
      out.write("\t    \t\t\t\t\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t\tdia = new dijit.Dialog({\r\n");
      out.write("\t    \t\t\t\tid\t\t\t:\t\"contentletWfDialog\",\r\n");
      out.write("\t    \t\t\t\ttitle\t\t: \t\"");
      out.print(LanguageUtil.get(pageContext, "Workflow-Actions"));
      out.write("\",\r\n");
      out.write("\t\t\t\t\t\tstyle\t\t:\t\"min-width:500px;min-height:300px;\"\r\n");
      out.write("\t    \t\t\t\t});\r\n");
      out.write("\t    \t\t\t\r\n");
      out.write("\r\n");
      out.write("\t    \t\t\tmyCp = new dojox.layout.ContentPane({\r\n");
      out.write("\t    \t\t\t\tid \t\t\t: \"contentletWfCP\",\r\n");
      out.write("\t    \t\t\t\tstyle\t\t: \"min-width:500px;min-height:300px;margin:auto;\"\r\n");
      out.write("\t    \t\t\t}).placeAt(\"contentletWfDialog\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t    \t\t\tdia.show();\r\n");
      out.write("\t    \t\t\tmyCp.attr(\"href\", \"/DotAjaxDirector/com.dotmarketing.portlets.workflows.ajax.WfTaskAjax?cmd=renderAction&actionId=\" + wfId + \"&inode=\" + inode);\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\telse{\r\n");
      out.write("\t    \t\t\tdojo.byId(\"wfActionId\").value=this.wfActionId;\r\n");
      out.write("\r\n");
      out.write("\t    \t\t\tthis.executeWorkflow();\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t},\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \tsaveAssign : function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t\tvar assignRole = (dijit.byId(\"taskAssignmentAux\")) \r\n");
      out.write("\t    \t\t\t? dijit.byId(\"taskAssignmentAux\").getValue()\r\n");
      out.write("\t    \t\t\t\t: (dojo.byId(\"taskAssignmentAux\")) \r\n");
      out.write("\t    \t\t\t\t\t? dojo.byId(\"taskAssignmentAux\").value\r\n");
      out.write("\t    \t\t\t\t\t\t\t: \"\";\r\n");
      out.write("\r\n");
      out.write("\t    \t\tif(!assignRole || assignRole.length ==0 ){\r\n");
      out.write("\t    \t\t\tshowDotCMSSystemMessage(\"");
      out.print(LanguageUtil.get(pageContext, "Assign-To-Required"));
      out.write("\");\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\r\n");
      out.write("\t    \t\tvar comments = (dijit.byId(\"taskCommentsAux\")) \r\n");
      out.write("\t    \t\t\t? dijit.byId(\"taskCommentsAux\").getValue()\r\n");
      out.write("\t    \t\t\t\t: (dojo.byId(\"taskCommentsAux\")) \r\n");
      out.write("\t    \t\t\t\t\t? dojo.byId(\"taskCommentsAux\").value\r\n");
      out.write("\t    \t\t\t\t\t\t\t: \"\";\r\n");
      out.write("\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t\tdojo.byId(\"wfActionAssign\").value=assignRole;\r\n");
      out.write("    \t\t\tdojo.byId(\"wfActionComments\").value=comments;\r\n");
      out.write("\t    \t\tdojo.byId(\"wfActionId\").value=this.wfActionId;\r\n");
      out.write("\t    \t\tdijit.byId(\"contentletWfDialog\").hide();\r\n");
      out.write("\t    \t\tthis.executeWorkflow();\r\n");
      out.write("\t    \t},\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \texecuteWorkflow : function (){\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t\tdijit.byId('savingContentDialog').show();\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar xhrArgs = {\r\n");
      out.write("\t\t\t\t\tform: dojo.byId(\"submitWorkflowTaskFrm\"),\r\n");
      out.write("\t\t\t\t\thandleAs: \"text\",\r\n");
      out.write("\t\t\t\t\tload: function(data) {\r\n");
      out.write("\t\t\t\t\t\tshowDotCMSSystemMessage(\"");
      out.print(LanguageUtil.get(pageContext, "Workflow-executed"));
      out.write("\");\r\n");
      out.write("\t\t\t\t\t\twindow.location='");
      //  portlet:actionURL
      com.liferay.portlet.taglib.ActionURLTag _jspx_th_portlet_005factionURL_005f6 = (com.liferay.portlet.taglib.ActionURLTag) _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.get(com.liferay.portlet.taglib.ActionURLTag.class);
      _jspx_th_portlet_005factionURL_005f6.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005factionURL_005f6.setParent(null);
      // /html/portlet/ext/workflows/workflows_js_inc.jsp(191,23) name = windowState type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_portlet_005factionURL_005f6.setWindowState( WindowState.MAXIMIZED.toString() );
      int _jspx_eval_portlet_005factionURL_005f6 = _jspx_th_portlet_005factionURL_005f6.doStartTag();
      if (_jspx_eval_portlet_005factionURL_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_portlet_005factionURL_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_portlet_005factionURL_005f6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_portlet_005factionURL_005f6.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_portlet_005fparam_005f17(_jspx_th_portlet_005factionURL_005f6, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          //  portlet:param
          com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f18 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
          _jspx_th_portlet_005fparam_005f18.setPageContext(_jspx_page_context);
          _jspx_th_portlet_005fparam_005f18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f6);
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(193,6) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f18.setName("referer");
          // /html/portlet/ext/workflows/workflows_js_inc.jsp(193,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_portlet_005fparam_005f18.setValue( referer );
          int _jspx_eval_portlet_005fparam_005f18 = _jspx_th_portlet_005fparam_005f18.doStartTag();
          if (_jspx_th_portlet_005fparam_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f18);
            return;
          }
          _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f18);
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_portlet_005factionURL_005f6.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_portlet_005factionURL_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_portlet_005factionURL_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f6);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f6);
      out.write("';\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror: function(error) {\r\n");
      out.write("\t\t\t\t\t\tshowDotCMSSystemMessage(error);\r\n");
      out.write("\t\t\t\t\t\tdijit.byId('savingContentDialog').hide();\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tdojo.xhrPost(xhrArgs);\r\n");
      out.write("\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t}\r\n");
      out.write("\r\n");
      out.write("\t    });\r\n");
      out.write("\t    var contentAdmin = new dotcms.dijit.contentlet.ContentAdmin();\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\t\r\n");
      out.write("\tdojo.require(\"dijit.form.FilteringSelect\");\r\n");
      out.write("\tdojo.require(\"dotcms.dojo.data.RoleReadStore\");\r\n");
      out.write("\tdojo.require(\"dotcms.dojo.data.RoleReadStore\");\r\n");
      out.write("\tdojo.require(\"dojox.layout.ContentPane\");\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doFilter () {\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar url=\"\";\r\n");
      out.write("\r\n");
      out.write("\t\tif(!dijit.byId(\"showOpen\").checked && !dijit.byId(\"showClosed\").checked){\r\n");
      out.write("\t\t\tdijit.byId(\"showOpen\").setValue(true) ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tvar container = dojo.byId(\"filterTasksFrm\");\r\n");
      out.write("\t\tvar widgets = dojo.query(\"[widgetId]\", container).map(dijit.byNode);\r\n");
      out.write("\t\tdojo.forEach(widgets, function(inputElem){ \r\n");
      out.write("\t\t\tif(\"checkbox\" == inputElem.type){\r\n");
      out.write("\t\t\t\turl = url + \"&\" + inputElem.name +\"=\" +inputElem.checked ; \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\turl = url + \"&\" + inputElem.name +\"=\" +inputElem.value ; \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
if(isAdministrator) {
      out.write("\r\n");
      out.write("\t\t     if(show4All) {\r\n");
      out.write("\t\t    \t url = url + \"&show4all=true\";\r\n");
      out.write("\t\t     }\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\trefreshTaskList(url);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\tvar lastUrlParams ;\r\n");
      out.write("\t\r\n");
      out.write("\tfunction refreshTaskList(urlParams){\r\n");
      out.write("\t\tlastUrlParams = urlParams;\r\n");
      out.write("\t\tvar r = Math.floor(Math.random() * 1000000000);\r\n");
      out.write("\t\tvar url = \"/html/portlet/ext/workflows/view_tasks_list.jsp?r=\" + r + urlParams;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar myCp = dijit.byId(\"workflowTaskListCp\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (myCp) {\r\n");
      out.write("\t\t\tdojo.attr(myCp,\"content\",\"\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tmyCp = new dojox.layout.ContentPane({\r\n");
      out.write("\t\t\t\tid : \"workflowTaskListCp\"\r\n");
      out.write("\t\t\t}).placeAt(\"hangTaskListHere\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\tmyCp.attr(\"href\", url);\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doOrderBy (newOrder) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdojo.byId(\"orderBy\").value= newOrder;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar newURL = \"\";\r\n");
      out.write("\t\t\tvar x  =lastUrlParams.split(\"&\");\r\n");
      out.write("\t\t\tfor(i =0;i<x.length;i++){\r\n");
      out.write("\t\t\t\tif(x[i].indexOf(\"orderBy\")<0){\r\n");
      out.write("\t\t\t\t\tnewURL+=\"&\" + x[i];\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tnewURL+=\"&orderBy=\" +newOrder;\r\n");
      out.write("\r\n");
      out.write("\t\t\trefreshTaskList(newURL);\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar stepStore = new dojo.data.ItemFileReadStore({url:\"/DotAjaxDirector/com.dotmarketing.portlets.workflows.ajax.WfStepAjax?cmd=listByScheme\"});\r\n");
      out.write("\tvar assignedToStore = new dotcms.dojo.data.RoleReadStore({nodeId: \"assignedTo\", jsId:\"assignedToStore\"});\r\n");
      out.write("\tvar emptyData = { \"identifier\" : \"id\", \"label\" : \"name\", \"items\": [{ name: '',id: '' }] };\r\n");
      out.write("\tvar emptyStore = new dojo.data.ItemFileReadStore({data:emptyData});\r\n");
      out.write("\tvar daysData= { \"identifier\" : \"d\", \"label\" : \"days\", \"items\":\r\n");
      out.write("\t\t[{d:1},{d:2},{d:5},{d:10},{d:15},{d:20},{d:30},{d:40},{d:50},{d:60}]};\r\n");
      out.write("\tvar daysOldStore = new dojo.data.ItemFileReadStore({data:daysData});\r\n");
      out.write("\t\r\n");
      out.write("\tdojo.ready(function(){\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
if(isAdministrator){
      out.write("\r\n");
      out.write("\t\tvar assignedTo = new dijit.form.FilteringSelect({\r\n");
      out.write("\t\t    id: \"assignedTo\",\r\n");
      out.write("\t\t    name: \"assignedTo\",\r\n");
      out.write("\t\t    store: assignedToStore,\r\n");
      out.write("\t\t    searchDelay:300,\r\n");
      out.write("\t\t    pageSize:20,\r\n");
      out.write("\t\t    required:false,\r\n");
      out.write("\t\t    value:\"");
      out.print(assignedTo.getId());
      out.write("\",\r\n");
      out.write("\t\t    onClick:function(){\r\n");
      out.write("\t\t    \tdijit.byId(\"assignedTo\").displayedValue=\"\";\r\n");
      out.write("\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    onChange:doFilter\r\n");
      out.write("\t\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t},\r\n");
      out.write("\t\t\"assignedTo\");\r\n");
      out.write("\t\tdoFilter();\r\n");
      out.write("\t");
}
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar stepId = new dijit.form.FilteringSelect({\r\n");
      out.write("\t\t    id: \"stepId\",\r\n");
      out.write("\t\t    name: \"stepId\",\r\n");
      out.write("\t\t    store: stepStore,\r\n");
      out.write("\t\t    searchDelay:300,\r\n");
      out.write("\t\t    pageSize:20,\r\n");
      out.write("\t\t    required:false,\r\n");
      out.write("\t\t    onClick:function(){\r\n");
      out.write("\t\t    \tdijit.byId(\"stepId\").displayedValue=\"\";\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\t\"stepId\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar olderThanCombo = new dijit.form.ComboBox({\r\n");
      out.write("\t        id:\"daysold\",\r\n");
      out.write("\t        name:\"daysold\",\r\n");
      out.write("\t        store:daysOldStore,\r\n");
      out.write("\t        required:false,\r\n");
      out.write("\t        value:\"\",\r\n");
      out.write("\t        searchAttr:\"d\"\r\n");
      out.write("\t    },\"daysold\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdoFilter();\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tvar emptyData = {\"identifier\" : \"id\",\"label\" : \"name\",\"items\": [{ name: '', id: ''}]};\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("          \r\n");
      out.write("            \r\n");
      out.write("\tfunction updateSteps(){\r\n");
      out.write("\t\tvar schemeId = dijit.byId(\"schemeId\").value;\r\n");
      out.write("\t\tvar myUrl = \"/DotAjaxDirector/com.dotmarketing.portlets.workflows.ajax.WfStepAjax?cmd=listByScheme&schemeId=\" + schemeId;\r\n");
      out.write("\t\tdijit.byId(\"stepId\").attr('value','');\r\n");
      out.write("\t\tdijit.byId(\"stepId\").set('store',new dojo.data.ItemFileReadStore({url:myUrl}));\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction assignedToMe(){\r\n");
      out.write("\t\t");
if(isAdministrator){
      out.write("\r\n");
      out.write("             disable4AllUsers();\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar assignedTo = dijit.byId(\"assignedTo\");\r\n");
      out.write("\t\tassignedTo.displayedValue=\"\";\r\n");
      out.write("\t\tassignedTo.setValue(\"");
      out.print(myRole.getId());
      out.write("\");\r\n");
      out.write("\t}\r\n");
      out.write("\t");
if(isAdministrator){
      out.write("\r\n");
      out.write("\t    var show4All=false;\r\n");
      out.write("\t\tfunction showTasks4AllUsers() {\r\n");
      out.write("\t\t\tif(show4All) {\r\n");
      out.write("\t\t\t\tdisable4AllUsers();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse {\r\n");
      out.write("\t\t\t\tvar assignedTo = dijit.byId(\"assignedTo\");\r\n");
      out.write("\t\t        assignedTo.displayedValue=\"\";\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        assignedTo.attr(\"disabled\",\"true\");\r\n");
      out.write("\t\t        dojo.style(dojo.byId(\"showAllLink\"),\"fontWeight\",\"bold\");\r\n");
      out.write("\t\t        show4All=true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tdoFilter();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction disable4AllUsers() {\r\n");
      out.write("\t\t\tshow4All=false;\r\n");
      out.write("\t\t\tvar assignedTo = dijit.byId(\"assignedTo\");\r\n");
      out.write("\t\t\tassignedTo.attr(\"disabled\",false);\r\n");
      out.write("\t\t\tdojo.style(dojo.byId(\"showAllLink\"),\"fontWeight\",\"normal\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t");
}
      out.write("\r\n");
      out.write("\tfunction resetFilters(){\r\n");
      out.write("\t\tdijit.byId(\"daysold\").setValue(\"\");\t\r\n");
      out.write("\t\tvar stepId = dijit.byId(\"stepId\");\r\n");
      out.write("\t\tstepId.store= emptyStore;\r\n");
      out.write("\t\tstepId.displayedValue=\"\";\r\n");
      out.write("\t\tvar assignedTo = dijit.byId(\"assignedTo\");\r\n");
      out.write("\t\tassignedTo.store= emptyStore;\r\n");
      out.write("\t\tassignedTo.displayedValue=\"\";\r\n");
      out.write("\t\tassignedTo.store=assignedToStore;\r\n");
      out.write("\t\t");
if(isAdministrator){
      out.write("\r\n");
      out.write("\t\t     disable4AllUsers();\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t\tvar schemeId = dijit.byId(\"schemeId\");\r\n");
      out.write("\r\n");
      out.write("\t\tschemeId.setValue(\"\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdijit.byId(\"keywords\").setValue(\"\");\r\n");
      out.write("\t\tdijit.byId(\"showOpen\").setValue(true);\r\n");
      out.write("\t\tdijit.byId(\"showClosed\").setValue(false);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdoFilter();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction editTask(id){\r\n");
      out.write("\t\tvar url = \"");
      if (_jspx_meth_portlet_005factionURL_005f7(_jspx_page_context))
        return;
      out.write("\";\r\n");
      out.write("\t\turl = url.replace(\"REPLACEME\", id);\r\n");
      out.write("\t\twindow.location=url;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdojo.ready(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\tupdateSteps();\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction checkAll(){\r\n");
      out.write("\t\tvar x = dijit.byId(\"checkAllCkBx\").checked;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdojo.query(\".taskCheckBox\").forEach(function(node){\r\n");
      out.write("\t\t\tdijit.byNode(node).setValue(x);\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction excuteWorkflowAction(){\r\n");
      out.write("\t\tvar actionId = dijit.byId(\"performAction\").getValue();\r\n");
      out.write("\r\n");
      out.write("\t\tif(! actionId || actionId.length <1){\r\n");
      out.write("\t\t\tshowDotCMSSystemMessage(\"");
      out.print(LanguageUtil.get(pageContext, "Please-select-an-action"));
      out.write("\", true);\r\n");
      out.write("\t\t\treturn;\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdojo.byId(\"wfActionId\").value =actionId;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar hasChecks = false;\r\n");
      out.write("\t\tvar cons =\"\";\r\n");
      out.write("\t\tdojo.query(\".taskCheckBox\").forEach(function(node){\r\n");
      out.write("\t\t\tvar check = dijit.byNode(node);\r\n");
      out.write("\t\t\tif(check.getValue()){\r\n");
      out.write("\t\t\t\tcons = cons +  check.id + \",\";\r\n");
      out.write("\t\t\t\thasChecks=true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!hasChecks){\r\n");
      out.write("\t\t\tshowDotCMSSystemMessage(\"");
      out.print(LanguageUtil.get(pageContext, "Please-select-a-task"));
      out.write("\", true);\r\n");
      out.write("\t\t\treturn;\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdojo.byId(\"wfCons\").value=cons;\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\tactionStore.fetch({query: {id:actionId}, onComplete:function(item){\r\n");
      out.write("\t\t\tif(item[0].assignable ==\"true\" || item[0].commentable == \"true\"){\r\n");
      out.write("\t\t\t\tvar dia = dijit.byId(\"contentletWfDialog\");\r\n");
      out.write("    \t\t\tif(dia){\r\n");
      out.write("    \t\t\t\tdia.destroyRecursive();\r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\tdia = new dijit.Dialog({\r\n");
      out.write("    \t\t\t\tid\t\t\t:\t\"contentletWfDialog\",\r\n");
      out.write("    \t\t\t\ttitle\t\t: \t\"");
      out.print(LanguageUtil.get(pageContext, "Workflow-Actions"));
      out.write("\"\r\n");
      out.write("    \t\t\t\t});\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\t\r\n");
      out.write("  \t\t\t\tvar myCp = dijit.byId(\"contentletWfCP\");\r\n");
      out.write("    \t\t\tif(myCp){\r\n");
      out.write("    \t\t\t\tmyCp.destroyRecursive();\r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\tmyCp = new dojox.layout.ContentPane({\r\n");
      out.write("    \t\t\t\tid \t\t\t: \"contentletWfCP\"\r\n");
      out.write("    \t\t\t}).placeAt(\"contentletWfDialog\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("    \t\t\tdia.show();\r\n");
      out.write("    \t\t\tmyCp.attr(\"href\", \"/DotAjaxDirector/com.dotmarketing.portlets.workflows.ajax.WfTaskAjax?cmd=renderAction&actionId=\" + actionId);\r\n");
      out.write("    \t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\tcontentAdmin.saveAssign();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar contentAdmin = {\r\n");
      out.write("\t\tsaveAssign:function(){\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(dojo.byId(\"taskAssignmentAux\")){\r\n");
      out.write("\t\t\t\tdojo.byId(\"wfActionAssign\").value=dijit.byId('taskAssignmentAux').getValue();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(dojo.byId(\"taskCommentsAux\")){\r\n");
      out.write("\t\t\t\tdojo.byId(\"wfActionComments\").value=dijit.byId('taskCommentsAux').getValue();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(dojo.byId(\"contentletWfDialog\")){\r\n");
      out.write("\t\t\t\tdijit.byId(\"contentletWfDialog\").hide();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tdojo.xhrPost({\r\n");
      out.write("\t\t\t\tform : \"executeTasksFrm\",\r\n");
      out.write("\t\t\t\ttimeout : 30000,\r\n");
      out.write("\t\t\t\thandle : function(dataOrError, ioArgs) {\r\n");
      out.write("\t\t\t\t\tif (dojo.isString(dataOrError)) {\r\n");
      out.write("\t\t\t\t\t\tif (dataOrError.indexOf(\"FAILURE\") == 0) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tshowDotCMSSystemMessage(dataOrError, true);\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tshowDotCMSSystemMessage(\"");
      out.print(LanguageUtil.get(pageContext, "Saved"));
      out.write("\");\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tthis.saveError(\"");
      out.print(LanguageUtil.get(pageContext, "Unable-to-excute-workflows"));
      out.write("\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tdoFilter();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      //  liferay:box
      com.liferay.taglib.BoxTag _jspx_th_liferay_005fbox_005f0 = (com.liferay.taglib.BoxTag) _005fjspx_005ftagPool_005fliferay_005fbox_0026_005ftop_005fbottom.get(com.liferay.taglib.BoxTag.class);
      _jspx_th_liferay_005fbox_005f0.setPageContext(_jspx_page_context);
      _jspx_th_liferay_005fbox_005f0.setParent(null);
      // /html/portlet/ext/workflows/view_workflow_tasks.jsp(437,0) name = top type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_liferay_005fbox_005f0.setTop("/html/common/box_top.jsp");
      // /html/portlet/ext/workflows/view_workflow_tasks.jsp(437,0) name = bottom type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_liferay_005fbox_005f0.setBottom("/html/common/box_bottom.jsp");
      int _jspx_eval_liferay_005fbox_005f0 = _jspx_th_liferay_005fbox_005f0.doStartTag();
      if (_jspx_eval_liferay_005fbox_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_liferay_005fbox_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_liferay_005fbox_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_liferay_005fbox_005f0.doInitBody();
        }
        do {
          out.write('\r');
          out.write('\n');
          //  liferay:param
          com.liferay.taglib.ParamTag _jspx_th_liferay_005fparam_005f0 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fliferay_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
          _jspx_th_liferay_005fparam_005f0.setPageContext(_jspx_page_context);
          _jspx_th_liferay_005fparam_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay_005fbox_005f0);
          // /html/portlet/ext/workflows/view_workflow_tasks.jsp(439,0) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_liferay_005fparam_005f0.setName("box_title");
          // /html/portlet/ext/workflows/view_workflow_tasks.jsp(439,0) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_liferay_005fparam_005f0.setValue( LanguageUtil.get(pageContext, "Filtered-Tasks") );
          int _jspx_eval_liferay_005fparam_005f0 = _jspx_th_liferay_005fparam_005f0.doStartTag();
          if (_jspx_th_liferay_005fparam_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fliferay_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_liferay_005fparam_005f0);
            return;
          }
          _005fjspx_005ftagPool_005fliferay_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_liferay_005fparam_005f0);
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<!-- START Button Row -->\r\n");
          out.write("\t<div class=\"buttonBoxLeft\"><h3>");
          out.print(LanguageUtil.get(pageContext, "javax.portlet.title.EXT_21"));
          out.write("</h3></div>\r\n");
          out.write("\r\n");
          out.write("<!-- END Button Row -->\r\n");
          out.write("\r\n");
          out.write("<!-- START Split Box -->\r\n");
          out.write("<div dojoType=\"dijit.layout.BorderContainer\" design=\"sidebar\" gutters=\"false\" liveSplitters=\"true\" id=\"borderContainer\" class=\"shadowBox headerBox\" style=\"height:100px;\">\r\n");
          out.write("\t\t\r\n");
          out.write("<!-- START Left Column -->\t\r\n");
          out.write("\t<div dojoType=\"dijit.layout.ContentPane\" splitter=\"false\" region=\"leading\" style=\"width: 350px;\" class=\"lineRight\">\r\n");
          out.write("\t\t<div style=\"margin-top:48px;\">\r\n");
          out.write("\t\t\t<div  id=\"filterTasksFrm\">\r\n");
          out.write("\t\t\t\t<input type=\"hidden\" name=\"cmd\" value=\"filterTasks\">\r\n");
          out.write("\t\t\t\t<input type=\"hidden\" name=\"orderBy\" id=\"orderBy\" value=\"mod_date desc\">\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<dl>\r\n");
          out.write("\t\t\t\t\t<dt>");
          out.print(LanguageUtil.get(pageContext, "Keywords"));
          out.write(":</dt>\r\n");
          out.write("\t\t\t\t\t<dd><input type=\"text\" dojoType=\"dijit.form.TextBox\" name=\"keywords\" id=\"keywords\" value=\"");
          out.print(UtilMethods.webifyString(searcher.getKeywords()));
          out.write("\" /></dd>\r\n");
          out.write("\t\t\t\t\t<dt>");
          out.print(LanguageUtil.get(pageContext, "Assigned-To"));
          out.write(":</dt>\r\n");
          out.write("\t\t\t\t\t<dd>\t\r\n");
          out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"assignedTo\" name=\"assignedTo\" value=\"");
          out.print(myRole.getId() );
          out.write("\" />\r\n");
          out.write("\t\t\t\t\t\t");
if(isAdministrator) { 
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<a id=\"showAllLink\" href=\"#\" onclick=\"showTasks4AllUsers()\">");
          out.print(LanguageUtil.get(pageContext, "all") );
          out.write("</a>\r\n");
          out.write("                        ");
} 
          out.write("\r\n");
          out.write("\t\t\t\t        <a href=\"#\" onclick=\"assignedToMe()\">");
          out.print(LanguageUtil.get(pageContext, "me") );
          out.write("</a> \r\n");
          out.write("\t\t\t\t\t</dd>\r\n");
          out.write("\t\t\t\t\t<dt>");
          out.print(LanguageUtil.get(pageContext, "Older-than (days)") );
          out.write("</dt>\r\n");
          out.write("\t\t\t\t\t<dd>\r\n");
          out.write("\t\t\t\t\t   <input type=\"text\" id=\"daysold\" name=\"daysold\"/>\r\n");
          out.write("\t\t\t\t\t</dd>\r\n");
          out.write("\t\t\t\t\t<dt>");
          out.print(LanguageUtil.get(pageContext, "Scheme"));
          out.write(":</dt>\r\n");
          out.write("\t\t\t\t\t<dd>\r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t<select name=\"schemeId\" id=\"schemeId\" dojoType=\"dijit.form.FilteringSelect\" value=\"");
          out.print(UtilMethods.webifyString(searcher.getSchemeId()));
          out.write("\" onChange=\"updateSteps();doFilter();\">\r\n");
          out.write("\t\t\t\t\t\t\t<option value=\"\"></option>\r\n");
          out.write("\t\t\t\t\t\t\t");
for(WorkflowScheme scheme : schemes) {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<option value=\"");
          out.print(scheme.getId());
          out.write('"');
          out.write(' ');
          out.write(' ');
          out.print((scheme.getId().equals(searcher.getSchemeId())) ? "selected": "");
          out.write('>');
          out.print(scheme.getName());
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t\t");
} 
          out.write("\r\n");
          out.write("\t\t\t\t\t\t</select>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t         \r\n");
          out.write("\t\t\t\t\t</dd>\r\n");
          out.write("\t\t\t\t\t<dt>");
          out.print(LanguageUtil.get(pageContext, "Step"));
          out.write(":</dt>\r\n");
          out.write("\t\t\t\t\t<dd>\r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"stepId\" name=\"stepId\"  />\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t         \r\n");
          out.write("\t\t\t\t\t</dd>\r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t<dt>");
          out.print(LanguageUtil.get(pageContext, "Show"));
          out.write(":</dt>\r\n");
          out.write("\t\t\t\t\t<dd>\r\n");
          out.write("\t\t\t\t\t\t<input dojoType=\"dijit.form.CheckBox\" ");
if(searcher.isOpen()){
          out.write(" checked='checked' ");
}
          out.write(" type=\"checkbox\" name=\"open\" value=\"true\" id=\"showOpen\" onclick=\"doFilter()\" /> <label for=\"showOpen\">");
          out.print(LanguageUtil.get(pageContext, "open-tasks"));
          out.write("</label><br/> \r\n");
          out.write("\t\t\t\t\t\t<input dojoType=\"dijit.form.CheckBox\" ");
if(searcher.isClosed()){
          out.write(" checked='checked' ");
}
          out.write(" type=\"checkbox\" name=\"closed\" value=\"true\" id=\"showClosed\"  onclick=\"doFilter()\"  /> <label for=\"showClosed\">");
          out.print(LanguageUtil.get(pageContext, "resolved-tasks"));
          out.write("</label><br/> \r\n");
          out.write("\t\t\t\t\t</dd>\r\n");
          out.write("\t\t\t\t</dl>\r\n");
          out.write("\t\t\t\t<div class=\"buttonRow\">\r\n");
          out.write("\t\t\t\t\t<button dojoType=\"dijit.form.Button\" iconClass=\"searchIcon\" name=\"filterButton\" onclick=\"doFilter()\"> ");
          out.print( UtilMethods.escapeSingleQuotes(LanguageUtil.get(pageContext, "Search")) );
          out.write("</button>\r\n");
          out.write("\t\t\t\t\t<button dojoType=\"dijit.form.Button\" name=\"resetButton\"  iconClass=\"resetIcon\" onclick=\"resetFilters()\">");
          out.print(LanguageUtil.get(pageContext, "reset"));
          out.write("</button>    \r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t</div>\r\n");
          out.write("\t</div>\r\n");
          out.write("<!-- END Left Column -->\r\n");
          out.write("\t\r\n");
          out.write("\r\n");
          out.write("<!-- START Right Column -->\r\n");
          out.write("\t<div dojoType=\"dijit.layout.ContentPane\" splitter=\"true\" region=\"center\" style=\"margin-top:37px;\">\r\n");
          out.write("\t\t<div id=\"hangTaskListHere\">\r\n");
          out.write("\t\t\r\n");
          out.write("\t\t\r\n");
          out.write("\t\t</div>\r\n");
          out.write("\t\t\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t</div>\r\n");
          out.write("<!-- END Right Column -->\r\n");
          out.write("\r\n");
          out.write("</div>\r\n");
          out.write("<!-- END Split Box -->\r\n");
          out.write("\t\r\n");
          int evalDoAfterBody = _jspx_th_liferay_005fbox_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_liferay_005fbox_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_liferay_005fbox_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fliferay_005fbox_0026_005ftop_005fbottom.reuse(_jspx_th_liferay_005fbox_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fliferay_005fbox_0026_005ftop_005fbottom.reuse(_jspx_th_liferay_005fbox_005f0);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("dojo.ready(resizeBrowser);\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_portlet_005fparam_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f0 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f0);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(8,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f0.setName("struts_action");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(8,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f0.setValue("/ext/workflows/edit_workflow_task");
    int _jspx_eval_portlet_005fparam_005f0 = _jspx_th_portlet_005fparam_005f0.doStartTag();
    if (_jspx_th_portlet_005fparam_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f0);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f1 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f1.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f0);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(9,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f1.setName("cmd");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(9,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f1.setValue("publish");
    int _jspx_eval_portlet_005fparam_005f1 = _jspx_th_portlet_005fparam_005f1.doStartTag();
    if (_jspx_th_portlet_005fparam_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f1);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f3 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f3.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f1);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(20,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f3.setName("struts_action");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(20,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f3.setValue("/ext/workflows/edit_workflow_task");
    int _jspx_eval_portlet_005fparam_005f3 = _jspx_th_portlet_005fparam_005f3.doStartTag();
    if (_jspx_th_portlet_005fparam_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f3);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f4 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f4.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f1);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(21,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f4.setName("cmd");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(21,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f4.setValue("unpublish");
    int _jspx_eval_portlet_005fparam_005f4 = _jspx_th_portlet_005fparam_005f4.doStartTag();
    if (_jspx_th_portlet_005fparam_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f4);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f6 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f6.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f2);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(33,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f6.setName("struts_action");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(33,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f6.setValue("/ext/workflows/edit_workflow_task");
    int _jspx_eval_portlet_005fparam_005f6 = _jspx_th_portlet_005fparam_005f6.doStartTag();
    if (_jspx_th_portlet_005fparam_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f6);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f7 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f7.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f2);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(34,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f7.setName("cmd");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(34,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f7.setValue("delete");
    int _jspx_eval_portlet_005fparam_005f7 = _jspx_th_portlet_005fparam_005f7.doStartTag();
    if (_jspx_th_portlet_005fparam_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f7);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f9 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f9.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f3);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(46,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f9.setName("struts_action");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(46,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f9.setValue("/ext/workflows/edit_workflow_task");
    int _jspx_eval_portlet_005fparam_005f9 = _jspx_th_portlet_005fparam_005f9.doStartTag();
    if (_jspx_th_portlet_005fparam_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f9);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f10 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f10.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f3);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(47,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f10.setName("cmd");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(47,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f10.setValue("undelete");
    int _jspx_eval_portlet_005fparam_005f10 = _jspx_th_portlet_005fparam_005f10.doStartTag();
    if (_jspx_th_portlet_005fparam_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f10);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f12 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f12.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f4);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(56,89) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f12.setName("struts_action");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(56,89) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f12.setValue("/ext/htmlpages/preview_htmlpage");
    int _jspx_eval_portlet_005fparam_005f12 = _jspx_th_portlet_005fparam_005f12.doStartTag();
    if (_jspx_th_portlet_005fparam_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f12);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f13 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f13.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f4);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(56,167) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f13.setName("previewPage");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(56,167) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f13.setValue("1");
    int _jspx_eval_portlet_005fparam_005f13 = _jspx_th_portlet_005fparam_005f13.doStartTag();
    if (_jspx_th_portlet_005fparam_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f13);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f14 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f14.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f5);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(67,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f14.setName("struts_action");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(67,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f14.setValue("/ext/workflows/edit_workflow_task");
    int _jspx_eval_portlet_005fparam_005f14 = _jspx_th_portlet_005fparam_005f14.doStartTag();
    if (_jspx_th_portlet_005fparam_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f14);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f15 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f15.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f5);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(68,18) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f15.setName("cmd");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(68,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f15.setValue("full_delete");
    int _jspx_eval_portlet_005fparam_005f15 = _jspx_th_portlet_005fparam_005f15.doStartTag();
    if (_jspx_th_portlet_005fparam_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f15);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f17 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f17.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f6);
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(192,6) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f17.setName("struts_action");
    // /html/portlet/ext/workflows/workflows_js_inc.jsp(192,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f17.setValue("/ext/workflows/view_workflow_tasks");
    int _jspx_eval_portlet_005fparam_005f17 = _jspx_th_portlet_005fparam_005f17.doStartTag();
    if (_jspx_th_portlet_005fparam_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f17);
    return false;
  }

  private boolean _jspx_meth_portlet_005factionURL_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:actionURL
    com.liferay.portlet.taglib.ActionURLTag _jspx_th_portlet_005factionURL_005f7 = (com.liferay.portlet.taglib.ActionURLTag) _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.get(com.liferay.portlet.taglib.ActionURLTag.class);
    _jspx_th_portlet_005factionURL_005f7.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005factionURL_005f7.setParent(null);
    // /html/portlet/ext/workflows/view_workflow_tasks.jsp(311,13) name = windowState type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005factionURL_005f7.setWindowState("maximized");
    int _jspx_eval_portlet_005factionURL_005f7 = _jspx_th_portlet_005factionURL_005f7.doStartTag();
    if (_jspx_eval_portlet_005factionURL_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_portlet_005factionURL_005f7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_portlet_005factionURL_005f7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_portlet_005factionURL_005f7.doInitBody();
      }
      do {
        if (_jspx_meth_portlet_005fparam_005f19(_jspx_th_portlet_005factionURL_005f7, _jspx_page_context))
          return true;
        if (_jspx_meth_portlet_005fparam_005f20(_jspx_th_portlet_005factionURL_005f7, _jspx_page_context))
          return true;
        if (_jspx_meth_portlet_005fparam_005f21(_jspx_th_portlet_005factionURL_005f7, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_portlet_005factionURL_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_portlet_005factionURL_005f7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_portlet_005factionURL_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005factionURL_0026_005fwindowState.reuse(_jspx_th_portlet_005factionURL_005f7);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f19(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f19 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f19.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f7);
    // /html/portlet/ext/workflows/view_workflow_tasks.jsp(311,56) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f19.setName("struts_action");
    // /html/portlet/ext/workflows/view_workflow_tasks.jsp(311,56) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f19.setValue("/ext/workflows/edit_workflow_task");
    int _jspx_eval_portlet_005fparam_005f19 = _jspx_th_portlet_005fparam_005f19.doStartTag();
    if (_jspx_th_portlet_005fparam_005f19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f19);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f19);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f20(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f20 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f20.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f7);
    // /html/portlet/ext/workflows/view_workflow_tasks.jsp(311,136) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f20.setName("cmd");
    // /html/portlet/ext/workflows/view_workflow_tasks.jsp(311,136) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f20.setValue("view");
    int _jspx_eval_portlet_005fparam_005f20 = _jspx_th_portlet_005fparam_005f20.doStartTag();
    if (_jspx_th_portlet_005fparam_005f20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f20);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f20);
    return false;
  }

  private boolean _jspx_meth_portlet_005fparam_005f21(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_005factionURL_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.ParamTag _jspx_th_portlet_005fparam_005f21 = (com.liferay.taglib.ParamTag) _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.get(com.liferay.taglib.ParamTag.class);
    _jspx_th_portlet_005fparam_005f21.setPageContext(_jspx_page_context);
    _jspx_th_portlet_005fparam_005f21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_005factionURL_005f7);
    // /html/portlet/ext/workflows/view_workflow_tasks.jsp(311,177) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f21.setName("taskId");
    // /html/portlet/ext/workflows/view_workflow_tasks.jsp(311,177) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_portlet_005fparam_005f21.setValue("REPLACEME");
    int _jspx_eval_portlet_005fparam_005f21 = _jspx_th_portlet_005fparam_005f21.doStartTag();
    if (_jspx_th_portlet_005fparam_005f21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f21);
      return true;
    }
    _005fjspx_005ftagPool_005fportlet_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_portlet_005fparam_005f21);
    return false;
  }
}
