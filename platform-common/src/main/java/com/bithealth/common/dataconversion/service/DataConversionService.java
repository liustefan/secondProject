/**
 * @PackageName:      com.bithealth.common.service
 * @FileName:     DataConversionService.java  
 * @Description: TODO( 数据转换处理服务接口)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月22日 下午1:46:51  
 * 
 */
package com.bithealth.common.dataconversion.service;

import com.bithealth.common.dataconversion.constants.ArithmeticEnum;

/**
 * 类名称: DataConversionService  
 * 功能描述: 数据转换处理服务接口.  
 * 日期: 2016年6月22日 下午1:46:51 
 * 
 * @author 胡翔
 * @version  
 */
public interface DataConversionService {
	
	/**
	 * @Title:encryptData 
	 * TODO(按照所选择的算法进行数据加密).  
	 * @author 胡翔
	 * @param source 需要加密的数据
	 * @param enumValue 算法枚举
	 * @return 加密后的数据
	 * @throws Exception 
	 */ 
	public String encryptData(String source,ArithmeticEnum enumValue) throws Exception;
	
	/**
	 * @Title:decodeData 
	 * TODO(按照所选择的算法进行数据解密).  
	 * @author 胡翔
	 * @param source 需要解密的数据
	 * @param enumValue 算法枚举
	 * @return 解密后的数据，无法解密的数据（如：MD5等）直接返回原数据
	 * @throws Exception 
	 */ 
	public String decodeData(String source,ArithmeticEnum enumValue) throws Exception;
}
