/*
 * AdvertisementExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.cmsCore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bithealth.sdk.common.utils.StringUtil;


public class AdvertisementExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public AdvertisementExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    public String getOrderByClause() {
        return orderByClause;
    }
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    public boolean isDistinct() {
        return distinct;
    }
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * [2.1]广告表
     * 
     * @author ${user}
     * @version 1.0 2016-08-18
     */
    protected abstract static class GeneratedCriteria {

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }
        public boolean isValid() {
            return criteria.size() > 0;
        }
        public List<Criterion> getAllCriteria() {
            return criteria;
        }
        public List<Criterion> getCriteria() {
            return criteria;
        }
        protected void addCriterion(String condition) {
            if (condition == null) {
                  return;//
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                  return;//
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                  return;//
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andAidIsNull() {
            addCriterion("AID is null");
            return (Criteria) this;
        }
        public Criteria andAidIsNotNull() {
            addCriterion("AID is not null");
            return (Criteria) this;
        }
        public Criteria andAidEqualTo(Integer value) {
            addCriterion("AID =", value, "aid");
            return (Criteria) this;
        }
        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("AID <>", value, "aid");
            return (Criteria) this;
        }
        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("AID >", value, "aid");
            return (Criteria) this;
        }
        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AID >=", value, "aid");
            return (Criteria) this;
        }
        public Criteria andAidLessThan(Integer value) {
            addCriterion("AID <", value, "aid");
            return (Criteria) this;
        }
        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("AID <=", value, "aid");
            return (Criteria) this;
        }
        public Criteria andAidIn(List<Integer> values) {
            addCriterion("AID in", values, "aid");
            return (Criteria) this;
        }
        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("AID not in", values, "aid");
            return (Criteria) this;
        }
        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("AID between", value1, value2, "aid");
            return (Criteria) this;
        }
        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("AID not between", value1, value2, "aid");
            return (Criteria) this;
        }
        public Criteria andTitleIsNull() {
            addCriterion("tb_advertisement.Title is null");
            return (Criteria) this;
        }
        public Criteria andTitleIsNotNull() {
            addCriterion("tb_advertisement.Title is not null");
            return (Criteria) this;
        }
        public Criteria andTitleEqualTo(String value) {
            addCriterion("tb_advertisement.Title =", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("tb_advertisement.Title <>", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThan(String value) {
            addCriterion("tb_advertisement.Title >", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("tb_advertisement.Title >=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThan(String value) {
            addCriterion("tb_advertisement.Title <", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("tb_advertisement.Title <=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLike(String value) {
        	if (StringUtil.isNotEmpty(value))
            addCriterion("tb_advertisement.Title like", "%"+value+"%", "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotLike(String value) {
            addCriterion("tb_advertisement.Title not like", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleIn(List<String> values) {
            addCriterion("tb_advertisement.Title in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("tb_advertisement.Title not in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("tb_advertisement.Title between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("tb_advertisement.Title not between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andCoverimageIsNull() {
            addCriterion("CoverImage is null");
            return (Criteria) this;
        }
        public Criteria andCoverimageIsNotNull() {
            addCriterion("CoverImage is not null");
            return (Criteria) this;
        }
        public Criteria andCoverimageEqualTo(String value) {
            addCriterion("CoverImage =", value, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageNotEqualTo(String value) {
            addCriterion("CoverImage <>", value, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageGreaterThan(String value) {
            addCriterion("CoverImage >", value, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageGreaterThanOrEqualTo(String value) {
            addCriterion("CoverImage >=", value, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageLessThan(String value) {
            addCriterion("CoverImage <", value, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageLessThanOrEqualTo(String value) {
            addCriterion("CoverImage <=", value, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageLike(String value) {
            addCriterion("CoverImage like", value, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageNotLike(String value) {
            addCriterion("CoverImage not like", value, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageIn(List<String> values) {
            addCriterion("CoverImage in", values, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageNotIn(List<String> values) {
            addCriterion("CoverImage not in", values, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageBetween(String value1, String value2) {
            addCriterion("CoverImage between", value1, value2, "coverimage");
            return (Criteria) this;
        }
        public Criteria andCoverimageNotBetween(String value1, String value2) {
            addCriterion("CoverImage not between", value1, value2, "coverimage");
            return (Criteria) this;
        }
        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }
        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }
        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andUsepageIsNull() {
            addCriterion("UsePage is null");
            return (Criteria) this;
        }
        public Criteria andUsepageIsNotNull() {
            addCriterion("UsePage is not null");
            return (Criteria) this;
        }
        public Criteria andUsepageEqualTo(Byte value) {
            addCriterion("UsePage =", value, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageNotEqualTo(Byte value) {
            addCriterion("UsePage <>", value, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageGreaterThan(Byte value) {
            addCriterion("UsePage >", value, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageGreaterThanOrEqualTo(Byte value) {
            addCriterion("UsePage >=", value, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageLessThan(Byte value) {
            addCriterion("UsePage <", value, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageLessThanOrEqualTo(Byte value) {
            addCriterion("UsePage <=", value, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageIn(List<Byte> values) {
            addCriterion("UsePage in", values, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageNotIn(List<Byte> values) {
            addCriterion("UsePage not in", values, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageBetween(Byte value1, Byte value2) {
            addCriterion("UsePage between", value1, value2, "usepage");
            return (Criteria) this;
        }
        public Criteria andUsepageNotBetween(Byte value1, Byte value2) {
            addCriterion("UsePage not between", value1, value2, "usepage");
            return (Criteria) this;
        }
        public Criteria andStatustypeIsNull() {
            addCriterion("tb_advertisement.StatusType is null");
            return (Criteria) this;
        }
        public Criteria andStatustypeIsNotNull() {
            addCriterion("tb_advertisement.StatusType is not null");
            return (Criteria) this;
        }
        public Criteria andStatustypeEqualTo(Byte value) {
            addCriterion("tb_advertisement.StatusType =", value, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeNotEqualTo(Byte value) {
            addCriterion("tb_advertisement.StatusType <>", value, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeGreaterThan(Byte value) {
            addCriterion("tb_advertisement.StatusType >", value, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("tb_advertisement.StatusType >=", value, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeLessThan(Byte value) {
            addCriterion("tb_advertisement.StatusType <", value, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeLessThanOrEqualTo(Byte value) {
            addCriterion("tb_advertisement.StatusType <=", value, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeIn(List<Byte> values) {
            addCriterion("tb_advertisement.StatusType in", values, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeNotIn(List<Byte> values) {
            addCriterion("tb_advertisement.StatusType not in", values, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeBetween(Byte value1, Byte value2) {
            addCriterion("tb_advertisement.StatusType between", value1, value2, "statustype");
            return (Criteria) this;
        }
        public Criteria andStatustypeNotBetween(Byte value1, Byte value2) {
            addCriterion("tb_advertisement.StatusType not between", value1, value2, "statustype");
            return (Criteria) this;
        }
        public Criteria andReleasetimeIsNull() {
            addCriterion("tb_advertisement.ReleaseTime is null");
            return (Criteria) this;
        }
        public Criteria andReleasetimeIsNotNull() {
            addCriterion("tb_advertisement.ReleaseTime is not null");
            return (Criteria) this;
        }
        public Criteria andReleasetimeEqualTo(Date value) {
            addCriterion("tb_advertisement.ReleaseTime =", value, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeNotEqualTo(Date value) {
            addCriterion("tb_advertisement.ReleaseTime <>", value, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeGreaterThan(Date value) {
            addCriterion("tb_advertisement.ReleaseTime >", value, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tb_advertisement.ReleaseTime >=", value, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeLessThan(Date value) {
            addCriterion("tb_advertisement.ReleaseTime <", value, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeLessThanOrEqualTo(Date value) {
            addCriterion("tb_advertisement.ReleaseTime <=", value, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeIn(List<Date> values) {
            addCriterion("tb_advertisement.ReleaseTime in", values, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeNotIn(List<Date> values) {
            addCriterion("tb_advertisement.ReleaseTime not in", values, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeBetween(Date value1, Date value2) {
            addCriterion("tb_advertisement.ReleaseTime between", value1, value2, "releasetime");
            return (Criteria) this;
        }
        public Criteria andReleasetimeNotBetween(Date value1, Date value2) {
            addCriterion("tb_advertisement.ReleaseTime not between", value1, value2, "releasetime");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNull() {
            addCriterion("CreateID is null");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNotNull() {
            addCriterion("CreateID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateidEqualTo(Integer value) {
            addCriterion("CreateID =", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotEqualTo(Integer value) {
            addCriterion("CreateID <>", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThan(Integer value) {
            addCriterion("CreateID >", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateID >=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThan(Integer value) {
            addCriterion("CreateID <", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThanOrEqualTo(Integer value) {
            addCriterion("CreateID <=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidIn(List<Integer> values) {
            addCriterion("CreateID in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotIn(List<Integer> values) {
            addCriterion("CreateID not in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidBetween(Integer value1, Integer value2) {
            addCriterion("CreateID between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateID not between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }
        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andUpdateidIsNull() {
            addCriterion("UpdateID is null");
            return (Criteria) this;
        }
        public Criteria andUpdateidIsNotNull() {
            addCriterion("UpdateID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateidEqualTo(Integer value) {
            addCriterion("UpdateID =", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotEqualTo(Integer value) {
            addCriterion("UpdateID <>", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidGreaterThan(Integer value) {
            addCriterion("UpdateID >", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateID >=", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidLessThan(Integer value) {
            addCriterion("UpdateID <", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateID <=", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidIn(List<Integer> values) {
            addCriterion("UpdateID in", values, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotIn(List<Integer> values) {
            addCriterion("UpdateID not in", values, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID between", value1, value2, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID not between", value1, value2, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [2.1]广告表
     * 
     * @author ${user}
     * @version 1.0 2016-08-18
     */
    public static class Criterion {

        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return condition;
        }
        public Object getValue() {
            return value;
        }
        public Object getSecondValue() {
            return secondValue;
        }
        public boolean isNoValue() {
            return noValue;
        }
        public boolean isSingleValue() {
            return singleValue;
        }
        public boolean isBetweenValue() {
            return betweenValue;
        }
        public boolean isListValue() {
            return listValue;
        }
        public String getTypeHandler() {
            return typeHandler;
        }
        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }
        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }
        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}