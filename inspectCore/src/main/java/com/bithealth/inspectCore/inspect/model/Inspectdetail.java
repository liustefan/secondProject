 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.model
 * @FileName:     Inspectdetail.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月11日 下午3:10:40  
 * 
 */

package com.bithealth.inspectCore.inspect.model;

import java.math.BigDecimal;

import com.bithealth.inspectCore.model.DictEntity;


/**
 * 类名称: Inspectdetail  
 * 功能描述: TODO 随访详情公用字段  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月11日 下午3:10:40 
 * 
 * @author baozj
 * @version  
 */
public class Inspectdetail extends DictEntity {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 2673498756600060251L;

    /**
     * 体征_身高(cm)
     */
    private BigDecimal height;
    /**
     * 体征_当前体重(kg)
     */
    private BigDecimal weight;
    /**
     * 体征_下次目标体重(kg)
     */
    private BigDecimal weight_Next;
    /**
     * 体征_当前体质指数
     */
    private BigDecimal BMI;
    /**
     * 体征_下次目标体质指数
     */
    private BigDecimal BMI_Next;
    /**
     * 生活方式指导_当前日吸烟量(支)
     */
    private Short dailySmoking;
    /**
     * 生活方式指导_下次目标日吸烟量(支)
     */
    private Short dailySmoking_Next;
    /**
     * 生活方式指导_当前日饮酒量(两)
     */
    private BigDecimal dailyDrink;
    /**
     * 生活方式指导_下次目标日饮酒量(两)
     */
    private BigDecimal dailyDrink_Next;
    /**
     * 生活方式指导_当前运动频率(次/周)
     */
    private String sportFrequency;
    /**
     * 生活方式指导_下次目标运动频率(次/周)
     */
    private String sportFrequency_Next;
    /**
     * 生活方式指导_当前时长(分钟/次)
     */
    private Short sportDuration;
    /**
     * 生活方式指导_下次目标时长(分钟/次)
     */
    private Short sportDuration_Next;
    /**
     * 体征_收缩压(mmHg)
     */
    private Short systolic;
    /**
     * 体征_舒张压(mmHg)
     */
    private Short diastolic;
    
    public BigDecimal getHeight() {
        return height;
    }
    public void setHeight(BigDecimal height) {
        this.height = height;
    }
    public BigDecimal getWeight() {
        return weight;
    }
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    public BigDecimal getWeight_Next() {
        return weight_Next;
    }
    public void setWeight_Next(BigDecimal weight_Next) {
        this.weight_Next = weight_Next;
    }
    public BigDecimal getBMI() {
        return BMI;
    }
    public void setBMI(BigDecimal BMI) {
        this.BMI = BMI;
    }
    public BigDecimal getBMI_Next() {
        return BMI_Next;
    }
    public void setBMI_Next(BigDecimal BMI_Next) {
        this.BMI_Next = BMI_Next;
    }
    public Short getDailySmoking() {
        return dailySmoking;
    }
    public void setDailySmoking(Short dailySmoking) {
        this.dailySmoking = dailySmoking;
    }
    public Short getDailySmoking_Next() {
        return dailySmoking_Next;
    }
    public void setDailySmoking_Next(Short dailySmoking_Next) {
        this.dailySmoking_Next = dailySmoking_Next;
    }
    public BigDecimal getDailyDrink() {
        return dailyDrink;
    }
    public void setDailyDrink(BigDecimal dailyDrink) {
        this.dailyDrink = dailyDrink;
    }
    public BigDecimal getDailyDrink_Next() {
        return dailyDrink_Next;
    }
    public void setDailyDrink_Next(BigDecimal dailyDrink_Next) {
        this.dailyDrink_Next = dailyDrink_Next;
    }
    public String getSportFrequency() {
        return sportFrequency;
    }
    public void setSportFrequency(String sportFrequency) {
        this.sportFrequency = sportFrequency;
    }
    public String getSportFrequency_Next() {
        return sportFrequency_Next;
    }
    public void setSportFrequency_Next(String sportFrequency_Next) {
        this.sportFrequency_Next = sportFrequency_Next;
    }
    public Short getSportDuration() {
        return sportDuration;
    }
    public void setSportDuration(Short sportDuration) {
        this.sportDuration = sportDuration;
    }
    public Short getSportDuration_Next() {
        return sportDuration_Next;
    }
    public void setSportDuration_Next(Short sportDuration_Next) {
        this.sportDuration_Next = sportDuration_Next;
    }
    public Short getSystolic() {
        return systolic;
    }
    public void setSystolic(Short systolic) {
        this.systolic = systolic;
    }
    public Short getDiastolic() {
        return diastolic;
    }
    public void setDiastolic(Short diastolic) {
        this.diastolic = diastolic;
    }
}

