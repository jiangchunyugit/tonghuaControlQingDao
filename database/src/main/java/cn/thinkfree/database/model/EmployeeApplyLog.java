package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.util.Date;

/**
 * Database Table Remarks:
 *   员工申请记录表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table employee_apply_log
 */
public class EmployeeApplyLog extends BaseModel {
    /**
     * Database Column Remarks:
     *   用户ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * Database Column Remarks:
     *   申请时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.apply_time
     *
     * @mbg.generated
     */
    private Date applyTime;

    /**
     * Database Column Remarks:
     *   处理状态，1已处理，2未处理，3已过期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.deal_state
     *
     * @mbg.generated
     */
    private Integer dealState;

    /**
     * Database Column Remarks:
     *   处理时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.deal_time
     *
     * @mbg.generated
     */
    private Date dealTime;

    /**
     * Database Column Remarks:
     *   处理结果
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.deal_explain
     *
     * @mbg.generated
     */
    private String dealExplain;

    /**
     * Database Column Remarks:
     *   处理人ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.deal_user_id
     *
     * @mbg.generated
     */
    private String dealUserId;

    /**
     * Database Column Remarks:
     *   关联公司ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   失效时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.invalid_time
     *
     * @mbg.generated
     */
    private Date invalidTime;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_apply_log.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.user_id
     *
     * @return the value of employee_apply_log.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.user_id
     *
     * @param userId the value for employee_apply_log.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.apply_time
     *
     * @return the value of employee_apply_log.apply_time
     *
     * @mbg.generated
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.apply_time
     *
     * @param applyTime the value for employee_apply_log.apply_time
     *
     * @mbg.generated
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.deal_state
     *
     * @return the value of employee_apply_log.deal_state
     *
     * @mbg.generated
     */
    public Integer getDealState() {
        return dealState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.deal_state
     *
     * @param dealState the value for employee_apply_log.deal_state
     *
     * @mbg.generated
     */
    public void setDealState(Integer dealState) {
        this.dealState = dealState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.deal_time
     *
     * @return the value of employee_apply_log.deal_time
     *
     * @mbg.generated
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.deal_time
     *
     * @param dealTime the value for employee_apply_log.deal_time
     *
     * @mbg.generated
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.deal_explain
     *
     * @return the value of employee_apply_log.deal_explain
     *
     * @mbg.generated
     */
    public String getDealExplain() {
        return dealExplain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.deal_explain
     *
     * @param dealExplain the value for employee_apply_log.deal_explain
     *
     * @mbg.generated
     */
    public void setDealExplain(String dealExplain) {
        this.dealExplain = dealExplain == null ? null : dealExplain.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.deal_user_id
     *
     * @return the value of employee_apply_log.deal_user_id
     *
     * @mbg.generated
     */
    public String getDealUserId() {
        return dealUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.deal_user_id
     *
     * @param dealUserId the value for employee_apply_log.deal_user_id
     *
     * @mbg.generated
     */
    public void setDealUserId(String dealUserId) {
        this.dealUserId = dealUserId == null ? null : dealUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.company_id
     *
     * @return the value of employee_apply_log.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.company_id
     *
     * @param companyId the value for employee_apply_log.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.invalid_time
     *
     * @return the value of employee_apply_log.invalid_time
     *
     * @mbg.generated
     */
    public Date getInvalidTime() {
        return invalidTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.invalid_time
     *
     * @param invalidTime the value for employee_apply_log.invalid_time
     *
     * @mbg.generated
     */
    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_apply_log.remark
     *
     * @return the value of employee_apply_log.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_apply_log.remark
     *
     * @param remark the value for employee_apply_log.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}