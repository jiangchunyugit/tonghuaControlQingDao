package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.util.Date;

/**
 * Database Table Remarks:
 *   项目资料表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table project_data
 */
public class ProjectData extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   公司编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   项目编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.project_no
     *
     * @mbg.generated
     */
    private String projectNo;

    /**
     * Database Column Remarks:
     *   资料类型(1,设计资料 2,施工资料 3,报价单)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     * Database Column Remarks:
     *   状态(1,正常  2,失效)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   资料类别(客厅施工图,开工报告)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.category
     *
     * @mbg.generated
     */
    private Integer category;

    /**
     * Database Column Remarks:
     *   上传时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.upload_time
     *
     * @mbg.generated
     */
    private Date uploadTime;

    /**
     * Database Column Remarks:
     *   效果图地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.url
     *
     * @mbg.generated
     */
    private String url;

    /**
     * Database Column Remarks:
     *   是否确认(1,已确认 2,未确认)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.is_confirm
     *
     * @mbg.generated
     */
    private Integer isConfirm;

    /**
     * Database Column Remarks:
     *   确认时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.confirm_time
     *
     * @mbg.generated
     */
    private Date confirmTime;

    /**
     * Database Column Remarks:
     *   文件类型(1,png 2,PDF 3,3D云)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.file_type
     *
     * @mbg.generated
     */
    private Integer fileType;

    /**
     * Database Column Remarks:
     *   文件名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.file_name
     *
     * @mbg.generated
     */
    private String fileName;

    /**
     * Database Column Remarks:
     *   案例ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.case_id
     *
     * @mbg.generated
     */
    private String caseId;

    /**
     * Database Column Remarks:
     *   全景图地
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_data.photo_panorama_url
     *
     * @mbg.generated
     */
    private String photoPanoramaUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.id
     *
     * @return the value of project_data.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.id
     *
     * @param id the value for project_data.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.company_id
     *
     * @return the value of project_data.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.company_id
     *
     * @param companyId the value for project_data.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.project_no
     *
     * @return the value of project_data.project_no
     *
     * @mbg.generated
     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.project_no
     *
     * @param projectNo the value for project_data.project_no
     *
     * @mbg.generated
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.type
     *
     * @return the value of project_data.type
     *
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.type
     *
     * @param type the value for project_data.type
     *
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.status
     *
     * @return the value of project_data.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.status
     *
     * @param status the value for project_data.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.category
     *
     * @return the value of project_data.category
     *
     * @mbg.generated
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.category
     *
     * @param category the value for project_data.category
     *
     * @mbg.generated
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.upload_time
     *
     * @return the value of project_data.upload_time
     *
     * @mbg.generated
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.upload_time
     *
     * @param uploadTime the value for project_data.upload_time
     *
     * @mbg.generated
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.url
     *
     * @return the value of project_data.url
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.url
     *
     * @param url the value for project_data.url
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.is_confirm
     *
     * @return the value of project_data.is_confirm
     *
     * @mbg.generated
     */
    public Integer getIsConfirm() {
        return isConfirm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.is_confirm
     *
     * @param isConfirm the value for project_data.is_confirm
     *
     * @mbg.generated
     */
    public void setIsConfirm(Integer isConfirm) {
        this.isConfirm = isConfirm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.confirm_time
     *
     * @return the value of project_data.confirm_time
     *
     * @mbg.generated
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.confirm_time
     *
     * @param confirmTime the value for project_data.confirm_time
     *
     * @mbg.generated
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.file_type
     *
     * @return the value of project_data.file_type
     *
     * @mbg.generated
     */
    public Integer getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.file_type
     *
     * @param fileType the value for project_data.file_type
     *
     * @mbg.generated
     */
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.file_name
     *
     * @return the value of project_data.file_name
     *
     * @mbg.generated
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.file_name
     *
     * @param fileName the value for project_data.file_name
     *
     * @mbg.generated
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.case_id
     *
     * @return the value of project_data.case_id
     *
     * @mbg.generated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.case_id
     *
     * @param caseId the value for project_data.case_id
     *
     * @mbg.generated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_data.photo_panorama_url
     *
     * @return the value of project_data.photo_panorama_url
     *
     * @mbg.generated
     */
    public String getPhotoPanoramaUrl() {
        return photoPanoramaUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_data.photo_panorama_url
     *
     * @param photoPanoramaUrl the value for project_data.photo_panorama_url
     *
     * @mbg.generated
     */
    public void setPhotoPanoramaUrl(String photoPanoramaUrl) {
        this.photoPanoramaUrl = photoPanoramaUrl == null ? null : photoPanoramaUrl.trim();
    }
}