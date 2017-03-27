/*
 * OasrSerialnumberExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.model;

import java.util.ArrayList;
import java.util.List;

public class OasrSerialnumberExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OasrSerialnumberExample() {
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
     * @version 1.0 2016-07-19
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
        public Criteria andSerialNumberIsNull() {
            addCriterion("serialNumber is null");
            return (Criteria) this;
        }
        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serialNumber is not null");
            return (Criteria) this;
        }
        public Criteria andSerialNumberEqualTo(Long value) {
            addCriterion("serialNumber =", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotEqualTo(Long value) {
            addCriterion("serialNumber <>", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberGreaterThan(Long value) {
            addCriterion("serialNumber >", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("serialNumber >=", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberLessThan(Long value) {
            addCriterion("serialNumber <", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberLessThanOrEqualTo(Long value) {
            addCriterion("serialNumber <=", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberIn(List<Long> values) {
            addCriterion("serialNumber in", values, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotIn(List<Long> values) {
            addCriterion("serialNumber not in", values, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberBetween(Long value1, Long value2) {
            addCriterion("serialNumber between", value1, value2, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotBetween(Long value1, Long value2) {
            addCriterion("serialNumber not between", value1, value2, "serialNumber");
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
     * @version 1.0 2016-07-19
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