/*
 * FunctionExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

import java.util.ArrayList;
import java.util.List;

public class FunctionExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public FunctionExample() {
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
     * 分组功能表
     * 
     * @author ${user}
     * @version 1.0 2016-07-14
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
        public Criteria andFunNameIsNull() {
            addCriterion("FunName is null");
            return (Criteria) this;
        }
        public Criteria andFunNameIsNotNull() {
            addCriterion("FunName is not null");
            return (Criteria) this;
        }
        public Criteria andFunNameEqualTo(String value) {
            addCriterion("FunName =", value, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameNotEqualTo(String value) {
            addCriterion("FunName <>", value, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameGreaterThan(String value) {
            addCriterion("FunName >", value, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameGreaterThanOrEqualTo(String value) {
            addCriterion("FunName >=", value, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameLessThan(String value) {
            addCriterion("FunName <", value, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameLessThanOrEqualTo(String value) {
            addCriterion("FunName <=", value, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameLike(String value) {
            addCriterion("FunName like", value, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameNotLike(String value) {
            addCriterion("FunName not like", value, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameIn(List<String> values) {
            addCriterion("FunName in", values, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameNotIn(List<String> values) {
            addCriterion("FunName not in", values, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameBetween(String value1, String value2) {
            addCriterion("FunName between", value1, value2, "funName");
            return (Criteria) this;
        }
        public Criteria andFunNameNotBetween(String value1, String value2) {
            addCriterion("FunName not between", value1, value2, "funName");
            return (Criteria) this;
        }
        public Criteria andFunDesIsNull() {
            addCriterion("FunDes is null");
            return (Criteria) this;
        }
        public Criteria andFunDesIsNotNull() {
            addCriterion("FunDes is not null");
            return (Criteria) this;
        }
        public Criteria andFunDesEqualTo(String value) {
            addCriterion("FunDes =", value, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesNotEqualTo(String value) {
            addCriterion("FunDes <>", value, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesGreaterThan(String value) {
            addCriterion("FunDes >", value, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesGreaterThanOrEqualTo(String value) {
            addCriterion("FunDes >=", value, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesLessThan(String value) {
            addCriterion("FunDes <", value, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesLessThanOrEqualTo(String value) {
            addCriterion("FunDes <=", value, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesLike(String value) {
            addCriterion("FunDes like", value, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesNotLike(String value) {
            addCriterion("FunDes not like", value, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesIn(List<String> values) {
            addCriterion("FunDes in", values, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesNotIn(List<String> values) {
            addCriterion("FunDes not in", values, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesBetween(String value1, String value2) {
            addCriterion("FunDes between", value1, value2, "funDes");
            return (Criteria) this;
        }
        public Criteria andFunDesNotBetween(String value1, String value2) {
            addCriterion("FunDes not between", value1, value2, "funDes");
            return (Criteria) this;
        }
        public Criteria andTagIsNull() {
            addCriterion("Tag is null");
            return (Criteria) this;
        }
        public Criteria andTagIsNotNull() {
            addCriterion("Tag is not null");
            return (Criteria) this;
        }
        public Criteria andTagEqualTo(String value) {
            addCriterion("Tag =", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotEqualTo(String value) {
            addCriterion("Tag <>", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThan(String value) {
            addCriterion("Tag >", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("Tag >=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThan(String value) {
            addCriterion("Tag <", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("Tag <=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLike(String value) {
            addCriterion("Tag like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotLike(String value) {
            addCriterion("Tag not like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagIn(List<String> values) {
            addCriterion("Tag in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotIn(List<String> values) {
            addCriterion("Tag not in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("Tag between", value1, value2, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("Tag not between", value1, value2, "tag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 分组功能表
     * 
     * @author ${user}
     * @version 1.0 2016-07-14
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