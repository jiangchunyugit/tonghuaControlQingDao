package cn.thinkfree.service.user.builder;

import cn.thinkfree.database.constants.UserLevel;
import cn.thinkfree.database.mapper.CompanyInfoMapper;
import cn.thinkfree.database.model.CompanyInfo;
import cn.thinkfree.database.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyAreaStrategy implements Strategy {

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    /**
     * 构建关系图
     *
     * @return
     * @param userVO
     */
    @Override
    public List<String> builder(UserVO userVO) {
        CompanyInfo condition = new CompanyInfo();
        condition.setRootCompanyId(userVO.getPcUserInfo().getRootCompanyId());
        condition.setProvinceCode(Short.valueOf(userVO.getPcUserInfo().getProvince()));
        condition.setCityCode(Short.valueOf(userVO.getPcUserInfo().getCity()));
        condition.setAreaCode(Integer.valueOf(userVO.getPcUserInfo().getArea()));
        condition.setParentCompanyId(UserLevel.Company_Area.code+"");
        return companyInfoMapper.selectRelationMap(condition);
    }
}
