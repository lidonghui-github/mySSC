package cn.hd.model;

import java.util.Date;

public class Approval {
    //主键id
    private String id;
    //批复号
    private String rescriptumno;
    //客户号
    private String custNo;
    //根节点号
    private String rootNo;
    //额度类型
    private String crdtType;
    //授信金额
    private Long apprAmt;
    //已用授信金额
    private Long useApprAmt;
    //冻结授信金额
    private Long frozApprAmt;
    //可用授信金额
    private Long enabApprAmt;
    //额度状态
    private String crdtStat;
    //冻结状态
    private String frozStat;
    //被纳入标识
    private String covIntoFlag;
    //被替换标识
    private String covReplFlag;
    //额度生效日
    private Date crdtValdDate;
    //额度到期日
    private Date crdtEndDate;
    //创建时间
    private Date crtTime;
    //更新时间
    private Date updTime;
    //版本号
    private Integer verNo;
    //备注
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

    @Override
    public String toString() {
        return "Approval{" +
                "id='" + id + '\'' +
                ", rescriptumno='" + rescriptumno + '\'' +
                ", custNo='" + custNo + '\'' +
                ", rootNo='" + rootNo + '\'' +
                ", crdtType='" + crdtType + '\'' +
                ", apprAmt=" + apprAmt +
                ", useApprAmt=" + useApprAmt +
                ", frozApprAmt=" + frozApprAmt +
                ", enabApprAmt=" + enabApprAmt +
                ", crdtStat='" + crdtStat + '\'' +
                ", frozStat='" + frozStat + '\'' +
                ", covIntoFlag='" + covIntoFlag + '\'' +
                ", covReplFlag='" + covReplFlag + '\'' +
                ", crdtValdDate=" + crdtValdDate +
                ", crdtEndDate=" + crdtEndDate +
                ", crtTime=" + crtTime +
                ", updTime=" + updTime +
                ", verNo=" + verNo +
                ", remark='" + remark + '\'' +
                '}';
    }
}