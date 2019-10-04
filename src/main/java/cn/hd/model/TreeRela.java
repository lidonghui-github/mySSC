package cn.hd.model;

import java.util.Date;

public class TreeRela {
    private String id;

    private String bigTreeNo;

    private String smallTreeNo;

    private String relaType;

    private String validFlag;

    private Date crtTime;

    private String crtTimeFormat;

    private Date updTime;

    private String updTimeFromat;

    private Integer verNo;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBigTreeNo() {
        return bigTreeNo;
    }

    public void setBigTreeNo(String bigTreeNo) {
        this.bigTreeNo = bigTreeNo == null ? null : bigTreeNo.trim();
    }

    public String getSmallTreeNo() {
        return smallTreeNo;
    }

    public void setSmallTreeNo(String smallTreeNo) {
        this.smallTreeNo = smallTreeNo == null ? null : smallTreeNo.trim();
    }

    public String getRelaType() {
        return relaType;
    }

    public void setRelaType(String relaType) {
        this.relaType = relaType == null ? null : relaType.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
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

    public String getUpdTimeFromat() {
        return updTimeFromat;
    }

    public void setUpdTimeFromat(String updTimeFromat) {
        this.updTimeFromat = updTimeFromat == null ? null : updTimeFromat.trim();
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
        return "TreeRela{" +
                "id='" + id + '\'' +
                ", bigTreeNo='" + bigTreeNo + '\'' +
                ", smallTreeNo='" + smallTreeNo + '\'' +
                ", relaType='" + relaType + '\'' +
                ", validFlag='" + validFlag + '\'' +
                ", crtTime=" + crtTime +
                ", crtTimeFormat='" + crtTimeFormat + '\'' +
                ", updTime=" + updTime +
                ", updTimeFromat='" + updTimeFromat + '\'' +
                ", verNo=" + verNo +
                ", remark='" + remark + '\'' +
                '}';
    }
}