package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.math.BigDecimal;

/**
 * Database Table Remarks:
 *   项目报价单房间基础施工项详情表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table project_quotation_rooms_construct
 */
public class ProjectQuotationRoomsConstruct extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   客户报价
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.customer_price
     *
     * @mbg.generated
     */
    private BigDecimal customerPrice;

    /**
     * Database Column Remarks:
     *   工长报价
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.foreman_price
     *
     * @mbg.generated
     */
    private BigDecimal foremanPrice;

    /**
     * Database Column Remarks:
     *   单价
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.unit_price
     *
     * @mbg.generated
     */
    private BigDecimal unitPrice;

    /**
     * Database Column Remarks:
     *   施工项id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.construct_id
     *
     * @mbg.generated
     */
    private String constructId;

    /**
     * Database Column Remarks:
     *   施工项编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.construct_code
     *
     * @mbg.generated
     */
    private String constructCode;

    /**
     * Database Column Remarks:
     *   施工项名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.construct_name
     *
     * @mbg.generated
     */
    private String constructName;

    /**
     * Database Column Remarks:
     *   使用量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.used_quantity
     *
     * @mbg.generated
     */
    private Integer usedQuantity;

    /**
     * Database Column Remarks:
     *   限量值
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.limits
     *
     * @mbg.generated
     */
    private Integer limits;

    /**
     * Database Column Remarks:
     *   状态(1,有效 2,失效)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   房间类型,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.room_type
     *
     * @mbg.generated
     */
    private String roomType;

    /**
     * Database Column Remarks:
     *   项目编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms_construct.project_no
     *
     * @mbg.generated
     */
    private String projectNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.id
     *
     * @return the value of project_quotation_rooms_construct.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.id
     *
     * @param id the value for project_quotation_rooms_construct.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.customer_price
     *
     * @return the value of project_quotation_rooms_construct.customer_price
     *
     * @mbg.generated
     */
    public BigDecimal getCustomerPrice() {
        return customerPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.customer_price
     *
     * @param customerPrice the value for project_quotation_rooms_construct.customer_price
     *
     * @mbg.generated
     */
    public void setCustomerPrice(BigDecimal customerPrice) {
        this.customerPrice = customerPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.foreman_price
     *
     * @return the value of project_quotation_rooms_construct.foreman_price
     *
     * @mbg.generated
     */
    public BigDecimal getForemanPrice() {
        return foremanPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.foreman_price
     *
     * @param foremanPrice the value for project_quotation_rooms_construct.foreman_price
     *
     * @mbg.generated
     */
    public void setForemanPrice(BigDecimal foremanPrice) {
        this.foremanPrice = foremanPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.unit_price
     *
     * @return the value of project_quotation_rooms_construct.unit_price
     *
     * @mbg.generated
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.unit_price
     *
     * @param unitPrice the value for project_quotation_rooms_construct.unit_price
     *
     * @mbg.generated
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.construct_id
     *
     * @return the value of project_quotation_rooms_construct.construct_id
     *
     * @mbg.generated
     */
    public String getConstructId() {
        return constructId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.construct_id
     *
     * @param constructId the value for project_quotation_rooms_construct.construct_id
     *
     * @mbg.generated
     */
    public void setConstructId(String constructId) {
        this.constructId = constructId == null ? null : constructId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.construct_code
     *
     * @return the value of project_quotation_rooms_construct.construct_code
     *
     * @mbg.generated
     */
    public String getConstructCode() {
        return constructCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.construct_code
     *
     * @param constructCode the value for project_quotation_rooms_construct.construct_code
     *
     * @mbg.generated
     */
    public void setConstructCode(String constructCode) {
        this.constructCode = constructCode == null ? null : constructCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.construct_name
     *
     * @return the value of project_quotation_rooms_construct.construct_name
     *
     * @mbg.generated
     */
    public String getConstructName() {
        return constructName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.construct_name
     *
     * @param constructName the value for project_quotation_rooms_construct.construct_name
     *
     * @mbg.generated
     */
    public void setConstructName(String constructName) {
        this.constructName = constructName == null ? null : constructName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.used_quantity
     *
     * @return the value of project_quotation_rooms_construct.used_quantity
     *
     * @mbg.generated
     */
    public Integer getUsedQuantity() {
        return usedQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.used_quantity
     *
     * @param usedQuantity the value for project_quotation_rooms_construct.used_quantity
     *
     * @mbg.generated
     */
    public void setUsedQuantity(Integer usedQuantity) {
        this.usedQuantity = usedQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.limits
     *
     * @return the value of project_quotation_rooms_construct.limits
     *
     * @mbg.generated
     */
    public Integer getLimits() {
        return limits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.limits
     *
     * @param limits the value for project_quotation_rooms_construct.limits
     *
     * @mbg.generated
     */
    public void setLimits(Integer limits) {
        this.limits = limits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.status
     *
     * @return the value of project_quotation_rooms_construct.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.status
     *
     * @param status the value for project_quotation_rooms_construct.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.room_type
     *
     * @return the value of project_quotation_rooms_construct.room_type
     *
     * @mbg.generated
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.room_type
     *
     * @param roomType the value for project_quotation_rooms_construct.room_type
     *
     * @mbg.generated
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms_construct.project_no
     *
     * @return the value of project_quotation_rooms_construct.project_no
     *
     * @mbg.generated
     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms_construct.project_no
     *
     * @param projectNo the value for project_quotation_rooms_construct.project_no
     *
     * @mbg.generated
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }
}