package com.push.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * @ClassName:     SmsConfig.java 
 * @Description:   短信语音配置信息实体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月10日 上午9:38:17
*****/
@Entity
public class SmsConfig implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int id; //主键ID
	private int serverId;	//组织id server_id
	private String account;	//网关账号
	private String passWord;	//网关密码
	private String logo;	//签名
	private String tip;	//客服提示信息
	private int totalCount;	//总条数限制
	private int dataCount;	//每日发送最大发送条数
	private int memberAceptCount;	//会员每日接收最大值
	private int dateRepeat;	//每日重复最大值
	
	private String endpointURL ;//weService服务地址

	private String sendTime;	//发送时间
	private Date updateDate;	//更新时间
	private Date createDate;	//创建时间
	private String createBy;	//创建者
	private String updateBy;	//更新者
	
	public String getEndpointURL() {
		return endpointURL;
	}
	public void setEndpointURL(String endpointURL) {
		this.endpointURL = endpointURL;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public int getMemberAceptCount() {
		return memberAceptCount;
	}
	public void setMemberAceptCount(int memberAceptCount) {
		this.memberAceptCount = memberAceptCount;
	}
	public int getDateRepeat() {
		return dateRepeat;
	}
	public void setDateRepeat(int dateRepeat) {
		this.dateRepeat = dateRepeat;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	
}
