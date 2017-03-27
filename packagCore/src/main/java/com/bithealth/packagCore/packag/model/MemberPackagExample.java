/*
 * MemberPackagExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-07 Created
 */
package com.bithealth.packagCore.packag.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberPackagExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemberPackagExample() {
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
     * 会员订购套餐表(OMMT)
     * 
     * @author ${user}
     * @version 1.0 2016-07-07
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
        public Criteria andLineNumIsNull() {
            addCriterion("LineNum is null");
            return (Criteria) this;
        }
        public Criteria andLineNumIsNotNull() {
            addCriterion("LineNum is not null");
            return (Criteria) this;
        }
        public Criteria andLineNumEqualTo(Short value) {
            addCriterion("LineNum =", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotEqualTo(Short value) {
            addCriterion("LineNum <>", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumGreaterThan(Short value) {
            addCriterion("LineNum >", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumGreaterThanOrEqualTo(Short value) {
            addCriterion("LineNum >=", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumLessThan(Short value) {
            addCriterion("LineNum <", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumLessThanOrEqualTo(Short value) {
            addCriterion("LineNum <=", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumIn(List<Short> values) {
            addCriterion("LineNum in", values, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotIn(List<Short> values) {
            addCriterion("LineNum not in", values, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumBetween(Short value1, Short value2) {
            addCriterion("LineNum between", value1, value2, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotBetween(Short value1, Short value2) {
            addCriterion("LineNum not between", value1, value2, "lineNum");
            return (Criteria) this;
        }
        public Criteria andPackageCodeIsNull() {
            addCriterion("PackageCode is null");
            return (Criteria) this;
        }
        public Criteria andPackageCodeIsNotNull() {
            addCriterion("PackageCode is not null");
            return (Criteria) this;
        }
        public Criteria andPackageCodeEqualTo(Integer value) {
            addCriterion("PackageCode =", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeNotEqualTo(Integer value) {
            addCriterion("PackageCode <>", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeGreaterThan(Integer value) {
            addCriterion("PackageCode >", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PackageCode >=", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeLessThan(Integer value) {
            addCriterion("PackageCode <", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeLessThanOrEqualTo(Integer value) {
            addCriterion("PackageCode <=", value, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeIn(List<Integer> values) {
            addCriterion("PackageCode in", values, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeNotIn(List<Integer> values) {
            addCriterion("PackageCode not in", values, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeBetween(Integer value1, Integer value2) {
            addCriterion("PackageCode between", value1, value2, "packageCode");
            return (Criteria) this;
        }
        public Criteria andPackageCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("PackageCode not between", value1, value2, "packageCode");
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
            addCriterion("CreateName like", value, "createName");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员订购套餐表(OMMT)
     * 
     * @author ${user}
     * @version 1.0 2016-07-07
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