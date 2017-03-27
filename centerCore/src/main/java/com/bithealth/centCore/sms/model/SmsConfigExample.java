/*
 * SmsConfigExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.centCore.sms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SmsConfigExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SmsConfigExample() {
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
     * [3.0]短信配置
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
        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                  return;//
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }
        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                  return;//
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }
        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                  return; 
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }
        public Criteria andSCfgIDIsNull() {
            addCriterion("SCfgID is null");
            return (Criteria) this;
        }
        public Criteria andSCfgIDIsNotNull() {
            addCriterion("SCfgID is not null");
            return (Criteria) this;
        }
        public Criteria andSCfgIDEqualTo(Integer value) {
            addCriterion("SCfgID =", value, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDNotEqualTo(Integer value) {
            addCriterion("SCfgID <>", value, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDGreaterThan(Integer value) {
            addCriterion("SCfgID >", value, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCfgID >=", value, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDLessThan(Integer value) {
            addCriterion("SCfgID <", value, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDLessThanOrEqualTo(Integer value) {
            addCriterion("SCfgID <=", value, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDIn(List<Integer> values) {
            addCriterion("SCfgID in", values, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDNotIn(List<Integer> values) {
            addCriterion("SCfgID not in", values, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDBetween(Integer value1, Integer value2) {
            addCriterion("SCfgID between", value1, value2, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andSCfgIDNotBetween(Integer value1, Integer value2) {
            addCriterion("SCfgID not between", value1, value2, "SCfgID");
            return (Criteria) this;
        }
        public Criteria andServerIDIsNull() {
            addCriterion("ServerID is null");
            return (Criteria) this;
        }
        public Criteria andServerIDIsNotNull() {
            addCriterion("ServerID is not null");
            return (Criteria) this;
        }
        public Criteria andServerIDEqualTo(Integer value) {
            addCriterion("ServerID =", value, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDNotEqualTo(Integer value) {
            addCriterion("ServerID <>", value, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDGreaterThan(Integer value) {
            addCriterion("ServerID >", value, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ServerID >=", value, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDLessThan(Integer value) {
            addCriterion("ServerID <", value, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDLessThanOrEqualTo(Integer value) {
            addCriterion("ServerID <=", value, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDIn(List<Integer> values) {
            addCriterion("ServerID in", values, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDNotIn(List<Integer> values) {
            addCriterion("ServerID not in", values, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDBetween(Integer value1, Integer value2) {
            addCriterion("ServerID between", value1, value2, "serverID");
            return (Criteria) this;
        }
        public Criteria andServerIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ServerID not between", value1, value2, "serverID");
            return (Criteria) this;
        }
        public Criteria andOrgIDIsNull() {
            addCriterion("OrgID is null");
            return (Criteria) this;
        }
        public Criteria andOrgIDIsNotNull() {
            addCriterion("OrgID is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIDEqualTo(Integer value) {
            addCriterion("OrgID =", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotEqualTo(Integer value) {
            addCriterion("OrgID <>", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDGreaterThan(Integer value) {
            addCriterion("OrgID >", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgID >=", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDLessThan(Integer value) {
            addCriterion("OrgID <", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDLessThanOrEqualTo(Integer value) {
            addCriterion("OrgID <=", value, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDIn(List<Integer> values) {
            addCriterion("OrgID in", values, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotIn(List<Integer> values) {
            addCriterion("OrgID not in", values, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDBetween(Integer value1, Integer value2) {
            addCriterion("OrgID between", value1, value2, "orgID");
            return (Criteria) this;
        }
        public Criteria andOrgIDNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgID not between", value1, value2, "orgID");
            return (Criteria) this;
        }
        public Criteria andAccountIsNull() {
            addCriterion("Account is null");
            return (Criteria) this;
        }
        public Criteria andAccountIsNotNull() {
            addCriterion("Account is not null");
            return (Criteria) this;
        }
        public Criteria andAccountEqualTo(String value) {
            addCriterion("Account =", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("Account <>", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountGreaterThan(String value) {
            addCriterion("Account >", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("Account >=", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountLessThan(String value) {
            addCriterion("Account <", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("Account <=", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountLike(String value) {
            addCriterion("Account like", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountNotLike(String value) {
            addCriterion("Account not like", value, "account");
            return (Criteria) this;
        }
        public Criteria andAccountIn(List<String> values) {
            addCriterion("Account in", values, "account");
            return (Criteria) this;
        }
        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("Account not in", values, "account");
            return (Criteria) this;
        }
        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("Account between", value1, value2, "account");
            return (Criteria) this;
        }
        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("Account not between", value1, value2, "account");
            return (Criteria) this;
        }
        public Criteria andPasswdIsNull() {
            addCriterion("Passwd is null");
            return (Criteria) this;
        }
        public Criteria andPasswdIsNotNull() {
            addCriterion("Passwd is not null");
            return (Criteria) this;
        }
        public Criteria andPasswdEqualTo(String value) {
            addCriterion("Passwd =", value, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("Passwd <>", value, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("Passwd >", value, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("Passwd >=", value, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdLessThan(String value) {
            addCriterion("Passwd <", value, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("Passwd <=", value, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdLike(String value) {
            addCriterion("Passwd like", value, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdNotLike(String value) {
            addCriterion("Passwd not like", value, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdIn(List<String> values) {
            addCriterion("Passwd in", values, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdNotIn(List<String> values) {
            addCriterion("Passwd not in", values, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("Passwd between", value1, value2, "passwd");
            return (Criteria) this;
        }
        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("Passwd not between", value1, value2, "passwd");
            return (Criteria) this;
        }
        public Criteria andSignatureIsNull() {
            addCriterion("Signature is null");
            return (Criteria) this;
        }
        public Criteria andSignatureIsNotNull() {
            addCriterion("Signature is not null");
            return (Criteria) this;
        }
        public Criteria andSignatureEqualTo(String value) {
            addCriterion("Signature =", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("Signature <>", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("Signature >", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("Signature >=", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureLessThan(String value) {
            addCriterion("Signature <", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("Signature <=", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureLike(String value) {
            addCriterion("Signature like", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureNotLike(String value) {
            addCriterion("Signature not like", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureIn(List<String> values) {
            addCriterion("Signature in", values, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("Signature not in", values, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("Signature between", value1, value2, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("Signature not between", value1, value2, "signature");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitIsNull() {
            addCriterion("TotalSendLimit is null");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitIsNotNull() {
            addCriterion("TotalSendLimit is not null");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitEqualTo(Integer value) {
            addCriterion("TotalSendLimit =", value, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitNotEqualTo(Integer value) {
            addCriterion("TotalSendLimit <>", value, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitGreaterThan(Integer value) {
            addCriterion("TotalSendLimit >", value, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("TotalSendLimit >=", value, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitLessThan(Integer value) {
            addCriterion("TotalSendLimit <", value, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitLessThanOrEqualTo(Integer value) {
            addCriterion("TotalSendLimit <=", value, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitIn(List<Integer> values) {
            addCriterion("TotalSendLimit in", values, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitNotIn(List<Integer> values) {
            addCriterion("TotalSendLimit not in", values, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitBetween(Integer value1, Integer value2) {
            addCriterion("TotalSendLimit between", value1, value2, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andTotalSendLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("TotalSendLimit not between", value1, value2, "totalSendLimit");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendIsNull() {
            addCriterion("DailyMaxSend is null");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendIsNotNull() {
            addCriterion("DailyMaxSend is not null");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendEqualTo(Integer value) {
            addCriterion("DailyMaxSend =", value, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendNotEqualTo(Integer value) {
            addCriterion("DailyMaxSend <>", value, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendGreaterThan(Integer value) {
            addCriterion("DailyMaxSend >", value, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendGreaterThanOrEqualTo(Integer value) {
            addCriterion("DailyMaxSend >=", value, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendLessThan(Integer value) {
            addCriterion("DailyMaxSend <", value, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendLessThanOrEqualTo(Integer value) {
            addCriterion("DailyMaxSend <=", value, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendIn(List<Integer> values) {
            addCriterion("DailyMaxSend in", values, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendNotIn(List<Integer> values) {
            addCriterion("DailyMaxSend not in", values, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendBetween(Integer value1, Integer value2) {
            addCriterion("DailyMaxSend between", value1, value2, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andDailyMaxSendNotBetween(Integer value1, Integer value2) {
            addCriterion("DailyMaxSend not between", value1, value2, "dailyMaxSend");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvIsNull() {
            addCriterion("MemberDailyMaxRecv is null");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvIsNotNull() {
            addCriterion("MemberDailyMaxRecv is not null");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvEqualTo(Short value) {
            addCriterion("MemberDailyMaxRecv =", value, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvNotEqualTo(Short value) {
            addCriterion("MemberDailyMaxRecv <>", value, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvGreaterThan(Short value) {
            addCriterion("MemberDailyMaxRecv >", value, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvGreaterThanOrEqualTo(Short value) {
            addCriterion("MemberDailyMaxRecv >=", value, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvLessThan(Short value) {
            addCriterion("MemberDailyMaxRecv <", value, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvLessThanOrEqualTo(Short value) {
            addCriterion("MemberDailyMaxRecv <=", value, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvIn(List<Short> values) {
            addCriterion("MemberDailyMaxRecv in", values, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvNotIn(List<Short> values) {
            addCriterion("MemberDailyMaxRecv not in", values, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvBetween(Short value1, Short value2) {
            addCriterion("MemberDailyMaxRecv between", value1, value2, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxRecvNotBetween(Short value1, Short value2) {
            addCriterion("MemberDailyMaxRecv not between", value1, value2, "memberDailyMaxRecv");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplIsNull() {
            addCriterion("MemberDailyMaxRepl is null");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplIsNotNull() {
            addCriterion("MemberDailyMaxRepl is not null");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplEqualTo(Byte value) {
            addCriterion("MemberDailyMaxRepl =", value, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplNotEqualTo(Byte value) {
            addCriterion("MemberDailyMaxRepl <>", value, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplGreaterThan(Byte value) {
            addCriterion("MemberDailyMaxRepl >", value, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplGreaterThanOrEqualTo(Byte value) {
            addCriterion("MemberDailyMaxRepl >=", value, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplLessThan(Byte value) {
            addCriterion("MemberDailyMaxRepl <", value, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplLessThanOrEqualTo(Byte value) {
            addCriterion("MemberDailyMaxRepl <=", value, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplIn(List<Byte> values) {
            addCriterion("MemberDailyMaxRepl in", values, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplNotIn(List<Byte> values) {
            addCriterion("MemberDailyMaxRepl not in", values, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplBetween(Byte value1, Byte value2) {
            addCriterion("MemberDailyMaxRepl between", value1, value2, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andMemberDailyMaxReplNotBetween(Byte value1, Byte value2) {
            addCriterion("MemberDailyMaxRepl not between", value1, value2, "memberDailyMaxRepl");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeIsNull() {
            addCriterion("SendStartTime is null");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeIsNotNull() {
            addCriterion("SendStartTime is not null");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("SendStartTime =", value, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("SendStartTime <>", value, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("SendStartTime >", value, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("SendStartTime >=", value, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("SendStartTime <", value, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("SendStartTime <=", value, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("SendStartTime in", values, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("SendStartTime not in", values, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("SendStartTime between", value1, value2, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("SendStartTime not between", value1, value2, "sendStartTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeIsNull() {
            addCriterion("SendEndTime is null");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeIsNotNull() {
            addCriterion("SendEndTime is not null");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("SendEndTime =", value, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("SendEndTime <>", value, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("SendEndTime >", value, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("SendEndTime >=", value, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("SendEndTime <", value, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("SendEndTime <=", value, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("SendEndTime in", values, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("SendEndTime not in", values, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("SendEndTime between", value1, value2, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andSendEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("SendEndTime not between", value1, value2, "sendEndTime");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoIsNull() {
            addCriterion("CaptchaTempletNo is null");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoIsNotNull() {
            addCriterion("CaptchaTempletNo is not null");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoEqualTo(String value) {
            addCriterion("CaptchaTempletNo =", value, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoNotEqualTo(String value) {
            addCriterion("CaptchaTempletNo <>", value, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoGreaterThan(String value) {
            addCriterion("CaptchaTempletNo >", value, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoGreaterThanOrEqualTo(String value) {
            addCriterion("CaptchaTempletNo >=", value, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoLessThan(String value) {
            addCriterion("CaptchaTempletNo <", value, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoLessThanOrEqualTo(String value) {
            addCriterion("CaptchaTempletNo <=", value, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoLike(String value) {
            addCriterion("CaptchaTempletNo like", value, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoNotLike(String value) {
            addCriterion("CaptchaTempletNo not like", value, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoIn(List<String> values) {
            addCriterion("CaptchaTempletNo in", values, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoNotIn(List<String> values) {
            addCriterion("CaptchaTempletNo not in", values, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoBetween(String value1, String value2) {
            addCriterion("CaptchaTempletNo between", value1, value2, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andCaptchaTempletNoNotBetween(String value1, String value2) {
            addCriterion("CaptchaTempletNo not between", value1, value2, "captchaTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoIsNull() {
            addCriterion("InviteSMSTempletNo is null");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoIsNotNull() {
            addCriterion("InviteSMSTempletNo is not null");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoEqualTo(String value) {
            addCriterion("InviteSMSTempletNo =", value, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoNotEqualTo(String value) {
            addCriterion("InviteSMSTempletNo <>", value, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoGreaterThan(String value) {
            addCriterion("InviteSMSTempletNo >", value, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoGreaterThanOrEqualTo(String value) {
            addCriterion("InviteSMSTempletNo >=", value, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoLessThan(String value) {
            addCriterion("InviteSMSTempletNo <", value, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoLessThanOrEqualTo(String value) {
            addCriterion("InviteSMSTempletNo <=", value, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoLike(String value) {
            addCriterion("InviteSMSTempletNo like", value, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoNotLike(String value) {
            addCriterion("InviteSMSTempletNo not like", value, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoIn(List<String> values) {
            addCriterion("InviteSMSTempletNo in", values, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoNotIn(List<String> values) {
            addCriterion("InviteSMSTempletNo not in", values, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoBetween(String value1, String value2) {
            addCriterion("InviteSMSTempletNo between", value1, value2, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andInviteSMSTempletNoNotBetween(String value1, String value2) {
            addCriterion("InviteSMSTempletNo not between", value1, value2, "inviteSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoIsNull() {
            addCriterion("TestSMSTempletNo is null");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoIsNotNull() {
            addCriterion("TestSMSTempletNo is not null");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoEqualTo(String value) {
            addCriterion("TestSMSTempletNo =", value, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoNotEqualTo(String value) {
            addCriterion("TestSMSTempletNo <>", value, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoGreaterThan(String value) {
            addCriterion("TestSMSTempletNo >", value, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoGreaterThanOrEqualTo(String value) {
            addCriterion("TestSMSTempletNo >=", value, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoLessThan(String value) {
            addCriterion("TestSMSTempletNo <", value, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoLessThanOrEqualTo(String value) {
            addCriterion("TestSMSTempletNo <=", value, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoLike(String value) {
            addCriterion("TestSMSTempletNo like", value, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoNotLike(String value) {
            addCriterion("TestSMSTempletNo not like", value, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoIn(List<String> values) {
            addCriterion("TestSMSTempletNo in", values, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoNotIn(List<String> values) {
            addCriterion("TestSMSTempletNo not in", values, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoBetween(String value1, String value2) {
            addCriterion("TestSMSTempletNo between", value1, value2, "testSMSTempletNo");
            return (Criteria) this;
        }
        public Criteria andTestSMSTempletNoNotBetween(String value1, String value2) {
            addCriterion("TestSMSTempletNo not between", value1, value2, "testSMSTempletNo");
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
     * [3.0]短信配置
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