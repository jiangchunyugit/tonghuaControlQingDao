package cn.thinkfree.database.appvo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

/**
 * @author gejiaming
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ProjectTitleVo",description = "项目头详情")
public class ProjectTitleVo {
    @ApiModelProperty(name = "projectNo",value = "项目编号")
    private String projectNo;
    @ApiModelProperty(name = "address",value = "装修地址")
    private String address;
    @ApiModelProperty(name = "constructionProgress",value = "施工进度")
    private Integer constructionProgress;
    @ApiModelProperty(name = "taskNum",value = "任务数")
    private Integer taskNum;
    @ApiModelProperty(name = "cost",value = "费用")
    private Integer cost;
    @ApiModelProperty(name = "schedule",value = "工期")
    private Integer schedule;
    @ApiModelProperty(name = "delay",value = "延迟天数")
    private Integer delay;
    @ApiModelProperty(value = "排期是否可以编辑(0,不可以 1,可以)")
    private Integer isConfirm;
    @ApiModelProperty(value = "项目开始时间")
    private Date projectStartTime;
    @ApiModelProperty(value = "项目结束时间")
    private Date projectEndTime;


}