package com.push.Utils;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.push.constants.Constants;
import com.push.model.WsdlBean;
import com.push.model.WsdlSmsBean;


/**
 * @ClassName:     SmsPushHelper.java 
 * @Description:   短信语音发送帮助类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月8日 下午3:34:25
*****/
public class SmsPushHelper {


	/** 
	 * @Title: getUserInfo 
	 * @Description: 获取账户的基本信息 
	 * @param username
	 * @param password
	 * @return Object
	 * @throws Exception Object     
	*/
	public static Object getUserInfo(String username,String password,String endpointURL) throws Exception{
		WsdlBean parame = new WsdlBean();
		parame.setEndpointURL(endpointURL);
		parame.setMethod(Constants.SMS_METHOD_GETUSERINFO);
		parame.setObjs(new Object[] {username,password});
		return send(parame);
	}
	
	
	 /** 
	 * @Title: setUserInfo 
	 * @Description: 修改账号信息：如修改密码 
	 * @param sms
	 * @return
	 * @throws Exception    
	 * @retrun Object
	 */
	public Object setUserInfo(WsdlSmsBean sms) throws Exception{
		WsdlBean parame = new WsdlBean();
		parame.setEndpointURL(sms.getEndpointURL());
		parame.setMethod(Constants.SMS_METHOD_SETUSERINFO);
		parame.setObjs(new Object[] {sms.getUsername(),sms.getPassword(),sms.getNewPassword()});
		return send(parame);
	}

	
	 /** 
	 * @Title: smsSend 
	 * @Description: 短信语音发送 
	 * @param sms
	 * @return
	 * @throws Exception    
	 * @retrun Object
	 */
	public static Object smsSend(WsdlSmsBean sms) throws Exception{
		WsdlBean parame = new WsdlBean();
		parame.setEndpointURL(sms.getEndpointURL());
		parame.setMethod(Constants.SMS_METHOD_CLUSTERSEND);
		parame.setObjs(new Object[] {sms.getUsername(),sms.getPassword(),sms.getFrom(),sms.getTo(),sms.getText(),sms.getPresendTime(),sms.getIsVoice()});
		return send(parame);
	}

	
	/** 
	 * @Title: send 
	 * @Description: 调用webservice方法实现交互 
	 * @param aa
	 * @return Object     
	 * @throws
	 * @throws Exception 
	*/
	public static Object send(WsdlBean parame) throws Exception{
	 	Service service = new Service();
        Call call = (Call) service.createCall();       
        call.setTargetEndpointAddress(new java.net.URL(parame.getEndpointURL()) );
        call.setOperationName(parame.getMethod()); //指定调用函数  
		return call.invoke(parame.getObjs());//执行并返回结果
	}
	

}
