/**
 * @PackageName:      com.bithealth.memberCore.uc.bean
 * @FileName:     ModifyPwd.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月26日 下午2:46:31  
 * 
 */
package com.bithealth.memberCore.uc.bean;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 类名称: ModifyPwd  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月26日 下午2:46:31 
 * 
 * @author liuhm
 * @version  
 */
public class ModifyPwd extends UCRetBase {
	
	private List<JSONObject> content;

	public List<JSONObject> getContent() {
		return content;
	}

	public void setContent(List<JSONObject> content) {
		this.content = content;
	}

}
