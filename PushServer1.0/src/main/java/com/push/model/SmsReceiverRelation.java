package com.push.model;

import javax.persistence.Entity;


/**
 * @ClassName:     TextReceive.java 
 * @Description:   TODO
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月10日 上午9:45:54
*****/
@Entity
public class SmsReceiverRelation {

	private String msgId;	//消息的id   msg_id
	private String receivePhone; //接收者
	private int returnCode;	//第三方返回码
	private int busCode;//合作方代码 ，0001：三三得九合作方，0002：梦网科技
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getReceivePhone() {
		return receivePhone;
	}
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public int getBusCode() {
		return busCode;
	}
	public void setBusCode(int busCode) {
		this.busCode = busCode;
	}
	
	
	
}
