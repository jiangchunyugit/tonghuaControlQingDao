package cn.thinkfree.service.pcthirdpartdate;

import java.util.List;

import cn.thinkfree.database.vo.MarginContractVO;
import cn.thinkfree.database.vo.remote.SyncOrderVO;

/**
 * @author jiangchunyu(后台)
 * @date 20181109
 * @Description 第三方数据接口
 */
public interface ThirdPartDateService {

    MarginContractVO getMarginContract(String contractCode,String signedTime);
    
    /**
     * 小C上传完后合同后 调用支付订单
     * 2018年11月15日 13:50:51
     * 吕启栋
     */
    List<SyncOrderVO> getOrderContract(String orderNumber);
    
    /**
     * to B 保证金 生成预防订单
     * 2018年11月26日 10:00:35
     * lqd
     */
    List<SyncOrderVO> getOrderContractToB(String orderNumber);
}
