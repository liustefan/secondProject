/*
 * MemSessionExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemSessionExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemSessionExample() {
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
     * 会员登录密码及状态表
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
        public Criteria andPasswordIsNull() {
            addCriterion("PassWord is null");
            return (Criteria) this;
        }
        public Criteria andPasswordIsNotNull() {
            addCriterion("PassWord is not null");
            return (Criteria) this;
        }
        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PassWord =", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PassWord <>", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PassWord >", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PassWord >=", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordLessThan(String value) {
            addCriterion("PassWord <", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PassWord <=", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordLike(String value) {
            addCriterion("PassWord like", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordNotLike(String value) {
            addCriterion("PassWord not like", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PassWord in", values, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PassWord not in", values, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PassWord between", value1, value2, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PassWord not between", value1, value2, "password");
            return (Criteria) this;
        }
        public Criteria andSessionIsNull() {
            addCriterion("Session is null");
            return (Criteria) this;
        }
        public Criteria andSessionIsNotNull() {
            addCriterion("Session is not null");
            return (Criteria) this;
        }
        public Criteria andSessionEqualTo(String value) {
            addCriterion("Session =", value, "session");
            return (Criteria) this;
        }
        public Criteria andSessionNotEqualTo(String value) {
            addCriterion("Session <>", value, "session");
            return (Criteria) this;
        }
        public Criteria andSessionGreaterThan(String value) {
            addCriterion("Session >", value, "session");
            return (Criteria) this;
        }
        public Criteria andSessionGreaterThanOrEqualTo(String value) {
            addCriterion("Session >=", value, "session");
            return (Criteria) this;
        }
        public Criteria andSessionLessThan(String value) {
            addCriterion("Session <", value, "session");
            return (Criteria) this;
        }
        public Criteria andSessionLessThanOrEqualTo(String value) {
            addCriterion("Session <=", value, "session");
            return (Criteria) this;
        }
        public Criteria andSessionLike(String value) {
            addCriterion("Session like", value, "session");
            return (Criteria) this;
        }
        public Criteria andSessionNotLike(String value) {
            addCriterion("Session not like", value, "session");
            return (Criteria) this;
        }
        public Criteria andSessionIn(List<String> values) {
            addCriterion("Session in", values, "session");
            return (Criteria) this;
        }
        public Criteria andSessionNotIn(List<String> values) {
            addCriterion("Session not in", values, "session");
            return (Criteria) this;
        }
        public Criteria andSessionBetween(String value1, String value2) {
            addCriterion("Session between", value1, value2, "session");
            return (Criteria) this;
        }
        public Criteria andSessionNotBetween(String value1, String value2) {
            addCriterion("Session not between", value1, value2, "session");
            return (Criteria) this;
        }
        public Criteria andCurtagIsNull() {
            addCriterion("curTag is null");
            return (Criteria) this;
        }
        public Criteria andCurtagIsNotNull() {
            addCriterion("curTag is not null");
            return (Criteria) this;
        }
        public Criteria andCurtagEqualTo(String value) {
            addCriterion("curTag =", value, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagNotEqualTo(String value) {
            addCriterion("curTag <>", value, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagGreaterThan(String value) {
            addCriterion("curTag >", value, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagGreaterThanOrEqualTo(String value) {
            addCriterion("curTag >=", value, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagLessThan(String value) {
            addCriterion("curTag <", value, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagLessThanOrEqualTo(String value) {
            addCriterion("curTag <=", value, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagLike(String value) {
            addCriterion("curTag like", value, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagNotLike(String value) {
            addCriterion("curTag not like", value, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagIn(List<String> values) {
            addCriterion("curTag in", values, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagNotIn(List<String> values) {
            addCriterion("curTag not in", values, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagBetween(String value1, String value2) {
            addCriterion("curTag between", value1, value2, "curtag");
            return (Criteria) this;
        }
        public Criteria andCurtagNotBetween(String value1, String value2) {
            addCriterion("curTag not between", value1, value2, "curtag");
            return (Criteria) this;
        }
        public Criteria andLogintimeIsNull() {
            addCriterion("LoginTime is null");
            return (Criteria) this;
        }
        public Criteria andLogintimeIsNotNull() {
            addCriterion("LoginTime is not null");
            return (Criteria) this;
        }
        public Criteria andLogintimeEqualTo(Date value) {
            addCriterion("LoginTime =", value, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeNotEqualTo(Date value) {
            addCriterion("LoginTime <>", value, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeGreaterThan(Date value) {
            addCriterion("LoginTime >", value, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LoginTime >=", value, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeLessThan(Date value) {
            addCriterion("LoginTime <", value, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeLessThanOrEqualTo(Date value) {
            addCriterion("LoginTime <=", value, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeIn(List<Date> values) {
            addCriterion("LoginTime in", values, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeNotIn(List<Date> values) {
            addCriterion("LoginTime not in", values, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeBetween(Date value1, Date value2) {
            addCriterion("LoginTime between", value1, value2, "logintime");
            return (Criteria) this;
        }
        public Criteria andLogintimeNotBetween(Date value1, Date value2) {
            addCriterion("LoginTime not between", value1, value2, "logintime");
            return (Criteria) this;
        }
        public Criteria andDeviceIsNull() {
            addCriterion("Device is null");
            return (Criteria) this;
        }
        public Criteria andDeviceIsNotNull() {
            addCriterion("Device is not null");
            return (Criteria) this;
        }
        public Criteria andDeviceEqualTo(String value) {
            addCriterion("Device =", value, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceNotEqualTo(String value) {
            addCriterion("Device <>", value, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceGreaterThan(String value) {
            addCriterion("Device >", value, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("Device >=", value, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceLessThan(String value) {
            addCriterion("Device <", value, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceLessThanOrEqualTo(String value) {
            addCriterion("Device <=", value, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceLike(String value) {
            addCriterion("Device like", value, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceNotLike(String value) {
            addCriterion("Device not like", value, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceIn(List<String> values) {
            addCriterion("Device in", values, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceNotIn(List<String> values) {
            addCriterion("Device not in", values, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceBetween(String value1, String value2) {
            addCriterion("Device between", value1, value2, "device");
            return (Criteria) this;
        }
        public Criteria andDeviceNotBetween(String value1, String value2) {
            addCriterion("Device not between", value1, value2, "device");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员登录密码及状态表
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