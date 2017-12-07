package com.baoshu.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransLogExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
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

        public Criteria andChildFundidIsNull() {
            addCriterion("child_fundid is null");
            return (Criteria) this;
        }

        public Criteria andChildFundidIsNotNull() {
            addCriterion("child_fundid is not null");
            return (Criteria) this;
        }

        public Criteria andChildFundidEqualTo(String value) {
            addCriterion("child_fundid =", value, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidNotEqualTo(String value) {
            addCriterion("child_fundid <>", value, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidGreaterThan(String value) {
            addCriterion("child_fundid >", value, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidGreaterThanOrEqualTo(String value) {
            addCriterion("child_fundid >=", value, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidLessThan(String value) {
            addCriterion("child_fundid <", value, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidLessThanOrEqualTo(String value) {
            addCriterion("child_fundid <=", value, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidLike(String value) {
            addCriterion("child_fundid like", value, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidNotLike(String value) {
            addCriterion("child_fundid not like", value, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidIn(List<String> values) {
            addCriterion("child_fundid in", values, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidNotIn(List<String> values) {
            addCriterion("child_fundid not in", values, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidBetween(String value1, String value2) {
            addCriterion("child_fundid between", value1, value2, "childFundid");
            return (Criteria) this;
        }

        public Criteria andChildFundidNotBetween(String value1, String value2) {
            addCriterion("child_fundid not between", value1, value2, "childFundid");
            return (Criteria) this;
        }

        public Criteria andStkCodeIsNull() {
            addCriterion("stk_code is null");
            return (Criteria) this;
        }

        public Criteria andStkCodeIsNotNull() {
            addCriterion("stk_code is not null");
            return (Criteria) this;
        }

        public Criteria andStkCodeEqualTo(String value) {
            addCriterion("stk_code =", value, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeNotEqualTo(String value) {
            addCriterion("stk_code <>", value, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeGreaterThan(String value) {
            addCriterion("stk_code >", value, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stk_code >=", value, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeLessThan(String value) {
            addCriterion("stk_code <", value, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeLessThanOrEqualTo(String value) {
            addCriterion("stk_code <=", value, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeLike(String value) {
            addCriterion("stk_code like", value, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeNotLike(String value) {
            addCriterion("stk_code not like", value, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeIn(List<String> values) {
            addCriterion("stk_code in", values, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeNotIn(List<String> values) {
            addCriterion("stk_code not in", values, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeBetween(String value1, String value2) {
            addCriterion("stk_code between", value1, value2, "stkCode");
            return (Criteria) this;
        }

        public Criteria andStkCodeNotBetween(String value1, String value2) {
            addCriterion("stk_code not between", value1, value2, "stkCode");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("qty is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("qty is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(Integer value) {
            addCriterion("qty =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Integer value) {
            addCriterion("qty <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Integer value) {
            addCriterion("qty >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("qty >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Integer value) {
            addCriterion("qty <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Integer value) {
            addCriterion("qty <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Integer> values) {
            addCriterion("qty in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Integer> values) {
            addCriterion("qty not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Integer value1, Integer value2) {
            addCriterion("qty between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("qty not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andMarketIsNull() {
            addCriterion("market is null");
            return (Criteria) this;
        }

        public Criteria andMarketIsNotNull() {
            addCriterion("market is not null");
            return (Criteria) this;
        }

        public Criteria andMarketEqualTo(String value) {
            addCriterion("market =", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotEqualTo(String value) {
            addCriterion("market <>", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketGreaterThan(String value) {
            addCriterion("market >", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketGreaterThanOrEqualTo(String value) {
            addCriterion("market >=", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketLessThan(String value) {
            addCriterion("market <", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketLessThanOrEqualTo(String value) {
            addCriterion("market <=", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketLike(String value) {
            addCriterion("market like", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotLike(String value) {
            addCriterion("market not like", value, "market");
            return (Criteria) this;
        }

        public Criteria andMarketIn(List<String> values) {
            addCriterion("market in", values, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotIn(List<String> values) {
            addCriterion("market not in", values, "market");
            return (Criteria) this;
        }

        public Criteria andMarketBetween(String value1, String value2) {
            addCriterion("market between", value1, value2, "market");
            return (Criteria) this;
        }

        public Criteria andMarketNotBetween(String value1, String value2) {
            addCriterion("market not between", value1, value2, "market");
            return (Criteria) this;
        }

        public Criteria andQsflagIsNull() {
            addCriterion("qsflag is null");
            return (Criteria) this;
        }

        public Criteria andQsflagIsNotNull() {
            addCriterion("qsflag is not null");
            return (Criteria) this;
        }

        public Criteria andQsflagEqualTo(String value) {
            addCriterion("qsflag =", value, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagNotEqualTo(String value) {
            addCriterion("qsflag <>", value, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagGreaterThan(String value) {
            addCriterion("qsflag >", value, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagGreaterThanOrEqualTo(String value) {
            addCriterion("qsflag >=", value, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagLessThan(String value) {
            addCriterion("qsflag <", value, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagLessThanOrEqualTo(String value) {
            addCriterion("qsflag <=", value, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagLike(String value) {
            addCriterion("qsflag like", value, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagNotLike(String value) {
            addCriterion("qsflag not like", value, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagIn(List<String> values) {
            addCriterion("qsflag in", values, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagNotIn(List<String> values) {
            addCriterion("qsflag not in", values, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagBetween(String value1, String value2) {
            addCriterion("qsflag between", value1, value2, "qsflag");
            return (Criteria) this;
        }

        public Criteria andQsflagNotBetween(String value1, String value2) {
            addCriterion("qsflag not between", value1, value2, "qsflag");
            return (Criteria) this;
        }

        public Criteria andLsnoIsNull() {
            addCriterion("lsno is null");
            return (Criteria) this;
        }

        public Criteria andLsnoIsNotNull() {
            addCriterion("lsno is not null");
            return (Criteria) this;
        }

        public Criteria andLsnoEqualTo(String value) {
            addCriterion("lsno =", value, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoNotEqualTo(String value) {
            addCriterion("lsno <>", value, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoGreaterThan(String value) {
            addCriterion("lsno >", value, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoGreaterThanOrEqualTo(String value) {
            addCriterion("lsno >=", value, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoLessThan(String value) {
            addCriterion("lsno <", value, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoLessThanOrEqualTo(String value) {
            addCriterion("lsno <=", value, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoLike(String value) {
            addCriterion("lsno like", value, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoNotLike(String value) {
            addCriterion("lsno not like", value, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoIn(List<String> values) {
            addCriterion("lsno in", values, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoNotIn(List<String> values) {
            addCriterion("lsno not in", values, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoBetween(String value1, String value2) {
            addCriterion("lsno between", value1, value2, "lsno");
            return (Criteria) this;
        }

        public Criteria andLsnoNotBetween(String value1, String value2) {
            addCriterion("lsno not between", value1, value2, "lsno");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoIsNull() {
            addCriterion("devide_order_no is null");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoIsNotNull() {
            addCriterion("devide_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoEqualTo(String value) {
            addCriterion("devide_order_no =", value, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoNotEqualTo(String value) {
            addCriterion("devide_order_no <>", value, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoGreaterThan(String value) {
            addCriterion("devide_order_no >", value, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("devide_order_no >=", value, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoLessThan(String value) {
            addCriterion("devide_order_no <", value, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoLessThanOrEqualTo(String value) {
            addCriterion("devide_order_no <=", value, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoLike(String value) {
            addCriterion("devide_order_no like", value, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoNotLike(String value) {
            addCriterion("devide_order_no not like", value, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoIn(List<String> values) {
            addCriterion("devide_order_no in", values, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoNotIn(List<String> values) {
            addCriterion("devide_order_no not in", values, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoBetween(String value1, String value2) {
            addCriterion("devide_order_no between", value1, value2, "devideOrderNo");
            return (Criteria) this;
        }

        public Criteria andDevideOrderNoNotBetween(String value1, String value2) {
            addCriterion("devide_order_no not between", value1, value2, "devideOrderNo");
            return (Criteria) this;
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

        public Criteria andRequestIdIsNull() {
            addCriterion("request_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNotNull() {
            addCriterion("request_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIdEqualTo(String value) {
            addCriterion("request_id =", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotEqualTo(String value) {
            addCriterion("request_id <>", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThan(String value) {
            addCriterion("request_id >", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThanOrEqualTo(String value) {
            addCriterion("request_id >=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThan(String value) {
            addCriterion("request_id <", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThanOrEqualTo(String value) {
            addCriterion("request_id <=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLike(String value) {
            addCriterion("request_id like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotLike(String value) {
            addCriterion("request_id not like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdIn(List<String> values) {
            addCriterion("request_id in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotIn(List<String> values) {
            addCriterion("request_id not in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdBetween(String value1, String value2) {
            addCriterion("request_id between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotBetween(String value1, String value2) {
            addCriterion("request_id not between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andIsDoneIsNull() {
            addCriterion("is_done is null");
            return (Criteria) this;
        }

        public Criteria andIsDoneIsNotNull() {
            addCriterion("is_done is not null");
            return (Criteria) this;
        }

        public Criteria andIsDoneEqualTo(Boolean value) {
            addCriterion("is_done =", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotEqualTo(Boolean value) {
            addCriterion("is_done <>", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneGreaterThan(Boolean value) {
            addCriterion("is_done >", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_done >=", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneLessThan(Boolean value) {
            addCriterion("is_done <", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneLessThanOrEqualTo(Boolean value) {
            addCriterion("is_done <=", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneIn(List<Boolean> values) {
            addCriterion("is_done in", values, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotIn(List<Boolean> values) {
            addCriterion("is_done not in", values, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneBetween(Boolean value1, Boolean value2) {
            addCriterion("is_done between", value1, value2, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_done not between", value1, value2, "isDone");
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