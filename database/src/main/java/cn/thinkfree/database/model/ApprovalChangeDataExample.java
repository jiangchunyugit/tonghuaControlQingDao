package cn.thinkfree.database.model;

import java.util.ArrayList;
import java.util.List;

public class ApprovalChangeDataExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    public ApprovalChangeDataExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
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
     * This method corresponds to the database table approval_change_data
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
     * This method corresponds to the database table approval_change_data
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_change_data
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
     * This class corresponds to the database table approval_change_data
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

        public Criteria andNodeNumIsNull() {
            addCriterion("node_num is null");
            return (Criteria) this;
        }

        public Criteria andNodeNumIsNotNull() {
            addCriterion("node_num is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNumEqualTo(String value) {
            addCriterion("node_num =", value, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumNotEqualTo(String value) {
            addCriterion("node_num <>", value, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumGreaterThan(String value) {
            addCriterion("node_num >", value, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumGreaterThanOrEqualTo(String value) {
            addCriterion("node_num >=", value, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumLessThan(String value) {
            addCriterion("node_num <", value, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumLessThanOrEqualTo(String value) {
            addCriterion("node_num <=", value, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumLike(String value) {
            addCriterion("node_num like", value, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumNotLike(String value) {
            addCriterion("node_num not like", value, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumIn(List<String> values) {
            addCriterion("node_num in", values, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumNotIn(List<String> values) {
            addCriterion("node_num not in", values, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumBetween(String value1, String value2) {
            addCriterion("node_num between", value1, value2, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andNodeNumNotBetween(String value1, String value2) {
            addCriterion("node_num not between", value1, value2, "nodeNum");
            return (Criteria) this;
        }

        public Criteria andChangeConIsNull() {
            addCriterion("change_con is null");
            return (Criteria) this;
        }

        public Criteria andChangeConIsNotNull() {
            addCriterion("change_con is not null");
            return (Criteria) this;
        }

        public Criteria andChangeConEqualTo(String value) {
            addCriterion("change_con =", value, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConNotEqualTo(String value) {
            addCriterion("change_con <>", value, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConGreaterThan(String value) {
            addCriterion("change_con >", value, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConGreaterThanOrEqualTo(String value) {
            addCriterion("change_con >=", value, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConLessThan(String value) {
            addCriterion("change_con <", value, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConLessThanOrEqualTo(String value) {
            addCriterion("change_con <=", value, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConLike(String value) {
            addCriterion("change_con like", value, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConNotLike(String value) {
            addCriterion("change_con not like", value, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConIn(List<String> values) {
            addCriterion("change_con in", values, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConNotIn(List<String> values) {
            addCriterion("change_con not in", values, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConBetween(String value1, String value2) {
            addCriterion("change_con between", value1, value2, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeConNotBetween(String value1, String value2) {
            addCriterion("change_con not between", value1, value2, "changeCon");
            return (Criteria) this;
        }

        public Criteria andChangeDesIsNull() {
            addCriterion("change_des is null");
            return (Criteria) this;
        }

        public Criteria andChangeDesIsNotNull() {
            addCriterion("change_des is not null");
            return (Criteria) this;
        }

        public Criteria andChangeDesEqualTo(String value) {
            addCriterion("change_des =", value, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesNotEqualTo(String value) {
            addCriterion("change_des <>", value, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesGreaterThan(String value) {
            addCriterion("change_des >", value, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesGreaterThanOrEqualTo(String value) {
            addCriterion("change_des >=", value, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesLessThan(String value) {
            addCriterion("change_des <", value, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesLessThanOrEqualTo(String value) {
            addCriterion("change_des <=", value, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesLike(String value) {
            addCriterion("change_des like", value, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesNotLike(String value) {
            addCriterion("change_des not like", value, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesIn(List<String> values) {
            addCriterion("change_des in", values, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesNotIn(List<String> values) {
            addCriterion("change_des not in", values, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesBetween(String value1, String value2) {
            addCriterion("change_des between", value1, value2, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeDesNotBetween(String value1, String value2) {
            addCriterion("change_des not between", value1, value2, "changeDes");
            return (Criteria) this;
        }

        public Criteria andChangeRequireIsNull() {
            addCriterion("change_require is null");
            return (Criteria) this;
        }

        public Criteria andChangeRequireIsNotNull() {
            addCriterion("change_require is not null");
            return (Criteria) this;
        }

        public Criteria andChangeRequireEqualTo(String value) {
            addCriterion("change_require =", value, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireNotEqualTo(String value) {
            addCriterion("change_require <>", value, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireGreaterThan(String value) {
            addCriterion("change_require >", value, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireGreaterThanOrEqualTo(String value) {
            addCriterion("change_require >=", value, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireLessThan(String value) {
            addCriterion("change_require <", value, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireLessThanOrEqualTo(String value) {
            addCriterion("change_require <=", value, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireLike(String value) {
            addCriterion("change_require like", value, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireNotLike(String value) {
            addCriterion("change_require not like", value, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireIn(List<String> values) {
            addCriterion("change_require in", values, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireNotIn(List<String> values) {
            addCriterion("change_require not in", values, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireBetween(String value1, String value2) {
            addCriterion("change_require between", value1, value2, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andChangeRequireNotBetween(String value1, String value2) {
            addCriterion("change_require not between", value1, value2, "changeRequire");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumIsNull() {
            addCriterion("create_log_num is null");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumIsNotNull() {
            addCriterion("create_log_num is not null");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumEqualTo(String value) {
            addCriterion("create_log_num =", value, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumNotEqualTo(String value) {
            addCriterion("create_log_num <>", value, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumGreaterThan(String value) {
            addCriterion("create_log_num >", value, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumGreaterThanOrEqualTo(String value) {
            addCriterion("create_log_num >=", value, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumLessThan(String value) {
            addCriterion("create_log_num <", value, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumLessThanOrEqualTo(String value) {
            addCriterion("create_log_num <=", value, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumLike(String value) {
            addCriterion("create_log_num like", value, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumNotLike(String value) {
            addCriterion("create_log_num not like", value, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumIn(List<String> values) {
            addCriterion("create_log_num in", values, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumNotIn(List<String> values) {
            addCriterion("create_log_num not in", values, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumBetween(String value1, String value2) {
            addCriterion("create_log_num between", value1, value2, "createLogNum");
            return (Criteria) this;
        }

        public Criteria andCreateLogNumNotBetween(String value1, String value2) {
            addCriterion("create_log_num not between", value1, value2, "createLogNum");
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

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table approval_change_data
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
     * This class corresponds to the database table approval_change_data
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