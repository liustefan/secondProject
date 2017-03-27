/*
 * AppServerExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.ucCore.uc.model;

import java.util.ArrayList;
import java.util.List;

public class AppServerExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public AppServerExample() {
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
     * 
     * 
     * @author ${user}
     * @version 1.0 2016-08-18
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
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }
        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }
        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andAppIdIsNull() {
            addCriterion("appId is null");
            return (Criteria) this;
        }
        public Criteria andAppIdIsNotNull() {
            addCriterion("appId is not null");
            return (Criteria) this;
        }
        public Criteria andAppIdEqualTo(Integer value) {
            addCriterion("appId =", value, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdNotEqualTo(Integer value) {
            addCriterion("appId <>", value, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdGreaterThan(Integer value) {
            addCriterion("appId >", value, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("appId >=", value, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdLessThan(Integer value) {
            addCriterion("appId <", value, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("appId <=", value, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdIn(List<Integer> values) {
            addCriterion("appId in", values, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdNotIn(List<Integer> values) {
            addCriterion("appId not in", values, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdBetween(Integer value1, Integer value2) {
            addCriterion("appId between", value1, value2, "appId");
            return (Criteria) this;
        }
        public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("appId not between", value1, value2, "appId");
            return (Criteria) this;
        }
        public Criteria andServerNameIsNull() {
            addCriterion("serverName is null");
            return (Criteria) this;
        }
        public Criteria andServerNameIsNotNull() {
            addCriterion("serverName is not null");
            return (Criteria) this;
        }
        public Criteria andServerNameEqualTo(String value) {
            addCriterion("serverName =", value, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameNotEqualTo(String value) {
            addCriterion("serverName <>", value, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameGreaterThan(String value) {
            addCriterion("serverName >", value, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("serverName >=", value, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameLessThan(String value) {
            addCriterion("serverName <", value, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameLessThanOrEqualTo(String value) {
            addCriterion("serverName <=", value, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameLike(String value) {
            addCriterion("serverName like", value, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameNotLike(String value) {
            addCriterion("serverName not like", value, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameIn(List<String> values) {
            addCriterion("serverName in", values, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameNotIn(List<String> values) {
            addCriterion("serverName not in", values, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameBetween(String value1, String value2) {
            addCriterion("serverName between", value1, value2, "serverName");
            return (Criteria) this;
        }
        public Criteria andServerNameNotBetween(String value1, String value2) {
            addCriterion("serverName not between", value1, value2, "serverName");
            return (Criteria) this;
        }
        public Criteria andIpAddressIsNull() {
            addCriterion("ipAddress is null");
            return (Criteria) this;
        }
        public Criteria andIpAddressIsNotNull() {
            addCriterion("ipAddress is not null");
            return (Criteria) this;
        }
        public Criteria andIpAddressEqualTo(String value) {
            addCriterion("ipAddress =", value, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressNotEqualTo(String value) {
            addCriterion("ipAddress <>", value, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressGreaterThan(String value) {
            addCriterion("ipAddress >", value, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ipAddress >=", value, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressLessThan(String value) {
            addCriterion("ipAddress <", value, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressLessThanOrEqualTo(String value) {
            addCriterion("ipAddress <=", value, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressLike(String value) {
            addCriterion("ipAddress like", value, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressNotLike(String value) {
            addCriterion("ipAddress not like", value, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressIn(List<String> values) {
            addCriterion("ipAddress in", values, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressNotIn(List<String> values) {
            addCriterion("ipAddress not in", values, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressBetween(String value1, String value2) {
            addCriterion("ipAddress between", value1, value2, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andIpAddressNotBetween(String value1, String value2) {
            addCriterion("ipAddress not between", value1, value2, "ipAddress");
            return (Criteria) this;
        }
        public Criteria andCreateNameIsNull() {
            addCriterion("createName is null");
            return (Criteria) this;
        }
        public Criteria andCreateNameIsNotNull() {
            addCriterion("createName is not null");
            return (Criteria) this;
        }
        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("createName =", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("createName <>", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("createName >", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("createName >=", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLessThan(String value) {
            addCriterion("createName <", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("createName <=", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLike(String value) {
            addCriterion("createName like", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotLike(String value) {
            addCriterion("createName not like", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("createName in", values, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("createName not in", values, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("createName between", value1, value2, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("createName not between", value1, value2, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }
        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }
        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("createDate =", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("createDate <>", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("createDate >", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("createDate >=", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateLessThan(String value) {
            addCriterion("createDate <", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("createDate <=", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateLike(String value) {
            addCriterion("createDate like", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotLike(String value) {
            addCriterion("createDate not like", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("createDate in", values, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("createDate not in", values, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("createDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }
        public Criteria andWebAddressIsNull() {
            addCriterion("webAddress is null");
            return (Criteria) this;
        }
        public Criteria andWebAddressIsNotNull() {
            addCriterion("webAddress is not null");
            return (Criteria) this;
        }
        public Criteria andWebAddressEqualTo(String value) {
            addCriterion("webAddress =", value, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressNotEqualTo(String value) {
            addCriterion("webAddress <>", value, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressGreaterThan(String value) {
            addCriterion("webAddress >", value, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressGreaterThanOrEqualTo(String value) {
            addCriterion("webAddress >=", value, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressLessThan(String value) {
            addCriterion("webAddress <", value, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressLessThanOrEqualTo(String value) {
            addCriterion("webAddress <=", value, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressLike(String value) {
            addCriterion("webAddress like", value, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressNotLike(String value) {
            addCriterion("webAddress not like", value, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressIn(List<String> values) {
            addCriterion("webAddress in", values, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressNotIn(List<String> values) {
            addCriterion("webAddress not in", values, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressBetween(String value1, String value2) {
            addCriterion("webAddress between", value1, value2, "webAddress");
            return (Criteria) this;
        }
        public Criteria andWebAddressNotBetween(String value1, String value2) {
            addCriterion("webAddress not between", value1, value2, "webAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressIsNull() {
            addCriterion("HttpsAddress is null");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressIsNotNull() {
            addCriterion("HttpsAddress is not null");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressEqualTo(String value) {
            addCriterion("HttpsAddress =", value, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressNotEqualTo(String value) {
            addCriterion("HttpsAddress <>", value, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressGreaterThan(String value) {
            addCriterion("HttpsAddress >", value, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressGreaterThanOrEqualTo(String value) {
            addCriterion("HttpsAddress >=", value, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressLessThan(String value) {
            addCriterion("HttpsAddress <", value, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressLessThanOrEqualTo(String value) {
            addCriterion("HttpsAddress <=", value, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressLike(String value) {
            addCriterion("HttpsAddress like", value, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressNotLike(String value) {
            addCriterion("HttpsAddress not like", value, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressIn(List<String> values) {
            addCriterion("HttpsAddress in", values, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressNotIn(List<String> values) {
            addCriterion("HttpsAddress not in", values, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressBetween(String value1, String value2) {
            addCriterion("HttpsAddress between", value1, value2, "httpsAddress");
            return (Criteria) this;
        }
        public Criteria andHttpsAddressNotBetween(String value1, String value2) {
            addCriterion("HttpsAddress not between", value1, value2, "httpsAddress");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author ${user}
     * @version 1.0 2016-08-18
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