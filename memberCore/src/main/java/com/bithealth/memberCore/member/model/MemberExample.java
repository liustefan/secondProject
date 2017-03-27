/*
 * MemberExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bithealth.sdk.common.utils.StringUtil;

public class MemberExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemberExample() {
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
     * 会员档案（OMEM）
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
        public Criteria andMemberidIsNull() {
            addCriterion("Memberid is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("Memberid is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("Memberid =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("Memberid <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("Memberid >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Memberid >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("Memberid <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("Memberid <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("Memberid in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("Memberid not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("Memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("Memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andLognameIsNull() {
            addCriterion("LogName is null");
            return (Criteria) this;
        }
        public Criteria andLognameIsNotNull() {
            addCriterion("LogName is not null");
            return (Criteria) this;
        }
        public Criteria andLognameEqualTo(String value) {
            addCriterion("LogName =", value, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameNotEqualTo(String value) {
            addCriterion("LogName <>", value, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameGreaterThan(String value) {
            addCriterion("LogName >", value, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameGreaterThanOrEqualTo(String value) {
            addCriterion("LogName >=", value, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameLessThan(String value) {
            addCriterion("LogName <", value, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameLessThanOrEqualTo(String value) {
            addCriterion("LogName <=", value, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameLike(String value) {
            addCriterion("LogName like", value, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameNotLike(String value) {
            addCriterion("LogName not like", value, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameIn(List<String> values) {
            addCriterion("LogName in", values, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameNotIn(List<String> values) {
            addCriterion("LogName not in", values, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameBetween(String value1, String value2) {
            addCriterion("LogName between", value1, value2, "logname");
            return (Criteria) this;
        }
        public Criteria andLognameNotBetween(String value1, String value2) {
            addCriterion("LogName not between", value1, value2, "logname");
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
        public Criteria andMemidIsNull() {
            addCriterion("MemId is null");
            return (Criteria) this;
        }
        public Criteria andMemidIsNotNull() {
            addCriterion("MemId is not null");
            return (Criteria) this;
        }
        public Criteria andMemidEqualTo(Short value) {
            addCriterion("MemId =", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidNotEqualTo(Short value) {
            addCriterion("MemId <>", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidGreaterThan(Short value) {
            addCriterion("MemId >", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidGreaterThanOrEqualTo(Short value) {
            addCriterion("MemId >=", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidLessThan(Short value) {
            addCriterion("MemId <", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidLessThanOrEqualTo(Short value) {
            addCriterion("MemId <=", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidIn(List<Short> values) {
            addCriterion("MemId in", values, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidNotIn(List<Short> values) {
            addCriterion("MemId not in", values, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidBetween(Short value1, Short value2) {
            addCriterion("MemId between", value1, value2, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidNotBetween(Short value1, Short value2) {
            addCriterion("MemId not between", value1, value2, "memid");
            return (Criteria) this;
        }
        public Criteria andMemnameIsNull() {
            addCriterion("MemName is null");
            return (Criteria) this;
        }
        public Criteria andMemnameIsNotNull() {
            addCriterion("MemName is not null");
            return (Criteria) this;
        }
        public Criteria andMemnameEqualTo(String value) {
            addCriterion("MemName =", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameNotEqualTo(String value) {
            addCriterion("MemName <>", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameGreaterThan(String value) {
            addCriterion("MemName >", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameGreaterThanOrEqualTo(String value) {
            addCriterion("MemName >=", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameLessThan(String value) {
            addCriterion("MemName <", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameLessThanOrEqualTo(String value) {
            addCriterion("MemName <=", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameLike(String value) {
            addCriterion("MemName like", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameNotLike(String value) {
            addCriterion("MemName not like", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameIn(List<String> values) {
            addCriterion("MemName in", values, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameNotIn(List<String> values) {
            addCriterion("MemName not in", values, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameBetween(String value1, String value2) {
            addCriterion("MemName between", value1, value2, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameNotBetween(String value1, String value2) {
            addCriterion("MemName not between", value1, value2, "memname");
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
        public Criteria andIdcardIsNull() {
            addCriterion("IdCard is null");
            return (Criteria) this;
        }
        public Criteria andIdcardIsNotNull() {
            addCriterion("IdCard is not null");
            return (Criteria) this;
        }
        public Criteria andIdcardEqualTo(String value) {
            addCriterion("IdCard =", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("IdCard <>", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("IdCard >", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("IdCard >=", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardLessThan(String value) {
            addCriterion("IdCard <", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("IdCard <=", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardLike(String value) {
            addCriterion("IdCard like", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardNotLike(String value) {
            addCriterion("IdCard not like", value, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardIn(List<String> values) {
            addCriterion("IdCard in", values, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("IdCard not in", values, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("IdCard between", value1, value2, "idcard");
            return (Criteria) this;
        }
        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("IdCard not between", value1, value2, "idcard");
            return (Criteria) this;
        }
        public Criteria andNativeaddrIsNull() {
            addCriterion("NativeAddr is null");
            return (Criteria) this;
        }
        public Criteria andNativeaddrIsNotNull() {
            addCriterion("NativeAddr is not null");
            return (Criteria) this;
        }
        public Criteria andNativeaddrEqualTo(String value) {
            addCriterion("NativeAddr =", value, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrNotEqualTo(String value) {
            addCriterion("NativeAddr <>", value, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrGreaterThan(String value) {
            addCriterion("NativeAddr >", value, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrGreaterThanOrEqualTo(String value) {
            addCriterion("NativeAddr >=", value, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrLessThan(String value) {
            addCriterion("NativeAddr <", value, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrLessThanOrEqualTo(String value) {
            addCriterion("NativeAddr <=", value, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrLike(String value) {
            addCriterion("NativeAddr like", value, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrNotLike(String value) {
            addCriterion("NativeAddr not like", value, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrIn(List<String> values) {
            addCriterion("NativeAddr in", values, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrNotIn(List<String> values) {
            addCriterion("NativeAddr not in", values, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrBetween(String value1, String value2) {
            addCriterion("NativeAddr between", value1, value2, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andNativeaddrNotBetween(String value1, String value2) {
            addCriterion("NativeAddr not between", value1, value2, "nativeaddr");
            return (Criteria) this;
        }
        public Criteria andAddressIsNull() {
            addCriterion("Address is null");
            return (Criteria) this;
        }
        public Criteria andAddressIsNotNull() {
            addCriterion("Address is not null");
            return (Criteria) this;
        }
        public Criteria andAddressEqualTo(String value) {
            addCriterion("Address =", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("Address <>", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressGreaterThan(String value) {
            addCriterion("Address >", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Address >=", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressLessThan(String value) {
            addCriterion("Address <", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("Address <=", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressLike(String value) {
            addCriterion("Address like", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressNotLike(String value) {
            addCriterion("Address not like", value, "address");
            return (Criteria) this;
        }
        public Criteria andAddressIn(List<String> values) {
            addCriterion("Address in", values, "address");
            return (Criteria) this;
        }
        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("Address not in", values, "address");
            return (Criteria) this;
        }
        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("Address between", value1, value2, "address");
            return (Criteria) this;
        }
        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("Address not between", value1, value2, "address");
            return (Criteria) this;
        }
        public Criteria andMarrystatusIsNull() {
            addCriterion("MarryStatus is null");
            return (Criteria) this;
        }
        public Criteria andMarrystatusIsNotNull() {
            addCriterion("MarryStatus is not null");
            return (Criteria) this;
        }
        public Criteria andMarrystatusEqualTo(String value) {
            addCriterion("MarryStatus =", value, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusNotEqualTo(String value) {
            addCriterion("MarryStatus <>", value, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusGreaterThan(String value) {
            addCriterion("MarryStatus >", value, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusGreaterThanOrEqualTo(String value) {
            addCriterion("MarryStatus >=", value, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusLessThan(String value) {
            addCriterion("MarryStatus <", value, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusLessThanOrEqualTo(String value) {
            addCriterion("MarryStatus <=", value, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusLike(String value) {
            addCriterion("MarryStatus like", value, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusNotLike(String value) {
            addCriterion("MarryStatus not like", value, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusIn(List<String> values) {
            addCriterion("MarryStatus in", values, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusNotIn(List<String> values) {
            addCriterion("MarryStatus not in", values, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusBetween(String value1, String value2) {
            addCriterion("MarryStatus between", value1, value2, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andMarrystatusNotBetween(String value1, String value2) {
            addCriterion("MarryStatus not between", value1, value2, "marrystatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusIsNull() {
            addCriterion("EducationStatus is null");
            return (Criteria) this;
        }
        public Criteria andEducationstatusIsNotNull() {
            addCriterion("EducationStatus is not null");
            return (Criteria) this;
        }
        public Criteria andEducationstatusEqualTo(String value) {
            addCriterion("EducationStatus =", value, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusNotEqualTo(String value) {
            addCriterion("EducationStatus <>", value, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusGreaterThan(String value) {
            addCriterion("EducationStatus >", value, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusGreaterThanOrEqualTo(String value) {
            addCriterion("EducationStatus >=", value, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusLessThan(String value) {
            addCriterion("EducationStatus <", value, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusLessThanOrEqualTo(String value) {
            addCriterion("EducationStatus <=", value, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusLike(String value) {
            addCriterion("EducationStatus like", value, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusNotLike(String value) {
            addCriterion("EducationStatus not like", value, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusIn(List<String> values) {
            addCriterion("EducationStatus in", values, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusNotIn(List<String> values) {
            addCriterion("EducationStatus not in", values, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusBetween(String value1, String value2) {
            addCriterion("EducationStatus between", value1, value2, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andEducationstatusNotBetween(String value1, String value2) {
            addCriterion("EducationStatus not between", value1, value2, "educationstatus");
            return (Criteria) this;
        }
        public Criteria andOccupationIsNull() {
            addCriterion("Occupation is null");
            return (Criteria) this;
        }
        public Criteria andOccupationIsNotNull() {
            addCriterion("Occupation is not null");
            return (Criteria) this;
        }
        public Criteria andOccupationEqualTo(String value) {
            addCriterion("Occupation =", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationNotEqualTo(String value) {
            addCriterion("Occupation <>", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationGreaterThan(String value) {
            addCriterion("Occupation >", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationGreaterThanOrEqualTo(String value) {
            addCriterion("Occupation >=", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationLessThan(String value) {
            addCriterion("Occupation <", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationLessThanOrEqualTo(String value) {
            addCriterion("Occupation <=", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationLike(String value) {
            addCriterion("Occupation like", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationNotLike(String value) {
            addCriterion("Occupation not like", value, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationIn(List<String> values) {
            addCriterion("Occupation in", values, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationNotIn(List<String> values) {
            addCriterion("Occupation not in", values, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationBetween(String value1, String value2) {
            addCriterion("Occupation between", value1, value2, "occupation");
            return (Criteria) this;
        }
        public Criteria andOccupationNotBetween(String value1, String value2) {
            addCriterion("Occupation not between", value1, value2, "occupation");
            return (Criteria) this;
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
        public Criteria andUsetagIsNull() {
            addCriterion("UseTag is null");
            return (Criteria) this;
        }
        public Criteria andUsetagIsNotNull() {
            addCriterion("UseTag is not null");
            return (Criteria) this;
        }
        public Criteria andUsetagEqualTo(String value) {
            addCriterion("UseTag =", value, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagNotEqualTo(String value) {
            addCriterion("UseTag <>", value, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagGreaterThan(String value) {
            addCriterion("UseTag >", value, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagGreaterThanOrEqualTo(String value) {
            addCriterion("UseTag >=", value, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagLessThan(String value) {
            addCriterion("UseTag <", value, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagLessThanOrEqualTo(String value) {
            addCriterion("UseTag <=", value, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagLike(String value) {
            addCriterion("UseTag like", value, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagNotLike(String value) {
            addCriterion("UseTag not like", value, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagIn(List<String> values) {
            addCriterion("UseTag in", values, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagNotIn(List<String> values) {
            addCriterion("UseTag not in", values, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagBetween(String value1, String value2) {
            addCriterion("UseTag between", value1, value2, "usetag");
            return (Criteria) this;
        }
        public Criteria andUsetagNotBetween(String value1, String value2) {
            addCriterion("UseTag not between", value1, value2, "usetag");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }
        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andHeadimgIsNull() {
            addCriterion("headImg is null");
            return (Criteria) this;
        }
        public Criteria andHeadimgIsNotNull() {
            addCriterion("headImg is not null");
            return (Criteria) this;
        }
        public Criteria andHeadimgEqualTo(byte[] value) {
            addCriterion("headImg =", value, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgNotEqualTo(byte[] value) {
            addCriterion("headImg <>", value, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgGreaterThan(byte[] value) {
            addCriterion("headImg >", value, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgGreaterThanOrEqualTo(byte[] value) {
            addCriterion("headImg >=", value, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgLessThan(byte[] value) {
            addCriterion("headImg <", value, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgLessThanOrEqualTo(byte[] value) {
            addCriterion("headImg <=", value, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgIn(List<byte[]> values) {
            addCriterion("headImg in", values, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgNotIn(List<byte[]> values) {
            addCriterion("headImg not in", values, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgBetween(byte[] value1, byte[] value2) {
            addCriterion("headImg between", value1, value2, "headimg");
            return (Criteria) this;
        }
        public Criteria andHeadimgNotBetween(byte[] value1, byte[] value2) {
            addCriterion("headImg not between", value1, value2, "headimg");
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
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }
        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }
        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }
        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }
        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }
        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }
        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }
        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }
        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }
        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }
        public Criteria andUniqueIdIsNull() {
            addCriterion("unique_id is null");
            return (Criteria) this;
        }
        public Criteria andUniqueIdIsNotNull() {
            addCriterion("unique_id is not null");
            return (Criteria) this;
        }
        public Criteria andUniqueIdEqualTo(String value) {
            addCriterion("unique_id =", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdNotEqualTo(String value) {
            addCriterion("unique_id <>", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdGreaterThan(String value) {
            addCriterion("unique_id >", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdGreaterThanOrEqualTo(String value) {
            addCriterion("unique_id >=", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdLessThan(String value) {
            addCriterion("unique_id <", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdLessThanOrEqualTo(String value) {
            addCriterion("unique_id <=", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdLike(String value) {
            addCriterion("unique_id like", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdNotLike(String value) {
            addCriterion("unique_id not like", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdIn(List<String> values) {
            addCriterion("unique_id in", values, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdNotIn(List<String> values) {
            addCriterion("unique_id not in", values, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdBetween(String value1, String value2) {
            addCriterion("unique_id between", value1, value2, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdNotBetween(String value1, String value2) {
            addCriterion("unique_id not between", value1, value2, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDIsNull() {
            addCriterion("memberGUID is null");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDIsNotNull() {
            addCriterion("memberGUID is not null");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDEqualTo(String value) {
            addCriterion("memberGUID =", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotEqualTo(String value) {
            addCriterion("memberGUID <>", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDGreaterThan(String value) {
            addCriterion("memberGUID >", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("memberGUID >=", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLessThan(String value) {
            addCriterion("memberGUID <", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLessThanOrEqualTo(String value) {
            addCriterion("memberGUID <=", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLike(String value) {
            addCriterion("memberGUID like", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotLike(String value) {
            addCriterion("memberGUID not like", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDIn(List<String> values) {
            addCriterion("memberGUID in", values, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotIn(List<String> values) {
            addCriterion("memberGUID not in", values, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDBetween(String value1, String value2) {
            addCriterion("memberGUID between", value1, value2, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotBetween(String value1, String value2) {
            addCriterion("memberGUID not between", value1, value2, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeIsNull() {
            addCriterion("MemNameCode is null");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeIsNotNull() {
            addCriterion("MemNameCode is not null");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeEqualTo(String value) {
            addCriterion("MemNameCode =", value, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeNotEqualTo(String value) {
            addCriterion("MemNameCode <>", value, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeGreaterThan(String value) {
            addCriterion("MemNameCode >", value, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MemNameCode >=", value, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeLessThan(String value) {
            addCriterion("MemNameCode <", value, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeLessThanOrEqualTo(String value) {
            addCriterion("MemNameCode <=", value, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeLike(String value) {
            addCriterion("MemNameCode like", value, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeNotLike(String value) {
            addCriterion("MemNameCode not like", value, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeIn(List<String> values) {
            addCriterion("MemNameCode in", values, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeNotIn(List<String> values) {
            addCriterion("MemNameCode not in", values, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeBetween(String value1, String value2) {
            addCriterion("MemNameCode between", value1, value2, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andMemNameCodeNotBetween(String value1, String value2) {
            addCriterion("MemNameCode not between", value1, value2, "memNameCode");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeIsNull() {
            addCriterion("VerifyType is null");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeIsNotNull() {
            addCriterion("VerifyType is not null");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeEqualTo(Byte value) {
            addCriterion("VerifyType =", value, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeNotEqualTo(Byte value) {
            addCriterion("VerifyType <>", value, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeGreaterThan(Byte value) {
            addCriterion("VerifyType >", value, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("VerifyType >=", value, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeLessThan(Byte value) {
            addCriterion("VerifyType <", value, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeLessThanOrEqualTo(Byte value) {
            addCriterion("VerifyType <=", value, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeIn(List<Byte> values) {
            addCriterion("VerifyType in", values, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeNotIn(List<Byte> values) {
            addCriterion("VerifyType not in", values, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeBetween(Byte value1, Byte value2) {
            addCriterion("VerifyType between", value1, value2, "verifyType");
            return (Criteria) this;
        }
        public Criteria andVerifyTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("VerifyType not between", value1, value2, "verifyType");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectIsNull() {
            addCriterion("IsInfoPerfect is null");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectIsNotNull() {
            addCriterion("IsInfoPerfect is not null");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectEqualTo(Byte value) {
            addCriterion("IsInfoPerfect =", value, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectNotEqualTo(Byte value) {
            addCriterion("IsInfoPerfect <>", value, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectGreaterThan(Byte value) {
            addCriterion("IsInfoPerfect >", value, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsInfoPerfect >=", value, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectLessThan(Byte value) {
            addCriterion("IsInfoPerfect <", value, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectLessThanOrEqualTo(Byte value) {
            addCriterion("IsInfoPerfect <=", value, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectIn(List<Byte> values) {
            addCriterion("IsInfoPerfect in", values, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectNotIn(List<Byte> values) {
            addCriterion("IsInfoPerfect not in", values, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectBetween(Byte value1, Byte value2) {
            addCriterion("IsInfoPerfect between", value1, value2, "isInfoPerfect");
            return (Criteria) this;
        }
        public Criteria andIsInfoPerfectNotBetween(Byte value1, Byte value2) {
            addCriterion("IsInfoPerfect not between", value1, value2, "isInfoPerfect");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员档案（OMEM）
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