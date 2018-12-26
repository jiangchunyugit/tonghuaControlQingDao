package cn.thinkfree.database.appvo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "项目资料详情")
@Data
public class NewDataVo {
    @ApiModelProperty("量房资料详情")
    private String quantityDataJson;
    @ApiModelProperty("量房资料是否确认  0,未确认 1,确认")
    private Integer quantityDataIsConfirm;
    @ApiModelProperty("设计资料详情")
    private String designDataJson;
    @ApiModelProperty("设计资料是否确认  0,未确认 1,确认")
    private Integer designDataIsConfirm;
}
