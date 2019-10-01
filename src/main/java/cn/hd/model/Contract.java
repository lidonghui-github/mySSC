package cn.hd.model;

import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable {
    private String id;

    private String contNo;

    private String treeNo;

    private Integer contAmt;

    private Date crtTime;

    private String crtTimeFormat;

    private Date updTime;

    private String updTimeFormat;

    private Date beginDate;

    private String beginDateFormat;

    private Date endData;

    private String endDateFormat;

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

    public String getTreeNo() {
        return treeNo;
    }

    public void setTreeNo(String treeNo) {
        this.treeNo = treeNo == null ? null : treeNo.trim();
    }

    public Integer getContAmt() {
        return contAmt;
    }

    public void setContAmt(Integer contAmt) {
        this.contAmt = contAmt;
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getBeginDateFormat() {
        return beginDateFormat;
    }

    public void setBeginDateFormat(String beginDateFormat) {
        this.beginDateFormat = beginDateFormat == null ? null : beginDateFormat.trim();
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    public String getEndDateFormat() {
        return endDateFormat;
    }

    public void setEndDateFormat(String endDateFormat) {
        this.endDateFormat = endDateFormat == null ? null : endDateFormat.trim();
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

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", contNo='" + contNo + '\'' +
                ", treeNo='" + treeNo + '\'' +
                ", contAmt=" + contAmt +
                ", crtTime=" + crtTime +
                ", crtTimeFormat='" + crtTimeFormat + '\'' +
                ", updTime=" + updTime +
                ", updTimeFormat='" + updTimeFormat + '\'' +
                ", beginDate=" + beginDate +
                ", beginDateFormat='" + beginDateFormat + '\'' +
                ", endData=" + endData +
                ", endDateFormat='" + endDateFormat + '\'' +
                ", verNo=" + verNo +
                ", remark='" + remark + '\'' +
                '}';
    }
}