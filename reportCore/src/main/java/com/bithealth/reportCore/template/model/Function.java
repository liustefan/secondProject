/*
 * Function.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 分组功能表
 * 
 * @author ${user}
 * @version 1.0 2016-07-14
 */
public class Function extends GenericModel {

    /**
     * 功能代码
     */
    private Short funId;
    /**
     * 功能名称
     */
    private String funName;
    /**
     * 功能名称
     */
    private String funDes;
    /**
     * 标记
     */
    private String tag;

    public Short getFunId() {
        return funId;
    }
    public void setFunId(Short funId) {
        this.funId = funId;
    }
    public String getFunName() {
        return funName;
    }
    public void setFunName(String funName) {
        this.funName = funName;
    }
    public String getFunDes() {
        return funDes;
    }
    public void setFunDes(String funDes) {
        this.funDes = funDes;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}