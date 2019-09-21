package cn.hd.model;

import java.util.Date;

public class Tree {
    private String id;

    private String treeName;

    private String treeNo;

    private String upTreeNo;

    private String apprNo;

    private String frozStat;

    private String crdtStat;

    private Integer apprAmt;

    private Integer usedAmt;

    private Integer enabAmt;

    private Integer frozAmt;

    private Date crtTime;

    private String crtTimeFormat;

    private Date updTime;

    private String updTimeFormat;

    private Integer verNo;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName == null ? null : treeName.trim();
    }

    public String getTreeNo() {
        return treeNo;
    }

    public void setTreeNo(String treeNo) {
        this.treeNo = treeNo == null ? null : treeNo.trim();
    }

    public String getUpTreeNo() {
        return upTreeNo;
    }

    public void setUpTreeNo(String upTreeNo) {
        this.upTreeNo = upTreeNo == null ? null : upTreeNo.trim();
    }

    public String getApprNo() {
        return apprNo;
    }

    public void setApprNo(String apprNo) {
        this.apprNo = apprNo == null ? null : apprNo.trim();
    }

    public String getFrozStat() {
        return frozStat;
    }

    public void setFrozStat(String frozStat) {
        this.frozStat = frozStat == null ? null : frozStat.trim();
    }

    public String getCrdtStat() {
        return crdtStat;
    }

    public void setCrdtStat(String crdtStat) {
        this.crdtStat = crdtStat == null ? null : crdtStat.trim();
    }

    public Integer getApprAmt() {
        return apprAmt;
    }

    public void setApprAmt(Integer apprAmt) {
        this.apprAmt = apprAmt;
    }

    public Integer getUsedAmt() {
        return usedAmt;
    }

    public void setUsedAmt(Integer usedAmt) {
        this.usedAmt = usedAmt;
    }

    public Integer getEnabAmt() {
        return enabAmt;
    }

    public void setEnabAmt(Integer enabAmt) {
        this.enabAmt = enabAmt;
    }

    public Integer getFrozAmt() {
        return frozAmt;
    }

    public void setFrozAmt(Integer frozAmt) {
        this.frozAmt = frozAmt;
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