package cn.thinkfree.service.dictionary;

import cn.thinkfree.core.constants.SysConstants;
import cn.thinkfree.core.security.filter.util.SessionUserDetailsUtil;
import cn.thinkfree.database.mapper.*;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {


    @Autowired
    ProvinceMapper provinceMapper;

    @Autowired
    CityMapper cityMapper;

    @Autowired
    AreaMapper areaMapper;

    @Autowired
    PreProjectHouseTypeMapper preProjectHouseTypeMapper;

    @Autowired
    HousingStatusMapper housingStatusMapper;

    @Autowired
    ProjectTypeMapper projectTypeMapper;

    @Autowired
    CompanyInfoMapper companyInfoMapper;


    /**
     * 查询所有省份
     *
     * @return
     */
    @Override
    public List<Province> findAllProvince() {
        return provinceMapper.selectByExample(null);
    }

    /**
     * 根据省份查询市区
     *
     * @param province
     * @return
     */
    @Override
    public List<City> findCityByProvince(String province) {
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andProvinceCodeEqualTo(province);
        return cityMapper.selectByExample(cityExample);
    }

    /**
     * 根据市区查询县区
     *
     * @param city
     * @return
     */
    @Override
    public List<Area> findAreaByCity(String city) {
        AreaExample areaExample = new AreaExample();
        areaExample.createCriteria().andCityCodeEqualTo(city);
        return areaMapper.selectByExample(areaExample);
    }

    /**
     * 获取所有房屋类型
     *
     * @return
     */
    @Override
    public List<PreProjectHouseType> findAllHouseType() {
        return preProjectHouseTypeMapper.selectByExample(null);
    }

    /**
     * 获取房屋新旧程度
     *
     * @return
     */
    @Override
    public List<HousingStatus> findAlHouseStatus() {
        HousingStatusExample housingStatusExample = new HousingStatusExample();
        housingStatusExample.setOrderByClause(" sort_no");
        return housingStatusMapper.selectByExample(housingStatusExample);
    }

    /**
     * 获取项目套餐
     *
     * @return
     */
    @Override
    public List<ProjectType> findAllProjectType() {
        ProjectTypeExample projectTypeExample = new ProjectTypeExample();
        projectTypeExample.setOrderByClause(" sort_no");
        return projectTypeMapper.selectByExample(projectTypeExample);
    }

    /**
     * 根据区域编码查询公司信息
     *
     * @param areaCode
     * @return
     */
    @Override
    public List<CompanyInfo> findCompanyByAreaCode(Integer areaCode) {

        UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
        List<String> companyRelationMap = userVO.getRelationMap();

        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.createCriteria().andIsDeleteEqualTo(SysConstants.YesOrNo.NO.shortVal())
                .andRootCompanyIdEqualTo(userVO.getPcUserInfo().getRootCompanyId())
                .andAreaCodeEqualTo(areaCode);

        return companyInfoMapper.selectByExample(companyInfoExample);
    }


}
