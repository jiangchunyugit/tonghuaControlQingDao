package cn.thinkfree.service.platform.designer;

import cn.thinkfree.service.platform.vo.UserMsgVo;

import java.util.List;
import java.util.Map;

/**
 * @author xusonghui
 * 获取用户信息服务即可
 */
public interface UserCenterService {
    /**
     * 根据用户ID查询用户信息
     *
     * @param userIds 用户ID列表
     * @return
     */
    List<UserMsgVo> queryUsers(List<String> userIds);

    /**
     * 模糊查询业主信息
     *
     * @param userMsg
     * @return
     */
    List<UserMsgVo> queryUserMsg(String userMsg);

    /**
     * 根据用户id查询用户信息
     *
     * @param userIds
     * @return
     */
    Map<String, UserMsgVo> queryUserMap(List<String> userIds);

    /**
     * 根据用户ID查询用户
     *
     * @param userId
     * @return
     */
    UserMsgVo queryUser(String userId);

    /**
     * 调用用户注册接口
     *
     * @param userName  姓名
     * @param userPhone 手机号
     * @param isOwner   是否是业主
     * @return
     */
    UserMsgVo registerUser(String userName, String userPhone, boolean isOwner);
}
