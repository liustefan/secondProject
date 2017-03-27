
package com.bithealth.careCore.facade.model;

import com.bithealth.sdk.common.utils.Md5Utils;



public class RelateAcount  {
	
	private String remark;
	private Integer memberId;
	private String memberGUID;
	private String account;
	private String password;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getMemberGUID() {
		return memberGUID;
	}
	public void setMemberGUID(String memberGUID) {
		this.memberGUID = memberGUID;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return Md5Utils.encript(password+"zkhk");
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}