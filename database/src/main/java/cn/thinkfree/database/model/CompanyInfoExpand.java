package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.util.Date;

/**
 * Database Table Remarks:
 *   公司资质拓展表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table company_info_expand
 */
public class CompanyInfoExpand extends BaseModel {
    /**
     * Database Column Remarks:
     *   主键自增
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   公司编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   省份编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.register_province_code
     *
     * @mbg.generated
     */
    private Short registerProvinceCode;

    /**
     * Database Column Remarks:
     *   城市编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.register_city_code
     *
     * @mbg.generated
     */
    private Short registerCityCode;

    /**
     * Database Column Remarks:
     *   区域编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.register_area_code
     *
     * @mbg.generated
     */
    private Integer registerAreaCode;

    /**
     * Database Column Remarks:
     *   公司注册详细地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.register_address
     *
     * @mbg.generated
     */
    private String registerAddress;

    /**
     * Database Column Remarks:
     *   邮政编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.postcode
     *
     * @mbg.generated
     */
    private String postcode;

    /**
     * Database Column Remarks:
     *   邮箱
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     * Database Column Remarks:
     *   公司类型：0:有限责任公司,1:股份有限公司,2:个人独资企业,3:合伙企业,4:全民所有制企业,5:集体所有制企业
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.company_type
     *
     * @mbg.generated
     */
    private Short companyType;

    /**
     * Database Column Remarks:
     *   统一社会信用代码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.unify_social_credit_code
     *
     * @mbg.generated
     */
    private String unifySocialCreditCode;

    /**
     * Database Column Remarks:
     *   电子公章照片地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.official_seal_url
     *
     * @mbg.generated
     */
    private String officialSealUrl;

    /**
     * Database Column Remarks:
     *   是否三证合一：1是0否
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.is_three_to_one
     *
     * @mbg.generated
     */
    private Short isThreeToOne;

    /**
     * Database Column Remarks:
     *   税务登记证图片上传地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.tax_code_photo_url
     *
     * @mbg.generated
     */
    private String taxCodePhotoUrl;

    /**
     * Database Column Remarks:
     *   联系人姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.contact_name
     *
     * @mbg.generated
     */
    private String contactName;

    /**
     * Database Column Remarks:
     *   联系人电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.contact_phone
     *
     * @mbg.generated
     */
    private String contactPhone;

    /**
     * Database Column Remarks:
     *   是否一般纳税人：1是0否
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.is_taxpayer
     *
     * @mbg.generated
     */
    private Short isTaxpayer;

    /**
     * Database Column Remarks:
     *   公司性质0:自营1：合作
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info_expand.comapny_nature
     *
     * @mbg.generated
     */
    private Short comapnyNature;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.id
     *
     * @return the value of company_info_expand.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.id
     *
     * @param id the value for company_info_expand.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.company_id
     *
     * @return the value of company_info_expand.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.company_id
     *
     * @param companyId the value for company_info_expand.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.create_time
     *
     * @return the value of company_info_expand.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.create_time
     *
     * @param createTime the value for company_info_expand.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.update_time
     *
     * @return the value of company_info_expand.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.update_time
     *
     * @param updateTime the value for company_info_expand.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.register_province_code
     *
     * @return the value of company_info_expand.register_province_code
     *
     * @mbg.generated
     */
    public Short getRegisterProvinceCode() {
        return registerProvinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.register_province_code
     *
     * @param registerProvinceCode the value for company_info_expand.register_province_code
     *
     * @mbg.generated
     */
    public void setRegisterProvinceCode(Short registerProvinceCode) {
        this.registerProvinceCode = registerProvinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.register_city_code
     *
     * @return the value of company_info_expand.register_city_code
     *
     * @mbg.generated
     */
    public Short getRegisterCityCode() {
        return registerCityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.register_city_code
     *
     * @param registerCityCode the value for company_info_expand.register_city_code
     *
     * @mbg.generated
     */
    public void setRegisterCityCode(Short registerCityCode) {
        this.registerCityCode = registerCityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.register_area_code
     *
     * @return the value of company_info_expand.register_area_code
     *
     * @mbg.generated
     */
    public Integer getRegisterAreaCode() {
        return registerAreaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.register_area_code
     *
     * @param registerAreaCode the value for company_info_expand.register_area_code
     *
     * @mbg.generated
     */
    public void setRegisterAreaCode(Integer registerAreaCode) {
        this.registerAreaCode = registerAreaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.register_address
     *
     * @return the value of company_info_expand.register_address
     *
     * @mbg.generated
     */
    public String getRegisterAddress() {
        return registerAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.register_address
     *
     * @param registerAddress the value for company_info_expand.register_address
     *
     * @mbg.generated
     */
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.postcode
     *
     * @return the value of company_info_expand.postcode
     *
     * @mbg.generated
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.postcode
     *
     * @param postcode the value for company_info_expand.postcode
     *
     * @mbg.generated
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.email
     *
     * @return the value of company_info_expand.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.email
     *
     * @param email the value for company_info_expand.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.company_type
     *
     * @return the value of company_info_expand.company_type
     *
     * @mbg.generated
     */
    public Short getCompanyType() {
        return companyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.company_type
     *
     * @param companyType the value for company_info_expand.company_type
     *
     * @mbg.generated
     */
    public void setCompanyType(Short companyType) {
        this.companyType = companyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.unify_social_credit_code
     *
     * @return the value of company_info_expand.unify_social_credit_code
     *
     * @mbg.generated
     */
    public String getUnifySocialCreditCode() {
        return unifySocialCreditCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.unify_social_credit_code
     *
     * @param unifySocialCreditCode the value for company_info_expand.unify_social_credit_code
     *
     * @mbg.generated
     */
    public void setUnifySocialCreditCode(String unifySocialCreditCode) {
        this.unifySocialCreditCode = unifySocialCreditCode == null ? null : unifySocialCreditCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.official_seal_url
     *
     * @return the value of company_info_expand.official_seal_url
     *
     * @mbg.generated
     */
    public String getOfficialSealUrl() {
        return officialSealUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.official_seal_url
     *
     * @param officialSealUrl the value for company_info_expand.official_seal_url
     *
     * @mbg.generated
     */
    public void setOfficialSealUrl(String officialSealUrl) {
        this.officialSealUrl = officialSealUrl == null ? null : officialSealUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.is_three_to_one
     *
     * @return the value of company_info_expand.is_three_to_one
     *
     * @mbg.generated
     */
    public Short getIsThreeToOne() {
        return isThreeToOne;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.is_three_to_one
     *
     * @param isThreeToOne the value for company_info_expand.is_three_to_one
     *
     * @mbg.generated
     */
    public void setIsThreeToOne(Short isThreeToOne) {
        this.isThreeToOne = isThreeToOne;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.tax_code_photo_url
     *
     * @return the value of company_info_expand.tax_code_photo_url
     *
     * @mbg.generated
     */
    public String getTaxCodePhotoUrl() {
        return taxCodePhotoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.tax_code_photo_url
     *
     * @param taxCodePhotoUrl the value for company_info_expand.tax_code_photo_url
     *
     * @mbg.generated
     */
    public void setTaxCodePhotoUrl(String taxCodePhotoUrl) {
        this.taxCodePhotoUrl = taxCodePhotoUrl == null ? null : taxCodePhotoUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.contact_name
     *
     * @return the value of company_info_expand.contact_name
     *
     * @mbg.generated
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.contact_name
     *
     * @param contactName the value for company_info_expand.contact_name
     *
     * @mbg.generated
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.contact_phone
     *
     * @return the value of company_info_expand.contact_phone
     *
     * @mbg.generated
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.contact_phone
     *
     * @param contactPhone the value for company_info_expand.contact_phone
     *
     * @mbg.generated
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.is_taxpayer
     *
     * @return the value of company_info_expand.is_taxpayer
     *
     * @mbg.generated
     */
    public Short getIsTaxpayer() {
        return isTaxpayer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.is_taxpayer
     *
     * @param isTaxpayer the value for company_info_expand.is_taxpayer
     *
     * @mbg.generated
     */
    public void setIsTaxpayer(Short isTaxpayer) {
        this.isTaxpayer = isTaxpayer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info_expand.comapny_nature
     *
     * @return the value of company_info_expand.comapny_nature
     *
     * @mbg.generated
     */
    public Short getComapnyNature() {
        return comapnyNature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info_expand.comapny_nature
     *
     * @param comapnyNature the value for company_info_expand.comapny_nature
     *
     * @mbg.generated
     */
    public void setComapnyNature(Short comapnyNature) {
        this.comapnyNature = comapnyNature;
    }
}