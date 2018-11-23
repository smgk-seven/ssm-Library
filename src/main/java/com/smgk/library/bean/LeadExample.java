package com.smgk.library.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LeadExample() {
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

        public Criteria andLendIdIsNull() {
            addCriterion("lend_id is null");
            return (Criteria) this;
        }

        public Criteria andLendIdIsNotNull() {
            addCriterion("lend_id is not null");
            return (Criteria) this;
        }

        public Criteria andLendIdEqualTo(Integer value) {
            addCriterion("lend_id =", value, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdNotEqualTo(Integer value) {
            addCriterion("lend_id <>", value, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdGreaterThan(Integer value) {
            addCriterion("lend_id >", value, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lend_id >=", value, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdLessThan(Integer value) {
            addCriterion("lend_id <", value, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdLessThanOrEqualTo(Integer value) {
            addCriterion("lend_id <=", value, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdIn(List<Integer> values) {
            addCriterion("lend_id in", values, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdNotIn(List<Integer> values) {
            addCriterion("lend_id not in", values, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdBetween(Integer value1, Integer value2) {
            addCriterion("lend_id between", value1, value2, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lend_id not between", value1, value2, "lendId");
            return (Criteria) this;
        }

        public Criteria andLendNumIsNull() {
            addCriterion("lend_num is null");
            return (Criteria) this;
        }

        public Criteria andLendNumIsNotNull() {
            addCriterion("lend_num is not null");
            return (Criteria) this;
        }

        public Criteria andLendNumEqualTo(Integer value) {
            addCriterion("lend_num =", value, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumNotEqualTo(Integer value) {
            addCriterion("lend_num <>", value, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumGreaterThan(Integer value) {
            addCriterion("lend_num >", value, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("lend_num >=", value, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumLessThan(Integer value) {
            addCriterion("lend_num <", value, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumLessThanOrEqualTo(Integer value) {
            addCriterion("lend_num <=", value, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumIn(List<Integer> values) {
            addCriterion("lend_num in", values, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumNotIn(List<Integer> values) {
            addCriterion("lend_num not in", values, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumBetween(Integer value1, Integer value2) {
            addCriterion("lend_num between", value1, value2, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendNumNotBetween(Integer value1, Integer value2) {
            addCriterion("lend_num not between", value1, value2, "lendNum");
            return (Criteria) this;
        }

        public Criteria andLendTimeIsNull() {
            addCriterion("lend_time is null");
            return (Criteria) this;
        }

        public Criteria andLendTimeIsNotNull() {
            addCriterion("lend_time is not null");
            return (Criteria) this;
        }

        public Criteria andLendTimeEqualTo(Date value) {
            addCriterion("lend_time =", value, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeNotEqualTo(Date value) {
            addCriterion("lend_time <>", value, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeGreaterThan(Date value) {
            addCriterion("lend_time >", value, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lend_time >=", value, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeLessThan(Date value) {
            addCriterion("lend_time <", value, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeLessThanOrEqualTo(Date value) {
            addCriterion("lend_time <=", value, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeIn(List<Date> values) {
            addCriterion("lend_time in", values, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeNotIn(List<Date> values) {
            addCriterion("lend_time not in", values, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeBetween(Date value1, Date value2) {
            addCriterion("lend_time between", value1, value2, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendTimeNotBetween(Date value1, Date value2) {
            addCriterion("lend_time not between", value1, value2, "lendTime");
            return (Criteria) this;
        }

        public Criteria andLendStatusIsNull() {
            addCriterion("lend_status is null");
            return (Criteria) this;
        }

        public Criteria andLendStatusIsNotNull() {
            addCriterion("lend_status is not null");
            return (Criteria) this;
        }

        public Criteria andLendStatusEqualTo(String value) {
            addCriterion("lend_status =", value, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusNotEqualTo(String value) {
            addCriterion("lend_status <>", value, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusGreaterThan(String value) {
            addCriterion("lend_status >", value, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusGreaterThanOrEqualTo(String value) {
            addCriterion("lend_status >=", value, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusLessThan(String value) {
            addCriterion("lend_status <", value, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusLessThanOrEqualTo(String value) {
            addCriterion("lend_status <=", value, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusLike(String value) {
            addCriterion("lend_status like", value, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusNotLike(String value) {
            addCriterion("lend_status not like", value, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusIn(List<String> values) {
            addCriterion("lend_status in", values, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusNotIn(List<String> values) {
            addCriterion("lend_status not in", values, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusBetween(String value1, String value2) {
            addCriterion("lend_status between", value1, value2, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStatusNotBetween(String value1, String value2) {
            addCriterion("lend_status not between", value1, value2, "lendStatus");
            return (Criteria) this;
        }

        public Criteria andLendStuIsNull() {
            addCriterion("lend_stu is null");
            return (Criteria) this;
        }

        public Criteria andLendStuIsNotNull() {
            addCriterion("lend_stu is not null");
            return (Criteria) this;
        }

        public Criteria andLendStuEqualTo(Integer value) {
            addCriterion("lend_stu =", value, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuNotEqualTo(Integer value) {
            addCriterion("lend_stu <>", value, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuGreaterThan(Integer value) {
            addCriterion("lend_stu >", value, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuGreaterThanOrEqualTo(Integer value) {
            addCriterion("lend_stu >=", value, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuLessThan(Integer value) {
            addCriterion("lend_stu <", value, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuLessThanOrEqualTo(Integer value) {
            addCriterion("lend_stu <=", value, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuIn(List<Integer> values) {
            addCriterion("lend_stu in", values, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuNotIn(List<Integer> values) {
            addCriterion("lend_stu not in", values, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuBetween(Integer value1, Integer value2) {
            addCriterion("lend_stu between", value1, value2, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendStuNotBetween(Integer value1, Integer value2) {
            addCriterion("lend_stu not between", value1, value2, "lendStu");
            return (Criteria) this;
        }

        public Criteria andLendBookIsNull() {
            addCriterion("lend_book is null");
            return (Criteria) this;
        }

        public Criteria andLendBookIsNotNull() {
            addCriterion("lend_book is not null");
            return (Criteria) this;
        }

        public Criteria andLendBookEqualTo(Integer value) {
            addCriterion("lend_book =", value, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookNotEqualTo(Integer value) {
            addCriterion("lend_book <>", value, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookGreaterThan(Integer value) {
            addCriterion("lend_book >", value, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookGreaterThanOrEqualTo(Integer value) {
            addCriterion("lend_book >=", value, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookLessThan(Integer value) {
            addCriterion("lend_book <", value, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookLessThanOrEqualTo(Integer value) {
            addCriterion("lend_book <=", value, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookIn(List<Integer> values) {
            addCriterion("lend_book in", values, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookNotIn(List<Integer> values) {
            addCriterion("lend_book not in", values, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookBetween(Integer value1, Integer value2) {
            addCriterion("lend_book between", value1, value2, "lendBook");
            return (Criteria) this;
        }

        public Criteria andLendBookNotBetween(Integer value1, Integer value2) {
            addCriterion("lend_book not between", value1, value2, "lendBook");
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