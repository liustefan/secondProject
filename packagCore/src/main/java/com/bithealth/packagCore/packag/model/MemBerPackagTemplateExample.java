/*
 * MemBerPackagTemplateExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-07 Created
 */
package com.bithealth.packagCore.packag.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MemBerPackagTemplateExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemBerPackagTemplateExample() {
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
     * 与PSP1表对应
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
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                 return;
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }
        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                  return;//
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }
        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                  return;//
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }
        public Criteria andMemberidIsNull() {
            addCriterion("Memberid is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("Memberid is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("Memberid =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("Memberid <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("Memberid >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Memberid >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("Memberid <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("Memberid <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("Memberid in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("Memberid not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("Memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("Memberid not between", value1, value2, "memberid");
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
        public Criteria andSubmitNumIsNull() {
            addCriterion("SubmitNum is null");
            return (Criteria) this;
        }
        public Criteria andSubmitNumIsNotNull() {
            addCriterion("SubmitNum is not null");
            return (Criteria) this;
        }
        public Criteria andSubmitNumEqualTo(Short value) {
            addCriterion("SubmitNum =", value, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumNotEqualTo(Short value) {
            addCriterion("SubmitNum <>", value, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumGreaterThan(Short value) {
            addCriterion("SubmitNum >", value, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumGreaterThanOrEqualTo(Short value) {
            addCriterion("SubmitNum >=", value, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumLessThan(Short value) {
            addCriterion("SubmitNum <", value, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumLessThanOrEqualTo(Short value) {
            addCriterion("SubmitNum <=", value, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumIn(List<Short> values) {
            addCriterion("SubmitNum in", values, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumNotIn(List<Short> values) {
            addCriterion("SubmitNum not in", values, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumBetween(Short value1, Short value2) {
            addCriterion("SubmitNum between", value1, value2, "submitNum");
            return (Criteria) this;
        }
        public Criteria andSubmitNumNotBetween(Short value1, Short value2) {
            addCriterion("SubmitNum not between", value1, value2, "submitNum");
            return (Criteria) this;
        }
        public Criteria andBeginDateIsNull() {
            addCriterion("BeginDate is null");
            return (Criteria) this;
        }
        public Criteria andBeginDateIsNotNull() {
            addCriterion("BeginDate is not null");
            return (Criteria) this;
        }
        public Criteria andBeginDateEqualTo(Date value) {
            addCriterionForJDBCDate("BeginDate =", value, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("BeginDate <>", value, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterionForJDBCDate("BeginDate >", value, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BeginDate >=", value, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateLessThan(Date value) {
            addCriterionForJDBCDate("BeginDate <", value, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BeginDate <=", value, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateIn(List<Date> values) {
            addCriterionForJDBCDate("BeginDate in", values, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("BeginDate not in", values, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BeginDate between", value1, value2, "beginDate");
            return (Criteria) this;
        }
        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BeginDate not between", value1, value2, "beginDate");
            return (Criteria) this;
        }
        public Criteria andEndDateIsNull() {
            addCriterion("EndDate is null");
            return (Criteria) this;
        }
        public Criteria andEndDateIsNotNull() {
            addCriterion("EndDate is not null");
            return (Criteria) this;
        }
        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("EndDate =", value, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("EndDate <>", value, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("EndDate >", value, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EndDate >=", value, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("EndDate <", value, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EndDate <=", value, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("EndDate in", values, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("EndDate not in", values, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EndDate between", value1, value2, "endDate");
            return (Criteria) this;
        }
        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EndDate not between", value1, value2, "endDate");
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
     * 与PSP1表对应
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