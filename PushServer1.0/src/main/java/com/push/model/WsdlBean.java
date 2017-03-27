package com.push.model;


import javax.persistence.Entity;

/**
 * @ClassName:     WsdlBean.java 
 * @Description:   webservice调用参数
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月8日 下午3:50:18
*****/
@Entity
public class WsdlBean {

	private String endpointURL;	//webservice的地址
	
	private String method; //需要调用的webservice的方法
	
	private Object[] objs; //发送的参数
	
	public String getEndpointURL() {
		return endpointURL;
	}
	public void setEndpointURL(String endpointURL) {
		this.endpointURL = endpointURL;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Object[] getObjs() {
		return objs;
	}
	public void setObjs(Object[] objs) {
		this.objs = objs;
	}
	
	
	
	
}
