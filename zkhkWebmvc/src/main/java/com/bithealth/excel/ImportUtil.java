/**
 * @PackageName:      com.bithealth.excel
 * @FileName:     ImportUtil.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月10日 上午11:28:04  
 * 
 */
package com.bithealth.excel;

/**
 * 类名称: ImportUtil  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月10日 上午11:28:04 
 * 
 * @author liuhm
 * @version  
 */
public class ImportUtil {
	
	public static boolean arrayIsEqual(String[] from, String[] target) {
		if(from == null || target == null || from.length == 0 || target.length == 0) {
			return false;
		}
		if(from.length != target.length) {
			return false;
		}
		for(int len = 0; len < from.length; len++) {
			if(!from[len].equals(target[len])) {
				return false;
			}
		}
		
		return true;
	}

}
