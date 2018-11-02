package cn.thinkfree.service.approvalflow;

import cn.thinkfree.database.model.AfApprovalLog;

import java.util.List;

/**
 * TODO
 *
 * @author song
 * @version 1.0
 * @date 2018/10/26 10:40
 */
public interface AfApprovalLogService {

    AfApprovalLog findByNo(String approvalLogNo);

    List<AfApprovalLog> findByInstanceNo(String instanceNo);

    AfApprovalLog findByInstanceNoAndSort(String instanceNo, Integer sort);

    void updateByPrimaryKey(AfApprovalLog approvalLog);

    List<AfApprovalLog> findByUserId(String userId);

    void create(List<AfApprovalLog> afApprovalLogs);
}
