/*
 * ManageDiseaseExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.diseaseManage.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManageDiseaseExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ManageDiseaseExample() {
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
     * [3.0]管理方案_疾病
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
        public Criteria andMsdiseaseidIsNull() {
            addCriterion("MSDiseaseID is null");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidIsNotNull() {
            addCriterion("MSDiseaseID is not null");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidEqualTo(Integer value) {
            addCriterion("MSDiseaseID =", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidNotEqualTo(Integer value) {
            addCriterion("MSDiseaseID <>", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidGreaterThan(Integer value) {
            addCriterion("MSDiseaseID >", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSDiseaseID >=", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidLessThan(Integer value) {
            addCriterion("MSDiseaseID <", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidLessThanOrEqualTo(Integer value) {
            addCriterion("MSDiseaseID <=", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidIn(List<Integer> values) {
            addCriterion("MSDiseaseID in", values, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidNotIn(List<Integer> values) {
            addCriterion("MSDiseaseID not in", values, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidBetween(Integer value1, Integer value2) {
            addCriterion("MSDiseaseID between", value1, value2, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("MSDiseaseID not between", value1, value2, "msdiseaseid");
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
        public Criteria andParentidIsNull() {
            addCriterion("ParentID is null");
            return (Criteria) this;
        }
        public Criteria andParentidIsNotNull() {
            addCriterion("ParentID is not null");
            return (Criteria) this;
        }
        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("ParentID =", value, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("ParentID <>", value, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("ParentID >", value, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ParentID >=", value, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidLessThan(Integer value) {
            addCriterion("ParentID <", value, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("ParentID <=", value, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("ParentID in", values, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("ParentID not in", values, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("ParentID between", value1, value2, "parentid");
            return (Criteria) this;
        }
        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("ParentID not between", value1, value2, "parentid");
            return (Criteria) this;
        }
        public Criteria andSortnoIsNull() {
            addCriterion("SortNo is null");
            return (Criteria) this;
        }
        public Criteria andSortnoIsNotNull() {
            addCriterion("SortNo is not null");
            return (Criteria) this;
        }
        public Criteria andSortnoEqualTo(Integer value) {
            addCriterion("SortNo =", value, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoNotEqualTo(Integer value) {
            addCriterion("SortNo <>", value, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoGreaterThan(Integer value) {
            addCriterion("SortNo >", value, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SortNo >=", value, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoLessThan(Integer value) {
            addCriterion("SortNo <", value, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoLessThanOrEqualTo(Integer value) {
            addCriterion("SortNo <=", value, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoIn(List<Integer> values) {
            addCriterion("SortNo in", values, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoNotIn(List<Integer> values) {
            addCriterion("SortNo not in", values, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoBetween(Integer value1, Integer value2) {
            addCriterion("SortNo between", value1, value2, "sortno");
            return (Criteria) this;
        }
        public Criteria andSortnoNotBetween(Integer value1, Integer value2) {
            addCriterion("SortNo not between", value1, value2, "sortno");
            return (Criteria) this;
        }
        public Criteria andDescriptionIsNull() {
            addCriterion("Description is null");
            return (Criteria) this;
        }
        public Criteria andDescriptionIsNotNull() {
            addCriterion("Description is not null");
            return (Criteria) this;
        }
        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("Description =", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("Description <>", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("Description >", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Description >=", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionLessThan(String value) {
            addCriterion("Description <", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("Description <=", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionLike(String value) {
            addCriterion("Description like", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionNotLike(String value) {
            addCriterion("Description not like", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("Description in", values, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("Description not in", values, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("Description between", value1, value2, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("Description not between", value1, value2, "description");
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
        public Criteria andCreateidIsNull() {
            addCriterion("CreateID is null");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNotNull() {
            addCriterion("CreateID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateidEqualTo(Integer value) {
            addCriterion("CreateID =", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotEqualTo(Integer value) {
            addCriterion("CreateID <>", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThan(Integer value) {
            addCriterion("CreateID >", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateID >=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThan(Integer value) {
            addCriterion("CreateID <", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThanOrEqualTo(Integer value) {
            addCriterion("CreateID <=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidIn(List<Integer> values) {
            addCriterion("CreateID in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotIn(List<Integer> values) {
            addCriterion("CreateID not in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidBetween(Integer value1, Integer value2) {
            addCriterion("CreateID between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateID not between", value1, value2, "createid");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [3.0]管理方案_疾病
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