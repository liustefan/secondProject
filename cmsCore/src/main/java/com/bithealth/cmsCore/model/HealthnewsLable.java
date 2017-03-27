/*
 * HealthnewsLable.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.cmsCore.model;

import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [2.1]健康资讯_标签表
 * 
 * @author ${user}
 * @version 1.0 2016-08-18
 */
public class HealthnewsLable extends GenericModel {

    /**
	 * 序列化id
	 */
	private static final long serialVersionUID = -2767999738534543778L;
	/**
     * 健康资讯_标签ID
     */
    private Integer hnlabelid;
    /**
     * 内容
     */
    private String content;
    /**
     * 状态：1-新建，2-已启用，3-已禁用
     */
    private Byte statustype;
    /**
     * 创建者ID
     */
    private Integer createid;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 更新者ID
     */
    private Integer updateid;
    /**
     * 更新时间
     */
    private Date updatetime;
    
    private Date startCreatetime;
    
    private Date endCreatetime;
    
    private Doctor doctor;
    
    private MemberLabel memberLabel;
    
    private Member member;

    public Integer getHnlabelid() {
        return hnlabelid;
    }
    public void setHnlabelid(Integer hnlabelid) {
        this.hnlabelid = hnlabelid;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Byte getStatustype() {
        return statustype;
    }
    public void setStatustype(Byte statustype) {
        this.statustype = statustype;
    }
    public Integer getCreateid() {
        return createid;
    }
    public void setCreateid(Integer createid) {
        this.createid = createid;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Integer getUpdateid() {
        return updateid;
    }
    public void setUpdateid(Integer updateid) {
        this.updateid = updateid;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
	public Date getStartCreatetime() {
		return startCreatetime;
	}
	public void setStartCreatetime(Date startCreatetime) {
		this.startCreatetime = startCreatetime;
	}
	public Date getEndCreatetime() {
		return endCreatetime;
	}
	public void setEndCreatetime(Date endCreatetime) {
		this.endCreatetime = endCreatetime;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public MemberLabel getMemberLabel() {
		return memberLabel;
	}
	public void setMemberLabel(MemberLabel memberLabel) {
		this.memberLabel = memberLabel;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}