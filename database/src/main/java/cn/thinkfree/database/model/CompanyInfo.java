package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Database Table Remarks:
 *   公司资质信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table company_info
 */
@Api(value = "公司资质信息")
public class CompanyInfo extends BaseModel {
    /**
     * Database Column Remarks:
     *   自增id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.id

     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   公司编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.company_id

     */
    @ApiModelProperty("公司编号")
    private String companyId;

    /**
     * Database Column Remarks:
     *   公司名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.company_name

     */
    @ApiModelProperty("公司名称")
    private String companyName;

    /**
     * Database Column Remarks:
     *   公司角色id 来源user_role_set表
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.role_id

     */
    @ApiModelProperty("公司角色id 来源user_role_set表")
    private String roleId;

    /**
     * Database Column Remarks:
     *   省份编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.province_code

     */
    @ApiModelProperty("省份编码")
    private Short provinceCode;

    /**
     * Database Column Remarks:
     *   公司详细地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.address

     */
    @ApiModelProperty("公司详细地址")
    private String address;

    /**
     * Database Column Remarks:
     *   法人姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.legal_name

     */
    @ApiModelProperty("法人姓名")
    private String legalName;

    /**
     * Database Column Remarks:
     *   法人电话号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.legal_phone

     */
    @ApiModelProperty("法人电话号")
    private String legalPhone;

    /**
     * Database Column Remarks:
     *   法人身份证号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.legal_id_card

     */
    @ApiModelProperty("法人身份证号")
    private String legalIdCard;

    /**
     * Database Column Remarks:
     *   营业执照编码(三证合一编码)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.business_code

     */
    @ApiModelProperty("营业执照编码(三证合一编码)")
    private String businessCode;

    /**
     * Database Column Remarks:
     *   组织机构代码证
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.organization_code

     */
    @ApiModelProperty("组织机构代码证")
    private String organizationCode;

    /**
     * Database Column Remarks:
     *   税务登记证
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.tax_code

     */
    @ApiModelProperty("税务登记证")
    private String taxCode;

    /**
     * Database Column Remarks:
     *   入驻是否审核通过 1审核通过 2审核不通过
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.is_check

     */
    @ApiModelProperty("入驻是否审核通过 1审核通过 2审核不通过")
    private Short isCheck;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.create_time

     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * Database Column Remarks:
     *   管理员手机号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.phone

     */
    @ApiModelProperty("管理员手机号")
    private String phone;

    /**
     * Database Column Remarks:
     *   营业执照照片地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.business_photo_url

     */
    @ApiModelProperty("营业执照照片地址url")
    private String businessPhotoUrl;

    /**
     * Database Column Remarks:
     *   施工资质照片地址(装饰公司专用)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.work_photo_url

     */
    @ApiModelProperty("施工资质照片地址(装饰公司专用)url")
    private String workPhotoUrl;

    /**
     * Database Column Remarks:
     *   担保金
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.deposit_money

     */
    @ApiModelProperty("担保金")
    private Integer depositMoney;

    /**
     * Database Column Remarks:
     *   经纬度信息
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.lbs

     */
    @ApiModelProperty("经纬度信息")
    private String lbs;

    /**
     * Database Column Remarks:
     *   是否删除 1是 2否
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.is_delete

     */
    @ApiModelProperty("是否删除 1是 2否")
    private Short isDelete;

    /**
     * Database Column Remarks:
     *   城市编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.city_code

     */
    @ApiModelProperty("城市编码")
    private Short cityCode;

    /**
     * Database Column Remarks:
     *   区域编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.area_code

     */
    @ApiModelProperty("区域编码")
    private Integer areaCode;

    /**
     * Database Column Remarks:
     *   公司座机
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.telephone

     */
    @ApiModelProperty("公司座机")
    private String telephone;

    /**
     * Database Column Remarks:
     *   描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.content

     */
    @ApiModelProperty("描述")
    private String content;

    /**
     * Database Column Remarks:
     *   公司入驻状态 0待激活1已激活2财务审核中3财务审核成功4财务审核失败5待交保证金6已交保证金 7入驻成功 8资质待审核 9资质审核通过 10资质审核不通过
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.audit_status

     */
    @ApiModelProperty("公司入驻状态 0待激活1已激活2财务审核中3财务审核成功4财务审核失败5待交保证金6已交保证金 7入驻成功 8资质待审核 9资质审核通过 10资质审核不通过")
    private String auditStatus;

    /**
     * Database Column Remarks:
     *   法人身份证正面
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.lefal_card_up_url

     */
    @ApiModelProperty("法人身份证正面url")
    private String lefalCardUpUrl;

    /**
     * Database Column Remarks:
     *   法人身份证反面
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.lefal_card_down_url

     */
    @ApiModelProperty("法人身份证反面url")
    private String lefalCardDownUrl;

    /**
     * Database Column Remarks:
     *   发证机关（装饰公司专用）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.work_card_from

     */
    @ApiModelProperty("发证机关（装饰公司专用）")
    private String workCardFrom;

    /**
     * Database Column Remarks:
     *   复审时间及有效期（装饰公司专用）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.work_card_indate

     */
    @ApiModelProperty("复审时间及有效期（装饰公司专用）")
    private Date workCardIndate;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.update_time

     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   劳务分包资质证书编号（装饰公司专用）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.work_code

     */
    @ApiModelProperty("劳务分包资质证书编号（装饰公司专用）")
    private String workCode;

    /**
     * Database Column Remarks:
     *   公司分类：0：一级公司 1：二级公司（子公司，分站）2：三级公司（入驻公司）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.company_classify

     */
    private Short companyClassify;

    /**
     * Database Column Remarks:
     *   站点id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.site_company_id

     */
    @ApiModelProperty("站点id")
    private String siteCompanyId;

    /**
     * Database Column Remarks:
     *   业务类型：0：设计 1：施工
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.business_type

     */
    @ApiModelProperty("业务类型：设计 施工")
    private Short businessType;

    /**
     * Database Column Remarks:
     *   0正常，1冻结，2下架（冻结高于下架）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company_info.platform_type

     */
    @ApiModelProperty("平台状态：0正常，1冻结，2下架（冻结高于下架）")
    private Short platformType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.id
     *
     * @return the value of company_info.id

     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.id
     *
     * @param id the value for company_info.id

     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.company_id
     *
     * @return the value of company_info.company_id

     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.company_id
     *
     * @param companyId the value for company_info.company_id

     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.company_name
     *
     * @return the value of company_info.company_name

     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.company_name
     *
     * @param companyName the value for company_info.company_name

     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.role_id
     *
     * @return the value of company_info.role_id

     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.role_id
     *
     * @param roleId the value for company_info.role_id

     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.province_code
     *
     * @return the value of company_info.province_code

     */
    public Short getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.province_code
     *
     * @param provinceCode the value for company_info.province_code

     */
    public void setProvinceCode(Short provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.address
     *
     * @return the value of company_info.address

     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.address
     *
     * @param address the value for company_info.address

     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.legal_name
     *
     * @return the value of company_info.legal_name

     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.legal_name
     *
     * @param legalName the value for company_info.legal_name

     */
    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.legal_phone
     *
     * @return the value of company_info.legal_phone

     */
    public String getLegalPhone() {
        return legalPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.legal_phone
     *
     * @param legalPhone the value for company_info.legal_phone

     */
    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone == null ? null : legalPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.legal_id_card
     *
     * @return the value of company_info.legal_id_card

     */
    public String getLegalIdCard() {
        return legalIdCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.legal_id_card
     *
     * @param legalIdCard the value for company_info.legal_id_card

     */
    public void setLegalIdCard(String legalIdCard) {
        this.legalIdCard = legalIdCard == null ? null : legalIdCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.business_code
     *
     * @return the value of company_info.business_code

     */
    public String getBusinessCode() {
        return businessCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.business_code
     *
     * @param businessCode the value for company_info.business_code

     */
    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.organization_code
     *
     * @return the value of company_info.organization_code

     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.organization_code
     *
     * @param organizationCode the value for company_info.organization_code

     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.tax_code
     *
     * @return the value of company_info.tax_code

     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.tax_code
     *
     * @param taxCode the value for company_info.tax_code

     */
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode == null ? null : taxCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.is_check
     *
     * @return the value of company_info.is_check

     */
    public Short getIsCheck() {
        return isCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.is_check
     *
     * @param isCheck the value for company_info.is_check

     */
    public void setIsCheck(Short isCheck) {
        this.isCheck = isCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.create_time
     *
     * @return the value of company_info.create_time

     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.create_time
     *
     * @param createTime the value for company_info.create_time

     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.phone
     *
     * @return the value of company_info.phone

     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.phone
     *
     * @param phone the value for company_info.phone

     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.business_photo_url
     *
     * @return the value of company_info.business_photo_url

     */
    public String getBusinessPhotoUrl() {
        return businessPhotoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.business_photo_url
     *
     * @param businessPhotoUrl the value for company_info.business_photo_url

     */
    public void setBusinessPhotoUrl(String businessPhotoUrl) {
        this.businessPhotoUrl = businessPhotoUrl == null ? null : businessPhotoUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.work_photo_url
     *
     * @return the value of company_info.work_photo_url

     */
    public String getWorkPhotoUrl() {
        return workPhotoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.work_photo_url
     *
     * @param workPhotoUrl the value for company_info.work_photo_url

     */
    public void setWorkPhotoUrl(String workPhotoUrl) {
        this.workPhotoUrl = workPhotoUrl == null ? null : workPhotoUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.deposit_money
     *
     * @return the value of company_info.deposit_money

     */
    public Integer getDepositMoney() {
        return depositMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.deposit_money
     *
     * @param depositMoney the value for company_info.deposit_money

     */
    public void setDepositMoney(Integer depositMoney) {
        this.depositMoney = depositMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.lbs
     *
     * @return the value of company_info.lbs

     */
    public String getLbs() {
        return lbs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.lbs
     *
     * @param lbs the value for company_info.lbs

     */
    public void setLbs(String lbs) {
        this.lbs = lbs == null ? null : lbs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.is_delete
     *
     * @return the value of company_info.is_delete

     */
    public Short getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.is_delete
     *
     * @param isDelete the value for company_info.is_delete

     */
    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.city_code
     *
     * @return the value of company_info.city_code

     */
    public Short getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.city_code
     *
     * @param cityCode the value for company_info.city_code

     */
    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.area_code
     *
     * @return the value of company_info.area_code

     */
    public Integer getAreaCode() {
        return areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.area_code
     *
     * @param areaCode the value for company_info.area_code

     */
    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.telephone
     *
     * @return the value of company_info.telephone

     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.telephone
     *
     * @param telephone the value for company_info.telephone

     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.content
     *
     * @return the value of company_info.content

     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.content
     *
     * @param content the value for company_info.content

     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.audit_status
     *
     * @return the value of company_info.audit_status

     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.audit_status
     *
     * @param auditStatus the value for company_info.audit_status

     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.lefal_card_up_url
     *
     * @return the value of company_info.lefal_card_up_url

     */
    public String getLefalCardUpUrl() {
        return lefalCardUpUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.lefal_card_up_url
     *
     * @param lefalCardUpUrl the value for company_info.lefal_card_up_url

     */
    public void setLefalCardUpUrl(String lefalCardUpUrl) {
        this.lefalCardUpUrl = lefalCardUpUrl == null ? null : lefalCardUpUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.lefal_card_down_url
     *
     * @return the value of company_info.lefal_card_down_url

     */
    public String getLefalCardDownUrl() {
        return lefalCardDownUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.lefal_card_down_url
     *
     * @param lefalCardDownUrl the value for company_info.lefal_card_down_url

     */
    public void setLefalCardDownUrl(String lefalCardDownUrl) {
        this.lefalCardDownUrl = lefalCardDownUrl == null ? null : lefalCardDownUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.work_card_from
     *
     * @return the value of company_info.work_card_from

     */
    public String getWorkCardFrom() {
        return workCardFrom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.work_card_from
     *
     * @param workCardFrom the value for company_info.work_card_from

     */
    public void setWorkCardFrom(String workCardFrom) {
        this.workCardFrom = workCardFrom == null ? null : workCardFrom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.work_card_indate
     *
     * @return the value of company_info.work_card_indate

     */
    public Date getWorkCardIndate() {
        return workCardIndate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.work_card_indate
     *
     * @param workCardIndate the value for company_info.work_card_indate

     */
    public void setWorkCardIndate(Date workCardIndate) {
        this.workCardIndate = workCardIndate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.update_time
     *
     * @return the value of company_info.update_time

     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.update_time
     *
     * @param updateTime the value for company_info.update_time

     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.work_code
     *
     * @return the value of company_info.work_code

     */
    public String getWorkCode() {
        return workCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.work_code
     *
     * @param workCode the value for company_info.work_code

     */
    public void setWorkCode(String workCode) {
        this.workCode = workCode == null ? null : workCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.company_classify
     *
     * @return the value of company_info.company_classify

     */
    public Short getCompanyClassify() {
        return companyClassify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.company_classify
     *
     * @param companyClassify the value for company_info.company_classify

     */
    public void setCompanyClassify(Short companyClassify) {
        this.companyClassify = companyClassify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.site_company_id
     *
     * @return the value of company_info.site_company_id

     */
    public String getSiteCompanyId() {
        return siteCompanyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.site_company_id
     *
     * @param siteCompanyId the value for company_info.site_company_id

     */
    public void setSiteCompanyId(String siteCompanyId) {
        this.siteCompanyId = siteCompanyId == null ? null : siteCompanyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.business_type
     *
     * @return the value of company_info.business_type

     */
    public Short getBusinessType() {
        return businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.business_type
     *
     * @param businessType the value for company_info.business_type

     */
    public void setBusinessType(Short businessType) {
        this.businessType = businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company_info.platform_type
     *
     * @return the value of company_info.platform_type

     */
    public Short getPlatformType() {
        return platformType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company_info.platform_type
     *
     * @param platformType the value for company_info.platform_type

     */
    public void setPlatformType(Short platformType) {
        this.platformType = platformType;
    }
}