/*
 * ManageschemeDesignTaskExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManageschemeDesignTaskExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ManageschemeDesignTaskExample() {
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
     * [3.0]管理方案_制定_任务
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
        public Criteria andMSDTaskIDIsNull() {
            addCriterion("MSDTaskID is null");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDIsNotNull() {
            addCriterion("MSDTaskID is not null");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDEqualTo(Integer value) {
            addCriterion("MSDTaskID =", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDNotEqualTo(Integer value) {
            addCriterion("MSDTaskID <>", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDGreaterThan(Integer value) {
            addCriterion("MSDTaskID >", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSDTaskID >=", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDLessThan(Integer value) {
            addCriterion("MSDTaskID <", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDLessThanOrEqualTo(Integer value) {
            addCriterion("MSDTaskID <=", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDIn(List<Integer> values) {
            addCriterion("MSDTaskID in", values, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDNotIn(List<Integer> values) {
            addCriterion("MSDTaskID not in", values, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDBetween(Integer value1, Integer value2) {
            addCriterion("MSDTaskID between", value1, value2, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MSDTaskID not between", value1, value2, "MSDTaskID");
            return (Criteria) this;
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
        public Criteria andPlanTimeValueIsNull() {
            addCriterion("PlanTimeValue is null");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueIsNotNull() {
            addCriterion("PlanTimeValue is not null");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueEqualTo(Short value) {
            addCriterion("PlanTimeValue =", value, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueNotEqualTo(Short value) {
            addCriterion("PlanTimeValue <>", value, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueGreaterThan(Short value) {
            addCriterion("PlanTimeValue >", value, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueGreaterThanOrEqualTo(Short value) {
            addCriterion("PlanTimeValue >=", value, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueLessThan(Short value) {
            addCriterion("PlanTimeValue <", value, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueLessThanOrEqualTo(Short value) {
            addCriterion("PlanTimeValue <=", value, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueIn(List<Short> values) {
            addCriterion("PlanTimeValue in", values, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueNotIn(List<Short> values) {
            addCriterion("PlanTimeValue not in", values, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueBetween(Short value1, Short value2) {
            addCriterion("PlanTimeValue between", value1, value2, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeValueNotBetween(Short value1, Short value2) {
            addCriterion("PlanTimeValue not between", value1, value2, "planTimeValue");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeIsNull() {
            addCriterion("PlanTimeType is null");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeIsNotNull() {
            addCriterion("PlanTimeType is not null");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeEqualTo(Byte value) {
            addCriterion("PlanTimeType =", value, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeNotEqualTo(Byte value) {
            addCriterion("PlanTimeType <>", value, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeGreaterThan(Byte value) {
            addCriterion("PlanTimeType >", value, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("PlanTimeType >=", value, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeLessThan(Byte value) {
            addCriterion("PlanTimeType <", value, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("PlanTimeType <=", value, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeIn(List<Byte> values) {
            addCriterion("PlanTimeType in", values, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeNotIn(List<Byte> values) {
            addCriterion("PlanTimeType not in", values, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeBetween(Byte value1, Byte value2) {
            addCriterion("PlanTimeType between", value1, value2, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andPlanTimeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("PlanTimeType not between", value1, value2, "planTimeType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeIsNull() {
            addCriterion("TaskType is null");
            return (Criteria) this;
        }
        public Criteria andTaskTypeIsNotNull() {
            addCriterion("TaskType is not null");
            return (Criteria) this;
        }
        public Criteria andTaskTypeEqualTo(Byte value) {
            addCriterion("TaskType =", value, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeNotEqualTo(Byte value) {
            addCriterion("TaskType <>", value, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeGreaterThan(Byte value) {
            addCriterion("TaskType >", value, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("TaskType >=", value, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeLessThan(Byte value) {
            addCriterion("TaskType <", value, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeLessThanOrEqualTo(Byte value) {
            addCriterion("TaskType <=", value, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeIn(List<Byte> values) {
            addCriterion("TaskType in", values, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeNotIn(List<Byte> values) {
            addCriterion("TaskType not in", values, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeBetween(Byte value1, Byte value2) {
            addCriterion("TaskType between", value1, value2, "taskType");
            return (Criteria) this;
        }
        public Criteria andTaskTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("TaskType not between", value1, value2, "taskType");
            return (Criteria) this;
        }
        public Criteria andExecWayIsNull() {
            addCriterion("ExecWay is null");
            return (Criteria) this;
        }
        public Criteria andExecWayIsNotNull() {
            addCriterion("ExecWay is not null");
            return (Criteria) this;
        }
        public Criteria andExecWayEqualTo(Byte value) {
            addCriterion("ExecWay =", value, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayNotEqualTo(Byte value) {
            addCriterion("ExecWay <>", value, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayGreaterThan(Byte value) {
            addCriterion("ExecWay >", value, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayGreaterThanOrEqualTo(Byte value) {
            addCriterion("ExecWay >=", value, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayLessThan(Byte value) {
            addCriterion("ExecWay <", value, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayLessThanOrEqualTo(Byte value) {
            addCriterion("ExecWay <=", value, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayIn(List<Byte> values) {
            addCriterion("ExecWay in", values, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayNotIn(List<Byte> values) {
            addCriterion("ExecWay not in", values, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayBetween(Byte value1, Byte value2) {
            addCriterion("ExecWay between", value1, value2, "execWay");
            return (Criteria) this;
        }
        public Criteria andExecWayNotBetween(Byte value1, Byte value2) {
            addCriterion("ExecWay not between", value1, value2, "execWay");
            return (Criteria) this;
        }
        public Criteria andSummaryIsNull() {
            addCriterion("Summary is null");
            return (Criteria) this;
        }
        public Criteria andSummaryIsNotNull() {
            addCriterion("Summary is not null");
            return (Criteria) this;
        }
        public Criteria andSummaryEqualTo(String value) {
            addCriterion("Summary =", value, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("Summary <>", value, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("Summary >", value, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("Summary >=", value, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryLessThan(String value) {
            addCriterion("Summary <", value, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("Summary <=", value, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryLike(String value) {
            addCriterion("Summary like", value, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryNotLike(String value) {
            addCriterion("Summary not like", value, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryIn(List<String> values) {
            addCriterion("Summary in", values, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("Summary not in", values, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("Summary between", value1, value2, "summary");
            return (Criteria) this;
        }
        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("Summary not between", value1, value2, "summary");
            return (Criteria) this;
        }
        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }
        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }
        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
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
     * [3.0]管理方案_制定_任务
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