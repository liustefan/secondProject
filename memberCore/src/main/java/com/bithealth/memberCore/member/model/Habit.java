/*
 * Habit.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员习惯信息（MEM7）
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class Habit extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 9176158005058976357L;
	/**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 是否抽烟
     */
    private String smoking;
    /**
     * 是否喝酒
     */
    private String dodrink;
    /**
     * 不喜欢的食品
     */
    private String dontfood;
    /**
     * 主食
     */
    private String staplefood;
    /**
     * 睡眠状况
     */
    private String sleepcond;
    /**
     * 喜欢的运动
     */
    private String likesports;
    /**
     * 运动时长
     */
    private String movelong;
    /**
     * 时间间段
     */
    private String timeseg;
    /**
     * 每周几次
     */
    private Short weeknumtimes;

    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public String getSmoking() {
        return smoking;
    }
    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }
    public String getDodrink() {
        return dodrink;
    }
    public void setDodrink(String dodrink) {
        this.dodrink = dodrink;
    }
    public String getDontfood() {
        return dontfood;
    }
    public void setDontfood(String dontfood) {
        this.dontfood = dontfood;
    }
    public String getStaplefood() {
        return staplefood;
    }
    public void setStaplefood(String staplefood) {
        this.staplefood = staplefood;
    }
    public String getSleepcond() {
        return sleepcond;
    }
    public void setSleepcond(String sleepcond) {
        this.sleepcond = sleepcond;
    }
    public String getLikesports() {
        return likesports;
    }
    public void setLikesports(String likesports) {
        this.likesports = likesports;
    }
    public String getMovelong() {
        return movelong;
    }
    public void setMovelong(String movelong) {
        this.movelong = movelong;
    }
    public String getTimeseg() {
        return timeseg;
    }
    public void setTimeseg(String timeseg) {
        this.timeseg = timeseg;
    }
    public Short getWeeknumtimes() {
        return weeknumtimes;
    }
    public void setWeeknumtimes(Short weeknumtimes) {
        this.weeknumtimes = weeknumtimes;
    }
}