package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

import java.util.Date;

/**
 * Database Table Remarks:
 * 项目施工顺序表(大排期)
 * <p>
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table project_base_big_scheduling
 */
public class ProjectBigScheduling extends BaseModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     * 公司编号
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     * 序号
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.sort
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * Database Column Remarks:
     * 工作模块名称
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     * 自定义大排期名字
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.rename
     *
     * @mbg.generated
     */
    private String rename;

    /**
     * Database Column Remarks:
     * 描述
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * Database Column Remarks:
     * 下限平米
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.square_metre_start
     *
     * @mbg.generated
     */
    private Integer squareMetreStart;

    /**
     * Database Column Remarks:
     * 上限平米
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.square_metre_end
     *
     * @mbg.generated
     */
    private Integer squareMetreEnd;

    /**
     * Database Column Remarks:
     * 施工工期，单位（天）
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.workload
     *
     * @mbg.generated
     */
    private Integer workload;

    /**
     * Database Column Remarks:
     * 状态(1,正常  2,失效)
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * Database Column Remarks:
     * 创建时间
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     * 版本号
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.version
     *
     * @mbg.generated
     */
    private Integer version;

    /**
     * Database Column Remarks:
     * 是否需要验收(0-不需要验收，1-需要验收)
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.is_need_check
     *
     * @mbg.generated
     */
    private Short isNeedCheck;

    /**
     * Database Column Remarks:
     * 房屋新旧(1 新,2 旧)
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.is_new
     *
     * @mbg.generated
     */
    private Short isNew;

    /**
     * Database Column Remarks:
     * 室
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.room_num
     *
     * @mbg.generated
     */
    private Integer roomNum;

    /**
     * Database Column Remarks:
     * 前置任务序号
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_base_big_scheduling.predecessor_small_sort
     *
     * @mbg.generated
     */
    private Integer predecessorSmallSort;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.id
     *
     * @return the value of project_base_big_scheduling.id
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.id
     *
     * @param id the value for project_base_big_scheduling.id
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.company_id
     *
     * @return the value of project_base_big_scheduling.company_id
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.company_id
     *
     * @param companyId the value for project_base_big_scheduling.company_id
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.sort
     *
     * @return the value of project_base_big_scheduling.sort
     * @mbg.generated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.sort
     *
     * @param sort the value for project_base_big_scheduling.sort
     * @mbg.generated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.name
     *
     * @return the value of project_base_big_scheduling.name
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.name
     *
     * @param name the value for project_base_big_scheduling.name
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.rename
     *
     * @return the value of project_base_big_scheduling.rename
     * @mbg.generated
     */
    public String getRename() {
        return rename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.rename
     *
     * @param rename the value for project_base_big_scheduling.rename
     * @mbg.generated
     */
    public void setRename(String rename) {
        this.rename = rename == null ? null : rename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.description
     *
     * @return the value of project_base_big_scheduling.description
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.description
     *
     * @param description the value for project_base_big_scheduling.description
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.square_metre_start
     *
     * @return the value of project_base_big_scheduling.square_metre_start
     * @mbg.generated
     */
    public Integer getSquareMetreStart() {
        return squareMetreStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.square_metre_start
     *
     * @param squareMetreStart the value for project_base_big_scheduling.square_metre_start
     * @mbg.generated
     */
    public void setSquareMetreStart(Integer squareMetreStart) {
        this.squareMetreStart = squareMetreStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.square_metre_end
     *
     * @return the value of project_base_big_scheduling.square_metre_end
     * @mbg.generated
     */
    public Integer getSquareMetreEnd() {
        return squareMetreEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.square_metre_end
     *
     * @param squareMetreEnd the value for project_base_big_scheduling.square_metre_end
     * @mbg.generated
     */
    public void setSquareMetreEnd(Integer squareMetreEnd) {
        this.squareMetreEnd = squareMetreEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.workload
     *
     * @return the value of project_base_big_scheduling.workload
     * @mbg.generated
     */
    public Integer getWorkload() {
        return workload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.workload
     *
     * @param workload the value for project_base_big_scheduling.workload
     * @mbg.generated
     */
    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.status
     *
     * @return the value of project_base_big_scheduling.status
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.status
     *
     * @param status the value for project_base_big_scheduling.status
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.create_time
     *
     * @return the value of project_base_big_scheduling.create_time
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.create_time
     *
     * @param createTime the value for project_base_big_scheduling.create_time
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.version
     *
     * @return the value of project_base_big_scheduling.version
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.version
     *
     * @param version the value for project_base_big_scheduling.version
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.is_need_check
     *
     * @return the value of project_base_big_scheduling.is_need_check
     * @mbg.generated
     */
    public Short getIsNeedCheck() {
        return isNeedCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.is_need_check
     *
     * @param isNeedCheck the value for project_base_big_scheduling.is_need_check
     * @mbg.generated
     */
    public void setIsNeedCheck(Short isNeedCheck) {
        this.isNeedCheck = isNeedCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.is_new
     *
     * @return the value of project_base_big_scheduling.is_new
     * @mbg.generated
     */
    public Short getIsNew() {
        return isNew;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.is_new
     *
     * @param isNew the value for project_base_big_scheduling.is_new
     * @mbg.generated
     */
    public void setIsNew(Short isNew) {
        this.isNew = isNew;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.room_num
     *
     * @return the value of project_base_big_scheduling.room_num
     * @mbg.generated
     */
    public Integer getRoomNum() {
        return roomNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.room_num
     *
     * @param roomNum the value for project_base_big_scheduling.room_num
     * @mbg.generated
     */
    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_base_big_scheduling.predecessor_small_sort
     *
     * @return the value of project_base_big_scheduling.predecessor_small_sort
     * @mbg.generated
     */
    public Integer getPredecessorSmallSort() {
        return predecessorSmallSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_base_big_scheduling.predecessor_small_sort
     *
     * @param predecessorSmallSort the value for project_base_big_scheduling.predecessor_small_sort
     * @mbg.generated
     */
    public void setPredecessorSmallSort(Integer predecessorSmallSort) {
        this.predecessorSmallSort = predecessorSmallSort;
    }
}