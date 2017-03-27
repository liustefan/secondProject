/*
 * Ecg1Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

import java.util.ArrayList;
import java.util.List;

public class Ecg1Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Ecg1Example() {
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
     * 心电测量明细
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
        public Criteria andLinenumIsNull() {
            addCriterion("LineNum is null");
            return (Criteria) this;
        }
        public Criteria andLinenumIsNotNull() {
            addCriterion("LineNum is not null");
            return (Criteria) this;
        }
        public Criteria andLinenumEqualTo(Short value) {
            addCriterion("LineNum =", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumNotEqualTo(Short value) {
            addCriterion("LineNum <>", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumGreaterThan(Short value) {
            addCriterion("LineNum >", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumGreaterThanOrEqualTo(Short value) {
            addCriterion("LineNum >=", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumLessThan(Short value) {
            addCriterion("LineNum <", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumLessThanOrEqualTo(Short value) {
            addCriterion("LineNum <=", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumIn(List<Short> values) {
            addCriterion("LineNum in", values, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumNotIn(List<Short> values) {
            addCriterion("LineNum not in", values, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumBetween(Short value1, Short value2) {
            addCriterion("LineNum between", value1, value2, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumNotBetween(Short value1, Short value2) {
            addCriterion("LineNum not between", value1, value2, "linenum");
            return (Criteria) this;
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
        public Criteria andAbecgtypeIsNull() {
            addCriterion("AbECGType is null");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeIsNotNull() {
            addCriterion("AbECGType is not null");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeEqualTo(String value) {
            addCriterion("AbECGType =", value, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeNotEqualTo(String value) {
            addCriterion("AbECGType <>", value, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeGreaterThan(String value) {
            addCriterion("AbECGType >", value, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("AbECGType >=", value, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeLessThan(String value) {
            addCriterion("AbECGType <", value, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeLessThanOrEqualTo(String value) {
            addCriterion("AbECGType <=", value, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeLike(String value) {
            addCriterion("AbECGType like", value, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeNotLike(String value) {
            addCriterion("AbECGType not like", value, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeIn(List<String> values) {
            addCriterion("AbECGType in", values, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeNotIn(List<String> values) {
            addCriterion("AbECGType not in", values, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeBetween(String value1, String value2) {
            addCriterion("AbECGType between", value1, value2, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtypeNotBetween(String value1, String value2) {
            addCriterion("AbECGType not between", value1, value2, "abecgtype");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeIsNull() {
            addCriterion("AbECGTime is null");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeIsNotNull() {
            addCriterion("AbECGTime is not null");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeEqualTo(Integer value) {
            addCriterion("AbECGTime =", value, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeNotEqualTo(Integer value) {
            addCriterion("AbECGTime <>", value, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeGreaterThan(Integer value) {
            addCriterion("AbECGTime >", value, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AbECGTime >=", value, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeLessThan(Integer value) {
            addCriterion("AbECGTime <", value, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeLessThanOrEqualTo(Integer value) {
            addCriterion("AbECGTime <=", value, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeIn(List<Integer> values) {
            addCriterion("AbECGTime in", values, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeNotIn(List<Integer> values) {
            addCriterion("AbECGTime not in", values, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeBetween(Integer value1, Integer value2) {
            addCriterion("AbECGTime between", value1, value2, "abecgtime");
            return (Criteria) this;
        }
        public Criteria andAbecgtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("AbECGTime not between", value1, value2, "abecgtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 心电测量明细
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