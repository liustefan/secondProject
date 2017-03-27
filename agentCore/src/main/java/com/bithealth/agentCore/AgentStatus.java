/**
 * @PackageName:      com.bithealth.agentCore
 * @FileName:     AgentStatus.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月25日 下午3:18:48  
 * 
 */
package com.bithealth.agentCore;

/**
 * 类名称: AgentStatus  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月25日 下午3:18:48 
 * 
 * @author liuhm
 * @version  
 */
public interface AgentStatus {
	  
	 /** 方法错误  */
	public static final int METHOD_ERROR = 9999;
	
	 /** <tt>200 OK</tt> (HTTP/1.0 - RFC 1945) */
    public static final int SC_OK = 200;
    

    /** <tt>400 Bad Request</tt> (HTTP/1.1 - RFC 2616) */
    public static final int SC_BAD_REQUEST = 400;
    /** <tt>401 Unauthorized</tt> (HTTP/1.0 - RFC 1945) */
    public static final int SC_UNAUTHORIZED = 401;
    /** <tt>402 Payment Required</tt> (HTTP/1.1 - RFC 2616) */
    public static final int SC_PAYMENT_REQUIRED = 402;
    /** <tt>403 Forbidden</tt> (HTTP/1.0 - RFC 1945) */
    public static final int SC_FORBIDDEN = 403;
    /** <tt>404 Not Found</tt> (HTTP/1.0 - RFC 1945) */
    public static final int SC_NOT_FOUND = 404;
    
    /** <tt>408 Request Timeout</tt> (HTTP/1.1 - RFC 2616) */
    public static final int SC_REQUEST_TIMEOUT = 408;

    // --- 5xx Server Error ---

    /** <tt>500 Server Error</tt> (HTTP/1.0 - RFC 1945) */
    public static final int SC_INTERNAL_SERVER_ERROR = 500;
    
    /** <tt>503 Service Unavailable</tt> (HTTP/1.0 - RFC 1945) */
    public static final int SC_SERVICE_UNAVAILABLE = 503;
    
}
