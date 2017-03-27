/*
 * MemberMovmentExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-25 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberMovmentExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemberMovmentExample() {
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
     * [3.0]会员转移
     * 
     * @author ${user}
     * @version 1.0 2016-11-25
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
        public Criteria andMMovementIDIsNull() {
            addCriterion("MMovementID is null");
            return (Criteria) this;
        }
        public Criteria andMMovementIDIsNotNull() {
            addCriterion("MMovementID is not null");
            return (Criteria) this;
        }
        public Criteria andMMovementIDEqualTo(Integer value) {
            addCriterion("MMovementID =", value, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDNotEqualTo(Integer value) {
            addCriterion("MMovementID <>", value, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDGreaterThan(Integer value) {
            addCriterion("MMovementID >", value, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MMovementID >=", value, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDLessThan(Integer value) {
            addCriterion("MMovementID <", value, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDLessThanOrEqualTo(Integer value) {
            addCriterion("MMovementID <=", value, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDIn(List<Integer> values) {
            addCriterion("MMovementID in", values, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDNotIn(List<Integer> values) {
            addCriterion("MMovementID not in", values, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDBetween(Integer value1, Integer value2) {
            addCriterion("MMovementID between", value1, value2, "MMovementID");
            return (Criteria) this;
        }
        public Criteria andMMovementIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MMovementID not between", value1, value2, "MMovementID");
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
        public Criteria andOutOrgIDIsNull() {
            addCriterion("OutOrgID is null");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDIsNotNull() {
            addCriterion("OutOrgID is not null");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDEqualTo(Integer value) {
            addCriterion("OutOrgID =", value, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDNotEqualTo(Integer value) {
            addCriterion("OutOrgID <>", value, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDGreaterThan(Integer value) {
            addCriterion("OutOrgID >", value, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("OutOrgID >=", value, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDLessThan(Integer value) {
            addCriterion("OutOrgID <", value, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDLessThanOrEqualTo(Integer value) {
            addCriterion("OutOrgID <=", value, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDIn(List<Integer> values) {
            addCriterion("OutOrgID in", values, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDNotIn(List<Integer> values) {
            addCriterion("OutOrgID not in", values, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDBetween(Integer value1, Integer value2) {
            addCriterion("OutOrgID between", value1, value2, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutOrgIDNotBetween(Integer value1, Integer value2) {
            addCriterion("OutOrgID not between", value1, value2, "outOrgID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDIsNull() {
            addCriterion("OutDrID is null");
            return (Criteria) this;
        }
        public Criteria andOutDrIDIsNotNull() {
            addCriterion("OutDrID is not null");
            return (Criteria) this;
        }
        public Criteria andOutDrIDEqualTo(Integer value) {
            addCriterion("OutDrID =", value, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDNotEqualTo(Integer value) {
            addCriterion("OutDrID <>", value, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDGreaterThan(Integer value) {
            addCriterion("OutDrID >", value, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("OutDrID >=", value, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDLessThan(Integer value) {
            addCriterion("OutDrID <", value, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDLessThanOrEqualTo(Integer value) {
            addCriterion("OutDrID <=", value, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDIn(List<Integer> values) {
            addCriterion("OutDrID in", values, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDNotIn(List<Integer> values) {
            addCriterion("OutDrID not in", values, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDBetween(Integer value1, Integer value2) {
            addCriterion("OutDrID between", value1, value2, "outDrID");
            return (Criteria) this;
        }
        public Criteria andOutDrIDNotBetween(Integer value1, Integer value2) {
            addCriterion("OutDrID not between", value1, value2, "outDrID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDIsNull() {
            addCriterion("InOrgID is null");
            return (Criteria) this;
        }
        public Criteria andInOrgIDIsNotNull() {
            addCriterion("InOrgID is not null");
            return (Criteria) this;
        }
        public Criteria andInOrgIDEqualTo(Integer value) {
            addCriterion("InOrgID =", value, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDNotEqualTo(Integer value) {
            addCriterion("InOrgID <>", value, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDGreaterThan(Integer value) {
            addCriterion("InOrgID >", value, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("InOrgID >=", value, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDLessThan(Integer value) {
            addCriterion("InOrgID <", value, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDLessThanOrEqualTo(Integer value) {
            addCriterion("InOrgID <=", value, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDIn(List<Integer> values) {
            addCriterion("InOrgID in", values, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDNotIn(List<Integer> values) {
            addCriterion("InOrgID not in", values, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDBetween(Integer value1, Integer value2) {
            addCriterion("InOrgID between", value1, value2, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInOrgIDNotBetween(Integer value1, Integer value2) {
            addCriterion("InOrgID not between", value1, value2, "inOrgID");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListIsNull() {
            addCriterion("InMemGrpidList is null");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListIsNotNull() {
            addCriterion("InMemGrpidList is not null");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListEqualTo(String value) {
            addCriterion("InMemGrpidList =", value, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListNotEqualTo(String value) {
            addCriterion("InMemGrpidList <>", value, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListGreaterThan(String value) {
            addCriterion("InMemGrpidList >", value, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListGreaterThanOrEqualTo(String value) {
            addCriterion("InMemGrpidList >=", value, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListLessThan(String value) {
            addCriterion("InMemGrpidList <", value, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListLessThanOrEqualTo(String value) {
            addCriterion("InMemGrpidList <=", value, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListLike(String value) {
            addCriterion("InMemGrpidList like", value, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListNotLike(String value) {
            addCriterion("InMemGrpidList not like", value, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListIn(List<String> values) {
            addCriterion("InMemGrpidList in", values, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListNotIn(List<String> values) {
            addCriterion("InMemGrpidList not in", values, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListBetween(String value1, String value2) {
            addCriterion("InMemGrpidList between", value1, value2, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andInMemGrpidListNotBetween(String value1, String value2) {
            addCriterion("InMemGrpidList not between", value1, value2, "inMemGrpidList");
            return (Criteria) this;
        }
        public Criteria andMoveStatusIsNull() {
            addCriterion("MoveStatus is null");
            return (Criteria) this;
        }
        public Criteria andMoveStatusIsNotNull() {
            addCriterion("MoveStatus is not null");
            return (Criteria) this;
        }
        public Criteria andMoveStatusEqualTo(Byte value) {
            addCriterion("MoveStatus =", value, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusNotEqualTo(Byte value) {
            addCriterion("MoveStatus <>", value, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusGreaterThan(Byte value) {
            addCriterion("MoveStatus >", value, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("MoveStatus >=", value, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusLessThan(Byte value) {
            addCriterion("MoveStatus <", value, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusLessThanOrEqualTo(Byte value) {
            addCriterion("MoveStatus <=", value, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusIn(List<Byte> values) {
            addCriterion("MoveStatus in", values, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusNotIn(List<Byte> values) {
            addCriterion("MoveStatus not in", values, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusBetween(Byte value1, Byte value2) {
            addCriterion("MoveStatus between", value1, value2, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andMoveStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("MoveStatus not between", value1, value2, "moveStatus");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeIsNull() {
            addCriterion("ConfirmTime is null");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeIsNotNull() {
            addCriterion("ConfirmTime is not null");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeEqualTo(Date value) {
            addCriterion("ConfirmTime =", value, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeNotEqualTo(Date value) {
            addCriterion("ConfirmTime <>", value, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeGreaterThan(Date value) {
            addCriterion("ConfirmTime >", value, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ConfirmTime >=", value, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeLessThan(Date value) {
            addCriterion("ConfirmTime <", value, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("ConfirmTime <=", value, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeIn(List<Date> values) {
            addCriterion("ConfirmTime in", values, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeNotIn(List<Date> values) {
            addCriterion("ConfirmTime not in", values, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeBetween(Date value1, Date value2) {
            addCriterion("ConfirmTime between", value1, value2, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andConfirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("ConfirmTime not between", value1, value2, "confirmTime");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonIsNull() {
            addCriterion("RefuseReason is null");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonIsNotNull() {
            addCriterion("RefuseReason is not null");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonEqualTo(String value) {
            addCriterion("RefuseReason =", value, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonNotEqualTo(String value) {
            addCriterion("RefuseReason <>", value, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonGreaterThan(String value) {
            addCriterion("RefuseReason >", value, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("RefuseReason >=", value, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonLessThan(String value) {
            addCriterion("RefuseReason <", value, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonLessThanOrEqualTo(String value) {
            addCriterion("RefuseReason <=", value, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonLike(String value) {
            addCriterion("RefuseReason like", value, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonNotLike(String value) {
            addCriterion("RefuseReason not like", value, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonIn(List<String> values) {
            addCriterion("RefuseReason in", values, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonNotIn(List<String> values) {
            addCriterion("RefuseReason not in", values, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonBetween(String value1, String value2) {
            addCriterion("RefuseReason between", value1, value2, "refuseReason");
            return (Criteria) this;
        }
        public Criteria andRefuseReasonNotBetween(String value1, String value2) {
            addCriterion("RefuseReason not between", value1, value2, "refuseReason");
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
     * [3.0]会员转移
     * 
     * @author ${user}
     * @version 1.0 2016-11-25
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