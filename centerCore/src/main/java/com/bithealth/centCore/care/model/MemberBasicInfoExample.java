/*
 * MemberBasicInfoExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-01 Created
 */
package com.bithealth.centCore.care.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MemberBasicInfoExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemberBasicInfoExample() {
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
     * [1.1]会员表
     * 
     * @author ${user}
     * @version 1.0 2016-09-01
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
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                 return;
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }
        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                  return;//
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }
        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                  return;//
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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
        public Criteria andMemberNameIsNull() {
            addCriterion("MemberName is null");
            return (Criteria) this;
        }
        public Criteria andMemberNameIsNotNull() {
            addCriterion("MemberName is not null");
            return (Criteria) this;
        }
        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("MemberName =", value, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("MemberName <>", value, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("MemberName >", value, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("MemberName >=", value, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameLessThan(String value) {
            addCriterion("MemberName <", value, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("MemberName <=", value, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameLike(String value) {
            addCriterion("MemberName like", value, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameNotLike(String value) {
            addCriterion("MemberName not like", value, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("MemberName in", values, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("MemberName not in", values, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("MemberName between", value1, value2, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("MemberName not between", value1, value2, "memberName");
            return (Criteria) this;
        }
        public Criteria andMemberSexIsNull() {
            addCriterion("MemberSex is null");
            return (Criteria) this;
        }
        public Criteria andMemberSexIsNotNull() {
            addCriterion("MemberSex is not null");
            return (Criteria) this;
        }
        public Criteria andMemberSexEqualTo(Byte value) {
            addCriterion("MemberSex =", value, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexNotEqualTo(Byte value) {
            addCriterion("MemberSex <>", value, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexGreaterThan(Byte value) {
            addCriterion("MemberSex >", value, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("MemberSex >=", value, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexLessThan(Byte value) {
            addCriterion("MemberSex <", value, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexLessThanOrEqualTo(Byte value) {
            addCriterion("MemberSex <=", value, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexIn(List<Byte> values) {
            addCriterion("MemberSex in", values, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexNotIn(List<Byte> values) {
            addCriterion("MemberSex not in", values, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexBetween(Byte value1, Byte value2) {
            addCriterion("MemberSex between", value1, value2, "memberSex");
            return (Criteria) this;
        }
        public Criteria andMemberSexNotBetween(Byte value1, Byte value2) {
            addCriterion("MemberSex not between", value1, value2, "memberSex");
            return (Criteria) this;
        }
        public Criteria andBirthdayIsNull() {
            addCriterion("Birthday is null");
            return (Criteria) this;
        }
        public Criteria andBirthdayIsNotNull() {
            addCriterion("Birthday is not null");
            return (Criteria) this;
        }
        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("Birthday =", value, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("Birthday <>", value, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("Birthday >", value, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Birthday >=", value, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("Birthday <", value, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Birthday <=", value, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("Birthday in", values, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("Birthday not in", values, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }
        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }
        public Criteria andMobileIsNull() {
            addCriterion("Mobile is null");
            return (Criteria) this;
        }
        public Criteria andMobileIsNotNull() {
            addCriterion("Mobile is not null");
            return (Criteria) this;
        }
        public Criteria andMobileEqualTo(String value) {
            addCriterion("Mobile =", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("Mobile <>", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileGreaterThan(String value) {
            addCriterion("Mobile >", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("Mobile >=", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileLessThan(String value) {
            addCriterion("Mobile <", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("Mobile <=", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileLike(String value) {
            addCriterion("Mobile like", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileNotLike(String value) {
            addCriterion("Mobile not like", value, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileIn(List<String> values) {
            addCriterion("Mobile in", values, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("Mobile not in", values, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("Mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }
        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("Mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }
        public Criteria andIDCardIsNull() {
            addCriterion("IDCard is null");
            return (Criteria) this;
        }
        public Criteria andIDCardIsNotNull() {
            addCriterion("IDCard is not null");
            return (Criteria) this;
        }
        public Criteria andIDCardEqualTo(String value) {
            addCriterion("IDCard =", value, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardNotEqualTo(String value) {
            addCriterion("IDCard <>", value, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardGreaterThan(String value) {
            addCriterion("IDCard >", value, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardGreaterThanOrEqualTo(String value) {
            addCriterion("IDCard >=", value, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardLessThan(String value) {
            addCriterion("IDCard <", value, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardLessThanOrEqualTo(String value) {
            addCriterion("IDCard <=", value, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardLike(String value) {
            addCriterion("IDCard like", value, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardNotLike(String value) {
            addCriterion("IDCard not like", value, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardIn(List<String> values) {
            addCriterion("IDCard in", values, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardNotIn(List<String> values) {
            addCriterion("IDCard not in", values, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardBetween(String value1, String value2) {
            addCriterion("IDCard between", value1, value2, "IDCard");
            return (Criteria) this;
        }
        public Criteria andIDCardNotBetween(String value1, String value2) {
            addCriterion("IDCard not between", value1, value2, "IDCard");
            return (Criteria) this;
        }
        public Criteria andHeadAddressIsNull() {
            addCriterion("HeadAddress is null");
            return (Criteria) this;
        }
        public Criteria andHeadAddressIsNotNull() {
            addCriterion("HeadAddress is not null");
            return (Criteria) this;
        }
        public Criteria andHeadAddressEqualTo(String value) {
            addCriterion("HeadAddress =", value, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressNotEqualTo(String value) {
            addCriterion("HeadAddress <>", value, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressGreaterThan(String value) {
            addCriterion("HeadAddress >", value, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressGreaterThanOrEqualTo(String value) {
            addCriterion("HeadAddress >=", value, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressLessThan(String value) {
            addCriterion("HeadAddress <", value, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressLessThanOrEqualTo(String value) {
            addCriterion("HeadAddress <=", value, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressLike(String value) {
            addCriterion("HeadAddress like", value, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressNotLike(String value) {
            addCriterion("HeadAddress not like", value, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressIn(List<String> values) {
            addCriterion("HeadAddress in", values, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressNotIn(List<String> values) {
            addCriterion("HeadAddress not in", values, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressBetween(String value1, String value2) {
            addCriterion("HeadAddress between", value1, value2, "headAddress");
            return (Criteria) this;
        }
        public Criteria andHeadAddressNotBetween(String value1, String value2) {
            addCriterion("HeadAddress not between", value1, value2, "headAddress");
            return (Criteria) this;
        }
        public Criteria andPwdIsNull() {
            addCriterion("Pwd is null");
            return (Criteria) this;
        }
        public Criteria andPwdIsNotNull() {
            addCriterion("Pwd is not null");
            return (Criteria) this;
        }
        public Criteria andPwdEqualTo(String value) {
            addCriterion("Pwd =", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("Pwd <>", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdGreaterThan(String value) {
            addCriterion("Pwd >", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("Pwd >=", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdLessThan(String value) {
            addCriterion("Pwd <", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("Pwd <=", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdLike(String value) {
            addCriterion("Pwd like", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdNotLike(String value) {
            addCriterion("Pwd not like", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdIn(List<String> values) {
            addCriterion("Pwd in", values, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("Pwd not in", values, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("Pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("Pwd not between", value1, value2, "pwd");
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
     * [1.1]会员表
     * 
     * @author ${user}
     * @version 1.0 2016-09-01
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