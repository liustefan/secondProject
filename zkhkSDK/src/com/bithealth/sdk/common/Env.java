package com.bithealth.sdk.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bithealth.sdk.core.util.IoUtils;

/**
 * 
 * <p>
 * 应用程序的公共环境，主要包括SpringFramework的执行环境
 * <p>
 * <p>
 * 金蝶移动互联有限公司版权所有
 * </p>
 * 
 * @author jasonchai
 * @since 2.1.15
 * @created 2007-10-11 下午02:27:30
 */
public final class Env implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Log LOG = LogFactory.getLog(Env.class);

	public final static String CONFIG_FILE = "applicationContext.xml";

	public final static String DEBUG_PROPERTY = "zkhk.debug";

	private final static ThreadLocal<YoushangContext> contextThreadLocal = new ThreadLocal<YoushangContext>();

	/**
	 * 用作LazyLoad，替代double check
	 */
	private static final class InternalResource implements Serializable {

		private static final long serialVersionUID = 1L;

		public static class Spring implements Serializable {
			private static final long serialVersionUID = 1L;

			public static final ClassPathXmlApplicationContext context;

			/**
			 * 初始化SpringContext
			 */
			static {
				long start = System.currentTimeMillis();
				context = new ClassPathXmlApplicationContext(CONFIG_FILE);
				long timespan = System.currentTimeMillis() - start;

				if (LOG.isInfoEnabled()) LOG.info("spring context loaded. " + timespan + " millis");
			}
		}

		public static class Property implements Serializable {
			private static final long serialVersionUID = 1L;

			public static final Properties properties;

			public static final String propertyName = "zkhk-env";

			static {
				properties = new Properties();

				InputStream in = null;
				try {
					String propertyFile = System.getProperty(propertyName);
					if (StringUtils.isBlank(propertyFile)) {
						propertyFile = "zkhk-env.properties";
					}

					in = Env.class.getClassLoader().getResourceAsStream(propertyFile);
					if (in == null) {
						in = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFile);	
					}
					
					if (in != null) {
						properties.load(in);
					} else {
						if (LOG.isWarnEnabled()) LOG.warn("property file '" + propertyFile + "' not found.");
					}
				} catch (IOException e) {
					if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
				} finally {
					IoUtils.close(in);
				}
			}
		}
	}

	/**
	 * 获取SpringBean
	 * 
	 * @param name
	 * @return
	 * @throws BeansException
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T getBean(String name) throws BeansException {
		return (T) InternalResource.Spring.context.getBean(name);
	}

	/**
	 * 是否包含SpringBean
	 * 
	 * @param name
	 * @return
	 */
	public final static boolean containsBean(String name) {
		return InternalResource.Spring.context.containsBean(name);
	}

	final static ClassPathXmlApplicationContext getSpringContextInternal() {
		return InternalResource.Spring.context;
	}

	/**
	 * 获得应用程序的SpringContext
	 * 
	 * @return
	 */
	public final static ApplicationContext getSpringContext() {
		return EnvWebApplicationContextWrapper.getInstance();
	}

	/**
	 * 获取多语言资源属性
	 * @param messageSourceId 在Spring配置文件中的messageResourceId
	 * @param key messageKey
	 * @param args
	 * @return
	 */
	public final static String getResourceMessage(String messageSourceId, String key, Object... args) {
		YoushangContext context = getContext();
		Locale locale = context != null ? context.getLocale() : null;
		return getResourceMessage(locale, messageSourceId, key, args);
	}

	/**
	 * 获取多语言资源属性
	 * @param locale 语言
	 * @param messageSourceId 在Spring配置文件中的messageResourceId
	 * @param key
	 * @param args
	 * @return
	 */
	public final static String getResourceMessage(Locale locale, String messageSourceId, String key, Object... args) {
		MessageSource messageSource = getBean(messageSourceId);
		return messageSource.getMessage(key, args, locale);
	}

	/**
	 * 获取全局多语言资源属性
	 * @param code
	 * @param args
	 * @return
	 */
	public final static String getGlobalResourceMessage(String code, Object... args) {
		YoushangContext context = getContext();
		Locale locale = context != null ? context.getLocale() : null;
		return InternalResource.Spring.context.getMessage(code, args, locale);
	}

	public final static MessageSource getGlobalResource() {
		return getBean("messageSource");
	}

	public final static YoushangContext getContext() {
		return contextThreadLocal.get();
	}

	public final static void setContext(YoushangContext context) {
		contextThreadLocal.set(context);
		if (context == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("setContext : null");
			}
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("setContext : " + context.toString());
			}
		}
	}

	/**
	 * 获取整体环境的属性
	 * 
	 * @param propertyName
	 * @return
	 */
	public final static Object getProperty(String propertyName) {
		return InternalResource.Property.properties.get(propertyName);
	}

	/**
	 * 设置整体环境的属性
	 * 
	 * @param propertyName
	 * @param value
	 */
	public final static void setProperty(String propertyName, Object value) {
		InternalResource.Property.properties.put(propertyName, value);
	}

	/**
	 * 判断是否Debug环境, 启动参数最优, 上下文参数次之，第三是'zkhk-env.properties的配置', 缺省返回false
	 * 
	 * @return
	 */
	public final static boolean isDebugEnabled() {
		// 启动参数最优
		{
			String property = System.getProperty(DEBUG_PROPERTY);
			if (StringUtils.isNotBlank(property)) {
				return Boolean.parseBoolean(property.trim());
			}
		}

		// 上下文参数
		{
			YoushangContext context = Env.getContext();
			if (context != null) {
				Object o = context.getAttribute(DEBUG_PROPERTY);
				if (o != null) {
					return Boolean.parseBoolean(o.toString());
				}
			}
		}

		// zkhk-env.properties的配置
		{
			Object o = Env.getProperty(DEBUG_PROPERTY);
			if (o != null) {
				return Boolean.parseBoolean(o.toString());
			}
		}

		// 缺省返回false
		return false;
	}
	
	public static boolean isPangooPlatform() {
		final String ATTR_TENANT_ID = "tenantId";
		YoushangContext context = getContext();
		if (context == null) {
			throw new IllegalStateException("Env.getContext() is null");
		}
		String tenantIdValue = (String) context.getAttribute(ATTR_TENANT_ID);
		return StringUtils.isNotBlank(tenantIdValue);
	}
}
