/*
 * orolExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-24 Created
 */
package com.bithealth.doctorCore.doctor.model;

import java.util.ArrayList;
import java.util.List;

public class OrolExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OrolExample() {
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
     * 角色表(OROL)
     * 
     * @author ${user}
     * @version 1.0 2016-06-24
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
        public Criteria andRoleidIsNull() {
            addCriterion("RoleId is null");
            return (Criteria) this;
        }
        public Criteria andRoleidIsNotNull() {
            addCriterion("RoleId is not null");
            return (Criteria) this;
        }
        public Criteria andRoleidEqualTo(Short value) {
            addCriterion("RoleId =", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidNotEqualTo(Short value) {
            addCriterion("RoleId <>", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidGreaterThan(Short value) {
            addCriterion("RoleId >", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidGreaterThanOrEqualTo(Short value) {
            addCriterion("RoleId >=", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidLessThan(Short value) {
            addCriterion("RoleId <", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidLessThanOrEqualTo(Short value) {
            addCriterion("RoleId <=", value, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidIn(List<Short> values) {
            addCriterion("RoleId in", values, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidNotIn(List<Short> values) {
            addCriterion("RoleId not in", values, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidBetween(Short value1, Short value2) {
            addCriterion("RoleId between", value1, value2, "roleid");
            return (Criteria) this;
        }
        public Criteria andRoleidNotBetween(Short value1, Short value2) {
            addCriterion("RoleId not between", value1, value2, "roleid");
            return (Criteria) this;
        }
        public Criteria andRolenameIsNull() {
            addCriterion("RoleName is null");
            return (Criteria) this;
        }
        public Criteria andRolenameIsNotNull() {
            addCriterion("RoleName is not null");
            return (Criteria) this;
        }
        public Criteria andRolenameEqualTo(String value) {
            addCriterion("RoleName =", value, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameNotEqualTo(String value) {
            addCriterion("RoleName <>", value, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameGreaterThan(String value) {
            addCriterion("RoleName >", value, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameGreaterThanOrEqualTo(String value) {
            addCriterion("RoleName >=", value, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameLessThan(String value) {
            addCriterion("RoleName <", value, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameLessThanOrEqualTo(String value) {
            addCriterion("RoleName <=", value, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameLike(String value) {
            addCriterion("RoleName like", value, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameNotLike(String value) {
            addCriterion("RoleName not like", value, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameIn(List<String> values) {
            addCriterion("RoleName in", values, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameNotIn(List<String> values) {
            addCriterion("RoleName not in", values, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameBetween(String value1, String value2) {
            addCriterion("RoleName between", value1, value2, "rolename");
            return (Criteria) this;
        }
        public Criteria andRolenameNotBetween(String value1, String value2) {
            addCriterion("RoleName not between", value1, value2, "rolename");
            return (Criteria) this;
        }
        public Criteria andRoledesIsNull() {
            addCriterion("RoleDes is null");
            return (Criteria) this;
        }
        public Criteria andRoledesIsNotNull() {
            addCriterion("RoleDes is not null");
            return (Criteria) this;
        }
        public Criteria andRoledesEqualTo(String value) {
            addCriterion("RoleDes =", value, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesNotEqualTo(String value) {
            addCriterion("RoleDes <>", value, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesGreaterThan(String value) {
            addCriterion("RoleDes >", value, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesGreaterThanOrEqualTo(String value) {
            addCriterion("RoleDes >=", value, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesLessThan(String value) {
            addCriterion("RoleDes <", value, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesLessThanOrEqualTo(String value) {
            addCriterion("RoleDes <=", value, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesLike(String value) {
            addCriterion("RoleDes like", value, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesNotLike(String value) {
            addCriterion("RoleDes not like", value, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesIn(List<String> values) {
            addCriterion("RoleDes in", values, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesNotIn(List<String> values) {
            addCriterion("RoleDes not in", values, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesBetween(String value1, String value2) {
            addCriterion("RoleDes between", value1, value2, "roledes");
            return (Criteria) this;
        }
        public Criteria andRoledesNotBetween(String value1, String value2) {
            addCriterion("RoleDes not between", value1, value2, "roledes");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 角色表(OROL)
     * 
     * @author ${user}
     * @version 1.0 2016-06-24
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