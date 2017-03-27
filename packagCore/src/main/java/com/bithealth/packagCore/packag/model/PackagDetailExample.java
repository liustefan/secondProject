/*
 * PackagDetailExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-07 Created
 */
package com.bithealth.packagCore.packag.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PackagDetailExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public PackagDetailExample() {
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
     * 套餐明细（PSP1）
     * 
     * @author ${user}
     * @version 1.0 2016-07-07
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
        public Criteria andPackageCodeIsNull() {
            addCriterion("PackageCode is null");
            return (Criteria) this;
        }
        public Criteria andPackageCodeIsNotNull() {
            addCriterion("PackageCode is not null");
            return (Criteria) this;
        }
        public Criteria andPackageCodeEqualTo(Integer value) {
            addCriterion("PackageCode =", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeNotEqualTo(Integer value) {
            addCriterion("PackageCode <>", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeGreaterThan(Integer value) {
            addCriterion("PackageCode >", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PackageCode >=", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeLessThan(Integer value) {
            addCriterion("PackageCode <", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeLessThanOrEqualTo(Integer value) {
            addCriterion("PackageCode <=", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeIn(List<Integer> values) {
            addCriterion("PackageCode in", values, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeNotIn(List<Integer> values) {
            addCriterion("PackageCode not in", values, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeBetween(Integer value1, Integer value2) {
            addCriterion("PackageCode between", value1, value2, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("PackageCode not between", value1, value2, "packageCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeIsNull() {
            addCriterion("SumRepTempCode is null");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeIsNotNull() {
            addCriterion("SumRepTempCode is not null");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeEqualTo(Integer value) {
            addCriterion("SumRepTempCode =", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotEqualTo(Integer value) {
            addCriterion("SumRepTempCode <>", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeGreaterThan(Integer value) {
            addCriterion("SumRepTempCode >", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SumRepTempCode >=", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeLessThan(Integer value) {
            addCriterion("SumRepTempCode <", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeLessThanOrEqualTo(Integer value) {
            addCriterion("SumRepTempCode <=", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeIn(List<Integer> values) {
            addCriterion("SumRepTempCode in", values, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotIn(List<Integer> values) {
            addCriterion("SumRepTempCode not in", values, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeBetween(Integer value1, Integer value2) {
            addCriterion("SumRepTempCode between", value1, value2, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("SumRepTempCode not between", value1, value2, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andNumTimesIsNull() {
            addCriterion("NumTimes is null");
            return (Criteria) this;
        }
        public Criteria andNumTimesIsNotNull() {
            addCriterion("NumTimes is not null");
            return (Criteria) this;
        }
        public Criteria andNumTimesEqualTo(Short value) {
            addCriterion("NumTimes =", value, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesNotEqualTo(Short value) {
            addCriterion("NumTimes <>", value, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesGreaterThan(Short value) {
            addCriterion("NumTimes >", value, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("NumTimes >=", value, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesLessThan(Short value) {
            addCriterion("NumTimes <", value, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesLessThanOrEqualTo(Short value) {
            addCriterion("NumTimes <=", value, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesIn(List<Short> values) {
            addCriterion("NumTimes in", values, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesNotIn(List<Short> values) {
            addCriterion("NumTimes not in", values, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesBetween(Short value1, Short value2) {
            addCriterion("NumTimes between", value1, value2, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumTimesNotBetween(Short value1, Short value2) {
            addCriterion("NumTimes not between", value1, value2, "numTimes");
            return (Criteria) this;
        }
        public Criteria andNumDayIsNull() {
            addCriterion("NumDay is null");
            return (Criteria) this;
        }
        public Criteria andNumDayIsNotNull() {
            addCriterion("NumDay is not null");
            return (Criteria) this;
        }
        public Criteria andNumDayEqualTo(Short value) {
            addCriterion("NumDay =", value, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayNotEqualTo(Short value) {
            addCriterion("NumDay <>", value, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayGreaterThan(Short value) {
            addCriterion("NumDay >", value, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayGreaterThanOrEqualTo(Short value) {
            addCriterion("NumDay >=", value, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayLessThan(Short value) {
            addCriterion("NumDay <", value, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayLessThanOrEqualTo(Short value) {
            addCriterion("NumDay <=", value, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayIn(List<Short> values) {
            addCriterion("NumDay in", values, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayNotIn(List<Short> values) {
            addCriterion("NumDay not in", values, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayBetween(Short value1, Short value2) {
            addCriterion("NumDay between", value1, value2, "numDay");
            return (Criteria) this;
        }
        public Criteria andNumDayNotBetween(Short value1, Short value2) {
            addCriterion("NumDay not between", value1, value2, "numDay");
            return (Criteria) this;
        }
        public Criteria andCalcTypeIsNull() {
            addCriterion("CalcType is null");
            return (Criteria) this;
        }
        public Criteria andCalcTypeIsNotNull() {
            addCriterion("CalcType is not null");
            return (Criteria) this;
        }
        public Criteria andCalcTypeEqualTo(String value) {
            addCriterion("CalcType =", value, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeNotEqualTo(String value) {
            addCriterion("CalcType <>", value, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeGreaterThan(String value) {
            addCriterion("CalcType >", value, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CalcType >=", value, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeLessThan(String value) {
            addCriterion("CalcType <", value, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeLessThanOrEqualTo(String value) {
            addCriterion("CalcType <=", value, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeLike(String value) {
            addCriterion("CalcType like", value, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeNotLike(String value) {
            addCriterion("CalcType not like", value, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeIn(List<String> values) {
            addCriterion("CalcType in", values, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeNotIn(List<String> values) {
            addCriterion("CalcType not in", values, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeBetween(String value1, String value2) {
            addCriterion("CalcType between", value1, value2, "calcType");
            return (Criteria) this;
        }
        public Criteria andCalcTypeNotBetween(String value1, String value2) {
            addCriterion("CalcType not between", value1, value2, "calcType");
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
        public Criteria andCreateidIsNull() {
            addCriterion("Createid is null");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNotNull() {
            addCriterion("Createid is not null");
            return (Criteria) this;
        }
        public Criteria andCreateidEqualTo(Integer value) {
            addCriterion("Createid =", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotEqualTo(Integer value) {
            addCriterion("Createid <>", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThan(Integer value) {
            addCriterion("Createid >", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Createid >=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThan(Integer value) {
            addCriterion("Createid <", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThanOrEqualTo(Integer value) {
            addCriterion("Createid <=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidIn(List<Integer> values) {
            addCriterion("Createid in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotIn(List<Integer> values) {
            addCriterion("Createid not in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidBetween(Integer value1, Integer value2) {
            addCriterion("Createid between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotBetween(Integer value1, Integer value2) {
            addCriterion("Createid not between", value1, value2, "createid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 套餐明细（PSP1）
     * 
     * @author ${user}
     * @version 1.0 2016-07-07
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