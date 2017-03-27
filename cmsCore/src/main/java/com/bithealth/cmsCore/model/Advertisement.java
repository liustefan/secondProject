/*
 * Advertisement.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.cmsCore.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [2.1]广告表
 * 
 * @author ${user}
 * @version 1.0 2016-08-18
 */
public class Advertisement extends GenericModel {

    /**
	 * 序列化id
	 */
	private static final long serialVersionUID = -4880621616921279497L;
	/**
     * 广告ID
     */
    private Integer aid;
    /**
     * 标题
     */
    private String title;
    /**
     * 封面图路径
     */
    private String coverimage;
    /**
     * 内容
     */
    private String content;
    /**
     * 使用页面：1-App首页，2-App健康中心，3-App选择测量工具
     */
    private Byte usepage;
    /**
     * 状态：1-新建，2-已发布
     */
    private Byte statustype;
    /**
     * 发布时间
     */
    private Date releasetime;
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
    
    private MultipartFile coverimageFile;
    
    private Date startReleasetime;
    
    private Date endReleasetime;
    
    private Doctor doctor;
    
    public Date getStartReleasetime() {
		return startReleasetime;
	}
	public void setStartReleasetime(Date startReleasetime) {
		this.startReleasetime = startReleasetime;
	}
	public Date getEndReleasetime() {
		return endReleasetime;
	}
	public void setEndReleasetime(Date endReleasetime) {
		this.endReleasetime = endReleasetime;
	}
	public Integer getAid() {
        return aid;
    }
    public void setAid(Integer aid) {
        this.aid = aid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCoverimage() {
        return coverimage;
    }
    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Byte getUsepage() {
        return usepage;
    }
    public void setUsepage(Byte usepage) {
        this.usepage = usepage;
    }
    public Byte getStatustype() {
        return statustype;
    }
    public void setStatustype(Byte statustype) {
        this.statustype = statustype;
    }
    public Date getReleasetime() {
        return releasetime;
    }
    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
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
	public MultipartFile getCoverimageFile() {
		return coverimageFile;
	}
	public void setCoverimageFile(MultipartFile coverimageFile) {
		this.coverimageFile = coverimageFile;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
    
}