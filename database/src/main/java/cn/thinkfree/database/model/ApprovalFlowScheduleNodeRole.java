package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table approval_flow_schedule_node_role
 */
public class ApprovalFlowScheduleNodeRole extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_flow_schedule_node_role.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   关联approval_flow_node表中的数据唯一编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_flow_schedule_node_role.node_num
     *
     * @mbg.generated
     */
    private String nodeNum;

    /**
     * Database Column Remarks:
     *   角色编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_flow_schedule_node_role.role_id
     *
     * @mbg.generated
     */
    private String roleId;

    /**
     * Database Column Remarks:
     *   项目节点编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_flow_schedule_node_role.schedule_sort
     *
     * @mbg.generated
     */
    private Integer scheduleSort;

    /**
     * Database Column Remarks:
     *   项目排期版本号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approval_flow_schedule_node_role.schedule_version
     *
     * @mbg.generated
     */
    private Integer scheduleVersion;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_flow_schedule_node_role.id
     *
     * @return the value of approval_flow_schedule_node_role.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_flow_schedule_node_role.id
     *
     * @param id the value for approval_flow_schedule_node_role.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_flow_schedule_node_role.node_num
     *
     * @return the value of approval_flow_schedule_node_role.node_num
     *
     * @mbg.generated
     */
    public String getNodeNum() {
        return nodeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_flow_schedule_node_role.node_num
     *
     * @param nodeNum the value for approval_flow_schedule_node_role.node_num
     *
     * @mbg.generated
     */
    public void setNodeNum(String nodeNum) {
        this.nodeNum = nodeNum == null ? null : nodeNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_flow_schedule_node_role.role_id
     *
     * @return the value of approval_flow_schedule_node_role.role_id
     *
     * @mbg.generated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_flow_schedule_node_role.role_id
     *
     * @param roleId the value for approval_flow_schedule_node_role.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_flow_schedule_node_role.schedule_sort
     *
     * @return the value of approval_flow_schedule_node_role.schedule_sort
     *
     * @mbg.generated
     */
    public Integer getScheduleSort() {
        return scheduleSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_flow_schedule_node_role.schedule_sort
     *
     * @param scheduleSort the value for approval_flow_schedule_node_role.schedule_sort
     *
     * @mbg.generated
     */
    public void setScheduleSort(Integer scheduleSort) {
        this.scheduleSort = scheduleSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approval_flow_schedule_node_role.schedule_version
     *
     * @return the value of approval_flow_schedule_node_role.schedule_version
     *
     * @mbg.generated
     */
    public Integer getScheduleVersion() {
        return scheduleVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approval_flow_schedule_node_role.schedule_version
     *
     * @param scheduleVersion the value for approval_flow_schedule_node_role.schedule_version
     *
     * @mbg.generated
     */
    public void setScheduleVersion(Integer scheduleVersion) {
        this.scheduleVersion = scheduleVersion;
    }
}