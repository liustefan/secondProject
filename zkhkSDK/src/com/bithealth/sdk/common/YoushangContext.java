package com.bithealth.sdk.common;

import java.io.Serializable;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 

/**
 * 
 * <p>
 * 调用上下文
 * <p>
 * <p>
 * 金蝶移动互联有限公司版权所有
 * </p>
 * 
 * @author jasonchai
 * @created 2007-11-13 下午03:32:43
 * @since 2.1.15
 */
public class YoushangContext implements Serializable {
	
	private static Log LOG = LogFactory.getLog(YoushangContext.class);
	
	public LoginContext getLoginContext() {
		return loginContext;
	}

	public static final String APP_NAME = "Youshang";

	private static final long serialVersionUID = -2319772908777715670L;

	// context本身的Id，用于方便跟踪和监控，无业务语义。
	private long id;
	
	private final LoginContext loginContext;

	// 所在公司Id
	private long companyId = 0L;
	
	//友商ID
	private long ysId = 0L;
	
	//saas总线是否启用了
	private int esbAbled;
	
	private int serviceType;
	

	//公司名称
	private String companyName;
	//账套名称
	private String accountName;
	//合作伙伴ID
	private int partnerId;
	
	private String partyId; //用于订货平台的往来单位id
	
	private Locale locale = null;
	//皮肤
	private String lookAndFeel = null;
	
//	private TimeZone timeZone = CONSTANTS.DEFAULT_TIMEZONE;

	// 扩展属性
	private final Map<String, Object> attributes = Collections.synchronizedMap(new HashMap<String, Object>());

	// 用于放置一些临时属性，不需要序列化
	private transient Map<String, Object> transientAttributes = Collections.synchronizedMap(new HashMap<String, Object>());

	
	//订货平台增加门户id
	private long portalId = 0L;
	
	public Map<String, Object> getTransientAttributes() {
		if (transientAttributes == null) {
			transientAttributes = Collections.synchronizedMap(new HashMap<String, Object>());
		}

		return transientAttributes;
	}
	
	public YoushangContext(LoginContext loginContext) {
		this.loginContext = loginContext;
	}

	public YoushangContext() {
		long id;
		try {
//			id = UIDUtils.createUIDValue();
		} catch (Throwable ex) {
			if (LOG.isWarnEnabled()) {
				LOG.warn("createUIDValue error", ex);
			}
			
			id = new SecureRandom().nextLong();
		}
//		this.id = id;
		this.loginContext = createLoginContext();
	}
	
	private LoginContext createLoginContext() {
		try {
			Configuration config = null;
			CallbackHandler callbackHandler = null;
			
//			if (Env.containsBean(CONSTANTS.Security.JAAS_CONFIG_BEAN_NAME)) {
//				config = Env.getBean(CONSTANTS.Security.JAAS_CONFIG_BEAN_NAME);
//			}
//			
//			if (Env.containsBean(CONSTANTS.Security.JAAS_CALLBACK_HANDLER_BEAN_NAME)) {
//				callbackHandler = Env.getBean(CONSTANTS.Security.JAAS_CALLBACK_HANDLER_BEAN_NAME);
//			}
//			
			LoginContext context = new LoginContext(APP_NAME, new Subject(), callbackHandler, config);
			return context;
		} catch (LoginException e) {
			throw new IllegalStateException("craete LoginContext error", e);
		}
	}

	public YoushangContext(long contextId) {
		this.id = contextId;
		
		this.loginContext = createLoginContext();
	}

	/**
	 * 所在公司的Id
	 * 
	 * @return
	 */
	public long getCompanyId() {
		return companyId;
	}

	/**
	 * 设置所在公司的Id
	 * 
	 * @param companyId
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 登陆用户Id
	 * 
	 * @return
	 */
	public long getUserId() {
//		ApplicationPrincipal principal = ((ApplicationPrincipal) getPrincipal());
//		return principal.getId();
		return 0;
	}
	
	public void	setUserId(long id){
//		ApplicationPrincipal principal = ((ApplicationPrincipal) getPrincipal());
//		principal.setId(id);
		 
	}
	
	/**
	 * 登陆用户name
	 * 
	 * @return
	 */
	public String getUserName() {
//		String name = (String)getAttribute(CONSTANTS.CONTEXT_ATTR_LOGON_USER_NAME);
//		return name;
		return "";
	}
	
	/**
	 * 登陆用户number
	 * 
	 * @return
	 */
	public String getUserNumber() {
//		ApplicationPrincipal principal = ((ApplicationPrincipal) getPrincipal());
//		return principal.getName();
		return "";
	}

	/**
	 * 获取多语言属性
	 */
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * 获取扩展属性
	 * 
	 * @param attrName
	 * @return
	 */
	public Object getAttribute(String attrName) {
		return attributes.get(attrName);
	}

	public Object removeAttribute(String attrName) {
		return this.attributes.remove(attrName);
	}

	/**
	 * 获取扩展属性列表
	 * 
	 * @return
	 */
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttribute(String attrName, Object attrValue) {
		attributes.put(attrName, attrValue);
	}

	public long getDatabaseId() {
		Principal principal = getPrincipal();
		
//		if (principal instanceof SimpleApplicationPrincipal) {
//			return ((SimpleApplicationPrincipal) principal).getDbId();
//		}
//		
//		if (principal instanceof YoushangTenantPrincipal) {
//			return ((YoushangTenantPrincipal) principal).getDbId();
//		}
		
		return 0L;
		//throw new UnsupportedOperationException();
	}

	public void setDatabaseId(long databaseId) {
		Principal principal = getPrincipal();
//		
//		if (principal instanceof SimpleApplicationPrincipal) {
//			((SimpleApplicationPrincipal) principal).setDbId(databaseId);
//			return;
//		}
//		
//		if (principal instanceof YoushangTenantPrincipal) {
//			((YoushangTenantPrincipal) principal).setDbId(databaseId);
//			return;
//		}
		
		throw new UnsupportedOperationException();
	}


	public long getId() {
		return id;
	}

	public TimeZone getTimeZone() {
//		return timeZone;
		return null;
	}

	public void setTimeZone(TimeZone zone) {
//		this.timeZone = zone;
	}

	public String getLookAndFeel() {
		return lookAndFeel;
	}

	public void setLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
	}
	
	public Principal getPrincipal() {
		Set<Principal> principals = this.getLoginContext().getSubject().getPrincipals();
		if (principals.isEmpty()) {
			return null;
		}
		
		return principals.iterator().next();
	}

	public void addPrincipal(Principal principal) {
		Set<Principal> principals = this.getLoginContext().getSubject().getPrincipals();
		if (!principals.contains(principal)) {
			principals.add(principal);
		}
	}
	
	public void setPrincipal(Principal principal) {
		Set<Principal> principals = this.getLoginContext().getSubject().getPrincipals();
		principals.clear();
		principals.add(principal);
	}
	
//	public JSONObject toJSON() {
//		JSONObject json = new JSONObject();
//		json.put("lookAndFeel", this.attributes);
//		json.put("companyName", this.companyName);
//		
//		json.put("companyId", this.companyId);
//		json.put("locale", this.locale);
//		json.put("lookAndFeel", this.lookAndFeel);
//		json.put("timeZone", this.timeZone.toString());
//		json.put("partnerId", this.getPartnerId());
//		
//		if (this.getLoginContext() != null) {
//			json.put("principals", this.getLoginContext().getSubject().getPrincipals());
//		}
//		
//		return json;
//	}
//	
//	public void fromJSON(JSONObject json) {
//		JSON.fromJSON(YoushangContext.class, this, json);
//	}
//	
//	public String toString() {
//		return this.toJSON().toString();
//	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	
	public long getYsId() {
		return ysId;
	}

	public void setYsId(long ysId) {
		this.ysId = ysId;
	}

	public void setEsbAbled(int esbAbled) {
		this.esbAbled = esbAbled;
	}

	public int getEsbAbled() {
		return esbAbled;
	}

	public long getPortalId() {
		return portalId;
	}

	public void setPortalId(long portalId) {
		this.portalId = portalId;
	}
	
	public int getServiceType() {
		return (Integer) this.getAttribute("SAASServiceType");
	}
	
	public boolean isBigIntegrated() {
		boolean rst = false;
		int serviceType = this.getServiceType();
		if ((serviceType & 15) > 0) rst = true;
		return rst;
	}
	
	public boolean hasVersion(int type) {
		boolean rst = false;
		int serviceType = this.getServiceType();
		if ((serviceType & type) > 0) rst = true;
		return rst;
	}
	
	public boolean isYkbMarketingVersion() {
		return this.hasVersion(16);
	}
	
	public boolean isYkb() {
		return this.hasVersion(16) || this.hasVersion(32) || this.hasVersion(64);
	}
	
	public int getAccessMode() {
		return (Integer) this.getAttribute("AccessMode");
	}
	
	public int getCustMode() {
		return (Integer) this.getAttribute("CustMode");
	}
	
	/*
	 * 获取公司名字超强版
	 */
	public String getCompanyNameX() {
		Principal principal = this.getPrincipal();
		String name = this.getCompanyName();
		if (StringUtils.isEmpty(name)) {
//			if (principal instanceof YoushangTenantPrincipal) {
//				name = ((ApplicationPrincipal) this.getPrincipal()).getDisplayName();
//			} else if (principal instanceof PangooTenantPrincipal) {
//				name = ((PangooTenantPrincipal) principal).getIsolationId();				
//			} else {
//				name = ((ApplicationPrincipal) this.getPrincipal()).getDisplayName();
//			}
		}
		return name;
	}
	
}
