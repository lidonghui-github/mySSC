package cn.hd.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
    private String orderNo;

    private String orderCrtUserNo;

    private Date orderCrtTime;

    private Date orderUpdTime;

    private String orderStatus;

    private String orderOperateStatus;

    private String orderDriverNo;

    private String orderOrigin;

    private String orderDestination;

    private Date orderAppointmenTime;

    private String orderUpdUserNo;

    private String orderCustomerNo;

    @Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", orderCrtUserNo="
				+ orderCrtUserNo + ", orderCrtTime=" + orderCrtTime
				+ ", orderUpdTime=" + orderUpdTime + ", orderStatus="
				+ orderStatus + ", orderOperateStatus=" + orderOperateStatus
				+ ", orderDriverNo=" + orderDriverNo + ", orderOrigin="
				+ orderOrigin + ", orderDestination=" + orderDestination
				+ ", orderAppointmenTime=" + orderAppointmenTime
				+ ", orderUpdUserNo=" + orderUpdUserNo + ", orderCustomerNo="
				+ orderCustomerNo + ", remark=" + remark + "]";
	}

	private String remark;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderCrtUserNo() {
        return orderCrtUserNo;
    }

    public void setOrderCrtUserNo(String orderCrtUserNo) {
        this.orderCrtUserNo = orderCrtUserNo == null ? null : orderCrtUserNo.trim();
    }

    public Date getOrderCrtTime() {
        return orderCrtTime;
    }

    public void setOrderCrtTime(Date orderCrtTime) {
        this.orderCrtTime = orderCrtTime;
    }

    public Date getOrderUpdTime() {
        return orderUpdTime;
    }

    public void setOrderUpdTime(Date orderUpdTime) {
        this.orderUpdTime = orderUpdTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderOperateStatus() {
        return orderOperateStatus;
    }

    public void setOrderOperateStatus(String orderOperateStatus) {
        this.orderOperateStatus = orderOperateStatus == null ? null : orderOperateStatus.trim();
    }

    public String getOrderDriverNo() {
        return orderDriverNo;
    }

    public void setOrderDriverNo(String orderDriverNo) {
        this.orderDriverNo = orderDriverNo == null ? null : orderDriverNo.trim();
    }

    public String getOrderOrigin() {
        return orderOrigin;
    }

    public void setOrderOrigin(String orderOrigin) {
        this.orderOrigin = orderOrigin == null ? null : orderOrigin.trim();
    }

    public String getOrderDestination() {
        return orderDestination;
    }

    public void setOrderDestination(String orderDestination) {
        this.orderDestination = orderDestination == null ? null : orderDestination.trim();
    }

    public Date getOrderAppointmenTime() {
        return orderAppointmenTime;
    }

    public void setOrderAppointmenTime(Date orderAppointmenTime) {
        this.orderAppointmenTime = orderAppointmenTime;
    }

    public String getOrderUpdUserNo() {
        return orderUpdUserNo;
    }

    public void setOrderUpdUserNo(String orderUpdUserNo) {
        this.orderUpdUserNo = orderUpdUserNo == null ? null : orderUpdUserNo.trim();
    }

    public String getOrderCustomerNo() {
        return orderCustomerNo;
    }

    public void setOrderCustomerNo(String orderCustomerNo) {
        this.orderCustomerNo = orderCustomerNo == null ? null : orderCustomerNo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}