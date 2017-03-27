 
/**
 * @PackageName:      com.bithealth.measureCore.model
 * @FileName:     ImageParam.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月18日 下午5:25:15  
 * 
 */

package com.bithealth.measureCore.common.model;

import java.util.Date;


/**
 * 类名称: ImageParam  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月18日 下午5:25:15 
 * 
 * @author 陈哲
 * @version  
 */
public class ImageParam {
	
	private String type;

    private String rawImage;
    
    private int fs;
    
    private int page;
    
    private Date measureTime;
    
    private int width;
    
    private int height;
    
    private String deviceCode;
    
    private int showTimeLength;
    
    private int totalPage;
    
    private boolean timeQuery;
    
    private int startTimeQueryDis;//心电图测量，以时间为条件加载心电图，起始时间条件到心电测量时间的长度，时间单位秒
    
    private int endTimeQueryDis;//心电图测量，以时间为条件加载心电图，时间条件查询的心电长度，时间单位秒

	/**
	 * type.
	 *
	 * @return  the type 
	 */
	public String getType() {
		return type;
	}

	/**
	 * type.
	 *
	 * @param   type    the type to set 
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * rawImage.
	 *
	 * @return  the rawImage 
	 */
	public String getRawImage() {
		return rawImage;
	}

	/**
	 * rawImage.
	 *
	 * @param   rawImage    the rawImage to set 
	 */
	public void setRawImage(String rawImage) {
		this.rawImage = rawImage;
	}

	/**
	 * fs.
	 *
	 * @return  the fs 
	 */
	public int getFs() {
		return fs;
	}

	/**
	 * fs.
	 *
	 * @param   fs    the fs to set 
	 */
	public void setFs(int fs) {
		this.fs = fs;
	}

	/**
	 * page.
	 *
	 * @return  the page 
	 */
	public int getPage() {
		return page;
	}

	/**
	 * page.
	 *
	 * @param   page    the page to set 
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * measureTime.
	 *
	 * @return  the measureTime 
	 */
	public Date getMeasureTime() {
		return measureTime;
	}

	/**
	 * measureTime.
	 *
	 * @param   measureTime    the measureTime to set 
	 */
	public void setMeasureTime(Date measureTime) {
		this.measureTime = measureTime;
	}

	/**
	 * width.
	 *
	 * @return  the width 
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * width.
	 *
	 * @param   width    the width to set 
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * height.
	 *
	 * @return  the height 
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * height.
	 *
	 * @param   height    the height to set 
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * deviceCode.
	 *
	 * @return  the deviceCode 
	 */
	public String getDeviceCode() {
		return deviceCode;
	}

	/**
	 * deviceCode.
	 *
	 * @param   deviceCode    the deviceCode to set 
	 */
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	/**
	 * showTimeLength.
	 *
	 * @return  the showTimeLength 
	 */
	public int getShowTimeLength() {
		return showTimeLength;
	}

	/**
	 * showTimeLength.
	 *
	 * @param   showTimeLength    the showTimeLength to set 
	 */
	public void setShowTimeLength(int showTimeLength) {
		this.showTimeLength = showTimeLength;
	}

	/**
	 * totalPage.
	 *
	 * @return  the totalPage 
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * totalPage.
	 *
	 * @param   totalPage    the totalPage to set 
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * timeQuery.
	 *
	 * @return  the timeQuery 
	 */
	public boolean isTimeQuery() {
		return timeQuery;
	}

	/**
	 * timeQuery.
	 *
	 * @param   timeQuery    the timeQuery to set 
	 */
	public void setTimeQuery(boolean timeQuery) {
		this.timeQuery = timeQuery;
	}

	/**
	 * startTimeQueryDis.
	 *
	 * @return  the startTimeQueryDis 
	 */
	public int getStartTimeQueryDis() {
		return startTimeQueryDis;
	}

	/**
	 * startTimeQueryDis.
	 *
	 * @param   startTimeQueryDis    the startTimeQueryDis to set 
	 */
	public void setStartTimeQueryDis(int startTimeQueryDis) {
		this.startTimeQueryDis = startTimeQueryDis;
	}

	/**
	 * endTimeQueryDis.
	 *
	 * @return  the endTimeQueryDis 
	 */
	public int getEndTimeQueryDis() {
		return endTimeQueryDis;
	}

	/**
	 * endTimeQueryDis.
	 *
	 * @param   endTimeQueryDis    the endTimeQueryDis to set 
	 */
	public void setEndTimeQueryDis(int endTimeQueryDis) {
		this.endTimeQueryDis = endTimeQueryDis;
	}
	
}

