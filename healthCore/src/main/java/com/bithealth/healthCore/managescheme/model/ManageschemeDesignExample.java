/*
 * ManageschemeDesignExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.enmu.MassEffectProcessEnum;

public class ManageschemeDesignExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ManageschemeDesignExample() {
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
     * [3.0]管理方案_制定
     * 
     * @author ${user}
     * @version 1.0 2016-12-08
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
        public Criteria andMSDesignIDIsNull() {
            addCriterion("MSDesignID is null");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDIsNotNull() {
            addCriterion("MSDesignID is not null");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDEqualTo(Integer value) {
            addCriterion("MSDesignID =", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDNotEqualTo(Integer value) {
            addCriterion("MSDesignID <>", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDGreaterThan(Integer value) {
            addCriterion("MSDesignID >", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSDesignID >=", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDLessThan(Integer value) {
            addCriterion("MSDesignID <", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDLessThanOrEqualTo(Integer value) {
            addCriterion("MSDesignID <=", value, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDIn(List<Integer> values) {
            addCriterion("MSDesignID in", values, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDNotIn(List<Integer> values) {
            addCriterion("MSDesignID not in", values, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDBetween(Integer value1, Integer value2) {
            addCriterion("MSDesignID between", value1, value2, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andMSDesignIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MSDesignID not between", value1, value2, "MSDesignID");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeIsNull() {
            addCriterion("SchemeType is null");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeIsNotNull() {
            addCriterion("SchemeType is not null");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeEqualTo(Byte value) {
            addCriterion("SchemeType =", value, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeNotEqualTo(Byte value) {
            addCriterion("SchemeType <>", value, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeGreaterThan(Byte value) {
            addCriterion("SchemeType >", value, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SchemeType >=", value, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeLessThan(Byte value) {
            addCriterion("SchemeType <", value, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("SchemeType <=", value, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeIn(List<Byte> values) {
            addCriterion("SchemeType in", values, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeNotIn(List<Byte> values) {
            addCriterion("SchemeType not in", values, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeBetween(Byte value1, Byte value2) {
            addCriterion("SchemeType between", value1, value2, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SchemeType not between", value1, value2, "schemeType");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleIsNull() {
            addCriterion("SchemeTitle is null");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleIsNotNull() {
            addCriterion("SchemeTitle is not null");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleEqualTo(String value) {
            addCriterion("SchemeTitle =", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleNotEqualTo(String value) {
            addCriterion("SchemeTitle <>", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleGreaterThan(String value) {
            addCriterion("SchemeTitle >", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("SchemeTitle >=", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleLessThan(String value) {
            addCriterion("SchemeTitle <", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleLessThanOrEqualTo(String value) {
            addCriterion("SchemeTitle <=", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("SchemeTitle like", "%"+value+"%", "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleNotLike(String value) {
            addCriterion("SchemeTitle not like", value, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleIn(List<String> values) {
            addCriterion("SchemeTitle in", values, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleNotIn(List<String> values) {
            addCriterion("SchemeTitle not in", values, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleBetween(String value1, String value2) {
            addCriterion("SchemeTitle between", value1, value2, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andSchemeTitleNotBetween(String value1, String value2) {
            addCriterion("SchemeTitle not between", value1, value2, "schemeTitle");
            return (Criteria) this;
        }
        public Criteria andMassStatusIsNull() {
            addCriterion("MassStatus is null");
            return (Criteria) this;
        }
        public Criteria andMassStatusIsNotNull() {
            addCriterion("MassStatus is not null");
            return (Criteria) this;
        }
        public Criteria andMassStatusEqualTo(Byte value) {
            addCriterion("MassStatus =", value, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusEqualTo(GroupManageschemeEnum status) {
        	if(status != null)
        		addCriterion("MassStatus =", status.getCode(), "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusNotEqualTo(Byte value) {
            addCriterion("MassStatus <>", value, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusGreaterThan(Byte value) {
            addCriterion("MassStatus >", value, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("MassStatus >=", value, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusLessThan(Byte value) {
            addCriterion("MassStatus <", value, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusLessThanOrEqualTo(Byte value) {
            addCriterion("MassStatus <=", value, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusIn(List<Byte> values) {
            addCriterion("MassStatus in", values, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusNotIn(List<Byte> values) {
            addCriterion("MassStatus not in", values, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusBetween(Byte value1, Byte value2) {
            addCriterion("MassStatus between", value1, value2, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("MassStatus not between", value1, value2, "massStatus");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeIsNull() {
            addCriterion("MassEffectTime is null");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeIsNotNull() {
            addCriterion("MassEffectTime is not null");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeEqualTo(Date value) {
            addCriterion("MassEffectTime =", value, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeNotEqualTo(Date value) {
            addCriterion("MassEffectTime <>", value, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeGreaterThan(Date value) {
            addCriterion("MassEffectTime >", value, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MassEffectTime >=", value, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeLessThan(Date value) {
            addCriterion("MassEffectTime <", value, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeLessThanOrEqualTo(Date value) {
            addCriterion("MassEffectTime <=", value, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeIn(List<Date> values) {
            addCriterion("MassEffectTime in", values, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeNotIn(List<Date> values) {
            addCriterion("MassEffectTime not in", values, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeBetween(Date value1, Date value2) {
            addCriterion("MassEffectTime between", value1, value2, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassEffectTimeNotBetween(Date value1, Date value2) {
            addCriterion("MassEffectTime not between", value1, value2, "massEffectTime");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonIsNull() {
            addCriterion("MassOffReason is null");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonIsNotNull() {
            addCriterion("MassOffReason is not null");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonEqualTo(String value) {
            addCriterion("MassOffReason =", value, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonNotEqualTo(String value) {
            addCriterion("MassOffReason <>", value, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonGreaterThan(String value) {
            addCriterion("MassOffReason >", value, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonGreaterThanOrEqualTo(String value) {
            addCriterion("MassOffReason >=", value, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonLessThan(String value) {
            addCriterion("MassOffReason <", value, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonLessThanOrEqualTo(String value) {
            addCriterion("MassOffReason <=", value, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonLike(String value) {
            addCriterion("MassOffReason like", value, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonNotLike(String value) {
            addCriterion("MassOffReason not like", value, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonIn(List<String> values) {
            addCriterion("MassOffReason in", values, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonNotIn(List<String> values) {
            addCriterion("MassOffReason not in", values, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonBetween(String value1, String value2) {
            addCriterion("MassOffReason between", value1, value2, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassOffReasonNotBetween(String value1, String value2) {
            addCriterion("MassOffReason not between", value1, value2, "massOffReason");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessIsNull() {
            addCriterion("MassEffectProcess is null");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessIsNotNull() {
            addCriterion("MassEffectProcess is not null");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessEqualTo(Byte value) {
            addCriterion("MassEffectProcess =", value, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessEqualTo(MassEffectProcessEnum effectProcess) {
        	if(effectProcess != null)
        		addCriterion("MassEffectProcess =", effectProcess.getCode(), "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessNotEqualTo(Byte value) {
            addCriterion("MassEffectProcess <>", value, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessGreaterThan(Byte value) {
            addCriterion("MassEffectProcess >", value, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessGreaterThanOrEqualTo(Byte value) {
            addCriterion("MassEffectProcess >=", value, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessLessThan(Byte value) {
            addCriterion("MassEffectProcess <", value, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessLessThanOrEqualTo(Byte value) {
            addCriterion("MassEffectProcess <=", value, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessIn(List<Byte> values) {
            addCriterion("MassEffectProcess in", values, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessNotIn(List<Byte> values) {
            addCriterion("MassEffectProcess not in", values, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessBetween(Byte value1, Byte value2) {
            addCriterion("MassEffectProcess between", value1, value2, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andMassEffectProcessNotBetween(Byte value1, Byte value2) {
            addCriterion("MassEffectProcess not between", value1, value2, "massEffectProcess");
            return (Criteria) this;
        }
        public Criteria andExecDrIDIsNull() {
            addCriterion("ExecDrID is null");
            return (Criteria) this;
        }
        public Criteria andExecDrIDIsNotNull() {
            addCriterion("ExecDrID is not null");
            return (Criteria) this;
        }
        public Criteria andExecDrIDEqualTo(Integer value) {
            addCriterion("ExecDrID =", value, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDNotEqualTo(Integer value) {
            addCriterion("ExecDrID <>", value, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDGreaterThan(Integer value) {
            addCriterion("ExecDrID >", value, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExecDrID >=", value, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDLessThan(Integer value) {
            addCriterion("ExecDrID <", value, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDLessThanOrEqualTo(Integer value) {
            addCriterion("ExecDrID <=", value, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDIn(List<Integer> values) {
            addCriterion("ExecDrID in", values, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDNotIn(List<Integer> values) {
            addCriterion("ExecDrID not in", values, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDBetween(Integer value1, Integer value2) {
            addCriterion("ExecDrID between", value1, value2, "execDrID");
            return (Criteria) this;
        }
        public Criteria andExecDrIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ExecDrID not between", value1, value2, "execDrID");
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
     * [3.0]管理方案_制定
     * 
     * @author ${user}
     * @version 1.0 2016-12-08
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