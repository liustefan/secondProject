package com.bithealth.memberCore.uc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class MemberInfo implements Serializable {

	private static final long serialVersionUID = -9109659103393536071L;
	
	private String memberID;
	
	private String memberName;
	
	private String memberSex;
	
	private String birthday;
	
	private String mobile;
	
	private String IDCard;
	
	private String pwd;
	
	private String syncTimestamp;
	
	/**
	 * 头像
	 */
	private String headAddress;
	
	private List<Account> accountList = new ArrayList<Account>();
	
	public MemberInfo(String memberID) {
		this.memberID = memberID;
	}
	
	public MemberInfo(){
		
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberSex() {
		return memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@JSONField(name = "IDCard") 
	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public String getSyncTimestamp() {
		return syncTimestamp;
	}

	public void setSyncTimestamp(String syncTimestamp) {
		this.syncTimestamp = syncTimestamp;
	}
	
	public String getHeadAddress() {
		return headAddress;
	}

	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	@Override
	public String toString() {
		return "MemberInfo [memberID=" + memberID + ", memberName="
				+ memberName + ", memberSex=" + memberSex + ", birthday="
				+ birthday + ", mobile=" + mobile + ", IDCard=" + IDCard
				+ ", pwd=" + pwd + ", syncTimestamp=" + syncTimestamp
				+ ", headAddress=" + headAddress + ", accountList="
				+ accountList + "]";
	}
	
}
