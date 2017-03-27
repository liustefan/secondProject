/*
 * OcamExample.java
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

public class OcamExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OcamExample() {
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
     * 会员组合答卷主表（OCAM）
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
        public Criteria andCombAnsidIsNull() {
            addCriterion("ocam.CombAnsid is null");
            return (Criteria) this;
        }
        public Criteria andCombAnsidIsNotNull() {
            addCriterion("ocam.CombAnsid is not null");
            return (Criteria) this;
        }
        public Criteria andCombAnsidEqualTo(Integer value) {
            addCriterion("ocam.CombAnsid =", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidNotEqualTo(Integer value) {
            addCriterion("ocam.CombAnsid <>", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidGreaterThan(Integer value) {
            addCriterion("ocam.CombAnsid >", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocam.CombAnsid >=", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidLessThan(Integer value) {
            addCriterion("ocam.CombAnsid <", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidLessThanOrEqualTo(Integer value) {
            addCriterion("ocam.CombAnsid <=", value, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidIn(List<Integer> values) {
            addCriterion("ocam.CombAnsid in", values, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidNotIn(List<Integer> values) {
            addCriterion("ocam.CombAnsid not in", values, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidBetween(Integer value1, Integer value2) {
            addCriterion("ocam.CombAnsid between", value1, value2, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombAnsidNotBetween(Integer value1, Integer value2) {
            addCriterion("ocam.CombAnsid not between", value1, value2, "combAnsid");
            return (Criteria) this;
        }
        public Criteria andCombQustidIsNull() {
            addCriterion("ocam.CombQustid is null");
            return (Criteria) this;
        }
        public Criteria andCombQustidIsNotNull() {
            addCriterion("ocam.CombQustid is not null");
            return (Criteria) this;
        }
        public Criteria andCombQustidEqualTo(Integer value) {
            addCriterion("ocam.CombQustid =", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotEqualTo(Integer value) {
            addCriterion("ocam.CombQustid <>", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidGreaterThan(Integer value) {
            addCriterion("ocam.CombQustid >", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocam.CombQustid >=", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidLessThan(Integer value) {
            addCriterion("ocam.CombQustid <", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidLessThanOrEqualTo(Integer value) {
            addCriterion("ocam.CombQustid <=", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidIn(List<Integer> values) {
            addCriterion("ocam.CombQustid in", values, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotIn(List<Integer> values) {
            addCriterion("ocam.CombQustid not in", values, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidBetween(Integer value1, Integer value2) {
            addCriterion("ocam.CombQustid between", value1, value2, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotBetween(Integer value1, Integer value2) {
            addCriterion("ocam.CombQustid not between", value1, value2, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustNameIsNull() {
            addCriterion("ocam.CombQustName is null");
            return (Criteria) this;
        }
        public Criteria andCombQustNameIsNotNull() {
            addCriterion("ocam.CombQustName is not null");
            return (Criteria) this;
        }
        public Criteria andCombQustNameEqualTo(String value) {
            addCriterion("ocam.CombQustName =", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameNotEqualTo(String value) {
            addCriterion("ocam.CombQustName <>", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameGreaterThan(String value) {
            addCriterion("ocam.CombQustName >", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameGreaterThanOrEqualTo(String value) {
            addCriterion("ocam.CombQustName >=", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameLessThan(String value) {
            addCriterion("ocam.CombQustName <", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameLessThanOrEqualTo(String value) {
            addCriterion("ocam.CombQustName <=", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("ocam.CombQustName like", "%"+value+"%", "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameNotLike(String value) {
            addCriterion("ocam.CombQustName not like", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameIn(List<String> values) {
            addCriterion("ocam.CombQustName in", values, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameNotIn(List<String> values) {
            addCriterion("ocam.CombQustName not in", values, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameBetween(String value1, String value2) {
            addCriterion("ocam.CombQustName between", value1, value2, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameNotBetween(String value1, String value2) {
            addCriterion("ocam.CombQustName not between", value1, value2, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeIsNull() {
            addCriterion("ocam.CombQustCode is null");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeIsNotNull() {
            addCriterion("ocam.CombQustCode is not null");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeEqualTo(Integer value) {
            addCriterion("ocam.CombQustCode =", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeNotEqualTo(Integer value) {
            addCriterion("ocam.CombQustCode <>", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeGreaterThan(Integer value) {
            addCriterion("ocam.CombQustCode >", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocam.CombQustCode >=", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeLessThan(Integer value) {
            addCriterion("ocam.CombQustCode <", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeLessThanOrEqualTo(Integer value) {
            addCriterion("ocam.CombQustCode <=", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeIn(List<Integer> values) {
            addCriterion("ocam.CombQustCode in", values, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeNotIn(List<Integer> values) {
            addCriterion("ocam.CombQustCode not in", values, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeBetween(Integer value1, Integer value2) {
            addCriterion("ocam.CombQustCode between", value1, value2, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("ocam.CombQustCode not between", value1, value2, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombDescIsNull() {
            addCriterion("ocam.CombDesc is null");
            return (Criteria) this;
        }
        public Criteria andCombDescIsNotNull() {
            addCriterion("ocam.CombDesc is not null");
            return (Criteria) this;
        }
        public Criteria andCombDescEqualTo(String value) {
            addCriterion("ocam.CombDesc =", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescNotEqualTo(String value) {
            addCriterion("ocam.CombDesc <>", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescGreaterThan(String value) {
            addCriterion("ocam.CombDesc >", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescGreaterThanOrEqualTo(String value) {
            addCriterion("ocam.CombDesc >=", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescLessThan(String value) {
            addCriterion("ocam.CombDesc <", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescLessThanOrEqualTo(String value) {
            addCriterion("ocam.CombDesc <=", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescLike(String value) {
            addCriterion("ocam.CombDesc like", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescNotLike(String value) {
            addCriterion("ocam.CombDesc not like", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescIn(List<String> values) {
            addCriterion("ocam.CombDesc in", values, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescNotIn(List<String> values) {
            addCriterion("ocam.CombDesc not in", values, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescBetween(String value1, String value2) {
            addCriterion("ocam.CombDesc between", value1, value2, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescNotBetween(String value1, String value2) {
            addCriterion("ocam.CombDesc not between", value1, value2, "combDesc");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeIsNull() {
            addCriterion("ocam.PublisherTime is null");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeIsNotNull() {
            addCriterion("ocam.PublisherTime is not null");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeEqualTo(Date value) {
            addCriterion("ocam.PublisherTime =", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeNotEqualTo(Date value) {
            addCriterion("ocam.PublisherTime <>", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeGreaterThan(Date value) {
            addCriterion("ocam.PublisherTime >", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ocam.PublisherTime >=", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeLessThan(Date value) {
            addCriterion("ocam.PublisherTime <", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeLessThanOrEqualTo(Date value) {
            addCriterion("ocam.PublisherTime <=", value, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeIn(List<Date> values) {
            addCriterion("ocam.PublisherTime in", values, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeNotIn(List<Date> values) {
            addCriterion("ocam.PublisherTime not in", values, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeBetween(Date value1, Date value2) {
            addCriterion("ocam.PublisherTime between", value1, value2, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andPublisherTimeNotBetween(Date value1, Date value2) {
            addCriterion("ocam.PublisherTime not between", value1, value2, "publisherTime");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNull() {
            addCriterion("ocam.Memberid is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("ocam.Memberid is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("ocam.Memberid =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("ocam.Memberid <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("ocam.Memberid >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocam.Memberid >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("ocam.Memberid <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("ocam.Memberid <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("ocam.Memberid in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("ocam.Memberid not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("ocam.Memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("ocam.Memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andChTagIsNull() {
            addCriterion("ocam.ChTag is null");
            return (Criteria) this;
        }
        public Criteria andChTagIsNotNull() {
            addCriterion("ocam.ChTag is not null");
            return (Criteria) this;
        }
        public Criteria andChTagEqualTo(String value) {
            addCriterion("ocam.ChTag =", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotEqualTo(String value) {
            addCriterion("ocam.ChTag <>", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagGreaterThan(String value) {
            addCriterion("ocam.ChTag >", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagGreaterThanOrEqualTo(String value) {
            addCriterion("ocam.ChTag >=", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLessThan(String value) {
            addCriterion("ocam.ChTag <", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLessThanOrEqualTo(String value) {
            addCriterion("ocam.ChTag <=", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLike(String value) {
            addCriterion("ocam.ChTag like", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotLike(String value) {
            addCriterion("ocam.ChTag not like", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagIn(List<String> values) {
            addCriterion("ocam.ChTag in", values, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotIn(List<String> values) {
            addCriterion("ocam.ChTag not in", values, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagBetween(String value1, String value2) {
            addCriterion("ocam.ChTag between", value1, value2, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotBetween(String value1, String value2) {
            addCriterion("ocam.ChTag not between", value1, value2, "chTag");
            return (Criteria) this;
        }
        public Criteria andCombTagIsNull() {
            addCriterion("ocam.CombTag is null");
            return (Criteria) this;
        }
        public Criteria andCombTagIsNotNull() {
            addCriterion("ocam.CombTag is not null");
            return (Criteria) this;
        }
        public Criteria andCombTagEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("ocam.CombTag =", value, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagNotEqualTo(String value) {
            addCriterion("ocam.CombTag <>", value, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagGreaterThan(String value) {
            addCriterion("ocam.CombTag >", value, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagGreaterThanOrEqualTo(String value) {
            addCriterion("ocam.CombTag >=", value, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagLessThan(String value) {
            addCriterion("ocam.CombTag <", value, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagLessThanOrEqualTo(String value) {
            addCriterion("ocam.CombTag <=", value, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagLike(String value) {
            addCriterion("ocam.CombTag like", value, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagNotLike(String value) {
            addCriterion("ocam.CombTag not like", value, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagIn(List<String> values) {
            addCriterion("ocam.CombTag in", values, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagNotIn(List<String> values) {
            addCriterion("ocam.CombTag not in", values, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagBetween(String value1, String value2) {
            addCriterion("ocam.CombTag between", value1, value2, "combTag");
            return (Criteria) this;
        }
        public Criteria andCombTagNotBetween(String value1, String value2) {
            addCriterion("ocam.CombTag not between", value1, value2, "combTag");
            return (Criteria) this;
        }
        public Criteria andAssessDateIsNull() {
            addCriterion("ocam.AssessDate is null");
            return (Criteria) this;
        }
        public Criteria andAssessDateIsNotNull() {
            addCriterion("ocam.AssessDate is not null");
            return (Criteria) this;
        }
        public Criteria andAssessDateEqualTo(Date value) {
            addCriterionForJDBCDate("ocam.AssessDate =", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ocam.AssessDate <>", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ocam.AssessDate >", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ocam.AssessDate >=", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateLessThan(Date value) {
            addCriterionForJDBCDate("ocam.AssessDate <", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ocam.AssessDate <=", value, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateIn(List<Date> values) {
            addCriterionForJDBCDate("ocam.AssessDate in", values, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ocam.AssessDate not in", values, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ocam.AssessDate between", value1, value2, "assessDate");
            return (Criteria) this;
        }
        public Criteria andAssessDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ocam.AssessDate not between", value1, value2, "assessDate");
            return (Criteria) this;
        }
        public Criteria andDocidIsNull() {
            addCriterion("ocam.Docid is null");
            return (Criteria) this;
        }
        public Criteria andDocidIsNotNull() {
            addCriterion("ocam.Docid is not null");
            return (Criteria) this;
        }
        public Criteria andDocidEqualTo(Integer value) {
            addCriterion("ocam.Docid =", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotEqualTo(Integer value) {
            addCriterion("ocam.Docid <>", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThan(Integer value) {
            addCriterion("ocam.Docid >", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocam.Docid >=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThan(Integer value) {
            addCriterion("ocam.Docid <", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThanOrEqualTo(Integer value) {
            addCriterion("ocam.Docid <=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidIn(List<Integer> values) {
            addCriterion("ocam.Docid in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotIn(List<Integer> values) {
            addCriterion("ocam.Docid not in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidBetween(Integer value1, Integer value2) {
            addCriterion("ocam.Docid between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotBetween(Integer value1, Integer value2) {
            addCriterion("ocam.Docid not between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andDocNameIsNull() {
            addCriterion("ocam.DocName is null");
            return (Criteria) this;
        }
        public Criteria andDocNameIsNotNull() {
            addCriterion("ocam.DocName is not null");
            return (Criteria) this;
        }
        public Criteria andDocNameEqualTo(String value) {
            addCriterion("ocam.DocName =", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotEqualTo(String value) {
            addCriterion("ocam.DocName <>", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameGreaterThan(String value) {
            addCriterion("ocam.DocName >", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameGreaterThanOrEqualTo(String value) {
            addCriterion("ocam.DocName >=", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLessThan(String value) {
            addCriterion("ocam.DocName <", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLessThanOrEqualTo(String value) {
            addCriterion("ocam.DocName <=", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("ocam.DocName like", "%"+value+"%", "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotLike(String value) {
            addCriterion("ocam.DocName not like", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameIn(List<String> values) {
            addCriterion("ocam.DocName in", values, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotIn(List<String> values) {
            addCriterion("ocam.DocName not in", values, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameBetween(String value1, String value2) {
            addCriterion("ocam.DocName between", value1, value2, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotBetween(String value1, String value2) {
            addCriterion("ocam.DocName not between", value1, value2, "docName");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIsNull() {
            addCriterion("ocam.answerTime is null");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIsNotNull() {
            addCriterion("ocam.answerTime is not null");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeEqualTo(Date value) {
            addCriterion("ocam.answerTime =", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotEqualTo(Date value) {
            addCriterion("ocam.answerTime <>", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeGreaterThan(Date value) {
            addCriterion("ocam.answerTime >", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ocam.answerTime >=", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeLessThan(Date value) {
            addCriterion("ocam.answerTime <", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeLessThanOrEqualTo(Date value) {
            addCriterion("ocam.answerTime <=", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIn(List<Date> values) {
            addCriterion("ocam.answerTime in", values, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotIn(List<Date> values) {
            addCriterion("ocam.answerTime not in", values, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeBetween(Date value1, Date value2) {
            addCriterion("ocam.answerTime between", value1, value2, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotBetween(Date value1, Date value2) {
            addCriterion("ocam.answerTime not between", value1, value2, "answerTime");
            return (Criteria) this;
        }
        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("omem.orgId =", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andMemberNameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("omem.MemName like", "%"+value+"%", "MemName");
            return (Criteria) this;
        }
        public Criteria andMemberNameOrDocNameOrCombQustNameLike(String criteria){
        	if(StringUtils.isNotEmpty(criteria)){
        		List<String > conditions = new ArrayList<String>();
        		conditions.add("omem.MemName like");
        		conditions.add("ocam.DocName like");
        		conditions.add("ocam.CombQustName like");
        		addCriterion(conditions, "%"+criteria+"%");
        	}
        	return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员组合答卷主表（OCAM）
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