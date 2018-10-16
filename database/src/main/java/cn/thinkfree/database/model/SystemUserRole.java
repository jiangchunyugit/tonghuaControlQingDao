package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

/**
 * Database Table Remarks:
 *   后台_用户角色表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_system_user_role
 */
public class SystemUserRole extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_system_user_role.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   角色id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_system_user_role.role_id
     *
     * @mbg.generated
     */
    private Integer roleId;

    /**
     * Database Column Remarks:
     *   用户主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_system_user_role.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_system_user_role.id
     *
     * @return the value of pc_system_user_role.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_system_user_role.id
     *
     * @param id the value for pc_system_user_role.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_system_user_role.role_id
     *
     * @return the value of pc_system_user_role.role_id
     *
     * @mbg.generated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_system_user_role.role_id
     *
     * @param roleId the value for pc_system_user_role.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_system_user_role.user_id
     *
     * @return the value of pc_system_user_role.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_system_user_role.user_id
     *
     * @param userId the value for pc_system_user_role.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}