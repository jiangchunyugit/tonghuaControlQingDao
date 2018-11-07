package cn.thinkfree.database.model;

import java.util.Date;


/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_contract_template
 */



import cn.thinkfree.core.model.BaseModel;

public class ContractTemplate extends BaseModel {
    /**
     * Database Column Remarks:
     *   主键id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.id

     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   合同类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.contract_tp_type

     */
    private String contractTpType;

    /**
     * Database Column Remarks:
     *   合同名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.contract_tp_name

     */
    private String contractTpName;

    /**
     * Database Column Remarks:
     *   合同备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.contract_tp_remark

     */
    private String contractTpRemark;

    /**
     * Database Column Remarks:
     *   上传时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.upload_time 

     */
    private Date uploadTime;

    /**
     * Database Column Remarks:
     *   附件url
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.upload_url

     */
    private String uploadUrl;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.create_time

     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.update_time

     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   保证金
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.contract_deposit

     */
    private String contractDeposit;

    /**
     * Database Column Remarks:
     *   付款模式 （存字典id）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.payment_type

     */

    private String paymentType;

    /**
     * Database Column Remarks:
     *   0可用1不可用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.contract_status

     */
    private String contractStatus;

    /**
     * Database Column Remarks:
     *   pdf url
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_template.pdf_url

     */
    private String pdfUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.id
     *
     * @return the value of pc_contract_template.id

     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.id
     *
     * @param id the value for pc_contract_template.id

     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.contract_tp_type
     *
     * @return the value of pc_contract_template.contract_tp_type

     */
    public String getContractTpType() {
        return contractTpType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.contract_tp_type
     *
     * @param contractTpType the value for pc_contract_template.contract_tp_type

     */
    public void setContractTpType(String contractTpType) {
        this.contractTpType = contractTpType == null ? null : contractTpType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.contract_tp_name
     *
     * @return the value of pc_contract_template.contract_tp_name

     */
    public String getContractTpName() {
        return contractTpName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.contract_tp_name
     *
     * @param contractTpName the value for pc_contract_template.contract_tp_name

     */
    public void setContractTpName(String contractTpName) {
        this.contractTpName = contractTpName == null ? null : contractTpName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.contract_tp_remark
     *
     * @return the value of pc_contract_template.contract_tp_remark

     */
    public String getContractTpRemark() {
        return contractTpRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.contract_tp_remark
     *
     * @param contractTpRemark the value for pc_contract_template.contract_tp_remark

     */
    public void setContractTpRemark(String contractTpRemark) {
        this.contractTpRemark = contractTpRemark == null ? null : contractTpRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.upload_time 
     *
     * @return the value of pc_contract_template.upload_time 

     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.upload_time 
     *
     * @param uploadTime the value for pc_contract_template.upload_time 

     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.upload_url
     *
     * @return the value of pc_contract_template.upload_url

     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.upload_url
     *
     * @param uploadUrl the value for pc_contract_template.upload_url

     */
    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl == null ? null : uploadUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.create_time
     *
     * @return the value of pc_contract_template.create_time

     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.create_time
     *
     * @param createTime the value for pc_contract_template.create_time

     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.update_time
     *
     * @return the value of pc_contract_template.update_time

     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.update_time
     *
     * @param updateTime the value for pc_contract_template.update_time

     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.contract_deposit
     *
     * @return the value of pc_contract_template.contract_deposit

     */
    public String getContractDeposit() {
        return contractDeposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.contract_deposit
     *
     * @param contractDeposit the value for pc_contract_template.contract_deposit

     */
    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit == null ? null : contractDeposit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.payment_type
     *
     * @return the value of pc_contract_template.payment_type

     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.payment_type
     *
     * @param paymentType the value for pc_contract_template.payment_type

     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.contract_status
     *
     * @return the value of pc_contract_template.contract_status

     */
    public String getContractStatus() {
        return contractStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.contract_status
     *
     * @param contractStatus the value for pc_contract_template.contract_status

     */
    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus == null ? null : contractStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_template.pdf_url
     *
     * @return the value of pc_contract_template.pdf_url

     */
    public String getPdfUrl() {
        return pdfUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_template.pdf_url
     *
     * @param pdfUrl the value for pc_contract_template.pdf_url

     */
    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl == null ? null : pdfUrl.trim();
    }
}