/*
 * OrgConfigExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-11 Created
 */
package com.bithealth.orgainCore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgConfigExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OrgConfigExample() {
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
     * 组织配置表
     * 
     * @author ${user}
     * @version 1.0 2016-08-11
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
        public Criteria andLogIDIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogIDIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogIDEqualTo(Integer value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Integer value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Integer value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Integer value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Integer value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Integer> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Integer> values) {
            addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Integer value1, Integer value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Integer value1, Integer value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andOrgIDIsNull() {
            addCriterion("OrgID is null");
            return (Criteria) this;
        }
        public Criteria andOrgIDIsNotNull() {
            addCriterion("OrgID is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIDEqualTo(Integer value) {
            addCriterion("OrgID =", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotEqualTo(Integer value) {
            addCriterion("OrgID <>", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDGreaterThan(Integer value) {
            addCriterion("OrgID >", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgID >=", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDLessThan(Integer value) {
            addCriterion("OrgID <", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDLessThanOrEqualTo(Integer value) {
            addCriterion("OrgID <=", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDIn(List<Integer> values) {
            addCriterion("OrgID in", values, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotIn(List<Integer> values) {
            addCriterion("OrgID not in", values, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDBetween(Integer value1, Integer value2) {
            addCriterion("OrgID between", value1, value2, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgID not between", value1, value2, "orgID");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemIsNull() {
            addCriterion("MemMustSetItem is null");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemIsNotNull() {
            addCriterion("MemMustSetItem is not null");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemEqualTo(Long value) {
            addCriterion("MemMustSetItem =", value, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemNotEqualTo(Long value) {
            addCriterion("MemMustSetItem <>", value, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemGreaterThan(Long value) {
            addCriterion("MemMustSetItem >", value, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemGreaterThanOrEqualTo(Long value) {
            addCriterion("MemMustSetItem >=", value, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemLessThan(Long value) {
            addCriterion("MemMustSetItem <", value, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemLessThanOrEqualTo(Long value) {
            addCriterion("MemMustSetItem <=", value, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemIn(List<Long> values) {
            addCriterion("MemMustSetItem in", values, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemNotIn(List<Long> values) {
            addCriterion("MemMustSetItem not in", values, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemBetween(Long value1, Long value2) {
            addCriterion("MemMustSetItem between", value1, value2, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemMustSetItemNotBetween(Long value1, Long value2) {
            addCriterion("MemMustSetItem not between", value1, value2, "memMustSetItem");
            return (Criteria) this;
        }
        public Criteria andMemIdIsNull() {
            addCriterion("MemId is null");
            return (Criteria) this;
        }
        public Criteria andMemIdIsNotNull() {
            addCriterion("MemId is not null");
            return (Criteria) this;
        }
        public Criteria andMemIdEqualTo(Short value) {
            addCriterion("MemId =", value, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdNotEqualTo(Short value) {
            addCriterion("MemId <>", value, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdGreaterThan(Short value) {
            addCriterion("MemId >", value, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdGreaterThanOrEqualTo(Short value) {
            addCriterion("MemId >=", value, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdLessThan(Short value) {
            addCriterion("MemId <", value, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdLessThanOrEqualTo(Short value) {
            addCriterion("MemId <=", value, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdIn(List<Short> values) {
            addCriterion("MemId in", values, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdNotIn(List<Short> values) {
            addCriterion("MemId not in", values, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdBetween(Short value1, Short value2) {
            addCriterion("MemId between", value1, value2, "memId");
            return (Criteria) this;
        }
        public Criteria andMemIdNotBetween(Short value1, Short value2) {
            addCriterion("MemId not between", value1, value2, "memId");
            return (Criteria) this;
        }
        public Criteria andExperienceNumIsNull() {
            addCriterion("ExperienceNum is null");
            return (Criteria) this;
        }
        public Criteria andExperienceNumIsNotNull() {
            addCriterion("ExperienceNum is not null");
            return (Criteria) this;
        }
        public Criteria andExperienceNumEqualTo(Integer value) {
            addCriterion("ExperienceNum =", value, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumNotEqualTo(Integer value) {
            addCriterion("ExperienceNum <>", value, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumGreaterThan(Integer value) {
            addCriterion("ExperienceNum >", value, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExperienceNum >=", value, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumLessThan(Integer value) {
            addCriterion("ExperienceNum <", value, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumLessThanOrEqualTo(Integer value) {
            addCriterion("ExperienceNum <=", value, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumIn(List<Integer> values) {
            addCriterion("ExperienceNum in", values, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumNotIn(List<Integer> values) {
            addCriterion("ExperienceNum not in", values, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumBetween(Integer value1, Integer value2) {
            addCriterion("ExperienceNum between", value1, value2, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ExperienceNum not between", value1, value2, "experienceNum");
            return (Criteria) this;
        }
        public Criteria andExperienceDayIsNull() {
            addCriterion("ExperienceDay is null");
            return (Criteria) this;
        }
        public Criteria andExperienceDayIsNotNull() {
            addCriterion("ExperienceDay is not null");
            return (Criteria) this;
        }
        public Criteria andExperienceDayEqualTo(Integer value) {
            addCriterion("ExperienceDay =", value, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayNotEqualTo(Integer value) {
            addCriterion("ExperienceDay <>", value, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayGreaterThan(Integer value) {
            addCriterion("ExperienceDay >", value, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExperienceDay >=", value, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayLessThan(Integer value) {
            addCriterion("ExperienceDay <", value, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayLessThanOrEqualTo(Integer value) {
            addCriterion("ExperienceDay <=", value, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayIn(List<Integer> values) {
            addCriterion("ExperienceDay in", values, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayNotIn(List<Integer> values) {
            addCriterion("ExperienceDay not in", values, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayBetween(Integer value1, Integer value2) {
            addCriterion("ExperienceDay between", value1, value2, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andExperienceDayNotBetween(Integer value1, Integer value2) {
            addCriterion("ExperienceDay not between", value1, value2, "experienceDay");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardIsNull() {
            addCriterion("IsDisplayCard is null");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardIsNotNull() {
            addCriterion("IsDisplayCard is not null");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardEqualTo(Byte value) {
            addCriterion("IsDisplayCard =", value, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardNotEqualTo(Byte value) {
            addCriterion("IsDisplayCard <>", value, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardGreaterThan(Byte value) {
            addCriterion("IsDisplayCard >", value, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsDisplayCard >=", value, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardLessThan(Byte value) {
            addCriterion("IsDisplayCard <", value, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardLessThanOrEqualTo(Byte value) {
            addCriterion("IsDisplayCard <=", value, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardIn(List<Byte> values) {
            addCriterion("IsDisplayCard in", values, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardNotIn(List<Byte> values) {
            addCriterion("IsDisplayCard not in", values, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardBetween(Byte value1, Byte value2) {
            addCriterion("IsDisplayCard between", value1, value2, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andIsDisplayCardNotBetween(Byte value1, Byte value2) {
            addCriterion("IsDisplayCard not between", value1, value2, "isDisplayCard");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDIsNull() {
            addCriterion("CreateDrID is null");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDIsNotNull() {
            addCriterion("CreateDrID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDEqualTo(Integer value) {
            addCriterion("CreateDrID =", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDNotEqualTo(Integer value) {
            addCriterion("CreateDrID <>", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDGreaterThan(Integer value) {
            addCriterion("CreateDrID >", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateDrID >=", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDLessThan(Integer value) {
            addCriterion("CreateDrID <", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDLessThanOrEqualTo(Integer value) {
            addCriterion("CreateDrID <=", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDIn(List<Integer> values) {
            addCriterion("CreateDrID in", values, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDNotIn(List<Integer> values) {
            addCriterion("CreateDrID not in", values, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDBetween(Integer value1, Integer value2) {
            addCriterion("CreateDrID between", value1, value2, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateDrID not between", value1, value2, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDIsNull() {
            addCriterion("UpdateDrID is null");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDIsNotNull() {
            addCriterion("UpdateDrID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDEqualTo(Integer value) {
            addCriterion("UpdateDrID =", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDNotEqualTo(Integer value) {
            addCriterion("UpdateDrID <>", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDGreaterThan(Integer value) {
            addCriterion("UpdateDrID >", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateDrID >=", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDLessThan(Integer value) {
            addCriterion("UpdateDrID <", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateDrID <=", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDIn(List<Integer> values) {
            addCriterion("UpdateDrID in", values, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDNotIn(List<Integer> values) {
            addCriterion("UpdateDrID not in", values, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDBetween(Integer value1, Integer value2) {
            addCriterion("UpdateDrID between", value1, value2, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateDrID not between", value1, value2, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 组织配置表
     * 
     * @author ${user}
     * @version 1.0 2016-08-11
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