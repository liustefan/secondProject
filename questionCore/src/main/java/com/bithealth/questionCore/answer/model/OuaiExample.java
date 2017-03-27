/*
 * OuaiExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class OuaiExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OuaiExample() {
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
     * 会员答卷信息表（OUAI）
     * 
     * @author ${user}
     * @version 1.0 2016-07-18
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
        protected void addCriterion(List<String> conditions, String value) {
            if (conditions == null) {
                  return;//
            }
            criteria.add(new Criterion(conditions, value));
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
        public Criteria andAnsNumberIsNull() {
            addCriterion("ouai.AnsNumber is null");
            return (Criteria) this;
        }
        public Criteria andAnsNumberIsNotNull() {
            addCriterion("ouai.AnsNumber is not null");
            return (Criteria) this;
        }
        public Criteria andAnsNumberEqualTo(Integer value) {
            addCriterion("ouai.AnsNumber =", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotEqualTo(Integer value) {
            addCriterion("ouai.AnsNumber <>", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberGreaterThan(Integer value) {
            addCriterion("ouai.AnsNumber >", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ouai.AnsNumber >=", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberLessThan(Integer value) {
            addCriterion("ouai.AnsNumber <", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("ouai.AnsNumber <=", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberIn(List<Integer> values) {
            addCriterion("ouai.AnsNumber in", values, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotIn(List<Integer> values) {
            addCriterion("ouai.AnsNumber not in", values, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberBetween(Integer value1, Integer value2) {
            addCriterion("ouai.AnsNumber between", value1, value2, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ouai.AnsNumber not between", value1, value2, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNull() {
            addCriterion("ouai.Memberid is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("ouai.Memberid is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("ouai.Memberid =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("ouai.Memberid <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("ouai.Memberid >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ouai.Memberid >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("ouai.Memberid <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("ouai.Memberid <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("ouai.Memberid in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("ouai.Memberid not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("ouai.Memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("ouai.Memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andQustidIsNull() {
            addCriterion("ouai.Qustid is null");
            return (Criteria) this;
        }
        public Criteria andQustidIsNotNull() {
            addCriterion("ouai.Qustid is not null");
            return (Criteria) this;
        }
        public Criteria andQustidEqualTo(Integer value) {
            addCriterion("ouai.Qustid =", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotEqualTo(Integer value) {
            addCriterion("ouai.Qustid <>", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidGreaterThan(Integer value) {
            addCriterion("ouai.Qustid >", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ouai.Qustid >=", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidLessThan(Integer value) {
            addCriterion("ouai.Qustid <", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidLessThanOrEqualTo(Integer value) {
            addCriterion("ouai.Qustid <=", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidIn(List<Integer> values) {
            addCriterion("ouai.Qustid in", values, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotIn(List<Integer> values) {
            addCriterion("ouai.Qustid not in", values, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidBetween(Integer value1, Integer value2) {
            addCriterion("ouai.Qustid between", value1, value2, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotBetween(Integer value1, Integer value2) {
            addCriterion("ouai.Qustid not between", value1, value2, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustVerIsNull() {
            addCriterion("ouai.QustVer is null");
            return (Criteria) this;
        }
        public Criteria andQustVerIsNotNull() {
            addCriterion("ouai.QustVer is not null");
            return (Criteria) this;
        }
        public Criteria andQustVerEqualTo(String value) {
            addCriterion("ouai.QustVer =", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotEqualTo(String value) {
            addCriterion("ouai.QustVer <>", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerGreaterThan(String value) {
            addCriterion("ouai.QustVer >", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerGreaterThanOrEqualTo(String value) {
            addCriterion("ouai.QustVer >=", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLessThan(String value) {
            addCriterion("ouai.QustVer <", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLessThanOrEqualTo(String value) {
            addCriterion("ouai.QustVer <=", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLike(String value) {
            addCriterion("ouai.QustVer like", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotLike(String value) {
            addCriterion("ouai.QustVer not like", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerIn(List<String> values) {
            addCriterion("ouai.QustVer in", values, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotIn(List<String> values) {
            addCriterion("ouai.QustVer not in", values, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerBetween(String value1, String value2) {
            addCriterion("ouai.QustVer between", value1, value2, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotBetween(String value1, String value2) {
            addCriterion("ouai.QustVer not between", value1, value2, "qustVer");
            return (Criteria) this;
        }
        public Criteria andAssessDateIsNull() {
            addCriterion("ouai.AssessDate is null");
            return (Criteria) this;
        }
        public Criteria andAssessDateIsNotNull() {
            addCriterion("ouai.AssessDate is not null");
            return (Criteria) this;
        }
        public Criteria andAssessDateEqualTo(Date value) {
            addCriterionForJDBCDate("ouai.AssessDate =", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ouai.AssessDate <>", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ouai.AssessDate >", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ouai.AssessDate >=", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateLessThan(Date value) {
            addCriterionForJDBCDate("ouai.AssessDate <", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ouai.AssessDate <=", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateIn(List<Date> values) {
            addCriterionForJDBCDate("ouai.AssessDate in", values, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ouai.AssessDate not in", values, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ouai.AssessDate between", value1, value2, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ouai.AssessDate not between", value1, value2, "assessDate");
            return (Criteria) this;
        }
        public Criteria andChTagIsNull() {
            addCriterion("ouai.ChTag is null");
            return (Criteria) this;
        }
        public Criteria andChTagIsNotNull() {
            addCriterion("ouai.ChTag is not null");
            return (Criteria) this;
        }
        public Criteria andChTagEqualTo(String value) {
            addCriterion("ouai.ChTag =", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotEqualTo(String value) {
            addCriterion("ouai.ChTag <>", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagGreaterThan(String value) {
            addCriterion("ouai.ChTag >", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagGreaterThanOrEqualTo(String value) {
            addCriterion("ouai.ChTag >=", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLessThan(String value) {
            addCriterion("ouai.ChTag <", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLessThanOrEqualTo(String value) {
            addCriterion("ouai.ChTag <=", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLike(String value) {
            addCriterion("ouai.ChTag like", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotLike(String value) {
            addCriterion("ouai.ChTag not like", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagIn(List<String> values) {
            addCriterion("ouai.ChTag in", values, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotIn(List<String> values) {
            addCriterion("ouai.ChTag not in", values, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagBetween(String value1, String value2) {
            addCriterion("ouai.ChTag between", value1, value2, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotBetween(String value1, String value2) {
            addCriterion("ouai.ChTag not between", value1, value2, "chTag");
            return (Criteria) this;
        }
        public Criteria andQustTagIsNull() {
            addCriterion("ouai.QustTag is null");
            return (Criteria) this;
        }
        public Criteria andQustTagIsNotNull() {
            addCriterion("ouai.QustTag is not null");
            return (Criteria) this;
        }
        public Criteria andQustTagEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("ouai.QustTag =", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagNotEqualTo(String value) {
            addCriterion("ouai.QustTag <>", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagGreaterThan(String value) {
            addCriterion("ouai.QustTag >", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagGreaterThanOrEqualTo(String value) {
            addCriterion("ouai.QustTag >=", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagLessThan(String value) {
            addCriterion("ouai.QustTag <", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagLessThanOrEqualTo(String value) {
            addCriterion("ouai.QustTag <=", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagLike(String value) {
            addCriterion("ouai.QustTag like", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagNotLike(String value) {
            addCriterion("ouai.QustTag not like", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagIn(List<String> values) {
            addCriterion("ouai.QustTag in", values, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagNotIn(List<String> values) {
            addCriterion("ouai.QustTag not in", values, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagBetween(String value1, String value2) {
            addCriterion("ouai.QustTag between", value1, value2, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagNotBetween(String value1, String value2) {
            addCriterion("ouai.QustTag not between", value1, value2, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustCodeIsNull() {
            addCriterion("ouai.QustCode is null");
            return (Criteria) this;
        }
        public Criteria andQustCodeIsNotNull() {
            addCriterion("ouai.QustCode is not null");
            return (Criteria) this;
        }
        public Criteria andQustCodeEqualTo(String value) {
            addCriterion("ouai.QustCode =", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotEqualTo(String value) {
            addCriterion("ouai.QustCode <>", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeGreaterThan(String value) {
            addCriterion("ouai.QustCode >", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ouai.QustCode >=", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLessThan(String value) {
            addCriterion("ouai.QustCode <", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLessThanOrEqualTo(String value) {
            addCriterion("ouai.QustCode <=", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLike(String value) {
            addCriterion("ouai.QustCode like", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotLike(String value) {
            addCriterion("ouai.QustCode not like", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeIn(List<String> values) {
            addCriterion("ouai.QustCode in", values, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotIn(List<String> values) {
            addCriterion("ouai.QustCode not in", values, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeBetween(String value1, String value2) {
            addCriterion("ouai.QustCode between", value1, value2, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotBetween(String value1, String value2) {
            addCriterion("ouai.QustCode not between", value1, value2, "qustCode");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeIsNull() {
            addCriterion("ouai.PublisherTime is null");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeIsNotNull() {
            addCriterion("ouai.PublisherTime is not null");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeEqualTo(Date value) {
            addCriterion("ouai.PublisherTime =", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeNotEqualTo(Date value) {
            addCriterion("ouai.PublisherTime <>", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeGreaterThan(Date value) {
            addCriterion("ouai.PublisherTime >", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ouai.PublisherTime >=", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeLessThan(Date value) {
            addCriterion("ouai.PublisherTime <", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeLessThanOrEqualTo(Date value) {
            addCriterion("ouai.PublisherTime <=", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeIn(List<Date> values) {
            addCriterion("ouai.PublisherTime in", values, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeNotIn(List<Date> values) {
            addCriterion("ouai.PublisherTime not in", values, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeBetween(Date value1, Date value2) {
            addCriterion("ouai.PublisherTime between", value1, value2, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeNotBetween(Date value1, Date value2) {
            addCriterion("ouai.PublisherTime not between", value1, value2, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeIsNull() {
            addCriterion("ouai.FailureTime is null");
            return (Criteria) this;
        }
        public Criteria andFailureTimeIsNotNull() {
            addCriterion("ouai.FailureTime is not null");
            return (Criteria) this;
        }
        public Criteria andFailureTimeEqualTo(Date value) {
            addCriterion("ouai.FailureTime =", value, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeNotEqualTo(Date value) {
            addCriterion("ouai.FailureTime <>", value, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeGreaterThan(Date value) {
            addCriterion("ouai.FailureTime >", value, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ouai.FailureTime >=", value, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeLessThan(Date value) {
            addCriterion("ouai.FailureTime <", value, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeLessThanOrEqualTo(Date value) {
            addCriterion("ouai.FailureTime <=", value, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeIn(List<Date> values) {
            addCriterion("ouai.FailureTime in", values, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeNotIn(List<Date> values) {
            addCriterion("ouai.FailureTime not in", values, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeBetween(Date value1, Date value2) {
            addCriterion("ouai.FailureTime between", value1, value2, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFailureTimeNotBetween(Date value1, Date value2) {
            addCriterion("ouai.FailureTime not between", value1, value2, "failureTime");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNull() {
            addCriterion("ouai.FunId is null");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNotNull() {
            addCriterion("ouai.FunId is not null");
            return (Criteria) this;
        }
        public Criteria andFunIdEqualTo(Short value) {
            addCriterion("ouai.FunId =", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotEqualTo(Short value) {
            addCriterion("ouai.FunId <>", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThan(Short value) {
            addCriterion("ouai.FunId >", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThanOrEqualTo(Short value) {
            addCriterion("ouai.FunId >=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThan(Short value) {
            addCriterion("ouai.FunId <", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThanOrEqualTo(Short value) {
            addCriterion("ouai.FunId <=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdIn(List<Short> values) {
            addCriterion("ouai.FunId in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotIn(List<Short> values) {
            addCriterion("ouai.FunId not in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdBetween(Short value1, Short value2) {
            addCriterion("ouai.FunId between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotBetween(Short value1, Short value2) {
            addCriterion("ouai.FunId not between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNull() {
            addCriterion("ouai.OptId is null");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNotNull() {
            addCriterion("ouai.OptId is not null");
            return (Criteria) this;
        }
        public Criteria andOptIdEqualTo(Short value) {
            addCriterion("ouai.OptId =", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotEqualTo(Short value) {
            addCriterion("ouai.OptId <>", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThan(Short value) {
            addCriterion("ouai.OptId >", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThanOrEqualTo(Short value) {
            addCriterion("ouai.OptId >=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThan(Short value) {
            addCriterion("ouai.OptId <", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThanOrEqualTo(Short value) {
            addCriterion("ouai.OptId <=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdIn(List<Short> values) {
            addCriterion("ouai.OptId in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotIn(List<Short> values) {
            addCriterion("ouai.OptId not in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdBetween(Short value1, Short value2) {
            addCriterion("ouai.OptId between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotBetween(Short value1, Short value2) {
            addCriterion("ouai.OptId not between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andDocidIsNull() {
            addCriterion("ouai.Docid is null");
            return (Criteria) this;
        }
        public Criteria andDocidIsNotNull() {
            addCriterion("ouai.Docid is not null");
            return (Criteria) this;
        }
        public Criteria andDocidEqualTo(Integer value) {
            addCriterion("ouai.Docid =", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotEqualTo(Integer value) {
            addCriterion("ouai.Docid <>", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThan(Integer value) {
            addCriterion("ouai.Docid >", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ouai.Docid >=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThan(Integer value) {
            addCriterion("ouai.Docid <", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThanOrEqualTo(Integer value) {
            addCriterion("ouai.Docid <=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidIn(List<Integer> values) {
            addCriterion("ouai.Docid in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotIn(List<Integer> values) {
            addCriterion("ouai.Docid not in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidBetween(Integer value1, Integer value2) {
            addCriterion("ouai.Docid between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotBetween(Integer value1, Integer value2) {
            addCriterion("ouai.Docid not between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andDocNameIsNull() {
            addCriterion("ouai.DocName is null");
            return (Criteria) this;
        }
        public Criteria andDocNameIsNotNull() {
            addCriterion("ouai.DocName is not null");
            return (Criteria) this;
        }
        public Criteria andDocNameEqualTo(String value) {
            addCriterion("ouai.DocName =", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotEqualTo(String value) {
            addCriterion("ouai.DocName <>", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameGreaterThan(String value) {
            addCriterion("ouai.DocName >", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameGreaterThanOrEqualTo(String value) {
            addCriterion("ouai.DocName >=", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLessThan(String value) {
            addCriterion("ouai.DocName <", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLessThanOrEqualTo(String value) {
            addCriterion("ouai.DocName <=", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("ouai.DocName like", "%"+value+"%", "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotLike(String value) {
            addCriterion("ouai.DocName not like", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameIn(List<String> values) {
            addCriterion("ouai.DocName in", values, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotIn(List<String> values) {
            addCriterion("ouai.DocName not in", values, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameBetween(String value1, String value2) {
            addCriterion("ouai.DocName between", value1, value2, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotBetween(String value1, String value2) {
            addCriterion("ouai.DocName not between", value1, value2, "docName");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIsNull() {
            addCriterion("ouai.answerTime is null");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIsNotNull() {
            addCriterion("ouai.answerTime is not null");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeEqualTo(Date value) {
            addCriterion("ouai.answerTime =", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotEqualTo(Date value) {
            addCriterion("ouai.answerTime <>", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeGreaterThan(Date value) {
            addCriterion("ouai.answerTime >", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ouai.answerTime >=", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeLessThan(Date value) {
            addCriterion("ouai.answerTime <", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeLessThanOrEqualTo(Date value) {
            addCriterion("ouai.answerTime <=", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIn(List<Date> values) {
            addCriterion("ouai.answerTime in", values, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotIn(List<Date> values) {
            addCriterion("ouai.answerTime not in", values, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeBetween(Date value1, Date value2) {
            addCriterion("ouai.answerTime between", value1, value2, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotBetween(Date value1, Date value2) {
            addCriterion("ouai.answerTime not between", value1, value2, "answerTime");
            return (Criteria) this;
        }
        public Criteria andReadStatusIsNull() {
            addCriterion("ouai.readStatus is null");
            return (Criteria) this;
        }
        public Criteria andReadStatusIsNotNull() {
            addCriterion("ouai.readStatus is not null");
            return (Criteria) this;
        }
        public Criteria andReadStatusEqualTo(Integer value) {
            addCriterion("ouai.readStatus =", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusNotEqualTo(Integer value) {
            addCriterion("ouai.readStatus <>", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusGreaterThan(Integer value) {
            addCriterion("ouai.readStatus >", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ouai.readStatus >=", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusLessThan(Integer value) {
            addCriterion("ouai.readStatus <", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ouai.readStatus <=", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusIn(List<Integer> values) {
            addCriterion("ouai.readStatus in", values, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusNotIn(List<Integer> values) {
            addCriterion("ouai.readStatus not in", values, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusBetween(Integer value1, Integer value2) {
            addCriterion("ouai.readStatus between", value1, value2, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ouai.readStatus not between", value1, value2, "readStatus");
            return (Criteria) this;
        }
        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("omem.orgId =", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andHExamIDEqualTo(Long value) {
            addCriterion("ouai.HExamID =", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andMemberNameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("omem.MemName like", "%"+value+"%", "MemName");
            return (Criteria) this;
        }
        public Criteria andQustNameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("omfq.Qustname like", "%"+value+"%", "Qustname");
            return (Criteria) this;
        }
        public Criteria andMemberNameOrDocNameOrQustNameLike(String criteria){
        	if(StringUtils.isNotEmpty(criteria)){
        		List<String > conditions = new ArrayList<String>();
        		conditions.add("omem.MemName like");
        		conditions.add("ouai.DocName like");
        		conditions.add("omfq.Qustname like");
        		addCriterion(conditions, "%"+criteria+"%");
        	}
        	return (Criteria) this;
        }
        public Criteria andMSETaskIDEqualTo(Long value) {
            addCriterion("ouai.MSETaskID =", value, "MSETaskID");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员答卷信息表（OUAI）
     * 
     * @author ${user}
     * @version 1.0 2016-07-18
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
        private boolean listOr;
        private List<String> conditions;

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
        public boolean isListOr() {
			return listOr;
		}
		
		public List<String> getConditions() {
			return conditions;
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
        protected Criterion(List<String> conditions, String value) {
            super();
            if(conditions.size() > 0){
            	this.conditions = conditions;
            	this.value = value;
            	this.typeHandler = null;
            	this.listOr = true;
            }
        }
    }
}