package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Database Table Remarks:
 *   项目表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pre_project_guide
 */
@ApiModel(description = "项目引导表")
public class PreProjectGuide extends BaseModel {
    /**
     * Database Column Remarks:
     *   主键id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.id

     */
    @ApiModelProperty("主键")
    private Integer id;

    /**
     * Database Column Remarks:
     *   项目编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.project_no

     */
    @ApiModelProperty("项目编号")
    private String projectNo;

    /**
     * Database Column Remarks:
     *   项目名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.project_name

     */
    @ApiModelProperty("项目名称")
    private String projectName;

    /**
     * Database Column Remarks:
     *   业主姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.customer_name

     */
    @ApiModelProperty("业主姓名")
    private String customerName;

    /**
     * Database Column Remarks:
     *   业主电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.customer_phone

     */
    @ApiModelProperty("业主电话")
    private String customerPhone;

    /**
     * Database Column Remarks:
     *   业主编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.customer_no

     */
    @ApiModelProperty("业主编号")
    private String customerNo;

    /**
     * Database Column Remarks:
     *   合同编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.contract_no

     */
    @ApiModelProperty("合同编号")
    private String contractNo;

    /**
     * Database Column Remarks:
     *   合同开始时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.contract_starttime

     */
    @ApiModelProperty("合同开始时间")
    private Date contractStarttime;

    /**
     * Database Column Remarks:
     *   合同结束时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.contract_endtime

     */
    @ApiModelProperty("合同结束时间")
    private Date contractEndtime;

    /**
     * Database Column Remarks:
     *   项目开始时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.project_starttime

     */
    @ApiModelProperty("项目开始时间")
    private Date projectStarttime;

    /**
     * Database Column Remarks:
     *   省
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.province

     */
    @ApiModelProperty("省")
    private String province;

    /**
     * Database Column Remarks:
     *   市
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.city

     */
    @ApiModelProperty("市")
    private String city;

    /**
     * Database Column Remarks:
     *   区
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.area

     */
    @ApiModelProperty("区")
    private String area;

    /**
     * Database Column Remarks:
     *   详细地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.address

     */
    @ApiModelProperty("详细地址")
    private String address;

    /**
     * Database Column Remarks:
     *   经度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.longitude

     */
    @ApiModelProperty("经度")
    @NotBlank(message = "经度不能为空")
    private String longitude;

    /**
     * Database Column Remarks:
     *   纬度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.latitude

     */
    @ApiModelProperty("纬度")
    @NotBlank(message = "纬度不能为空")
    private String latitude;

    /**
     * Database Column Remarks:
     *   修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.update_time

     */
    @ApiModelProperty("修改时间")
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   是否删除 0未删除 1已经删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.is_delete

     */
    @ApiModelProperty("是否删除")
    private Short isDelete;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.create_time

     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * Database Column Remarks:
     *   施工项目总费用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.total_price

     */
    @ApiModelProperty("施工项目总费用")
    private BigDecimal totalPrice;

    /**
     * Database Column Remarks:
     *   逾期天数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.overdue_days

     */
    @ApiModelProperty("逾期天数")
    private Short overdueDays;

    /**
     * Database Column Remarks:
     *   进度阶段
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.progress_stage

     */
    @ApiModelProperty("进度阶段")
    private Short progressStage;

    /**
     * Database Column Remarks:
     *   验收阶段
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.acceptance_stage

     */
    @ApiModelProperty("验收阶段")
    private Short acceptanceStage;

    /**
     * Database Column Remarks:
     *   是否验收
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.is_acceptance

     */
    @ApiModelProperty("是否验收")
    private Short isAcceptance;

    /**
     * Database Column Remarks:
     *   项目状态 0未上线、1未开始(订单)、2在建、3完工、4停工 
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.status

     */
    @ApiModelProperty("项目状态 0未上线  1未开始 2 在建 3 完工 4 停工")
    private Short status;

    /**
     * Database Column Remarks:
     *   项目图片url
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.project_pic

     */
    @ApiModelProperty("项目缩略图")
    private String projectPic;

    /**
     * Database Column Remarks:
     *   项目结束时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pre_project_guide.project_endtime

     */
    @ApiModelProperty("项目结束时间")
    private Date projectEndtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.id
     *
     * @return the value of pre_project_guide.id

     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.id
     *
     * @param id the value for pre_project_guide.id

     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.project_no
     *
     * @return the value of pre_project_guide.project_no

     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.project_no
     *
     * @param projectNo the value for pre_project_guide.project_no

     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.project_name
     *
     * @return the value of pre_project_guide.project_name

     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.project_name
     *
     * @param projectName the value for pre_project_guide.project_name

     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.customer_name
     *
     * @return the value of pre_project_guide.customer_name

     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.customer_name
     *
     * @param customerName the value for pre_project_guide.customer_name

     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.customer_phone
     *
     * @return the value of pre_project_guide.customer_phone

     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.customer_phone
     *
     * @param customerPhone the value for pre_project_guide.customer_phone

     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.customer_no
     *
     * @return the value of pre_project_guide.customer_no

     */
    public String getCustomerNo() {
        return customerNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.customer_no
     *
     * @param customerNo the value for pre_project_guide.customer_no

     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.contract_no
     *
     * @return the value of pre_project_guide.contract_no

     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.contract_no
     *
     * @param contractNo the value for pre_project_guide.contract_no

     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.contract_starttime
     *
     * @return the value of pre_project_guide.contract_starttime

     */
    public Date getContractStarttime() {
        return contractStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.contract_starttime
     *
     * @param contractStarttime the value for pre_project_guide.contract_starttime

     */
    public void setContractStarttime(Date contractStarttime) {
        this.contractStarttime = contractStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.contract_endtime
     *
     * @return the value of pre_project_guide.contract_endtime

     */
    public Date getContractEndtime() {
        return contractEndtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.contract_endtime
     *
     * @param contractEndtime the value for pre_project_guide.contract_endtime

     */
    public void setContractEndtime(Date contractEndtime) {
        this.contractEndtime = contractEndtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.project_starttime
     *
     * @return the value of pre_project_guide.project_starttime

     */
    public Date getProjectStarttime() {
        return projectStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.project_starttime
     *
     * @param projectStarttime the value for pre_project_guide.project_starttime

     */
    public void setProjectStarttime(Date projectStarttime) {
        this.projectStarttime = projectStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.province
     *
     * @return the value of pre_project_guide.province

     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.province
     *
     * @param province the value for pre_project_guide.province

     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.city
     *
     * @return the value of pre_project_guide.city

     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.city
     *
     * @param city the value for pre_project_guide.city

     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.area
     *
     * @return the value of pre_project_guide.area

     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.area
     *
     * @param area the value for pre_project_guide.area

     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.address
     *
     * @return the value of pre_project_guide.address

     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.address
     *
     * @param address the value for pre_project_guide.address

     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.longitude
     *
     * @return the value of pre_project_guide.longitude

     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.longitude
     *
     * @param longitude the value for pre_project_guide.longitude

     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.latitude
     *
     * @return the value of pre_project_guide.latitude

     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.latitude
     *
     * @param latitude the value for pre_project_guide.latitude

     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.update_time
     *
     * @return the value of pre_project_guide.update_time

     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.update_time
     *
     * @param updateTime the value for pre_project_guide.update_time

     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.is_delete
     *
     * @return the value of pre_project_guide.is_delete

     */
    public Short getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.is_delete
     *
     * @param isDelete the value for pre_project_guide.is_delete

     */
    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.create_time
     *
     * @return the value of pre_project_guide.create_time

     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.create_time
     *
     * @param createTime the value for pre_project_guide.create_time

     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.total_price
     *
     * @return the value of pre_project_guide.total_price

     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.total_price
     *
     * @param totalPrice the value for pre_project_guide.total_price

     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.overdue_days
     *
     * @return the value of pre_project_guide.overdue_days

     */
    public Short getOverdueDays() {
        return overdueDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.overdue_days
     *
     * @param overdueDays the value for pre_project_guide.overdue_days

     */
    public void setOverdueDays(Short overdueDays) {
        this.overdueDays = overdueDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.progress_stage
     *
     * @return the value of pre_project_guide.progress_stage

     */
    public Short getProgressStage() {
        return progressStage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.progress_stage
     *
     * @param progressStage the value for pre_project_guide.progress_stage

     */
    public void setProgressStage(Short progressStage) {
        this.progressStage = progressStage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.acceptance_stage
     *
     * @return the value of pre_project_guide.acceptance_stage

     */
    public Short getAcceptanceStage() {
        return acceptanceStage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.acceptance_stage
     *
     * @param acceptanceStage the value for pre_project_guide.acceptance_stage

     */
    public void setAcceptanceStage(Short acceptanceStage) {
        this.acceptanceStage = acceptanceStage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.is_acceptance
     *
     * @return the value of pre_project_guide.is_acceptance

     */
    public Short getIsAcceptance() {
        return isAcceptance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.is_acceptance
     *
     * @param isAcceptance the value for pre_project_guide.is_acceptance

     */
    public void setIsAcceptance(Short isAcceptance) {
        this.isAcceptance = isAcceptance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.status
     *
     * @return the value of pre_project_guide.status

     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.status
     *
     * @param status the value for pre_project_guide.status

     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.project_pic
     *
     * @return the value of pre_project_guide.project_pic

     */
    public String getProjectPic() {
        return projectPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.project_pic
     *
     * @param projectPic the value for pre_project_guide.project_pic

     */
    public void setProjectPic(String projectPic) {
        this.projectPic = projectPic == null ? null : projectPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pre_project_guide.project_endtime
     *
     * @return the value of pre_project_guide.project_endtime

     */
    public Date getProjectEndtime() {
        return projectEndtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pre_project_guide.project_endtime
     *
     * @param projectEndtime the value for pre_project_guide.project_endtime

     */
    public void setProjectEndtime(Date projectEndtime) {
        this.projectEndtime = projectEndtime;
    }
}