/*
 * ManageschemeExecExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bithealth.healthCore.enmu.PersonManageschemeEnum;

public class ManageschemeExecExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ManageschemeExecExample() {
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
     * [3.0]管理方案_个人执行
     * 
     * @author ${user}
     * @version 1.0 2016-12-08
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
        public Criteria andMSExecIDIsNull() {
            addCriterion("MSExecID is null");
            return (Criteria) this;
        }
        public Criteria andMSExecIDIsNotNull() {
            addCriterion("MSExecID is not null");
            return (Criteria) this;
        }
        public Criteria andMSExecIDEqualTo(Long value) {
            addCriterion("MSExecID =", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDNotEqualTo(Long value) {
            addCriterion("MSExecID <>", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDGreaterThan(Long value) {
            addCriterion("MSExecID >", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDGreaterThanOrEqualTo(Long value) {
            addCriterion("MSExecID >=", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDLessThan(Long value) {
            addCriterion("MSExecID <", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDLessThanOrEqualTo(Long value) {
            addCriterion("MSExecID <=", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDIn(List<Long> values) {
            addCriterion("MSExecID in", values, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDNotIn(List<Long> values) {
            addCriterion("MSExecID not in", values, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDBetween(Long value1, Long value2) {
            addCriterion("MSExecID between", value1, value2, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDNotBetween(Long value1, Long value2) {
            addCriterion("MSExecID not between", value1, value2, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDIsNull() {
            addCriterion("MSDesignID is null");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDIsNotNull() {
            addCriterion("MSDesignID is not null");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDEqualTo(Integer value) {
            addCriterion("MSDesignID =", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDNotEqualTo(Integer value) {
            addCriterion("MSDesignID <>", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDGreaterThan(Integer value) {
            addCriterion("MSDesignID >", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSDesignID >=", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDLessThan(Integer value) {
            addCriterion("MSDesignID <", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDLessThanOrEqualTo(Integer value) {
            addCriterion("MSDesignID <=", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDIn(List<Integer> values) {
            addCriterion("MSDesignID in", values, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDNotIn(List<Integer> values) {
            addCriterion("MSDesignID not in", values, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDBetween(Integer value1, Integer value2) {
            addCriterion("MSDesignID between", value1, value2, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MSDesignID not between", value1, value2, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMemberIDIsNull() {
            addCriterion("MemberID is null");
            return (Criteria) this;
        }
        public Criteria andMemberIDIsNotNull() {
            addCriterion("MemberID is not null");
            return (Criteria) this;
        }
        public Criteria andMemberIDEqualTo(Integer value) {
            addCriterion("MemberID =", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotEqualTo(Integer value) {
            addCriterion("MemberID <>", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDGreaterThan(Integer value) {
            addCriterion("MemberID >", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MemberID >=", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLessThan(Integer value) {
            addCriterion("MemberID <", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLessThanOrEqualTo(Integer value) {
            addCriterion("MemberID <=", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDIn(List<Integer> values) {
            addCriterion("MemberID in", values, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotIn(List<Integer> values) {
            addCriterion("MemberID not in", values, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDBetween(Integer value1, Integer value2) {
            addCriterion("MemberID between", value1, value2, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MemberID not between", value1, value2, "memberID");
            return (Criteria) this;
        }
        public Criteria andExecStatusIsNull() {
            addCriterion("ExecStatus is null");
            return (Criteria) this;
        }
        public Criteria andExecStatusIsNotNull() {
            addCriterion("ExecStatus is not null");
            return (Criteria) this;
        }
        public Criteria andExecStatusEqualTo(Byte value) {
            addCriterion("ExecStatus =", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusEqualTo(PersonManageschemeEnum status) {
        	if(status != null)
        		addCriterion("ExecStatus =", status.getCode(), "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusNotEqualTo(Byte value) {
            addCriterion("ExecStatus <>", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusGreaterThan(Byte value) {
            addCriterion("ExecStatus >", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("ExecStatus >=", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusLessThan(Byte value) {
            addCriterion("ExecStatus <", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusLessThanOrEqualTo(Byte value) {
            addCriterion("ExecStatus <=", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusIn(List<Byte> values) {
            addCriterion("ExecStatus in", values, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusNotIn(List<Byte> values) {
            addCriterion("ExecStatus not in", values, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusBetween(Byte value1, Byte value2) {
            addCriterion("ExecStatus between", value1, value2, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("ExecStatus not between", value1, value2, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonIsNull() {
            addCriterion("ExecOffReason is null");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonIsNotNull() {
            addCriterion("ExecOffReason is not null");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonEqualTo(String value) {
            addCriterion("ExecOffReason =", value, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonNotEqualTo(String value) {
            addCriterion("ExecOffReason <>", value, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonGreaterThan(String value) {
            addCriterion("ExecOffReason >", value, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonGreaterThanOrEqualTo(String value) {
            addCriterion("ExecOffReason >=", value, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonLessThan(String value) {
            addCriterion("ExecOffReason <", value, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonLessThanOrEqualTo(String value) {
            addCriterion("ExecOffReason <=", value, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonLike(String value) {
            addCriterion("ExecOffReason like", value, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonNotLike(String value) {
            addCriterion("ExecOffReason not like", value, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonIn(List<String> values) {
            addCriterion("ExecOffReason in", values, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonNotIn(List<String> values) {
            addCriterion("ExecOffReason not in", values, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonBetween(String value1, String value2) {
            addCriterion("ExecOffReason between", value1, value2, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andExecOffReasonNotBetween(String value1, String value2) {
            addCriterion("ExecOffReason not between", value1, value2, "execOffReason");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessIsNull() {
            addCriterion("MEPersonProcess is null");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessIsNotNull() {
            addCriterion("MEPersonProcess is not null");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessEqualTo(Byte value) {
            addCriterion("MEPersonProcess =", value, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessNotEqualTo(Byte value) {
            addCriterion("MEPersonProcess <>", value, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessGreaterThan(Byte value) {
            addCriterion("MEPersonProcess >", value, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessGreaterThanOrEqualTo(Byte value) {
            addCriterion("MEPersonProcess >=", value, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessLessThan(Byte value) {
            addCriterion("MEPersonProcess <", value, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessLessThanOrEqualTo(Byte value) {
            addCriterion("MEPersonProcess <=", value, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessIn(List<Byte> values) {
            addCriterion("MEPersonProcess in", values, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessNotIn(List<Byte> values) {
            addCriterion("MEPersonProcess not in", values, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessBetween(Byte value1, Byte value2) {
            addCriterion("MEPersonProcess between", value1, value2, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPersonProcessNotBetween(Byte value1, Byte value2) {
            addCriterion("MEPersonProcess not between", value1, value2, "MEPersonProcess");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeIsNull() {
            addCriterion("MEPTriggerTime is null");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeIsNotNull() {
            addCriterion("MEPTriggerTime is not null");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeEqualTo(Date value) {
            addCriterion("MEPTriggerTime =", value, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeNotEqualTo(Date value) {
            addCriterion("MEPTriggerTime <>", value, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeGreaterThan(Date value) {
            addCriterion("MEPTriggerTime >", value, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MEPTriggerTime >=", value, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeLessThan(Date value) {
            addCriterion("MEPTriggerTime <", value, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeLessThanOrEqualTo(Date value) {
            addCriterion("MEPTriggerTime <=", value, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeIn(List<Date> values) {
            addCriterion("MEPTriggerTime in", values, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeNotIn(List<Date> values) {
            addCriterion("MEPTriggerTime not in", values, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeBetween(Date value1, Date value2) {
            addCriterion("MEPTriggerTime between", value1, value2, "MEPTriggerTime");
            return (Criteria) this;
        }
        public Criteria andMEPTriggerTimeNotBetween(Date value1, Date value2) {
            addCriterion("MEPTriggerTime not between", value1, value2, "MEPTriggerTime");
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
     * [3.0]管理方案_个人执行
     * 
     * @author ${user}
     * @version 1.0 2016-12-08
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