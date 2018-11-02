package cn.thinkfree.service.approvalflow.impl;

import cn.thinkfree.database.mapper.AfSubRoleMapper;
import cn.thinkfree.database.model.*;
import cn.thinkfree.service.approvalflow.AfSubRoleService;
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
 * @date 2018/10/25 15:52
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AfSubRoleServiceImpl implements AfSubRoleService {

    @Resource
    private AfSubRoleMapper subRoleMapper;

    @Override
    public List<AfSubRole> findByConfigSchemeNo(String configSchemeNo) {
        AfSubRoleExample example = new AfSubRoleExample();
        example.createCriteria().andConfigSchemeNoEqualTo(configSchemeNo);
        return subRoleMapper.selectByExample(example);
    }

    @Override
    public List<UserRoleSet> findByConfigSchemeNo(String configSchemeNo, List<UserRoleSet> allRoles) {
        List<AfSubRole> subRoles = findByConfigSchemeNo(configSchemeNo);
        return getRoles(subRoles, allRoles);
    }

    private List<UserRoleSet> getRoles(List<AfSubRole> subRoles, List<UserRoleSet> allRoles) {
        List<UserRoleSet> roles = new ArrayList<>();
        if (subRoles != null) {
            for (AfSubRole subRole : subRoles) {
                UserRoleSet role = null;
                for (UserRoleSet record : allRoles) {
                    if (record.getRoleCode().equals(subRole.getRoleId())) {
                        role = record;
                        break;
                    }
                }
                if (role == null) {
                    // TODO
                    throw new RuntimeException();
                } else {
                    roles.add(role);
                }
            }
        }
        return roles;
    }

    @Override
    public void create(String configSchemeNo, List<UserRoleSet> roles) {
        if (roles != null) {
            AfSubRole subRole;
            for (int index = 0; index < roles.size(); index++){
                subRole = new AfSubRole();
                subRole.setConfigSchemeNo(configSchemeNo);
                subRole.setRoleId(roles.get(index).getRoleCode());
                insert(subRole);
            }
        }
    }
    private void insert(AfSubRole subRole) {
        subRoleMapper.insertSelective(subRole);
    }
}
