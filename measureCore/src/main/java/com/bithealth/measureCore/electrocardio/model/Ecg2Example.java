/*
 * Ecg2Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

import java.util.ArrayList;
import java.util.List;

public class Ecg2Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Ecg2Example() {
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
     * 心电12种异常（ECG2）
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
        public Criteria andAbnnameIsNull() {
            addCriterion("AbnName is null");
            return (Criteria) this;
        }
        public Criteria andAbnnameIsNotNull() {
            addCriterion("AbnName is not null");
            return (Criteria) this;
        }
        public Criteria andAbnnameEqualTo(String value) {
            addCriterion("AbnName =", value, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameNotEqualTo(String value) {
            addCriterion("AbnName <>", value, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameGreaterThan(String value) {
            addCriterion("AbnName >", value, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameGreaterThanOrEqualTo(String value) {
            addCriterion("AbnName >=", value, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameLessThan(String value) {
            addCriterion("AbnName <", value, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameLessThanOrEqualTo(String value) {
            addCriterion("AbnName <=", value, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameLike(String value) {
            addCriterion("AbnName like", value, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameNotLike(String value) {
            addCriterion("AbnName not like", value, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameIn(List<String> values) {
            addCriterion("AbnName in", values, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameNotIn(List<String> values) {
            addCriterion("AbnName not in", values, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameBetween(String value1, String value2) {
            addCriterion("AbnName between", value1, value2, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnameNotBetween(String value1, String value2) {
            addCriterion("AbnName not between", value1, value2, "abnname");
            return (Criteria) this;
        }
        public Criteria andAbnnumIsNull() {
            addCriterion("AbnNum is null");
            return (Criteria) this;
        }
        public Criteria andAbnnumIsNotNull() {
            addCriterion("AbnNum is not null");
            return (Criteria) this;
        }
        public Criteria andAbnnumEqualTo(Integer value) {
            addCriterion("AbnNum =", value, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumNotEqualTo(Integer value) {
            addCriterion("AbnNum <>", value, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumGreaterThan(Integer value) {
            addCriterion("AbnNum >", value, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("AbnNum >=", value, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumLessThan(Integer value) {
            addCriterion("AbnNum <", value, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumLessThanOrEqualTo(Integer value) {
            addCriterion("AbnNum <=", value, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumIn(List<Integer> values) {
            addCriterion("AbnNum in", values, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumNotIn(List<Integer> values) {
            addCriterion("AbnNum not in", values, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumBetween(Integer value1, Integer value2) {
            addCriterion("AbnNum between", value1, value2, "abnnum");
            return (Criteria) this;
        }
        public Criteria andAbnnumNotBetween(Integer value1, Integer value2) {
            addCriterion("AbnNum not between", value1, value2, "abnnum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 心电12种异常（ECG2）
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