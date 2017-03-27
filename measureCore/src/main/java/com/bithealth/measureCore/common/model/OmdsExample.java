/*
 * OmdsExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-22 Created
 */
package com.bithealth.measureCore.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmdsExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OmdsExample() {
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
     * 测量数据记录表（OMDS）
     * 
     * @author ${user}
     * @version 1.0 2016-08-22
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
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (Criteria) this;
        }
        public Criteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (Criteria) this;
        }
        public Criteria andEventidEqualTo(Long value) {
            addCriterion("eventid =", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidNotEqualTo(Long value) {
            addCriterion("eventid <>", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidGreaterThan(Long value) {
            addCriterion("eventid >", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidGreaterThanOrEqualTo(Long value) {
            addCriterion("eventid >=", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidLessThan(Long value) {
            addCriterion("eventid <", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidLessThanOrEqualTo(Long value) {
            addCriterion("eventid <=", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidIn(List<Long> values) {
            addCriterion("eventid in", values, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidNotIn(List<Long> values) {
            addCriterion("eventid not in", values, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidBetween(Long value1, Long value2) {
            addCriterion("eventid between", value1, value2, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidNotBetween(Long value1, Long value2) {
            addCriterion("eventid not between", value1, value2, "eventid");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNull() {
            addCriterion("Memberid is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("Memberid is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("Memberid =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("Memberid <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("Memberid >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Memberid >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("Memberid <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("Memberid <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("Memberid in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("Memberid not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("Memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("Memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andTimelengthIsNull() {
            addCriterion("TimeLength is null");
            return (Criteria) this;
        }
        public Criteria andTimelengthIsNotNull() {
            addCriterion("TimeLength is not null");
            return (Criteria) this;
        }
        public Criteria andTimelengthEqualTo(Integer value) {
            addCriterion("TimeLength =", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthNotEqualTo(Integer value) {
            addCriterion("TimeLength <>", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthGreaterThan(Integer value) {
            addCriterion("TimeLength >", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("TimeLength >=", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthLessThan(Integer value) {
            addCriterion("TimeLength <", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthLessThanOrEqualTo(Integer value) {
            addCriterion("TimeLength <=", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthIn(List<Integer> values) {
            addCriterion("TimeLength in", values, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthNotIn(List<Integer> values) {
            addCriterion("TimeLength not in", values, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthBetween(Integer value1, Integer value2) {
            addCriterion("TimeLength between", value1, value2, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthNotBetween(Integer value1, Integer value2) {
            addCriterion("TimeLength not between", value1, value2, "timelength");
            return (Criteria) this;
        }
        public Criteria andUploadtimeIsNull() {
            addCriterion("UploadTime is null");
            return (Criteria) this;
        }
        public Criteria andUploadtimeIsNotNull() {
            addCriterion("UploadTime is not null");
            return (Criteria) this;
        }
        public Criteria andUploadtimeEqualTo(Date value) {
            addCriterion("UploadTime =", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeNotEqualTo(Date value) {
            addCriterion("UploadTime <>", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeGreaterThan(Date value) {
            addCriterion("UploadTime >", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UploadTime >=", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeLessThan(Date value) {
            addCriterion("UploadTime <", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeLessThanOrEqualTo(Date value) {
            addCriterion("UploadTime <=", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeIn(List<Date> values) {
            addCriterion("UploadTime in", values, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeNotIn(List<Date> values) {
            addCriterion("UploadTime not in", values, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeBetween(Date value1, Date value2) {
            addCriterion("UploadTime between", value1, value2, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeNotBetween(Date value1, Date value2) {
            addCriterion("UploadTime not between", value1, value2, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andEventtypeIsNull() {
            addCriterion("EventType is null");
            return (Criteria) this;
        }
        public Criteria andEventtypeIsNotNull() {
            addCriterion("EventType is not null");
            return (Criteria) this;
        }
        public Criteria andEventtypeEqualTo(String value) {
            addCriterion("EventType =", value, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeNotEqualTo(String value) {
            addCriterion("EventType <>", value, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeGreaterThan(String value) {
            addCriterion("EventType >", value, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeGreaterThanOrEqualTo(String value) {
            addCriterion("EventType >=", value, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeLessThan(String value) {
            addCriterion("EventType <", value, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeLessThanOrEqualTo(String value) {
            addCriterion("EventType <=", value, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeLike(String value) {
            addCriterion("EventType like", value, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeNotLike(String value) {
            addCriterion("EventType not like", value, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeIn(List<String> values) {
            addCriterion("EventType in", values, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeNotIn(List<String> values) {
            addCriterion("EventType not in", values, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeBetween(String value1, String value2) {
            addCriterion("EventType between", value1, value2, "eventtype");
            return (Criteria) this;
        }
        public Criteria andEventtypeNotBetween(String value1, String value2) {
            addCriterion("EventType not between", value1, value2, "eventtype");
            return (Criteria) this;
        }
        public Criteria andWheabntagIsNull() {
            addCriterion("WheAbnTag is null");
            return (Criteria) this;
        }
        public Criteria andWheabntagIsNotNull() {
            addCriterion("WheAbnTag is not null");
            return (Criteria) this;
        }
        public Criteria andWheabntagEqualTo(String value) {
            addCriterion("WheAbnTag =", value, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagNotEqualTo(String value) {
            addCriterion("WheAbnTag <>", value, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagGreaterThan(String value) {
            addCriterion("WheAbnTag >", value, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagGreaterThanOrEqualTo(String value) {
            addCriterion("WheAbnTag >=", value, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagLessThan(String value) {
            addCriterion("WheAbnTag <", value, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagLessThanOrEqualTo(String value) {
            addCriterion("WheAbnTag <=", value, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagLike(String value) {
            addCriterion("WheAbnTag like", value, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagNotLike(String value) {
            addCriterion("WheAbnTag not like", value, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagIn(List<String> values) {
            addCriterion("WheAbnTag in", values, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagNotIn(List<String> values) {
            addCriterion("WheAbnTag not in", values, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagBetween(String value1, String value2) {
            addCriterion("WheAbnTag between", value1, value2, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andWheabntagNotBetween(String value1, String value2) {
            addCriterion("WheAbnTag not between", value1, value2, "wheabntag");
            return (Criteria) this;
        }
        public Criteria andStatustagIsNull() {
            addCriterion("StatusTag is null");
            return (Criteria) this;
        }
        public Criteria andStatustagIsNotNull() {
            addCriterion("StatusTag is not null");
            return (Criteria) this;
        }
        public Criteria andStatustagEqualTo(Short value) {
            addCriterion("StatusTag =", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagNotEqualTo(Short value) {
            addCriterion("StatusTag <>", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagGreaterThan(Short value) {
            addCriterion("StatusTag >", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagGreaterThanOrEqualTo(Short value) {
            addCriterion("StatusTag >=", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagLessThan(Short value) {
            addCriterion("StatusTag <", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagLessThanOrEqualTo(Short value) {
            addCriterion("StatusTag <=", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagIn(List<Short> values) {
            addCriterion("StatusTag in", values, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagNotIn(List<Short> values) {
            addCriterion("StatusTag not in", values, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagBetween(Short value1, Short value2) {
            addCriterion("StatusTag between", value1, value2, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagNotBetween(Short value1, Short value2) {
            addCriterion("StatusTag not between", value1, value2, "statustag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 测量数据记录表（OMDS）
     * 
     * @author ${user}
     * @version 1.0 2016-08-22
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