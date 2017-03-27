/*
 * ChatMessageExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-20 Created
 */
package com.bithealth.chatCore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatMessageExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ChatMessageExample() {
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
     * [2.1]聊天表
     * 
     * @author ${user}
     * @version 1.0 2016-12-20
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
        public Criteria and_logidIsNull() {
            addCriterion("_logid is null");
            return (Criteria) this;
        }
        public Criteria and_logidIsNotNull() {
            addCriterion("_logid is not null");
            return (Criteria) this;
        }
        public Criteria and_logidEqualTo(Integer value) {
            addCriterion("_logid =", value, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidNotEqualTo(Integer value) {
            addCriterion("_logid <>", value, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidGreaterThan(Integer value) {
            addCriterion("_logid >", value, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidGreaterThanOrEqualTo(Integer value) {
            addCriterion("_logid >=", value, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidLessThan(Integer value) {
            addCriterion("_logid <", value, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidLessThanOrEqualTo(Integer value) {
            addCriterion("_logid <=", value, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidIn(List<Integer> values) {
            addCriterion("_logid in", values, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidNotIn(List<Integer> values) {
            addCriterion("_logid not in", values, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidBetween(Integer value1, Integer value2) {
            addCriterion("_logid between", value1, value2, "_logid");
            return (Criteria) this;
        }
        public Criteria and_logidNotBetween(Integer value1, Integer value2) {
            addCriterion("_logid not between", value1, value2, "_logid");
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
        public Criteria andSenderEqualTo(Integer value) {
            addCriterion("Sender =", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderNotEqualTo(Integer value) {
            addCriterion("Sender <>", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderGreaterThan(Integer value) {
            addCriterion("Sender >", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("Sender >=", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderLessThan(Integer value) {
            addCriterion("Sender <", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderLessThanOrEqualTo(Integer value) {
            addCriterion("Sender <=", value, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderIn(List<Integer> values) {
            addCriterion("Sender in", values, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderNotIn(List<Integer> values) {
            addCriterion("Sender not in", values, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderBetween(Integer value1, Integer value2) {
            addCriterion("Sender between", value1, value2, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderNotBetween(Integer value1, Integer value2) {
            addCriterion("Sender not between", value1, value2, "sender");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDIsNull() {
            addCriterion("SenderGUID is null");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDIsNotNull() {
            addCriterion("SenderGUID is not null");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDEqualTo(String value) {
            addCriterion("SenderGUID =", value, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDNotEqualTo(String value) {
            addCriterion("SenderGUID <>", value, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDGreaterThan(String value) {
            addCriterion("SenderGUID >", value, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("SenderGUID >=", value, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDLessThan(String value) {
            addCriterion("SenderGUID <", value, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDLessThanOrEqualTo(String value) {
            addCriterion("SenderGUID <=", value, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDLike(String value) {
            addCriterion("SenderGUID like", value, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDNotLike(String value) {
            addCriterion("SenderGUID not like", value, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDIn(List<String> values) {
            addCriterion("SenderGUID in", values, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDNotIn(List<String> values) {
            addCriterion("SenderGUID not in", values, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDBetween(String value1, String value2) {
            addCriterion("SenderGUID between", value1, value2, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSenderGUIDNotBetween(String value1, String value2) {
            addCriterion("SenderGUID not between", value1, value2, "senderGUID");
            return (Criteria) this;
        }
        public Criteria andSendTimeIsNull() {
            addCriterion("SendTime is null");
            return (Criteria) this;
        }
        public Criteria andSendTimeIsNotNull() {
            addCriterion("SendTime is not null");
            return (Criteria) this;
        }
        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("SendTime =", value, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("SendTime <>", value, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("SendTime >", value, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SendTime >=", value, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("SendTime <", value, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("SendTime <=", value, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("SendTime in", values, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("SendTime not in", values, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("SendTime between", value1, value2, "sendTime");
            return (Criteria) this;
        }
        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("SendTime not between", value1, value2, "sendTime");
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
        public Criteria andReceiverEqualTo(Integer value) {
            addCriterion("Receiver =", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverNotEqualTo(Integer value) {
            addCriterion("Receiver <>", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverGreaterThan(Integer value) {
            addCriterion("Receiver >", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverGreaterThanOrEqualTo(Integer value) {
            addCriterion("Receiver >=", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverLessThan(Integer value) {
            addCriterion("Receiver <", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverLessThanOrEqualTo(Integer value) {
            addCriterion("Receiver <=", value, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverIn(List<Integer> values) {
            addCriterion("Receiver in", values, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverNotIn(List<Integer> values) {
            addCriterion("Receiver not in", values, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverBetween(Integer value1, Integer value2) {
            addCriterion("Receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverNotBetween(Integer value1, Integer value2) {
            addCriterion("Receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDIsNull() {
            addCriterion("ReceiverGUID is null");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDIsNotNull() {
            addCriterion("ReceiverGUID is not null");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDEqualTo(String value) {
            addCriterion("ReceiverGUID =", value, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDNotEqualTo(String value) {
            addCriterion("ReceiverGUID <>", value, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDGreaterThan(String value) {
            addCriterion("ReceiverGUID >", value, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("ReceiverGUID >=", value, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDLessThan(String value) {
            addCriterion("ReceiverGUID <", value, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDLessThanOrEqualTo(String value) {
            addCriterion("ReceiverGUID <=", value, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDLike(String value) {
            addCriterion("ReceiverGUID like", value, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDNotLike(String value) {
            addCriterion("ReceiverGUID not like", value, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDIn(List<String> values) {
            addCriterion("ReceiverGUID in", values, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDNotIn(List<String> values) {
            addCriterion("ReceiverGUID not in", values, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDBetween(String value1, String value2) {
            addCriterion("ReceiverGUID between", value1, value2, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiverGUIDNotBetween(String value1, String value2) {
            addCriterion("ReceiverGUID not between", value1, value2, "receiverGUID");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeIsNull() {
            addCriterion("ReceiveTime is null");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("ReceiveTime is not null");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("ReceiveTime =", value, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("ReceiveTime <>", value, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("ReceiveTime >", value, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ReceiveTime >=", value, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("ReceiveTime <", value, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("ReceiveTime <=", value, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("ReceiveTime in", values, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("ReceiveTime not in", values, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("ReceiveTime between", value1, value2, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("ReceiveTime not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }
        public Criteria andContentTypeIsNull() {
            addCriterion("ContentType is null");
            return (Criteria) this;
        }
        public Criteria andContentTypeIsNotNull() {
            addCriterion("ContentType is not null");
            return (Criteria) this;
        }
        public Criteria andContentTypeEqualTo(Byte value) {
            addCriterion("ContentType =", value, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeNotEqualTo(Byte value) {
            addCriterion("ContentType <>", value, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeGreaterThan(Byte value) {
            addCriterion("ContentType >", value, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ContentType >=", value, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeLessThan(Byte value) {
            addCriterion("ContentType <", value, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeLessThanOrEqualTo(Byte value) {
            addCriterion("ContentType <=", value, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeIn(List<Byte> values) {
            addCriterion("ContentType in", values, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeNotIn(List<Byte> values) {
            addCriterion("ContentType not in", values, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeBetween(Byte value1, Byte value2) {
            addCriterion("ContentType between", value1, value2, "contentType");
            return (Criteria) this;
        }
        public Criteria andContentTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ContentType not between", value1, value2, "contentType");
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
        public Criteria andRefTypeIsNull() {
            addCriterion("RefType is null");
            return (Criteria) this;
        }
        public Criteria andRefTypeIsNotNull() {
            addCriterion("RefType is not null");
            return (Criteria) this;
        }
        public Criteria andRefTypeEqualTo(Byte value) {
            addCriterion("RefType =", value, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeNotEqualTo(Byte value) {
            addCriterion("RefType <>", value, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeGreaterThan(Byte value) {
            addCriterion("RefType >", value, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("RefType >=", value, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeLessThan(Byte value) {
            addCriterion("RefType <", value, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeLessThanOrEqualTo(Byte value) {
            addCriterion("RefType <=", value, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeIn(List<Byte> values) {
            addCriterion("RefType in", values, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeNotIn(List<Byte> values) {
            addCriterion("RefType not in", values, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeBetween(Byte value1, Byte value2) {
            addCriterion("RefType between", value1, value2, "refType");
            return (Criteria) this;
        }
        public Criteria andRefTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("RefType not between", value1, value2, "refType");
            return (Criteria) this;
        }
        public Criteria andRefIDIsNull() {
            addCriterion("RefID is null");
            return (Criteria) this;
        }
        public Criteria andRefIDIsNotNull() {
            addCriterion("RefID is not null");
            return (Criteria) this;
        }
        public Criteria andRefIDEqualTo(Long value) {
            addCriterion("RefID =", value, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDNotEqualTo(Long value) {
            addCriterion("RefID <>", value, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDGreaterThan(Long value) {
            addCriterion("RefID >", value, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDGreaterThanOrEqualTo(Long value) {
            addCriterion("RefID >=", value, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDLessThan(Long value) {
            addCriterion("RefID <", value, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDLessThanOrEqualTo(Long value) {
            addCriterion("RefID <=", value, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDIn(List<Long> values) {
            addCriterion("RefID in", values, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDNotIn(List<Long> values) {
            addCriterion("RefID not in", values, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDBetween(Long value1, Long value2) {
            addCriterion("RefID between", value1, value2, "refID");
            return (Criteria) this;
        }
        public Criteria andRefIDNotBetween(Long value1, Long value2) {
            addCriterion("RefID not between", value1, value2, "refID");
            return (Criteria) this;
        }
        public Criteria andRefStatusIsNull() {
            addCriterion("RefStatus is null");
            return (Criteria) this;
        }
        public Criteria andRefStatusIsNotNull() {
            addCriterion("RefStatus is not null");
            return (Criteria) this;
        }
        public Criteria andRefStatusEqualTo(Byte value) {
            addCriterion("RefStatus =", value, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusNotEqualTo(Byte value) {
            addCriterion("RefStatus <>", value, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusGreaterThan(Byte value) {
            addCriterion("RefStatus >", value, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("RefStatus >=", value, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusLessThan(Byte value) {
            addCriterion("RefStatus <", value, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusLessThanOrEqualTo(Byte value) {
            addCriterion("RefStatus <=", value, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusIn(List<Byte> values) {
            addCriterion("RefStatus in", values, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusNotIn(List<Byte> values) {
            addCriterion("RefStatus not in", values, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusBetween(Byte value1, Byte value2) {
            addCriterion("RefStatus between", value1, value2, "refStatus");
            return (Criteria) this;
        }
        public Criteria andRefStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("RefStatus not between", value1, value2, "refStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [2.1]聊天表
     * 
     * @author ${user}
     * @version 1.0 2016-12-20
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