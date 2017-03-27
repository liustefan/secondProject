/*
 * Ouai.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

import java.util.Date;
import java.util.List;

import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员答卷信息表（OUAI）
 * 
 * @author ${user}
 * @version 1.0 2016-07-18
 */
public class Ouai extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -5646046857761979222L;
	/**
     * 答卷编号
     */
    private Integer ansNumber;
    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 问卷ID号
     */
    private Integer qustid;
    /**
     * 问卷版本号
     */
    private String qustVer;
    /**
     * 评定日期
     */
    private Date assessDate;
    /**
     * 是否审核  Y : 审核， N ：免审
     */
    private String chTag;
    /**
     * [2.0.4]答卷状态：T-已答，F-未答，C-已审核，B-暂存
     */
    private String qustTag;
    /**
     * 问卷编号
     */
    private String qustCode;
    /**
     * 发放时间
     */
    private Date publisherTime;
    /**
     * 失效时间
     */
    private Date failureTime;
    /**
     * 功能代码
     */
    private Short funId;
    /**
     * 选项代码
     */
    private Short optId;
    /**
     * 发放医生ID
     */
    private Integer docid;
    /**
     * 发放医生姓名
     */
    private String docName;
    /**
     * 答卷时间
     */
    private Date answerTime;
    /**
     * 会员是否已读已审核的答卷：已读：0;未读：1;
     */
    private Integer readStatus;
    
    /**
     * 体检主ID(引用ph_healthexam)
     */
    private Long HExamID;
    
    private Long MSETaskID;
    
    private List<Uai21> uai21s;
    
    private Uai4 uai4;
    
    private Uai3 uai3;
    
    private Omfq omfq;
    
    private Member member;
    
    private String optName;
    
    private Integer combQustId;
    
    private Doctor doctor;
    
    private String source;
    
    private Boolean isComAnswer;
    
    public Integer getAnsNumber() {
        return ansNumber;
    }
    public void setAnsNumber(Integer ansNumber) {
        this.ansNumber = ansNumber;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Integer getQustid() {
        return qustid;
    }
    public void setQustid(Integer qustid) {
        this.qustid = qustid;
    }
    public String getQustVer() {
        return qustVer;
    }
    public void setQustVer(String qustVer) {
        this.qustVer = qustVer;
    }
    public Date getAssessDate() {
        return assessDate;
    }
    public void setAssessDate(Date assessDate) {
        this.assessDate = assessDate;
    }
    public String getChTag() {
        return chTag;
    }
    public void setChTag(String chTag) {
        this.chTag = chTag;
    }
    public String getQustTag() {
        return qustTag;
    }
    public void setQustTag(String qustTag) {
        this.qustTag = qustTag;
    }
    public String getQustCode() {
        return qustCode;
    }
    public void setQustCode(String qustCode) {
        this.qustCode = qustCode;
    }
    public Date getPublisherTime() {
        return publisherTime;
    }
    public void setPublisherTime(Date publisherTime) {
        this.publisherTime = publisherTime;
    }
    public Date getFailureTime() {
        return failureTime;
    }
    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }
    public Short getFunId() {
        return funId;
    }
    public void setFunId(Short funId) {
        this.funId = funId;
    }
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
    public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public String getDocName() {
        return docName;
    }
    public void setDocName(String docName) {
        this.docName = docName;
    }
    public Date getAnswerTime() {
        return answerTime;
    }
    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }
    public Integer getReadStatus() {
        return readStatus;
    }
    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }
	public Long getHExamID() {
		return HExamID;
	}
	public void setHExamID(Long hExamID) {
		HExamID = hExamID;
	}
	public List<Uai21> getUai21s() {
		return uai21s;
	}
	public void setUai21s(List<Uai21> uai21s) {
		this.uai21s = uai21s;
	}
	public Uai4 getUai4() {
		return uai4;
	}
	public void setUai4(Uai4 uai4) {
		this.uai4 = uai4;
	}
	public Uai3 getUai3() {
		return uai3;
	}
	public void setUai3(Uai3 uai3) {
		this.uai3 = uai3;
	}
	public Omfq getOmfq() {
		return omfq;
	}
	public void setOmfq(Omfq omfq) {
		this.omfq = omfq;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	public String getQustTagName(){
		return SingleAnswerStatusEnum.getEnumByCode(this.qustTag).getName();
	}
	
	public int getMemberAge(){
		try {
			if(this.member != null)
				return TimeUtil.getAge(this.member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Integer getCombQustId() {
		return combQustId;
	}
	public void setCombQustId(Integer combQustId) {
		this.combQustId = combQustId;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	/**
	 * mSETaskID.
	 *
	 * @return  the mSETaskID 
	 */
	public Long getMSETaskID() {
		return MSETaskID;
	}
	/**
	 * mSETaskID.
	 *
	 * @param   mSETaskID    the mSETaskID to set 
	 */
	public void setMSETaskID(Long mSETaskID) {
		MSETaskID = mSETaskID;
	}
	/**
	 * source.
	 *
	 * @return  the source 
	 */
	public String getSource() {
		return source;
	}
	/**
	 * source.
	 *
	 * @param   source    the source to set 
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * isComAnswer.
	 *
	 * @return  the isComAnswer 
	 */
	public Boolean getIsComAnswer() {
		return isComAnswer;
	}
	/**
	 * isComAnswer.
	 *
	 * @param   isComAnswer    the isComAnswer to set 
	 */
	public void setIsComAnswer(Boolean isComAnswer) {
		this.isComAnswer = isComAnswer;
	}
	
	
	
}