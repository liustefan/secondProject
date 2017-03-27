
package com.bithealth.centCore.facade.model;

import com.bithealth.sdk.common.utils.Md5Utils;



public class RelateAcount  {
	
    private String memberRemark;
    private String focusRemark;
	private Integer memberId;
	private String memberGUID;
	private String account;
	private String password;

	
	
	public String getMemberRemark() {
		return memberRemark;
	}
	public void setMemberRemark(String memberRemark) {
		this.memberRemark = memberRemark;
	}
	public String getFocusRemark() {
		return focusRemark;
	}
	public void setFocusRemark(String focusRemark) {
		this.focusRemark = focusRemark;
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