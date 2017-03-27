package com.push.model;


import javax.persistence.Entity;

/**
 * @ClassName:     WsdlSmsBean.java 
 * @Description:   webservice短信语音实体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月8日 下午5:10:54
*****/
@Entity
public class WsdlSmsBean {
	
	private String username;//登录名，由机构ID和登录名组成。username=机构ID：用户登录名。例：机构ID为10001登录用户名为admin则username为10001:admin
	
	private String password; //密码
	
	private String newPassword; //新密码
	
	private String from; //三三得九合作方保留字段
	
	private String to; //接收手机号，多个号码间以逗号分隔且最大不超过100个号码
	
	private String text; //发送内容,标准内容不能超过70个汉字 
	
	private String presendTime=""; //发送时间,可以空.默认为当前系统时间
	
	
	private String endpointURL ;//weService服务地址
	
	/**
	*   是否语音短信,若为空默认为普通短信.该参数格式:
	*	是否语音(0表示普通短信,1表示语音短信)|重听次数|重拨次数|是否回复(0表示不回复,1表示回复)
	*	如: isVoice=”1|1|2|0” 即:语音短信,重听次数1,重拨次数2,不回复.
	*/
	private String isVoice;
	

	public String getEndpointURL() {
		return endpointURL;
	}

	public void setEndpointURL(String endpointURL) {
		this.endpointURL = endpointURL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPresendTime() {
		return presendTime;
	}

	public void setPresendTime(String presendTime) {
		this.presendTime = presendTime;
	}

	public String getIsVoice() {
		return isVoice;
	}

	public void setIsVoice(String isVoice) {
		this.isVoice = isVoice;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	} 

	
	
}
