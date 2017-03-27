/*
 * MemFamilyCardExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-11 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemFamilyCardExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemFamilyCardExample() {
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
     * 会员及家庭成员卡号表
     * 
     * @author ${user}
     * @version 1.0 2016-08-11
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
        public Criteria andLogIDEqualTo(Integer value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Integer value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Integer value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Integer value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Integer value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Integer> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Integer> values) {
            addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Integer value1, Integer value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Integer value1, Integer value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
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
        public Criteria andFamilyMemberidIsNull() {
            addCriterion("FamilyMemberid is null");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidIsNotNull() {
            addCriterion("FamilyMemberid is not null");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidEqualTo(Integer value) {
            addCriterion("FamilyMemberid =", value, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidNotEqualTo(Integer value) {
            addCriterion("FamilyMemberid <>", value, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidGreaterThan(Integer value) {
            addCriterion("FamilyMemberid >", value, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FamilyMemberid >=", value, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidLessThan(Integer value) {
            addCriterion("FamilyMemberid <", value, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("FamilyMemberid <=", value, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidIn(List<Integer> values) {
            addCriterion("FamilyMemberid in", values, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidNotIn(List<Integer> values) {
            addCriterion("FamilyMemberid not in", values, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidBetween(Integer value1, Integer value2) {
            addCriterion("FamilyMemberid between", value1, value2, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andFamilyMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("FamilyMemberid not between", value1, value2, "familyMemberid");
            return (Criteria) this;
        }
        public Criteria andRoleIsNull() {
            addCriterion("Role is null");
            return (Criteria) this;
        }
        public Criteria andRoleIsNotNull() {
            addCriterion("Role is not null");
            return (Criteria) this;
        }
        public Criteria andRoleEqualTo(Byte value) {
            addCriterion("Role =", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleNotEqualTo(Byte value) {
            addCriterion("Role <>", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleGreaterThan(Byte value) {
            addCriterion("Role >", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleGreaterThanOrEqualTo(Byte value) {
            addCriterion("Role >=", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleLessThan(Byte value) {
            addCriterion("Role <", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleLessThanOrEqualTo(Byte value) {
            addCriterion("Role <=", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleIn(List<Byte> values) {
            addCriterion("Role in", values, "role");
            return (Criteria) this;
        }
        public Criteria andRoleNotIn(List<Byte> values) {
            addCriterion("Role not in", values, "role");
            return (Criteria) this;
        }
        public Criteria andRoleBetween(Byte value1, Byte value2) {
            addCriterion("Role between", value1, value2, "role");
            return (Criteria) this;
        }
        public Criteria andRoleNotBetween(Byte value1, Byte value2) {
            addCriterion("Role not between", value1, value2, "role");
            return (Criteria) this;
        }
        public Criteria andCardNoIsNull() {
            addCriterion("CardNo is null");
            return (Criteria) this;
        }
        public Criteria andCardNoIsNotNull() {
            addCriterion("CardNo is not null");
            return (Criteria) this;
        }
        public Criteria andCardNoEqualTo(String value) {
            addCriterion("CardNo =", value, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("CardNo <>", value, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("CardNo >", value, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("CardNo >=", value, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoLessThan(String value) {
            addCriterion("CardNo <", value, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("CardNo <=", value, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoLike(String value) {
            addCriterion("CardNo like", value, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoNotLike(String value) {
            addCriterion("CardNo not like", value, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoIn(List<String> values) {
            addCriterion("CardNo in", values, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("CardNo not in", values, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("CardNo between", value1, value2, "cardNo");
            return (Criteria) this;
        }
        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("CardNo not between", value1, value2, "cardNo");
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
        public Criteria andRoleNameIsNull() {
            addCriterion("RoleName is null");
            return (Criteria) this;
        }
        public Criteria andRoleNameIsNotNull() {
            addCriterion("RoleName is not null");
            return (Criteria) this;
        }
        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("RoleName =", value, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("RoleName <>", value, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("RoleName >", value, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("RoleName >=", value, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameLessThan(String value) {
            addCriterion("RoleName <", value, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("RoleName <=", value, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameLike(String value) {
            addCriterion("RoleName like", value, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameNotLike(String value) {
            addCriterion("RoleName not like", value, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("RoleName in", values, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("RoleName not in", values, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("RoleName between", value1, value2, "roleName");
            return (Criteria) this;
        }
        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("RoleName not between", value1, value2, "roleName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员及家庭成员卡号表
     * 
     * @author ${user}
     * @version 1.0 2016-08-11
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