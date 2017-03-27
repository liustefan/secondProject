/*
 * OcqtExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class OcqtExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OcqtExample() {
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
     * 组合问卷主表（OCQT）
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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
        public Criteria andCombQustidIsNull() {
            addCriterion("CombQustid is null");
            return (Criteria) this;
        }
        public Criteria andCombQustidIsNotNull() {
            addCriterion("CombQustid is not null");
            return (Criteria) this;
        }
        public Criteria andCombQustidEqualTo(Integer value) {
            addCriterion("CombQustid =", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotEqualTo(Integer value) {
            addCriterion("CombQustid <>", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidGreaterThan(Integer value) {
            addCriterion("CombQustid >", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CombQustid >=", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidLessThan(Integer value) {
            addCriterion("CombQustid <", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidLessThanOrEqualTo(Integer value) {
            addCriterion("CombQustid <=", value, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidIn(List<Integer> values) {
            addCriterion("CombQustid in", values, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotIn(List<Integer> values) {
            addCriterion("CombQustid not in", values, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidBetween(Integer value1, Integer value2) {
            addCriterion("CombQustid between", value1, value2, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustidNotBetween(Integer value1, Integer value2) {
            addCriterion("CombQustid not between", value1, value2, "combQustid");
            return (Criteria) this;
        }
        public Criteria andCombQustNameIsNull() {
            addCriterion("CombQustName is null");
            return (Criteria) this;
        }
        public Criteria andCombQustNameIsNotNull() {
            addCriterion("CombQustName is not null");
            return (Criteria) this;
        }
        public Criteria andCombQustNameEqualTo(String value) {
            addCriterion("CombQustName =", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameNotEqualTo(String value) {
            addCriterion("CombQustName <>", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameGreaterThan(String value) {
            addCriterion("CombQustName >", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CombQustName >=", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameLessThan(String value) {
            addCriterion("CombQustName <", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameLessThanOrEqualTo(String value) {
            addCriterion("CombQustName <=", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("CombQustName like", "%"+value+"%", "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameNotLike(String value) {
            addCriterion("CombQustName not like", value, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameIn(List<String> values) {
            addCriterion("CombQustName in", values, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameNotIn(List<String> values) {
            addCriterion("CombQustName not in", values, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameBetween(String value1, String value2) {
            addCriterion("CombQustName between", value1, value2, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustNameNotBetween(String value1, String value2) {
            addCriterion("CombQustName not between", value1, value2, "combQustName");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeIsNull() {
            addCriterion("CombQustCode is null");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeIsNotNull() {
            addCriterion("CombQustCode is not null");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeEqualTo(Integer value) {
            addCriterion("CombQustCode =", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeNotEqualTo(Integer value) {
            addCriterion("CombQustCode <>", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeGreaterThan(Integer value) {
            addCriterion("CombQustCode >", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CombQustCode >=", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeLessThan(Integer value) {
            addCriterion("CombQustCode <", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeLessThanOrEqualTo(Integer value) {
            addCriterion("CombQustCode <=", value, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeIn(List<Integer> values) {
            addCriterion("CombQustCode in", values, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeNotIn(List<Integer> values) {
            addCriterion("CombQustCode not in", values, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeBetween(Integer value1, Integer value2) {
            addCriterion("CombQustCode between", value1, value2, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombQustCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("CombQustCode not between", value1, value2, "combQustCode");
            return (Criteria) this;
        }
        public Criteria andCombDescIsNull() {
            addCriterion("CombDesc is null");
            return (Criteria) this;
        }
        public Criteria andCombDescIsNotNull() {
            addCriterion("CombDesc is not null");
            return (Criteria) this;
        }
        public Criteria andCombDescEqualTo(String value) {
            addCriterion("CombDesc =", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescNotEqualTo(String value) {
            addCriterion("CombDesc <>", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescGreaterThan(String value) {
            addCriterion("CombDesc >", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescGreaterThanOrEqualTo(String value) {
            addCriterion("CombDesc >=", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescLessThan(String value) {
            addCriterion("CombDesc <", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescLessThanOrEqualTo(String value) {
            addCriterion("CombDesc <=", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescLike(String value) {
            addCriterion("CombDesc like", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescNotLike(String value) {
            addCriterion("CombDesc not like", value, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescIn(List<String> values) {
            addCriterion("CombDesc in", values, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescNotIn(List<String> values) {
            addCriterion("CombDesc not in", values, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescBetween(String value1, String value2) {
            addCriterion("CombDesc between", value1, value2, "combDesc");
            return (Criteria) this;
        }
        public Criteria andCombDescNotBetween(String value1, String value2) {
            addCriterion("CombDesc not between", value1, value2, "combDesc");
            return (Criteria) this;
        }
        public Criteria andChTagIsNull() {
            addCriterion("ChTag is null");
            return (Criteria) this;
        }
        public Criteria andChTagIsNotNull() {
            addCriterion("ChTag is not null");
            return (Criteria) this;
        }
        public Criteria andChTagEqualTo(String value) {
            addCriterion("ChTag =", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotEqualTo(String value) {
            addCriterion("ChTag <>", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagGreaterThan(String value) {
            addCriterion("ChTag >", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagGreaterThanOrEqualTo(String value) {
            addCriterion("ChTag >=", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLessThan(String value) {
            addCriterion("ChTag <", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLessThanOrEqualTo(String value) {
            addCriterion("ChTag <=", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagLike(String value) {
            addCriterion("ChTag like", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotLike(String value) {
            addCriterion("ChTag not like", value, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagIn(List<String> values) {
            addCriterion("ChTag in", values, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotIn(List<String> values) {
            addCriterion("ChTag not in", values, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagBetween(String value1, String value2) {
            addCriterion("ChTag between", value1, value2, "chTag");
            return (Criteria) this;
        }
        public Criteria andChTagNotBetween(String value1, String value2) {
            addCriterion("ChTag not between", value1, value2, "chTag");
            return (Criteria) this;
        }
        public Criteria andQustTagIsNull() {
            addCriterion("QustTag is null");
            return (Criteria) this;
        }
        public Criteria andQustTagIsNotNull() {
            addCriterion("QustTag is not null");
            return (Criteria) this;
        }
        public Criteria andQustTagEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("QustTag =", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagNotEqualTo(String value) {
            addCriterion("QustTag <>", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagGreaterThan(String value) {
            addCriterion("QustTag >", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagGreaterThanOrEqualTo(String value) {
            addCriterion("QustTag >=", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagLessThan(String value) {
            addCriterion("QustTag <", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagLessThanOrEqualTo(String value) {
            addCriterion("QustTag <=", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagLike(String value) {
            addCriterion("QustTag like", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagNotLike(String value) {
            addCriterion("QustTag not like", value, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagIn(List<String> values) {
            addCriterion("QustTag in", values, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagNotIn(List<String> values) {
            addCriterion("QustTag not in", values, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagBetween(String value1, String value2) {
            addCriterion("QustTag between", value1, value2, "qustTag");
            return (Criteria) this;
        }
        public Criteria andQustTagNotBetween(String value1, String value2) {
            addCriterion("QustTag not between", value1, value2, "qustTag");
            return (Criteria) this;
        }
        public Criteria andCreateDateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }
        public Criteria andCreateDateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }
        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate =", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate <>", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CreateDate >", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate >=", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CreateDate <", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate <=", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CreateDate in", values, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CreateDate not in", values, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateDate between", value1, value2, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNull() {
            addCriterion("Createid is null");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNotNull() {
            addCriterion("Createid is not null");
            return (Criteria) this;
        }
        public Criteria andCreateidEqualTo(Integer value) {
            addCriterion("Createid =", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotEqualTo(Integer value) {
            addCriterion("Createid <>", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThan(Integer value) {
            addCriterion("Createid >", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Createid >=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThan(Integer value) {
            addCriterion("Createid <", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThanOrEqualTo(Integer value) {
            addCriterion("Createid <=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidIn(List<Integer> values) {
            addCriterion("Createid in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotIn(List<Integer> values) {
            addCriterion("Createid not in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidBetween(Integer value1, Integer value2) {
            addCriterion("Createid between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotBetween(Integer value1, Integer value2) {
            addCriterion("Createid not between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateNameIsNull() {
            addCriterion("CreateName is null");
            return (Criteria) this;
        }
        public Criteria andCreateNameIsNotNull() {
            addCriterion("CreateName is not null");
            return (Criteria) this;
        }
        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("CreateName =", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("CreateName <>", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("CreateName >", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("CreateName >=", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLessThan(String value) {
            addCriterion("CreateName <", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("CreateName <=", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("CreateName like", "%"+value+"%", "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotLike(String value) {
            addCriterion("CreateName not like", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("CreateName in", values, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("CreateName not in", values, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("CreateName between", value1, value2, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("CreateName not between", value1, value2, "createName");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNull() {
            addCriterion("ocqt.orgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNotNull() {
            addCriterion("ocqt.orgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("ocqt.orgId =", value, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("ocqt.orgId <>", value, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("ocqt.orgId >", value, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocqt.orgId >=", value, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("ocqt.orgId <", value, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("ocqt.orgId <=", value, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("ocqt.orgId in", values, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("ocqt.orgId not in", values, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("ocqt.orgId between", value1, value2, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ocqt.orgId not between", value1, value2, "ocqt.orgId");
            return (Criteria) this;
        }
        public Criteria andQustVerIsNull() {
            addCriterion("qustVer is null");
            return (Criteria) this;
        }
        public Criteria andQustVerIsNotNull() {
            addCriterion("qustVer is not null");
            return (Criteria) this;
        }
        public Criteria andQustVerEqualTo(String value) {
            addCriterion("qustVer =", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotEqualTo(String value) {
            addCriterion("qustVer <>", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerGreaterThan(String value) {
            addCriterion("qustVer >", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerGreaterThanOrEqualTo(String value) {
            addCriterion("qustVer >=", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLessThan(String value) {
            addCriterion("qustVer <", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLessThanOrEqualTo(String value) {
            addCriterion("qustVer <=", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLike(String value) {
            addCriterion("qustVer like", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotLike(String value) {
            addCriterion("qustVer not like", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerIn(List<String> values) {
            addCriterion("qustVer in", values, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotIn(List<String> values) {
            addCriterion("qustVer not in", values, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerBetween(String value1, String value2) {
            addCriterion("qustVer between", value1, value2, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotBetween(String value1, String value2) {
            addCriterion("qustVer not between", value1, value2, "qustVer");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNull() {
            addCriterion("ocqt.optId is null");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNotNull() {
            addCriterion("ocqt.optId is not null");
            return (Criteria) this;
        }
        public Criteria andOptIdEqualTo(Short value) {
            addCriterion("ocqt.optId =", value, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotEqualTo(Short value) {
            addCriterion("ocqt.optId <>", value, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThan(Short value) {
            addCriterion("ocqt.optId >", value, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThanOrEqualTo(Short value) {
            addCriterion("ocqt.optId >=", value, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThan(Short value) {
            addCriterion("ocqt.optId <", value, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThanOrEqualTo(Short value) {
            addCriterion("ocqt.optId <=", value, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdIn(List<Short> values) {
            addCriterion("ocqt.optId in", values, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotIn(List<Short> values) {
            addCriterion("ocqt.optId not in", values, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdBetween(Short value1, Short value2) {
            addCriterion("ocqt.optId between", value1, value2, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotBetween(Short value1, Short value2) {
            addCriterion("ocqt.optId not between", value1, value2, "ocqt.optId");
            return (Criteria) this;
        }
        public Criteria andCombQustNameOrCreateNameLike(String criteria){
        	if(StringUtils.isNotEmpty(criteria)){
        		List<String > conditions = new ArrayList<String>();
        		conditions.add("ocqt.CombQustName like");
        		conditions.add("ocqt.CreateName like");        		
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
     * 组合问卷主表（OCQT）
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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