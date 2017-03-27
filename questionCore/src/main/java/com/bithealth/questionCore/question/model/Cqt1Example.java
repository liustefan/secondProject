/*
 * Cqt1Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.List;

public class Cqt1Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Cqt1Example() {
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
     * 组合问卷关联单份明细（CQT1）
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
        public Criteria andCombQustidIsNull() {
            addCriterion("CombQustid is null");
            return (Criteria) this;
        }
        public Criteria andCombQustidIsNotNull() {
            addCriterion("CombQustid is not null");
            return (Criteria) this;
        }
        public Criteria andCombQustidEqualTo(Integer value) {
            addCriterion("CombQustid =", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotEqualTo(Integer value) {
            addCriterion("CombQustid <>", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidGreaterThan(Integer value) {
            addCriterion("CombQustid >", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CombQustid >=", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidLessThan(Integer value) {
            addCriterion("CombQustid <", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidLessThanOrEqualTo(Integer value) {
            addCriterion("CombQustid <=", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidIn(List<Integer> values) {
            addCriterion("CombQustid in", values, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotIn(List<Integer> values) {
            addCriterion("CombQustid not in", values, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidBetween(Integer value1, Integer value2) {
            addCriterion("CombQustid between", value1, value2, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotBetween(Integer value1, Integer value2) {
            addCriterion("CombQustid not between", value1, value2, "combQustid");
            return (Criteria) this;
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
        public Criteria andQustCodeIsNull() {
            addCriterion("QustCode is null");
            return (Criteria) this;
        }
        public Criteria andQustCodeIsNotNull() {
            addCriterion("QustCode is not null");
            return (Criteria) this;
        }
        public Criteria andQustCodeEqualTo(String value) {
            addCriterion("QustCode =", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotEqualTo(String value) {
            addCriterion("QustCode <>", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeGreaterThan(String value) {
            addCriterion("QustCode >", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeGreaterThanOrEqualTo(String value) {
            addCriterion("QustCode >=", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLessThan(String value) {
            addCriterion("QustCode <", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLessThanOrEqualTo(String value) {
            addCriterion("QustCode <=", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLike(String value) {
            addCriterion("QustCode like", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotLike(String value) {
            addCriterion("QustCode not like", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeIn(List<String> values) {
            addCriterion("QustCode in", values, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotIn(List<String> values) {
            addCriterion("QustCode not in", values, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeBetween(String value1, String value2) {
            addCriterion("QustCode between", value1, value2, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotBetween(String value1, String value2) {
            addCriterion("QustCode not between", value1, value2, "qustCode");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNull() {
            addCriterion("OptId is null");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNotNull() {
            addCriterion("OptId is not null");
            return (Criteria) this;
        }
        public Criteria andOptIdEqualTo(Short value) {
            addCriterion("OptId =", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotEqualTo(Short value) {
            addCriterion("OptId <>", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThan(Short value) {
            addCriterion("OptId >", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThanOrEqualTo(Short value) {
            addCriterion("OptId >=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThan(Short value) {
            addCriterion("OptId <", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThanOrEqualTo(Short value) {
            addCriterion("OptId <=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdIn(List<Short> values) {
            addCriterion("OptId in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotIn(List<Short> values) {
            addCriterion("OptId not in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdBetween(Short value1, Short value2) {
            addCriterion("OptId between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotBetween(Short value1, Short value2) {
            addCriterion("OptId not between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNull() {
            addCriterion("FunId is null");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNotNull() {
            addCriterion("FunId is not null");
            return (Criteria) this;
        }
        public Criteria andFunIdEqualTo(Short value) {
            addCriterion("FunId =", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotEqualTo(Short value) {
            addCriterion("FunId <>", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThan(Short value) {
            addCriterion("FunId >", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThanOrEqualTo(Short value) {
            addCriterion("FunId >=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThan(Short value) {
            addCriterion("FunId <", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThanOrEqualTo(Short value) {
            addCriterion("FunId <=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdIn(List<Short> values) {
            addCriterion("FunId in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotIn(List<Short> values) {
            addCriterion("FunId not in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdBetween(Short value1, Short value2) {
            addCriterion("FunId between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotBetween(Short value1, Short value2) {
            addCriterion("FunId not between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andQustnameIsNull() {
            addCriterion("Qustname is null");
            return (Criteria) this;
        }
        public Criteria andQustnameIsNotNull() {
            addCriterion("Qustname is not null");
            return (Criteria) this;
        }
        public Criteria andQustnameEqualTo(String value) {
            addCriterion("Qustname =", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameNotEqualTo(String value) {
            addCriterion("Qustname <>", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameGreaterThan(String value) {
            addCriterion("Qustname >", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameGreaterThanOrEqualTo(String value) {
            addCriterion("Qustname >=", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameLessThan(String value) {
            addCriterion("Qustname <", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameLessThanOrEqualTo(String value) {
            addCriterion("Qustname <=", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameLike(String value) {
            addCriterion("Qustname like", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameNotLike(String value) {
            addCriterion("Qustname not like", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameIn(List<String> values) {
            addCriterion("Qustname in", values, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameNotIn(List<String> values) {
            addCriterion("Qustname not in", values, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameBetween(String value1, String value2) {
            addCriterion("Qustname between", value1, value2, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameNotBetween(String value1, String value2) {
            addCriterion("Qustname not between", value1, value2, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustVerIsNull() {
            addCriterion("QustVer is null");
            return (Criteria) this;
        }
        public Criteria andQustVerIsNotNull() {
            addCriterion("QustVer is not null");
            return (Criteria) this;
        }
        public Criteria andQustVerEqualTo(String value) {
            addCriterion("QustVer =", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotEqualTo(String value) {
            addCriterion("QustVer <>", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerGreaterThan(String value) {
            addCriterion("QustVer >", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerGreaterThanOrEqualTo(String value) {
            addCriterion("QustVer >=", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLessThan(String value) {
            addCriterion("QustVer <", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLessThanOrEqualTo(String value) {
            addCriterion("QustVer <=", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLike(String value) {
            addCriterion("QustVer like", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotLike(String value) {
            addCriterion("QustVer not like", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerIn(List<String> values) {
            addCriterion("QustVer in", values, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotIn(List<String> values) {
            addCriterion("QustVer not in", values, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerBetween(String value1, String value2) {
            addCriterion("QustVer between", value1, value2, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotBetween(String value1, String value2) {
            addCriterion("QustVer not between", value1, value2, "qustVer");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 组合问卷关联单份明细（CQT1）
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