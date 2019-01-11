package cn.thinkfree.service.platform.designer.impl;

import cn.thinkfree.core.base.RespData;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.*;
import cn.thinkfree.core.security.filter.util.SessionUserDetailsUtil;
import cn.thinkfree.core.utils.JSONUtil;
import cn.thinkfree.database.appvo.*;
import cn.thinkfree.database.mapper.*;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.*;
import cn.thinkfree.service.config.HttpLinks;
import cn.thinkfree.service.constants.ProjectDataStatus;
import cn.thinkfree.service.construction.ConstructionAndPayStateService;
import cn.thinkfree.service.neworder.NewOrderUserService;
import cn.thinkfree.service.platform.basics.BasicsService;
import cn.thinkfree.service.platform.basics.RoleFunctionService;
import cn.thinkfree.service.platform.build.BuildConfigService;
import cn.thinkfree.service.platform.designer.CreatePayOrderService;
import cn.thinkfree.service.platform.designer.DesignDispatchService;
import cn.thinkfree.service.platform.designer.DesignerService;
import cn.thinkfree.service.platform.designer.UserCenterService;
import cn.thinkfree.service.platform.employee.ProjectUserService;
import cn.thinkfree.service.platform.order.SendOrderNoticeService;
import cn.thinkfree.service.platform.vo.*;
import cn.thinkfree.service.project.ProjectStageLogService;
import cn.thinkfree.service.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static cn.thinkfree.core.constants.DesignStateEnum.STATE_40;

/**
 * @author xusonghui
 * 设计派单服务实现类
 */
@Service
public class DesignDispatchServiceImpl implements DesignDispatchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DesignDispatchServiceImpl.class);

    @Autowired
    private OptionLogMapper optionLogMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private DesignerOrderMapper designerOrderMapper;
    @Autowired
    private DesignerMsgMapper designerMsgMapper;
    @Autowired
    private EmployeeMsgMapper employeeMsgMapper;
    @Autowired
    private RemindOwnerLogMapper remindOwnerLogMapper;
    @Autowired
    private BasicsService basicsService;
    @Autowired
    private ConstructionOrderMapper constructionOrderMapper;
    @Autowired
    private UserCenterService userService;
    @Autowired
    private ProjectStageLogMapper stageLogMapper;
    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private DesignerService designerService;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;
    @Autowired
    private OrderUserMapper orderUserMapper;
    @Autowired
    private CreatePayOrderService createPayOrderService;
    @Autowired
    private BuildConfigService buildConfigService;
    @Autowired
    private ConstructionAndPayStateService constructionAndPayStateService;
    @Autowired
    NewOrderUserService newOrderUserService;
    @Autowired
    private HttpLinks httpLinks;
    @Autowired
    private OrderContractMapper orderContractMapper;
    @Autowired
    private RoleFunctionService roleFunctionService;
    @Autowired
    private ContractTermsMapper contractTermsMapper;
    @Autowired
    private SendOrderNoticeService orderNoticeService;
    @Autowired
    ProvinceMapper provinceMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    AreaMapper areaMapper;
    @Autowired
    private FundsOrderMapper fundsOrderMapper;
    @Autowired
    private FundsFlowMapper fundsFlowMapper;
    @Autowired
    private ProjectDataMapper projectDataMapper;
    @Autowired
    private FundsSettleAccountsNodeLogMapper fundsSettleAccountsNodeLogMapper;
    @Autowired
    private ProjectStageLogService projectStageLogService;
    @Autowired
    private BasicsDataMapper basicsDataMapper;
    /**
     * 查询设计订单，主表为design_order,附表为project
     *
     * @param queryStage         具体查询阶段
     * @param orderTpye
     * @param projectNo          订单编号（project.project_no）
     * @param userMsg            业主姓名或电话（调用用户中心查询获取userId）
     * @param orderSource        订单来源（project.order_source）
     * @param createTimeStart    创建时间开始（design_order.create_time）
     * @param createTimeEnd      创建时间结束（design_order.create_time）
     * @param styleCode          装饰风格（design_order.style_type）
     * @param money              装修预算（project.decoration_budget）
     * @param acreage            建筑面积（project.area）
     * @param designerOrderState 订单状态（design_order.order_stage）
     * @param companyState       公司状态（根据状态查询公司）
     * @param optionUserName     操作人姓名（option_log.option_user_name）
     * @param optionTimeStart    操作时间开始（option_log.option_time）
     * @param optionTimeEnd      操作时间结束（option_log.option_time）
     * @param stateType          状态类型
     * @return
     */
    @Override
    public PageVo<List<DesignerOrderVo>> queryDesignerOrder(
            String queryStage, Integer orderTpye, String companyId, String projectNo, String userMsg, String orderSource, String createTimeStart, String createTimeEnd,
            String styleCode, String provinceCode, String cityCode, String areaCode, String money, String acreage, int designerOrderState, int companyState,
            String optionUserName, String optionTimeStart, String optionTimeEnd, int pageSize, int pageIndex, int stateType, String companyName, String designerName,String branchCompanyCode,String cityBranchCode,String storeCode) {
        if (orderTpye == null) {
            throw new RuntimeException("请输入订单类别");
        }
        // 模糊查询用户信息
        List<String> queryProjectNo = queryProjectNos(userMsg);
        // 根据公司状态查询公司ID
        List<String> companyIds = queryCompanyIds(companyState, companyName);
        if (companyIds != null && companyIds.isEmpty()) {
            return PageVo.def(new ArrayList<>());
        }
        List<String> projectNos = getProjectNos(provinceCode, cityCode, areaCode, projectNo, orderSource, money, queryProjectNo, designerName);
        if (projectNos != null && projectNos.isEmpty()) {
            return PageVo.def(new ArrayList<>());
        }
        DesignerOrderExample orderExample = new DesignerOrderExample();
        DesignerOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        if (orderTpye == 1) {
            orderExampleCriteria.andOrderStageLessThan(DesignStateEnum.STATE_30.getState());
        }
        if (orderTpye == 2) {
            orderExampleCriteria.andOrderStageGreaterThanOrEqualTo(DesignStateEnum.STATE_30.getState());
            List<String> observeCompanyIds = getCompanyIds();
            if(observeCompanyIds != null && observeCompanyIds.isEmpty()){
                return PageVo.def(new ArrayList<>());
            }
            if(observeCompanyIds != null){
                orderExampleCriteria.andCompanyIdIn(observeCompanyIds);
            }
        }
        if (StringUtils.isNotBlank(createTimeStart)) {
            orderExampleCriteria.andCreateTimeGreaterThanOrEqualTo(DateUtils.strToDate(createTimeStart));
        }
        if (StringUtils.isNotBlank(createTimeEnd)) {
            orderExampleCriteria.andCreateTimeLessThanOrEqualTo(DateUtils.strToDate(createTimeEnd));
        }
        if (StringUtils.isNotBlank(styleCode)) {
            orderExampleCriteria.andStyleTypeEqualTo(styleCode);
        }
        if (designerOrderState > 0) {
            orderExampleCriteria.andOrderStageIn(DesignStateEnum.queryStatesByState(designerOrderState, stateType));
        }
        if ("DOCL".equals(queryStage)) {
            List<Integer> orderStates = Arrays.asList(DesignStateEnum.STATE_130.getState());
            orderExampleCriteria.andOrderStageIn(orderStates);
        }
        if (projectNos != null && !projectNos.isEmpty()) {
            orderExampleCriteria.andProjectNoIn(projectNos);
        }
        if (companyIds != null && !companyIds.isEmpty()) {
            orderExampleCriteria.andCompanyIdIn(companyIds);
        }
        orderExample.setOrderByClause(" create_time desc ");
        long total = designerOrderMapper.countByExample(orderExample);
        PageHelper.startPage(pageIndex, pageSize);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.isEmpty()) {
            return PageVo.def(new ArrayList<>());
        }
        PageInfo<DesignerOrderVo> pageInfo = new PageInfo(designerOrders);
        List<DesignerOrderVo> designerOrderVos = getDesignerOrderVos(stateType, designerOrders);
        List<CompanyCitySiteVO> companyCity = getCompanyCity(designerOrders, branchCompanyCode, cityBranchCode, storeCode);
        for(DesignerOrderVo designerOrder :designerOrderVos){
            for(CompanyCitySiteVO company:companyCity){
                if(designerOrder.getCompanyId()!=null&&company.getCompanyId()!=null){
                    if(designerOrder.getCompanyId().equals(company.getCompanyId())){
                        designerOrder.setBranchCompanyName(company.getBranchCompanyName());
                        designerOrder.setCityBranchName(company.getCityBranchName());
                        designerOrder.setStoreName(company.getStoreName());
                    }
                }

            }
        }
        PageVo<List<DesignerOrderVo>> pageVo = new PageVo<>();
        pageVo.setPageSize(pageSize);
        pageVo.setTotal(total);
        pageVo.setData(designerOrderVos);
        pageVo.setPageIndex(pageIndex);
        return pageVo;
    }
    public List<CompanyCitySiteVO> getCompanyCity(List<DesignerOrder> designerOrders,String branchCompanyCode,String cityBranchCode ,String storeCode){
        if(designerOrders ==null || designerOrders.size() < 0){
            throw new RuntimeException("为空");
        }
        List<CompanyCitySiteVO> companyList = new ArrayList<>();
        List<String> companyIds =new ArrayList<>();
        for (DesignerOrder companyId:designerOrders){
            companyIds.add(companyId.getCompanyId());
        }
        companyInfoMapper.selectCompanyCitySiteByCompanyId(companyIds,branchCompanyCode,cityBranchCode,storeCode);
        if(companyList == null || companyList.size() < 0){
            throw new RuntimeException("公司城市分站信息查询为空");
        }
        return companyList;
    }
    @Override
    public List<String> getCompanyIds(){
        UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
        if(userVO == null){
            return null;
        }
        List<String> relationMap = userVO.getRelationMap();
        if(relationMap == null){
            return null;
        }
        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.createCriteria().andSiteCompanyIdIn(relationMap);
        List<CompanyInfo> companyInfos = companyInfoMapper.selectByExample(companyInfoExample);
        return ReflectUtils.getList(companyInfos,"companyId");
    }

    /**
     * 项目角色拼接
     * @param orderUsers
     * @param ownerRoleCode
     * @param designerRoleCode
     * @return
     */
    private Map<String,OrderUser> getOrderUserMap(List<OrderUser> orderUsers, String ownerRoleCode, String designerRoleCode){
        Map<String,OrderUser> orderUserMap = new HashMap<>();
        for(OrderUser orderUser : orderUsers){
            if(ownerRoleCode != null && ownerRoleCode.equals(orderUser.getRoleCode())){
                orderUserMap.put(ownerRoleCode + "-" + orderUser.getProjectNo(), orderUser);
            }
            if(designerRoleCode != null && designerRoleCode.equals(orderUser.getRoleCode())){
                orderUserMap.put(designerRoleCode + "-" + orderUser.getProjectNo(), orderUser);
            }
        }
        return orderUserMap;
    }

    private Map<String, Project> getProjectMap(List<String> projectNos) {
        if (projectNos == null || projectNos.isEmpty()) {
            return new HashMap<>();
        }
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectNoIn(projectNos);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        return ReflectUtils.listToMap(projects, "projectNo");
    }

    @Override
    public PageVo<List<DesignerOrderVo>> queryDesignerOrderByCompanyId(
            String queryStage, Integer orderTpye, String companyId, String projectNo, String userMsg, String orderSource, String createTimeStart, String createTimeEnd,
            String styleCode, String provinceCode, String cityCode, String areaCode, String money, String acreage, int designerOrderState, String optionUserName,
            String optionTimeStart, String optionTimeEnd, int pageSize, int pageIndex, int stateType, String designerName) {
        if (StringUtils.isBlank(companyId)) {
            throw new RuntimeException("公司缺失");
        }
        if (orderTpye == null) {
            throw new RuntimeException("请输入订单类别");
        }
        // 模糊查询用户信息
        List<String> queryProjectNo = queryProjectNos(userMsg);
        // 根据公司状态查询公司ID
        List<String> projectNos = getProjectNos(provinceCode, cityCode, areaCode, projectNo, orderSource, money, queryProjectNo, designerName);
        DesignerOrderExample orderExample = new DesignerOrderExample();
        DesignerOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        if (orderTpye == 1) {
            orderExampleCriteria.andOrderStageLessThan(DesignStateEnum.STATE_30.getState());
        }
        if (orderTpye == 2) {
            orderExampleCriteria.andOrderStageGreaterThanOrEqualTo(DesignStateEnum.STATE_30.getState());
        }
        if (StringUtils.isNotBlank(createTimeStart)) {
            orderExampleCriteria.andCreateTimeGreaterThanOrEqualTo(DateUtils.strToDate(createTimeStart));
        }
        if (StringUtils.isNotBlank(createTimeEnd)) {
            orderExampleCriteria.andCreateTimeLessThanOrEqualTo(DateUtils.strToDate(createTimeEnd));
        }
        if (StringUtils.isNotBlank(styleCode)) {
            orderExampleCriteria.andStyleTypeEqualTo(styleCode);
        }
        if (designerOrderState > 0) {
            orderExampleCriteria.andOrderStageIn(DesignStateEnum.queryStatesByState(designerOrderState, stateType));
        }
        if ("DOCL".equals(queryStage)) {
            List<Integer> orderStates = Arrays.asList(DesignStateEnum.STATE_130.getState());
            orderExampleCriteria.andOrderStageIn(orderStates);
        }
        if (projectNos != null && !projectNos.isEmpty()) {
            orderExampleCriteria.andProjectNoIn(projectNos);
        }
        if (projectNos != null && projectNos.isEmpty()) {
            return PageVo.def(new ArrayList<>());
        }
        orderExampleCriteria.andCompanyIdEqualTo(companyId);
        orderExample.setOrderByClause(" create_time desc ");
        long total = designerOrderMapper.countByExample(orderExample);
        PageHelper.startPage(pageIndex, pageSize);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.isEmpty()) {
            return PageVo.def(new ArrayList<>());
        }
        List<DesignerOrderVo> designerOrderVos = getDesignerOrderVos(stateType, designerOrders);
        PageVo<List<DesignerOrderVo>> pageVo = new PageVo<>();
        pageVo.setPageSize(pageSize);
        pageVo.setTotal(total);
        pageVo.setData(designerOrderVos);
        pageVo.setPageIndex(pageIndex);
        return pageVo;
    }

    /**
     * 数据拼接
     * @param stateType
     * @param designerOrders
     * @return
     */
    private List<DesignerOrderVo> getDesignerOrderVos(int stateType, List<DesignerOrder> designerOrders) {
        List<String> companyIds;
        List<String> projectNos;
        List<DesignerOrderVo> designerOrderVos = new ArrayList<>();
        Map<String, DesignerStyleConfigVo> designerStyleConfigMap = queryDesignerStyleConfig();
        companyIds = ReflectUtils.getList(designerOrders, "companyId");
        projectNos = ReflectUtils.getList(designerOrders, "projectNo");
        OrderUserExample userExample = new OrderUserExample();
        userExample.createCriteria().andProjectNoIn(projectNos);
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(userExample);
        List<String> userIds = ReflectUtils.getList(orderUsers, "userId");
        Map<String, CompanyInfo> companyInfoMap = getCompanyByIds(companyIds);
        Map<String, UserMsgVo> msgVoMap = userService.queryUserMap(userIds);
        Map<String, Project> projectMap = getProjectMap(projectNos);
        Map<String, String> provinceMap = basicsService.getProvince();
        Map<String, String> cityMap = basicsService.getCity();
        Map<String, String> areaMap = basicsService.getArea();
        List<BasicsData> projectSourceList = basicsService.queryData(BasicsDataParentEnum.PROJECT_SOURCE.getCode());
        Map<String,BasicsData> projectSourceMap = ReflectUtils.listToMap(projectSourceList,"basicsCode");
        List<BasicsData> huxingList = basicsService.queryData(BasicsDataParentEnum.HOUSE_STRUCTURE.getCode());
        Map<String,BasicsData> huxingMap = ReflectUtils.listToMap(huxingList,"basicsCode");
        String ownerRoleCode = roleFunctionService.queryRoleCode(RoleFunctionEnum.OWNER_POWER);
        String designerRoleCode = roleFunctionService.queryRoleCode(RoleFunctionEnum.DESIGN_POWER);
        Map<String,OrderUser> orderUserMap = getOrderUserMap(orderUsers, ownerRoleCode, designerRoleCode);
        List<String> staffIds = new ArrayList<>();
        for (DesignerOrder designerOrder : designerOrders) {
            CompanyInfo companyInfo = companyInfoMap.get(designerOrder.getCompanyId());
            Project project = projectMap.get(designerOrder.getProjectNo());
            DesignerOrderVo designerOrderVo = getDesignerOrderVo(companyInfo, stateType, designerStyleConfigMap, designerOrder, project,
                    msgVoMap, projectSourceMap, huxingMap, orderUserMap, ownerRoleCode, designerRoleCode);
            designerOrderVo.setProvinceName(provinceMap.get(project.getProvince()));
            designerOrderVo.setCityName(cityMap.get(project.getCity()));
            designerOrderVo.setRegionName(areaMap.get(project.getRegion()));
            designerOrderVo.setCompanyId(designerOrder.getCompanyId());
            staffIds.add(designerOrderVo.getDesignerName());
            designerOrderVos.add(designerOrderVo);
        }
        queryStaffMsg(designerOrderVos, staffIds);
        return designerOrderVos;
    }

    private void queryStaffMsg(List<DesignerOrderVo> designerOrderVos, List<String> staffIds) {
        EmployeeMsgExample employeeMsgExample = new EmployeeMsgExample();
        employeeMsgExample.createCriteria().andUserIdIn(staffIds);
        List<EmployeeMsg> employeeMsgs = employeeMsgMapper.selectByExample(employeeMsgExample);
        Map<String,EmployeeMsg> employeeMsgMap = ReflectUtils.listToMap(employeeMsgs,"userId");
        for(DesignerOrderVo designerOrderVo : designerOrderVos){
            EmployeeMsg employeeMsg = employeeMsgMap.get(designerOrderVo.getDesignerName());
            if(employeeMsg == null){
                continue;
            }
            designerOrderVo.setDesignerName(employeeMsg.getRealName());
        }
    }

    private List<String> getProjectNos(String provinceCode, String cityCode, String areaCode, String projectNo, String orderSource, String money, List<String> queryProjectNo, String designerName) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectCriteria = projectExample.createCriteria();
        int conditionNum = 0;
        List<String> eProjectNos = queryProjectNoAndDesignerName(designerName);
        if(eProjectNos != null && eProjectNos.isEmpty()){
            return new ArrayList<>();
        }
        if(eProjectNos != null && !eProjectNos.isEmpty()){
            projectCriteria.andProjectNoIn(eProjectNos);
            conditionNum++;
        }
        if (StringUtils.isNotBlank(provinceCode)) {
            projectCriteria.andProvinceEqualTo(provinceCode);
            conditionNum++;
        }
        if (StringUtils.isNotBlank(cityCode)) {
            projectCriteria.andCityEqualTo(cityCode);
            conditionNum++;
        }
        if (StringUtils.isNotBlank(areaCode)) {
            projectCriteria.andRegionEqualTo(areaCode);
            conditionNum++;
        }
        if (StringUtils.isNotBlank(orderSource)) {
            projectCriteria.andOrderSourceEqualTo(Integer.parseInt(orderSource));
            conditionNum++;
        }
        if (StringUtils.isNotBlank(projectNo)) {
            projectCriteria.andProjectNoLike(projectNo);
            conditionNum++;
        }
        if (StringUtils.isNotBlank(money)) {
            projectCriteria.andDecorationBudgetEqualTo(Integer.parseInt(money));
            conditionNum++;
        }
        if (!queryProjectNo.isEmpty()) {
            projectCriteria.andProjectNoIn(queryProjectNo);
            conditionNum++;
        }
        if (conditionNum == 0) {
            return null;
        }
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<String> projectNos = ReflectUtils.getList(projects, "projectNo");
        return projectNos;
    }

    private List<String> queryProjectNoAndDesignerName(String designerName){
        if(StringUtils.isBlank(designerName)){
            return null;
        }
        EmployeeMsgExample employeeMsgExample = new EmployeeMsgExample();
        employeeMsgExample.createCriteria().andRealNameLike("%" + designerName + "%");
        List<EmployeeMsg> employeeMsgs = employeeMsgMapper.selectByExample(employeeMsgExample);
        if(employeeMsgs.isEmpty()){
            return new ArrayList<>();
        }
        OrderUserExample userExample = new OrderUserExample();
        userExample.createCriteria().andUserIdIn(ReflectUtils.getList(employeeMsgs,"userId"));
        List<OrderUser> userList = orderUserMapper.selectByExample(userExample);
        return ReflectUtils.getList(userList, "projectNo");
    }

    private List<String> queryProjectNos(String userMsg) {
        if (StringUtils.isBlank(userMsg)) {
            return new ArrayList<>();
        }
        List<UserMsgVo> msgVos = userService.queryUserMsg(userMsg);
        if (msgVos.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> userIds = ReflectUtils.getList(msgVos, "userId");
        OrderUserExample userExample = new OrderUserExample();
        userExample.createCriteria().andUserIdIn(userIds);
        List<OrderUser> userList = orderUserMapper.selectByExample(userExample);
        return ReflectUtils.getList(userList, "projectNo");
    }

    /**
     * @param companyState 0入驻中 1资质待审核 2资质审核通过 3资质审核不通过4财务审核中5财务审核成功6财务审核失败7待交保证金8入驻成功
     * @return
     */
    private List<String> queryCompanyIds(int companyState, String companyName) {
        if (companyState < 0 && StringUtils.isBlank(companyName)) {
            return null;
        }
        CompanyInfoExample infoExample = new CompanyInfoExample();
        CompanyInfoExample.Criteria criteria = infoExample.createCriteria();
        if(companyState >= 0){
            criteria.andAuditStatusEqualTo(companyState + "");
        }
        if(StringUtils.isNotBlank(companyName)){
            criteria.andCompanyNameLike("%" + companyName + "%");
        }
        List<CompanyInfo> companyInfos = companyInfoMapper.selectByExample(infoExample);
        return ReflectUtils.getList(companyInfos, "companyId");
    }

    /**
     * 根据公司ID查询公司信息
     *
     * @param companyIds
     * @return
     */
    private Map<String, CompanyInfo> getCompanyByIds(List<String> companyIds) {
        if (companyIds == null || companyIds.isEmpty()) {
            return new HashMap<>();
        }
        CompanyInfoExample infoExample = new CompanyInfoExample();
        CompanyInfoExample.Criteria criteria = infoExample.createCriteria();
        criteria.andCompanyIdIn(companyIds);
        List<CompanyInfo> companyInfos = companyInfoMapper.selectByExample(infoExample);
        return ReflectUtils.listToMap(companyInfos, "companyId");
    }

    /**
     * 返回一个设计订单详情
     *
     * @param stateType              1获取平台状态，2获取设计公司状态，3获取设计师状态，4获取消费者状态
     * @param designerStyleConfigMap
     * @param designerOrder          设计订单信息
     * @param project                项目信息
     * @param msgVoMap               用户信息
     * @return
     */
    private DesignerOrderVo getDesignerOrderVo(
            CompanyInfo companyInfo, int stateType, Map<String, DesignerStyleConfigVo> designerStyleConfigMap, DesignerOrder designerOrder,
            Project project, Map<String, UserMsgVo> msgVoMap, Map<String,BasicsData> projectSourceMap, Map<String,BasicsData> huxingMap,
            Map<String,OrderUser> orderUserMap, String ownerRoleCode, String designerRoleCode) {
        DesignerOrderVo designerOrderVo = new DesignerOrderVo();
        designerOrderVo.setProjectNo(project.getProjectNo());
        designerOrderVo.setDesignOrderNo(designerOrder.getOrderNo());
        OrderUser orderUser = orderUserMap.get(ownerRoleCode + "-" + project.getProjectNo());
        UserMsgVo ownerMsg = null;
        if(orderUser != null){
            String ownerId = orderUser.getUserId();
            ownerMsg = msgVoMap.get(ownerId);
        }
        if (ownerMsg != null) {
            designerOrderVo.setOwnerName(ownerMsg.getUserName());
            designerOrderVo.setOwnerPhone(ownerMsg.getUserPhone());
        }
        designerOrderVo.setAddress(project.getAddressDetail());
        try {
            BasicsData basicsData = projectSourceMap.get(project.getOrderSource() + "");
            String sourceName = null;
            if (basicsData != null) {
                sourceName = basicsData.getBasicsName();
            }
            designerOrderVo.setOrderSource(sourceName);
        } catch (Exception e) {
            designerOrderVo.setOrderSource("未知");
        }
        try {
            BasicsData huxing = huxingMap.get(project.getHouseHuxing() + "");
            String huxingName = null;
            if (huxing != null) {
                huxingName = huxing.getBasicsName();
            }
            designerOrderVo.setHuxing(huxingName);
        } catch (Exception e) {
            designerOrderVo.setHuxing("未知");
        }
        if (project.getCreateTime() != null) {
            designerOrderVo.setCreateTime(project.getCreateTime().getTime() + "");
        }
        DesignerStyleConfigVo designerStyleConfig = designerStyleConfigMap.get(designerOrder.getStyleType());
        if (designerStyleConfig != null) {
            designerOrderVo.setStyleName(designerStyleConfig.getStyleName());
        }
        designerOrderVo.setBudget(project.getDecorationBudget() + "");
        designerOrderVo.setArea(project.getArea() + "");
        if (companyInfo != null) {
            designerOrderVo.setCompanyName(companyInfo.getCompanyName());
            designerOrderVo.setCompanyState(companyInfo.getAuditStatus());
        }
        orderUser = orderUserMap.get(designerRoleCode + "-" + project.getProjectNo());
        String designerId = null;
        if(orderUser != null){
            designerId = orderUser.getUserId();
            designerOrderVo.setDesignerName(designerId);
        }
        try {
            designerOrderVo.setOrderStateName(DesignStateEnum.queryByState(designerOrder.getOrderStage()).getStateName(stateType));
        } catch (Exception e) {
            designerOrderVo.setOrderStateName("未知");
        }
        designerOrderVo.setOrderState(designerOrder.getOrderStage() + "");
        designerOrderVo.setProjectMoney(project.getDecorationBudget() + "");
        OptionLogExample logExample = new OptionLogExample();
        logExample.createCriteria().andLinkNoEqualTo(designerOrder.getOrderNo()).andOptionTypeEqualTo("DO");
        logExample.setOrderByClause(" option_time desc limit 1");
        List<OptionLog> optionLogs = optionLogMapper.selectByExample(logExample);
        if (!optionLogs.isEmpty()) {
            OptionLog optionLog = optionLogs.get(0);
            designerOrderVo.setOptionUserName(optionLog.getOptionUserName());
            designerOrderVo.setOptionTime(optionLog.getOptionTime().getTime() + "");
        }
        return designerOrderVo;
    }

    /**
     * 查询设计风格
     *
     * @return
     */
    private Map<String, DesignerStyleConfigVo> queryDesignerStyleConfig() {
        List<DesignerStyleConfigVo> styleConfigs = designerService.queryDesignerStyle();
        return ReflectUtils.listToMap(styleConfigs, "styleCode");
    }

    @Override
    public void designerOrderExcel(Integer orderTpye, String companyId, String projectNo, String userMsg, String orderSource, String createTimeStart, String createTimeEnd,
                                   String styleCode, String provinceCode, String cityCode, String areaCode, String money, String acreage, int designerOrderState, int companyState, String optionUserName,
                                   String optionTimeStart, String optionTimeEnd, int stateType, String fileName, HttpServletResponse response,String branchCompanyCode,String cityBranchCode,String storeCode) {
        PageVo<List<DesignerOrderVo>> pageVo = queryDesignerOrder(null, orderTpye, companyId, projectNo, userMsg, orderSource, createTimeStart, createTimeEnd, styleCode,
                provinceCode, cityCode, areaCode, money, acreage, designerOrderState, companyState, optionUserName, optionTimeStart, optionTimeEnd, 1000000, 1, stateType, null, null,branchCompanyCode, cityBranchCode, storeCode);

        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("序号", "订单编号", "订单子编号", "业主姓名", "业主电话", "所在地", "订单来源", "创建时间",
                "装饰风格", "建筑面积", "建筑预算", "归属设计公司", "公司状态", "归属设计师", "订单状态", "操作人", "操作时间"));
        List<DesignerOrderVo> DesignerOrderVos = pageVo.getData();
        int index = 1;
        for (DesignerOrderVo DesignerOrderVo : DesignerOrderVos) {
            List<String> excelContent = new ArrayList<>();
            excelContent.add(index + "");
            excelContent.add(DesignerOrderVo.getProjectNo());
            excelContent.add(DesignerOrderVo.getDesignOrderNo());
            excelContent.add(DesignerOrderVo.getOwnerName());
            excelContent.add(DesignerOrderVo.getOwnerPhone());
            excelContent.add(DesignerOrderVo.getAddress());
            excelContent.add(DesignerOrderVo.getOrderSource());
            excelContent.add(DesignerOrderVo.getCreateTime());
            excelContent.add(DesignerOrderVo.getStyleName());
            excelContent.add(DesignerOrderVo.getArea());
            excelContent.add(DesignerOrderVo.getBudget());
            excelContent.add(DesignerOrderVo.getCompanyName());
            excelContent.add(DesignerOrderVo.getCompanyState());
            excelContent.add(DesignerOrderVo.getDesignerName());
            excelContent.add(DesignerOrderVo.getOrderStateName());
            excelContent.add(DesignerOrderVo.getOptionUserName());
            excelContent.add(DesignerOrderVo.getOptionTime());
            lists.add(excelContent);
            index++;
        }
        ExcelUtil.loadExcel(lists, fileName, response);
    }

    /**
     * 合同审核通过
     *
     * @param orderNo      设计订单编号
     * @param contractType 合同类型，1全款合同，2分期合同
     */
    @Override
    public void reviewPass(String orderNo, int contractType) {
        if (contractType != 1 && contractType != 2) {
            throw new RuntimeException("必须声明合同类型");
        }
        DesignStateEnum stateEnum = DesignStateEnum.STATE_220;
        if (contractType == 2) {
            stateEnum = DesignStateEnum.STATE_140;
        }
        DesignerOrder designerOrder = queryDesignerOrderByOrderNo(orderNo);
        Project project = queryProjectByNo(designerOrder.getProjectNo());
//        if (!designerOrder.getCompanyId().equals(companyId)) {
//            throw new RuntimeException("无权操作");
//        }
        DesignerOrder updateOrder = new DesignerOrder();
        updateOrder.setId(designerOrder.getId());
        updateOrder.setContractType(contractType);
        updateOrder.setOrderStage(stateEnum.getState());
        designerOrderMapper.updateByPrimaryKeySelective(updateOrder);
        //记录操作日志
        saveOptionLog(designerOrder.getOrderNo(), "system", "system", "合同审核通过");
        saveLog(stateEnum.getState(), project);
        updateProjectState(project.getProjectNo(), stateEnum.getState());
        // 支付阶段通知
        /*constructionAndPayStateService.notifyPay(designerOrder.getOrderNo(), 1);*/
    }

    @Override
    public void setDesignId(String projectNo, String designId, String designerId) {
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        //查询设计师
        String userId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.DESIGN_POWER);
        if (userId == null || !userId.equals(designerId)) {
            throw new RuntimeException("无权操作");
        }
        DesignerOrder updateOrder = new DesignerOrder();
        updateOrder.setDesignId(designId);
        updateOrder.setId(designerOrder.getId());
        designerOrderMapper.updateByPrimaryKeySelective(updateOrder);
    }

    /**
     * 创建施工订单
     *
     * @param projectNo
     */
    @Override
    public void createConstructionOrder(String projectNo) {
        Project project = queryProjectByNo(projectNo);
        ConstructionOrder constructionOrder = new ConstructionOrder();
        constructionOrder.setOrderNo(OrderNoUtils.getNo("CO"));
        constructionOrder.setCreateTime(new Date());
        constructionOrder.setProjectNo(projectNo);
        constructionOrder.setStatus(1);
        constructionOrder.setOrderStage(ConstructionStateEnum.STATE_500.getState());
        // 1小包，2大包
        if (project.getContractType() != null && project.getContractType() == 2) {
            DesignerOrder designerOrders = queryDesignerOrder(projectNo);
            String companyId = designerOrders.getCompanyId();
            constructionOrder.setCompanyId(companyId);
            constructionOrder.setSchemeNo(buildConfigService.getSchemeNoByCompanyId(companyId));
            constructionOrder.setOrderStage(ConstructionStateEnum.STATE_510.getState());
        }
        constructionOrderMapper.insertSelective(constructionOrder);
        updateProjectState(projectNo, constructionOrder.getOrderStage());
        projectStageLogService.create(projectNo, constructionOrder.getOrderStage());
    }

    /**
     * 不指派
     *
     * @param projectNo      项目编号
     * @param reason         不派单原因
     * @param optionUserId   操作人ID
     * @param optionUserName 操作人姓名
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void notDispatch(String projectNo, String reason, String optionUserId, String optionUserName) {
        if (StringUtils.isBlank(reason)) {
            throw new RuntimeException("必须填写不派单原因");
        }
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrders = queryDesignerOrder(projectNo);
        checkOrderState(designerOrders, DesignStateEnum.STATE_CLOSE_PLATFORM);
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        updateOrder.setOrderStage(DesignStateEnum.STATE_CLOSE_PLATFORM.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrders.getOrderNo());
        List<DesignerOrder> designerOrderList = designerOrderMapper.selectByExample(orderExample);
        if (designerOrderList.size() > 0 && designerOrderList.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //记录操作日志
        saveOptionLog(designerOrders.getOrderNo(), optionUserId, optionUserName, reason);
        saveLog(DesignStateEnum.STATE_CLOSE_PLATFORM.getState(), project);
        updateProjectState(projectNo, DesignStateEnum.STATE_CLOSE_PLATFORM.getState());

    }

    /**
     * 指派设计公司
     *
     * @param projectNo      项目编号
     * @param companyId      公司ID
     * @param optionUserId   操作人ID
     * @param optionUserName 操作人姓名
     * @param contractType   承包类型，1小包，2大包
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void dispatch(String projectNo, String companyId, String optionUserId, String optionUserName, int contractType) {
        Project project = queryProjectByNo(projectNo);
        project.setContractType(contractType);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        //设置该设计订单所属公司
        checkOrderState(designerOrder, DesignStateEnum.STATE_10);
        DesignerOrder updateOrder = new DesignerOrder();
        updateOrder.setCompanyId(companyId);
        updateOrder.setOrderStage(DesignStateEnum.STATE_10.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //记录操作日志
        String remark = "指派订单给公司【" + companyId + "】";
        saveOptionLog(designerOrder.getOrderNo(), optionUserId, optionUserName, remark);
        saveLog(DesignStateEnum.STATE_10.getState(), project);
        updateProjectState(projectNo, DesignStateEnum.STATE_10.getState());
        orderNoticeService.sendPlatformDispatch(companyId, projectNo, "设计订单");
    }

    @Override
    public PcDesignOrderMsgVo queryDesignerOrderVoByProjectNo(String projectNo, int stateType) {
        PcDesignOrderMsgVo pcDesignOrderMsgVo = new PcDesignOrderMsgVo();
        Map<String, DesignerStyleConfigVo> designerStyleConfigMap = queryDesignerStyleConfig();
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        Project project = queryProjectByNo(projectNo);
        List<Map<String, Object>> stateMaps = DesignStateEnum.allState(designerOrder.getOrderStage());
        pcDesignOrderMsgVo.setStateMaps(stateMaps);
        pcDesignOrderMsgVo.setOrderState(designerOrder.getOrderStage());
        String contractUrl = getContractUrl(designerOrder.getOrderNo());
        if (contractUrl != null) {
            pcDesignOrderMsgVo.setContractName("居然设计家设计合同");
            pcDesignOrderMsgVo.setContractUrl(contractUrl);
        }
        List<String> userIds = new ArrayList<>();
        userIds.add(projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.OWNER_POWER));
        userIds.add(projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.DESIGN_POWER));
        Map<String, UserMsgVo> msgVoMap = userService.queryUserMap(userIds);
        Map<String, CompanyInfo> companyInfoMap = getCompanyByIds(Arrays.asList(designerOrder.getCompanyId()));
        List<BasicsData> projectSourceList = basicsService.queryData(BasicsDataParentEnum.PROJECT_SOURCE.getCode());
        Map<String,BasicsData> projectSourceMap = ReflectUtils.listToMap(projectSourceList,"basicsCode");
        List<BasicsData> huxingList = basicsService.queryData(BasicsDataParentEnum.HOUSE_STRUCTURE.getCode());
        Map<String,BasicsData> huxingMap = ReflectUtils.listToMap(huxingList,"basicsCode");
        String ownerRoleCode = roleFunctionService.queryRoleCode(RoleFunctionEnum.OWNER_POWER);
        String designerRoleCode = roleFunctionService.queryRoleCode(RoleFunctionEnum.DESIGN_POWER);
        OrderUserExample userExample = new OrderUserExample();
        userExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(userExample);
        Map<String,OrderUser> orderUserMap = getOrderUserMap(orderUsers, ownerRoleCode, designerRoleCode);
        DesignerOrderVo designerOrderVo = getDesignerOrderVo(companyInfoMap.get(designerOrder.getCompanyId()), stateType, designerStyleConfigMap, designerOrder,
                project, msgVoMap, projectSourceMap, huxingMap, orderUserMap, ownerRoleCode, designerRoleCode);
        EmployeeMsg employeeMsg = employeeMsgMapper.selectByPrimaryKey(designerOrderVo.getDesignerName());
        if(employeeMsg != null){
            designerOrderVo.setDesignerName(employeeMsg.getRealName());
        }
        Map<String, String> provinceMap = basicsService.getProvince(project.getProvince());
        Map<String, String> cityMap = basicsService.getCity(project.getCity());
        Map<String, String> areaMap = basicsService.getArea(project.getRegion());
        designerOrderVo.setProvinceName(provinceMap.get(project.getProvince()));
        designerOrderVo.setCityName(cityMap.get(project.getCity()));
        designerOrderVo.setRegionName(areaMap.get(project.getRegion()));
        DesignStateEnum stateEnum = DesignStateEnum.queryByState(designerOrder.getOrderStage());
        DesignOrderDelVo designOrderDelVo = new DesignOrderDelVo(1, stateEnum.getStateName(stateType),
                "", "小区名称", designerOrder.getProjectNo());
        designOrderDelVo = ReflectUtils.beanCopy(designerOrderVo, designOrderDelVo);
        pcDesignOrderMsgVo.setDesignerOrderVo(designOrderDelVo);
        designOrderDelVo.setPeopleNo(project.getPeopleNo() + "");
        if(designerOrder.getVolumeRoomTime() != null){
            pcDesignOrderMsgVo.setVolumeRoomDate(designerOrder.getVolumeRoomTime().getTime());
        }
        if(designerOrder.getVolumeRoomMoney() != null){
            pcDesignOrderMsgVo.setVolumeRoomMoney((designerOrder.getVolumeRoomMoney() / 100) + "");
        }
        List<DesignOrderPayMsgVo> payMsgVos = getPayMsgVos(designerOrder.getOrderNo());
        pcDesignOrderMsgVo.setPayMsgVos(payMsgVos);
        pcDesignOrderMsgVo.setDataVolume(getProjectData(designerOrder.getProjectNo(), 1));
        pcDesignOrderMsgVo.setData3D(getProjectData(designerOrder.getProjectNo(), 2));
        pcDesignOrderMsgVo.setDataCons(getProjectData(designerOrder.getProjectNo(), 3));
        return pcDesignOrderMsgVo;
    }

    private List<ProjectData> getProjectData(String projectNo, int dataType) {
        ProjectDataExample dataExample = new ProjectDataExample();
        dataExample.createCriteria().andProjectNoEqualTo(projectNo).andTypeEqualTo(dataType).andStatusEqualTo(1);
        return projectDataMapper.selectByExample(dataExample);
    }

    private String getContractUrl(String orderNo) {
        OrderContractExample contractExample = new OrderContractExample();
        contractExample.createCriteria().andOrderNumberEqualTo(orderNo).andAuditTypeEqualTo(("1"));
        List<OrderContract> contracts = orderContractMapper.selectByExample(contractExample);
        if (contracts.isEmpty()) {
            return null;
        }
        return contracts.get(0).getConractUrlPdf();
    }

    /**
     * 查询支付信息
     *
     * @param orderNo
     * @return
     */
    private List<DesignOrderPayMsgVo> getPayMsgVos(String orderNo) {
        FundsOrderExample fundsOrderExample = new FundsOrderExample();
        fundsOrderExample.createCriteria().andFromOrderidEqualTo(orderNo);
        fundsOrderExample.setOrderByClause(" sort,update_time asc ");
        List<FundsOrder> fundsOrders = fundsOrderMapper.selectByExample(fundsOrderExample);
        if (fundsOrders == null || fundsOrders.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> orderIds = ReflectUtils.getList(fundsOrders, "orderNo");
        FundsFlowExample fundsFlowExample = new FundsFlowExample();
        fundsFlowExample.createCriteria().andOrderIdIn(orderIds);
        List<FundsFlow> fundsFlows = fundsFlowMapper.selectByExample(fundsFlowExample);
        Map<String, FundsFlow> fundsFlowMap = ReflectUtils.listToMap(fundsFlows, "orderId");
        List<DesignOrderPayMsgVo> payMsgVos = new ArrayList<>();
        for (FundsOrder fundsOrder : fundsOrders) {
            DesignOrderPayMsgVo payMsgVo = new DesignOrderPayMsgVo();
            payMsgVo.setTypeSubName(fundsOrder.getTypeSubName());
            payMsgVo.setDiscountMoney(fundsOrder.getCouponAmount());
            payMsgVo.setReceivableMoney(fundsOrder.getActualAmount());
            FundsFlow fundsFlow = fundsFlowMap.get(fundsOrder.getOrderNo());
            if (fundsFlow != null) {
                payMsgVo.setAcceptedMoney(fundsFlow.getActualAmount());
                if (fundsFlow.getTraceSuccessTime() != null) {
                    payMsgVo.setPayTime(fundsFlow.getTraceSuccessTime());
                }
                payMsgVo.setState(1);
            } else {
                payMsgVo.setState(2);
            }
            payMsgVo.setSerialNumber(fundsOrder.getOrderNo());
            payMsgVos.add(payMsgVo);
        }
        return payMsgVos;
    }

    /**
     * 设计公司拒绝接单
     *
     * @param projectNo      项目编号
     * @param companyId      设计公司ID
     * @param reason         拒绝原因
     * @param optionUserId   操作人ID
     * @param optionUserName 操作人名称
     */
    @Override
    public void refuseOrder(String projectNo, String companyId, String reason, String optionUserId, String optionUserName) {
        if (StringUtils.isBlank(reason)) {
            throw new RuntimeException("必须填写不接单原因");
        }
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        if (!designerOrder.getCompanyId().equals(companyId)) {
            throw new RuntimeException("无权操作");
        }
        checkOrderState(designerOrder, DesignStateEnum.STATE_1);
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        updateOrder.setCompanyId("");
        updateOrder.setOrderStage(DesignStateEnum.STATE_1.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //记录操作日志
        String remark = "公司编号为【" + companyId + "】的公司拒绝接单，拒绝原因：" + reason;
        saveOptionLog(designerOrder.getOrderNo(), optionUserId, optionUserName, remark);
        saveLog(DesignStateEnum.STATE_1.getState(), project);
        updateProjectState(projectNo, DesignStateEnum.STATE_1.getState());
    }

    /**
     * 设计公司指派设计师
     *
     * @param projectNo      项目编号
     * @param companyId      公司ID
     * @param designerUserId 设计师ID
     * @param optionUserId   操作人ID
     * @param optionUserName 操作人名称
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void assignDesigner(String projectNo, String companyId, String designerUserId, String optionUserId, String optionUserName) {
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        if (!designerOrder.getCompanyId().equals(companyId)) {
            throw new RuntimeException("无权操作");
        }
        checkOrderState(designerOrder, DesignStateEnum.STATE_20);
        //添加设计师
        projectUserService.addUserId(designerOrder.getOrderNo(), designerOrder.getProjectNo(), designerUserId, RoleFunctionEnum.DESIGN_POWER);
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        updateOrder.setOrderStage(DesignStateEnum.STATE_20.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //记录操作日志
        String remark = "公司编号为【" + companyId + "】的公司指派设计师";
        saveOptionLog(designerOrder.getOrderNo(), optionUserId, optionUserName, remark);
        saveLog(DesignStateEnum.STATE_20.getState(), project);
        updateProjectState(projectNo, DesignStateEnum.STATE_20.getState());
        orderNoticeService.sendCompanyDispatch(designerUserId, projectNo);
    }

    /**
     * 设计师拒绝接单
     *
     * @param projectNo      项目编号
     * @param reason         拒绝原因
     * @param designerUserId 设计师ID
     */
    @Override
    public void designerRefuse(String projectNo, String reason, String designerUserId) {
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        //查询设计师
        String userId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.DESIGN_POWER);
        if (userId == null || !userId.equals(designerUserId)) {
            throw new RuntimeException("无权操作");
        }
        checkOrderState(designerOrder, DesignStateEnum.STATE_10);
        queryDesignerMsg(designerUserId);
        EmployeeMsg employeeMsg = queryEmployeeMsg(designerUserId);
        String optionUserName = employeeMsg.getRealName();
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        //清空设计师ID
        //updateOrder.setUserId("");
        projectUserService.delUserRel(designerOrder.getOrderNo(), designerOrder.getProjectNo(), designerUserId, RoleFunctionEnum.DESIGN_POWER);
        updateOrder.setOrderStage(DesignStateEnum.STATE_10.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //TODO 需要发出通知给设计师
        //记录操作日志
        String remark = "设计师【" + optionUserName + "】拒绝接单";
        saveOptionLog(designerOrder.getOrderNo(), designerUserId, optionUserName, remark);
        saveLog(DesignStateEnum.STATE_10.getState(), project);
        updateProjectState(projectNo, DesignStateEnum.STATE_10.getState());
        orderNoticeService.sendDesignerNoReceipt(designerOrder.getCompanyId(), projectNo, optionUserName);
    }

    /**
     * 设计师接单
     *
     * @param projectNo      项目编号
     * @param designerUserId 设计师ID
     */
    @Override
    public void designerReceipt(String projectNo, String designerUserId) {
        //设计师接单
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        //查询设计师
        String userId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.DESIGN_POWER);
        if (userId == null || !userId.equals(designerUserId)) {
            throw new RuntimeException("无权操作");
        }
        checkOrderState(designerOrder, DesignStateEnum.STATE_30);
        queryDesignerMsg(designerUserId);
        EmployeeMsg employeeMsg = queryEmployeeMsg(designerUserId);
        String optionUserName = employeeMsg.getRealName();
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        //清空设计师ID
        updateOrder.setOrderStage(DesignStateEnum.STATE_30.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //TODO 需要发出通知给设计师
        //记录操作日志
        String remark = "设计师【" + optionUserName + "】已接单";
        saveOptionLog(designerOrder.getOrderNo(), designerUserId, optionUserName, remark);
        saveLog(DesignStateEnum.STATE_30.getState(), project);
        updateProjectState(projectNo, DesignStateEnum.STATE_30.getState());
        String ownerId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.OWNER_POWER);
        orderNoticeService.sendDesignerReceipt(ownerId, projectNo);
    }

    /**
     * 设计师发起量房预约
     *
     * @param projectNo      项目编号
     * @param designerUserId 设计师ID
     * @param volumeRoomDate 预约时间
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void makeAnAppointmentVolumeRoom(String projectNo, String designerUserId, String volumeRoomDate, String appointmentAmount) {
        //设计师接单
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        String userId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.DESIGN_POWER);
        if (userId == null || !userId.equals(designerUserId)) {
            throw new RuntimeException("无权操作");
        }
        checkOrderState(designerOrder, STATE_40);
        queryDesignerMsg(designerUserId);
        EmployeeMsg employeeMsg = queryEmployeeMsg(designerUserId);
        String optionUserName = employeeMsg.getRealName();
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        //清空设计师ID
        updateOrder.setOrderStage(STATE_40.getState());
        Date date = DateUtils.strToDate(volumeRoomDate, "yyyy-MM-dd");
        if (date.getTime() == 0) {
            throw new RuntimeException("无效的预约时间");
        }
        updateOrder.setVolumeRoomTime(date);
        //预约金额
        updateOrder.setVolumeRoomMoney(MathUtil.getFen(appointmentAmount));
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //TODO 需要发出通知给业主
        //记录操作日志
        String remark = "设计师【" + optionUserName + "】发起量房预约";
        saveOptionLog(designerOrder.getOrderNo(), designerUserId, optionUserName, remark);
        saveLog(STATE_40.getState(), project);

        updateProjectState(projectNo, STATE_40.getState());
    }

    @Override
    public void remindOwner(String projectNo, String designerUserId) {
        //设计师接单
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        String userId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.DESIGN_POWER);
        if (userId == null || !userId.equals(designerUserId)) {
            throw new RuntimeException("无权操作");
        }
        RemindOwnerLogExample logExample = new RemindOwnerLogExample();
        //24小时内只能提示一次
        logExample.createCriteria().andDesignerOrderNoEqualTo(designerOrder.getOrderNo())
                .andRemindTimeGreaterThanOrEqualTo(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24));
        List<RemindOwnerLog> remindOwnerLogs = remindOwnerLogMapper.selectByExample(logExample);
        if (!remindOwnerLogs.isEmpty()) {
            throw new RuntimeException("每24小时能只能提醒一次~");
        }
        String ownerId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.OWNER_POWER);
        if (ownerId == null) {
            throw new RuntimeException("没有查询到业主信息");
        }
        RemindOwnerLog remindOwnerLog = new RemindOwnerLog();
        remindOwnerLog.setDesignerOrderNo(designerOrder.getOrderNo());
        remindOwnerLog.setOwnerId(ownerId);
        remindOwnerLog.setRemindTime(new Date());
        sendMessage(project.getProjectNo(), userId, remindOwnerLog.getOwnerId(), "请支付支付量房费");
        remindOwnerLogMapper.insertSelective(remindOwnerLog);
    }

    /**
     * @return
     * @Author jiang
     * @Description 提醒业主支付量房费
     * @Date
     * @Param
     **/
    private void sendMessage(String projectNo, String sendUserId, String subUserId, String content) {
        Map<String, String> requestMsg = new HashMap<>();
        requestMsg.put("projectNo", projectNo);
        requestMsg.put("userNo", "[\"" + subUserId + "\"]");
        requestMsg.put("senderId", sendUserId);
        requestMsg.put("content", content);
        requestMsg.put("dynamicId", "0");
        requestMsg.put("type", "2");
        LOGGER.info("发送消息：requestMsg：{}", requestMsg);
        try {
            HttpUtils.HttpRespMsg respMsg = HttpUtils.post(httpLinks.getMessageSave(), requestMsg);
            LOGGER.info("respMsg:{}", JSONUtil.bean2JsonStr(respMsg));
        } catch (Exception e) {
            LOGGER.error("发送消息出错", e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateOrderState(String projectNo, int orderState, String optionId, String optionName) {
        //设计师接单
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        DesignStateEnum stateEnum = DesignStateEnum.queryByState(orderState);
        checkOrderState(designerOrder, stateEnum);
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        //清空设计师ID
        updateOrder.setOrderStage(orderState);
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //TODO 需要发出通知给业主
        //记录操作日志
        String remark = stateEnum.getLogText();
        saveOptionLog(designerOrder.getOrderNo(), optionId, optionName, remark);
        saveLog(stateEnum.getState(), project);
        updateProjectState(projectNo, orderState);
        if (orderState == DesignStateEnum.STATE_170.getState()) {
            // 支付阶段通知
            constructionAndPayStateService.notifyPay(designerOrder.getOrderNo(), 2);
        }
        if (orderState == DesignStateEnum.STATE_200.getState()) {
            // 支付阶段通知
            constructionAndPayStateService.notifyPay(designerOrder.getOrderNo(), 3);
        }
    }

    @Override
    public void updateOrderState(String projectNo, int orderState, String optionId, String optionName, String reason) {
        //设计师接单
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        DesignStateEnum stateEnum = DesignStateEnum.queryByState(orderState);
        checkOrderState(designerOrder, stateEnum);
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        //清空设计师ID
        updateOrder.setOrderStage(orderState);
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //TODO 需要发出通知给业主
        //记录操作日志
        saveOptionLog(designerOrder.getOrderNo(), optionId, optionName, reason);
        saveLog(stateEnum.getState(), project);
        updateProjectState(projectNo, orderState);
        if (orderState == DesignStateEnum.STATE_170.getState()) {
            // 支付阶段通知
            constructionAndPayStateService.notifyPay(designerOrder.getOrderNo(), 2);
        }
        if (orderState == DesignStateEnum.STATE_200.getState()) {
            // 支付阶段通知
            constructionAndPayStateService.notifyPay(designerOrder.getOrderNo(), 3);
        }
    }

    @Override
    public void confirmedDeliveries(String projectNo, String optionId) {
        //设计师接单
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrders = queryDesignerOrder(projectNo);
        checkOrderState(designerOrders, DesignStateEnum.STATE_70);
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        //清空设计师ID
        updateOrder.setOrderStage(DesignStateEnum.STATE_70.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrders.getOrderNo());
        List<DesignerOrder> designerOrderList = designerOrderMapper.selectByExample(orderExample);
        if (designerOrderList.size() > 0 && designerOrderList.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //TODO 需要发出通知给业主
        //记录操作日志
        String remark = DesignStateEnum.STATE_70.getLogText();
        saveOptionLog(designerOrders.getOrderNo(), optionId, "业主", remark);
        saveLog(DesignStateEnum.STATE_70.getState(), project);
        updateProjectState(projectNo, DesignStateEnum.STATE_70.getState());
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void paySuccess(String orderNo) {
        //设计师接单
        DesignerOrder designerOrder = queryDesignerOrderByOrderNo(orderNo);
        Project project = queryProjectByNo(designerOrder.getProjectNo());
        DesignStateEnum designStateEnum = DesignStateEnum.queryByState(designerOrder.getOrderStage());
        LOGGER.info("订单编号：{}，订单状态：{}", orderNo, designStateEnum.getState());
        //设置该设计订单所属公司
        DesignerOrder updateOrder = new DesignerOrder();
        DesignStateEnum stateEnum = null;
        switch (designStateEnum) {
            case STATE_45:
                stateEnum = DesignStateEnum.STATE_50;
                break;
            case STATE_142:
                stateEnum = DesignStateEnum.STATE_150;
                saveFundsSettleAccountsNodeLog(designerOrder, "6");
                break;
            case STATE_170:
                stateEnum = DesignStateEnum.STATE_180;
                saveFundsSettleAccountsNodeLog(designerOrder, "7");
                break;
            case STATE_200:
                stateEnum = DesignStateEnum.STATE_210;
                saveFundsSettleAccountsNodeLog(designerOrder, "8");
                break;
            case STATE_222:
                stateEnum = DesignStateEnum.STATE_230;
                saveFundsSettleAccountsNodeLog(designerOrder, "6");
                break;
            default:
                throw new RuntimeException("无效的状态");
        }
        updateOrder.setOrderStage(stateEnum.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //TODO 需要发出通知给业主
        //记录操作日志
        String remark = stateEnum.getLogText();
        saveOptionLog(designerOrder.getOrderNo(), "system", "system", remark);
        saveLog(stateEnum.getState(), project);
        updateProjectState(project.getProjectNo(), stateEnum.getState());
    }


    @Override
    public void payTimeOut(String projectNo) {
        //设计师接单
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        DesignStateEnum designStateEnum = DesignStateEnum.queryByState(designerOrder.getOrderStage());
        DesignStateEnum timeOutState = null;
        switch (designStateEnum) {
            case STATE_40:
                timeOutState = DesignStateEnum.STATE_42;
                break;
            case STATE_140:
                timeOutState = DesignStateEnum.STATE_141;
                break;
            case STATE_170:
                timeOutState = DesignStateEnum.STATE_171;
                break;
            case STATE_220:
                timeOutState = DesignStateEnum.STATE_221;
                break;
            default:
                throw new RuntimeException("无效的订单状态");
        }
        updateOrderState(projectNo, timeOutState.getState(), "system", "system");
        saveLog(timeOutState.getState(), project);
    }

    /**
     * 业主发起终止订单操作
     *
     * @param projectNo 项目编号
     * @param userId    用户Id
     * @param reason    终止合同原因
     */
    @Override
    public void endOrder(String projectNo, String userId, String reason) {
        //设计师接单
        Project project = queryProjectByNo(projectNo);
        DesignerOrder designerOrder = queryDesignerOrder(projectNo);
        if (!project.getOwnerId().equals(userId)) {
            throw new RuntimeException("无权操作");
        }
        DesignStateEnum stateEnum = null;
        try {
            stateEnum = stateEnum(DesignStateEnum.queryByState(designerOrder.getOrderStage()));
            checkOrderState(designerOrder, stateEnum);
        } catch (Exception e) {
            throw new RuntimeException("当前订单不可取消，如有疑问，请联系客服");
        }
        DesignerOrder updateOrder = new DesignerOrder();
        //清空设计师ID
        updateOrder.setOrderStage(stateEnum.getState());
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designerOrder.getOrderNo());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0).getComplaintState() == 2) {
            throw new RuntimeException("客诉处理中");
        }
        designerOrderMapper.updateByExampleSelective(updateOrder, orderExample);
        //TODO 需要发出通知给业主
        //记录操作日志
        String remark = stateEnum.getLogText();
        saveOptionLog(designerOrder.getOrderNo(), userId, "业主", remark);
        saveLog(stateEnum.getState(), project);
        updateProjectState(projectNo, stateEnum.getState());
    }

    /**
     * 获取关闭订单的状态值
     *
     * @param stateEnum
     * @return
     */
    private DesignStateEnum stateEnum(DesignStateEnum stateEnum) {
        switch (stateEnum) {
            case STATE_1:
                return DesignStateEnum.STATE_ORDER_END_3;
            case STATE_10:
                return DesignStateEnum.STATE_ORDER_END_11;
            case STATE_20:
                return DesignStateEnum.STATE_ORDER_END_21;
            case STATE_30:
                return DesignStateEnum.STATE_ORDER_END_31;
            case STATE_40:
                return DesignStateEnum.STATE_ORDER_END_41;
            case STATE_45:
                return DesignStateEnum.STATE_ORDER_END_46;
            default:
                throw new RuntimeException("无效的订单状态值");
        }
    }

    /**
     * 检查设计订单状态
     *
     * @param DesignerOrder   设计订单
     * @param designStateEnum 目标状态
     */
    @Override
    public void checkOrderState(DesignerOrder DesignerOrder, DesignStateEnum designStateEnum) {
        int orderState = DesignerOrder.getOrderStage();
        DesignStateEnum currentState = DesignStateEnum.queryByState(orderState);
        if (!currentState.getNextStates().contains(designStateEnum)) {
            throw new RuntimeException("不能进行该操作");
        }
    }

    /**
     * 根据设计师ID查询设计师信息,1审核通过的
     *
     * @param designerUserId 设计师ID
     * @return
     */
    private DesignerMsg queryDesignerMsg(String designerUserId) {
        DesignerMsgExample msgExample = new DesignerMsgExample();
        msgExample.createCriteria().andUserIdEqualTo(designerUserId).andReviewStateEqualTo(2);
        List<DesignerMsg> designerMsgs = designerMsgMapper.selectByExample(msgExample);
        if (designerMsgs.isEmpty()) {
            return createDesignerMsg(designerUserId);
        }
        return designerMsgs.get(0);
    }

    private DesignerMsg createDesignerMsg(String designerUserId) {
        DesignerMsg designerMsg = new DesignerMsg();
        designerMsg.setUserId(designerUserId);
        designerMsg.setVolumeRoomMoney(new BigDecimal(100));
        designerMsg.setDesignerMoneyLow(new BigDecimal(100));
        designerMsg.setDesignerMoneyHigh(new BigDecimal(100));
        designerMsg.setIdentity(Long.parseLong("1"));
        designerMsg.setTag(Long.parseLong("1"));
        designerMsg.setReviewState(2);
        designerMsg.setLevel(Long.parseLong("1"));
        designerMsgMapper.insertSelective(designerMsg);
        return designerMsg;
    }

    /**
     * 根据设计师ID查询员工信息，1已实名认证，2在职
     *
     * @param employeeMsgId 员工ID
     * @return
     */
    private EmployeeMsg queryEmployeeMsg(String employeeMsgId) {
        EmployeeMsgExample msgExample = new EmployeeMsgExample();
        msgExample.createCriteria().andUserIdEqualTo(employeeMsgId).andEmployeeStateEqualTo(1).andAuthStateEqualTo(2);
        List<EmployeeMsg> employeeMsgs = employeeMsgMapper.selectByExample(msgExample);
        if (employeeMsgs.isEmpty()) {
            throw new RuntimeException("没有查询到员工");
        }
        return employeeMsgs.get(0);
    }

    /**
     * 记录操作日志
     *
     * @param orderNo        记录订单编号
     * @param optionUserId   操作人ID
     * @param optionUserName 操作人姓名
     * @param remark         备注
     */
    private void saveOptionLog(String orderNo, String optionUserId, String optionUserName, String remark) {
        //记录操作日志
        OptionLog optionLog = new OptionLog();
        optionLog.setLinkNo(orderNo);
        optionLog.setOptionTime(new Date());
        optionLog.setOptionType("DO");
        optionLog.setOptionUserId(optionUserId);
        optionLog.setOptionUserName(optionUserName);
        optionLog.setRemark(remark);
        optionLogMapper.insertSelective(optionLog);
    }

    /**
     * 根据项目编号查询项目信息
     *
     * @param projectNo 项目编号
     * @return
     */
    @Override
    public Project queryProjectByNo(String projectNo) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        if (projects.isEmpty()) {
            throw new RuntimeException("没有查询到该项目");
        }
        return projects.get(0);
    }

    /**
     * 根据项目编号查询设计订单
     *
     * @param projectNo 项目编号
     * @return
     */
    @Override
    public DesignerOrder queryDesignerOrder(String projectNo) {
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andProjectNoEqualTo(projectNo).andStatusEqualTo(1);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.isEmpty()) {
            throw new RuntimeException("没有查询到相关设计订单");
        }
        return designerOrders.get(0);
    }

    /**
     * 根据项目编号查询设计订单
     *
     * @param orderNo 设计订单编号
     * @return
     */
    @Override
    public DesignerOrder queryDesignerOrderByOrderNo(String orderNo) {
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(orderNo).andStatusEqualTo(1);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.isEmpty()) {
            throw new RuntimeException("没有查询到相关设计订单");
        }
        return designerOrders.get(0);
    }

    /**
     * 记录操作日志
     *
     * @param state   设计订单状态
     * @param project 项目信息
     */
    private void saveLog(int state, Project project) {
        ProjectStageLog stageLog = new ProjectStageLog();
        stageLog.setCreateTime(new Date());
        stageLog.setStage(state);
        stageLog.setProjectNo(project.getProjectNo());
        stageLog.setBeginTime(new Date());
        stageLog.setType(project.getContractType());
        stageLogMapper.insertSelective(stageLog);
    }

    /**
     * @param designOrderNo 设计订单编号
     * @return ["LFYY(量房预约),LFFY(提醒支付量房费用)","LFZL(提交量房资料)",
     * "SJZL(提交设计资料)","SGZL(提交施工资料)","CKHT(查看合同)","YJD(预交底)","ZSG(转施工)"]
     */
    @Override
    public List<String> showBtn(String designOrderNo) {
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designOrderNo).andStatusEqualTo(1);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.isEmpty()) {
            throw new RuntimeException("无效的订单编号");
        }
        DesignerOrder designerOrder = designerOrders.get(0);
        DesignStateEnum stateEnum = DesignStateEnum.queryByState(designerOrder.getOrderStage());
        List<String> btns = new ArrayList<>();
        switch (stateEnum) {
            case STATE_30:
                btns.add("LFYY");
            case STATE_45:
                btns.add("LFFY");
                break;
            case STATE_50:
                btns.add("LFZL");
                break;
/*            case STATE_140:
            case STATE_160:
            case STATE_170:
            case STATE_190:
            case STATE_210:
            case STATE_220:
            case STATE_240:
            case STATE_260:*/
            case STATE_150:
            case STATE_230:
                btns.add("SJZL");
                break;
            case STATE_180:
            case STATE_250:
                btns.add("SGZL");
                break;
        }
        OrderContractExample orderContractExample = new OrderContractExample();
        OrderContractExample.Criteria criteria = orderContractExample.createCriteria();
        criteria.andOrderNumberEqualTo(designOrderNo);
        //合同类型 02设计合同, 03施工合同
        criteria.andContractTypeEqualTo("02");
        //审批状态：0：不通过 1：通过2：审核中
        criteria.andAuditTypeEqualTo("1");
        List<OrderContract> orderContracts = orderContractMapper.selectByExample(orderContractExample);

        if (stateEnum == DesignStateEnum.STATE_270 || stateEnum == DesignStateEnum.STATE_210) {
            if (designerOrder.getPreviewState() == 2) {
                btns.add("YJD");
            }
        }
        if (orderContracts.size() > 0) {
            btns.add("CKHT");
        }
        return btns;
    }

    /**
     * @param designOrderNo 设计订单编号
     * @return ["LFYY(量房预约),LFFY(提醒支付量房费用)","LFZL(提交量房资料)",
     * "SJZL(提交设计资料)","SGZL(提交施工资料)","CKHT(查看合同)","YJD(预交底)"]
     */
    @Override
    public List<String> showBtnByUserId(String projectNo, String designOrderNo, String userId) {
        OrderUserExample orderUserExample = new OrderUserExample();
        OrderUserExample.Criteria criteria1 = orderUserExample.createCriteria().andOrderNoEqualTo(designOrderNo).andRoleCodeEqualTo("CC");
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(orderUserExample);
        OrderUser orderUser = orderUsers.get(0);
        String designerId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.DESIGN_POWER);
        OrderContractExample orderContractExample = new OrderContractExample();
        OrderContractExample.Criteria criteria = orderContractExample.createCriteria();
        criteria.andOrderNumberEqualTo(designOrderNo);
        //合同类型 02设计合同, 03施工合同
        criteria.andContractTypeEqualTo("02");
        //审批状态：0：不通过 1：通过2：审核中
        criteria.andAuditTypeEqualTo("1");
        List<OrderContract> orderContracts = orderContractMapper.selectByExample(orderContractExample);
        List<String> btns = new ArrayList<>();
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(designOrderNo).andStatusEqualTo(1);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.isEmpty()) {
            throw new RuntimeException("无效的订单编号");
        }
        DesignerOrder designerOrder = designerOrders.get(0);
        DesignStateEnum stateEnum = DesignStateEnum.queryByState(designerOrder.getOrderStage());
        if (designerId != null && userId.equals(designerId)) {
            switch (stateEnum) {
                case STATE_30:
                    btns.add("LFYY");
                case STATE_45:
                    btns.add("LFFY");
                    break;
                case STATE_50:
                    btns.add("LFZL");
                    break;
                case STATE_150:
                case STATE_230:
                    btns.add("SJZL");
                    break;
                case STATE_180:
                case STATE_250:
                    btns.add("SGZL");
                    break;
            }
            //判断是否存在施工订单
            ConstructionOrderExample constructionExample = new ConstructionOrderExample();
            ConstructionOrderExample.Criteria constructionCriteria = constructionExample.createCriteria();
            constructionCriteria.andProjectNoEqualTo(designerOrder.getProjectNo());
            List<ConstructionOrder> constructionOrders = constructionOrderMapper.selectByExample(constructionExample);
            if (stateEnum == DesignStateEnum.STATE_270 || stateEnum == DesignStateEnum.STATE_210) {
                if (designerOrder.getPreviewState() == 2 && constructionOrders.size() > 0) {
                    btns.add("YJD");
                } else if (designerOrder.getPreviewState() == 2 && constructionOrders.size() == 0) {
                    btns.add("ZSG");
                }
            }
            if (orderContracts.size() > 0) {
                btns.add("CKHT");
            }
        } else if (orderUser.getUserId() != null && userId.equals(orderUser.getUserId())) {
            if (orderContracts.size() > 0) {
                btns.add("CKHT");
            } else if (stateEnum == STATE_40) {
                btns.add("LFYY");
            }
        }
        return btns;
    }


    @Override
    public void updateProjectState(String projectNo, int state) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectNoEqualTo(projectNo);
        Project project = new Project();
        project.setStage(state);
        projectMapper.updateByExampleSelective(project, projectExample);
    }

    @Override
    public ContractMsgVo queryContractMsg(String projectNo) {
        Project project = queryProjectByNo(projectNo);
        CompanyInfoVo companyInfo = getCompanyMsg(projectNo);
        String ownerId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.OWNER_POWER);
        UserMsgVo userMsgVo = userService.queryUser(ownerId);
        ContractMsgVo contractMsgVo = new ContractMsgVo();
        contractMsgVo.setOwnerAddress(project.getAddressDetail());
        contractMsgVo.setOwnerCardNo(userMsgVo.getMemberEcode());
        contractMsgVo.setOwnerEmaile("");
        contractMsgVo.setOwnerName(userMsgVo.getUserName());
        contractMsgVo.setOwnerPhone(userMsgVo.getUserPhone());
        contractMsgVo.setCompanyName(companyInfo.getCompanyName());
        contractMsgVo.setCompanyLegalPerson(companyInfo.getLegalName());
        contractMsgVo.setCompanyOrganizationCode(companyInfo.getOrganizationCode());
        return contractMsgVo;
    }

    /**
     * 设计师发起量房预约详情页
     *
     * @param projectNo
     * @return
     */
    @Override
    public MyRespBundle<VolumeReservationDetailsVO> queryVolumeReservationDetails(String projectNo) {
        if (projectNo == null || projectNo.trim().isEmpty()) {
            return RespData.error("projectNo 不可为空!");
        }
        VolumeReservationDetailsVO volumeReservationDetailsVO = new VolumeReservationDetailsVO();
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andProjectNoEqualTo(projectNo);
        List<Project> projects = projectMapper.selectByExample(example);
        if (projects.size() == 0) {
            return RespData.error("项目不存在!!");
        }
        Project project = projects.get(0);
        //添加业主信息
        PersionVo owner = new PersionVo();
        try {
            Map userName1 = newOrderUserService.getUserName(project.getOwnerId(), ProjectDataStatus.OWNER.getDescription());
            owner.setPhone(userName1.get("phone").toString());
            owner.setName(userName1.get("nickName").toString());
        } catch (Exception e) {
            e.printStackTrace();
            return RespData.error("调取人员信息失败!");
        }
        volumeReservationDetailsVO.setOwnerName(owner.getName());
        volumeReservationDetailsVO.setOwnerPhone(owner.getPhone());
        DesignerOrderExample designerOrderExample = new DesignerOrderExample();
        DesignerOrderExample.Criteria designCriteria = designerOrderExample.createCriteria();
        designCriteria.andProjectNoEqualTo(projectNo);
        designCriteria.andStatusEqualTo(ProjectDataStatus.BASE_STATUS.getValue());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(designerOrderExample);
        if (designerOrders.size() == ProjectDataStatus.INSERT_FAILD.getValue()) {
            return RespData.error("查无此设计订单");
        }
        DesignerOrder designerOrder = designerOrders.get(0);
        OrderPlayVo designOrderPlayVo = designerOrderMapper.selectByProjectNoAndStatus(projectNo, ProjectDataStatus.BASE_STATUS.getValue());
        String designerId = projectUserService.queryUserIdOne(projectNo, RoleFunctionEnum.DESIGN_POWER);
        List<PersionVo> persionVos = employeeMsgMapper.selectByUserId(designerId);
        if (persionVos.size() > 0 && persionVos.get(0) != null) {
            volumeReservationDetailsVO.setDesignerName(persionVos.get(0).getName());
        }
        volumeReservationDetailsVO.setDesignOrderNo(designerOrder.getOrderNo());
        //订单来源
        switch (project.getOrderSource()) {
            case 1:
                volumeReservationDetailsVO.setOrderSource("天猫");
                break;
            case 10:
                volumeReservationDetailsVO.setOrderSource("线下导入");
                break;
            case 20:
                volumeReservationDetailsVO.setOrderSource("运营平台创建");
                break;
            case 30:
                volumeReservationDetailsVO.setOrderSource("运营平台导入");
                break;
            case 40:
                volumeReservationDetailsVO.setOrderSource("设计公司创建");
                break;
            case 50:
                volumeReservationDetailsVO.setOrderSource("设计公司导入");
                break;
            default:
                volumeReservationDetailsVO.setOrderSource("其他");
                break;
        }

        volumeReservationDetailsVO.setHouseType(getHouseTypeNum(projectNo));
        volumeReservationDetailsVO.setPermanentResidents(project.getPeopleNo());
        volumeReservationDetailsVO.setArea(project.getArea());
        volumeReservationDetailsVO.setCompanyName(designOrderPlayVo.getConstructionCompany());
        volumeReservationDetailsVO.setPropertyType(project.getHouseType() == 1 ? "新房" : "旧房");
        volumeReservationDetailsVO.setDecorationLocation(project.getAddressDetail());
        volumeReservationDetailsVO.setMeasuringRoomLocation(project.getAddressDetail());
        if (designerOrder.getVolumeRoomTime() != null) {
            volumeReservationDetailsVO.setVolumeRoomDate(designerOrder.getVolumeRoomTime().getTime());
        }
        if (designerOrder.getVolumeRoomMoney() != null) {
            volumeReservationDetailsVO.setAppointmentAmount(MathUtil.getYuan(designerOrder.getVolumeRoomMoney()));
        }
        return RespData.success(volumeReservationDetailsVO);
    }

    private CompanyInfoVo getCompanyMsg(String projectNo) {
        CompanyInfoVo companyInfo;
        ConstructionOrderExample constructionOrderExample = new ConstructionOrderExample();
        constructionOrderExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<ConstructionOrder> constructionOrders = constructionOrderMapper.selectByExample(constructionOrderExample);
        String companyId = null;
        if (!constructionOrders.isEmpty()) {
            companyId = constructionOrders.get(0).getCompanyId();
        } else {
            return null;
        }
        companyInfo = companyInfoMapper.selectByCompanyId(companyId);
        return companyInfo;
    }

    /**
     * app-C端确认量房
     *
     * @param projectNo
     * @param userId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MyRespBundle confirmeVolumeRoom(String projectNo, String userId) {
        if (projectNo == null || projectNo.trim().isEmpty()) {
            return RespData.error("projectNo 不可为空!");
        }
        if (userId == null || userId.trim().isEmpty()) {
            return RespData.error("userId 不可为空!");
        }
        DesignerOrderExample designerOrderExample = new DesignerOrderExample();
        DesignerOrderExample.Criteria designCriteria = designerOrderExample.createCriteria();
        designCriteria.andProjectNoEqualTo(projectNo);
        designCriteria.andStatusEqualTo(ProjectDataStatus.BASE_STATUS.getValue());
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(designerOrderExample);
        if (designerOrders.size() == ProjectDataStatus.INSERT_FAILD.getValue()) {
            return RespData.error("查无此设计订单");
        }
        DesignerOrder designerOrder = designerOrders.get(0);
        updateOrderState(projectNo, DesignStateEnum.STATE_45.getState(), userId, "");
        createPayOrderService.createVolumeRoomPay(projectNo, MathUtil.getYuan(designerOrder.getVolumeRoomMoney()));
        if (designerOrder.getVolumeRoomMoney() != null && designerOrder.getVolumeRoomMoney() == 0) {
            paySuccess(designerOrder.getOrderNo());
        }
        return RespData.success();
    }

    @Override
    public PageVo<List<ContractListItemVo>> designContract(
            String contractNo, String projectNo, String orderSource, String provinceCode, String cityCode, String areaCode,
            String contractState, String signTimeS, String signTimeE, String ownerMsg, String branchCompanyCode, String cityBranchCode, String storeCode, int pageSize, int pageIndex) {
        List<String> projectNos = null;
        if (StringUtils.isNotBlank(ownerMsg)) {
            List<UserMsgVo> userMsgVos = userService.queryUserMsg(ownerMsg);
            if (userMsgVos == null || userMsgVos.isEmpty()) {
                return PageVo.def(new ArrayList<>());
            }
            List<String> userIds = ReflectUtils.getList(userMsgVos, "consumerId");
            OrderUserExample userExample = new OrderUserExample();
            userExample.createCriteria().andUserIdIn(userIds);
            List<OrderUser> userList = orderUserMapper.selectByExample(userExample);
            if (userList.isEmpty()) {
                return PageVo.def(new ArrayList<>());
            }
            projectNos = ReflectUtils.getList(userList, "projectNo");
        }
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        int whereNum = 0;
        if (StringUtils.isNotBlank(projectNo)) {
            criteria.andProjectNoLike("%" + projectNo + "%");
            whereNum++;
        }
        if (StringUtils.isNotBlank(orderSource)) {
            criteria.andOrderSourceEqualTo(Integer.parseInt(orderSource));
            whereNum++;
        }
        if (StringUtils.isNotBlank(provinceCode)) {
            criteria.andProvinceEqualTo(provinceCode);
            whereNum++;
        }
        if (StringUtils.isNotBlank(cityCode)) {
            criteria.andCityEqualTo(cityCode);
            whereNum++;
        }
        if (StringUtils.isNotBlank(areaCode)) {
            criteria.andRegionEqualTo(areaCode);
            whereNum++;
        }
        if (projectNos != null && !projectNos.isEmpty()) {
            criteria.andProjectNoIn(projectNos);
            whereNum++;
        }
        List<String> designOrders = null;
        if (whereNum > 0) {
            List<Project> projects = projectMapper.selectByExample(projectExample);
            if (projects.isEmpty()) {
                return PageVo.def(new ArrayList<>());
            }
            projectNos = ReflectUtils.getList(projects, "projectNo");
            DesignerOrderExample orderExample = new DesignerOrderExample();
            orderExample.createCriteria().andProjectNoIn(projectNos);
            List<DesignerOrder> orders = designerOrderMapper.selectByExample(orderExample);
            if (orders.isEmpty()) {
                return PageVo.def(new ArrayList<>());
            }
            designOrders = ReflectUtils.getList(orders, "orderNo");
        }
        OrderContractExample contractExample = new OrderContractExample();
        OrderContractExample.Criteria contractCriteria = contractExample.createCriteria();
        contractCriteria.andContractTypeEqualTo("02");
        if (StringUtils.isNotBlank(contractNo)) {
            contractCriteria.andContractNumberLike("%" + contractNo + "%");
        }
        if (StringUtils.isNotBlank(contractState)) {
            contractCriteria.andAuditTypeEqualTo(contractState);
        }
        if (StringUtils.isNotBlank(signTimeS)) {
            contractCriteria.andSignTimeGreaterThanOrEqualTo(DateUtil.formateToDate(signTimeS, "yyyy-MM-dd"));
        }
        if (StringUtils.isNotBlank(signTimeE)) {
            contractCriteria.andSignTimeLessThanOrEqualTo(DateUtil.formateToDate(signTimeE, "yyyy-MM-dd"));
        }
        if (designOrders != null && !designOrders.isEmpty()) {
            contractCriteria.andOrderNumberIn(designOrders);
        }
        List<String> observeCompanyIds = getCompanyIds();
        if(observeCompanyIds != null && observeCompanyIds.isEmpty()){
            return PageVo.def(new ArrayList<>());
        }
        if(observeCompanyIds != null){
            contractCriteria.andCompanyIdIn(observeCompanyIds);
        }
        long total = orderContractMapper.countByExample(contractExample);
        if (total <= 0) {
            return PageVo.def(new ArrayList<>());
        }
        PageHelper.startPage(pageIndex, pageSize);
        List<OrderContract> orderContracts = orderContractMapper.selectByExample(contractExample);
        List<String> contractNos = new ArrayList<>();
        for (OrderContract orderContract : orderContracts) {
            contractNos.add(orderContract.getContractNumber());
        }
        ContractTermsExample termsExample = new ContractTermsExample();
        termsExample.createCriteria().andContractNumberIn(contractNos).andContractDictCodeEqualTo("c16");
        List<ContractTerms> termsList = contractTermsMapper.selectByExample(termsExample);
        Map<String, String> contractMoneyMap = ReflectUtils.listToMap(termsList, "contractNumber", "contractValue");
        designOrders = ReflectUtils.getList(orderContracts, "orderNumber");
        Map<String, Project> projectMap = getProjectByDesignerOrderNo(designOrders);
        Map<String, UserMsgVo> userMsgVoMap = getOwnerMsg(designOrders);
        List<String> orderSources = new ArrayList<>();
        List<ContractListItemVo> itemVos = new ArrayList<>();
        List<String> companyIds = new ArrayList<>();
        for (OrderContract contract : orderContracts) {
            companyIds.add(contract.getCompanyId());
        }
        List<CompanyCitySiteVO> companyList = companyInfoMapper.selectCompanyCitySiteByCompanyId(companyIds,branchCompanyCode,cityBranchCode,storeCode);
        for (OrderContract contract : orderContracts) {
            ContractListItemVo itemVo = new ContractListItemVo();
            Project project = projectMap.get(contract.getOrderNumber());
           for(CompanyCitySiteVO company:companyList){
               if(contract.getCompanyId()!=null && company.getCompanyId()!=null){
                   if(contract.getCompanyId().equals(company.getCompanyId())){
                       itemVo.setBranchCompanyName(company.getBranchCompanyName());
                       itemVo.setCityBranchName(company.getCityBranchName());
                       itemVo.setStoreName(company.getStoreName());
                   }
               }
           }
            if (project != null) {
                itemVo.setAddress(project.getAddressDetail());
                orderSources.add(project.getOrderSource() + "");
                itemVo.setOrderSource(project.getOrderSource() + "");
                itemVo.setProjectNo(project.getProjectNo());
                itemVo.setProvinceName(project.getProvince());
                itemVo.setAreaName(project.getRegion());
                itemVo.setCityName(project.getCity());
            }
            if (contract.getSignTime() != null) {
                itemVo.setCreateTime(contract.getSignTime().getTime() + "");
            }
            UserMsgVo userMsgVo = userMsgVoMap.get(contract.getOrderNumber());
            if (userMsgVo != null) {
                itemVo.setOwnerName(userMsgVo.getUserName());
                itemVo.setOwnerPhone(userMsgVo.getUserPhone());
            }
            itemVo.setContractState(contract.getAuditType());
            itemVo.setContractUrl(contract.getConractUrlPdf());
            itemVo.setContractNo(contract.getContractNumber());
            itemVo.setChildNo(contract.getOrderNumber());
            itemVo.setMoney(contractMoneyMap.get(contract.getContractNumber()));
            itemVos.add(itemVo);
        }
        List<BasicsData> basicsDatas = basicsService.queryData(BasicsDataParentEnum.PROJECT_SOURCE.getCode(), orderSources);
        Map<String, BasicsData> basicsDataMap = ReflectUtils.listToMap(basicsDatas, "basicsCode");
        for (int i = 0; i < itemVos.size(); i++) {
            BasicsData basicsData = basicsDataMap.get(itemVos.get(i).getOrderSource());
            if (basicsData != null) {
                itemVos.get(i).setOrderSource(basicsData.getBasicsName());
            }
        }
        PageVo<List<ContractListItemVo>> pageVo = new PageVo();
        pageVo.setData(itemVos);
        pageVo.setTotal(total);
        pageVo.setPageIndex(pageIndex);
        pageVo.setPageSize(pageSize);
        return pageVo;
    }

    @Override
    public DesignContractToVo getDesigneContractInfo(String orderNo) {
        DesignContractToVo resVo = new DesignContractToVo();
        //查询订单信息
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(orderNo);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        if (designerOrders.size() > 0 && designerOrders.get(0) != null) {
            ProjectExample projectExample = new ProjectExample();
            projectExample.createCriteria().andProjectNoEqualTo(designerOrders.get(0).getProjectNo());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            //查询业主
            AfUserDTO customerInfo = AfUtils.getUserInfo(httpLinks.getUserCenterGetUserMsg(), projects.get(0).getOwnerId(), Role.CC.id);
            //业主姓名
            resVo.setOwnerName(customerInfo.getUsername());
            //业主手机号码
            resVo.setOwnerTel(customerInfo.getPhone());

            //设计师相关信息
            if (designerOrders.get(0).getUserId() != null) {
                AfUserDTO customerInfoOne = AfUtils.getUserInfo(httpLinks.getUserCenterGetUserMsg(), designerOrders.get(0).getUserId(), Role.CD.id);

                resVo.setDesignerTel(customerInfoOne.getPhone());
            }
            //设计师名称
            String designerId = projectUserService.queryUserIdOne(projects.get(0).getProjectNo(), RoleFunctionEnum.DESIGN_POWER);
            EmployeeMsg employeeMsg = employeeMsgMapper.selectByPrimaryKey(designerId);
            if (employeeMsg != null) {
                resVo.setDesignerName(employeeMsg.getRealName());

            }
            Map<String, String> provinceMap = basicsService.getProvince();
            Map<String, String> cityMap = basicsService.getCity();
            Map<String, String> areaMap = basicsService.getArea();
            //省
            resVo.setProvince(provinceMap.get(projects.get(0).getProvince()) == null ? "" : provinceMap.get(projects.get(0).getProvince()));
            //市
            resVo.setCity(cityMap.get(projects.get(0).getCity()) == null ? "" : cityMap.get(projects.get(0).getCity()));
            //区
            resVo.setRegion(areaMap.get(projects.get(0).getArea()) == null ? "" : provinceMap.get(projects.get(0).getArea()));
            //地址详情
            resVo.setAddressDetail(projects.get(0).getAddressDetail());
            //建筑面积
            resVo.setArea(String.valueOf(projects.get(0).getArea()));
            //设计费金额

            BigDecimal a;
            BigDecimal b;
            a = new BigDecimal(designerOrders.get(0).getVolumeRoomMoney());
            b = new BigDecimal(1000);
            resVo.setVolumeRoomMoney(designerOrders.get(0).getVolumeRoomMoney() == null ? "0" : (String.valueOf(a.divide(b, 2, RoundingMode.HALF_UP))));
            //合同类型
            resVo.setContractType(String.valueOf(designerOrders.get(0).getContractType()));
            //
            CompanyInfoExample example = new CompanyInfoExample();
            example.createCriteria().andCompanyIdEqualTo(designerOrders.get(0).getCompanyId());
            List<CompanyInfo> list = companyInfoMapper.selectByExample(example);
            //设计公司名称
            resVo.setDesignName(list.get(0) == null ? "" : list.get(0).getCompanyName());
            //  resVo.setProjectName(projects.get(0)!=null?""projects.get(0).getp);
        }

        return resVo;
    }

    private Map<String, UserMsgVo> getOwnerMsg(List<String> designOrders) {
        String roleCode = roleFunctionService.queryRoleCode(RoleFunctionEnum.OWNER_POWER);
        OrderUserExample userExample = new OrderUserExample();
        userExample.createCriteria().andOrderNoIn(designOrders).andRoleCodeEqualTo(roleCode);
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(userExample);
        List<String> userIds = ReflectUtils.getList(orderUsers, "userId");
        List<UserMsgVo> userMsgVos = userService.queryUsers(userIds);
        Map<String, UserMsgVo> userMsgVoMap0 = ReflectUtils.listToMap(userMsgVos, "consumerId");
        Map<String, UserMsgVo> userMsgVoMap = new HashMap<>();
        for (OrderUser orderUser : orderUsers) {
            UserMsgVo userMsgVo = userMsgVoMap0.get(orderUser.getUserId());
            userMsgVoMap.put(orderUser.getOrderNo(), userMsgVo);
        }
        return userMsgVoMap;
    }

    private Map<String, Project> getProjectByDesignerOrderNo(List<String> designOrders) {
        DesignerOrderExample orderExample = new DesignerOrderExample();
        orderExample.createCriteria().andOrderNoIn(designOrders);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(orderExample);
        Map<String, String> orderNoMap = ReflectUtils.listToMap(designerOrders, "projectNo", "orderNo");
        List<String> projectNos = ReflectUtils.getList(designerOrders, "projectNo");
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectNoIn(projectNos);
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<String> provinceCodes = new ArrayList<>();
        List<String> cityCodes = new ArrayList<>();
        List<String> areaCodes = new ArrayList<>();
        for (Project project : projects) {
            provinceCodes.add(project.getProvince());
            cityCodes.add(project.getCity());
            areaCodes.add(project.getRegion());
        }
        Map<String, String> provinceMap = basicsService.getProvince(provinceCodes.toArray(new String[]{}));
        Map<String, String> cityMap = basicsService.getCity(cityCodes.toArray(new String[]{}));
        Map<String, String> areaMap = basicsService.getArea(areaCodes.toArray(new String[]{}));
        Map<String, Project> projectMap = new HashMap<>();
        for (Project project : projects) {
            String designerNo = orderNoMap.get(project.getProjectNo());
            project.setProvince(provinceMap.get(project.getProvince()));
            if (project.getProvince() == null || project.getProvince().contains("null")) {
                project.setProvince("");
            }
            project.setCity(cityMap.get(project.getCity()));
            if (project.getCity() == null || project.getCity().contains("null")) {
                project.setCity("");
            }
            project.setRegion(areaMap.get(project.getRegion()));
            if (project.getRegion() == null || project.getRegion().contains("null")) {
                project.setRegion("");
            }
            projectMap.put(designerNo, project);
        }
        return projectMap;
    }

    /**
     * @param designerOrder
     * @param nodeNo
     */
    private void saveFundsSettleAccountsNodeLog(DesignerOrder designerOrder, String nodeNo) {
        FundsSettleAccountsNodeLog nodeLog = new FundsSettleAccountsNodeLog();
        nodeLog.setCompanyId(designerOrder.getCompanyId());
        nodeLog.setCompletionDate(DateUtil.formartDate(new Date(), DateUtil.FORMAT_YYMMDD));
        nodeLog.setNodeNo(nodeNo);
        nodeLog.setOrderNo(designerOrder.getOrderNo());
        nodeLog.setProjectNo(designerOrder.getProjectNo());
        nodeLog.setDesignerCompanyId(designerOrder.getCompanyId());
        fundsSettleAccountsNodeLogMapper.insertSelective(nodeLog);
    }

    /**
     * @return
     * @Author jiang
     * @Description
     * @Date
     * @Param orderNo 设计订单编号
     * @Param 合同类型，1全款合同，2分期款合同
     * 类型:1同意 2不同意
     **/
    @Override
    public void contractApproval(String orderNo,Integer type, int contractType) {
        if (contractType != 1 && contractType != 2) {
            throw new RuntimeException("必须声明合同类型");
        }
        if (type != 1 && type != 2) {
            throw new RuntimeException("必须是否同意");
        }
        DesignStateEnum stateEnum = DesignStateEnum.STATE_222;
        //业主不同意
        if(type == 2 && contractType == 2){
            stateEnum = DesignStateEnum.STATE_140;
        } else if (type == 2 && contractType == 1){
            stateEnum = DesignStateEnum.STATE_220;
        }else {
            //业主同意
            if (type == 1 && contractType == 2) {
                stateEnum = DesignStateEnum.STATE_142;
            } else {
                stateEnum = DesignStateEnum.STATE_222;
            }
        }
        DesignerOrder designerOrder = queryDesignerOrderByOrderNo(orderNo);
        Project project = queryProjectByNo(designerOrder.getProjectNo());
//        if (!designerOrder.getCompanyId().equals(companyId)) {
//            throw new RuntimeException("无权操作");
//        }
        DesignerOrder updateOrder = new DesignerOrder();
        updateOrder.setId(designerOrder.getId());
        updateOrder.setContractType(contractType);
        updateOrder.setOrderStage(stateEnum.getState());
        designerOrderMapper.updateByPrimaryKeySelective(updateOrder);
        //记录操作日志
        saveOptionLog(designerOrder.getOrderNo(), "system", "system", "合同审核通过");
        saveLog(stateEnum.getState(), project);
        updateProjectState(project.getProjectNo(), stateEnum.getState());
      // 支付阶段通知
        /*constructionAndPayStateService.notifyPay(designerOrder.getOrderNo(), 1);*/

    }
    /**
     * @Author jiang
     * @Description 返回是否能撤换设计师 0不能 1能
     * @Date
     * @Param orderNo
     * @return
     **/
    @Override
    public Integer replaceDesigners(String orderNo) {
        if(StringUtils.isBlank(orderNo)){
            throw new RuntimeException("订单编号不能为空");
        }
        Integer status;
        DesignerOrderExample designerOrderExample = new DesignerOrderExample();
        designerOrderExample.createCriteria().andOrderNoEqualTo(orderNo);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(designerOrderExample);
        if(designerOrders.get(0).getOrderStage() >= 170 && designerOrders.get(0).getOrderStage() <= 210){
            status = 0;
            return status;
        }else  if (designerOrders.get(0).getOrderStage() >= 250 && designerOrders.get(0).getOrderStage() <= 270){
            status = 0;
            return status;
        }else {
            status = 1;
            return status;
        }
    }

    /**
     * @Author jiang
     * @Description 获取房间厅室数量
     * @Date
     * @Param
     * @return
     **/
    @Override
    public String getHouseTypeNum(String projectNo) {
        if(StringUtils.isBlank(projectNo)){
            throw new RuntimeException("项目编号不能为空");
        }
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<Project> project = projectMapper.selectByExample(projectExample);
        if(project.isEmpty()){
            return "";
        }
        BasicsDataExample basicsDataExample = new BasicsDataExample();
        basicsDataExample.createCriteria().andBasicsCodeEqualTo(project.get(0).getHouseHuxing().toString()).andBasicsGroupEqualTo("HOUSE_STRUCTURE");
        List<BasicsData> basicsData = basicsDataMapper.selectByExample(basicsDataExample);
        if(basicsData.isEmpty()){
            return "";
        }
        return  basicsData.get(0).getBasicsName();
    }

}
