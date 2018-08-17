package cn.thinkfree.core.constants;

/**
 * 系统日志 行为
 * 配置切面和注解
 * @see cn.thinkfree.core.annotation.MySysLog
 */
public enum  SysLogAction {

    LOGIN(1,"登录"),
    SAVE(2,"保存"),
    QUERY(3,"查询"),
    DEL(4,"删除"),
    CHANGE_STATE(5,"改变状态"),
    EDIT(6,"编辑");

    public String mes;
    public Integer code;
    SysLogAction(Integer code, String mes) {
        this.code = code;
        this.mes = mes;
    }
}
