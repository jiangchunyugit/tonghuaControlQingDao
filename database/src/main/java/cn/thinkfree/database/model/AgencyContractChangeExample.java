package cn.thinkfree.database.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgencyContractChangeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public AgencyContractChangeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
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

        public Criteria andChangeBeforeCodeIsNull() {
            addCriterion("change_before_code is null");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeIsNotNull() {
            addCriterion("change_before_code is not null");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeEqualTo(String value) {
            addCriterion("change_before_code =", value, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeNotEqualTo(String value) {
            addCriterion("change_before_code <>", value, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeGreaterThan(String value) {
            addCriterion("change_before_code >", value, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("change_before_code >=", value, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeLessThan(String value) {
            addCriterion("change_before_code <", value, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeLessThanOrEqualTo(String value) {
            addCriterion("change_before_code <=", value, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeLike(String value) {
            addCriterion("change_before_code like", value, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeNotLike(String value) {
            addCriterion("change_before_code not like", value, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeIn(List<String> values) {
            addCriterion("change_before_code in", values, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeNotIn(List<String> values) {
            addCriterion("change_before_code not in", values, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeBetween(String value1, String value2) {
            addCriterion("change_before_code between", value1, value2, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeBeforeCodeNotBetween(String value1, String value2) {
            addCriterion("change_before_code not between", value1, value2, "changeBeforeCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeIsNull() {
            addCriterion("change_after_code is null");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeIsNotNull() {
            addCriterion("change_after_code is not null");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeEqualTo(String value) {
            addCriterion("change_after_code =", value, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeNotEqualTo(String value) {
            addCriterion("change_after_code <>", value, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeGreaterThan(String value) {
            addCriterion("change_after_code >", value, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("change_after_code >=", value, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeLessThan(String value) {
            addCriterion("change_after_code <", value, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeLessThanOrEqualTo(String value) {
            addCriterion("change_after_code <=", value, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeLike(String value) {
            addCriterion("change_after_code like", value, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeNotLike(String value) {
            addCriterion("change_after_code not like", value, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeIn(List<String> values) {
            addCriterion("change_after_code in", values, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeNotIn(List<String> values) {
            addCriterion("change_after_code not in", values, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeBetween(String value1, String value2) {
            addCriterion("change_after_code between", value1, value2, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeAfterCodeNotBetween(String value1, String value2) {
            addCriterion("change_after_code not between", value1, value2, "changeAfterCode");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNull() {
            addCriterion("change_time is null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNotNull() {
            addCriterion("change_time is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeEqualTo(Date value) {
            addCriterion("change_time =", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotEqualTo(Date value) {
            addCriterion("change_time <>", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThan(Date value) {
            addCriterion("change_time >", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("change_time >=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThan(Date value) {
            addCriterion("change_time <", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThanOrEqualTo(Date value) {
            addCriterion("change_time <=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIn(List<Date> values) {
            addCriterion("change_time in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotIn(List<Date> values) {
            addCriterion("change_time not in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeBetween(Date value1, Date value2) {
            addCriterion("change_time between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotBetween(Date value1, Date value2) {
            addCriterion("change_time not between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeIsNull() {
            addCriterion("changed_time is null");
            return (Criteria) this;
        }

        public Criteria andChangedTimeIsNotNull() {
            addCriterion("changed_time is not null");
            return (Criteria) this;
        }

        public Criteria andChangedTimeEqualTo(Date value) {
            addCriterion("changed_time =", value, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeNotEqualTo(Date value) {
            addCriterion("changed_time <>", value, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeGreaterThan(Date value) {
            addCriterion("changed_time >", value, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("changed_time >=", value, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeLessThan(Date value) {
            addCriterion("changed_time <", value, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeLessThanOrEqualTo(Date value) {
            addCriterion("changed_time <=", value, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeIn(List<Date> values) {
            addCriterion("changed_time in", values, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeNotIn(List<Date> values) {
            addCriterion("changed_time not in", values, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeBetween(Date value1, Date value2) {
            addCriterion("changed_time between", value1, value2, "changedTime");
            return (Criteria) this;
        }

        public Criteria andChangedTimeNotBetween(Date value1, Date value2) {
            addCriterion("changed_time not between", value1, value2, "changedTime");
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

        public Criteria andIsDoneEqualTo(Short value) {
            addCriterion("is_done =", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotEqualTo(Short value) {
            addCriterion("is_done <>", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneGreaterThan(Short value) {
            addCriterion("is_done >", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneGreaterThanOrEqualTo(Short value) {
            addCriterion("is_done >=", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneLessThan(Short value) {
            addCriterion("is_done <", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneLessThanOrEqualTo(Short value) {
            addCriterion("is_done <=", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneIn(List<Short> values) {
            addCriterion("is_done in", values, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotIn(List<Short> values) {
            addCriterion("is_done not in", values, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneBetween(Short value1, Short value2) {
            addCriterion("is_done between", value1, value2, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotBetween(Short value1, Short value2) {
            addCriterion("is_done not between", value1, value2, "isDone");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pc_agency_contract_change
     *
     * @mbg.generated
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