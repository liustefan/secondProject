package com.bithealth.dataConversionServer.bean;

/**
 * @ClassName:     ReturnData.java 
 * @Description:   谢美团
 * @author         lenovo  
 * @version        V1.0   
 * @Date           2016年7月1日 下午4:27:17
 *****/
public class ReturnData {
	
	public String idcard;
	public String uniqueId;
	public String msg;
	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getMsg() {
		msg = msg.substring(0, msg.length()>299?299:(msg.length()));
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
