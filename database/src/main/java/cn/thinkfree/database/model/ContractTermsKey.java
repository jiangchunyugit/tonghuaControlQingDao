package cn.thinkfree.database.model;

import cn.thinkfree.core.model.BaseModel;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pc_contract_terms
 */
public class ContractTermsKey extends BaseModel {
    /**
     * Database Column Remarks:
     *   字典id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_terms.contract_dict_code

     */
    private String contractDictCode;

    /**
     * Database Column Remarks:
     *   合同编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_terms.contract_number

     */
    private String contractNumber;

    /**
     * Database Column Remarks:
     *   公司编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_contract_terms.company_id

     */
    private String companyId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_terms.contract_dict_code
     *
     * @return the value of pc_contract_terms.contract_dict_code

     */
    public String getContractDictCode() {
        return contractDictCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_terms.contract_dict_code
     *
     * @param contractDictCode the value for pc_contract_terms.contract_dict_code

     */
    public void setContractDictCode(String contractDictCode) {
        this.contractDictCode = contractDictCode == null ? null : contractDictCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_terms.contract_number
     *
     * @return the value of pc_contract_terms.contract_number

     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_terms.contract_number
     *
     * @param contractNumber the value for pc_contract_terms.contract_number

     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_contract_terms.company_id
     *
     * @return the value of pc_contract_terms.company_id

     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_contract_terms.company_id
     *
     * @param companyId the value for pc_contract_terms.company_id

     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }
}