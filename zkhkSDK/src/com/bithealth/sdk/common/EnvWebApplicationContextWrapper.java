/**
 * 
 */
package com.bithealth.sdk.common;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;

import com.bithealth.sdk.core.util .YoushangContextUtils;

/**
 * 
 * <p>SpringContext<p>
 * <p>金蝶移动互联有限公司版权所有</p>
 * 
 * 使用Wrappper代替继承，是避免Spring使用LOG方式不对导致LOG混乱的问题。
 * 
 * @author jasonchai
 * @created 2009-1-5 上午10:34:18
 */
class EnvWebApplicationContextWrapper implements WebApplicationContext, ConfigurableApplicationContext {
	
	private static EnvWebApplicationContextWrapper intance = new EnvWebApplicationContextWrapper();
	
	public static EnvWebApplicationContextWrapper getInstance() {
		return intance;
	}

	public ServletContext getServletContext() {
		return YoushangContextUtils.getServletContext();
	}

	public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
		return Env.getSpringContextInternal().getAutowireCapableBeanFactory();
	}

	public String getDisplayName() {
		return Env.getSpringContextInternal().getDisplayName();
	}

	public String getId() {
		return Env.getSpringContextInternal().getId();
	}

	public ApplicationContext getParent() {
		return Env.getSpringContextInternal().getParent();
	}

	public long getStartupDate() {
		return Env.getSpringContextInternal().getStartupDate();
	}

	public boolean containsBeanDefinition(String beanName) {
		return Env.getSpringContextInternal().containsBeanDefinition(beanName);
	}

	public int getBeanDefinitionCount() {
		return Env.getSpringContextInternal().getBeanDefinitionCount();
	}

	public String[] getBeanDefinitionNames() {
		return Env.getSpringContextInternal().getBeanDefinitionNames();
	}

	public String[] getBeanNamesForType(Class type) {
		return Env.getSpringContextInternal().getBeanNamesForType(type);
	}

	public String[] getBeanNamesForType(Class type, boolean includeNonSingletons, boolean allowEagerInit) {
		return Env.getSpringContextInternal().getBeanNamesForType(type, includeNonSingletons, allowEagerInit);
	}

	public Map getBeansOfType(Class type) throws BeansException {
		return Env.getSpringContextInternal().getBeansOfType(type);
	}

	public Map getBeansOfType(Class type, boolean includeNonSingletons, boolean allowEagerInit) throws BeansException {
		return Env.getSpringContextInternal().getBeansOfType(type, includeNonSingletons, allowEagerInit);
	}

	public boolean containsBean(String name) {
		return Env.getSpringContextInternal().containsBean(name);
	}

	public String[] getAliases(String name) {
		return Env.getSpringContextInternal().getAliases(name);
	}

	public Object getBean(String name) throws BeansException {
		return Env.getSpringContextInternal().getBean(name);
	}

	public Object getBean(String name, Class requiredType) throws BeansException {
		return Env.getSpringContextInternal().getBean(name, requiredType);
	}

	public Object getBean(String name, Object[] args) throws BeansException {
		return Env.getSpringContextInternal().getBean(name, args);
	}

	public Class getType(String name) throws NoSuchBeanDefinitionException {
		return Env.getSpringContextInternal().getType(name);
	}

	public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
		return Env.getSpringContextInternal().isPrototype(name);
	}

	public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
		return Env.getSpringContextInternal().isSingleton(name);
	}

	public boolean isTypeMatch(String name, Class targetType) throws NoSuchBeanDefinitionException {
		return Env.getSpringContextInternal().isTypeMatch(name, targetType);
	}

	public boolean containsLocalBean(String name) {
		return Env.getSpringContextInternal().containsLocalBean(name);
	}

	public BeanFactory getParentBeanFactory() {
		return Env.getSpringContextInternal().getParentBeanFactory();
	}

	public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
		return Env.getSpringContextInternal().getMessage(resolvable, locale);
	}

	public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
		return Env.getSpringContextInternal().getMessage(code, args, locale);
	}

	public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		return Env.getSpringContextInternal().getMessage(code, args, defaultMessage, locale);
	}

	public void publishEvent(ApplicationEvent event) {
		Env.getSpringContextInternal().publishEvent(event);
	}

	public Resource[] getResources(String locationPattern) throws IOException {
		return Env.getSpringContextInternal().getResources(locationPattern);
	}

	public ClassLoader getClassLoader() {
		return Env.getSpringContextInternal().getClassLoader();
	}

	public Resource getResource(String location) {
		return Env.getSpringContextInternal().getResource(location);
	}

	public void addApplicationListener(ApplicationListener listener) {
		Env.getSpringContextInternal().addApplicationListener(listener);
	}

	public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor beanFactoryPostProcessor) {
		Env.getSpringContextInternal().addBeanFactoryPostProcessor(beanFactoryPostProcessor);
	}

	public void close() {
		Env.getSpringContextInternal().close();
	}

	public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
		return Env.getSpringContextInternal().getBeanFactory();
	}

	public boolean isActive() {
		return Env.getSpringContextInternal().isActive();
	}

	public void refresh() throws BeansException, IllegalStateException {
		Env.getSpringContextInternal().refresh();
	}

	public void registerShutdownHook() {
		Env.getSpringContextInternal().registerShutdownHook();
	}

	public void setParent(ApplicationContext parent) {
		Env.getSpringContextInternal().setParent(parent);
	}

	public boolean isRunning() {
		return Env.getSpringContextInternal().isRunning();
	}

	public void start() {
		Env.getSpringContextInternal().start();	
	}

	public void stop() {
		Env.getSpringContextInternal().stop();	
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContext#getApplicationName()
	 */
	@Override
	public String getApplicationName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.ListableBeanFactory#getBeanNamesForAnnotation(java.lang.Class)
	 */
	@Override
	public String[] getBeanNamesForAnnotation(
			Class<? extends Annotation> annotationType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.ListableBeanFactory#getBeansWithAnnotation(java.lang.Class)
	 */
	@Override
	public Map<String, Object> getBeansWithAnnotation(
			Class<? extends Annotation> annotationType) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.ListableBeanFactory#findAnnotationOnBean(java.lang.String, java.lang.Class)
	 */
	@Override
	public <A extends Annotation> A findAnnotationOnBean(String beanName,
			Class<A> annotationType) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanFactory#getBean(java.lang.Class)
	 */
	@Override
	public <T> T getBean(Class<T> requiredType) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ConfigurableApplicationContext#getEnvironment()
	 */
	@Override
	public ConfigurableEnvironment getEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ConfigurableApplicationContext#setEnvironment(org.springframework.core.env.ConfigurableEnvironment)
	 */
	@Override
	public void setEnvironment(ConfigurableEnvironment arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ConfigurableApplicationContext#setId(java.lang.String)
	 */
	@Override
	public void setId(String arg0) {
		// TODO Auto-generated method stub
		
	}

	
}