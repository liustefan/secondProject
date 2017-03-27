package com.bithealth.dataConversionServer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;


public class HttpUtil {
	
	private static final Logger log = Logger.getLogger(HttpUtil.class);
	/**
     * 向指定URL发送GET方法的请求
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
	public static String sendGet(String url, String param, String host) {
		String result = "";
		String urlNameString = url;
		if(param != null && !"".equals(param.trim())){
			urlNameString += "?" + param;
		}
		GetMethod getMethod = new GetMethod(urlNameString);
		getMethod.addRequestHeader("DNS", host);
		try {
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(60000);
			int status = client.executeMethod(getMethod);
			if (status == HttpStatus.SC_OK) {
				byte[] responseBody = null;
				responseBody = getMethod.getResponseBody();
				result = new String(responseBody,"utf-8");
				System.out.println(result);
				return result;
			} else {
				System.out.println(result);
				result = "连接统一接入服务器失败！";
				return result;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result = "连接统一接入服务器失败！";
			return result;
		} finally {
			getMethod.releaseConnection();
		}
	}
	
	/**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param host 本地host 
     * @return 所代表远程资源的响应结果
     */
	public static String sendPost(String url, String param, String host) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("DNS", host);
			
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if(result == null || "".equals(result.trim())){
        	result = "会员验证接口验证失败！";
        }
		return result;
	}
	
	public static String sendPost(String url, Object json, String host, String serverId) {
		PostMethod postMethod = new PostMethod(url);
		postMethod.addParameter("params",json.toString());
		postMethod.addParameter("serverId",serverId);
		postMethod.getParams().setContentCharset("utf-8");
        postMethod.setRequestHeader("DNS",host);
        HttpClient client = new HttpClient();
        try {
			int statusCode = client.executeMethod(postMethod);
			log.info("UC接口返回状态码：" + statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				return postMethod.getResponseBodyAsString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	/**
     * 向指定URL发送GET方法的请求
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
	public static String sendGet(String url) {
		String result = "";
		BufferedReader in = null;
		
		try{
			String urlNameString = url;
		
			URL realUrl = new URL(urlNameString);
			
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
	        
	        // 设置通用的请求属性
	        connection.setRequestProperty("accept", "*/*");
	        connection.setRequestProperty("connection", "Keep-Alive");
	        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");	        
	        // 建立实际的连接
	        connection.connect();
	        /*
	         Map<String, List<String>> map = connection.getHeaderFields();
	        
	        // 遍历所有的响应头字段
	        for (String key : map.keySet()) {
	        	System.out.println(key + "--->" + map.get(key));
	        }
	        */
	        
	        // 定义 BufferedReader输入流来读取URL的响应
	        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
	        String line;
	        while ((line = in.readLine()) != null) {
	            result += line;
	        }
		}catch(Exception e){
			System.out.println("发送GET请求出现异常！" + e);
		}finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
        if(result == null || "".equals(result.trim())){
        	result = "调用接口异常";
        }
		return result;
	}
}
