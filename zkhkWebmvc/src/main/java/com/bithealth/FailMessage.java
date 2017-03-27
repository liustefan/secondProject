 
/**
 * @PackageName:      com.bithealth
 * @FileName:     FailMessage.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月9日 上午11:22:11  
 * 
 */

package com.bithealth;


/**
 * 类名称: FailMessage  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月9日 上午11:22:11 
 * 
 * @author baozj
 * @version  
 */
public class FailMessage extends Message {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -385597962629300707L;

	public FailMessage() {
		setStatus(false);
		setContent("操作失败！");
	}
	
	public FailMessage(Object data) {
		setStatus(false);
		setContent("操作失败！");
		setData(data);
	}
	
	public FailMessage(String content, Object data) {
		setStatus(false);
		setContent(content);
		setData(data);
	}
	
	public FailMessage(String content) {
		setStatus(false);
		setContent(content);
	}
}

