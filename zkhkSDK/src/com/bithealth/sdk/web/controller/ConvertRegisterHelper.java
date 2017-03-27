 
/**
 * @PackageName:      com.bithealth.sdk.web.controller
 * @FileName:     ConvertRegisterHelper.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年7月8日 上午11:57:49  
 * 
 */

package com.bithealth.sdk.web.controller;


/**
 * 类名称: ConvertRegisterHelper  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月8日 上午11:57:49 
 * 
 * @author "jason chai"
 * @version  
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BigIntegerConverter;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimeConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;

import org.apache.commons.beanutils.converters.StringConverter;
/**
 * 用于注册Converter,可以修改此处代码以添加新的Converter
 * 用于Bean.copyProperties()方法中的class类型转换;
 * @author "jason chai"  
 */
public class ConvertRegisterHelper {

    private ConvertRegisterHelper(){}
    
    public static void registerConverters() {
        ConvertUtils.register(new StringConverter(), String.class);
        //date 
        ConvertUtils.register(new DateConverter(null),java.util.Date.class);
        ConvertUtils.register(new SqlDateConverter(null),java.sql.Date.class);
        ConvertUtils.register(new SqlTimeConverter(null),Time.class);
        ConvertUtils.register(new SqlTimestampConverter(null),Timestamp.class);
        //number
        ConvertUtils.register(new BooleanConverter(null), Boolean.class);
        ConvertUtils.register(new ShortConverter(null), Short.class);
        ConvertUtils.register(new IntegerConverter(null), Integer.class);
        ConvertUtils.register(new LongConverter(null), Long.class);
        ConvertUtils.register(new FloatConverter(null), Float.class);
        ConvertUtils.register(new DoubleConverter(null), Double.class);
        ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class); 
        ConvertUtils.register(new BigIntegerConverter(null), BigInteger.class); 
    }
    
}

