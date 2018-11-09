package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_construction_base_dic
 */
public class ConstructionBaseDic extends BaseModel {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_construction_base_dic.id

     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   施工项目名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_construction_base_dic.name

     */
    private String name;

    /**
     * Database Column Remarks:
     *   施工阶段code
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_construction_base_dic.construction_code

     */
    private String constructionCode;

    /**
     * Database Column Remarks:
     *   项目阶段code
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_construction_base_dic.project_code

     */
    private String projectCode;

    /**
     * Database Column Remarks:
     *   施工阶段说明
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_construction_base_dic.remarks

     */
    private String remarks;

    /**
     * Database Column Remarks:
     *   材料
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_construction_base_dic.material

     */
    private String material;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_construction_base_dic.id
     *
     * @return the value of pc_construction_base_dic.id

     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_construction_base_dic.id
     *
     * @param id the value for pc_construction_base_dic.id

     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_construction_base_dic.name
     *
     * @return the value of pc_construction_base_dic.name

     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_construction_base_dic.name
     *
     * @param name the value for pc_construction_base_dic.name

     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_construction_base_dic.construction_code
     *
     * @return the value of pc_construction_base_dic.construction_code

     */
    public String getConstructionCode() {
        return constructionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_construction_base_dic.construction_code
     *
     * @param constructionCode the value for pc_construction_base_dic.construction_code

     */
    public void setConstructionCode(String constructionCode) {
        this.constructionCode = constructionCode == null ? null : constructionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_construction_base_dic.project_code
     *
     * @return the value of pc_construction_base_dic.project_code

     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_construction_base_dic.project_code
     *
     * @param projectCode the value for pc_construction_base_dic.project_code

     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_construction_base_dic.remarks
     *
     * @return the value of pc_construction_base_dic.remarks

     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_construction_base_dic.remarks
     *
     * @param remarks the value for pc_construction_base_dic.remarks

     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_construction_base_dic.material
     *
     * @return the value of pc_construction_base_dic.material

     */
    public String getMaterial() {
        return material;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_construction_base_dic.material
     *
     * @param material the value for pc_construction_base_dic.material

     */
    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }
}