package cn.thinkfree.service.platform.designer.vo;

/**
 * @author xusonghui
 * 用户信息对象
 */
public class UserMsgVo {

    private String userId;

    private String userName;

    private String userPhone;

    private String userType;

    public UserMsgVo() {
    }

    public UserMsgVo(String userId, String userName, String userPhone, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
