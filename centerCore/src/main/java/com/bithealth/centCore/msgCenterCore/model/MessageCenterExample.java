/*
 * MessageCenterExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-26 Created
 */
package com.bithealth.centCore.msgCenterCore.model;

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
     * [1.1]消息中心表
     * 
     * @author ${user}
     * @version 1.0 2016-12-26
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
        public Criteria andSendTypeIsNull() {
            addCriterion("SendType is null");
            return (Criteria) this;
        }
        public Criteria andSendTypeIsNotNull() {
            addCriterion("SendType is not null");
            return (Criteria) this;
        }
        public Criteria andSendTypeEqualTo(Byte value) {
            addCriterion("SendType =", value, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeNotEqualTo(Byte value) {
            addCriterion("SendType <>", value, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeGreaterThan(Byte value) {
            addCriterion("SendType >", value, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SendType >=", value, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeLessThan(Byte value) {
            addCriterion("SendType <", value, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeLessThanOrEqualTo(Byte value) {
            addCriterion("SendType <=", value, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeIn(List<Byte> values) {
            addCriterion("SendType in", values, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeNotIn(List<Byte> values) {
            addCriterion("SendType not in", values, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeBetween(Byte value1, Byte value2) {
            addCriterion("SendType between", value1, value2, "sendType");
            return (Criteria) this;
        }
        public Criteria andSendTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SendType not between", value1, value2, "sendType");
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
        public Criteria andReceiveTypeIsNull() {
            addCriterion("ReceiveType is null");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeIsNotNull() {
            addCriterion("ReceiveType is not null");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeEqualTo(Byte value) {
            addCriterion("ReceiveType =", value, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeNotEqualTo(Byte value) {
            addCriterion("ReceiveType <>", value, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeGreaterThan(Byte value) {
            addCriterion("ReceiveType >", value, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ReceiveType >=", value, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeLessThan(Byte value) {
            addCriterion("ReceiveType <", value, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeLessThanOrEqualTo(Byte value) {
            addCriterion("ReceiveType <=", value, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeIn(List<Byte> values) {
            addCriterion("ReceiveType in", values, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeNotIn(List<Byte> values) {
            addCriterion("ReceiveType not in", values, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeBetween(Byte value1, Byte value2) {
            addCriterion("ReceiveType between", value1, value2, "receiveType");
            return (Criteria) this;
        }
        public Criteria andReceiveTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ReceiveType not between", value1, value2, "receiveType");
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
        public Criteria andLastSourceIDIsNull() {
            addCriterion("LastSourceID is null");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDIsNotNull() {
            addCriterion("LastSourceID is not null");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDEqualTo(Long value) {
            addCriterion("LastSourceID =", value, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDNotEqualTo(Long value) {
            addCriterion("LastSourceID <>", value, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDGreaterThan(Long value) {
            addCriterion("LastSourceID >", value, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDGreaterThanOrEqualTo(Long value) {
            addCriterion("LastSourceID >=", value, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDLessThan(Long value) {
            addCriterion("LastSourceID <", value, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDLessThanOrEqualTo(Long value) {
            addCriterion("LastSourceID <=", value, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDIn(List<Long> values) {
            addCriterion("LastSourceID in", values, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDNotIn(List<Long> values) {
            addCriterion("LastSourceID not in", values, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDBetween(Long value1, Long value2) {
            addCriterion("LastSourceID between", value1, value2, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastSourceIDNotBetween(Long value1, Long value2) {
            addCriterion("LastSourceID not between", value1, value2, "lastSourceID");
            return (Criteria) this;
        }
        public Criteria andLastContentIsNull() {
            addCriterion("LastContent is null");
            return (Criteria) this;
        }
        public Criteria andLastContentIsNotNull() {
            addCriterion("LastContent is not null");
            return (Criteria) this;
        }
        public Criteria andLastContentEqualTo(String value) {
            addCriterion("LastContent =", value, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentNotEqualTo(String value) {
            addCriterion("LastContent <>", value, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentGreaterThan(String value) {
            addCriterion("LastContent >", value, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentGreaterThanOrEqualTo(String value) {
            addCriterion("LastContent >=", value, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentLessThan(String value) {
            addCriterion("LastContent <", value, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentLessThanOrEqualTo(String value) {
            addCriterion("LastContent <=", value, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentLike(String value) {
            addCriterion("LastContent like", value, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentNotLike(String value) {
            addCriterion("LastContent not like", value, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentIn(List<String> values) {
            addCriterion("LastContent in", values, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentNotIn(List<String> values) {
            addCriterion("LastContent not in", values, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentBetween(String value1, String value2) {
            addCriterion("LastContent between", value1, value2, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentNotBetween(String value1, String value2) {
            addCriterion("LastContent not between", value1, value2, "lastContent");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeIsNull() {
            addCriterion("LastContentNotice is null");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeIsNotNull() {
            addCriterion("LastContentNotice is not null");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeEqualTo(String value) {
            addCriterion("LastContentNotice =", value, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeNotEqualTo(String value) {
            addCriterion("LastContentNotice <>", value, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeGreaterThan(String value) {
            addCriterion("LastContentNotice >", value, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("LastContentNotice >=", value, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeLessThan(String value) {
            addCriterion("LastContentNotice <", value, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeLessThanOrEqualTo(String value) {
            addCriterion("LastContentNotice <=", value, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeLike(String value) {
            addCriterion("LastContentNotice like", value, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeNotLike(String value) {
            addCriterion("LastContentNotice not like", value, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeIn(List<String> values) {
            addCriterion("LastContentNotice in", values, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeNotIn(List<String> values) {
            addCriterion("LastContentNotice not in", values, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeBetween(String value1, String value2) {
            addCriterion("LastContentNotice between", value1, value2, "lastContentNotice");
            return (Criteria) this;
        }
        public Criteria andLastContentNoticeNotBetween(String value1, String value2) {
            addCriterion("LastContentNotice not between", value1, value2, "lastContentNotice");
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
              
        public Criteria andSendStatusIsNull() {
            addCriterion("SendStatus is null");
            return (Criteria) this;
        }
        public Criteria andSendStatusIsNotNull() {
            addCriterion("SendStatus is not null");
            return (Criteria) this;
        }
        public Criteria andSendStatusEqualTo(Byte value) {
            addCriterion("SendStatus =", value, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusNotEqualTo(Byte value) {
            addCriterion("SendStatus <>", value, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusGreaterThan(Byte value) {
            addCriterion("SendStatus >", value, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("SendStatus >=", value, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusLessThan(Byte value) {
            addCriterion("SendStatus <", value, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusLessThanOrEqualTo(Byte value) {
            addCriterion("SendStatus <=", value, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusIn(List<Byte> values) {
            addCriterion("SendStatus in", values, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusNotIn(List<Byte> values) {
            addCriterion("SendStatus not in", values, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusBetween(Byte value1, Byte value2) {
            addCriterion("SendStatus between", value1, value2, "sendStatus");
            return (Criteria) this;
        }
        public Criteria andSendStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("SendStatus not between", value1, value2, "sendStatus");
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
     * [1.1]消息中心表
     * 
     * @author ${user}
     * @version 1.0 2016-12-26
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