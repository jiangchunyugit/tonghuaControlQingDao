package cn.thinkfree.service.user;

import cn.thinkfree.core.constants.SysConstants;
import cn.thinkfree.core.logger.AbsLogPrinter;
import cn.thinkfree.core.security.dao.SecurityUserDao;
import cn.thinkfree.core.security.token.MyCustomUserDetailToken;
import cn.thinkfree.database.mapper.*;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.IndexUserReportVO;
import cn.thinkfree.database.vo.UserVO;
import cn.thinkfree.service.constants.UserRegisterType;
import cn.thinkfree.service.user.strategy.StrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl extends AbsLogPrinter implements UserService, SecurityUserDao{


    @Autowired
    UserRegisterMapper userRegisterMapper;

    @Autowired
    PcUserInfoMapper pcUserInfoMapper;

    @Autowired
    SystemResourceMapper systemResourceMapper;

    @Autowired
    PcUserResourceMapper pcUserResourceMapper;

    @Autowired
    CompanyUserSetMapper companyUserSetMapper;

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    @Autowired
    StrategyFactory strategyFactory;

    @Autowired
    UserLoginLogMapper userLoginLogMapper;

    /**
     * 汇总
     * @param companyRelationMap 公司ID
     * @return
     */
    @Override
    public IndexUserReportVO countCompanyUser(List<String> companyRelationMap) {
        IndexUserReportVO i = companyUserSetMapper.countCompanyUser(companyRelationMap);
        return i == null ? new IndexUserReportVO():i;
    }

    @Transactional
    @Override
    public String userLoginAfter(UserLoginLog userLoginLog) {
        userLoginLogMapper.insertSelective(userLoginLog);
        return "SUCCESS";
    }


    /**
     * 权限验证
     * 1.获取账号信息
     * 2.补全账号信息
     * 3.拉取权限信息
     * @param phone
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        printDebugMes("用户登录:{}",phone);
        UserRegisterExample userRegisterExample = new UserRegisterExample();
        userRegisterExample.createCriteria().andPhoneEqualTo(phone)
                .andTypeEqualTo(UserRegisterType.Staff.shortVal())
                .andIsDeleteEqualTo(SysConstants.YesOrNo.NO.shortVal());
        List<UserRegister> users = userRegisterMapper.selectByExample(userRegisterExample);
        if(users.isEmpty()|| users.size() > 1){
            printErrorMes("用户账号信息错误",phone);
            throw  new UsernameNotFoundException("用户账号信息错误");
        }
        UserRegister user = users.get(0);

        UserRegisterType type = UserRegisterType.values()[Integer.valueOf(user.getType())];
        UserDetails userDetails = strategyFactory.getStrategy(type).build(user.getUserId());



        return userDetails;
    }



    @Override
    public UserDetails loadPlatformUser(MyCustomUserDetailToken.TokenDetail detail) throws UsernameNotFoundException {

        UserRegisterExample userRegisterExample = new UserRegisterExample();
        userRegisterExample.createCriteria().andPhoneEqualTo(detail.getUserName()).andIsDeleteEqualTo(SysConstants.YesOrNo.NO.shortVal());
        List<UserRegister> users = userRegisterMapper.selectByExample(userRegisterExample);
        if(users.isEmpty() || users.size() > 1){
            throw new UsernameNotFoundException("用户信息异常");
        }
        UserRegisterType type = UserRegisterType.values()[Integer.valueOf(detail.getType())];
        UserDetails userDetails = strategyFactory.getStrategy(type).build(detail.getUserName());


        return userDetails;
    }
}
