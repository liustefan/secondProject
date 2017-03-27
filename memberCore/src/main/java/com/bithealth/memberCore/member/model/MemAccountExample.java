/*
 * MemAccountExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemAccountExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemAccountExample() {
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
     * 会员账号表
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
        public Criteria andLogidIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogidIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogidEqualTo(Integer value) {
            addCriterion("LogID =", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotEqualTo(Integer value) {
            addCriterion("LogID <>", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidGreaterThan(Integer value) {
            addCriterion("LogID >", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LogID >=", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidLessThan(Integer value) {
            addCriterion("LogID <", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidLessThanOrEqualTo(Integer value) {
            addCriterion("LogID <=", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidIn(List<Integer> values) {
            addCriterion("LogID in", values, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotIn(List<Integer> values) {
            addCriterion("LogID not in", values, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidBetween(Integer value1, Integer value2) {
            addCriterion("LogID between", value1, value2, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotBetween(Integer value1, Integer value2) {
            addCriterion("LogID not between", value1, value2, "logid");
            return (Criteria) this;
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
        public Criteria andAccountIsNull() {
            addCriterion("Account is null");
            return (Criteria) this;
        }
        public Criteria andAccountIsNotNull() {
            addCriterion("Account is not null");
            return (Criteria) this;
        }
        public Criteria andAccountEqualTo(String value) {
            addCriterion("Account =", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("Account <>", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountGreaterThan(String value) {
            addCriterion("Account >", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("Account >=", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountLessThan(String value) {
            addCriterion("Account <", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("Account <=", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountLike(String value) {
            addCriterion("Account like", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountNotLike(String value) {
            addCriterion("Account not like", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountIn(List<String> values) {
            addCriterion("Account in", values, "account");
            return (Criteria) this;
        }
        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("Account not in", values, "account");
            return (Criteria) this;
        }
        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("Account between", value1, value2, "account");
            return (Criteria) this;
        }
        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("Account not between", value1, value2, "account");
            return (Criteria) this;
        }
        public Criteria andAccounttypeIsNull() {
            addCriterion("AccountType is null");
            return (Criteria) this;
        }
        public Criteria andAccounttypeIsNotNull() {
            addCriterion("AccountType is not null");
            return (Criteria) this;
        }
        public Criteria andAccounttypeEqualTo(Byte value) {
            addCriterion("AccountType =", value, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeNotEqualTo(Byte value) {
            addCriterion("AccountType <>", value, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeGreaterThan(Byte value) {
            addCriterion("AccountType >", value, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("AccountType >=", value, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeLessThan(Byte value) {
            addCriterion("AccountType <", value, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeLessThanOrEqualTo(Byte value) {
            addCriterion("AccountType <=", value, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeIn(List<Byte> values) {
            addCriterion("AccountType in", values, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeNotIn(List<Byte> values) {
            addCriterion("AccountType not in", values, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeBetween(Byte value1, Byte value2) {
            addCriterion("AccountType between", value1, value2, "accounttype");
            return (Criteria) this;
        }
        public Criteria andAccounttypeNotBetween(Byte value1, Byte value2) {
            addCriterion("AccountType not between", value1, value2, "accounttype");
            return (Criteria) this;
        }
        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }
        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }
        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLessThan(Byte value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }
        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }
        public Criteria andCreatedridIsNull() {
            addCriterion("CreateDrID is null");
            return (Criteria) this;
        }
        public Criteria andCreatedridIsNotNull() {
            addCriterion("CreateDrID is not null");
            return (Criteria) this;
        }
        public Criteria andCreatedridEqualTo(Integer value) {
            addCriterion("CreateDrID =", value, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridNotEqualTo(Integer value) {
            addCriterion("CreateDrID <>", value, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridGreaterThan(Integer value) {
            addCriterion("CreateDrID >", value, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateDrID >=", value, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridLessThan(Integer value) {
            addCriterion("CreateDrID <", value, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridLessThanOrEqualTo(Integer value) {
            addCriterion("CreateDrID <=", value, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridIn(List<Integer> values) {
            addCriterion("CreateDrID in", values, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridNotIn(List<Integer> values) {
            addCriterion("CreateDrID not in", values, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridBetween(Integer value1, Integer value2) {
            addCriterion("CreateDrID between", value1, value2, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatedridNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateDrID not between", value1, value2, "createdrid");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }
        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andUpdatedridIsNull() {
            addCriterion("UpdateDrID is null");
            return (Criteria) this;
        }
        public Criteria andUpdatedridIsNotNull() {
            addCriterion("UpdateDrID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdatedridEqualTo(Integer value) {
            addCriterion("UpdateDrID =", value, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridNotEqualTo(Integer value) {
            addCriterion("UpdateDrID <>", value, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridGreaterThan(Integer value) {
            addCriterion("UpdateDrID >", value, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateDrID >=", value, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridLessThan(Integer value) {
            addCriterion("UpdateDrID <", value, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateDrID <=", value, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridIn(List<Integer> values) {
            addCriterion("UpdateDrID in", values, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridNotIn(List<Integer> values) {
            addCriterion("UpdateDrID not in", values, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridBetween(Integer value1, Integer value2) {
            addCriterion("UpdateDrID between", value1, value2, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatedridNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateDrID not between", value1, value2, "updatedrid");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员账号表
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