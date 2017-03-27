/*
 * Mfq12Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.List;

public class Mfq12Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Mfq12Example() {
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
     * 比较值取分表（MFQ12)
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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
        public Criteria andQustidIsNull() {
            addCriterion("Qustid is null");
            return (Criteria) this;
        }
        public Criteria andQustidIsNotNull() {
            addCriterion("Qustid is not null");
            return (Criteria) this;
        }
        public Criteria andQustidEqualTo(Integer value) {
            addCriterion("Qustid =", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotEqualTo(Integer value) {
            addCriterion("Qustid <>", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidGreaterThan(Integer value) {
            addCriterion("Qustid >", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Qustid >=", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidLessThan(Integer value) {
            addCriterion("Qustid <", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidLessThanOrEqualTo(Integer value) {
            addCriterion("Qustid <=", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidIn(List<Integer> values) {
            addCriterion("Qustid in", values, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotIn(List<Integer> values) {
            addCriterion("Qustid not in", values, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidBetween(Integer value1, Integer value2) {
            addCriterion("Qustid between", value1, value2, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotBetween(Integer value1, Integer value2) {
            addCriterion("Qustid not between", value1, value2, "qustid");
            return (Criteria) this;
        }
        public Criteria andProblemidIsNull() {
            addCriterion("Problemid is null");
            return (Criteria) this;
        }
        public Criteria andProblemidIsNotNull() {
            addCriterion("Problemid is not null");
            return (Criteria) this;
        }
        public Criteria andProblemidEqualTo(Integer value) {
            addCriterion("Problemid =", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidNotEqualTo(Integer value) {
            addCriterion("Problemid <>", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidGreaterThan(Integer value) {
            addCriterion("Problemid >", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Problemid >=", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidLessThan(Integer value) {
            addCriterion("Problemid <", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidLessThanOrEqualTo(Integer value) {
            addCriterion("Problemid <=", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidIn(List<Integer> values) {
            addCriterion("Problemid in", values, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidNotIn(List<Integer> values) {
            addCriterion("Problemid not in", values, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidBetween(Integer value1, Integer value2) {
            addCriterion("Problemid between", value1, value2, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidNotBetween(Integer value1, Integer value2) {
            addCriterion("Problemid not between", value1, value2, "problemid");
            return (Criteria) this;
        }
        public Criteria andAnsidIsNull() {
            addCriterion("Ansid is null");
            return (Criteria) this;
        }
        public Criteria andAnsidIsNotNull() {
            addCriterion("Ansid is not null");
            return (Criteria) this;
        }
        public Criteria andAnsidEqualTo(Short value) {
            addCriterion("Ansid =", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidNotEqualTo(Short value) {
            addCriterion("Ansid <>", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidGreaterThan(Short value) {
            addCriterion("Ansid >", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidGreaterThanOrEqualTo(Short value) {
            addCriterion("Ansid >=", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidLessThan(Short value) {
            addCriterion("Ansid <", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidLessThanOrEqualTo(Short value) {
            addCriterion("Ansid <=", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidIn(List<Short> values) {
            addCriterion("Ansid in", values, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidNotIn(List<Short> values) {
            addCriterion("Ansid not in", values, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidBetween(Short value1, Short value2) {
            addCriterion("Ansid between", value1, value2, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidNotBetween(Short value1, Short value2) {
            addCriterion("Ansid not between", value1, value2, "ansid");
            return (Criteria) this;
        }
        public Criteria andLineNumIsNull() {
            addCriterion("LineNum is null");
            return (Criteria) this;
        }
        public Criteria andLineNumIsNotNull() {
            addCriterion("LineNum is not null");
            return (Criteria) this;
        }
        public Criteria andLineNumEqualTo(Short value) {
            addCriterion("LineNum =", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotEqualTo(Short value) {
            addCriterion("LineNum <>", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumGreaterThan(Short value) {
            addCriterion("LineNum >", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumGreaterThanOrEqualTo(Short value) {
            addCriterion("LineNum >=", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumLessThan(Short value) {
            addCriterion("LineNum <", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumLessThanOrEqualTo(Short value) {
            addCriterion("LineNum <=", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumIn(List<Short> values) {
            addCriterion("LineNum in", values, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotIn(List<Short> values) {
            addCriterion("LineNum not in", values, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumBetween(Short value1, Short value2) {
            addCriterion("LineNum between", value1, value2, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotBetween(Short value1, Short value2) {
            addCriterion("LineNum not between", value1, value2, "lineNum");
            return (Criteria) this;
        }
        public Criteria andMinNumIsNull() {
            addCriterion("MinNum is null");
            return (Criteria) this;
        }
        public Criteria andMinNumIsNotNull() {
            addCriterion("MinNum is not null");
            return (Criteria) this;
        }
        public Criteria andMinNumEqualTo(Integer value) {
            addCriterion("MinNum =", value, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumNotEqualTo(Integer value) {
            addCriterion("MinNum <>", value, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumGreaterThan(Integer value) {
            addCriterion("MinNum >", value, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("MinNum >=", value, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumLessThan(Integer value) {
            addCriterion("MinNum <", value, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumLessThanOrEqualTo(Integer value) {
            addCriterion("MinNum <=", value, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumIn(List<Integer> values) {
            addCriterion("MinNum in", values, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumNotIn(List<Integer> values) {
            addCriterion("MinNum not in", values, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumBetween(Integer value1, Integer value2) {
            addCriterion("MinNum between", value1, value2, "minNum");
            return (Criteria) this;
        }
        public Criteria andMinNumNotBetween(Integer value1, Integer value2) {
            addCriterion("MinNum not between", value1, value2, "minNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumIsNull() {
            addCriterion("MaxNum is null");
            return (Criteria) this;
        }
        public Criteria andMaxNumIsNotNull() {
            addCriterion("MaxNum is not null");
            return (Criteria) this;
        }
        public Criteria andMaxNumEqualTo(Integer value) {
            addCriterion("MaxNum =", value, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumNotEqualTo(Integer value) {
            addCriterion("MaxNum <>", value, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumGreaterThan(Integer value) {
            addCriterion("MaxNum >", value, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("MaxNum >=", value, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumLessThan(Integer value) {
            addCriterion("MaxNum <", value, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumLessThanOrEqualTo(Integer value) {
            addCriterion("MaxNum <=", value, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumIn(List<Integer> values) {
            addCriterion("MaxNum in", values, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumNotIn(List<Integer> values) {
            addCriterion("MaxNum not in", values, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumBetween(Integer value1, Integer value2) {
            addCriterion("MaxNum between", value1, value2, "maxNum");
            return (Criteria) this;
        }
        public Criteria andMaxNumNotBetween(Integer value1, Integer value2) {
            addCriterion("MaxNum not between", value1, value2, "maxNum");
            return (Criteria) this;
        }
        public Criteria andScoreIsNull() {
            addCriterion("Score is null");
            return (Criteria) this;
        }
        public Criteria andScoreIsNotNull() {
            addCriterion("Score is not null");
            return (Criteria) this;
        }
        public Criteria andScoreEqualTo(Double value) {
            addCriterion("Score =", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("Score <>", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("Score >", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("Score >=", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreLessThan(Double value) {
            addCriterion("Score <", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("Score <=", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreIn(List<Double> values) {
            addCriterion("Score in", values, "score");
            return (Criteria) this;
        }
        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("Score not in", values, "score");
            return (Criteria) this;
        }
        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("Score between", value1, value2, "score");
            return (Criteria) this;
        }
        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("Score not between", value1, value2, "score");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 比较值取分表（MFQ12)
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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