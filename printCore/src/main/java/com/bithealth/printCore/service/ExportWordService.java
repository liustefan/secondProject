 
/**
 * @PackageName:      com.bithealth.printCore.service
 * @FileName:     ExportWordService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月30日 下午5:41:16  
 * 
 */

package com.bithealth.printCore.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 类名称: ExportWordService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月30日 下午5:41:16 
 * 
 * @author 陈哲
 * @version  
 */
public interface ExportWordService {
	
	void ExportWord(HttpServletRequest request, HttpServletResponse response, Map<String, Object> dataMap, String exportFileName,
			String templateName);
	
	String doImage(String svgStr, HttpServletRequest request);

}

