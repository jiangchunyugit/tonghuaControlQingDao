package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_company_user_role
 */
public class CompanyUserRole extends BaseModel {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_company_user_role.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   入驻角色id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_company_user_role.role_id
     *
     * @mbg.generated
     */
    private String roleId;

    /**
     * Database Column Remarks:
     *   入驻用户id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_company_user_role.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_company_user_role.id
     *
     * @return the value of pc_company_user_role.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_company_user_role.id
     *
     * @param id the value for pc_company_user_role.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_company_user_role.role_id
     *
     * @return the value of pc_company_user_role.role_id
     *
     * @mbg.generated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_company_user_role.role_id
     *
     * @param roleId the value for pc_company_user_role.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_company_user_role.user_id
     *
     * @return the value of pc_company_user_role.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_company_user_role.user_id
     *
     * @param userId the value for pc_company_user_role.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}