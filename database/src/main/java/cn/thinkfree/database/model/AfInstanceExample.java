package cn.thinkfree.database.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AfInstanceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    public AfInstanceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
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
     * This method corresponds to the database table a_f_instance
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
     * This method corresponds to the database table a_f_instance
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_f_instance
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
     * This class corresponds to the database table a_f_instance
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

        public Criteria andProjectNoIsNull() {
            addCriterion("project_no is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNotNull() {
            addCriterion("project_no is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoEqualTo(String value) {
            addCriterion("project_no =", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotEqualTo(String value) {
            addCriterion("project_no <>", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThan(String value) {
            addCriterion("project_no >", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("project_no >=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThan(String value) {
            addCriterion("project_no <", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThanOrEqualTo(String value) {
            addCriterion("project_no <=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLike(String value) {
            addCriterion("project_no like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotLike(String value) {
            addCriterion("project_no not like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIn(List<String> values) {
            addCriterion("project_no in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotIn(List<String> values) {
            addCriterion("project_no not in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoBetween(String value1, String value2) {
            addCriterion("project_no between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotBetween(String value1, String value2) {
            addCriterion("project_no not between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoIsNull() {
            addCriterion("instance_no is null");
            return (Criteria) this;
        }

        public Criteria andInstanceNoIsNotNull() {
            addCriterion("instance_no is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceNoEqualTo(String value) {
            addCriterion("instance_no =", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoNotEqualTo(String value) {
            addCriterion("instance_no <>", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoGreaterThan(String value) {
            addCriterion("instance_no >", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoGreaterThanOrEqualTo(String value) {
            addCriterion("instance_no >=", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoLessThan(String value) {
            addCriterion("instance_no <", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoLessThanOrEqualTo(String value) {
            addCriterion("instance_no <=", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoLike(String value) {
            addCriterion("instance_no like", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoNotLike(String value) {
            addCriterion("instance_no not like", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoIn(List<String> values) {
            addCriterion("instance_no in", values, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoNotIn(List<String> values) {
            addCriterion("instance_no not in", values, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoBetween(String value1, String value2) {
            addCriterion("instance_no between", value1, value2, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoNotBetween(String value1, String value2) {
            addCriterion("instance_no not between", value1, value2, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andScheduleSortIsNull() {
            addCriterion("schedule_sort is null");
            return (Criteria) this;
        }

        public Criteria andScheduleSortIsNotNull() {
            addCriterion("schedule_sort is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleSortEqualTo(Integer value) {
            addCriterion("schedule_sort =", value, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortNotEqualTo(Integer value) {
            addCriterion("schedule_sort <>", value, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortGreaterThan(Integer value) {
            addCriterion("schedule_sort >", value, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule_sort >=", value, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortLessThan(Integer value) {
            addCriterion("schedule_sort <", value, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortLessThanOrEqualTo(Integer value) {
            addCriterion("schedule_sort <=", value, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortIn(List<Integer> values) {
            addCriterion("schedule_sort in", values, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortNotIn(List<Integer> values) {
            addCriterion("schedule_sort not in", values, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortBetween(Integer value1, Integer value2) {
            addCriterion("schedule_sort between", value1, value2, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andScheduleSortNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule_sort not between", value1, value2, "scheduleSort");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdIsNull() {
            addCriterion("create_role_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdIsNotNull() {
            addCriterion("create_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdEqualTo(String value) {
            addCriterion("create_role_id =", value, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdNotEqualTo(String value) {
            addCriterion("create_role_id <>", value, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdGreaterThan(String value) {
            addCriterion("create_role_id >", value, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_role_id >=", value, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdLessThan(String value) {
            addCriterion("create_role_id <", value, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdLessThanOrEqualTo(String value) {
            addCriterion("create_role_id <=", value, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdLike(String value) {
            addCriterion("create_role_id like", value, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdNotLike(String value) {
            addCriterion("create_role_id not like", value, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdIn(List<String> values) {
            addCriterion("create_role_id in", values, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdNotIn(List<String> values) {
            addCriterion("create_role_id not in", values, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdBetween(String value1, String value2) {
            addCriterion("create_role_id between", value1, value2, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIdNotBetween(String value1, String value2) {
            addCriterion("create_role_id not between", value1, value2, "createRoleId");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("data is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("data is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("data =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("data <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("data >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("data >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("data <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("data <=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLike(String value) {
            addCriterion("data like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("data not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("data in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("data not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("data between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("data not between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoIsNull() {
            addCriterion("current_approval_log_no is null");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoIsNotNull() {
            addCriterion("current_approval_log_no is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoEqualTo(String value) {
            addCriterion("current_approval_log_no =", value, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoNotEqualTo(String value) {
            addCriterion("current_approval_log_no <>", value, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoGreaterThan(String value) {
            addCriterion("current_approval_log_no >", value, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoGreaterThanOrEqualTo(String value) {
            addCriterion("current_approval_log_no >=", value, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoLessThan(String value) {
            addCriterion("current_approval_log_no <", value, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoLessThanOrEqualTo(String value) {
            addCriterion("current_approval_log_no <=", value, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoLike(String value) {
            addCriterion("current_approval_log_no like", value, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoNotLike(String value) {
            addCriterion("current_approval_log_no not like", value, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoIn(List<String> values) {
            addCriterion("current_approval_log_no in", values, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoNotIn(List<String> values) {
            addCriterion("current_approval_log_no not in", values, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoBetween(String value1, String value2) {
            addCriterion("current_approval_log_no between", value1, value2, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andCurrentApprovalLogNoNotBetween(String value1, String value2) {
            addCriterion("current_approval_log_no not between", value1, value2, "currentApprovalLogNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoIsNull() {
            addCriterion("approval_order_no is null");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoIsNotNull() {
            addCriterion("approval_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoEqualTo(String value) {
            addCriterion("approval_order_no =", value, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoNotEqualTo(String value) {
            addCriterion("approval_order_no <>", value, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoGreaterThan(String value) {
            addCriterion("approval_order_no >", value, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("approval_order_no >=", value, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoLessThan(String value) {
            addCriterion("approval_order_no <", value, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoLessThanOrEqualTo(String value) {
            addCriterion("approval_order_no <=", value, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoLike(String value) {
            addCriterion("approval_order_no like", value, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoNotLike(String value) {
            addCriterion("approval_order_no not like", value, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoIn(List<String> values) {
            addCriterion("approval_order_no in", values, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoNotIn(List<String> values) {
            addCriterion("approval_order_no not in", values, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoBetween(String value1, String value2) {
            addCriterion("approval_order_no between", value1, value2, "approvalOrderNo");
            return (Criteria) this;
        }

        public Criteria andApprovalOrderNoNotBetween(String value1, String value2) {
            addCriterion("approval_order_no not between", value1, value2, "approvalOrderNo");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andConfigNoIsNull() {
            addCriterion("config_no is null");
            return (Criteria) this;
        }

        public Criteria andConfigNoIsNotNull() {
            addCriterion("config_no is not null");
            return (Criteria) this;
        }

        public Criteria andConfigNoEqualTo(String value) {
            addCriterion("config_no =", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotEqualTo(String value) {
            addCriterion("config_no <>", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoGreaterThan(String value) {
            addCriterion("config_no >", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoGreaterThanOrEqualTo(String value) {
            addCriterion("config_no >=", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLessThan(String value) {
            addCriterion("config_no <", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLessThanOrEqualTo(String value) {
            addCriterion("config_no <=", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLike(String value) {
            addCriterion("config_no like", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotLike(String value) {
            addCriterion("config_no not like", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoIn(List<String> values) {
            addCriterion("config_no in", values, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotIn(List<String> values) {
            addCriterion("config_no not in", values, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoBetween(String value1, String value2) {
            addCriterion("config_no between", value1, value2, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotBetween(String value1, String value2) {
            addCriterion("config_no not between", value1, value2, "configNo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table a_f_instance
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
     * This class corresponds to the database table a_f_instance
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