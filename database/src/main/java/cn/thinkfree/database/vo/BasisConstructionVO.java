package cn.thinkfree.database.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Auther: jiang
 * @Date: 2018/11/13 10:37
 * @Description: 基础施工详情
 */
@ApiModel("基础施工详情")
@Getter
@Setter
public class BasisConstructionVO {
    @ApiModelProperty("施工项目编号")
    private String projectNo;
    @ApiModelProperty("项目名称")
    private String constructCode;
    @ApiModelProperty("房屋类型")
    private String roomType;
    @ApiModelProperty("房屋名称")
    private String roomName;
    @ApiModelProperty("项目说明")
    private String constructName;
    @ApiModelProperty("单价")
    private BigDecimal unitPrice;
    @ApiModelProperty("数量")
    private Integer usedQuantity;
    @ApiModelProperty("总价")
    private BigDecimal totalPrice;
    @ApiModelProperty("数据唯一ID")
    private String id;
}
