/*
 * OptionExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

import java.util.ArrayList;
import java.util.List;

public class OptionExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OptionExample() {
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
     * 选项表(OOPT)
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
        public Criteria andOptNameIsNull() {
            addCriterion("OptName is null");
            return (Criteria) this;
        }
        public Criteria andOptNameIsNotNull() {
            addCriterion("OptName is not null");
            return (Criteria) this;
        }
        public Criteria andOptNameEqualTo(String value) {
            addCriterion("OptName =", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotEqualTo(String value) {
            addCriterion("OptName <>", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameGreaterThan(String value) {
            addCriterion("OptName >", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameGreaterThanOrEqualTo(String value) {
            addCriterion("OptName >=", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLessThan(String value) {
            addCriterion("OptName <", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLessThanOrEqualTo(String value) {
            addCriterion("OptName <=", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLike(String value) {
            addCriterion("OptName like", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotLike(String value) {
            addCriterion("OptName not like", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameIn(List<String> values) {
            addCriterion("OptName in", values, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotIn(List<String> values) {
            addCriterion("OptName not in", values, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameBetween(String value1, String value2) {
            addCriterion("OptName between", value1, value2, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotBetween(String value1, String value2) {
            addCriterion("OptName not between", value1, value2, "optName");
            return (Criteria) this;
        }
        public Criteria andOptDesIsNull() {
            addCriterion("OptDes is null");
            return (Criteria) this;
        }
        public Criteria andOptDesIsNotNull() {
            addCriterion("OptDes is not null");
            return (Criteria) this;
        }
        public Criteria andOptDesEqualTo(String value) {
            addCriterion("OptDes =", value, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesNotEqualTo(String value) {
            addCriterion("OptDes <>", value, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesGreaterThan(String value) {
            addCriterion("OptDes >", value, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesGreaterThanOrEqualTo(String value) {
            addCriterion("OptDes >=", value, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesLessThan(String value) {
            addCriterion("OptDes <", value, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesLessThanOrEqualTo(String value) {
            addCriterion("OptDes <=", value, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesLike(String value) {
            addCriterion("OptDes like", value, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesNotLike(String value) {
            addCriterion("OptDes not like", value, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesIn(List<String> values) {
            addCriterion("OptDes in", values, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesNotIn(List<String> values) {
            addCriterion("OptDes not in", values, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesBetween(String value1, String value2) {
            addCriterion("OptDes between", value1, value2, "optDes");
            return (Criteria) this;
        }
        public Criteria andOptDesNotBetween(String value1, String value2) {
            addCriterion("OptDes not between", value1, value2, "optDes");
            return (Criteria) this;
        }
        public Criteria andCHLevelIsNull() {
            addCriterion("CHLevel is null");
            return (Criteria) this;
        }
        public Criteria andCHLevelIsNotNull() {
            addCriterion("CHLevel is not null");
            return (Criteria) this;
        }
        public Criteria andCHLevelEqualTo(Short value) {
            addCriterion("CHLevel =", value, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelNotEqualTo(Short value) {
            addCriterion("CHLevel <>", value, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelGreaterThan(Short value) {
            addCriterion("CHLevel >", value, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("CHLevel >=", value, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelLessThan(Short value) {
            addCriterion("CHLevel <", value, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelLessThanOrEqualTo(Short value) {
            addCriterion("CHLevel <=", value, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelIn(List<Short> values) {
            addCriterion("CHLevel in", values, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelNotIn(List<Short> values) {
            addCriterion("CHLevel not in", values, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelBetween(Short value1, Short value2) {
            addCriterion("CHLevel between", value1, value2, "CHLevel");
            return (Criteria) this;
        }
        public Criteria andCHLevelNotBetween(Short value1, Short value2) {
            addCriterion("CHLevel not between", value1, value2, "CHLevel");
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
        public Criteria andOrgidIsNull() {
            addCriterion("orgid is null");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNotNull() {
            addCriterion("orgid is not null");
            return (Criteria) this;
        }
        public Criteria andOrgidEqualTo(Integer value) {
            addCriterion("orgid =", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotEqualTo(Integer value) {
            addCriterion("orgid <>", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThan(Integer value) {
            addCriterion("orgid >", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orgid >=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThan(Integer value) {
            addCriterion("orgid <", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThanOrEqualTo(Integer value) {
            addCriterion("orgid <=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidIn(List<Integer> values) {
            addCriterion("orgid in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotIn(List<Integer> values) {
            addCriterion("orgid not in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidBetween(Integer value1, Integer value2) {
            addCriterion("orgid between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotBetween(Integer value1, Integer value2) {
            addCriterion("orgid not between", value1, value2, "orgid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 选项表(OOPT)
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