/*
 * PhysicalExaminationExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PhysicalExaminationExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public PhysicalExaminationExample() {
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
     * 体格检查(MEM2)
     * 
     * @author ${user}
     * @version 1.0 2016-06-23
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
        public Criteria andBloodtypeIsNull() {
            addCriterion("BloodType is null");
            return (Criteria) this;
        }
        public Criteria andBloodtypeIsNotNull() {
            addCriterion("BloodType is not null");
            return (Criteria) this;
        }
        public Criteria andBloodtypeEqualTo(String value) {
            addCriterion("BloodType =", value, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeNotEqualTo(String value) {
            addCriterion("BloodType <>", value, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeGreaterThan(String value) {
            addCriterion("BloodType >", value, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeGreaterThanOrEqualTo(String value) {
            addCriterion("BloodType >=", value, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeLessThan(String value) {
            addCriterion("BloodType <", value, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeLessThanOrEqualTo(String value) {
            addCriterion("BloodType <=", value, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeLike(String value) {
            addCriterion("BloodType like", value, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeNotLike(String value) {
            addCriterion("BloodType not like", value, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeIn(List<String> values) {
            addCriterion("BloodType in", values, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeNotIn(List<String> values) {
            addCriterion("BloodType not in", values, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeBetween(String value1, String value2) {
            addCriterion("BloodType between", value1, value2, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andBloodtypeNotBetween(String value1, String value2) {
            addCriterion("BloodType not between", value1, value2, "bloodtype");
            return (Criteria) this;
        }
        public Criteria andAllergichisIsNull() {
            addCriterion("AllergicHis is null");
            return (Criteria) this;
        }
        public Criteria andAllergichisIsNotNull() {
            addCriterion("AllergicHis is not null");
            return (Criteria) this;
        }
        public Criteria andAllergichisEqualTo(String value) {
            addCriterion("AllergicHis =", value, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisNotEqualTo(String value) {
            addCriterion("AllergicHis <>", value, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisGreaterThan(String value) {
            addCriterion("AllergicHis >", value, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisGreaterThanOrEqualTo(String value) {
            addCriterion("AllergicHis >=", value, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisLessThan(String value) {
            addCriterion("AllergicHis <", value, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisLessThanOrEqualTo(String value) {
            addCriterion("AllergicHis <=", value, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisLike(String value) {
            addCriterion("AllergicHis like", value, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisNotLike(String value) {
            addCriterion("AllergicHis not like", value, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisIn(List<String> values) {
            addCriterion("AllergicHis in", values, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisNotIn(List<String> values) {
            addCriterion("AllergicHis not in", values, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisBetween(String value1, String value2) {
            addCriterion("AllergicHis between", value1, value2, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisNotBetween(String value1, String value2) {
            addCriterion("AllergicHis not between", value1, value2, "allergichis");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameIsNull() {
            addCriterion("AllergicHisName is null");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameIsNotNull() {
            addCriterion("AllergicHisName is not null");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameEqualTo(String value) {
            addCriterion("AllergicHisName =", value, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameNotEqualTo(String value) {
            addCriterion("AllergicHisName <>", value, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameGreaterThan(String value) {
            addCriterion("AllergicHisName >", value, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameGreaterThanOrEqualTo(String value) {
            addCriterion("AllergicHisName >=", value, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameLessThan(String value) {
            addCriterion("AllergicHisName <", value, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameLessThanOrEqualTo(String value) {
            addCriterion("AllergicHisName <=", value, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameLike(String value) {
            addCriterion("AllergicHisName like", value, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameNotLike(String value) {
            addCriterion("AllergicHisName not like", value, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameIn(List<String> values) {
            addCriterion("AllergicHisName in", values, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameNotIn(List<String> values) {
            addCriterion("AllergicHisName not in", values, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameBetween(String value1, String value2) {
            addCriterion("AllergicHisName between", value1, value2, "allergichisname");
            return (Criteria) this;
        }
        public Criteria andAllergichisnameNotBetween(String value1, String value2) {
            addCriterion("AllergicHisName not between", value1, value2, "allergichisname");
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
        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("Height =", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("Height <>", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("Height >", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("Height >=", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightLessThan(Integer value) {
            addCriterion("Height <", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("Height <=", value, "height");
            return (Criteria) this;
        }
        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("Height in", values, "height");
            return (Criteria) this;
        }
        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("Height not in", values, "height");
            return (Criteria) this;
        }
        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("Height between", value1, value2, "height");
            return (Criteria) this;
        }
        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
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
        public Criteria andWaistEqualTo(Integer value) {
            addCriterion("Waist =", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistNotEqualTo(Integer value) {
            addCriterion("Waist <>", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistGreaterThan(Integer value) {
            addCriterion("Waist >", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistGreaterThanOrEqualTo(Integer value) {
            addCriterion("Waist >=", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistLessThan(Integer value) {
            addCriterion("Waist <", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistLessThanOrEqualTo(Integer value) {
            addCriterion("Waist <=", value, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistIn(List<Integer> values) {
            addCriterion("Waist in", values, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistNotIn(List<Integer> values) {
            addCriterion("Waist not in", values, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistBetween(Integer value1, Integer value2) {
            addCriterion("Waist between", value1, value2, "waist");
            return (Criteria) this;
        }
        public Criteria andWaistNotBetween(Integer value1, Integer value2) {
            addCriterion("Waist not between", value1, value2, "waist");
            return (Criteria) this;
        }
        public Criteria andHipIsNull() {
            addCriterion("Hip is null");
            return (Criteria) this;
        }
        public Criteria andHipIsNotNull() {
            addCriterion("Hip is not null");
            return (Criteria) this;
        }
        public Criteria andHipEqualTo(Integer value) {
            addCriterion("Hip =", value, "hip");
            return (Criteria) this;
        }
        public Criteria andHipNotEqualTo(Integer value) {
            addCriterion("Hip <>", value, "hip");
            return (Criteria) this;
        }
        public Criteria andHipGreaterThan(Integer value) {
            addCriterion("Hip >", value, "hip");
            return (Criteria) this;
        }
        public Criteria andHipGreaterThanOrEqualTo(Integer value) {
            addCriterion("Hip >=", value, "hip");
            return (Criteria) this;
        }
        public Criteria andHipLessThan(Integer value) {
            addCriterion("Hip <", value, "hip");
            return (Criteria) this;
        }
        public Criteria andHipLessThanOrEqualTo(Integer value) {
            addCriterion("Hip <=", value, "hip");
            return (Criteria) this;
        }
        public Criteria andHipIn(List<Integer> values) {
            addCriterion("Hip in", values, "hip");
            return (Criteria) this;
        }
        public Criteria andHipNotIn(List<Integer> values) {
            addCriterion("Hip not in", values, "hip");
            return (Criteria) this;
        }
        public Criteria andHipBetween(Integer value1, Integer value2) {
            addCriterion("Hip between", value1, value2, "hip");
            return (Criteria) this;
        }
        public Criteria andHipNotBetween(Integer value1, Integer value2) {
            addCriterion("Hip not between", value1, value2, "hip");
            return (Criteria) this;
        }
        public Criteria andPulseIsNull() {
            addCriterion("Pulse is null");
            return (Criteria) this;
        }
        public Criteria andPulseIsNotNull() {
            addCriterion("Pulse is not null");
            return (Criteria) this;
        }
        public Criteria andPulseEqualTo(Integer value) {
            addCriterion("Pulse =", value, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseNotEqualTo(Integer value) {
            addCriterion("Pulse <>", value, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseGreaterThan(Integer value) {
            addCriterion("Pulse >", value, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseGreaterThanOrEqualTo(Integer value) {
            addCriterion("Pulse >=", value, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseLessThan(Integer value) {
            addCriterion("Pulse <", value, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseLessThanOrEqualTo(Integer value) {
            addCriterion("Pulse <=", value, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseIn(List<Integer> values) {
            addCriterion("Pulse in", values, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseNotIn(List<Integer> values) {
            addCriterion("Pulse not in", values, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseBetween(Integer value1, Integer value2) {
            addCriterion("Pulse between", value1, value2, "pulse");
            return (Criteria) this;
        }
        public Criteria andPulseNotBetween(Integer value1, Integer value2) {
            addCriterion("Pulse not between", value1, value2, "pulse");
            return (Criteria) this;
        }
        public Criteria andHeartrateIsNull() {
            addCriterion("HeartRate is null");
            return (Criteria) this;
        }
        public Criteria andHeartrateIsNotNull() {
            addCriterion("HeartRate is not null");
            return (Criteria) this;
        }
        public Criteria andHeartrateEqualTo(Integer value) {
            addCriterion("HeartRate =", value, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateNotEqualTo(Integer value) {
            addCriterion("HeartRate <>", value, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateGreaterThan(Integer value) {
            addCriterion("HeartRate >", value, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("HeartRate >=", value, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateLessThan(Integer value) {
            addCriterion("HeartRate <", value, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateLessThanOrEqualTo(Integer value) {
            addCriterion("HeartRate <=", value, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateIn(List<Integer> values) {
            addCriterion("HeartRate in", values, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateNotIn(List<Integer> values) {
            addCriterion("HeartRate not in", values, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateBetween(Integer value1, Integer value2) {
            addCriterion("HeartRate between", value1, value2, "heartrate");
            return (Criteria) this;
        }
        public Criteria andHeartrateNotBetween(Integer value1, Integer value2) {
            addCriterion("HeartRate not between", value1, value2, "heartrate");
            return (Criteria) this;
        }
        public Criteria andBloodhIsNull() {
            addCriterion("BloodH is null");
            return (Criteria) this;
        }
        public Criteria andBloodhIsNotNull() {
            addCriterion("BloodH is not null");
            return (Criteria) this;
        }
        public Criteria andBloodhEqualTo(Short value) {
            addCriterion("BloodH =", value, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhNotEqualTo(Short value) {
            addCriterion("BloodH <>", value, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhGreaterThan(Short value) {
            addCriterion("BloodH >", value, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhGreaterThanOrEqualTo(Short value) {
            addCriterion("BloodH >=", value, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhLessThan(Short value) {
            addCriterion("BloodH <", value, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhLessThanOrEqualTo(Short value) {
            addCriterion("BloodH <=", value, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhIn(List<Short> values) {
            addCriterion("BloodH in", values, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhNotIn(List<Short> values) {
            addCriterion("BloodH not in", values, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhBetween(Short value1, Short value2) {
            addCriterion("BloodH between", value1, value2, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodhNotBetween(Short value1, Short value2) {
            addCriterion("BloodH not between", value1, value2, "bloodh");
            return (Criteria) this;
        }
        public Criteria andBloodlIsNull() {
            addCriterion("BloodL is null");
            return (Criteria) this;
        }
        public Criteria andBloodlIsNotNull() {
            addCriterion("BloodL is not null");
            return (Criteria) this;
        }
        public Criteria andBloodlEqualTo(Short value) {
            addCriterion("BloodL =", value, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlNotEqualTo(Short value) {
            addCriterion("BloodL <>", value, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlGreaterThan(Short value) {
            addCriterion("BloodL >", value, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlGreaterThanOrEqualTo(Short value) {
            addCriterion("BloodL >=", value, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlLessThan(Short value) {
            addCriterion("BloodL <", value, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlLessThanOrEqualTo(Short value) {
            addCriterion("BloodL <=", value, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlIn(List<Short> values) {
            addCriterion("BloodL in", values, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlNotIn(List<Short> values) {
            addCriterion("BloodL not in", values, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlBetween(Short value1, Short value2) {
            addCriterion("BloodL between", value1, value2, "bloodl");
            return (Criteria) this;
        }
        public Criteria andBloodlNotBetween(Short value1, Short value2) {
            addCriterion("BloodL not between", value1, value2, "bloodl");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseIsNull() {
            addCriterion("FastingGlucose is null");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseIsNotNull() {
            addCriterion("FastingGlucose is not null");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseEqualTo(BigDecimal value) {
            addCriterion("FastingGlucose =", value, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseNotEqualTo(BigDecimal value) {
            addCriterion("FastingGlucose <>", value, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseGreaterThan(BigDecimal value) {
            addCriterion("FastingGlucose >", value, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FastingGlucose >=", value, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseLessThan(BigDecimal value) {
            addCriterion("FastingGlucose <", value, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FastingGlucose <=", value, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseIn(List<BigDecimal> values) {
            addCriterion("FastingGlucose in", values, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseNotIn(List<BigDecimal> values) {
            addCriterion("FastingGlucose not in", values, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FastingGlucose between", value1, value2, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andFastingglucoseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FastingGlucose not between", value1, value2, "fastingglucose");
            return (Criteria) this;
        }
        public Criteria andUricacidIsNull() {
            addCriterion("UricAcid is null");
            return (Criteria) this;
        }
        public Criteria andUricacidIsNotNull() {
            addCriterion("UricAcid is not null");
            return (Criteria) this;
        }
        public Criteria andUricacidEqualTo(Integer value) {
            addCriterion("UricAcid =", value, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidNotEqualTo(Integer value) {
            addCriterion("UricAcid <>", value, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidGreaterThan(Integer value) {
            addCriterion("UricAcid >", value, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UricAcid >=", value, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidLessThan(Integer value) {
            addCriterion("UricAcid <", value, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidLessThanOrEqualTo(Integer value) {
            addCriterion("UricAcid <=", value, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidIn(List<Integer> values) {
            addCriterion("UricAcid in", values, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidNotIn(List<Integer> values) {
            addCriterion("UricAcid not in", values, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidBetween(Integer value1, Integer value2) {
            addCriterion("UricAcid between", value1, value2, "uricacid");
            return (Criteria) this;
        }
        public Criteria andUricacidNotBetween(Integer value1, Integer value2) {
            addCriterion("UricAcid not between", value1, value2, "uricacid");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolIsNull() {
            addCriterion("TotalCholesterol is null");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolIsNotNull() {
            addCriterion("TotalCholesterol is not null");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolEqualTo(BigDecimal value) {
            addCriterion("TotalCholesterol =", value, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolNotEqualTo(BigDecimal value) {
            addCriterion("TotalCholesterol <>", value, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolGreaterThan(BigDecimal value) {
            addCriterion("TotalCholesterol >", value, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TotalCholesterol >=", value, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolLessThan(BigDecimal value) {
            addCriterion("TotalCholesterol <", value, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TotalCholesterol <=", value, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolIn(List<BigDecimal> values) {
            addCriterion("TotalCholesterol in", values, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolNotIn(List<BigDecimal> values) {
            addCriterion("TotalCholesterol not in", values, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TotalCholesterol between", value1, value2, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTotalcholesterolNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TotalCholesterol not between", value1, value2, "totalcholesterol");
            return (Criteria) this;
        }
        public Criteria andTriglycerideIsNull() {
            addCriterion("Triglyceride is null");
            return (Criteria) this;
        }
        public Criteria andTriglycerideIsNotNull() {
            addCriterion("Triglyceride is not null");
            return (Criteria) this;
        }
        public Criteria andTriglycerideEqualTo(BigDecimal value) {
            addCriterion("Triglyceride =", value, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideNotEqualTo(BigDecimal value) {
            addCriterion("Triglyceride <>", value, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideGreaterThan(BigDecimal value) {
            addCriterion("Triglyceride >", value, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Triglyceride >=", value, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideLessThan(BigDecimal value) {
            addCriterion("Triglyceride <", value, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Triglyceride <=", value, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideIn(List<BigDecimal> values) {
            addCriterion("Triglyceride in", values, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideNotIn(List<BigDecimal> values) {
            addCriterion("Triglyceride not in", values, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Triglyceride between", value1, value2, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andTriglycerideNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Triglyceride not between", value1, value2, "triglyceride");
            return (Criteria) this;
        }
        public Criteria andDensitylipopIsNull() {
            addCriterion("DensityLipop is null");
            return (Criteria) this;
        }
        public Criteria andDensitylipopIsNotNull() {
            addCriterion("DensityLipop is not null");
            return (Criteria) this;
        }
        public Criteria andDensitylipopEqualTo(BigDecimal value) {
            addCriterion("DensityLipop =", value, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopNotEqualTo(BigDecimal value) {
            addCriterion("DensityLipop <>", value, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopGreaterThan(BigDecimal value) {
            addCriterion("DensityLipop >", value, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DensityLipop >=", value, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopLessThan(BigDecimal value) {
            addCriterion("DensityLipop <", value, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DensityLipop <=", value, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopIn(List<BigDecimal> values) {
            addCriterion("DensityLipop in", values, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopNotIn(List<BigDecimal> values) {
            addCriterion("DensityLipop not in", values, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DensityLipop between", value1, value2, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andDensitylipopNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DensityLipop not between", value1, value2, "densitylipop");
            return (Criteria) this;
        }
        public Criteria andLdlipIsNull() {
            addCriterion("LDLip is null");
            return (Criteria) this;
        }
        public Criteria andLdlipIsNotNull() {
            addCriterion("LDLip is not null");
            return (Criteria) this;
        }
        public Criteria andLdlipEqualTo(BigDecimal value) {
            addCriterion("LDLip =", value, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipNotEqualTo(BigDecimal value) {
            addCriterion("LDLip <>", value, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipGreaterThan(BigDecimal value) {
            addCriterion("LDLip >", value, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LDLip >=", value, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipLessThan(BigDecimal value) {
            addCriterion("LDLip <", value, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LDLip <=", value, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipIn(List<BigDecimal> values) {
            addCriterion("LDLip in", values, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipNotIn(List<BigDecimal> values) {
            addCriterion("LDLip not in", values, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LDLip between", value1, value2, "ldlip");
            return (Criteria) this;
        }
        public Criteria andLdlipNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LDLip not between", value1, value2, "ldlip");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 体格检查(MEM2)
     * 
     * @author ${user}
     * @version 1.0 2016-06-23
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