/*
 * MemImportLog.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-14 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [2.1]会员导入记录表
 * 
 * @author ${user}
 * @version 1.0 2016-12-14
 */
public class MemImportLog extends GenericModel {

    /**
     * 记录ID
     */
    private Long logID;
    /**
     * 会员GUID
     */
    private String memberGUID;
    /**
     * 导入批次GUID
     */
    private String importBatchGUID;
    /**
     * 导入时间
     */
    private Date importTime;
    /**
     * 原因
     */
    private String reason;
    /**
     * 使用tag：T-有效，F-无效
     */
    private String useTag;
    /**
     * 同步时间戳
     */
    private Long syncTimestamp;
    /**
     * 内容
     */
    private String content;
    /**
     * [3.0]来源类型：1-Web，2-App
     */
    private Byte sourceType = 1;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getLogID() {
        return logID;
    }
    public void setLogID(Long logID) {
        this.logID = logID;
    }
    public String getMemberGUID() {
        return memberGUID;
    }
    public void setMemberGUID(String memberGUID) {
        this.memberGUID = memberGUID;
    }
    public String getImportBatchGUID() {
        return importBatchGUID;
    }
    public void setImportBatchGUID(String importBatchGUID) {
        this.importBatchGUID = importBatchGUID;
    }
    public Date getImportTime() {
        return importTime;
    }
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getUseTag() {
        return useTag;
    }
    public void setUseTag(String useTag) {
        this.useTag = useTag;
    }
    public Long getSyncTimestamp() {
        return syncTimestamp;
    }
    public void setSyncTimestamp(Long syncTimestamp) {
        this.syncTimestamp = syncTimestamp;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Byte getSourceType() {
        return sourceType;
    }
    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}