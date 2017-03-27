/*
 * OrgExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.orgainCore.model;

import java.util.ArrayList;
import java.util.List;

public class OrgExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OrgExample() {
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
     * 组织架构表(ORGS)
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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
        public Criteria andOrgCodeIsNull() {
            addCriterion("orgCode is null");
            return (Criteria) this;
        }
        public Criteria andOrgCodeIsNotNull() {
            addCriterion("orgCode is not null");
            return (Criteria) this;
        }
        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("orgCode =", value, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("orgCode <>", value, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("orgCode >", value, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgCode >=", value, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("orgCode <", value, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("orgCode <=", value, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeLike(String value) {
            addCriterion("orgCode like", value, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("orgCode not like", value, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("orgCode in", values, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("orgCode not in", values, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("orgCode between", value1, value2, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("orgCode not between", value1, value2, "orgCode");
            return (Criteria) this;
        }
        public Criteria andOrgNameIsNull() {
            addCriterion("OrgName is null");
            return (Criteria) this;
        }
        public Criteria andOrgNameIsNotNull() {
            addCriterion("OrgName is not null");
            return (Criteria) this;
        }
        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("OrgName =", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("OrgName <>", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("OrgName >", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("OrgName >=", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameLessThan(String value) {
            addCriterion("OrgName <", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("OrgName <=", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameLike(String value) {
            addCriterion("OrgName like", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameNotLike(String value) {
            addCriterion("OrgName not like", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("OrgName in", values, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("OrgName not in", values, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("OrgName between", value1, value2, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("OrgName not between", value1, value2, "orgName");
            return (Criteria) this;
        }
        public Criteria andSuperiorIsNull() {
            addCriterion("Superior is null");
            return (Criteria) this;
        }
        public Criteria andSuperiorIsNotNull() {
            addCriterion("Superior is not null");
            return (Criteria) this;
        }
        public Criteria andSuperiorEqualTo(Integer value) {
            addCriterion("Superior =", value, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorNotEqualTo(Integer value) {
            addCriterion("Superior <>", value, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorGreaterThan(Integer value) {
            addCriterion("Superior >", value, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorGreaterThanOrEqualTo(Integer value) {
            addCriterion("Superior >=", value, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorLessThan(Integer value) {
            addCriterion("Superior <", value, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorLessThanOrEqualTo(Integer value) {
            addCriterion("Superior <=", value, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorIn(List<Integer> values) {
            addCriterion("Superior in", values, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorNotIn(List<Integer> values) {
            addCriterion("Superior not in", values, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorBetween(Integer value1, Integer value2) {
            addCriterion("Superior between", value1, value2, "superior");
            return (Criteria) this;
        }
        public Criteria andSuperiorNotBetween(Integer value1, Integer value2) {
            addCriterion("Superior not between", value1, value2, "superior");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceIsNull() {
            addCriterion("IsExternalService is null");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceIsNotNull() {
            addCriterion("IsExternalService is not null");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceEqualTo(String value) {
            addCriterion("IsExternalService =", value, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceNotEqualTo(String value) {
            addCriterion("IsExternalService <>", value, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceGreaterThan(String value) {
            addCriterion("IsExternalService >", value, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceGreaterThanOrEqualTo(String value) {
            addCriterion("IsExternalService >=", value, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceLessThan(String value) {
            addCriterion("IsExternalService <", value, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceLessThanOrEqualTo(String value) {
            addCriterion("IsExternalService <=", value, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceLike(String value) {
            addCriterion("IsExternalService like", value, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceNotLike(String value) {
            addCriterion("IsExternalService not like", value, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceIn(List<String> values) {
            addCriterion("IsExternalService in", values, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceNotIn(List<String> values) {
            addCriterion("IsExternalService not in", values, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceBetween(String value1, String value2) {
            addCriterion("IsExternalService between", value1, value2, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andIsExternalServiceNotBetween(String value1, String value2) {
            addCriterion("IsExternalService not between", value1, value2, "isExternalService");
            return (Criteria) this;
        }
        public Criteria andOtypeIsNull() {
            addCriterion("Otype is null");
            return (Criteria) this;
        }
        public Criteria andOtypeIsNotNull() {
            addCriterion("Otype is not null");
            return (Criteria) this;
        }
        public Criteria andOtypeEqualTo(Short value) {
            addCriterion("Otype =", value, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeNotEqualTo(Short value) {
            addCriterion("Otype <>", value, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeGreaterThan(Short value) {
            addCriterion("Otype >", value, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("Otype >=", value, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeLessThan(Short value) {
            addCriterion("Otype <", value, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeLessThanOrEqualTo(Short value) {
            addCriterion("Otype <=", value, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeIn(List<Short> values) {
            addCriterion("Otype in", values, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeNotIn(List<Short> values) {
            addCriterion("Otype not in", values, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeBetween(Short value1, Short value2) {
            addCriterion("Otype between", value1, value2, "otype");
            return (Criteria) this;
        }
        public Criteria andOtypeNotBetween(Short value1, Short value2) {
            addCriterion("Otype not between", value1, value2, "otype");
            return (Criteria) this;
        }
        public Criteria andMemnumIsNull() {
            addCriterion("Memnum is null");
            return (Criteria) this;
        }
        public Criteria andMemnumIsNotNull() {
            addCriterion("Memnum is not null");
            return (Criteria) this;
        }
        public Criteria andMemnumEqualTo(Integer value) {
            addCriterion("Memnum =", value, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumNotEqualTo(Integer value) {
            addCriterion("Memnum <>", value, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumGreaterThan(Integer value) {
            addCriterion("Memnum >", value, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Memnum >=", value, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumLessThan(Integer value) {
            addCriterion("Memnum <", value, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumLessThanOrEqualTo(Integer value) {
            addCriterion("Memnum <=", value, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumIn(List<Integer> values) {
            addCriterion("Memnum in", values, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumNotIn(List<Integer> values) {
            addCriterion("Memnum not in", values, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumBetween(Integer value1, Integer value2) {
            addCriterion("Memnum between", value1, value2, "memnum");
            return (Criteria) this;
        }
        public Criteria andMemnumNotBetween(Integer value1, Integer value2) {
            addCriterion("Memnum not between", value1, value2, "memnum");
            return (Criteria) this;
        }
        public Criteria andDocNumIsNull() {
            addCriterion("DocNum is null");
            return (Criteria) this;
        }
        public Criteria andDocNumIsNotNull() {
            addCriterion("DocNum is not null");
            return (Criteria) this;
        }
        public Criteria andDocNumEqualTo(Integer value) {
            addCriterion("DocNum =", value, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumNotEqualTo(Integer value) {
            addCriterion("DocNum <>", value, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumGreaterThan(Integer value) {
            addCriterion("DocNum >", value, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("DocNum >=", value, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumLessThan(Integer value) {
            addCriterion("DocNum <", value, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumLessThanOrEqualTo(Integer value) {
            addCriterion("DocNum <=", value, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumIn(List<Integer> values) {
            addCriterion("DocNum in", values, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumNotIn(List<Integer> values) {
            addCriterion("DocNum not in", values, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumBetween(Integer value1, Integer value2) {
            addCriterion("DocNum between", value1, value2, "docNum");
            return (Criteria) this;
        }
        public Criteria andDocNumNotBetween(Integer value1, Integer value2) {
            addCriterion("DocNum not between", value1, value2, "docNum");
            return (Criteria) this;
        }
        public Criteria andUseTagIsNull() {
            addCriterion("UseTag is null");
            return (Criteria) this;
        }
        public Criteria andUseTagIsNotNull() {
            addCriterion("UseTag is not null");
            return (Criteria) this;
        }
        public Criteria andUseTagEqualTo(String value) {
            addCriterion("UseTag =", value, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagNotEqualTo(String value) {
            addCriterion("UseTag <>", value, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagGreaterThan(String value) {
            addCriterion("UseTag >", value, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagGreaterThanOrEqualTo(String value) {
            addCriterion("UseTag >=", value, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagLessThan(String value) {
            addCriterion("UseTag <", value, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagLessThanOrEqualTo(String value) {
            addCriterion("UseTag <=", value, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagLike(String value) {
            addCriterion("UseTag like", value, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagNotLike(String value) {
            addCriterion("UseTag not like", value, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagIn(List<String> values) {
            addCriterion("UseTag in", values, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagNotIn(List<String> values) {
            addCriterion("UseTag not in", values, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagBetween(String value1, String value2) {
            addCriterion("UseTag between", value1, value2, "useTag");
            return (Criteria) this;
        }
        public Criteria andUseTagNotBetween(String value1, String value2) {
            addCriterion("UseTag not between", value1, value2, "useTag");
            return (Criteria) this;
        }
        public Criteria andOrderIsNull() {
            addCriterion("`order` is null");
            return (Criteria) this;
        }
        public Criteria andOrderIsNotNull() {
            addCriterion("`order` is not null");
            return (Criteria) this;
        }
        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("`order` =", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("`order` <>", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("`order` >", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("`order` >=", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderLessThan(Integer value) {
            addCriterion("`order` <", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("`order` <=", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("`order` in", values, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("`order` not in", values, "order");
            return (Criteria) this;
        }
        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("`order` between", value1, value2, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("`order` not between", value1, value2, "order");
            return (Criteria) this;
        }
        public Criteria andPathIsNull() {
            addCriterion("Path is null");
            return (Criteria) this;
        }
        public Criteria andPathIsNotNull() {
            addCriterion("Path is not null");
            return (Criteria) this;
        }
        public Criteria andPathEqualTo(String value) {
            addCriterion("Path =", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathNotEqualTo(String value) {
            addCriterion("Path <>", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathGreaterThan(String value) {
            addCriterion("Path >", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("Path >=", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathLessThan(String value) {
            addCriterion("Path <", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("Path <=", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathLike(String value) {
            addCriterion("Path like", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathNotLike(String value) {
            addCriterion("Path not like", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathIn(List<String> values) {
            addCriterion("Path in", values, "path");
            return (Criteria) this;
        }
        public Criteria andPathNotIn(List<String> values) {
            addCriterion("Path not in", values, "path");
            return (Criteria) this;
        }
        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("Path between", value1, value2, "path");
            return (Criteria) this;
        }
        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("Path not between", value1, value2, "path");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 组织架构表(ORGS)
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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