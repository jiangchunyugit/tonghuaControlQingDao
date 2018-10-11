package cn.thinkfree.service.approvalFlow.impl;

import cn.thinkfree.core.utils.UniqueCodeGenerator;
import cn.thinkfree.database.mapper.ApprovalFlowNodeMapper;
import cn.thinkfree.database.model.ApprovalFlowNode;
import cn.thinkfree.database.model.ApprovalFlowNodeExample;
import cn.thinkfree.database.model.ApprovalFlowNodeRole;
import cn.thinkfree.database.model.UserRoleSet;
import cn.thinkfree.database.vo.ApprovalFlowNodeVo;
import cn.thinkfree.database.vo.NodeRoleSequenceVo;
import cn.thinkfree.service.approvalFlow.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 审批流节点服务层
 */
@Service
@Transactional
public class ApprovalFlowNodeServiceImpl implements ApprovalFlowNodeService {

    @Resource
    private ApprovalFlowNodeMapper nodeMapper;
    @Resource
    private ApprovalFlowFormService formDataService;
    @Resource
    private ApprovalFlowNoticeUrlService noticeUrlService;
    @Resource
    private ApprovalFlowOptionService optionService;
    @Resource
    private ApprovalFlowNodeRoleService nodeRoleService;
    @Resource
    private ApprovalFlowTimeoutNoticeService timeoutNoticeService;
    @Resource
    private ApprovalFlowConfigLogService configLogService;
    @Resource
    private RoleService roleService;

    /**
     * 根据节点编号查询节点信息
     * @param configLogNum 节点编号
     * @return 审批流节点信息
     */
    @Override
    public List<ApprovalFlowNodeVo> findVoByConfigLogNum(String configLogNum) {
        return nodeMapper.findByConfigLogNum(configLogNum);
    }
    /**
     * 根据节点编号查询节点信息
     * @param configLogNum 节点编号
     * @return 审批流节点信息
     */
    @Override
    public List<ApprovalFlowNode> findByConfigLogNum(String configLogNum) {
        ApprovalFlowNodeExample nodeExample = new ApprovalFlowNodeExample();
        nodeExample.createCriteria().andNumEqualTo(configLogNum);
        nodeExample.setOrderByClause("sort asc");
        return nodeMapper.selectByExample(nodeExample);
    }

    /**
     * 创建审批流节点
     * @param configLogNum 审批流配置记录编号
     * @param nodeVos 审批流节点信息
     */
    @Override
    public void create(String configLogNum, List<ApprovalFlowNodeVo> nodeVos) {
        if (nodeVos != null){
            for (ApprovalFlowNodeVo nodeVo : nodeVos){
                nodeVo.setConfigLogNum(configLogNum);
                nodeVo.setNum(UniqueCodeGenerator.AF_NODE.getCode());

                formDataService.create(nodeVo.getNum(), nodeVo.getFormVos());
                noticeUrlService.create(nodeVo.getNum(),  nodeVo.getNoticeUrls());
                optionService.create(nodeVo.getNum(), nodeVo.getOptions());
                nodeRoleService.create(nodeVo.getNum(), nodeVo.getNodeRoles());
                timeoutNoticeService.create(nodeVo.getNum(), nodeVo.getTimeoutNotices());

                nodeMapper.insert(nodeVo);
            }
        }
    }

    /**
     * 根据审批流配置记录编号删除审批流节点
     * @param configLogNums 审批流配置记录编号
     */
    @Override
    public void deleteByConfigLogNums(List<String> configLogNums) {
        ApprovalFlowNodeExample nodeExample = new ApprovalFlowNodeExample();
        nodeExample.createCriteria().andNumIn(configLogNums);
        nodeMapper.deleteByExample(nodeExample);
    }

    @Override
    public List<NodeRoleSequenceVo> findNodeRoleSequence(String approvalFlowNum, String companyId, Long projectBigSchedulingId) {
        configLogService.findLastVersionByApprovalFlowNum(approvalFlowNum);
        List<ApprovalFlowNode> nodes = findByConfigLogNum(approvalFlowNum);
        List<NodeRoleSequenceVo> nodeRoleSequenceVos = new ArrayList<>(nodes.size());
        List<UserRoleSet> userRoleSets = roleService.findAll();
        for (ApprovalFlowNode node : nodes) {
            List<ApprovalFlowNodeRole> nodeRoles = nodeRoleService.findLastVersionByNodeNumAndProjectBigSchedulingId(node.getNum(), projectBigSchedulingId);
            List<UserRoleSet> roles = new ArrayList<>(nodeRoles.size());
            for (ApprovalFlowNodeRole nodeRole : nodeRoles){
                for (UserRoleSet userRoleSet : userRoleSets){
                    if (nodeRole.getRoleId().equals(userRoleSet.getRoleCode())){
                        roles.add(userRoleSet);
                    }
                }
            }
            NodeRoleSequenceVo nodeRoleSequenceVo = new NodeRoleSequenceVo();
            nodeRoleSequenceVo.setNodeNum(node.getNum());
            nodeRoleSequenceVo.setSort(node.getSort());
            nodeRoleSequenceVo.setRoles(roles);
            nodeRoleSequenceVos.add(nodeRoleSequenceVo);
        }
        return nodeRoleSequenceVos;
    }
}
