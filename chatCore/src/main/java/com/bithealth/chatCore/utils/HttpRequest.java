package com.bithealth.chatCore.utils;


import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;



/**
 * 
 * 类名称: HttpRequest  
 * 功能描述: TODO HttpRequest请求处理类  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月21日 上午11:01:53 
 * 
 * @author 胡翔
 * @version
 */
public class HttpRequest  implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param map
     *            请求参数，map集合形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendApachePost(String url,Map<String,Object> map) throws HttpException, IOException{
    	PostMethod postMethod = new PostMethod(url);
    	Set<Entry<String, Object>> entrySet = map.entrySet();
    	Iterator<Entry<String, Object>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Entry<String, Object> entry = iterator.next();
			postMethod.addParameter(entry.getKey(),entry.getValue().toString());
    	}
        postMethod.getParams().setContentCharset("utf-8");
        HttpClient client = new HttpClient();
        int status = client.executeMethod(postMethod);
        if(status == HttpStatus.SC_OK){
        	return new String(postMethod.getResponseBody(),"UTF-8");
        }
        return null;
    } 
}
