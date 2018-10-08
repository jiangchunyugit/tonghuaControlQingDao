package cn.thinkfree.database.vo;

import cn.thinkfree.database.model.ApprovalFlow;
import cn.thinkfree.database.model.ApprovalFlowConfigLog;
import cn.thinkfree.database.model.UserRoleSet;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 审批流详细信息
 * @author songchuanrang
 */
public class ApprovalFlowDetailVo {
    /**
     * 审批流信息
     */
    @ApiModelProperty("审批流对象")
    private ApprovalFlow approvalFlow;
    /**
     * 审批节点信息
     */
    @ApiModelProperty("审批流节点信息")
    private List<ApprovalFlowNodeVo> nodes;
    /**
     * 审批流修改日志表
     */
    @ApiModelProperty("审批流修改日志d")
    private List<ApprovalFlowConfigLog> configLogs;

    @ApiModelProperty("角色信息集合")
    private List<UserRoleSet> userRoleSets;

    public ApprovalFlow getApprovalFlow() {
        return approvalFlow;
    }

    public void setApprovalFlow(ApprovalFlow approvalFlow) {
        this.approvalFlow = approvalFlow;
    }

    public List<ApprovalFlowNodeVo> getNodes() {
        return nodes;
    }

    public void setNodes(List<ApprovalFlowNodeVo> nodes) {
        this.nodes = nodes;
    }

    public List<ApprovalFlowConfigLog> getConfigLogs() {
        return configLogs;
    }

    public void setConfigLogs(List<ApprovalFlowConfigLog> configLogs) {
        this.configLogs = configLogs;
    }

    public List<UserRoleSet> getUserRoleSets() {
        return userRoleSets;
    }

    public void setUserRoleSets(List<UserRoleSet> userRoleSets) {
        this.userRoleSets = userRoleSets;
    }
}
