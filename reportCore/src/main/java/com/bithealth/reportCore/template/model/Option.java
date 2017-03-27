/*
 * Option.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

/**
 * 选项表(OOPT)
 * 
 * @author ${user}
 * @version 1.0 2016-07-14
 */
public class Option extends OptionKey {

    /**
     * 选项名称
     */
    private String optName;
    /**
     * 选项说明
     */
    private String optDes;
    /**
     * 审核级数
     */
    private Short CHLevel;
    /**
     * 标记
     */
    private String tag;
    private Integer orgid;

    public String getOptName() {
        return optName;
    }
    public void setOptName(String optName) {
        this.optName = optName;
    }
    public String getOptDes() {
        return optDes;
    }
    public void setOptDes(String optDes) {
        this.optDes = optDes;
    }
    public Short getCHLevel() {
        return CHLevel;
    }
    public void setCHLevel(Short CHLevel) {
        this.CHLevel = CHLevel;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
}