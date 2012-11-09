package org.apache.jsp.html.portlet.ext.workflows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.util.Logger;
import org.apache.commons.beanutils.BeanUtils;
import com.dotmarketing.portlets.workflows.model.WorkflowAction;
import com.dotmarketing.util.DateUtil;
import com.dotmarketing.util.PortletURLUtil;
import com.dotmarketing.portlets.workflows.model.WorkflowStep;
import com.dotmarketing.business.Role;
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
import com.liferay.portal.language.LanguageUtil;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.portlets.workflows.business.WorkflowAPI;
import java.util.List;
import com.dotmarketing.portlets.workflows.model.WorkflowTask;
import com.dotmarketing.portlets.workflows.model.WorkflowSearcher;

public final class view_005ftasks_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(7);
    _jspx_dependants.add("/html/common/init.jsp");
    _jspx_dependants.add("/WEB-INF/tld/c-rt.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tld/liferay-portlet.tld");
    _jspx_dependants.add("/WEB-INF/tld/liferay-util.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-tiles.tld");
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	WorkflowSearcher searcher = new WorkflowSearcher(request.getParameterMap(), user);
	session.setAttribute(com.dotmarketing.util.WebKeys.WORKFLOW_SEARCHER, searcher);
	
	WorkflowSearcher fakeSearcher =(WorkflowSearcher) BeanUtils.cloneBean(searcher) ;
	WorkflowAPI wapi = APILocator.getWorkflowAPI();

	List<WorkflowTask> tasks = searcher.findTasks();
	


	java.util.Map params = new java.util.HashMap();
	params.put("struts_action", new String[] { "/ext/workflows/view_workflow_tasks" });

	String referer = PortletURLUtil.getActionURL(request, WindowState.MAXIMIZED
        	.toString(), params);
        	

	boolean singleStep = true;
	String currentStep =null;
	for(WorkflowTask task: tasks){
		if(currentStep==null && singleStep) {
			currentStep =task.getStatus();
		} 
		if(!task.getStatus().equals(currentStep)){ 
			singleStep = false;
			currentStep = null;
		} 
	}
	
	if(currentStep == null){
		currentStep = searcher.getStepId();
	}

	
	
   	List<WorkflowAction> availableActions= new ArrayList();
   	if(currentStep != null){
   		WorkflowStep step = new WorkflowStep();
   		step.setId(currentStep);
   		
   		List<WorkflowAction>  myActions = wapi.findActions(step, user);
   		for(WorkflowAction a : myActions){
   			if(!a.requiresCheckout()){
   				availableActions.add(a);
   			}
   			
   		}
   		if(availableActions.size() ==0){
   			singleStep=false;
   		}
   	}
   	

   	
   	


      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar actionData = { \r\n");
      out.write("\t\tidentifier: 'id',\r\n");
      out.write("\t \tlabel: 'name',\r\n");
      out.write("\t  \titems: [\r\n");
      out.write("\t\t{ id:'',  name:'' }\r\n");
      out.write("\t\t");
for(WorkflowAction action : availableActions){
      out.write("\r\n");
      out.write("\t\t\t  ,{ id:'");
      out.print(action.getId());
      out.write("', \r\n");
      out.write("\t\t\t\t  name:'");
      out.print(action.getName());
      out.write("', \r\n");
      out.write("\t\t\t\t  assignable:'");
      out.print(action.isAssignable());
      out.write("',\r\n");
      out.write("\t\t\t\t  commentable:'");
      out.print(action.isCommentable() ||  UtilMethods.isSet(action.getCondition()));
      out.write("'\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t]};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar actionStore = new dojo.data.ItemFileReadStore({data:actionData});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"margin:15px;\">\r\n");
      out.write("\t<table class=\"listingTable\">\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th id=\"checkAllCheckbox\" style=\"width:20px;\">\r\n");
      out.write("\t\t\t<input type=\"checkbox\" dojoType=\"dijit.form.CheckBox\" ");
if(!singleStep){ 
      out.write("disabled=\"true\"");
} 
      out.write(" id=\"checkAllCkBx\" value=\"true\" onClick=\"checkAll()\" />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</th>\r\n");
      out.write("\t\t<th nowrap=\"nowrap\" style=\"text-align:center;\"><a href=\"javascript: doOrderBy('");
      out.print("title".equals(searcher.getOrderBy())?"title desc":"title");
      out.write("')\">");
      out.print(LanguageUtil.get(pageContext, "Title"));
      out.write("</a></th>\r\n");
      out.write("\r\n");
      out.write("\t\t<th nowrap=\"nowrap\" width=\"8%\" style=\"text-align:center;\"><a href=\"javascript: doOrderBy('");
      out.print("status".equals(searcher.getOrderBy())?"status desc":"status");
      out.write("')\">");
      out.print(LanguageUtil.get(pageContext, "Status"));
      out.write("</a></th>\r\n");
      out.write("\t\t<th nowrap=\"nowrap\" width=\"10%\" style=\"text-align:center;\"><a href=\"javascript: doOrderBy('");
      out.print("workflow_step.name".equals(searcher.getOrderBy())?"workflow_step.name desc":"workflow_step.name");
      out.write("')\">");
      out.print(LanguageUtil.get(pageContext, "Workflow-Step"));
      out.write("</a></th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<th nowrap=\"nowrap\" width=\"10%\" style=\"text-align:center;\"><a href=\"javascript: doOrderBy('");
      out.print("assigned_to".equals(searcher.getOrderBy())?"assigned_to desc":"assigned_to");
      out.write("')\">");
      out.print(LanguageUtil.get(pageContext, "Assignee"));
      out.write("</a></th>\r\n");
      out.write("\t\t<th nowrap=\"nowrap\" width=\"15%\" style=\"text-align:center;\"><a href=\"javascript: doOrderBy('");
      out.print("mod_date".equals(searcher.getOrderBy())?"mod_date desc":"mod_date");
      out.write("')\">");
      out.print(LanguageUtil.get(pageContext, "Last-Updated"));
      out.write("</a></th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
if(tasks==null || tasks.size() ==0){ 
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"100\">\r\n");
      out.write("\t\t\t\t<div class=\"noResultsMessage\">");
      out.print(LanguageUtil.get(pageContext, "No-Tasks-Found"));
      out.write("</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t");
} 
      out.write('\r');
      out.write('\n');
      out.write('	');
for(WorkflowTask task : tasks){ 
      out.write("\r\n");
      out.write("\t\t");
Role r = APILocator.getRoleAPI().loadRoleById(task.getAssignedTo()); 
      out.write("\r\n");
      out.write("\t\t");
Contentlet contentlet = new Contentlet();

			try{
			 contentlet 	= APILocator.getContentletAPI().findContentletByIdentifier(task.getWebasset(),false,APILocator.getLanguageAPI().getDefaultLanguage().getId(), user, true);
			}
			catch(Exception e){
				Logger.error(this.getClass(), e.getMessage());	
			}
			
      out.write("\r\n");
      out.write("\t\t");
WorkflowStep step = APILocator.getWorkflowAPI().findStep(task.getStatus()); 
      out.write("\r\n");
      out.write("\t\t<tr class=\"alternate_1\">\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input ");
if(!singleStep){ 
      out.write("disabled=\"true\"");
} 
      out.write(" type=\"checkbox\" dojoType=\"dijit.form.CheckBox\" id=\"");
      out.print(task.getWebasset() );
      out.write("\" class=\"taskCheckBox\" value=\"");
      out.print(task.getId() );
      out.write("\"  />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td onClick=\"editTask('");
      out.print(task.getId());
      out.write("')\">\r\n");
      out.write("\t\t\t\t");
      out.print(task.getTitle() );
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t<td nowrap=\"true\" align=\"center\" width=\"1%\" onClick=\"editTask('");
      out.print(task.getId());
      out.write("')\">\r\n");
      out.write("\t\t\t\t");
if (contentlet.isLive()) {
      out.write("\r\n");
      out.write("\t\t            <span class=\"liveIcon\"></span>\r\n");
      out.write("\t\t        ");
} else if (contentlet.isArchived()) {
      out.write("\r\n");
      out.write("\t\t        \t<span class=\"archivedIcon\"></span>\r\n");
      out.write("\t\t        ");
} else if (contentlet.isWorking()) {
      out.write("\r\n");
      out.write("\t\t            <span class=\"workingIcon\"></span>\r\n");
      out.write("\t\t        ");
}
      out.write("\r\n");
      out.write("\t\t        ");
if (contentlet.isLocked()) {
		        
		  		  	User u = APILocator.getUserAPI().loadUserById(APILocator.getVersionableAPI().getLockedBy(contentlet), APILocator.getUserAPI().getSystemUser(), false); 
      out.write("\r\n");
      out.write("\t\t        \t<span class=\"lockIcon\"  title=\"");
      out.print(UtilMethods.javaScriptify(u.getFullName()) );
      out.write("\"></span>\r\n");
      out.write("\t\t   \t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<td align=\"center\" onClick=\"editTask('");
      out.print(task.getId());
      out.write("')\" ");
if(step.isResolved()) {
      out.write("style=\"text-decoration: line-through;\"");
} 
      out.write(" >\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t ");
      out.print(step.getName() );
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td nowrap=\"norap\" align=\"center\">");
      out.print(r.getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td align=\"center\" nowrap=\"norap\">");
      out.print(DateUtil.prettyDateSince(task.getModDate(), user.getLocale()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<table width=\"95%\" align=\"center\" style=\"margin:10px;\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td width=\"33%\">\r\n");
      out.write("\t\t\t");
if(searcher.hasBack()){ 
				fakeSearcher.setPage(searcher.getPage()-1);
			
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<button dojoType=\"dijit.form.Button\" onClick=\"refreshTaskList('");
      out.print(fakeSearcher.getQueryString());
      out.write("');\" iconClass=\"previousIcon\">\r\n");
      out.write("\t\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "Back") );
      out.write(" \r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td width=\"34%\" align=\"center\">\r\n");
      out.write("\t\t\t");
if(searcher.getTotalPages() > 1){ 
      out.write("\r\n");
      out.write("\t\t\t\t");
for(int i = searcher.getStartPage();i< searcher.getTotalPages();i++){ 
					fakeSearcher.setPage(i);
					
      out.write("\r\n");
      out.write("\t\t\t\t\t");
if(i == searcher.getPage()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(i+1 );
      out.write("\r\n");
      out.write("\t\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:refreshTaskList('");
      out.print(fakeSearcher.getQueryString());
      out.write("')\">");
      out.print(i+1 );
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td width=\"33%\" align=\"right\">\r\n");
      out.write("\t\t\t");
if(searcher.hasNext()){ 
				fakeSearcher.setPage(searcher.getPage()+1);
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<button dojoType=\"dijit.form.Button\" onClick=\"refreshTaskList('");
      out.print(fakeSearcher.getQueryString());
      out.write("');\" iconClass=\"nextIcon\">\r\n");
      out.write("\t\t\t\t");
      out.print( LanguageUtil.get(pageContext, "Next") );
      out.write(" \r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
if(tasks != null && tasks.size() >0 ){ 
      out.write("\r\n");
      out.write("\t\t<div class=\"buttonRow\" style=\"text-align: left\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
if(availableActions.size() > 0){ 
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(LanguageUtil.get(pageContext, "Workflows") );
      out.write(" : \r\n");
      out.write("\t\t\t\t<select name=\"performAction\" id=\"performAction\" store=\"actionStore\" dojoType=\"dijit.form.FilteringSelect\"></select>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<button dojoType=\"dijit.form.Button\" onClick=\"excuteWorkflowAction()\">\r\n");
      out.write("\t\t\t\t\t");
      out.print(LanguageUtil.get(pageContext, "Perform-Workflow") );
      out.write("\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t<form name=\"executeTasksFrm\" id=\"executeTasksFrm\" action=\"/DotAjaxDirector/com.dotmarketing.portlets.workflows.ajax.WfTaskAjax?cmd=executeActions\" method=\"post\">\r\n");
      out.write("\t\t<input name=\"wfActionAssign\" id=\"wfActionAssign\" type=\"hidden\" value=\"\">\r\n");
      out.write("\t\t<input name=\"wfActionComments\" id=\"wfActionComments\" type=\"hidden\"\" value=\"\">\r\n");
      out.write("\t\t<input name=\"wfActionId\" id=\"wfActionId\" type=\"hidden\" value=\"\">\r\n");
      out.write("\t\t<input name=\"wfCons\" id=\"wfCons\" type=\"hidden\" value=\"\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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
