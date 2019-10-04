package cn.hd.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ContractInfo {
    @NotNull
    private String id;

    private String contNo;

    private Date crtTime;

    private String crtTimeFormat;

    private Date updTime;

    private String updTimeFormat;

    private String contStat;

    private Integer verNo;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getCrtTimeFormat() {
        return crtTimeFormat;
    }

    public void setCrtTimeFormat(String crtTimeFormat) {
        this.crtTimeFormat = crtTimeFormat == null ? null : crtTimeFormat.trim();
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public String getUpdTimeFormat() {
        return updTimeFormat;
    }

    public void setUpdTimeFormat(String updTimeFormat) {
        this.updTimeFormat = updTimeFormat == null ? null : updTimeFormat.trim();
    }

    public String getContStat() {
        return contStat;
    }

    public void setContStat(String contStat) {
        this.contStat = contStat == null ? null : contStat.trim();
    }

    public Integer getVerNo() {
        return verNo;
    }

    public void setVerNo(Integer verNo) {
        this.verNo = verNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}