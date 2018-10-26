package cn.thinkfree.core.utils;

import java.util.UUID;

/**
 * 唯一编码生成器
 * @author songchuanrang
 */
public enum UniqueCodeGenerator {

    /**
     * 审批流配置编码前缀
     */
    AF_CONFIG("AF_CONFIG_"),
    /**
     * 审批流配置记录编码前缀
     */
    AF_CONFIG_LOG("AF_CONFIG_LOG_"),
    /**
     * 审批流实例编码前缀
     */
    AF_INSTANCE("AF_INSTANCE_"),
    /**
     * 审批流审批日志编码前缀
     */
    AF_APPROVAL_LOG("AF_APPROVAL_LOG_"),
    /**
     * 审批流操作项编码前缀
     */
    AF_OPTION("AF_OPTION_"),
    /**
     * 审批流审批顺序方案
     */
    AF_PLAN("AF_PLAN_"),
    /**
     * 审批流节点编码前缀
     */
    AF_NODE("AF_NODE_"),
    /**
     * 审批流配置节点表单前缀
     */
    AF_FORM("AF_FORM_"),
    /**
     * 审批流配置节点表单前缀
     */
    AF_FORM_ELEMENT("AF_FORM_ELEMENT_"),
    /**
     * 审批流配置节点表单前缀
     */
    AF_FORM_ELEMENT_TYPE("AF_FORM_ELEMENT_TYPE_");

    private String prefix;

    UniqueCodeGenerator(String prefix){
        this.prefix = prefix;
    }

    public String getCode(){
        return (prefix + UUID.randomUUID().toString().replaceAll("-",""));
    }
}
