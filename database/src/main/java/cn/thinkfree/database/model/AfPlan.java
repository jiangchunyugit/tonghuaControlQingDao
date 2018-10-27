package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table a_f_plan
 */
public class AfPlan extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_f_plan.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   审批流配置记录编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_f_plan.config_log_no
     *
     * @mbg.generated
     */
    private String configLogNo;

    /**
     * Database Column Remarks:
     *   方案编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_f_plan.plan_no
     *
     * @mbg.generated
     */
    private String planNo;

    /**
     * Database Column Remarks:
     *   方案名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column a_f_plan.plan_name
     *
     * @mbg.generated
     */
    private String planName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_f_plan.id
     *
     * @return the value of a_f_plan.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_f_plan.id
     *
     * @param id the value for a_f_plan.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_f_plan.config_log_no
     *
     * @return the value of a_f_plan.config_log_no
     *
     * @mbg.generated
     */
    public String getConfigLogNo() {
        return configLogNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_f_plan.config_log_no
     *
     * @param configLogNo the value for a_f_plan.config_log_no
     *
     * @mbg.generated
     */
    public void setConfigLogNo(String configLogNo) {
        this.configLogNo = configLogNo == null ? null : configLogNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_f_plan.plan_no
     *
     * @return the value of a_f_plan.plan_no
     *
     * @mbg.generated
     */
    public String getPlanNo() {
        return planNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_f_plan.plan_no
     *
     * @param planNo the value for a_f_plan.plan_no
     *
     * @mbg.generated
     */
    public void setPlanNo(String planNo) {
        this.planNo = planNo == null ? null : planNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column a_f_plan.plan_name
     *
     * @return the value of a_f_plan.plan_name
     *
     * @mbg.generated
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column a_f_plan.plan_name
     *
     * @param planName the value for a_f_plan.plan_name
     *
     * @mbg.generated
     */
    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }
}