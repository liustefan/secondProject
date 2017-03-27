/*
 * PhHypertensiondetailExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhHypertensiondetailExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public PhHypertensiondetailExample() {
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
     * 公共卫生_高血压随访明细表
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
        public Criteria andHypertensionIDNotEqualTo(Long value) {
            addCriterion("HypertensionID <>", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDGreaterThan(Long value) {
            addCriterion("HypertensionID >", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDGreaterThanOrEqualTo(Long value) {
            addCriterion("HypertensionID >=", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDLessThan(Long value) {
            addCriterion("HypertensionID <", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDLessThanOrEqualTo(Long value) {
            addCriterion("HypertensionID <=", value, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDIn(List<Long> values) {
            addCriterion("HypertensionID in", values, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDNotIn(List<Long> values) {
            addCriterion("HypertensionID not in", values, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDBetween(Long value1, Long value2) {
            addCriterion("HypertensionID between", value1, value2, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andHypertensionIDNotBetween(Long value1, Long value2) {
            addCriterion("HypertensionID not between", value1, value2, "hypertensionID");
            return (Criteria) this;
        }
        public Criteria andVisitWayIsNull() {
            addCriterion("VisitWay is null");
            return (Criteria) this;
        }
        public Criteria andVisitWayIsNotNull() {
            addCriterion("VisitWay is not null");
            return (Criteria) this;
        }
        public Criteria andVisitWayEqualTo(Byte value) {
            addCriterion("VisitWay =", value, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayNotEqualTo(Byte value) {
            addCriterion("VisitWay <>", value, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayGreaterThan(Byte value) {
            addCriterion("VisitWay >", value, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayGreaterThanOrEqualTo(Byte value) {
            addCriterion("VisitWay >=", value, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayLessThan(Byte value) {
            addCriterion("VisitWay <", value, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayLessThanOrEqualTo(Byte value) {
            addCriterion("VisitWay <=", value, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayIn(List<Byte> values) {
            addCriterion("VisitWay in", values, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayNotIn(List<Byte> values) {
            addCriterion("VisitWay not in", values, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayBetween(Byte value1, Byte value2) {
            addCriterion("VisitWay between", value1, value2, "visitWay");
            return (Criteria) this;
        }
        public Criteria andVisitWayNotBetween(Byte value1, Byte value2) {
            addCriterion("VisitWay not between", value1, value2, "visitWay");
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
        public Criteria andSystolicIsNull() {
            addCriterion("Systolic is null");
            return (Criteria) this;
        }
        public Criteria andSystolicIsNotNull() {
            addCriterion("Systolic is not null");
            return (Criteria) this;
        }
        public Criteria andSystolicEqualTo(Short value) {
            addCriterion("Systolic =", value, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicNotEqualTo(Short value) {
            addCriterion("Systolic <>", value, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicGreaterThan(Short value) {
            addCriterion("Systolic >", value, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicGreaterThanOrEqualTo(Short value) {
            addCriterion("Systolic >=", value, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicLessThan(Short value) {
            addCriterion("Systolic <", value, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicLessThanOrEqualTo(Short value) {
            addCriterion("Systolic <=", value, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicIn(List<Short> values) {
            addCriterion("Systolic in", values, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicNotIn(List<Short> values) {
            addCriterion("Systolic not in", values, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicBetween(Short value1, Short value2) {
            addCriterion("Systolic between", value1, value2, "systolic");
            return (Criteria) this;
        }
        public Criteria andSystolicNotBetween(Short value1, Short value2) {
            addCriterion("Systolic not between", value1, value2, "systolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicIsNull() {
            addCriterion("Diastolic is null");
            return (Criteria) this;
        }
        public Criteria andDiastolicIsNotNull() {
            addCriterion("Diastolic is not null");
            return (Criteria) this;
        }
        public Criteria andDiastolicEqualTo(Short value) {
            addCriterion("Diastolic =", value, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicNotEqualTo(Short value) {
            addCriterion("Diastolic <>", value, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicGreaterThan(Short value) {
            addCriterion("Diastolic >", value, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicGreaterThanOrEqualTo(Short value) {
            addCriterion("Diastolic >=", value, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicLessThan(Short value) {
            addCriterion("Diastolic <", value, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicLessThanOrEqualTo(Short value) {
            addCriterion("Diastolic <=", value, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicIn(List<Short> values) {
            addCriterion("Diastolic in", values, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicNotIn(List<Short> values) {
            addCriterion("Diastolic not in", values, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicBetween(Short value1, Short value2) {
            addCriterion("Diastolic between", value1, value2, "diastolic");
            return (Criteria) this;
        }
        public Criteria andDiastolicNotBetween(Short value1, Short value2) {
            addCriterion("Diastolic not between", value1, value2, "diastolic");
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
        public Criteria andWeight_NextIsNull() {
            addCriterion("Weight_Next is null");
            return (Criteria) this;
        }
        public Criteria andWeight_NextIsNotNull() {
            addCriterion("Weight_Next is not null");
            return (Criteria) this;
        }
        public Criteria andWeight_NextEqualTo(BigDecimal value) {
            addCriterion("Weight_Next =", value, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextNotEqualTo(BigDecimal value) {
            addCriterion("Weight_Next <>", value, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextGreaterThan(BigDecimal value) {
            addCriterion("Weight_Next >", value, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Weight_Next >=", value, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextLessThan(BigDecimal value) {
            addCriterion("Weight_Next <", value, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Weight_Next <=", value, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextIn(List<BigDecimal> values) {
            addCriterion("Weight_Next in", values, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextNotIn(List<BigDecimal> values) {
            addCriterion("Weight_Next not in", values, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Weight_Next between", value1, value2, "weight_Next");
            return (Criteria) this;
        }
        public Criteria andWeight_NextNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Weight_Next not between", value1, value2, "weight_Next");
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
        public Criteria andBMI_NextIsNull() {
            addCriterion("BMI_Next is null");
            return (Criteria) this;
        }
        public Criteria andBMI_NextIsNotNull() {
            addCriterion("BMI_Next is not null");
            return (Criteria) this;
        }
        public Criteria andBMI_NextEqualTo(BigDecimal value) {
            addCriterion("BMI_Next =", value, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextNotEqualTo(BigDecimal value) {
            addCriterion("BMI_Next <>", value, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextGreaterThan(BigDecimal value) {
            addCriterion("BMI_Next >", value, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BMI_Next >=", value, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextLessThan(BigDecimal value) {
            addCriterion("BMI_Next <", value, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BMI_Next <=", value, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextIn(List<BigDecimal> values) {
            addCriterion("BMI_Next in", values, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextNotIn(List<BigDecimal> values) {
            addCriterion("BMI_Next not in", values, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BMI_Next between", value1, value2, "BMI_Next");
            return (Criteria) this;
        }
        public Criteria andBMI_NextNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BMI_Next not between", value1, value2, "BMI_Next");
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
        public Criteria andOtherSignIsNull() {
            addCriterion("OtherSign is null");
            return (Criteria) this;
        }
        public Criteria andOtherSignIsNotNull() {
            addCriterion("OtherSign is not null");
            return (Criteria) this;
        }
        public Criteria andOtherSignEqualTo(String value) {
            addCriterion("OtherSign =", value, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignNotEqualTo(String value) {
            addCriterion("OtherSign <>", value, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignGreaterThan(String value) {
            addCriterion("OtherSign >", value, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignGreaterThanOrEqualTo(String value) {
            addCriterion("OtherSign >=", value, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignLessThan(String value) {
            addCriterion("OtherSign <", value, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignLessThanOrEqualTo(String value) {
            addCriterion("OtherSign <=", value, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignLike(String value) {
            addCriterion("OtherSign like", value, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignNotLike(String value) {
            addCriterion("OtherSign not like", value, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignIn(List<String> values) {
            addCriterion("OtherSign in", values, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignNotIn(List<String> values) {
            addCriterion("OtherSign not in", values, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignBetween(String value1, String value2) {
            addCriterion("OtherSign between", value1, value2, "otherSign");
            return (Criteria) this;
        }
        public Criteria andOtherSignNotBetween(String value1, String value2) {
            addCriterion("OtherSign not between", value1, value2, "otherSign");
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
        public Criteria andDailySmoking_NextIsNull() {
            addCriterion("DailySmoking_Next is null");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextIsNotNull() {
            addCriterion("DailySmoking_Next is not null");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextEqualTo(Short value) {
            addCriterion("DailySmoking_Next =", value, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextNotEqualTo(Short value) {
            addCriterion("DailySmoking_Next <>", value, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextGreaterThan(Short value) {
            addCriterion("DailySmoking_Next >", value, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextGreaterThanOrEqualTo(Short value) {
            addCriterion("DailySmoking_Next >=", value, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextLessThan(Short value) {
            addCriterion("DailySmoking_Next <", value, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextLessThanOrEqualTo(Short value) {
            addCriterion("DailySmoking_Next <=", value, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextIn(List<Short> values) {
            addCriterion("DailySmoking_Next in", values, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextNotIn(List<Short> values) {
            addCriterion("DailySmoking_Next not in", values, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextBetween(Short value1, Short value2) {
            addCriterion("DailySmoking_Next between", value1, value2, "dailySmoking_Next");
            return (Criteria) this;
        }
        public Criteria andDailySmoking_NextNotBetween(Short value1, Short value2) {
            addCriterion("DailySmoking_Next not between", value1, value2, "dailySmoking_Next");
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
        public Criteria andDailyDrink_NextIsNull() {
            addCriterion("DailyDrink_Next is null");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextIsNotNull() {
            addCriterion("DailyDrink_Next is not null");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextEqualTo(Short value) {
            addCriterion("DailyDrink_Next =", value, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextNotEqualTo(Short value) {
            addCriterion("DailyDrink_Next <>", value, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextGreaterThan(Short value) {
            addCriterion("DailyDrink_Next >", value, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextGreaterThanOrEqualTo(Short value) {
            addCriterion("DailyDrink_Next >=", value, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextLessThan(Short value) {
            addCriterion("DailyDrink_Next <", value, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextLessThanOrEqualTo(Short value) {
            addCriterion("DailyDrink_Next <=", value, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextIn(List<Short> values) {
            addCriterion("DailyDrink_Next in", values, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextNotIn(List<Short> values) {
            addCriterion("DailyDrink_Next not in", values, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextBetween(Short value1, Short value2) {
            addCriterion("DailyDrink_Next between", value1, value2, "dailyDrink_Next");
            return (Criteria) this;
        }
        public Criteria andDailyDrink_NextNotBetween(Short value1, Short value2) {
            addCriterion("DailyDrink_Next not between", value1, value2, "dailyDrink_Next");
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
        public Criteria andSportFrequencyEqualTo(String value) {
            addCriterion("SportFrequency =", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyNotEqualTo(String value) {
            addCriterion("SportFrequency <>", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyGreaterThan(String value) {
            addCriterion("SportFrequency >", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("SportFrequency >=", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyLessThan(String value) {
            addCriterion("SportFrequency <", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyLessThanOrEqualTo(String value) {
            addCriterion("SportFrequency <=", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyLike(String value) {
            addCriterion("SportFrequency like", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyNotLike(String value) {
            addCriterion("SportFrequency not like", value, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyIn(List<String> values) {
            addCriterion("SportFrequency in", values, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyNotIn(List<String> values) {
            addCriterion("SportFrequency not in", values, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyBetween(String value1, String value2) {
            addCriterion("SportFrequency between", value1, value2, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequencyNotBetween(String value1, String value2) {
            addCriterion("SportFrequency not between", value1, value2, "sportFrequency");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextIsNull() {
            addCriterion("SportFrequency_Next is null");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextIsNotNull() {
            addCriterion("SportFrequency_Next is not null");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextEqualTo(String value) {
            addCriterion("SportFrequency_Next =", value, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextNotEqualTo(String value) {
            addCriterion("SportFrequency_Next <>", value, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextGreaterThan(String value) {
            addCriterion("SportFrequency_Next >", value, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextGreaterThanOrEqualTo(String value) {
            addCriterion("SportFrequency_Next >=", value, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextLessThan(String value) {
            addCriterion("SportFrequency_Next <", value, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextLessThanOrEqualTo(String value) {
            addCriterion("SportFrequency_Next <=", value, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextLike(String value) {
            addCriterion("SportFrequency_Next like", value, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextNotLike(String value) {
            addCriterion("SportFrequency_Next not like", value, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextIn(List<String> values) {
            addCriterion("SportFrequency_Next in", values, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextNotIn(List<String> values) {
            addCriterion("SportFrequency_Next not in", values, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextBetween(String value1, String value2) {
            addCriterion("SportFrequency_Next between", value1, value2, "sportFrequency_Next");
            return (Criteria) this;
        }
        public Criteria andSportFrequency_NextNotBetween(String value1, String value2) {
            addCriterion("SportFrequency_Next not between", value1, value2, "sportFrequency_Next");
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
        public Criteria andSportDuration_NextIsNull() {
            addCriterion("SportDuration_Next is null");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextIsNotNull() {
            addCriterion("SportDuration_Next is not null");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextEqualTo(Short value) {
            addCriterion("SportDuration_Next =", value, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextNotEqualTo(Short value) {
            addCriterion("SportDuration_Next <>", value, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextGreaterThan(Short value) {
            addCriterion("SportDuration_Next >", value, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextGreaterThanOrEqualTo(Short value) {
            addCriterion("SportDuration_Next >=", value, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextLessThan(Short value) {
            addCriterion("SportDuration_Next <", value, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextLessThanOrEqualTo(Short value) {
            addCriterion("SportDuration_Next <=", value, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextIn(List<Short> values) {
            addCriterion("SportDuration_Next in", values, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextNotIn(List<Short> values) {
            addCriterion("SportDuration_Next not in", values, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextBetween(Short value1, Short value2) {
            addCriterion("SportDuration_Next between", value1, value2, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andSportDuration_NextNotBetween(Short value1, Short value2) {
            addCriterion("SportDuration_Next not between", value1, value2, "sportDuration_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltIsNull() {
            addCriterion("IntakeSalt is null");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltIsNotNull() {
            addCriterion("IntakeSalt is not null");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltEqualTo(Byte value) {
            addCriterion("IntakeSalt =", value, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltNotEqualTo(Byte value) {
            addCriterion("IntakeSalt <>", value, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltGreaterThan(Byte value) {
            addCriterion("IntakeSalt >", value, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltGreaterThanOrEqualTo(Byte value) {
            addCriterion("IntakeSalt >=", value, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltLessThan(Byte value) {
            addCriterion("IntakeSalt <", value, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltLessThanOrEqualTo(Byte value) {
            addCriterion("IntakeSalt <=", value, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltIn(List<Byte> values) {
            addCriterion("IntakeSalt in", values, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltNotIn(List<Byte> values) {
            addCriterion("IntakeSalt not in", values, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltBetween(Byte value1, Byte value2) {
            addCriterion("IntakeSalt between", value1, value2, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSaltNotBetween(Byte value1, Byte value2) {
            addCriterion("IntakeSalt not between", value1, value2, "intakeSalt");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextIsNull() {
            addCriterion("IntakeSalt_Next is null");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextIsNotNull() {
            addCriterion("IntakeSalt_Next is not null");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextEqualTo(Byte value) {
            addCriterion("IntakeSalt_Next =", value, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextNotEqualTo(Byte value) {
            addCriterion("IntakeSalt_Next <>", value, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextGreaterThan(Byte value) {
            addCriterion("IntakeSalt_Next >", value, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextGreaterThanOrEqualTo(Byte value) {
            addCriterion("IntakeSalt_Next >=", value, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextLessThan(Byte value) {
            addCriterion("IntakeSalt_Next <", value, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextLessThanOrEqualTo(Byte value) {
            addCriterion("IntakeSalt_Next <=", value, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextIn(List<Byte> values) {
            addCriterion("IntakeSalt_Next in", values, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextNotIn(List<Byte> values) {
            addCriterion("IntakeSalt_Next not in", values, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextBetween(Byte value1, Byte value2) {
            addCriterion("IntakeSalt_Next between", value1, value2, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andIntakeSalt_NextNotBetween(Byte value1, Byte value2) {
            addCriterion("IntakeSalt_Next not between", value1, value2, "intakeSalt_Next");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryIsNull() {
            addCriterion("PsychologicalRecovery is null");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryIsNotNull() {
            addCriterion("PsychologicalRecovery is not null");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryEqualTo(Byte value) {
            addCriterion("PsychologicalRecovery =", value, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryNotEqualTo(Byte value) {
            addCriterion("PsychologicalRecovery <>", value, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryGreaterThan(Byte value) {
            addCriterion("PsychologicalRecovery >", value, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryGreaterThanOrEqualTo(Byte value) {
            addCriterion("PsychologicalRecovery >=", value, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryLessThan(Byte value) {
            addCriterion("PsychologicalRecovery <", value, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryLessThanOrEqualTo(Byte value) {
            addCriterion("PsychologicalRecovery <=", value, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryIn(List<Byte> values) {
            addCriterion("PsychologicalRecovery in", values, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryNotIn(List<Byte> values) {
            addCriterion("PsychologicalRecovery not in", values, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryBetween(Byte value1, Byte value2) {
            addCriterion("PsychologicalRecovery between", value1, value2, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andPsychologicalRecoveryNotBetween(Byte value1, Byte value2) {
            addCriterion("PsychologicalRecovery not between", value1, value2, "psychologicalRecovery");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorIsNull() {
            addCriterion("ComplianceBehavior is null");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorIsNotNull() {
            addCriterion("ComplianceBehavior is not null");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorEqualTo(Byte value) {
            addCriterion("ComplianceBehavior =", value, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorNotEqualTo(Byte value) {
            addCriterion("ComplianceBehavior <>", value, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorGreaterThan(Byte value) {
            addCriterion("ComplianceBehavior >", value, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorGreaterThanOrEqualTo(Byte value) {
            addCriterion("ComplianceBehavior >=", value, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorLessThan(Byte value) {
            addCriterion("ComplianceBehavior <", value, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorLessThanOrEqualTo(Byte value) {
            addCriterion("ComplianceBehavior <=", value, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorIn(List<Byte> values) {
            addCriterion("ComplianceBehavior in", values, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorNotIn(List<Byte> values) {
            addCriterion("ComplianceBehavior not in", values, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorBetween(Byte value1, Byte value2) {
            addCriterion("ComplianceBehavior between", value1, value2, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andComplianceBehaviorNotBetween(Byte value1, Byte value2) {
            addCriterion("ComplianceBehavior not between", value1, value2, "complianceBehavior");
            return (Criteria) this;
        }
        public Criteria andCheckResultIsNull() {
            addCriterion("CheckResult is null");
            return (Criteria) this;
        }
        public Criteria andCheckResultIsNotNull() {
            addCriterion("CheckResult is not null");
            return (Criteria) this;
        }
        public Criteria andCheckResultEqualTo(String value) {
            addCriterion("CheckResult =", value, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultNotEqualTo(String value) {
            addCriterion("CheckResult <>", value, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultGreaterThan(String value) {
            addCriterion("CheckResult >", value, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("CheckResult >=", value, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultLessThan(String value) {
            addCriterion("CheckResult <", value, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultLessThanOrEqualTo(String value) {
            addCriterion("CheckResult <=", value, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultLike(String value) {
            addCriterion("CheckResult like", value, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultNotLike(String value) {
            addCriterion("CheckResult not like", value, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultIn(List<String> values) {
            addCriterion("CheckResult in", values, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultNotIn(List<String> values) {
            addCriterion("CheckResult not in", values, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultBetween(String value1, String value2) {
            addCriterion("CheckResult between", value1, value2, "checkResult");
            return (Criteria) this;
        }
        public Criteria andCheckResultNotBetween(String value1, String value2) {
            addCriterion("CheckResult not between", value1, value2, "checkResult");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceIsNull() {
            addCriterion("DrugCompliance is null");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceIsNotNull() {
            addCriterion("DrugCompliance is not null");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceEqualTo(Byte value) {
            addCriterion("DrugCompliance =", value, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceNotEqualTo(Byte value) {
            addCriterion("DrugCompliance <>", value, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceGreaterThan(Byte value) {
            addCriterion("DrugCompliance >", value, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceGreaterThanOrEqualTo(Byte value) {
            addCriterion("DrugCompliance >=", value, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceLessThan(Byte value) {
            addCriterion("DrugCompliance <", value, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceLessThanOrEqualTo(Byte value) {
            addCriterion("DrugCompliance <=", value, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceIn(List<Byte> values) {
            addCriterion("DrugCompliance in", values, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceNotIn(List<Byte> values) {
            addCriterion("DrugCompliance not in", values, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceBetween(Byte value1, Byte value2) {
            addCriterion("DrugCompliance between", value1, value2, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugComplianceNotBetween(Byte value1, Byte value2) {
            addCriterion("DrugCompliance not between", value1, value2, "drugCompliance");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionIsNull() {
            addCriterion("DrugAdverseReaction is null");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionIsNotNull() {
            addCriterion("DrugAdverseReaction is not null");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionEqualTo(Byte value) {
            addCriterion("DrugAdverseReaction =", value, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionNotEqualTo(Byte value) {
            addCriterion("DrugAdverseReaction <>", value, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionGreaterThan(Byte value) {
            addCriterion("DrugAdverseReaction >", value, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionGreaterThanOrEqualTo(Byte value) {
            addCriterion("DrugAdverseReaction >=", value, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionLessThan(Byte value) {
            addCriterion("DrugAdverseReaction <", value, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionLessThanOrEqualTo(Byte value) {
            addCriterion("DrugAdverseReaction <=", value, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionIn(List<Byte> values) {
            addCriterion("DrugAdverseReaction in", values, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionNotIn(List<Byte> values) {
            addCriterion("DrugAdverseReaction not in", values, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionBetween(Byte value1, Byte value2) {
            addCriterion("DrugAdverseReaction between", value1, value2, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReactionNotBetween(Byte value1, Byte value2) {
            addCriterion("DrugAdverseReaction not between", value1, value2, "drugAdverseReaction");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescIsNull() {
            addCriterion("DrugAdverseReaction_Desc is null");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescIsNotNull() {
            addCriterion("DrugAdverseReaction_Desc is not null");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescEqualTo(String value) {
            addCriterion("DrugAdverseReaction_Desc =", value, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescNotEqualTo(String value) {
            addCriterion("DrugAdverseReaction_Desc <>", value, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescGreaterThan(String value) {
            addCriterion("DrugAdverseReaction_Desc >", value, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescGreaterThanOrEqualTo(String value) {
            addCriterion("DrugAdverseReaction_Desc >=", value, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescLessThan(String value) {
            addCriterion("DrugAdverseReaction_Desc <", value, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescLessThanOrEqualTo(String value) {
            addCriterion("DrugAdverseReaction_Desc <=", value, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescLike(String value) {
            addCriterion("DrugAdverseReaction_Desc like", value, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescNotLike(String value) {
            addCriterion("DrugAdverseReaction_Desc not like", value, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescIn(List<String> values) {
            addCriterion("DrugAdverseReaction_Desc in", values, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescNotIn(List<String> values) {
            addCriterion("DrugAdverseReaction_Desc not in", values, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescBetween(String value1, String value2) {
            addCriterion("DrugAdverseReaction_Desc between", value1, value2, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andDrugAdverseReaction_DescNotBetween(String value1, String value2) {
            addCriterion("DrugAdverseReaction_Desc not between", value1, value2, "drugAdverseReaction_Desc");
            return (Criteria) this;
        }
        public Criteria andTransferReasonIsNull() {
            addCriterion("TransferReason is null");
            return (Criteria) this;
        }
        public Criteria andTransferReasonIsNotNull() {
            addCriterion("TransferReason is not null");
            return (Criteria) this;
        }
        public Criteria andTransferReasonEqualTo(String value) {
            addCriterion("TransferReason =", value, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonNotEqualTo(String value) {
            addCriterion("TransferReason <>", value, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonGreaterThan(String value) {
            addCriterion("TransferReason >", value, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonGreaterThanOrEqualTo(String value) {
            addCriterion("TransferReason >=", value, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonLessThan(String value) {
            addCriterion("TransferReason <", value, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonLessThanOrEqualTo(String value) {
            addCriterion("TransferReason <=", value, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonLike(String value) {
            addCriterion("TransferReason like", value, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonNotLike(String value) {
            addCriterion("TransferReason not like", value, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonIn(List<String> values) {
            addCriterion("TransferReason in", values, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonNotIn(List<String> values) {
            addCriterion("TransferReason not in", values, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonBetween(String value1, String value2) {
            addCriterion("TransferReason between", value1, value2, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferReasonNotBetween(String value1, String value2) {
            addCriterion("TransferReason not between", value1, value2, "transferReason");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptIsNull() {
            addCriterion("TransferOrgAndDept is null");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptIsNotNull() {
            addCriterion("TransferOrgAndDept is not null");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptEqualTo(String value) {
            addCriterion("TransferOrgAndDept =", value, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptNotEqualTo(String value) {
            addCriterion("TransferOrgAndDept <>", value, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptGreaterThan(String value) {
            addCriterion("TransferOrgAndDept >", value, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptGreaterThanOrEqualTo(String value) {
            addCriterion("TransferOrgAndDept >=", value, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptLessThan(String value) {
            addCriterion("TransferOrgAndDept <", value, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptLessThanOrEqualTo(String value) {
            addCriterion("TransferOrgAndDept <=", value, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptLike(String value) {
            addCriterion("TransferOrgAndDept like", value, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptNotLike(String value) {
            addCriterion("TransferOrgAndDept not like", value, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptIn(List<String> values) {
            addCriterion("TransferOrgAndDept in", values, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptNotIn(List<String> values) {
            addCriterion("TransferOrgAndDept not in", values, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptBetween(String value1, String value2) {
            addCriterion("TransferOrgAndDept between", value1, value2, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andTransferOrgAndDeptNotBetween(String value1, String value2) {
            addCriterion("TransferOrgAndDept not between", value1, value2, "transferOrgAndDept");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextIsNull() {
            addCriterion("VisitDate_Next is null");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextIsNotNull() {
            addCriterion("VisitDate_Next is not null");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextEqualTo(Date value) {
            addCriterion("VisitDate_Next =", value, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextNotEqualTo(Date value) {
            addCriterion("VisitDate_Next <>", value, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextGreaterThan(Date value) {
            addCriterion("VisitDate_Next >", value, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextGreaterThanOrEqualTo(Date value) {
            addCriterion("VisitDate_Next >=", value, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextLessThan(Date value) {
            addCriterion("VisitDate_Next <", value, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextLessThanOrEqualTo(Date value) {
            addCriterion("VisitDate_Next <=", value, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextIn(List<Date> values) {
            addCriterion("VisitDate_Next in", values, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextNotIn(List<Date> values) {
            addCriterion("VisitDate_Next not in", values, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextBetween(Date value1, Date value2) {
            addCriterion("VisitDate_Next between", value1, value2, "visitDate_Next");
            return (Criteria) this;
        }
        public Criteria andVisitDate_NextNotBetween(Date value1, Date value2) {
            addCriterion("VisitDate_Next not between", value1, value2, "visitDate_Next");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 公共卫生_高血压随访明细表
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