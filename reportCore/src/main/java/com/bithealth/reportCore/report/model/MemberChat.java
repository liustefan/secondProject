/*
 * Member.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员档案（OMEM）
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class MemberChat extends GenericModel {

	private static final long serialVersionUID = 3782785777920082394L;
	/**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 发送类型：1-医生，2-会员
     */
    private Byte sendType;

    private Byte receiveType;
    
    private Integer receiver;
    /**
     * 会员姓名
     */
    private String memname;
    /**
     * 性别：1男；2女；3未知
     */
    private String gender;
    /**
     * 出生年月
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdate;
    /**
     * 手机号码
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    
    private String headaddress;
   
    //===================== 
   	/**
        * 记录ID
        */
       private Integer _logid;
   
//       /**
//        * 发送者
//        */
//       private Integer sender;
  
       /**
        * 发送时间
        */
       private Date sendTime;
       
       /**
        * 内容类别：1-文本，2-图片，3-音频，4-视频
        */
       private Byte contentType;
       /**
        * 内容
        */
       private String content;
       
       private Integer sender;
       
       private Doctor doctor;
       
       private Member member;
       
       
       /** 
        * [3.0]引用类型：1-健教，2-复诊，3-测量，4-单份问卷，5-组合问卷，6-高血压随访(公卫)，7-糖尿病随访(公卫)
        */
       private Byte refType;
       /**
        * [3.0]引用相关表记录ID
        */
       private Long refID;
       /**
        * [3.0]引用对应的状态：(问卷调查)1-未答、2-已答、3-已审核、4-已撤回
        */
       private Byte refStatus;  
       
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public Byte getSendType() {
		return sendType;
	}
	public void setSendType(Byte sendType) {
		this.sendType = sendType;
	}
	public Byte getReceiveType() {
		return receiveType;
	}
	public void setReceiveType(Byte receiveType) {
		this.receiveType = receiveType;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer get_logid() {
		return _logid;
	}
	public void set_logid(Integer _logid) {
		this._logid = _logid;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Byte getContentType() {
		return contentType;
	}
	public void setContentType(Byte contentType) {
		this.contentType = contentType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getHeadaddress() {
		return headaddress;
	}
	public void setHeadaddress(String headaddress) {
		this.headaddress = headaddress;
	}
	public Integer getReceiver() {
		return receiver;
	}
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Byte getRefType() {
		return refType;
	}
	public void setRefType(Byte refType) {
		this.refType = refType;
	}
	public Long getRefID() {
		return refID;
	}
	public void setRefID(Long refID) {
		this.refID = refID;
	}
	public Byte getRefStatus() {
		return refStatus;
	}
	public void setRefStatus(Byte refStatus) {
		this.refStatus = refStatus;
	}
	
}