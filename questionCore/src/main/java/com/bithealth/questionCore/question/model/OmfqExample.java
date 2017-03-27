/*
 * OmfqExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class OmfqExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OmfqExample() {
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
    public List<Criteria> createOredCriteria(){
    	List<Criteria> oredCriteria = new ArrayList<Criteria>();
    	return oredCriteria;
    }

    /**
     * 问卷信息主表（OMFQ)
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
        public Criteria andQustidIsNull() {
            addCriterion("Qustid is null");
            return (Criteria) this;
        }
        public Criteria andQustidIsNotNull() {
            addCriterion("Qustid is not null");
            return (Criteria) this;
        }
        public Criteria andQustidEqualTo(Integer value) {
            addCriterion("Qustid =", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotEqualTo(Integer value) {
            addCriterion("Qustid <>", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidGreaterThan(Integer value) {
            addCriterion("Qustid >", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Qustid >=", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidLessThan(Integer value) {
            addCriterion("Qustid <", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidLessThanOrEqualTo(Integer value) {
            addCriterion("Qustid <=", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidIn(List<Integer> values) {
            addCriterion("Qustid in", values, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotIn(List<Integer> values) {
            addCriterion("Qustid not in", values, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidBetween(Integer value1, Integer value2) {
            addCriterion("Qustid between", value1, value2, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotBetween(Integer value1, Integer value2) {
            addCriterion("Qustid not between", value1, value2, "qustid");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNull() {
            addCriterion("omfq.optId is null");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNotNull() {
            addCriterion("omfq.optId is not null");
            return (Criteria) this;
        }
        public Criteria andOptIdEqualTo(Short value) {
            addCriterion("omfq.optId =", value, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotEqualTo(Short value) {
            addCriterion("omfq.optId <>", value, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThan(Short value) {
            addCriterion("omfq.optId >", value, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThanOrEqualTo(Short value) {
            addCriterion("omfq.optId >=", value, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThan(Short value) {
            addCriterion("omfq.optId <", value, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThanOrEqualTo(Short value) {
            addCriterion("omfq.optId <=", value, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdIn(List<Short> values) {
            addCriterion("omfq.optId in", values, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotIn(List<Short> values) {
            addCriterion("omfq.optId not in", values, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdBetween(Short value1, Short value2) {
            addCriterion("omfq.optId between", value1, value2, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotBetween(Short value1, Short value2) {
            addCriterion("omfq.optId not between", value1, value2, "omfq.optId");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNull() {
            addCriterion("FunId is null");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNotNull() {
            addCriterion("FunId is not null");
            return (Criteria) this;
        }
        public Criteria andFunIdEqualTo(Short value) {
            addCriterion("FunId =", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotEqualTo(Short value) {
            addCriterion("FunId <>", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThan(Short value) {
            addCriterion("FunId >", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThanOrEqualTo(Short value) {
            addCriterion("FunId >=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThan(Short value) {
            addCriterion("FunId <", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThanOrEqualTo(Short value) {
            addCriterion("FunId <=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdIn(List<Short> values) {
            addCriterion("FunId in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotIn(List<Short> values) {
            addCriterion("FunId not in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdBetween(Short value1, Short value2) {
            addCriterion("FunId between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotBetween(Short value1, Short value2) {
            addCriterion("FunId not between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNull() {
            addCriterion("omfq.OrgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNotNull() {
            addCriterion("omfq.OrgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("omfq.OrgId =", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("omfq.OrgId <>", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("omfq.OrgId >", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("omfq.OrgId >=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("omfq.OrgId <", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("omfq.OrgId <=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("omfq.OrgId in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("omfq.OrgId not in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("omfq.OrgId between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("omfq.OrgId not between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andQustCodeIsNull() {
            addCriterion("QustCode is null");
            return (Criteria) this;
        }
        public Criteria andQustCodeIsNotNull() {
            addCriterion("QustCode is not null");
            return (Criteria) this;
        }
        public Criteria andQustCodeEqualTo(String value) {
            addCriterion("QustCode =", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotEqualTo(String value) {
            addCriterion("QustCode <>", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeGreaterThan(String value) {
            addCriterion("QustCode >", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeGreaterThanOrEqualTo(String value) {
            addCriterion("QustCode >=", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLessThan(String value) {
            addCriterion("QustCode <", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLessThanOrEqualTo(String value) {
            addCriterion("QustCode <=", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeLike(String value) {
            addCriterion("QustCode like", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotLike(String value) {
            addCriterion("QustCode not like", value, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeIn(List<String> values) {
            addCriterion("QustCode in", values, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotIn(List<String> values) {
            addCriterion("QustCode not in", values, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeBetween(String value1, String value2) {
            addCriterion("QustCode between", value1, value2, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustCodeNotBetween(String value1, String value2) {
            addCriterion("QustCode not between", value1, value2, "qustCode");
            return (Criteria) this;
        }
        public Criteria andQustnameIsNull() {
            addCriterion("Qustname is null");
            return (Criteria) this;
        }
        public Criteria andQustnameIsNotNull() {
            addCriterion("Qustname is not null");
            return (Criteria) this;
        }
        public Criteria andQustnameEqualTo(String value) {
            addCriterion("Qustname =", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameNotEqualTo(String value) {
            addCriterion("Qustname <>", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameGreaterThan(String value) {
            addCriterion("Qustname >", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameGreaterThanOrEqualTo(String value) {
            addCriterion("Qustname >=", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameLessThan(String value) {
            addCriterion("Qustname <", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameLessThanOrEqualTo(String value) {
            addCriterion("Qustname <=", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("Qustname like", "%" + value + "%", "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameNotLike(String value) {
            addCriterion("Qustname not like", value, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameIn(List<String> values) {
            addCriterion("Qustname in", values, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameNotIn(List<String> values) {
            addCriterion("Qustname not in", values, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameBetween(String value1, String value2) {
            addCriterion("Qustname between", value1, value2, "qustname");
            return (Criteria) this;
        }
        public Criteria andQustnameNotBetween(String value1, String value2) {
            addCriterion("Qustname not between", value1, value2, "qustname");
            return (Criteria) this;
        }
        public Criteria andAnsModeIsNull() {
            addCriterion("AnsMode is null");
            return (Criteria) this;
        }
        public Criteria andAnsModeIsNotNull() {
            addCriterion("AnsMode is not null");
            return (Criteria) this;
        }
        public Criteria andAnsModeEqualTo(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("AnsMode =", value, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeNotEqualTo(String value) {
            addCriterion("AnsMode <>", value, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeGreaterThan(String value) {
            addCriterion("AnsMode >", value, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeGreaterThanOrEqualTo(String value) {
            addCriterion("AnsMode >=", value, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeLessThan(String value) {
            addCriterion("AnsMode <", value, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeLessThanOrEqualTo(String value) {
            addCriterion("AnsMode <=", value, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeLike(String value) {
            addCriterion("AnsMode like", value, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeNotLike(String value) {
            addCriterion("AnsMode not like", value, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeIn(List<String> values) {
            addCriterion("AnsMode in", values, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeNotIn(List<String> values) {
            addCriterion("AnsMode not in", values, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeBetween(String value1, String value2) {
            addCriterion("AnsMode between", value1, value2, "ansMode");
            return (Criteria) this;
        }
        public Criteria andAnsModeNotBetween(String value1, String value2) {
            addCriterion("AnsMode not between", value1, value2, "ansMode");
            return (Criteria) this;
        }
        public Criteria andDesriptionIsNull() {
            addCriterion("Desription is null");
            return (Criteria) this;
        }
        public Criteria andDesriptionIsNotNull() {
            addCriterion("Desription is not null");
            return (Criteria) this;
        }
        public Criteria andDesriptionEqualTo(String value) {
            addCriterion("Desription =", value, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionNotEqualTo(String value) {
            addCriterion("Desription <>", value, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionGreaterThan(String value) {
            addCriterion("Desription >", value, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Desription >=", value, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionLessThan(String value) {
            addCriterion("Desription <", value, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionLessThanOrEqualTo(String value) {
            addCriterion("Desription <=", value, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionLike(String value) {
            addCriterion("Desription like", value, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionNotLike(String value) {
            addCriterion("Desription not like", value, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionIn(List<String> values) {
            addCriterion("Desription in", values, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionNotIn(List<String> values) {
            addCriterion("Desription not in", values, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionBetween(String value1, String value2) {
            addCriterion("Desription between", value1, value2, "desription");
            return (Criteria) this;
        }
        public Criteria andDesriptionNotBetween(String value1, String value2) {
            addCriterion("Desription not between", value1, value2, "desription");
            return (Criteria) this;
        }
        public Criteria andQustVerIsNull() {
            addCriterion("QustVer is null");
            return (Criteria) this;
        }
        public Criteria andQustVerIsNotNull() {
            addCriterion("QustVer is not null");
            return (Criteria) this;
        }
        public Criteria andQustVerEqualTo(String value) {
            addCriterion("QustVer =", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotEqualTo(String value) {
            addCriterion("QustVer <>", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerGreaterThan(String value) {
            addCriterion("QustVer >", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerGreaterThanOrEqualTo(String value) {
            addCriterion("QustVer >=", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLessThan(String value) {
            addCriterion("QustVer <", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLessThanOrEqualTo(String value) {
            addCriterion("QustVer <=", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerLike(String value) {
            addCriterion("QustVer like", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotLike(String value) {
            addCriterion("QustVer not like", value, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerIn(List<String> values) {
            addCriterion("QustVer in", values, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotIn(List<String> values) {
            addCriterion("QustVer not in", values, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerBetween(String value1, String value2) {
            addCriterion("QustVer between", value1, value2, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustVerNotBetween(String value1, String value2) {
            addCriterion("QustVer not between", value1, value2, "qustVer");
            return (Criteria) this;
        }
        public Criteria andQustDescIsNull() {
            addCriterion("QustDesc is null");
            return (Criteria) this;
        }
        public Criteria andQustDescIsNotNull() {
            addCriterion("QustDesc is not null");
            return (Criteria) this;
        }
        public Criteria andQustDescEqualTo(String value) {
            addCriterion("QustDesc =", value, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescNotEqualTo(String value) {
            addCriterion("QustDesc <>", value, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescGreaterThan(String value) {
            addCriterion("QustDesc >", value, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescGreaterThanOrEqualTo(String value) {
            addCriterion("QustDesc >=", value, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescLessThan(String value) {
            addCriterion("QustDesc <", value, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescLessThanOrEqualTo(String value) {
            addCriterion("QustDesc <=", value, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescLike(String value) {
            addCriterion("QustDesc like", value, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescNotLike(String value) {
            addCriterion("QustDesc not like", value, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescIn(List<String> values) {
            addCriterion("QustDesc in", values, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescNotIn(List<String> values) {
            addCriterion("QustDesc not in", values, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescBetween(String value1, String value2) {
            addCriterion("QustDesc between", value1, value2, "qustDesc");
            return (Criteria) this;
        }
        public Criteria andQustDescNotBetween(String value1, String value2) {
            addCriterion("QustDesc not between", value1, value2, "qustDesc");
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
        public Criteria andUseRangeEqualTo(Byte value) {
            addCriterion("useRange =", value, "useRange");
            return (Criteria) this;
        }
        public Criteria andUseRangeIn(List<Byte> values) {
            addCriterion("useRange in", values, "useRange");
            return (Criteria) this;
        }
        public Criteria andRoleId(Integer roleId, Byte useRange, Integer orgId, String superOrgIds){
        	if(roleId != null){
        		if(roleId.equals(6)){//系统管理员
        			addCriterion("useRange IN (1 , 2)");
        			andOrgIdEqualTo(orgId);
        			if(useRange != null)
        				andUseRangeEqualTo(useRange);
        		}else{//医生
        			String orgIds = "0, " + superOrgIds;
        			addCriterion("((QustTag = 'T' AND omfq.`OrgId` IN (" + orgIds + ")) OR (useRange = 3 AND omfq.OrgId = " + orgId + "))"); 
        			andQustnameNotEqualTo("中医体质辨识问卷");
        			if(useRange != null){
        				if(useRange.equals((byte)2))
        					andUseRangeIn(Arrays.asList((byte)2,(byte)3));
        				else
        					andUseRangeEqualTo(useRange);
        			}
        		}
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
     * 问卷信息主表（OMFQ)
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