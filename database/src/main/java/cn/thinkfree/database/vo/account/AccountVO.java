package cn.thinkfree.database.vo.account;

import cn.thinkfree.core.model.BaseModel;
import cn.thinkfree.database.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Set;

@ApiModel("账号主题")
public class AccountVO  extends BaseModel {
    /**
     * 权限范围
     */
    @ApiModelProperty("权限范围")
    private String scope;

    /**
     * 角色集
     */
    @ApiModelProperty("角色集合")
    private List<SystemRole> roles;

    /**
     * 埃森哲账号信息
     */
    @ApiModelProperty("三方信息")
    private ThirdAccountVO thirdAccount;

    /**
     * 第三方主键
     */
    @ApiModelProperty("第三方主键")
    private String thirdId;

    @ApiModelProperty("用户信息")
    private PcUserInfo pcUserInfo;

    /**
     * 分店集合
     */
    @ApiModelProperty("分店集合")
    private Set<SystemUserStore> storeList;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SystemRole> roles) {
        this.roles = roles;
    }

    public ThirdAccountVO getThirdAccount() {
        return thirdAccount;
    }

    public void setThirdAccount(ThirdAccountVO thirdAccount) {
        this.thirdAccount = thirdAccount;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public PcUserInfo getPcUserInfo() {
        return pcUserInfo;
    }

    public void setPcUserInfo(PcUserInfo pcUserInfo) {
        this.pcUserInfo = pcUserInfo;
    }

    public Set<SystemUserStore> getStoreList() {
        return storeList;
    }

    public void setStoreList(Set<SystemUserStore> storeList) {
        this.storeList = storeList;
    }
}
