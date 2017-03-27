package com.bithealth.dataConversionServer.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;


/**
 * @ClassName:     HTTPHelper.java 
 * @Description:   HTTP请求帮助类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年4月16日 下午1:46:47
*****/
public class HTTPHelper  implements Serializable{
	
	private static Logger logger = Logger.getLogger(HTTPHelper.class);

	/**
	* TODO
	*/
	
	private static final long serialVersionUID = 1L;
	
	
	
	 /** 
	 * @Title: sendPost 
	 * @Description: 发送post请求，用户utf-8编码
	 * @param postMethod
	 * @return    
	 * @retrun String
	 */
	public static String sendPost(PostMethod postMethod){
		postMethod.getParams().setContentCharset("utf-8");
        HttpClient client = new HttpClient();
        String result = "";
        try{
            int statusCode = client.executeMethod(postMethod); 
            if (statusCode == HttpStatus.SC_OK) { 
            	Header[]  b = (Header[]) postMethod.getResponseHeaders("Content-Encoding");
            	if(b.length>0 && b[0].getValue().equals("gzip")){
            		String a = GzipUtil.uncompressToString(postMethod.getResponseBody());
            		System.out.println(a);
            	}else{
            	    InputStream stream = postMethod.getResponseBodyAsStream(); 
    				BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));  
    				StringBuffer buf = new StringBuffer();  
    				String line;  
    				while (null != (line = br.readLine())) {  
    				    buf.append(line).append("\n");  
    				}  
    				result = buf.toString();
            	}
            }
            //释放连接  
            postMethod.releaseConnection(); 
            return result;
        }catch(Exception e){
        	logger.error("HTTP连接异常："+e.getMessage());
        	return null;
        }
	}
	
	
	
	
	
	
	
	
}
