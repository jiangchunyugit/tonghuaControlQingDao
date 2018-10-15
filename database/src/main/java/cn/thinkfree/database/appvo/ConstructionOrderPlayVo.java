package cn.thinkfree.database.appvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
/**
 * @author gejiaming
 */
@Data
public class ConstructionOrderPlayVo {
    @ApiModelProperty(name = "constructionCompany",value = "承接公司")
    private String constructionCompany;
    @ApiModelProperty(name = "persionList",value = "人员集合")
    private List<PersionVo> persionList;
    @ApiModelProperty(name = "taskNum",value = "任务数")
    private Integer taskNum;
    @ApiModelProperty(name = "cost",value = "费用")
    private Integer cost;
    @ApiModelProperty(name = "schedule",value = "工期")
    private Integer schedule;
    @ApiModelProperty(name = "delay",value = "延迟天数")
    private Integer delay;
}
