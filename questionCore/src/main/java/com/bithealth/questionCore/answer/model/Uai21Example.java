/*
 * Uai21Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

import java.util.ArrayList;
import java.util.List;

public class Uai21Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Uai21Example() {
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
     * 会员答卷答案明细（UAI21）
     * 
     * @author ${user}
     * @version 1.0 2016-07-18
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
        public Criteria andAnsNumberIsNull() {
            addCriterion("AnsNumber is null");
            return (Criteria) this;
        }
        public Criteria andAnsNumberIsNotNull() {
            addCriterion("AnsNumber is not null");
            return (Criteria) this;
        }
        public Criteria andAnsNumberEqualTo(Integer value) {
            addCriterion("AnsNumber =", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotEqualTo(Integer value) {
            addCriterion("AnsNumber <>", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberGreaterThan(Integer value) {
            addCriterion("AnsNumber >", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("AnsNumber >=", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberLessThan(Integer value) {
            addCriterion("AnsNumber <", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("AnsNumber <=", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberIn(List<Integer> values) {
            addCriterion("AnsNumber in", values, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotIn(List<Integer> values) {
            addCriterion("AnsNumber not in", values, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberBetween(Integer value1, Integer value2) {
            addCriterion("AnsNumber between", value1, value2, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("AnsNumber not between", value1, value2, "ansNumber");
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
        public Criteria andFillblankIsNull() {
            addCriterion("Fillblank is null");
            return (Criteria) this;
        }
        public Criteria andFillblankIsNotNull() {
            addCriterion("Fillblank is not null");
            return (Criteria) this;
        }
        public Criteria andFillblankEqualTo(String value) {
            addCriterion("Fillblank =", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankNotEqualTo(String value) {
            addCriterion("Fillblank <>", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankGreaterThan(String value) {
            addCriterion("Fillblank >", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankGreaterThanOrEqualTo(String value) {
            addCriterion("Fillblank >=", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankLessThan(String value) {
            addCriterion("Fillblank <", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankLessThanOrEqualTo(String value) {
            addCriterion("Fillblank <=", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankLike(String value) {
            addCriterion("Fillblank like", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankNotLike(String value) {
            addCriterion("Fillblank not like", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankIn(List<String> values) {
            addCriterion("Fillblank in", values, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankNotIn(List<String> values) {
            addCriterion("Fillblank not in", values, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankBetween(String value1, String value2) {
            addCriterion("Fillblank between", value1, value2, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankNotBetween(String value1, String value2) {
            addCriterion("Fillblank not between", value1, value2, "fillblank");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员答卷答案明细（UAI21）
     * 
     * @author ${user}
     * @version 1.0 2016-07-18
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