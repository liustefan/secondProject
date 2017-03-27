/*
 * PhHealthexamdetailExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-27 Created
 */
package com.bithealth.inspectCore.physical.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PhHealthexamdetailExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public PhHealthexamdetailExample() {
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
     * 公共卫生_健康体检明细表
     * 
     * @author ${user}
     * @version 1.0 2016-06-27
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
        public Criteria andHExamIDIsNull() {
            addCriterion("HExamID is null");
            return (Criteria) this;
        }
        public Criteria andHExamIDIsNotNull() {
            addCriterion("HExamID is not null");
            return (Criteria) this;
        }
        public Criteria andHExamIDEqualTo(Long value) {
            addCriterion("HExamID =", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDNotEqualTo(Long value) {
            addCriterion("HExamID <>", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDGreaterThan(Long value) {
            addCriterion("HExamID >", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDGreaterThanOrEqualTo(Long value) {
            addCriterion("HExamID >=", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDLessThan(Long value) {
            addCriterion("HExamID <", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDLessThanOrEqualTo(Long value) {
            addCriterion("HExamID <=", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDIn(List<Long> values) {
            addCriterion("HExamID in", values, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDNotIn(List<Long> values) {
            addCriterion("HExamID not in", values, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDBetween(Long value1, Long value2) {
            addCriterion("HExamID between", value1, value2, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDNotBetween(Long value1, Long value2) {
            addCriterion("HExamID not between", value1, value2, "HExamID");
            return (Criteria) this;
        }
        public Criteria andSymptomIsNull() {
            addCriterion("Symptom is null");
            return (Criteria) this;
        }
        public Criteria andSymptomIsNotNull() {
            addCriterion("Symptom is not null");
            return (Criteria) this;
        }
        public Criteria andSymptomEqualTo(String value) {
            addCriterion("Symptom =", value, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomNotEqualTo(String value) {
            addCriterion("Symptom <>", value, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomGreaterThan(String value) {
            addCriterion("Symptom >", value, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomGreaterThanOrEqualTo(String value) {
            addCriterion("Symptom >=", value, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomLessThan(String value) {
            addCriterion("Symptom <", value, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomLessThanOrEqualTo(String value) {
            addCriterion("Symptom <=", value, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomLike(String value) {
            addCriterion("Symptom like", value, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomNotLike(String value) {
            addCriterion("Symptom not like", value, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomIn(List<String> values) {
            addCriterion("Symptom in", values, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomNotIn(List<String> values) {
            addCriterion("Symptom not in", values, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomBetween(String value1, String value2) {
            addCriterion("Symptom between", value1, value2, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptomNotBetween(String value1, String value2) {
            addCriterion("Symptom not between", value1, value2, "symptom");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescIsNull() {
            addCriterion("Symptom_Desc is null");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescIsNotNull() {
            addCriterion("Symptom_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescEqualTo(String value) {
            addCriterion("Symptom_Desc =", value, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescNotEqualTo(String value) {
            addCriterion("Symptom_Desc <>", value, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescGreaterThan(String value) {
            addCriterion("Symptom_Desc >", value, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Symptom_Desc >=", value, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescLessThan(String value) {
            addCriterion("Symptom_Desc <", value, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescLessThanOrEqualTo(String value) {
            addCriterion("Symptom_Desc <=", value, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescLike(String value) {
            addCriterion("Symptom_Desc like", value, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescNotLike(String value) {
            addCriterion("Symptom_Desc not like", value, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescIn(List<String> values) {
            addCriterion("Symptom_Desc in", values, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescNotIn(List<String> values) {
            addCriterion("Symptom_Desc not in", values, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescBetween(String value1, String value2) {
            addCriterion("Symptom_Desc between", value1, value2, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andSymptom_DescNotBetween(String value1, String value2) {
            addCriterion("Symptom_Desc not between", value1, value2, "symptom_Desc");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureIsNull() {
            addCriterion("BodyTemperature is null");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureIsNotNull() {
            addCriterion("BodyTemperature is not null");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureEqualTo(BigDecimal value) {
            addCriterion("BodyTemperature =", value, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureNotEqualTo(BigDecimal value) {
            addCriterion("BodyTemperature <>", value, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureGreaterThan(BigDecimal value) {
            addCriterion("BodyTemperature >", value, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BodyTemperature >=", value, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureLessThan(BigDecimal value) {
            addCriterion("BodyTemperature <", value, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BodyTemperature <=", value, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureIn(List<BigDecimal> values) {
            addCriterion("BodyTemperature in", values, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureNotIn(List<BigDecimal> values) {
            addCriterion("BodyTemperature not in", values, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BodyTemperature between", value1, value2, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andBodyTemperatureNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BodyTemperature not between", value1, value2, "bodyTemperature");
            return (Criteria) this;
        }
        public Criteria andPulseRateIsNull() {
            addCriterion("PulseRate is null");
            return (Criteria) this;
        }
        public Criteria andPulseRateIsNotNull() {
            addCriterion("PulseRate is not null");
            return (Criteria) this;
        }
        public Criteria andPulseRateEqualTo(Short value) {
            addCriterion("PulseRate =", value, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateNotEqualTo(Short value) {
            addCriterion("PulseRate <>", value, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateGreaterThan(Short value) {
            addCriterion("PulseRate >", value, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateGreaterThanOrEqualTo(Short value) {
            addCriterion("PulseRate >=", value, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateLessThan(Short value) {
            addCriterion("PulseRate <", value, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateLessThanOrEqualTo(Short value) {
            addCriterion("PulseRate <=", value, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateIn(List<Short> values) {
            addCriterion("PulseRate in", values, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateNotIn(List<Short> values) {
            addCriterion("PulseRate not in", values, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateBetween(Short value1, Short value2) {
            addCriterion("PulseRate between", value1, value2, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andPulseRateNotBetween(Short value1, Short value2) {
            addCriterion("PulseRate not between", value1, value2, "pulseRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateIsNull() {
            addCriterion("RespiratoryRate is null");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateIsNotNull() {
            addCriterion("RespiratoryRate is not null");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateEqualTo(Short value) {
            addCriterion("RespiratoryRate =", value, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateNotEqualTo(Short value) {
            addCriterion("RespiratoryRate <>", value, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateGreaterThan(Short value) {
            addCriterion("RespiratoryRate >", value, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateGreaterThanOrEqualTo(Short value) {
            addCriterion("RespiratoryRate >=", value, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateLessThan(Short value) {
            addCriterion("RespiratoryRate <", value, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateLessThanOrEqualTo(Short value) {
            addCriterion("RespiratoryRate <=", value, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateIn(List<Short> values) {
            addCriterion("RespiratoryRate in", values, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateNotIn(List<Short> values) {
            addCriterion("RespiratoryRate not in", values, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateBetween(Short value1, Short value2) {
            addCriterion("RespiratoryRate between", value1, value2, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andRespiratoryRateNotBetween(Short value1, Short value2) {
            addCriterion("RespiratoryRate not between", value1, value2, "respiratoryRate");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicIsNull() {
            addCriterion("LeftSystolic is null");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicIsNotNull() {
            addCriterion("LeftSystolic is not null");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicEqualTo(Short value) {
            addCriterion("LeftSystolic =", value, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicNotEqualTo(Short value) {
            addCriterion("LeftSystolic <>", value, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicGreaterThan(Short value) {
            addCriterion("LeftSystolic >", value, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicGreaterThanOrEqualTo(Short value) {
            addCriterion("LeftSystolic >=", value, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicLessThan(Short value) {
            addCriterion("LeftSystolic <", value, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicLessThanOrEqualTo(Short value) {
            addCriterion("LeftSystolic <=", value, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicIn(List<Short> values) {
            addCriterion("LeftSystolic in", values, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicNotIn(List<Short> values) {
            addCriterion("LeftSystolic not in", values, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicBetween(Short value1, Short value2) {
            addCriterion("LeftSystolic between", value1, value2, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftSystolicNotBetween(Short value1, Short value2) {
            addCriterion("LeftSystolic not between", value1, value2, "leftSystolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicIsNull() {
            addCriterion("LeftDiastolic is null");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicIsNotNull() {
            addCriterion("LeftDiastolic is not null");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicEqualTo(Short value) {
            addCriterion("LeftDiastolic =", value, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicNotEqualTo(Short value) {
            addCriterion("LeftDiastolic <>", value, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicGreaterThan(Short value) {
            addCriterion("LeftDiastolic >", value, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicGreaterThanOrEqualTo(Short value) {
            addCriterion("LeftDiastolic >=", value, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicLessThan(Short value) {
            addCriterion("LeftDiastolic <", value, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicLessThanOrEqualTo(Short value) {
            addCriterion("LeftDiastolic <=", value, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicIn(List<Short> values) {
            addCriterion("LeftDiastolic in", values, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicNotIn(List<Short> values) {
            addCriterion("LeftDiastolic not in", values, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicBetween(Short value1, Short value2) {
            addCriterion("LeftDiastolic between", value1, value2, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andLeftDiastolicNotBetween(Short value1, Short value2) {
            addCriterion("LeftDiastolic not between", value1, value2, "leftDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicIsNull() {
            addCriterion("RightSystolic is null");
            return (Criteria) this;
        }
        public Criteria andRightSystolicIsNotNull() {
            addCriterion("RightSystolic is not null");
            return (Criteria) this;
        }
        public Criteria andRightSystolicEqualTo(Short value) {
            addCriterion("RightSystolic =", value, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicNotEqualTo(Short value) {
            addCriterion("RightSystolic <>", value, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicGreaterThan(Short value) {
            addCriterion("RightSystolic >", value, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicGreaterThanOrEqualTo(Short value) {
            addCriterion("RightSystolic >=", value, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicLessThan(Short value) {
            addCriterion("RightSystolic <", value, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicLessThanOrEqualTo(Short value) {
            addCriterion("RightSystolic <=", value, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicIn(List<Short> values) {
            addCriterion("RightSystolic in", values, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicNotIn(List<Short> values) {
            addCriterion("RightSystolic not in", values, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicBetween(Short value1, Short value2) {
            addCriterion("RightSystolic between", value1, value2, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightSystolicNotBetween(Short value1, Short value2) {
            addCriterion("RightSystolic not between", value1, value2, "rightSystolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicIsNull() {
            addCriterion("RightDiastolic is null");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicIsNotNull() {
            addCriterion("RightDiastolic is not null");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicEqualTo(Short value) {
            addCriterion("RightDiastolic =", value, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicNotEqualTo(Short value) {
            addCriterion("RightDiastolic <>", value, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicGreaterThan(Short value) {
            addCriterion("RightDiastolic >", value, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicGreaterThanOrEqualTo(Short value) {
            addCriterion("RightDiastolic >=", value, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicLessThan(Short value) {
            addCriterion("RightDiastolic <", value, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicLessThanOrEqualTo(Short value) {
            addCriterion("RightDiastolic <=", value, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicIn(List<Short> values) {
            addCriterion("RightDiastolic in", values, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicNotIn(List<Short> values) {
            addCriterion("RightDiastolic not in", values, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicBetween(Short value1, Short value2) {
            addCriterion("RightDiastolic between", value1, value2, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andRightDiastolicNotBetween(Short value1, Short value2) {
            addCriterion("RightDiastolic not between", value1, value2, "rightDiastolic");
            return (Criteria) this;
        }
        public Criteria andHeightIsNull() {
            addCriterion("Height is null");
            return (Criteria) this;
        }
        public Criteria andHeightIsNotNull() {
            addCriterion("Height is not null");
            return (Criteria) this;
        }
        public Criteria andHeightEqualTo(BigDecimal value) {
            addCriterion("Height =", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightNotEqualTo(BigDecimal value) {
            addCriterion("Height <>", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightGreaterThan(BigDecimal value) {
            addCriterion("Height >", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Height >=", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightLessThan(BigDecimal value) {
            addCriterion("Height <", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Height <=", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightIn(List<BigDecimal> values) {
            addCriterion("Height in", values, "height");
            return (Criteria) this;
        }
        public Criteria andHeightNotIn(List<BigDecimal> values) {
            addCriterion("Height not in", values, "height");
            return (Criteria) this;
        }
        public Criteria andHeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Height between", value1, value2, "height");
            return (Criteria) this;
        }
        public Criteria andHeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Height not between", value1, value2, "height");
            return (Criteria) this;
        }
        public Criteria andWeightIsNull() {
            addCriterion("Weight is null");
            return (Criteria) this;
        }
        public Criteria andWeightIsNotNull() {
            addCriterion("Weight is not null");
            return (Criteria) this;
        }
        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("Weight =", value, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("Weight <>", value, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("Weight >", value, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Weight >=", value, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("Weight <", value, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Weight <=", value, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("Weight in", values, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("Weight not in", values, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Weight between", value1, value2, "weight");
            return (Criteria) this;
        }
        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Weight not between", value1, value2, "weight");
            return (Criteria) this;
        }
        public Criteria andWaistIsNull() {
            addCriterion("Waist is null");
            return (Criteria) this;
        }
        public Criteria andWaistIsNotNull() {
            addCriterion("Waist is not null");
            return (Criteria) this;
        }
        public Criteria andWaistEqualTo(BigDecimal value) {
            addCriterion("Waist =", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistNotEqualTo(BigDecimal value) {
            addCriterion("Waist <>", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistGreaterThan(BigDecimal value) {
            addCriterion("Waist >", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Waist >=", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistLessThan(BigDecimal value) {
            addCriterion("Waist <", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Waist <=", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistIn(List<BigDecimal> values) {
            addCriterion("Waist in", values, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistNotIn(List<BigDecimal> values) {
            addCriterion("Waist not in", values, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Waist between", value1, value2, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Waist not between", value1, value2, "waist");
            return (Criteria) this;
        }
        public Criteria andBMIIsNull() {
            addCriterion("BMI is null");
            return (Criteria) this;
        }
        public Criteria andBMIIsNotNull() {
            addCriterion("BMI is not null");
            return (Criteria) this;
        }
        public Criteria andBMIEqualTo(BigDecimal value) {
            addCriterion("BMI =", value, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMINotEqualTo(BigDecimal value) {
            addCriterion("BMI <>", value, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMIGreaterThan(BigDecimal value) {
            addCriterion("BMI >", value, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMIGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BMI >=", value, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMILessThan(BigDecimal value) {
            addCriterion("BMI <", value, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMILessThanOrEqualTo(BigDecimal value) {
            addCriterion("BMI <=", value, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMIIn(List<BigDecimal> values) {
            addCriterion("BMI in", values, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMINotIn(List<BigDecimal> values) {
            addCriterion("BMI not in", values, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMIBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BMI between", value1, value2, "BMI");
            return (Criteria) this;
        }
        public Criteria andBMINotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BMI not between", value1, value2, "BMI");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateIsNull() {
            addCriterion("AgedHealthEvaluate is null");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateIsNotNull() {
            addCriterion("AgedHealthEvaluate is not null");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateEqualTo(Byte value) {
            addCriterion("AgedHealthEvaluate =", value, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateNotEqualTo(Byte value) {
            addCriterion("AgedHealthEvaluate <>", value, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateGreaterThan(Byte value) {
            addCriterion("AgedHealthEvaluate >", value, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateGreaterThanOrEqualTo(Byte value) {
            addCriterion("AgedHealthEvaluate >=", value, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateLessThan(Byte value) {
            addCriterion("AgedHealthEvaluate <", value, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateLessThanOrEqualTo(Byte value) {
            addCriterion("AgedHealthEvaluate <=", value, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateIn(List<Byte> values) {
            addCriterion("AgedHealthEvaluate in", values, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateNotIn(List<Byte> values) {
            addCriterion("AgedHealthEvaluate not in", values, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateBetween(Byte value1, Byte value2) {
            addCriterion("AgedHealthEvaluate between", value1, value2, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedHealthEvaluateNotBetween(Byte value1, Byte value2) {
            addCriterion("AgedHealthEvaluate not between", value1, value2, "agedHealthEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateIsNull() {
            addCriterion("AgedLifeEvaluate is null");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateIsNotNull() {
            addCriterion("AgedLifeEvaluate is not null");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateEqualTo(Byte value) {
            addCriterion("AgedLifeEvaluate =", value, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateNotEqualTo(Byte value) {
            addCriterion("AgedLifeEvaluate <>", value, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateGreaterThan(Byte value) {
            addCriterion("AgedLifeEvaluate >", value, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateGreaterThanOrEqualTo(Byte value) {
            addCriterion("AgedLifeEvaluate >=", value, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateLessThan(Byte value) {
            addCriterion("AgedLifeEvaluate <", value, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateLessThanOrEqualTo(Byte value) {
            addCriterion("AgedLifeEvaluate <=", value, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateIn(List<Byte> values) {
            addCriterion("AgedLifeEvaluate in", values, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateNotIn(List<Byte> values) {
            addCriterion("AgedLifeEvaluate not in", values, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateBetween(Byte value1, Byte value2) {
            addCriterion("AgedLifeEvaluate between", value1, value2, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedLifeEvaluateNotBetween(Byte value1, Byte value2) {
            addCriterion("AgedLifeEvaluate not between", value1, value2, "agedLifeEvaluate");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionIsNull() {
            addCriterion("AgedCognition is null");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionIsNotNull() {
            addCriterion("AgedCognition is not null");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionEqualTo(Byte value) {
            addCriterion("AgedCognition =", value, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionNotEqualTo(Byte value) {
            addCriterion("AgedCognition <>", value, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionGreaterThan(Byte value) {
            addCriterion("AgedCognition >", value, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionGreaterThanOrEqualTo(Byte value) {
            addCriterion("AgedCognition >=", value, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionLessThan(Byte value) {
            addCriterion("AgedCognition <", value, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionLessThanOrEqualTo(Byte value) {
            addCriterion("AgedCognition <=", value, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionIn(List<Byte> values) {
            addCriterion("AgedCognition in", values, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionNotIn(List<Byte> values) {
            addCriterion("AgedCognition not in", values, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionBetween(Byte value1, Byte value2) {
            addCriterion("AgedCognition between", value1, value2, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionNotBetween(Byte value1, Byte value2) {
            addCriterion("AgedCognition not between", value1, value2, "agedCognition");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreIsNull() {
            addCriterion("AgedCognitionScore is null");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreIsNotNull() {
            addCriterion("AgedCognitionScore is not null");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreEqualTo(Byte value) {
            addCriterion("AgedCognitionScore =", value, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreNotEqualTo(Byte value) {
            addCriterion("AgedCognitionScore <>", value, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreGreaterThan(Byte value) {
            addCriterion("AgedCognitionScore >", value, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("AgedCognitionScore >=", value, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreLessThan(Byte value) {
            addCriterion("AgedCognitionScore <", value, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreLessThanOrEqualTo(Byte value) {
            addCriterion("AgedCognitionScore <=", value, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreIn(List<Byte> values) {
            addCriterion("AgedCognitionScore in", values, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreNotIn(List<Byte> values) {
            addCriterion("AgedCognitionScore not in", values, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreBetween(Byte value1, Byte value2) {
            addCriterion("AgedCognitionScore between", value1, value2, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedCognitionScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("AgedCognitionScore not between", value1, value2, "agedCognitionScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingIsNull() {
            addCriterion("AgedFeeling is null");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingIsNotNull() {
            addCriterion("AgedFeeling is not null");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingEqualTo(Byte value) {
            addCriterion("AgedFeeling =", value, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingNotEqualTo(Byte value) {
            addCriterion("AgedFeeling <>", value, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingGreaterThan(Byte value) {
            addCriterion("AgedFeeling >", value, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingGreaterThanOrEqualTo(Byte value) {
            addCriterion("AgedFeeling >=", value, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingLessThan(Byte value) {
            addCriterion("AgedFeeling <", value, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingLessThanOrEqualTo(Byte value) {
            addCriterion("AgedFeeling <=", value, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingIn(List<Byte> values) {
            addCriterion("AgedFeeling in", values, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingNotIn(List<Byte> values) {
            addCriterion("AgedFeeling not in", values, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingBetween(Byte value1, Byte value2) {
            addCriterion("AgedFeeling between", value1, value2, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingNotBetween(Byte value1, Byte value2) {
            addCriterion("AgedFeeling not between", value1, value2, "agedFeeling");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreIsNull() {
            addCriterion("AgedFeelingScore is null");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreIsNotNull() {
            addCriterion("AgedFeelingScore is not null");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreEqualTo(Byte value) {
            addCriterion("AgedFeelingScore =", value, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreNotEqualTo(Byte value) {
            addCriterion("AgedFeelingScore <>", value, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreGreaterThan(Byte value) {
            addCriterion("AgedFeelingScore >", value, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("AgedFeelingScore >=", value, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreLessThan(Byte value) {
            addCriterion("AgedFeelingScore <", value, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreLessThanOrEqualTo(Byte value) {
            addCriterion("AgedFeelingScore <=", value, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreIn(List<Byte> values) {
            addCriterion("AgedFeelingScore in", values, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreNotIn(List<Byte> values) {
            addCriterion("AgedFeelingScore not in", values, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreBetween(Byte value1, Byte value2) {
            addCriterion("AgedFeelingScore between", value1, value2, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andAgedFeelingScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("AgedFeelingScore not between", value1, value2, "agedFeelingScore");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyIsNull() {
            addCriterion("SportFrequency is null");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyIsNotNull() {
            addCriterion("SportFrequency is not null");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyEqualTo(Byte value) {
            addCriterion("SportFrequency =", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyNotEqualTo(Byte value) {
            addCriterion("SportFrequency <>", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyGreaterThan(Byte value) {
            addCriterion("SportFrequency >", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyGreaterThanOrEqualTo(Byte value) {
            addCriterion("SportFrequency >=", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyLessThan(Byte value) {
            addCriterion("SportFrequency <", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyLessThanOrEqualTo(Byte value) {
            addCriterion("SportFrequency <=", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyIn(List<Byte> values) {
            addCriterion("SportFrequency in", values, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyNotIn(List<Byte> values) {
            addCriterion("SportFrequency not in", values, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyBetween(Byte value1, Byte value2) {
            addCriterion("SportFrequency between", value1, value2, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyNotBetween(Byte value1, Byte value2) {
            addCriterion("SportFrequency not between", value1, value2, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportDurationIsNull() {
            addCriterion("SportDuration is null");
            return (Criteria) this;
        }
        public Criteria andSportDurationIsNotNull() {
            addCriterion("SportDuration is not null");
            return (Criteria) this;
        }
        public Criteria andSportDurationEqualTo(Short value) {
            addCriterion("SportDuration =", value, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationNotEqualTo(Short value) {
            addCriterion("SportDuration <>", value, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationGreaterThan(Short value) {
            addCriterion("SportDuration >", value, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationGreaterThanOrEqualTo(Short value) {
            addCriterion("SportDuration >=", value, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationLessThan(Short value) {
            addCriterion("SportDuration <", value, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationLessThanOrEqualTo(Short value) {
            addCriterion("SportDuration <=", value, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationIn(List<Short> values) {
            addCriterion("SportDuration in", values, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationNotIn(List<Short> values) {
            addCriterion("SportDuration not in", values, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationBetween(Short value1, Short value2) {
            addCriterion("SportDuration between", value1, value2, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportDurationNotBetween(Short value1, Short value2) {
            addCriterion("SportDuration not between", value1, value2, "sportDuration");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeIsNull() {
            addCriterion("SportTotalTime is null");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeIsNotNull() {
            addCriterion("SportTotalTime is not null");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeEqualTo(Byte value) {
            addCriterion("SportTotalTime =", value, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeNotEqualTo(Byte value) {
            addCriterion("SportTotalTime <>", value, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeGreaterThan(Byte value) {
            addCriterion("SportTotalTime >", value, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SportTotalTime >=", value, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeLessThan(Byte value) {
            addCriterion("SportTotalTime <", value, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeLessThanOrEqualTo(Byte value) {
            addCriterion("SportTotalTime <=", value, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeIn(List<Byte> values) {
            addCriterion("SportTotalTime in", values, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeNotIn(List<Byte> values) {
            addCriterion("SportTotalTime not in", values, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeBetween(Byte value1, Byte value2) {
            addCriterion("SportTotalTime between", value1, value2, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportTotalTimeNotBetween(Byte value1, Byte value2) {
            addCriterion("SportTotalTime not between", value1, value2, "sportTotalTime");
            return (Criteria) this;
        }
        public Criteria andSportWayIsNull() {
            addCriterion("SportWay is null");
            return (Criteria) this;
        }
        public Criteria andSportWayIsNotNull() {
            addCriterion("SportWay is not null");
            return (Criteria) this;
        }
        public Criteria andSportWayEqualTo(String value) {
            addCriterion("SportWay =", value, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayNotEqualTo(String value) {
            addCriterion("SportWay <>", value, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayGreaterThan(String value) {
            addCriterion("SportWay >", value, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayGreaterThanOrEqualTo(String value) {
            addCriterion("SportWay >=", value, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayLessThan(String value) {
            addCriterion("SportWay <", value, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayLessThanOrEqualTo(String value) {
            addCriterion("SportWay <=", value, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayLike(String value) {
            addCriterion("SportWay like", value, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayNotLike(String value) {
            addCriterion("SportWay not like", value, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayIn(List<String> values) {
            addCriterion("SportWay in", values, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayNotIn(List<String> values) {
            addCriterion("SportWay not in", values, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayBetween(String value1, String value2) {
            addCriterion("SportWay between", value1, value2, "sportWay");
            return (Criteria) this;
        }
        public Criteria andSportWayNotBetween(String value1, String value2) {
            addCriterion("SportWay not between", value1, value2, "sportWay");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsIsNull() {
            addCriterion("EatingHabits is null");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsIsNotNull() {
            addCriterion("EatingHabits is not null");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsEqualTo(String value) {
            addCriterion("EatingHabits =", value, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsNotEqualTo(String value) {
            addCriterion("EatingHabits <>", value, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsGreaterThan(String value) {
            addCriterion("EatingHabits >", value, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsGreaterThanOrEqualTo(String value) {
            addCriterion("EatingHabits >=", value, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsLessThan(String value) {
            addCriterion("EatingHabits <", value, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsLessThanOrEqualTo(String value) {
            addCriterion("EatingHabits <=", value, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsLike(String value) {
            addCriterion("EatingHabits like", value, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsNotLike(String value) {
            addCriterion("EatingHabits not like", value, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsIn(List<String> values) {
            addCriterion("EatingHabits in", values, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsNotIn(List<String> values) {
            addCriterion("EatingHabits not in", values, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsBetween(String value1, String value2) {
            addCriterion("EatingHabits between", value1, value2, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andEatingHabitsNotBetween(String value1, String value2) {
            addCriterion("EatingHabits not between", value1, value2, "eatingHabits");
            return (Criteria) this;
        }
        public Criteria andSmokingStateIsNull() {
            addCriterion("SmokingState is null");
            return (Criteria) this;
        }
        public Criteria andSmokingStateIsNotNull() {
            addCriterion("SmokingState is not null");
            return (Criteria) this;
        }
        public Criteria andSmokingStateEqualTo(Byte value) {
            addCriterion("SmokingState =", value, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateNotEqualTo(Byte value) {
            addCriterion("SmokingState <>", value, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateGreaterThan(Byte value) {
            addCriterion("SmokingState >", value, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("SmokingState >=", value, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateLessThan(Byte value) {
            addCriterion("SmokingState <", value, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateLessThanOrEqualTo(Byte value) {
            addCriterion("SmokingState <=", value, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateIn(List<Byte> values) {
            addCriterion("SmokingState in", values, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateNotIn(List<Byte> values) {
            addCriterion("SmokingState not in", values, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateBetween(Byte value1, Byte value2) {
            addCriterion("SmokingState between", value1, value2, "smokingState");
            return (Criteria) this;
        }
        public Criteria andSmokingStateNotBetween(Byte value1, Byte value2) {
            addCriterion("SmokingState not between", value1, value2, "smokingState");
            return (Criteria) this;
        }
        public Criteria andDailySmokingIsNull() {
            addCriterion("DailySmoking is null");
            return (Criteria) this;
        }
        public Criteria andDailySmokingIsNotNull() {
            addCriterion("DailySmoking is not null");
            return (Criteria) this;
        }
        public Criteria andDailySmokingEqualTo(Short value) {
            addCriterion("DailySmoking =", value, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingNotEqualTo(Short value) {
            addCriterion("DailySmoking <>", value, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingGreaterThan(Short value) {
            addCriterion("DailySmoking >", value, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingGreaterThanOrEqualTo(Short value) {
            addCriterion("DailySmoking >=", value, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingLessThan(Short value) {
            addCriterion("DailySmoking <", value, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingLessThanOrEqualTo(Short value) {
            addCriterion("DailySmoking <=", value, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingIn(List<Short> values) {
            addCriterion("DailySmoking in", values, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingNotIn(List<Short> values) {
            addCriterion("DailySmoking not in", values, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingBetween(Short value1, Short value2) {
            addCriterion("DailySmoking between", value1, value2, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andDailySmokingNotBetween(Short value1, Short value2) {
            addCriterion("DailySmoking not between", value1, value2, "dailySmoking");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeIsNull() {
            addCriterion("SmokingStartAge is null");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeIsNotNull() {
            addCriterion("SmokingStartAge is not null");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeEqualTo(Byte value) {
            addCriterion("SmokingStartAge =", value, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeNotEqualTo(Byte value) {
            addCriterion("SmokingStartAge <>", value, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeGreaterThan(Byte value) {
            addCriterion("SmokingStartAge >", value, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SmokingStartAge >=", value, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeLessThan(Byte value) {
            addCriterion("SmokingStartAge <", value, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeLessThanOrEqualTo(Byte value) {
            addCriterion("SmokingStartAge <=", value, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeIn(List<Byte> values) {
            addCriterion("SmokingStartAge in", values, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeNotIn(List<Byte> values) {
            addCriterion("SmokingStartAge not in", values, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeBetween(Byte value1, Byte value2) {
            addCriterion("SmokingStartAge between", value1, value2, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingStartAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("SmokingStartAge not between", value1, value2, "smokingStartAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeIsNull() {
            addCriterion("SmokingEndAge is null");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeIsNotNull() {
            addCriterion("SmokingEndAge is not null");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeEqualTo(Byte value) {
            addCriterion("SmokingEndAge =", value, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeNotEqualTo(Byte value) {
            addCriterion("SmokingEndAge <>", value, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeGreaterThan(Byte value) {
            addCriterion("SmokingEndAge >", value, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SmokingEndAge >=", value, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeLessThan(Byte value) {
            addCriterion("SmokingEndAge <", value, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeLessThanOrEqualTo(Byte value) {
            addCriterion("SmokingEndAge <=", value, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeIn(List<Byte> values) {
            addCriterion("SmokingEndAge in", values, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeNotIn(List<Byte> values) {
            addCriterion("SmokingEndAge not in", values, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeBetween(Byte value1, Byte value2) {
            addCriterion("SmokingEndAge between", value1, value2, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andSmokingEndAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("SmokingEndAge not between", value1, value2, "smokingEndAge");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyIsNull() {
            addCriterion("DrinkFrequency is null");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyIsNotNull() {
            addCriterion("DrinkFrequency is not null");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyEqualTo(Byte value) {
            addCriterion("DrinkFrequency =", value, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyNotEqualTo(Byte value) {
            addCriterion("DrinkFrequency <>", value, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyGreaterThan(Byte value) {
            addCriterion("DrinkFrequency >", value, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyGreaterThanOrEqualTo(Byte value) {
            addCriterion("DrinkFrequency >=", value, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyLessThan(Byte value) {
            addCriterion("DrinkFrequency <", value, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyLessThanOrEqualTo(Byte value) {
            addCriterion("DrinkFrequency <=", value, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyIn(List<Byte> values) {
            addCriterion("DrinkFrequency in", values, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyNotIn(List<Byte> values) {
            addCriterion("DrinkFrequency not in", values, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyBetween(Byte value1, Byte value2) {
            addCriterion("DrinkFrequency between", value1, value2, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDrinkFrequencyNotBetween(Byte value1, Byte value2) {
            addCriterion("DrinkFrequency not between", value1, value2, "drinkFrequency");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkIsNull() {
            addCriterion("DailyDrink is null");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkIsNotNull() {
            addCriterion("DailyDrink is not null");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkEqualTo(Short value) {
            addCriterion("DailyDrink =", value, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkNotEqualTo(Short value) {
            addCriterion("DailyDrink <>", value, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkGreaterThan(Short value) {
            addCriterion("DailyDrink >", value, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkGreaterThanOrEqualTo(Short value) {
            addCriterion("DailyDrink >=", value, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkLessThan(Short value) {
            addCriterion("DailyDrink <", value, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkLessThanOrEqualTo(Short value) {
            addCriterion("DailyDrink <=", value, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkIn(List<Short> values) {
            addCriterion("DailyDrink in", values, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkNotIn(List<Short> values) {
            addCriterion("DailyDrink not in", values, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkBetween(Short value1, Short value2) {
            addCriterion("DailyDrink between", value1, value2, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andDailyDrinkNotBetween(Short value1, Short value2) {
            addCriterion("DailyDrink not between", value1, value2, "dailyDrink");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceIsNull() {
            addCriterion("IsAbstinence is null");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceIsNotNull() {
            addCriterion("IsAbstinence is not null");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceEqualTo(Byte value) {
            addCriterion("IsAbstinence =", value, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceNotEqualTo(Byte value) {
            addCriterion("IsAbstinence <>", value, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceGreaterThan(Byte value) {
            addCriterion("IsAbstinence >", value, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsAbstinence >=", value, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceLessThan(Byte value) {
            addCriterion("IsAbstinence <", value, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceLessThanOrEqualTo(Byte value) {
            addCriterion("IsAbstinence <=", value, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceIn(List<Byte> values) {
            addCriterion("IsAbstinence in", values, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceNotIn(List<Byte> values) {
            addCriterion("IsAbstinence not in", values, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceBetween(Byte value1, Byte value2) {
            addCriterion("IsAbstinence between", value1, value2, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andIsAbstinenceNotBetween(Byte value1, Byte value2) {
            addCriterion("IsAbstinence not between", value1, value2, "isAbstinence");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeIsNull() {
            addCriterion("AbstinenceAge is null");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeIsNotNull() {
            addCriterion("AbstinenceAge is not null");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeEqualTo(Byte value) {
            addCriterion("AbstinenceAge =", value, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeNotEqualTo(Byte value) {
            addCriterion("AbstinenceAge <>", value, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeGreaterThan(Byte value) {
            addCriterion("AbstinenceAge >", value, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("AbstinenceAge >=", value, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeLessThan(Byte value) {
            addCriterion("AbstinenceAge <", value, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeLessThanOrEqualTo(Byte value) {
            addCriterion("AbstinenceAge <=", value, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeIn(List<Byte> values) {
            addCriterion("AbstinenceAge in", values, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeNotIn(List<Byte> values) {
            addCriterion("AbstinenceAge not in", values, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeBetween(Byte value1, Byte value2) {
            addCriterion("AbstinenceAge between", value1, value2, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andAbstinenceAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("AbstinenceAge not between", value1, value2, "abstinenceAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeIsNull() {
            addCriterion("DrinkStartAge is null");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeIsNotNull() {
            addCriterion("DrinkStartAge is not null");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeEqualTo(Byte value) {
            addCriterion("DrinkStartAge =", value, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeNotEqualTo(Byte value) {
            addCriterion("DrinkStartAge <>", value, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeGreaterThan(Byte value) {
            addCriterion("DrinkStartAge >", value, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("DrinkStartAge >=", value, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeLessThan(Byte value) {
            addCriterion("DrinkStartAge <", value, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeLessThanOrEqualTo(Byte value) {
            addCriterion("DrinkStartAge <=", value, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeIn(List<Byte> values) {
            addCriterion("DrinkStartAge in", values, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeNotIn(List<Byte> values) {
            addCriterion("DrinkStartAge not in", values, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeBetween(Byte value1, Byte value2) {
            addCriterion("DrinkStartAge between", value1, value2, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andDrinkStartAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("DrinkStartAge not between", value1, value2, "drinkStartAge");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearIsNull() {
            addCriterion("IsTemulenceLastYear is null");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearIsNotNull() {
            addCriterion("IsTemulenceLastYear is not null");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearEqualTo(Byte value) {
            addCriterion("IsTemulenceLastYear =", value, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearNotEqualTo(Byte value) {
            addCriterion("IsTemulenceLastYear <>", value, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearGreaterThan(Byte value) {
            addCriterion("IsTemulenceLastYear >", value, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsTemulenceLastYear >=", value, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearLessThan(Byte value) {
            addCriterion("IsTemulenceLastYear <", value, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearLessThanOrEqualTo(Byte value) {
            addCriterion("IsTemulenceLastYear <=", value, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearIn(List<Byte> values) {
            addCriterion("IsTemulenceLastYear in", values, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearNotIn(List<Byte> values) {
            addCriterion("IsTemulenceLastYear not in", values, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearBetween(Byte value1, Byte value2) {
            addCriterion("IsTemulenceLastYear between", value1, value2, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andIsTemulenceLastYearNotBetween(Byte value1, Byte value2) {
            addCriterion("IsTemulenceLastYear not between", value1, value2, "isTemulenceLastYear");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeIsNull() {
            addCriterion("DrinkType is null");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeIsNotNull() {
            addCriterion("DrinkType is not null");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeEqualTo(String value) {
            addCriterion("DrinkType =", value, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeNotEqualTo(String value) {
            addCriterion("DrinkType <>", value, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeGreaterThan(String value) {
            addCriterion("DrinkType >", value, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DrinkType >=", value, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeLessThan(String value) {
            addCriterion("DrinkType <", value, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeLessThanOrEqualTo(String value) {
            addCriterion("DrinkType <=", value, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeLike(String value) {
            addCriterion("DrinkType like", value, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeNotLike(String value) {
            addCriterion("DrinkType not like", value, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeIn(List<String> values) {
            addCriterion("DrinkType in", values, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeNotIn(List<String> values) {
            addCriterion("DrinkType not in", values, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeBetween(String value1, String value2) {
            addCriterion("DrinkType between", value1, value2, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkTypeNotBetween(String value1, String value2) {
            addCriterion("DrinkType not between", value1, value2, "drinkType");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescIsNull() {
            addCriterion("DrinkOther_Desc is null");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescIsNotNull() {
            addCriterion("DrinkOther_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescEqualTo(String value) {
            addCriterion("DrinkOther_Desc =", value, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescNotEqualTo(String value) {
            addCriterion("DrinkOther_Desc <>", value, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescGreaterThan(String value) {
            addCriterion("DrinkOther_Desc >", value, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescGreaterThanOrEqualTo(String value) {
            addCriterion("DrinkOther_Desc >=", value, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescLessThan(String value) {
            addCriterion("DrinkOther_Desc <", value, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescLessThanOrEqualTo(String value) {
            addCriterion("DrinkOther_Desc <=", value, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescLike(String value) {
            addCriterion("DrinkOther_Desc like", value, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescNotLike(String value) {
            addCriterion("DrinkOther_Desc not like", value, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescIn(List<String> values) {
            addCriterion("DrinkOther_Desc in", values, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescNotIn(List<String> values) {
            addCriterion("DrinkOther_Desc not in", values, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescBetween(String value1, String value2) {
            addCriterion("DrinkOther_Desc between", value1, value2, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andDrinkOther_DescNotBetween(String value1, String value2) {
            addCriterion("DrinkOther_Desc not between", value1, value2, "drinkOther_Desc");
            return (Criteria) this;
        }
        public Criteria andOccupationIsNull() {
            addCriterion("Occupation is null");
            return (Criteria) this;
        }
        public Criteria andOccupationIsNotNull() {
            addCriterion("Occupation is not null");
            return (Criteria) this;
        }
        public Criteria andOccupationEqualTo(Byte value) {
            addCriterion("Occupation =", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationNotEqualTo(Byte value) {
            addCriterion("Occupation <>", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationGreaterThan(Byte value) {
            addCriterion("Occupation >", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationGreaterThanOrEqualTo(Byte value) {
            addCriterion("Occupation >=", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationLessThan(Byte value) {
            addCriterion("Occupation <", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationLessThanOrEqualTo(Byte value) {
            addCriterion("Occupation <=", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationIn(List<Byte> values) {
            addCriterion("Occupation in", values, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationNotIn(List<Byte> values) {
            addCriterion("Occupation not in", values, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationBetween(Byte value1, Byte value2) {
            addCriterion("Occupation between", value1, value2, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationNotBetween(Byte value1, Byte value2) {
            addCriterion("Occupation not between", value1, value2, "occupation");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkIsNull() {
            addCriterion("TypeOfWork is null");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkIsNotNull() {
            addCriterion("TypeOfWork is not null");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkEqualTo(String value) {
            addCriterion("TypeOfWork =", value, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkNotEqualTo(String value) {
            addCriterion("TypeOfWork <>", value, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkGreaterThan(String value) {
            addCriterion("TypeOfWork >", value, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkGreaterThanOrEqualTo(String value) {
            addCriterion("TypeOfWork >=", value, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkLessThan(String value) {
            addCriterion("TypeOfWork <", value, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkLessThanOrEqualTo(String value) {
            addCriterion("TypeOfWork <=", value, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkLike(String value) {
            addCriterion("TypeOfWork like", value, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkNotLike(String value) {
            addCriterion("TypeOfWork not like", value, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkIn(List<String> values) {
            addCriterion("TypeOfWork in", values, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkNotIn(List<String> values) {
            addCriterion("TypeOfWork not in", values, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkBetween(String value1, String value2) {
            addCriterion("TypeOfWork between", value1, value2, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andTypeOfWorkNotBetween(String value1, String value2) {
            addCriterion("TypeOfWork not between", value1, value2, "typeOfWork");
            return (Criteria) this;
        }
        public Criteria andWorkTimeIsNull() {
            addCriterion("WorkTime is null");
            return (Criteria) this;
        }
        public Criteria andWorkTimeIsNotNull() {
            addCriterion("WorkTime is not null");
            return (Criteria) this;
        }
        public Criteria andWorkTimeEqualTo(Byte value) {
            addCriterion("WorkTime =", value, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeNotEqualTo(Byte value) {
            addCriterion("WorkTime <>", value, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeGreaterThan(Byte value) {
            addCriterion("WorkTime >", value, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeGreaterThanOrEqualTo(Byte value) {
            addCriterion("WorkTime >=", value, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeLessThan(Byte value) {
            addCriterion("WorkTime <", value, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeLessThanOrEqualTo(Byte value) {
            addCriterion("WorkTime <=", value, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeIn(List<Byte> values) {
            addCriterion("WorkTime in", values, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeNotIn(List<Byte> values) {
            addCriterion("WorkTime not in", values, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeBetween(Byte value1, Byte value2) {
            addCriterion("WorkTime between", value1, value2, "workTime");
            return (Criteria) this;
        }
        public Criteria andWorkTimeNotBetween(Byte value1, Byte value2) {
            addCriterion("WorkTime not between", value1, value2, "workTime");
            return (Criteria) this;
        }
        public Criteria andDustIsNull() {
            addCriterion("Dust is null");
            return (Criteria) this;
        }
        public Criteria andDustIsNotNull() {
            addCriterion("Dust is not null");
            return (Criteria) this;
        }
        public Criteria andDustEqualTo(String value) {
            addCriterion("Dust =", value, "dust");
            return (Criteria) this;
        }
        public Criteria andDustNotEqualTo(String value) {
            addCriterion("Dust <>", value, "dust");
            return (Criteria) this;
        }
        public Criteria andDustGreaterThan(String value) {
            addCriterion("Dust >", value, "dust");
            return (Criteria) this;
        }
        public Criteria andDustGreaterThanOrEqualTo(String value) {
            addCriterion("Dust >=", value, "dust");
            return (Criteria) this;
        }
        public Criteria andDustLessThan(String value) {
            addCriterion("Dust <", value, "dust");
            return (Criteria) this;
        }
        public Criteria andDustLessThanOrEqualTo(String value) {
            addCriterion("Dust <=", value, "dust");
            return (Criteria) this;
        }
        public Criteria andDustLike(String value) {
            addCriterion("Dust like", value, "dust");
            return (Criteria) this;
        }
        public Criteria andDustNotLike(String value) {
            addCriterion("Dust not like", value, "dust");
            return (Criteria) this;
        }
        public Criteria andDustIn(List<String> values) {
            addCriterion("Dust in", values, "dust");
            return (Criteria) this;
        }
        public Criteria andDustNotIn(List<String> values) {
            addCriterion("Dust not in", values, "dust");
            return (Criteria) this;
        }
        public Criteria andDustBetween(String value1, String value2) {
            addCriterion("Dust between", value1, value2, "dust");
            return (Criteria) this;
        }
        public Criteria andDustNotBetween(String value1, String value2) {
            addCriterion("Dust not between", value1, value2, "dust");
            return (Criteria) this;
        }
        public Criteria andDustGuardIsNull() {
            addCriterion("DustGuard is null");
            return (Criteria) this;
        }
        public Criteria andDustGuardIsNotNull() {
            addCriterion("DustGuard is not null");
            return (Criteria) this;
        }
        public Criteria andDustGuardEqualTo(Byte value) {
            addCriterion("DustGuard =", value, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardNotEqualTo(Byte value) {
            addCriterion("DustGuard <>", value, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardGreaterThan(Byte value) {
            addCriterion("DustGuard >", value, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardGreaterThanOrEqualTo(Byte value) {
            addCriterion("DustGuard >=", value, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardLessThan(Byte value) {
            addCriterion("DustGuard <", value, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardLessThanOrEqualTo(Byte value) {
            addCriterion("DustGuard <=", value, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardIn(List<Byte> values) {
            addCriterion("DustGuard in", values, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardNotIn(List<Byte> values) {
            addCriterion("DustGuard not in", values, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardBetween(Byte value1, Byte value2) {
            addCriterion("DustGuard between", value1, value2, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuardNotBetween(Byte value1, Byte value2) {
            addCriterion("DustGuard not between", value1, value2, "dustGuard");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescIsNull() {
            addCriterion("DustGuard_Desc is null");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescIsNotNull() {
            addCriterion("DustGuard_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescEqualTo(String value) {
            addCriterion("DustGuard_Desc =", value, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescNotEqualTo(String value) {
            addCriterion("DustGuard_Desc <>", value, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescGreaterThan(String value) {
            addCriterion("DustGuard_Desc >", value, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescGreaterThanOrEqualTo(String value) {
            addCriterion("DustGuard_Desc >=", value, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescLessThan(String value) {
            addCriterion("DustGuard_Desc <", value, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescLessThanOrEqualTo(String value) {
            addCriterion("DustGuard_Desc <=", value, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescLike(String value) {
            addCriterion("DustGuard_Desc like", value, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescNotLike(String value) {
            addCriterion("DustGuard_Desc not like", value, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescIn(List<String> values) {
            addCriterion("DustGuard_Desc in", values, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescNotIn(List<String> values) {
            addCriterion("DustGuard_Desc not in", values, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescBetween(String value1, String value2) {
            addCriterion("DustGuard_Desc between", value1, value2, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andDustGuard_DescNotBetween(String value1, String value2) {
            addCriterion("DustGuard_Desc not between", value1, value2, "dustGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenIsNull() {
            addCriterion("Radiogen is null");
            return (Criteria) this;
        }
        public Criteria andRadiogenIsNotNull() {
            addCriterion("Radiogen is not null");
            return (Criteria) this;
        }
        public Criteria andRadiogenEqualTo(String value) {
            addCriterion("Radiogen =", value, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenNotEqualTo(String value) {
            addCriterion("Radiogen <>", value, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenGreaterThan(String value) {
            addCriterion("Radiogen >", value, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenGreaterThanOrEqualTo(String value) {
            addCriterion("Radiogen >=", value, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenLessThan(String value) {
            addCriterion("Radiogen <", value, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenLessThanOrEqualTo(String value) {
            addCriterion("Radiogen <=", value, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenLike(String value) {
            addCriterion("Radiogen like", value, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenNotLike(String value) {
            addCriterion("Radiogen not like", value, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenIn(List<String> values) {
            addCriterion("Radiogen in", values, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenNotIn(List<String> values) {
            addCriterion("Radiogen not in", values, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenBetween(String value1, String value2) {
            addCriterion("Radiogen between", value1, value2, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenNotBetween(String value1, String value2) {
            addCriterion("Radiogen not between", value1, value2, "radiogen");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardIsNull() {
            addCriterion("RadiogenGuard is null");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardIsNotNull() {
            addCriterion("RadiogenGuard is not null");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardEqualTo(Byte value) {
            addCriterion("RadiogenGuard =", value, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardNotEqualTo(Byte value) {
            addCriterion("RadiogenGuard <>", value, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardGreaterThan(Byte value) {
            addCriterion("RadiogenGuard >", value, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardGreaterThanOrEqualTo(Byte value) {
            addCriterion("RadiogenGuard >=", value, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardLessThan(Byte value) {
            addCriterion("RadiogenGuard <", value, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardLessThanOrEqualTo(Byte value) {
            addCriterion("RadiogenGuard <=", value, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardIn(List<Byte> values) {
            addCriterion("RadiogenGuard in", values, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardNotIn(List<Byte> values) {
            addCriterion("RadiogenGuard not in", values, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardBetween(Byte value1, Byte value2) {
            addCriterion("RadiogenGuard between", value1, value2, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuardNotBetween(Byte value1, Byte value2) {
            addCriterion("RadiogenGuard not between", value1, value2, "radiogenGuard");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescIsNull() {
            addCriterion("RadiogenGuard_Desc is null");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescIsNotNull() {
            addCriterion("RadiogenGuard_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescEqualTo(String value) {
            addCriterion("RadiogenGuard_Desc =", value, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescNotEqualTo(String value) {
            addCriterion("RadiogenGuard_Desc <>", value, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescGreaterThan(String value) {
            addCriterion("RadiogenGuard_Desc >", value, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescGreaterThanOrEqualTo(String value) {
            addCriterion("RadiogenGuard_Desc >=", value, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescLessThan(String value) {
            addCriterion("RadiogenGuard_Desc <", value, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescLessThanOrEqualTo(String value) {
            addCriterion("RadiogenGuard_Desc <=", value, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescLike(String value) {
            addCriterion("RadiogenGuard_Desc like", value, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescNotLike(String value) {
            addCriterion("RadiogenGuard_Desc not like", value, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescIn(List<String> values) {
            addCriterion("RadiogenGuard_Desc in", values, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescNotIn(List<String> values) {
            addCriterion("RadiogenGuard_Desc not in", values, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescBetween(String value1, String value2) {
            addCriterion("RadiogenGuard_Desc between", value1, value2, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andRadiogenGuard_DescNotBetween(String value1, String value2) {
            addCriterion("RadiogenGuard_Desc not between", value1, value2, "radiogenGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalIsNull() {
            addCriterion("Physical is null");
            return (Criteria) this;
        }
        public Criteria andPhysicalIsNotNull() {
            addCriterion("Physical is not null");
            return (Criteria) this;
        }
        public Criteria andPhysicalEqualTo(String value) {
            addCriterion("Physical =", value, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalNotEqualTo(String value) {
            addCriterion("Physical <>", value, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalGreaterThan(String value) {
            addCriterion("Physical >", value, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalGreaterThanOrEqualTo(String value) {
            addCriterion("Physical >=", value, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalLessThan(String value) {
            addCriterion("Physical <", value, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalLessThanOrEqualTo(String value) {
            addCriterion("Physical <=", value, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalLike(String value) {
            addCriterion("Physical like", value, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalNotLike(String value) {
            addCriterion("Physical not like", value, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalIn(List<String> values) {
            addCriterion("Physical in", values, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalNotIn(List<String> values) {
            addCriterion("Physical not in", values, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalBetween(String value1, String value2) {
            addCriterion("Physical between", value1, value2, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalNotBetween(String value1, String value2) {
            addCriterion("Physical not between", value1, value2, "physical");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardIsNull() {
            addCriterion("PhysicalGuard is null");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardIsNotNull() {
            addCriterion("PhysicalGuard is not null");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardEqualTo(Byte value) {
            addCriterion("PhysicalGuard =", value, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardNotEqualTo(Byte value) {
            addCriterion("PhysicalGuard <>", value, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardGreaterThan(Byte value) {
            addCriterion("PhysicalGuard >", value, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardGreaterThanOrEqualTo(Byte value) {
            addCriterion("PhysicalGuard >=", value, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardLessThan(Byte value) {
            addCriterion("PhysicalGuard <", value, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardLessThanOrEqualTo(Byte value) {
            addCriterion("PhysicalGuard <=", value, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardIn(List<Byte> values) {
            addCriterion("PhysicalGuard in", values, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardNotIn(List<Byte> values) {
            addCriterion("PhysicalGuard not in", values, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardBetween(Byte value1, Byte value2) {
            addCriterion("PhysicalGuard between", value1, value2, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuardNotBetween(Byte value1, Byte value2) {
            addCriterion("PhysicalGuard not between", value1, value2, "physicalGuard");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescIsNull() {
            addCriterion("PhysicalGuard_Desc is null");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescIsNotNull() {
            addCriterion("PhysicalGuard_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescEqualTo(String value) {
            addCriterion("PhysicalGuard_Desc =", value, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescNotEqualTo(String value) {
            addCriterion("PhysicalGuard_Desc <>", value, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescGreaterThan(String value) {
            addCriterion("PhysicalGuard_Desc >", value, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescGreaterThanOrEqualTo(String value) {
            addCriterion("PhysicalGuard_Desc >=", value, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescLessThan(String value) {
            addCriterion("PhysicalGuard_Desc <", value, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescLessThanOrEqualTo(String value) {
            addCriterion("PhysicalGuard_Desc <=", value, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescLike(String value) {
            addCriterion("PhysicalGuard_Desc like", value, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescNotLike(String value) {
            addCriterion("PhysicalGuard_Desc not like", value, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescIn(List<String> values) {
            addCriterion("PhysicalGuard_Desc in", values, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescNotIn(List<String> values) {
            addCriterion("PhysicalGuard_Desc not in", values, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescBetween(String value1, String value2) {
            addCriterion("PhysicalGuard_Desc between", value1, value2, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andPhysicalGuard_DescNotBetween(String value1, String value2) {
            addCriterion("PhysicalGuard_Desc not between", value1, value2, "physicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalIsNull() {
            addCriterion("Chemical is null");
            return (Criteria) this;
        }
        public Criteria andChemicalIsNotNull() {
            addCriterion("Chemical is not null");
            return (Criteria) this;
        }
        public Criteria andChemicalEqualTo(String value) {
            addCriterion("Chemical =", value, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalNotEqualTo(String value) {
            addCriterion("Chemical <>", value, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalGreaterThan(String value) {
            addCriterion("Chemical >", value, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalGreaterThanOrEqualTo(String value) {
            addCriterion("Chemical >=", value, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalLessThan(String value) {
            addCriterion("Chemical <", value, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalLessThanOrEqualTo(String value) {
            addCriterion("Chemical <=", value, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalLike(String value) {
            addCriterion("Chemical like", value, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalNotLike(String value) {
            addCriterion("Chemical not like", value, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalIn(List<String> values) {
            addCriterion("Chemical in", values, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalNotIn(List<String> values) {
            addCriterion("Chemical not in", values, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalBetween(String value1, String value2) {
            addCriterion("Chemical between", value1, value2, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalNotBetween(String value1, String value2) {
            addCriterion("Chemical not between", value1, value2, "chemical");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardIsNull() {
            addCriterion("ChemicalGuard is null");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardIsNotNull() {
            addCriterion("ChemicalGuard is not null");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardEqualTo(Byte value) {
            addCriterion("ChemicalGuard =", value, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardNotEqualTo(Byte value) {
            addCriterion("ChemicalGuard <>", value, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardGreaterThan(Byte value) {
            addCriterion("ChemicalGuard >", value, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardGreaterThanOrEqualTo(Byte value) {
            addCriterion("ChemicalGuard >=", value, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardLessThan(Byte value) {
            addCriterion("ChemicalGuard <", value, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardLessThanOrEqualTo(Byte value) {
            addCriterion("ChemicalGuard <=", value, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardIn(List<Byte> values) {
            addCriterion("ChemicalGuard in", values, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardNotIn(List<Byte> values) {
            addCriterion("ChemicalGuard not in", values, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardBetween(Byte value1, Byte value2) {
            addCriterion("ChemicalGuard between", value1, value2, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuardNotBetween(Byte value1, Byte value2) {
            addCriterion("ChemicalGuard not between", value1, value2, "chemicalGuard");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescIsNull() {
            addCriterion("ChemicalGuard_Desc is null");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescIsNotNull() {
            addCriterion("ChemicalGuard_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescEqualTo(String value) {
            addCriterion("ChemicalGuard_Desc =", value, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescNotEqualTo(String value) {
            addCriterion("ChemicalGuard_Desc <>", value, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescGreaterThan(String value) {
            addCriterion("ChemicalGuard_Desc >", value, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescGreaterThanOrEqualTo(String value) {
            addCriterion("ChemicalGuard_Desc >=", value, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescLessThan(String value) {
            addCriterion("ChemicalGuard_Desc <", value, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescLessThanOrEqualTo(String value) {
            addCriterion("ChemicalGuard_Desc <=", value, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescLike(String value) {
            addCriterion("ChemicalGuard_Desc like", value, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescNotLike(String value) {
            addCriterion("ChemicalGuard_Desc not like", value, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescIn(List<String> values) {
            addCriterion("ChemicalGuard_Desc in", values, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescNotIn(List<String> values) {
            addCriterion("ChemicalGuard_Desc not in", values, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescBetween(String value1, String value2) {
            addCriterion("ChemicalGuard_Desc between", value1, value2, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andChemicalGuard_DescNotBetween(String value1, String value2) {
            addCriterion("ChemicalGuard_Desc not between", value1, value2, "chemicalGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherIsNull() {
            addCriterion("ToxicOther is null");
            return (Criteria) this;
        }
        public Criteria andToxicOtherIsNotNull() {
            addCriterion("ToxicOther is not null");
            return (Criteria) this;
        }
        public Criteria andToxicOtherEqualTo(String value) {
            addCriterion("ToxicOther =", value, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherNotEqualTo(String value) {
            addCriterion("ToxicOther <>", value, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGreaterThan(String value) {
            addCriterion("ToxicOther >", value, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGreaterThanOrEqualTo(String value) {
            addCriterion("ToxicOther >=", value, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherLessThan(String value) {
            addCriterion("ToxicOther <", value, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherLessThanOrEqualTo(String value) {
            addCriterion("ToxicOther <=", value, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherLike(String value) {
            addCriterion("ToxicOther like", value, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherNotLike(String value) {
            addCriterion("ToxicOther not like", value, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherIn(List<String> values) {
            addCriterion("ToxicOther in", values, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherNotIn(List<String> values) {
            addCriterion("ToxicOther not in", values, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherBetween(String value1, String value2) {
            addCriterion("ToxicOther between", value1, value2, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherNotBetween(String value1, String value2) {
            addCriterion("ToxicOther not between", value1, value2, "toxicOther");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardIsNull() {
            addCriterion("ToxicOtherGuard is null");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardIsNotNull() {
            addCriterion("ToxicOtherGuard is not null");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardEqualTo(Byte value) {
            addCriterion("ToxicOtherGuard =", value, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardNotEqualTo(Byte value) {
            addCriterion("ToxicOtherGuard <>", value, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardGreaterThan(Byte value) {
            addCriterion("ToxicOtherGuard >", value, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardGreaterThanOrEqualTo(Byte value) {
            addCriterion("ToxicOtherGuard >=", value, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardLessThan(Byte value) {
            addCriterion("ToxicOtherGuard <", value, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardLessThanOrEqualTo(Byte value) {
            addCriterion("ToxicOtherGuard <=", value, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardIn(List<Byte> values) {
            addCriterion("ToxicOtherGuard in", values, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardNotIn(List<Byte> values) {
            addCriterion("ToxicOtherGuard not in", values, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardBetween(Byte value1, Byte value2) {
            addCriterion("ToxicOtherGuard between", value1, value2, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuardNotBetween(Byte value1, Byte value2) {
            addCriterion("ToxicOtherGuard not between", value1, value2, "toxicOtherGuard");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescIsNull() {
            addCriterion("ToxicOtherGuard_Desc is null");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescIsNotNull() {
            addCriterion("ToxicOtherGuard_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescEqualTo(String value) {
            addCriterion("ToxicOtherGuard_Desc =", value, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescNotEqualTo(String value) {
            addCriterion("ToxicOtherGuard_Desc <>", value, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescGreaterThan(String value) {
            addCriterion("ToxicOtherGuard_Desc >", value, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescGreaterThanOrEqualTo(String value) {
            addCriterion("ToxicOtherGuard_Desc >=", value, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescLessThan(String value) {
            addCriterion("ToxicOtherGuard_Desc <", value, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescLessThanOrEqualTo(String value) {
            addCriterion("ToxicOtherGuard_Desc <=", value, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescLike(String value) {
            addCriterion("ToxicOtherGuard_Desc like", value, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescNotLike(String value) {
            addCriterion("ToxicOtherGuard_Desc not like", value, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescIn(List<String> values) {
            addCriterion("ToxicOtherGuard_Desc in", values, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescNotIn(List<String> values) {
            addCriterion("ToxicOtherGuard_Desc not in", values, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescBetween(String value1, String value2) {
            addCriterion("ToxicOtherGuard_Desc between", value1, value2, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andToxicOtherGuard_DescNotBetween(String value1, String value2) {
            addCriterion("ToxicOtherGuard_Desc not between", value1, value2, "toxicOtherGuard_Desc");
            return (Criteria) this;
        }
        public Criteria andLipsIsNull() {
            addCriterion("Lips is null");
            return (Criteria) this;
        }
        public Criteria andLipsIsNotNull() {
            addCriterion("Lips is not null");
            return (Criteria) this;
        }
        public Criteria andLipsEqualTo(Byte value) {
            addCriterion("Lips =", value, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsNotEqualTo(Byte value) {
            addCriterion("Lips <>", value, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsGreaterThan(Byte value) {
            addCriterion("Lips >", value, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsGreaterThanOrEqualTo(Byte value) {
            addCriterion("Lips >=", value, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsLessThan(Byte value) {
            addCriterion("Lips <", value, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsLessThanOrEqualTo(Byte value) {
            addCriterion("Lips <=", value, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsIn(List<Byte> values) {
            addCriterion("Lips in", values, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsNotIn(List<Byte> values) {
            addCriterion("Lips not in", values, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsBetween(Byte value1, Byte value2) {
            addCriterion("Lips between", value1, value2, "lips");
            return (Criteria) this;
        }
        public Criteria andLipsNotBetween(Byte value1, Byte value2) {
            addCriterion("Lips not between", value1, value2, "lips");
            return (Criteria) this;
        }
        public Criteria andDentitionIsNull() {
            addCriterion("Dentition is null");
            return (Criteria) this;
        }
        public Criteria andDentitionIsNotNull() {
            addCriterion("Dentition is not null");
            return (Criteria) this;
        }
        public Criteria andDentitionEqualTo(Byte value) {
            addCriterion("Dentition =", value, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionNotEqualTo(Byte value) {
            addCriterion("Dentition <>", value, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionGreaterThan(Byte value) {
            addCriterion("Dentition >", value, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionGreaterThanOrEqualTo(Byte value) {
            addCriterion("Dentition >=", value, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionLessThan(Byte value) {
            addCriterion("Dentition <", value, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionLessThanOrEqualTo(Byte value) {
            addCriterion("Dentition <=", value, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionIn(List<Byte> values) {
            addCriterion("Dentition in", values, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionNotIn(List<Byte> values) {
            addCriterion("Dentition not in", values, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionBetween(Byte value1, Byte value2) {
            addCriterion("Dentition between", value1, value2, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentitionNotBetween(Byte value1, Byte value2) {
            addCriterion("Dentition not between", value1, value2, "dentition");
            return (Criteria) this;
        }
        public Criteria andDentition_DescIsNull() {
            addCriterion("Dentition_Desc is null");
            return (Criteria) this;
        }
        public Criteria andDentition_DescIsNotNull() {
            addCriterion("Dentition_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andDentition_DescEqualTo(String value) {
            addCriterion("Dentition_Desc =", value, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescNotEqualTo(String value) {
            addCriterion("Dentition_Desc <>", value, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescGreaterThan(String value) {
            addCriterion("Dentition_Desc >", value, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Dentition_Desc >=", value, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescLessThan(String value) {
            addCriterion("Dentition_Desc <", value, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescLessThanOrEqualTo(String value) {
            addCriterion("Dentition_Desc <=", value, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescLike(String value) {
            addCriterion("Dentition_Desc like", value, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescNotLike(String value) {
            addCriterion("Dentition_Desc not like", value, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescIn(List<String> values) {
            addCriterion("Dentition_Desc in", values, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescNotIn(List<String> values) {
            addCriterion("Dentition_Desc not in", values, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescBetween(String value1, String value2) {
            addCriterion("Dentition_Desc between", value1, value2, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andDentition_DescNotBetween(String value1, String value2) {
            addCriterion("Dentition_Desc not between", value1, value2, "dentition_Desc");
            return (Criteria) this;
        }
        public Criteria andThroatIsNull() {
            addCriterion("Throat is null");
            return (Criteria) this;
        }
        public Criteria andThroatIsNotNull() {
            addCriterion("Throat is not null");
            return (Criteria) this;
        }
        public Criteria andThroatEqualTo(Byte value) {
            addCriterion("Throat =", value, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatNotEqualTo(Byte value) {
            addCriterion("Throat <>", value, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatGreaterThan(Byte value) {
            addCriterion("Throat >", value, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatGreaterThanOrEqualTo(Byte value) {
            addCriterion("Throat >=", value, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatLessThan(Byte value) {
            addCriterion("Throat <", value, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatLessThanOrEqualTo(Byte value) {
            addCriterion("Throat <=", value, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatIn(List<Byte> values) {
            addCriterion("Throat in", values, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatNotIn(List<Byte> values) {
            addCriterion("Throat not in", values, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatBetween(Byte value1, Byte value2) {
            addCriterion("Throat between", value1, value2, "throat");
            return (Criteria) this;
        }
        public Criteria andThroatNotBetween(Byte value1, Byte value2) {
            addCriterion("Throat not between", value1, value2, "throat");
            return (Criteria) this;
        }
        public Criteria andLeftVisionIsNull() {
            addCriterion("LeftVision is null");
            return (Criteria) this;
        }
        public Criteria andLeftVisionIsNotNull() {
            addCriterion("LeftVision is not null");
            return (Criteria) this;
        }
        public Criteria andLeftVisionEqualTo(BigDecimal value) {
            addCriterion("LeftVision =", value, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionNotEqualTo(BigDecimal value) {
            addCriterion("LeftVision <>", value, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionGreaterThan(BigDecimal value) {
            addCriterion("LeftVision >", value, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LeftVision >=", value, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionLessThan(BigDecimal value) {
            addCriterion("LeftVision <", value, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LeftVision <=", value, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionIn(List<BigDecimal> values) {
            addCriterion("LeftVision in", values, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionNotIn(List<BigDecimal> values) {
            addCriterion("LeftVision not in", values, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LeftVision between", value1, value2, "leftVision");
            return (Criteria) this;
        }
        public Criteria andLeftVisionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LeftVision not between", value1, value2, "leftVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionIsNull() {
            addCriterion("RightVision is null");
            return (Criteria) this;
        }
        public Criteria andRightVisionIsNotNull() {
            addCriterion("RightVision is not null");
            return (Criteria) this;
        }
        public Criteria andRightVisionEqualTo(BigDecimal value) {
            addCriterion("RightVision =", value, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionNotEqualTo(BigDecimal value) {
            addCriterion("RightVision <>", value, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionGreaterThan(BigDecimal value) {
            addCriterion("RightVision >", value, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RightVision >=", value, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionLessThan(BigDecimal value) {
            addCriterion("RightVision <", value, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RightVision <=", value, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionIn(List<BigDecimal> values) {
            addCriterion("RightVision in", values, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionNotIn(List<BigDecimal> values) {
            addCriterion("RightVision not in", values, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RightVision between", value1, value2, "rightVision");
            return (Criteria) this;
        }
        public Criteria andRightVisionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RightVision not between", value1, value2, "rightVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionIsNull() {
            addCriterion("LeftCorrectVision is null");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionIsNotNull() {
            addCriterion("LeftCorrectVision is not null");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionEqualTo(BigDecimal value) {
            addCriterion("LeftCorrectVision =", value, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionNotEqualTo(BigDecimal value) {
            addCriterion("LeftCorrectVision <>", value, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionGreaterThan(BigDecimal value) {
            addCriterion("LeftCorrectVision >", value, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LeftCorrectVision >=", value, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionLessThan(BigDecimal value) {
            addCriterion("LeftCorrectVision <", value, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LeftCorrectVision <=", value, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionIn(List<BigDecimal> values) {
            addCriterion("LeftCorrectVision in", values, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionNotIn(List<BigDecimal> values) {
            addCriterion("LeftCorrectVision not in", values, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LeftCorrectVision between", value1, value2, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andLeftCorrectVisionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LeftCorrectVision not between", value1, value2, "leftCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionIsNull() {
            addCriterion("RightCorrectVision is null");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionIsNotNull() {
            addCriterion("RightCorrectVision is not null");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionEqualTo(BigDecimal value) {
            addCriterion("RightCorrectVision =", value, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionNotEqualTo(BigDecimal value) {
            addCriterion("RightCorrectVision <>", value, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionGreaterThan(BigDecimal value) {
            addCriterion("RightCorrectVision >", value, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RightCorrectVision >=", value, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionLessThan(BigDecimal value) {
            addCriterion("RightCorrectVision <", value, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RightCorrectVision <=", value, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionIn(List<BigDecimal> values) {
            addCriterion("RightCorrectVision in", values, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionNotIn(List<BigDecimal> values) {
            addCriterion("RightCorrectVision not in", values, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RightCorrectVision between", value1, value2, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andRightCorrectVisionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RightCorrectVision not between", value1, value2, "rightCorrectVision");
            return (Criteria) this;
        }
        public Criteria andHearingIsNull() {
            addCriterion("Hearing is null");
            return (Criteria) this;
        }
        public Criteria andHearingIsNotNull() {
            addCriterion("Hearing is not null");
            return (Criteria) this;
        }
        public Criteria andHearingEqualTo(Byte value) {
            addCriterion("Hearing =", value, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingNotEqualTo(Byte value) {
            addCriterion("Hearing <>", value, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingGreaterThan(Byte value) {
            addCriterion("Hearing >", value, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingGreaterThanOrEqualTo(Byte value) {
            addCriterion("Hearing >=", value, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingLessThan(Byte value) {
            addCriterion("Hearing <", value, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingLessThanOrEqualTo(Byte value) {
            addCriterion("Hearing <=", value, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingIn(List<Byte> values) {
            addCriterion("Hearing in", values, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingNotIn(List<Byte> values) {
            addCriterion("Hearing not in", values, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingBetween(Byte value1, Byte value2) {
            addCriterion("Hearing between", value1, value2, "hearing");
            return (Criteria) this;
        }
        public Criteria andHearingNotBetween(Byte value1, Byte value2) {
            addCriterion("Hearing not between", value1, value2, "hearing");
            return (Criteria) this;
        }
        public Criteria andMovementIsNull() {
            addCriterion("Movement is null");
            return (Criteria) this;
        }
        public Criteria andMovementIsNotNull() {
            addCriterion("Movement is not null");
            return (Criteria) this;
        }
        public Criteria andMovementEqualTo(Byte value) {
            addCriterion("Movement =", value, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementNotEqualTo(Byte value) {
            addCriterion("Movement <>", value, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementGreaterThan(Byte value) {
            addCriterion("Movement >", value, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementGreaterThanOrEqualTo(Byte value) {
            addCriterion("Movement >=", value, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementLessThan(Byte value) {
            addCriterion("Movement <", value, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementLessThanOrEqualTo(Byte value) {
            addCriterion("Movement <=", value, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementIn(List<Byte> values) {
            addCriterion("Movement in", values, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementNotIn(List<Byte> values) {
            addCriterion("Movement not in", values, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementBetween(Byte value1, Byte value2) {
            addCriterion("Movement between", value1, value2, "movement");
            return (Criteria) this;
        }
        public Criteria andMovementNotBetween(Byte value1, Byte value2) {
            addCriterion("Movement not between", value1, value2, "movement");
            return (Criteria) this;
        }
        public Criteria andEyegroundIsNull() {
            addCriterion("Eyeground is null");
            return (Criteria) this;
        }
        public Criteria andEyegroundIsNotNull() {
            addCriterion("Eyeground is not null");
            return (Criteria) this;
        }
        public Criteria andEyegroundEqualTo(Byte value) {
            addCriterion("Eyeground =", value, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundNotEqualTo(Byte value) {
            addCriterion("Eyeground <>", value, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundGreaterThan(Byte value) {
            addCriterion("Eyeground >", value, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundGreaterThanOrEqualTo(Byte value) {
            addCriterion("Eyeground >=", value, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundLessThan(Byte value) {
            addCriterion("Eyeground <", value, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundLessThanOrEqualTo(Byte value) {
            addCriterion("Eyeground <=", value, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundIn(List<Byte> values) {
            addCriterion("Eyeground in", values, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundNotIn(List<Byte> values) {
            addCriterion("Eyeground not in", values, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundBetween(Byte value1, Byte value2) {
            addCriterion("Eyeground between", value1, value2, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyegroundNotBetween(Byte value1, Byte value2) {
            addCriterion("Eyeground not between", value1, value2, "eyeground");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescIsNull() {
            addCriterion("Eyeground_Desc is null");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescIsNotNull() {
            addCriterion("Eyeground_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescEqualTo(String value) {
            addCriterion("Eyeground_Desc =", value, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescNotEqualTo(String value) {
            addCriterion("Eyeground_Desc <>", value, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescGreaterThan(String value) {
            addCriterion("Eyeground_Desc >", value, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Eyeground_Desc >=", value, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescLessThan(String value) {
            addCriterion("Eyeground_Desc <", value, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescLessThanOrEqualTo(String value) {
            addCriterion("Eyeground_Desc <=", value, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescLike(String value) {
            addCriterion("Eyeground_Desc like", value, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescNotLike(String value) {
            addCriterion("Eyeground_Desc not like", value, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescIn(List<String> values) {
            addCriterion("Eyeground_Desc in", values, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescNotIn(List<String> values) {
            addCriterion("Eyeground_Desc not in", values, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescBetween(String value1, String value2) {
            addCriterion("Eyeground_Desc between", value1, value2, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andEyeground_DescNotBetween(String value1, String value2) {
            addCriterion("Eyeground_Desc not between", value1, value2, "eyeground_Desc");
            return (Criteria) this;
        }
        public Criteria andSkinIsNull() {
            addCriterion("Skin is null");
            return (Criteria) this;
        }
        public Criteria andSkinIsNotNull() {
            addCriterion("Skin is not null");
            return (Criteria) this;
        }
        public Criteria andSkinEqualTo(Byte value) {
            addCriterion("Skin =", value, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinNotEqualTo(Byte value) {
            addCriterion("Skin <>", value, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinGreaterThan(Byte value) {
            addCriterion("Skin >", value, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinGreaterThanOrEqualTo(Byte value) {
            addCriterion("Skin >=", value, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinLessThan(Byte value) {
            addCriterion("Skin <", value, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinLessThanOrEqualTo(Byte value) {
            addCriterion("Skin <=", value, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinIn(List<Byte> values) {
            addCriterion("Skin in", values, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinNotIn(List<Byte> values) {
            addCriterion("Skin not in", values, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinBetween(Byte value1, Byte value2) {
            addCriterion("Skin between", value1, value2, "skin");
            return (Criteria) this;
        }
        public Criteria andSkinNotBetween(Byte value1, Byte value2) {
            addCriterion("Skin not between", value1, value2, "skin");
            return (Criteria) this;
        }
        public Criteria andSkin_DescIsNull() {
            addCriterion("Skin_Desc is null");
            return (Criteria) this;
        }
        public Criteria andSkin_DescIsNotNull() {
            addCriterion("Skin_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andSkin_DescEqualTo(String value) {
            addCriterion("Skin_Desc =", value, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescNotEqualTo(String value) {
            addCriterion("Skin_Desc <>", value, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescGreaterThan(String value) {
            addCriterion("Skin_Desc >", value, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Skin_Desc >=", value, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescLessThan(String value) {
            addCriterion("Skin_Desc <", value, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescLessThanOrEqualTo(String value) {
            addCriterion("Skin_Desc <=", value, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescLike(String value) {
            addCriterion("Skin_Desc like", value, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescNotLike(String value) {
            addCriterion("Skin_Desc not like", value, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescIn(List<String> values) {
            addCriterion("Skin_Desc in", values, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescNotIn(List<String> values) {
            addCriterion("Skin_Desc not in", values, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescBetween(String value1, String value2) {
            addCriterion("Skin_Desc between", value1, value2, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andSkin_DescNotBetween(String value1, String value2) {
            addCriterion("Skin_Desc not between", value1, value2, "skin_Desc");
            return (Criteria) this;
        }
        public Criteria andScleroIsNull() {
            addCriterion("Sclero is null");
            return (Criteria) this;
        }
        public Criteria andScleroIsNotNull() {
            addCriterion("Sclero is not null");
            return (Criteria) this;
        }
        public Criteria andScleroEqualTo(Byte value) {
            addCriterion("Sclero =", value, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroNotEqualTo(Byte value) {
            addCriterion("Sclero <>", value, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroGreaterThan(Byte value) {
            addCriterion("Sclero >", value, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroGreaterThanOrEqualTo(Byte value) {
            addCriterion("Sclero >=", value, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroLessThan(Byte value) {
            addCriterion("Sclero <", value, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroLessThanOrEqualTo(Byte value) {
            addCriterion("Sclero <=", value, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroIn(List<Byte> values) {
            addCriterion("Sclero in", values, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroNotIn(List<Byte> values) {
            addCriterion("Sclero not in", values, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroBetween(Byte value1, Byte value2) {
            addCriterion("Sclero between", value1, value2, "sclero");
            return (Criteria) this;
        }
        public Criteria andScleroNotBetween(Byte value1, Byte value2) {
            addCriterion("Sclero not between", value1, value2, "sclero");
            return (Criteria) this;
        }
        public Criteria andSclero_DescIsNull() {
            addCriterion("Sclero_Desc is null");
            return (Criteria) this;
        }
        public Criteria andSclero_DescIsNotNull() {
            addCriterion("Sclero_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andSclero_DescEqualTo(String value) {
            addCriterion("Sclero_Desc =", value, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescNotEqualTo(String value) {
            addCriterion("Sclero_Desc <>", value, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescGreaterThan(String value) {
            addCriterion("Sclero_Desc >", value, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Sclero_Desc >=", value, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescLessThan(String value) {
            addCriterion("Sclero_Desc <", value, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescLessThanOrEqualTo(String value) {
            addCriterion("Sclero_Desc <=", value, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescLike(String value) {
            addCriterion("Sclero_Desc like", value, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescNotLike(String value) {
            addCriterion("Sclero_Desc not like", value, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescIn(List<String> values) {
            addCriterion("Sclero_Desc in", values, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescNotIn(List<String> values) {
            addCriterion("Sclero_Desc not in", values, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescBetween(String value1, String value2) {
            addCriterion("Sclero_Desc between", value1, value2, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andSclero_DescNotBetween(String value1, String value2) {
            addCriterion("Sclero_Desc not between", value1, value2, "sclero_Desc");
            return (Criteria) this;
        }
        public Criteria andLymphIsNull() {
            addCriterion("Lymph is null");
            return (Criteria) this;
        }
        public Criteria andLymphIsNotNull() {
            addCriterion("Lymph is not null");
            return (Criteria) this;
        }
        public Criteria andLymphEqualTo(Byte value) {
            addCriterion("Lymph =", value, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphNotEqualTo(Byte value) {
            addCriterion("Lymph <>", value, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphGreaterThan(Byte value) {
            addCriterion("Lymph >", value, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphGreaterThanOrEqualTo(Byte value) {
            addCriterion("Lymph >=", value, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphLessThan(Byte value) {
            addCriterion("Lymph <", value, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphLessThanOrEqualTo(Byte value) {
            addCriterion("Lymph <=", value, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphIn(List<Byte> values) {
            addCriterion("Lymph in", values, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphNotIn(List<Byte> values) {
            addCriterion("Lymph not in", values, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphBetween(Byte value1, Byte value2) {
            addCriterion("Lymph between", value1, value2, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymphNotBetween(Byte value1, Byte value2) {
            addCriterion("Lymph not between", value1, value2, "lymph");
            return (Criteria) this;
        }
        public Criteria andLymph_DescIsNull() {
            addCriterion("Lymph_Desc is null");
            return (Criteria) this;
        }
        public Criteria andLymph_DescIsNotNull() {
            addCriterion("Lymph_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andLymph_DescEqualTo(String value) {
            addCriterion("Lymph_Desc =", value, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescNotEqualTo(String value) {
            addCriterion("Lymph_Desc <>", value, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescGreaterThan(String value) {
            addCriterion("Lymph_Desc >", value, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Lymph_Desc >=", value, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescLessThan(String value) {
            addCriterion("Lymph_Desc <", value, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescLessThanOrEqualTo(String value) {
            addCriterion("Lymph_Desc <=", value, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescLike(String value) {
            addCriterion("Lymph_Desc like", value, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescNotLike(String value) {
            addCriterion("Lymph_Desc not like", value, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescIn(List<String> values) {
            addCriterion("Lymph_Desc in", values, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescNotIn(List<String> values) {
            addCriterion("Lymph_Desc not in", values, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescBetween(String value1, String value2) {
            addCriterion("Lymph_Desc between", value1, value2, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLymph_DescNotBetween(String value1, String value2) {
            addCriterion("Lymph_Desc not between", value1, value2, "lymph_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestIsNull() {
            addCriterion("LungBarrelChest is null");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestIsNotNull() {
            addCriterion("LungBarrelChest is not null");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestEqualTo(Byte value) {
            addCriterion("LungBarrelChest =", value, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestNotEqualTo(Byte value) {
            addCriterion("LungBarrelChest <>", value, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestGreaterThan(Byte value) {
            addCriterion("LungBarrelChest >", value, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestGreaterThanOrEqualTo(Byte value) {
            addCriterion("LungBarrelChest >=", value, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestLessThan(Byte value) {
            addCriterion("LungBarrelChest <", value, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestLessThanOrEqualTo(Byte value) {
            addCriterion("LungBarrelChest <=", value, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestIn(List<Byte> values) {
            addCriterion("LungBarrelChest in", values, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestNotIn(List<Byte> values) {
            addCriterion("LungBarrelChest not in", values, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestBetween(Byte value1, Byte value2) {
            addCriterion("LungBarrelChest between", value1, value2, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBarrelChestNotBetween(Byte value1, Byte value2) {
            addCriterion("LungBarrelChest not between", value1, value2, "lungBarrelChest");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsIsNull() {
            addCriterion("LungBreathSounds is null");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsIsNotNull() {
            addCriterion("LungBreathSounds is not null");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsEqualTo(Byte value) {
            addCriterion("LungBreathSounds =", value, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsNotEqualTo(Byte value) {
            addCriterion("LungBreathSounds <>", value, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsGreaterThan(Byte value) {
            addCriterion("LungBreathSounds >", value, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsGreaterThanOrEqualTo(Byte value) {
            addCriterion("LungBreathSounds >=", value, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsLessThan(Byte value) {
            addCriterion("LungBreathSounds <", value, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsLessThanOrEqualTo(Byte value) {
            addCriterion("LungBreathSounds <=", value, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsIn(List<Byte> values) {
            addCriterion("LungBreathSounds in", values, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsNotIn(List<Byte> values) {
            addCriterion("LungBreathSounds not in", values, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsBetween(Byte value1, Byte value2) {
            addCriterion("LungBreathSounds between", value1, value2, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSoundsNotBetween(Byte value1, Byte value2) {
            addCriterion("LungBreathSounds not between", value1, value2, "lungBreathSounds");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescIsNull() {
            addCriterion("LungBreathSounds_Desc is null");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescIsNotNull() {
            addCriterion("LungBreathSounds_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescEqualTo(String value) {
            addCriterion("LungBreathSounds_Desc =", value, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescNotEqualTo(String value) {
            addCriterion("LungBreathSounds_Desc <>", value, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescGreaterThan(String value) {
            addCriterion("LungBreathSounds_Desc >", value, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescGreaterThanOrEqualTo(String value) {
            addCriterion("LungBreathSounds_Desc >=", value, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescLessThan(String value) {
            addCriterion("LungBreathSounds_Desc <", value, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescLessThanOrEqualTo(String value) {
            addCriterion("LungBreathSounds_Desc <=", value, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescLike(String value) {
            addCriterion("LungBreathSounds_Desc like", value, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescNotLike(String value) {
            addCriterion("LungBreathSounds_Desc not like", value, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescIn(List<String> values) {
            addCriterion("LungBreathSounds_Desc in", values, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescNotIn(List<String> values) {
            addCriterion("LungBreathSounds_Desc not in", values, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescBetween(String value1, String value2) {
            addCriterion("LungBreathSounds_Desc between", value1, value2, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungBreathSounds_DescNotBetween(String value1, String value2) {
            addCriterion("LungBreathSounds_Desc not between", value1, value2, "lungBreathSounds_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRalesIsNull() {
            addCriterion("LungRales is null");
            return (Criteria) this;
        }
        public Criteria andLungRalesIsNotNull() {
            addCriterion("LungRales is not null");
            return (Criteria) this;
        }
        public Criteria andLungRalesEqualTo(Byte value) {
            addCriterion("LungRales =", value, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesNotEqualTo(Byte value) {
            addCriterion("LungRales <>", value, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesGreaterThan(Byte value) {
            addCriterion("LungRales >", value, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesGreaterThanOrEqualTo(Byte value) {
            addCriterion("LungRales >=", value, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesLessThan(Byte value) {
            addCriterion("LungRales <", value, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesLessThanOrEqualTo(Byte value) {
            addCriterion("LungRales <=", value, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesIn(List<Byte> values) {
            addCriterion("LungRales in", values, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesNotIn(List<Byte> values) {
            addCriterion("LungRales not in", values, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesBetween(Byte value1, Byte value2) {
            addCriterion("LungRales between", value1, value2, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRalesNotBetween(Byte value1, Byte value2) {
            addCriterion("LungRales not between", value1, value2, "lungRales");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescIsNull() {
            addCriterion("LungRales_Desc is null");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescIsNotNull() {
            addCriterion("LungRales_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescEqualTo(String value) {
            addCriterion("LungRales_Desc =", value, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescNotEqualTo(String value) {
            addCriterion("LungRales_Desc <>", value, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescGreaterThan(String value) {
            addCriterion("LungRales_Desc >", value, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescGreaterThanOrEqualTo(String value) {
            addCriterion("LungRales_Desc >=", value, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescLessThan(String value) {
            addCriterion("LungRales_Desc <", value, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescLessThanOrEqualTo(String value) {
            addCriterion("LungRales_Desc <=", value, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescLike(String value) {
            addCriterion("LungRales_Desc like", value, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescNotLike(String value) {
            addCriterion("LungRales_Desc not like", value, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescIn(List<String> values) {
            addCriterion("LungRales_Desc in", values, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescNotIn(List<String> values) {
            addCriterion("LungRales_Desc not in", values, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescBetween(String value1, String value2) {
            addCriterion("LungRales_Desc between", value1, value2, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andLungRales_DescNotBetween(String value1, String value2) {
            addCriterion("LungRales_Desc not between", value1, value2, "lungRales_Desc");
            return (Criteria) this;
        }
        public Criteria andHeartRateIsNull() {
            addCriterion("HeartRate is null");
            return (Criteria) this;
        }
        public Criteria andHeartRateIsNotNull() {
            addCriterion("HeartRate is not null");
            return (Criteria) this;
        }
        public Criteria andHeartRateEqualTo(Short value) {
            addCriterion("HeartRate =", value, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateNotEqualTo(Short value) {
            addCriterion("HeartRate <>", value, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateGreaterThan(Short value) {
            addCriterion("HeartRate >", value, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateGreaterThanOrEqualTo(Short value) {
            addCriterion("HeartRate >=", value, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateLessThan(Short value) {
            addCriterion("HeartRate <", value, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateLessThanOrEqualTo(Short value) {
            addCriterion("HeartRate <=", value, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateIn(List<Short> values) {
            addCriterion("HeartRate in", values, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateNotIn(List<Short> values) {
            addCriterion("HeartRate not in", values, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateBetween(Short value1, Short value2) {
            addCriterion("HeartRate between", value1, value2, "heartRate");
            return (Criteria) this;
        }
        public Criteria andHeartRateNotBetween(Short value1, Short value2) {
            addCriterion("HeartRate not between", value1, value2, "heartRate");
            return (Criteria) this;
        }
        public Criteria andRhythmIsNull() {
            addCriterion("Rhythm is null");
            return (Criteria) this;
        }
        public Criteria andRhythmIsNotNull() {
            addCriterion("Rhythm is not null");
            return (Criteria) this;
        }
        public Criteria andRhythmEqualTo(Byte value) {
            addCriterion("Rhythm =", value, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmNotEqualTo(Byte value) {
            addCriterion("Rhythm <>", value, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmGreaterThan(Byte value) {
            addCriterion("Rhythm >", value, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmGreaterThanOrEqualTo(Byte value) {
            addCriterion("Rhythm >=", value, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmLessThan(Byte value) {
            addCriterion("Rhythm <", value, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmLessThanOrEqualTo(Byte value) {
            addCriterion("Rhythm <=", value, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmIn(List<Byte> values) {
            addCriterion("Rhythm in", values, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmNotIn(List<Byte> values) {
            addCriterion("Rhythm not in", values, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmBetween(Byte value1, Byte value2) {
            addCriterion("Rhythm between", value1, value2, "rhythm");
            return (Criteria) this;
        }
        public Criteria andRhythmNotBetween(Byte value1, Byte value2) {
            addCriterion("Rhythm not between", value1, value2, "rhythm");
            return (Criteria) this;
        }
        public Criteria andMurmurIsNull() {
            addCriterion("Murmur is null");
            return (Criteria) this;
        }
        public Criteria andMurmurIsNotNull() {
            addCriterion("Murmur is not null");
            return (Criteria) this;
        }
        public Criteria andMurmurEqualTo(Byte value) {
            addCriterion("Murmur =", value, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurNotEqualTo(Byte value) {
            addCriterion("Murmur <>", value, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurGreaterThan(Byte value) {
            addCriterion("Murmur >", value, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurGreaterThanOrEqualTo(Byte value) {
            addCriterion("Murmur >=", value, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurLessThan(Byte value) {
            addCriterion("Murmur <", value, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurLessThanOrEqualTo(Byte value) {
            addCriterion("Murmur <=", value, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurIn(List<Byte> values) {
            addCriterion("Murmur in", values, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurNotIn(List<Byte> values) {
            addCriterion("Murmur not in", values, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurBetween(Byte value1, Byte value2) {
            addCriterion("Murmur between", value1, value2, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmurNotBetween(Byte value1, Byte value2) {
            addCriterion("Murmur not between", value1, value2, "murmur");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescIsNull() {
            addCriterion("Murmur_Desc is null");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescIsNotNull() {
            addCriterion("Murmur_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescEqualTo(String value) {
            addCriterion("Murmur_Desc =", value, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescNotEqualTo(String value) {
            addCriterion("Murmur_Desc <>", value, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescGreaterThan(String value) {
            addCriterion("Murmur_Desc >", value, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Murmur_Desc >=", value, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescLessThan(String value) {
            addCriterion("Murmur_Desc <", value, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescLessThanOrEqualTo(String value) {
            addCriterion("Murmur_Desc <=", value, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescLike(String value) {
            addCriterion("Murmur_Desc like", value, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescNotLike(String value) {
            addCriterion("Murmur_Desc not like", value, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescIn(List<String> values) {
            addCriterion("Murmur_Desc in", values, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescNotIn(List<String> values) {
            addCriterion("Murmur_Desc not in", values, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescBetween(String value1, String value2) {
            addCriterion("Murmur_Desc between", value1, value2, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andMurmur_DescNotBetween(String value1, String value2) {
            addCriterion("Murmur_Desc not between", value1, value2, "murmur_Desc");
            return (Criteria) this;
        }
        public Criteria andPainIsNull() {
            addCriterion("Pain is null");
            return (Criteria) this;
        }
        public Criteria andPainIsNotNull() {
            addCriterion("Pain is not null");
            return (Criteria) this;
        }
        public Criteria andPainEqualTo(Byte value) {
            addCriterion("Pain =", value, "pain");
            return (Criteria) this;
        }
        public Criteria andPainNotEqualTo(Byte value) {
            addCriterion("Pain <>", value, "pain");
            return (Criteria) this;
        }
        public Criteria andPainGreaterThan(Byte value) {
            addCriterion("Pain >", value, "pain");
            return (Criteria) this;
        }
        public Criteria andPainGreaterThanOrEqualTo(Byte value) {
            addCriterion("Pain >=", value, "pain");
            return (Criteria) this;
        }
        public Criteria andPainLessThan(Byte value) {
            addCriterion("Pain <", value, "pain");
            return (Criteria) this;
        }
        public Criteria andPainLessThanOrEqualTo(Byte value) {
            addCriterion("Pain <=", value, "pain");
            return (Criteria) this;
        }
        public Criteria andPainIn(List<Byte> values) {
            addCriterion("Pain in", values, "pain");
            return (Criteria) this;
        }
        public Criteria andPainNotIn(List<Byte> values) {
            addCriterion("Pain not in", values, "pain");
            return (Criteria) this;
        }
        public Criteria andPainBetween(Byte value1, Byte value2) {
            addCriterion("Pain between", value1, value2, "pain");
            return (Criteria) this;
        }
        public Criteria andPainNotBetween(Byte value1, Byte value2) {
            addCriterion("Pain not between", value1, value2, "pain");
            return (Criteria) this;
        }
        public Criteria andPain_DescIsNull() {
            addCriterion("Pain_Desc is null");
            return (Criteria) this;
        }
        public Criteria andPain_DescIsNotNull() {
            addCriterion("Pain_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andPain_DescEqualTo(String value) {
            addCriterion("Pain_Desc =", value, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescNotEqualTo(String value) {
            addCriterion("Pain_Desc <>", value, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescGreaterThan(String value) {
            addCriterion("Pain_Desc >", value, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Pain_Desc >=", value, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescLessThan(String value) {
            addCriterion("Pain_Desc <", value, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescLessThanOrEqualTo(String value) {
            addCriterion("Pain_Desc <=", value, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescLike(String value) {
            addCriterion("Pain_Desc like", value, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescNotLike(String value) {
            addCriterion("Pain_Desc not like", value, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescIn(List<String> values) {
            addCriterion("Pain_Desc in", values, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescNotIn(List<String> values) {
            addCriterion("Pain_Desc not in", values, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescBetween(String value1, String value2) {
            addCriterion("Pain_Desc between", value1, value2, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andPain_DescNotBetween(String value1, String value2) {
            addCriterion("Pain_Desc not between", value1, value2, "pain_Desc");
            return (Criteria) this;
        }
        public Criteria andBlockIsNull() {
            addCriterion("Block is null");
            return (Criteria) this;
        }
        public Criteria andBlockIsNotNull() {
            addCriterion("Block is not null");
            return (Criteria) this;
        }
        public Criteria andBlockEqualTo(Byte value) {
            addCriterion("Block =", value, "block");
            return (Criteria) this;
        }
        public Criteria andBlockNotEqualTo(Byte value) {
            addCriterion("Block <>", value, "block");
            return (Criteria) this;
        }
        public Criteria andBlockGreaterThan(Byte value) {
            addCriterion("Block >", value, "block");
            return (Criteria) this;
        }
        public Criteria andBlockGreaterThanOrEqualTo(Byte value) {
            addCriterion("Block >=", value, "block");
            return (Criteria) this;
        }
        public Criteria andBlockLessThan(Byte value) {
            addCriterion("Block <", value, "block");
            return (Criteria) this;
        }
        public Criteria andBlockLessThanOrEqualTo(Byte value) {
            addCriterion("Block <=", value, "block");
            return (Criteria) this;
        }
        public Criteria andBlockIn(List<Byte> values) {
            addCriterion("Block in", values, "block");
            return (Criteria) this;
        }
        public Criteria andBlockNotIn(List<Byte> values) {
            addCriterion("Block not in", values, "block");
            return (Criteria) this;
        }
        public Criteria andBlockBetween(Byte value1, Byte value2) {
            addCriterion("Block between", value1, value2, "block");
            return (Criteria) this;
        }
        public Criteria andBlockNotBetween(Byte value1, Byte value2) {
            addCriterion("Block not between", value1, value2, "block");
            return (Criteria) this;
        }
        public Criteria andBlock_DescIsNull() {
            addCriterion("Block_Desc is null");
            return (Criteria) this;
        }
        public Criteria andBlock_DescIsNotNull() {
            addCriterion("Block_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andBlock_DescEqualTo(String value) {
            addCriterion("Block_Desc =", value, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescNotEqualTo(String value) {
            addCriterion("Block_Desc <>", value, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescGreaterThan(String value) {
            addCriterion("Block_Desc >", value, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Block_Desc >=", value, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescLessThan(String value) {
            addCriterion("Block_Desc <", value, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescLessThanOrEqualTo(String value) {
            addCriterion("Block_Desc <=", value, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescLike(String value) {
            addCriterion("Block_Desc like", value, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescNotLike(String value) {
            addCriterion("Block_Desc not like", value, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescIn(List<String> values) {
            addCriterion("Block_Desc in", values, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescNotIn(List<String> values) {
            addCriterion("Block_Desc not in", values, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescBetween(String value1, String value2) {
            addCriterion("Block_Desc between", value1, value2, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andBlock_DescNotBetween(String value1, String value2) {
            addCriterion("Block_Desc not between", value1, value2, "block_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyIsNull() {
            addCriterion("Hepatomegaly is null");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyIsNotNull() {
            addCriterion("Hepatomegaly is not null");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyEqualTo(Byte value) {
            addCriterion("Hepatomegaly =", value, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyNotEqualTo(Byte value) {
            addCriterion("Hepatomegaly <>", value, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyGreaterThan(Byte value) {
            addCriterion("Hepatomegaly >", value, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyGreaterThanOrEqualTo(Byte value) {
            addCriterion("Hepatomegaly >=", value, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyLessThan(Byte value) {
            addCriterion("Hepatomegaly <", value, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyLessThanOrEqualTo(Byte value) {
            addCriterion("Hepatomegaly <=", value, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyIn(List<Byte> values) {
            addCriterion("Hepatomegaly in", values, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyNotIn(List<Byte> values) {
            addCriterion("Hepatomegaly not in", values, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyBetween(Byte value1, Byte value2) {
            addCriterion("Hepatomegaly between", value1, value2, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegalyNotBetween(Byte value1, Byte value2) {
            addCriterion("Hepatomegaly not between", value1, value2, "hepatomegaly");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescIsNull() {
            addCriterion("Hepatomegaly_Desc is null");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescIsNotNull() {
            addCriterion("Hepatomegaly_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescEqualTo(String value) {
            addCriterion("Hepatomegaly_Desc =", value, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescNotEqualTo(String value) {
            addCriterion("Hepatomegaly_Desc <>", value, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescGreaterThan(String value) {
            addCriterion("Hepatomegaly_Desc >", value, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Hepatomegaly_Desc >=", value, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescLessThan(String value) {
            addCriterion("Hepatomegaly_Desc <", value, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescLessThanOrEqualTo(String value) {
            addCriterion("Hepatomegaly_Desc <=", value, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescLike(String value) {
            addCriterion("Hepatomegaly_Desc like", value, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescNotLike(String value) {
            addCriterion("Hepatomegaly_Desc not like", value, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescIn(List<String> values) {
            addCriterion("Hepatomegaly_Desc in", values, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescNotIn(List<String> values) {
            addCriterion("Hepatomegaly_Desc not in", values, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescBetween(String value1, String value2) {
            addCriterion("Hepatomegaly_Desc between", value1, value2, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andHepatomegaly_DescNotBetween(String value1, String value2) {
            addCriterion("Hepatomegaly_Desc not between", value1, value2, "hepatomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyIsNull() {
            addCriterion("Splenomegaly is null");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyIsNotNull() {
            addCriterion("Splenomegaly is not null");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyEqualTo(Byte value) {
            addCriterion("Splenomegaly =", value, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyNotEqualTo(Byte value) {
            addCriterion("Splenomegaly <>", value, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyGreaterThan(Byte value) {
            addCriterion("Splenomegaly >", value, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyGreaterThanOrEqualTo(Byte value) {
            addCriterion("Splenomegaly >=", value, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyLessThan(Byte value) {
            addCriterion("Splenomegaly <", value, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyLessThanOrEqualTo(Byte value) {
            addCriterion("Splenomegaly <=", value, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyIn(List<Byte> values) {
            addCriterion("Splenomegaly in", values, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyNotIn(List<Byte> values) {
            addCriterion("Splenomegaly not in", values, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyBetween(Byte value1, Byte value2) {
            addCriterion("Splenomegaly between", value1, value2, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegalyNotBetween(Byte value1, Byte value2) {
            addCriterion("Splenomegaly not between", value1, value2, "splenomegaly");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescIsNull() {
            addCriterion("Splenomegaly_Desc is null");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescIsNotNull() {
            addCriterion("Splenomegaly_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescEqualTo(String value) {
            addCriterion("Splenomegaly_Desc =", value, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescNotEqualTo(String value) {
            addCriterion("Splenomegaly_Desc <>", value, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescGreaterThan(String value) {
            addCriterion("Splenomegaly_Desc >", value, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Splenomegaly_Desc >=", value, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescLessThan(String value) {
            addCriterion("Splenomegaly_Desc <", value, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescLessThanOrEqualTo(String value) {
            addCriterion("Splenomegaly_Desc <=", value, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescLike(String value) {
            addCriterion("Splenomegaly_Desc like", value, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescNotLike(String value) {
            addCriterion("Splenomegaly_Desc not like", value, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescIn(List<String> values) {
            addCriterion("Splenomegaly_Desc in", values, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescNotIn(List<String> values) {
            addCriterion("Splenomegaly_Desc not in", values, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescBetween(String value1, String value2) {
            addCriterion("Splenomegaly_Desc between", value1, value2, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andSplenomegaly_DescNotBetween(String value1, String value2) {
            addCriterion("Splenomegaly_Desc not between", value1, value2, "splenomegaly_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonantIsNull() {
            addCriterion("MoveSonant is null");
            return (Criteria) this;
        }
        public Criteria andMoveSonantIsNotNull() {
            addCriterion("MoveSonant is not null");
            return (Criteria) this;
        }
        public Criteria andMoveSonantEqualTo(Byte value) {
            addCriterion("MoveSonant =", value, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantNotEqualTo(Byte value) {
            addCriterion("MoveSonant <>", value, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantGreaterThan(Byte value) {
            addCriterion("MoveSonant >", value, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantGreaterThanOrEqualTo(Byte value) {
            addCriterion("MoveSonant >=", value, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantLessThan(Byte value) {
            addCriterion("MoveSonant <", value, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantLessThanOrEqualTo(Byte value) {
            addCriterion("MoveSonant <=", value, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantIn(List<Byte> values) {
            addCriterion("MoveSonant in", values, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantNotIn(List<Byte> values) {
            addCriterion("MoveSonant not in", values, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantBetween(Byte value1, Byte value2) {
            addCriterion("MoveSonant between", value1, value2, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonantNotBetween(Byte value1, Byte value2) {
            addCriterion("MoveSonant not between", value1, value2, "moveSonant");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescIsNull() {
            addCriterion("MoveSonant_Desc is null");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescIsNotNull() {
            addCriterion("MoveSonant_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescEqualTo(String value) {
            addCriterion("MoveSonant_Desc =", value, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescNotEqualTo(String value) {
            addCriterion("MoveSonant_Desc <>", value, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescGreaterThan(String value) {
            addCriterion("MoveSonant_Desc >", value, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescGreaterThanOrEqualTo(String value) {
            addCriterion("MoveSonant_Desc >=", value, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescLessThan(String value) {
            addCriterion("MoveSonant_Desc <", value, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescLessThanOrEqualTo(String value) {
            addCriterion("MoveSonant_Desc <=", value, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescLike(String value) {
            addCriterion("MoveSonant_Desc like", value, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescNotLike(String value) {
            addCriterion("MoveSonant_Desc not like", value, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescIn(List<String> values) {
            addCriterion("MoveSonant_Desc in", values, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescNotIn(List<String> values) {
            addCriterion("MoveSonant_Desc not in", values, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescBetween(String value1, String value2) {
            addCriterion("MoveSonant_Desc between", value1, value2, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andMoveSonant_DescNotBetween(String value1, String value2) {
            addCriterion("MoveSonant_Desc not between", value1, value2, "moveSonant_Desc");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaIsNull() {
            addCriterion("LowLimbEdema is null");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaIsNotNull() {
            addCriterion("LowLimbEdema is not null");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaEqualTo(Byte value) {
            addCriterion("LowLimbEdema =", value, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaNotEqualTo(Byte value) {
            addCriterion("LowLimbEdema <>", value, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaGreaterThan(Byte value) {
            addCriterion("LowLimbEdema >", value, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaGreaterThanOrEqualTo(Byte value) {
            addCriterion("LowLimbEdema >=", value, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaLessThan(Byte value) {
            addCriterion("LowLimbEdema <", value, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaLessThanOrEqualTo(Byte value) {
            addCriterion("LowLimbEdema <=", value, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaIn(List<Byte> values) {
            addCriterion("LowLimbEdema in", values, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaNotIn(List<Byte> values) {
            addCriterion("LowLimbEdema not in", values, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaBetween(Byte value1, Byte value2) {
            addCriterion("LowLimbEdema between", value1, value2, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andLowLimbEdemaNotBetween(Byte value1, Byte value2) {
            addCriterion("LowLimbEdema not between", value1, value2, "lowLimbEdema");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusIsNull() {
            addCriterion("Arteriopalmus is null");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusIsNotNull() {
            addCriterion("Arteriopalmus is not null");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusEqualTo(Byte value) {
            addCriterion("Arteriopalmus =", value, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusNotEqualTo(Byte value) {
            addCriterion("Arteriopalmus <>", value, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusGreaterThan(Byte value) {
            addCriterion("Arteriopalmus >", value, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusGreaterThanOrEqualTo(Byte value) {
            addCriterion("Arteriopalmus >=", value, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusLessThan(Byte value) {
            addCriterion("Arteriopalmus <", value, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusLessThanOrEqualTo(Byte value) {
            addCriterion("Arteriopalmus <=", value, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusIn(List<Byte> values) {
            addCriterion("Arteriopalmus in", values, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusNotIn(List<Byte> values) {
            addCriterion("Arteriopalmus not in", values, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusBetween(Byte value1, Byte value2) {
            addCriterion("Arteriopalmus between", value1, value2, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andArteriopalmusNotBetween(Byte value1, Byte value2) {
            addCriterion("Arteriopalmus not between", value1, value2, "arteriopalmus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusIsNull() {
            addCriterion("AnusTactus is null");
            return (Criteria) this;
        }
        public Criteria andAnusTactusIsNotNull() {
            addCriterion("AnusTactus is not null");
            return (Criteria) this;
        }
        public Criteria andAnusTactusEqualTo(Byte value) {
            addCriterion("AnusTactus =", value, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusNotEqualTo(Byte value) {
            addCriterion("AnusTactus <>", value, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusGreaterThan(Byte value) {
            addCriterion("AnusTactus >", value, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusGreaterThanOrEqualTo(Byte value) {
            addCriterion("AnusTactus >=", value, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusLessThan(Byte value) {
            addCriterion("AnusTactus <", value, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusLessThanOrEqualTo(Byte value) {
            addCriterion("AnusTactus <=", value, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusIn(List<Byte> values) {
            addCriterion("AnusTactus in", values, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusNotIn(List<Byte> values) {
            addCriterion("AnusTactus not in", values, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusBetween(Byte value1, Byte value2) {
            addCriterion("AnusTactus between", value1, value2, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactusNotBetween(Byte value1, Byte value2) {
            addCriterion("AnusTactus not between", value1, value2, "anusTactus");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescIsNull() {
            addCriterion("AnusTactus_Desc is null");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescIsNotNull() {
            addCriterion("AnusTactus_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescEqualTo(String value) {
            addCriterion("AnusTactus_Desc =", value, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescNotEqualTo(String value) {
            addCriterion("AnusTactus_Desc <>", value, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescGreaterThan(String value) {
            addCriterion("AnusTactus_Desc >", value, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescGreaterThanOrEqualTo(String value) {
            addCriterion("AnusTactus_Desc >=", value, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescLessThan(String value) {
            addCriterion("AnusTactus_Desc <", value, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescLessThanOrEqualTo(String value) {
            addCriterion("AnusTactus_Desc <=", value, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescLike(String value) {
            addCriterion("AnusTactus_Desc like", value, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescNotLike(String value) {
            addCriterion("AnusTactus_Desc not like", value, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescIn(List<String> values) {
            addCriterion("AnusTactus_Desc in", values, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescNotIn(List<String> values) {
            addCriterion("AnusTactus_Desc not in", values, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescBetween(String value1, String value2) {
            addCriterion("AnusTactus_Desc between", value1, value2, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andAnusTactus_DescNotBetween(String value1, String value2) {
            addCriterion("AnusTactus_Desc not between", value1, value2, "anusTactus_Desc");
            return (Criteria) this;
        }
        public Criteria andBreastIsNull() {
            addCriterion("Breast is null");
            return (Criteria) this;
        }
        public Criteria andBreastIsNotNull() {
            addCriterion("Breast is not null");
            return (Criteria) this;
        }
        public Criteria andBreastEqualTo(String value) {
            addCriterion("Breast =", value, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastNotEqualTo(String value) {
            addCriterion("Breast <>", value, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastGreaterThan(String value) {
            addCriterion("Breast >", value, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastGreaterThanOrEqualTo(String value) {
            addCriterion("Breast >=", value, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastLessThan(String value) {
            addCriterion("Breast <", value, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastLessThanOrEqualTo(String value) {
            addCriterion("Breast <=", value, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastLike(String value) {
            addCriterion("Breast like", value, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastNotLike(String value) {
            addCriterion("Breast not like", value, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastIn(List<String> values) {
            addCriterion("Breast in", values, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastNotIn(List<String> values) {
            addCriterion("Breast not in", values, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastBetween(String value1, String value2) {
            addCriterion("Breast between", value1, value2, "breast");
            return (Criteria) this;
        }
        public Criteria andBreastNotBetween(String value1, String value2) {
            addCriterion("Breast not between", value1, value2, "breast");
            return (Criteria) this;
        }
        public Criteria andBreast_DescIsNull() {
            addCriterion("Breast_Desc is null");
            return (Criteria) this;
        }
        public Criteria andBreast_DescIsNotNull() {
            addCriterion("Breast_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andBreast_DescEqualTo(String value) {
            addCriterion("Breast_Desc =", value, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescNotEqualTo(String value) {
            addCriterion("Breast_Desc <>", value, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescGreaterThan(String value) {
            addCriterion("Breast_Desc >", value, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Breast_Desc >=", value, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescLessThan(String value) {
            addCriterion("Breast_Desc <", value, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescLessThanOrEqualTo(String value) {
            addCriterion("Breast_Desc <=", value, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescLike(String value) {
            addCriterion("Breast_Desc like", value, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescNotLike(String value) {
            addCriterion("Breast_Desc not like", value, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescIn(List<String> values) {
            addCriterion("Breast_Desc in", values, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescNotIn(List<String> values) {
            addCriterion("Breast_Desc not in", values, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescBetween(String value1, String value2) {
            addCriterion("Breast_Desc between", value1, value2, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andBreast_DescNotBetween(String value1, String value2) {
            addCriterion("Breast_Desc not between", value1, value2, "breast_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendumIsNull() {
            addCriterion("Pudendum is null");
            return (Criteria) this;
        }
        public Criteria andPudendumIsNotNull() {
            addCriterion("Pudendum is not null");
            return (Criteria) this;
        }
        public Criteria andPudendumEqualTo(Byte value) {
            addCriterion("Pudendum =", value, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumNotEqualTo(Byte value) {
            addCriterion("Pudendum <>", value, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumGreaterThan(Byte value) {
            addCriterion("Pudendum >", value, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumGreaterThanOrEqualTo(Byte value) {
            addCriterion("Pudendum >=", value, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumLessThan(Byte value) {
            addCriterion("Pudendum <", value, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumLessThanOrEqualTo(Byte value) {
            addCriterion("Pudendum <=", value, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumIn(List<Byte> values) {
            addCriterion("Pudendum in", values, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumNotIn(List<Byte> values) {
            addCriterion("Pudendum not in", values, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumBetween(Byte value1, Byte value2) {
            addCriterion("Pudendum between", value1, value2, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendumNotBetween(Byte value1, Byte value2) {
            addCriterion("Pudendum not between", value1, value2, "pudendum");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescIsNull() {
            addCriterion("Pudendum_Desc is null");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescIsNotNull() {
            addCriterion("Pudendum_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescEqualTo(String value) {
            addCriterion("Pudendum_Desc =", value, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescNotEqualTo(String value) {
            addCriterion("Pudendum_Desc <>", value, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescGreaterThan(String value) {
            addCriterion("Pudendum_Desc >", value, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Pudendum_Desc >=", value, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescLessThan(String value) {
            addCriterion("Pudendum_Desc <", value, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescLessThanOrEqualTo(String value) {
            addCriterion("Pudendum_Desc <=", value, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescLike(String value) {
            addCriterion("Pudendum_Desc like", value, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescNotLike(String value) {
            addCriterion("Pudendum_Desc not like", value, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescIn(List<String> values) {
            addCriterion("Pudendum_Desc in", values, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescNotIn(List<String> values) {
            addCriterion("Pudendum_Desc not in", values, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescBetween(String value1, String value2) {
            addCriterion("Pudendum_Desc between", value1, value2, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andPudendum_DescNotBetween(String value1, String value2) {
            addCriterion("Pudendum_Desc not between", value1, value2, "pudendum_Desc");
            return (Criteria) this;
        }
        public Criteria andVaginaIsNull() {
            addCriterion("Vagina is null");
            return (Criteria) this;
        }
        public Criteria andVaginaIsNotNull() {
            addCriterion("Vagina is not null");
            return (Criteria) this;
        }
        public Criteria andVaginaEqualTo(Byte value) {
            addCriterion("Vagina =", value, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaNotEqualTo(Byte value) {
            addCriterion("Vagina <>", value, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaGreaterThan(Byte value) {
            addCriterion("Vagina >", value, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaGreaterThanOrEqualTo(Byte value) {
            addCriterion("Vagina >=", value, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaLessThan(Byte value) {
            addCriterion("Vagina <", value, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaLessThanOrEqualTo(Byte value) {
            addCriterion("Vagina <=", value, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaIn(List<Byte> values) {
            addCriterion("Vagina in", values, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaNotIn(List<Byte> values) {
            addCriterion("Vagina not in", values, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaBetween(Byte value1, Byte value2) {
            addCriterion("Vagina between", value1, value2, "vagina");
            return (Criteria) this;
        }
        public Criteria andVaginaNotBetween(Byte value1, Byte value2) {
            addCriterion("Vagina not between", value1, value2, "vagina");
            return (Criteria) this;
        }
        public Criteria andVagina_DescIsNull() {
            addCriterion("Vagina_Desc is null");
            return (Criteria) this;
        }
        public Criteria andVagina_DescIsNotNull() {
            addCriterion("Vagina_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andVagina_DescEqualTo(String value) {
            addCriterion("Vagina_Desc =", value, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescNotEqualTo(String value) {
            addCriterion("Vagina_Desc <>", value, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescGreaterThan(String value) {
            addCriterion("Vagina_Desc >", value, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Vagina_Desc >=", value, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescLessThan(String value) {
            addCriterion("Vagina_Desc <", value, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescLessThanOrEqualTo(String value) {
            addCriterion("Vagina_Desc <=", value, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescLike(String value) {
            addCriterion("Vagina_Desc like", value, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescNotLike(String value) {
            addCriterion("Vagina_Desc not like", value, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescIn(List<String> values) {
            addCriterion("Vagina_Desc in", values, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescNotIn(List<String> values) {
            addCriterion("Vagina_Desc not in", values, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescBetween(String value1, String value2) {
            addCriterion("Vagina_Desc between", value1, value2, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andVagina_DescNotBetween(String value1, String value2) {
            addCriterion("Vagina_Desc not between", value1, value2, "vagina_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalIsNull() {
            addCriterion("Cervical is null");
            return (Criteria) this;
        }
        public Criteria andCervicalIsNotNull() {
            addCriterion("Cervical is not null");
            return (Criteria) this;
        }
        public Criteria andCervicalEqualTo(Byte value) {
            addCriterion("Cervical =", value, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalNotEqualTo(Byte value) {
            addCriterion("Cervical <>", value, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalGreaterThan(Byte value) {
            addCriterion("Cervical >", value, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalGreaterThanOrEqualTo(Byte value) {
            addCriterion("Cervical >=", value, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalLessThan(Byte value) {
            addCriterion("Cervical <", value, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalLessThanOrEqualTo(Byte value) {
            addCriterion("Cervical <=", value, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalIn(List<Byte> values) {
            addCriterion("Cervical in", values, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalNotIn(List<Byte> values) {
            addCriterion("Cervical not in", values, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalBetween(Byte value1, Byte value2) {
            addCriterion("Cervical between", value1, value2, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervicalNotBetween(Byte value1, Byte value2) {
            addCriterion("Cervical not between", value1, value2, "cervical");
            return (Criteria) this;
        }
        public Criteria andCervical_DescIsNull() {
            addCriterion("Cervical_Desc is null");
            return (Criteria) this;
        }
        public Criteria andCervical_DescIsNotNull() {
            addCriterion("Cervical_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andCervical_DescEqualTo(String value) {
            addCriterion("Cervical_Desc =", value, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescNotEqualTo(String value) {
            addCriterion("Cervical_Desc <>", value, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescGreaterThan(String value) {
            addCriterion("Cervical_Desc >", value, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Cervical_Desc >=", value, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescLessThan(String value) {
            addCriterion("Cervical_Desc <", value, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescLessThanOrEqualTo(String value) {
            addCriterion("Cervical_Desc <=", value, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescLike(String value) {
            addCriterion("Cervical_Desc like", value, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescNotLike(String value) {
            addCriterion("Cervical_Desc not like", value, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescIn(List<String> values) {
            addCriterion("Cervical_Desc in", values, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescNotIn(List<String> values) {
            addCriterion("Cervical_Desc not in", values, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescBetween(String value1, String value2) {
            addCriterion("Cervical_Desc between", value1, value2, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andCervical_DescNotBetween(String value1, String value2) {
            addCriterion("Cervical_Desc not between", value1, value2, "cervical_Desc");
            return (Criteria) this;
        }
        public Criteria andUteriIsNull() {
            addCriterion("Uteri is null");
            return (Criteria) this;
        }
        public Criteria andUteriIsNotNull() {
            addCriterion("Uteri is not null");
            return (Criteria) this;
        }
        public Criteria andUteriEqualTo(Byte value) {
            addCriterion("Uteri =", value, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriNotEqualTo(Byte value) {
            addCriterion("Uteri <>", value, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriGreaterThan(Byte value) {
            addCriterion("Uteri >", value, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriGreaterThanOrEqualTo(Byte value) {
            addCriterion("Uteri >=", value, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriLessThan(Byte value) {
            addCriterion("Uteri <", value, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriLessThanOrEqualTo(Byte value) {
            addCriterion("Uteri <=", value, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriIn(List<Byte> values) {
            addCriterion("Uteri in", values, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriNotIn(List<Byte> values) {
            addCriterion("Uteri not in", values, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriBetween(Byte value1, Byte value2) {
            addCriterion("Uteri between", value1, value2, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteriNotBetween(Byte value1, Byte value2) {
            addCriterion("Uteri not between", value1, value2, "uteri");
            return (Criteria) this;
        }
        public Criteria andUteri_DescIsNull() {
            addCriterion("Uteri_Desc is null");
            return (Criteria) this;
        }
        public Criteria andUteri_DescIsNotNull() {
            addCriterion("Uteri_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andUteri_DescEqualTo(String value) {
            addCriterion("Uteri_Desc =", value, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescNotEqualTo(String value) {
            addCriterion("Uteri_Desc <>", value, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescGreaterThan(String value) {
            addCriterion("Uteri_Desc >", value, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Uteri_Desc >=", value, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescLessThan(String value) {
            addCriterion("Uteri_Desc <", value, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescLessThanOrEqualTo(String value) {
            addCriterion("Uteri_Desc <=", value, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescLike(String value) {
            addCriterion("Uteri_Desc like", value, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescNotLike(String value) {
            addCriterion("Uteri_Desc not like", value, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescIn(List<String> values) {
            addCriterion("Uteri_Desc in", values, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescNotIn(List<String> values) {
            addCriterion("Uteri_Desc not in", values, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescBetween(String value1, String value2) {
            addCriterion("Uteri_Desc between", value1, value2, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andUteri_DescNotBetween(String value1, String value2) {
            addCriterion("Uteri_Desc not between", value1, value2, "uteri_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosureIsNull() {
            addCriterion("Enclosure is null");
            return (Criteria) this;
        }
        public Criteria andEnclosureIsNotNull() {
            addCriterion("Enclosure is not null");
            return (Criteria) this;
        }
        public Criteria andEnclosureEqualTo(Byte value) {
            addCriterion("Enclosure =", value, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureNotEqualTo(Byte value) {
            addCriterion("Enclosure <>", value, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureGreaterThan(Byte value) {
            addCriterion("Enclosure >", value, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureGreaterThanOrEqualTo(Byte value) {
            addCriterion("Enclosure >=", value, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureLessThan(Byte value) {
            addCriterion("Enclosure <", value, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureLessThanOrEqualTo(Byte value) {
            addCriterion("Enclosure <=", value, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureIn(List<Byte> values) {
            addCriterion("Enclosure in", values, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureNotIn(List<Byte> values) {
            addCriterion("Enclosure not in", values, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureBetween(Byte value1, Byte value2) {
            addCriterion("Enclosure between", value1, value2, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosureNotBetween(Byte value1, Byte value2) {
            addCriterion("Enclosure not between", value1, value2, "enclosure");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescIsNull() {
            addCriterion("Enclosure_Desc is null");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescIsNotNull() {
            addCriterion("Enclosure_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescEqualTo(String value) {
            addCriterion("Enclosure_Desc =", value, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescNotEqualTo(String value) {
            addCriterion("Enclosure_Desc <>", value, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescGreaterThan(String value) {
            addCriterion("Enclosure_Desc >", value, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Enclosure_Desc >=", value, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescLessThan(String value) {
            addCriterion("Enclosure_Desc <", value, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescLessThanOrEqualTo(String value) {
            addCriterion("Enclosure_Desc <=", value, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescLike(String value) {
            addCriterion("Enclosure_Desc like", value, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescNotLike(String value) {
            addCriterion("Enclosure_Desc not like", value, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescIn(List<String> values) {
            addCriterion("Enclosure_Desc in", values, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescNotIn(List<String> values) {
            addCriterion("Enclosure_Desc not in", values, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescBetween(String value1, String value2) {
            addCriterion("Enclosure_Desc between", value1, value2, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andEnclosure_DescNotBetween(String value1, String value2) {
            addCriterion("Enclosure_Desc not between", value1, value2, "enclosure_Desc");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherIsNull() {
            addCriterion("GynaecologyOther is null");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherIsNotNull() {
            addCriterion("GynaecologyOther is not null");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherEqualTo(String value) {
            addCriterion("GynaecologyOther =", value, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherNotEqualTo(String value) {
            addCriterion("GynaecologyOther <>", value, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherGreaterThan(String value) {
            addCriterion("GynaecologyOther >", value, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherGreaterThanOrEqualTo(String value) {
            addCriterion("GynaecologyOther >=", value, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherLessThan(String value) {
            addCriterion("GynaecologyOther <", value, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherLessThanOrEqualTo(String value) {
            addCriterion("GynaecologyOther <=", value, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherLike(String value) {
            addCriterion("GynaecologyOther like", value, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherNotLike(String value) {
            addCriterion("GynaecologyOther not like", value, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherIn(List<String> values) {
            addCriterion("GynaecologyOther in", values, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherNotIn(List<String> values) {
            addCriterion("GynaecologyOther not in", values, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherBetween(String value1, String value2) {
            addCriterion("GynaecologyOther between", value1, value2, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andGynaecologyOtherNotBetween(String value1, String value2) {
            addCriterion("GynaecologyOther not between", value1, value2, "gynaecologyOther");
            return (Criteria) this;
        }
        public Criteria andHemoglobinIsNull() {
            addCriterion("Hemoglobin is null");
            return (Criteria) this;
        }
        public Criteria andHemoglobinIsNotNull() {
            addCriterion("Hemoglobin is not null");
            return (Criteria) this;
        }
        public Criteria andHemoglobinEqualTo(Short value) {
            addCriterion("Hemoglobin =", value, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinNotEqualTo(Short value) {
            addCriterion("Hemoglobin <>", value, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinGreaterThan(Short value) {
            addCriterion("Hemoglobin >", value, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinGreaterThanOrEqualTo(Short value) {
            addCriterion("Hemoglobin >=", value, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinLessThan(Short value) {
            addCriterion("Hemoglobin <", value, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinLessThanOrEqualTo(Short value) {
            addCriterion("Hemoglobin <=", value, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinIn(List<Short> values) {
            addCriterion("Hemoglobin in", values, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinNotIn(List<Short> values) {
            addCriterion("Hemoglobin not in", values, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinBetween(Short value1, Short value2) {
            addCriterion("Hemoglobin between", value1, value2, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andHemoglobinNotBetween(Short value1, Short value2) {
            addCriterion("Hemoglobin not between", value1, value2, "hemoglobin");
            return (Criteria) this;
        }
        public Criteria andLeukocyteIsNull() {
            addCriterion("Leukocyte is null");
            return (Criteria) this;
        }
        public Criteria andLeukocyteIsNotNull() {
            addCriterion("Leukocyte is not null");
            return (Criteria) this;
        }
        public Criteria andLeukocyteEqualTo(BigDecimal value) {
            addCriterion("Leukocyte =", value, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteNotEqualTo(BigDecimal value) {
            addCriterion("Leukocyte <>", value, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteGreaterThan(BigDecimal value) {
            addCriterion("Leukocyte >", value, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Leukocyte >=", value, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteLessThan(BigDecimal value) {
            addCriterion("Leukocyte <", value, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Leukocyte <=", value, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteIn(List<BigDecimal> values) {
            addCriterion("Leukocyte in", values, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteNotIn(List<BigDecimal> values) {
            addCriterion("Leukocyte not in", values, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Leukocyte between", value1, value2, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andLeukocyteNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Leukocyte not between", value1, value2, "leukocyte");
            return (Criteria) this;
        }
        public Criteria andPlateletIsNull() {
            addCriterion("Platelet is null");
            return (Criteria) this;
        }
        public Criteria andPlateletIsNotNull() {
            addCriterion("Platelet is not null");
            return (Criteria) this;
        }
        public Criteria andPlateletEqualTo(Short value) {
            addCriterion("Platelet =", value, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletNotEqualTo(Short value) {
            addCriterion("Platelet <>", value, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletGreaterThan(Short value) {
            addCriterion("Platelet >", value, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletGreaterThanOrEqualTo(Short value) {
            addCriterion("Platelet >=", value, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletLessThan(Short value) {
            addCriterion("Platelet <", value, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletLessThanOrEqualTo(Short value) {
            addCriterion("Platelet <=", value, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletIn(List<Short> values) {
            addCriterion("Platelet in", values, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletNotIn(List<Short> values) {
            addCriterion("Platelet not in", values, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletBetween(Short value1, Short value2) {
            addCriterion("Platelet between", value1, value2, "platelet");
            return (Criteria) this;
        }
        public Criteria andPlateletNotBetween(Short value1, Short value2) {
            addCriterion("Platelet not between", value1, value2, "platelet");
            return (Criteria) this;
        }
        public Criteria andBloodOtherIsNull() {
            addCriterion("BloodOther is null");
            return (Criteria) this;
        }
        public Criteria andBloodOtherIsNotNull() {
            addCriterion("BloodOther is not null");
            return (Criteria) this;
        }
        public Criteria andBloodOtherEqualTo(String value) {
            addCriterion("BloodOther =", value, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherNotEqualTo(String value) {
            addCriterion("BloodOther <>", value, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherGreaterThan(String value) {
            addCriterion("BloodOther >", value, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherGreaterThanOrEqualTo(String value) {
            addCriterion("BloodOther >=", value, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherLessThan(String value) {
            addCriterion("BloodOther <", value, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherLessThanOrEqualTo(String value) {
            addCriterion("BloodOther <=", value, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherLike(String value) {
            addCriterion("BloodOther like", value, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherNotLike(String value) {
            addCriterion("BloodOther not like", value, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherIn(List<String> values) {
            addCriterion("BloodOther in", values, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherNotIn(List<String> values) {
            addCriterion("BloodOther not in", values, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherBetween(String value1, String value2) {
            addCriterion("BloodOther between", value1, value2, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andBloodOtherNotBetween(String value1, String value2) {
            addCriterion("BloodOther not between", value1, value2, "bloodOther");
            return (Criteria) this;
        }
        public Criteria andUrineProteinIsNull() {
            addCriterion("UrineProtein is null");
            return (Criteria) this;
        }
        public Criteria andUrineProteinIsNotNull() {
            addCriterion("UrineProtein is not null");
            return (Criteria) this;
        }
        public Criteria andUrineProteinEqualTo(String value) {
            addCriterion("UrineProtein =", value, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinNotEqualTo(String value) {
            addCriterion("UrineProtein <>", value, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinGreaterThan(String value) {
            addCriterion("UrineProtein >", value, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinGreaterThanOrEqualTo(String value) {
            addCriterion("UrineProtein >=", value, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinLessThan(String value) {
            addCriterion("UrineProtein <", value, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinLessThanOrEqualTo(String value) {
            addCriterion("UrineProtein <=", value, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinLike(String value) {
            addCriterion("UrineProtein like", value, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinNotLike(String value) {
            addCriterion("UrineProtein not like", value, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinIn(List<String> values) {
            addCriterion("UrineProtein in", values, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinNotIn(List<String> values) {
            addCriterion("UrineProtein not in", values, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinBetween(String value1, String value2) {
            addCriterion("UrineProtein between", value1, value2, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineProteinNotBetween(String value1, String value2) {
            addCriterion("UrineProtein not between", value1, value2, "urineProtein");
            return (Criteria) this;
        }
        public Criteria andUrineSugarIsNull() {
            addCriterion("UrineSugar is null");
            return (Criteria) this;
        }
        public Criteria andUrineSugarIsNotNull() {
            addCriterion("UrineSugar is not null");
            return (Criteria) this;
        }
        public Criteria andUrineSugarEqualTo(String value) {
            addCriterion("UrineSugar =", value, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarNotEqualTo(String value) {
            addCriterion("UrineSugar <>", value, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarGreaterThan(String value) {
            addCriterion("UrineSugar >", value, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarGreaterThanOrEqualTo(String value) {
            addCriterion("UrineSugar >=", value, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarLessThan(String value) {
            addCriterion("UrineSugar <", value, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarLessThanOrEqualTo(String value) {
            addCriterion("UrineSugar <=", value, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarLike(String value) {
            addCriterion("UrineSugar like", value, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarNotLike(String value) {
            addCriterion("UrineSugar not like", value, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarIn(List<String> values) {
            addCriterion("UrineSugar in", values, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarNotIn(List<String> values) {
            addCriterion("UrineSugar not in", values, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarBetween(String value1, String value2) {
            addCriterion("UrineSugar between", value1, value2, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineSugarNotBetween(String value1, String value2) {
            addCriterion("UrineSugar not between", value1, value2, "urineSugar");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyIsNull() {
            addCriterion("UrineAcetoneBody is null");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyIsNotNull() {
            addCriterion("UrineAcetoneBody is not null");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyEqualTo(String value) {
            addCriterion("UrineAcetoneBody =", value, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyNotEqualTo(String value) {
            addCriterion("UrineAcetoneBody <>", value, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyGreaterThan(String value) {
            addCriterion("UrineAcetoneBody >", value, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyGreaterThanOrEqualTo(String value) {
            addCriterion("UrineAcetoneBody >=", value, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyLessThan(String value) {
            addCriterion("UrineAcetoneBody <", value, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyLessThanOrEqualTo(String value) {
            addCriterion("UrineAcetoneBody <=", value, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyLike(String value) {
            addCriterion("UrineAcetoneBody like", value, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyNotLike(String value) {
            addCriterion("UrineAcetoneBody not like", value, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyIn(List<String> values) {
            addCriterion("UrineAcetoneBody in", values, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyNotIn(List<String> values) {
            addCriterion("UrineAcetoneBody not in", values, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyBetween(String value1, String value2) {
            addCriterion("UrineAcetoneBody between", value1, value2, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineAcetoneBodyNotBetween(String value1, String value2) {
            addCriterion("UrineAcetoneBody not between", value1, value2, "urineAcetoneBody");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodIsNull() {
            addCriterion("UrineOccultBlood is null");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodIsNotNull() {
            addCriterion("UrineOccultBlood is not null");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodEqualTo(String value) {
            addCriterion("UrineOccultBlood =", value, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodNotEqualTo(String value) {
            addCriterion("UrineOccultBlood <>", value, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodGreaterThan(String value) {
            addCriterion("UrineOccultBlood >", value, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodGreaterThanOrEqualTo(String value) {
            addCriterion("UrineOccultBlood >=", value, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodLessThan(String value) {
            addCriterion("UrineOccultBlood <", value, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodLessThanOrEqualTo(String value) {
            addCriterion("UrineOccultBlood <=", value, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodLike(String value) {
            addCriterion("UrineOccultBlood like", value, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodNotLike(String value) {
            addCriterion("UrineOccultBlood not like", value, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodIn(List<String> values) {
            addCriterion("UrineOccultBlood in", values, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodNotIn(List<String> values) {
            addCriterion("UrineOccultBlood not in", values, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodBetween(String value1, String value2) {
            addCriterion("UrineOccultBlood between", value1, value2, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOccultBloodNotBetween(String value1, String value2) {
            addCriterion("UrineOccultBlood not between", value1, value2, "urineOccultBlood");
            return (Criteria) this;
        }
        public Criteria andUrineOtherIsNull() {
            addCriterion("UrineOther is null");
            return (Criteria) this;
        }
        public Criteria andUrineOtherIsNotNull() {
            addCriterion("UrineOther is not null");
            return (Criteria) this;
        }
        public Criteria andUrineOtherEqualTo(String value) {
            addCriterion("UrineOther =", value, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherNotEqualTo(String value) {
            addCriterion("UrineOther <>", value, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherGreaterThan(String value) {
            addCriterion("UrineOther >", value, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherGreaterThanOrEqualTo(String value) {
            addCriterion("UrineOther >=", value, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherLessThan(String value) {
            addCriterion("UrineOther <", value, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherLessThanOrEqualTo(String value) {
            addCriterion("UrineOther <=", value, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherLike(String value) {
            addCriterion("UrineOther like", value, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherNotLike(String value) {
            addCriterion("UrineOther not like", value, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherIn(List<String> values) {
            addCriterion("UrineOther in", values, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherNotIn(List<String> values) {
            addCriterion("UrineOther not in", values, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherBetween(String value1, String value2) {
            addCriterion("UrineOther between", value1, value2, "urineOther");
            return (Criteria) this;
        }
        public Criteria andUrineOtherNotBetween(String value1, String value2) {
            addCriterion("UrineOther not between", value1, value2, "urineOther");
            return (Criteria) this;
        }
        public Criteria andGLUIsNull() {
            addCriterion("GLU is null");
            return (Criteria) this;
        }
        public Criteria andGLUIsNotNull() {
            addCriterion("GLU is not null");
            return (Criteria) this;
        }
        public Criteria andGLUEqualTo(BigDecimal value) {
            addCriterion("GLU =", value, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLUNotEqualTo(BigDecimal value) {
            addCriterion("GLU <>", value, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLUGreaterThan(BigDecimal value) {
            addCriterion("GLU >", value, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLUGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GLU >=", value, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLULessThan(BigDecimal value) {
            addCriterion("GLU <", value, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLULessThanOrEqualTo(BigDecimal value) {
            addCriterion("GLU <=", value, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLUIn(List<BigDecimal> values) {
            addCriterion("GLU in", values, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLUNotIn(List<BigDecimal> values) {
            addCriterion("GLU not in", values, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLUBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GLU between", value1, value2, "GLU");
            return (Criteria) this;
        }
        public Criteria andGLUNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GLU not between", value1, value2, "GLU");
            return (Criteria) this;
        }
        public Criteria andPGLUIsNull() {
            addCriterion("PGLU is null");
            return (Criteria) this;
        }
        public Criteria andPGLUIsNotNull() {
            addCriterion("PGLU is not null");
            return (Criteria) this;
        }
        public Criteria andPGLUEqualTo(BigDecimal value) {
            addCriterion("PGLU =", value, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLUNotEqualTo(BigDecimal value) {
            addCriterion("PGLU <>", value, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLUGreaterThan(BigDecimal value) {
            addCriterion("PGLU >", value, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLUGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PGLU >=", value, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLULessThan(BigDecimal value) {
            addCriterion("PGLU <", value, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLULessThanOrEqualTo(BigDecimal value) {
            addCriterion("PGLU <=", value, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLUIn(List<BigDecimal> values) {
            addCriterion("PGLU in", values, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLUNotIn(List<BigDecimal> values) {
            addCriterion("PGLU not in", values, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLUBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PGLU between", value1, value2, "PGLU");
            return (Criteria) this;
        }
        public Criteria andPGLUNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PGLU not between", value1, value2, "PGLU");
            return (Criteria) this;
        }
        public Criteria andCardiogramIsNull() {
            addCriterion("Cardiogram is null");
            return (Criteria) this;
        }
        public Criteria andCardiogramIsNotNull() {
            addCriterion("Cardiogram is not null");
            return (Criteria) this;
        }
        public Criteria andCardiogramEqualTo(Byte value) {
            addCriterion("Cardiogram =", value, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramNotEqualTo(Byte value) {
            addCriterion("Cardiogram <>", value, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramGreaterThan(Byte value) {
            addCriterion("Cardiogram >", value, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramGreaterThanOrEqualTo(Byte value) {
            addCriterion("Cardiogram >=", value, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramLessThan(Byte value) {
            addCriterion("Cardiogram <", value, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramLessThanOrEqualTo(Byte value) {
            addCriterion("Cardiogram <=", value, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramIn(List<Byte> values) {
            addCriterion("Cardiogram in", values, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramNotIn(List<Byte> values) {
            addCriterion("Cardiogram not in", values, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramBetween(Byte value1, Byte value2) {
            addCriterion("Cardiogram between", value1, value2, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogramNotBetween(Byte value1, Byte value2) {
            addCriterion("Cardiogram not between", value1, value2, "cardiogram");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescIsNull() {
            addCriterion("Cardiogram_Desc is null");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescIsNotNull() {
            addCriterion("Cardiogram_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescEqualTo(String value) {
            addCriterion("Cardiogram_Desc =", value, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescNotEqualTo(String value) {
            addCriterion("Cardiogram_Desc <>", value, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescGreaterThan(String value) {
            addCriterion("Cardiogram_Desc >", value, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Cardiogram_Desc >=", value, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescLessThan(String value) {
            addCriterion("Cardiogram_Desc <", value, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescLessThanOrEqualTo(String value) {
            addCriterion("Cardiogram_Desc <=", value, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescLike(String value) {
            addCriterion("Cardiogram_Desc like", value, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescNotLike(String value) {
            addCriterion("Cardiogram_Desc not like", value, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescIn(List<String> values) {
            addCriterion("Cardiogram_Desc in", values, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescNotIn(List<String> values) {
            addCriterion("Cardiogram_Desc not in", values, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescBetween(String value1, String value2) {
            addCriterion("Cardiogram_Desc between", value1, value2, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andCardiogram_DescNotBetween(String value1, String value2) {
            addCriterion("Cardiogram_Desc not between", value1, value2, "cardiogram_Desc");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminIsNull() {
            addCriterion("UrineMicroAlbumin is null");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminIsNotNull() {
            addCriterion("UrineMicroAlbumin is not null");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminEqualTo(BigDecimal value) {
            addCriterion("UrineMicroAlbumin =", value, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminNotEqualTo(BigDecimal value) {
            addCriterion("UrineMicroAlbumin <>", value, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminGreaterThan(BigDecimal value) {
            addCriterion("UrineMicroAlbumin >", value, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UrineMicroAlbumin >=", value, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminLessThan(BigDecimal value) {
            addCriterion("UrineMicroAlbumin <", value, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UrineMicroAlbumin <=", value, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminIn(List<BigDecimal> values) {
            addCriterion("UrineMicroAlbumin in", values, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminNotIn(List<BigDecimal> values) {
            addCriterion("UrineMicroAlbumin not in", values, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UrineMicroAlbumin between", value1, value2, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andUrineMicroAlbuminNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UrineMicroAlbumin not between", value1, value2, "urineMicroAlbumin");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodIsNull() {
            addCriterion("FecalOccultBlood is null");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodIsNotNull() {
            addCriterion("FecalOccultBlood is not null");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodEqualTo(Byte value) {
            addCriterion("FecalOccultBlood =", value, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodNotEqualTo(Byte value) {
            addCriterion("FecalOccultBlood <>", value, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodGreaterThan(Byte value) {
            addCriterion("FecalOccultBlood >", value, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodGreaterThanOrEqualTo(Byte value) {
            addCriterion("FecalOccultBlood >=", value, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodLessThan(Byte value) {
            addCriterion("FecalOccultBlood <", value, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodLessThanOrEqualTo(Byte value) {
            addCriterion("FecalOccultBlood <=", value, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodIn(List<Byte> values) {
            addCriterion("FecalOccultBlood in", values, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodNotIn(List<Byte> values) {
            addCriterion("FecalOccultBlood not in", values, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodBetween(Byte value1, Byte value2) {
            addCriterion("FecalOccultBlood between", value1, value2, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andFecalOccultBloodNotBetween(Byte value1, Byte value2) {
            addCriterion("FecalOccultBlood not between", value1, value2, "fecalOccultBlood");
            return (Criteria) this;
        }
        public Criteria andHBA1CIsNull() {
            addCriterion("HBA1C is null");
            return (Criteria) this;
        }
        public Criteria andHBA1CIsNotNull() {
            addCriterion("HBA1C is not null");
            return (Criteria) this;
        }
        public Criteria andHBA1CEqualTo(BigDecimal value) {
            addCriterion("HBA1C =", value, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CNotEqualTo(BigDecimal value) {
            addCriterion("HBA1C <>", value, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CGreaterThan(BigDecimal value) {
            addCriterion("HBA1C >", value, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HBA1C >=", value, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CLessThan(BigDecimal value) {
            addCriterion("HBA1C <", value, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HBA1C <=", value, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CIn(List<BigDecimal> values) {
            addCriterion("HBA1C in", values, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CNotIn(List<BigDecimal> values) {
            addCriterion("HBA1C not in", values, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HBA1C between", value1, value2, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBA1CNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HBA1C not between", value1, value2, "HBA1C");
            return (Criteria) this;
        }
        public Criteria andHBSAGIsNull() {
            addCriterion("HBSAG is null");
            return (Criteria) this;
        }
        public Criteria andHBSAGIsNotNull() {
            addCriterion("HBSAG is not null");
            return (Criteria) this;
        }
        public Criteria andHBSAGEqualTo(Byte value) {
            addCriterion("HBSAG =", value, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGNotEqualTo(Byte value) {
            addCriterion("HBSAG <>", value, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGGreaterThan(Byte value) {
            addCriterion("HBSAG >", value, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGGreaterThanOrEqualTo(Byte value) {
            addCriterion("HBSAG >=", value, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGLessThan(Byte value) {
            addCriterion("HBSAG <", value, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGLessThanOrEqualTo(Byte value) {
            addCriterion("HBSAG <=", value, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGIn(List<Byte> values) {
            addCriterion("HBSAG in", values, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGNotIn(List<Byte> values) {
            addCriterion("HBSAG not in", values, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGBetween(Byte value1, Byte value2) {
            addCriterion("HBSAG between", value1, value2, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andHBSAGNotBetween(Byte value1, Byte value2) {
            addCriterion("HBSAG not between", value1, value2, "HBSAG");
            return (Criteria) this;
        }
        public Criteria andCPTIsNull() {
            addCriterion("CPT is null");
            return (Criteria) this;
        }
        public Criteria andCPTIsNotNull() {
            addCriterion("CPT is not null");
            return (Criteria) this;
        }
        public Criteria andCPTEqualTo(Short value) {
            addCriterion("CPT =", value, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTNotEqualTo(Short value) {
            addCriterion("CPT <>", value, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTGreaterThan(Short value) {
            addCriterion("CPT >", value, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTGreaterThanOrEqualTo(Short value) {
            addCriterion("CPT >=", value, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTLessThan(Short value) {
            addCriterion("CPT <", value, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTLessThanOrEqualTo(Short value) {
            addCriterion("CPT <=", value, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTIn(List<Short> values) {
            addCriterion("CPT in", values, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTNotIn(List<Short> values) {
            addCriterion("CPT not in", values, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTBetween(Short value1, Short value2) {
            addCriterion("CPT between", value1, value2, "CPT");
            return (Criteria) this;
        }
        public Criteria andCPTNotBetween(Short value1, Short value2) {
            addCriterion("CPT not between", value1, value2, "CPT");
            return (Criteria) this;
        }
        public Criteria andASTIsNull() {
            addCriterion("AST is null");
            return (Criteria) this;
        }
        public Criteria andASTIsNotNull() {
            addCriterion("AST is not null");
            return (Criteria) this;
        }
        public Criteria andASTEqualTo(Short value) {
            addCriterion("AST =", value, "AST");
            return (Criteria) this;
        }
        public Criteria andASTNotEqualTo(Short value) {
            addCriterion("AST <>", value, "AST");
            return (Criteria) this;
        }
        public Criteria andASTGreaterThan(Short value) {
            addCriterion("AST >", value, "AST");
            return (Criteria) this;
        }
        public Criteria andASTGreaterThanOrEqualTo(Short value) {
            addCriterion("AST >=", value, "AST");
            return (Criteria) this;
        }
        public Criteria andASTLessThan(Short value) {
            addCriterion("AST <", value, "AST");
            return (Criteria) this;
        }
        public Criteria andASTLessThanOrEqualTo(Short value) {
            addCriterion("AST <=", value, "AST");
            return (Criteria) this;
        }
        public Criteria andASTIn(List<Short> values) {
            addCriterion("AST in", values, "AST");
            return (Criteria) this;
        }
        public Criteria andASTNotIn(List<Short> values) {
            addCriterion("AST not in", values, "AST");
            return (Criteria) this;
        }
        public Criteria andASTBetween(Short value1, Short value2) {
            addCriterion("AST between", value1, value2, "AST");
            return (Criteria) this;
        }
        public Criteria andASTNotBetween(Short value1, Short value2) {
            addCriterion("AST not between", value1, value2, "AST");
            return (Criteria) this;
        }
        public Criteria andALBIsNull() {
            addCriterion("ALB is null");
            return (Criteria) this;
        }
        public Criteria andALBIsNotNull() {
            addCriterion("ALB is not null");
            return (Criteria) this;
        }
        public Criteria andALBEqualTo(Short value) {
            addCriterion("ALB =", value, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBNotEqualTo(Short value) {
            addCriterion("ALB <>", value, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBGreaterThan(Short value) {
            addCriterion("ALB >", value, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBGreaterThanOrEqualTo(Short value) {
            addCriterion("ALB >=", value, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBLessThan(Short value) {
            addCriterion("ALB <", value, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBLessThanOrEqualTo(Short value) {
            addCriterion("ALB <=", value, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBIn(List<Short> values) {
            addCriterion("ALB in", values, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBNotIn(List<Short> values) {
            addCriterion("ALB not in", values, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBBetween(Short value1, Short value2) {
            addCriterion("ALB between", value1, value2, "ALB");
            return (Criteria) this;
        }
        public Criteria andALBNotBetween(Short value1, Short value2) {
            addCriterion("ALB not between", value1, value2, "ALB");
            return (Criteria) this;
        }
        public Criteria andTBILIsNull() {
            addCriterion("TBIL is null");
            return (Criteria) this;
        }
        public Criteria andTBILIsNotNull() {
            addCriterion("TBIL is not null");
            return (Criteria) this;
        }
        public Criteria andTBILEqualTo(BigDecimal value) {
            addCriterion("TBIL =", value, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILNotEqualTo(BigDecimal value) {
            addCriterion("TBIL <>", value, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILGreaterThan(BigDecimal value) {
            addCriterion("TBIL >", value, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TBIL >=", value, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILLessThan(BigDecimal value) {
            addCriterion("TBIL <", value, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TBIL <=", value, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILIn(List<BigDecimal> values) {
            addCriterion("TBIL in", values, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILNotIn(List<BigDecimal> values) {
            addCriterion("TBIL not in", values, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TBIL between", value1, value2, "TBIL");
            return (Criteria) this;
        }
        public Criteria andTBILNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TBIL not between", value1, value2, "TBIL");
            return (Criteria) this;
        }
        public Criteria andCBILIsNull() {
            addCriterion("CBIL is null");
            return (Criteria) this;
        }
        public Criteria andCBILIsNotNull() {
            addCriterion("CBIL is not null");
            return (Criteria) this;
        }
        public Criteria andCBILEqualTo(BigDecimal value) {
            addCriterion("CBIL =", value, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILNotEqualTo(BigDecimal value) {
            addCriterion("CBIL <>", value, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILGreaterThan(BigDecimal value) {
            addCriterion("CBIL >", value, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CBIL >=", value, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILLessThan(BigDecimal value) {
            addCriterion("CBIL <", value, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CBIL <=", value, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILIn(List<BigDecimal> values) {
            addCriterion("CBIL in", values, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILNotIn(List<BigDecimal> values) {
            addCriterion("CBIL not in", values, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CBIL between", value1, value2, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCBILNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CBIL not between", value1, value2, "CBIL");
            return (Criteria) this;
        }
        public Criteria andCRIsNull() {
            addCriterion("CR is null");
            return (Criteria) this;
        }
        public Criteria andCRIsNotNull() {
            addCriterion("CR is not null");
            return (Criteria) this;
        }
        public Criteria andCREqualTo(BigDecimal value) {
            addCriterion("CR =", value, "CR");
            return (Criteria) this;
        }
        public Criteria andCRNotEqualTo(BigDecimal value) {
            addCriterion("CR <>", value, "CR");
            return (Criteria) this;
        }
        public Criteria andCRGreaterThan(BigDecimal value) {
            addCriterion("CR >", value, "CR");
            return (Criteria) this;
        }
        public Criteria andCRGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CR >=", value, "CR");
            return (Criteria) this;
        }
        public Criteria andCRLessThan(BigDecimal value) {
            addCriterion("CR <", value, "CR");
            return (Criteria) this;
        }
        public Criteria andCRLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CR <=", value, "CR");
            return (Criteria) this;
        }
        public Criteria andCRIn(List<BigDecimal> values) {
            addCriterion("CR in", values, "CR");
            return (Criteria) this;
        }
        public Criteria andCRNotIn(List<BigDecimal> values) {
            addCriterion("CR not in", values, "CR");
            return (Criteria) this;
        }
        public Criteria andCRBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CR between", value1, value2, "CR");
            return (Criteria) this;
        }
        public Criteria andCRNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CR not between", value1, value2, "CR");
            return (Criteria) this;
        }
        public Criteria andBUNIsNull() {
            addCriterion("BUN is null");
            return (Criteria) this;
        }
        public Criteria andBUNIsNotNull() {
            addCriterion("BUN is not null");
            return (Criteria) this;
        }
        public Criteria andBUNEqualTo(BigDecimal value) {
            addCriterion("BUN =", value, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNNotEqualTo(BigDecimal value) {
            addCriterion("BUN <>", value, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNGreaterThan(BigDecimal value) {
            addCriterion("BUN >", value, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUN >=", value, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNLessThan(BigDecimal value) {
            addCriterion("BUN <", value, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUN <=", value, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNIn(List<BigDecimal> values) {
            addCriterion("BUN in", values, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNNotIn(List<BigDecimal> values) {
            addCriterion("BUN not in", values, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUN between", value1, value2, "BUN");
            return (Criteria) this;
        }
        public Criteria andBUNNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUN not between", value1, value2, "BUN");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumIsNull() {
            addCriterion("SerumPotassium is null");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumIsNotNull() {
            addCriterion("SerumPotassium is not null");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumEqualTo(BigDecimal value) {
            addCriterion("SerumPotassium =", value, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumNotEqualTo(BigDecimal value) {
            addCriterion("SerumPotassium <>", value, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumGreaterThan(BigDecimal value) {
            addCriterion("SerumPotassium >", value, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SerumPotassium >=", value, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumLessThan(BigDecimal value) {
            addCriterion("SerumPotassium <", value, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SerumPotassium <=", value, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumIn(List<BigDecimal> values) {
            addCriterion("SerumPotassium in", values, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumNotIn(List<BigDecimal> values) {
            addCriterion("SerumPotassium not in", values, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SerumPotassium between", value1, value2, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumPotassiumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SerumPotassium not between", value1, value2, "serumPotassium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumIsNull() {
            addCriterion("SerumSodium is null");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumIsNotNull() {
            addCriterion("SerumSodium is not null");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumEqualTo(Short value) {
            addCriterion("SerumSodium =", value, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumNotEqualTo(Short value) {
            addCriterion("SerumSodium <>", value, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumGreaterThan(Short value) {
            addCriterion("SerumSodium >", value, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumGreaterThanOrEqualTo(Short value) {
            addCriterion("SerumSodium >=", value, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumLessThan(Short value) {
            addCriterion("SerumSodium <", value, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumLessThanOrEqualTo(Short value) {
            addCriterion("SerumSodium <=", value, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumIn(List<Short> values) {
            addCriterion("SerumSodium in", values, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumNotIn(List<Short> values) {
            addCriterion("SerumSodium not in", values, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumBetween(Short value1, Short value2) {
            addCriterion("SerumSodium between", value1, value2, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andSerumSodiumNotBetween(Short value1, Short value2) {
            addCriterion("SerumSodium not between", value1, value2, "serumSodium");
            return (Criteria) this;
        }
        public Criteria andCHOLIsNull() {
            addCriterion("CHOL is null");
            return (Criteria) this;
        }
        public Criteria andCHOLIsNotNull() {
            addCriterion("CHOL is not null");
            return (Criteria) this;
        }
        public Criteria andCHOLEqualTo(BigDecimal value) {
            addCriterion("CHOL =", value, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLNotEqualTo(BigDecimal value) {
            addCriterion("CHOL <>", value, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLGreaterThan(BigDecimal value) {
            addCriterion("CHOL >", value, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHOL >=", value, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLLessThan(BigDecimal value) {
            addCriterion("CHOL <", value, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHOL <=", value, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLIn(List<BigDecimal> values) {
            addCriterion("CHOL in", values, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLNotIn(List<BigDecimal> values) {
            addCriterion("CHOL not in", values, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHOL between", value1, value2, "CHOL");
            return (Criteria) this;
        }
        public Criteria andCHOLNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHOL not between", value1, value2, "CHOL");
            return (Criteria) this;
        }
        public Criteria andTGIsNull() {
            addCriterion("TG is null");
            return (Criteria) this;
        }
        public Criteria andTGIsNotNull() {
            addCriterion("TG is not null");
            return (Criteria) this;
        }
        public Criteria andTGEqualTo(BigDecimal value) {
            addCriterion("TG =", value, "TG");
            return (Criteria) this;
        }
        public Criteria andTGNotEqualTo(BigDecimal value) {
            addCriterion("TG <>", value, "TG");
            return (Criteria) this;
        }
        public Criteria andTGGreaterThan(BigDecimal value) {
            addCriterion("TG >", value, "TG");
            return (Criteria) this;
        }
        public Criteria andTGGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TG >=", value, "TG");
            return (Criteria) this;
        }
        public Criteria andTGLessThan(BigDecimal value) {
            addCriterion("TG <", value, "TG");
            return (Criteria) this;
        }
        public Criteria andTGLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TG <=", value, "TG");
            return (Criteria) this;
        }
        public Criteria andTGIn(List<BigDecimal> values) {
            addCriterion("TG in", values, "TG");
            return (Criteria) this;
        }
        public Criteria andTGNotIn(List<BigDecimal> values) {
            addCriterion("TG not in", values, "TG");
            return (Criteria) this;
        }
        public Criteria andTGBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TG between", value1, value2, "TG");
            return (Criteria) this;
        }
        public Criteria andTGNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TG not between", value1, value2, "TG");
            return (Criteria) this;
        }
        public Criteria andLDL_CIsNull() {
            addCriterion("LDL_C is null");
            return (Criteria) this;
        }
        public Criteria andLDL_CIsNotNull() {
            addCriterion("LDL_C is not null");
            return (Criteria) this;
        }
        public Criteria andLDL_CEqualTo(BigDecimal value) {
            addCriterion("LDL_C =", value, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CNotEqualTo(BigDecimal value) {
            addCriterion("LDL_C <>", value, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CGreaterThan(BigDecimal value) {
            addCriterion("LDL_C >", value, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LDL_C >=", value, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CLessThan(BigDecimal value) {
            addCriterion("LDL_C <", value, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LDL_C <=", value, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CIn(List<BigDecimal> values) {
            addCriterion("LDL_C in", values, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CNotIn(List<BigDecimal> values) {
            addCriterion("LDL_C not in", values, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LDL_C between", value1, value2, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andLDL_CNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LDL_C not between", value1, value2, "LDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CIsNull() {
            addCriterion("HDL_C is null");
            return (Criteria) this;
        }
        public Criteria andHDL_CIsNotNull() {
            addCriterion("HDL_C is not null");
            return (Criteria) this;
        }
        public Criteria andHDL_CEqualTo(BigDecimal value) {
            addCriterion("HDL_C =", value, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CNotEqualTo(BigDecimal value) {
            addCriterion("HDL_C <>", value, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CGreaterThan(BigDecimal value) {
            addCriterion("HDL_C >", value, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HDL_C >=", value, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CLessThan(BigDecimal value) {
            addCriterion("HDL_C <", value, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HDL_C <=", value, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CIn(List<BigDecimal> values) {
            addCriterion("HDL_C in", values, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CNotIn(List<BigDecimal> values) {
            addCriterion("HDL_C not in", values, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HDL_C between", value1, value2, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andHDL_CNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HDL_C not between", value1, value2, "HDL_C");
            return (Criteria) this;
        }
        public Criteria andX_RAYIsNull() {
            addCriterion("X_RAY is null");
            return (Criteria) this;
        }
        public Criteria andX_RAYIsNotNull() {
            addCriterion("X_RAY is not null");
            return (Criteria) this;
        }
        public Criteria andX_RAYEqualTo(Byte value) {
            addCriterion("X_RAY =", value, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYNotEqualTo(Byte value) {
            addCriterion("X_RAY <>", value, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYGreaterThan(Byte value) {
            addCriterion("X_RAY >", value, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYGreaterThanOrEqualTo(Byte value) {
            addCriterion("X_RAY >=", value, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYLessThan(Byte value) {
            addCriterion("X_RAY <", value, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYLessThanOrEqualTo(Byte value) {
            addCriterion("X_RAY <=", value, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYIn(List<Byte> values) {
            addCriterion("X_RAY in", values, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYNotIn(List<Byte> values) {
            addCriterion("X_RAY not in", values, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYBetween(Byte value1, Byte value2) {
            addCriterion("X_RAY between", value1, value2, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAYNotBetween(Byte value1, Byte value2) {
            addCriterion("X_RAY not between", value1, value2, "x_RAY");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescIsNull() {
            addCriterion("X_RAY_Desc is null");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescIsNotNull() {
            addCriterion("X_RAY_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescEqualTo(String value) {
            addCriterion("X_RAY_Desc =", value, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescNotEqualTo(String value) {
            addCriterion("X_RAY_Desc <>", value, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescGreaterThan(String value) {
            addCriterion("X_RAY_Desc >", value, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescGreaterThanOrEqualTo(String value) {
            addCriterion("X_RAY_Desc >=", value, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescLessThan(String value) {
            addCriterion("X_RAY_Desc <", value, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescLessThanOrEqualTo(String value) {
            addCriterion("X_RAY_Desc <=", value, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescLike(String value) {
            addCriterion("X_RAY_Desc like", value, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescNotLike(String value) {
            addCriterion("X_RAY_Desc not like", value, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescIn(List<String> values) {
            addCriterion("X_RAY_Desc in", values, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescNotIn(List<String> values) {
            addCriterion("X_RAY_Desc not in", values, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescBetween(String value1, String value2) {
            addCriterion("X_RAY_Desc between", value1, value2, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andX_RAY_DescNotBetween(String value1, String value2) {
            addCriterion("X_RAY_Desc not between", value1, value2, "x_RAY_Desc");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicIsNull() {
            addCriterion("B_Ultrasonic is null");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicIsNotNull() {
            addCriterion("B_Ultrasonic is not null");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicEqualTo(Byte value) {
            addCriterion("B_Ultrasonic =", value, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicNotEqualTo(Byte value) {
            addCriterion("B_Ultrasonic <>", value, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicGreaterThan(Byte value) {
            addCriterion("B_Ultrasonic >", value, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicGreaterThanOrEqualTo(Byte value) {
            addCriterion("B_Ultrasonic >=", value, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicLessThan(Byte value) {
            addCriterion("B_Ultrasonic <", value, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicLessThanOrEqualTo(Byte value) {
            addCriterion("B_Ultrasonic <=", value, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicIn(List<Byte> values) {
            addCriterion("B_Ultrasonic in", values, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicNotIn(List<Byte> values) {
            addCriterion("B_Ultrasonic not in", values, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicBetween(Byte value1, Byte value2) {
            addCriterion("B_Ultrasonic between", value1, value2, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_UltrasonicNotBetween(Byte value1, Byte value2) {
            addCriterion("B_Ultrasonic not between", value1, value2, "b_Ultrasonic");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescIsNull() {
            addCriterion("B_Ultrasonic_Desc is null");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescIsNotNull() {
            addCriterion("B_Ultrasonic_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescEqualTo(String value) {
            addCriterion("B_Ultrasonic_Desc =", value, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescNotEqualTo(String value) {
            addCriterion("B_Ultrasonic_Desc <>", value, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescGreaterThan(String value) {
            addCriterion("B_Ultrasonic_Desc >", value, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescGreaterThanOrEqualTo(String value) {
            addCriterion("B_Ultrasonic_Desc >=", value, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescLessThan(String value) {
            addCriterion("B_Ultrasonic_Desc <", value, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescLessThanOrEqualTo(String value) {
            addCriterion("B_Ultrasonic_Desc <=", value, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescLike(String value) {
            addCriterion("B_Ultrasonic_Desc like", value, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescNotLike(String value) {
            addCriterion("B_Ultrasonic_Desc not like", value, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescIn(List<String> values) {
            addCriterion("B_Ultrasonic_Desc in", values, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescNotIn(List<String> values) {
            addCriterion("B_Ultrasonic_Desc not in", values, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescBetween(String value1, String value2) {
            addCriterion("B_Ultrasonic_Desc between", value1, value2, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andB_Ultrasonic_DescNotBetween(String value1, String value2) {
            addCriterion("B_Ultrasonic_Desc not between", value1, value2, "b_Ultrasonic_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearIsNull() {
            addCriterion("CervicalSmear is null");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearIsNotNull() {
            addCriterion("CervicalSmear is not null");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearEqualTo(Byte value) {
            addCriterion("CervicalSmear =", value, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearNotEqualTo(Byte value) {
            addCriterion("CervicalSmear <>", value, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearGreaterThan(Byte value) {
            addCriterion("CervicalSmear >", value, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearGreaterThanOrEqualTo(Byte value) {
            addCriterion("CervicalSmear >=", value, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearLessThan(Byte value) {
            addCriterion("CervicalSmear <", value, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearLessThanOrEqualTo(Byte value) {
            addCriterion("CervicalSmear <=", value, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearIn(List<Byte> values) {
            addCriterion("CervicalSmear in", values, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearNotIn(List<Byte> values) {
            addCriterion("CervicalSmear not in", values, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearBetween(Byte value1, Byte value2) {
            addCriterion("CervicalSmear between", value1, value2, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmearNotBetween(Byte value1, Byte value2) {
            addCriterion("CervicalSmear not between", value1, value2, "cervicalSmear");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescIsNull() {
            addCriterion("CervicalSmear_Desc is null");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescIsNotNull() {
            addCriterion("CervicalSmear_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescEqualTo(String value) {
            addCriterion("CervicalSmear_Desc =", value, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescNotEqualTo(String value) {
            addCriterion("CervicalSmear_Desc <>", value, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescGreaterThan(String value) {
            addCriterion("CervicalSmear_Desc >", value, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescGreaterThanOrEqualTo(String value) {
            addCriterion("CervicalSmear_Desc >=", value, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescLessThan(String value) {
            addCriterion("CervicalSmear_Desc <", value, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescLessThanOrEqualTo(String value) {
            addCriterion("CervicalSmear_Desc <=", value, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescLike(String value) {
            addCriterion("CervicalSmear_Desc like", value, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescNotLike(String value) {
            addCriterion("CervicalSmear_Desc not like", value, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescIn(List<String> values) {
            addCriterion("CervicalSmear_Desc in", values, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescNotIn(List<String> values) {
            addCriterion("CervicalSmear_Desc not in", values, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescBetween(String value1, String value2) {
            addCriterion("CervicalSmear_Desc between", value1, value2, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andCervicalSmear_DescNotBetween(String value1, String value2) {
            addCriterion("CervicalSmear_Desc not between", value1, value2, "cervicalSmear_Desc");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherIsNull() {
            addCriterion("AssistCheckOther is null");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherIsNotNull() {
            addCriterion("AssistCheckOther is not null");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherEqualTo(String value) {
            addCriterion("AssistCheckOther =", value, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherNotEqualTo(String value) {
            addCriterion("AssistCheckOther <>", value, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherGreaterThan(String value) {
            addCriterion("AssistCheckOther >", value, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherGreaterThanOrEqualTo(String value) {
            addCriterion("AssistCheckOther >=", value, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherLessThan(String value) {
            addCriterion("AssistCheckOther <", value, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherLessThanOrEqualTo(String value) {
            addCriterion("AssistCheckOther <=", value, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherLike(String value) {
            addCriterion("AssistCheckOther like", value, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherNotLike(String value) {
            addCriterion("AssistCheckOther not like", value, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherIn(List<String> values) {
            addCriterion("AssistCheckOther in", values, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherNotIn(List<String> values) {
            addCriterion("AssistCheckOther not in", values, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherBetween(String value1, String value2) {
            addCriterion("AssistCheckOther between", value1, value2, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andAssistCheckOtherNotBetween(String value1, String value2) {
            addCriterion("AssistCheckOther not between", value1, value2, "assistCheckOther");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZIsNull() {
            addCriterion("TCM_PHZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZIsNotNull() {
            addCriterion("TCM_PHZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZEqualTo(Byte value) {
            addCriterion("TCM_PHZ =", value, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZNotEqualTo(Byte value) {
            addCriterion("TCM_PHZ <>", value, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZGreaterThan(Byte value) {
            addCriterion("TCM_PHZ >", value, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_PHZ >=", value, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZLessThan(Byte value) {
            addCriterion("TCM_PHZ <", value, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_PHZ <=", value, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZIn(List<Byte> values) {
            addCriterion("TCM_PHZ in", values, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZNotIn(List<Byte> values) {
            addCriterion("TCM_PHZ not in", values, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_PHZ between", value1, value2, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_PHZ not between", value1, value2, "TCM_PHZ");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideIsNull() {
            addCriterion("TCM_PHZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideIsNotNull() {
            addCriterion("TCM_PHZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideEqualTo(String value) {
            addCriterion("TCM_PHZ_Guide =", value, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_PHZ_Guide <>", value, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideGreaterThan(String value) {
            addCriterion("TCM_PHZ_Guide >", value, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_PHZ_Guide >=", value, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideLessThan(String value) {
            addCriterion("TCM_PHZ_Guide <", value, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_PHZ_Guide <=", value, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideLike(String value) {
            addCriterion("TCM_PHZ_Guide like", value, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideNotLike(String value) {
            addCriterion("TCM_PHZ_Guide not like", value, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideIn(List<String> values) {
            addCriterion("TCM_PHZ_Guide in", values, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_PHZ_Guide not in", values, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_PHZ_Guide between", value1, value2, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_PHZ_Guide not between", value1, value2, "TCM_PHZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescIsNull() {
            addCriterion("TCM_PHZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescIsNotNull() {
            addCriterion("TCM_PHZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_PHZ_Guide_Desc =", value, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_PHZ_Guide_Desc <>", value, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_PHZ_Guide_Desc >", value, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_PHZ_Guide_Desc >=", value, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_PHZ_Guide_Desc <", value, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_PHZ_Guide_Desc <=", value, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescLike(String value) {
            addCriterion("TCM_PHZ_Guide_Desc like", value, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_PHZ_Guide_Desc not like", value, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_PHZ_Guide_Desc in", values, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_PHZ_Guide_Desc not in", values, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_PHZ_Guide_Desc between", value1, value2, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_PHZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_PHZ_Guide_Desc not between", value1, value2, "TCM_PHZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZIsNull() {
            addCriterion("TCM_QXZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZIsNotNull() {
            addCriterion("TCM_QXZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZEqualTo(Byte value) {
            addCriterion("TCM_QXZ =", value, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZNotEqualTo(Byte value) {
            addCriterion("TCM_QXZ <>", value, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZGreaterThan(Byte value) {
            addCriterion("TCM_QXZ >", value, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_QXZ >=", value, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZLessThan(Byte value) {
            addCriterion("TCM_QXZ <", value, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_QXZ <=", value, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZIn(List<Byte> values) {
            addCriterion("TCM_QXZ in", values, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZNotIn(List<Byte> values) {
            addCriterion("TCM_QXZ not in", values, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_QXZ between", value1, value2, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_QXZ not between", value1, value2, "TCM_QXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideIsNull() {
            addCriterion("TCM_QXZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideIsNotNull() {
            addCriterion("TCM_QXZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideEqualTo(String value) {
            addCriterion("TCM_QXZ_Guide =", value, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_QXZ_Guide <>", value, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideGreaterThan(String value) {
            addCriterion("TCM_QXZ_Guide >", value, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_QXZ_Guide >=", value, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideLessThan(String value) {
            addCriterion("TCM_QXZ_Guide <", value, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_QXZ_Guide <=", value, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideLike(String value) {
            addCriterion("TCM_QXZ_Guide like", value, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideNotLike(String value) {
            addCriterion("TCM_QXZ_Guide not like", value, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideIn(List<String> values) {
            addCriterion("TCM_QXZ_Guide in", values, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_QXZ_Guide not in", values, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_QXZ_Guide between", value1, value2, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_QXZ_Guide not between", value1, value2, "TCM_QXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescIsNull() {
            addCriterion("TCM_QXZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescIsNotNull() {
            addCriterion("TCM_QXZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_QXZ_Guide_Desc =", value, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_QXZ_Guide_Desc <>", value, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_QXZ_Guide_Desc >", value, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_QXZ_Guide_Desc >=", value, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_QXZ_Guide_Desc <", value, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_QXZ_Guide_Desc <=", value, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescLike(String value) {
            addCriterion("TCM_QXZ_Guide_Desc like", value, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_QXZ_Guide_Desc not like", value, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_QXZ_Guide_Desc in", values, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_QXZ_Guide_Desc not in", values, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_QXZ_Guide_Desc between", value1, value2, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QXZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_QXZ_Guide_Desc not between", value1, value2, "TCM_QXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZIsNull() {
            addCriterion("TCM_YXZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZIsNotNull() {
            addCriterion("TCM_YXZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZEqualTo(Byte value) {
            addCriterion("TCM_YXZ =", value, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZNotEqualTo(Byte value) {
            addCriterion("TCM_YXZ <>", value, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZGreaterThan(Byte value) {
            addCriterion("TCM_YXZ >", value, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_YXZ >=", value, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZLessThan(Byte value) {
            addCriterion("TCM_YXZ <", value, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_YXZ <=", value, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZIn(List<Byte> values) {
            addCriterion("TCM_YXZ in", values, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZNotIn(List<Byte> values) {
            addCriterion("TCM_YXZ not in", values, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_YXZ between", value1, value2, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_YXZ not between", value1, value2, "TCM_YXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideIsNull() {
            addCriterion("TCM_YXZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideIsNotNull() {
            addCriterion("TCM_YXZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideEqualTo(String value) {
            addCriterion("TCM_YXZ_Guide =", value, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_YXZ_Guide <>", value, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideGreaterThan(String value) {
            addCriterion("TCM_YXZ_Guide >", value, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_YXZ_Guide >=", value, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideLessThan(String value) {
            addCriterion("TCM_YXZ_Guide <", value, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_YXZ_Guide <=", value, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideLike(String value) {
            addCriterion("TCM_YXZ_Guide like", value, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideNotLike(String value) {
            addCriterion("TCM_YXZ_Guide not like", value, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideIn(List<String> values) {
            addCriterion("TCM_YXZ_Guide in", values, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_YXZ_Guide not in", values, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_YXZ_Guide between", value1, value2, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_YXZ_Guide not between", value1, value2, "TCM_YXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescIsNull() {
            addCriterion("TCM_YXZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescIsNotNull() {
            addCriterion("TCM_YXZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_YXZ_Guide_Desc =", value, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_YXZ_Guide_Desc <>", value, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_YXZ_Guide_Desc >", value, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_YXZ_Guide_Desc >=", value, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_YXZ_Guide_Desc <", value, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_YXZ_Guide_Desc <=", value, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescLike(String value) {
            addCriterion("TCM_YXZ_Guide_Desc like", value, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_YXZ_Guide_Desc not like", value, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_YXZ_Guide_Desc in", values, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_YXZ_Guide_Desc not in", values, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_YXZ_Guide_Desc between", value1, value2, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YXZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_YXZ_Guide_Desc not between", value1, value2, "TCM_YXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZIsNull() {
            addCriterion("TCM_YIXZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZIsNotNull() {
            addCriterion("TCM_YIXZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZEqualTo(Byte value) {
            addCriterion("TCM_YIXZ =", value, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZNotEqualTo(Byte value) {
            addCriterion("TCM_YIXZ <>", value, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZGreaterThan(Byte value) {
            addCriterion("TCM_YIXZ >", value, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_YIXZ >=", value, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZLessThan(Byte value) {
            addCriterion("TCM_YIXZ <", value, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_YIXZ <=", value, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZIn(List<Byte> values) {
            addCriterion("TCM_YIXZ in", values, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZNotIn(List<Byte> values) {
            addCriterion("TCM_YIXZ not in", values, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_YIXZ between", value1, value2, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_YIXZ not between", value1, value2, "TCM_YIXZ");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideIsNull() {
            addCriterion("TCM_YIXZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideIsNotNull() {
            addCriterion("TCM_YIXZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideEqualTo(String value) {
            addCriterion("TCM_YIXZ_Guide =", value, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_YIXZ_Guide <>", value, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideGreaterThan(String value) {
            addCriterion("TCM_YIXZ_Guide >", value, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_YIXZ_Guide >=", value, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideLessThan(String value) {
            addCriterion("TCM_YIXZ_Guide <", value, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_YIXZ_Guide <=", value, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideLike(String value) {
            addCriterion("TCM_YIXZ_Guide like", value, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideNotLike(String value) {
            addCriterion("TCM_YIXZ_Guide not like", value, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideIn(List<String> values) {
            addCriterion("TCM_YIXZ_Guide in", values, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_YIXZ_Guide not in", values, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_YIXZ_Guide between", value1, value2, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_YIXZ_Guide not between", value1, value2, "TCM_YIXZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescIsNull() {
            addCriterion("TCM_YIXZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescIsNotNull() {
            addCriterion("TCM_YIXZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_YIXZ_Guide_Desc =", value, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_YIXZ_Guide_Desc <>", value, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_YIXZ_Guide_Desc >", value, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_YIXZ_Guide_Desc >=", value, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_YIXZ_Guide_Desc <", value, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_YIXZ_Guide_Desc <=", value, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescLike(String value) {
            addCriterion("TCM_YIXZ_Guide_Desc like", value, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_YIXZ_Guide_Desc not like", value, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_YIXZ_Guide_Desc in", values, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_YIXZ_Guide_Desc not in", values, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_YIXZ_Guide_Desc between", value1, value2, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_YIXZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_YIXZ_Guide_Desc not between", value1, value2, "TCM_YIXZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZIsNull() {
            addCriterion("TCM_TSZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZIsNotNull() {
            addCriterion("TCM_TSZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZEqualTo(Byte value) {
            addCriterion("TCM_TSZ =", value, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZNotEqualTo(Byte value) {
            addCriterion("TCM_TSZ <>", value, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZGreaterThan(Byte value) {
            addCriterion("TCM_TSZ >", value, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_TSZ >=", value, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZLessThan(Byte value) {
            addCriterion("TCM_TSZ <", value, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_TSZ <=", value, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZIn(List<Byte> values) {
            addCriterion("TCM_TSZ in", values, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZNotIn(List<Byte> values) {
            addCriterion("TCM_TSZ not in", values, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_TSZ between", value1, value2, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_TSZ not between", value1, value2, "TCM_TSZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideIsNull() {
            addCriterion("TCM_TSZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideIsNotNull() {
            addCriterion("TCM_TSZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideEqualTo(String value) {
            addCriterion("TCM_TSZ_Guide =", value, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_TSZ_Guide <>", value, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideGreaterThan(String value) {
            addCriterion("TCM_TSZ_Guide >", value, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_TSZ_Guide >=", value, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideLessThan(String value) {
            addCriterion("TCM_TSZ_Guide <", value, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_TSZ_Guide <=", value, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideLike(String value) {
            addCriterion("TCM_TSZ_Guide like", value, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideNotLike(String value) {
            addCriterion("TCM_TSZ_Guide not like", value, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideIn(List<String> values) {
            addCriterion("TCM_TSZ_Guide in", values, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_TSZ_Guide not in", values, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_TSZ_Guide between", value1, value2, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_TSZ_Guide not between", value1, value2, "TCM_TSZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescIsNull() {
            addCriterion("TCM_TSZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescIsNotNull() {
            addCriterion("TCM_TSZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_TSZ_Guide_Desc =", value, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_TSZ_Guide_Desc <>", value, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_TSZ_Guide_Desc >", value, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_TSZ_Guide_Desc >=", value, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_TSZ_Guide_Desc <", value, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_TSZ_Guide_Desc <=", value, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescLike(String value) {
            addCriterion("TCM_TSZ_Guide_Desc like", value, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_TSZ_Guide_Desc not like", value, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_TSZ_Guide_Desc in", values, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_TSZ_Guide_Desc not in", values, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_TSZ_Guide_Desc between", value1, value2, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TSZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_TSZ_Guide_Desc not between", value1, value2, "TCM_TSZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZIsNull() {
            addCriterion("TCM_SRZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZIsNotNull() {
            addCriterion("TCM_SRZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZEqualTo(Byte value) {
            addCriterion("TCM_SRZ =", value, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZNotEqualTo(Byte value) {
            addCriterion("TCM_SRZ <>", value, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZGreaterThan(Byte value) {
            addCriterion("TCM_SRZ >", value, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_SRZ >=", value, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZLessThan(Byte value) {
            addCriterion("TCM_SRZ <", value, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_SRZ <=", value, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZIn(List<Byte> values) {
            addCriterion("TCM_SRZ in", values, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZNotIn(List<Byte> values) {
            addCriterion("TCM_SRZ not in", values, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_SRZ between", value1, value2, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_SRZ not between", value1, value2, "TCM_SRZ");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideIsNull() {
            addCriterion("TCM_SRZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideIsNotNull() {
            addCriterion("TCM_SRZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideEqualTo(String value) {
            addCriterion("TCM_SRZ_Guide =", value, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_SRZ_Guide <>", value, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideGreaterThan(String value) {
            addCriterion("TCM_SRZ_Guide >", value, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_SRZ_Guide >=", value, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideLessThan(String value) {
            addCriterion("TCM_SRZ_Guide <", value, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_SRZ_Guide <=", value, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideLike(String value) {
            addCriterion("TCM_SRZ_Guide like", value, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideNotLike(String value) {
            addCriterion("TCM_SRZ_Guide not like", value, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideIn(List<String> values) {
            addCriterion("TCM_SRZ_Guide in", values, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_SRZ_Guide not in", values, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_SRZ_Guide between", value1, value2, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_SRZ_Guide not between", value1, value2, "TCM_SRZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescIsNull() {
            addCriterion("TCM_SRZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescIsNotNull() {
            addCriterion("TCM_SRZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_SRZ_Guide_Desc =", value, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_SRZ_Guide_Desc <>", value, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_SRZ_Guide_Desc >", value, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_SRZ_Guide_Desc >=", value, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_SRZ_Guide_Desc <", value, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_SRZ_Guide_Desc <=", value, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescLike(String value) {
            addCriterion("TCM_SRZ_Guide_Desc like", value, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_SRZ_Guide_Desc not like", value, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_SRZ_Guide_Desc in", values, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_SRZ_Guide_Desc not in", values, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_SRZ_Guide_Desc between", value1, value2, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_SRZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_SRZ_Guide_Desc not between", value1, value2, "TCM_SRZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZIsNull() {
            addCriterion("TCM_XTZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZIsNotNull() {
            addCriterion("TCM_XTZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZEqualTo(Byte value) {
            addCriterion("TCM_XTZ =", value, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZNotEqualTo(Byte value) {
            addCriterion("TCM_XTZ <>", value, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZGreaterThan(Byte value) {
            addCriterion("TCM_XTZ >", value, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_XTZ >=", value, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZLessThan(Byte value) {
            addCriterion("TCM_XTZ <", value, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_XTZ <=", value, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZIn(List<Byte> values) {
            addCriterion("TCM_XTZ in", values, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZNotIn(List<Byte> values) {
            addCriterion("TCM_XTZ not in", values, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_XTZ between", value1, value2, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_XTZ not between", value1, value2, "TCM_XTZ");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideIsNull() {
            addCriterion("TCM_XTZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideIsNotNull() {
            addCriterion("TCM_XTZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideEqualTo(String value) {
            addCriterion("TCM_XTZ_Guide =", value, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_XTZ_Guide <>", value, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideGreaterThan(String value) {
            addCriterion("TCM_XTZ_Guide >", value, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_XTZ_Guide >=", value, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideLessThan(String value) {
            addCriterion("TCM_XTZ_Guide <", value, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_XTZ_Guide <=", value, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideLike(String value) {
            addCriterion("TCM_XTZ_Guide like", value, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideNotLike(String value) {
            addCriterion("TCM_XTZ_Guide not like", value, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideIn(List<String> values) {
            addCriterion("TCM_XTZ_Guide in", values, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_XTZ_Guide not in", values, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_XTZ_Guide between", value1, value2, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_XTZ_Guide not between", value1, value2, "TCM_XTZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescIsNull() {
            addCriterion("TCM_XTZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescIsNotNull() {
            addCriterion("TCM_XTZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_XTZ_Guide_Desc =", value, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_XTZ_Guide_Desc <>", value, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_XTZ_Guide_Desc >", value, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_XTZ_Guide_Desc >=", value, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_XTZ_Guide_Desc <", value, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_XTZ_Guide_Desc <=", value, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescLike(String value) {
            addCriterion("TCM_XTZ_Guide_Desc like", value, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_XTZ_Guide_Desc not like", value, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_XTZ_Guide_Desc in", values, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_XTZ_Guide_Desc not in", values, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_XTZ_Guide_Desc between", value1, value2, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_XTZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_XTZ_Guide_Desc not between", value1, value2, "TCM_XTZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZIsNull() {
            addCriterion("TCM_QYZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZIsNotNull() {
            addCriterion("TCM_QYZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZEqualTo(Byte value) {
            addCriterion("TCM_QYZ =", value, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZNotEqualTo(Byte value) {
            addCriterion("TCM_QYZ <>", value, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZGreaterThan(Byte value) {
            addCriterion("TCM_QYZ >", value, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_QYZ >=", value, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZLessThan(Byte value) {
            addCriterion("TCM_QYZ <", value, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_QYZ <=", value, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZIn(List<Byte> values) {
            addCriterion("TCM_QYZ in", values, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZNotIn(List<Byte> values) {
            addCriterion("TCM_QYZ not in", values, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_QYZ between", value1, value2, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_QYZ not between", value1, value2, "TCM_QYZ");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideIsNull() {
            addCriterion("TCM_QYZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideIsNotNull() {
            addCriterion("TCM_QYZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideEqualTo(String value) {
            addCriterion("TCM_QYZ_Guide =", value, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_QYZ_Guide <>", value, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideGreaterThan(String value) {
            addCriterion("TCM_QYZ_Guide >", value, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_QYZ_Guide >=", value, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideLessThan(String value) {
            addCriterion("TCM_QYZ_Guide <", value, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_QYZ_Guide <=", value, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideLike(String value) {
            addCriterion("TCM_QYZ_Guide like", value, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideNotLike(String value) {
            addCriterion("TCM_QYZ_Guide not like", value, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideIn(List<String> values) {
            addCriterion("TCM_QYZ_Guide in", values, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_QYZ_Guide not in", values, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_QYZ_Guide between", value1, value2, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_QYZ_Guide not between", value1, value2, "TCM_QYZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescIsNull() {
            addCriterion("TCM_QYZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescIsNotNull() {
            addCriterion("TCM_QYZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_QYZ_Guide_Desc =", value, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_QYZ_Guide_Desc <>", value, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_QYZ_Guide_Desc >", value, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_QYZ_Guide_Desc >=", value, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_QYZ_Guide_Desc <", value, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_QYZ_Guide_Desc <=", value, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescLike(String value) {
            addCriterion("TCM_QYZ_Guide_Desc like", value, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_QYZ_Guide_Desc not like", value, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_QYZ_Guide_Desc in", values, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_QYZ_Guide_Desc not in", values, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_QYZ_Guide_Desc between", value1, value2, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_QYZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_QYZ_Guide_Desc not between", value1, value2, "TCM_QYZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZIsNull() {
            addCriterion("TCM_TBZ is null");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZIsNotNull() {
            addCriterion("TCM_TBZ is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZEqualTo(Byte value) {
            addCriterion("TCM_TBZ =", value, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZNotEqualTo(Byte value) {
            addCriterion("TCM_TBZ <>", value, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZGreaterThan(Byte value) {
            addCriterion("TCM_TBZ >", value, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZGreaterThanOrEqualTo(Byte value) {
            addCriterion("TCM_TBZ >=", value, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZLessThan(Byte value) {
            addCriterion("TCM_TBZ <", value, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZLessThanOrEqualTo(Byte value) {
            addCriterion("TCM_TBZ <=", value, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZIn(List<Byte> values) {
            addCriterion("TCM_TBZ in", values, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZNotIn(List<Byte> values) {
            addCriterion("TCM_TBZ not in", values, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZBetween(Byte value1, Byte value2) {
            addCriterion("TCM_TBZ between", value1, value2, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZNotBetween(Byte value1, Byte value2) {
            addCriterion("TCM_TBZ not between", value1, value2, "TCM_TBZ");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselIsNull() {
            addCriterion("CerebralVessel is null");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselIsNotNull() {
            addCriterion("CerebralVessel is not null");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselEqualTo(String value) {
            addCriterion("CerebralVessel =", value, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselNotEqualTo(String value) {
            addCriterion("CerebralVessel <>", value, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselGreaterThan(String value) {
            addCriterion("CerebralVessel >", value, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselGreaterThanOrEqualTo(String value) {
            addCriterion("CerebralVessel >=", value, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselLessThan(String value) {
            addCriterion("CerebralVessel <", value, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselLessThanOrEqualTo(String value) {
            addCriterion("CerebralVessel <=", value, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselLike(String value) {
            addCriterion("CerebralVessel like", value, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselNotLike(String value) {
            addCriterion("CerebralVessel not like", value, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselIn(List<String> values) {
            addCriterion("CerebralVessel in", values, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselNotIn(List<String> values) {
            addCriterion("CerebralVessel not in", values, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselBetween(String value1, String value2) {
            addCriterion("CerebralVessel between", value1, value2, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andCerebralVesselNotBetween(String value1, String value2) {
            addCriterion("CerebralVessel not between", value1, value2, "cerebralVessel");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideIsNull() {
            addCriterion("TCM_TBZ_Guide is null");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideIsNotNull() {
            addCriterion("TCM_TBZ_Guide is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideEqualTo(String value) {
            addCriterion("TCM_TBZ_Guide =", value, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideNotEqualTo(String value) {
            addCriterion("TCM_TBZ_Guide <>", value, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideGreaterThan(String value) {
            addCriterion("TCM_TBZ_Guide >", value, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_TBZ_Guide >=", value, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideLessThan(String value) {
            addCriterion("TCM_TBZ_Guide <", value, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideLessThanOrEqualTo(String value) {
            addCriterion("TCM_TBZ_Guide <=", value, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideLike(String value) {
            addCriterion("TCM_TBZ_Guide like", value, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideNotLike(String value) {
            addCriterion("TCM_TBZ_Guide not like", value, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideIn(List<String> values) {
            addCriterion("TCM_TBZ_Guide in", values, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideNotIn(List<String> values) {
            addCriterion("TCM_TBZ_Guide not in", values, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideBetween(String value1, String value2) {
            addCriterion("TCM_TBZ_Guide between", value1, value2, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_GuideNotBetween(String value1, String value2) {
            addCriterion("TCM_TBZ_Guide not between", value1, value2, "TCM_TBZ_Guide");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescIsNull() {
            addCriterion("TCM_TBZ_Guide_Desc is null");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescIsNotNull() {
            addCriterion("TCM_TBZ_Guide_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescEqualTo(String value) {
            addCriterion("TCM_TBZ_Guide_Desc =", value, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescNotEqualTo(String value) {
            addCriterion("TCM_TBZ_Guide_Desc <>", value, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescGreaterThan(String value) {
            addCriterion("TCM_TBZ_Guide_Desc >", value, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescGreaterThanOrEqualTo(String value) {
            addCriterion("TCM_TBZ_Guide_Desc >=", value, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescLessThan(String value) {
            addCriterion("TCM_TBZ_Guide_Desc <", value, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescLessThanOrEqualTo(String value) {
            addCriterion("TCM_TBZ_Guide_Desc <=", value, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescLike(String value) {
            addCriterion("TCM_TBZ_Guide_Desc like", value, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescNotLike(String value) {
            addCriterion("TCM_TBZ_Guide_Desc not like", value, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescIn(List<String> values) {
            addCriterion("TCM_TBZ_Guide_Desc in", values, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescNotIn(List<String> values) {
            addCriterion("TCM_TBZ_Guide_Desc not in", values, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescBetween(String value1, String value2) {
            addCriterion("TCM_TBZ_Guide_Desc between", value1, value2, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andTCM_TBZ_Guide_DescNotBetween(String value1, String value2) {
            addCriterion("TCM_TBZ_Guide_Desc not between", value1, value2, "TCM_TBZ_Guide_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescIsNull() {
            addCriterion("CerebralVessel_Desc is null");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescIsNotNull() {
            addCriterion("CerebralVessel_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescEqualTo(String value) {
            addCriterion("CerebralVessel_Desc =", value, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescNotEqualTo(String value) {
            addCriterion("CerebralVessel_Desc <>", value, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescGreaterThan(String value) {
            addCriterion("CerebralVessel_Desc >", value, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescGreaterThanOrEqualTo(String value) {
            addCriterion("CerebralVessel_Desc >=", value, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescLessThan(String value) {
            addCriterion("CerebralVessel_Desc <", value, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescLessThanOrEqualTo(String value) {
            addCriterion("CerebralVessel_Desc <=", value, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescLike(String value) {
            addCriterion("CerebralVessel_Desc like", value, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescNotLike(String value) {
            addCriterion("CerebralVessel_Desc not like", value, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescIn(List<String> values) {
            addCriterion("CerebralVessel_Desc in", values, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescNotIn(List<String> values) {
            addCriterion("CerebralVessel_Desc not in", values, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescBetween(String value1, String value2) {
            addCriterion("CerebralVessel_Desc between", value1, value2, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andCerebralVessel_DescNotBetween(String value1, String value2) {
            addCriterion("CerebralVessel_Desc not between", value1, value2, "cerebralVessel_Desc");
            return (Criteria) this;
        }
        public Criteria andKidneyIsNull() {
            addCriterion("Kidney is null");
            return (Criteria) this;
        }
        public Criteria andKidneyIsNotNull() {
            addCriterion("Kidney is not null");
            return (Criteria) this;
        }
        public Criteria andKidneyEqualTo(String value) {
            addCriterion("Kidney =", value, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyNotEqualTo(String value) {
            addCriterion("Kidney <>", value, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyGreaterThan(String value) {
            addCriterion("Kidney >", value, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyGreaterThanOrEqualTo(String value) {
            addCriterion("Kidney >=", value, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyLessThan(String value) {
            addCriterion("Kidney <", value, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyLessThanOrEqualTo(String value) {
            addCriterion("Kidney <=", value, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyLike(String value) {
            addCriterion("Kidney like", value, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyNotLike(String value) {
            addCriterion("Kidney not like", value, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyIn(List<String> values) {
            addCriterion("Kidney in", values, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyNotIn(List<String> values) {
            addCriterion("Kidney not in", values, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyBetween(String value1, String value2) {
            addCriterion("Kidney between", value1, value2, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidneyNotBetween(String value1, String value2) {
            addCriterion("Kidney not between", value1, value2, "kidney");
            return (Criteria) this;
        }
        public Criteria andKidney_DescIsNull() {
            addCriterion("Kidney_Desc is null");
            return (Criteria) this;
        }
        public Criteria andKidney_DescIsNotNull() {
            addCriterion("Kidney_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andKidney_DescEqualTo(String value) {
            addCriterion("Kidney_Desc =", value, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescNotEqualTo(String value) {
            addCriterion("Kidney_Desc <>", value, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescGreaterThan(String value) {
            addCriterion("Kidney_Desc >", value, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Kidney_Desc >=", value, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescLessThan(String value) {
            addCriterion("Kidney_Desc <", value, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescLessThanOrEqualTo(String value) {
            addCriterion("Kidney_Desc <=", value, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescLike(String value) {
            addCriterion("Kidney_Desc like", value, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescNotLike(String value) {
            addCriterion("Kidney_Desc not like", value, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescIn(List<String> values) {
            addCriterion("Kidney_Desc in", values, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescNotIn(List<String> values) {
            addCriterion("Kidney_Desc not in", values, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescBetween(String value1, String value2) {
            addCriterion("Kidney_Desc between", value1, value2, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andKidney_DescNotBetween(String value1, String value2) {
            addCriterion("Kidney_Desc not between", value1, value2, "kidney_Desc");
            return (Criteria) this;
        }
        public Criteria andHeartIsNull() {
            addCriterion("Heart is null");
            return (Criteria) this;
        }
        public Criteria andHeartIsNotNull() {
            addCriterion("Heart is not null");
            return (Criteria) this;
        }
        public Criteria andHeartEqualTo(String value) {
            addCriterion("Heart =", value, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartNotEqualTo(String value) {
            addCriterion("Heart <>", value, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartGreaterThan(String value) {
            addCriterion("Heart >", value, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartGreaterThanOrEqualTo(String value) {
            addCriterion("Heart >=", value, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartLessThan(String value) {
            addCriterion("Heart <", value, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartLessThanOrEqualTo(String value) {
            addCriterion("Heart <=", value, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartLike(String value) {
            addCriterion("Heart like", value, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartNotLike(String value) {
            addCriterion("Heart not like", value, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartIn(List<String> values) {
            addCriterion("Heart in", values, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartNotIn(List<String> values) {
            addCriterion("Heart not in", values, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartBetween(String value1, String value2) {
            addCriterion("Heart between", value1, value2, "heart");
            return (Criteria) this;
        }
        public Criteria andHeartNotBetween(String value1, String value2) {
            addCriterion("Heart not between", value1, value2, "heart");
            return (Criteria) this;
        }
        public Criteria andHeart_DescIsNull() {
            addCriterion("Heart_Desc is null");
            return (Criteria) this;
        }
        public Criteria andHeart_DescIsNotNull() {
            addCriterion("Heart_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andHeart_DescEqualTo(String value) {
            addCriterion("Heart_Desc =", value, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescNotEqualTo(String value) {
            addCriterion("Heart_Desc <>", value, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescGreaterThan(String value) {
            addCriterion("Heart_Desc >", value, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescGreaterThanOrEqualTo(String value) {
            addCriterion("Heart_Desc >=", value, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescLessThan(String value) {
            addCriterion("Heart_Desc <", value, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescLessThanOrEqualTo(String value) {
            addCriterion("Heart_Desc <=", value, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescLike(String value) {
            addCriterion("Heart_Desc like", value, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescNotLike(String value) {
            addCriterion("Heart_Desc not like", value, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescIn(List<String> values) {
            addCriterion("Heart_Desc in", values, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescNotIn(List<String> values) {
            addCriterion("Heart_Desc not in", values, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescBetween(String value1, String value2) {
            addCriterion("Heart_Desc between", value1, value2, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andHeart_DescNotBetween(String value1, String value2) {
            addCriterion("Heart_Desc not between", value1, value2, "heart_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipeIsNull() {
            addCriterion("BloodPipe is null");
            return (Criteria) this;
        }
        public Criteria andBloodPipeIsNotNull() {
            addCriterion("BloodPipe is not null");
            return (Criteria) this;
        }
        public Criteria andBloodPipeEqualTo(String value) {
            addCriterion("BloodPipe =", value, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeNotEqualTo(String value) {
            addCriterion("BloodPipe <>", value, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeGreaterThan(String value) {
            addCriterion("BloodPipe >", value, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeGreaterThanOrEqualTo(String value) {
            addCriterion("BloodPipe >=", value, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeLessThan(String value) {
            addCriterion("BloodPipe <", value, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeLessThanOrEqualTo(String value) {
            addCriterion("BloodPipe <=", value, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeLike(String value) {
            addCriterion("BloodPipe like", value, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeNotLike(String value) {
            addCriterion("BloodPipe not like", value, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeIn(List<String> values) {
            addCriterion("BloodPipe in", values, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeNotIn(List<String> values) {
            addCriterion("BloodPipe not in", values, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeBetween(String value1, String value2) {
            addCriterion("BloodPipe between", value1, value2, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipeNotBetween(String value1, String value2) {
            addCriterion("BloodPipe not between", value1, value2, "bloodPipe");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescIsNull() {
            addCriterion("BloodPipe_Desc is null");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescIsNotNull() {
            addCriterion("BloodPipe_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescEqualTo(String value) {
            addCriterion("BloodPipe_Desc =", value, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescNotEqualTo(String value) {
            addCriterion("BloodPipe_Desc <>", value, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescGreaterThan(String value) {
            addCriterion("BloodPipe_Desc >", value, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescGreaterThanOrEqualTo(String value) {
            addCriterion("BloodPipe_Desc >=", value, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescLessThan(String value) {
            addCriterion("BloodPipe_Desc <", value, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescLessThanOrEqualTo(String value) {
            addCriterion("BloodPipe_Desc <=", value, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescLike(String value) {
            addCriterion("BloodPipe_Desc like", value, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescNotLike(String value) {
            addCriterion("BloodPipe_Desc not like", value, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescIn(List<String> values) {
            addCriterion("BloodPipe_Desc in", values, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescNotIn(List<String> values) {
            addCriterion("BloodPipe_Desc not in", values, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescBetween(String value1, String value2) {
            addCriterion("BloodPipe_Desc between", value1, value2, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andBloodPipe_DescNotBetween(String value1, String value2) {
            addCriterion("BloodPipe_Desc not between", value1, value2, "bloodPipe_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePartIsNull() {
            addCriterion("EyePart is null");
            return (Criteria) this;
        }
        public Criteria andEyePartIsNotNull() {
            addCriterion("EyePart is not null");
            return (Criteria) this;
        }
        public Criteria andEyePartEqualTo(String value) {
            addCriterion("EyePart =", value, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartNotEqualTo(String value) {
            addCriterion("EyePart <>", value, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartGreaterThan(String value) {
            addCriterion("EyePart >", value, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartGreaterThanOrEqualTo(String value) {
            addCriterion("EyePart >=", value, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartLessThan(String value) {
            addCriterion("EyePart <", value, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartLessThanOrEqualTo(String value) {
            addCriterion("EyePart <=", value, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartLike(String value) {
            addCriterion("EyePart like", value, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartNotLike(String value) {
            addCriterion("EyePart not like", value, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartIn(List<String> values) {
            addCriterion("EyePart in", values, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartNotIn(List<String> values) {
            addCriterion("EyePart not in", values, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartBetween(String value1, String value2) {
            addCriterion("EyePart between", value1, value2, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePartNotBetween(String value1, String value2) {
            addCriterion("EyePart not between", value1, value2, "eyePart");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescIsNull() {
            addCriterion("EyePart_Desc is null");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescIsNotNull() {
            addCriterion("EyePart_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescEqualTo(String value) {
            addCriterion("EyePart_Desc =", value, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescNotEqualTo(String value) {
            addCriterion("EyePart_Desc <>", value, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescGreaterThan(String value) {
            addCriterion("EyePart_Desc >", value, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescGreaterThanOrEqualTo(String value) {
            addCriterion("EyePart_Desc >=", value, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescLessThan(String value) {
            addCriterion("EyePart_Desc <", value, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescLessThanOrEqualTo(String value) {
            addCriterion("EyePart_Desc <=", value, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescLike(String value) {
            addCriterion("EyePart_Desc like", value, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescNotLike(String value) {
            addCriterion("EyePart_Desc not like", value, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescIn(List<String> values) {
            addCriterion("EyePart_Desc in", values, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescNotIn(List<String> values) {
            addCriterion("EyePart_Desc not in", values, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescBetween(String value1, String value2) {
            addCriterion("EyePart_Desc between", value1, value2, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andEyePart_DescNotBetween(String value1, String value2) {
            addCriterion("EyePart_Desc not between", value1, value2, "eyePart_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystemIsNull() {
            addCriterion("NervousSystem is null");
            return (Criteria) this;
        }
        public Criteria andNervousSystemIsNotNull() {
            addCriterion("NervousSystem is not null");
            return (Criteria) this;
        }
        public Criteria andNervousSystemEqualTo(Byte value) {
            addCriterion("NervousSystem =", value, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemNotEqualTo(Byte value) {
            addCriterion("NervousSystem <>", value, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemGreaterThan(Byte value) {
            addCriterion("NervousSystem >", value, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemGreaterThanOrEqualTo(Byte value) {
            addCriterion("NervousSystem >=", value, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemLessThan(Byte value) {
            addCriterion("NervousSystem <", value, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemLessThanOrEqualTo(Byte value) {
            addCriterion("NervousSystem <=", value, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemIn(List<Byte> values) {
            addCriterion("NervousSystem in", values, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemNotIn(List<Byte> values) {
            addCriterion("NervousSystem not in", values, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemBetween(Byte value1, Byte value2) {
            addCriterion("NervousSystem between", value1, value2, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystemNotBetween(Byte value1, Byte value2) {
            addCriterion("NervousSystem not between", value1, value2, "nervousSystem");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescIsNull() {
            addCriterion("NervousSystem_Desc is null");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescIsNotNull() {
            addCriterion("NervousSystem_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescEqualTo(String value) {
            addCriterion("NervousSystem_Desc =", value, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescNotEqualTo(String value) {
            addCriterion("NervousSystem_Desc <>", value, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescGreaterThan(String value) {
            addCriterion("NervousSystem_Desc >", value, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescGreaterThanOrEqualTo(String value) {
            addCriterion("NervousSystem_Desc >=", value, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescLessThan(String value) {
            addCriterion("NervousSystem_Desc <", value, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescLessThanOrEqualTo(String value) {
            addCriterion("NervousSystem_Desc <=", value, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescLike(String value) {
            addCriterion("NervousSystem_Desc like", value, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescNotLike(String value) {
            addCriterion("NervousSystem_Desc not like", value, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescIn(List<String> values) {
            addCriterion("NervousSystem_Desc in", values, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescNotIn(List<String> values) {
            addCriterion("NervousSystem_Desc not in", values, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescBetween(String value1, String value2) {
            addCriterion("NervousSystem_Desc between", value1, value2, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andNervousSystem_DescNotBetween(String value1, String value2) {
            addCriterion("NervousSystem_Desc not between", value1, value2, "nervousSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystemIsNull() {
            addCriterion("OtherSystem is null");
            return (Criteria) this;
        }
        public Criteria andOtherSystemIsNotNull() {
            addCriterion("OtherSystem is not null");
            return (Criteria) this;
        }
        public Criteria andOtherSystemEqualTo(Byte value) {
            addCriterion("OtherSystem =", value, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemNotEqualTo(Byte value) {
            addCriterion("OtherSystem <>", value, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemGreaterThan(Byte value) {
            addCriterion("OtherSystem >", value, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemGreaterThanOrEqualTo(Byte value) {
            addCriterion("OtherSystem >=", value, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemLessThan(Byte value) {
            addCriterion("OtherSystem <", value, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemLessThanOrEqualTo(Byte value) {
            addCriterion("OtherSystem <=", value, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemIn(List<Byte> values) {
            addCriterion("OtherSystem in", values, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemNotIn(List<Byte> values) {
            addCriterion("OtherSystem not in", values, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemBetween(Byte value1, Byte value2) {
            addCriterion("OtherSystem between", value1, value2, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystemNotBetween(Byte value1, Byte value2) {
            addCriterion("OtherSystem not between", value1, value2, "otherSystem");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescIsNull() {
            addCriterion("OtherSystem_Desc is null");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescIsNotNull() {
            addCriterion("OtherSystem_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescEqualTo(String value) {
            addCriterion("OtherSystem_Desc =", value, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescNotEqualTo(String value) {
            addCriterion("OtherSystem_Desc <>", value, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescGreaterThan(String value) {
            addCriterion("OtherSystem_Desc >", value, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescGreaterThanOrEqualTo(String value) {
            addCriterion("OtherSystem_Desc >=", value, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescLessThan(String value) {
            addCriterion("OtherSystem_Desc <", value, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescLessThanOrEqualTo(String value) {
            addCriterion("OtherSystem_Desc <=", value, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescLike(String value) {
            addCriterion("OtherSystem_Desc like", value, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescNotLike(String value) {
            addCriterion("OtherSystem_Desc not like", value, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescIn(List<String> values) {
            addCriterion("OtherSystem_Desc in", values, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescNotIn(List<String> values) {
            addCriterion("OtherSystem_Desc not in", values, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescBetween(String value1, String value2) {
            addCriterion("OtherSystem_Desc between", value1, value2, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andOtherSystem_DescNotBetween(String value1, String value2) {
            addCriterion("OtherSystem_Desc not between", value1, value2, "otherSystem_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateIsNull() {
            addCriterion("HealthEvaluate is null");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateIsNotNull() {
            addCriterion("HealthEvaluate is not null");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateEqualTo(Byte value) {
            addCriterion("HealthEvaluate =", value, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateNotEqualTo(Byte value) {
            addCriterion("HealthEvaluate <>", value, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateGreaterThan(Byte value) {
            addCriterion("HealthEvaluate >", value, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateGreaterThanOrEqualTo(Byte value) {
            addCriterion("HealthEvaluate >=", value, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateLessThan(Byte value) {
            addCriterion("HealthEvaluate <", value, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateLessThanOrEqualTo(Byte value) {
            addCriterion("HealthEvaluate <=", value, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateIn(List<Byte> values) {
            addCriterion("HealthEvaluate in", values, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateNotIn(List<Byte> values) {
            addCriterion("HealthEvaluate not in", values, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateBetween(Byte value1, Byte value2) {
            addCriterion("HealthEvaluate between", value1, value2, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluateNotBetween(Byte value1, Byte value2) {
            addCriterion("HealthEvaluate not between", value1, value2, "healthEvaluate");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescIsNull() {
            addCriterion("HealthEvaluate_Desc is null");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescIsNotNull() {
            addCriterion("HealthEvaluate_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescEqualTo(String value) {
            addCriterion("HealthEvaluate_Desc =", value, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescNotEqualTo(String value) {
            addCriterion("HealthEvaluate_Desc <>", value, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescGreaterThan(String value) {
            addCriterion("HealthEvaluate_Desc >", value, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescGreaterThanOrEqualTo(String value) {
            addCriterion("HealthEvaluate_Desc >=", value, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescLessThan(String value) {
            addCriterion("HealthEvaluate_Desc <", value, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescLessThanOrEqualTo(String value) {
            addCriterion("HealthEvaluate_Desc <=", value, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescLike(String value) {
            addCriterion("HealthEvaluate_Desc like", value, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescNotLike(String value) {
            addCriterion("HealthEvaluate_Desc not like", value, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescIn(List<String> values) {
            addCriterion("HealthEvaluate_Desc in", values, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescNotIn(List<String> values) {
            addCriterion("HealthEvaluate_Desc not in", values, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescBetween(String value1, String value2) {
            addCriterion("HealthEvaluate_Desc between", value1, value2, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthEvaluate_DescNotBetween(String value1, String value2) {
            addCriterion("HealthEvaluate_Desc not between", value1, value2, "healthEvaluate_Desc");
            return (Criteria) this;
        }
        public Criteria andHealthGuideIsNull() {
            addCriterion("HealthGuide is null");
            return (Criteria) this;
        }
        public Criteria andHealthGuideIsNotNull() {
            addCriterion("HealthGuide is not null");
            return (Criteria) this;
        }
        public Criteria andHealthGuideEqualTo(String value) {
            addCriterion("HealthGuide =", value, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideNotEqualTo(String value) {
            addCriterion("HealthGuide <>", value, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideGreaterThan(String value) {
            addCriterion("HealthGuide >", value, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideGreaterThanOrEqualTo(String value) {
            addCriterion("HealthGuide >=", value, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideLessThan(String value) {
            addCriterion("HealthGuide <", value, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideLessThanOrEqualTo(String value) {
            addCriterion("HealthGuide <=", value, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideLike(String value) {
            addCriterion("HealthGuide like", value, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideNotLike(String value) {
            addCriterion("HealthGuide not like", value, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideIn(List<String> values) {
            addCriterion("HealthGuide in", values, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideNotIn(List<String> values) {
            addCriterion("HealthGuide not in", values, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideBetween(String value1, String value2) {
            addCriterion("HealthGuide between", value1, value2, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andHealthGuideNotBetween(String value1, String value2) {
            addCriterion("HealthGuide not between", value1, value2, "healthGuide");
            return (Criteria) this;
        }
        public Criteria andRiskFactorIsNull() {
            addCriterion("RiskFactor is null");
            return (Criteria) this;
        }
        public Criteria andRiskFactorIsNotNull() {
            addCriterion("RiskFactor is not null");
            return (Criteria) this;
        }
        public Criteria andRiskFactorEqualTo(String value) {
            addCriterion("RiskFactor =", value, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorNotEqualTo(String value) {
            addCriterion("RiskFactor <>", value, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorGreaterThan(String value) {
            addCriterion("RiskFactor >", value, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorGreaterThanOrEqualTo(String value) {
            addCriterion("RiskFactor >=", value, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorLessThan(String value) {
            addCriterion("RiskFactor <", value, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorLessThanOrEqualTo(String value) {
            addCriterion("RiskFactor <=", value, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorLike(String value) {
            addCriterion("RiskFactor like", value, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorNotLike(String value) {
            addCriterion("RiskFactor not like", value, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorIn(List<String> values) {
            addCriterion("RiskFactor in", values, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorNotIn(List<String> values) {
            addCriterion("RiskFactor not in", values, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorBetween(String value1, String value2) {
            addCriterion("RiskFactor between", value1, value2, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactorNotBetween(String value1, String value2) {
            addCriterion("RiskFactor not between", value1, value2, "riskFactor");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetIsNull() {
            addCriterion("RiskFactor_Target is null");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetIsNotNull() {
            addCriterion("RiskFactor_Target is not null");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetEqualTo(String value) {
            addCriterion("RiskFactor_Target =", value, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetNotEqualTo(String value) {
            addCriterion("RiskFactor_Target <>", value, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetGreaterThan(String value) {
            addCriterion("RiskFactor_Target >", value, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetGreaterThanOrEqualTo(String value) {
            addCriterion("RiskFactor_Target >=", value, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetLessThan(String value) {
            addCriterion("RiskFactor_Target <", value, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetLessThanOrEqualTo(String value) {
            addCriterion("RiskFactor_Target <=", value, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetLike(String value) {
            addCriterion("RiskFactor_Target like", value, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetNotLike(String value) {
            addCriterion("RiskFactor_Target not like", value, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetIn(List<String> values) {
            addCriterion("RiskFactor_Target in", values, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetNotIn(List<String> values) {
            addCriterion("RiskFactor_Target not in", values, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetBetween(String value1, String value2) {
            addCriterion("RiskFactor_Target between", value1, value2, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_TargetNotBetween(String value1, String value2) {
            addCriterion("RiskFactor_Target not between", value1, value2, "riskFactor_Target");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineIsNull() {
            addCriterion("RiskFactor_Vaccine is null");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineIsNotNull() {
            addCriterion("RiskFactor_Vaccine is not null");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineEqualTo(String value) {
            addCriterion("RiskFactor_Vaccine =", value, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineNotEqualTo(String value) {
            addCriterion("RiskFactor_Vaccine <>", value, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineGreaterThan(String value) {
            addCriterion("RiskFactor_Vaccine >", value, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineGreaterThanOrEqualTo(String value) {
            addCriterion("RiskFactor_Vaccine >=", value, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineLessThan(String value) {
            addCriterion("RiskFactor_Vaccine <", value, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineLessThanOrEqualTo(String value) {
            addCriterion("RiskFactor_Vaccine <=", value, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineLike(String value) {
            addCriterion("RiskFactor_Vaccine like", value, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineNotLike(String value) {
            addCriterion("RiskFactor_Vaccine not like", value, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineIn(List<String> values) {
            addCriterion("RiskFactor_Vaccine in", values, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineNotIn(List<String> values) {
            addCriterion("RiskFactor_Vaccine not in", values, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineBetween(String value1, String value2) {
            addCriterion("RiskFactor_Vaccine between", value1, value2, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_VaccineNotBetween(String value1, String value2) {
            addCriterion("RiskFactor_Vaccine not between", value1, value2, "riskFactor_Vaccine");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherIsNull() {
            addCriterion("RiskFactor_Other is null");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherIsNotNull() {
            addCriterion("RiskFactor_Other is not null");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherEqualTo(String value) {
            addCriterion("RiskFactor_Other =", value, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherNotEqualTo(String value) {
            addCriterion("RiskFactor_Other <>", value, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherGreaterThan(String value) {
            addCriterion("RiskFactor_Other >", value, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherGreaterThanOrEqualTo(String value) {
            addCriterion("RiskFactor_Other >=", value, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherLessThan(String value) {
            addCriterion("RiskFactor_Other <", value, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherLessThanOrEqualTo(String value) {
            addCriterion("RiskFactor_Other <=", value, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherLike(String value) {
            addCriterion("RiskFactor_Other like", value, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherNotLike(String value) {
            addCriterion("RiskFactor_Other not like", value, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherIn(List<String> values) {
            addCriterion("RiskFactor_Other in", values, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherNotIn(List<String> values) {
            addCriterion("RiskFactor_Other not in", values, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherBetween(String value1, String value2) {
            addCriterion("RiskFactor_Other between", value1, value2, "riskFactor_Other");
            return (Criteria) this;
        }
        public Criteria andRiskFactor_OtherNotBetween(String value1, String value2) {
            addCriterion("RiskFactor_Other not between", value1, value2, "riskFactor_Other");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 公共卫生_健康体检明细表
     * 
     * @author ${user}
     * @version 1.0 2016-06-27
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