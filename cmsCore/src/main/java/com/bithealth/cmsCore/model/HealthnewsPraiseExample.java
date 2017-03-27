/*
 * HealthnewsPraiseExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-26 Created
 */
package com.bithealth.cmsCore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HealthnewsPraiseExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public HealthnewsPraiseExample() {
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
     * [2.1]健康资讯_点赞表
     * 
     * @author ${user}
     * @version 1.0 2016-08-26
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
        public Criteria andLogIDIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogIDIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogIDEqualTo(Long value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Long value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Long value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Long value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Long value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Long value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Long> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Long> values) {
            addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Long value1, Long value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Long value1, Long value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDIsNull() {
            addCriterion("HNInfoID is null");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDIsNotNull() {
            addCriterion("HNInfoID is not null");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDEqualTo(Integer value) {
            addCriterion("HNInfoID =", value, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDNotEqualTo(Integer value) {
            addCriterion("HNInfoID <>", value, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDGreaterThan(Integer value) {
            addCriterion("HNInfoID >", value, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("HNInfoID >=", value, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDLessThan(Integer value) {
            addCriterion("HNInfoID <", value, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDLessThanOrEqualTo(Integer value) {
            addCriterion("HNInfoID <=", value, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDIn(List<Integer> values) {
            addCriterion("HNInfoID in", values, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDNotIn(List<Integer> values) {
            addCriterion("HNInfoID not in", values, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDBetween(Integer value1, Integer value2) {
            addCriterion("HNInfoID between", value1, value2, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andHNInfoIDNotBetween(Integer value1, Integer value2) {
            addCriterion("HNInfoID not between", value1, value2, "HNInfoID");
            return (Criteria) this;
        }
        public Criteria andMemberIDIsNull() {
            addCriterion("MemberID is null");
            return (Criteria) this;
        }
        public Criteria andMemberIDIsNotNull() {
            addCriterion("MemberID is not null");
            return (Criteria) this;
        }
        public Criteria andMemberIDEqualTo(Integer value) {
            addCriterion("MemberID =", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotEqualTo(Integer value) {
            addCriterion("MemberID <>", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDGreaterThan(Integer value) {
            addCriterion("MemberID >", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MemberID >=", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLessThan(Integer value) {
            addCriterion("MemberID <", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLessThanOrEqualTo(Integer value) {
            addCriterion("MemberID <=", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDIn(List<Integer> values) {
            addCriterion("MemberID in", values, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotIn(List<Integer> values) {
            addCriterion("MemberID not in", values, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDBetween(Integer value1, Integer value2) {
            addCriterion("MemberID between", value1, value2, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MemberID not between", value1, value2, "memberID");
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
     * [2.1]健康资讯_点赞表
     * 
     * @author ${user}
     * @version 1.0 2016-08-26
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