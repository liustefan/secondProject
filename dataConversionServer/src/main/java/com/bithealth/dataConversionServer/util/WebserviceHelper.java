package com.bithealth.dataConversionServer.util;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.log4j.Logger;

import com.bithealth.dataConversionServer.bean.WebServiceClientBean;


/**
 * @ClassName:     WebserviceHelper.java 
 * @Description:   Webservic 帮助类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月21日 下午4:48:04
*****/
public final class WebserviceHelper {
	
	private static Logger logger=Logger.getLogger(WebserviceHelper.class);
	
	
	
	 /** 
	 * @Title: invoke 
	 * @Description: 调用执行指定远程webservice方法 
	 * @param parame
	 * @return    
	 * @retrun Object
	 */
	public static Object invoke(WebServiceClientBean parame){
		try{
		 	Service service = new Service();
	        Call call = (Call) service.createCall();       
	        call.setTargetEndpointAddress(new java.net.URL(parame.getEndpointURL()) );
	        call.setOperationName(parame.getMethod()); //指定调用函数  
			return call.invoke(parame.getObjs());//执行并返回结果
		}catch(Exception e){
			logger.error("调用执行webService发生异常", e);
			return null;
		}

	}

	
}
