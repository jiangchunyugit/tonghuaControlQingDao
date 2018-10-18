package cn.thinkfree.service.neworder;

import cn.thinkfree.database.model.OrderUser;
import cn.thinkfree.database.vo.OrderConfirmationVO;
import cn.thinkfree.database.vo.OrderDetailsVO;
import cn.thinkfree.database.vo.ProjectOrderVO;
import cn.thinkfree.database.vo.StageDetailsVO;

import java.util.List;

/**
 * 项目用户关系服务层
 *
 * @author song
 * @version 1.0
 * @date 2018/10/18 11:37
 */
public interface NewOrderUserService {

    /**
     * 根据项目编号查询项目用户关系
     * @param orderNo 项目编号
     * @return 项目用户关系
     */
    List<OrderUser> findByOrderNo(String orderNo);

    /**
     * @return
     * @Author jiang
     * @Description 分页查询项目派单
     * @Date
     * @Param
     **/
    List<ProjectOrderVO> queryProjectOrderByPage(ProjectOrderVO projectOrderVO, Integer pageNum, Integer pageSize);

    /**
     * @return
     * @Author jiang
     * @Description 查询项目派单总条数
     * @Date
     * @Param
     **/
    Integer queryProjectOrderCount(ProjectOrderVO projectOrderVO);

    /**
     * @return
     * @Author jiang
     * @Description 订单确认接口
     * @Date
     * @Param orderConfirmationVO
     **/
    Integer updateorderConfirmation(OrderConfirmationVO orderConfirmationVO);

    /**
     * @Author jiang
     * @Description 查看订单详情
     * @Date
     * @Param
     * @return
     **/
    OrderDetailsVO selectOrderDetails(String projectNo);
    /**
     * @Author jiang
     * @Description 阶段展示
     * @Date
     * @Param
     * @return
     **/
    List<StageDetailsVO> selectStageDetailsList(String projectNo);
}
