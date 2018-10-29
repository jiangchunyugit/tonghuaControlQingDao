package cn.thinkfree.database.vo.account;

/**
 * 第三方账号信息--埃森哲
 */
public class ThirdAccountVO {

    /**
     * 部门
     */
    private String dept;
    /**
     * 组
     */
    private String group;
    /**
     * 姓名
     */
    private String name;
    /**
     * 公号
     */
    private String workNumber;
    /**
     * 账号
     */
    private String account;
    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;


    private String id;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
