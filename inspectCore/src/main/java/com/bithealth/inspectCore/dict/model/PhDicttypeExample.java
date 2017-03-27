/*
 * PhDicttypeExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.dict.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhDicttypeExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public PhDicttypeExample() {
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
     * 公共卫生_字典类型表
     * 
     * @author ${user}
     * @version 1.0 2016-06-28
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
        public Criteria andDTypeIDIsNull() {
            addCriterion("DTypeID is null");
            return (Criteria) this;
        }
        public Criteria andDTypeIDIsNotNull() {
            addCriterion("DTypeID is not null");
            return (Criteria) this;
        }
        public Criteria andDTypeIDEqualTo(Short value) {
            addCriterion("DTypeID =", value, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDNotEqualTo(Short value) {
            addCriterion("DTypeID <>", value, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDGreaterThan(Short value) {
            addCriterion("DTypeID >", value, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDGreaterThanOrEqualTo(Short value) {
            addCriterion("DTypeID >=", value, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDLessThan(Short value) {
            addCriterion("DTypeID <", value, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDLessThanOrEqualTo(Short value) {
            addCriterion("DTypeID <=", value, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDIn(List<Short> values) {
            addCriterion("DTypeID in", values, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDNotIn(List<Short> values) {
            addCriterion("DTypeID not in", values, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDBetween(Short value1, Short value2) {
            addCriterion("DTypeID between", value1, value2, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeIDNotBetween(Short value1, Short value2) {
            addCriterion("DTypeID not between", value1, value2, "DTypeID");
            return (Criteria) this;
        }
        public Criteria andDTypeNameIsNull() {
            addCriterion("DTypeName is null");
            return (Criteria) this;
        }
        public Criteria andDTypeNameIsNotNull() {
            addCriterion("DTypeName is not null");
            return (Criteria) this;
        }
        public Criteria andDTypeNameEqualTo(String value) {
            addCriterion("DTypeName =", value, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameNotEqualTo(String value) {
            addCriterion("DTypeName <>", value, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameGreaterThan(String value) {
            addCriterion("DTypeName >", value, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("DTypeName >=", value, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameLessThan(String value) {
            addCriterion("DTypeName <", value, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameLessThanOrEqualTo(String value) {
            addCriterion("DTypeName <=", value, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameLike(String value) {
            addCriterion("DTypeName like", value, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameNotLike(String value) {
            addCriterion("DTypeName not like", value, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameIn(List<String> values) {
            addCriterion("DTypeName in", values, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameNotIn(List<String> values) {
            addCriterion("DTypeName not in", values, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameBetween(String value1, String value2) {
            addCriterion("DTypeName between", value1, value2, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andDTypeNameNotBetween(String value1, String value2) {
            addCriterion("DTypeName not between", value1, value2, "DTypeName");
            return (Criteria) this;
        }
        public Criteria andSourceIsNull() {
            addCriterion("Source is null");
            return (Criteria) this;
        }
        public Criteria andSourceIsNotNull() {
            addCriterion("Source is not null");
            return (Criteria) this;
        }
        public Criteria andSourceEqualTo(String value) {
            addCriterion("Source =", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("Source <>", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceGreaterThan(String value) {
            addCriterion("Source >", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("Source >=", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceLessThan(String value) {
            addCriterion("Source <", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("Source <=", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceLike(String value) {
            addCriterion("Source like", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceNotLike(String value) {
            addCriterion("Source not like", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceIn(List<String> values) {
            addCriterion("Source in", values, "source");
            return (Criteria) this;
        }
        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("Source not in", values, "source");
            return (Criteria) this;
        }
        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("Source between", value1, value2, "source");
            return (Criteria) this;
        }
        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("Source not between", value1, value2, "source");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 公共卫生_字典类型表
     * 
     * @author ${user}
     * @version 1.0 2016-06-28
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