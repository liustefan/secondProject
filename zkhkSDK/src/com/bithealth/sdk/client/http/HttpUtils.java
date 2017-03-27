package com.bithealth.sdk.client.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.bithealth.sdk.common.utils.StringUtil;

public class HttpUtils {

	public static String inputStreamToString(InputStream input) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input, "utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
	}

	public static String paramsToBuffer(
			Set<Entry<String, CharSequence>> entries, String delimiter,
			String equals) {
		if (entries == null || entries.isEmpty()) {
			return null;
		}
		StringBuilder buffer = new StringBuilder();
		boolean notFirst = false;
		for (Entry<String, CharSequence> entry : entries) {
			if (notFirst) {
				buffer.append(delimiter);
			} else {
				notFirst = true;
			}
			CharSequence value = entry.getValue();
			try {
				buffer.append(entry.getKey()).append(equals)
						.append(URLEncoder.encode(value.toString(), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// System.out.println(buffer.toString());
		return new String(buffer);
	}

	public static Response get(URL url, Map<String, CharSequence> payload) throws   ResponseException, IOException {
		return get(getHttpUrlConnection(url), payload);
	}

	public static HttpURLConnection getHttpUrlConnection(URL url)
			throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.addRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		return conn;
	}

	private static HttpURLConnection getConnection(URL url, String method,
			String ctype) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(method);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
		conn.setRequestProperty("User-Agent", "top-sdk-java");
		conn.setRequestProperty("Content-Type", ctype);
		return conn;
	}

	public static Response get(HttpURLConnection connection, Map<String, CharSequence> payload) throws ResponseException {
		Response response = new Response();
		int status = 500;
		try {
			String buffer = paramsToBuffer(payload.entrySet(), "&", "=");

			if (buffer != null && !buffer.equals(""))
				connection.getOutputStream().write(buffer.getBytes());

			// 获取链接的返回结果
			
			String body = inputStreamToString(connection.getInputStream());
			status = connection.getResponseCode();
			response.setBody(body);
			response.setStatus(status);
		} catch (IOException ex) {
			ResponseException responseException  = new ResponseException();
			try{
				status = connection.getResponseCode();
				
				responseException.setStatus(status); 
				responseException.setError(ex.getMessage());
				
			}catch(Exception exa){
				  responseException  = new ResponseException();
				status =HttpURLConnection.HTTP_BAD_REQUEST;// connection.getResponseCode();
				 
				responseException.setStatus(status); 
				responseException.setError(ex.getMessage());
				throw responseException;
			}
			throw responseException;
		}

		return response;
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static Response sendGet(String url, Map<String, CharSequence> param, String host) {
		String result = "";
		StringBuilder urlNameString = new StringBuilder();
		if(param != null  && !param.isEmpty()) {
			for(String key : param.keySet()) {
				if(urlNameString.length() == 0) {
					urlNameString.append("?" + key +"=" + param.get(key));
				} else {
					urlNameString.append("&" + key +"=" + param.get(key));
				}
			}
		}
		GetMethod getMethod = new GetMethod(url + urlNameString.toString());
		if(StringUtil.isNotEmpty(host)) {
			getMethod.addRequestHeader("DNS", host);
		}
		HttpClient client = new HttpClient();
		try {
			
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(60000);
			int status = client.executeMethod(getMethod);
			if (status == HttpStatus.SC_OK) {
				byte[] responseBody = null;
				responseBody = getMethod.getResponseBody();
				result = new String(responseBody, "utf-8");
				return new Response(status, result);
			} else {
				return new Response(status, null, getMethod.getStatusText());
			}
		} catch (Exception ex) {
			return new Response(HttpStatus.SC_REQUEST_TIMEOUT, ex.getLocalizedMessage(), ex.getLocalizedMessage());
		} finally {
			getMethod.releaseConnection();
		}
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url) {
		String result = "";
		BufferedReader in = null;

		try {
			String urlNameString = url;

			URL realUrl = new URL(urlNameString);

			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();

			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			/*
			 * Map<String, List<String>> map = connection.getHeaderFields();
			 * 
			 * // 遍历所有的响应头字段 for (String key : map.keySet()) {
			 * System.out.println(key + "--->" + map.get(key)); }
			 */

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (result == null || "".equals(result.trim())) {
			result = "调用接口异常";
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @param host
	 *            本地host
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
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
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
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
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
		if (result == null || "".equals(result.trim())) {
			result = "会员验证接口验证失败！";
		}
		return result;
	}
	
	public static Response sendPost(String url, Map<String, CharSequence> parameters, String host) {
		PostMethod postMethod = new PostMethod(url);
		if (parameters != null && !parameters.isEmpty()) {
			for (String key : parameters.keySet()) {
				postMethod.addParameter(key, parameters.get(key).toString());
			}
		}
		postMethod.getParams().setContentCharset("utf-8");
		if(StringUtil.isNotEmpty(host)) {
			postMethod.setRequestHeader("DNS", host);
		}
		HttpClient client = new HttpClient();
		Response response = new Response();
		try {
			int statusCode = client.executeMethod(postMethod);
			response.setStatus(statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				response.setBody(postMethod.getResponseBodyAsString());
			} else {
				response.setError(postMethod.getStatusText());
			}
		} catch (IOException e) {
			response.setError(e.getMessage());
			response.setStatus(HttpStatus.SC_BAD_REQUEST);
		}finally {
			postMethod.releaseConnection();
		}
		return response;
	}
	
	/**
	 * 请求参数放入body中
	 * @param url
	 * @param parameters
	 * @param host
	 * @return
	 */
	public static Response sendPostBody(String url, Map<String, CharSequence> parameters, String host) {
		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");  
		if (parameters != null && !parameters.isEmpty()) {
			NameValuePair[] param = new NameValuePair[]{};
			int i = 0;
			for (String key : parameters.keySet()) {
				param[i] = new NameValuePair(key, parameters.get(key).toString());
				i++;
			}
			postMethod.setRequestBody(param);
		}
		HttpClient client = new HttpClient();
		Response response = new Response();
		try {
			int statusCode = client.executeMethod(postMethod);
			response.setStatus(statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				response.setBody(postMethod.getResponseBodyAsString());
			} else {
				response.setError(postMethod.getStatusText());
			}
		} catch (IOException e) {
			response.setError(e.getMessage());
			response.setStatus(HttpStatus.SC_BAD_REQUEST);
		}finally {
			postMethod.releaseConnection();
		}
		 return response;
	}

	public static void main(String[] arg) {
		URL url;
		Response res = null;
		try {

			Map<String, CharSequence> payload = new HashMap<String, CharSequence>();
			url = new URL(
					"http://192.168.10.27:9082/Push/pushByMemberId");

			Map data    =  new HashMap<String, CharSequence>();
			data.put("logId", "374");
			data.put("memberId", "doc_274");
			data.put("msgType","0");
			data.put("platform", "1");
			 
			data.put("sendTime","1472892160");
			data.put("sender", "mem_30056");
			data.put("sign", "5051beacffe8cf16c309a833a5956685");
			
			
//			{data={"logId":374}, description=, memberId=doc_274, msgType=0, platform=1, sendTime=1472892160, sender=mem_30056, sign=5051beacffe8cf16c309a833a5956685, title=}
			
			
			
			try {
				// get(URL url, Map<String, CharSequence> payload)
				res = post(url, data);
				// res =
				getConnection(url, "GET", "");
				System.out.println(res.getStatus());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(res);
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Response post(URL url, Map<String, CharSequence> parameters)
			throws IOException {
		HttpURLConnection conn = null;

        OutputStream output = null;  
        OutputStreamWriter outr = null;  
        
		int status = 200;
		String responseContent = null;
		 Response response = new Response();

			response.setStatus(500);
	        
		try {
			 
		  
		        
			StringBuffer params = new StringBuffer();
			for (Iterator<Map.Entry<String, CharSequence>> iter = parameters
					.entrySet().iterator(); iter.hasNext();) {
				Map.Entry<String, CharSequence> element = (Map.Entry<String, CharSequence>) iter
						.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(),
						"utf-8"));
				params.append("&");
			}

			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "text/xml");  
			conn.connect(); 
			
			 output = conn.getOutputStream();  
		     outr = new OutputStreamWriter(output);  
		        // 写入请求参数  

//				byte[] b = params.toString().getBytes();
//		      outr.write(params.toString().toCharArray(), 0, inputParam  
//		                .toString().length());
//		      

		      outr .write(params.toString().toCharArray(), 0, params.toString().length());
		        
		      outr.flush();  
		      outr.close();  
			

			     System.out.println("send ok");  
			       
//			conn.getOutputStream().write(b, 0, b.length);
			status = conn.getResponseCode();
			  
			int code = conn.getResponseCode();  
	        System.out.println("code " + code);  
	        System.out.println(conn.getResponseMessage());  

			 //读取响应内容  
	       
	        
	        if (code == 200)  
	        {  
	              
	            InputStream in = conn.getInputStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(in, "utf-8"));
				String tempLine = rd.readLine();
				StringBuffer tempStr = new StringBuffer();
				String crlf = System.getProperty("line.separator");
				while (tempLine != null) {
					tempStr.append(tempLine);
					tempStr.append(crlf);
					tempLine = rd.readLine();
				}
				responseContent = tempStr.toString();
				rd.close();
				in.close();

				response.setStatus(code);
				
	        } else  
	        {  
	        	responseContent = "远程服务器连接失败,错误代码:" + code;  
	            

	    		response.setStatus(code);
	  
	        }  
	        
			

		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

        response.setBody(responseContent);
		
		
		return response;
	}

}
