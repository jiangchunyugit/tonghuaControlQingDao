package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

/**
 * Database Table Remarks:
 *   城市分站店面信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_store_info
 */
public class StoreInfo extends BaseModel {
    /**
     * Database Column Remarks:
     *   自增主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_store_info.id

     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   城市分站id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_store_info.city_branch_id

     */
    private Integer cityBranchId;

    /**
     * Database Column Remarks:
     *   店面名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_store_info.name

     */
    private String name;

    /**
     * Database Column Remarks:
     *   经营主体id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_store_info.business_entity_id

     */
    private Integer businessEntityId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_store_info.id
     *
     * @return the value of pc_store_info.id

     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_store_info.id
     *
     * @param id the value for pc_store_info.id

     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_store_info.city_branch_id
     *
     * @return the value of pc_store_info.city_branch_id

     */
    public Integer getCityBranchId() {
        return cityBranchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_store_info.city_branch_id
     *
     * @param cityBranchId the value for pc_store_info.city_branch_id

     */
    public void setCityBranchId(Integer cityBranchId) {
        this.cityBranchId = cityBranchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_store_info.name
     *
     * @return the value of pc_store_info.name

     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_store_info.name
     *
     * @param name the value for pc_store_info.name

     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_store_info.business_entity_id
     *
     * @return the value of pc_store_info.business_entity_id

     */
    public Integer getBusinessEntityId() {
        return businessEntityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_store_info.business_entity_id
     *
     * @param businessEntityId the value for pc_store_info.business_entity_id

     */
    public void setBusinessEntityId(Integer businessEntityId) {
        this.businessEntityId = businessEntityId;
    }
}