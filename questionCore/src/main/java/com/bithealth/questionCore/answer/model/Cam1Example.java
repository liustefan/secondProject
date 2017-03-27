/*
 * Cam1Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

import java.util.ArrayList;
import java.util.List;

public class Cam1Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Cam1Example() {
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
     * 组合答卷关联单份答卷（CAM1）
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
        public Criteria andCombAnsidIsNull() {
            addCriterion("CombAnsid is null");
            return (Criteria) this;
        }
        public Criteria andCombAnsidIsNotNull() {
            addCriterion("CombAnsid is not null");
            return (Criteria) this;
        }
        public Criteria andCombAnsidEqualTo(Integer value) {
            addCriterion("CombAnsid =", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidNotEqualTo(Integer value) {
            addCriterion("CombAnsid <>", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidGreaterThan(Integer value) {
            addCriterion("CombAnsid >", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CombAnsid >=", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidLessThan(Integer value) {
            addCriterion("CombAnsid <", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidLessThanOrEqualTo(Integer value) {
            addCriterion("CombAnsid <=", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidIn(List<Integer> values) {
            addCriterion("CombAnsid in", values, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidNotIn(List<Integer> values) {
            addCriterion("CombAnsid not in", values, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidBetween(Integer value1, Integer value2) {
            addCriterion("CombAnsid between", value1, value2, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidNotBetween(Integer value1, Integer value2) {
            addCriterion("CombAnsid not between", value1, value2, "combAnsid");
            return (Criteria) this;
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
        public Criteria andAnsTagIsNull() {
            addCriterion("AnsTag is null");
            return (Criteria) this;
        }
        public Criteria andAnsTagIsNotNull() {
            addCriterion("AnsTag is not null");
            return (Criteria) this;
        }
        public Criteria andAnsTagEqualTo(String value) {
            addCriterion("AnsTag =", value, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagNotEqualTo(String value) {
            addCriterion("AnsTag <>", value, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagGreaterThan(String value) {
            addCriterion("AnsTag >", value, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagGreaterThanOrEqualTo(String value) {
            addCriterion("AnsTag >=", value, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagLessThan(String value) {
            addCriterion("AnsTag <", value, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagLessThanOrEqualTo(String value) {
            addCriterion("AnsTag <=", value, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagLike(String value) {
            addCriterion("AnsTag like", value, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagNotLike(String value) {
            addCriterion("AnsTag not like", value, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagIn(List<String> values) {
            addCriterion("AnsTag in", values, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagNotIn(List<String> values) {
            addCriterion("AnsTag not in", values, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagBetween(String value1, String value2) {
            addCriterion("AnsTag between", value1, value2, "ansTag");
            return (Criteria) this;
        }
        public Criteria andAnsTagNotBetween(String value1, String value2) {
            addCriterion("AnsTag not between", value1, value2, "ansTag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 组合答卷关联单份答卷（CAM1）
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