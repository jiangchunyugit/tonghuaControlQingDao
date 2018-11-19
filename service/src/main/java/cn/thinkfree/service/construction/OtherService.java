package cn.thinkfree.service.construction;

import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.service.construction.vo.PrecisionPriceVo;
import cn.thinkfree.service.construction.vo.OfferProjectVo;
import com.github.pagehelper.PageInfo;

public interface OtherService {

    /**
     * 精准报价
     * @param companyNo
     * @param pageNum
     * @param pageSize
     * @return
     */
    MyRespBundle<PageInfo<PrecisionPriceVo>> getOfferList(String companyNo, int pageNum, int pageSize);

    /**
     * 项目编号
     * @param projectNo
     * @return
     */
    MyRespBundle<OfferProjectVo> getProject(String projectNo);
}