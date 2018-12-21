package cn.thinkfree.service.construction.impl;

import cn.thinkfree.core.base.RespData;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.AfConstants;
import cn.thinkfree.core.constants.ConstructionStateEnum;
import cn.thinkfree.database.appvo.ConstructionProjectVo;
import cn.thinkfree.database.mapper.ConstructionOrderMapper;
import cn.thinkfree.database.model.ConstructionOrder;
import cn.thinkfree.database.model.ConstructionOrderExample;
import cn.thinkfree.database.vo.ConstructCountVO;
import cn.thinkfree.service.approvalflow.AfConfigService;
import cn.thinkfree.service.construction.CommonService;
import cn.thinkfree.service.construction.ConstructOrderService;
import cn.thinkfree.service.construction.OrderListCommonService;
import cn.thinkfree.service.construction.vo.ConstructionOrderListVo;
import cn.thinkfree.service.construction.vo.ConstructionOrderManageVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ConstructOrderServiceImpl implements ConstructOrderService {

    @Autowired
    private OrderListCommonService orderListCommonService;
    @Autowired
    private ConstructionOrderMapper constructionOrderMapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private AfConfigService configService;

    /**
     * 订单列表
     *
     * @param pageNum
     * @param pageSize
     * @param cityName
     * @param orderType
     * @return
     */
    @Override
    public PageInfo<ConstructionOrderListVo> getOrderList(int pageNum, int pageSize, String cityName, int orderType) {
        PageInfo<ConstructionOrderListVo> pageInfo = orderListCommonService.getConstructionOrderList(pageNum, pageSize, cityName, orderType);
        return pageInfo;
    }

    /**
     * 施工订单列表统计
     * @return
     */

    @Override
    public MyRespBundle<ConstructionOrderManageVo> getOrderNum() {

        ConstructionOrderExample example = new ConstructionOrderExample();
        List<ConstructionOrder> list = constructionOrderMapper.selectByExample(example);

        /* 统计状态个数 */
        int waitExamine = 0, waitSign = 0, waitPay = 0;
        for (ConstructionOrder constructionOrder : list) {
            // 订单状态 统计
            int stage = constructionOrder.getOrderStage();
            if (stage == ConstructionStateEnum.STATE_530.getState()) {
                waitExamine++;
            }
            if (stage == ConstructionStateEnum.STATE_540.getState()) {
                waitSign++;
            }
            if ((stage >= ConstructionStateEnum.STATE_600.getState() && stage <= ConstructionStateEnum.STATE_700.getState())) {
                waitPay++;
            }
        }

        ConstructionOrderManageVo constructionOrderManageVo = new ConstructionOrderManageVo();
        constructionOrderManageVo.setCityList(commonService.getCityList());
        constructionOrderManageVo.setOrderNum(list.size());
        constructionOrderManageVo.setWaitExamine(waitExamine);
        constructionOrderManageVo.setWaitSign(waitSign);
        constructionOrderManageVo.setWaitPay(waitPay);
        return RespData.success(constructionOrderManageVo);
    }

    @Override
    public ConstructCountVO count(String userId, String approvalType, Integer pageNum, Integer pageSize) {
        ConstructCountVO constructCountVO = new ConstructCountVO();

        int total = constructionOrderMapper.countByUserId(userId);
        constructCountVO.setTotal(total);

        List<String> configNos = configService.getConfigNosByApprovalType(AfConstants.APPROVAL_TYPE_SCHEDULE_APPROVAL);
        int count = constructionOrderMapper.countByApproval(userId, configNos, ConstructionStateEnum.STATE_700.getState());
        constructCountVO.setCheckCount(count);

        configNos = configService.getConfigNosByApprovalType(AfConstants.APPROVAL_TYPE_CONSTRUCTION_CHANGE);
        count = constructionOrderMapper.countByApproval(userId, configNos, ConstructionStateEnum.STATE_700.getState());
        constructCountVO.setChangeCount(count);

        configNos = configService.getConfigNosByApprovalType(AfConstants.APPROVAL_TYPE_PROBLEM_RECTIFICATION);
        count = constructionOrderMapper.countByApproval(userId, configNos, ConstructionStateEnum.STATE_700.getState());
        constructCountVO.setProblemCount(count);

        configNos = configService.getConfigNosByApprovalType(AfConstants.APPROVAL_TYPE_DELAY_VERIFY);
        count = constructionOrderMapper.countByApproval(userId, configNos, ConstructionStateEnum.STATE_700.getState());
        constructCountVO.setDelayCount(count);

        configNos = configService.getConfigNosByApprovalType(approvalType);
        List<ConstructionProjectVo> constructionProjectVos = constructionOrderMapper.selectByApproval(userId, configNos, ConstructionStateEnum.STATE_700.getState(), (pageNum - 1) * pageSize, pageSize);
        PageInfo<ConstructionProjectVo> pageInfo = new PageInfo<>(constructionProjectVos);
        count = constructionOrderMapper.countByApproval(userId, configNos, ConstructionStateEnum.STATE_700.getState());
        pageInfo.setTotal(count);
        pageInfo.setPages((count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1));
        for (ConstructionProjectVo constructionProjectVo : constructionProjectVos) {
            constructionProjectVo.setStageName(ConstructionStateEnum.queryByState(constructionProjectVo.getStage()).getStateName(1));
        }
        constructCountVO.setPageInfo(pageInfo);

        return constructCountVO;
    }

    @Override
    public ConstructionOrder findByProjectNo(String projectNo) {
        ConstructionOrderExample example = new ConstructionOrderExample();
        example.createCriteria().andProjectNoEqualTo(projectNo);
        List<ConstructionOrder> constructionOrders = constructionOrderMapper.selectByExample(example);
        return constructionOrders != null && constructionOrders.size() > 0 ? constructionOrders.get(0) : null;
    }
}