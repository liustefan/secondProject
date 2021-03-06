/*
 * PhDiabetesExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;

public class PhDiabetesExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    protected Page<PhDiabetes> page;

    public PhDiabetesExample() {
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
        page = null;
    }

    public Page<PhDiabetes> getPage() {
		return page;
	}
	public void setPage(Page<PhDiabetes> page) {
		this.page = page;
	}

	/**
     * 公共卫生_2型糖尿病随访表
     * 
     * @author ${user}
     * @version 1.0 2016-06-28
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
                throw new RuntimeException("Value for condition cannot be null");
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
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andDiabetesIDIsNull() {
            addCriterion("DiabetesID is null");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDIsNotNull() {
            addCriterion("DiabetesID is not null");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDEqualTo(Long value) {
            addCriterion("DiabetesID =", value, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDNotEqualTo(Long value) {
            addCriterion("DiabetesID <>", value, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDGreaterThan(Long value) {
            addCriterion("DiabetesID >", value, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDGreaterThanOrEqualTo(Long value) {
            addCriterion("DiabetesID >=", value, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDLessThan(Long value) {
            addCriterion("DiabetesID <", value, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDLessThanOrEqualTo(Long value) {
            addCriterion("DiabetesID <=", value, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDIn(List<Long> values) {
            addCriterion("DiabetesID in", values, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDNotIn(List<Long> values) {
            addCriterion("DiabetesID not in", values, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDBetween(Long value1, Long value2) {
            addCriterion("DiabetesID between", value1, value2, "diabetesID");
            return (Criteria) this;
        }
        public Criteria andDiabetesIDNotBetween(Long value1, Long value2) {
            addCriterion("DiabetesID not between", value1, value2, "diabetesID");
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
        public Criteria andMemberIDEqualTo(Integer value) {
            addCriterion("MemberID =", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotEqualTo(Integer value) {
            addCriterion("MemberID <>", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDGreaterThan(Integer value) {
            addCriterion("MemberID >", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MemberID >=", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLessThan(Integer value) {
            addCriterion("MemberID <", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDLessThanOrEqualTo(Integer value) {
            addCriterion("MemberID <=", value, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDIn(List<Integer> values) {
            addCriterion("MemberID in", values, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotIn(List<Integer> values) {
            addCriterion("MemberID not in", values, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDBetween(Integer value1, Integer value2) {
            addCriterion("MemberID between", value1, value2, "memberID");
            return (Criteria) this;
        }
        public Criteria andMemberIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MemberID not between", value1, value2, "memberID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDIsNull() {
            addCriterion("Unique_ID is null");
            return (Criteria) this;
        }
        public Criteria andUnique_IDIsNotNull() {
            addCriterion("Unique_ID is not null");
            return (Criteria) this;
        }
        public Criteria andUnique_IDEqualTo(String value) {
            addCriterion("Unique_ID =", value, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDNotEqualTo(String value) {
            addCriterion("Unique_ID <>", value, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDGreaterThan(String value) {
            addCriterion("Unique_ID >", value, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDGreaterThanOrEqualTo(String value) {
            addCriterion("Unique_ID >=", value, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDLessThan(String value) {
            addCriterion("Unique_ID <", value, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDLessThanOrEqualTo(String value) {
            addCriterion("Unique_ID <=", value, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDLike(String value) {
            addCriterion("Unique_ID like", value, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDNotLike(String value) {
            addCriterion("Unique_ID not like", value, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDIn(List<String> values) {
            addCriterion("Unique_ID in", values, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDNotIn(List<String> values) {
            addCriterion("Unique_ID not in", values, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDBetween(String value1, String value2) {
            addCriterion("Unique_ID between", value1, value2, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andUnique_IDNotBetween(String value1, String value2) {
            addCriterion("Unique_ID not between", value1, value2, "unique_ID");
            return (Criteria) this;
        }
        public Criteria andRefCompanyIsNull() {
            addCriterion("RefCompany is null");
            return (Criteria) this;
        }
        public Criteria andRefCompanyIsNotNull() {
            addCriterion("RefCompany is not null");
            return (Criteria) this;
        }
        public Criteria andRefCompanyEqualTo(Byte value) {
            addCriterion("RefCompany =", value, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyNotEqualTo(Byte value) {
            addCriterion("RefCompany <>", value, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyGreaterThan(Byte value) {
            addCriterion("RefCompany >", value, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyGreaterThanOrEqualTo(Byte value) {
            addCriterion("RefCompany >=", value, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyLessThan(Byte value) {
            addCriterion("RefCompany <", value, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyLessThanOrEqualTo(Byte value) {
            addCriterion("RefCompany <=", value, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyIn(List<Byte> values) {
            addCriterion("RefCompany in", values, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyNotIn(List<Byte> values) {
            addCriterion("RefCompany not in", values, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyBetween(Byte value1, Byte value2) {
            addCriterion("RefCompany between", value1, value2, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefCompanyNotBetween(Byte value1, Byte value2) {
            addCriterion("RefCompany not between", value1, value2, "refCompany");
            return (Criteria) this;
        }
        public Criteria andRefDataPKIsNull() {
            addCriterion("RefDataPK is null");
            return (Criteria) this;
        }
        public Criteria andRefDataPKIsNotNull() {
            addCriterion("RefDataPK is not null");
            return (Criteria) this;
        }
        public Criteria andRefDataPKEqualTo(String value) {
            addCriterion("RefDataPK =", value, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKNotEqualTo(String value) {
            addCriterion("RefDataPK <>", value, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKGreaterThan(String value) {
            addCriterion("RefDataPK >", value, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKGreaterThanOrEqualTo(String value) {
            addCriterion("RefDataPK >=", value, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKLessThan(String value) {
            addCriterion("RefDataPK <", value, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKLessThanOrEqualTo(String value) {
            addCriterion("RefDataPK <=", value, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKLike(String value) {
            addCriterion("RefDataPK like", value, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKNotLike(String value) {
            addCriterion("RefDataPK not like", value, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKIn(List<String> values) {
            addCriterion("RefDataPK in", values, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKNotIn(List<String> values) {
            addCriterion("RefDataPK not in", values, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKBetween(String value1, String value2) {
            addCriterion("RefDataPK between", value1, value2, "refDataPK");
            return (Criteria) this;
        }
        public Criteria andRefDataPKNotBetween(String value1, String value2) {
            addCriterion("RefDataPK not between", value1, value2, "refDataPK");
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
        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }
        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }
        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }
        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }
        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }
        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }
        public Criteria andVisitDateIsNull() {
            addCriterion("VisitDate is null");
            return (Criteria) this;
        }
        public Criteria andVisitDateIsNotNull() {
            addCriterion("VisitDate is not null");
            return (Criteria) this;
        }
        public Criteria andVisitDateEqualTo(Date value) {
            addCriterion("VisitDate =", value, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateNotEqualTo(Date value) {
            addCriterion("VisitDate <>", value, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateGreaterThan(Date value) {
            addCriterion("VisitDate >", value, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("VisitDate >=", value, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateLessThan(Date value) {
            addCriterion("VisitDate <", value, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateLessThanOrEqualTo(Date value) {
            addCriterion("VisitDate <=", value, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateIn(List<Date> values) {
            addCriterion("VisitDate in", values, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateNotIn(List<Date> values) {
            addCriterion("VisitDate not in", values, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateBetween(Date value1, Date value2) {
            addCriterion("VisitDate between", value1, value2, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDateNotBetween(Date value1, Date value2) {
            addCriterion("VisitDate not between", value1, value2, "visitDate");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameIsNull() {
            addCriterion("VisitDrName is null");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameIsNotNull() {
            addCriterion("VisitDrName is not null");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameEqualTo(String value) {
            addCriterion("VisitDrName =", value, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameNotEqualTo(String value) {
            addCriterion("VisitDrName <>", value, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameGreaterThan(String value) {
            addCriterion("VisitDrName >", value, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameGreaterThanOrEqualTo(String value) {
            addCriterion("VisitDrName >=", value, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameLessThan(String value) {
            addCriterion("VisitDrName <", value, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameLessThanOrEqualTo(String value) {
            addCriterion("VisitDrName <=", value, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameLike(String value) {
            addCriterion("VisitDrName like", value, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameNotLike(String value) {
            addCriterion("VisitDrName not like", value, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameIn(List<String> values) {
            addCriterion("VisitDrName in", values, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameNotIn(List<String> values) {
            addCriterion("VisitDrName not in", values, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameBetween(String value1, String value2) {
            addCriterion("VisitDrName between", value1, value2, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitDrNameNotBetween(String value1, String value2) {
            addCriterion("VisitDrName not between", value1, value2, "visitDrName");
            return (Criteria) this;
        }
        public Criteria andVisitClassIsNull() {
            addCriterion("VisitClass is null");
            return (Criteria) this;
        }
        public Criteria andVisitClassIsNotNull() {
            addCriterion("VisitClass is not null");
            return (Criteria) this;
        }
        public Criteria andVisitClassEqualTo(Byte value) {
            addCriterion("VisitClass =", value, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassNotEqualTo(Byte value) {
            addCriterion("VisitClass <>", value, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassGreaterThan(Byte value) {
            addCriterion("VisitClass >", value, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassGreaterThanOrEqualTo(Byte value) {
            addCriterion("VisitClass >=", value, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassLessThan(Byte value) {
            addCriterion("VisitClass <", value, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassLessThanOrEqualTo(Byte value) {
            addCriterion("VisitClass <=", value, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassIn(List<Byte> values) {
            addCriterion("VisitClass in", values, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassNotIn(List<Byte> values) {
            addCriterion("VisitClass not in", values, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassBetween(Byte value1, Byte value2) {
            addCriterion("VisitClass between", value1, value2, "visitClass");
            return (Criteria) this;
        }
        public Criteria andVisitClassNotBetween(Byte value1, Byte value2) {
            addCriterion("VisitClass not between", value1, value2, "visitClass");
            return (Criteria) this;
        }
        public Criteria andGetTimeIsNull() {
            addCriterion("GetTime is null");
            return (Criteria) this;
        }
        public Criteria andGetTimeIsNotNull() {
            addCriterion("GetTime is not null");
            return (Criteria) this;
        }
        public Criteria andGetTimeEqualTo(Date value) {
            addCriterion("GetTime =", value, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeNotEqualTo(Date value) {
            addCriterion("GetTime <>", value, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeGreaterThan(Date value) {
            addCriterion("GetTime >", value, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("GetTime >=", value, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeLessThan(Date value) {
            addCriterion("GetTime <", value, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeLessThanOrEqualTo(Date value) {
            addCriterion("GetTime <=", value, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeIn(List<Date> values) {
            addCriterion("GetTime in", values, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeNotIn(List<Date> values) {
            addCriterion("GetTime not in", values, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeBetween(Date value1, Date value2) {
            addCriterion("GetTime between", value1, value2, "getTime");
            return (Criteria) this;
        }
        public Criteria andGetTimeNotBetween(Date value1, Date value2) {
            addCriterion("GetTime not between", value1, value2, "getTime");
            return (Criteria) this;
        }
        public Criteria andIsDeletedIsNull() {
            addCriterion("IsDeleted is null");
            return (Criteria) this;
        }
        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IsDeleted is not null");
            return (Criteria) this;
        }
        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("IsDeleted =", value, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("IsDeleted <>", value, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("IsDeleted >", value, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsDeleted >=", value, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("IsDeleted <", value, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("IsDeleted <=", value, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("IsDeleted in", values, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("IsDeleted not in", values, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("IsDeleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("IsDeleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDIsNull() {
            addCriterion("CreateDrID is null");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDIsNotNull() {
            addCriterion("CreateDrID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDEqualTo(Integer value) {
            addCriterion("CreateDrID =", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDNotEqualTo(Integer value) {
            addCriterion("CreateDrID <>", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDGreaterThan(Integer value) {
            addCriterion("CreateDrID >", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateDrID >=", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDLessThan(Integer value) {
            addCriterion("CreateDrID <", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDLessThanOrEqualTo(Integer value) {
            addCriterion("CreateDrID <=", value, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDIn(List<Integer> values) {
            addCriterion("CreateDrID in", values, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDNotIn(List<Integer> values) {
            addCriterion("CreateDrID not in", values, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDBetween(Integer value1, Integer value2) {
            addCriterion("CreateDrID between", value1, value2, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrIDNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateDrID not between", value1, value2, "createDrID");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameIsNull() {
            addCriterion("CreateDrName is null");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameIsNotNull() {
            addCriterion("CreateDrName is not null");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameEqualTo(String value) {
            addCriterion("CreateDrName =", value, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameNotEqualTo(String value) {
            addCriterion("CreateDrName <>", value, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameGreaterThan(String value) {
            addCriterion("CreateDrName >", value, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameGreaterThanOrEqualTo(String value) {
            addCriterion("CreateDrName >=", value, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameLessThan(String value) {
            addCriterion("CreateDrName <", value, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameLessThanOrEqualTo(String value) {
            addCriterion("CreateDrName <=", value, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameLike(String value) {
            addCriterion("CreateDrName like", value, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameNotLike(String value) {
            addCriterion("CreateDrName not like", value, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameIn(List<String> values) {
            addCriterion("CreateDrName in", values, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameNotIn(List<String> values) {
            addCriterion("CreateDrName not in", values, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameBetween(String value1, String value2) {
            addCriterion("CreateDrName between", value1, value2, "createDrName");
            return (Criteria) this;
        }
        public Criteria andCreateDrNameNotBetween(String value1, String value2) {
            addCriterion("CreateDrName not between", value1, value2, "createDrName");
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
        public Criteria andUpdateDrIDIsNull() {
            addCriterion("UpdateDrID is null");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDIsNotNull() {
            addCriterion("UpdateDrID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDEqualTo(Integer value) {
            addCriterion("UpdateDrID =", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDNotEqualTo(Integer value) {
            addCriterion("UpdateDrID <>", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDGreaterThan(Integer value) {
            addCriterion("UpdateDrID >", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateDrID >=", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDLessThan(Integer value) {
            addCriterion("UpdateDrID <", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateDrID <=", value, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDIn(List<Integer> values) {
            addCriterion("UpdateDrID in", values, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDNotIn(List<Integer> values) {
            addCriterion("UpdateDrID not in", values, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDBetween(Integer value1, Integer value2) {
            addCriterion("UpdateDrID between", value1, value2, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrIDNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateDrID not between", value1, value2, "updateDrID");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameIsNull() {
            addCriterion("UpdateDrName is null");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameIsNotNull() {
            addCriterion("UpdateDrName is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameEqualTo(String value) {
            addCriterion("UpdateDrName =", value, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameNotEqualTo(String value) {
            addCriterion("UpdateDrName <>", value, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameGreaterThan(String value) {
            addCriterion("UpdateDrName >", value, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameGreaterThanOrEqualTo(String value) {
            addCriterion("UpdateDrName >=", value, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameLessThan(String value) {
            addCriterion("UpdateDrName <", value, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameLessThanOrEqualTo(String value) {
            addCriterion("UpdateDrName <=", value, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameLike(String value) {
            addCriterion("UpdateDrName like", value, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameNotLike(String value) {
            addCriterion("UpdateDrName not like", value, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameIn(List<String> values) {
            addCriterion("UpdateDrName in", values, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameNotIn(List<String> values) {
            addCriterion("UpdateDrName not in", values, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameBetween(String value1, String value2) {
            addCriterion("UpdateDrName between", value1, value2, "updateDrName");
            return (Criteria) this;
        }
        public Criteria andUpdateDrNameNotBetween(String value1, String value2) {
            addCriterion("UpdateDrName not between", value1, value2, "updateDrName");
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
        public Criteria andMSETaskIDEqualTo(Long value) {
            addCriterion("MSETaskID =", value, "MSETaskID");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 公共卫生_2型糖尿病随访表
     * 
     * @author ${user}
     * @version 1.0 2016-06-28
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