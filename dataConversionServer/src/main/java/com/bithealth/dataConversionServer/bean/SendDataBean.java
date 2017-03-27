package com.bithealth.dataConversionServer.bean;

import java.util.Date;

/**
 * @ClassName:     SendDataBean.java 
 * @Description:   发送数据集实体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年1月27日 下午1:38:16
 *****/
public class SendDataBean {
	
	private String xmlStr;
	
	private String memberId;
	
	private Date sendTime; 
	
	private int fileStatus;
	
	private String prgid;
	
	private int source;
	
	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public String getPrgid() {
		return prgid;
	}

	public void setPrgid(String prgid) {
		this.prgid = prgid;
	}

	public String getXmlStr() {
		return xmlStr;
	}

	public void setXmlStr(String xmlStr) {
		this.xmlStr = xmlStr;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public int getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(int fileStatus) {
		this.fileStatus = fileStatus;
	}
	
	
	
	

}
