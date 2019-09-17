package cn.hd.model;

public class Tree {
    @Override
	public String toString() {
		return "Tree [nodeNo=" + nodeNo + ", upNodeNo=" + upNodeNo
				+ ", rescriptumno=" + rescriptumno + ", dimCode=" + dimCode
				+ "]";
	}

	private String nodeNo;

    private String upNodeNo;

    private String rescriptumno;

    private String dimCode;

    public String getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(String nodeNo) {
        this.nodeNo = nodeNo == null ? null : nodeNo.trim();
    }

    public String getUpNodeNo() {
        return upNodeNo;
    }

    public void setUpNodeNo(String upNodeNo) {
        this.upNodeNo = upNodeNo == null ? null : upNodeNo.trim();
    }

    public String getRescriptumno() {
        return rescriptumno;
    }

    public void setRescriptumno(String rescriptumno) {
        this.rescriptumno = rescriptumno == null ? null : rescriptumno.trim();
    }

    public String getDimCode() {
        return dimCode;
    }

    public void setDimCode(String dimCode) {
        this.dimCode = dimCode == null ? null : dimCode.trim();
    }
}