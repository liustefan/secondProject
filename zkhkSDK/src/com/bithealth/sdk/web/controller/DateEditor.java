/**
 * @PackageName:      com.bithealth.sdk.web.controller
 * @FileName:     DateFormatter.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午4:24:36  
 * 
 */

package com.bithealth.sdk.web.controller;

/**
 * 类名称: DateFormatter  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午4:24:36 
 * 
 * @author "jason chai"
 * @version  
 */
import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateEditor extends PropertyEditorSupport {

    private static final DateFormat YMD_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd");  
    private static final DateFormat YMDHM_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
    private static final DateFormat YMDHMS_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public String getAsText() {
        Date value = (Date) getValue();
        if (null == value) {
           return null;// value = new Date();
        }
        
         String source="";
           try {  
               source = YMD_DATETIME_FORMAT.format(value);  
           } catch ( Exception e) {  
               try {  
                   source = YMDHM_DATETIME_FORMAT.format(value);  
               } catch ( Exception e1) {  
                   try {  
                       source = YMDHMS_DATETIME_FORMAT.format(value);  
                   } catch ( Exception e2) {  
                       source = null;  
                   }  
               }  
           } 

        
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        
//        return df.format(value);
           return source;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        Date value = null;
        if (null != text && !text.equals("")) {
           
            
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                value = df.parse(text);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
             
            try {  
            	 value = YMDHMS_DATETIME_FORMAT.parse(text);  
            } catch (ParseException e) {  
                try {  
                    value = YMDHM_DATETIME_FORMAT.parse(text);  
                } catch (ParseException e1) {  
                    try {  

                        value = YMD_DATETIME_FORMAT.parse(text);  
                       
                    } catch (ParseException e2) {  
                        value = null;  
                    }  
                }  
            } 

        }
        setValue(value);
    }
    

    public static void main(String[] arg){
    	DateEditor dteEditor = new DateEditor();

    	dteEditor.	setAsText("2015-01-22 21:30:12");
    	dteEditor.	setAsText("2015-01-22");
    	dteEditor.	setAsText("2015-01-22 21:30");


    }
    
    
    
}
