package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;
import java.math.BigDecimal;

/**
 * Database Table Remarks:
 *   设计师信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table designer_msg
 */
public class DesignerMsg extends BaseModel {
    /**
     * Database Column Remarks:
     *   对应用户ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * Database Column Remarks:
     *   来源，1无来源，2用户注册，3后台创建
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.source
     *
     * @mbg.generated
     */
    private Short source;

    /**
     * Database Column Remarks:
     *   设计师身份,1社会化设计师
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.identity
     *
     * @mbg.generated
     */
    private Long identity;

    /**
     * Database Column Remarks:
     *   设计师标签
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.tag
     *
     * @mbg.generated
     */
    private Long tag;

    /**
     * Database Column Remarks:
     *   设计师等级
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.level
     *
     * @mbg.generated
     */
    private Long level;

    /**
     * Database Column Remarks:
     *   排序权重
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.weight
     *
     * @mbg.generated
     */
    private Long weight;

    /**
     * Database Column Remarks:
     *   审核状态，1未审核，2审核通过，3审核不通过
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.review_state
     *
     * @mbg.generated
     */
    private Short reviewState;

    /**
     * Database Column Remarks:
     *   量房费用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.volume_room_money
     *
     * @mbg.generated
     */
    private BigDecimal volumeRoomMoney;

    /**
     * Database Column Remarks:
     *   设计费用最低(单位：元/m2)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.designer_money_low
     *
     * @mbg.generated
     */
    private BigDecimal designerMoneyLow;

    /**
     * Database Column Remarks:
     *   设计费用最高(单位：元/m2)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column designer_msg.designer_money_high
     *
     * @mbg.generated
     */
    private BigDecimal designerMoneyHigh;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.user_id
     *
     * @return the value of designer_msg.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.user_id
     *
     * @param userId the value for designer_msg.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.source
     *
     * @return the value of designer_msg.source
     *
     * @mbg.generated
     */
    public Short getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.source
     *
     * @param source the value for designer_msg.source
     *
     * @mbg.generated
     */
    public void setSource(Short source) {
        this.source = source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.identity
     *
     * @return the value of designer_msg.identity
     *
     * @mbg.generated
     */
    public Long getIdentity() {
        return identity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.identity
     *
     * @param identity the value for designer_msg.identity
     *
     * @mbg.generated
     */
    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.tag
     *
     * @return the value of designer_msg.tag
     *
     * @mbg.generated
     */
    public Long getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.tag
     *
     * @param tag the value for designer_msg.tag
     *
     * @mbg.generated
     */
    public void setTag(Long tag) {
        this.tag = tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.level
     *
     * @return the value of designer_msg.level
     *
     * @mbg.generated
     */
    public Long getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.level
     *
     * @param level the value for designer_msg.level
     *
     * @mbg.generated
     */
    public void setLevel(Long level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.weight
     *
     * @return the value of designer_msg.weight
     *
     * @mbg.generated
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.weight
     *
     * @param weight the value for designer_msg.weight
     *
     * @mbg.generated
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.review_state
     *
     * @return the value of designer_msg.review_state
     *
     * @mbg.generated
     */
    public Short getReviewState() {
        return reviewState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.review_state
     *
     * @param reviewState the value for designer_msg.review_state
     *
     * @mbg.generated
     */
    public void setReviewState(Short reviewState) {
        this.reviewState = reviewState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.volume_room_money
     *
     * @return the value of designer_msg.volume_room_money
     *
     * @mbg.generated
     */
    public BigDecimal getVolumeRoomMoney() {
        return volumeRoomMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.volume_room_money
     *
     * @param volumeRoomMoney the value for designer_msg.volume_room_money
     *
     * @mbg.generated
     */
    public void setVolumeRoomMoney(BigDecimal volumeRoomMoney) {
        this.volumeRoomMoney = volumeRoomMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.designer_money_low
     *
     * @return the value of designer_msg.designer_money_low
     *
     * @mbg.generated
     */
    public BigDecimal getDesignerMoneyLow() {
        return designerMoneyLow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.designer_money_low
     *
     * @param designerMoneyLow the value for designer_msg.designer_money_low
     *
     * @mbg.generated
     */
    public void setDesignerMoneyLow(BigDecimal designerMoneyLow) {
        this.designerMoneyLow = designerMoneyLow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column designer_msg.designer_money_high
     *
     * @return the value of designer_msg.designer_money_high
     *
     * @mbg.generated
     */
    public BigDecimal getDesignerMoneyHigh() {
        return designerMoneyHigh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column designer_msg.designer_money_high
     *
     * @param designerMoneyHigh the value for designer_msg.designer_money_high
     *
     * @mbg.generated
     */
    public void setDesignerMoneyHigh(BigDecimal designerMoneyHigh) {
        this.designerMoneyHigh = designerMoneyHigh;
    }
}