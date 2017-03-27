package com.push.validate;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;








import com.push.Utils.PushUtils;
import com.push.constants.Constants;
import com.push.result.ResultObject;


/**
 * @author xiemt
 *
 */
public class ParamInterceptor implements HandlerInterceptor {
	
	private static Logger logger = Logger.getLogger(ParamInterceptor.class); 

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception arg3)throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object arg2) throws Exception {
		boolean returnResult = false;
		PrintWriter out = null;  
		ResultObject result = new ResultObject();
		try { 
			TreeMap<String, String> paramMap = new TreeMap<String, String>();
			
			Enumeration<String> params = request.getParameterNames();
			while(params.hasMoreElements()){  
				String paraName=(String)params.nextElement(); 
				paramMap.put(paraName, request.getParameter(paraName));
			} 
			
			String urlStr = request.getRequestURL().toString();
			String sign = caculateSign(paramMap,urlStr);
			logger.info("url:"+urlStr+"\n"+"Parameter:"+JSONObject.fromObject(paramMap).toString());
			if(null!=sign && sign.equals(request.getParameter("sign")) ){
				returnResult = true;
			}else{
				returnResult = true;
				/*result.setResult(Constants.SIGN_ERROR,"sign签名验证错误","");
				JSONObject json = JSONObject.fromObject(result);  
			    response.setCharacterEncoding("UTF-8");  
			    response.setContentType("application/json; charset=utf-8");  
		        out = response.getWriter(); 	
		        out.append(json.toString());
		        logger.info("sign签名验证错误!");
		        logger.info("url:"+urlStr+"\n"+"Parameter:"+JSONObject.fromObject(paramMap).toString()+"\n"+"sign:"+sign);*/
			}
	    } catch (Exception e) {  
	    	logger.error("拦截器参数验证异常!"+e.getMessage());
	    } finally {  
	        if (out != null) {  
	            out.close();  
	        }  
	    }  
		return returnResult;
	}
	
	/**
	 * 计算请求签名值
	 * @param paramMap 请求参数map
	 * @param url 请求URL
	 * @return
	 */
	public String caculateSign(Map<String, String> paramMap,String url) {
		String sign = null;
		try{
			StringBuffer buffer = new StringBuffer(PushUtils.encode(url.getBytes()));
			//循环请求参数
			for (Object key : paramMap.keySet()) { 
				if(!"sign".equals(key)){
					buffer.append(key);
					//String value = StringUtils.join(paramMap.get(key));
					String value = paramMap.get(key);
					buffer.append(PushUtils.encode(value.getBytes("utf-8")));				
				}
	        } 
			sign = PushUtils.MD5(buffer.toString().getBytes("utf-8"));
		}catch(Exception e){
			logger.error("验证签名异常!"+e.getMessage());
		}
		return sign;
	}			 
}