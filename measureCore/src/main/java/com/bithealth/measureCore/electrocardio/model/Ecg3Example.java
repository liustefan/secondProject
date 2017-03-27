/*
 * Ecg3Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

import java.util.ArrayList;
import java.util.List;

public class Ecg3Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Ecg3Example() {
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
     * 
     * 
     * @author ${user}
     * @version 1.0 2016-07-11
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
        public Criteria andObjectidIsNull() {
            addCriterion("ObjectId is null");
            return (Criteria) this;
        }
        public Criteria andObjectidIsNotNull() {
            addCriterion("ObjectId is not null");
            return (Criteria) this;
        }
        public Criteria andObjectidEqualTo(String value) {
            addCriterion("ObjectId =", value, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidNotEqualTo(String value) {
            addCriterion("ObjectId <>", value, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidGreaterThan(String value) {
            addCriterion("ObjectId >", value, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidGreaterThanOrEqualTo(String value) {
            addCriterion("ObjectId >=", value, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidLessThan(String value) {
            addCriterion("ObjectId <", value, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidLessThanOrEqualTo(String value) {
            addCriterion("ObjectId <=", value, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidLike(String value) {
            addCriterion("ObjectId like", value, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidNotLike(String value) {
            addCriterion("ObjectId not like", value, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidIn(List<String> values) {
            addCriterion("ObjectId in", values, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidNotIn(List<String> values) {
            addCriterion("ObjectId not in", values, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidBetween(String value1, String value2) {
            addCriterion("ObjectId between", value1, value2, "objectid");
            return (Criteria) this;
        }
        public Criteria andObjectidNotBetween(String value1, String value2) {
            addCriterion("ObjectId not between", value1, value2, "objectid");
            return (Criteria) this;
        }
        public Criteria andDocentryIsNull() {
            addCriterion("Docentry is null");
            return (Criteria) this;
        }
        public Criteria andDocentryIsNotNull() {
            addCriterion("Docentry is not null");
            return (Criteria) this;
        }
        public Criteria andDocentryEqualTo(Long value) {
            addCriterion("Docentry =", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryNotEqualTo(Long value) {
            addCriterion("Docentry <>", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryGreaterThan(Long value) {
            addCriterion("Docentry >", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryGreaterThanOrEqualTo(Long value) {
            addCriterion("Docentry >=", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryLessThan(Long value) {
            addCriterion("Docentry <", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryLessThanOrEqualTo(Long value) {
            addCriterion("Docentry <=", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryIn(List<Long> values) {
            addCriterion("Docentry in", values, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryNotIn(List<Long> values) {
            addCriterion("Docentry not in", values, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryBetween(Long value1, Long value2) {
            addCriterion("Docentry between", value1, value2, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryNotBetween(Long value1, Long value2) {
            addCriterion("Docentry not between", value1, value2, "docentry");
            return (Criteria) this;
        }
        public Criteria andStarttimeIsNull() {
            addCriterion("StartTime is null");
            return (Criteria) this;
        }
        public Criteria andStarttimeIsNotNull() {
            addCriterion("StartTime is not null");
            return (Criteria) this;
        }
        public Criteria andStarttimeEqualTo(Long value) {
            addCriterion("StartTime =", value, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeNotEqualTo(Long value) {
            addCriterion("StartTime <>", value, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeGreaterThan(Long value) {
            addCriterion("StartTime >", value, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeGreaterThanOrEqualTo(Long value) {
            addCriterion("StartTime >=", value, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeLessThan(Long value) {
            addCriterion("StartTime <", value, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeLessThanOrEqualTo(Long value) {
            addCriterion("StartTime <=", value, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeIn(List<Long> values) {
            addCriterion("StartTime in", values, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeNotIn(List<Long> values) {
            addCriterion("StartTime not in", values, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeBetween(Long value1, Long value2) {
            addCriterion("StartTime between", value1, value2, "starttime");
            return (Criteria) this;
        }
        public Criteria andStarttimeNotBetween(Long value1, Long value2) {
            addCriterion("StartTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }
        public Criteria andEndtimeIsNull() {
            addCriterion("EndTime is null");
            return (Criteria) this;
        }
        public Criteria andEndtimeIsNotNull() {
            addCriterion("EndTime is not null");
            return (Criteria) this;
        }
        public Criteria andEndtimeEqualTo(Long value) {
            addCriterion("EndTime =", value, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeNotEqualTo(Long value) {
            addCriterion("EndTime <>", value, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeGreaterThan(Long value) {
            addCriterion("EndTime >", value, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("EndTime >=", value, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeLessThan(Long value) {
            addCriterion("EndTime <", value, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeLessThanOrEqualTo(Long value) {
            addCriterion("EndTime <=", value, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeIn(List<Long> values) {
            addCriterion("EndTime in", values, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeNotIn(List<Long> values) {
            addCriterion("EndTime not in", values, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeBetween(Long value1, Long value2) {
            addCriterion("EndTime between", value1, value2, "endtime");
            return (Criteria) this;
        }
        public Criteria andEndtimeNotBetween(Long value1, Long value2) {
            addCriterion("EndTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author ${user}
     * @version 1.0 2016-07-11
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