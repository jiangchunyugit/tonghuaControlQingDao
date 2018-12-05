package cn.thinkfree.service.platform.designer.impl;

import cn.thinkfree.database.mapper.EmployeeMsgMapper;
import cn.thinkfree.database.model.EmployeeMsg;
import cn.thinkfree.database.model.EmployeeMsgExample;
import cn.thinkfree.service.platform.designer.UserCenterService;
import cn.thinkfree.service.platform.vo.UserMsgVo;
import cn.thinkfree.service.utils.HttpUtils;
import cn.thinkfree.service.utils.ReflectUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author xusonghui
 */
@Service
public class UserCenterServiceImpl implements UserCenterService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmployeeMsgMapper employeeMsgMapper;
    @Value("${custom.service.ip}")
    private String userCenterIp;
    @Value("${custom.service.port}")
    private String userCenterPort;
    /**
     * 查询用户的用户中心地址
     */
    private String queryUserUrl = "/userapi/other/getUserMsgByPhone";
    /**
     * 业主注册
     */
    private String registerC = "/userapi/register/api/registerC";
    /**
     * 员工注册
     */
    private String registerS = "/userapi/register/api/registerS";
    /**
     * 根据手机号和姓名模糊查询用户信息
     */
    private String queryUserByPhoneAndName = "/userapi/other/getUserMsgByPhoneAndName";
    /**
     * 根据用户ID查询用户信息
     */
    private String getAllUserByIds = "/userapi/other/api/getListUserByUserIds";

    @Override
    public String getUrl(String suffix) {
        return "http://" + userCenterIp + ":" + userCenterPort + suffix;
    }

    @Override
    public List<UserMsgVo> queryUsers(List<String> userIds) {
        List<UserMsgVo> userMsgVos = new ArrayList<>();
        Map<String, EmployeeMsg> employeeMsgMap = queryEmployeeMsg(userIds);
        for (String userId : userIds) {
            if (!employeeMsgMap.containsKey(userId)) {
                EmployeeMsg employeeMsg = new EmployeeMsg();
                employeeMsg.setRoleCode("CC");
                employeeMsg.setUserId(userId);
                employeeMsgMap.put(userId, employeeMsg);
            }
        }
        userMsgVos.addAll(queryUserMsg(employeeMsgMap));
        return userMsgVos;
    }

    @Override
    public UserMsgVo registerUser(String userName, String userPhone, boolean isOwner) {
        UserMsgVo userMsgVo = queryByPhone(userPhone);
        if (userMsgVo == null) {
            userMsgVo = register(userName, userPhone, isOwner);
        }
        if(isOwner && StringUtils.isBlank(userMsgVo.getConsumerId())){
            userMsgVo = register(userName, userPhone, isOwner);
        }
        if(isOwner && StringUtils.isBlank(userMsgVo.getStaffId())){
            userMsgVo = register(userName, userPhone, false);
        }
        return userMsgVo;
    }

    /**
     * 注册用户
     *
     * @param userName
     * @param userPhone
     * @param isOwner
     */
    private UserMsgVo register(String userName, String userPhone, boolean isOwner) {
        if (isOwner) {
            return registerC(userName, userPhone);
        } else {
            return registerS(userName, userPhone);
        }
    }

    private UserMsgVo registerC(String userName, String userPhone) {
        Map<String, String> params = new HashMap<>();
        params.put("userName", userName);
        params.put("userPhone", userPhone);
        HttpUtils.HttpRespMsg httpRespMsg = HttpUtils.post(getUrl(registerC), HttpUtils.mapToParams(params));
        logger.info("registerC:" + JSONObject.toJSONString(httpRespMsg));
        if (httpRespMsg.getResponseCode() != 200) {
            //用户中心服务异常
            throw new RuntimeException("用户中心异常");
        }
        JSONObject jsonObject = JSONObject.parseObject(httpRespMsg.getContent());
        if (!"1000".equals(jsonObject.getString("code"))) {
            throw new RuntimeException(jsonObject.getString("msg"));
        }
        JSONObject msgs = jsonObject.getJSONObject("data");
        JSONObject user = msgs.getJSONObject(userPhone);
        if (user == null) {
            throw new RuntimeException("注册失败");
        }
        UserMsgVo msgVo = new UserMsgVo();
        msgVo.setStaffId(user.getString("staffId"));
        msgVo.setConsumerId(user.getString("consumerId"));
        msgVo.setUserName(userName);
        msgVo.setUserPhone(userPhone);
        return msgVo;
    }

    private UserMsgVo registerS(String userName, String userPhone) {
        Map<String, String> params = new HashMap<>();
        params.put("userName", userName);
        params.put("userPhone", userPhone);
        List<Map<String, String>> mapList = new ArrayList<>();
        mapList.add(params);
        HttpUtils.HttpRespMsg httpRespMsg = HttpUtils.postJson(getUrl(registerS), JSONObject.toJSONString(mapList));
        logger.info("registerS:" + JSONObject.toJSONString(httpRespMsg));
        if (httpRespMsg.getResponseCode() != 200) {
            //用户中心服务异常
            throw new RuntimeException("用户中心异常");
        }
        JSONObject jsonObject = JSONObject.parseObject(httpRespMsg.getContent());
        if (!"1000".equals(jsonObject.getString("code"))) {
            throw new RuntimeException(jsonObject.getString("msg"));
        }
        JSONObject msgs = jsonObject.getJSONObject("data");
        JSONObject user = msgs.getJSONObject(userPhone);
        if (user == null) {
            throw new RuntimeException("注册失败");
        }
        UserMsgVo msgVo = new UserMsgVo();
        msgVo.setStaffId(user.getString("staffId"));
        msgVo.setConsumerId(user.getString("consumerId"));
        msgVo.setUserName(userName);
        msgVo.setUserPhone(userPhone);
        return msgVo;
    }

    /**
     * 根据手机号查询用户信息
     *
     * @param userPhone
     */
    private UserMsgVo queryByPhone(String userPhone) {
        Map<String, String> queryUserParams = new HashMap<>();
        queryUserParams.put("phone", userPhone);
        HttpUtils.HttpRespMsg httpRespMsg = HttpUtils.post(getUrl(queryUserUrl), HttpUtils.mapToParams(queryUserParams));
        logger.info("queryByPhone:" + JSONObject.toJSONString(httpRespMsg));
        if (httpRespMsg.getResponseCode() != 200) {
            //用户中心服务异常
            throw new RuntimeException("用户中心异常");
        }
        JSONObject jsonObject = JSONObject.parseObject(httpRespMsg.getContent());
        if (!"1000".equals(jsonObject.getString("code"))) {
            throw new RuntimeException(jsonObject.getString("msg"));
        }
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        if (jsonArray.size() < 1) {
            return null;
        }
        JSONObject msgObj = jsonArray.getJSONObject(0);
        UserMsgVo msgVo = new UserMsgVo();
        msgVo.setUserName(msgObj.getString("nickName"));
        msgVo.setUserPhone(userPhone);
        msgVo.setUserIcon(msgObj.getString("headPortraits"));
        msgVo.setConsumerId(msgObj.getString("consumerId"));
        msgVo.setStaffId(msgObj.getString("staffId"));
        msgVo.setMemberEcode(msgObj.getString("memberEcode"));
        msgVo.setRegisterTime(msgObj.getString("registerTime"));
        return msgVo;
    }

    @Override
    public UserMsgVo queryUserMsgOne(String roleCode, String userId) {
        Map<String, EmployeeMsg> employeeMsgMap = new HashMap<>();
        EmployeeMsg employeeMsg = new EmployeeMsg();
        employeeMsg.setUserId(userId);
        employeeMsg.setRoleCode(roleCode);
        employeeMsgMap.put(userId, employeeMsg);
        List<UserMsgVo> userMsgVos = queryUserMsg(employeeMsgMap);
        if (userMsgVos != null || !userMsgVos.isEmpty()) {
            return userMsgVos.get(0);
        }
        return null;
    }

    @Override
    public List<UserMsgVo> queryUserMsg(Map<String, EmployeeMsg> employeeMsgMap) {
        HttpUtils.HttpRespMsg httpRespMsg = HttpUtils.postJson(getUrl(getAllUserByIds), getParams(employeeMsgMap));
        logger.info("queryUserMsg:" + JSONObject.toJSONString(httpRespMsg));
        if (httpRespMsg.getResponseCode() != 200) {
            //用户中心服务异常
            return new ArrayList<>();
        }
        JSONObject jsonObject = JSONObject.parseObject(httpRespMsg.getContent());
        if (!"1000".equals(jsonObject.getString("code"))) {
            return new ArrayList<>();
        }
        JSONObject dataObj = jsonObject.getJSONObject("data");
        List<UserMsgVo> userMsgVos = new ArrayList<>();
        for (Map.Entry<String, EmployeeMsg> msgEntry : employeeMsgMap.entrySet()) {
            EmployeeMsg employeeMsg = msgEntry.getValue();
            String userId = employeeMsg.getUserId();
            if (!dataObj.containsKey(userId)) {
                continue;
            }
            JSONObject userMsg = dataObj.getJSONObject(userId);
            String userName = userMsg.getString("nickName");
            String phone = userMsg.getString("phone");
            String headPortraits = userMsg.getString("headPortraits");
            String memberEcode = userMsg.getString("memberEcode");
            UserMsgVo userMsgVo = new UserMsgVo(userId, userName, phone, employeeMsg.getRoleCode(), employeeMsg.getRealName(), headPortraits, memberEcode);
            String registerTime = userMsg.getString("registerTime");
            userMsgVo.setRegisterTime(registerTime);
            userMsgVos.add(userMsgVo);
        }
        return userMsgVos;
    }

    @Override
    public List<UserMsgVo> queryUserMsg(String nickName, String phone) {
        if(StringUtils.isBlank(nickName) && StringUtils.isBlank(phone)){
            return new ArrayList<>();
        }
        Map<String, String> queryUserParams = new HashMap<>();
        if (StringUtils.isNotBlank(phone)) {
            queryUserParams.put("phone", phone);
        }
        if (StringUtils.isNotBlank(nickName)) {
            queryUserParams.put("nickName", nickName);
        }
        HttpUtils.HttpRespMsg httpRespMsg = HttpUtils.post(getUrl(queryUserByPhoneAndName), HttpUtils.mapToParams(queryUserParams));
        logger.info("queryUserMsg:like:" + JSONObject.toJSONString(httpRespMsg));
        if (httpRespMsg.getResponseCode() != 200) {
            //用户中心服务异常
            return new ArrayList<>();
        }
        JSONObject jsonObject = JSONObject.parseObject(httpRespMsg.getContent());
        if (!"1000".equals(jsonObject.getString("code"))) {
            return new ArrayList<>();
        }
        JSONArray array = jsonObject.getJSONArray("data");
        List<UserMsgVo> userMsgVos = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject userObj = array.getJSONObject(i);
            String userName = userObj.getString("nickName");
            String userPhone = userObj.getString("phone");
            String headPortraits = userObj.getString("headPortraits");
            String consumerId = userObj.getString("consumerId");
            String staffId = userObj.getString("staffId");
            String registerTime = userObj.getString("registerTime");
            if (StringUtils.isBlank(consumerId)) {
                continue;
            }
            UserMsgVo msgVo = new UserMsgVo(consumerId, userName, userPhone, "CC", "", headPortraits);
            msgVo.setStaffId(staffId);
            msgVo.setRegisterTime(registerTime);
            userMsgVos.add(msgVo);
        }
        return userMsgVos;
    }

    @Override
    public List<UserMsgVo> queryUserMsg(String userMsg) {
        long phone;
        try {
            phone = Long.parseLong(userMsg);
        } catch (Exception e) {
            phone = -1;
        }
        Map<String, String> queryUserParams = new HashMap<>();
        if (phone > 0) {
            queryUserParams.put("phone", userMsg);
        } else {
            queryUserParams.put("nickName", userMsg);
        }
        HttpUtils.HttpRespMsg httpRespMsg = HttpUtils.post(getUrl(queryUserByPhoneAndName), HttpUtils.mapToParams(queryUserParams));
        logger.info("queryUserMsg:like:" + JSONObject.toJSONString(httpRespMsg));
        if (httpRespMsg.getResponseCode() != 200) {
            //用户中心服务异常
            return new ArrayList<>();
        }
        JSONObject jsonObject = JSONObject.parseObject(httpRespMsg.getContent());
        if (!"1000".equals(jsonObject.getString("code"))) {
            return new ArrayList<>();
        }
        JSONArray array = jsonObject.getJSONArray("data");
        List<UserMsgVo> userMsgVos = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject userObj = array.getJSONObject(i);
            String userName = userObj.getString("nickName");
            String userPhone = userObj.getString("phone");
            String headPortraits = userObj.getString("headPortraits");
            String consumerId = userObj.getString("consumerId");
            String staffId = userObj.getString("staffId");
            if (StringUtils.isBlank(consumerId)) {
                continue;
            }
            UserMsgVo msgVo = new UserMsgVo(consumerId, userName, userPhone, "CC", "", headPortraits);
            msgVo.setStaffId(staffId);
            userMsgVos.add(msgVo);
        }
        return userMsgVos;
    }

    /**
     * 参数转换
     *
     * @param employeeMsgMap
     * @return
     */
    private String getParams(Map<String, EmployeeMsg> employeeMsgMap) {
        List<String> userIds = new ArrayList<>();
        for (Map.Entry<String, EmployeeMsg> msgEntry : employeeMsgMap.entrySet()) {
            EmployeeMsg employeeMsg = msgEntry.getValue();
            userIds.add(employeeMsg.getUserId());
        }
        return JSONObject.toJSONString(userIds);
    }

    /**
     * 根据员工ID查询员工信息
     *
     * @param userIds
     * @return
     */
    private Map<String, EmployeeMsg> queryEmployeeMsg(List<String> userIds) {
        EmployeeMsgExample msgExample = new EmployeeMsgExample();
        msgExample.createCriteria().andUserIdIn(userIds);
        List<EmployeeMsg> employeeMsgs = employeeMsgMapper.selectByExample(msgExample);
        return ReflectUtils.listToMap(employeeMsgs, "userId");
    }

    @Override
    public Map<String, UserMsgVo> queryUserMap(List<String> userIds) {
        List<UserMsgVo> msgVos = queryUsers(userIds);
        return ReflectUtils.listToMap(msgVos, "userId");
    }

    @Override
    public UserMsgVo queryUser(String userId) {
        List<UserMsgVo> msgVos = queryUsers(Arrays.asList(userId));
        if (msgVos.isEmpty()) {
            throw new RuntimeException("没有查询到用户信息");
        }
        return msgVos.get(0);
    }
}
