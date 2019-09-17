package cn.hd.model;

import java.io.Serializable;

public class Role implements Serializable{
    @Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", remark=" + remark + "]";
	}

	private String roleId;

    private String roleName;

    private String remark;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}