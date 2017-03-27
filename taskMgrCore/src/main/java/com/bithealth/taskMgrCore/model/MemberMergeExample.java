/*
 * MemberMergeExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-21 Created
 */
package com.bithealth.taskMgrCore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberMergeExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemberMergeExample() {
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
     * [3.0]日志_同步
     * 
     * @author ${user}
     * @version 1.0 2016-12-21
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
        public Criteria andLogIDIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogIDIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogIDEqualTo(Long value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Long value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Long value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Long value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Long value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Long value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Long> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Long> values) {
            addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Long value1, Long value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Long value1, Long value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andModuleTypeIsNull() {
            addCriterion("ModuleType is null");
            return (Criteria) this;
        }
        public Criteria andModuleTypeIsNotNull() {
            addCriterion("ModuleType is not null");
            return (Criteria) this;
        }
        public Criteria andModuleTypeEqualTo(Byte value) {
            addCriterion("ModuleType =", value, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeNotEqualTo(Byte value) {
            addCriterion("ModuleType <>", value, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeGreaterThan(Byte value) {
            addCriterion("ModuleType >", value, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ModuleType >=", value, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeLessThan(Byte value) {
            addCriterion("ModuleType <", value, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeLessThanOrEqualTo(Byte value) {
            addCriterion("ModuleType <=", value, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeIn(List<Byte> values) {
            addCriterion("ModuleType in", values, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeNotIn(List<Byte> values) {
            addCriterion("ModuleType not in", values, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeBetween(Byte value1, Byte value2) {
            addCriterion("ModuleType between", value1, value2, "moduleType");
            return (Criteria) this;
        }
        public Criteria andModuleTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ModuleType not between", value1, value2, "moduleType");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDIsNull() {
            addCriterion("SourceServiceID is null");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDIsNotNull() {
            addCriterion("SourceServiceID is not null");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDEqualTo(Integer value) {
            addCriterion("SourceServiceID =", value, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDNotEqualTo(Integer value) {
            addCriterion("SourceServiceID <>", value, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDGreaterThan(Integer value) {
            addCriterion("SourceServiceID >", value, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("SourceServiceID >=", value, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDLessThan(Integer value) {
            addCriterion("SourceServiceID <", value, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDLessThanOrEqualTo(Integer value) {
            addCriterion("SourceServiceID <=", value, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDIn(List<Integer> values) {
            addCriterion("SourceServiceID in", values, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDNotIn(List<Integer> values) {
            addCriterion("SourceServiceID not in", values, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDBetween(Integer value1, Integer value2) {
            addCriterion("SourceServiceID between", value1, value2, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceServiceIDNotBetween(Integer value1, Integer value2) {
            addCriterion("SourceServiceID not between", value1, value2, "sourceServiceID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDIsNull() {
            addCriterion("SourceMemberID is null");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDIsNotNull() {
            addCriterion("SourceMemberID is not null");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDEqualTo(String value) {
            addCriterion("SourceMemberID =", value, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDNotEqualTo(String value) {
            addCriterion("SourceMemberID <>", value, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDGreaterThan(String value) {
            addCriterion("SourceMemberID >", value, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDGreaterThanOrEqualTo(String value) {
            addCriterion("SourceMemberID >=", value, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDLessThan(String value) {
            addCriterion("SourceMemberID <", value, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDLessThanOrEqualTo(String value) {
            addCriterion("SourceMemberID <=", value, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDLike(String value) {
            addCriterion("SourceMemberID like", value, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDNotLike(String value) {
            addCriterion("SourceMemberID not like", value, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDIn(List<String> values) {
            addCriterion("SourceMemberID in", values, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDNotIn(List<String> values) {
            addCriterion("SourceMemberID not in", values, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDBetween(String value1, String value2) {
            addCriterion("SourceMemberID between", value1, value2, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andSourceMemberIDNotBetween(String value1, String value2) {
            addCriterion("SourceMemberID not between", value1, value2, "sourceMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDIsNull() {
            addCriterion("TargetServiceID is null");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDIsNotNull() {
            addCriterion("TargetServiceID is not null");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDEqualTo(Integer value) {
            addCriterion("TargetServiceID =", value, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDNotEqualTo(Integer value) {
            addCriterion("TargetServiceID <>", value, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDGreaterThan(Integer value) {
            addCriterion("TargetServiceID >", value, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("TargetServiceID >=", value, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDLessThan(Integer value) {
            addCriterion("TargetServiceID <", value, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDLessThanOrEqualTo(Integer value) {
            addCriterion("TargetServiceID <=", value, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDIn(List<Integer> values) {
            addCriterion("TargetServiceID in", values, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDNotIn(List<Integer> values) {
            addCriterion("TargetServiceID not in", values, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDBetween(Integer value1, Integer value2) {
            addCriterion("TargetServiceID between", value1, value2, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetServiceIDNotBetween(Integer value1, Integer value2) {
            addCriterion("TargetServiceID not between", value1, value2, "targetServiceID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDIsNull() {
            addCriterion("TargetMemberID is null");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDIsNotNull() {
            addCriterion("TargetMemberID is not null");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDEqualTo(String value) {
            addCriterion("TargetMemberID =", value, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDNotEqualTo(String value) {
            addCriterion("TargetMemberID <>", value, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDGreaterThan(String value) {
            addCriterion("TargetMemberID >", value, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDGreaterThanOrEqualTo(String value) {
            addCriterion("TargetMemberID >=", value, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDLessThan(String value) {
            addCriterion("TargetMemberID <", value, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDLessThanOrEqualTo(String value) {
            addCriterion("TargetMemberID <=", value, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDLike(String value) {
            addCriterion("TargetMemberID like", value, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDNotLike(String value) {
            addCriterion("TargetMemberID not like", value, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDIn(List<String> values) {
            addCriterion("TargetMemberID in", values, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDNotIn(List<String> values) {
            addCriterion("TargetMemberID not in", values, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDBetween(String value1, String value2) {
            addCriterion("TargetMemberID between", value1, value2, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andTargetMemberIDNotBetween(String value1, String value2) {
            addCriterion("TargetMemberID not between", value1, value2, "targetMemberID");
            return (Criteria) this;
        }
        public Criteria andSyncStatusIsNull() {
            addCriterion("SyncStatus is null");
            return (Criteria) this;
        }
        public Criteria andSyncStatusIsNotNull() {
            addCriterion("SyncStatus is not null");
            return (Criteria) this;
        }
        public Criteria andSyncStatusEqualTo(Byte value) {
            addCriterion("SyncStatus =", value, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusNotEqualTo(Byte value) {
            addCriterion("SyncStatus <>", value, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusGreaterThan(Byte value) {
            addCriterion("SyncStatus >", value, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("SyncStatus >=", value, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusLessThan(Byte value) {
            addCriterion("SyncStatus <", value, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusLessThanOrEqualTo(Byte value) {
            addCriterion("SyncStatus <=", value, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusIn(List<Byte> values) {
            addCriterion("SyncStatus in", values, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusNotIn(List<Byte> values) {
            addCriterion("SyncStatus not in", values, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusBetween(Byte value1, Byte value2) {
            addCriterion("SyncStatus between", value1, value2, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("SyncStatus not between", value1, value2, "syncStatus");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeIsNull() {
            addCriterion("SyncSTime is null");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeIsNotNull() {
            addCriterion("SyncSTime is not null");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeEqualTo(Date value) {
            addCriterion("SyncSTime =", value, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeNotEqualTo(Date value) {
            addCriterion("SyncSTime <>", value, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeGreaterThan(Date value) {
            addCriterion("SyncSTime >", value, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SyncSTime >=", value, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeLessThan(Date value) {
            addCriterion("SyncSTime <", value, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeLessThanOrEqualTo(Date value) {
            addCriterion("SyncSTime <=", value, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeIn(List<Date> values) {
            addCriterion("SyncSTime in", values, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeNotIn(List<Date> values) {
            addCriterion("SyncSTime not in", values, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeBetween(Date value1, Date value2) {
            addCriterion("SyncSTime between", value1, value2, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncSTimeNotBetween(Date value1, Date value2) {
            addCriterion("SyncSTime not between", value1, value2, "syncSTime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeIsNull() {
            addCriterion("SyncETime is null");
            return (Criteria) this;
        }
        public Criteria andSyncETimeIsNotNull() {
            addCriterion("SyncETime is not null");
            return (Criteria) this;
        }
        public Criteria andSyncETimeEqualTo(Date value) {
            addCriterion("SyncETime =", value, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeNotEqualTo(Date value) {
            addCriterion("SyncETime <>", value, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeGreaterThan(Date value) {
            addCriterion("SyncETime >", value, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SyncETime >=", value, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeLessThan(Date value) {
            addCriterion("SyncETime <", value, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeLessThanOrEqualTo(Date value) {
            addCriterion("SyncETime <=", value, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeIn(List<Date> values) {
            addCriterion("SyncETime in", values, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeNotIn(List<Date> values) {
            addCriterion("SyncETime not in", values, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeBetween(Date value1, Date value2) {
            addCriterion("SyncETime between", value1, value2, "syncETime");
            return (Criteria) this;
        }
        public Criteria andSyncETimeNotBetween(Date value1, Date value2) {
            addCriterion("SyncETime not between", value1, value2, "syncETime");
            return (Criteria) this;
        }
        public Criteria andFailReasonIsNull() {
            addCriterion("FailReason is null");
            return (Criteria) this;
        }
        public Criteria andFailReasonIsNotNull() {
            addCriterion("FailReason is not null");
            return (Criteria) this;
        }
        public Criteria andFailReasonEqualTo(String value) {
            addCriterion("FailReason =", value, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonNotEqualTo(String value) {
            addCriterion("FailReason <>", value, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonGreaterThan(String value) {
            addCriterion("FailReason >", value, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonGreaterThanOrEqualTo(String value) {
            addCriterion("FailReason >=", value, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonLessThan(String value) {
            addCriterion("FailReason <", value, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonLessThanOrEqualTo(String value) {
            addCriterion("FailReason <=", value, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonLike(String value) {
            addCriterion("FailReason like", value, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonNotLike(String value) {
            addCriterion("FailReason not like", value, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonIn(List<String> values) {
            addCriterion("FailReason in", values, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonNotIn(List<String> values) {
            addCriterion("FailReason not in", values, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonBetween(String value1, String value2) {
            addCriterion("FailReason between", value1, value2, "failReason");
            return (Criteria) this;
        }
        public Criteria andFailReasonNotBetween(String value1, String value2) {
            addCriterion("FailReason not between", value1, value2, "failReason");
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
     * [3.0]日志_同步
     * 
     * @author ${user}
     * @version 1.0 2016-12-21
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