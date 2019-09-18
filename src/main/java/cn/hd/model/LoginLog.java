package cn.hd.model;

import cn.hd.utils.MyDateUtil;

import java.util.Date;

public class LoginLog {
    private String id;

    private String userName;

    private Date loginTime;

    private String loginTimeFormat;

    private String loginIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginTimeFormat() {
        return loginTimeFormat;
    }

    public void setLoginTimeFormat(String loginTimeFormat) {
        this.loginTimeFormat = loginTimeFormat == null ? null : loginTimeFormat.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }


    public void initLoginTimeFormat() {
        this.loginTimeFormat = MyDateUtil.dateFormate_YYYY_MM_DD_HH_mm_ss(loginTime);
    }
}