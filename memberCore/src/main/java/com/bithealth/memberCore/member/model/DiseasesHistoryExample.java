/*
 * DiseasesHistoryExample.java
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

public class DiseasesHistoryExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public DiseasesHistoryExample() {
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
     * 疾病史(MEM3)
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
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }
        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
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
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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
        public Criteria andLinenumIsNull() {
            addCriterion("LineNum is null");
            return (Criteria) this;
        }
        public Criteria andLinenumIsNotNull() {
            addCriterion("LineNum is not null");
            return (Criteria) this;
        }
        public Criteria andLinenumEqualTo(Short value) {
            addCriterion("LineNum =", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumNotEqualTo(Short value) {
            addCriterion("LineNum <>", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumGreaterThan(Short value) {
            addCriterion("LineNum >", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumGreaterThanOrEqualTo(Short value) {
            addCriterion("LineNum >=", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumLessThan(Short value) {
            addCriterion("LineNum <", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumLessThanOrEqualTo(Short value) {
            addCriterion("LineNum <=", value, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumIn(List<Short> values) {
            addCriterion("LineNum in", values, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumNotIn(List<Short> values) {
            addCriterion("LineNum not in", values, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumBetween(Short value1, Short value2) {
            addCriterion("LineNum between", value1, value2, "linenum");
            return (Criteria) this;
        }
        public Criteria andLinenumNotBetween(Short value1, Short value2) {
            addCriterion("LineNum not between", value1, value2, "linenum");
            return (Criteria) this;
        }
        public Criteria andDiseaseidIsNull() {
            addCriterion("DiseaseID is null");
            return (Criteria) this;
        }
        public Criteria andDiseaseidIsNotNull() {
            addCriterion("DiseaseID is not null");
            return (Criteria) this;
        }
        public Criteria andDiseaseidEqualTo(Integer value) {
            addCriterion("DiseaseID =", value, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidNotEqualTo(Integer value) {
            addCriterion("DiseaseID <>", value, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidGreaterThan(Integer value) {
            addCriterion("DiseaseID >", value, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DiseaseID >=", value, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidLessThan(Integer value) {
            addCriterion("DiseaseID <", value, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidLessThanOrEqualTo(Integer value) {
            addCriterion("DiseaseID <=", value, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidIn(List<Integer> values) {
            addCriterion("DiseaseID in", values, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidNotIn(List<Integer> values) {
            addCriterion("DiseaseID not in", values, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidBetween(Integer value1, Integer value2) {
            addCriterion("DiseaseID between", value1, value2, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("DiseaseID not between", value1, value2, "diseaseid");
            return (Criteria) this;
        }
        public Criteria andDiseasenameIsNull() {
            addCriterion("DiseaseName is null");
            return (Criteria) this;
        }
        public Criteria andDiseasenameIsNotNull() {
            addCriterion("DiseaseName is not null");
            return (Criteria) this;
        }
        public Criteria andDiseasenameEqualTo(String value) {
            addCriterion("DiseaseName =", value, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameNotEqualTo(String value) {
            addCriterion("DiseaseName <>", value, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameGreaterThan(String value) {
            addCriterion("DiseaseName >", value, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameGreaterThanOrEqualTo(String value) {
            addCriterion("DiseaseName >=", value, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameLessThan(String value) {
            addCriterion("DiseaseName <", value, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameLessThanOrEqualTo(String value) {
            addCriterion("DiseaseName <=", value, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameLike(String value) {
            addCriterion("DiseaseName like", value, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameNotLike(String value) {
            addCriterion("DiseaseName not like", value, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameIn(List<String> values) {
            addCriterion("DiseaseName in", values, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameNotIn(List<String> values) {
            addCriterion("DiseaseName not in", values, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameBetween(String value1, String value2) {
            addCriterion("DiseaseName between", value1, value2, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiseasenameNotBetween(String value1, String value2) {
            addCriterion("DiseaseName not between", value1, value2, "diseasename");
            return (Criteria) this;
        }
        public Criteria andDiagtimeIsNull() {
            addCriterion("DiagTime is null");
            return (Criteria) this;
        }
        public Criteria andDiagtimeIsNotNull() {
            addCriterion("DiagTime is not null");
            return (Criteria) this;
        }
        public Criteria andDiagtimeEqualTo(Date value) {
            addCriterionForJDBCDate("DiagTime =", value, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("DiagTime <>", value, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("DiagTime >", value, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DiagTime >=", value, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeLessThan(Date value) {
            addCriterionForJDBCDate("DiagTime <", value, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DiagTime <=", value, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeIn(List<Date> values) {
            addCriterionForJDBCDate("DiagTime in", values, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("DiagTime not in", values, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DiagTime between", value1, value2, "diagtime");
            return (Criteria) this;
        }
        public Criteria andDiagtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DiagTime not between", value1, value2, "diagtime");
            return (Criteria) this;
        }
        public Criteria andProtagIsNull() {
            addCriterion("ProTag is null");
            return (Criteria) this;
        }
        public Criteria andProtagIsNotNull() {
            addCriterion("ProTag is not null");
            return (Criteria) this;
        }
        public Criteria andProtagEqualTo(String value) {
            addCriterion("ProTag =", value, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagNotEqualTo(String value) {
            addCriterion("ProTag <>", value, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagGreaterThan(String value) {
            addCriterion("ProTag >", value, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagGreaterThanOrEqualTo(String value) {
            addCriterion("ProTag >=", value, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagLessThan(String value) {
            addCriterion("ProTag <", value, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagLessThanOrEqualTo(String value) {
            addCriterion("ProTag <=", value, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagLike(String value) {
            addCriterion("ProTag like", value, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagNotLike(String value) {
            addCriterion("ProTag not like", value, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagIn(List<String> values) {
            addCriterion("ProTag in", values, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagNotIn(List<String> values) {
            addCriterion("ProTag not in", values, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagBetween(String value1, String value2) {
            addCriterion("ProTag between", value1, value2, "protag");
            return (Criteria) this;
        }
        public Criteria andProtagNotBetween(String value1, String value2) {
            addCriterion("ProTag not between", value1, value2, "protag");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 疾病史(MEM3)
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