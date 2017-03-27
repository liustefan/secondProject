/*
 * SmsSendDetailExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.centCore.sms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsSendDetailExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SmsSendDetailExample() {
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
     * [3.0]短信发送明细
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
        public Criteria andSSDetailIDIsNull() {
            addCriterion("SSDetailID is null");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDIsNotNull() {
            addCriterion("SSDetailID is not null");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDEqualTo(Integer value) {
            addCriterion("SSDetailID =", value, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDNotEqualTo(Integer value) {
            addCriterion("SSDetailID <>", value, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDGreaterThan(Integer value) {
            addCriterion("SSDetailID >", value, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("SSDetailID >=", value, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDLessThan(Integer value) {
            addCriterion("SSDetailID <", value, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDLessThanOrEqualTo(Integer value) {
            addCriterion("SSDetailID <=", value, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDIn(List<Integer> values) {
            addCriterion("SSDetailID in", values, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDNotIn(List<Integer> values) {
            addCriterion("SSDetailID not in", values, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDBetween(Integer value1, Integer value2) {
            addCriterion("SSDetailID between", value1, value2, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSDetailIDNotBetween(Integer value1, Integer value2) {
            addCriterion("SSDetailID not between", value1, value2, "SSDetailID");
            return (Criteria) this;
        }
        public Criteria andSSendIDIsNull() {
            addCriterion("SSendID is null");
            return (Criteria) this;
        }
        public Criteria andSSendIDIsNotNull() {
            addCriterion("SSendID is not null");
            return (Criteria) this;
        }
        public Criteria andSSendIDEqualTo(Integer value) {
            addCriterion("SSendID =", value, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDNotEqualTo(Integer value) {
            addCriterion("SSendID <>", value, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDGreaterThan(Integer value) {
            addCriterion("SSendID >", value, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("SSendID >=", value, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDLessThan(Integer value) {
            addCriterion("SSendID <", value, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDLessThanOrEqualTo(Integer value) {
            addCriterion("SSendID <=", value, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDIn(List<Integer> values) {
            addCriterion("SSendID in", values, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDNotIn(List<Integer> values) {
            addCriterion("SSendID not in", values, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDBetween(Integer value1, Integer value2) {
            addCriterion("SSendID between", value1, value2, "SSendID");
            return (Criteria) this;
        }
        public Criteria andSSendIDNotBetween(Integer value1, Integer value2) {
            addCriterion("SSendID not between", value1, value2, "SSendID");
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
        public Criteria andMemberIDEqualTo(String value) {
            addCriterion("MemberID =", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotEqualTo(String value) {
            addCriterion("MemberID <>", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDGreaterThan(String value) {
            addCriterion("MemberID >", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDGreaterThanOrEqualTo(String value) {
            addCriterion("MemberID >=", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLessThan(String value) {
            addCriterion("MemberID <", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLessThanOrEqualTo(String value) {
            addCriterion("MemberID <=", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLike(String value) {
            addCriterion("MemberID like", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotLike(String value) {
            addCriterion("MemberID not like", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDIn(List<String> values) {
            addCriterion("MemberID in", values, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotIn(List<String> values) {
            addCriterion("MemberID not in", values, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDBetween(String value1, String value2) {
            addCriterion("MemberID between", value1, value2, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotBetween(String value1, String value2) {
            addCriterion("MemberID not between", value1, value2, "memberID");
            return (Criteria) this;
        }
        public Criteria andRecvNumberIsNull() {
            addCriterion("RecvNumber is null");
            return (Criteria) this;
        }
        public Criteria andRecvNumberIsNotNull() {
            addCriterion("RecvNumber is not null");
            return (Criteria) this;
        }
        public Criteria andRecvNumberEqualTo(String value) {
            addCriterion("RecvNumber =", value, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberNotEqualTo(String value) {
            addCriterion("RecvNumber <>", value, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberGreaterThan(String value) {
            addCriterion("RecvNumber >", value, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberGreaterThanOrEqualTo(String value) {
            addCriterion("RecvNumber >=", value, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberLessThan(String value) {
            addCriterion("RecvNumber <", value, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberLessThanOrEqualTo(String value) {
            addCriterion("RecvNumber <=", value, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberLike(String value) {
            addCriterion("RecvNumber like", value, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberNotLike(String value) {
            addCriterion("RecvNumber not like", value, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberIn(List<String> values) {
            addCriterion("RecvNumber in", values, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberNotIn(List<String> values) {
            addCriterion("RecvNumber not in", values, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberBetween(String value1, String value2) {
            addCriterion("RecvNumber between", value1, value2, "recvNumber");
            return (Criteria) this;
        }
        public Criteria andRecvNumberNotBetween(String value1, String value2) {
            addCriterion("RecvNumber not between", value1, value2, "recvNumber");
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
        public Criteria andRecvTimeIsNull() {
            addCriterion("RecvTime is null");
            return (Criteria) this;
        }
        public Criteria andRecvTimeIsNotNull() {
            addCriterion("RecvTime is not null");
            return (Criteria) this;
        }
        public Criteria andRecvTimeEqualTo(Date value) {
            addCriterion("RecvTime =", value, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeNotEqualTo(Date value) {
            addCriterion("RecvTime <>", value, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeGreaterThan(Date value) {
            addCriterion("RecvTime >", value, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RecvTime >=", value, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeLessThan(Date value) {
            addCriterion("RecvTime <", value, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeLessThanOrEqualTo(Date value) {
            addCriterion("RecvTime <=", value, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeIn(List<Date> values) {
            addCriterion("RecvTime in", values, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeNotIn(List<Date> values) {
            addCriterion("RecvTime not in", values, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeBetween(Date value1, Date value2) {
            addCriterion("RecvTime between", value1, value2, "recvTime");
            return (Criteria) this;
        }
        public Criteria andRecvTimeNotBetween(Date value1, Date value2) {
            addCriterion("RecvTime not between", value1, value2, "recvTime");
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
        public Criteria andFailCountIsNull() {
            addCriterion("FailCount is null");
            return (Criteria) this;
        }
        public Criteria andFailCountIsNotNull() {
            addCriterion("FailCount is not null");
            return (Criteria) this;
        }
        public Criteria andFailCountEqualTo(Integer value) {
            addCriterion("FailCount =", value, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountNotEqualTo(Integer value) {
            addCriterion("FailCount <>", value, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountGreaterThan(Integer value) {
            addCriterion("FailCount >", value, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("FailCount >=", value, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountLessThan(Integer value) {
            addCriterion("FailCount <", value, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountLessThanOrEqualTo(Integer value) {
            addCriterion("FailCount <=", value, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountIn(List<Integer> values) {
            addCriterion("FailCount in", values, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountNotIn(List<Integer> values) {
            addCriterion("FailCount not in", values, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountBetween(Integer value1, Integer value2) {
            addCriterion("FailCount between", value1, value2, "failCount");
            return (Criteria) this;
        }
        public Criteria andFailCountNotBetween(Integer value1, Integer value2) {
            addCriterion("FailCount not between", value1, value2, "failCount");
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
     * [3.0]短信发送明细
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