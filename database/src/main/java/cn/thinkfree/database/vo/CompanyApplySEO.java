package cn.thinkfree.database.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author ying007
 * 申请信息查询参数
 */
@ApiModel(description = "申请信息查询参数")
public class CompanyApplySEO extends AbsPageSearchCriteria {

    /**
     * 公司名称，联系人姓名，手机号
     */
    @ApiModelProperty(value = "公司名称，联系人姓名，手机号")
    private String param;

    @ApiModelProperty(value = "开始时间")
    private String startDate;

    @ApiModelProperty(value = "结束时间")
    private String endDate;

    @ApiModelProperty(value = "申请事项")
    private Short applyThingType;

    @ApiModelProperty(value = "公司类型")
    private String companyRole;

    @ApiModelProperty(value = "市")
    private Short cityCode;

    @ApiModelProperty(value = "区")
    private Integer areaCode;

    @ApiModelProperty(value = "省")
    private Short provinceCode;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Short getApplyThingType() {
        return applyThingType;
    }

    public void setApplyThingType(Short applyThingType) {
        this.applyThingType = applyThingType;
    }

    public String getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole;
    }

    public Short getCityCode() {
        return cityCode;
    }

    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Short getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Short provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public String toString() {
        return "CompanyApplySEO{" +
                "param='" + param + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", applyThingType=" + applyThingType +
                ", companyRole='" + companyRole + '\'' +
                ", cityCode=" + cityCode +
                ", areaCode=" + areaCode +
                ", provinceCode=" + provinceCode +
                '}';
    }
}
