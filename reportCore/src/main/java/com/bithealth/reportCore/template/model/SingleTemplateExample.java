/*
 * SingleTemplateExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-13 Created
 */
package com.bithealth.reportCore.template.model;

import java.util.ArrayList;
import java.util.List;

public class SingleTemplateExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SingleTemplateExample() {
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
     * 审核模板设置(ORTS)
     * 
     * @author ${user}
     * @version 1.0 2016-07-13
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
        public Criteria andTempCodeIsNull() {
            addCriterion("TempCode is null");
            return (Criteria) this;
        }
        public Criteria andTempCodeIsNotNull() {
            addCriterion("TempCode is not null");
            return (Criteria) this;
        }
        public Criteria andTempCodeEqualTo(Integer value) {
            addCriterion("TempCode =", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotEqualTo(Integer value) {
            addCriterion("TempCode <>", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeGreaterThan(Integer value) {
            addCriterion("TempCode >", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TempCode >=", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeLessThan(Integer value) {
            addCriterion("TempCode <", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeLessThanOrEqualTo(Integer value) {
            addCriterion("TempCode <=", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeIn(List<Integer> values) {
            addCriterion("TempCode in", values, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotIn(List<Integer> values) {
            addCriterion("TempCode not in", values, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeBetween(Integer value1, Integer value2) {
            addCriterion("TempCode between", value1, value2, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("TempCode not between", value1, value2, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempNameIsNull() {
            addCriterion("TempName is null");
            return (Criteria) this;
        }
        public Criteria andTempNameIsNotNull() {
            addCriterion("TempName is not null");
            return (Criteria) this;
        }
        public Criteria andTempNameEqualTo(String value) {
            addCriterion("TempName =", value, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameNotEqualTo(String value) {
            addCriterion("TempName <>", value, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameGreaterThan(String value) {
            addCriterion("TempName >", value, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameGreaterThanOrEqualTo(String value) {
            addCriterion("TempName >=", value, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameLessThan(String value) {
            addCriterion("TempName <", value, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameLessThanOrEqualTo(String value) {
            addCriterion("TempName <=", value, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameLike(String value) {
            addCriterion("TempName like", value, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameNotLike(String value) {
            addCriterion("TempName not like", value, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameIn(List<String> values) {
            addCriterion("TempName in", values, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameNotIn(List<String> values) {
            addCriterion("TempName not in", values, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameBetween(String value1, String value2) {
            addCriterion("TempName between", value1, value2, "tempName");
            return (Criteria) this;
        }
        public Criteria andTempNameNotBetween(String value1, String value2) {
            addCriterion("TempName not between", value1, value2, "tempName");
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
        public Criteria andSetDescIsNull() {
            addCriterion("SetDesc is null");
            return (Criteria) this;
        }
        public Criteria andSetDescIsNotNull() {
            addCriterion("SetDesc is not null");
            return (Criteria) this;
        }
        public Criteria andSetDescEqualTo(String value) {
            addCriterion("SetDesc =", value, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescNotEqualTo(String value) {
            addCriterion("SetDesc <>", value, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescGreaterThan(String value) {
            addCriterion("SetDesc >", value, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescGreaterThanOrEqualTo(String value) {
            addCriterion("SetDesc >=", value, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescLessThan(String value) {
            addCriterion("SetDesc <", value, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescLessThanOrEqualTo(String value) {
            addCriterion("SetDesc <=", value, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescLike(String value) {
            addCriterion("SetDesc like", value, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescNotLike(String value) {
            addCriterion("SetDesc not like", value, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescIn(List<String> values) {
            addCriterion("SetDesc in", values, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescNotIn(List<String> values) {
            addCriterion("SetDesc not in", values, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescBetween(String value1, String value2) {
            addCriterion("SetDesc between", value1, value2, "setDesc");
            return (Criteria) this;
        }
        public Criteria andSetDescNotBetween(String value1, String value2) {
            addCriterion("SetDesc not between", value1, value2, "setDesc");
            return (Criteria) this;
        }
        public Criteria andMinRecordsIsNull() {
            addCriterion("MinRecords is null");
            return (Criteria) this;
        }
        public Criteria andMinRecordsIsNotNull() {
            addCriterion("MinRecords is not null");
            return (Criteria) this;
        }
        public Criteria andMinRecordsEqualTo(Short value) {
            addCriterion("MinRecords =", value, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsNotEqualTo(Short value) {
            addCriterion("MinRecords <>", value, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsGreaterThan(Short value) {
            addCriterion("MinRecords >", value, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsGreaterThanOrEqualTo(Short value) {
            addCriterion("MinRecords >=", value, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsLessThan(Short value) {
            addCriterion("MinRecords <", value, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsLessThanOrEqualTo(Short value) {
            addCriterion("MinRecords <=", value, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsIn(List<Short> values) {
            addCriterion("MinRecords in", values, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsNotIn(List<Short> values) {
            addCriterion("MinRecords not in", values, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsBetween(Short value1, Short value2) {
            addCriterion("MinRecords between", value1, value2, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinRecordsNotBetween(Short value1, Short value2) {
            addCriterion("MinRecords not between", value1, value2, "minRecords");
            return (Criteria) this;
        }
        public Criteria andMinDisDayIsNull() {
            addCriterion("MinDisDay is null");
            return (Criteria) this;
        }
        public Criteria andMinDisDayIsNotNull() {
            addCriterion("MinDisDay is not null");
            return (Criteria) this;
        }
        public Criteria andMinDisDayEqualTo(Short value) {
            addCriterion("MinDisDay =", value, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayNotEqualTo(Short value) {
            addCriterion("MinDisDay <>", value, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayGreaterThan(Short value) {
            addCriterion("MinDisDay >", value, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayGreaterThanOrEqualTo(Short value) {
            addCriterion("MinDisDay >=", value, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayLessThan(Short value) {
            addCriterion("MinDisDay <", value, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayLessThanOrEqualTo(Short value) {
            addCriterion("MinDisDay <=", value, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayIn(List<Short> values) {
            addCriterion("MinDisDay in", values, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayNotIn(List<Short> values) {
            addCriterion("MinDisDay not in", values, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayBetween(Short value1, Short value2) {
            addCriterion("MinDisDay between", value1, value2, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMinDisDayNotBetween(Short value1, Short value2) {
            addCriterion("MinDisDay not between", value1, value2, "minDisDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayIsNull() {
            addCriterion("MaxMumDay is null");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayIsNotNull() {
            addCriterion("MaxMumDay is not null");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayEqualTo(Short value) {
            addCriterion("MaxMumDay =", value, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayNotEqualTo(Short value) {
            addCriterion("MaxMumDay <>", value, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayGreaterThan(Short value) {
            addCriterion("MaxMumDay >", value, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayGreaterThanOrEqualTo(Short value) {
            addCriterion("MaxMumDay >=", value, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayLessThan(Short value) {
            addCriterion("MaxMumDay <", value, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayLessThanOrEqualTo(Short value) {
            addCriterion("MaxMumDay <=", value, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayIn(List<Short> values) {
            addCriterion("MaxMumDay in", values, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayNotIn(List<Short> values) {
            addCriterion("MaxMumDay not in", values, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayBetween(Short value1, Short value2) {
            addCriterion("MaxMumDay between", value1, value2, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andMaxMumDayNotBetween(Short value1, Short value2) {
            addCriterion("MaxMumDay not between", value1, value2, "maxMumDay");
            return (Criteria) this;
        }
        public Criteria andChTagIsNull() {
            addCriterion("ChTag is null");
            return (Criteria) this;
        }
        public Criteria andChTagIsNotNull() {
            addCriterion("ChTag is not null");
            return (Criteria) this;
        }
        public Criteria andChTagEqualTo(String value) {
            addCriterion("ChTag =", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotEqualTo(String value) {
            addCriterion("ChTag <>", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagGreaterThan(String value) {
            addCriterion("ChTag >", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagGreaterThanOrEqualTo(String value) {
            addCriterion("ChTag >=", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLessThan(String value) {
            addCriterion("ChTag <", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLessThanOrEqualTo(String value) {
            addCriterion("ChTag <=", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLike(String value) {
            addCriterion("ChTag like", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotLike(String value) {
            addCriterion("ChTag not like", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagIn(List<String> values) {
            addCriterion("ChTag in", values, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotIn(List<String> values) {
            addCriterion("ChTag not in", values, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagBetween(String value1, String value2) {
            addCriterion("ChTag between", value1, value2, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotBetween(String value1, String value2) {
            addCriterion("ChTag not between", value1, value2, "chTag");
            return (Criteria) this;
        }
        public Criteria andValiTagIsNull() {
            addCriterion("ValiTag is null");
            return (Criteria) this;
        }
        public Criteria andValiTagIsNotNull() {
            addCriterion("ValiTag is not null");
            return (Criteria) this;
        }
        public Criteria andValiTagEqualTo(String value) {
            addCriterion("ValiTag =", value, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagNotEqualTo(String value) {
            addCriterion("ValiTag <>", value, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagGreaterThan(String value) {
            addCriterion("ValiTag >", value, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagGreaterThanOrEqualTo(String value) {
            addCriterion("ValiTag >=", value, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagLessThan(String value) {
            addCriterion("ValiTag <", value, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagLessThanOrEqualTo(String value) {
            addCriterion("ValiTag <=", value, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagLike(String value) {
            addCriterion("ValiTag like", value, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagNotLike(String value) {
            addCriterion("ValiTag not like", value, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagIn(List<String> values) {
            addCriterion("ValiTag in", values, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagNotIn(List<String> values) {
            addCriterion("ValiTag not in", values, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagBetween(String value1, String value2) {
            addCriterion("ValiTag between", value1, value2, "valiTag");
            return (Criteria) this;
        }
        public Criteria andValiTagNotBetween(String value1, String value2) {
            addCriterion("ValiTag not between", value1, value2, "valiTag");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNull() {
            addCriterion("OrgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNotNull() {
            addCriterion("OrgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("OrgId =", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("OrgId <>", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("OrgId >", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgId >=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("OrgId <", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("OrgId <=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("OrgId in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("OrgId not in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("OrgId between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgId not between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andMaxCycleIsNull() {
            addCriterion("MaxCycle is null");
            return (Criteria) this;
        }
        public Criteria andMaxCycleIsNotNull() {
            addCriterion("MaxCycle is not null");
            return (Criteria) this;
        }
        public Criteria andMaxCycleEqualTo(Short value) {
            addCriterion("MaxCycle =", value, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleNotEqualTo(Short value) {
            addCriterion("MaxCycle <>", value, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleGreaterThan(Short value) {
            addCriterion("MaxCycle >", value, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleGreaterThanOrEqualTo(Short value) {
            addCriterion("MaxCycle >=", value, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleLessThan(Short value) {
            addCriterion("MaxCycle <", value, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleLessThanOrEqualTo(Short value) {
            addCriterion("MaxCycle <=", value, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleIn(List<Short> values) {
            addCriterion("MaxCycle in", values, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleNotIn(List<Short> values) {
            addCriterion("MaxCycle not in", values, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleBetween(Short value1, Short value2) {
            addCriterion("MaxCycle between", value1, value2, "maxCycle");
            return (Criteria) this;
        }
        public Criteria andMaxCycleNotBetween(Short value1, Short value2) {
            addCriterion("MaxCycle not between", value1, value2, "maxCycle");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 审核模板设置(ORTS)
     * 
     * @author ${user}
     * @version 1.0 2016-07-13
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