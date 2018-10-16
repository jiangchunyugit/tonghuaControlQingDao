package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.util.Date;

/**
 * Database Table Remarks:
 *   员工信息
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table employee_msg
 */
public class EmployeeMsg extends BaseModel {
    /**
     * Database Column Remarks:
     *   用户ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * Database Column Remarks:
     *   公司ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   证件号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.certificate
     *
     * @mbg.generated
     */
    private String certificate;

    /**
     * Database Column Remarks:
     *   真实姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.real_name
     *
     * @mbg.generated
     */
    private String realName;

    /**
     * Database Column Remarks:
     *   证件类型，1身份证，2护照
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.certificate_type
     *
     * @mbg.generated
     */
    private Integer certificateType;

    /**
     * Database Column Remarks:
     *   实名认证状态，1未认证，2已认证
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.auth_state
     *
     * @mbg.generated
     */
    private Integer authState;

    /**
     * Database Column Remarks:
     *   角色编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.role_code
     *
     * @mbg.generated
     */
    private String roleCode;

    /**
     * Database Column Remarks:
     *   性别，1男，2女
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.sex
     *
     * @mbg.generated
     */
    private Integer sex;

    /**
     * Database Column Remarks:
     *   所在省份编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.province
     *
     * @mbg.generated
     */
    private String province;

    /**
     * Database Column Remarks:
     *   所在市编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.city
     *
     * @mbg.generated
     */
    private String city;

    /**
     * Database Column Remarks:
     *   所在区编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.area
     *
     * @mbg.generated
     */
    private String area;

    /**
     * Database Column Remarks:
     *   邮箱地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     * Database Column Remarks:
     *   申请时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.apply_time
     *
     * @mbg.generated
     */
    private Date applyTime;

    /**
     * Database Column Remarks:
     *   员工当前状态，1在职，2离职
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.employee_state
     *
     * @mbg.generated
     */
    private Integer employeeState;

    /**
     * Database Column Remarks:
     *   离职时间(解约时间)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.leavedate
     *
     * @mbg.generated
     */
    private Date leavedate;

    /**
     * Database Column Remarks:
     *   绑定时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.bind_date
     *
     * @mbg.generated
     */
    private Date bindDate;

    /**
     * Database Column Remarks:
     *   工作年限
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.working_time
     *
     * @mbg.generated
     */
    private Integer workingTime;

    /**
     * Database Column Remarks:
     *   员工申请状态，1入驻待审核，2入驻不通过，3已入驻，4解约待审核，5解约不通过，6已解约
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee_msg.employee_apply_state
     *
     * @mbg.generated
     */
    private Integer employeeApplyState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.user_id
     *
     * @return the value of employee_msg.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.user_id
     *
     * @param userId the value for employee_msg.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.company_id
     *
     * @return the value of employee_msg.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.company_id
     *
     * @param companyId the value for employee_msg.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.certificate
     *
     * @return the value of employee_msg.certificate
     *
     * @mbg.generated
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.certificate
     *
     * @param certificate the value for employee_msg.certificate
     *
     * @mbg.generated
     */
    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.real_name
     *
     * @return the value of employee_msg.real_name
     *
     * @mbg.generated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.real_name
     *
     * @param realName the value for employee_msg.real_name
     *
     * @mbg.generated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.certificate_type
     *
     * @return the value of employee_msg.certificate_type
     *
     * @mbg.generated
     */
    public Integer getCertificateType() {
        return certificateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.certificate_type
     *
     * @param certificateType the value for employee_msg.certificate_type
     *
     * @mbg.generated
     */
    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.auth_state
     *
     * @return the value of employee_msg.auth_state
     *
     * @mbg.generated
     */
    public Integer getAuthState() {
        return authState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.auth_state
     *
     * @param authState the value for employee_msg.auth_state
     *
     * @mbg.generated
     */
    public void setAuthState(Integer authState) {
        this.authState = authState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.role_code
     *
     * @return the value of employee_msg.role_code
     *
     * @mbg.generated
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.role_code
     *
     * @param roleCode the value for employee_msg.role_code
     *
     * @mbg.generated
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.sex
     *
     * @return the value of employee_msg.sex
     *
     * @mbg.generated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.sex
     *
     * @param sex the value for employee_msg.sex
     *
     * @mbg.generated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.province
     *
     * @return the value of employee_msg.province
     *
     * @mbg.generated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.province
     *
     * @param province the value for employee_msg.province
     *
     * @mbg.generated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.city
     *
     * @return the value of employee_msg.city
     *
     * @mbg.generated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.city
     *
     * @param city the value for employee_msg.city
     *
     * @mbg.generated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.area
     *
     * @return the value of employee_msg.area
     *
     * @mbg.generated
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.area
     *
     * @param area the value for employee_msg.area
     *
     * @mbg.generated
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.email
     *
     * @return the value of employee_msg.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.email
     *
     * @param email the value for employee_msg.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.apply_time
     *
     * @return the value of employee_msg.apply_time
     *
     * @mbg.generated
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.apply_time
     *
     * @param applyTime the value for employee_msg.apply_time
     *
     * @mbg.generated
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.employee_state
     *
     * @return the value of employee_msg.employee_state
     *
     * @mbg.generated
     */
    public Integer getEmployeeState() {
        return employeeState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.employee_state
     *
     * @param employeeState the value for employee_msg.employee_state
     *
     * @mbg.generated
     */
    public void setEmployeeState(Integer employeeState) {
        this.employeeState = employeeState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.leavedate
     *
     * @return the value of employee_msg.leavedate
     *
     * @mbg.generated
     */
    public Date getLeavedate() {
        return leavedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.leavedate
     *
     * @param leavedate the value for employee_msg.leavedate
     *
     * @mbg.generated
     */
    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.bind_date
     *
     * @return the value of employee_msg.bind_date
     *
     * @mbg.generated
     */
    public Date getBindDate() {
        return bindDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.bind_date
     *
     * @param bindDate the value for employee_msg.bind_date
     *
     * @mbg.generated
     */
    public void setBindDate(Date bindDate) {
        this.bindDate = bindDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.working_time
     *
     * @return the value of employee_msg.working_time
     *
     * @mbg.generated
     */
    public Integer getWorkingTime() {
        return workingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.working_time
     *
     * @param workingTime the value for employee_msg.working_time
     *
     * @mbg.generated
     */
    public void setWorkingTime(Integer workingTime) {
        this.workingTime = workingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee_msg.employee_apply_state
     *
     * @return the value of employee_msg.employee_apply_state
     *
     * @mbg.generated
     */
    public Integer getEmployeeApplyState() {
        return employeeApplyState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee_msg.employee_apply_state
     *
     * @param employeeApplyState the value for employee_msg.employee_apply_state
     *
     * @mbg.generated
     */
    public void setEmployeeApplyState(Integer employeeApplyState) {
        this.employeeApplyState = employeeApplyState;
    }
}