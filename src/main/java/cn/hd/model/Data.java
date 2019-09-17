package cn.hd.model;

import java.io.Serializable;

public class Data implements Serializable{
    @Override
	public String toString() {
		return "Data [dataId=" + dataId + ", dataName=" + dataName
				+ ", remark=" + remark + "]";
	}

	private String dataId;

    private String dataName;

    private String remark;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId == null ? null : dataId.trim();
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}