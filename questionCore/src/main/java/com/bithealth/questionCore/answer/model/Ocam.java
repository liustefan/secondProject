/*
 * Ocam.java
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
import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.enmu.ComAnswerStatusEnum;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员组合答卷主表（OCAM）
 * 
 * @author ${user}
 * @version 1.0 2016-07-18
 */
public class Ocam extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -2971154300583436344L;
	/**
     * 组合答卷ID
     */
    private Integer combAnsid;
    /**
     * 组合答卷ID
     */
    private Integer combQustid;
    /**
     * 组合问卷名称
     */
    private String combQustName;
    /**
     * 组合问卷编号
     */
    private Integer combQustCode;
    /**
     * 组合介绍
     */
    private String combDesc;
    /**
     * 发放时间
     */
    private Date publisherTime;
    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 是否审核
Y : 审核，N ：免审
     */
    private String chTag;
    /**
     * [2.0.4]组合答卷状态：0-未完成，1-已完成正在审核中，2-审核完成 3-作答中
     */
    private String combTag;
    /**
     * 评定日期
     */
    private Date assessDate;
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
    
    private List<Cam1> cam1s;
    
    private Cam2 cam2;
    
    private Ocqt ocqt;
    
    private Member member;
    
    private Short optId;
    
    private String optName;
    
    private List<Ouai> ouais;
    
    private Doctor doctor;
    
    public Integer getCombAnsid() {
        return combAnsid;
    }
    public void setCombAnsid(Integer combAnsid) {
        this.combAnsid = combAnsid;
    }
    public Integer getCombQustid() {
        return combQustid;
    }
    public void setCombQustid(Integer combQustid) {
        this.combQustid = combQustid;
    }
    public String getCombQustName() {
        return combQustName;
    }
    public void setCombQustName(String combQustName) {
        this.combQustName = combQustName;
    }
    public Integer getCombQustCode() {
        return combQustCode;
    }
    public void setCombQustCode(Integer combQustCode) {
        this.combQustCode = combQustCode;
    }
    public String getCombDesc() {
        return combDesc;
    }
    public void setCombDesc(String combDesc) {
        this.combDesc = combDesc;
    }
    public Date getPublisherTime() {
        return publisherTime;
    }
    public void setPublisherTime(Date publisherTime) {
        this.publisherTime = publisherTime;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public String getChTag() {
        return chTag;
    }
    public void setChTag(String chTag) {
        this.chTag = chTag;
    }
    public String getCombTag() {
        return combTag;
    }
    public void setCombTag(String combTag) {
        this.combTag = combTag;
    }
    public Date getAssessDate() {
        return assessDate;
    }
    public void setAssessDate(Date assessDate) {
        this.assessDate = assessDate;
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
	public Cam2 getCam2() {
		return cam2;
	}
	public void setCam2(Cam2 cam2) {
		this.cam2 = cam2;
	}
	public List<Cam1> getCam1s() {
		return cam1s;
	}
	public void setCam1s(List<Cam1> cam1s) {
		this.cam1s = cam1s;
	}
	public Ocqt getOcqt() {
		return ocqt;
	}
	public void setOcqt(Ocqt ocqt) {
		this.ocqt = ocqt;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Short getOptId() {
		return optId;
	}
	public void setOptId(Short optId) {
		this.optId = optId;
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
    
	public String getCombTagName(){
		ComAnswerStatusEnum enu = ComAnswerStatusEnum.getEnumByCode(this.combTag);
		return enu != null ? enu.getName() : null;
	}
	public List<Ouai> getOuais() {
		return ouais;
	}
	public void setOuais(List<Ouai> ouais) {
		this.ouais = ouais;
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
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}