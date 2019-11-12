package cn.hd.model;

import java.util.Date;

public class Approval {
    private String id;

    private String rescriptumno;

    private String custNo;

    private String rootNo;

    private String crdtType;

    private Long apprAmt;

    private Long useApprAmt;

    private Long frozApprAmt;

    private Long enabApprAmt;

    private String crdtStat;

    private String frozStat;

    private String covIntoFlag;

    private String covReplFlag;

    private Date crdtValdDate;

    private Date crdtEndDate;

    private Date crtTime;

    private Date updTime;

    private Integer verNo;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRescriptumno() {
        return rescriptumno;
    }

    public void setRescriptumno(String rescriptumno) {
        this.rescriptumno = rescriptumno == null ? null : rescriptumno.trim();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getRootNo() {
        return rootNo;
    }

    public void setRootNo(String rootNo) {
        this.rootNo = rootNo == null ? null : rootNo.trim();
    }

    public String getCrdtType() {
        return crdtType;
    }

    public void setCrdtType(String crdtType) {
        this.crdtType = crdtType == null ? null : crdtType.trim();
    }

    public Long getApprAmt() {
        return apprAmt;
    }

    public void setApprAmt(Long apprAmt) {
        this.apprAmt = apprAmt;
    }

    public Long getUseApprAmt() {
        return useApprAmt;
    }

    public void setUseApprAmt(Long useApprAmt) {
        this.useApprAmt = useApprAmt;
    }

    public Long getFrozApprAmt() {
        return frozApprAmt;
    }

    public void setFrozApprAmt(Long frozApprAmt) {
        this.frozApprAmt = frozApprAmt;
    }

    public Long getEnabApprAmt() {
        return enabApprAmt;
    }

    public void setEnabApprAmt(Long enabApprAmt) {
        this.enabApprAmt = enabApprAmt;
    }

    public String getCrdtStat() {
        return crdtStat;
    }

    public void setCrdtStat(String crdtStat) {
        this.crdtStat = crdtStat == null ? null : crdtStat.trim();
    }

    public String getFrozStat() {
        return frozStat;
    }

    public void setFrozStat(String frozStat) {
        this.frozStat = frozStat == null ? null : frozStat.trim();
    }

    public String getCovIntoFlag() {
        return covIntoFlag;
    }

    public void setCovIntoFlag(String covIntoFlag) {
        this.covIntoFlag = covIntoFlag == null ? null : covIntoFlag.trim();
    }

    public String getCovReplFlag() {
        return covReplFlag;
    }

    public void setCovReplFlag(String covReplFlag) {
        this.covReplFlag = covReplFlag == null ? null : covReplFlag.trim();
    }

    public Date getCrdtValdDate() {
        return crdtValdDate;
    }

    public void setCrdtValdDate(Date crdtValdDate) {
        this.crdtValdDate = crdtValdDate;
    }

    public Date getCrdtEndDate() {
        return crdtEndDate;
    }

    public void setCrdtEndDate(Date crdtEndDate) {
        this.crdtEndDate = crdtEndDate;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
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