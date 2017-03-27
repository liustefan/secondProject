/*
 * AlibabaSmsReq.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-02 Created
 */
package com.bithealth.centCore.sms.taobao;



/**
 * 类名称: AlibabaSmsReq  
 * 功能描述: 阿里巴巴短信发送结果请求参数实体 
 * 日期: 2016年12月2日 上午10:01:43 
 * 
 * @author 谢美团
 * @version  
 */
public class AlibabaSmsNumQueryReq {
	
	
	private String queryDate; //短信发送日期，支持近30天记录查询，格式yyyyMMdd
	private long currentPage = 1L;
	private long pageSize = 10L;
	private String recNum; //接收号码
	private String appKey;  // 应用账号
	private String appSecret;  //应用密码
	
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public String getRecNum() {
		return recNum;
	}
	public void setRecNum(String recNum) {
		this.recNum = recNum;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}


}