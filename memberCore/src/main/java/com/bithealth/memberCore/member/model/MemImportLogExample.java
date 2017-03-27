/*
 * MemImportLogExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-14 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemImportLogExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemImportLogExample() {
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
     * [2.1]会员导入记录表
     * 
     * @author ${user}
     * @version 1.0 2016-12-14
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
        public Criteria andMemberGUIDIsNull() {
            addCriterion("memberGUID is null");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDIsNotNull() {
            addCriterion("memberGUID is not null");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDEqualTo(String value) {
            addCriterion("memberGUID =", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotEqualTo(String value) {
            addCriterion("memberGUID <>", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDGreaterThan(String value) {
            addCriterion("memberGUID >", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("memberGUID >=", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLessThan(String value) {
            addCriterion("memberGUID <", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLessThanOrEqualTo(String value) {
            addCriterion("memberGUID <=", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLike(String value) {
            addCriterion("memberGUID like", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotLike(String value) {
            addCriterion("memberGUID not like", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDIn(List<String> values) {
            addCriterion("memberGUID in", values, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotIn(List<String> values) {
            addCriterion("memberGUID not in", values, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDBetween(String value1, String value2) {
            addCriterion("memberGUID between", value1, value2, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotBetween(String value1, String value2) {
            addCriterion("memberGUID not between", value1, value2, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDIsNull() {
            addCriterion("ImportBatchGUID is null");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDIsNotNull() {
            addCriterion("ImportBatchGUID is not null");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDEqualTo(String value) {
            addCriterion("ImportBatchGUID =", value, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDNotEqualTo(String value) {
            addCriterion("ImportBatchGUID <>", value, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDGreaterThan(String value) {
            addCriterion("ImportBatchGUID >", value, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("ImportBatchGUID >=", value, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDLessThan(String value) {
            addCriterion("ImportBatchGUID <", value, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDLessThanOrEqualTo(String value) {
            addCriterion("ImportBatchGUID <=", value, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDLike(String value) {
            addCriterion("ImportBatchGUID like", value, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDNotLike(String value) {
            addCriterion("ImportBatchGUID not like", value, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDIn(List<String> values) {
            addCriterion("ImportBatchGUID in", values, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDNotIn(List<String> values) {
            addCriterion("ImportBatchGUID not in", values, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDBetween(String value1, String value2) {
            addCriterion("ImportBatchGUID between", value1, value2, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportBatchGUIDNotBetween(String value1, String value2) {
            addCriterion("ImportBatchGUID not between", value1, value2, "importBatchGUID");
            return (Criteria) this;
        }
        public Criteria andImportTimeIsNull() {
            addCriterion("ImportTime is null");
            return (Criteria) this;
        }
        public Criteria andImportTimeIsNotNull() {
            addCriterion("ImportTime is not null");
            return (Criteria) this;
        }
        public Criteria andImportTimeEqualTo(Date value) {
            addCriterion("ImportTime =", value, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeNotEqualTo(Date value) {
            addCriterion("ImportTime <>", value, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeGreaterThan(Date value) {
            addCriterion("ImportTime >", value, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ImportTime >=", value, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeLessThan(Date value) {
            addCriterion("ImportTime <", value, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeLessThanOrEqualTo(Date value) {
            addCriterion("ImportTime <=", value, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeIn(List<Date> values) {
            addCriterion("ImportTime in", values, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeNotIn(List<Date> values) {
            addCriterion("ImportTime not in", values, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeBetween(Date value1, Date value2) {
            addCriterion("ImportTime between", value1, value2, "importTime");
            return (Criteria) this;
        }
        public Criteria andImportTimeNotBetween(Date value1, Date value2) {
            addCriterion("ImportTime not between", value1, value2, "importTime");
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
        public Criteria andSyncTimestampIsNull() {
            addCriterion("SyncTimestamp is null");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampIsNotNull() {
            addCriterion("SyncTimestamp is not null");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampEqualTo(Long value) {
            addCriterion("SyncTimestamp =", value, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampNotEqualTo(Long value) {
            addCriterion("SyncTimestamp <>", value, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampGreaterThan(Long value) {
            addCriterion("SyncTimestamp >", value, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampGreaterThanOrEqualTo(Long value) {
            addCriterion("SyncTimestamp >=", value, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampLessThan(Long value) {
            addCriterion("SyncTimestamp <", value, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampLessThanOrEqualTo(Long value) {
            addCriterion("SyncTimestamp <=", value, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampIn(List<Long> values) {
            addCriterion("SyncTimestamp in", values, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampNotIn(List<Long> values) {
            addCriterion("SyncTimestamp not in", values, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampBetween(Long value1, Long value2) {
            addCriterion("SyncTimestamp between", value1, value2, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andSyncTimestampNotBetween(Long value1, Long value2) {
            addCriterion("SyncTimestamp not between", value1, value2, "syncTimestamp");
            return (Criteria) this;
        }
        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }
        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }
        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andSourceTypeIsNull() {
            addCriterion("SourceType is null");
            return (Criteria) this;
        }
        public Criteria andSourceTypeIsNotNull() {
            addCriterion("SourceType is not null");
            return (Criteria) this;
        }
        public Criteria andSourceTypeEqualTo(Byte value) {
            addCriterion("SourceType =", value, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeNotEqualTo(Byte value) {
            addCriterion("SourceType <>", value, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeGreaterThan(Byte value) {
            addCriterion("SourceType >", value, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SourceType >=", value, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeLessThan(Byte value) {
            addCriterion("SourceType <", value, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("SourceType <=", value, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeIn(List<Byte> values) {
            addCriterion("SourceType in", values, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeNotIn(List<Byte> values) {
            addCriterion("SourceType not in", values, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeBetween(Byte value1, Byte value2) {
            addCriterion("SourceType between", value1, value2, "sourceType");
            return (Criteria) this;
        }
        public Criteria andSourceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SourceType not between", value1, value2, "sourceType");
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
     * [2.1]会员导入记录表
     * 
     * @author ${user}
     * @version 1.0 2016-12-14
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