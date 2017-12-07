package com.baoshu.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QueryLogExample() {
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

        public Criteria andOrdersNoIsNull() {
            addCriterion("orders_no is null");
            return (Criteria) this;
        }

        public Criteria andOrdersNoIsNotNull() {
            addCriterion("orders_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersNoEqualTo(String value) {
            addCriterion("orders_no =", value, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoNotEqualTo(String value) {
            addCriterion("orders_no <>", value, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoGreaterThan(String value) {
            addCriterion("orders_no >", value, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoGreaterThanOrEqualTo(String value) {
            addCriterion("orders_no >=", value, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoLessThan(String value) {
            addCriterion("orders_no <", value, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoLessThanOrEqualTo(String value) {
            addCriterion("orders_no <=", value, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoLike(String value) {
            addCriterion("orders_no like", value, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoNotLike(String value) {
            addCriterion("orders_no not like", value, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoIn(List<String> values) {
            addCriterion("orders_no in", values, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoNotIn(List<String> values) {
            addCriterion("orders_no not in", values, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoBetween(String value1, String value2) {
            addCriterion("orders_no between", value1, value2, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andOrdersNoNotBetween(String value1, String value2) {
            addCriterion("orders_no not between", value1, value2, "ordersNo");
            return (Criteria) this;
        }

        public Criteria andFundidIsNull() {
            addCriterion("fundid is null");
            return (Criteria) this;
        }

        public Criteria andFundidIsNotNull() {
            addCriterion("fundid is not null");
            return (Criteria) this;
        }

        public Criteria andFundidEqualTo(String value) {
            addCriterion("fundid =", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidNotEqualTo(String value) {
            addCriterion("fundid <>", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidGreaterThan(String value) {
            addCriterion("fundid >", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidGreaterThanOrEqualTo(String value) {
            addCriterion("fundid >=", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidLessThan(String value) {
            addCriterion("fundid <", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidLessThanOrEqualTo(String value) {
            addCriterion("fundid <=", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidLike(String value) {
            addCriterion("fundid like", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidNotLike(String value) {
            addCriterion("fundid not like", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidIn(List<String> values) {
            addCriterion("fundid in", values, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidNotIn(List<String> values) {
            addCriterion("fundid not in", values, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidBetween(String value1, String value2) {
            addCriterion("fundid between", value1, value2, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidNotBetween(String value1, String value2) {
            addCriterion("fundid not between", value1, value2, "fundid");
            return (Criteria) this;
        }

        public Criteria andUseMoneyIsNull() {
            addCriterion("use_money is null");
            return (Criteria) this;
        }

        public Criteria andUseMoneyIsNotNull() {
            addCriterion("use_money is not null");
            return (Criteria) this;
        }

        public Criteria andUseMoneyEqualTo(BigDecimal value) {
            addCriterion("use_money =", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyNotEqualTo(BigDecimal value) {
            addCriterion("use_money <>", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyGreaterThan(BigDecimal value) {
            addCriterion("use_money >", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("use_money >=", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyLessThan(BigDecimal value) {
            addCriterion("use_money <", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("use_money <=", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyIn(List<BigDecimal> values) {
            addCriterion("use_money in", values, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyNotIn(List<BigDecimal> values) {
            addCriterion("use_money not in", values, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("use_money between", value1, value2, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("use_money not between", value1, value2, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseAmountIsNull() {
            addCriterion("use_amount is null");
            return (Criteria) this;
        }

        public Criteria andUseAmountIsNotNull() {
            addCriterion("use_amount is not null");
            return (Criteria) this;
        }

        public Criteria andUseAmountEqualTo(Integer value) {
            addCriterion("use_amount =", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountNotEqualTo(Integer value) {
            addCriterion("use_amount <>", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountGreaterThan(Integer value) {
            addCriterion("use_amount >", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_amount >=", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountLessThan(Integer value) {
            addCriterion("use_amount <", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountLessThanOrEqualTo(Integer value) {
            addCriterion("use_amount <=", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountIn(List<Integer> values) {
            addCriterion("use_amount in", values, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountNotIn(List<Integer> values) {
            addCriterion("use_amount not in", values, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountBetween(Integer value1, Integer value2) {
            addCriterion("use_amount between", value1, value2, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("use_amount not between", value1, value2, "useAmount");
            return (Criteria) this;
        }

        public Criteria andPostStrIsNull() {
            addCriterion("post_str is null");
            return (Criteria) this;
        }

        public Criteria andPostStrIsNotNull() {
            addCriterion("post_str is not null");
            return (Criteria) this;
        }

        public Criteria andPostStrEqualTo(Integer value) {
            addCriterion("post_str =", value, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrNotEqualTo(Integer value) {
            addCriterion("post_str <>", value, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrGreaterThan(Integer value) {
            addCriterion("post_str >", value, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_str >=", value, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrLessThan(Integer value) {
            addCriterion("post_str <", value, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrLessThanOrEqualTo(Integer value) {
            addCriterion("post_str <=", value, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrIn(List<Integer> values) {
            addCriterion("post_str in", values, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrNotIn(List<Integer> values) {
            addCriterion("post_str not in", values, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrBetween(Integer value1, Integer value2) {
            addCriterion("post_str between", value1, value2, "postStr");
            return (Criteria) this;
        }

        public Criteria andPostStrNotBetween(Integer value1, Integer value2) {
            addCriterion("post_str not between", value1, value2, "postStr");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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