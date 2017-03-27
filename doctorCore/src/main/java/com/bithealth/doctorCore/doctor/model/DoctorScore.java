/*
 * DoctorScore.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.doctor.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 医生积分表（DOC2）
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class DoctorScore extends GenericModel {

    /**
     * 医生代码
     */
    private Integer docid;
    /**
     * 本月积分
     */
    private Integer monintegral;
    /**
     * 累计积分
     */
    private Integer accintegral;
    /**
     * 本月报告数
     */
    private Integer monreport;
    /**
     * 累计报告数
     */
    private Integer accreport;
    /**
     * 本月回复咨询
     */
    private Integer monreply;
    /**
     * 累计回复咨询
     */
    private Integer accreply;

    public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public Integer getMonintegral() {
        return monintegral;
    }
    public void setMonintegral(Integer monintegral) {
        this.monintegral = monintegral;
    }
    public Integer getAccintegral() {
        return accintegral;
    }
    public void setAccintegral(Integer accintegral) {
        this.accintegral = accintegral;
    }
    public Integer getMonreport() {
        return monreport;
    }
    public void setMonreport(Integer monreport) {
        this.monreport = monreport;
    }
    public Integer getAccreport() {
        return accreport;
    }
    public void setAccreport(Integer accreport) {
        this.accreport = accreport;
    }
    public Integer getMonreply() {
        return monreply;
    }
    public void setMonreply(Integer monreply) {
        this.monreply = monreply;
    }
    public Integer getAccreply() {
        return accreply;
    }
    public void setAccreply(Integer accreply) {
        this.accreply = accreply;
    }
}