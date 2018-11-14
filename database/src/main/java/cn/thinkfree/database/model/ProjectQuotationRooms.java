package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.math.BigDecimal;

/**
 * Database Table Remarks:
 *   项目报价单房间详情表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table project_quotation_rooms
 */
public class ProjectQuotationRooms extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   房间面积,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.area
     *
     * @mbg.generated
     */
    private Integer area;

    /**
     * Database Column Remarks:
     *   房间内施工项总价,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.constructs_price
     *
     * @mbg.generated
     */
    private BigDecimal constructsPrice;

    /**
     * Database Column Remarks:
     *   房间内硬装商品总价,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.hard_material_price
     *
     * @mbg.generated
     */
    private BigDecimal hardMaterialPrice;

    /**
     * Database Column Remarks:
     *   房屋高,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.height
     *
     * @mbg.generated
     */
    private Integer height;

    /**
     * Database Column Remarks:
     *   房间内周长,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.perimeter
     *
     * @mbg.generated
     */
    private Integer perimeter;

    /**
     * Database Column Remarks:
     *   房间id,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.room_id
     *
     * @mbg.generated
     */
    private String roomId;

    /**
     * Database Column Remarks:
     *   房间名称,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.room_name
     *
     * @mbg.generated
     */
    private String roomName;

    /**
     * Database Column Remarks:
     *   房间类型,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.room_type
     *
     * @mbg.generated
     */
    private String roomType;

    /**
     * Database Column Remarks:
     *    软装上平总价,
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.soft_material_price
     *
     * @mbg.generated
     */
    private BigDecimal softMaterialPrice;

    /**
     * Database Column Remarks:
     *   房间内价格总计
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.total_price
     *
     * @mbg.generated
     */
    private BigDecimal totalPrice;

    /**
     * Database Column Remarks:
     *   状态(1,有效 2,失效)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   项目编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.project_no
     *
     * @mbg.generated
     */
    private String projectNo;

    /**
     * Database Column Remarks:
     *   报价id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_quotation_rooms.quote_id
     *
     * @mbg.generated
     */
    private String quoteId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.id
     *
     * @return the value of project_quotation_rooms.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.id
     *
     * @param id the value for project_quotation_rooms.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.area
     *
     * @return the value of project_quotation_rooms.area
     *
     * @mbg.generated
     */
    public Integer getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.area
     *
     * @param area the value for project_quotation_rooms.area
     *
     * @mbg.generated
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.constructs_price
     *
     * @return the value of project_quotation_rooms.constructs_price
     *
     * @mbg.generated
     */
    public BigDecimal getConstructsPrice() {
        return constructsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.constructs_price
     *
     * @param constructsPrice the value for project_quotation_rooms.constructs_price
     *
     * @mbg.generated
     */
    public void setConstructsPrice(BigDecimal constructsPrice) {
        this.constructsPrice = constructsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.hard_material_price
     *
     * @return the value of project_quotation_rooms.hard_material_price
     *
     * @mbg.generated
     */
    public BigDecimal getHardMaterialPrice() {
        return hardMaterialPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.hard_material_price
     *
     * @param hardMaterialPrice the value for project_quotation_rooms.hard_material_price
     *
     * @mbg.generated
     */
    public void setHardMaterialPrice(BigDecimal hardMaterialPrice) {
        this.hardMaterialPrice = hardMaterialPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.height
     *
     * @return the value of project_quotation_rooms.height
     *
     * @mbg.generated
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.height
     *
     * @param height the value for project_quotation_rooms.height
     *
     * @mbg.generated
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.perimeter
     *
     * @return the value of project_quotation_rooms.perimeter
     *
     * @mbg.generated
     */
    public Integer getPerimeter() {
        return perimeter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.perimeter
     *
     * @param perimeter the value for project_quotation_rooms.perimeter
     *
     * @mbg.generated
     */
    public void setPerimeter(Integer perimeter) {
        this.perimeter = perimeter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.room_id
     *
     * @return the value of project_quotation_rooms.room_id
     *
     * @mbg.generated
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.room_id
     *
     * @param roomId the value for project_quotation_rooms.room_id
     *
     * @mbg.generated
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.room_name
     *
     * @return the value of project_quotation_rooms.room_name
     *
     * @mbg.generated
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.room_name
     *
     * @param roomName the value for project_quotation_rooms.room_name
     *
     * @mbg.generated
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.room_type
     *
     * @return the value of project_quotation_rooms.room_type
     *
     * @mbg.generated
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.room_type
     *
     * @param roomType the value for project_quotation_rooms.room_type
     *
     * @mbg.generated
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.soft_material_price
     *
     * @return the value of project_quotation_rooms.soft_material_price
     *
     * @mbg.generated
     */
    public BigDecimal getSoftMaterialPrice() {
        return softMaterialPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.soft_material_price
     *
     * @param softMaterialPrice the value for project_quotation_rooms.soft_material_price
     *
     * @mbg.generated
     */
    public void setSoftMaterialPrice(BigDecimal softMaterialPrice) {
        this.softMaterialPrice = softMaterialPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.total_price
     *
     * @return the value of project_quotation_rooms.total_price
     *
     * @mbg.generated
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.total_price
     *
     * @param totalPrice the value for project_quotation_rooms.total_price
     *
     * @mbg.generated
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.status
     *
     * @return the value of project_quotation_rooms.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.status
     *
     * @param status the value for project_quotation_rooms.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.project_no
     *
     * @return the value of project_quotation_rooms.project_no
     *
     * @mbg.generated
     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.project_no
     *
     * @param projectNo the value for project_quotation_rooms.project_no
     *
     * @mbg.generated
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_quotation_rooms.quote_id
     *
     * @return the value of project_quotation_rooms.quote_id
     *
     * @mbg.generated
     */
    public String getQuoteId() {
        return quoteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_quotation_rooms.quote_id
     *
     * @param quoteId the value for project_quotation_rooms.quote_id
     *
     * @mbg.generated
     */
    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId == null ? null : quoteId.trim();
    }
}