/*
 * SmsSendExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.centCore.sms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsSendExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SmsSendExample() {
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
     * [3.0]短信发送
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
        public Criteria andOrgNameIsNull() {
            addCriterion("OrgName is null");
            return (Criteria) this;
        }
        public Criteria andOrgNameIsNotNull() {
            addCriterion("OrgName is not null");
            return (Criteria) this;
        }
        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("OrgName =", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("OrgName <>", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("OrgName >", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("OrgName >=", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameLessThan(String value) {
            addCriterion("OrgName <", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("OrgName <=", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameLike(String value) {
            addCriterion("OrgName like", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameNotLike(String value) {
            addCriterion("OrgName not like", value, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("OrgName in", values, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("OrgName not in", values, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("OrgName between", value1, value2, "orgName");
            return (Criteria) this;
        }
        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("OrgName not between", value1, value2, "orgName");
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
        public Criteria andSmsTypeIsNull() {
            addCriterion("SmsType is null");
            return (Criteria) this;
        }
        public Criteria andSmsTypeIsNotNull() {
            addCriterion("SmsType is not null");
            return (Criteria) this;
        }
        public Criteria andSmsTypeEqualTo(Byte value) {
            addCriterion("SmsType =", value, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeNotEqualTo(Byte value) {
            addCriterion("SmsType <>", value, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeGreaterThan(Byte value) {
            addCriterion("SmsType >", value, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SmsType >=", value, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeLessThan(Byte value) {
            addCriterion("SmsType <", value, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeLessThanOrEqualTo(Byte value) {
            addCriterion("SmsType <=", value, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeIn(List<Byte> values) {
            addCriterion("SmsType in", values, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeNotIn(List<Byte> values) {
            addCriterion("SmsType not in", values, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeBetween(Byte value1, Byte value2) {
            addCriterion("SmsType between", value1, value2, "smsType");
            return (Criteria) this;
        }
        public Criteria andSmsTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SmsType not between", value1, value2, "smsType");
            return (Criteria) this;
        }
        public Criteria andPriorityIsNull() {
            addCriterion("Priority is null");
            return (Criteria) this;
        }
        public Criteria andPriorityIsNotNull() {
            addCriterion("Priority is not null");
            return (Criteria) this;
        }
        public Criteria andPriorityEqualTo(Byte value) {
            addCriterion("Priority =", value, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityNotEqualTo(Byte value) {
            addCriterion("Priority <>", value, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityGreaterThan(Byte value) {
            addCriterion("Priority >", value, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityGreaterThanOrEqualTo(Byte value) {
            addCriterion("Priority >=", value, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityLessThan(Byte value) {
            addCriterion("Priority <", value, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityLessThanOrEqualTo(Byte value) {
            addCriterion("Priority <=", value, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityIn(List<Byte> values) {
            addCriterion("Priority in", values, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityNotIn(List<Byte> values) {
            addCriterion("Priority not in", values, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityBetween(Byte value1, Byte value2) {
            addCriterion("Priority between", value1, value2, "priority");
            return (Criteria) this;
        }
        public Criteria andPriorityNotBetween(Byte value1, Byte value2) {
            addCriterion("Priority not between", value1, value2, "priority");
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
     * [3.0]短信发送
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