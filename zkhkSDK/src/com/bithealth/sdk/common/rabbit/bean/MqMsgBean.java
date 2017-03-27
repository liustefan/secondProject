package com.bithealth.sdk.common.rabbit.bean;


/**
 * @ClassName:     MqMsgBean.java 
 * @Description:   Mq消息体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月21日 下午1:54:38
*****/
public class MqMsgBean { 
	//数据主键ID
	private  String dataId ;
	//命令操作
	private  String operation ;
	//时间
	private  String timestamp ;
	//合作方码
	private  int companyCode ;
	
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	@Override
	public String toString() {
		return "MqMsgBean [dataId=" + dataId + ", operation=" + operation
				+ ", timestamp=" + timestamp + ", companyCode=" + companyCode
				+ "]";
	}

	
}
