/*
 * LabelItemExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.memberCore.memberLabel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;


public class LabelItemExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public LabelItemExample() {
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
     * [3.0]会员标签小项表
     * 
     * @author ${user}
     * @version 1.0 2016-11-29
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
        public Criteria andLitemidIsNull() {
            addCriterion("LItemID is null");
            return (Criteria) this;
        }
        public Criteria andLitemidIsNotNull() {
            addCriterion("LItemID is not null");
            return (Criteria) this;
        }
        public Criteria andLitemidEqualTo(Integer value) {
            addCriterion("LItemID =", value, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidNotEqualTo(Integer value) {
            addCriterion("LItemID <>", value, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidGreaterThan(Integer value) {
            addCriterion("LItemID >", value, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LItemID >=", value, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidLessThan(Integer value) {
            addCriterion("LItemID <", value, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidLessThanOrEqualTo(Integer value) {
            addCriterion("LItemID <=", value, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidIn(List<Integer> values) {
            addCriterion("LItemID in", values, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidNotIn(List<Integer> values) {
            addCriterion("LItemID not in", values, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidBetween(Integer value1, Integer value2) {
            addCriterion("LItemID between", value1, value2, "litemid");
            return (Criteria) this;
        }
        public Criteria andLitemidNotBetween(Integer value1, Integer value2) {
            addCriterion("LItemID not between", value1, value2, "litemid");
            return (Criteria) this;
        }
        public Criteria andLclassidIsNull() {
            addCriterion("tb_label_item.LClassID is null");
            return (Criteria) this;
        }
        public Criteria andLclassidIsNotNull() {
            addCriterion("tb_label_item.LClassID is not null");
            return (Criteria) this;
        }
        public Criteria andLclassidEqualTo(Integer value) {
            addCriterion("tb_label_item.LClassID =", value, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidNotEqualTo(Integer value) {
            addCriterion("tb_label_item.LClassID <>", value, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidGreaterThan(Integer value) {
            addCriterion("tb_label_item.LClassID >", value, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_label_item.LClassID >=", value, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidLessThan(Integer value) {
            addCriterion("tb_label_item.LClassID <", value, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidLessThanOrEqualTo(Integer value) {
            addCriterion("tb_label_item.LClassID <=", value, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidIn(List<Integer> values) {
            addCriterion("tb_label_item.LClassID in", values, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidNotIn(List<Integer> values) {
            addCriterion("tb_label_item.LClassID not in", values, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidBetween(Integer value1, Integer value2) {
            addCriterion("tb_label_item.LClassID between", value1, value2, "lclassid");
            return (Criteria) this;
        }
        public Criteria andLclassidNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_label_item.LClassID not between", value1, value2, "lclassid");
            return (Criteria) this;
        }
        public Criteria andItemnameIsNull() {
            addCriterion("ItemName is null");
            return (Criteria) this;
        }
        public Criteria andItemnameIsNotNull() {
            addCriterion("ItemName is not null");
            return (Criteria) this;
        }
        public Criteria andItemnameEqualTo(String value) {
            addCriterion("ItemName =", value, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameNotEqualTo(String value) {
            addCriterion("ItemName <>", value, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameGreaterThan(String value) {
            addCriterion("ItemName >", value, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameGreaterThanOrEqualTo(String value) {
            addCriterion("ItemName >=", value, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameLessThan(String value) {
            addCriterion("ItemName <", value, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameLessThanOrEqualTo(String value) {
            addCriterion("ItemName <=", value, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameLike(String value) {
        	if(StringUtils.isNotEmpty(value))
        		addCriterion("ItemName like", "%" + value + "%", "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameNotLike(String value) {
            addCriterion("ItemName not like", value, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameIn(List<String> values) {
            addCriterion("ItemName in", values, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameNotIn(List<String> values) {
            addCriterion("ItemName not in", values, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameBetween(String value1, String value2) {
            addCriterion("ItemName between", value1, value2, "itemname");
            return (Criteria) this;
        }
        public Criteria andItemnameNotBetween(String value1, String value2) {
            addCriterion("ItemName not between", value1, value2, "itemname");
            return (Criteria) this;
        }
        public Criteria andRemarksIsNull() {
            addCriterion("Remarks is null");
            return (Criteria) this;
        }
        public Criteria andRemarksIsNotNull() {
            addCriterion("Remarks is not null");
            return (Criteria) this;
        }
        public Criteria andRemarksEqualTo(String value) {
            addCriterion("Remarks =", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("Remarks <>", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("Remarks >", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("Remarks >=", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksLessThan(String value) {
            addCriterion("Remarks <", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("Remarks <=", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksLike(String value) {
            addCriterion("Remarks like", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksNotLike(String value) {
            addCriterion("Remarks not like", value, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksIn(List<String> values) {
            addCriterion("Remarks in", values, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("Remarks not in", values, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("Remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }
        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("Remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
        public Criteria andItemstatusIsNull() {
            addCriterion("ItemStatus is null");
            return (Criteria) this;
        }
        public Criteria andItemstatusIsNotNull() {
            addCriterion("ItemStatus is not null");
            return (Criteria) this;
        }
        public Criteria andItemstatusEqualTo(Byte value) {
            addCriterion("ItemStatus =", value, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusNotEqualTo(Byte value) {
            addCriterion("ItemStatus <>", value, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusGreaterThan(Byte value) {
            addCriterion("ItemStatus >", value, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("ItemStatus >=", value, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusLessThan(Byte value) {
            addCriterion("ItemStatus <", value, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusLessThanOrEqualTo(Byte value) {
            addCriterion("ItemStatus <=", value, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusIn(List<Byte> values) {
            addCriterion("ItemStatus in", values, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusNotIn(List<Byte> values) {
            addCriterion("ItemStatus not in", values, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusBetween(Byte value1, Byte value2) {
            addCriterion("ItemStatus between", value1, value2, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andItemstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("ItemStatus not between", value1, value2, "itemstatus");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNull() {
            addCriterion("OrgID is null");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNotNull() {
            addCriterion("OrgID is not null");
            return (Criteria) this;
        }
        public Criteria andOrgidEqualTo(Integer value) {
            addCriterion("OrgID =", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotEqualTo(Integer value) {
            addCriterion("OrgID <>", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThan(Integer value) {
            addCriterion("OrgID >", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgID >=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThan(Integer value) {
            addCriterion("OrgID <", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThanOrEqualTo(Integer value) {
            addCriterion("OrgID <=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidIn(List<Integer> values) {
            addCriterion("OrgID in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotIn(List<Integer> values) {
            addCriterion("OrgID not in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidBetween(Integer value1, Integer value2) {
            addCriterion("OrgID between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgID not between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andUserangeIsNull() {
            addCriterion("UseRange is null");
            return (Criteria) this;
        }
        public Criteria andUserangeIsNotNull() {
            addCriterion("UseRange is not null");
            return (Criteria) this;
        }
        public Criteria andUserangeEqualTo(Byte value) {
            addCriterion("UseRange =", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeNotEqualTo(Byte value) {
            addCriterion("UseRange <>", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeGreaterThan(Byte value) {
            addCriterion("UseRange >", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeGreaterThanOrEqualTo(Byte value) {
            addCriterion("UseRange >=", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeLessThan(Byte value) {
            addCriterion("UseRange <", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeLessThanOrEqualTo(Byte value) {
            addCriterion("UseRange <=", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeIn(List<Byte> values) {
            addCriterion("UseRange in", values, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeNotIn(List<Byte> values) {
            addCriterion("UseRange not in", values, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeBetween(Byte value1, Byte value2) {
            addCriterion("UseRange between", value1, value2, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeNotBetween(Byte value1, Byte value2) {
            addCriterion("UseRange not between", value1, value2, "userange");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNull() {
            addCriterion("tb_label_item.CreateID is null");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNotNull() {
            addCriterion("tb_label_item.CreateID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateidEqualTo(Integer value) {
            addCriterion("tb_label_item.CreateID =", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotEqualTo(Integer value) {
            addCriterion("tb_label_item.CreateID <>", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThan(Integer value) {
            addCriterion("tb_label_item.CreateID >", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_label_item.CreateID >=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThan(Integer value) {
            addCriterion("tb_label_item.CreateID <", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThanOrEqualTo(Integer value) {
            addCriterion("tb_label_item.CreateID <=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidIn(List<Integer> values) {
            addCriterion("tb_label_item.CreateID in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotIn(List<Integer> values) {
            addCriterion("tb_label_item.CreateID not in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidBetween(Integer value1, Integer value2) {
            addCriterion("tb_label_item.CreateID between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_label_item.CreateID not between", value1, value2, "createid");
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
        public Criteria andUpdateidIsNull() {
            addCriterion("UpdateID is null");
            return (Criteria) this;
        }
        public Criteria andUpdateidIsNotNull() {
            addCriterion("UpdateID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateidEqualTo(Integer value) {
            addCriterion("UpdateID =", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotEqualTo(Integer value) {
            addCriterion("UpdateID <>", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidGreaterThan(Integer value) {
            addCriterion("UpdateID >", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateID >=", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidLessThan(Integer value) {
            addCriterion("UpdateID <", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateID <=", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidIn(List<Integer> values) {
            addCriterion("UpdateID in", values, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotIn(List<Integer> values) {
            addCriterion("UpdateID not in", values, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID between", value1, value2, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID not between", value1, value2, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
        
      //扩展方法
        public Criteria andselectLableClassByIdIn(List<Integer> values) {
            addCriterion("tb_label_item.LClassID in", values, "lclassid");
            return (Criteria) this;
        }
        public Criteria andselectLableClassByIdEqualTo(Integer values) {
            addCriterion("tb_label_item.LClassID =", values, "lclassid");
            return (Criteria) this;
        }

    }

   
    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [3.0]会员标签小项表
     * 
     * @author ${user}
     * @version 1.0 2016-11-29
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