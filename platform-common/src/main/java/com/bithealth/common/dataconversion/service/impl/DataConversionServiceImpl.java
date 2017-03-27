/**
 * @PackageName:      com.bithealth.common.service.impl
 * @FileName:     DataConversionServiceImpl.java  
 * @Description: TODO(数据转换加解密服务类)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月22日 下午3:11:55  
 * 
 */
package com.bithealth.common.dataconversion.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.bithealth.common.dataconversion.constants.ArithmeticEnum;
import com.bithealth.common.dataconversion.service.DataConversionService;
import com.bithealth.common.dataconversion.utils.Base64Utils;
import com.bithealth.common.dataconversion.utils.DesUtils;
import com.bithealth.common.dataconversion.utils.MessageDigestUtils;

/**
 * 类名称: DataConversionServiceImpl  
 * 功能描述: TODO 数据转换加解密服务类  
 * 日期: 2016年6月22日 下午3:11:55 
 * 
 * @author 胡翔
 * @version  
 */
@Service
public class DataConversionServiceImpl implements DataConversionService{
	
	@Override
	public String encryptData(String source, ArithmeticEnum enumValue)
			throws Exception {
		if(StringUtils.isBlank(source)){
			return source;
		}
		switch (enumValue) {
			case BASE64:
				return Base64Utils.encryptData(source);
			case DES:
				return DesUtils.encryptData(source);
			case MD5:
				return MessageDigestUtils.encryptDataByMD5(source);
			case SHA:
				return MessageDigestUtils.encryptDataBySHA(source);
			default:
				break;
			}
		return source;
	}

	@Override
	public String decodeData(String source, ArithmeticEnum enumValue)
			throws Exception {
		if(StringUtils.isBlank(source)){
			return source;
		}
		switch (enumValue) {
			case BASE64:
				return Base64Utils.decodeData(source);
			case DES:
				return DesUtils.decodeData(source);
			case MD5:
				break; //md5不支持解密
			case SHA:
				break;
			default:
				break;
		}
		return source;
	}

}
