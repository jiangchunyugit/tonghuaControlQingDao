package cn.thinkfree.service.constants;

import lombok.Getter;

@Getter
public enum ProjectDataStatus {
    /**
     * 操作失败
     */
    INSERT_FAILD(0,"操作失败"),
    /**
     *正常状态
     */
    BASE_STATUS(1,"正常状态"),
    /**
     *失效状态
     */
    INVALID_STATUS(2,"失效状态"),
    /**
     *版本号
     */
    VERSION(1,"版本号"),
    /**
     *操作成功
     */
    INSERT_SUCCESS(1,"操作成功"),
    /**
     *设计订单type
     */
    DESIGN_STATUS(1,"设计订单type"),
    /**
     *施工订单type
     */
    CONSTRUCTION_STATUS(2,"施工订单type"),
    /**
     *报价单type
     */
    QUOTATION_STATUS(3,"报价单type"),
    /**
     *png 文件
     */
    FILE_PNG(1,"png 文件"),
    /**
     *PDF 文件
     */
    FILE_PDF(2,"PDF 文件"),
    /**
     *3D云 文件
     */
    FILE_THIRD(3,"3D云 文件"),
    /**
     *已确认
     */
    CONFIRM(1,"已确认"),
    /**
     * 退款
     */
    REFUND_ONE(1,"退款"),
    /**
     * 先行赔付
     */
    REDUND_TWO(2,"先行赔付"),
    /**
     * 消费者
     */
    PLAY_CONSUMER(4,"消费者"),
    /**
     *平台
     */
    PLAY_PLATFORM(1,"平台"),
    /**
     *设计师
     */
    PLAY_DESIGNER(3,"设计师"),
    /**
     *设计公司
     */
    PLAY_DESIGN_COMPANY(2,"设计公司"),
    /**
     * 业主
     */
    OWNER(1,"CC");

    private Integer value;
    private String description;

    ProjectDataStatus(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
}
