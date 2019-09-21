package cn.hd.model;

import java.util.Date;

public class Froz {
    private String id;

    private String frozNo;

    private String frozTreeNo;

    private String frozApprNo;

    private Integer frozApprAmt;

    private Date crtTime;

    private String crtTimeFormat;

    private Date updTime;

    private String updTimeFormat;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFrozNo() {
        return frozNo;
    }

    public void setFrozNo(String frozNo) {
        this.frozNo = frozNo == null ? null : frozNo.trim();
    }

    public String getFrozTreeNo() {
        return frozTreeNo;
    }

    public void setFrozTreeNo(String frozTreeNo) {
        this.frozTreeNo = frozTreeNo == null ? null : frozTreeNo.trim();
    }

    public String getFrozApprNo() {
        return frozApprNo;
    }

    public void setFrozApprNo(String frozApprNo) {
        this.frozApprNo = frozApprNo == null ? null : frozApprNo.trim();
    }

    public Integer getFrozApprAmt() {
        return frozApprAmt;
    }

    public void setFrozApprAmt(Integer frozApprAmt) {
        this.frozApprAmt = frozApprAmt;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}