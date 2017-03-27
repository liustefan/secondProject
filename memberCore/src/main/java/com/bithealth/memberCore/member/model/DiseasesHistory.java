/*
 * DiseasesHistory.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 疾病史(MEM3)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class DiseasesHistory extends DiseasesHistoryKey {

	private static final long serialVersionUID = 3948092909639597490L;
	/**
     * 疾病ID，来源字典
     */
    private Integer diseaseid;
    /**
     * 疾病名称
     */
    private String diseasename;
    /**
     * 确诊时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date diagtime;
    /**
     * 既往标记 (N : 现病史  ,Y : 既往病史)
     */
    private String protag;
    /**
     * 创建时间
     */
    private Date createtime;

    public Integer getDiseaseid() {
        return diseaseid;
    }
    public void setDiseaseid(Integer diseaseid) {
        this.diseaseid = diseaseid;
    }
    public String getDiseasename() {
        return diseasename;
    }
    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }
    public Date getDiagtime() {
        return diagtime;
    }
    public void setDiagtime(Date diagtime) {
        this.diagtime = diagtime;
    }
    public String getProtag() {
        return protag;
    }
    public void setProtag(String protag) {
        this.protag = protag;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}