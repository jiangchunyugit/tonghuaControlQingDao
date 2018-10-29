package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.util.Date;

/**
 * Database Table Remarks:
 *   公司申请表：入驻，资质变更，续约
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_apply_info
 */
public class PcApplyInfo extends BaseModel {
    /**
     * Database Column Remarks:
     *   主键自增
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.id

     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   公司id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.company_id

     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   申请类型0：app申请(不显示删除）1:后台运营申请(显示删除)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.apply_type

     */
    private Short applyType;

    /**
     * Database Column Remarks:
     *   申请日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.apply_date

     */
    private Date applyDate;

    /**
     * Database Column Remarks:
     *   申请事项0：入驻申请1：资质变更 2：续签
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.apply_thing_type

     */
    private Short applyThingType;

    /**
     * Database Column Remarks:
     *   公司角色id 来源user_role_set表
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.company_role

     */
    private String companyRole;

    /**
     * Database Column Remarks:
     *   公司名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.company_name

     */
    private String companyName;

    /**
     * Database Column Remarks:
     *   城市编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.city_code

     */
    private Short cityCode;

    /**
     * Database Column Remarks:
     *   区域编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.area_code

     */
    private Integer areaCode;

    /**
     * Database Column Remarks:
     *   省份编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.province_code

     */
    private Short provinceCode;

    /**
     * Database Column Remarks:
     *   联系人姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.contact_name

     */
    private String contactName;

    /**
     * Database Column Remarks:
     *   联系人电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.contact_phone

     */
    private String contactPhone;

    /**
     * Database Column Remarks:
     *   是否删除1是0否
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.is_delete

     */
    private Short isDelete;

    /**
     * Database Column Remarks:
     *   是否办理：1是0否
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.transact_type

     */
    private Short transactType;

    /**
     * Database Column Remarks:
     *   邮箱
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_apply_info.email

     */
    private String email;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.id
     *
     * @return the value of pc_apply_info.id

     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.id
     *
     * @param id the value for pc_apply_info.id

     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.company_id
     *
     * @return the value of pc_apply_info.company_id

     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.company_id
     *
     * @param companyId the value for pc_apply_info.company_id

     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.apply_type
     *
     * @return the value of pc_apply_info.apply_type

     */
    public Short getApplyType() {
        return applyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.apply_type
     *
     * @param applyType the value for pc_apply_info.apply_type

     */
    public void setApplyType(Short applyType) {
        this.applyType = applyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.apply_date
     *
     * @return the value of pc_apply_info.apply_date

     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.apply_date
     *
     * @param applyDate the value for pc_apply_info.apply_date

     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.apply_thing_type
     *
     * @return the value of pc_apply_info.apply_thing_type

     */
    public Short getApplyThingType() {
        return applyThingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.apply_thing_type
     *
     * @param applyThingType the value for pc_apply_info.apply_thing_type

     */
    public void setApplyThingType(Short applyThingType) {
        this.applyThingType = applyThingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.company_role
     *
     * @return the value of pc_apply_info.company_role

     */
    public String getCompanyRole() {
        return companyRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.company_role
     *
     * @param companyRole the value for pc_apply_info.company_role

     */
    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole == null ? null : companyRole.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.company_name
     *
     * @return the value of pc_apply_info.company_name

     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.company_name
     *
     * @param companyName the value for pc_apply_info.company_name

     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.city_code
     *
     * @return the value of pc_apply_info.city_code

     */
    public Short getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.city_code
     *
     * @param cityCode the value for pc_apply_info.city_code

     */
    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.area_code
     *
     * @return the value of pc_apply_info.area_code

     */
    public Integer getAreaCode() {
        return areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.area_code
     *
     * @param areaCode the value for pc_apply_info.area_code

     */
    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.province_code
     *
     * @return the value of pc_apply_info.province_code

     */
    public Short getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.province_code
     *
     * @param provinceCode the value for pc_apply_info.province_code

     */
    public void setProvinceCode(Short provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.contact_name
     *
     * @return the value of pc_apply_info.contact_name

     */
    public String getContactName() {
        return contactName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.contact_name
     *
     * @param contactName the value for pc_apply_info.contact_name

     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.contact_phone
     *
     * @return the value of pc_apply_info.contact_phone

     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.contact_phone
     *
     * @param contactPhone the value for pc_apply_info.contact_phone

     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.is_delete
     *
     * @return the value of pc_apply_info.is_delete

     */
    public Short getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.is_delete
     *
     * @param isDelete the value for pc_apply_info.is_delete

     */
    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.transact_type
     *
     * @return the value of pc_apply_info.transact_type

     */
    public Short getTransactType() {
        return transactType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.transact_type
     *
     * @param transactType the value for pc_apply_info.transact_type

     */
    public void setTransactType(Short transactType) {
        this.transactType = transactType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_apply_info.email
     *
     * @return the value of pc_apply_info.email

     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_apply_info.email
     *
     * @param email the value for pc_apply_info.email

     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}