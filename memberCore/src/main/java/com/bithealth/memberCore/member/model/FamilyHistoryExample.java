/*
 * FamilyHistoryExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-09 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FamilyHistoryExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public FamilyHistoryExample() {
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
     * [2.1]会员家族史表
     * 
     * @author ${user}
     * @version 1.0 2016-09-09
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
        public Criteria andLogIDIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogIDIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogIDEqualTo(Long value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Long value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Long value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Long value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Long value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Long value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Long> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Long> values) {
            addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Long value1, Long value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Long value1, Long value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andRelationIsNull() {
            addCriterion("Relation is null");
            return (Criteria) this;
        }
        public Criteria andRelationIsNotNull() {
            addCriterion("Relation is not null");
            return (Criteria) this;
        }
        public Criteria andRelationEqualTo(Byte value) {
            addCriterion("Relation =", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotEqualTo(Byte value) {
            addCriterion("Relation <>", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationGreaterThan(Byte value) {
            addCriterion("Relation >", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationGreaterThanOrEqualTo(Byte value) {
            addCriterion("Relation >=", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLessThan(Byte value) {
            addCriterion("Relation <", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLessThanOrEqualTo(Byte value) {
            addCriterion("Relation <=", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationIn(List<Byte> values) {
            addCriterion("Relation in", values, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotIn(List<Byte> values) {
            addCriterion("Relation not in", values, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationBetween(Byte value1, Byte value2) {
            addCriterion("Relation between", value1, value2, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotBetween(Byte value1, Byte value2) {
            addCriterion("Relation not between", value1, value2, "relation");
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
        public Criteria andDiseaseIDIsNull() {
            addCriterion("DiseaseID is null");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDIsNotNull() {
            addCriterion("DiseaseID is not null");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDEqualTo(Integer value) {
            addCriterion("DiseaseID =", value, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDNotEqualTo(Integer value) {
            addCriterion("DiseaseID <>", value, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDGreaterThan(Integer value) {
            addCriterion("DiseaseID >", value, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("DiseaseID >=", value, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDLessThan(Integer value) {
            addCriterion("DiseaseID <", value, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDLessThanOrEqualTo(Integer value) {
            addCriterion("DiseaseID <=", value, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDIn(List<Integer> values) {
            addCriterion("DiseaseID in", values, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDNotIn(List<Integer> values) {
            addCriterion("DiseaseID not in", values, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDBetween(Integer value1, Integer value2) {
            addCriterion("DiseaseID between", value1, value2, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseIDNotBetween(Integer value1, Integer value2) {
            addCriterion("DiseaseID not between", value1, value2, "diseaseID");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameIsNull() {
            addCriterion("DiseaseName is null");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameIsNotNull() {
            addCriterion("DiseaseName is not null");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameEqualTo(String value) {
            addCriterion("DiseaseName =", value, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameNotEqualTo(String value) {
            addCriterion("DiseaseName <>", value, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameGreaterThan(String value) {
            addCriterion("DiseaseName >", value, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("DiseaseName >=", value, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameLessThan(String value) {
            addCriterion("DiseaseName <", value, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameLessThanOrEqualTo(String value) {
            addCriterion("DiseaseName <=", value, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameLike(String value) {
            addCriterion("DiseaseName like", value, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameNotLike(String value) {
            addCriterion("DiseaseName not like", value, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameIn(List<String> values) {
            addCriterion("DiseaseName in", values, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameNotIn(List<String> values) {
            addCriterion("DiseaseName not in", values, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameBetween(String value1, String value2) {
            addCriterion("DiseaseName between", value1, value2, "diseaseName");
            return (Criteria) this;
        }
        public Criteria andDiseaseNameNotBetween(String value1, String value2) {
            addCriterion("DiseaseName not between", value1, value2, "diseaseName");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [2.1]会员家族史表
     * 
     * @author ${user}
     * @version 1.0 2016-09-09
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