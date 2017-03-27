 
/**
 * @PackageName:      com.bithealth
 * @FileName:     WarnMessage.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月18日 下午1:35:22  
 * 
 */

package com.bithealth;


/**
 * 类名称: WarnMessage  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月18日 下午1:35:22 
 * 
 * @author baozj
 * @version  
 */
public class WarnMessage extends Message {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	
	public WarnMessage() {
		setStatus(true);
		setContent("操作成功！");
		setType("warn");
	}
	
	public WarnMessage(Object data) {
		setStatus(true);
		setContent("操作成功！");
		setData(data);
		setType("warn");
	}
	
	public WarnMessage(String content, Object data) {
		setStatus(true);
		setContent(content);
		setData(data);
		setType("warn");
	}
	
	public WarnMessage(String content) {
		setStatus(true);
		setContent(content);
		setType("warn");
	}

	/**
	 * type.
	 *
	 * @return  the type 
	 */
	public String getType() {
		return type;
	}

	/**
	 * type.
	 *
	 * @param   type    the type to set 
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}

