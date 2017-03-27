 
/**
 * @PackageName:      com.bithealth
 * @FileName:     SuccessMessage.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月9日 上午11:22:04  
 * 
 */

package com.bithealth;


/**
 * 类名称: SuccessMessage  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月9日 上午11:22:04 
 * 
 * @author baozj
 * @version  
 */
public class SuccessMessage extends Message {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 6007396055530000853L;
	
	public SuccessMessage() {
		setStatus(true);
		setContent("操作成功！");
	}
	
	public SuccessMessage(Object data) {
		setStatus(true);
		setContent("操作成功！");
		setData(data);
	}
	
	public SuccessMessage(String content, Object data) {
		setStatus(true);
		setContent(content);
		setData(data);
	}
	
	public SuccessMessage(String content) {
		setStatus(true);
		setContent(content);
	}
}

