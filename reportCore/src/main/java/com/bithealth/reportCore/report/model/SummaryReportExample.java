/*
 * SummaryReportExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SummaryReportExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SummaryReportExample() {
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
     * 汇总测量报告（OSMR）
     * 
     * @author ${user}
     * @version 1.0 2016-07-20
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
        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }
        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }
        public Criteria andIDEqualTo(Integer value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDLessThan(Integer value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDIn(List<Integer> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }
        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }
        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }
        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNull() {
            addCriterion("OrgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNotNull() {
            addCriterion("OrgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("OrgId =", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("OrgId <>", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("OrgId >", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgId >=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("OrgId <", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("OrgId <=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("OrgId in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("OrgId not in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("OrgId between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgId not between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeIsNull() {
            addCriterion("SumRepCode is null");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeIsNotNull() {
            addCriterion("SumRepCode is not null");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeEqualTo(String value) {
            addCriterion("SumRepCode =", value, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeNotEqualTo(String value) {
            addCriterion("SumRepCode <>", value, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeGreaterThan(String value) {
            addCriterion("SumRepCode >", value, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SumRepCode >=", value, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeLessThan(String value) {
            addCriterion("SumRepCode <", value, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeLessThanOrEqualTo(String value) {
            addCriterion("SumRepCode <=", value, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeLike(String value) {
            addCriterion("SumRepCode like", value, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeNotLike(String value) {
            addCriterion("SumRepCode not like", value, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeIn(List<String> values) {
            addCriterion("SumRepCode in", values, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeNotIn(List<String> values) {
            addCriterion("SumRepCode not in", values, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeBetween(String value1, String value2) {
            addCriterion("SumRepCode between", value1, value2, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepCodeNotBetween(String value1, String value2) {
            addCriterion("SumRepCode not between", value1, value2, "sumRepCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeIsNull() {
            addCriterion("SumRepTempCode is null");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeIsNotNull() {
            addCriterion("SumRepTempCode is not null");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeEqualTo(Integer value) {
            addCriterion("SumRepTempCode =", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotEqualTo(Integer value) {
            addCriterion("SumRepTempCode <>", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeGreaterThan(Integer value) {
            addCriterion("SumRepTempCode >", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SumRepTempCode >=", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeLessThan(Integer value) {
            addCriterion("SumRepTempCode <", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeLessThanOrEqualTo(Integer value) {
            addCriterion("SumRepTempCode <=", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeIn(List<Integer> values) {
            addCriterion("SumRepTempCode in", values, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotIn(List<Integer> values) {
            addCriterion("SumRepTempCode not in", values, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeBetween(Integer value1, Integer value2) {
            addCriterion("SumRepTempCode between", value1, value2, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("SumRepTempCode not between", value1, value2, "sumRepTempCode");
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
        public Criteria andGrenerTimeIsNull() {
            addCriterion("GrenerTime is null");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeIsNotNull() {
            addCriterion("GrenerTime is not null");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeEqualTo(Date value) {
            addCriterion("GrenerTime =", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotEqualTo(Date value) {
            addCriterion("GrenerTime <>", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeGreaterThan(Date value) {
            addCriterion("GrenerTime >", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("GrenerTime >=", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeLessThan(Date value) {
            addCriterion("GrenerTime <", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeLessThanOrEqualTo(Date value) {
            addCriterion("GrenerTime <=", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeIn(List<Date> values) {
            addCriterion("GrenerTime in", values, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotIn(List<Date> values) {
            addCriterion("GrenerTime not in", values, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeBetween(Date value1, Date value2) {
            addCriterion("GrenerTime between", value1, value2, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotBetween(Date value1, Date value2) {
            addCriterion("GrenerTime not between", value1, value2, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andReportStateIsNull() {
            addCriterion("ReportState is null");
            return (Criteria) this;
        }
        public Criteria andReportStateIsNotNull() {
            addCriterion("ReportState is not null");
            return (Criteria) this;
        }
        public Criteria andReportStateEqualTo(String value) {
            addCriterion("ReportState =", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateNotEqualTo(String value) {
            addCriterion("ReportState <>", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateGreaterThan(String value) {
            addCriterion("ReportState >", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateGreaterThanOrEqualTo(String value) {
            addCriterion("ReportState >=", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateLessThan(String value) {
            addCriterion("ReportState <", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateLessThanOrEqualTo(String value) {
            addCriterion("ReportState <=", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateLike(String value) {
            addCriterion("ReportState like", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateNotLike(String value) {
            addCriterion("ReportState not like", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateIn(List<String> values) {
            addCriterion("ReportState in", values, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateNotIn(List<String> values) {
            addCriterion("ReportState not in", values, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateBetween(String value1, String value2) {
            addCriterion("ReportState between", value1, value2, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateNotBetween(String value1, String value2) {
            addCriterion("ReportState not between", value1, value2, "reportState");
            return (Criteria) this;
        }
        public Criteria andPendingLevelIsNull() {
            addCriterion("PendingLevel is null");
            return (Criteria) this;
        }
        public Criteria andPendingLevelIsNotNull() {
            addCriterion("PendingLevel is not null");
            return (Criteria) this;
        }
        public Criteria andPendingLevelEqualTo(Short value) {
            addCriterion("PendingLevel =", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelNotEqualTo(Short value) {
            addCriterion("PendingLevel <>", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelGreaterThan(Short value) {
            addCriterion("PendingLevel >", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("PendingLevel >=", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelLessThan(Short value) {
            addCriterion("PendingLevel <", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelLessThanOrEqualTo(Short value) {
            addCriterion("PendingLevel <=", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelIn(List<Short> values) {
            addCriterion("PendingLevel in", values, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelNotIn(List<Short> values) {
            addCriterion("PendingLevel not in", values, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelBetween(Short value1, Short value2) {
            addCriterion("PendingLevel between", value1, value2, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelNotBetween(Short value1, Short value2) {
            addCriterion("PendingLevel not between", value1, value2, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagIsNull() {
            addCriterion("RetrialBackTag is null");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagIsNotNull() {
            addCriterion("RetrialBackTag is not null");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagEqualTo(String value) {
            addCriterion("RetrialBackTag =", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagNotEqualTo(String value) {
            addCriterion("RetrialBackTag <>", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagGreaterThan(String value) {
            addCriterion("RetrialBackTag >", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagGreaterThanOrEqualTo(String value) {
            addCriterion("RetrialBackTag >=", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagLessThan(String value) {
            addCriterion("RetrialBackTag <", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagLessThanOrEqualTo(String value) {
            addCriterion("RetrialBackTag <=", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagLike(String value) {
            addCriterion("RetrialBackTag like", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagNotLike(String value) {
            addCriterion("RetrialBackTag not like", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagIn(List<String> values) {
            addCriterion("RetrialBackTag in", values, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagNotIn(List<String> values) {
            addCriterion("RetrialBackTag not in", values, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagBetween(String value1, String value2) {
            addCriterion("RetrialBackTag between", value1, value2, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagNotBetween(String value1, String value2) {
            addCriterion("RetrialBackTag not between", value1, value2, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonIsNull() {
            addCriterion("ApprovalReason is null");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonIsNotNull() {
            addCriterion("ApprovalReason is not null");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonEqualTo(String value) {
            addCriterion("ApprovalReason =", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonNotEqualTo(String value) {
            addCriterion("ApprovalReason <>", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonGreaterThan(String value) {
            addCriterion("ApprovalReason >", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonGreaterThanOrEqualTo(String value) {
            addCriterion("ApprovalReason >=", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonLessThan(String value) {
            addCriterion("ApprovalReason <", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonLessThanOrEqualTo(String value) {
            addCriterion("ApprovalReason <=", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonLike(String value) {
            addCriterion("ApprovalReason like", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonNotLike(String value) {
            addCriterion("ApprovalReason not like", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonIn(List<String> values) {
            addCriterion("ApprovalReason in", values, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonNotIn(List<String> values) {
            addCriterion("ApprovalReason not in", values, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonBetween(String value1, String value2) {
            addCriterion("ApprovalReason between", value1, value2, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonNotBetween(String value1, String value2) {
            addCriterion("ApprovalReason not between", value1, value2, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andChkDescIsNull() {
            addCriterion("ChkDesc is null");
            return (Criteria) this;
        }
        public Criteria andChkDescIsNotNull() {
            addCriterion("ChkDesc is not null");
            return (Criteria) this;
        }
        public Criteria andChkDescEqualTo(String value) {
            addCriterion("ChkDesc =", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescNotEqualTo(String value) {
            addCriterion("ChkDesc <>", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescGreaterThan(String value) {
            addCriterion("ChkDesc >", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescGreaterThanOrEqualTo(String value) {
            addCriterion("ChkDesc >=", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescLessThan(String value) {
            addCriterion("ChkDesc <", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescLessThanOrEqualTo(String value) {
            addCriterion("ChkDesc <=", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescLike(String value) {
            addCriterion("ChkDesc like", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescNotLike(String value) {
            addCriterion("ChkDesc not like", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescIn(List<String> values) {
            addCriterion("ChkDesc in", values, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescNotIn(List<String> values) {
            addCriterion("ChkDesc not in", values, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescBetween(String value1, String value2) {
            addCriterion("ChkDesc between", value1, value2, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescNotBetween(String value1, String value2) {
            addCriterion("ChkDesc not between", value1, value2, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andReadStatusIsNull() {
            addCriterion("readStatus is null");
            return (Criteria) this;
        }
        public Criteria andReadStatusIsNotNull() {
            addCriterion("readStatus is not null");
            return (Criteria) this;
        }
        public Criteria andReadStatusEqualTo(Integer value) {
            addCriterion("readStatus =", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusNotEqualTo(Integer value) {
            addCriterion("readStatus <>", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusGreaterThan(Integer value) {
            addCriterion("readStatus >", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("readStatus >=", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusLessThan(Integer value) {
            addCriterion("readStatus <", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("readStatus <=", value, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusIn(List<Integer> values) {
            addCriterion("readStatus in", values, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusNotIn(List<Integer> values) {
            addCriterion("readStatus not in", values, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusBetween(Integer value1, Integer value2) {
            addCriterion("readStatus between", value1, value2, "readStatus");
            return (Criteria) this;
        }
        public Criteria andReadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("readStatus not between", value1, value2, "readStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 汇总测量报告（OSMR）
     * 
     * @author ${user}
     * @version 1.0 2016-07-20
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