package com.easygo.sample.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepotHeadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepotHeadExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNull() {
            addCriterion("sub_type is null");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNotNull() {
            addCriterion("sub_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubTypeEqualTo(String value) {
            addCriterion("sub_type =", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotEqualTo(String value) {
            addCriterion("sub_type <>", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThan(String value) {
            addCriterion("sub_type >", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_type >=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThan(String value) {
            addCriterion("sub_type <", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThanOrEqualTo(String value) {
            addCriterion("sub_type <=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLike(String value) {
            addCriterion("sub_type like", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotLike(String value) {
            addCriterion("sub_type not like", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeIn(List<String> values) {
            addCriterion("sub_type in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotIn(List<String> values) {
            addCriterion("sub_type not in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeBetween(String value1, String value2) {
            addCriterion("sub_type between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotBetween(String value1, String value2) {
            addCriterion("sub_type not between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberIsNull() {
            addCriterion("default_number is null");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberIsNotNull() {
            addCriterion("default_number is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberEqualTo(String value) {
            addCriterion("default_number =", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberNotEqualTo(String value) {
            addCriterion("default_number <>", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberGreaterThan(String value) {
            addCriterion("default_number >", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberGreaterThanOrEqualTo(String value) {
            addCriterion("default_number >=", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberLessThan(String value) {
            addCriterion("default_number <", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberLessThanOrEqualTo(String value) {
            addCriterion("default_number <=", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberLike(String value) {
            addCriterion("default_number like", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberNotLike(String value) {
            addCriterion("default_number not like", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberIn(List<String> values) {
            addCriterion("default_number in", values, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberNotIn(List<String> values) {
            addCriterion("default_number not in", values, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberBetween(String value1, String value2) {
            addCriterion("default_number between", value1, value2, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberNotBetween(String value1, String value2) {
            addCriterion("default_number not between", value1, value2, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andOrganIdIsNull() {
            addCriterion("organ_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganIdIsNotNull() {
            addCriterion("organ_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganIdEqualTo(Long value) {
            addCriterion("organ_id =", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotEqualTo(Long value) {
            addCriterion("organ_id <>", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdGreaterThan(Long value) {
            addCriterion("organ_id >", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdGreaterThanOrEqualTo(Long value) {
            addCriterion("organ_id >=", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLessThan(Long value) {
            addCriterion("organ_id <", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLessThanOrEqualTo(Long value) {
            addCriterion("organ_id <=", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdIn(List<Long> values) {
            addCriterion("organ_id in", values, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotIn(List<Long> values) {
            addCriterion("organ_id not in", values, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdBetween(Long value1, Long value2) {
            addCriterion("organ_id between", value1, value2, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotBetween(Long value1, Long value2) {
            addCriterion("organ_id not between", value1, value2, "organId");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNull() {
            addCriterion("oper_time is null");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNotNull() {
            addCriterion("oper_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperTimeEqualTo(Date value) {
            addCriterion("oper_time =", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotEqualTo(Date value) {
            addCriterion("oper_time <>", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThan(Date value) {
            addCriterion("oper_time >", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oper_time >=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThan(Date value) {
            addCriterion("oper_time <", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThanOrEqualTo(Date value) {
            addCriterion("oper_time <=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeIn(List<Date> values) {
            addCriterion("oper_time in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotIn(List<Date> values) {
            addCriterion("oper_time not in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeBetween(Date value1, Date value2) {
            addCriterion("oper_time between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotBetween(Date value1, Date value2) {
            addCriterion("oper_time not between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIsNull() {
            addCriterion("change_amount is null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIsNotNull() {
            addCriterion("change_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountEqualTo(BigDecimal value) {
            addCriterion("change_amount =", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotEqualTo(BigDecimal value) {
            addCriterion("change_amount <>", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThan(BigDecimal value) {
            addCriterion("change_amount >", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("change_amount >=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThan(BigDecimal value) {
            addCriterion("change_amount <", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("change_amount <=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIn(List<BigDecimal> values) {
            addCriterion("change_amount in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotIn(List<BigDecimal> values) {
            addCriterion("change_amount not in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change_amount between", value1, value2, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change_amount not between", value1, value2, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNull() {
            addCriterion("bill_type is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("bill_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(String value) {
            addCriterion("bill_type =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(String value) {
            addCriterion("bill_type <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(String value) {
            addCriterion("bill_type >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_type >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(String value) {
            addCriterion("bill_type <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(String value) {
            addCriterion("bill_type <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLike(String value) {
            addCriterion("bill_type like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotLike(String value) {
            addCriterion("bill_type not like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<String> values) {
            addCriterion("bill_type in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<String> values) {
            addCriterion("bill_type not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(String value1, String value2) {
            addCriterion("bill_type between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(String value1, String value2) {
            addCriterion("bill_type not between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andSalesManIsNull() {
            addCriterion("sales_man is null");
            return (Criteria) this;
        }

        public Criteria andSalesManIsNotNull() {
            addCriterion("sales_man is not null");
            return (Criteria) this;
        }

        public Criteria andSalesManEqualTo(String value) {
            addCriterion("sales_man =", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManNotEqualTo(String value) {
            addCriterion("sales_man <>", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManGreaterThan(String value) {
            addCriterion("sales_man >", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManGreaterThanOrEqualTo(String value) {
            addCriterion("sales_man >=", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManLessThan(String value) {
            addCriterion("sales_man <", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManLessThanOrEqualTo(String value) {
            addCriterion("sales_man <=", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManLike(String value) {
            addCriterion("sales_man like", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManNotLike(String value) {
            addCriterion("sales_man not like", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManIn(List<String> values) {
            addCriterion("sales_man in", values, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManNotIn(List<String> values) {
            addCriterion("sales_man not in", values, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManBetween(String value1, String value2) {
            addCriterion("sales_man between", value1, value2, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManNotBetween(String value1, String value2) {
            addCriterion("sales_man not between", value1, value2, "salesMan");
            return (Criteria) this;
        }

        public Criteria andAccountIdListIsNull() {
            addCriterion("account_id_list is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdListIsNotNull() {
            addCriterion("account_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdListEqualTo(String value) {
            addCriterion("account_id_list =", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListNotEqualTo(String value) {
            addCriterion("account_id_list <>", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListGreaterThan(String value) {
            addCriterion("account_id_list >", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListGreaterThanOrEqualTo(String value) {
            addCriterion("account_id_list >=", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListLessThan(String value) {
            addCriterion("account_id_list <", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListLessThanOrEqualTo(String value) {
            addCriterion("account_id_list <=", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListLike(String value) {
            addCriterion("account_id_list like", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListNotLike(String value) {
            addCriterion("account_id_list not like", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListIn(List<String> values) {
            addCriterion("account_id_list in", values, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListNotIn(List<String> values) {
            addCriterion("account_id_list not in", values, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListBetween(String value1, String value2) {
            addCriterion("account_id_list between", value1, value2, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListNotBetween(String value1, String value2) {
            addCriterion("account_id_list not between", value1, value2, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListIsNull() {
            addCriterion("account_money_list is null");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListIsNotNull() {
            addCriterion("account_money_list is not null");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListEqualTo(String value) {
            addCriterion("account_money_list =", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListNotEqualTo(String value) {
            addCriterion("account_money_list <>", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListGreaterThan(String value) {
            addCriterion("account_money_list >", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListGreaterThanOrEqualTo(String value) {
            addCriterion("account_money_list >=", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListLessThan(String value) {
            addCriterion("account_money_list <", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListLessThanOrEqualTo(String value) {
            addCriterion("account_money_list <=", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListLike(String value) {
            addCriterion("account_money_list like", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListNotLike(String value) {
            addCriterion("account_money_list not like", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListIn(List<String> values) {
            addCriterion("account_money_list in", values, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListNotIn(List<String> values) {
            addCriterion("account_money_list not in", values, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListBetween(String value1, String value2) {
            addCriterion("account_money_list between", value1, value2, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListNotBetween(String value1, String value2) {
            addCriterion("account_money_list not between", value1, value2, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(BigDecimal value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(BigDecimal value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(BigDecimal value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(BigDecimal value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<BigDecimal> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<BigDecimal> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNull() {
            addCriterion("discount_money is null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNotNull() {
            addCriterion("discount_money is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyEqualTo(BigDecimal value) {
            addCriterion("discount_money =", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotEqualTo(BigDecimal value) {
            addCriterion("discount_money <>", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThan(BigDecimal value) {
            addCriterion("discount_money >", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_money >=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThan(BigDecimal value) {
            addCriterion("discount_money <", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_money <=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIn(List<BigDecimal> values) {
            addCriterion("discount_money in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotIn(List<BigDecimal> values) {
            addCriterion("discount_money not in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_money between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_money not between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyIsNull() {
            addCriterion("discount_last_money is null");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyIsNotNull() {
            addCriterion("discount_last_money is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyEqualTo(BigDecimal value) {
            addCriterion("discount_last_money =", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyNotEqualTo(BigDecimal value) {
            addCriterion("discount_last_money <>", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyGreaterThan(BigDecimal value) {
            addCriterion("discount_last_money >", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_last_money >=", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyLessThan(BigDecimal value) {
            addCriterion("discount_last_money <", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_last_money <=", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyIn(List<BigDecimal> values) {
            addCriterion("discount_last_money in", values, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyNotIn(List<BigDecimal> values) {
            addCriterion("discount_last_money not in", values, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_last_money between", value1, value2, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_last_money not between", value1, value2, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyIsNull() {
            addCriterion("other_money is null");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyIsNotNull() {
            addCriterion("other_money is not null");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyEqualTo(BigDecimal value) {
            addCriterion("other_money =", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyNotEqualTo(BigDecimal value) {
            addCriterion("other_money <>", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyGreaterThan(BigDecimal value) {
            addCriterion("other_money >", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_money >=", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyLessThan(BigDecimal value) {
            addCriterion("other_money <", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_money <=", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyIn(List<BigDecimal> values) {
            addCriterion("other_money in", values, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyNotIn(List<BigDecimal> values) {
            addCriterion("other_money not in", values, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_money between", value1, value2, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_money not between", value1, value2, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLinkNumberIsNull() {
            addCriterion("link_number is null");
            return (Criteria) this;
        }

        public Criteria andLinkNumberIsNotNull() {
            addCriterion("link_number is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNumberEqualTo(String value) {
            addCriterion("link_number =", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberNotEqualTo(String value) {
            addCriterion("link_number <>", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberGreaterThan(String value) {
            addCriterion("link_number >", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberGreaterThanOrEqualTo(String value) {
            addCriterion("link_number >=", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberLessThan(String value) {
            addCriterion("link_number <", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberLessThanOrEqualTo(String value) {
            addCriterion("link_number <=", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberLike(String value) {
            addCriterion("link_number like", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberNotLike(String value) {
            addCriterion("link_number not like", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberIn(List<String> values) {
            addCriterion("link_number in", values, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberNotIn(List<String> values) {
            addCriterion("link_number not in", values, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberBetween(String value1, String value2) {
            addCriterion("link_number between", value1, value2, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberNotBetween(String value1, String value2) {
            addCriterion("link_number not between", value1, value2, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusIsNull() {
            addCriterion("out_depot_status is null");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusIsNotNull() {
            addCriterion("out_depot_status is not null");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusEqualTo(String value) {
            addCriterion("out_depot_status =", value, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusNotEqualTo(String value) {
            addCriterion("out_depot_status <>", value, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusGreaterThan(String value) {
            addCriterion("out_depot_status >", value, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusGreaterThanOrEqualTo(String value) {
            addCriterion("out_depot_status >=", value, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusLessThan(String value) {
            addCriterion("out_depot_status <", value, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusLessThanOrEqualTo(String value) {
            addCriterion("out_depot_status <=", value, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusLike(String value) {
            addCriterion("out_depot_status like", value, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusNotLike(String value) {
            addCriterion("out_depot_status not like", value, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusIn(List<String> values) {
            addCriterion("out_depot_status in", values, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusNotIn(List<String> values) {
            addCriterion("out_depot_status not in", values, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusBetween(String value1, String value2) {
            addCriterion("out_depot_status between", value1, value2, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andOutDepotStatusNotBetween(String value1, String value2) {
            addCriterion("out_depot_status not between", value1, value2, "outDepotStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeIsNull() {
            addCriterion("logistics_fee is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeIsNotNull() {
            addCriterion("logistics_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeEqualTo(BigDecimal value) {
            addCriterion("logistics_fee =", value, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeNotEqualTo(BigDecimal value) {
            addCriterion("logistics_fee <>", value, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeGreaterThan(BigDecimal value) {
            addCriterion("logistics_fee >", value, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("logistics_fee >=", value, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeLessThan(BigDecimal value) {
            addCriterion("logistics_fee <", value, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("logistics_fee <=", value, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeIn(List<BigDecimal> values) {
            addCriterion("logistics_fee in", values, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeNotIn(List<BigDecimal> values) {
            addCriterion("logistics_fee not in", values, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("logistics_fee between", value1, value2, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("logistics_fee not between", value1, value2, "logisticsFee");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayIsNull() {
            addCriterion("logistics_way is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayIsNotNull() {
            addCriterion("logistics_way is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayEqualTo(String value) {
            addCriterion("logistics_way =", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayNotEqualTo(String value) {
            addCriterion("logistics_way <>", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayGreaterThan(String value) {
            addCriterion("logistics_way >", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_way >=", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayLessThan(String value) {
            addCriterion("logistics_way <", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayLessThanOrEqualTo(String value) {
            addCriterion("logistics_way <=", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayLike(String value) {
            addCriterion("logistics_way like", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayNotLike(String value) {
            addCriterion("logistics_way not like", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayIn(List<String> values) {
            addCriterion("logistics_way in", values, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayNotIn(List<String> values) {
            addCriterion("logistics_way not in", values, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayBetween(String value1, String value2) {
            addCriterion("logistics_way between", value1, value2, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayNotBetween(String value1, String value2) {
            addCriterion("logistics_way not between", value1, value2, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(String value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(String value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(String value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(String value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(String value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLike(String value) {
            addCriterion("delivery_time like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotLike(String value) {
            addCriterion("delivery_time not like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<String> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<String> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(String value1, String value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(String value1, String value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyIsNull() {
            addCriterion("logistics_company is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyIsNotNull() {
            addCriterion("logistics_company is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyEqualTo(String value) {
            addCriterion("logistics_company =", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotEqualTo(String value) {
            addCriterion("logistics_company <>", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyGreaterThan(String value) {
            addCriterion("logistics_company >", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_company >=", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLessThan(String value) {
            addCriterion("logistics_company <", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLessThanOrEqualTo(String value) {
            addCriterion("logistics_company <=", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLike(String value) {
            addCriterion("logistics_company like", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotLike(String value) {
            addCriterion("logistics_company not like", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyIn(List<String> values) {
            addCriterion("logistics_company in", values, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotIn(List<String> values) {
            addCriterion("logistics_company not in", values, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyBetween(String value1, String value2) {
            addCriterion("logistics_company between", value1, value2, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotBetween(String value1, String value2) {
            addCriterion("logistics_company not between", value1, value2, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberIsNull() {
            addCriterion("logistics_number is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberIsNotNull() {
            addCriterion("logistics_number is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberEqualTo(String value) {
            addCriterion("logistics_number =", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotEqualTo(String value) {
            addCriterion("logistics_number <>", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberGreaterThan(String value) {
            addCriterion("logistics_number >", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_number >=", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberLessThan(String value) {
            addCriterion("logistics_number <", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberLessThanOrEqualTo(String value) {
            addCriterion("logistics_number <=", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberLike(String value) {
            addCriterion("logistics_number like", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotLike(String value) {
            addCriterion("logistics_number not like", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberIn(List<String> values) {
            addCriterion("logistics_number in", values, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotIn(List<String> values) {
            addCriterion("logistics_number not in", values, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberBetween(String value1, String value2) {
            addCriterion("logistics_number between", value1, value2, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotBetween(String value1, String value2) {
            addCriterion("logistics_number not between", value1, value2, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdIsNull() {
            addCriterion("cust_address_id is null");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdIsNotNull() {
            addCriterion("cust_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdEqualTo(Long value) {
            addCriterion("cust_address_id =", value, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdNotEqualTo(Long value) {
            addCriterion("cust_address_id <>", value, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdGreaterThan(Long value) {
            addCriterion("cust_address_id >", value, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cust_address_id >=", value, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdLessThan(Long value) {
            addCriterion("cust_address_id <", value, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdLessThanOrEqualTo(Long value) {
            addCriterion("cust_address_id <=", value, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdIn(List<Long> values) {
            addCriterion("cust_address_id in", values, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdNotIn(List<Long> values) {
            addCriterion("cust_address_id not in", values, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdBetween(Long value1, Long value2) {
            addCriterion("cust_address_id between", value1, value2, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andCustAddressIdNotBetween(Long value1, Long value2) {
            addCriterion("cust_address_id not between", value1, value2, "custAddressId");
            return (Criteria) this;
        }

        public Criteria andTechnicianIsNull() {
            addCriterion("technician is null");
            return (Criteria) this;
        }

        public Criteria andTechnicianIsNotNull() {
            addCriterion("technician is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicianEqualTo(String value) {
            addCriterion("technician =", value, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianNotEqualTo(String value) {
            addCriterion("technician <>", value, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianGreaterThan(String value) {
            addCriterion("technician >", value, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianGreaterThanOrEqualTo(String value) {
            addCriterion("technician >=", value, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianLessThan(String value) {
            addCriterion("technician <", value, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianLessThanOrEqualTo(String value) {
            addCriterion("technician <=", value, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianLike(String value) {
            addCriterion("technician like", value, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianNotLike(String value) {
            addCriterion("technician not like", value, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianIn(List<String> values) {
            addCriterion("technician in", values, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianNotIn(List<String> values) {
            addCriterion("technician not in", values, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianBetween(String value1, String value2) {
            addCriterion("technician between", value1, value2, "technician");
            return (Criteria) this;
        }

        public Criteria andTechnicianNotBetween(String value1, String value2) {
            addCriterion("technician not between", value1, value2, "technician");
            return (Criteria) this;
        }

        public Criteria andDepotIdIsNull() {
            addCriterion("depot_id is null");
            return (Criteria) this;
        }

        public Criteria andDepotIdIsNotNull() {
            addCriterion("depot_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepotIdEqualTo(Long value) {
            addCriterion("depot_id =", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotEqualTo(Long value) {
            addCriterion("depot_id <>", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdGreaterThan(Long value) {
            addCriterion("depot_id >", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("depot_id >=", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdLessThan(Long value) {
            addCriterion("depot_id <", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdLessThanOrEqualTo(Long value) {
            addCriterion("depot_id <=", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdIn(List<Long> values) {
            addCriterion("depot_id in", values, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotIn(List<Long> values) {
            addCriterion("depot_id not in", values, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdBetween(Long value1, Long value2) {
            addCriterion("depot_id between", value1, value2, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotBetween(Long value1, Long value2) {
            addCriterion("depot_id not between", value1, value2, "depotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdIsNull() {
            addCriterion("another_depot_id is null");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdIsNotNull() {
            addCriterion("another_depot_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdEqualTo(Long value) {
            addCriterion("another_depot_id =", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdNotEqualTo(Long value) {
            addCriterion("another_depot_id <>", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdGreaterThan(Long value) {
            addCriterion("another_depot_id >", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("another_depot_id >=", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdLessThan(Long value) {
            addCriterion("another_depot_id <", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdLessThanOrEqualTo(Long value) {
            addCriterion("another_depot_id <=", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdIn(List<Long> values) {
            addCriterion("another_depot_id in", values, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdNotIn(List<Long> values) {
            addCriterion("another_depot_id not in", values, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdBetween(Long value1, Long value2) {
            addCriterion("another_depot_id between", value1, value2, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdNotBetween(Long value1, Long value2) {
            addCriterion("another_depot_id not between", value1, value2, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(Long value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(Long value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(Long value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(Long value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(Long value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(Long value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<Long> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<Long> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(Long value1, Long value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(Long value1, Long value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(Long value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Long value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Long value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Long value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Long value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Long value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Long> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Long> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Long value1, Long value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Long value1, Long value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(Long value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(Long value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(Long value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(Long value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(Long value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(Long value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<Long> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<Long> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(Long value1, Long value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(Long value1, Long value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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