package cn.thinkfree.service.approvalflow.impl;

import cn.thinkfree.core.utils.UniqueCodeGenerator;
import cn.thinkfree.database.mapper.AfPlanMapper;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.AfPlanVO;
import cn.thinkfree.service.approvalflow.AfApprovalRoleService;
import cn.thinkfree.service.approvalflow.AfCompanyPlanService;
import cn.thinkfree.service.approvalflow.AfPlanService;
import cn.thinkfree.service.approvalflow.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author song
 * @version 1.0
 * @date 2018/10/26 15:53
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AfPlanServiceImpl implements AfPlanService {

    @Resource
    private AfPlanMapper planMapper;
    @Resource
    private AfApprovalRoleService approvalRoleService;
    @Resource
    private RoleService roleService;
    @Resource
    private AfCompanyPlanService companyPlanService;

    @Override
    public List<AfPlanVO> findByConfigLogNo(String configLogNo, List<UserRoleSet> allRoles) {
        List<AfPlanVO> planVOs = new ArrayList<>();
        AfPlanExample example = new AfPlanExample();
        example.createCriteria().andConfigLogNoEqualTo(configLogNo);
        List<AfPlan> plans = planMapper.selectByExample(example);
        if (plans != null) {
            for (AfPlan plan : plans) {
                List<UserRoleSet> roles = approvalRoleService.findByPlanNo(plan.getPlanNo(), allRoles);

                AfPlanVO planVO = new AfPlanVO();
                planVO.setPlan(plan);
                planVO.setRoles(roles);

                planVOs.add(planVO);
            }
        }
        return planVOs;
    }

    @Override
    public void create(String configLogNo, List<AfPlanVO> planVOs) {
        if (planVOs != null) {
            AfPlan plan;
            for (AfPlanVO planVO : planVOs) {
                plan = planVO.getPlan();
                plan.setId(null);
                plan.setConfigLogNo(configLogNo);
                plan.setPlanNo(UniqueCodeGenerator.AF_PLAN.getCode());
                approvalRoleService.create(plan.getPlanNo(), planVO.getRoles());
                insert(plan);
            }
        }
    }

    private void insert(AfPlan plan) {
        planMapper.insertSelective(plan);
    }

    @Override
    public AfPlanVO findByPlanNo(String planNo) {
        AfPlanVO planVO = null;
        AfPlanExample example = new AfPlanExample();
        example.createCriteria().andPlanNoEqualTo(planNo);
        List<AfPlan> plans = planMapper.selectByExample(example);
        AfPlan plan = null;
        if (plans != null && plans.size() > 0) {
            plan = plans.get(0);

            List<UserRoleSet> allRoles = roleService.findAll();
            List<UserRoleSet> roles = approvalRoleService.findByPlanNo(plan.getPlanNo(), allRoles);

            planVO = new AfPlanVO();
            planVO.setPlan(plan);
            planVO.setRoles(roles);
        }
        return planVO;
    }

    @Override
    public AfPlan findByConfigNoAndCompanyNoAndRoleId(String configNo, String companyNo, String roleId) {
        List<AfCompanyPlan> companyPlans = companyPlanService.findByCompanyNoAndConfigNo(companyNo, configNo);
        if (companyPlans != null && companyPlans.size() > 0) {
            List<String> planNos = new ArrayList<>(companyPlans.size());
            for (AfCompanyPlan companyPlan : companyPlans) {
                planNos.add(companyPlan.getPlanNo());
            }

            AfPlanExample example = new AfPlanExample();
            example.createCriteria().andPlanNoIn(planNos).andFirstRoleIdEqualTo(roleId);
            List<AfPlan> plans = planMapper.selectByExample(example);
            return plans != null && plans.size() > 0 ? plans.get(0) : null;
        }
        return null;
    }
}
