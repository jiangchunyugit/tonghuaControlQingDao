package cn.thinkfree.service.pcUser;

import cn.thinkfree.core.security.filter.util.SessionUserDetailsUtil;
import cn.thinkfree.core.security.utils.MultipleMd5;
import cn.thinkfree.database.constants.UserEnabled;
import cn.thinkfree.database.constants.UserLevel;
import cn.thinkfree.database.mapper.CompanyInfoMapper;
import cn.thinkfree.database.mapper.PcUserInfoMapper;
import cn.thinkfree.database.mapper.UserRegisterMapper;
import cn.thinkfree.database.model.PcUserInfo;
import cn.thinkfree.database.model.UserRegister;
import cn.thinkfree.database.vo.MyPageHelper;
import cn.thinkfree.database.vo.PcUserInfoVo;
import cn.thinkfree.database.vo.UserVO;
import cn.thinkfree.service.constants.UserRegisterType;
import cn.thinkfree.service.utils.UserNoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PcUserInfoServiceImpl implements PcUserInfoService {

    @Autowired
    PcUserInfoMapper pcUserInfoMapper;

    @Autowired
    UserRegisterMapper userRegisterMapper;

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    @Override
    public List<PcUserInfo> selectByParam(UserVO userVO) {
        return pcUserInfoMapper.selectByParam(userVO.getRelationMap());
    }

    /**
     * 权限管理  模糊查询
     * @param
     * @return
     */
    @Override
    public PageInfo<PcUserInfoVo> findByParam(UserVO userVO, MyPageHelper myPageHelper) {
        Map<String, Object> params = new HashMap<>();
        Object param = myPageHelper.getData();
        if(null == param || "".equals(param)){
            param = "";
        }else{
            param = "%" + param +"%";
        }
        params.put("param", param);
        params.put("companyId", userVO.getRelationMap());
        PageHelper.startPage(myPageHelper.getPage(), myPageHelper.getRows());
        List<PcUserInfoVo> pcUserInfoVos = pcUserInfoMapper.findByParam(params);
        PageInfo<PcUserInfoVo> pcUserInfoVoPageInfo = new PageInfo<>(pcUserInfoVos);
        return pcUserInfoVoPageInfo;
    }

    /**
     * 删除账户 pc_user_info  user_register
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public boolean delPcUserInfo(String userId) {
        boolean flag = false;
        int pcline = pcUserInfoMapper.deleteByPrimaryKey(userId);
        int regLine = userRegisterMapper.deleteByUserId(userId);
        if(pcline > 0 && regLine > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 添加账户
     * @param pcUserInfoVo
     * @return
     */
    @Override
    @Transactional
    public boolean saveUserInfo(PcUserInfoVo pcUserInfoVo) {
        UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
        String userId = UserNoUtils.getUserNo("pc");
        Date date = new Date();
        pcUserInfoVo.setCreateTime(date);
        pcUserInfoVo.setId(userId);
        pcUserInfoVo.setRootCompanyId(userVO.getPcUserInfo().getRootCompanyId());
        pcUserInfoVo.setEnabled(UserEnabled.Enabled_false.shortVal());
        //TODO 应该有问题  根据登陆用户级别插入level
        if(userVO.getPcUserInfo().getLevel() == UserLevel.Company_Admin.shortVal()){
            pcUserInfoVo.setLevel(UserLevel.Company_Province.shortVal());
        }else if (userVO.getPcUserInfo().getLevel() == UserLevel.Company_Province.shortVal()){
            pcUserInfoVo.setLevel(UserLevel.Company_City.shortVal());
        }else{
            pcUserInfoVo.setLevel(UserLevel.Company_City.shortVal());
        }
        pcUserInfoVo.setParentCompanyId(userVO.getCompanyID());
        //TODO 省市区未存
//        CompanyInfo companyInfo = companyInfoMapper.findByCompanyId(pcUserInfo.getCompanyId());
//        pcUserInfo.setCity(companyInfo.getCityCode());


        //注册表
        UserRegister userRegister = new UserRegister();
        userRegister.setRegisterTime(date);
        userRegister.setType(UserRegisterType.Staff.shortVal());
        userRegister.setUpdateTime(date);
        MultipleMd5 md5 = new MultipleMd5();
        //加密
        /*if(null == pcUserInfoVo.getPassword() || "".equals(pcUserInfoVo.getPassword())){
            pcUserInfoVo.setPassword("123456");
        }*/
        userRegister.setPassword(md5.encode(pcUserInfoVo.getPassword()));
        userRegister.setPhone(pcUserInfoVo.getRegPhone());
        userRegister.setUserId(userId);
        int pcLine = pcUserInfoMapper.insertUserInfoVo(pcUserInfoVo);
        int regLine = userRegisterMapper.insertSelective(userRegister);

        boolean flag = false;
        if(pcLine > 0 && regLine > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 更新用户信息
     * @param
     * @return
     */
    @Override
    @Transactional
    public boolean updateUserInfo(PcUserInfoVo pcUserInfoVo) {
        /*PcUserInfo pcUserInfo = new PcUserInfo();
        pcUserInfo.setId(pcUserInfoVo.getId());
        pcUserInfo.setMemo(pcUserInfoVo.getMemo());
        pcUserInfo.setPhone(pcUserInfoVo.getPhone());
        pcUserInfo.setName(pcUserInfoVo.getName());*/

        UserRegister userRegister = new UserRegister();
        userRegister.setUserId(pcUserInfoVo.getId());
        userRegister.setUpdateTime(new Date());
        MultipleMd5 md5 = new MultipleMd5();
        userRegister.setPassword(md5.encode(pcUserInfoVo.getPassword()));

        int pcLine = pcUserInfoMapper.updateById(pcUserInfoVo);
        int regLine = userRegisterMapper.updateByUserId(userRegister);

        boolean flag = false;
        if(pcLine > 0 && regLine > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 单个用户信息查询
     * @param userId
     * @return
     */
    @Override
    public PcUserInfoVo findByUserId(String userId) {
        PcUserInfoVo pcUserInfoVo = pcUserInfoMapper.findByUserId(userId);
//        MultipleMd5 md5 = new MultipleMd5();
//        pcUserInfoVo.setPassword(md5.matches());
        return pcUserInfoVo;
    }

}
