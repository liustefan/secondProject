/*
 * HealthnewsInfo.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.cmsCore.model;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [2.1]健康资讯_信息表
 * 
 * @author ${user}
 * @version 1.0 2016-08-18
 */
public class HealthnewsInfo extends GenericModel {

    /**
	 * 序列化id
	 */
	private static final long serialVersionUID = 7554496079737707676L;
	/**
     * 健康资讯_信息ID
     */
    private Integer hninfoid;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 缩略图路径
     */
    private String thumbnail;
    /**
     * 封面图路径
     */
    private String coverimage;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否置顶：0-否，1-是o
     */
    private Byte isstickypost;
    /**
     * 状态：1-新建，2-已发布，3-已推送，4-已删除
     */
    private Byte statustype;
    /**
     * 发布时间
     */
    private Date releasetime;
    /**
     * 生效时间
     */
    private Date takeeffecttime;
    /**
     * 已推送的删除原因
     */
    private String delreason;
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
    
    private Date startReleasetime;
    
    private Date endReleasetime;
    
    private Date startUpdatetime;
    
    private Date endUpdatetime;
    
    private MultipartFile thumbnailFile;
    
    private MultipartFile coverimageFile;
    
    private List<HealthnewsLable> healthnewsLables;
    
    private Doctor doctor;

    public Integer getHninfoid() {
        return hninfoid;
    }
    public void setHninfoid(Integer hninfoid) {
        this.hninfoid = hninfoid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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
    public Byte getIsstickypost() {
        return isstickypost;
    }
    public void setIsstickypost(Byte isstickypost) {
        this.isstickypost = isstickypost;
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
    public Date getTakeeffecttime() {
        return takeeffecttime;
    }
    public void setTakeeffecttime(Date takeeffecttime) {
        this.takeeffecttime = takeeffecttime;
    }
    public String getDelreason() {
        return delreason;
    }
    public void setDelreason(String delreason) {
        this.delreason = delreason;
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
	
	public Date getStartUpdatetime() {
		return startUpdatetime;
	}
	public void setStartUpdatetime(Date startUpdatetime) {
		this.startUpdatetime = startUpdatetime;
	}
	public Date getEndUpdatetime() {
		return endUpdatetime;
	}
	public void setEndUpdatetime(Date endUpdatetime) {
		this.endUpdatetime = endUpdatetime;
	}
	public MultipartFile getThumbnailFile() {
		return thumbnailFile;
	}
	public void setThumbnailFile(MultipartFile thumbnailFile) {
		this.thumbnailFile = thumbnailFile;
	}
	public MultipartFile getCoverimageFile() {
		return coverimageFile;
	}
	public void setCoverimageFile(MultipartFile coverimageFile) {
		this.coverimageFile = coverimageFile;
	}
	public List<HealthnewsLable> getHealthnewsLables() {
		return healthnewsLables;
	}
	public void setHealthnewsLables(List<HealthnewsLable> healthnewsLables) {
		this.healthnewsLables = healthnewsLables;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
}