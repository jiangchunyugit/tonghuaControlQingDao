package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table approval_check_data_log
 */
public class ApprovalCheckData extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.node_num
     *
     * @mbg.generated
     */
    private String nodeNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.check_num
     *
     * @mbg.generated
     */
    private String checkNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.check_state_num
     *
     * @mbg.generated
     */
    private String checkStateNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.check_state_name
     *
     * @mbg.generated
     */
    private String checkStateName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.count_num
     *
     * @mbg.generated
     */
    private String countNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.create_log_num
     *
     * @mbg.generated
     */
    private String createLogNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.not_check_num
     *
     * @mbg.generated
     */
    private String notCheckNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.pass_state
     *
     * @mbg.generated
     */
    private Integer passState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.project_no
     *
     * @mbg.generated
     */
    private String projectNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.rectification_num
     *
     * @mbg.generated
     */
    private String rectificationNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_check_data_log.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.id
     *
     * @return the value of approval_check_data_log.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.id
     *
     * @param id the value for approval_check_data_log.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.node_num
     *
     * @return the value of approval_check_data_log.node_num
     *
     * @mbg.generated
     */
    public String getNodeNum() {
        return nodeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.node_num
     *
     * @param nodeNum the value for approval_check_data_log.node_num
     *
     * @mbg.generated
     */
    public void setNodeNum(String nodeNum) {
        this.nodeNum = nodeNum == null ? null : nodeNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.check_num
     *
     * @return the value of approval_check_data_log.check_num
     *
     * @mbg.generated
     */
    public String getCheckNum() {
        return checkNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.check_num
     *
     * @param checkNum the value for approval_check_data_log.check_num
     *
     * @mbg.generated
     */
    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum == null ? null : checkNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.check_state_num
     *
     * @return the value of approval_check_data_log.check_state_num
     *
     * @mbg.generated
     */
    public String getCheckStateNum() {
        return checkStateNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.check_state_num
     *
     * @param checkStateNum the value for approval_check_data_log.check_state_num
     *
     * @mbg.generated
     */
    public void setCheckStateNum(String checkStateNum) {
        this.checkStateNum = checkStateNum == null ? null : checkStateNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.check_state_name
     *
     * @return the value of approval_check_data_log.check_state_name
     *
     * @mbg.generated
     */
    public String getCheckStateName() {
        return checkStateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.check_state_name
     *
     * @param checkStateName the value for approval_check_data_log.check_state_name
     *
     * @mbg.generated
     */
    public void setCheckStateName(String checkStateName) {
        this.checkStateName = checkStateName == null ? null : checkStateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.count_num
     *
     * @return the value of approval_check_data_log.count_num
     *
     * @mbg.generated
     */
    public String getCountNum() {
        return countNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.count_num
     *
     * @param countNum the value for approval_check_data_log.count_num
     *
     * @mbg.generated
     */
    public void setCountNum(String countNum) {
        this.countNum = countNum == null ? null : countNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.create_log_num
     *
     * @return the value of approval_check_data_log.create_log_num
     *
     * @mbg.generated
     */
    public String getCreateLogNum() {
        return createLogNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.create_log_num
     *
     * @param createLogNum the value for approval_check_data_log.create_log_num
     *
     * @mbg.generated
     */
    public void setCreateLogNum(String createLogNum) {
        this.createLogNum = createLogNum == null ? null : createLogNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.create_time
     *
     * @return the value of approval_check_data_log.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.create_time
     *
     * @param createTime the value for approval_check_data_log.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.not_check_num
     *
     * @return the value of approval_check_data_log.not_check_num
     *
     * @mbg.generated
     */
    public String getNotCheckNum() {
        return notCheckNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.not_check_num
     *
     * @param notCheckNum the value for approval_check_data_log.not_check_num
     *
     * @mbg.generated
     */
    public void setNotCheckNum(String notCheckNum) {
        this.notCheckNum = notCheckNum == null ? null : notCheckNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.pass_state
     *
     * @return the value of approval_check_data_log.pass_state
     *
     * @mbg.generated
     */
    public Integer getPassState() {
        return passState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.pass_state
     *
     * @param passState the value for approval_check_data_log.pass_state
     *
     * @mbg.generated
     */
    public void setPassState(Integer passState) {
        this.passState = passState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.project_no
     *
     * @return the value of approval_check_data_log.project_no
     *
     * @mbg.generated
     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.project_no
     *
     * @param projectNo the value for approval_check_data_log.project_no
     *
     * @mbg.generated
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.rectification_num
     *
     * @return the value of approval_check_data_log.rectification_num
     *
     * @mbg.generated
     */
    public String getRectificationNum() {
        return rectificationNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.rectification_num
     *
     * @param rectificationNum the value for approval_check_data_log.rectification_num
     *
     * @mbg.generated
     */
    public void setRectificationNum(String rectificationNum) {
        this.rectificationNum = rectificationNum == null ? null : rectificationNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.remark
     *
     * @return the value of approval_check_data_log.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.remark
     *
     * @param remark the value for approval_check_data_log.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.type
     *
     * @return the value of approval_check_data_log.type
     *
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.type
     *
     * @param type the value for approval_check_data_log.type
     *
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.user_id
     *
     * @return the value of approval_check_data_log.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.user_id
     *
     * @param userId the value for approval_check_data_log.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_check_data_log.user_name
     *
     * @return the value of approval_check_data_log.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_check_data_log.user_name
     *
     * @param userName the value for approval_check_data_log.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}