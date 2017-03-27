/*
 * TransferTreatmentExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferTreatmentExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public TransferTreatmentExample() {
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
     * [3.0]转诊
     * 
     * @author ${user}
     * @version 1.0 2016-11-28
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
                return;
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andTtreatmentidIsNull() {
            addCriterion("TTreatmentID is null");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidIsNotNull() {
            addCriterion("TTreatmentID is not null");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidEqualTo(Integer value) {
            addCriterion("TTreatmentID =", value, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidNotEqualTo(Integer value) {
            addCriterion("TTreatmentID <>", value, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidGreaterThan(Integer value) {
            addCriterion("TTreatmentID >", value, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TTreatmentID >=", value, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidLessThan(Integer value) {
            addCriterion("TTreatmentID <", value, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidLessThanOrEqualTo(Integer value) {
            addCriterion("TTreatmentID <=", value, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidIn(List<Integer> values) {
            addCriterion("TTreatmentID in", values, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidNotIn(List<Integer> values) {
            addCriterion("TTreatmentID not in", values, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidBetween(Integer value1, Integer value2) {
            addCriterion("TTreatmentID between", value1, value2, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andTtreatmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("TTreatmentID not between", value1, value2, "ttreatmentid");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNull() {
            addCriterion("MemberID is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("MemberID is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("MemberID =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("MemberID <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("MemberID >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MemberID >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("MemberID <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("MemberID <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("MemberID in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("MemberID not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("MemberID between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("MemberID not between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andOrganddeptIsNull() {
            addCriterion("OrgAndDept is null");
            return (Criteria) this;
        }
        public Criteria andOrganddeptIsNotNull() {
            addCriterion("OrgAndDept is not null");
            return (Criteria) this;
        }
        public Criteria andOrganddeptEqualTo(String value) {
            addCriterion("OrgAndDept =", value, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptNotEqualTo(String value) {
            addCriterion("OrgAndDept <>", value, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptGreaterThan(String value) {
            addCriterion("OrgAndDept >", value, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptGreaterThanOrEqualTo(String value) {
            addCriterion("OrgAndDept >=", value, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptLessThan(String value) {
            addCriterion("OrgAndDept <", value, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptLessThanOrEqualTo(String value) {
            addCriterion("OrgAndDept <=", value, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptLike(String value) {
            addCriterion("OrgAndDept like", value, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptNotLike(String value) {
            addCriterion("OrgAndDept not like", value, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptIn(List<String> values) {
            addCriterion("OrgAndDept in", values, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptNotIn(List<String> values) {
            addCriterion("OrgAndDept not in", values, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptBetween(String value1, String value2) {
            addCriterion("OrgAndDept between", value1, value2, "organddept");
            return (Criteria) this;
        }
        public Criteria andOrganddeptNotBetween(String value1, String value2) {
            addCriterion("OrgAndDept not between", value1, value2, "organddept");
            return (Criteria) this;
        }
        public Criteria andReasonIsNull() {
            addCriterion("Reason is null");
            return (Criteria) this;
        }
        public Criteria andReasonIsNotNull() {
            addCriterion("Reason is not null");
            return (Criteria) this;
        }
        public Criteria andReasonEqualTo(String value) {
            addCriterion("Reason =", value, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("Reason <>", value, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonGreaterThan(String value) {
            addCriterion("Reason >", value, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("Reason >=", value, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonLessThan(String value) {
            addCriterion("Reason <", value, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("Reason <=", value, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonLike(String value) {
            addCriterion("Reason like", value, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonNotLike(String value) {
            addCriterion("Reason not like", value, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonIn(List<String> values) {
            addCriterion("Reason in", values, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("Reason not in", values, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("Reason between", value1, value2, "reason");
            return (Criteria) this;
        }
        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("Reason not between", value1, value2, "reason");
            return (Criteria) this;
        }
        public Criteria andResultIsNull() {
            addCriterion("Result is null");
            return (Criteria) this;
        }
        public Criteria andResultIsNotNull() {
            addCriterion("Result is not null");
            return (Criteria) this;
        }
        public Criteria andResultEqualTo(String value) {
            addCriterion("Result =", value, "result");
            return (Criteria) this;
        }
        public Criteria andResultNotEqualTo(String value) {
            addCriterion("Result <>", value, "result");
            return (Criteria) this;
        }
        public Criteria andResultGreaterThan(String value) {
            addCriterion("Result >", value, "result");
            return (Criteria) this;
        }
        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("Result >=", value, "result");
            return (Criteria) this;
        }
        public Criteria andResultLessThan(String value) {
            addCriterion("Result <", value, "result");
            return (Criteria) this;
        }
        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("Result <=", value, "result");
            return (Criteria) this;
        }
        public Criteria andResultLike(String value) {
            addCriterion("Result like", value, "result");
            return (Criteria) this;
        }
        public Criteria andResultNotLike(String value) {
            addCriterion("Result not like", value, "result");
            return (Criteria) this;
        }
        public Criteria andResultIn(List<String> values) {
            addCriterion("Result in", values, "result");
            return (Criteria) this;
        }
        public Criteria andResultNotIn(List<String> values) {
            addCriterion("Result not in", values, "result");
            return (Criteria) this;
        }
        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("Result between", value1, value2, "result");
            return (Criteria) this;
        }
        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("Result not between", value1, value2, "result");
            return (Criteria) this;
        }
        public Criteria andTreattimeIsNull() {
            addCriterion("TreatTime is null");
            return (Criteria) this;
        }
        public Criteria andTreattimeIsNotNull() {
            addCriterion("TreatTime is not null");
            return (Criteria) this;
        }
        public Criteria andTreattimeEqualTo(Date value) {
            addCriterion("TreatTime =", value, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeNotEqualTo(Date value) {
            addCriterion("TreatTime <>", value, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeGreaterThan(Date value) {
            addCriterion("TreatTime >", value, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TreatTime >=", value, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeLessThan(Date value) {
            addCriterion("TreatTime <", value, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeLessThanOrEqualTo(Date value) {
            addCriterion("TreatTime <=", value, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeIn(List<Date> values) {
            addCriterion("TreatTime in", values, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeNotIn(List<Date> values) {
            addCriterion("TreatTime not in", values, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeBetween(Date value1, Date value2) {
            addCriterion("TreatTime between", value1, value2, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreattimeNotBetween(Date value1, Date value2) {
            addCriterion("TreatTime not between", value1, value2, "treattime");
            return (Criteria) this;
        }
        public Criteria andTreatstatusIsNull() {
            addCriterion("TreatStatus is null");
            return (Criteria) this;
        }
        public Criteria andTreatstatusIsNotNull() {
            addCriterion("TreatStatus is not null");
            return (Criteria) this;
        }
        public Criteria andTreatstatusEqualTo(Byte value) {
            addCriterion("TreatStatus =", value, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusNotEqualTo(Byte value) {
            addCriterion("TreatStatus <>", value, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusGreaterThan(Byte value) {
            addCriterion("TreatStatus >", value, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("TreatStatus >=", value, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusLessThan(Byte value) {
            addCriterion("TreatStatus <", value, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusLessThanOrEqualTo(Byte value) {
            addCriterion("TreatStatus <=", value, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusIn(List<Byte> values) {
            addCriterion("TreatStatus in", values, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusNotIn(List<Byte> values) {
            addCriterion("TreatStatus not in", values, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusBetween(Byte value1, Byte value2) {
            addCriterion("TreatStatus between", value1, value2, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andTreatstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("TreatStatus not between", value1, value2, "treatstatus");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNull() {
            addCriterion("CreateID is null");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNotNull() {
            addCriterion("CreateID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateidEqualTo(Integer value) {
            addCriterion("CreateID =", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotEqualTo(Integer value) {
            addCriterion("CreateID <>", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThan(Integer value) {
            addCriterion("CreateID >", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateID >=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThan(Integer value) {
            addCriterion("CreateID <", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThanOrEqualTo(Integer value) {
            addCriterion("CreateID <=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidIn(List<Integer> values) {
            addCriterion("CreateID in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotIn(List<Integer> values) {
            addCriterion("CreateID not in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidBetween(Integer value1, Integer value2) {
            addCriterion("CreateID between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateID not between", value1, value2, "createid");
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
        public Criteria andUpdateidIsNull() {
            addCriterion("UpdateID is null");
            return (Criteria) this;
        }
        public Criteria andUpdateidIsNotNull() {
            addCriterion("UpdateID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateidEqualTo(Integer value) {
            addCriterion("UpdateID =", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotEqualTo(Integer value) {
            addCriterion("UpdateID <>", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidGreaterThan(Integer value) {
            addCriterion("UpdateID >", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateID >=", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidLessThan(Integer value) {
            addCriterion("UpdateID <", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateID <=", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidIn(List<Integer> values) {
            addCriterion("UpdateID in", values, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotIn(List<Integer> values) {
            addCriterion("UpdateID not in", values, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID between", value1, value2, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID not between", value1, value2, "updateid");
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
     * [3.0]转诊
     * 
     * @author ${user}
     * @version 1.0 2016-11-28
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