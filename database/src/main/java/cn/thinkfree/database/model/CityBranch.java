package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * Database Table Remarks:
 *   城市分站信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_city_branch
 */
@ApiModel(value="cn.thinkfree.database.model.CityBranch")
public class CityBranch extends BaseModel {
    /**
     * Database Column Remarks:
     *   自增id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.id
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="id自增id")
    private Integer id;

    /**
     * Database Column Remarks:
     *   法人姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.legal_name
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="legalName法人姓名")
    private String legalName;

    /**
     * Database Column Remarks:
     *   法人电话号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.legal_phone
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="legalPhone法人电话号")
    private String legalPhone;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.create_time
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="createTime创建时间")
    private Date createTime;

    /**
     * Database Column Remarks:
     *   是否删除,1删除 2未删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.is_del
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="isDel是否删除,1删除 2未删除")
    private Short isDel;

    /**
     * Database Column Remarks:
     *   未启用0，启用1，禁用2
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.is_enable
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="isEnable未启用0，启用1，禁用2")
    private Short isEnable;

    /**
     * Database Column Remarks:
     *   城市分站名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.city_branch_name
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="cityBranchName城市分站名称")
    private String cityBranchName;

    /**
     * Database Column Remarks:
     *   所属城市分站ebsid
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.city_branch_ebsid
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="cityBranchEbsid所属城市分站ebsid")
    private Integer cityBranchEbsid;

    /**
     * Database Column Remarks:
     *   邮箱地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.mail
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="mail邮箱地址")
    private String mail;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.mark
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="mark备注")
    private String mark;

    /**
     * Database Column Remarks:
     *   所属分公司ebsid
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.branch_comp_ebsid
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="branchCompEbsid所属分公司ebsid")
    private Integer branchCompEbsid;

    /**
     * Database Column Remarks:
     *   分公司id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.branch_comp_id
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="branchCompId分公司id")
    private Integer branchCompId;

    /**
     * Database Column Remarks:
     *   省份编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.province_code
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="provinceCode省份编码")
    private Short provinceCode;

    /**
     * Database Column Remarks:
     *   城市编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_city_branch.city_code
     *
     * @mbg.generated
     */
    @ApiModelProperty(value="cityCode城市编码")
    private Short cityCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.id
     *
     * @return the value of pc_city_branch.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.id
     *
     * @param id the value for pc_city_branch.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.legal_name
     *
     * @return the value of pc_city_branch.legal_name
     *
     * @mbg.generated
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.legal_name
     *
     * @param legalName the value for pc_city_branch.legal_name
     *
     * @mbg.generated
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.legal_phone
     *
     * @return the value of pc_city_branch.legal_phone
     *
     * @mbg.generated
     */
    public String getLegalPhone() {
        return legalPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.legal_phone
     *
     * @param legalPhone the value for pc_city_branch.legal_phone
     *
     * @mbg.generated
     */
    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone == null ? null : legalPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.create_time
     *
     * @return the value of pc_city_branch.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.create_time
     *
     * @param createTime the value for pc_city_branch.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.is_del
     *
     * @return the value of pc_city_branch.is_del
     *
     * @mbg.generated
     */
    public Short getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.is_del
     *
     * @param isDel the value for pc_city_branch.is_del
     *
     * @mbg.generated
     */
    public void setIsDel(Short isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.is_enable
     *
     * @return the value of pc_city_branch.is_enable
     *
     * @mbg.generated
     */
    public Short getIsEnable() {
        return isEnable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.is_enable
     *
     * @param isEnable the value for pc_city_branch.is_enable
     *
     * @mbg.generated
     */
    public void setIsEnable(Short isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.city_branch_name
     *
     * @return the value of pc_city_branch.city_branch_name
     *
     * @mbg.generated
     */
    public String getCityBranchName() {
        return cityBranchName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.city_branch_name
     *
     * @param cityBranchName the value for pc_city_branch.city_branch_name
     *
     * @mbg.generated
     */
    public void setCityBranchName(String cityBranchName) {
        this.cityBranchName = cityBranchName == null ? null : cityBranchName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.city_branch_ebsid
     *
     * @return the value of pc_city_branch.city_branch_ebsid
     *
     * @mbg.generated
     */
    public Integer getCityBranchEbsid() {
        return cityBranchEbsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.city_branch_ebsid
     *
     * @param cityBranchEbsid the value for pc_city_branch.city_branch_ebsid
     *
     * @mbg.generated
     */
    public void setCityBranchEbsid(Integer cityBranchEbsid) {
        this.cityBranchEbsid = cityBranchEbsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.mail
     *
     * @return the value of pc_city_branch.mail
     *
     * @mbg.generated
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.mail
     *
     * @param mail the value for pc_city_branch.mail
     *
     * @mbg.generated
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.mark
     *
     * @return the value of pc_city_branch.mark
     *
     * @mbg.generated
     */
    public String getMark() {
        return mark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.mark
     *
     * @param mark the value for pc_city_branch.mark
     *
     * @mbg.generated
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.branch_comp_ebsid
     *
     * @return the value of pc_city_branch.branch_comp_ebsid
     *
     * @mbg.generated
     */
    public Integer getBranchCompEbsid() {
        return branchCompEbsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.branch_comp_ebsid
     *
     * @param branchCompEbsid the value for pc_city_branch.branch_comp_ebsid
     *
     * @mbg.generated
     */
    public void setBranchCompEbsid(Integer branchCompEbsid) {
        this.branchCompEbsid = branchCompEbsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.branch_comp_id
     *
     * @return the value of pc_city_branch.branch_comp_id
     *
     * @mbg.generated
     */
    public Integer getBranchCompId() {
        return branchCompId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.branch_comp_id
     *
     * @param branchCompId the value for pc_city_branch.branch_comp_id
     *
     * @mbg.generated
     */
    public void setBranchCompId(Integer branchCompId) {
        this.branchCompId = branchCompId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.province_code
     *
     * @return the value of pc_city_branch.province_code
     *
     * @mbg.generated
     */
    public Short getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.province_code
     *
     * @param provinceCode the value for pc_city_branch.province_code
     *
     * @mbg.generated
     */
    public void setProvinceCode(Short provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_city_branch.city_code
     *
     * @return the value of pc_city_branch.city_code
     *
     * @mbg.generated
     */
    public Short getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_city_branch.city_code
     *
     * @param cityCode the value for pc_city_branch.city_code
     *
     * @mbg.generated
     */
    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }
}