/*
 * ManageschemeTempletExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.templet.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bithealth.healthCore.enmu.TempletStatusEnum;

public class ManageschemeTempletExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ManageschemeTempletExample() {
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
     * [3.0]管理方案_模板
     * 
     * @author ${user}
     * @version 1.0 2016-11-29
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
        public Criteria andMSTempletIDIsNull() {
            addCriterion("MSTempletID is null");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDIsNotNull() {
            addCriterion("MSTempletID is not null");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDEqualTo(Integer value) {
            addCriterion("MSTempletID =", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDNotEqualTo(Integer value) {
            addCriterion("MSTempletID <>", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDGreaterThan(Integer value) {
            addCriterion("MSTempletID >", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSTempletID >=", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDLessThan(Integer value) {
            addCriterion("MSTempletID <", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDLessThanOrEqualTo(Integer value) {
            addCriterion("MSTempletID <=", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDIn(List<Integer> values) {
            addCriterion("MSTempletID in", values, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDNotIn(List<Integer> values) {
            addCriterion("MSTempletID not in", values, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDBetween(Integer value1, Integer value2) {
            addCriterion("MSTempletID between", value1, value2, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MSTempletID not between", value1, value2, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleIsNull() {
            addCriterion("SchemeTitle is null");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleIsNotNull() {
            addCriterion("SchemeTitle is not null");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleEqualTo(String value) {
            addCriterion("SchemeTitle =", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleNotEqualTo(String value) {
            addCriterion("SchemeTitle <>", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleGreaterThan(String value) {
            addCriterion("SchemeTitle >", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("SchemeTitle >=", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleLessThan(String value) {
            addCriterion("SchemeTitle <", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleLessThanOrEqualTo(String value) {
            addCriterion("SchemeTitle <=", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("SchemeTitle like", "%" + value + "%", "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleNotLike(String value) {
            addCriterion("SchemeTitle not like", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleIn(List<String> values) {
            addCriterion("SchemeTitle in", values, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleNotIn(List<String> values) {
            addCriterion("SchemeTitle not in", values, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleBetween(String value1, String value2) {
            addCriterion("SchemeTitle between", value1, value2, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleNotBetween(String value1, String value2) {
            addCriterion("SchemeTitle not between", value1, value2, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andManageGoalIsNull() {
            addCriterion("ManageGoal is null");
            return (Criteria) this;
        }
        public Criteria andManageGoalIsNotNull() {
            addCriterion("ManageGoal is not null");
            return (Criteria) this;
        }
        public Criteria andManageGoalEqualTo(String value) {
            addCriterion("ManageGoal =", value, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalNotEqualTo(String value) {
            addCriterion("ManageGoal <>", value, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalGreaterThan(String value) {
            addCriterion("ManageGoal >", value, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalGreaterThanOrEqualTo(String value) {
            addCriterion("ManageGoal >=", value, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalLessThan(String value) {
            addCriterion("ManageGoal <", value, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalLessThanOrEqualTo(String value) {
            addCriterion("ManageGoal <=", value, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalLike(String value) {
            addCriterion("ManageGoal like", value, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalNotLike(String value) {
            addCriterion("ManageGoal not like", value, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalIn(List<String> values) {
            addCriterion("ManageGoal in", values, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalNotIn(List<String> values) {
            addCriterion("ManageGoal not in", values, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalBetween(String value1, String value2) {
            addCriterion("ManageGoal between", value1, value2, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andManageGoalNotBetween(String value1, String value2) {
            addCriterion("ManageGoal not between", value1, value2, "manageGoal");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeIsNull() {
            addCriterion("BenchmarkTime is null");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeIsNotNull() {
            addCriterion("BenchmarkTime is not null");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeEqualTo(Byte value) {
            addCriterion("BenchmarkTime =", value, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeNotEqualTo(Byte value) {
            addCriterion("BenchmarkTime <>", value, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeGreaterThan(Byte value) {
            addCriterion("BenchmarkTime >", value, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeGreaterThanOrEqualTo(Byte value) {
            addCriterion("BenchmarkTime >=", value, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeLessThan(Byte value) {
            addCriterion("BenchmarkTime <", value, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeLessThanOrEqualTo(Byte value) {
            addCriterion("BenchmarkTime <=", value, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeIn(List<Byte> values) {
            addCriterion("BenchmarkTime in", values, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeNotIn(List<Byte> values) {
            addCriterion("BenchmarkTime not in", values, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeBetween(Byte value1, Byte value2) {
            addCriterion("BenchmarkTime between", value1, value2, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andBenchmarkTimeNotBetween(Byte value1, Byte value2) {
            addCriterion("BenchmarkTime not between", value1, value2, "benchmarkTime");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueIsNull() {
            addCriterion("SrvLimitValue is null");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueIsNotNull() {
            addCriterion("SrvLimitValue is not null");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueEqualTo(Byte value) {
            addCriterion("SrvLimitValue =", value, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueNotEqualTo(Byte value) {
            addCriterion("SrvLimitValue <>", value, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueGreaterThan(Byte value) {
            addCriterion("SrvLimitValue >", value, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueGreaterThanOrEqualTo(Byte value) {
            addCriterion("SrvLimitValue >=", value, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueLessThan(Byte value) {
            addCriterion("SrvLimitValue <", value, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueLessThanOrEqualTo(Byte value) {
            addCriterion("SrvLimitValue <=", value, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueIn(List<Byte> values) {
            addCriterion("SrvLimitValue in", values, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueNotIn(List<Byte> values) {
            addCriterion("SrvLimitValue not in", values, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueBetween(Byte value1, Byte value2) {
            addCriterion("SrvLimitValue between", value1, value2, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitValueNotBetween(Byte value1, Byte value2) {
            addCriterion("SrvLimitValue not between", value1, value2, "srvLimitValue");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeIsNull() {
            addCriterion("SrvLimitType is null");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeIsNotNull() {
            addCriterion("SrvLimitType is not null");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeEqualTo(Byte value) {
            addCriterion("SrvLimitType =", value, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeNotEqualTo(Byte value) {
            addCriterion("SrvLimitType <>", value, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeGreaterThan(Byte value) {
            addCriterion("SrvLimitType >", value, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SrvLimitType >=", value, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeLessThan(Byte value) {
            addCriterion("SrvLimitType <", value, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeLessThanOrEqualTo(Byte value) {
            addCriterion("SrvLimitType <=", value, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeIn(List<Byte> values) {
            addCriterion("SrvLimitType in", values, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeNotIn(List<Byte> values) {
            addCriterion("SrvLimitType not in", values, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeBetween(Byte value1, Byte value2) {
            addCriterion("SrvLimitType between", value1, value2, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andSrvLimitTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SrvLimitType not between", value1, value2, "srvLimitType");
            return (Criteria) this;
        }
        public Criteria andIsChargeIsNull() {
            addCriterion("IsCharge is null");
            return (Criteria) this;
        }
        public Criteria andIsChargeIsNotNull() {
            addCriterion("IsCharge is not null");
            return (Criteria) this;
        }
        public Criteria andIsChargeEqualTo(Byte value) {
            addCriterion("IsCharge =", value, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeNotEqualTo(Byte value) {
            addCriterion("IsCharge <>", value, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeGreaterThan(Byte value) {
            addCriterion("IsCharge >", value, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsCharge >=", value, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeLessThan(Byte value) {
            addCriterion("IsCharge <", value, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeLessThanOrEqualTo(Byte value) {
            addCriterion("IsCharge <=", value, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeIn(List<Byte> values) {
            addCriterion("IsCharge in", values, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeNotIn(List<Byte> values) {
            addCriterion("IsCharge not in", values, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeBetween(Byte value1, Byte value2) {
            addCriterion("IsCharge between", value1, value2, "isCharge");
            return (Criteria) this;
        }
        public Criteria andIsChargeNotBetween(Byte value1, Byte value2) {
            addCriterion("IsCharge not between", value1, value2, "isCharge");
            return (Criteria) this;
        }
        public Criteria andPriceIsNull() {
            addCriterion("Price is null");
            return (Criteria) this;
        }
        public Criteria andPriceIsNotNull() {
            addCriterion("Price is not null");
            return (Criteria) this;
        }
        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("Price =", value, "price");
            return (Criteria) this;
        }
        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("Price <>", value, "price");
            return (Criteria) this;
        }
        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("Price >", value, "price");
            return (Criteria) this;
        }
        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Price >=", value, "price");
            return (Criteria) this;
        }
        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("Price <", value, "price");
            return (Criteria) this;
        }
        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Price <=", value, "price");
            return (Criteria) this;
        }
        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("Price in", values, "price");
            return (Criteria) this;
        }
        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("Price not in", values, "price");
            return (Criteria) this;
        }
        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Price between", value1, value2, "price");
            return (Criteria) this;
        }
        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Price not between", value1, value2, "price");
            return (Criteria) this;
        }
        public Criteria andFileNameIsNull() {
            addCriterion("FileName is null");
            return (Criteria) this;
        }
        public Criteria andFileNameIsNotNull() {
            addCriterion("FileName is not null");
            return (Criteria) this;
        }
        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FileName =", value, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FileName <>", value, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FileName >", value, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FileName >=", value, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameLessThan(String value) {
            addCriterion("FileName <", value, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FileName <=", value, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameLike(String value) {
            addCriterion("FileName like", value, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameNotLike(String value) {
            addCriterion("FileName not like", value, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FileName in", values, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FileName not in", values, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FileName between", value1, value2, "fileName");
            return (Criteria) this;
        }
        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FileName not between", value1, value2, "fileName");
            return (Criteria) this;
        }
        public Criteria andFilePathIsNull() {
            addCriterion("FilePath is null");
            return (Criteria) this;
        }
        public Criteria andFilePathIsNotNull() {
            addCriterion("FilePath is not null");
            return (Criteria) this;
        }
        public Criteria andFilePathEqualTo(String value) {
            addCriterion("FilePath =", value, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("FilePath <>", value, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("FilePath >", value, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FilePath >=", value, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathLessThan(String value) {
            addCriterion("FilePath <", value, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("FilePath <=", value, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathLike(String value) {
            addCriterion("FilePath like", value, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathNotLike(String value) {
            addCriterion("FilePath not like", value, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathIn(List<String> values) {
            addCriterion("FilePath in", values, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("FilePath not in", values, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("FilePath between", value1, value2, "filePath");
            return (Criteria) this;
        }
        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("FilePath not between", value1, value2, "filePath");
            return (Criteria) this;
        }
        public Criteria andIntroductionIsNull() {
            addCriterion("Introduction is null");
            return (Criteria) this;
        }
        public Criteria andIntroductionIsNotNull() {
            addCriterion("Introduction is not null");
            return (Criteria) this;
        }
        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("Introduction =", value, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("Introduction <>", value, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("Introduction >", value, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("Introduction >=", value, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionLessThan(String value) {
            addCriterion("Introduction <", value, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("Introduction <=", value, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionLike(String value) {
            addCriterion("Introduction like", value, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionNotLike(String value) {
            addCriterion("Introduction not like", value, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("Introduction in", values, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("Introduction not in", values, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("Introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }
        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("Introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }
        public Criteria andUsedNumberIsNull() {
            addCriterion("UsedNumber is null");
            return (Criteria) this;
        }
        public Criteria andUsedNumberIsNotNull() {
            addCriterion("UsedNumber is not null");
            return (Criteria) this;
        }
        public Criteria andUsedNumberEqualTo(Integer value) {
            addCriterion("UsedNumber =", value, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberNotEqualTo(Integer value) {
            addCriterion("UsedNumber <>", value, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberGreaterThan(Integer value) {
            addCriterion("UsedNumber >", value, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("UsedNumber >=", value, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberLessThan(Integer value) {
            addCriterion("UsedNumber <", value, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("UsedNumber <=", value, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberIn(List<Integer> values) {
            addCriterion("UsedNumber in", values, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberNotIn(List<Integer> values) {
            addCriterion("UsedNumber not in", values, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberBetween(Integer value1, Integer value2) {
            addCriterion("UsedNumber between", value1, value2, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andUsedNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("UsedNumber not between", value1, value2, "usedNumber");
            return (Criteria) this;
        }
        public Criteria andTempletStatusIsNull() {
            addCriterion("TempletStatus is null");
            return (Criteria) this;
        }
        public Criteria andTempletStatusIsNotNull() {
            addCriterion("TempletStatus is not null");
            return (Criteria) this;
        }
        public Criteria andTempletStatusEqualTo(TempletStatusEnum status) {
        	if(status != null)
        		addCriterion("TempletStatus =", status.getCode(), "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusEqualTo(Byte value) {
            addCriterion("TempletStatus =", value, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusNotEqualTo(Byte value) {
            addCriterion("TempletStatus <>", value, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusGreaterThan(Byte value) {
            addCriterion("TempletStatus >", value, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("TempletStatus >=", value, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusLessThan(Byte value) {
            addCriterion("TempletStatus <", value, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusLessThanOrEqualTo(Byte value) {
            addCriterion("TempletStatus <=", value, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusIn(List<Byte> values) {
            addCriterion("TempletStatus in", values, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusNotIn(List<Byte> values) {
            addCriterion("TempletStatus not in", values, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusBetween(Byte value1, Byte value2) {
            addCriterion("TempletStatus between", value1, value2, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andTempletStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("TempletStatus not between", value1, value2, "templetStatus");
            return (Criteria) this;
        }
        public Criteria andOrgIDIsNull() {
            addCriterion("OrgID is null");
            return (Criteria) this;
        }
        public Criteria andOrgIDIsNotNull() {
            addCriterion("OrgID is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIDEqualTo(Integer value) {
            addCriterion("OrgID =", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotEqualTo(Integer value) {
            addCriterion("OrgID <>", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDGreaterThan(Integer value) {
            addCriterion("OrgID >", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgID >=", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDLessThan(Integer value) {
            addCriterion("OrgID <", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDLessThanOrEqualTo(Integer value) {
            addCriterion("OrgID <=", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDIn(List<Integer> values) {
            addCriterion("OrgID in", values, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotIn(List<Integer> values) {
            addCriterion("OrgID not in", values, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDBetween(Integer value1, Integer value2) {
            addCriterion("OrgID between", value1, value2, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgID not between", value1, value2, "orgID");
            return (Criteria) this;
        }
        public Criteria andUseRangeIsNull() {
            addCriterion("UseRange is null");
            return (Criteria) this;
        }
        public Criteria andUseRangeIsNotNull() {
            addCriterion("UseRange is not null");
            return (Criteria) this;
        }
        public Criteria andUseRangeEqualTo(Byte value) {
            addCriterion("UseRange =", value, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeNotEqualTo(Byte value) {
            addCriterion("UseRange <>", value, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeGreaterThan(Byte value) {
            addCriterion("UseRange >", value, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeGreaterThanOrEqualTo(Byte value) {
            addCriterion("UseRange >=", value, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeLessThan(Byte value) {
            addCriterion("UseRange <", value, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeLessThanOrEqualTo(Byte value) {
            addCriterion("UseRange <=", value, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeIn(List<Byte> values) {
            addCriterion("UseRange in", values, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeNotIn(List<Byte> values) {
            addCriterion("UseRange not in", values, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeBetween(Byte value1, Byte value2) {
            addCriterion("UseRange between", value1, value2, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeNotBetween(Byte value1, Byte value2) {
            addCriterion("UseRange not between", value1, value2, "useRange");
            return (Criteria) this;
        }
        public Criteria andCreateIDIsNull() {
            addCriterion("CreateID is null");
            return (Criteria) this;
        }
        public Criteria andCreateIDIsNotNull() {
            addCriterion("CreateID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateIDEqualTo(Integer value) {
            addCriterion("CreateID =", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDNotEqualTo(Integer value) {
            addCriterion("CreateID <>", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDGreaterThan(Integer value) {
            addCriterion("CreateID >", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateID >=", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDLessThan(Integer value) {
            addCriterion("CreateID <", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDLessThanOrEqualTo(Integer value) {
            addCriterion("CreateID <=", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDIn(List<Integer> values) {
            addCriterion("CreateID in", values, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDNotIn(List<Integer> values) {
            addCriterion("CreateID not in", values, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDBetween(Integer value1, Integer value2) {
            addCriterion("CreateID between", value1, value2, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateID not between", value1, value2, "createID");
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
        public Criteria andUpdateIDIsNull() {
            addCriterion("UpdateID is null");
            return (Criteria) this;
        }
        public Criteria andUpdateIDIsNotNull() {
            addCriterion("UpdateID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateIDEqualTo(Integer value) {
            addCriterion("UpdateID =", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDNotEqualTo(Integer value) {
            addCriterion("UpdateID <>", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDGreaterThan(Integer value) {
            addCriterion("UpdateID >", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateID >=", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDLessThan(Integer value) {
            addCriterion("UpdateID <", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateID <=", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDIn(List<Integer> values) {
            addCriterion("UpdateID in", values, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDNotIn(List<Integer> values) {
            addCriterion("UpdateID not in", values, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID between", value1, value2, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID not between", value1, value2, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [3.0]管理方案_模板
     * 
     * @author ${user}
     * @version 1.0 2016-11-29
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