package cn.thinkfree.database.vo;

import cn.thinkfree.database.model.ApprovalFlowConfig;
import cn.thinkfree.database.model.ApprovalFlowConfigSuper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 编辑审批流输入对象
 * @author xusonghui
 */
@ApiModel
@Data
public class ApprovalFlowConfigVO extends ApprovalFlowConfig {
    /**
     * 审批流节点信息
     */
    @ApiModelProperty(name = "审批流节点信息")
    private List<ApprovalFlowNodeVO> nodeVos;

    @ApiModelProperty("当前审批流依托关系")
    private List<ApprovalFlowConfigSuper> configSupers;

}
