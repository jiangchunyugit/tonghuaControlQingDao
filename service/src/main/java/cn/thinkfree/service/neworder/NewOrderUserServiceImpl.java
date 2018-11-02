package cn.thinkfree.service.neworder;

import cn.thinkfree.core.utils.JSONUtil;
import cn.thinkfree.database.mapper.*;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.*;
import cn.thinkfree.service.constants.HttpLinks;
import cn.thinkfree.service.utils.AfUtils;
import cn.thinkfree.service.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目用户关系服务层
 *
 * @author song
 * @version 1.0
 * @date 2018/10/18 11:37
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class NewOrderUserServiceImpl implements NewOrderUserService {

    @Resource
    private OrderUserMapper orderUserMapper;
    @Autowired(required = false)
    private PreProjectGuideMapper preProjectGuideMapper;
    @Autowired(required = false)
    private DesignerOrderMapper DesignerOrderMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ConstructionOrderMapper constructionOrderMapper;
    @Autowired
    private ProjectBigSchedulingDetailsMapper projectBigSchedulingDetailsMapper;
    @Autowired
    private EmployeeMsgMapper employeeMsgMapper;
    @Resource
    private HttpLinks httpLinks;

    @Override
    public List<OrderUser> findByOrderNo(String orderNo) {
        OrderUserExample example = new OrderUserExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        return orderUserMapper.selectByExample(example);
    }

    @Override
    public String findUserIdByOrderNoAndRoleId(String orderNo, String roleId) {
        OrderUser orderUser = findByOrderNoAndRoleId(orderNo, roleId);
        return orderUser != null ? orderUser.getUserId() : null;
    }

    @Override
    public String findRoleIdByOrderNoAndUserId(String orderNo, String userId) {
        OrderUser orderUser = findByOrderNoAndUserId(orderNo, userId);
        return orderUser != null ? orderUser.getRoleId() : null;
    }

    @Override
    public OrderUser findByOrderNoAndUserId(String orderNo, String userId) {
        OrderUserExample example = new OrderUserExample();
        example.createCriteria().andOrderNoEqualTo(orderNo).andUserIdEqualTo(userId);
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(example);
        return orderUsers != null && orderUsers.size() > 0 ? orderUsers.get(0) : null;
    }

    /**
     * @return
     * @Author jiang
     * @Description 分页查询项目派单
     * @Date
     * @Param
     **/
    @Override
    public List<ProjectOrderVO> queryProjectOrderByPage(ProjectOrderVO projectOrderVO, Integer pageNum, Integer pageSize) {
        projectOrderVO.setStatus(1);
        //获取业主  项目经理 设计师
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        OrderUserExample orderUserExample = new OrderUserExample();
        orderUserExample.createCriteria().andProjectNoEqualTo(projectOrderVO.getProjectNo());
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(orderUserExample);
        List<EmployeeInfoVO> list = new ArrayList<>();
        orderUsers.forEach((user) ->
                {
                    EmployeeMsgExample employeeMsgExample = new EmployeeMsgExample();
                    employeeMsgExample.createCriteria().andUserIdEqualTo(user.getUserId());
                    List<EmployeeMsg> employeeMsgs = employeeMsgMapper.selectByExample(employeeMsgExample);
                    employeeMsgs.forEach(employeeMsg -> {
                        if (employeeMsg.getRoleCode().equals("CP")) {
                            employeeInfoVO.setProjectManager(employeeMsg.getRealName());
                        } else if (employeeMsg.getRoleCode().equals("CM")) {
                            employeeInfoVO.setForeman(employeeMsg.getRealName());
                        }else if (employeeMsg.getRoleCode().equals("CS")) {
                            employeeInfoVO.setHousekeeper(employeeMsg.getRealName());
                        }else if(employeeMsg.getRoleCode().equals("CQ")) {
                            employeeInfoVO.setQualityInspection(employeeMsg.getRealName());
                        }else if(employeeMsg.getRoleCode().equals("CD")) {
                            employeeInfoVO.setDesigner(employeeMsg.getRealName());
                        }
                    });
                }

        );
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectNoEqualTo(projectOrderVO.getProjectNo());
        List<Project> projects = projectMapper.selectByExample(projectExample);
      /*  Map result = getUserName(projects.get(0).getOwnerId(), "CC");
        //昵称先用着
        String nickName = (String) result.get("nickName");
        String phone = (String) result.get("phone");
        */
        List<ProjectOrderVO> projectOrderList = DesignerOrderMapper.selectProjectOrderByPage(projectOrderVO, pageNum, pageSize);
        projectOrderList.forEach((projectOrder)->{
            projectOrder.setProjectManager(employeeInfoVO.getProjectManager());
            projectOrder.setDesignerName(employeeInfoVO.getDesigner());
           /* projectOrder.setOwner(nickName);
           projectOrder.setPhone(phone);*/
        });

        return projectOrderList;
    }

    /**
     * @return
     * @Author jiang
     * @Description 查询项目派单总条数
     * @Date
     * @Param
     **/
    @Override
    public Integer queryProjectOrderCount(ProjectOrderVO projectOrderVO) {
        projectOrderVO.setStatus(1);
        return DesignerOrderMapper.selectProjectOrderCount(projectOrderVO);
    }

    /**
     * @return
     * @Author jiang
     * @Description 订单确认接口
     * @Date
     * @Param orderConfirmationVO
     **/
    @Override
    public Integer updateorderConfirmation(OrderConfirmationVO orderConfirmationVO) {
        DesignerOrder DesignerOrder = new DesignerOrder();
        DesignerOrder.setCompanyId(orderConfirmationVO.getCompanyId());
        DesignerOrder.setOrderStage(orderConfirmationVO.getOrderStage().intValue());

        DesignerOrderExample example = new DesignerOrderExample();
        example.createCriteria().andProjectNoEqualTo(orderConfirmationVO.getProjectNo());
        return DesignerOrderMapper.updateByExampleSelective(DesignerOrder, example);
    }

    /**
     * @return
     * @Author jiang
     * @Description 查看订单详情
     * @Date
     * @Param
     **/
    @Override
    public OrderDetailsVO selectOrderDetails(String projectNo) {
  /*      ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        Map result = getUserName(projects.get(0).getOwnerId(), "CC");
        String phone = (String) result.get("phone");
        //昵称先用着
        String nickName = (String) result.get("nickName");*/
        OrderDetailsVO orderDetailsVO = projectMapper.selectOrderDetails(projectNo, 1).get(0);
    /*  orderDetailsVO.setPhone(phone);
        orderDetailsVO.setConsumerName(nickName);
        orderDetailsVO.setUserName(nickName);*/
        orderDetailsVO.setProjectNo(projectNo);
        return orderDetailsVO;
    }

    /**
     * 获取用户信息
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public Map getUserName(String userId, String roleId) {
        Map<String, String> requestMap = new HashMap<>(2);
        requestMap.put("userId", userId);
        requestMap.put("roleId", roleId);
        HttpUtils.HttpRespMsg httpRespMsg = HttpUtils.post(httpLinks.getUserCenterGetUserMsgUrl(), requestMap);
        Map responseMap = JSONUtil.json2Bean(httpRespMsg.getContent(), Map.class);
        return (Map) responseMap.get("data");
    }

    /**
     * @return
     * @Author jiang
     * @Description 阶段展示
     * @Date
     * @Param
     **/
    @Override
    public List<StageDetailsVO> selectStageDetailsList(String projectNo) {
        StageDetailsVO stageDetailsVO = new StageDetailsVO();
        stageDetailsVO.setType(3);//查询的是项目阶段 (1,设计订单 2,施工订单 3,项目)

        return constructionOrderMapper.selectStageDetailsList(projectNo, stageDetailsVO.getType());
    }

    @Override
    public OrderUser findByOrderNoAndRoleId(String projectNo, String roleId) {
        OrderUserExample example = new OrderUserExample();
        example.createCriteria().andOrderNoEqualTo(projectNo).andRoleIdEqualTo(roleId);
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(example);
        return orderUsers != null && orderUsers.size() > 0 ? orderUsers.get(0) : null;
    }

    /**
     * @return
     * @Author jiang
     * @Description 修改订单状态
     * @Date
     * @Param
     **/
    @Override
    public Integer modifyOrder(OrderConfirmationVO orderConfirmationVO) {
        DesignerOrder DesignerOrder = new DesignerOrder();
        DesignerOrder.setOrderStage(orderConfirmationVO.getOrderStage().intValue());
        DesignerOrderExample example = new DesignerOrderExample();
        example.createCriteria().andProjectNoEqualTo(orderConfirmationVO.getProjectNo());
        return DesignerOrderMapper.updateByExampleSelective(DesignerOrder, example);
    }

    /**
     * @return
     * @Author jiang
     * @Description 分页查询施工工地
     * @Date
     * @Param
     **/
    @Override
    public List<ConstructionSiteVO> querySiteDetailsByPage(ConstructionSiteVO constructionSiteVO, Integer pageNum, Integer pageSize) {
        constructionSiteVO.setStatus(1);
        return projectMapper.selectSiteDetailsByPage(constructionSiteVO, pageNum, pageSize);
    }

    /**
     * @return
     * @Author jiang
     * @Description 查询施工工地总条数
     * @Date
     * @Param
     **/
    @Override
    public Integer querySiteDetailsCount(ConstructionSiteVO constructionSiteVO) {
        constructionSiteVO.setStatus(1);
        return projectMapper.selectSiteDetailsCount(constructionSiteVO);
    }

    /**
     * @return
     * @Author jiang
     * @Description 分页查询工地详情
     * @Date
     * @Param
     **/
    @Override
    public List<SiteDetailsVO> querySiteByPage(SiteDetailsVO siteDetailsVO, Integer pageNum, Integer pageSize) {
        siteDetailsVO.setStage(1);
        return projectMapper.selectSiteByPage(siteDetailsVO, pageNum, pageSize);
    }

    /**
     * @return
     * @Author jiang
     * @Description 查询工地详情总条数
     * @Date
     * @Param
     **/
    @Override
    public Integer querySiteCount(SiteDetailsVO siteDetailsVO) {
        siteDetailsVO.setStage(1);
        return projectMapper.selectSiteCount(siteDetailsVO);
    }

    /**
     * @return
     * @Author jiang
     * @Description 分页查询施工计划
     * @Date
     * @Param
     **/
    @Override
    public List<ConstructionPlanVO> queryConstructionPlanByPage(ConstructionPlanVO constructionPlanVO, Integer pageNum, Integer pageSize) {
        constructionPlanVO.setStatus(1);
        return projectBigSchedulingDetailsMapper.selectConstructionPlanByPage(constructionPlanVO, pageNum, pageSize);
    }

    /**
     * @return
     * @Author jiang
     * @Description 查询施工计划总条数
     * @Date
     * @Param
     **/
    @Override
    public Integer queryConstructionPlanCount(ConstructionPlanVO constructionPlanVO) {
        constructionPlanVO.setStatus(1);
        return projectBigSchedulingDetailsMapper.selectConstructionPlanCount(constructionPlanVO);
    }

    /**
     * @return
     * @Author jiang
     * @Description 查询员工详情
     * @Date
     * @Param
     **/
    @Override
    public EmployeeInfoVO selectemployeeInfoList(String projectNo) {
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        OrderUserExample orderUserExample = new OrderUserExample();
        orderUserExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(orderUserExample);
        List<EmployeeInfoVO> list = new ArrayList<>();
        orderUsers.forEach((user) ->
                {
                    EmployeeMsgExample employeeMsgExample = new EmployeeMsgExample();
                    employeeMsgExample.createCriteria().andUserIdEqualTo(user.getUserId());
                    List<EmployeeMsg> employeeMsgs = employeeMsgMapper.selectByExample(employeeMsgExample);
                    employeeMsgs.forEach(employeeMsg -> {
                        if (employeeMsg.getRoleCode().equals("CP")) {
                            employeeInfoVO.setProjectManager(employeeMsg.getRealName());
                        } else if (employeeMsg.getRoleCode().equals("CM")) {
                            employeeInfoVO.setForeman(employeeMsg.getRealName());
                        }else if (employeeMsg.getRoleCode().equals("CS")) {
                            employeeInfoVO.setHousekeeper(employeeMsg.getRealName());
                        }else if(employeeMsg.getRoleCode().equals("CQ")) {
                            employeeInfoVO.setQualityInspection(employeeMsg.getRealName());
                        }
                    });
                }

        );

        return employeeInfoVO;
    }

    /**
     * @Author jiang
     * @Description 分页查询验收结果
     * @Date
     * @Param
     * @return
     **/
    @Override
    public List<AcceptanceResultsVO> queryAcceptanceResultsByPage(String projectNo, Integer pageNum, Integer pageSize) {

        return projectBigSchedulingDetailsMapper.selectAcceptanceResultsByPage( projectNo,  pageNum,  pageSize);
    }

    /**
     * @Author jiang
     * @Description 查询验收结果总条数
     * @Date
     * @Param
     * @return
     **/
    @Override
    public Integer queryAcceptanceResultsCount(String projectNo) {
        return projectBigSchedulingDetailsMapper.selectAcceptanceResultsCount(projectNo);
    }


}
