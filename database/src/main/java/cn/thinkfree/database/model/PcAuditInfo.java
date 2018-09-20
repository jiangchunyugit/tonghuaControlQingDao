package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_audit_info
 */
public class PcAuditInfo extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   审核类型0入驻 1合同 2变更 3续签
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.audit_type
     *
     * @mbg.generated
     */
    private String auditType;

    /**
     * Database Column Remarks:
     *   审核级别0初次审核1二级审核
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.audit_level
     *
     * @mbg.generated
     */
    private String auditLevel;

    /**
     * Database Column Remarks:
     *   审核人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.audit_persion
     *
     * @mbg.generated
     */
    private String auditPersion;

    /**
     * Database Column Remarks:
     *   审核状态 0通过1不通过
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.audit_status
     *
     * @mbg.generated
     */
    private String auditStatus;

    /**
     * Database Column Remarks:
     *   审核时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.audit_time
     *
     * @mbg.generated
     */
    private Date auditTime;

    /**
     * Database Column Remarks:
     *   公司编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   审核成功或者失败的原因
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.audit_case
     *
     * @mbg.generated
     */
    private String auditCase;

    /**
     * Database Column Remarks:
     *   合同编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.contract_number
     *
     * @mbg.generated
     */
    private String contractNumber;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_audit_info.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.id
     *
     * @return the value of pc_audit_info.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.id
     *
     * @param id the value for pc_audit_info.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.audit_type
     *
     * @return the value of pc_audit_info.audit_type
     *
     * @mbg.generated
     */
    public String getAuditType() {
        return auditType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.audit_type
     *
     * @param auditType the value for pc_audit_info.audit_type
     *
     * @mbg.generated
     */
    public void setAuditType(String auditType) {
        this.auditType = auditType == null ? null : auditType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.audit_level
     *
     * @return the value of pc_audit_info.audit_level
     *
     * @mbg.generated
     */
    public String getAuditLevel() {
        return auditLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.audit_level
     *
     * @param auditLevel the value for pc_audit_info.audit_level
     *
     * @mbg.generated
     */
    public void setAuditLevel(String auditLevel) {
        this.auditLevel = auditLevel == null ? null : auditLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.audit_persion
     *
     * @return the value of pc_audit_info.audit_persion
     *
     * @mbg.generated
     */
    public String getAuditPersion() {
        return auditPersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.audit_persion
     *
     * @param auditPersion the value for pc_audit_info.audit_persion
     *
     * @mbg.generated
     */
    public void setAuditPersion(String auditPersion) {
        this.auditPersion = auditPersion == null ? null : auditPersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.audit_status
     *
     * @return the value of pc_audit_info.audit_status
     *
     * @mbg.generated
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.audit_status
     *
     * @param auditStatus the value for pc_audit_info.audit_status
     *
     * @mbg.generated
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.audit_time
     *
     * @return the value of pc_audit_info.audit_time
     *
     * @mbg.generated
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.audit_time
     *
     * @param auditTime the value for pc_audit_info.audit_time
     *
     * @mbg.generated
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.company_id
     *
     * @return the value of pc_audit_info.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.company_id
     *
     * @param companyId the value for pc_audit_info.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.audit_case
     *
     * @return the value of pc_audit_info.audit_case
     *
     * @mbg.generated
     */
    public String getAuditCase() {
        return auditCase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.audit_case
     *
     * @param auditCase the value for pc_audit_info.audit_case
     *
     * @mbg.generated
     */
    public void setAuditCase(String auditCase) {
        this.auditCase = auditCase == null ? null : auditCase.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.contract_number
     *
     * @return the value of pc_audit_info.contract_number
     *
     * @mbg.generated
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.contract_number
     *
     * @param contractNumber the value for pc_audit_info.contract_number
     *
     * @mbg.generated
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_audit_info.create_time
     *
     * @return the value of pc_audit_info.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_audit_info.create_time
     *
     * @param createTime the value for pc_audit_info.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}