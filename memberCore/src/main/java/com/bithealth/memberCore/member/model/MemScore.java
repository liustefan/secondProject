/*
 * MemScore.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class MemScore extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -2033815357268717115L;
	private Integer id;
    private Integer memberid;
    private Integer score;
    private String uploadtime;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public String getUploadtime() {
        return uploadtime;
    }
    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }
}