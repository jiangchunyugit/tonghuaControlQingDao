package cn.thinkfree.database.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="经销商品牌品类，审批查询条件")
public class BrandDetailVO {

    @ApiModelProperty(value="公司id")
    private String companyId;

    @ApiModelProperty(value="经销商id")
    private String agencyCode;

    @ApiModelProperty(value="品类编号")
    private String categoryNo;

    @ApiModelProperty(value="品牌编号")
    private String brandNo;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getBrandNo() {
        return brandNo;
    }

    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo;
    }
}
