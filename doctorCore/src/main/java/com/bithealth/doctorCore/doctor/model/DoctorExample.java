/*
 * DoctorExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.doctor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bithealth.sdk.common.utils.StringUtil;


public class DoctorExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public DoctorExample() {
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
     * 医生档案(ODOC)
     * 
     * @author ${user}
     * @version 1.0 2016-06-23
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
            if (StringUtil.isNotEmpty(condition)) {
            	criteria.add(new Criterion(condition));
            }
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (StringUtil.isNotEmpty(value)) {
            	criteria.add(new Criterion(condition, value));
            }
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (StringUtil.isNotEmpty(value1) && StringUtil.isNotEmpty(value2)) {
            	criteria.add(new Criterion(condition, value1, value2));
            }
        }
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value != null) {
            	addCriterion(condition, new java.sql.Date(value.getTime()), property);
            }
            
        }
        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (StringUtil.isNotEmpty(values)) {
            	List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
                Iterator<Date> iter = values.iterator();
                while (iter.hasNext()) {
                    dateList.add(new java.sql.Date(iter.next().getTime()));
                }
                addCriterion(condition, dateList, property);
            }
        }
        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 != null && value2 != null) {
            	addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
            }
        }
        public Criteria andDocidIsNull() {
            addCriterion("Docid is null");
            return (Criteria) this;
        }
        public Criteria andDocidIsNotNull() {
            addCriterion("Docid is not null");
            return (Criteria) this;
        }
        public Criteria andDocidEqualTo(Integer value) {
            addCriterion("Docid =", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotEqualTo(Integer value) {
            addCriterion("Docid <>", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThan(Integer value) {
            addCriterion("Docid >", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Docid >=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThan(Integer value) {
            addCriterion("Docid <", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThanOrEqualTo(Integer value) {
            addCriterion("Docid <=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidIn(List<Integer> values) {
            addCriterion("Docid in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotIn(List<Integer> values) {
            addCriterion("Docid not in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidBetween(Integer value1, Integer value2) {
            addCriterion("Docid between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotBetween(Integer value1, Integer value2) {
            addCriterion("Docid not between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andRoleidIsNull() {
            addCriterion("RoleId is null");
            return (Criteria) this;
        }
        public Criteria andRoleidIsNotNull() {
            addCriterion("RoleId is not null");
            return (Criteria) this;
        }
        public Criteria andRoleidEqualTo(Short value) {
            addCriterion("RoleId =", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidNotEqualTo(Short value) {
            addCriterion("RoleId <>", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidGreaterThan(Short value) {
            addCriterion("RoleId >", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidGreaterThanOrEqualTo(Short value) {
            addCriterion("RoleId >=", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidLessThan(Short value) {
            addCriterion("RoleId <", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidLessThanOrEqualTo(Short value) {
            addCriterion("RoleId <=", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidIn(List<Short> values) {
            addCriterion("RoleId in", values, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidNotIn(List<Short> values) {
            addCriterion("RoleId not in", values, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidBetween(Short value1, Short value2) {
            addCriterion("RoleId between", value1, value2, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidNotBetween(Short value1, Short value2) {
            addCriterion("RoleId not between", value1, value2, "roleid");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNull() {
            addCriterion("OrgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNotNull() {
            addCriterion("OrgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgidEqualTo(Integer value) {
            addCriterion("OrgId =", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotEqualTo(Integer value) {
            addCriterion("OrgId <>", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThan(Integer value) {
            addCriterion("OrgId >", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgId >=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThan(Integer value) {
            addCriterion("OrgId <", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThanOrEqualTo(Integer value) {
            addCriterion("OrgId <=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidIn(List<Integer> values) {
            addCriterion("OrgId in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotIn(List<Integer> values) {
            addCriterion("OrgId not in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidBetween(Integer value1, Integer value2) {
            addCriterion("OrgId between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgId not between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andDocnameIsNull() {
            addCriterion("DocName is null");
            return (Criteria) this;
        }
        public Criteria andDocnameIsNotNull() {
            addCriterion("DocName is not null");
            return (Criteria) this;
        }
        public Criteria andDocnameEqualTo(String value) {
            addCriterion("DocName =", value, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameNotEqualTo(String value) {
            addCriterion("DocName <>", value, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameGreaterThan(String value) {
            addCriterion("DocName >", value, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameGreaterThanOrEqualTo(String value) {
            addCriterion("DocName >=", value, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameLessThan(String value) {
            addCriterion("DocName <", value, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameLessThanOrEqualTo(String value) {
            addCriterion("DocName <=", value, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameLike(String value) {
            addCriterion("DocName like", value, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameNotLike(String value) {
            addCriterion("DocName not like", value, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameIn(List<String> values) {
            addCriterion("DocName in", values, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameNotIn(List<String> values) {
            addCriterion("DocName not in", values, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameBetween(String value1, String value2) {
            addCriterion("DocName between", value1, value2, "docname");
            return (Criteria) this;
        }
        public Criteria andDocnameNotBetween(String value1, String value2) {
            addCriterion("DocName not between", value1, value2, "docname");
            return (Criteria) this;
        }
        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }
        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }
        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLike(String value) {
            addCriterion("Title like", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andGenderIsNull() {
            addCriterion("Gender is null");
            return (Criteria) this;
        }
        public Criteria andGenderIsNotNull() {
            addCriterion("Gender is not null");
            return (Criteria) this;
        }
        public Criteria andGenderEqualTo(String value) {
            addCriterion("Gender =", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("Gender <>", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderGreaterThan(String value) {
            addCriterion("Gender >", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("Gender >=", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderLessThan(String value) {
            addCriterion("Gender <", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("Gender <=", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderLike(String value) {
            addCriterion("Gender like", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderNotLike(String value) {
            addCriterion("Gender not like", value, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderIn(List<String> values) {
            addCriterion("Gender in", values, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("Gender not in", values, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("Gender between", value1, value2, "gender");
            return (Criteria) this;
        }
        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("Gender not between", value1, value2, "gender");
            return (Criteria) this;
        }
        public Criteria andBirthdateIsNull() {
            addCriterion("BirthDate is null");
            return (Criteria) this;
        }
        public Criteria andBirthdateIsNotNull() {
            addCriterion("BirthDate is not null");
            return (Criteria) this;
        }
        public Criteria andBirthdateEqualTo(Date value) {
            addCriterionForJDBCDate("BirthDate =", value, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("BirthDate <>", value, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateGreaterThan(Date value) {
            addCriterionForJDBCDate("BirthDate >", value, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BirthDate >=", value, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateLessThan(Date value) {
            addCriterionForJDBCDate("BirthDate <", value, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BirthDate <=", value, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateIn(List<Date> values) {
            addCriterionForJDBCDate("BirthDate in", values, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("BirthDate not in", values, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BirthDate between", value1, value2, "birthdate");
            return (Criteria) this;
        }
        public Criteria andBirthdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BirthDate not between", value1, value2, "birthdate");
            return (Criteria) this;
        }
        public Criteria andContacttelIsNull() {
            addCriterion("ContactTel is null");
            return (Criteria) this;
        }
        public Criteria andContacttelIsNotNull() {
            addCriterion("ContactTel is not null");
            return (Criteria) this;
        }
        public Criteria andContacttelEqualTo(String value) {
            addCriterion("ContactTel =", value, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelNotEqualTo(String value) {
            addCriterion("ContactTel <>", value, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelGreaterThan(String value) {
            addCriterion("ContactTel >", value, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelGreaterThanOrEqualTo(String value) {
            addCriterion("ContactTel >=", value, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelLessThan(String value) {
            addCriterion("ContactTel <", value, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelLessThanOrEqualTo(String value) {
            addCriterion("ContactTel <=", value, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelLike(String value) {
            addCriterion("ContactTel like", value, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelNotLike(String value) {
            addCriterion("ContactTel not like", value, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelIn(List<String> values) {
            addCriterion("ContactTel in", values, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelNotIn(List<String> values) {
            addCriterion("ContactTel not in", values, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelBetween(String value1, String value2) {
            addCriterion("ContactTel between", value1, value2, "contacttel");
            return (Criteria) this;
        }
        public Criteria andContacttelNotBetween(String value1, String value2) {
            addCriterion("ContactTel not between", value1, value2, "contacttel");
            return (Criteria) this;
        }
        public Criteria andTelIsNull() {
            addCriterion("Tel is null");
            return (Criteria) this;
        }
        public Criteria andTelIsNotNull() {
            addCriterion("Tel is not null");
            return (Criteria) this;
        }
        public Criteria andTelEqualTo(String value) {
            addCriterion("Tel =", value, "tel");
            return (Criteria) this;
        }
        public Criteria andTelNotEqualTo(String value) {
            addCriterion("Tel <>", value, "tel");
            return (Criteria) this;
        }
        public Criteria andTelGreaterThan(String value) {
            addCriterion("Tel >", value, "tel");
            return (Criteria) this;
        }
        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("Tel >=", value, "tel");
            return (Criteria) this;
        }
        public Criteria andTelLessThan(String value) {
            addCriterion("Tel <", value, "tel");
            return (Criteria) this;
        }
        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("Tel <=", value, "tel");
            return (Criteria) this;
        }
        public Criteria andTelLike(String value) {
            addCriterion("Tel like", value, "tel");
            return (Criteria) this;
        }
        public Criteria andTelNotLike(String value) {
            addCriterion("Tel not like", value, "tel");
            return (Criteria) this;
        }
        public Criteria andTelIn(List<String> values) {
            addCriterion("Tel in", values, "tel");
            return (Criteria) this;
        }
        public Criteria andTelNotIn(List<String> values) {
            addCriterion("Tel not in", values, "tel");
            return (Criteria) this;
        }
        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("Tel between", value1, value2, "tel");
            return (Criteria) this;
        }
        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("Tel not between", value1, value2, "tel");
            return (Criteria) this;
        }
        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }
        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }
        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }
        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }
        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }
        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }
        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }
        public Criteria andHomeaddressIsNull() {
            addCriterion("HomeAddress is null");
            return (Criteria) this;
        }
        public Criteria andHomeaddressIsNotNull() {
            addCriterion("HomeAddress is not null");
            return (Criteria) this;
        }
        public Criteria andHomeaddressEqualTo(String value) {
            addCriterion("HomeAddress =", value, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressNotEqualTo(String value) {
            addCriterion("HomeAddress <>", value, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressGreaterThan(String value) {
            addCriterion("HomeAddress >", value, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressGreaterThanOrEqualTo(String value) {
            addCriterion("HomeAddress >=", value, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressLessThan(String value) {
            addCriterion("HomeAddress <", value, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressLessThanOrEqualTo(String value) {
            addCriterion("HomeAddress <=", value, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressLike(String value) {
            addCriterion("HomeAddress like", value, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressNotLike(String value) {
            addCriterion("HomeAddress not like", value, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressIn(List<String> values) {
            addCriterion("HomeAddress in", values, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressNotIn(List<String> values) {
            addCriterion("HomeAddress not in", values, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressBetween(String value1, String value2) {
            addCriterion("HomeAddress between", value1, value2, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andHomeaddressNotBetween(String value1, String value2) {
            addCriterion("HomeAddress not between", value1, value2, "homeaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressIsNull() {
            addCriterion("workAddress is null");
            return (Criteria) this;
        }
        public Criteria andWorkaddressIsNotNull() {
            addCriterion("workAddress is not null");
            return (Criteria) this;
        }
        public Criteria andWorkaddressEqualTo(String value) {
            addCriterion("workAddress =", value, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressNotEqualTo(String value) {
            addCriterion("workAddress <>", value, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressGreaterThan(String value) {
            addCriterion("workAddress >", value, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressGreaterThanOrEqualTo(String value) {
            addCriterion("workAddress >=", value, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressLessThan(String value) {
            addCriterion("workAddress <", value, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressLessThanOrEqualTo(String value) {
            addCriterion("workAddress <=", value, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressLike(String value) {
            addCriterion("workAddress like", value, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressNotLike(String value) {
            addCriterion("workAddress not like", value, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressIn(List<String> values) {
            addCriterion("workAddress in", values, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressNotIn(List<String> values) {
            addCriterion("workAddress not in", values, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressBetween(String value1, String value2) {
            addCriterion("workAddress between", value1, value2, "workaddress");
            return (Criteria) this;
        }
        public Criteria andWorkaddressNotBetween(String value1, String value2) {
            addCriterion("workAddress not between", value1, value2, "workaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressIsNull() {
            addCriterion("UnitAddress is null");
            return (Criteria) this;
        }
        public Criteria andUnitaddressIsNotNull() {
            addCriterion("UnitAddress is not null");
            return (Criteria) this;
        }
        public Criteria andUnitaddressEqualTo(String value) {
            addCriterion("UnitAddress =", value, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressNotEqualTo(String value) {
            addCriterion("UnitAddress <>", value, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressGreaterThan(String value) {
            addCriterion("UnitAddress >", value, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressGreaterThanOrEqualTo(String value) {
            addCriterion("UnitAddress >=", value, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressLessThan(String value) {
            addCriterion("UnitAddress <", value, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressLessThanOrEqualTo(String value) {
            addCriterion("UnitAddress <=", value, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressLike(String value) {
            addCriterion("UnitAddress like", value, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressNotLike(String value) {
            addCriterion("UnitAddress not like", value, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressIn(List<String> values) {
            addCriterion("UnitAddress in", values, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressNotIn(List<String> values) {
            addCriterion("UnitAddress not in", values, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressBetween(String value1, String value2) {
            addCriterion("UnitAddress between", value1, value2, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andUnitaddressNotBetween(String value1, String value2) {
            addCriterion("UnitAddress not between", value1, value2, "unitaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressIsNull() {
            addCriterion("ResideAddress is null");
            return (Criteria) this;
        }
        public Criteria andResideaddressIsNotNull() {
            addCriterion("ResideAddress is not null");
            return (Criteria) this;
        }
        public Criteria andResideaddressEqualTo(String value) {
            addCriterion("ResideAddress =", value, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressNotEqualTo(String value) {
            addCriterion("ResideAddress <>", value, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressGreaterThan(String value) {
            addCriterion("ResideAddress >", value, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressGreaterThanOrEqualTo(String value) {
            addCriterion("ResideAddress >=", value, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressLessThan(String value) {
            addCriterion("ResideAddress <", value, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressLessThanOrEqualTo(String value) {
            addCriterion("ResideAddress <=", value, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressLike(String value) {
            addCriterion("ResideAddress like", value, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressNotLike(String value) {
            addCriterion("ResideAddress not like", value, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressIn(List<String> values) {
            addCriterion("ResideAddress in", values, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressNotIn(List<String> values) {
            addCriterion("ResideAddress not in", values, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressBetween(String value1, String value2) {
            addCriterion("ResideAddress between", value1, value2, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andResideaddressNotBetween(String value1, String value2) {
            addCriterion("ResideAddress not between", value1, value2, "resideaddress");
            return (Criteria) this;
        }
        public Criteria andCertitypeIsNull() {
            addCriterion("CertiType is null");
            return (Criteria) this;
        }
        public Criteria andCertitypeIsNotNull() {
            addCriterion("CertiType is not null");
            return (Criteria) this;
        }
        public Criteria andCertitypeEqualTo(String value) {
            addCriterion("CertiType =", value, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeNotEqualTo(String value) {
            addCriterion("CertiType <>", value, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeGreaterThan(String value) {
            addCriterion("CertiType >", value, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeGreaterThanOrEqualTo(String value) {
            addCriterion("CertiType >=", value, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeLessThan(String value) {
            addCriterion("CertiType <", value, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeLessThanOrEqualTo(String value) {
            addCriterion("CertiType <=", value, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeLike(String value) {
            addCriterion("CertiType like", value, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeNotLike(String value) {
            addCriterion("CertiType not like", value, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeIn(List<String> values) {
            addCriterion("CertiType in", values, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeNotIn(List<String> values) {
            addCriterion("CertiType not in", values, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeBetween(String value1, String value2) {
            addCriterion("CertiType between", value1, value2, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertitypeNotBetween(String value1, String value2) {
            addCriterion("CertiType not between", value1, value2, "certitype");
            return (Criteria) this;
        }
        public Criteria andCertinumIsNull() {
            addCriterion("CertiNum is null");
            return (Criteria) this;
        }
        public Criteria andCertinumIsNotNull() {
            addCriterion("CertiNum is not null");
            return (Criteria) this;
        }
        public Criteria andCertinumEqualTo(String value) {
            addCriterion("CertiNum =", value, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumNotEqualTo(String value) {
            addCriterion("CertiNum <>", value, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumGreaterThan(String value) {
            addCriterion("CertiNum >", value, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumGreaterThanOrEqualTo(String value) {
            addCriterion("CertiNum >=", value, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumLessThan(String value) {
            addCriterion("CertiNum <", value, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumLessThanOrEqualTo(String value) {
            addCriterion("CertiNum <=", value, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumLike(String value) {
            addCriterion("CertiNum like", value, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumNotLike(String value) {
            addCriterion("CertiNum not like", value, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumIn(List<String> values) {
            addCriterion("CertiNum in", values, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumNotIn(List<String> values) {
            addCriterion("CertiNum not in", values, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumBetween(String value1, String value2) {
            addCriterion("CertiNum between", value1, value2, "certinum");
            return (Criteria) this;
        }
        public Criteria andCertinumNotBetween(String value1, String value2) {
            addCriterion("CertiNum not between", value1, value2, "certinum");
            return (Criteria) this;
        }
        public Criteria andWeixinIsNull() {
            addCriterion("Weixin is null");
            return (Criteria) this;
        }
        public Criteria andWeixinIsNotNull() {
            addCriterion("Weixin is not null");
            return (Criteria) this;
        }
        public Criteria andWeixinEqualTo(String value) {
            addCriterion("Weixin =", value, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinNotEqualTo(String value) {
            addCriterion("Weixin <>", value, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinGreaterThan(String value) {
            addCriterion("Weixin >", value, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinGreaterThanOrEqualTo(String value) {
            addCriterion("Weixin >=", value, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinLessThan(String value) {
            addCriterion("Weixin <", value, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinLessThanOrEqualTo(String value) {
            addCriterion("Weixin <=", value, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinLike(String value) {
            addCriterion("Weixin like", value, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinNotLike(String value) {
            addCriterion("Weixin not like", value, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinIn(List<String> values) {
            addCriterion("Weixin in", values, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinNotIn(List<String> values) {
            addCriterion("Weixin not in", values, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinBetween(String value1, String value2) {
            addCriterion("Weixin between", value1, value2, "weixin");
            return (Criteria) this;
        }
        public Criteria andWeixinNotBetween(String value1, String value2) {
            addCriterion("Weixin not between", value1, value2, "weixin");
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
        public Criteria andWorkdepartIsNull() {
            addCriterion("WorkDepart is null");
            return (Criteria) this;
        }
        public Criteria andWorkdepartIsNotNull() {
            addCriterion("WorkDepart is not null");
            return (Criteria) this;
        }
        public Criteria andWorkdepartEqualTo(String value) {
            addCriterion("WorkDepart =", value, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartNotEqualTo(String value) {
            addCriterion("WorkDepart <>", value, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartGreaterThan(String value) {
            addCriterion("WorkDepart >", value, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartGreaterThanOrEqualTo(String value) {
            addCriterion("WorkDepart >=", value, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartLessThan(String value) {
            addCriterion("WorkDepart <", value, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartLessThanOrEqualTo(String value) {
            addCriterion("WorkDepart <=", value, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartLike(String value) {
            addCriterion("WorkDepart like", value, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartNotLike(String value) {
            addCriterion("WorkDepart not like", value, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartIn(List<String> values) {
            addCriterion("WorkDepart in", values, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartNotIn(List<String> values) {
            addCriterion("WorkDepart not in", values, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartBetween(String value1, String value2) {
            addCriterion("WorkDepart between", value1, value2, "workdepart");
            return (Criteria) this;
        }
        public Criteria andWorkdepartNotBetween(String value1, String value2) {
            addCriterion("WorkDepart not between", value1, value2, "workdepart");
            return (Criteria) this;
        }
        public Criteria andHeadaddressIsNull() {
            addCriterion("HeadAddress is null");
            return (Criteria) this;
        }
        public Criteria andHeadaddressIsNotNull() {
            addCriterion("HeadAddress is not null");
            return (Criteria) this;
        }
        public Criteria andHeadaddressEqualTo(String value) {
            addCriterion("HeadAddress =", value, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressNotEqualTo(String value) {
            addCriterion("HeadAddress <>", value, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressGreaterThan(String value) {
            addCriterion("HeadAddress >", value, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressGreaterThanOrEqualTo(String value) {
            addCriterion("HeadAddress >=", value, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressLessThan(String value) {
            addCriterion("HeadAddress <", value, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressLessThanOrEqualTo(String value) {
            addCriterion("HeadAddress <=", value, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressLike(String value) {
            addCriterion("HeadAddress like", value, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressNotLike(String value) {
            addCriterion("HeadAddress not like", value, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressIn(List<String> values) {
            addCriterion("HeadAddress in", values, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressNotIn(List<String> values) {
            addCriterion("HeadAddress not in", values, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressBetween(String value1, String value2) {
            addCriterion("HeadAddress between", value1, value2, "headaddress");
            return (Criteria) this;
        }
        public Criteria andHeadaddressNotBetween(String value1, String value2) {
            addCriterion("HeadAddress not between", value1, value2, "headaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressIsNull() {
            addCriterion("SignAddress is null");
            return (Criteria) this;
        }
        public Criteria andSignaddressIsNotNull() {
            addCriterion("SignAddress is not null");
            return (Criteria) this;
        }
        public Criteria andSignaddressEqualTo(String value) {
            addCriterion("SignAddress =", value, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressNotEqualTo(String value) {
            addCriterion("SignAddress <>", value, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressGreaterThan(String value) {
            addCriterion("SignAddress >", value, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressGreaterThanOrEqualTo(String value) {
            addCriterion("SignAddress >=", value, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressLessThan(String value) {
            addCriterion("SignAddress <", value, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressLessThanOrEqualTo(String value) {
            addCriterion("SignAddress <=", value, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressLike(String value) {
            addCriterion("SignAddress like", value, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressNotLike(String value) {
            addCriterion("SignAddress not like", value, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressIn(List<String> values) {
            addCriterion("SignAddress in", values, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressNotIn(List<String> values) {
            addCriterion("SignAddress not in", values, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressBetween(String value1, String value2) {
            addCriterion("SignAddress between", value1, value2, "signaddress");
            return (Criteria) this;
        }
        public Criteria andSignaddressNotBetween(String value1, String value2) {
            addCriterion("SignAddress not between", value1, value2, "signaddress");
            return (Criteria) this;
        }
        public Criteria andDocGUIDNull() {
            addCriterion("DocGUID is null");
            return (Criteria) this;
        }
        public Criteria andDocGUIDIsNotNull() {
            addCriterion("DocGUID is not null");
            return (Criteria) this;
        }
        public Criteria andDocGUIDEqualTo(String value) {
            addCriterion("DocGUID =", value, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDNotEqualTo(String value) {
            addCriterion("DocGUID <>", value, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDGreaterThan(String value) {
            addCriterion("DocGUID >", value, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("DocGUID >=", value, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDLessThan(String value) {
            addCriterion("DocGUID <", value, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDLessThanOrEqualTo(String value) {
            addCriterion("DocGUID <=", value, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDLike(String value) {
            addCriterion("DocGUID like", value, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDNotLike(String value) {
            addCriterion("DocGUID not like", value, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDIn(List<String> values) {
            addCriterion("DocGUID in", values, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDNotIn(List<String> values) {
            addCriterion("DocGUID not in", values, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDBetween(String value1, String value2) {
            addCriterion("DocGUID between", value1, value2, "docGUID");
            return (Criteria) this;
        }
        public Criteria andDocGUIDNotBetween(String value1, String value2) {
            addCriterion("DocGUID not between", value1, value2, "docGUID");
            return (Criteria) this;
        }
        public Criteria andTagIsNull() {
            addCriterion("Tag is null");
            return (Criteria) this;
        }
        public Criteria andTagIsNotNull() {
            addCriterion("Tag is not null");
            return (Criteria) this;
        }
        public Criteria andTagEqualTo(String value) {
            addCriterion("Tag =", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotEqualTo(String value) {
            addCriterion("Tag <>", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThan(String value) {
            addCriterion("Tag >", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("Tag >=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThan(String value) {
            addCriterion("Tag <", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("Tag <=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLike(String value) {
            addCriterion("Tag like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotLike(String value) {
            addCriterion("Tag not like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagIn(List<String> values) {
            addCriterion("Tag in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotIn(List<String> values) {
            addCriterion("Tag not in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("Tag between", value1, value2, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("Tag not between", value1, value2, "tag");
            return (Criteria) this;
        }
        
        
        //-----------------------------自定义查询条件-----------------------------------
        public Criteria andDocInGroup(int value) {
        	addCriterion("EXISTS (SELECT 1 FROM dgp1 d WHERE d.Docid=Docid AND d.OdgpId=" + value + ")");
        	return (Criteria)this;
        }
        
        public Criteria andCustomQuery(String criteria) {
        	addCriterion("(DocName like '%" + criteria + "%' OR Tel like '" + criteria + "%' OR Weixin like '%" + criteria + 
        			"%' OR Email like '%" + criteria+ "%' OR CertiNum like '" + criteria + "%')");
        	return (Criteria)this;
        }
        
        public Criteria andAccountLike(String value) {
        	if(StringUtil.isNotEmpty(value)) {
        		addCriterion("Docid IN(SELECT Docid FROM `doc1` WHERE DocAcc LIKE '%" + value + "%')");
        	}
        	return (Criteria)this;
        }
        
        public Criteria andInMemberAndOrg(Integer orgId, Integer memberId) {
        	if(orgId != null && memberId != null) {
        		addCriterion("Docid IN (SELECT dg.Docid FROM `dgp1` dg INNER JOIN `odmt` dmt ON  dg.`OdgpId`=dmt.`OdgpId` AND dg.`OrgId`=" + orgId + " INNER JOIN `ompb` mpb ON mpb.`MemGrpid`=dmt.`MemGrpid` AND mpb.`Memberid`=" + memberId + ")");
        	}
        	return (Criteria)this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 医生档案(ODOC)
     * 
     * @author ${user}
     * @version 1.0 2016-06-23
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