package cn.thinkfree.service.platform.basics;

import cn.thinkfree.database.model.BasicsData;
import cn.thinkfree.service.platform.vo.CardTypeVo;

import java.util.List;
import java.util.Map;

/**
 * @author xusonghui
 * 基础数据接口
 */
public interface BasicsService {

    /**
     * 查询证件类型
     * @return
     */
    List<BasicsData> cardTypes();
    /**
     * 查询证件类型
     * @return
     */
    List<BasicsData> countryType();
    /**
     * 查询证件类型
     * @return
     */
    List<BasicsData> cancelDesign();
    /**
     * 查询证件类型
     * @return
     */
    List<BasicsData> refund();
    /**
     * 查询证件类型
     * @return
     */
    List<BasicsData> cancelCons();

    /**
     * 获取省市区信息
     * @param type 类型，1省份，2市，3区
     * @param parentCode 父级编码
     * @return
     */
    List<Map<String,String>> pua(int type, String parentCode);
}
