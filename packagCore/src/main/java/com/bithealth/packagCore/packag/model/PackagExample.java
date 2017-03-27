/*
 * PackagExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-07 Created
 */
package com.bithealth.packagCore.packag.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PackagExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public PackagExample() {
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
     * 服务套餐设置(OPSP)
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
        public Criteria andPackageNameIsNull() {
            addCriterion("PackageName is null");
            return (Criteria) this;
        }
        public Criteria andPackageNameIsNotNull() {
            addCriterion("PackageName is not null");
            return (Criteria) this;
        }
        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("PackageName =", value, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("PackageName <>", value, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("PackageName >", value, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("PackageName >=", value, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameLessThan(String value) {
            addCriterion("PackageName <", value, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("PackageName <=", value, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameLike(String value) {
            addCriterion("PackageName like", value, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameNotLike(String value) {
            addCriterion("PackageName not like", value, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("PackageName in", values, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("PackageName not in", values, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("PackageName between", value1, value2, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("PackageName not between", value1, value2, "packageName");
            return (Criteria) this;
        }
        public Criteria andPackageDescIsNull() {
            addCriterion("PackageDesc is null");
            return (Criteria) this;
        }
        public Criteria andPackageDescIsNotNull() {
            addCriterion("PackageDesc is not null");
            return (Criteria) this;
        }
        public Criteria andPackageDescEqualTo(String value) {
            addCriterion("PackageDesc =", value, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescNotEqualTo(String value) {
            addCriterion("PackageDesc <>", value, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescGreaterThan(String value) {
            addCriterion("PackageDesc >", value, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescGreaterThanOrEqualTo(String value) {
            addCriterion("PackageDesc >=", value, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescLessThan(String value) {
            addCriterion("PackageDesc <", value, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescLessThanOrEqualTo(String value) {
            addCriterion("PackageDesc <=", value, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescLike(String value) {
            addCriterion("PackageDesc like", value, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescNotLike(String value) {
            addCriterion("PackageDesc not like", value, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescIn(List<String> values) {
            addCriterion("PackageDesc in", values, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescNotIn(List<String> values) {
            addCriterion("PackageDesc not in", values, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescBetween(String value1, String value2) {
            addCriterion("PackageDesc between", value1, value2, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageDescNotBetween(String value1, String value2) {
            addCriterion("PackageDesc not between", value1, value2, "packageDesc");
            return (Criteria) this;
        }
        public Criteria andPackageTypeIsNull() {
            addCriterion("PackageType is null");
            return (Criteria) this;
        }
        public Criteria andPackageTypeIsNotNull() {
            addCriterion("PackageType is not null");
            return (Criteria) this;
        }
        public Criteria andPackageTypeEqualTo(Short value) {
            addCriterion("PackageType =", value, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeNotEqualTo(Short value) {
            addCriterion("PackageType <>", value, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeGreaterThan(Short value) {
            addCriterion("PackageType >", value, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PackageType >=", value, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeLessThan(Short value) {
            addCriterion("PackageType <", value, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeLessThanOrEqualTo(Short value) {
            addCriterion("PackageType <=", value, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeIn(List<Short> values) {
            addCriterion("PackageType in", values, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeNotIn(List<Short> values) {
            addCriterion("PackageType not in", values, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeBetween(Short value1, Short value2) {
            addCriterion("PackageType between", value1, value2, "packageType");
            return (Criteria) this;
        }
        public Criteria andPackageTypeNotBetween(Short value1, Short value2) {
            addCriterion("PackageType not between", value1, value2, "packageType");
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
        public Criteria andPackageLevelIsNull() {
            addCriterion("PackageLevel is null");
            return (Criteria) this;
        }
        public Criteria andPackageLevelIsNotNull() {
            addCriterion("PackageLevel is not null");
            return (Criteria) this;
        }
        public Criteria andPackageLevelEqualTo(String value) {
            addCriterion("PackageLevel =", value, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelNotEqualTo(String value) {
            addCriterion("PackageLevel <>", value, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelGreaterThan(String value) {
            addCriterion("PackageLevel >", value, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelGreaterThanOrEqualTo(String value) {
            addCriterion("PackageLevel >=", value, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelLessThan(String value) {
            addCriterion("PackageLevel <", value, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelLessThanOrEqualTo(String value) {
            addCriterion("PackageLevel <=", value, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelLike(String value) {
            addCriterion("PackageLevel like", value, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelNotLike(String value) {
            addCriterion("PackageLevel not like", value, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelIn(List<String> values) {
            addCriterion("PackageLevel in", values, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelNotIn(List<String> values) {
            addCriterion("PackageLevel not in", values, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelBetween(String value1, String value2) {
            addCriterion("PackageLevel between", value1, value2, "packageLevel");
            return (Criteria) this;
        }
        public Criteria andPackageLevelNotBetween(String value1, String value2) {
            addCriterion("PackageLevel not between", value1, value2, "packageLevel");
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
        public Criteria andCreateNameIsNull() {
            addCriterion("CreateName is null");
            return (Criteria) this;
        }
        public Criteria andCreateNameIsNotNull() {
            addCriterion("CreateName is not null");
            return (Criteria) this;
        }
        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("CreateName =", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("CreateName <>", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("CreateName >", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("CreateName >=", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLessThan(String value) {
            addCriterion("CreateName <", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("CreateName <=", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLike(String value) {
            addCriterion("CreateName like", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotLike(String value) {
            addCriterion("CreateName not like", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("CreateName in", values, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("CreateName not in", values, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("CreateName between", value1, value2, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("CreateName not between", value1, value2, "createName");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 服务套餐设置(OPSP)
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