/*
 * DoctorGroupExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.model;

import java.util.ArrayList;
import java.util.List;

public class DoctorGroupExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public DoctorGroupExample() {
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
     * 医生分组(ODGP)
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
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andOdgpidIsNull() {
            addCriterion("OdgpId is null");
            return (Criteria) this;
        }
        public Criteria andOdgpidIsNotNull() {
            addCriterion("OdgpId is not null");
            return (Criteria) this;
        }
        public Criteria andOdgpidEqualTo(Integer value) {
            addCriterion("OdgpId =", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidNotEqualTo(Integer value) {
            addCriterion("OdgpId <>", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidGreaterThan(Integer value) {
            addCriterion("OdgpId >", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OdgpId >=", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidLessThan(Integer value) {
            addCriterion("OdgpId <", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidLessThanOrEqualTo(Integer value) {
            addCriterion("OdgpId <=", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidIn(List<Integer> values) {
            addCriterion("OdgpId in", values, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidNotIn(List<Integer> values) {
            addCriterion("OdgpId not in", values, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidBetween(Integer value1, Integer value2) {
            addCriterion("OdgpId between", value1, value2, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidNotBetween(Integer value1, Integer value2) {
            addCriterion("OdgpId not between", value1, value2, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpnameIsNull() {
            addCriterion("OdgpName is null");
            return (Criteria) this;
        }
        public Criteria andOdgpnameIsNotNull() {
            addCriterion("OdgpName is not null");
            return (Criteria) this;
        }
        public Criteria andOdgpnameEqualTo(String value) {
            addCriterion("OdgpName =", value, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameNotEqualTo(String value) {
            addCriterion("OdgpName <>", value, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameGreaterThan(String value) {
            addCriterion("OdgpName >", value, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameGreaterThanOrEqualTo(String value) {
            addCriterion("OdgpName >=", value, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameLessThan(String value) {
            addCriterion("OdgpName <", value, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameLessThanOrEqualTo(String value) {
            addCriterion("OdgpName <=", value, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameLike(String value) {
            addCriterion("OdgpName like", value, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameNotLike(String value) {
            addCriterion("OdgpName not like", value, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameIn(List<String> values) {
            addCriterion("OdgpName in", values, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameNotIn(List<String> values) {
            addCriterion("OdgpName not in", values, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameBetween(String value1, String value2) {
            addCriterion("OdgpName between", value1, value2, "odgpname");
            return (Criteria) this;
        }
        public Criteria andOdgpnameNotBetween(String value1, String value2) {
            addCriterion("OdgpName not between", value1, value2, "odgpname");
            return (Criteria) this;
        }
        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }
        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }
        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
        public Criteria andFathidIsNull() {
            addCriterion("FathId is null");
            return (Criteria) this;
        }
        public Criteria andFathidIsNotNull() {
            addCriterion("FathId is not null");
            return (Criteria) this;
        }
        public Criteria andFathidEqualTo(Integer value) {
            addCriterion("FathId =", value, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidNotEqualTo(Integer value) {
            addCriterion("FathId <>", value, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidGreaterThan(Integer value) {
            addCriterion("FathId >", value, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FathId >=", value, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidLessThan(Integer value) {
            addCriterion("FathId <", value, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidLessThanOrEqualTo(Integer value) {
            addCriterion("FathId <=", value, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidIn(List<Integer> values) {
            addCriterion("FathId in", values, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidNotIn(List<Integer> values) {
            addCriterion("FathId not in", values, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidBetween(Integer value1, Integer value2) {
            addCriterion("FathId between", value1, value2, "fathid");
            return (Criteria) this;
        }
        public Criteria andFathidNotBetween(Integer value1, Integer value2) {
            addCriterion("FathId not between", value1, value2, "fathid");
            return (Criteria) this;
        }
        public Criteria andDocnumIsNull() {
            addCriterion("DocNum is null");
            return (Criteria) this;
        }
        public Criteria andDocnumIsNotNull() {
            addCriterion("DocNum is not null");
            return (Criteria) this;
        }
        public Criteria andDocnumEqualTo(Integer value) {
            addCriterion("DocNum =", value, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumNotEqualTo(Integer value) {
            addCriterion("DocNum <>", value, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumGreaterThan(Integer value) {
            addCriterion("DocNum >", value, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("DocNum >=", value, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumLessThan(Integer value) {
            addCriterion("DocNum <", value, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumLessThanOrEqualTo(Integer value) {
            addCriterion("DocNum <=", value, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumIn(List<Integer> values) {
            addCriterion("DocNum in", values, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumNotIn(List<Integer> values) {
            addCriterion("DocNum not in", values, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumBetween(Integer value1, Integer value2) {
            addCriterion("DocNum between", value1, value2, "docnum");
            return (Criteria) this;
        }
        public Criteria andDocnumNotBetween(Integer value1, Integer value2) {
            addCriterion("DocNum not between", value1, value2, "docnum");
            return (Criteria) this;
        }
        public Criteria andChlevelIsNull() {
            addCriterion("ChLevel is null");
            return (Criteria) this;
        }
        public Criteria andChlevelIsNotNull() {
            addCriterion("ChLevel is not null");
            return (Criteria) this;
        }
        public Criteria andChlevelEqualTo(Short value) {
            addCriterion("ChLevel =", value, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelNotEqualTo(Short value) {
            addCriterion("ChLevel <>", value, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelGreaterThan(Short value) {
            addCriterion("ChLevel >", value, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("ChLevel >=", value, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelLessThan(Short value) {
            addCriterion("ChLevel <", value, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelLessThanOrEqualTo(Short value) {
            addCriterion("ChLevel <=", value, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelIn(List<Short> values) {
            addCriterion("ChLevel in", values, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelNotIn(List<Short> values) {
            addCriterion("ChLevel not in", values, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelBetween(Short value1, Short value2) {
            addCriterion("ChLevel between", value1, value2, "chlevel");
            return (Criteria) this;
        }
        public Criteria andChlevelNotBetween(Short value1, Short value2) {
            addCriterion("ChLevel not between", value1, value2, "chlevel");
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
        public Criteria andOptidIsNull() {
            addCriterion("OptId is null");
            return (Criteria) this;
        }
        public Criteria andOptidIsNotNull() {
            addCriterion("OptId is not null");
            return (Criteria) this;
        }
        public Criteria andOptidEqualTo(Short value) {
            addCriterion("OptId =", value, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidNotEqualTo(Short value) {
            addCriterion("OptId <>", value, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidGreaterThan(Short value) {
            addCriterion("OptId >", value, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidGreaterThanOrEqualTo(Short value) {
            addCriterion("OptId >=", value, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidLessThan(Short value) {
            addCriterion("OptId <", value, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidLessThanOrEqualTo(Short value) {
            addCriterion("OptId <=", value, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidIn(List<Short> values) {
            addCriterion("OptId in", values, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidNotIn(List<Short> values) {
            addCriterion("OptId not in", values, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidBetween(Short value1, Short value2) {
            addCriterion("OptId between", value1, value2, "optid");
            return (Criteria) this;
        }
        public Criteria andOptidNotBetween(Short value1, Short value2) {
            addCriterion("OptId not between", value1, value2, "optid");
            return (Criteria) this;
        }
        public Criteria andFunidIsNull() {
            addCriterion("FunId is null");
            return (Criteria) this;
        }
        public Criteria andFunidIsNotNull() {
            addCriterion("FunId is not null");
            return (Criteria) this;
        }
        public Criteria andFunidEqualTo(Short value) {
            addCriterion("FunId =", value, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidNotEqualTo(Short value) {
            addCriterion("FunId <>", value, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidGreaterThan(Short value) {
            addCriterion("FunId >", value, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidGreaterThanOrEqualTo(Short value) {
            addCriterion("FunId >=", value, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidLessThan(Short value) {
            addCriterion("FunId <", value, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidLessThanOrEqualTo(Short value) {
            addCriterion("FunId <=", value, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidIn(List<Short> values) {
            addCriterion("FunId in", values, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidNotIn(List<Short> values) {
            addCriterion("FunId not in", values, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidBetween(Short value1, Short value2) {
            addCriterion("FunId between", value1, value2, "funid");
            return (Criteria) this;
        }
        public Criteria andFunidNotBetween(Short value1, Short value2) {
            addCriterion("FunId not between", value1, value2, "funid");
            return (Criteria) this;
        }
        public Criteria andEndblocktagIsNull() {
            addCriterion("EndBlockTag is null");
            return (Criteria) this;
        }
        public Criteria andEndblocktagIsNotNull() {
            addCriterion("EndBlockTag is not null");
            return (Criteria) this;
        }
        public Criteria andEndblocktagEqualTo(Boolean value) {
            addCriterion("EndBlockTag =", value, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagNotEqualTo(Boolean value) {
            addCriterion("EndBlockTag <>", value, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagGreaterThan(Boolean value) {
            addCriterion("EndBlockTag >", value, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("EndBlockTag >=", value, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagLessThan(Boolean value) {
            addCriterion("EndBlockTag <", value, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagLessThanOrEqualTo(Boolean value) {
            addCriterion("EndBlockTag <=", value, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagIn(List<Boolean> values) {
            addCriterion("EndBlockTag in", values, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagNotIn(List<Boolean> values) {
            addCriterion("EndBlockTag not in", values, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagBetween(Boolean value1, Boolean value2) {
            addCriterion("EndBlockTag between", value1, value2, "endblocktag");
            return (Criteria) this;
        }
        public Criteria andEndblocktagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("EndBlockTag not between", value1, value2, "endblocktag");
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
        public Criteria andOrderIsNull() {
            addCriterion("`order` is null");
            return (Criteria) this;
        }
        public Criteria andOrderIsNotNull() {
            addCriterion("`order` is not null");
            return (Criteria) this;
        }
        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("`order` =", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("`order` <>", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("`order` >", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("`order` >=", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderLessThan(Integer value) {
            addCriterion("`order` <", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("`order` <=", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("`order` in", values, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("`order` not in", values, "order");
            return (Criteria) this;
        }
        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("`order` between", value1, value2, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("`order` not between", value1, value2, "order");
            return (Criteria) this;
        }
        public Criteria andPathIsNull() {
            addCriterion("Path is null");
            return (Criteria) this;
        }
        public Criteria andPathIsNotNull() {
            addCriterion("Path is not null");
            return (Criteria) this;
        }
        public Criteria andPathEqualTo(String value) {
            addCriterion("Path =", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathNotEqualTo(String value) {
            addCriterion("Path <>", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathGreaterThan(String value) {
            addCriterion("Path >", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("Path >=", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathLessThan(String value) {
            addCriterion("Path <", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("Path <=", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathLike(String value) {
            addCriterion("Path like", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathNotLike(String value) {
            addCriterion("Path not like", value, "path");
            return (Criteria) this;
        }
        public Criteria andPathIn(List<String> values) {
            addCriterion("Path in", values, "path");
            return (Criteria) this;
        }
        public Criteria andPathNotIn(List<String> values) {
            addCriterion("Path not in", values, "path");
            return (Criteria) this;
        }
        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("Path between", value1, value2, "path");
            return (Criteria) this;
        }
        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("Path not between", value1, value2, "path");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 医生分组(ODGP)
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