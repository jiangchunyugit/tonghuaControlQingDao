package cn.thinkfree.service.construction;

import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.service.construction.vo.ConstructionOrderListVo;
import cn.thinkfree.service.construction.vo.ConstructionOrderManageVo;
import com.github.pagehelper.PageInfo;
import cn.thinkfree.service.construction.vo.SiteDetailsVo;

public interface ConstructionOrderOperate {

    /**
     * 施工订单管理-列表
     * 运营后台
     * @return
     */
    MyRespBundle<ConstructionOrderManageVo> getConstructionOrderList(int pageNum, int pageSize,String cityName);
    /**
     * @Author jiang
     * @Description 工地管理接口-列表
     * @Date
     * @Param
     * @return
     **/
    MyRespBundle<ConstructionOrderManageVo> getConstructionSiteList(int pageNum, int pageSize, String cityName);

    MyRespBundle<SiteDetailsVo> getSiteDetails(String projectNo);
}
