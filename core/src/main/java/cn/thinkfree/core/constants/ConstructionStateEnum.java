package cn.thinkfree.core.constants;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 施工订单枚举类
 */

public enum ConstructionStateEnum {

    /**
     *  字段说明
     *
     *  designer = "设计师";
     *  platform = "运营平台";
     *  consumer = "消费者";
     *  constructionCompany = "装饰公司";
     *  constructor = "施工人员";
     *  1 可以取消
     *  0 不可取消
     */

    /**
     * 设计师-将订单转入施工 - 创建
     */
    STATE_500(500, new String[]{"designer"}, "订单转入施工", "待签约", "等待平台派单", "", "", 1),

    /**
     * 运营平台-派单给装饰公司 - 签约
     */
    STATE_510(510, new String[]{"platform-520-888","consumer-888"}, "派单给装饰公司", "待签约", "等待公司派单", "等待公司派单", "", 1),

    /**
     * 装饰公司-派单给服务人员 - 签约
     */
    STATE_520(520, new String[]{"constructionCompany-530-888","consumer-888"}, "派单给服务人员", "待签约", "等待报价", "等待公司派单", "", 1),

    /**
     * 装饰公司-施工报价完成- 签约
     */
    STATE_530(530, new String[]{"constructionCompany-540-888","consumer-888"}, "施工报价完成", "待签约", "等待报价审核", "等待报价审核", "", 1),

    /**
     * 装饰公司-审核完成- 签约
     */
    STATE_540(540, new String[]{"constructionCompany-550-888","consumer-888"}, "审核完成", "待签约", "等待合同录入", "等待合同录入", "", 1),

    /**
     * 装饰公司-合同录入- 签约
     */
    STATE_550(550, new String[]{"constructionCompany-560-888","consumer-888"}, "合同录入", "待签约", "等待签约", "等待签约", "", 1),

    /**
     * 装饰公司-确认线下签约完成（自动创建工地项目）- 签约
     */
    STATE_560(560, new String[]{"constructionCompany-600-888","consumer-888"}, "确认线下签约完成(自动创建工地项目)", "待支付", "等待首付款支付", "等待首付款支付", "等待首付款支付", 1),


    /**
     * 消费者- 首期款支付
     */
    STATE_600(600, new String[]{"consumer-605-720-888"}, "支付首期款", "待开工", "等待开工", "等待开工", "等待开工", 1),

    /**
     * 施工人员- 施工中
     */
    STATE_605(605, new String[]{"constructor-610"}, "开工报告", "施工中", "施工中", "施工中", "施工中", 0),

    /* 阶段款支付 - 施工人员 验收 */
    STATE_610(610, new String[]{"constructor"}, "阶段验收通过", "待支付", "等待阶段款支付", "等待阶段款支付", "等待阶段款支付", 0),

    /* 施工中 - 消费者 支付  */
    STATE_615(615, new String[]{"consumer-690"}, "支付阶段款", "施工中", "施工中", "施工中", "施工中", 0),

    /**
     * 施工人员- 尾款支付
     */
    STATE_690(690, new String[]{"constructor-700"}, "竣工验收通过", "待支付", "等待尾款支付", "等待尾款支付", "等待尾款支付", 0),

    //TODO
    /**
     * 消费者- 订单完成
     */
    STATE_700(700, new String[]{"consumer"}, "支付尾款", "已完成", "已完成", "已完成", "已完成", 0),

    //TODO
    /**
     *  消费者 签约阶段逆向
     */
    STATE_710(710, new String[]{"consumer"}, "取消订单", "等待处理——已关闭", "已关闭", "已关闭", "已关闭", 0),

    /**
     *  消费者 支付未开工逆向
     */
    STATE_720(720, new String[]{"consumer-730"}, "取消订单", "退款中", "退款待审核", "退款待审核", "退款待审核", 0),


    /**
     *  消费者 支付未开工逆向
     */
    STATE_730(730, new String[]{"constructionCompany-888"}, "支付尾款", "已完成", "已完成", "已完成", "已完成", 0),


    /**
     * 订单关闭 --
     */
    STATE_888(888, new String[]{"designer","platform","constructionCompany"}, "订单关闭", "订单关闭", "订单关闭", "订单关闭", "订单关闭", 1),

    ;


    // 状态值
    private int state;
    // 操作者
    private String[] operater = new String[]{};
    // 操作-说明
    private String operateInfo;
    // 消费者当前状态
    private String stateConsumer;
    // 运营平台当前状态
    private String statePlatform;
    // 装饰公司当前状态
    private String stateConstructionCompany;
    // 施工人员状态
    private String stateConstructor;
    // 是否自动可取消
    private int isCancel;

    ConstructionStateEnum(int state, String[] operater, String operateInfo, String stateConsumer, String statePlatform, String stateConstructionCompany, String stateConstructor, int isCancel) {
        this.state = state;
        this.operater = operater;
        this.operateInfo = operateInfo;
        this.stateConsumer = stateConsumer;
        this.statePlatform = statePlatform;
        this.stateConstructionCompany = stateConstructionCompany;
        this.stateConstructor = stateConstructor;
        this.isCancel = isCancel;
    }

    /**
     * 查询状态码 对应的状态
     *
     * @return
     */
    public static String getNowStateInfo(Integer state,int type) {
        ConstructionStateEnum[] stateEnums = ConstructionStateEnum.values();
        for (ConstructionStateEnum constructionStateEnum : stateEnums) {
            if (constructionStateEnum.state == state) {
                switch (type) {
                    case 1:
                        return constructionStateEnum.statePlatform;
                    case 2:
                        return constructionStateEnum.stateConstructionCompany;
                    case 3:
                        return constructionStateEnum.stateConstructor;
                    case 4:
                        return constructionStateEnum.stateConsumer;
                    default:
                        break;
                }
            }
        }
        return null;
    }

    /**
     * 下一步状态
     *
     * @return
     */
    public static List<String> getNextStates(Integer state,String role) {
        ConstructionStateEnum[] stateEnums = ConstructionStateEnum.values();
        for (ConstructionStateEnum constructionStateEnum : stateEnums) {
            if (constructionStateEnum.state == state) {
                List<String> nextStatesList = new ArrayList<>();
                for (String a1 : constructionStateEnum.operater){
                    if (a1.contains(role)){
                        String a2[] = a1.split("-");
                        for (String a3:a2){
                            if (a3.equals(role)){
                                continue;
                            }
                            nextStatesList.add(a3);
                        }
                    }
                }
                return nextStatesList;
            }
        }
        return null;
    }

    /**
     * 根据类型获取订单状态类型列表
     *
     * @param type ，1获取平台状态，2获取装饰公司状态，3获取施工人员状态，4获取消费者状态
     * @return
     */
    public static List<Map<String, Object>> allStates(int type) {
        List<Map<String, Object>> listMap = new ArrayList<>();
        ConstructionStateEnum[] stateEnums = ConstructionStateEnum.values();

        for (ConstructionStateEnum constructionStateEnum : stateEnums) {
            int stateCode = 0;
            String stateInfo = "";
            switch (type) {
                case 1:
                    stateCode = constructionStateEnum.state;
                    stateInfo = constructionStateEnum.statePlatform;
                    System.out.println("======"+constructionStateEnum.statePlatform);
                    break;
                case 2:
                    stateCode = constructionStateEnum.state;
                    stateInfo = constructionStateEnum.stateConstructionCompany;
                    break;
                case 3:
                    stateCode = constructionStateEnum.state;
                    stateInfo = constructionStateEnum.stateConstructor;
                    break;
                case 4:
                    stateCode = constructionStateEnum.state;
                    stateInfo = constructionStateEnum.stateConsumer;
                    break;
                default:
                    break;
            }
            if (StringUtils.isBlank(stateInfo)){
                continue;
            }
            Map<String, Object> map = new HashMap<>();
            map.put("key", stateCode);
            map.put("val", stateInfo);
            listMap.add(map);
        }
        return listMap;
    }

    /**
     * 根据类型获取所有类型值
     *
     * @param state 订单状态值
     * @param type  ，1获取平台状态，2获取装饰公司状态，3获取施工人员状态，4获取消费者状态
     * @return
     */
    public static List<Integer> queryStatesByState(int state, int type) {
        ConstructionStateEnum ConstructionStateEnum = queryByState(state);
        List<Integer> integers = new ArrayList<>();
        ConstructionStateEnum[] stateEnums = ConstructionStateEnum.values();
        for (ConstructionStateEnum stateEnum : stateEnums) {
            if (type == 1 && ConstructionStateEnum.statePlatform.equals(stateEnum.statePlatform)) {
                integers.add(stateEnum.state);
            }
            if (type == 2 && ConstructionStateEnum.stateConstructionCompany.equals(stateEnum.stateConstructionCompany)) {
                integers.add(stateEnum.state);
            }
            if (type == 3 && ConstructionStateEnum.stateConstructor.equals(stateEnum.stateConstructor)) {
                integers.add(stateEnum.state);
            }
            if (type == 4 && ConstructionStateEnum.stateConsumer.equals(stateEnum.stateConsumer)) {
                integers.add(stateEnum.state);
            }
        }
        return integers;
    }

    /**
     * 根据状态 & 角色 - 查询当前状态说明
     *
     * @param state
     * @param role
     * @return
     */
    public static String queryStateByRole(int state, String role) {
        ConstructionStateEnum[] stateEnums = ConstructionStateEnum.values();
        for (ConstructionStateEnum constructionStateEnum : stateEnums) {
            if (constructionStateEnum.state == state) {
                switch (role) {
                    case "platform":
                        return constructionStateEnum.statePlatform;
                    case "consumer":
                        return constructionStateEnum.stateConsumer;
                    case "constructionCompany":
                        return constructionStateEnum.stateConstructionCompany;
                    case "constructor":
                        return constructionStateEnum.stateConstructor;
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    /**
     * 查询角色权限
     *
     * @param role
     * @return
     */
    public static boolean queryIsState(String role) {
        ConstructionStateEnum[] stateEnums = ConstructionStateEnum.values();
        for (ConstructionStateEnum constructionStateEnum : stateEnums) {
            List<String> operater = Arrays.asList(constructionStateEnum.operater);
            if (operater.contains(role)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据类型获取所有类型值
     *
     * @param type  ，1获取平台状态，2获取装饰公司状态，3获取施工人员状态，4获取消费者状态
     * @return
     */
    public String getStateName(int type){
        switch (type) {
            case 1:
                return statePlatform;
            case 2:
                return stateConstructionCompany;
            case 3:
                return stateConstructor;
            case 4:
                return stateConsumer;
            default:
                throw new RuntimeException("无效的类型");
        }
    }

    /**
     * 根据枚举的状态值查询枚举
     *
     * @param state 状态值
     * @return
     */
    public static ConstructionStateEnum queryByState(int state) {
        ConstructionStateEnum[] stateEnums = ConstructionStateEnum.values();
        for (ConstructionStateEnum constructionStateEnum : stateEnums) {
            if (constructionStateEnum.state == state) {
                return constructionStateEnum;
            }
        }
        throw new RuntimeException("无效的状态值");
    }

    public int getState() {
        return state;
    }
}
