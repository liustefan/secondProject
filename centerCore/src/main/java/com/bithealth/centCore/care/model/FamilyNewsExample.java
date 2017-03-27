/*
 * FamilyNewsExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-10-26 Created
 */
package com.bithealth.centCore.care.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FamilyNewsExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public FamilyNewsExample() {
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
     * [1.1]关注的亲友动态表
     * 
     * @author ${user}
     * @version 1.0 2016-10-26
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
        public Criteria andLogIDEqualTo(Integer value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Integer value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Integer value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Integer value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Integer value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Integer> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Integer> values) {
            addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Integer value1, Integer value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Integer value1, Integer value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andMsgTypeIsNull() {
            addCriterion("MsgType is null");
            return (Criteria) this;
        }
        public Criteria andMsgTypeIsNotNull() {
            addCriterion("MsgType is not null");
            return (Criteria) this;
        }
        public Criteria andMsgTypeEqualTo(Byte value) {
            addCriterion("MsgType =", value, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeNotEqualTo(Byte value) {
            addCriterion("MsgType <>", value, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeGreaterThan(Byte value) {
            addCriterion("MsgType >", value, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("MsgType >=", value, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeLessThan(Byte value) {
            addCriterion("MsgType <", value, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeLessThanOrEqualTo(Byte value) {
            addCriterion("MsgType <=", value, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeIn(List<Byte> values) {
            addCriterion("MsgType in", values, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeNotIn(List<Byte> values) {
            addCriterion("MsgType not in", values, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeBetween(Byte value1, Byte value2) {
            addCriterion("MsgType between", value1, value2, "msgType");
            return (Criteria) this;
        }
        public Criteria andMsgTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("MsgType not between", value1, value2, "msgType");
            return (Criteria) this;
        }
        public Criteria andSenderIsNull() {
            addCriterion("Sender is null");
            return (Criteria) this;
        }
        public Criteria andSenderIsNotNull() {
            addCriterion("Sender is not null");
            return (Criteria) this;
        }
        public Criteria andSenderEqualTo(String value) {
            addCriterion("Sender =", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("Sender <>", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderGreaterThan(String value) {
            addCriterion("Sender >", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("Sender >=", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderLessThan(String value) {
            addCriterion("Sender <", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("Sender <=", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderLike(String value) {
            addCriterion("Sender like", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderNotLike(String value) {
            addCriterion("Sender not like", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderIn(List<String> values) {
            addCriterion("Sender in", values, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("Sender not in", values, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("Sender between", value1, value2, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("Sender not between", value1, value2, "sender");
            return (Criteria) this;
        }
        public Criteria andReceiverIsNull() {
            addCriterion("Receiver is null");
            return (Criteria) this;
        }
        public Criteria andReceiverIsNotNull() {
            addCriterion("Receiver is not null");
            return (Criteria) this;
        }
        public Criteria andReceiverEqualTo(String value) {
            addCriterion("Receiver =", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("Receiver <>", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("Receiver >", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("Receiver >=", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverLessThan(String value) {
            addCriterion("Receiver <", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("Receiver <=", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverLike(String value) {
            addCriterion("Receiver like", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverNotLike(String value) {
            addCriterion("Receiver not like", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverIn(List<String> values) {
            addCriterion("Receiver in", values, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("Receiver not in", values, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("Receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("Receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }
        public Criteria andSourceIDIsNull() {
            addCriterion("SourceID is null");
            return (Criteria) this;
        }
        public Criteria andSourceIDIsNotNull() {
            addCriterion("SourceID is not null");
            return (Criteria) this;
        }
        public Criteria andSourceIDEqualTo(Long value) {
            addCriterion("SourceID =", value, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDNotEqualTo(Long value) {
            addCriterion("SourceID <>", value, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDGreaterThan(Long value) {
            addCriterion("SourceID >", value, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDGreaterThanOrEqualTo(Long value) {
            addCriterion("SourceID >=", value, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDLessThan(Long value) {
            addCriterion("SourceID <", value, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDLessThanOrEqualTo(Long value) {
            addCriterion("SourceID <=", value, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDIn(List<Long> values) {
            addCriterion("SourceID in", values, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDNotIn(List<Long> values) {
            addCriterion("SourceID not in", values, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDBetween(Long value1, Long value2) {
            addCriterion("SourceID between", value1, value2, "sourceID");
            return (Criteria) this;
        }
        public Criteria andSourceIDNotBetween(Long value1, Long value2) {
            addCriterion("SourceID not between", value1, value2, "sourceID");
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
        public Criteria andIsSendIsNull() {
            addCriterion("IsSend is null");
            return (Criteria) this;
        }
        public Criteria andIsSendIsNotNull() {
            addCriterion("IsSend is not null");
            return (Criteria) this;
        }
        public Criteria andIsSendEqualTo(Byte value) {
            addCriterion("IsSend =", value, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendNotEqualTo(Byte value) {
            addCriterion("IsSend <>", value, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendGreaterThan(Byte value) {
            addCriterion("IsSend >", value, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsSend >=", value, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendLessThan(Byte value) {
            addCriterion("IsSend <", value, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendLessThanOrEqualTo(Byte value) {
            addCriterion("IsSend <=", value, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendIn(List<Byte> values) {
            addCriterion("IsSend in", values, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendNotIn(List<Byte> values) {
            addCriterion("IsSend not in", values, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendBetween(Byte value1, Byte value2) {
            addCriterion("IsSend between", value1, value2, "isSend");
            return (Criteria) this;
        }
        public Criteria andIsSendNotBetween(Byte value1, Byte value2) {
            addCriterion("IsSend not between", value1, value2, "isSend");
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
     * [1.1]关注的亲友动态表
     * 
     * @author ${user}
     * @version 1.0 2016-10-26
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