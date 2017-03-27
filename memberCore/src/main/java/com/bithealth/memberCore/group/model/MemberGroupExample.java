/*
 * MemberGroupExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.group.model;

import java.util.ArrayList;
import java.util.List;

public class MemberGroupExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemberGroupExample() {
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
     * 会员分组设置（OMGS)
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
        public Criteria andMemgrpidIsNull() {
            addCriterion("MemGrpid is null");
            return (Criteria) this;
        }
        public Criteria andMemgrpidIsNotNull() {
            addCriterion("MemGrpid is not null");
            return (Criteria) this;
        }
        public Criteria andMemgrpidEqualTo(Integer value) {
            addCriterion("MemGrpid =", value, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidNotEqualTo(Integer value) {
            addCriterion("MemGrpid <>", value, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidGreaterThan(Integer value) {
            addCriterion("MemGrpid >", value, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MemGrpid >=", value, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidLessThan(Integer value) {
            addCriterion("MemGrpid <", value, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidLessThanOrEqualTo(Integer value) {
            addCriterion("MemGrpid <=", value, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidIn(List<Integer> values) {
            addCriterion("MemGrpid in", values, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidNotIn(List<Integer> values) {
            addCriterion("MemGrpid not in", values, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidBetween(Integer value1, Integer value2) {
            addCriterion("MemGrpid between", value1, value2, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpidNotBetween(Integer value1, Integer value2) {
            addCriterion("MemGrpid not between", value1, value2, "memgrpid");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameIsNull() {
            addCriterion("MemGrpName is null");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameIsNotNull() {
            addCriterion("MemGrpName is not null");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameEqualTo(String value) {
            addCriterion("MemGrpName =", value, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameNotEqualTo(String value) {
            addCriterion("MemGrpName <>", value, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameGreaterThan(String value) {
            addCriterion("MemGrpName >", value, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameGreaterThanOrEqualTo(String value) {
            addCriterion("MemGrpName >=", value, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameLessThan(String value) {
            addCriterion("MemGrpName <", value, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameLessThanOrEqualTo(String value) {
            addCriterion("MemGrpName <=", value, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameLike(String value) {
            addCriterion("MemGrpName like", value, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameNotLike(String value) {
            addCriterion("MemGrpName not like", value, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameIn(List<String> values) {
            addCriterion("MemGrpName in", values, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameNotIn(List<String> values) {
            addCriterion("MemGrpName not in", values, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameBetween(String value1, String value2) {
            addCriterion("MemGrpName between", value1, value2, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpnameNotBetween(String value1, String value2) {
            addCriterion("MemGrpName not between", value1, value2, "memgrpname");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescIsNull() {
            addCriterion("MemGrpDesc is null");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescIsNotNull() {
            addCriterion("MemGrpDesc is not null");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescEqualTo(String value) {
            addCriterion("MemGrpDesc =", value, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescNotEqualTo(String value) {
            addCriterion("MemGrpDesc <>", value, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescGreaterThan(String value) {
            addCriterion("MemGrpDesc >", value, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescGreaterThanOrEqualTo(String value) {
            addCriterion("MemGrpDesc >=", value, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescLessThan(String value) {
            addCriterion("MemGrpDesc <", value, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescLessThanOrEqualTo(String value) {
            addCriterion("MemGrpDesc <=", value, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescLike(String value) {
            addCriterion("MemGrpDesc like", value, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescNotLike(String value) {
            addCriterion("MemGrpDesc not like", value, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescIn(List<String> values) {
            addCriterion("MemGrpDesc in", values, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescNotIn(List<String> values) {
            addCriterion("MemGrpDesc not in", values, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescBetween(String value1, String value2) {
            addCriterion("MemGrpDesc between", value1, value2, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andMemgrpdescNotBetween(String value1, String value2) {
            addCriterion("MemGrpDesc not between", value1, value2, "memgrpdesc");
            return (Criteria) this;
        }
        public Criteria andFamemidIsNull() {
            addCriterion("faMemid is null");
            return (Criteria) this;
        }
        public Criteria andFamemidIsNotNull() {
            addCriterion("faMemid is not null");
            return (Criteria) this;
        }
        public Criteria andFamemidEqualTo(Integer value) {
            addCriterion("faMemid =", value, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidNotEqualTo(Integer value) {
            addCriterion("faMemid <>", value, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidGreaterThan(Integer value) {
            addCriterion("faMemid >", value, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("faMemid >=", value, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidLessThan(Integer value) {
            addCriterion("faMemid <", value, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidLessThanOrEqualTo(Integer value) {
            addCriterion("faMemid <=", value, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidIn(List<Integer> values) {
            addCriterion("faMemid in", values, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidNotIn(List<Integer> values) {
            addCriterion("faMemid not in", values, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidBetween(Integer value1, Integer value2) {
            addCriterion("faMemid between", value1, value2, "famemid");
            return (Criteria) this;
        }
        public Criteria andFamemidNotBetween(Integer value1, Integer value2) {
            addCriterion("faMemid not between", value1, value2, "famemid");
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
            addCriterion("order is null");
            return (Criteria) this;
        }
        public Criteria andOrderIsNotNull() {
            addCriterion("order is not null");
            return (Criteria) this;
        }
        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("order =", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("order <>", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("order >", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("order >=", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderLessThan(Integer value) {
            addCriterion("order <", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("order <=", value, "order");
            return (Criteria) this;
        }
        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("order in", values, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("order not in", values, "order");
            return (Criteria) this;
        }
        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("order between", value1, value2, "order");
            return (Criteria) this;
        }
        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("order not between", value1, value2, "order");
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
        
        public Criteria andDocidEqualsTo(Integer docId) {
        	if(docId != null && docId != 0) {
            	addCriterion("EXISTS (SELECT 1 FROM (SELECT DISTINCT t.`MemGrpid` memberGrpId FROM odmt t INNER JOIN dgp1 d ON  d.`OdgpId`=t.`OdgpId` AND d.`Docid`=" + docId + ") t WHERE t.memberGrpId = `MemGrpid`)");
        	}
        	return (Criteria)this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员分组设置（OMGS)
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