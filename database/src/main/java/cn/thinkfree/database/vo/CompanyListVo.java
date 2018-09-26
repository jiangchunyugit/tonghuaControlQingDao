package cn.thinkfree.database.vo;

import cn.thinkfree.database.model.CompanyInfo;

import java.util.Date;

/**
 * 公司列表返回数据
 */
public class CompanyListVo extends CompanyInfo {
    /**
     * 公司性质
     */
    private Short comapnyNature;
    /**
     * 省
     */

    private Short siteProvinceCode;
    /**
     * 省
     */
    private String siteProvinceName;
    /**
     * 市
     */
    private Short siteCityCode;
    /**
     * 市
     */
    private String siteCityName;
    /**
     * 站点
     */
    private Short siteCode;
    /**
     * 站点
     */
    private String siteName;
    /**
     * 入驻时间
     */
    private Date startTime;
    /**
     * 截止日期
     */
    private Date endTime;
    /**
     * 签约日期
     */
    private Date signedTime;
    /**
     * 联系人
     */
    private String contactName;
    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 合同编号
     */
    private String contractNumber;

    public Short getComapnyNature() {
        return comapnyNature;
    }

    public void setComapnyNature(Short comapnyNature) {
        this.comapnyNature = comapnyNature;
    }

    public Short getSiteProvinceCode() {
        return siteProvinceCode;
    }

    public void setSiteProvinceCode(Short siteProvinceCode) {
        this.siteProvinceCode = siteProvinceCode;
    }

    public String getSiteProvinceName() {
        return siteProvinceName;
    }

    public void setSiteProvinceName(String siteProvinceName) {
        this.siteProvinceName = siteProvinceName;
    }

    public Short getSiteCityCode() {
        return siteCityCode;
    }

    public void setSiteCityCode(Short siteCityCode) {
        this.siteCityCode = siteCityCode;
    }

    public String getSiteCityName() {
        return siteCityName;
    }

    public void setSiteCityName(String siteCityName) {
        this.siteCityName = siteCityName;
    }

    public Short getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(Short siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    @Override
    public String toString() {
        return "CompanyListVo{" +
                "comapnyNature=" + comapnyNature +
                ", siteProvinceCode=" + siteProvinceCode +
                ", siteProvinceName='" + siteProvinceName + '\'' +
                ", siteCityCode=" + siteCityCode +
                ", siteCityName='" + siteCityName + '\'' +
                ", siteCode=" + siteCode +
                ", siteName='" + siteName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", signedTime=" + signedTime +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                '}';
    }
}
