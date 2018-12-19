package cn.thinkfree.database.appvo;

import cn.thinkfree.database.vo.AbsPageSearchCriteria;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gejiaming
 */
@ApiModel(value = "AppProjectSEO--项目列表入参实体",description = "AppProjectSEO--项目列表入参实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppProjectSEO extends AbsPageSearchCriteria {
    @ApiModelProperty(name = "userId",value = "用户编号")
    private String userId;
    @ApiModelProperty(name = "whichEnd",value = "app类型  1,消费端 2,设计端 3,施工端")
    private Integer whichEnd ;
}
