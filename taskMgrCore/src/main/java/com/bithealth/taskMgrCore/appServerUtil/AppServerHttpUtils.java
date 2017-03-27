package com.bithealth.taskMgrCore.appServerUtil;

import java.util.TreeMap;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.sdk.common.utils.Md5Utils;
import com.bithealth.sdk.common.utils.Util;
import com.bithealth.sdk.core.entity.JSONResult;


public class AppServerHttpUtils {
	private static final Logger logger = Logger.getLogger(AppServerHttpUtils.class);
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static JSONObject sendPostToAppserver(String url,RequetParam requetParam){
		PostMethod postMethod = new PostMethod(url);
		requetParam.setToken(getTokenByParam(requetParam));
        String str = JSONObject.toJSONString(requetParam);
        postMethod.setRequestBody(str);
        postMethod.getParams().setContentCharset("utf-8");	
        HttpClient client = new HttpClient();
        int statusCode = 0;
        try{
        	statusCode = client.executeMethod(postMethod); 
            String responeStr = postMethod.getResponseBodyAsString();
            if(statusCode == 200 && responeStr!= null){
            	return  (JSONObject) JSONObject.parseObject(responeStr, Object.class);
            }else{
            	return null;
            }
        }catch(Exception e){
        	logger.error("发送HTTP请求到Appserver异常。"+e.getMessage());
        	return null;
        }finally{
        	postMethod.releaseConnection();
        }
	}
	
	
	private static String getTokenByParam(RequetParam requetParam){
		TreeMap<String,Object> paramMap =Util.transBean2TreeMap(requetParam);
		return Util.calculatToken(paramMap);
	}
	
	
}
