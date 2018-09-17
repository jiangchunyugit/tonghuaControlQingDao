package cn.thinkfree.core.constants;

/**
 * 系统日志模块
 * 配合切面和注解
 */
public enum  SysLogModule {

    PC_USER(1,"用户模块"),
    PC_PROJECT(2,"项目模块"),
    PC_STAFFS(3,"员工模块");

    public final String mes;
    public final Integer code;

    SysLogModule(Integer code, String mes) {
        this.mes = mes;
        this.code = code;
    }
}
