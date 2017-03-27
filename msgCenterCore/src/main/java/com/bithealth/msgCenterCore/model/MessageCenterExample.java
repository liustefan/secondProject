/*
 * MessageCenterExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-29 Created
 */
package com.bithealth.msgCenterCore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageCenterExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MessageCenterExample() {
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
     * [2.1]消息中心表
     * 
     * @author ${user}
     * @version 1.0 2016-08-29
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
        public Criteria andMsgtypeIsNull() {
            addCriterion("MsgType is null");
            return (Criteria) this;
        }
        public Criteria andMsgtypeIsNotNull() {
            addCriterion("MsgType is not null");
            return (Criteria) this;
        }
        public Criteria andMsgtypeEqualTo(Byte value) {
            addCriterion("MsgType =", value, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeNotEqualTo(Byte value) {
            addCriterion("MsgType <>", value, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeGreaterThan(Byte value) {
            addCriterion("MsgType >", value, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("MsgType >=", value, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeLessThan(Byte value) {
            addCriterion("MsgType <", value, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeLessThanOrEqualTo(Byte value) {
            addCriterion("MsgType <=", value, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeIn(List<Byte> values) {
            addCriterion("MsgType in", values, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeNotIn(List<Byte> values) {
            addCriterion("MsgType not in", values, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeBetween(Byte value1, Byte value2) {
            addCriterion("MsgType between", value1, value2, "msgtype");
            return (Criteria) this;
        }
        public Criteria andMsgtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("MsgType not between", value1, value2, "msgtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeIsNull() {
            addCriterion("SendType is null");
            return (Criteria) this;
        }
        public Criteria andSendtypeIsNotNull() {
            addCriterion("SendType is not null");
            return (Criteria) this;
        }
        public Criteria andSendtypeEqualTo(Byte value) {
            addCriterion("SendType =", value, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeNotEqualTo(Byte value) {
            addCriterion("SendType <>", value, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeGreaterThan(Byte value) {
            addCriterion("SendType >", value, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SendType >=", value, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeLessThan(Byte value) {
            addCriterion("SendType <", value, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeLessThanOrEqualTo(Byte value) {
            addCriterion("SendType <=", value, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeIn(List<Byte> values) {
            addCriterion("SendType in", values, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeNotIn(List<Byte> values) {
            addCriterion("SendType not in", values, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeBetween(Byte value1, Byte value2) {
            addCriterion("SendType between", value1, value2, "sendtype");
            return (Criteria) this;
        }
        public Criteria andSendtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SendType not between", value1, value2, "sendtype");
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
        public Criteria andReceivetypeIsNull() {
            addCriterion("ReceiveType is null");
            return (Criteria) this;
        }
        public Criteria andReceivetypeIsNotNull() {
            addCriterion("ReceiveType is not null");
            return (Criteria) this;
        }
        public Criteria andReceivetypeEqualTo(Byte value) {
            addCriterion("ReceiveType =", value, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeNotEqualTo(Byte value) {
            addCriterion("ReceiveType <>", value, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeGreaterThan(Byte value) {
            addCriterion("ReceiveType >", value, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ReceiveType >=", value, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeLessThan(Byte value) {
            addCriterion("ReceiveType <", value, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeLessThanOrEqualTo(Byte value) {
            addCriterion("ReceiveType <=", value, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeIn(List<Byte> values) {
            addCriterion("ReceiveType in", values, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeNotIn(List<Byte> values) {
            addCriterion("ReceiveType not in", values, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeBetween(Byte value1, Byte value2) {
            addCriterion("ReceiveType between", value1, value2, "receivetype");
            return (Criteria) this;
        }
        public Criteria andReceivetypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ReceiveType not between", value1, value2, "receivetype");
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
        public Criteria andLastsourceidIsNull() {
            addCriterion("LastSourceID is null");
            return (Criteria) this;
        }
        public Criteria andLastsourceidIsNotNull() {
            addCriterion("LastSourceID is not null");
            return (Criteria) this;
        }
        public Criteria andLastsourceidEqualTo(Long value) {
            addCriterion("LastSourceID =", value, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidNotEqualTo(Long value) {
            addCriterion("LastSourceID <>", value, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidGreaterThan(Long value) {
            addCriterion("LastSourceID >", value, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidGreaterThanOrEqualTo(Long value) {
            addCriterion("LastSourceID >=", value, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidLessThan(Long value) {
            addCriterion("LastSourceID <", value, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidLessThanOrEqualTo(Long value) {
            addCriterion("LastSourceID <=", value, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidIn(List<Long> values) {
            addCriterion("LastSourceID in", values, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidNotIn(List<Long> values) {
            addCriterion("LastSourceID not in", values, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidBetween(Long value1, Long value2) {
            addCriterion("LastSourceID between", value1, value2, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastsourceidNotBetween(Long value1, Long value2) {
            addCriterion("LastSourceID not between", value1, value2, "lastsourceid");
            return (Criteria) this;
        }
        public Criteria andLastcontentIsNull() {
            addCriterion("LastContent is null");
            return (Criteria) this;
        }
        public Criteria andLastcontentIsNotNull() {
            addCriterion("LastContent is not null");
            return (Criteria) this;
        }
        public Criteria andLastcontentEqualTo(String value) {
            addCriterion("LastContent =", value, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentNotEqualTo(String value) {
            addCriterion("LastContent <>", value, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentGreaterThan(String value) {
            addCriterion("LastContent >", value, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentGreaterThanOrEqualTo(String value) {
            addCriterion("LastContent >=", value, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentLessThan(String value) {
            addCriterion("LastContent <", value, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentLessThanOrEqualTo(String value) {
            addCriterion("LastContent <=", value, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentLike(String value) {
            addCriterion("LastContent like", value, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentNotLike(String value) {
            addCriterion("LastContent not like", value, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentIn(List<String> values) {
            addCriterion("LastContent in", values, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentNotIn(List<String> values) {
            addCriterion("LastContent not in", values, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentBetween(String value1, String value2) {
            addCriterion("LastContent between", value1, value2, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andLastcontentNotBetween(String value1, String value2) {
            addCriterion("LastContent not between", value1, value2, "lastcontent");
            return (Criteria) this;
        }
        public Criteria andNumberIsNull() {
            addCriterion("Number is null");
            return (Criteria) this;
        }
        public Criteria andNumberIsNotNull() {
            addCriterion("Number is not null");
            return (Criteria) this;
        }
        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("Number =", value, "number");
            return (Criteria) this;
        }
        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("Number <>", value, "number");
            return (Criteria) this;
        }
        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("Number >", value, "number");
            return (Criteria) this;
        }
        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("Number >=", value, "number");
            return (Criteria) this;
        }
        public Criteria andNumberLessThan(Integer value) {
            addCriterion("Number <", value, "number");
            return (Criteria) this;
        }
        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("Number <=", value, "number");
            return (Criteria) this;
        }
        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("Number in", values, "number");
            return (Criteria) this;
        }
        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("Number not in", values, "number");
            return (Criteria) this;
        }
        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("Number between", value1, value2, "number");
            return (Criteria) this;
        }
        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("Number not between", value1, value2, "number");
            return (Criteria) this;
        }
        public Criteria andScheduletimeIsNull() {
            addCriterion("ScheduleTime is null");
            return (Criteria) this;
        }
        public Criteria andScheduletimeIsNotNull() {
            addCriterion("ScheduleTime is not null");
            return (Criteria) this;
        }
        public Criteria andScheduletimeEqualTo(Date value) {
            addCriterion("ScheduleTime =", value, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeNotEqualTo(Date value) {
            addCriterion("ScheduleTime <>", value, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeGreaterThan(Date value) {
            addCriterion("ScheduleTime >", value, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ScheduleTime >=", value, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeLessThan(Date value) {
            addCriterion("ScheduleTime <", value, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeLessThanOrEqualTo(Date value) {
            addCriterion("ScheduleTime <=", value, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeIn(List<Date> values) {
            addCriterion("ScheduleTime in", values, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeNotIn(List<Date> values) {
            addCriterion("ScheduleTime not in", values, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeBetween(Date value1, Date value2) {
            addCriterion("ScheduleTime between", value1, value2, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andScheduletimeNotBetween(Date value1, Date value2) {
            addCriterion("ScheduleTime not between", value1, value2, "scheduletime");
            return (Criteria) this;
        }
        public Criteria andSendstatusIsNull() {
            addCriterion("SendStatus is null");
            return (Criteria) this;
        }
        public Criteria andSendstatusIsNotNull() {
            addCriterion("SendStatus is not null");
            return (Criteria) this;
        }
        public Criteria andSendstatusEqualTo(Byte value) {
            addCriterion("SendStatus =", value, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusNotEqualTo(Byte value) {
            addCriterion("SendStatus <>", value, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusGreaterThan(Byte value) {
            addCriterion("SendStatus >", value, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("SendStatus >=", value, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusLessThan(Byte value) {
            addCriterion("SendStatus <", value, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusLessThanOrEqualTo(Byte value) {
            addCriterion("SendStatus <=", value, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusIn(List<Byte> values) {
            addCriterion("SendStatus in", values, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusNotIn(List<Byte> values) {
            addCriterion("SendStatus not in", values, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusBetween(Byte value1, Byte value2) {
            addCriterion("SendStatus between", value1, value2, "sendstatus");
            return (Criteria) this;
        }
        public Criteria andSendstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("SendStatus not between", value1, value2, "sendstatus");
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
     * [2.1]消息中心表
     * 
     * @author ${user}
     * @version 1.0 2016-08-29
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