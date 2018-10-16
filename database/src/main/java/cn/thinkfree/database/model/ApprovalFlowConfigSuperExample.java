package cn.thinkfree.database.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApprovalFlowConfigSuperExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    public ApprovalFlowConfigSuperExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
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
     * This method corresponds to the database table approval_flow_config_super
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
     * This method corresponds to the database table approval_flow_config_super
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_super
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
     * This class corresponds to the database table approval_flow_config_super
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

        public Criteria andConfigAliasIsNull() {
            addCriterion("config_alias is null");
            return (Criteria) this;
        }

        public Criteria andConfigAliasIsNotNull() {
            addCriterion("config_alias is not null");
            return (Criteria) this;
        }

        public Criteria andConfigAliasEqualTo(String value) {
            addCriterion("config_alias =", value, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasNotEqualTo(String value) {
            addCriterion("config_alias <>", value, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasGreaterThan(String value) {
            addCriterion("config_alias >", value, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasGreaterThanOrEqualTo(String value) {
            addCriterion("config_alias >=", value, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasLessThan(String value) {
            addCriterion("config_alias <", value, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasLessThanOrEqualTo(String value) {
            addCriterion("config_alias <=", value, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasLike(String value) {
            addCriterion("config_alias like", value, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasNotLike(String value) {
            addCriterion("config_alias not like", value, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasIn(List<String> values) {
            addCriterion("config_alias in", values, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasNotIn(List<String> values) {
            addCriterion("config_alias not in", values, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasBetween(String value1, String value2) {
            addCriterion("config_alias between", value1, value2, "configAlias");
            return (Criteria) this;
        }

        public Criteria andConfigAliasNotBetween(String value1, String value2) {
            addCriterion("config_alias not between", value1, value2, "configAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasIsNull() {
            addCriterion("super_config_alias is null");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasIsNotNull() {
            addCriterion("super_config_alias is not null");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasEqualTo(String value) {
            addCriterion("super_config_alias =", value, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasNotEqualTo(String value) {
            addCriterion("super_config_alias <>", value, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasGreaterThan(String value) {
            addCriterion("super_config_alias >", value, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasGreaterThanOrEqualTo(String value) {
            addCriterion("super_config_alias >=", value, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasLessThan(String value) {
            addCriterion("super_config_alias <", value, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasLessThanOrEqualTo(String value) {
            addCriterion("super_config_alias <=", value, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasLike(String value) {
            addCriterion("super_config_alias like", value, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasNotLike(String value) {
            addCriterion("super_config_alias not like", value, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasIn(List<String> values) {
            addCriterion("super_config_alias in", values, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasNotIn(List<String> values) {
            addCriterion("super_config_alias not in", values, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasBetween(String value1, String value2) {
            addCriterion("super_config_alias between", value1, value2, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andSuperConfigAliasNotBetween(String value1, String value2) {
            addCriterion("super_config_alias not between", value1, value2, "superConfigAlias");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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

        public Criteria andUsableIsNull() {
            addCriterion("usable is null");
            return (Criteria) this;
        }

        public Criteria andUsableIsNotNull() {
            addCriterion("usable is not null");
            return (Criteria) this;
        }

        public Criteria andUsableEqualTo(Integer value) {
            addCriterion("usable =", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableNotEqualTo(Integer value) {
            addCriterion("usable <>", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableGreaterThan(Integer value) {
            addCriterion("usable >", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableGreaterThanOrEqualTo(Integer value) {
            addCriterion("usable >=", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableLessThan(Integer value) {
            addCriterion("usable <", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableLessThanOrEqualTo(Integer value) {
            addCriterion("usable <=", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableIn(List<Integer> values) {
            addCriterion("usable in", values, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableNotIn(List<Integer> values) {
            addCriterion("usable not in", values, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableBetween(Integer value1, Integer value2) {
            addCriterion("usable between", value1, value2, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableNotBetween(Integer value1, Integer value2) {
            addCriterion("usable not between", value1, value2, "usable");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table approval_flow_config_super
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
     * This class corresponds to the database table approval_flow_config_super
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