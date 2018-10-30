package cn.thinkfree.service.approvalflow;

import cn.thinkfree.database.model.AfApprovalOrder;
import cn.thinkfree.database.model.UserRoleSet;
import cn.thinkfree.database.vo.AfApprovalOrderVO;

import java.util.List;

/**
 * TODO
 *
 * @author song
 * @version 1.0
 * @date 2018/10/26 15:53
 */
public interface AfApprovalOrderService {

    List<List<UserRoleSet>> findByConfigPlanNo(String configLogNo, List<UserRoleSet> roles);

    void create(String configPlanNo, String configNo, List<List<UserRoleSet>> approvalOrders);

    AfApprovalOrderVO findByNo(String planNo);

    AfApprovalOrder findByConfigNoAndCompanyNoAndRoleId(String configNo, String companyNo, String roleId);
}
