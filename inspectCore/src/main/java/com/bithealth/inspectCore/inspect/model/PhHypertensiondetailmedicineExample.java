/*
 * PhHypertensiondetailmedicineExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.model;

import java.util.ArrayList;
import java.util.List;

public class PhHypertensiondetailmedicineExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public PhHypertensiondetailmedicineExample() {
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
     * 公共卫生_高血压随访明细_用药情况表
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
        public Criteria andLogIDIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogIDIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogIDEqualTo(Long value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Long value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Long value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Long value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Long value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Long value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Long> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Long> values) {
        	if(values != null && !values.isEmpty())
        		addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Long value1, Long value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Long value1, Long value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDIsNull() {
            addCriterion("HypertensionID is null");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDIsNotNull() {
            addCriterion("HypertensionID is not null");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDEqualTo(Long value) {
            addCriterion("HypertensionID =", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDNotEqualTo(Integer value) {
            addCriterion("HypertensionID <>", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDGreaterThan(Integer value) {
            addCriterion("HypertensionID >", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("HypertensionID >=", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDLessThan(Integer value) {
            addCriterion("HypertensionID <", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDLessThanOrEqualTo(Integer value) {
            addCriterion("HypertensionID <=", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDIn(List<Long> values) {
            addCriterion("HypertensionID in", values, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDNotIn(List<Integer> values) {
            addCriterion("HypertensionID not in", values, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDBetween(Integer value1, Integer value2) {
            addCriterion("HypertensionID between", value1, value2, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDNotBetween(Integer value1, Integer value2) {
            addCriterion("HypertensionID not between", value1, value2, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andDrugNameIsNull() {
            addCriterion("DrugName is null");
            return (Criteria) this;
        }
        public Criteria andDrugNameIsNotNull() {
            addCriterion("DrugName is not null");
            return (Criteria) this;
        }
        public Criteria andDrugNameEqualTo(String value) {
            addCriterion("DrugName =", value, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameNotEqualTo(String value) {
            addCriterion("DrugName <>", value, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameGreaterThan(String value) {
            addCriterion("DrugName >", value, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameGreaterThanOrEqualTo(String value) {
            addCriterion("DrugName >=", value, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameLessThan(String value) {
            addCriterion("DrugName <", value, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameLessThanOrEqualTo(String value) {
            addCriterion("DrugName <=", value, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameLike(String value) {
            addCriterion("DrugName like", value, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameNotLike(String value) {
            addCriterion("DrugName not like", value, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameIn(List<String> values) {
            addCriterion("DrugName in", values, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameNotIn(List<String> values) {
            addCriterion("DrugName not in", values, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameBetween(String value1, String value2) {
            addCriterion("DrugName between", value1, value2, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugNameNotBetween(String value1, String value2) {
            addCriterion("DrugName not between", value1, value2, "drugName");
            return (Criteria) this;
        }
        public Criteria andDrugUsageIsNull() {
            addCriterion("DrugUsage is null");
            return (Criteria) this;
        }
        public Criteria andDrugUsageIsNotNull() {
            addCriterion("DrugUsage is not null");
            return (Criteria) this;
        }
        public Criteria andDrugUsageEqualTo(String value) {
            addCriterion("DrugUsage =", value, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageNotEqualTo(String value) {
            addCriterion("DrugUsage <>", value, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageGreaterThan(String value) {
            addCriterion("DrugUsage >", value, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageGreaterThanOrEqualTo(String value) {
            addCriterion("DrugUsage >=", value, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageLessThan(String value) {
            addCriterion("DrugUsage <", value, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageLessThanOrEqualTo(String value) {
            addCriterion("DrugUsage <=", value, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageLike(String value) {
            addCriterion("DrugUsage like", value, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageNotLike(String value) {
            addCriterion("DrugUsage not like", value, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageIn(List<String> values) {
            addCriterion("DrugUsage in", values, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageNotIn(List<String> values) {
            addCriterion("DrugUsage not in", values, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageBetween(String value1, String value2) {
            addCriterion("DrugUsage between", value1, value2, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugUsageNotBetween(String value1, String value2) {
            addCriterion("DrugUsage not between", value1, value2, "drugUsage");
            return (Criteria) this;
        }
        public Criteria andDrugFreqIsNull() {
            addCriterion("DrugFreq is null");
            return (Criteria) this;
        }
        public Criteria andDrugFreqIsNotNull() {
            addCriterion("DrugFreq is not null");
            return (Criteria) this;
        }
        public Criteria andDrugFreqEqualTo(String value) {
            addCriterion("DrugFreq =", value, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqNotEqualTo(String value) {
            addCriterion("DrugFreq <>", value, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqGreaterThan(String value) {
            addCriterion("DrugFreq >", value, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqGreaterThanOrEqualTo(String value) {
            addCriterion("DrugFreq >=", value, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqLessThan(String value) {
            addCriterion("DrugFreq <", value, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqLessThanOrEqualTo(String value) {
            addCriterion("DrugFreq <=", value, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqLike(String value) {
            addCriterion("DrugFreq like", value, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqNotLike(String value) {
            addCriterion("DrugFreq not like", value, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqIn(List<String> values) {
            addCriterion("DrugFreq in", values, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqNotIn(List<String> values) {
            addCriterion("DrugFreq not in", values, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqBetween(String value1, String value2) {
            addCriterion("DrugFreq between", value1, value2, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugFreqNotBetween(String value1, String value2) {
            addCriterion("DrugFreq not between", value1, value2, "drugFreq");
            return (Criteria) this;
        }
        public Criteria andDrugDosageIsNull() {
            addCriterion("DrugDosage is null");
            return (Criteria) this;
        }
        public Criteria andDrugDosageIsNotNull() {
            addCriterion("DrugDosage is not null");
            return (Criteria) this;
        }
        public Criteria andDrugDosageEqualTo(String value) {
            addCriterion("DrugDosage =", value, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageNotEqualTo(String value) {
            addCriterion("DrugDosage <>", value, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageGreaterThan(String value) {
            addCriterion("DrugDosage >", value, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageGreaterThanOrEqualTo(String value) {
            addCriterion("DrugDosage >=", value, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageLessThan(String value) {
            addCriterion("DrugDosage <", value, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageLessThanOrEqualTo(String value) {
            addCriterion("DrugDosage <=", value, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageLike(String value) {
            addCriterion("DrugDosage like", value, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageNotLike(String value) {
            addCriterion("DrugDosage not like", value, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageIn(List<String> values) {
            addCriterion("DrugDosage in", values, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageNotIn(List<String> values) {
            addCriterion("DrugDosage not in", values, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageBetween(String value1, String value2) {
            addCriterion("DrugDosage between", value1, value2, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugDosageNotBetween(String value1, String value2) {
            addCriterion("DrugDosage not between", value1, value2, "drugDosage");
            return (Criteria) this;
        }
        public Criteria andDrugUnitIsNull() {
            addCriterion("DrugUnit is null");
            return (Criteria) this;
        }
        public Criteria andDrugUnitIsNotNull() {
            addCriterion("DrugUnit is not null");
            return (Criteria) this;
        }
        public Criteria andDrugUnitEqualTo(String value) {
            addCriterion("DrugUnit =", value, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitNotEqualTo(String value) {
            addCriterion("DrugUnit <>", value, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitGreaterThan(String value) {
            addCriterion("DrugUnit >", value, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitGreaterThanOrEqualTo(String value) {
            addCriterion("DrugUnit >=", value, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitLessThan(String value) {
            addCriterion("DrugUnit <", value, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitLessThanOrEqualTo(String value) {
            addCriterion("DrugUnit <=", value, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitLike(String value) {
            addCriterion("DrugUnit like", value, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitNotLike(String value) {
            addCriterion("DrugUnit not like", value, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitIn(List<String> values) {
            addCriterion("DrugUnit in", values, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitNotIn(List<String> values) {
            addCriterion("DrugUnit not in", values, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitBetween(String value1, String value2) {
            addCriterion("DrugUnit between", value1, value2, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andDrugUnitNotBetween(String value1, String value2) {
            addCriterion("DrugUnit not between", value1, value2, "drugUnit");
            return (Criteria) this;
        }
        public Criteria andRemarksIsNull() {
            addCriterion("Remarks is null");
            return (Criteria) this;
        }
        public Criteria andRemarksIsNotNull() {
            addCriterion("Remarks is not null");
            return (Criteria) this;
        }
        public Criteria andRemarksEqualTo(String value) {
            addCriterion("Remarks =", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("Remarks <>", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("Remarks >", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("Remarks >=", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksLessThan(String value) {
            addCriterion("Remarks <", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("Remarks <=", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksLike(String value) {
            addCriterion("Remarks like", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksNotLike(String value) {
            addCriterion("Remarks not like", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksIn(List<String> values) {
            addCriterion("Remarks in", values, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("Remarks not in", values, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("Remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("Remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 公共卫生_高血压随访明细_用药情况表
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