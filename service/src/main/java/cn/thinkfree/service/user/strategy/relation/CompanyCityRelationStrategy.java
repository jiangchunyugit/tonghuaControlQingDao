package cn.thinkfree.service.user.strategy.relation;

import cn.thinkfree.core.exception.ForbiddenException;
import cn.thinkfree.database.constants.UserEnabled;
import cn.thinkfree.database.mapper.BranchCompanyMapper;
import cn.thinkfree.database.mapper.CityBranchMapper;
import cn.thinkfree.database.model.BranchCompany;
import cn.thinkfree.database.model.CityBranch;
import cn.thinkfree.database.model.StoreInfo;
import cn.thinkfree.database.vo.UserVO;
import cn.thinkfree.service.storeinfo.StoreInfoService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyCityRelationStrategy implements RelationStrategy {

    @Autowired
    StoreInfoService storeInfoService;

    /**
     * 构建关系图
     *
     * @return
     * @param userVO
     */
    @Override
    public List<String> build(UserVO userVO) {
        // todo jangchunyu
        return storeInfoService.storeInfoListByCityId(userVO.getPcUserInfo().getCityBranchCompanyId())
                .stream()
                .map(StoreInfo::getStoreId)
                .collect(Collectors.toList());
    }
}
