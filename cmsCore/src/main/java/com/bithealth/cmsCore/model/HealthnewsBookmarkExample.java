/*
 * HealthnewsBookmarkExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-26 Created
 */
package com.bithealth.cmsCore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HealthnewsBookmarkExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public HealthnewsBookmarkExample() {
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
     * [2.1]健康资讯_收藏表
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
        public Criteria andLogidIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogidIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogidEqualTo(Long value) {
            addCriterion("LogID =", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotEqualTo(Long value) {
            addCriterion("LogID <>", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidGreaterThan(Long value) {
            addCriterion("LogID >", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidGreaterThanOrEqualTo(Long value) {
            addCriterion("LogID >=", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidLessThan(Long value) {
            addCriterion("LogID <", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidLessThanOrEqualTo(Long value) {
            addCriterion("LogID <=", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidIn(List<Long> values) {
            addCriterion("LogID in", values, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotIn(List<Long> values) {
            addCriterion("LogID not in", values, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidBetween(Long value1, Long value2) {
            addCriterion("LogID between", value1, value2, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotBetween(Long value1, Long value2) {
            addCriterion("LogID not between", value1, value2, "logid");
            return (Criteria) this;
        }
        public Criteria andHninfoidIsNull() {
            addCriterion("HNInfoID is null");
            return (Criteria) this;
        }
        public Criteria andHninfoidIsNotNull() {
            addCriterion("HNInfoID is not null");
            return (Criteria) this;
        }
        public Criteria andHninfoidEqualTo(Integer value) {
            addCriterion("HNInfoID =", value, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidNotEqualTo(Integer value) {
            addCriterion("HNInfoID <>", value, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidGreaterThan(Integer value) {
            addCriterion("HNInfoID >", value, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("HNInfoID >=", value, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidLessThan(Integer value) {
            addCriterion("HNInfoID <", value, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidLessThanOrEqualTo(Integer value) {
            addCriterion("HNInfoID <=", value, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidIn(List<Integer> values) {
            addCriterion("HNInfoID in", values, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidNotIn(List<Integer> values) {
            addCriterion("HNInfoID not in", values, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidBetween(Integer value1, Integer value2) {
            addCriterion("HNInfoID between", value1, value2, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andHninfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("HNInfoID not between", value1, value2, "hninfoid");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNull() {
            addCriterion("MemberID is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("MemberID is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("MemberID =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("MemberID <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("MemberID >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MemberID >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("MemberID <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("MemberID <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("MemberID in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("MemberID not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("MemberID between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("MemberID not between", value1, value2, "memberid");
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
     * [2.1]健康资讯_收藏表
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